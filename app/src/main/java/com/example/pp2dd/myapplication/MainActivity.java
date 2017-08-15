package com.example.pp2dd.myapplication;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mImage = (ImageView)findViewById(R.id.image);
        //startObjectAnimation(mImage);
        startXMLAnimation(mImage);
    }

    private void startObjectAnimation(final View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.5f)
                .setDuration(2000);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setRepeatCount(-1);
        animator.start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float)valueAnimator.getAnimatedValue();
                view.setScaleX(value);
                view.setRotationX(360*value);
//                view.setRotationY(360*value);
                view.setTranslationX(200*value);
            }
        });

    }

    private void startObjectAnimation2(final View view){

    }

    private void startXMLAnimation(final View view){
        AnimatorSet animator = (AnimatorSet)AnimatorInflater.loadAnimator(this, R.animator.rotate_animator2);
        animator.setTarget(view);
        animator.start();
    }
}
