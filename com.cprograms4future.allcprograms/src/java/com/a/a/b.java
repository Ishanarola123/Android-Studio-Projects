/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.net.Uri
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.a.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.a.a.t;
import com.a.a.w;
import com.a.a.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class b
extends y {
    private static final int a = "file:///android_asset/".length();
    private final AssetManager b;

    public b(Context context) {
        this.b = context.getAssets();
    }

    static String b(w w2) {
        return w2.d.toString().substring(a);
    }

    @Override
    public y.a a(w w2, int n2) throws IOException {
        return new y.a(this.b.open(b.b(w2)), t.d.b);
    }

    @Override
    public boolean a(w w2) {
        Uri uri = w2.d;
        boolean bl = "file".equals((Object)uri.getScheme());
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = uri.getPathSegments().isEmpty();
            bl2 = false;
            if (!bl3) {
                boolean bl4 = "android_asset".equals(uri.getPathSegments().get(0));
                bl2 = false;
                if (bl4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }
}

