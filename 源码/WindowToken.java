/*
 * Copyright (C) 2011 The Android Open Source Project
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

package com.android.server.wm;

import android.os.IBinder;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Container of a set of related windows in the window manager.  Often this
 * is an AppWindowToken, which is the handle for an Activity that it uses
 * to display windows.  For nested windows, there is a WindowToken created for
 * the parent window to manage its children.
 */
/**
 * * WindowToken将属于同一个应用组件的窗口组织在一起。所谓的应用组件可以是Activity、InputMethod、Wallpaper以及Dream
 *  在WMS对窗口的管理过程中，用WindowToken只带一个应用组件。例如在进行窗口ZOrder排序时，属于同一个WindowToken的窗口
 *  会被安排到一起，而且在其中定义的一些属性将会影响所有属于此WindowToken的窗口。这些都表明了属于同一个WindowToken的窗口之间的
 *  紧密联系
 * * WindowToken具有令牌的作用，是对应用组件的行为进行规范管理的一个手段。WindowToken由应用组件或其管理者负责向WMS声明并持有
 *  应用组件在需要新的窗口时，必须提供WindowToken已表明自己的身份，并且窗口的类型必须与所持有的WindowToken类型一致
 *  从前面的代码可以看到，在创建系统类型的窗口时不需要提供一个有效的Token，WMS会隐式地为其声明一个WindowToken，看起来谁都可以
 *  添加一个系统级别的窗口。难道Android为了内部使用方便而置于安全而不顾吗？非也，addWindow函数一开始的mPolicy.checkAndPermission()
 *  的目的就是如此。它要求客户端必须拥有SYSTEM_ALERT_WINDOW或INTERNAL_SYSTEM_WINDOW权限才能创建系统类型的窗口
 */
/**
 * WindowToken有两层含义：
 * # 对显示组件（客户端）而言的Token，是任意一个Binder的实例，对显示组件（客户端）来说仅仅是一个创建窗口的令牌，没有其他含义
 * # 对WMS而言的WindowToken，这是一个WindowToken类的实例，保存了对应于客户端一侧的Token（Binder实例），并以这个Token为键，
 * 存储于mTokenMap中。客户端中一侧的Token是否已被声明，取决于其对应的WindowToken是否位于mTokenMap中
 */
class WindowToken {
    // The window manager!
    final WindowManagerService service;

    // The actual token.
    final IBinder token;

    // The type of window this token is for, as per WindowManager.LayoutParams.
    final int windowType;

    // Set if this token was explicitly added by a client, so should
    // not be removed when all windows are removed.
    final boolean explicit;

    // For printing.
    String stringName;

    // If this is an AppWindowToken, this is non-null.
    AppWindowToken appWindowToken;

    // All of the windows associated with this token.
    final WindowList windows = new WindowList();

    // Is key dispatching paused for this token?
    boolean paused = false;

    // Should this token's windows be hidden?
    boolean hidden;

    // Temporary for finding which tokens no longer have visible windows.
    boolean hasVisible;

    // Set to true when this token is in a pending transaction where it
    // will be shown.
    boolean waitingToShow;

    // Set to true when this token is in a pending transaction where it
    // will be hidden.
    boolean waitingToHide;

    // Set to true when this token is in a pending transaction where its
    // windows will be put to the bottom of the list.
    boolean sendingToBottom;

    WindowToken(WindowManagerService _service, IBinder _token, int type, boolean _explicit) {
        service = _service;
        token = _token;
        windowType = type;
        explicit = _explicit;
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("windows=");
        pw.println(windows);
        pw.print(prefix);
        pw.print("windowType=");
        pw.print(windowType);
        pw.print(" hidden=");
        pw.print(hidden);
        pw.print(" hasVisible=");
        pw.println(hasVisible);
        if (waitingToShow || waitingToHide || sendingToBottom) {
            pw.print(prefix);
            pw.print("waitingToShow=");
            pw.print(waitingToShow);
            pw.print(" waitingToHide=");
            pw.print(waitingToHide);
            pw.print(" sendingToBottom=");
            pw.print(sendingToBottom);
        }
    }

    @Override
    public String toString() {
        if (stringName == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("WindowToken{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" ");
            sb.append(token);
            sb.append('}');
            stringName = sb.toString();
        }
        return stringName;
    }
}