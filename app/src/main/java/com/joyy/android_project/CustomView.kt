package com.joyy.android_project

import android.annotation.SuppressLint
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
@SuppressLint("ClickableViewAccessibility")
class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    init {
        setOnClickListener { L.log("CustomView#setOnClickListener") }
        setOnLongClickListener {
            L.log("CustomView#setOnLongClickListener")
            false
        }
        setOnTouchListener { v, event ->
            L.log("CustomView@setOnTouchListener")
            false
        }
    }

    /*
        I/LLL: MainActivity#dispatchTouchEvent
        I/LLL: CustomFrameLayout#dispatchTouchEvent
        I/LLL: CustomFrameLayout#onInterceptTouchEvent
        I/LLL: CustomView#dispatchTouchEvent
        I/LLL: CustomView@setOnTouchListener
        I/LLL: MainActivity#dispatchTouchEvent
        I/LLL: CustomFrameLayout#dispatchTouchEvent
        I/LLL: CustomFrameLayout#onInterceptTouchEvent
        I/LLL: CustomView#dispatchTouchEvent
        I/LLL: CustomView@setOnTouchListener


        I/LLL: MainActivity#dispatchTouchEvent
        I/LLL: CustomFrameLayout#dispatchTouchEvent
        I/LLL: CustomFrameLayout#onInterceptTouchEvent
        I/LLL: CustomView#dispatchTouchEvent
        I/LLL: CustomView@setOnTouchListener
        I/LLL: CustomView@onTouchEvent
        I/LLL: MotionEvent.ACTION_DOWN
        I/LLL: CustomView#performLongClick
        I/LLL: CustomView#setOnLongClickListener
        I/LLL: MainActivity#dispatchTouchEvent
        I/LLL: CustomFrameLayout#dispatchTouchEvent
        I/LLL: CustomFrameLayout#onInterceptTouchEvent
        I/LLL: CustomView#dispatchTouchEvent
        I/LLL: CustomView@setOnTouchListener
        I/LLL: CustomView@onTouchEvent
        I/LLL: MotionEvent.ACTION_UP
        I/LLL: CustomView#performCLick
        I/LLL: CustomView#setOnClickListener
     */

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        L.log("CustomView#dispatchTouchEvent")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        L.log("CustomView@onTouchEvent")
        print(event)
        return super.onTouchEvent(event)
    }

    fun print(event: MotionEvent?) {
        when (event?.action) {
            MotionEvent.ACTION_UP -> L.log("MotionEvent.ACTION_UP")
            MotionEvent.ACTION_DOWN -> L.log("MotionEvent.ACTION_DOWN")
            MotionEvent.ACTION_CANCEL -> L.log("MotionEvent.ACTION_CANCEL")
            MotionEvent.ACTION_MOVE -> L.log("MotionEvent.ACTION_MOVE")
        }
    }

    override fun performClick(): Boolean {
        L.log("CustomView#performCLick")
        return super.performClick()
    }

    override fun performLongClick(): Boolean {
        L.log("CustomView#performLongClick")
        return super.performLongClick()
    }
}