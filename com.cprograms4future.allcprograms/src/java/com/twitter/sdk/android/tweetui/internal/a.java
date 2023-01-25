/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  java.lang.Object
 */
package com.twitter.sdk.android.tweetui.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

class a {
    public static ViewPropertyAnimator a(final View view, int n2) {
        if (view.getVisibility() == 0) {
            view.clearAnimation();
            ViewPropertyAnimator viewPropertyAnimator = view.animate();
            viewPropertyAnimator.alpha(0.0f).setDuration((long)n2).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(4);
                    view.setAlpha(1.0f);
                }
            });
            return viewPropertyAnimator;
        }
        return null;
    }

    public static ViewPropertyAnimator b(View view, int n2) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.clearAnimation();
        ViewPropertyAnimator viewPropertyAnimator = view.animate();
        viewPropertyAnimator.alpha(1.0f).setDuration((long)n2).setListener(null);
        return viewPropertyAnimator;
    }

}

