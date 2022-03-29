package com.joyy.android_project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.onClickText).setOnClickListener {
            L.log("MainActivity#setOnClickListener")
        }

        findViewById<View>(R.id.onLongClickTextTrue).setOnLongClickListener {
            L.log("MainActivity#setOnLongClickListener True")
            return@setOnLongClickListener true
        }

        findViewById<View>(R.id.onLongClickTextTrue).setOnClickListener {
            L.log("MainActivity#setOnClickListener")
        }

        findViewById<View>(R.id.onLongClickTextFalse).setOnLongClickListener {
            L.log("MainActivity#setOnLongClickListener False")
            return@setOnLongClickListener false
        }

        findViewById<View>(R.id.onLongClickTextFalse).setOnClickListener {
            L.log("MainActivity#setOnClickListener")
        }

        findViewById<View>(R.id.onTouchEventTrue).setOnTouchListener { v, event ->
            L.log("MainActivity@setOnTouchListener True")
            return@setOnTouchListener true
        }

        findViewById<View>(R.id.onTouchEventFalse).setOnTouchListener { v, event ->
            L.log("MainActivity@setOnTouchListener False")
            return@setOnTouchListener false
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        L.log("MainActivity#dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        L.log("MainActivity#onTouchEvent")
        return super.onTouchEvent(event)
    }
}