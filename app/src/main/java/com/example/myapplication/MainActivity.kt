package com.example.myapplication

import android.Manifest
import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    lateinit var lottieAnimationView: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(android.R.style.Theme_Wallpaper_NoTitleBar_Fullscreen)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn).setOnClickListener(object : View.OnClickListener {
            @SuppressLint("ResourceType")
            override fun onClick(v: View?) {
                //startActivity(Intent(Intent.ACTI_SET_WALLPAPER))
                val instance = WallpaperManager.getInstance(applicationContext)

                instance.setResource(R.drawable.pic)
                if (ActivityCompat.checkSelfPermission(
                        applicationContext,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@MainActivity,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        100
                    )
                    return
                }
                //findViewById<View>(R.id.myback).background = instance.drawable;
            }
        })

        load()
    }

    fun load() {
        lottieAnimationView = LottieAnimationView(this)
        val layoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1000)
        val container = findViewById<FrameLayout>(R.id.container)
        container.addView(lottieAnimationView, layoutParams)
        lottieAnimationView.setAnimation("")
        lottieAnimationView.loop(true)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        lottieAnimationView.playAnimation()
    }
}