package com.joyy.android_project

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity", "$this onCreate, $savedInstanceState")

        findViewById<View>(R.id.clickTv).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java));
        }
    }

//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        super.onSaveInstanceState(outState, outPersistentState)
//        Log.i("MainActivity", "this:onSaveInstanceState,outState")
//    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("MainActivity", "$this :onSaveInstanceState,$outState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MainActivity", "$this :onRestoreInstanceState,$savedInstanceState")
    }
}

/*
2022-04-03 04:47:12.610 7785-7785/com.joyy.android_project I/MainActivity: com.joyy.android_project.MainActivity@bb75e40 onCreate, null
2022-04-03 04:47:58.226 7785-7785/com.joyy.android_project I/MainActivity: com.joyy.android_project.MainActivity@6c52994 onCreate, null
2022-04-03 04:47:58.795 7785-7785/com.joyy.android_project I/MainActivity: com.joyy.android_project.MainActivity@bb75e40 :onSaveInstanceState,Bundle[{android:viewHierarchyState=Bundle[{android:views={16908290=android.view.AbsSavedState$1@95d01f4, 2131230771=androidx.appcompat.widget.Toolbar$SavedState@9ea5d1d, 2131230773=android.view.AbsSavedState$1@95d01f4, 2131230779=android.view.AbsSavedState$1@95d01f4, 2131230861=android.view.AbsSavedState$1@95d01f4, 2131231195=android.view.AbsSavedState$1@95d01f4}}], androidx.lifecycle.BundlableSavedStateRegistry.key=Bundle[{androidx:appcompat=Bundle[{}], android:support:activity-result=Bundle[{KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT=java.util.Random@296ab92, KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS=[FragmentManager:StartIntentSenderForResult, FragmentManager:StartActivityForResult, FragmentManager:RequestPermissions], KEY_COMPONENT_ACTIVITY_REGISTERED_RCS=[895346721, 670364158, 71375386], KEY_COMPONENT_ACTIVITY_PENDING_RESULT=Bundle[{}], KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS=[]}], android:support:fragments=Bundle[{}]}], android:lastAutofillId=1073741823, android:fragments=android.app.FragmentManagerState@759b963}]
2022-04-03 04:48:32.652 7785-7785/com.joyy.android_project I/MainActivity: com.joyy.android_project.MainActivity@bb75e40 :onSaveInstanceState,Bundle[{android:viewHierarchyState=Bundle[{android:views={16908290=android.view.AbsSavedState$1@95d01f4, 2131230771=androidx.appcompat.widget.Toolbar$SavedState@cd04f89, 2131230773=android.view.AbsSavedState$1@95d01f4, 2131230779=android.view.AbsSavedState$1@95d01f4, 2131230861=android.view.AbsSavedState$1@95d01f4, 2131231195=android.view.AbsSavedState$1@95d01f4}}], androidx.lifecycle.BundlableSavedStateRegistry.key=Bundle[{androidx:appcompat=Bundle[{}], android:support:activity-result=Bundle[{KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT=java.util.Random@296ab92, KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS=[FragmentManager:StartIntentSenderForResult, FragmentManager:StartActivityForResult, FragmentManager:RequestPermissions], KEY_COMPONENT_ACTIVITY_REGISTERED_RCS=[895346721, 670364158, 71375386], KEY_COMPONENT_ACTIVITY_PENDING_RESULT=Bundle[{}], KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS=[]}], android:support:fragments=Bundle[{}]}], android:lastAutofillId=1073741823, android:fragments=android.app.FragmentManagerState@9e3cb8e}]


2022-04-03 05:30:52.834 8083-8083/com.joyy.android_project I/MainActivity: com.joyy.android_project.MainActivity@b54d0b7 onCreate, null

2022-04-03 05:30:53.339 8083-8083/com.joyy.android_project I/MainActivity: com.joyy.android_project.MainActivity@6c52994 :onSaveInstanceState,
Bundle[
    {
    android:viewHierarchyState=Bundle[{
            android:views={
            16908290=android.view.AbsSavedState$1@95d01f4,
            2131230771=androidx.appcompat.widget.Toolbar$SavedState@dcc8d16,
            2131230773=android.view.AbsSavedState$1@95d01f4,
            2131230779=android.view.AbsSavedState$1@95d01f4,
            2131230861=android.view.AbsSavedState$1@95d01f4,
            2131231195=android.view.AbsSavedState$1@95d01f4}
            }
        ],
        androidx.lifecycle.BundlableSavedStateRegistry.key=Bundle[{androidx:appcompat=Bundle[{}],
        android:support:activity-result=Bundle[{KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT=java.util.Random@818f697, KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS=[FragmentManager:StartIntentSenderForResult, FragmentManager:StartActivityForResult, FragmentManager:RequestPermissions], KEY_COMPONENT_ACTIVITY_REGISTERED_RCS=[1931113489, 876261061, 1881063798], KEY_COMPONENT_ACTIVITY_PENDING_RESULT=Bundle[{}], KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS=[]}], android:support:fragments=Bundle[{}]}], android:lastAutofillId=1073741823, android:fragments=android.app.FragmentManagerState@d8d3084}
]

 */