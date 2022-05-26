package com.joyy.android_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_tween).setOnClickListener {
            startActivity(Intent(this, TweenActivity::class.java))
        }
        findViewById<View>(R.id.btn_Interpolator).setOnClickListener {
            startActivity(Intent(this, DefaultInterpolatorActivity::class.java))
        }
    }

}