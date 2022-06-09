package com.joyy.android_project

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity() {
    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn).setOnClickListener {
            var systemService: InputMethodManager =
                getSystemService(Context.INPUT_SERVICE) as InputMethodManager
            systemService.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)

        }
    }

}