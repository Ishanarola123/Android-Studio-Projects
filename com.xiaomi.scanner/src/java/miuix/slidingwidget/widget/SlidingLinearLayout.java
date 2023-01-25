/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Pair
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  androidx.annotation.RequiresApi
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.HashMap
 *  miuix.animation.Folme
 *  miuix.animation.IStateStyle
 *  miuix.animation.IVisibleStyle
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.property.ViewProperty
 *  miuix.slidingwidget.widget.SlidingLinearLayout$1
 *  miuix.slidingwidget.widget.SlidingLinearLayout$2
 *  miuix.slidingwidget.widget.SlidingLinearLayout$3
 */
package miuix.slidingwidget.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import miuix.animation.Folme;
import miuix.animation.IStateStyle;
import miuix.animation.IVisibleStyle;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.property.ViewProperty;
import miuix.slidingwidget.widget.SlidingLinearLayout;

public class SlidingLinearLayout
extends LinearLayout {
    private final HashMap<View, Pair<Float, Float>> preAddViewPairs = new HashMap();
    private final int[] preLayout = new int[4];
    private final HashMap<View, Pair<Float, Float>> preRemoveViewPairs = new HashMap();

    public SlidingLinearLayout(Context context) {
        this(context, null);
    }

    public SlidingLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingLinearLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.setLayoutTransition(null);
    }

    private void preAddView() {
        int n = this.getChildCount();
        for (int i = 0; i < n; ++i) {
            View view = this.getChildAt(i);
            this.preAddViewPairs.put((Object)view, (Object)new Pair((Object)Float.valueOf((float)view.getX()), (Object)Float.valueOf((float)view.getY())));
        }
    }

    private void preRemoveView(int n, int n2) {
        int n3 = this.getChildCount();
        for (int i = 0; i < n3; ++i) {
            View view = this.getChildAt(i);
            if (i >= n && i < n + n2 || view.getVisibility() == 8) continue;
            this.preRemoveViewPairs.put((Object)view, (Object)new Pair((Object)Float.valueOf((float)view.getX()), (Object)Float.valueOf((float)view.getY())));
        }
    }

    private void preRemoveView(View view) {
        int n = this.getChildCount();
        for (int i = 0; i < n; ++i) {
            View view2 = this.getChildAt(i);
            if (view == view2 || view2.getVisibility() == 8) continue;
            this.preRemoveViewPairs.put((Object)view2, (Object)new Pair((Object)Float.valueOf((float)view2.getX()), (Object)Float.valueOf((float)view2.getY())));
        }
    }

    private void show(View view) {
        Folme.useAt((View[])new View[]{view}).visible().setFlags(1L).setFlags(1L).setShowDelay(100L).setHide().show(new AnimConfig[0]);
    }

    public void addViewSliding(View view) {
        this.preAddView();
        this.addView(view);
        this.show(view);
    }

    public void addViewSliding(View view, int n) {
        this.preAddView();
        this.addView(view, n);
        this.show(view);
    }

    public void addViewSliding(View view, int n, int n2) {
        this.preAddView();
        this.addView(view, n, n2);
        this.show(view);
    }

    public void addViewSliding(View view, int n, LinearLayout.LayoutParams layoutParams) {
        this.preAddView();
        this.addView(view, n, (ViewGroup.LayoutParams)layoutParams);
        this.show(view);
    }

    public void addViewSliding(View view, LinearLayout.LayoutParams layoutParams) {
        this.preAddView();
        this.addView(view, (ViewGroup.LayoutParams)layoutParams);
        this.show(view);
    }

    /*
     * Enabled aggressive block sorting
     */
    @RequiresApi(api=24)
    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (bl) {
            int n5 = this.getChildCount();
            boolean bl2 = this.getOrientation() == 1 ? Math.abs((int)(this.preLayout[1] - n2)) > Math.abs((int)(this.preLayout[3] - n4)) : Math.abs((int)(this.preLayout[0] - n)) > Math.abs((int)(this.preLayout[2] - n3));
            int n6 = 0;
            while (n6 < n5) {
                int n7;
                View view = this.getChildAt(n6);
                HashMap<View, Pair<Float, Float>> hashMap = this.preAddViewPairs;
                if (hashMap != null && hashMap.size() > 0) {
                    Pair pair = (Pair)this.preAddViewPairs.get((Object)view);
                    if (pair != null && view.getVisibility() != 8) {
                        float f;
                        float f2;
                        if (!(view.getX() == ((Float)pair.first).floatValue() && view.getY() == ((Float)pair.second).floatValue() || bl2)) {
                            f2 = ((Float)pair.first).floatValue() - view.getX();
                            f = ((Float)pair.second).floatValue() - view.getY();
                        } else if (view.getX() == ((Float)pair.first).floatValue() && view.getY() == ((Float)pair.second).floatValue() && bl2) {
                            int[] arrn = this.preLayout;
                            f2 = arrn[0] - n;
                            f = arrn[1] - n2;
                        } else {
                            f = 0.0f;
                            f2 = 0.0f;
                        }
                        AnimState animState = new AnimState((Object)"start");
                        ViewProperty viewProperty = ViewProperty.TRANSLATION_X;
                        n7 = n6;
                        AnimState animState2 = animState.add((Object)viewProperty, (double)f2).add((Object)ViewProperty.TRANSLATION_Y, (double)f);
                        AnimState animState3 = new AnimState((Object)"end").add((Object)ViewProperty.TRANSLATION_X, 0.0).add((Object)ViewProperty.TRANSLATION_Y, 0.0);
                        Folme.useAt((View[])new View[]{view}).state().setTo((Object)animState2).fromTo((Object)animState2, (Object)animState3, new AnimConfig[0]);
                    } else {
                        n7 = n6;
                    }
                    this.preAddViewPairs.remove((Object)view);
                } else {
                    n7 = n6;
                }
                HashMap<View, Pair<Float, Float>> hashMap2 = this.preRemoveViewPairs;
                if (hashMap2 != null && hashMap2.size() > 0) {
                    Pair pair = (Pair)this.preRemoveViewPairs.get((Object)view);
                    if (pair != null && view.getVisibility() != 8) {
                        float f;
                        float f3;
                        if (!(view.getX() == ((Float)pair.first).floatValue() && view.getY() == ((Float)pair.second).floatValue() || bl2)) {
                            f3 = ((Float)pair.first).floatValue() - view.getX();
                            f = ((Float)pair.second).floatValue() - view.getY();
                        } else if (view.getX() == ((Float)pair.first).floatValue() && view.getY() == ((Float)pair.second).floatValue() && bl2) {
                            int[] arrn = this.preLayout;
                            f3 = arrn[0] - n;
                            f = arrn[1] - n2;
                        } else {
                            f = 0.0f;
                            f3 = 0.0f;
                        }
                        AnimState animState = new AnimState((Object)"start").add((Object)ViewProperty.TRANSLATION_X, (double)f3).add((Object)ViewProperty.TRANSLATION_Y, (double)f);
                        AnimState animState4 = new AnimState((Object)"end").add((Object)ViewProperty.TRANSLATION_X, 0.0).add((Object)ViewProperty.TRANSLATION_Y, 0.0);
                        Folme.useAt((View[])new View[]{view}).state().setTo((Object)animState).fromTo((Object)animState, (Object)animState4, new AnimConfig[0]);
                    }
                    this.preRemoveViewPairs.remove((Object)view);
                }
                n6 = n7 + 1;
            }
            this.preAddViewPairs.clear();
            this.preRemoveViewPairs.clear();
            int[] arrn = this.preLayout;
            arrn[0] = n;
            arrn[1] = n2;
            arrn[2] = n3;
            arrn[3] = n4;
        }
    }

    public void removeViewSliding(View view) {
        this.preRemoveView(view);
        IVisibleStyle iVisibleStyle = Folme.useAt((View[])new View[]{view}).visible().setFlags(1L).setShow();
        AnimConfig[] arranimConfig = new AnimConfig[1];
        AnimConfig animConfig = new AnimConfig();
        TransitionListener[] arrtransitionListener = new TransitionListener[]{new 1(this, view)};
        arranimConfig[0] = animConfig.addListeners(arrtransitionListener);
        iVisibleStyle.hide(arranimConfig);
    }

    public void removeViewSlidingAt(int n) {
        View view = this.getChildAt(n);
        this.preRemoveView(view);
        IVisibleStyle iVisibleStyle = Folme.useAt((View[])new View[]{view}).visible().setFlags(1L).setShow();
        AnimConfig[] arranimConfig = new AnimConfig[1];
        AnimConfig animConfig = new AnimConfig();
        TransitionListener[] arrtransitionListener = new TransitionListener[]{new 2(this, n)};
        arranimConfig[0] = animConfig.addListeners(arrtransitionListener);
        iVisibleStyle.hide(arranimConfig);
    }

    public void removeViewsSliding(int n, int n2) {
        this.preRemoveView(n, n2);
        int n3 = n + n2;
        for (int i = n; i < n3; ++i) {
            View view = this.getChildAt(i);
            if (view.getVisibility() == 8) continue;
            IVisibleStyle iVisibleStyle = Folme.useAt((View[])new View[]{view}).visible().setFlags(1L).setShow();
            AnimConfig[] arranimConfig = new AnimConfig[1];
            AnimConfig animConfig = new AnimConfig();
            TransitionListener[] arrtransitionListener = new TransitionListener[1];
            3 var10_10 = new 3(this, i, n3, n, n2);
            arrtransitionListener[0] = var10_10;
            arranimConfig[0] = animConfig.addListeners(arrtransitionListener);
            iVisibleStyle.hide(arranimConfig);
        }
    }
}

