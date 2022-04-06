package com.joyy.android_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import leakcanary.LeakCanary

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.mTv).setOnClickListener {
            startActivity(Intent(this, HandlerLeakActivity::class.java))
            //Toast.makeText(this, "mTv", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.mTv2).setOnClickListener {
            LeakCanary.dumpHeap()
        }

        findViewById<View>(R.id.startOtherLeak).setOnClickListener {
            startActivity(Intent(this, OtherLeakActivity::class.java))
        }
    }
}