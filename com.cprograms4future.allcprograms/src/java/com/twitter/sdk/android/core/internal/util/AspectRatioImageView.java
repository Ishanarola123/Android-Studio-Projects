/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.widget.ImageView
 *  java.lang.Double
 *  java.lang.Math
 */
package com.twitter.sdk.android.core.internal.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.twitter.sdk.android.core.h;

public class AspectRatioImageView
extends ImageView {
    private double a;
    private int b;

    public AspectRatioImageView(Context context) {
        this(context, null);
    }

    public AspectRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, h.e.tw__AspectRatioImageView);
        try {
            this.a = typedArray.getFloat(h.e.tw__AspectRatioImageView_tw__image_aspect_ratio, 1.0f);
            this.b = typedArray.getInt(h.e.tw__AspectRatioImageView_tw__image_dimension_to_adjust, 0);
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    int a(int n2, double d2) {
        if (d2 == 0.0) {
            return 0;
        }
        double d3 = n2;
        Double.isNaN((double)d3);
        return (int)Math.round((double)(d3 / d2));
    }

    int b(int n2, double d2) {
        double d3 = n2;
        Double.isNaN((double)d3);
        return (int)Math.round((double)(d3 * d2));
    }

    public double getAspectRatio() {
        return this.a;
    }

    public int getDimensionToAdjust() {
        return this.b;
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        int n4 = this.getMeasuredWidth();
        int n5 = this.getMeasuredHeight();
        if (this.b == 0) {
            n5 = this.a(n4, this.a);
        } else {
            n4 = this.b(n5, this.a);
        }
        this.setMeasuredDimension(n4, n5);
    }

    public void setAspectRatio(double d2) {
        this.a = d2;
    }
}

