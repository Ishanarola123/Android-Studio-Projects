/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.Property
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewConfiguration
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 */
package com.twitter.sdk.android.tweetui.internal;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class f
implements View.OnTouchListener {
    private int a;
    private float b;
    private final float c;
    private final float d;
    private a e;
    private float f;
    private float g;
    private int h;
    private boolean i;

    f(a a2, int n2, float f2) {
        this(a2, n2, f2, 0.2f * f2);
    }

    f(a a2, int n2, float f2, float f3) {
        this.a(a2);
        this.a = n2;
        this.c = f2;
        this.d = f3;
    }

    public static f a(View view, a a2) {
        return new f(a2, ViewConfiguration.get((Context)view.getContext()).getScaledTouchSlop(), 0.5f * (float)view.getContext().getResources().getDisplayMetrics().heightPixels);
    }

    void a(View view, float f2) {
        float f3 = view.getTranslationY();
        double d2 = f2;
        double d3 = this.b(f3);
        Double.isNaN((double)d2);
        float f4 = this.c(f3 + (float)(d2 * d3));
        view.setTranslationY(f4);
        if (this.e != null) {
            this.e.a(f4);
        }
    }

    public void a(a a2) {
        this.e = a2;
    }

    boolean a() {
        return this.i;
    }

    boolean a(float f2) {
        return Math.abs((float)f2) > (float)this.a;
    }

    boolean a(float f2, float f3) {
        return Math.abs((float)f3) > Math.abs((float)f2);
    }

    boolean a(MotionEvent motionEvent) {
        return this.h >= 0 && motionEvent.getPointerCount() == 1;
    }

    boolean a(View view) {
        float f2 = view.getTranslationY();
        if (!(f2 > this.d) && !(f2 < -this.d)) {
            this.b(view);
            return false;
        }
        if (this.e != null) {
            this.e.a();
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    boolean a(View view, MotionEvent motionEvent) {
        int n2;
        int n3 = motionEvent.getActionMasked();
        if (n3 != 5) {
            float f2;
            switch (n3) {
                default: {
                    return false;
                }
                case 2: {
                    float f3 = motionEvent.getRawX();
                    float f4 = motionEvent.getRawY();
                    float f5 = f4 - this.b;
                    float f6 = f3 - this.f;
                    float f7 = f4 - this.g;
                    this.f = f3;
                    this.g = f4;
                    if (!this.a(motionEvent)) return false;
                    if (!this.i) {
                        if (!this.a(f5)) return false;
                        if (!this.a(f6, f7)) return false;
                    }
                    this.i = true;
                    this.a(view, f7);
                    return false;
                }
                case 1: 
                case 3: {
                    boolean bl = this.a(motionEvent) && this.i ? this.a(view) : false;
                    this.i = false;
                    return bl;
                }
                case 0: 
            }
            this.f = motionEvent.getRawX();
            this.g = f2 = motionEvent.getRawY();
            this.b = f2;
            this.i = false;
            n2 = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
        } else {
            this.b(view);
            this.i = false;
            n2 = -1;
        }
        this.h = n2;
        return false;
    }

    double b(float f2) {
        float f3 = Math.abs((float)f2);
        float f4 = 2.0f * this.d;
        return 1.0 - Math.pow((double)f3, (double)2.0) / Math.pow((double)f4, (double)2.0);
    }

    void b(View view) {
        if (view.getTranslationY() != 0.0f) {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)view, (Property)View.TRANSLATION_Y, (float[])new float[]{0.0f}).setDuration(100L);
            objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                    if (f.this.e != null) {
                        f.this.e.a(f2);
                    }
                }
            });
            objectAnimator.start();
        }
    }

    float c(float f2) {
        if (f2 < -this.c) {
            return -this.c;
        }
        if (f2 > this.c) {
            f2 = this.c;
        }
        return f2;
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean bl;
        block4 : {
            block3 : {
                boolean bl2 = view instanceof b && !((b)view).f() && !this.a() ? false : this.a(view, motionEvent);
                if (bl2) break block3;
                boolean bl3 = view.onTouchEvent(motionEvent);
                bl = false;
                if (!bl3) break block4;
            }
            bl = true;
        }
        return bl;
    }

    public static interface a {
        public void a();

        public void a(float var1);
    }

    public static interface b {
        public boolean f();
    }

}

