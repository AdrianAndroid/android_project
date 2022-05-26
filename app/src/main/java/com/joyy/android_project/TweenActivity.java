package com.joyy.android_project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TweenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_alpha;
    private Button btn_scale;
    private Button btn_tran;
    private Button btn_rotate;
    private Button btn_set;
    private FrameLayout img_show;
    private Animation animation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        bindViews();
    }

    private void bindViews() {
        btn_alpha = findViewById(R.id.btn_alpha);
        btn_scale = findViewById(R.id.btn_scale);
        btn_tran = findViewById(R.id.btn_tran);
        btn_rotate = findViewById(R.id.btn_rotate);
        btn_set = findViewById(R.id.btn_set);
        img_show = findViewById(R.id.img_show);
        findViewById(R.id.btn_up).setOnClickListener(this);
        findViewById(R.id.btn_down).setOnClickListener(this);

        btn_alpha.setOnClickListener(this);
        btn_scale.setOnClickListener(this);
        btn_tran.setOnClickListener(this);
        btn_rotate.setOnClickListener(this);
        btn_set.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
                img_show.startAnimation(animation);
                break;
            case R.id.btn_scale:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
                img_show.startAnimation(animation);
                break;
            case R.id.btn_tran:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
                img_show.startAnimation(animation);
                break;
            case R.id.btn_rotate:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
                img_show.startAnimation(animation);
                break;
            case R.id.btn_set:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
                img_show.startAnimation(animation);
                break;
            case R.id.btn_up:
                AnimationSet set = new AnimationSet(true);
                ScaleAnimation scaleAnimation = new ScaleAnimation(
                        1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 0
                );
                AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
                set.setDuration(2000);
                set.setFillAfter(true);
                set.addAnimation(scaleAnimation);
                set.addAnimation(alphaAnimation);
                animation = set;
                img_show.startAnimation(animation);
                break;
            case R.id.btn_down:
                View viewById = findViewById(R.id.container);
                AnimationSet set2 = new AnimationSet(true);
                set2.setDuration(2000);
                set2.setFillAfter(false);
                ScaleAnimation scaleAnimation1 = new ScaleAnimation(1f, 0f, 1f, 0f
                , Animation.ABSOLUTE, viewById.getWidth()/2, Animation.ABSOLUTE, viewById.getHeight()/2);
                set2.addAnimation(scaleAnimation1);
                set2.addAnimation(new AlphaAnimation(1f, 0f));
                animation = set2;
                viewById.startAnimation(animation);
                break;
        }
    }
}