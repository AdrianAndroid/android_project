package com.joyy.android_project

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RotationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotation)


        ObjectAnimator.ofFloat(
            findViewById<View>(R.id.view),
            "rotation",
            0f, 180f
        ).setDuration(3000L).start();
    }
}