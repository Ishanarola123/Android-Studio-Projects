/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.widget.ImageView
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package com.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.a.a.a;
import com.a.a.e;
import com.a.a.t;
import com.a.a.u;
import com.a.a.w;
import java.lang.ref.WeakReference;

class l
extends a<ImageView> {
    e m;

    l(t t2, ImageView imageView, w w2, int n2, int n3, int n4, Drawable drawable, String string, Object object, e e2, boolean bl) {
        super(t2, imageView, w2, n2, n3, n4, drawable, string, object, bl);
        this.m = e2;
    }

    @Override
    public void a() {
        ImageView imageView = (ImageView)this.c.get();
        if (imageView == null) {
            return;
        }
        if (this.g != 0) {
            imageView.setImageResource(this.g);
        } else if (this.h != null) {
            imageView.setImageDrawable(this.h);
        }
        if (this.m != null) {
            this.m.b();
        }
    }

    @Override
    public void a(Bitmap bitmap, t.d d2) {
        if (bitmap != null) {
            ImageView imageView = (ImageView)this.c.get();
            if (imageView == null) {
                return;
            }
            Context context = this.a.c;
            boolean bl = this.a.k;
            u.a(imageView, context, bitmap, d2, this.d, bl);
            if (this.m != null) {
                this.m.a();
            }
            return;
        }
        throw new AssertionError((Object)String.format((String)"Attempted to complete action with no result!\n%s", (Object[])new Object[]{this}));
    }

    @Override
    void b() {
        super.b();
        if (this.m != null) {
            this.m = null;
        }
    }
}

