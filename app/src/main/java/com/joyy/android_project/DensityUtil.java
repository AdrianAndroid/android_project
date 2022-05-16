/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2014-2021. All rights reserved.
 */

package com.joyy.android_project;

import android.content.Context;

/**
 * DensityUtil.
 *
 * @author xinmei
 * @since 2014-11-14
 */
public class DensityUtil {
    private DensityUtil() {
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context 上下文
     * @param dpValue dp
     * @return {@link int}
     * @author shi
     * @since 2020/11/13 11:05
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param context 上下文
     * @param pxValue 像素
     * @return {@link int}
     * @author shi
     * @since 2020/11/13 11:06
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

//    /**
//     * 不随系统显示大小改变 不同分辨率下px
//     *
//     * @param context 上下文
//     * @param pxValue 初始px
//     * @return px
//     */
//    public static int px(Context context, int pxValue) {
//        int tempPxValue = pxValue;
//        if (context == null) {
//            return tempPxValue;
//        }
//        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
//        int widthPixels = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
//        final int halfWidth = 2;
//        if (KbdDeviceInfoManager.getInstance().isUnFoldState()) {
//            widthPixels = widthPixels / halfWidth;
//        }
//        final float normalBaseWidth = 360f;
//        final float padBaseWidh = 800f;
//        final float padPxValueRatio = 1.2f;
//        float baseWidth = normalBaseWidth;
//        if (DeviceUtils.isPad()) {
//            baseWidth = padBaseWidh;
//            tempPxValue *= padPxValueRatio;
//        }
//        final int scale = 100;
//        float ratio = new BigDecimal(widthPixels).divide(new BigDecimal(baseWidth), scale, BigDecimal.ROUND_HALF_EVEN)
//            .floatValue();
//        return (int) (tempPxValue * ratio);
//    }
}
