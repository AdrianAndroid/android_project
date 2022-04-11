package com.joyy.android_project

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "FRAGMENT"
        fun log(msg: String, prefix: String = "Activity") {
            Log.i(TAG, "$prefix -> $msg")
            print("$TAG $prefix -> $msg")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        MainActivity.log("onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btnFinish).setOnClickListener {
            finish()
        }
        findViewById<View>(R.id.btnAdd).setOnClickListener {
            fragmentManager
            val manager = supportFragmentManager
            val beginTransaction: FragmentTransaction = manager.beginTransaction()
            val oneFragment = OneFragment()
            beginTransaction.replace(R.id.dynamicContainer, oneFragment)
            beginTransaction.commit()
            beginTransaction.commitAllowingStateLoss()
            beginTransaction.commitNow()
            beginTransaction.commitNowAllowingStateLoss()
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