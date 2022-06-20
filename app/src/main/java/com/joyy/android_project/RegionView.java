package com.joyy.android_project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class RegionView extends View {
    private Paint mPaint;

    public RegionView(Context context) {
        super(context);
        init();
    }

    public RegionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RegionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(3);
    }

    private void drawRegion(Canvas canvas, Region region, Paint paint) {
        RegionIterator iter = new RegionIterator(region);
        Rect r = new Rect();
        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Region region = new Region(0, 0, 100, 100);
        region.setEmpty();
        Region region1 = new Region(0, 0, 100, 100);
        region.set(region1);
        Rect rect = new Rect(100, 0, 200, 200);
        region.union(rect);
        drawRegion(canvas, region, mPaint);
    }
}
