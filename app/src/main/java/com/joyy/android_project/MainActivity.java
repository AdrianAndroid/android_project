package com.joyy.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends BaseActivity2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void test() {
        Handler handler = new Handler();
        handler.sendEmptyMessage(0);
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}