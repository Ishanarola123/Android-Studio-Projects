/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.a.a.a;
import com.a.a.ac;
import com.a.a.t;
import com.a.a.w;

final class ad
extends a<ac> {
    ad(t t2, ac ac2, w w2, int n2, int n3, Drawable drawable, String string, Object object, int n4) {
        super(t2, ac2, w2, n2, n3, n4, drawable, string, object, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void a() {
        ac ac2 = (ac)this.d();
        if (ac2 == null) {
            return;
        }
        Drawable drawable = this.g != 0 ? this.a.c.getResources().getDrawable(this.g) : this.h;
        ac2.a(drawable);
    }

    @Override
    void a(Bitmap bitmap, t.d d2) {
        if (bitmap != null) {
            ac ac2 = (ac)this.d();
            if (ac2 != null) {
                ac2.a(bitmap, d2);
                if (!bitmap.isRecycled()) {
                    return;
                }
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
            return;
        }
        throw new AssertionError((Object)String.format((String)"Attempted to complete action with no result!\n%s", (Object[])new Object[]{this}));
    }
}

