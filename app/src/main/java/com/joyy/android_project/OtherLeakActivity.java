package com.joyy.android_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import androidx.appcompat.app.AppCompatActivity;
import leakcanary.LeakCanary;

public class OtherLeakActivity extends AppCompatActivity {

    static class MyMessage {
        final String message;

        MyMessage(String message) {
            this.message = message;
        }
    }

    static void startThread() {
        final BlockingQueue<MyMessage> queue = new LinkedBlockingQueue<>();
        MyMessage message = new MyMessage("Hello Leaking World!");
        queue.offer(message);
        new Thread() {
            @Override
            public void run() {
                //super.run();
                try {
                    loop(queue);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }
    void testHandler() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.sendEmptyMessage(0);
        handler.removeCallbacksAndMessages(null);
    }

    static void loop(BlockingQueue<MyMessage> queue) throws InterruptedException {
        while (true) {
            MyMessage message = queue.take();
            System.out.println("Received: " + message);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_leak);
        findViewById(R.id.btnLeakanary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeakCanary.INSTANCE.dumpHeap();
            }
        });
        findViewById(R.id.btnDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(OtherLeakActivity.this)
                    .setPositiveButton("Button", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            OtherLeakActivity.this.makeBread();
                        }
                    })
                    .show();
            }
        });
    }

    void makeBread() {
        System.out.println("makeBread");
    }

    private final View.OnClickListener mButtonHandler =
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Message m;

            }
        };

    void testHandlerThread() {
        HandlerThread background = new HandlerThread("BackgroundThread");
        background.start();
        Handler backgroundHandler = new Handler(background.getLooper());
        final DialogInterface.OnClickListener clickListener =
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    OtherLeakActivity.this.makeBread();
                }
            };
        backgroundHandler.post(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new AlertDialog.Builder(OtherLeakActivity.this)
                            .setPositiveButton("Buaguette", clickListener)
                            .show();
                    }
                });
            }
        });
    }
}