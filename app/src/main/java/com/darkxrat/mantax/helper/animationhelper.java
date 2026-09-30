package com.darkxrat.mantax.helper;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AnimationUtils;

public class AnimationHelper {

    // Fade in
    public static void fadeIn(View view, long duration) {
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        view.animate()
            .alpha(1f)
            .setDuration(duration)
            .start();
    }

    // Slide up
    public static void slideUp(View view, long duration) {
        view.setTranslationY(200f);
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        view.animate()
            .translationY(0f)
            .alpha(1f)
            .setDuration(duration)
            .start();
    }

    // Scale glow
    public static void scaleGlow(View view, long duration) {
        view.setScaleX(0.8f);
        view.setScaleY(0.8f);
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        view.animate()
            .scaleX(1f)
            .scaleY(1f)
            .alpha(1f)
            .setDuration(duration)
            .start();
    }

    // Pulse (glow bolak-balik)
    public static void pulse(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.5f, 1f);
        animator.setDuration(1500);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.start();
    }

    // Shake
    public static void shake(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX",
            0f, 25f, -25f, 25f, -25f, 15f, -15f, 6f, -6f, 0f);
        animator.setDuration(500);
        animator.start();
    }

    // Rotate
    public static void rotate(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        animator.setDuration(1000);
        animator.start();
    }
}