package com.joyy.android_project;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.MotionEvent;

public class Utils {

    public static void injectActionDown(float x, float y) {
        Instrumentation instrumentation = new Instrumentation();
        final long now = SystemClock.uptimeMillis();
        int action = MotionEvent.ACTION_DOWN;
        MotionEvent clickDown = MotionEvent.obtain(now, now, action, x, y, 0);
        instrumentation.sendPointerSync(clickDown);
    }

    public static void injectActionMove(float x, float y) {
        Instrumentation instrumentation = new Instrumentation();
        final long now = SystemClock.uptimeMillis();
        int action = MotionEvent.ACTION_MOVE;
        MotionEvent move = MotionEvent.obtain(now, now, action, x, y, 0);
        instrumentation.sendPointerSync(move);
    }

    public static void injectActionUp(float x, float y) {
        Instrumentation instrumentation = new Instrumentation();
        final long now = SystemClock.uptimeMillis();
        int action = MotionEvent.ACTION_UP;
        MotionEvent up = MotionEvent.obtain(now, now, action, x, y, 0);
        instrumentation.sendPointerSync(up);
    }

    public static void inject() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Instrumentation instrumentation = new Instrumentation();
                final long now = SystemClock.uptimeMillis();
                int action = MotionEvent.ACTION_DOWN;
                float x = 583;
                float y = 1250;
                MotionEvent clickDown = MotionEvent.obtain(now, now, action, x, y, 0);
                instrumentation.sendPointerSync(clickDown);
                action = MotionEvent.ACTION_UP;
                MotionEvent clickUp = MotionEvent.obtain(now, now, action, x, y, 0);
                instrumentation.sendPointerSync(clickUp);
            }
        }).start();
    }

}
