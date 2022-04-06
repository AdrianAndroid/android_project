package com.joyy.android_project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import leakcanary.LeakCanary

class HandlerLeakActivity : AppCompatActivity() {

    val bytes = IntArray(10000)

    private val mLeakHandler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            println("handleMessage")
            helloWorld()
        }
    }

    fun helloWorld() {
        println("Hello World!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_leak)


        mLeakHandler.postDelayed({
            println("Hello World!!!")
            helloWorld()
        }, 10000 * 60 * 40)
//        mLeakHandler.postDelayed({
//            repeat(10000) {
//                Log.i("HandlerLeakActivity", "#post")
//            }
//        }, 1000);
        findViewById<View>(android.R.id.content).setOnClickListener {
            startActivity(Intent(this, HandlerLeakActivity::class.java))
        }
    }
}