/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ProgressBar
 */
package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.a.a.ac;
import com.a.a.t;
import com.twitter.sdk.android.tweetui.internal.d;
import com.twitter.sdk.android.tweetui.internal.f;

public class b
extends FrameLayout
implements ac {
    final d a;
    final ProgressBar b;

    public b(Context context) {
        this(context, new d(context), new ProgressBar(context));
    }

    b(Context context, d d2, ProgressBar progressBar) {
        super(context);
        this.a = d2;
        this.b = progressBar;
        progressBar.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
        this.addView((View)progressBar);
        d2.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 17));
        this.addView((View)d2);
    }

    @Override
    public void a(Bitmap bitmap, t.d d2) {
        this.a.setImageBitmap(bitmap);
        this.b.setVisibility(8);
    }

    @Override
    public void a(Drawable drawable) {
    }

    @Override
    public void b(Drawable drawable) {
        this.a.setImageResource(17170445);
        this.b.setVisibility(0);
    }

    public void setSwipeToDismissCallback(f.a a2) {
        f f2 = f.a((View)this.a, a2);
        this.a.setOnTouchListener((View.OnTouchListener)f2);
    }
}

