/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
package com.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.a.a.t;
import com.a.a.w;
import com.a.a.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class g
extends y {
    final Context a;

    g(Context context) {
        this.a = context;
    }

    @Override
    public y.a a(w w2, int n2) throws IOException {
        return new y.a(this.b(w2), t.d.b);
    }

    @Override
    public boolean a(w w2) {
        return "content".equals((Object)w2.d.getScheme());
    }

    InputStream b(w w2) throws FileNotFoundException {
        return this.a.getContentResolver().openInputStream(w2.d);
    }
}

