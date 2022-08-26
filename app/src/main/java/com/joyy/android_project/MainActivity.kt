package com.joyy.android_project

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity"

    private fun log(msg: String) {
        Log.i("MainActivity", msg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        System.err.println("[WARN] RES_TABLE_PACKAGE_TYPE LoadedPackage load")

        // 左上角 x=230 y=1750
        // 右下角 x=1000 y=2300

        findViewById<View>(R.id.btnStart).setOnClickListener {
            it.postDelayed(Runnable {
                Thread {
                    log("down")
                    Utils.injectActionDown(34F, 460F)
                    Utils.injectActionUp(34F, 460F)
                }.start()
            }, 2000)
        }

        findViewById<View>(R.id.btnPause).setOnClickListener {

        }

        findViewById<View>(R.id.btnStop).setOnClickListener {

        }

        initEditText()
    }

    fun initEditText() {
        val onEdit = findViewById<EditText>(R.id.onEdit)
        onEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                log("beforeTextChanged s->$s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                log("onTextChanged s->$s")
            }

            override fun afterTextChanged(s: Editable?) {
//                log("afterTextChanged s->$s")
            }
        })
    }

    private var preAction = -1

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev == null) {
            return super.dispatchTouchEvent(ev)
        }
        if (ev.action != preAction) {
            preAction = ev.action
            when (ev.action) {
                MotionEvent.ACTION_DOWN -> log("ACTION_DOWN")
                MotionEvent.ACTION_MOVE -> log("ACTION_MOVE")
                MotionEvent.ACTION_UP -> log("ACTION_UP")
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        log("onKeyDown")
        return super.onKeyDown(keyCode, event)
    }

}