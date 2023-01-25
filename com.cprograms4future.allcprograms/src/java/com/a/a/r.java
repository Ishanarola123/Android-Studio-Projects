/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.NetworkInfo
 *  android.net.Uri
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
package com.a.a;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.net.Uri;
import com.a.a.aa;
import com.a.a.ag;
import com.a.a.j;
import com.a.a.t;
import com.a.a.w;
import com.a.a.y;
import java.io.IOException;
import java.io.InputStream;

class r
extends y {
    private final j a;
    private final aa b;

    public r(j j2, aa aa2) {
        this.a = j2;
        this.b = aa2;
    }

    @Override
    int a() {
        return 2;
    }

    @Override
    public y.a a(w w2, int n2) throws IOException {
        j.a a2 = this.a.a(w2.d, w2.c);
        if (a2 == null) {
            return null;
        }
        t.d d2 = a2.c ? t.d.b : t.d.c;
        Bitmap bitmap = a2.b();
        if (bitmap != null) {
            return new y.a(bitmap, d2);
        }
        InputStream inputStream = a2.a();
        if (inputStream == null) {
            return null;
        }
        if (d2 == t.d.b && a2.c() == 0L) {
            ag.a(inputStream);
            throw new IOException("Received response with 0 content-length header."){};
        }
        if (d2 == t.d.c && a2.c() > 0L) {
            this.b.a(a2.c());
        }
        return new y.a(inputStream, d2);
    }

    @Override
    public boolean a(w w2) {
        String string = w2.d.getScheme();
        return "http".equals((Object)string) || "https".equals((Object)string);
        {
        }
    }

    @Override
    boolean a(boolean bl, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
        {
        }
    }

    @Override
    boolean b() {
        return true;
    }

}

