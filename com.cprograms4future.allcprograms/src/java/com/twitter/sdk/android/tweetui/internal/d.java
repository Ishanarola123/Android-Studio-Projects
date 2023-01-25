/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 *  android.view.ViewParent
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package com.twitter.sdk.android.tweetui.internal;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.twitter.sdk.android.tweetui.internal.d;
import com.twitter.sdk.android.tweetui.internal.f;

public class d
extends ImageView
implements f.b {
    final ScaleGestureDetector a;
    final GestureDetector b;
    final Matrix c = new Matrix();
    final Matrix d = new Matrix();
    final Matrix e = new Matrix();
    final RectF f = new RectF();
    final RectF g = new RectF();
    final float[] h = new float[9];
    boolean i = false;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a = new ScaleGestureDetector(context, (ScaleGestureDetector.OnScaleGestureListener)new ScaleGestureDetector.SimpleOnScaleGestureListener(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                this.a.a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                this.a.e();
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                if (this.a.getScale() < 1.0f) {
                    this.a.c();
                    this.a.e();
                }
            }
        });
        this.b = new GestureDetector(context, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (this.a.getScale() > 1.0f) {
                    this.a.a(this.a.getScale(), 1.0f, motionEvent.getX(), motionEvent.getY());
                } else {
                    this.a.a(this.a.getScale(), 2.0f, motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                this.a.a(-f2, -f3);
                this.a.e();
                if (this.a.i && !this.a.a.isInProgress()) {
                    this.a.a(false);
                }
                return true;
            }
        });
    }

    RectF a(Matrix matrix) {
        Drawable drawable = this.getDrawable();
        if (drawable != null) {
            this.g.set(0.0f, 0.0f, (float)drawable.getIntrinsicWidth(), (float)drawable.getIntrinsicHeight());
            matrix.mapRect(this.g);
        }
        return this.g;
    }

    void a(float f2, float f3) {
        this.e.postTranslate(f2, f3);
    }

    void a(float f2, float f3, float f4) {
        this.e.postScale(f2, f2, f3, f4);
    }

    void a(float f2, float f3, float f4, float f5) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{f2, f3});
        valueAnimator.setDuration(300L);
        valueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, f4, f5){
            final /* synthetic */ float a;
            final /* synthetic */ float b;
            final /* synthetic */ d c;
            {
                this.c = d2;
                this.a = f2;
                this.b = f3;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2 = ((java.lang.Float)valueAnimator.getAnimatedValue()).floatValue() / this.c.getScale();
                this.c.a(f2, this.a, this.b);
                this.c.e();
            }
        });
        valueAnimator.start();
    }

    void a(Drawable drawable) {
        int n2 = drawable.getIntrinsicWidth();
        int n3 = drawable.getIntrinsicHeight();
        RectF rectF = new RectF(0.0f, 0.0f, (float)n2, (float)n3);
        this.d.reset();
        this.d.setRectToRect(rectF, this.f, Matrix.ScaleToFit.CENTER);
    }

    void a(boolean bl) {
        ViewParent viewParent = this.getParent();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(bl);
        }
    }

    boolean a() {
        Drawable drawable = this.getDrawable();
        return drawable != null && drawable.getIntrinsicWidth() > 0;
    }

    void b() {
        this.f.set((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getWidth() - this.getPaddingRight()), (float)(this.getHeight() - this.getPaddingBottom()));
    }

    void c() {
        this.e.reset();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void d() {
        block9 : {
            block8 : {
                var1_1 = this.a(this.getDrawMatrix());
                var2_2 = var1_1.height();
                var3_3 = this.f.height();
                var4_4 = 0.0f;
                if (!(var2_2 <= var3_3)) break block8;
                var8_5 = (this.f.height() - var1_1.height()) / 2.0f;
                var9_6 = var1_1.top;
                ** GOTO lbl16
            }
            if (var1_1.top > 0.0f) {
                var5_7 = -var1_1.top;
            } else if (var1_1.bottom < this.f.height()) {
                var8_5 = this.f.height();
                var9_6 = var1_1.bottom;
lbl16: // 2 sources:
                var5_7 = var8_5 - var9_6;
            } else {
                var5_7 = 0.0f;
            }
            if (!(var1_1.width() <= this.f.width())) break block9;
            this.i = true;
            var6_8 = (this.f.width() - var1_1.width()) / 2.0f;
            var7_9 = var1_1.left;
            ** GOTO lbl33
        }
        if (var1_1.left > 0.0f) {
            this.i = true;
            var4_4 = -var1_1.left;
        } else if (var1_1.right < this.f.width()) {
            this.i = true;
            var6_8 = this.f.width();
            var7_9 = var1_1.right;
lbl33: // 2 sources:
            var4_4 = var6_8 - var7_9;
        } else {
            this.i = false;
        }
        this.a(var4_4, var5_7);
    }

    void e() {
        this.d();
        this.setScaleType(ImageView.ScaleType.MATRIX);
        this.setImageMatrix(this.getDrawMatrix());
    }

    @Override
    public boolean f() {
        return this.getScale() == 1.0f;
    }

    Matrix getDrawMatrix() {
        this.c.set(this.d);
        this.c.postConcat(this.e);
        return this.c;
    }

    float getScale() {
        this.e.getValues(this.h);
        return this.h[0];
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        if (this.a()) {
            this.b();
            this.a(this.getDrawable());
            this.e();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.a()) {
            return false;
        }
        boolean bl = true;
        this.a(bl);
        boolean bl2 = this.a.onTouchEvent(motionEvent);
        boolean bl3 = this.b.onTouchEvent(motionEvent) || bl2;
        if (!bl3) {
            if (super.onTouchEvent(motionEvent)) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }
}

