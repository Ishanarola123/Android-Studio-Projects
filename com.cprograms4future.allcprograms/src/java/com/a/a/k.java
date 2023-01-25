/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.media.ExifInterface
 *  android.net.Uri
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
package com.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import com.a.a.g;
import com.a.a.t;
import com.a.a.w;
import com.a.a.y;
import java.io.IOException;
import java.io.InputStream;

class k
extends g {
    k(Context context) {
        super(context);
    }

    static int a(Uri uri) throws IOException {
        int n2 = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (n2 != 3) {
            if (n2 != 6) {
                if (n2 != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }

    @Override
    public y.a a(w w2, int n2) throws IOException {
        return new y.a(null, this.b(w2), t.d.b, k.a(w2.d));
    }

    @Override
    public boolean a(w w2) {
        return "file".equals((Object)w2.d.getScheme());
    }
}

