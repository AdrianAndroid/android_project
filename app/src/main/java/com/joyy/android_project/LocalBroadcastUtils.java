package com.joyy.android_project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.function.Function;

public class LocalBroadcastUtils {

    interface OnReceive {
        void onReceive(Context context, Intent intent);
    }

    public static BroadcastReceiver register2(
            Context mContext,
            OnReceive onReceive,
            IntentFilter intentFilter
    ) {
        BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (onReceive != null) onReceive.onReceive(context, intent);
            }
        };
        register(mContext, mBroadcastReceiver, intentFilter);

        return mBroadcastReceiver;
    }

    public static void register(
            Context mContext,
            BroadcastReceiver mBroadcastReceiver,
            IntentFilter intentFilter
    ) {
        LocalBroadcastManager.getInstance(mContext)
                .registerReceiver(mBroadcastReceiver, intentFilter);
    }

    public static void register(
            Context mContext,
            BroadcastReceiver mBroadcastReceiver,
            String... action
    ) {
        IntentFilter intentFilter = new IntentFilter();
        for (String a : action) {
            intentFilter.addAction(a);
        }
        register(mContext, mBroadcastReceiver, intentFilter);
    }

    public static void unRegister(Context mContext, BroadcastReceiver mBroadcastReceiver) {
        if (mContext == null) {
            throw new IllegalArgumentException("Context 不能为空");
        }
        if (mBroadcastReceiver != null) {
            LocalBroadcastManager.getInstance(mContext).unregisterReceiver(mBroadcastReceiver);
        }
    }

    public static void sendBroadcast(Context mContext, Intent intent) {
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
    }

    public static void sendBroadcast(Context mContext, String action) {
        sendBroadcast(mContext, new Intent(action));
    }

    public static void sendBroadcast(Context mContext, String... actions) {
        for (String action : actions) {
            sendBroadcast(mContext, action);
        }
    }

}
