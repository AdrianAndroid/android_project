package com.joyy.android_project

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * 自动换行布局
 */
class AutoWrapLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        var right: Int = 0
        var height: Int = paddingTop + paddingBottom
        var lineMaxHeight = 0
        for (i in 0 until childCount) {
            val view = getChildAt(i)
            val layoutParams = view.layoutParams as FrameLayout.LayoutParams
            val viewWidth = view.measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin
            val viewHeight =
                view.measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin
            if (right + viewWidth > width) {
                //换行
                height += lineMaxHeight
                right = 0
                lineMaxHeight = 0
            }
            if (right == 0) right = paddingLeft + paddingRight
            right += viewWidth
            if (lineMaxHeight < viewHeight) lineMaxHeight = viewHeight
            if (i == childCount - 1) height += lineMaxHeight
        }
        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        var childleft: Int = 0
        var childtop: Int = paddingTop
        for (i in 0 until childCount) {
            val view = getChildAt(i)
            val layoutParams = view.layoutParams as FrameLayout.LayoutParams
            val viewWidth = view.measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin
            val viewHeight =
                view.measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin
            if (childleft + viewWidth > right - paddingRight) {
                //换行
                childtop += viewHeight
                childleft = 0
            }
            if (childleft == 0) childleft += paddingLeft
            view.layout(childleft, childtop, childleft + viewWidth, childtop + viewHeight)
            childleft += viewWidth
        }
    }

}
