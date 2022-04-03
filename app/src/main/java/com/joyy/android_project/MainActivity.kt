package com.joyy.android_project

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity", "$this onCreate, $savedInstanceState")

        val mMyViewPager = findViewById<MyViewPager>(R.id.mMyViewPager)
        listOf<Int>(
            R.drawable.tu1,
            R.drawable.tu2,
            R.drawable.tu3,
        ).forEach {
            val iv = ImageView(this)
            iv.setBackgroundResource(it)
            mMyViewPager.addView(iv)
        }
    }
}