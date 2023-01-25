/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.support.v7.widget.h
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.github.rubensousa.raiflatbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.support.v7.widget.h;
import android.util.AttributeSet;
import android.view.View;
import com.github.rubensousa.raiflatbutton.a;
import com.github.rubensousa.raiflatbutton.b;

public class RaiflatButton
extends h {
    private b b;

    public RaiflatButton(Context context) {
        this(context, null);
    }

    public RaiflatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context, attributeSet);
    }

    public RaiflatButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.b = new b((View)this);
        if (Build.VERSION.SDK_INT >= 21 && attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, a.b.RaiflatButton);
            this.b.a(typedArray.getBoolean(a.b.RaiflatButton_flatten, true));
            typedArray.recycle();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(this.b.b(parcelable));
    }

    public Parcelable onSaveInstanceState() {
        return this.b.a(super.onSaveInstanceState());
    }

    public void setFlatEnabled(boolean bl) {
        this.b.b(bl);
    }
}

