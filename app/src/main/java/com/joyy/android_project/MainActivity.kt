package com.joyy.android_project

import android.os.Bundle
import android.os.HandlerThread
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.click).setOnClickListener {
//            val thread1 = Thread(object : Runnable {
//                override fun run() {
//                    println("thread1 start()");
//                    println("thread1 end()");
//                }
//
//            });
            val handlerThread = HandlerThread("HandlerThread");
            handlerThread.start();

        }
    }

    /**
     * {@inheritDoc}
     *
     * Dispatch onResume() to fragments.
     */
    override fun onPostResume() {
        super.onPostResume()
    }

    /**
     * This is the fragment-orientated version of {@link #onResume()} that you
     * can override to perform operations in the Activity at the same point
     * where its fragments are resumed.  Be sure to always call through to
     * the super-class.
     */
    override fun onResumeFragments() {
        super.onResumeFragments()
    }
}