package com.joyy.android_project

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        val anim: ObjectAnimator = ObjectAnimator.ofObject(
            findViewById<View>(R.id.myView2),
            "color",
            ColorEvaluator(),
            "#0000FF",
            "#FF0000"
        )
        anim.duration = 3000;
        anim.start();
    }

}