package com.joyy.android_project;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.DirectAction;
import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.PersistableBundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.Fragment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

public class BaseActivity2 extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.i(getClass().getSimpleName()," [Thread]->" + Thread.currentThread().getName(), new Exception());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(getClass().getSimpleName()," [Thread]->" + Thread.currentThread().getName(), new Exception());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getClass().getSimpleName()," [Thread]->" + Thread.currentThread().getName(), new Exception());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(getClass().getSimpleName()," [Thread]->" + Thread.currentThread().getName(), new Exception());
    }

    @Override
    protected void onPause() {
        Log.i(getClass().getSimpleName()," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(getClass().getSimpleName()," [Thread]->" + Thread.currentThread().getName(), new Exception());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getClass().getSimpleName()," [Thread]->" + Thread.currentThread().getName(), new Exception());
    }
}
