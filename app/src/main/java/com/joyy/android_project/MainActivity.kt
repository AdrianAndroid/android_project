package com.joyy.android_project

import android.os.Bundle
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       findViewById<TextView>(R.id.androidId).apply {
           var string = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
           setText("ANDROID_ID:"+string)
       }
        val telephonyManager: TelephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager

    }

    fun getCallState(telephonyManager: TelephonyManager) : String {
       return when (telephonyManager.callState) {
            TelephonyManager.CALL_STATE_IDLE -> "CALL_STATE_IDLE"
            TelephonyManager.CALL_STATE_RINGING -> "CALL_STATE_RINGING"
            TelephonyManager.CALL_STATE_OFFHOOK -> "CALL_STATE_OFFHOOK"
            else -> ""
        }
    }

    private fun log(msg: String) {
        Log.e("MainActivity", msg)
    }

}