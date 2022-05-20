package com.joyy.android_project

import android.animation.TimeInterpolator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class AnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_short)

        val longSet = ConstraintSet();
        val shortSet = ConstraintSet();

        val constraintLayout: ConstraintLayout = findViewById(R.id.root_layout);
        shortSet.clone(constraintLayout);
        longSet.clone(this, R.layout.activity_long);


        constraintLayout.setOnClickListener {
            val auto = AutoTransition();
            auto.setInterpolator(TypingInterpolator())
            TransitionManager.beginDelayedTransition(constraintLayout, auto);
            longSet.applyTo(constraintLayout);
        }
    }

    /**
     * 加速器+弹动效果
     *
     * @since 2022-05-18
     */
    internal class TypingInterpolator : TimeInterpolator {
        val two = 2.0f
        val five = 0.5f
        val mTension = 1.03f

        override fun getInterpolation(input: Float): Float {
            return input * input;
//            inTmp -= 1.0f
//            return inTmp * inTmp * ((mTension + 1) * inTmp + mTension) + 1.0f
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
//        private fun getAccelerateDecelerate(input: Float): Float {
//            return (Math.cos((input + 1) * Math.PI) / two).toFloat() + five
//        }
//
//        override fun getInterpolation(input: Float): Float {
//            var inTmp = getAccelerateDecelerate(input)
//            inTmp -= 1.0f
//            return inTmp * inTmp * ((mTension + 1) * inTmp + mTension) + 1.0f
//        }
//    }

}