package com.joyy.android_project

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity

class ObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)
        val view1 = findViewById<View>(R.id.view1);
        val view2 = findViewById<View>(R.id.view2);

        view1.setOnClickListener {
            var apply1 = ObjectAnimator.ofFloat(view1, "scaleX", 1f, 6f).apply {
                interpolator = TypingInterpolator()
            }
            var apply2 = ObjectAnimator.ofFloat(view2, "scaleX", 1f, 6f).apply {
                interpolator = LinearInterpolator();
            }
            val animatorSet = AnimatorSet()
            animatorSet.play(apply1).with(apply2)
            animatorSet.duration = 600L;
            animatorSet.start()
        }
    }

    internal class TypingInterpolator : TimeInterpolator {
        val two = 2.0f
        val five = 0.5f
        val mTension = 1.03f
        private fun getAccelerateDecelerate(input: Float): Float {
            return (Math.cos((input + 1) * Math.PI) / two).toFloat() + five
        }


        override fun getInterpolation(input: Float): Float {
            var inTmp = getAccelerateDecelerate(input)
            inTmp -= 1.0f
            return inTmp * inTmp * ((mTension + 1) * inTmp + mTension) + 1.0f
        }
    }

//    /**
//     * 加速器+弹动效果
//     *
//     * @since 2022-05-18
//     */
//    internal class TypingInterpolator : TimeInterpolator {
//        val two = 2.0f
//        val five = 0.5f
//        val mTension = 1.03f
//
//        override fun getInterpolation(input: Float): Float {
//            return input * input;
////            inTmp -= 1.0f
////            return inTmp * inTmp * ((mTension + 1) * inTmp + mTension) + 1.0f
//        }
//    }


}