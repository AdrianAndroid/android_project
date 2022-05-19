package com.joyy.android_project;

import android.animation.TypeEvaluator;

/**
 * 功能描述
 *
 * @author zhaojian
 * @since 2022-05-19
 */
public class PointEvaluator implements TypeEvaluator {

    // 复写evaluate()
    // 在evaluate()里写入对象动画过度的逻辑
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        // 将动画初始值startValue 和 动画结束值endValue 强制转换成Point对象
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;

        // 根据fraction来计算当前动画的x和y的值
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());

        // 将计算后的坐标封装到一个新的Point对象中并返回
        Point point = new Point(x, y);
        return point;
    }
}
