package com.joyy.android_project;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultInterpolatorActivity extends AppCompatActivity {

    class Obj {
        View view;
        Interpolator interpolator;

        public Obj(View view, android.view.animation.Interpolator interpolator) {
            this.view = view;
            this.interpolator = interpolator;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_interpolator);
        findViewById(R.id.btnStart).setOnClickListener(v -> {
            List<Obj> objects = Arrays.asList(
                    new Obj(findViewById(R.id.LinearInter), new LinearInterpolator()),
                    new Obj(findViewById(R.id.Accelerate), new AccelerateInterpolator()),
                    new Obj(findViewById(R.id.AccelerateDecelerate), new AccelerateDecelerateInterpolator()),
                    new Obj(findViewById(R.id.Cycle), new CycleInterpolator(4)),
                    new Obj(findViewById(R.id.Decelerate), new DecelerateInterpolator()),
                    new Obj(findViewById(R.id.Anticipate), new AnticipateInterpolator()),
                    new Obj(findViewById(R.id.AnticipateOvershoot), new AnticipateOvershootInterpolator()),
                    new Obj(findViewById(R.id.Bounce), new BounceInterpolator()),
                    new Obj(findViewById(R.id.Overshot), new OvershootInterpolator())
            );
            List<Animator> list = new ArrayList<>();
            for (Obj object : objects) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(object.view, "translationX", 0, 600);
                anim.setInterpolator(object.interpolator);
                list.add(anim);
            }
            AnimatorSet set = new AnimatorSet();
            set.setDuration(1000L);
            set.playTogether(list);
            set.start();
        });
    }
}