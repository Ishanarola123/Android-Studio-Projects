/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 *  java.lang.Double
 */
package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.twitter.sdk.android.tweetui.h;

public class AspectRatioFrameLayout
extends FrameLayout {
    protected double a;
    private int b;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a(n2);
    }

    private void a(int n2) {
        TypedArray typedArray = this.getContext().getTheme().obtainStyledAttributes(n2, h.h.AspectRatioFrameLayout);
        try {
            this.a = typedArray.getFloat(h.h.AspectRatioFrameLayout_tw__frame_layout_aspect_ratio, 1.0f);
            this.b = typedArray.getInt(h.h.AspectRatioFrameLayout_tw__frame_layout_dimension_to_adjust, 0);
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5;
        int n6 = this.getPaddingLeft() + this.getPaddingRight();
        int n7 = this.getPaddingBottom() + this.getPaddingTop();
        if (this.b == 0) {
            int n8;
            if (View.MeasureSpec.getMode((int)n2) == 1073741824) {
                n8 = View.MeasureSpec.getSize((int)n2);
            } else {
                super.onMeasure(n2, n3);
                n8 = this.getMeasuredWidth();
            }
            n5 = n8 - n6;
            double d2 = n5;
            double d3 = this.a;
            Double.isNaN((double)d2);
            n4 = (int)(d2 / d3);
        } else {
            int n9;
            if (View.MeasureSpec.getMode((int)n3) == 1073741824) {
                n9 = View.MeasureSpec.getSize((int)n3);
            } else {
                super.onMeasure(n2, n3);
                n9 = this.getMeasuredHeight();
            }
            n4 = n9 - n7;
            double d4 = n4;
            double d5 = this.a;
            Double.isNaN((double)d4);
            n5 = (int)(d4 * d5);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)(n5 + n6), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)(n4 + n7), (int)1073741824));
    }

    public void setAspectRatio(double d2) {
        this.a = d2;
    }
}

