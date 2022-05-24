package com.joyy.android_project;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

/**
 * Time:2022/6/9 23:38
 * Author:
 * Description:
 */
public class AidlService extends Service {

    private final IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            String s1 = "";
            String s2 = "";
            boolean equals = s1.equals(s2);
            boolean b = s1 == s2;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
