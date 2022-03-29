package com.joyy.android_project

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 * Time:2022/3/28 16:02
 * Author: flannery
 * Description:
 */
class CustomFrameLayout(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        L.log("CustomFrameLayout#dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        L.log("CustomFrameLayout#onInterceptTouchEvent")
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        L.log("CustomFrameLayout#onTouchEvent")
        return super.onTouchEvent(event)
    }
}