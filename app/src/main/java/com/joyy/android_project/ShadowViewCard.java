package com.joyy.android_project;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.core.content.ContextCompat;

/**
 * 自定义阴影效果
 *
 * @author shangxiaoshuai
 * @since 2021-12-15
 */
public class ShadowViewCard extends FrameLayout {
    private static final int DEFAULT_VALUE_SHADOW_COLOR = R.color.shadow_default_color;

    private static final int DEFAULT_VALUE_SHADOW_STROKE_COLOR = R.color.shadow_default_stroke_color;

    private static final int DEFAULT_VALUE_STROKE_WIDTH = 0;

    private static final int DEFAULT_VALUE_SHADOW_ROUND = 0;

    private static final int DEFAULT_VALUE_SHADOW_RADIUS = 10;

    private static final int DEFAULT_VALUE_SHADOW_TOP_HEIGHT = 0;

    private static final int DEFAULT_VALUE_SHADOW_LEFT_HEIGHT = 0;

    private static final int DEFAULT_VALUE_SHADOW_RIGHT_HEIGHT = 0;

    private static final int DEFAULT_VALUE_SHADOW_BOTTOM_HEIGHT = 0;

    private static final int DEFAULT_VALUE_SHADOW_OFFSET_X = DEFAULT_VALUE_SHADOW_TOP_HEIGHT / 3;

    private static final int DEFAULT_VALUE_SHADOW_OFFSET_Y = DEFAULT_VALUE_SHADOW_LEFT_HEIGHT / 3;

    private Paint bgPaint;

    private int shadowRound;

    private int shadowColor;

    private int shadowRadius;

    private int shadowOffsetX;

    private int shadowOffsetY;

    private int shadowTopHeight;

    private int shadowLeftHeight;

    private int shadowRightHeight;

    private int shadowBottomHeight;

    private int shadowStrokeWidth;

    private int shadowStrokeColor;

    /**
     * 构造方法
     *
     * @param context context
     */
    public ShadowViewCard(Context context) {
        this(context, null);
    }

    /**
     * 构造方法
     *
     * @param context context
     * @param attrs   attrs
     */
    public ShadowViewCard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 构造方法
     *
     * @param context      context
     * @param attrs        attrs
     * @param defStyleAttr defStyleAttr
     */
    public ShadowViewCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ShadowViewCard);
        shadowRound = a.getDimensionPixelSize(R.styleable.ShadowViewCard_shadowRound, DEFAULT_VALUE_SHADOW_ROUND);
        shadowColor = a.getColor(R.styleable.ShadowViewCard_shadowColor,
                ContextCompat.getColor(context, DEFAULT_VALUE_SHADOW_COLOR));
        shadowTopHeight = a.getDimensionPixelSize(R.styleable.ShadowViewCard_shadowTopHeight,
                DensityUtil.dp2px(getContext(), DEFAULT_VALUE_SHADOW_TOP_HEIGHT));
        shadowRightHeight = a.getDimensionPixelSize(R.styleable.ShadowViewCard_shadowRightHeight,
                DensityUtil.dp2px(getContext(), DEFAULT_VALUE_SHADOW_RIGHT_HEIGHT));
        shadowLeftHeight = a.getDimensionPixelSize(R.styleable.ShadowViewCard_shadowLeftHeight,
                DensityUtil.dp2px(getContext(), DEFAULT_VALUE_SHADOW_LEFT_HEIGHT));
        shadowBottomHeight = a.getDimensionPixelSize(R.styleable.ShadowViewCard_shadowBottomHeight,
                DensityUtil.dp2px(getContext(), DEFAULT_VALUE_SHADOW_BOTTOM_HEIGHT));
        shadowOffsetX = a.getDimensionPixelSize(R.styleable.ShadowViewCard_shadowOffsetX,
                DensityUtil.dp2px(getContext(), DEFAULT_VALUE_SHADOW_OFFSET_X));
        shadowOffsetY = a.getDimensionPixelSize(R.styleable.ShadowViewCard_shadowOffsetY,
                DensityUtil.dp2px(getContext(), DEFAULT_VALUE_SHADOW_OFFSET_Y));
        shadowRadius = a.getDimensionPixelSize(R.styleable.ShadowViewCard_shadowRadius,
                DensityUtil.dp2px(getContext(), DEFAULT_VALUE_SHADOW_RADIUS));
        shadowStrokeWidth =
                a.getDimensionPixelSize(R.styleable.ShadowViewCard_shadowStrokeWidth, DEFAULT_VALUE_STROKE_WIDTH);
        shadowStrokeColor = a.getColor(R.styleable.ShadowViewCard_shadowStrokeColor,
                ContextCompat.getColor(context, DEFAULT_VALUE_SHADOW_STROKE_COLOR));
        a.recycle();
        setPadding(shadowLeftHeight, shadowTopHeight, shadowRightHeight, shadowBottomHeight);
        bgPaint = new Paint();
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        bgPaint.setColor(shadowStrokeColor);
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.STROKE);
        if (shadowStrokeWidth != 0) {
            bgPaint.setStrokeWidth(shadowStrokeWidth);
        }
        bgPaint.setFilterBitmap(true);
        Paint shadowPaint = new Paint();
        shadowPaint.setColor(Color.TRANSPARENT);
        shadowPaint.setStyle(Paint.Style.FILL);
        shadowPaint.setAntiAlias(true);
        float left = shadowLeftHeight;
        float top = shadowTopHeight;
        float right = getWidth() - shadowRightHeight;
        float bottom = getHeight() - shadowBottomHeight;
        shadowPaint.setShadowLayer(shadowRadius, shadowOffsetX, shadowOffsetY, shadowColor);
        RectF rectF = new RectF(left, top, right, bottom);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
        canvas.drawRoundRect(rectF, shadowRound, shadowRound, shadowPaint);
        ShapeUtils.RoundedRectBean rectBean = new ShapeUtils.RoundedRectBean();
        rectBean.setLeft(left);
        rectBean.setTop(top);
        rectBean.setRight(right);
        rectBean.setBottom(bottom);
        rectBean.setBr(shadowRound);
        rectBean.setTr(shadowRound);
        rectBean.setTl(shadowRound);
        rectBean.setBl(shadowRound);
        Path path = ShapeUtils.roundedRect(rectBean);
        canvas.drawPath(path, bgPaint);
        canvas.clipPath(path);
        canvas.save();
        super.dispatchDraw(canvas);
    }

    public int getShadowStrokeColor() {
        return shadowStrokeColor;
    }

    /**
     * 设置边线颜色
     *
     * @param shadowStrokeColor 边线颜色
     */
    public void setShadowStrokeColor(int shadowStrokeColor) {
        this.shadowStrokeColor = shadowStrokeColor;
        invalidate();
    }

    /**
     * 设置圆角
     *
     * @param shadowRound 设置圆角
     */
    public void setShadowRound(int shadowRound) {
        this.shadowRound = shadowRound;
        invalidate();
    }
}
