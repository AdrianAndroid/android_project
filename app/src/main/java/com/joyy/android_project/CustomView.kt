package com.joyy.android_project

import android.content.Context
import android.util.AttributeSet
import android.view.InputDevice
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration

/**
 * Time:2022/3/28 16:01
 * Author: flannery
 * Description:
 */
class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        L.log("CustomView#dispatchTouchEvent")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        L.log("CustomView@onTouchEvent")
        print(event)
        return true;//super.onTouchEvent(event)
    }

    fun print(event: MotionEvent?) {
        when (event?.action) {
            MotionEvent.ACTION_UP -> L.log("MotionEvent.ACTION_UP")
            MotionEvent.ACTION_DOWN -> L.log("MotionEvent.ACTION_DOWN")
            MotionEvent.ACTION_CANCEL -> L.log("MotionEvent.ACTION_CANCEL")
            MotionEvent.ACTION_MOVE -> L.log("MotionEvent.ACTION_MOVE")
        }
    }
}