package com.example.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class StudentProfile extends AppCompatActivity {

    LinearLayout llSubject;
    ConstraintLayout clSubject;
    ImageView nextnavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        nextnavigation = findViewById(R.id.navigator);
        nextnavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your click handling logic here
                startActivity(new Intent(StudentProfile.this, studentMarksUi.class));
                // Example: Animate color change on click
                int colorFrom = Color.BLACK;
                int colorTo = Color.RED;
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(500); // Use 500 milliseconds for a half-second animation
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        nextnavigation.setColorFilter((int) animator.getAnimatedValue(), PorterDuff.Mode.SRC_IN);
                    }
                });
                colorAnimation.start();
            }
        });

//        clSubject = findViewById(R.id.clSubject);
//
//        clSubject.setOnClickListener(view -> {
//            if (llSubject.getVisibility() == View.GONE) {
//                llSubject.setVisibility(View.VISIBLE);
//            } else {
//                llSubject.setVisibility(View.GONE);
//            }
//        });
    }
}