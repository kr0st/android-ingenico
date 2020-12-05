package com.sudo.den.lesson6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable rocketAnimation;

    private View mContentView;
    private View mLoadingView;
    private int mShortAnimationDuration;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        animateStaticDrawable();
//        animateVectorDrawable();
//        animateRevealView();
        animateViewX();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    private void animateStaticDrawable() {
        setContentView(R.layout.activity_main);
        ImageView rocketImage = (ImageView) findViewById(R.id.rocket_image);
        rocketImage.setBackgroundResource(R.drawable.rocket_thrust);
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();

        rocketImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rocketAnimation.start();
            }
        });
    }

    private void animateVectorDrawable() {
        setContentView(R.layout.activity_main);
        ImageView rocketImage = (ImageView) findViewById(R.id.rocket_image);
        rocketImage.setImageResource(R.drawable.animvectordrawable);
        rocketImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Drawable drawable = ((ImageView)v).getDrawable();
                ((Animatable) drawable).start();
            }
        });
    }

    private void animateRevealView() {
        setContentView(R.layout.activity_main_reveal);

        mContentView = findViewById(R.id.content);
        mLoadingView = findViewById(R.id.loading_spinner);

        // Initially hide the content view.
        mContentView.setVisibility(View.GONE);

        // Retrieve and cache the system's default "short" animation time.
        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);

        mLoadingView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                crossfade();
            }
        });
    }

    private void crossfade() {

        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        mContentView.setAlpha(0f);
        mContentView.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        mContentView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        mLoadingView.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mLoadingView.setVisibility(View.GONE);
                    }
                });
    }

    private void animateViewX() {
        setContentView(R.layout.activity_main_move);

        final View view = findViewById(R.id.viewToAnimate);

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationX", 800f);
                animation.setDuration(2000);
                animation.start();
            }
        });
    }
}
