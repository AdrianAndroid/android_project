package com.joyy.android_project;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Time:2022/4/3 17:02
 * Author:
 * Description: https://blog.csdn.net/jingerlovexiaojie/article/details/105998351
 */
public class MyViewPager extends ViewGroup {

    private void log(String msg) {
        Log.i("MyViewPager", msg);
    }

    private GestureDetector mGestureDetector;
    private int scrollX;
    private int position;
    private Scroller mScroller;
    private int originalX = 0;
    private int originalY = 0;

    public MyViewPager(Context context) {
        super(context);
        initView(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    // public MyViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    //     super(context, attrs, defStyleAttr, defStyleRes);
    //     initView(context);
    // }

    private void initView(Context context) {
        mScroller = new Scroller(context);
        mGestureDetector = new GestureDetector(
            context,
            new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    // 当有手指在屏幕上滑动的时候回调
                    // distanceX为正时候，向左移动，为负时，向右移动
                    // 移动屏幕的方法scrollBy，很重要，这个方法会调用onScrollChanged方法，并刷新视图
                    // dx表示x方向上移动的距离，dy表示y方向上移动的距离。
                    scrollBy((int) distanceX, 0);
                    return super.onScroll(e1, e2, distanceX, distanceY);
                }
            }
        );
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // 如果左右滑动，就需要拦截，上下滑动，不需要拦截
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                originalX = (int) ev.getX();
                originalY = (int) ev.getY();
                //这个时候还需要把将ACTION_DOWN传递给手势识别器，因为拦截了MOVE的事件后，DOWN的事件还是要给手势识别器处理，否则会丢失事件，滑动的时候会存在bug。
                mGestureDetector.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                // 上下滑动拦截，左右滑动不拦截
                int currentX = (int) ev.getX();
                int currentY = (int) ev.getY();

                int dx = currentX - originalX;
                int dy = currentY - originalY;

                if (Math.abs(dx) > Math.abs(dy)) {
                    // 左右滑动
                    return true; // 中断事件传递，不允许孩子响应事件
                } else {
                    return false;
                }
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 将触摸事件传递手势识别器
        mGestureDetector.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                scrollX = getScrollX(); // 相对于初始位置滑动的距离
                // 你滑动的距离加上屏幕的一半，除以屏幕宽度，就是当前图片显示的position，
                // 如果你滑动距离超过了屏幕的一半，这个position就+1
                position = (getScrollX() + getWidth() / 2) / getWidth();
                // 滑动到最后一张的时候，不能出边界
                if (position >= getChildCount()) {
                    position = getChildCount() - 1;
                }
                if (position < 0) {
                    position = 0;
                }
                break;
            case MotionEvent.ACTION_UP:
                // 绝对滑动，直接滑到指定的x，y的位置，较迟钝
                // scrollTo(position*getWidth(), 0);
                // 滚动，startX, startY为开始滚动的位置，dx，dy为滚动的偏移量
                mScroller.startScroll(scrollX, 0, -(scrollX - position * getWidth()), 0);
                // 使用invalidate这个方法会执行一个回调方法computeScroll, 我们来重写这个方法
                invalidate();
                break;
        }
        //return super.onTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        //super.computeScroll();
        log("computeScroll");
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), 0);
            postInvalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        log("onMeasure");
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        log("onLayout");
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            view.layout(i * getWidth(), 0, (i + 1) * getWidth(), getHeight());
        }
    }

}
