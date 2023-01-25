/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.LinearLayout
 *  java.lang.Math
 *  miuix.appcompat.R
 *  miuix.appcompat.R$styleable
 */
package miuix.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import miuix.appcompat.R;

public class DialogParentPanel
extends LinearLayout {
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMaxHeightMajor;
    private TypedValue mMaxHeightMinor;
    private TypedValue mMaxWidthMajor;
    private TypedValue mMaxWidthMinor;

    public DialogParentPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.Window);
        if (typedArray.hasValue(R.styleable.Window_windowFixedWidthMinor)) {
            this.mFixedWidthMinor = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowFixedWidthMinor, this.mFixedWidthMinor);
        }
        if (typedArray.hasValue(R.styleable.Window_windowFixedHeightMajor)) {
            this.mFixedHeightMajor = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowFixedHeightMajor, this.mFixedHeightMajor);
        }
        if (typedArray.hasValue(R.styleable.Window_windowFixedWidthMajor)) {
            this.mFixedWidthMajor = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowFixedWidthMajor, this.mFixedWidthMajor);
        }
        if (typedArray.hasValue(R.styleable.Window_windowFixedHeightMinor)) {
            this.mFixedHeightMinor = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowFixedHeightMinor, this.mFixedHeightMinor);
        }
        if (typedArray.hasValue(R.styleable.Window_windowMaxWidthMinor)) {
            this.mMaxWidthMinor = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowMaxWidthMinor, this.mMaxWidthMinor);
        }
        if (typedArray.hasValue(R.styleable.Window_windowMaxWidthMajor)) {
            this.mMaxWidthMajor = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowMaxWidthMajor, this.mMaxWidthMajor);
        }
        if (typedArray.hasValue(R.styleable.Window_windowMaxHeightMajor)) {
            this.mMaxHeightMajor = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowMaxHeightMajor, this.mMaxHeightMajor);
        }
        if (typedArray.hasValue(R.styleable.Window_windowMaxHeightMinor)) {
            this.mMaxHeightMinor = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowMaxHeightMinor, this.mMaxHeightMinor);
        }
        typedArray.recycle();
    }

    private int getHeightMeasureSpec(int n) {
        return this.getMeasureSpec(n, false, this.mFixedHeightMinor, this.mFixedHeightMajor, this.mMaxHeightMinor, this.mMaxHeightMajor);
    }

    private int getMeasureSpec(int n, boolean bl, TypedValue typedValue, TypedValue typedValue2, TypedValue typedValue3, TypedValue typedValue4) {
        if (View.MeasureSpec.getMode((int)n) == Integer.MIN_VALUE) {
            DisplayMetrics displayMetrics = this.getContext().getResources().getDisplayMetrics();
            boolean bl2 = displayMetrics.widthPixels < displayMetrics.heightPixels;
            if (!bl2) {
                typedValue = typedValue2;
            }
            int n2 = this.resolveDimension(displayMetrics, typedValue, bl);
            if (n2 > 0) {
                return View.MeasureSpec.makeMeasureSpec((int)n2, (int)1073741824);
            }
            if (!bl2) {
                typedValue3 = typedValue4;
            }
            int n3 = this.resolveDimension(displayMetrics, typedValue3, bl);
            if (n3 > 0) {
                n = View.MeasureSpec.makeMeasureSpec((int)Math.min((int)n3, (int)View.MeasureSpec.getSize((int)n)), (int)Integer.MIN_VALUE);
            }
        }
        return n;
    }

    private int getWidthMeasureSpec(int n) {
        return this.getMeasureSpec(n, true, this.mFixedWidthMinor, this.mFixedWidthMajor, this.mMaxWidthMinor, this.mMaxWidthMajor);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int resolveDimension(DisplayMetrics displayMetrics, TypedValue typedValue, boolean bl) {
        float f;
        if (typedValue == null) return 0;
        if (typedValue.type == 5) {
            f = typedValue.getDimension(displayMetrics);
            do {
                return (int)f;
                break;
            } while (true);
        }
        if (typedValue.type != 6) return 0;
        int n = bl ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        float f2 = n;
        f = typedValue.getFraction(f2, f2);
        return (int)f;
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(this.getWidthMeasureSpec(n), this.getHeightMeasureSpec(n2));
    }
}

