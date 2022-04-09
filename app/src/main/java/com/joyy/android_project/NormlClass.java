package com.joyy.android_project;

import android.os.Handler;
import androidx.annotation.NonNull;

/**
 * Time:2022/4/7 11:53
 * Author:
 * Description:
 */
import android.os.Message;

import java.util.logging.LogRecord;

public class NormlClass {
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            send();
        }
    } ;

    void send() {
        handler.getLooper().quit();
        handler.sendEmptyMessage(0);
    }
}
