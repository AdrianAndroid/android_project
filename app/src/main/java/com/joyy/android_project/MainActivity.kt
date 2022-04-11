package com.joyy.android_project

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "FRAGMENT"
        fun log(msg: String, prefix: String = "Activity") {
            Log.i(TAG, "$prefix -> $msg")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        MainActivity.log("onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btnFinish).setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        log("onStart")
        super.onStart()
    }

    override fun onResume() {
        log("onResume")
        super.onResume()
    }

    override fun onRestart() {
        log("onRestart")
        super.onRestart()
    }

    override fun onPause() {
        log("onPause")
        super.onPause()
    }

    override fun onStop() {
        log("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        log("onDestroy")
        super.onDestroy()
    }

}