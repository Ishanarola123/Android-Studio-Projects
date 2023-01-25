/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.a.a;

import android.graphics.Bitmap;
import android.net.Uri;
import com.a.a.q;
import java.io.IOException;
import java.io.InputStream;

public interface j {
    public a a(Uri var1, int var2) throws IOException;

    public static class a {
        final InputStream a;
        final Bitmap b;
        final boolean c;
        final long d;

        public a(InputStream inputStream, boolean bl, long l2) {
            if (inputStream != null) {
                this.a = inputStream;
                this.b = null;
                this.c = bl;
                this.d = l2;
                return;
            }
            throw new IllegalArgumentException("Stream may not be null.");
        }

        public InputStream a() {
            return this.a;
        }

        @Deprecated
        public Bitmap b() {
            return this.b;
        }

        public long c() {
            return this.d;
        }
    }

    public static class b
    extends IOException {
        final boolean a;
        final int b;

        public b(String string, int n2, int n3) {
            super(string);
            this.a = q.c(n2);
            this.b = n3;
        }
    }

}

