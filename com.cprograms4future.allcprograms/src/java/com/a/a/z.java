/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.Uri
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package com.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.a.a.ag;
import com.a.a.t;
import com.a.a.w;
import com.a.a.y;
import java.io.IOException;

class z
extends y {
    private final Context a;

    z(Context context) {
        this.a = context;
    }

    private static Bitmap a(Resources resources, int n2, w w2) {
        BitmapFactory.Options options = z.c(w2);
        if (z.a(options)) {
            BitmapFactory.decodeResource((Resources)resources, (int)n2, (BitmapFactory.Options)options);
            z.a(w2.h, w2.i, options, w2);
        }
        return BitmapFactory.decodeResource((Resources)resources, (int)n2, (BitmapFactory.Options)options);
    }

    @Override
    public y.a a(w w2, int n2) throws IOException {
        Resources resources = ag.a(this.a, w2);
        return new y.a(z.a(resources, ag.a(resources, w2), w2), t.d.b);
    }

    @Override
    public boolean a(w w2) {
        if (w2.e != 0) {
            return true;
        }
        return "android.resource".equals((Object)w2.d.getScheme());
    }
}

