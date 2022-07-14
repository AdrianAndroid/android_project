package com.joyy.android_project

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var tv1 = findViewById<TextView>(R.id.tv1)
        tv1.movementMethod = ScrollingMovementMethod.getInstance()
        tv1.requestFocus()
    }

    /**
     * {@inheritDoc}
     *
     * Dispatch onResume() to fragments.
     */
    override fun onPostResume() {
        super.onPostResume()
    }

    /**
     * This is the fragment-orientated version of {@link #onResume()} that you
     * can override to perform operations in the Activity at the same point
     * where its fragments are resumed.  Be sure to always call through to
     * the super-class.
     */
    override fun onResumeFragments() {
        super.onResumeFragments()
    }
}