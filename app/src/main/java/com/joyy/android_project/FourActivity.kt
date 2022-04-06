package com.joyy.android_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)
    }

    override fun onResume() {
        super.onResume()
        Utils.printTask(this)
    }
}