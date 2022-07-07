package com.joyy.android_project;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class CustomListView extends ListView {

    public CustomListView(Context context) {
        super(context);
        init();
    }

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setRecyclerListener(new RecyclerListener() {
            @Override
            public void onMovedToScrapHeap(View view) {
                //log("onMovedToScrapHeap");
            }
        });
    }

    private void log(String str) {
        Log.i(CustomListView.class.getSimpleName(), str);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        log("onTouchEvent");
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        log("onGenericMotionEvent");
        return super.onGenericMotionEvent(event);
    }

    @Override
    protected void layoutChildren() {
        log("layoutChildren");
        super.layoutChildren();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        return super.startNestedScroll(axes);
    }

    @Override
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
    }

    @Override
    public void onViewAdded(View child) {
        super.onViewAdded(child);
    }
}
