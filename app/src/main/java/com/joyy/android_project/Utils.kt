package com.joyy.android_project

import android.app.ActivityManager
import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.content.Context
import android.os.Build
import android.util.Log

/**
 * Time:2022/4/6 12:16
 * Author:
 * Description:
 */
object Utils {

    fun printTask(ctx: Context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            val activityManager: ActivityManager = ctx.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            for (runningTask in activityManager.getRunningTasks(1)) {
                Log.i("Utils", runningTask.toString())
            }
        } else {
            val sUsageStateManager: UsageStatsManager =
                ctx.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
            val event = UsageEvents.Event()
            val usageEvents: UsageEvents = sUsageStateManager.queryEvents(
                0,
                System.currentTimeMillis()
            )
            while (usageEvents.hasNextEvent()) {
                usageEvents.getNextEvent(event)
                Log.i("Utils", event.toString())
            }
        }
    }
}