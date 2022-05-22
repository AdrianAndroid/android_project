package com.joyy.android_project.test;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.joyy.android_project.R;

public class DemoActivity extends AppCompatActivity {

    ConstraintSet set1 = new ConstraintSet();
    ConstraintSet set2 = new ConstraintSet();
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        constraintLayout = findViewById(R.id.root_layout);
        set1.clone(constraintLayout);
        set2.clone(this, R.layout.activity_demo2);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            boolean isTest = false;

            @Override
            public void onClick(View v) {
                AutoTransition autoTransition = new AutoTransition();
                TransitionManager.beginDelayedTransition(constraintLayout, autoTransition);
                if (isTest) {
                    set1.applyTo(constraintLayout);
                } else {
                    set2.applyTo(constraintLayout);
                }
                isTest = !isTest;
            }
        });
    }
}