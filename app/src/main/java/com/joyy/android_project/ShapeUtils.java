/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.joyy.android_project;

import android.graphics.Path;

/**
 * 计算阴影layout的path
 *
 * @author shangxiaoshuai
 * @since 2022-01-25
 */
public class ShapeUtils {
    private static final int MULTIPLE_2 = 2;
    
    /**
     * 计算圆角路径
     *
     * @param roundedRectBean 路径
     * @return Path
     */
    public static Path roundedRect(RoundedRectBean roundedRectBean) {
        Path path = new Path();
        float tl = roundedRectBean.getTl();
        tl = Math.max(tl, 0f);
        float tr = roundedRectBean.getTr();
        tr = Math.max(tr, 0f);
        float br = roundedRectBean.getBr();
        br = Math.max(br, 0f);
        float bl = roundedRectBean.getBl();
        bl = Math.max(bl, 0f);

        float left = roundedRectBean.getLeft();
        float top = roundedRectBean.getTop();
        float right = roundedRectBean.getRight();
        float bottom = roundedRectBean.getBottom();

        float width = right - left;
        float height = bottom - top;
        float min = Math.min(width, height);
        
        tl = Math.min(tl, min / MULTIPLE_2);
        tr = Math.min(tr, min / MULTIPLE_2);
        br = Math.min(br, min / MULTIPLE_2);
        bl = Math.min(bl, min / MULTIPLE_2);

        if (tl == tr && tr == br && br == bl && tl == min / MULTIPLE_2) {
            float radius = min / MULTIPLE_2;
            path.addCircle(left + radius, top + radius, radius, Path.Direction.CW);
            return path;
        }
        drawPathTr(path, right, top, tr);
        drawPathTl(path, width, tr, tl);
        drawPathBl(path, height, tl, bl);
        drawPathBr(path, width, bl, br);
        
        path.rLineTo(0f, -(height - br - tr));
        path.close();
        return path;
    }

    private static void drawPathTr(Path path, float right, float top, float tr) {
        path.moveTo(right, top + tr);
        if (tr > 0) {
            path.rQuadTo(0f, -tr, -tr, -tr);
        } else {
            path.rLineTo(0f, -tr);
            path.rLineTo(-tr, 0f);
        }
    }

    private static void drawPathTl(Path path, float width, float tr, float tl) {
        path.rLineTo(-(width - tr - tl), 0f);
        if (tl > 0) {
            path.rQuadTo(-tl, 0f, -tl, tl);
        } else {
            path.rLineTo(-tl, 0f);
            path.rLineTo(0f, tl);
        }
    }

    private static void drawPathBl(Path path, float height, float tl, float bl) {
        path.rLineTo(0f, height - tl - bl);
        if (bl > 0) {
            path.rQuadTo(0f, bl, bl, bl);
        } else {
            path.rLineTo(0f, bl);
            path.rLineTo(bl, 0f);
        }
    }

    private static void drawPathBr(Path path, float width, float bl, float br) {
        path.rLineTo(width - bl - br, 0f);
        if (br > 0) {
            path.rQuadTo(br, 0f, br, -br);
        } else {
            path.rLineTo(br, 0f);
            path.rLineTo(0f, -br);
        }
    }
    
    /**
     * 计算阴影layout的path 数据类
     *
     * @author shangxiaoshuai
     * @since 2022-01-25
     */
    public static class RoundedRectBean {
        private float left;

        private float top;

        private float right;

        private float bottom;

        private float tl;

        private float tr;

        private float br;

        private float bl;

        public float getLeft() {
            return left;
        }

        public void setLeft(float left) {
            this.left = left;
        }

        public float getTop() {
            return top;
        }

        public void setTop(float top) {
            this.top = top;
        }

        public float getRight() {
            return right;
        }

        public void setRight(float right) {
            this.right = right;
        }

        public float getBottom() {
            return bottom;
        }

        public void setBottom(float bottom) {
            this.bottom = bottom;
        }

        public float getTl() {
            return tl;
        }

        public void setTl(float tl) {
            this.tl = tl;
        }

        public float getTr() {
            return tr;
        }

        public void setTr(float tr) {
            this.tr = tr;
        }

        public float getBr() {
            return br;
        }

        public void setBr(float br) {
            this.br = br;
        }

        public float getBl() {
            return bl;
        }

        public void setBl(float bl) {
            this.bl = bl;
        }
    }
}
