package com.joyy.android_project;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import androidx.annotation.Nullable;

public class PointerSpeedView extends View {
    VelocityTracker velocityTracker = null;

    public PointerSpeedView(Context context) {
        super(context);
    }

    public PointerSpeedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PointerSpeedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction() & MotionEvent.ACTION_MASK;
        velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(event);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                velocityTracker.computeCurrentVelocity(1000);
                Log.i("speed", "move speed:" + velocityTracker.getXVelocity());
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: // Return a VelocityTracker object back to be re-used by others.
                velocityTracker.recycle();
                break;
        }
        return true;
    }
}
