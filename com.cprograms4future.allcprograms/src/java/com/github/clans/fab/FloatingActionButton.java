/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
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
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.graphics.drawable.shapes.OvalShape
 *  android.graphics.drawable.shapes.Shape
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.SystemClock
 *  android.util.AttributeSet
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewOutlineProvider
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.ImageButton
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.clans.fab;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.github.clans.fab.b;

public class FloatingActionButton
extends ImageButton {
    private static final Xfermode h = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private float A = -1.0f;
    private float B = -1.0f;
    private boolean C;
    private RectF D = new RectF();
    private Paint E = new Paint(1);
    private Paint F = new Paint(1);
    private boolean G;
    private long H;
    private float I = 195.0f;
    private long J = 0L;
    private double K;
    private boolean L = true;
    private int M = 16;
    private float N;
    private float O;
    private float P;
    private int Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U = 100;
    private boolean V;
    int a;
    boolean b;
    int c;
    int d = com.github.clans.fab.c.a(this.getContext(), 4.0f);
    int e = com.github.clans.fab.c.a(this.getContext(), 1.0f);
    int f = com.github.clans.fab.c.a(this.getContext(), 3.0f);
    GestureDetector g = new GestureDetector(this.getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(){

        public boolean onDown(MotionEvent motionEvent) {
            com.github.clans.fab.a a2 = (com.github.clans.fab.a)((Object)FloatingActionButton.this.getTag(b.d.fab_label));
            if (a2 != null) {
                a2.d();
            }
            FloatingActionButton.this.f();
            return super.onDown(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            com.github.clans.fab.a a2 = (com.github.clans.fab.a)((Object)FloatingActionButton.this.getTag(b.d.fab_label));
            if (a2 != null) {
                a2.e();
            }
            FloatingActionButton.this.g();
            return super.onSingleTapUp(motionEvent);
        }
    });
    private int i;
    private int j;
    private int k;
    private int l;
    private Drawable m;
    private int n = com.github.clans.fab.c.a(this.getContext(), 24.0f);
    private Animation o;
    private Animation p;
    private String q;
    private View.OnClickListener r;
    private Drawable s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w = com.github.clans.fab.c.a(this.getContext(), 6.0f);
    private int x;
    private int y;
    private boolean z;

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a(context, attributeSet, n2);
    }

    @TargetApi(value=21)
    public FloatingActionButton(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        this.a(context, attributeSet, n2);
    }

    private Drawable a(int n2) {
        a a2 = new a((Shape)new OvalShape());
        a2.getPaint().setColor(n2);
        return a2;
    }

    private void a(long l2) {
        if (this.J >= 200L) {
            double d2 = this.K;
            double d3 = l2;
            Double.isNaN((double)d3);
            this.K = d2 + d3;
            if (this.K > 500.0) {
                this.K -= 500.0;
                this.J = 0L;
                this.L = true ^ this.L;
            }
            float f2 = 0.5f + (float)Math.cos((double)(3.141592653589793 * (1.0 + this.K / 500.0))) / 2.0f;
            float f3 = 270 - this.M;
            if (this.L) {
                this.N = f2 * f3;
                return;
            }
            float f4 = f3 * (1.0f - f2);
            this.O += this.N - f4;
            this.N = f4;
            return;
        }
        this.J = l2 + this.J;
    }

    private void a(Context context, AttributeSet attributeSet, int n2) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, b.e.FloatingActionButton, n2, 0);
        this.i = typedArray.getColor(b.e.FloatingActionButton_fab_colorNormal, -2473162);
        this.j = typedArray.getColor(b.e.FloatingActionButton_fab_colorPressed, -1617853);
        this.k = typedArray.getColor(b.e.FloatingActionButton_fab_colorDisabled, -5592406);
        this.l = typedArray.getColor(b.e.FloatingActionButton_fab_colorRipple, -1711276033);
        this.b = typedArray.getBoolean(b.e.FloatingActionButton_fab_showShadow, true);
        this.c = typedArray.getColor(b.e.FloatingActionButton_fab_shadowColor, 1711276032);
        this.d = typedArray.getDimensionPixelSize(b.e.FloatingActionButton_fab_shadowRadius, this.d);
        this.e = typedArray.getDimensionPixelSize(b.e.FloatingActionButton_fab_shadowXOffset, this.e);
        this.f = typedArray.getDimensionPixelSize(b.e.FloatingActionButton_fab_shadowYOffset, this.f);
        this.a = typedArray.getInt(b.e.FloatingActionButton_fab_size, 0);
        this.q = typedArray.getString(b.e.FloatingActionButton_fab_label);
        this.S = typedArray.getBoolean(b.e.FloatingActionButton_fab_progress_indeterminate, false);
        this.x = typedArray.getColor(b.e.FloatingActionButton_fab_progress_color, -16738680);
        this.y = typedArray.getColor(b.e.FloatingActionButton_fab_progress_backgroundColor, 1291845632);
        this.U = typedArray.getInt(b.e.FloatingActionButton_fab_progress_max, this.U);
        this.V = typedArray.getBoolean(b.e.FloatingActionButton_fab_progress_showBackground, true);
        if (typedArray.hasValue(b.e.FloatingActionButton_fab_progress)) {
            this.Q = typedArray.getInt(b.e.FloatingActionButton_fab_progress, 0);
            this.T = true;
        }
        if (typedArray.hasValue(b.e.FloatingActionButton_fab_elevationCompat)) {
            float f2 = typedArray.getDimensionPixelOffset(b.e.FloatingActionButton_fab_elevationCompat, 0);
            if (this.isInEditMode()) {
                this.setElevation(f2);
            } else {
                this.setElevationCompat(f2);
            }
        }
        this.a(typedArray);
        this.b(typedArray);
        typedArray.recycle();
        if (this.isInEditMode()) {
            if (this.S) {
                this.setIndeterminate(true);
            } else if (this.T) {
                this.p();
                this.a(this.Q, false);
            }
        }
        this.setClickable(true);
    }

    private void a(TypedArray typedArray) {
        int n2 = typedArray.getResourceId(b.e.FloatingActionButton_fab_showAnimation, b.a.fab_scale_up);
        this.o = AnimationUtils.loadAnimation((Context)this.getContext(), (int)n2);
    }

    private void b(TypedArray typedArray) {
        int n2 = typedArray.getResourceId(b.e.FloatingActionButton_fab_hideAnimation, b.a.fab_scale_down);
        this.p = AnimationUtils.loadAnimation((Context)this.getContext(), (int)n2);
    }

    private int getCircleSize() {
        Resources resources = this.getResources();
        int n2 = this.a == 0 ? b.b.fab_size_normal : b.b.fab_size_mini;
        return resources.getDimensionPixelSize(n2);
    }

    private int getShadowX() {
        return this.d + Math.abs((int)this.e);
    }

    private int getShadowY() {
        return this.d + Math.abs((int)this.f);
    }

    private int k() {
        int n2 = this.getCircleSize() + this.a();
        if (this.v) {
            n2 += 2 * this.w;
        }
        return n2;
    }

    private int l() {
        int n2 = this.getCircleSize() + this.b();
        if (this.v) {
            n2 += 2 * this.w;
        }
        return n2;
    }

    private float m() {
        return this.getMeasuredWidth() / 2;
    }

    private float n() {
        return this.getMeasuredHeight() / 2;
    }

    @TargetApi(value=21)
    private Drawable o() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, this.a(this.k));
        stateListDrawable.addState(new int[]{16842919}, this.a(this.j));
        stateListDrawable.addState(new int[0], this.a(this.i));
        if (com.github.clans.fab.c.b()) {
            int[][] arrarrn = new int[][]{new int[0]};
            int[] arrn = new int[]{this.l};
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList((int[][])arrarrn, arrn), (Drawable)stateListDrawable, null);
            this.setOutlineProvider(new ViewOutlineProvider(){

                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
            this.setClipToOutline(true);
            this.s = rippleDrawable;
            return rippleDrawable;
        }
        this.s = stateListDrawable;
        return stateListDrawable;
    }

    private void p() {
        if (!this.C) {
            if (this.A == -1.0f) {
                this.A = this.getX();
            }
            if (this.B == -1.0f) {
                this.B = this.getY();
            }
            this.C = true;
        }
    }

    private void q() {
        float f2;
        float f3;
        if (this.v) {
            f2 = this.A > this.getX() ? this.getX() + (float)this.w : this.getX() - (float)this.w;
            f3 = this.B > this.getY() ? this.getY() + (float)this.w : this.getY() - (float)this.w;
        } else {
            f2 = this.A;
            f3 = this.B;
        }
        this.setX(f2);
        this.setY(f3);
    }

    private void r() {
        this.E.setColor(this.y);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth((float)this.w);
        this.F.setColor(this.x);
        this.F.setStyle(Paint.Style.STROKE);
        this.F.setStrokeWidth((float)this.w);
    }

    private void s() {
        int n2 = this.h() ? this.getShadowX() : 0;
        boolean bl = this.h();
        int n3 = 0;
        if (bl) {
            n3 = this.getShadowY();
        }
        this.D = new RectF((float)(n2 + this.w / 2), (float)(n3 + this.w / 2), (float)(this.k() - n2 - this.w / 2), (float)(this.l() - n3 - this.w / 2));
    }

    @TargetApi(value=16)
    private void setBackgroundCompat(Drawable drawable) {
        if (com.github.clans.fab.c.a()) {
            this.setBackground(drawable);
            return;
        }
        this.setBackgroundDrawable(drawable);
    }

    int a() {
        if (this.h()) {
            return 2 * this.getShadowX();
        }
        return 0;
    }

    void a(int n2, int n3, int n4) {
        this.i = n2;
        this.j = n3;
        this.l = n4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n2, boolean bl) {
        FloatingActionButton floatingActionButton = this;
        synchronized (floatingActionButton) {
            boolean bl2 = this.G;
            if (bl2) {
                return;
            }
            this.Q = n2;
            this.R = bl;
            if (!this.C) {
                this.T = true;
                return;
            }
            this.v = true;
            this.z = true;
            this.s();
            this.p();
            this.c();
            if (n2 < 0) {
                n2 = 0;
            } else if (n2 > this.U) {
                n2 = this.U;
            }
            float f2 = n2;
            float f3 = this.P;
            if (f2 == f3) {
                return;
            }
            float f4 = this.U > 0 ? 360.0f * (f2 / (float)this.U) : 0.0f;
            this.P = f4;
            this.H = SystemClock.uptimeMillis();
            if (!bl) {
                this.O = this.P;
            }
            this.invalidate();
            return;
        }
    }

    public void a(boolean bl) {
        if (this.i()) {
            if (bl) {
                this.d();
            }
            super.setVisibility(0);
        }
    }

    int b() {
        if (this.h()) {
            return 2 * this.getShadowY();
        }
        return 0;
    }

    public void b(boolean bl) {
        if (!this.i()) {
            if (bl) {
                this.e();
            }
            super.setVisibility(4);
        }
    }

    void c() {
        LayerDrawable layerDrawable;
        if (this.h()) {
            Drawable[] arrdrawable = new Drawable[]{new c(), this.o(), this.getIconDrawable()};
            layerDrawable = new LayerDrawable(arrdrawable);
        } else {
            Drawable[] arrdrawable = new Drawable[]{this.o(), this.getIconDrawable()};
            layerDrawable = new LayerDrawable(arrdrawable);
        }
        int n2 = -1;
        if (this.getIconDrawable() != null) {
            n2 = Math.max((int)this.getIconDrawable().getIntrinsicWidth(), (int)this.getIconDrawable().getIntrinsicHeight());
        }
        int n3 = this.getCircleSize();
        if (n2 <= 0) {
            n2 = this.n;
        }
        int n4 = (n3 - n2) / 2;
        int n5 = this.h() ? this.d + Math.abs((int)this.e) : 0;
        boolean bl = this.h();
        int n6 = 0;
        if (bl) {
            n6 = this.d + Math.abs((int)this.f);
        }
        if (this.v) {
            n5 += this.w;
            n6 += this.w;
        }
        int n7 = this.h() ? 2 : 1;
        int n8 = n5 + n4;
        int n9 = n6 + n4;
        layerDrawable.setLayerInset(n7, n8, n9, n8, n9);
        this.setBackgroundCompat((Drawable)layerDrawable);
    }

    void d() {
        this.p.cancel();
        this.startAnimation(this.o);
    }

    void e() {
        this.o.cancel();
        this.startAnimation(this.p);
    }

    @TargetApi(value=21)
    void f() {
        if (this.s instanceof StateListDrawable) {
            ((StateListDrawable)this.s).setState(new int[]{16842910, 16842919});
            return;
        }
        if (com.github.clans.fab.c.b()) {
            RippleDrawable rippleDrawable = (RippleDrawable)this.s;
            rippleDrawable.setState(new int[]{16842910, 16842919});
            rippleDrawable.setHotspot(this.m(), this.n());
            rippleDrawable.setVisible(true, true);
        }
    }

    @TargetApi(value=21)
    void g() {
        if (this.s instanceof StateListDrawable) {
            ((StateListDrawable)this.s).setState(new int[]{16842910});
            return;
        }
        if (com.github.clans.fab.c.b()) {
            RippleDrawable rippleDrawable = (RippleDrawable)this.s;
            rippleDrawable.setState(new int[]{16842910});
            rippleDrawable.setHotspot(this.m(), this.n());
            rippleDrawable.setVisible(true, true);
        }
    }

    public int getButtonSize() {
        return this.a;
    }

    public int getColorDisabled() {
        return this.k;
    }

    public int getColorNormal() {
        return this.i;
    }

    public int getColorPressed() {
        return this.j;
    }

    public int getColorRipple() {
        return this.l;
    }

    Animation getHideAnimation() {
        return this.p;
    }

    protected Drawable getIconDrawable() {
        if (this.m != null) {
            return this.m;
        }
        return new ColorDrawable(0);
    }

    public String getLabelText() {
        return this.q;
    }

    com.github.clans.fab.a getLabelView() {
        return (com.github.clans.fab.a)((Object)this.getTag(b.d.fab_label));
    }

    public int getLabelVisibility() {
        com.github.clans.fab.a a2 = this.getLabelView();
        if (a2 != null) {
            return a2.getVisibility();
        }
        return -1;
    }

    public int getMax() {
        FloatingActionButton floatingActionButton = this;
        synchronized (floatingActionButton) {
            int n2 = this.U;
            return n2;
        }
    }

    View.OnClickListener getOnClickListener() {
        return this.r;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int getProgress() {
        FloatingActionButton floatingActionButton = this;
        synchronized (floatingActionButton) {
            block4 : {
                if (!this.G) break block4;
                return 0;
            }
            return this.Q;
        }
    }

    public int getShadowColor() {
        return this.c;
    }

    public int getShadowRadius() {
        return this.d;
    }

    public int getShadowXOffset() {
        return this.e;
    }

    public int getShadowYOffset() {
        return this.f;
    }

    Animation getShowAnimation() {
        return this.o;
    }

    public boolean h() {
        return !this.t && this.b;
    }

    public boolean i() {
        return this.getVisibility() == 4;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.v) {
            RectF rectF;
            float f2;
            float f3;
            if (this.V) {
                canvas.drawArc(this.D, 360.0f, 360.0f, false, this.E);
            }
            boolean bl = this.G;
            boolean bl2 = true;
            if (bl) {
                long l2 = SystemClock.uptimeMillis() - this.H;
                float f4 = (float)l2 * this.I / 1000.0f;
                this.a(l2);
                this.O = f4 + this.O;
                if (this.O > 360.0f) {
                    this.O -= 360.0f;
                }
                this.H = SystemClock.uptimeMillis();
                float f5 = this.O - 90.0f;
                float f6 = (float)this.M + this.N;
                if (this.isInEditMode()) {
                    f3 = 135.0f;
                    f2 = 0.0f;
                } else {
                    f2 = f5;
                    f3 = f6;
                }
                rectF = this.D;
            } else {
                if (this.O != this.P) {
                    float f7 = (float)(SystemClock.uptimeMillis() - this.H) / 1000.0f * this.I;
                    float f8 = this.O > this.P ? Math.max((float)(this.O - f7), (float)this.P) : Math.min((float)(f7 + this.O), (float)this.P);
                    this.O = f8;
                    this.H = SystemClock.uptimeMillis();
                } else {
                    bl2 = false;
                }
                rectF = this.D;
                f2 = -90.0f;
                f3 = this.O;
            }
            canvas.drawArc(rectF, f2, f3, false, this.F);
            if (bl2) {
                this.invalidate();
            }
        }
    }

    protected void onMeasure(int n2, int n3) {
        this.setMeasuredDimension(this.k(), this.l());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b b2 = (b)parcelable;
        super.onRestoreInstanceState(b2.getSuperState());
        this.O = b2.a;
        this.P = b2.b;
        this.I = b2.c;
        this.w = b2.e;
        this.x = b2.f;
        this.y = b2.g;
        this.S = b2.k;
        this.T = b2.l;
        this.Q = b2.d;
        this.R = b2.m;
        this.V = b2.n;
        this.H = SystemClock.uptimeMillis();
    }

    public Parcelable onSaveInstanceState() {
        b b2 = new b(super.onSaveInstanceState());
        b2.a = this.O;
        b2.b = this.P;
        b2.c = this.I;
        b2.e = this.w;
        b2.f = this.x;
        b2.g = this.y;
        b2.k = this.G;
        boolean bl = this.v && this.Q > 0 && !this.G;
        b2.l = bl;
        b2.d = this.Q;
        b2.m = this.R;
        b2.n = this.V;
        return b2;
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        this.p();
        if (this.S) {
            this.setIndeterminate(true);
            this.S = false;
        } else if (this.T) {
            this.a(this.Q, this.R);
            this.T = false;
        } else if (this.z) {
            this.q();
            this.z = false;
        }
        super.onSizeChanged(n2, n3, n4, n5);
        this.s();
        this.r();
        this.c();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        block4 : {
            block6 : {
                block7 : {
                    com.github.clans.fab.a a2;
                    block8 : {
                        block5 : {
                            if (this.r == null || !this.isEnabled()) break block4;
                            a2 = (com.github.clans.fab.a)((Object)this.getTag(b.d.fab_label));
                            if (a2 == null) {
                                return super.onTouchEvent(motionEvent);
                            }
                            int n2 = motionEvent.getAction();
                            if (n2 == 1) break block5;
                            if (n2 != 3) break block6;
                            if (a2 == null) break block7;
                            break block8;
                        }
                        if (a2 == null) break block7;
                    }
                    a2.e();
                }
                this.g();
            }
            this.g.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setButtonSize(int n2) {
        if (n2 != 0 && n2 != 1) {
            throw new IllegalArgumentException("Use @FabSize constants only!");
        }
        if (this.a != n2) {
            this.a = n2;
            this.c();
        }
    }

    public void setColorDisabled(int n2) {
        if (n2 != this.k) {
            this.k = n2;
            this.c();
        }
    }

    public void setColorDisabledResId(int n2) {
        this.setColorDisabled(this.getResources().getColor(n2));
    }

    public void setColorNormal(int n2) {
        if (this.i != n2) {
            this.i = n2;
            this.c();
        }
    }

    public void setColorNormalResId(int n2) {
        this.setColorNormal(this.getResources().getColor(n2));
    }

    public void setColorPressed(int n2) {
        if (n2 != this.j) {
            this.j = n2;
            this.c();
        }
    }

    public void setColorPressedResId(int n2) {
        this.setColorPressed(this.getResources().getColor(n2));
    }

    public void setColorRipple(int n2) {
        if (n2 != this.l) {
            this.l = n2;
            this.c();
        }
    }

    public void setColorRippleResId(int n2) {
        this.setColorRipple(this.getResources().getColor(n2));
    }

    public void setElevation(float f2) {
        if (com.github.clans.fab.c.b() && f2 > 0.0f) {
            super.setElevation(f2);
            if (!this.isInEditMode()) {
                this.t = true;
                this.b = false;
            }
            this.c();
        }
    }

    @TargetApi(value=21)
    public void setElevationCompat(float f2) {
        this.c = 637534208;
        float f3 = f2 / 2.0f;
        this.d = Math.round((float)f3);
        this.e = 0;
        if (this.a == 0) {
            f3 = f2;
        }
        this.f = Math.round((float)f3);
        if (com.github.clans.fab.c.b()) {
            super.setElevation(f2);
            this.u = true;
            this.b = false;
            this.c();
            ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
            if (layoutParams != null) {
                this.setLayoutParams(layoutParams);
                return;
            }
        } else {
            this.b = true;
            this.c();
        }
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        com.github.clans.fab.a a2 = (com.github.clans.fab.a)((Object)this.getTag(b.d.fab_label));
        if (a2 != null) {
            a2.setEnabled(bl);
        }
    }

    public void setHideAnimation(Animation animation) {
        this.p = animation;
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.m != drawable) {
            this.m = drawable;
            this.c();
        }
    }

    public void setImageResource(int n2) {
        Drawable drawable = this.getResources().getDrawable(n2);
        if (this.m != drawable) {
            this.m = drawable;
            this.c();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void setIndeterminate(boolean var1_1) {
        var3_2 = this;
        // MONITORENTER : var3_2
        if (var1_1) ** GOTO lbl6
        this.O = 0.0f;
lbl6: // 2 sources:
        this.v = var1_1;
        this.z = true;
        this.G = var1_1;
        this.H = SystemClock.uptimeMillis();
        this.s();
        this.p();
        this.c();
        // MONITOREXIT : var3_2
        return;
    }

    public void setLabelText(String string) {
        this.q = string;
        com.github.clans.fab.a a2 = this.getLabelView();
        if (a2 != null) {
            a2.setText((CharSequence)string);
        }
    }

    public void setLabelVisibility(int n2) {
        com.github.clans.fab.a a2 = this.getLabelView();
        if (a2 != null) {
            a2.setVisibility(n2);
            boolean bl = n2 == 0;
            a2.setHandleVisibilityChanges(bl);
        }
    }

    @TargetApi(value=21)
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams && this.u) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            marginLayoutParams.leftMargin += this.getShadowX();
            marginLayoutParams.topMargin += this.getShadowY();
            marginLayoutParams.rightMargin += this.getShadowX();
            marginLayoutParams.bottomMargin += this.getShadowY();
        }
        super.setLayoutParams(layoutParams);
    }

    public void setMax(int n2) {
        FloatingActionButton floatingActionButton = this;
        synchronized (floatingActionButton) {
            this.U = n2;
            return;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.r = onClickListener;
        View view = (View)this.getTag(b.d.fab_label);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    if (FloatingActionButton.this.r != null) {
                        FloatingActionButton.this.r.onClick((View)FloatingActionButton.this);
                    }
                }
            });
        }
    }

    public void setShadowColor(int n2) {
        if (this.c != n2) {
            this.c = n2;
            this.c();
        }
    }

    public void setShadowColorResource(int n2) {
        int n3 = this.getResources().getColor(n2);
        if (this.c != n3) {
            this.c = n3;
            this.c();
        }
    }

    public void setShadowRadius(float f2) {
        this.d = com.github.clans.fab.c.a(this.getContext(), f2);
        this.requestLayout();
        this.c();
    }

    public void setShadowRadius(int n2) {
        int n3 = this.getResources().getDimensionPixelSize(n2);
        if (this.d != n3) {
            this.d = n3;
            this.requestLayout();
            this.c();
        }
    }

    public void setShadowXOffset(float f2) {
        this.e = com.github.clans.fab.c.a(this.getContext(), f2);
        this.requestLayout();
        this.c();
    }

    public void setShadowXOffset(int n2) {
        int n3 = this.getResources().getDimensionPixelSize(n2);
        if (this.e != n3) {
            this.e = n3;
            this.requestLayout();
            this.c();
        }
    }

    public void setShadowYOffset(float f2) {
        this.f = com.github.clans.fab.c.a(this.getContext(), f2);
        this.requestLayout();
        this.c();
    }

    public void setShadowYOffset(int n2) {
        int n3 = this.getResources().getDimensionPixelSize(n2);
        if (this.f != n3) {
            this.f = n3;
            this.requestLayout();
            this.c();
        }
    }

    public void setShowAnimation(Animation animation) {
        this.o = animation;
    }

    public void setShowProgressBackground(boolean bl) {
        FloatingActionButton floatingActionButton = this;
        synchronized (floatingActionButton) {
            this.V = bl;
            return;
        }
    }

    public void setShowShadow(boolean bl) {
        if (this.b != bl) {
            this.b = bl;
            this.c();
        }
    }

    public void setVisibility(int n2) {
        super.setVisibility(n2);
        com.github.clans.fab.a a2 = (com.github.clans.fab.a)((Object)this.getTag(b.d.fab_label));
        if (a2 != null) {
            a2.setVisibility(n2);
        }
    }

    private class a
    extends ShapeDrawable {
        private int b;
        private int c;

        private a(Shape shape) {
            super(shape);
            int n2 = FloatingActionButton.this.h() ? FloatingActionButton.this.d + Math.abs((int)FloatingActionButton.this.e) : 0;
            this.b = n2;
            boolean bl = FloatingActionButton.this.h();
            int n3 = 0;
            if (bl) {
                n3 = FloatingActionButton.this.d + Math.abs((int)FloatingActionButton.this.f);
            }
            this.c = n3;
            if (FloatingActionButton.this.v) {
                this.b += FloatingActionButton.this.w;
                this.c += FloatingActionButton.this.w;
            }
        }

        public void draw(Canvas canvas) {
            this.setBounds(this.b, this.c, FloatingActionButton.this.k() - this.b, FloatingActionButton.this.l() - this.c);
            super.draw(canvas);
        }
    }

    static class b
    extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>(){

            public b a(Parcel parcel) {
                return new b(parcel);
            }

            public b[] a(int n2) {
                return new b[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        float a;
        float b;
        float c;
        int d;
        int e;
        int f;
        int g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;

        private b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            boolean bl = parcel.readInt() != 0;
            this.h = bl;
            this.c = parcel.readFloat();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            boolean bl2 = parcel.readInt() != 0;
            this.i = bl2;
            boolean bl3 = parcel.readInt() != 0;
            this.j = bl3;
            boolean bl4 = parcel.readInt() != 0;
            this.k = bl4;
            boolean bl5 = parcel.readInt() != 0;
            this.l = bl5;
            boolean bl6 = parcel.readInt() != 0;
            this.m = bl6;
            int n2 = parcel.readInt();
            boolean bl7 = false;
            if (n2 != 0) {
                bl7 = true;
            }
            this.n = bl7;
        }

        b(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeInt((int)this.h);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt((int)this.i);
            parcel.writeInt((int)this.j);
            parcel.writeInt((int)this.k);
            parcel.writeInt((int)this.l);
            parcel.writeInt((int)this.m);
            parcel.writeInt((int)this.n);
        }

    }

    private class c
    extends Drawable {
        private Paint b = new Paint(1);
        private Paint c = new Paint(1);
        private float d;

        private c() {
            this.a();
        }

        private void a() {
            FloatingActionButton.this.setLayerType(1, null);
            this.b.setStyle(Paint.Style.FILL);
            this.b.setColor(FloatingActionButton.this.i);
            this.c.setXfermode(h);
            if (!FloatingActionButton.this.isInEditMode()) {
                this.b.setShadowLayer((float)FloatingActionButton.this.d, (float)FloatingActionButton.this.e, (float)FloatingActionButton.this.f, FloatingActionButton.this.c);
            }
            this.d = FloatingActionButton.this.getCircleSize() / 2;
            if (FloatingActionButton.this.v && FloatingActionButton.this.V) {
                this.d += (float)FloatingActionButton.this.w;
            }
        }

        public void draw(Canvas canvas) {
            canvas.drawCircle(FloatingActionButton.this.m(), FloatingActionButton.this.n(), this.d, this.b);
            canvas.drawCircle(FloatingActionButton.this.m(), FloatingActionButton.this.n(), this.d, this.c);
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

