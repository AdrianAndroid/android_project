package com.joyy.android_project

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var mBroadCast = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            // do something
        }
    }

    override fun onResume() {
        super.onResume()
        LocalBroadcastUtils.register(this, mBroadCast)
    }

    override fun onPause() {
        super.onPause()
        LocalBroadcastUtils.unRegister(this, mBroadCast)
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