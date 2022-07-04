package com.joyy.android_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.toListView).setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        findViewById<View>(R.id.toExpandableView).setOnClickListener {
            startActivity(Intent(this, ExpandableActivity::class.java))
        }
    }

}