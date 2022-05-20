package com.joyy.android_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btnMyView2).setOnClickListener {
            startActivity(Intent(this, ColorActivity::class.java));
        }

        findViewById<View>(R.id.btnMyView).setOnClickListener {
            startActivity(Intent(this, PointActivity::class.java));
        }

        findViewById<View>(R.id.Constraint).setOnClickListener {
            startActivity(Intent(this, AnimatorActivity::class.java));
        }
        findViewById<View>(R.id.ObjectID).setOnClickListener {
            startActivity(Intent(this, ObjectActivity::class.java));
        }
        findViewById<View>(R.id.rotation).setOnClickListener {
            startActivity(Intent(this, RotationActivity::class.java));
        }

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