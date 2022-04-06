package com.joyy.android_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<View>(R.id.toFirst).setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        findViewById<View>(R.id.toSecond).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        findViewById<View>(R.id.toThird).setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        findViewById<View>(R.id.toFour).setOnClickListener {
            startActivity(Intent(this, FourActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        Utils.printTask(this)
    }
}