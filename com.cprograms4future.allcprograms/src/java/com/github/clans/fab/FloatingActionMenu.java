/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.AnimatorSet$Builder
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.AttributeSet
 *  android.view.ContextThemeWrapper
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.view.animation.AnticipateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.OvershootInterpolator
 *  android.widget.ImageView
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.github.clans.fab;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.b;
import com.github.clans.fab.c;

public class FloatingActionMenu
extends ViewGroup {
    private boolean A;
    private int B;
    private float C = 4.0f;
    private float D = 1.0f;
    private float E = 3.0f;
    private int F;
    private int G;
    private int H;
    private Drawable I;
    private int J;
    private Interpolator K;
    private Interpolator L;
    private boolean M = true;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S = true;
    private ImageView T;
    private Animation U;
    private Animation V;
    private boolean W;
    GestureDetector a = new GestureDetector(this.getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(){

        public boolean onDown(MotionEvent motionEvent) {
            return FloatingActionMenu.this.W && FloatingActionMenu.this.b();
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            FloatingActionMenu.this.c(FloatingActionMenu.this.M);
            return true;
        }
    });
    private int aa;
    private a ab;
    private ValueAnimator ac;
    private ValueAnimator ad;
    private int ae;
    private int af;
    private Context ag;
    private String ah;
    private boolean ai;
    private AnimatorSet b = new AnimatorSet();
    private AnimatorSet c = new AnimatorSet();
    private AnimatorSet d;
    private int e = c.a(this.getContext(), 0.0f);
    private FloatingActionButton f;
    private int g;
    private int h = c.a(this.getContext(), 0.0f);
    private int i = c.a(this.getContext(), 0.0f);
    private int j;
    private boolean k;
    private boolean l;
    private Handler m = new Handler();
    private int n;
    private int o;
    private int p = c.a(this.getContext(), 4.0f);
    private int q = c.a(this.getContext(), 8.0f);
    private int r = c.a(this.getContext(), 4.0f);
    private int s = c.a(this.getContext(), 8.0f);
    private ColorStateList t;
    private float u;
    private int v = c.a(this.getContext(), 3.0f);
    private boolean w;
    private int x;
    private int y;
    private int z;

    public FloatingActionMenu(Context context) {
        this(context, null);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a(context, attributeSet);
    }

    private void a(int n2) {
        this.p = n2;
        this.q = n2;
        this.r = n2;
        this.s = n2;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, b.e.FloatingActionMenu, 0, 0);
        this.e = typedArray.getDimensionPixelSize(b.e.FloatingActionMenu_menu_buttonSpacing, this.e);
        this.h = typedArray.getDimensionPixelSize(b.e.FloatingActionMenu_menu_labels_margin, this.h);
        this.af = typedArray.getInt(b.e.FloatingActionMenu_menu_labels_position, 0);
        int n2 = b.e.FloatingActionMenu_menu_labels_showAnimation;
        int n3 = this.af == 0 ? b.a.fab_slide_in_from_right : b.a.fab_slide_in_from_left;
        this.n = typedArray.getResourceId(n2, n3);
        int n4 = b.e.FloatingActionMenu_menu_labels_hideAnimation;
        int n5 = this.af == 0 ? b.a.fab_slide_out_to_right : b.a.fab_slide_out_to_left;
        this.o = typedArray.getResourceId(n4, n5);
        this.p = typedArray.getDimensionPixelSize(b.e.FloatingActionMenu_menu_labels_paddingTop, this.p);
        this.q = typedArray.getDimensionPixelSize(b.e.FloatingActionMenu_menu_labels_paddingRight, this.q);
        this.r = typedArray.getDimensionPixelSize(b.e.FloatingActionMenu_menu_labels_paddingBottom, this.r);
        this.s = typedArray.getDimensionPixelSize(b.e.FloatingActionMenu_menu_labels_paddingLeft, this.s);
        this.t = typedArray.getColorStateList(b.e.FloatingActionMenu_menu_labels_textColor);
        if (this.t == null) {
            this.t = ColorStateList.valueOf((int)-1);
        }
        this.u = typedArray.getDimension(b.e.FloatingActionMenu_menu_labels_textSize, this.getResources().getDimension(b.b.labels_text_size));
        this.v = typedArray.getDimensionPixelSize(b.e.FloatingActionMenu_menu_labels_cornerRadius, this.v);
        this.w = typedArray.getBoolean(b.e.FloatingActionMenu_menu_labels_showShadow, true);
        this.x = typedArray.getColor(b.e.FloatingActionMenu_menu_labels_colorNormal, -13421773);
        this.y = typedArray.getColor(b.e.FloatingActionMenu_menu_labels_colorPressed, -12303292);
        this.z = typedArray.getColor(b.e.FloatingActionMenu_menu_labels_colorRipple, 1728053247);
        this.A = typedArray.getBoolean(b.e.FloatingActionMenu_menu_showShadow, true);
        this.B = typedArray.getColor(b.e.FloatingActionMenu_menu_shadowColor, 1711276032);
        this.C = typedArray.getDimension(b.e.FloatingActionMenu_menu_shadowRadius, this.C);
        this.D = typedArray.getDimension(b.e.FloatingActionMenu_menu_shadowXOffset, this.D);
        this.E = typedArray.getDimension(b.e.FloatingActionMenu_menu_shadowYOffset, this.E);
        this.F = typedArray.getColor(b.e.FloatingActionMenu_menu_colorNormal, -2473162);
        this.G = typedArray.getColor(b.e.FloatingActionMenu_menu_colorPressed, -1617853);
        this.H = typedArray.getColor(b.e.FloatingActionMenu_menu_colorRipple, -1711276033);
        this.J = typedArray.getInt(b.e.FloatingActionMenu_menu_animationDelayPerItem, 50);
        this.I = typedArray.getDrawable(b.e.FloatingActionMenu_menu_icon);
        if (this.I == null) {
            this.I = this.getResources().getDrawable(b.c.fab_add);
        }
        this.N = typedArray.getBoolean(b.e.FloatingActionMenu_menu_labels_singleLine, false);
        this.O = typedArray.getInt(b.e.FloatingActionMenu_menu_labels_ellipsize, 0);
        this.P = typedArray.getInt(b.e.FloatingActionMenu_menu_labels_maxLines, -1);
        this.Q = typedArray.getInt(b.e.FloatingActionMenu_menu_fab_size, 0);
        this.R = typedArray.getResourceId(b.e.FloatingActionMenu_menu_labels_style, 0);
        this.aa = typedArray.getInt(b.e.FloatingActionMenu_menu_openDirection, 0);
        this.ae = typedArray.getColor(b.e.FloatingActionMenu_menu_backgroundColor, 0);
        if (typedArray.hasValue(b.e.FloatingActionMenu_menu_fab_label)) {
            this.ai = true;
            this.ah = typedArray.getString(b.e.FloatingActionMenu_menu_fab_label);
        }
        if (typedArray.hasValue(b.e.FloatingActionMenu_menu_labels_padding)) {
            this.a(typedArray.getDimensionPixelSize(b.e.FloatingActionMenu_menu_labels_padding, 0));
        }
        this.K = new OvershootInterpolator();
        this.L = new AnticipateInterpolator();
        this.ag = new ContextThemeWrapper(this.getContext(), this.R);
        this.c();
        this.e();
        this.a(typedArray);
        typedArray.recycle();
    }

    private void a(TypedArray typedArray) {
        int n2 = typedArray.getResourceId(b.e.FloatingActionMenu_menu_fab_show_animation, b.a.fab_scale_up);
        this.setMenuButtonShowAnimation(AnimationUtils.loadAnimation((Context)this.getContext(), (int)n2));
        int n3 = typedArray.getResourceId(b.e.FloatingActionMenu_menu_fab_hide_animation, b.a.fab_scale_down);
        this.setMenuButtonHideAnimation(AnimationUtils.loadAnimation((Context)this.getContext(), (int)n3));
    }

    private void a(FloatingActionButton floatingActionButton) {
        String string = floatingActionButton.getLabelText();
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        com.github.clans.fab.a a2 = new com.github.clans.fab.a(this.ag);
        a2.setClickable(true);
        a2.setFab(floatingActionButton);
        a2.setShowAnimation(AnimationUtils.loadAnimation((Context)this.getContext(), (int)this.n));
        a2.setHideAnimation(AnimationUtils.loadAnimation((Context)this.getContext(), (int)this.o));
        if (this.R > 0) {
            a2.setTextAppearance(this.getContext(), this.R);
            a2.setShowShadow(false);
            a2.setUsingStyle(true);
        } else {
            a2.a(this.x, this.y, this.z);
            a2.setShowShadow(this.w);
            a2.setCornerRadius(this.v);
            if (this.O > 0) {
                this.setLabelEllipsize(a2);
            }
            a2.setMaxLines(this.P);
            a2.c();
            a2.setTextSize(0, this.u);
            a2.setTextColor(this.t);
            int n2 = this.s;
            int n3 = this.p;
            if (this.w) {
                n2 += floatingActionButton.getShadowRadius() + Math.abs((int)floatingActionButton.getShadowXOffset());
                n3 += floatingActionButton.getShadowRadius() + Math.abs((int)floatingActionButton.getShadowYOffset());
            }
            a2.setPadding(n2, n3, this.s, this.p);
            if (this.P < 0 || this.N) {
                a2.setSingleLine(this.N);
            }
        }
        a2.setText((CharSequence)string);
        a2.setOnClickListener(floatingActionButton.getOnClickListener());
        this.addView((View)a2);
        floatingActionButton.setTag(b.d.fab_label, (Object)a2);
    }

    private int b(int n2) {
        double d2 = n2;
        Double.isNaN((double)d2);
        double d3 = 0.03 * d2;
        Double.isNaN((double)d2);
        return (int)(d3 + d2);
    }

    private void c() {
        int n2 = Color.alpha((int)this.ae);
        final int n3 = Color.red((int)this.ae);
        final int n4 = Color.green((int)this.ae);
        final int n5 = Color.blue((int)this.ae);
        this.ac = ValueAnimator.ofInt((int[])new int[]{0, n2});
        this.ac.setDuration(300L);
        this.ac.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer n2 = (Integer)valueAnimator.getAnimatedValue();
                FloatingActionMenu.this.setBackgroundColor(Color.argb((int)n2, (int)n3, (int)n4, (int)n5));
            }
        });
        this.ad = ValueAnimator.ofInt((int[])new int[]{n2, 0});
        this.ad.setDuration(300L);
        this.ad.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer n2 = (Integer)valueAnimator.getAnimatedValue();
                FloatingActionMenu.this.setBackgroundColor(Color.argb((int)n2, (int)n3, (int)n4, (int)n5));
            }
        });
    }

    private boolean d() {
        return this.ae != 0;
    }

    private void e() {
        this.f = new FloatingActionButton(this.getContext());
        this.f.b = this.A;
        if (this.A) {
            this.f.d = c.a(this.getContext(), this.C);
            this.f.e = c.a(this.getContext(), this.D);
            this.f.f = c.a(this.getContext(), this.E);
        }
        this.f.a(this.F, this.G, this.H);
        this.f.c = this.B;
        this.f.a = this.Q;
        this.f.c();
        this.f.setLabelText(this.ah);
        this.T = new ImageView(this.getContext());
        this.T.setImageDrawable(this.I);
        this.addView((View)this.f, super.generateDefaultLayoutParams());
        this.addView((View)this.T);
        this.f();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void f() {
        float f2;
        float f3;
        block3 : {
            block4 : {
                block2 : {
                    int n2 = this.aa;
                    f3 = 135.0f;
                    if (n2 != 0) break block2;
                    f2 = this.af == 0 ? -135.0f : 135.0f;
                    if (this.af != 0) break block3;
                    break block4;
                }
                f2 = this.af == 0 ? 135.0f : -135.0f;
                if (this.af == 0) break block3;
            }
            f3 = -135.0f;
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this.T, (String)"rotation", (float[])new float[]{f2, 0.0f});
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)this.T, (String)"rotation", (float[])new float[]{0.0f, f3});
        this.b.play((Animator)objectAnimator2);
        this.c.play((Animator)objectAnimator);
        this.b.setInterpolator((TimeInterpolator)this.K);
        this.c.setInterpolator((TimeInterpolator)this.L);
        this.b.setDuration(300L);
        this.c.setDuration(300L);
    }

    private void g() {
        for (int i2 = 0; i2 < this.j; ++i2) {
            FloatingActionButton floatingActionButton;
            if (this.getChildAt(i2) == this.T || (floatingActionButton = (FloatingActionButton)this.getChildAt(i2)).getTag(b.d.fab_label) != null) continue;
            this.a(floatingActionButton);
            if (floatingActionButton != this.f) continue;
            this.f.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    FloatingActionMenu.this.a(FloatingActionMenu.this.M);
                }
            });
        }
    }

    private void setLabelEllipsize(com.github.clans.fab.a a2) {
        TextUtils.TruncateAt truncateAt;
        switch (this.O) {
            default: {
                return;
            }
            case 4: {
                truncateAt = TextUtils.TruncateAt.MARQUEE;
                break;
            }
            case 3: {
                truncateAt = TextUtils.TruncateAt.END;
                break;
            }
            case 2: {
                truncateAt = TextUtils.TruncateAt.MIDDLE;
                break;
            }
            case 1: {
                truncateAt = TextUtils.TruncateAt.START;
            }
        }
        a2.setEllipsize(truncateAt);
    }

    protected ViewGroup.MarginLayoutParams a() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public ViewGroup.MarginLayoutParams a(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(this.getContext(), attributeSet);
    }

    protected ViewGroup.MarginLayoutParams a(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public void a(boolean bl) {
        if (this.b()) {
            this.c(bl);
            return;
        }
        this.b(bl);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b(final boolean bl) {
        if (!this.b()) {
            if (this.d()) {
                this.ac.start();
            }
            if (this.S) {
                AnimatorSet animatorSet;
                if (this.d != null) {
                    animatorSet = this.d;
                } else {
                    this.c.cancel();
                    animatorSet = this.b;
                }
                animatorSet.start();
            }
            this.l = true;
            int n2 = 0;
            int n3 = 0;
            for (int i2 = this.getChildCount() - 1; i2 >= 0; --i2) {
                View view = this.getChildAt(i2);
                if (!(view instanceof FloatingActionButton) || view.getVisibility() == 8) continue;
                ++n2;
                final FloatingActionButton floatingActionButton = (FloatingActionButton)view;
                this.m.postDelayed(new Runnable(){

                    public void run() {
                        com.github.clans.fab.a a2;
                        if (FloatingActionMenu.this.b()) {
                            return;
                        }
                        if (floatingActionButton != FloatingActionMenu.this.f) {
                            floatingActionButton.a(bl);
                        }
                        if ((a2 = (com.github.clans.fab.a)((Object)floatingActionButton.getTag(b.d.fab_label))) != null && a2.f()) {
                            a2.a(bl);
                        }
                    }
                }, (long)n3);
                n3 += this.J;
            }
            this.m.postDelayed(new Runnable(){

                public void run() {
                    FloatingActionMenu.this.k = true;
                    if (FloatingActionMenu.this.ab != null) {
                        FloatingActionMenu.this.ab.a(true);
                    }
                }
            }, (long)((n2 + 1) * this.J));
        }
    }

    public boolean b() {
        return this.k;
    }

    public void c(final boolean bl) {
        if (this.b()) {
            if (this.d()) {
                this.ad.start();
            }
            if (this.S) {
                if (this.d != null) {
                    this.d.start();
                } else {
                    this.c.start();
                    this.b.cancel();
                }
            }
            this.l = false;
            int n2 = 0;
            int n3 = 0;
            for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
                View view = this.getChildAt(i2);
                if (!(view instanceof FloatingActionButton) || view.getVisibility() == 8) continue;
                ++n2;
                final FloatingActionButton floatingActionButton = (FloatingActionButton)view;
                this.m.postDelayed(new Runnable(){

                    public void run() {
                        com.github.clans.fab.a a2;
                        if (!FloatingActionMenu.this.b()) {
                            return;
                        }
                        if (floatingActionButton != FloatingActionMenu.this.f) {
                            floatingActionButton.b(bl);
                        }
                        if ((a2 = (com.github.clans.fab.a)((Object)floatingActionButton.getTag(b.d.fab_label))) != null && a2.f()) {
                            a2.b(bl);
                        }
                    }
                }, (long)n3);
                n3 += this.J;
            }
            this.m.postDelayed(new Runnable(){

                public void run() {
                    FloatingActionMenu.this.k = false;
                    if (FloatingActionMenu.this.ab != null) {
                        FloatingActionMenu.this.ab.a(false);
                    }
                }
            }, (long)((n2 + 1) * this.J));
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public int getAnimationDelayPerItem() {
        return this.J;
    }

    public AnimatorSet getIconToggleAnimatorSet() {
        return this.d;
    }

    public int getMenuButtonColorNormal() {
        return this.F;
    }

    public int getMenuButtonColorPressed() {
        return this.G;
    }

    public int getMenuButtonColorRipple() {
        return this.H;
    }

    public String getMenuButtonLabelText() {
        return this.ah;
    }

    public ImageView getMenuIconView() {
        return this.T;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.bringChildToFront((View)this.f);
        this.bringChildToFront((View)this.T);
        this.j = this.getChildCount();
        this.g();
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        int n6 = this.af == 0 ? n4 - n2 - this.g / 2 - this.getPaddingRight() : this.g / 2 + this.getPaddingLeft();
        boolean bl2 = this.aa == 0;
        int n7 = bl2 ? n5 - n3 - this.f.getMeasuredHeight() - this.getPaddingBottom() : this.getPaddingTop();
        int n8 = n6 - this.f.getMeasuredWidth() / 2;
        this.f.layout(n8, n7, n8 + this.f.getMeasuredWidth(), n7 + this.f.getMeasuredHeight());
        int n9 = n6 - this.T.getMeasuredWidth() / 2;
        int n10 = n7 + this.f.getMeasuredHeight() / 2 - this.T.getMeasuredHeight() / 2;
        this.T.layout(n9, n10, n9 + this.T.getMeasuredWidth(), n10 + this.T.getMeasuredHeight());
        if (bl2) {
            n7 = n7 + this.f.getMeasuredHeight() + this.e;
        }
        int n11 = this.j - 1;
        while (n11 >= 0) {
            FloatingActionButton floatingActionButton;
            View view = this.getChildAt(n11);
            if (view != this.T && (floatingActionButton = (FloatingActionButton)view).getVisibility() != 8) {
                View view2;
                int n12 = n6 - floatingActionButton.getMeasuredWidth() / 2;
                if (bl2) {
                    n7 = n7 - floatingActionButton.getMeasuredHeight() - this.e;
                }
                if (floatingActionButton != this.f) {
                    floatingActionButton.layout(n12, n7, n12 + floatingActionButton.getMeasuredWidth(), n7 + floatingActionButton.getMeasuredHeight());
                    if (!this.l) {
                        floatingActionButton.b(false);
                    }
                }
                if ((view2 = (View)floatingActionButton.getTag(b.d.fab_label)) != null) {
                    int n13 = this.ai ? this.g : floatingActionButton.getMeasuredWidth();
                    int n14 = n13 / 2;
                    int n15 = n14 + this.h;
                    int n16 = this.af == 0 ? n6 - n15 : n15 + n6;
                    int n17 = this.af == 0 ? n16 - view2.getMeasuredWidth() : n16 + view2.getMeasuredWidth();
                    int n18 = this.af == 0 ? n17 : n16;
                    if (this.af != 0) {
                        n16 = n17;
                    }
                    int n19 = n7 - this.i + (floatingActionButton.getMeasuredHeight() - view2.getMeasuredHeight()) / 2;
                    view2.layout(n18, n19, n16, n19 + view2.getMeasuredHeight());
                    if (!this.l) {
                        view2.setVisibility(4);
                    }
                }
                n7 = bl2 ? (n7 -= this.e) : n7 + view.getMeasuredHeight() + this.e;
            }
            --n11;
        }
        return;
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        this.g = 0;
        this.measureChildWithMargins((View)this.T, n2, 0, n3, 0);
        for (int i2 = 0; i2 < this.j; ++i2) {
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8 || view == this.T) continue;
            this.measureChildWithMargins(view, n2, 0, n3, 0);
            this.g = Math.max((int)this.g, (int)view.getMeasuredWidth());
        }
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        do {
            int n8 = this.j;
            n4 = 1;
            if (n6 >= n8) break;
            View view = this.getChildAt(n6);
            if (view.getVisibility() != 8 && view != this.T) {
                int n9 = 0 + view.getMeasuredWidth();
                int n10 = n5 + view.getMeasuredHeight();
                com.github.clans.fab.a a2 = (com.github.clans.fab.a)((Object)view.getTag(b.d.fab_label));
                if (a2 != null) {
                    int n11 = this.g - view.getMeasuredWidth();
                    if (!this.ai) {
                        n4 = 2;
                    }
                    int n12 = n11 / n4;
                    this.measureChildWithMargins((View)a2, n2, n12 + (view.getMeasuredWidth() + a2.a() + this.h), n3, 0);
                    n7 = Math.max((int)n7, (int)(n12 + (n9 + a2.getMeasuredWidth())));
                }
                n5 = n10;
            }
            ++n6;
        } while (true);
        int n13 = Math.max((int)this.g, (int)(n7 + this.h)) + this.getPaddingLeft() + this.getPaddingRight();
        int n14 = this.b(n5 + (this.e * (this.j - n4) + this.getPaddingTop() + this.getPaddingBottom()));
        if (this.getLayoutParams().width == -1) {
            n13 = FloatingActionMenu.getDefaultSize((int)this.getSuggestedMinimumWidth(), (int)n2);
        }
        if (this.getLayoutParams().height == -1) {
            n14 = FloatingActionMenu.getDefaultSize((int)this.getSuggestedMinimumHeight(), (int)n3);
        }
        this.setMeasuredDimension(n13, n14);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.W) {
            return this.a.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimated(boolean bl) {
        this.M = bl;
        AnimatorSet animatorSet = this.b;
        long l2 = 0L;
        long l3 = bl ? 300L : l2;
        animatorSet.setDuration(l3);
        AnimatorSet animatorSet2 = this.c;
        if (bl) {
            l2 = 300L;
        }
        animatorSet2.setDuration(l2);
    }

    public void setAnimationDelayPerItem(int n2) {
        this.J = n2;
    }

    public void setClosedOnTouchOutside(boolean bl) {
        this.W = bl;
    }

    public void setIconAnimated(boolean bl) {
        this.S = bl;
    }

    public void setIconAnimationCloseInterpolator(Interpolator interpolator) {
        this.c.setInterpolator((TimeInterpolator)interpolator);
    }

    public void setIconAnimationInterpolator(Interpolator interpolator) {
        this.b.setInterpolator((TimeInterpolator)interpolator);
        this.c.setInterpolator((TimeInterpolator)interpolator);
    }

    public void setIconAnimationOpenInterpolator(Interpolator interpolator) {
        this.b.setInterpolator((TimeInterpolator)interpolator);
    }

    public void setIconToggleAnimatorSet(AnimatorSet animatorSet) {
        this.d = animatorSet;
    }

    public void setMenuButtonColorNormal(int n2) {
        this.F = n2;
        this.f.setColorNormal(n2);
    }

    public void setMenuButtonColorNormalResId(int n2) {
        this.F = this.getResources().getColor(n2);
        this.f.setColorNormalResId(n2);
    }

    public void setMenuButtonColorPressed(int n2) {
        this.G = n2;
        this.f.setColorPressed(n2);
    }

    public void setMenuButtonColorPressedResId(int n2) {
        this.G = this.getResources().getColor(n2);
        this.f.setColorPressedResId(n2);
    }

    public void setMenuButtonColorRipple(int n2) {
        this.H = n2;
        this.f.setColorRipple(n2);
    }

    public void setMenuButtonColorRippleResId(int n2) {
        this.H = this.getResources().getColor(n2);
        this.f.setColorRippleResId(n2);
    }

    public void setMenuButtonHideAnimation(Animation animation) {
        this.V = animation;
        this.f.setHideAnimation(animation);
    }

    public void setMenuButtonLabelText(String string) {
        this.f.setLabelText(string);
    }

    public void setMenuButtonShowAnimation(Animation animation) {
        this.U = animation;
        this.f.setShowAnimation(animation);
    }

    public void setOnMenuButtonClickListener(View.OnClickListener onClickListener) {
        this.f.setOnClickListener(onClickListener);
    }

    public void setOnMenuToggleListener(a a2) {
        this.ab = a2;
    }

    public static interface a {
        public void a(boolean var1);
    }

}

