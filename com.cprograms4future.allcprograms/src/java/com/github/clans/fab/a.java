/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.graphics.drawable.shapes.RoundRectShape
 *  android.graphics.drawable.shapes.Shape
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewOutlineProvider
 *  android.view.animation.Animation
 *  android.widget.TextView
 *  java.lang.Math
 */
package com.github.clans.fab;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.widget.TextView;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.c;

public class a
extends TextView {
    private static final Xfermode b = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    GestureDetector a = new GestureDetector(this.getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(){

        public boolean onDown(MotionEvent motionEvent) {
            a.this.d();
            if (a.this.o != null) {
                a.this.o.f();
            }
            return super.onDown(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            a.this.e();
            if (a.this.o != null) {
                a.this.o.g();
            }
            return super.onSingleTapUp(motionEvent);
        }
    });
    private int c;
    private int d;
    private int e;
    private int f;
    private Drawable g;
    private boolean h = true;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private FloatingActionButton o;
    private Animation p;
    private Animation q;
    private boolean r;
    private boolean s = true;

    public a(Context context) {
        super(context);
    }

    private Drawable a(int n2) {
        float[] arrf = new float[]{this.n, this.n, this.n, this.n, this.n, this.n, this.n, this.n};
        ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RoundRectShape(arrf, null, null));
        shapeDrawable.getPaint().setColor(n2);
        return shapeDrawable;
    }

    private int h() {
        if (this.i == 0) {
            this.i = this.getMeasuredWidth();
        }
        return this.getMeasuredWidth() + this.a();
    }

    private int i() {
        if (this.j == 0) {
            this.j = this.getMeasuredHeight();
        }
        return this.getMeasuredHeight() + this.b();
    }

    @TargetApi(value=21)
    private Drawable j() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, this.a(this.l));
        stateListDrawable.addState(new int[0], this.a(this.k));
        if (c.b()) {
            int[][] arrarrn = new int[][]{new int[0]};
            int[] arrn = new int[]{this.m};
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList((int[][])arrarrn, arrn), (Drawable)stateListDrawable, null);
            this.setOutlineProvider(new ViewOutlineProvider(){

                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
            this.setClipToOutline(true);
            this.g = rippleDrawable;
            return rippleDrawable;
        }
        this.g = stateListDrawable;
        return stateListDrawable;
    }

    private void k() {
        if (this.p != null) {
            this.q.cancel();
            this.startAnimation(this.p);
        }
    }

    private void l() {
        if (this.q != null) {
            this.p.cancel();
            this.startAnimation(this.q);
        }
    }

    @TargetApi(value=21)
    private void setBackgroundCompat(Drawable drawable) {
        if (c.a()) {
            this.setBackground(drawable);
            return;
        }
        this.setBackgroundDrawable(drawable);
    }

    private void setShadow(FloatingActionButton floatingActionButton) {
        this.f = floatingActionButton.getShadowColor();
        this.c = floatingActionButton.getShadowRadius();
        this.d = floatingActionButton.getShadowXOffset();
        this.e = floatingActionButton.getShadowYOffset();
        this.h = floatingActionButton.h();
    }

    int a() {
        if (this.h) {
            return this.c + Math.abs((int)this.d);
        }
        return 0;
    }

    void a(int n2, int n3, int n4) {
        this.k = n2;
        this.l = n3;
        this.m = n4;
    }

    void a(boolean bl) {
        if (bl) {
            this.k();
        }
        this.setVisibility(0);
    }

    int b() {
        if (this.h) {
            return this.c + Math.abs((int)this.e);
        }
        return 0;
    }

    void b(boolean bl) {
        if (bl) {
            this.l();
        }
        this.setVisibility(4);
    }

    void c() {
        LayerDrawable layerDrawable;
        if (this.h) {
            Drawable[] arrdrawable = new Drawable[]{new a(), this.j()};
            layerDrawable = new LayerDrawable(arrdrawable);
            int n2 = this.c + Math.abs((int)this.d);
            int n3 = this.c + Math.abs((int)this.e);
            int n4 = this.c + Math.abs((int)this.d);
            int n5 = this.c + Math.abs((int)this.e);
            layerDrawable.setLayerInset(1, n2, n3, n4, n5);
        } else {
            Drawable[] arrdrawable = new Drawable[]{this.j()};
            layerDrawable = new LayerDrawable(arrdrawable);
        }
        this.setBackgroundCompat((Drawable)layerDrawable);
    }

    @TargetApi(value=21)
    void d() {
        if (this.r) {
            this.g = this.getBackground();
        }
        if (this.g instanceof StateListDrawable) {
            ((StateListDrawable)this.g).setState(new int[]{16842919});
        } else if (c.b() && this.g instanceof RippleDrawable) {
            RippleDrawable rippleDrawable = (RippleDrawable)this.g;
            rippleDrawable.setState(new int[]{16842910, 16842919});
            rippleDrawable.setHotspot((float)(this.getMeasuredWidth() / 2), (float)(this.getMeasuredHeight() / 2));
            rippleDrawable.setVisible(true, true);
        }
        this.setPressed(true);
    }

    @TargetApi(value=21)
    void e() {
        if (this.r) {
            this.g = this.getBackground();
        }
        if (this.g instanceof StateListDrawable) {
            ((StateListDrawable)this.g).setState(new int[0]);
        } else if (c.b() && this.g instanceof RippleDrawable) {
            RippleDrawable rippleDrawable = (RippleDrawable)this.g;
            rippleDrawable.setState(new int[0]);
            rippleDrawable.setHotspot((float)(this.getMeasuredWidth() / 2), (float)(this.getMeasuredHeight() / 2));
            rippleDrawable.setVisible(true, true);
        }
        this.setPressed(false);
    }

    boolean f() {
        return this.s;
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        this.setMeasuredDimension(this.h(), this.i());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.o != null && this.o.getOnClickListener() != null && this.o.isEnabled()) {
            int n2 = motionEvent.getAction();
            if (n2 == 1 || n2 == 3) {
                this.e();
                this.o.g();
            }
            this.a.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    void setCornerRadius(int n2) {
        this.n = n2;
    }

    void setFab(FloatingActionButton floatingActionButton) {
        this.o = floatingActionButton;
        this.setShadow(floatingActionButton);
    }

    void setHandleVisibilityChanges(boolean bl) {
        this.s = bl;
    }

    void setHideAnimation(Animation animation) {
        this.q = animation;
    }

    void setShowAnimation(Animation animation) {
        this.p = animation;
    }

    void setShowShadow(boolean bl) {
        this.h = bl;
    }

    void setUsingStyle(boolean bl) {
        this.r = bl;
    }

    private class a
    extends Drawable {
        private Paint b = new Paint(1);
        private Paint c = new Paint(1);

        private a() {
            this.a();
        }

        private void a() {
            a.this.setLayerType(1, null);
            this.b.setStyle(Paint.Style.FILL);
            this.b.setColor(a.this.k);
            this.c.setXfermode(b);
            if (!a.this.isInEditMode()) {
                this.b.setShadowLayer((float)a.this.c, (float)a.this.d, (float)a.this.e, a.this.f);
            }
        }

        public void draw(Canvas canvas) {
            RectF rectF = new RectF((float)(a.this.c + Math.abs((int)a.this.d)), (float)(a.this.c + Math.abs((int)a.this.e)), (float)a.this.i, (float)a.this.j);
            canvas.drawRoundRect(rectF, (float)a.this.n, (float)a.this.n, this.b);
            canvas.drawRoundRect(rectF, (float)a.this.n, (float)a.this.n, this.c);
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int n2) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

}

