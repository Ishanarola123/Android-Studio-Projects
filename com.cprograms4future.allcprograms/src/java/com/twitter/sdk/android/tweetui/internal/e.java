/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.widget.ImageView
 *  java.lang.Object
 */
package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class e
extends ImageView {
    a a = new a(null);

    public e(Context context) {
        super(context);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.a(this.getDrawableState());
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.a.a) {
            this.invalidate();
            return;
        }
        super.invalidateDrawable(drawable);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.a(canvas);
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        this.a.a(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        this.a.a(n2, n3);
    }

    public void setOverlayDrawable(Drawable drawable) {
        if (drawable != this.a.a) {
            this.a.a(this);
            if (drawable != null) {
                drawable.setCallback((Drawable.Callback)this);
            }
            this.a = new a(drawable);
            this.a.a(this.getDrawableState());
            this.requestLayout();
        }
    }

    protected static class a {
        final Drawable a;

        a(Drawable drawable) {
            this.a = drawable;
        }

        protected void a(int n2, int n3) {
            if (this.a != null) {
                this.a.setBounds(0, 0, n2, n3);
            }
        }

        protected void a(Canvas canvas) {
            if (this.a != null) {
                this.a.draw(canvas);
            }
        }

        protected void a(ImageView imageView) {
            if (this.a != null) {
                this.a.setCallback(null);
                imageView.unscheduleDrawable(this.a);
            }
        }

        protected void a(int[] arrn) {
            if (this.a != null && this.a.isStateful()) {
                this.a.setState(arrn);
            }
        }
    }

}

