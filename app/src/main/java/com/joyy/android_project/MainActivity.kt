package com.joyy.android_project

import android.animation.TimeInterpolator
import android.os.Bundle
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun test() {
        object : TimeInterpolator {
            override fun getInterpolation(input: Float): Float {
                return input;
            }

        };
        // 动画加速进行
        AccelerateInterpolator();
        // 快速完成动画超出再回到结果样式
        OvershootInterpolator();
        // 先加速再减速
        AccelerateDecelerateInterpolator();
        // 先退后再加速前进
        AnticipateInterpolator();
        // 先退后再加速前进，超出终点再回到终点
        AnticipateOvershootInterpolator();
        // 最后阶段弹球效果
        BounceInterpolator();
        // 周期运动
        CycleInterpolator(10f);
        // 减速
        DecelerateInterpolator();
        // 匀速
        LinearInterpolator();
    }

    /**
     * {@inheritDoc}
     *
     * Dispatch onResume() to fragments.
     */
    override fun onPostResume() {
        super.onPostResume()
    }

    /**
     * This is the fragment-orientated version of {@link #onResume()} that you
     * can override to perform operations in the Activity at the same point
     * where its fragments are resumed.  Be sure to always call through to
     * the super-class.
     */
    override fun onResumeFragments() {
        super.onResumeFragments()
    }
}