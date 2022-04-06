package com.joyy.android_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        findViewById<View>(R.id.toFirst).setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        findViewById<View>(R.id.toSecond).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        findViewById<View>(R.id.toThird).setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
            //Toast.makeText(this, "toThird", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.toFour).setOnClickListener {
            startActivity(Intent(this, FourActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        Utils.printTask(this)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "newIntent", Toast.LENGTH_SHORT).show()
    }
}