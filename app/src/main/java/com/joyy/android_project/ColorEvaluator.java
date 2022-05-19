package com.joyy.android_project;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * 功能描述
 *
 * @author zhaojian
 * @since 2022-05-19
 */
public class ColorEvaluator implements TypeEvaluator {

    // 实现TypeEvaluator接口
    private int mCurrentRed;
    private int mCurrentGreen;
    private int mCurrentBlue;

    // 复写evaluate()
    // 在eveluate()里写入对象动画过度的逻辑：此处是写颜色过度的逻辑
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Log.e(getClass().getSimpleName(), "fraction = " + fraction + " , startValue = " + startValue + " , endValue = " + endValue);

        // 获取到颜色的初始值和结束值
        String startColor = (String) startValue;
        String endColor = (String) endValue;

        // 通过字符串截取的方式将初始化亚瑟氛围RGB三个部分，并将RGB的值转换成十进制数字
        // 那么每个颜色的取值范围就是0-255
        int startRed = parseRed(startColor);
        int startGreen = parseGreen(startColor);
        int startBlue = parseBlue(startColor);


        int endRed = parseRed(endColor);
        int endGreen = parseGreen(endColor);
        int endBlue = parseBlue(endColor);

        // 将初始化颜色的值定义为当前需要操作的颜色值
        mCurrentRed = startRed;
        mCurrentGreen = startGreen;
        mCurrentBlue = startBlue;

        // 计算初始颜色和结束颜色之间的差值
        // 该差值决定着颜色变化的快慢：初始颜色值和结束颜色值很相近，那么颜色变化就会比较缓慢；否则，变化则很快
        int redDiff = Math.abs(startRed - endRed);
        int greeDiff = Math.abs(startGreen - endGreen);
        int blueDiff = Math.abs(startBlue - endBlue);
        int colorDiff = redDiff + greeDiff + blueDiff;
        if (mCurrentRed != endRed) {
            mCurrentRed = getCurrentColor(startRed, endRed, colorDiff, 0, fraction);
        } else if (mCurrentGreen != endGreen) {
            mCurrentGreen = getCurrentColor(startGreen, endGreen, colorDiff, redDiff, fraction);
        } else if (mCurrentBlue != endBlue) {
            mCurrentBlue = getCurrentColor(startBlue, endBlue, colorDiff, redDiff + greeDiff, fraction);
        }

        // 将计算出的当前颜色的值组装返回
        String currentColor = "#" + getHexString(mCurrentRed) + getHexString(mCurrentGreen) + getHexString(mCurrentBlue);

        // 由于我们计算出的颜色是十进制数字，所以需要转换成十六进制字符串：调用getHexString()->>关注2
        // 最终将RGB颜色拼装起来，并作为最终的结果返回
        return currentColor;
    }

    private int parseRed(String color) {
        return parseColor(color, 1, 3);
    }

    private int parseGreen(String color) {
        return parseColor(color, 3, 5);
    }

    private int parseBlue(String color) {
        return parseColor(color, 5, 7);
    }

    private int parseColor(String color, int start, int end) {
        return Integer.parseInt(color.substring(start, end), 16);
    }


    // 关注1：getCurrentColor()
    // 具体是根据fraction值来计算当前的颜色
    private int getCurrentColor(int startColor, int endColor, int colorDiff, int offset, float fraction) {
        int currentColor;
        if (startColor > endColor) {
            currentColor = (int) (startColor - (fraction * colorDiff - offset));
            if (currentColor < endColor) {
                currentColor = endColor;
            }
        } else {
            currentColor = (int) (startColor + (fraction * colorDiff - offset));
            if (currentColor > endColor) {
                currentColor = endColor;
            }
        }
        return currentColor;
    }

    // 关注2： 将10进制颜色值转换成16进制
    private String getHexString(int value) {
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString;
    }
}
