/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.systemui;

import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import android.view.IWindowManager;
import android.view.WindowManagerGlobal;
import android.view.accessibility.AccessibilityManager;

public class SystemUIService extends Service {
    static final String TAG = "SystemUIService";

    /**
     * The class names of the stuff to start.
     */
    // 1。SERVICES数组定义了运行于SystemUIService之中的子服务列表。当SystemUIService服务启动时将会依次启动列表中所存储的子服务
    final Object[] SERVICES = new Object[] {
            0, // system bar or status bar, filled in below.
            com.android.systemui.power.PowerUI.class,
            com.android.systemui.media.RingtonePlayer.class,
    };

    /**
     * Hold a reference on the stuff we start.
     */
    SystemUI[] mServices;

    private Class chooseClass(Object o) {
        if (o instanceof Integer) {
            final String cl = getString((Integer)o);
            try {
                return getClassLoader().loadClass(cl);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        } else if (o instanceof Class) {
            return (Class)o;
        } else {
            throw new RuntimeException("Unknown system ui service: " + o);
        }
    }

    @Override
    public void onCreate() {
        // Tell the accessibility layer that this process will
        // run as the current user, i.e. run across users.
        AccessibilityManager.createAsSharedAcrossUsers(this);

        // Pick status bar or system bar.
        IWindowManager wm = WindowManagerGlobal.getWindowManagerService();
        try {
            // 2。根据IWindowManager.hasSystemNavBar的返回值选择一个合适的状态栏与导航栏的实现
            SERVICES[0] = wm.hasSystemNavBar()
                    ? R.string.config_systemBarComponent
                    : R.string.config_statusBarComponent;
        } catch (RemoteException e) {
            Slog.w(TAG, "Failing checking whether status bar can hide", e);
        }

        final int N = SERVICES.length;
        // mServices数组中存储了子服务的实例
        mServices = new SystemUI[N];
        for (int i=0; i<N; i++) {
            Class cl = chooseClass(SERVICES[i]);
            Slog.d(TAG, "loading: " + cl);
            try {
                // 3。 实例化子服务并将其存储在mServices数组中
                mServices[i] = (SystemUI)cl.newInstance();
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            } catch (InstantiationException ex) {
                throw new RuntimeException(ex);
            }
            // 4。设置Context，并通过调用其start方法运行它
            mServices[i].mContext = this;
            Slog.d(TAG, "running: " + mServices[i]);
            mServices[i].start();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        for (SystemUI ui: mServices) {
            ui.onConfigurationChanged(newConfig);
        }
    }

    /**
     * Nobody binds to us.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (args == null || args.length == 0) {
            for (SystemUI ui: mServices) {
                pw.println("dumping service: " + ui.getClass().getName());
                ui.dump(fd, pw, args);
            }
        } else {
            String svc = args[0];
            for (SystemUI ui: mServices) {
                String name = ui.getClass().getName();
                if (name.endsWith(svc)) {
                    ui.dump(fd, pw, args);
                }
            }
        }
    }
}