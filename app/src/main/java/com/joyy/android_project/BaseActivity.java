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

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPostCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getSupportActionBar();
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setSupportActionBar(toolbar);
    }

    @Override
    public void setContentView(int layoutResID) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.addContentView(view, params);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostResume() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onDestroy();
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onTitleChanged(title, color);
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.supportInvalidateOptionsMenu();
    }

    @Override
    public void invalidateOptionsMenu() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.invalidateOptionsMenu();
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onSupportActionModeStarted(mode);
    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onSupportActionModeFinished(mode);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onWindowStartingSupportActionMode(callback);
    }

    @Nullable
    @Override
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.startSupportActionMode(callback);
    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onCreateSupportNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPrepareSupportNavigateUpTaskStack(builder);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onSupportNavigateUp();
    }

    @Override
    public void onContentChanged() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onContentChanged();
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void onPanelClosed(int featureId, @NonNull Menu menu) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPanelClosed(featureId, menu);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void openOptionsMenu() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.openOptionsMenu();
    }

    @Override
    public void closeOptionsMenu() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.closeOptionsMenu();
    }

    @Override
    protected void onNightModeChanged(int mode) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onNightModeChanged(mode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void supportFinishAfterTransition() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.supportFinishAfterTransition();
    }

    @Override
    public void supportPostponeEnterTransition() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.supportPostponeEnterTransition();
    }

    @Override
    public void supportStartPostponedEnterTransition() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.supportStartPostponedEnterTransition();
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onCreateView(parent, name, context, attrs);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public void onLowMemory() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onLowMemory();
    }

    @Override
    protected void onPause() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onNewIntent(intent);
    }

    @Override
    public void onStateNotSaved() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onStateNotSaved();
    }

    @Override
    protected void onResume() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onResume();
    }

    @Override
    protected void onResumeFragments() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onResumeFragments();
    }

    @Override
    public boolean onPreparePanel(int featureId, @Nullable View view, @NonNull Menu menu) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onPreparePanel(featureId, view, menu);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onAttachFragment(fragment);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void onBackPressed() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onBackPressed();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onRestart() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onRestart();
    }

    @Override
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onTopResumedActivityChanged(isTopResumedActivity);
    }

    @Override
    public boolean isVoiceInteraction() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.isVoiceInteraction();
    }

    @Override
    public boolean isVoiceInteractionRoot() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.isVoiceInteractionRoot();
    }

    @Override
    public boolean isLocalVoiceInteractionSupported() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.isLocalVoiceInteractionSupported();
    }

    @Override
    public void startLocalVoiceInteraction(Bundle privateOptions) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startLocalVoiceInteraction(privateOptions);
    }

    @Override
    public void onLocalVoiceInteractionStarted() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onLocalVoiceInteractionStarted();
    }

    @Override
    public void onLocalVoiceInteractionStopped() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onLocalVoiceInteractionStopped();
    }

    @Override
    public void stopLocalVoiceInteraction() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.stopLocalVoiceInteraction();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onUserLeaveHint() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onUserLeaveHint();
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onCreateThumbnail(outBitmap, canvas);
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onCreateDescription();
    }

    @Override
    public void onProvideAssistData(Bundle data) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onProvideAssistData(data);
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onProvideAssistContent(outContent);
    }

    @Override
    public void onGetDirectActions(@NonNull CancellationSignal cancellationSignal, @NonNull Consumer<List<DirectAction>> callback) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onGetDirectActions(cancellationSignal, callback);
    }

    @Override
    public void onPerformDirectAction(@NonNull String actionId, @NonNull Bundle arguments, @NonNull CancellationSignal cancellationSignal, @NonNull Consumer<Bundle> resultListener) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPerformDirectAction(actionId, arguments, cancellationSignal, resultListener);
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }

    @Override
    public int getMaxNumPictureInPictureActions() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getMaxNumPictureInPictureActions();
    }

    @Override
    public int getChangingConfigurations() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getChangingConfigurations();
    }

    @Nullable
    @Override
    public Object getLastNonConfigurationInstance() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getLastNonConfigurationInstance();
    }

    @Override
    public void onTrimMemory(int level) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onTrimMemory(level);
    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onAttachFragment(fragment);
    }

    @Nullable
    @Override
    public android.app.ActionBar getActionBar() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getActionBar();
    }

    @Override
    public void setActionBar(@Nullable android.widget.Toolbar toolbar) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setActionBar(toolbar);
    }

    @Override
    public TransitionManager getContentTransitionManager() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getContentTransitionManager();
    }

    @Override
    public void setContentTransitionManager(TransitionManager tm) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setContentTransitionManager(tm);
    }

    @Override
    public Scene getContentScene() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getContentScene();
    }

    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setFinishOnTouchOutside(finish);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onGenericMotionEvent(event);
    }

    @Override
    public void onUserInteraction() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onUserInteraction();
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onWindowAttributesChanged(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onAttachedToWindow() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onDetachedFromWindow();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.dispatchTrackballEvent(ev);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.dispatchGenericMotionEvent(ev);
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onCreatePanelView(featureId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigateUp() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onNavigateUp();
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onNavigateUpFromChild(child);
    }

    @Override
    public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onCreateNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPrepareNavigateUpTaskStack(builder);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void registerForContextMenu(View view) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.registerForContextMenu(view);
    }

    @Override
    public void unregisterForContextMenu(View view) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.unregisterForContextMenu(view);
    }

    @Override
    public void openContextMenu(View view) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.openContextMenu(view);
    }

    @Override
    public void closeContextMenu() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.closeContextMenu();
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onContextItemSelected(item);
    }

    @Override
    public void onContextMenuClosed(@NonNull Menu menu) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onContextMenuClosed(menu);
    }

    @Override
    public boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onSearchRequested(searchEvent);
    }

    @Override
    public boolean onSearchRequested() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onSearchRequested();
    }

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onApplyThemeResource(theme, resid, first);
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.shouldShowRequestPermissionRationale(permission);
    }

    @Override
    public boolean isActivityTransitionRunning() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.isActivityTransitionRunning();
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startActivity(intent, options);
    }

    @Override
    public void startActivities(Intent[] intents, @Nullable Bundle options) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startActivities(intents, options);
    }

    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.startActivityIfNeeded(intent, requestCode, options);
    }

    @Override
    public boolean startNextMatchingActivity(@NonNull Intent intent, @Nullable Bundle options) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.startNextMatchingActivity(intent, options);
    }

    @Override
    public void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startActivityFromChild(child, intent, requestCode, options);
    }

    @Override
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    public Uri onProvideReferrer() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onProvideReferrer();
    }

    @Nullable
    @Override
    public ComponentName getCallingActivity() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getCallingActivity();
    }

    @Override
    public boolean isChangingConfigurations() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.isChangingConfigurations();
    }

    @Override
    public void finishAfterTransition() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.finishAfterTransition();
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onActivityReenter(resultCode, data);
    }

    @Override
    public int getRequestedOrientation() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getRequestedOrientation();
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setRequestedOrientation(requestedOrientation);
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.moveTaskToBack(nonRoot);
    }

    @Override
    public ComponentName getComponentName() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getComponentName();
    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onChildTitleChanged(childActivity, title);
    }

    @Override
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setTaskDescription(taskDescription);
    }

    @Override
    public void onVisibleBehindCanceled() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onVisibleBehindCanceled();
    }

    @Override
    public void onEnterAnimationComplete() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onEnterAnimationComplete();
    }

    @Override
    public void setVrModeEnabled(boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setVrModeEnabled(enabled, requestedComponent);
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.startActionMode(callback);
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.startActionMode(callback, type);
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onWindowStartingActionMode(callback);
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.onWindowStartingActionMode(callback, type);
    }

    @Override
    public void onActionModeStarted(android.view.ActionMode mode) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onActionModeStarted(mode);
    }

    @Override
    public void onActionModeFinished(android.view.ActionMode mode) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onActionModeFinished(mode);
    }

    @Override
    public void postponeEnterTransition() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.startPostponedEnterTransition();
    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.requestDragAndDropPermissions(event);
    }

    @Override
    public void setTurnScreenOn(boolean turnScreenOn) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.setTurnScreenOn(turnScreenOn);
    }

    @Override
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override
    public Context getBaseContext() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getBaseContext();
    }

    @Override
    public ContentResolver getContentResolver() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getContentResolver();
    }

    @Override
    public Context getApplicationContext() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getApplicationContext();
    }

    @Override
    public String getOpPackageName() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getOpPackageName();
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.getApplicationInfo();
    }

    @Override
    public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.moveSharedPreferencesFrom(sourceContext, name);
    }

    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.openFileInput(name);
    }

    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.openFileOutput(name, mode);
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.openOrCreateDatabase(name, mode, factory);
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    @Override
    public boolean moveDatabaseFrom(Context sourceContext, String name) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.moveDatabaseFrom(sourceContext, name);
    }

    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.sendBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.sendOrderedBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags);
    }

    @Override
    public ComponentName startService(Intent service) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.startService(service);
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.startForegroundService(service);
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.bindService(service, conn, flags);
    }

    @Override
    public boolean bindService(Intent service, int flags, Executor executor, ServiceConnection conn) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.bindService(service, flags, executor, conn);
    }

    @Override
    public boolean bindIsolatedService(Intent service, int flags, String instanceName, Executor executor, ServiceConnection conn) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.bindIsolatedService(service, flags, instanceName, executor, conn);
    }

    @Override
    public void updateServiceGroup(ServiceConnection conn, int group, int importance) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.updateServiceGroup(conn, group, importance);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.unbindService(conn);
    }

    @Override
    public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.startInstrumentation(className, profileFile, arguments);
    }

    @Override
    public int checkPermission(String permission, int pid, int uid) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.checkPermission(permission, pid, uid);
    }

    @Override
    public int checkCallingPermission(String permission) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.checkCallingPermission(permission);
    }

    @Override
    public int checkCallingOrSelfPermission(String permission) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.checkCallingOrSelfPermission(permission);
    }

    @Override
    public int checkSelfPermission(String permission) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.checkSelfPermission(permission);
    }

    @Override
    public void enforcePermission(String permission, int pid, int uid, String message) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.enforcePermission(permission, pid, uid, message);
    }

    @Override
    public void enforceCallingPermission(String permission, String message) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.enforceCallingPermission(permission, message);
    }

    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.enforceCallingOrSelfPermission(permission, message);
    }

    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.grantUriPermission(toPackage, uri, modeFlags);
    }

    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.revokeUriPermission(uri, modeFlags);
    }

    @Override
    public void revokeUriPermission(String targetPackage, Uri uri, int modeFlags) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.revokeUriPermission(targetPackage, uri, modeFlags);
    }

    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.checkUriPermission(uri, pid, uid, modeFlags);
    }

    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.checkCallingUriPermission(uri, modeFlags);
    }

    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    @Override
    public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }

    @Override
    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    @Override
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.enforceCallingUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.createPackageContext(packageName, flags);
    }

    @Override
    public Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.createContextForSplit(splitName);
    }

    @Override
    public Context createConfigurationContext(Configuration overrideConfiguration) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.createConfigurationContext(overrideConfiguration);
    }

    @Override
    public Context createDisplayContext(Display display) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.createDisplayContext(display);
    }

    @Override
    public Context createDeviceProtectedStorageContext() {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.createDeviceProtectedStorageContext();
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.registerComponentCallbacks(callback);
    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.unregisterComponentCallbacks(callback);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        super.onPointerCaptureChanged(hasCapture);
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Log.i("BaseActivity"," [Thread]->" + Thread.currentThread().getName(), new Exception());
        return super.clone();
    }
}
