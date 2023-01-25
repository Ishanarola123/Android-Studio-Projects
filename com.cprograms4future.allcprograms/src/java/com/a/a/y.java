/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.NetworkInfo
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.Math
 *  java.lang.Object
 */
package com.a.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.a.a.ag;
import com.a.a.t;
import com.a.a.w;
import java.io.IOException;
import java.io.InputStream;

public abstract class y {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void a(int var0, int var1_1, int var2_2, int var3_3, BitmapFactory.Options var4_4, w var5_5) {
        block3 : {
            block4 : {
                block2 : {
                    if (var3_3 > var1_1 || var2_2 > var0) break block2;
                    var8_6 = 1;
                    break block3;
                }
                if (var1_1 != 0) break block4;
                var9_7 = (float)var2_2 / (float)var0;
                ** GOTO lbl11
            }
            if (var0 == 0) {
                var9_7 = (float)var3_3 / (float)var1_1;
lbl11: // 2 sources:
                var8_6 = (int)Math.floor((double)var9_7);
            } else {
                var6_8 = (int)Math.floor((double)((float)var3_3 / (float)var1_1));
                var7_9 = (int)Math.floor((double)((float)var2_2 / (float)var0));
                var8_6 = var5_5.k != false ? Math.max((int)var6_8, (int)var7_9) : Math.min((int)var6_8, (int)var7_9);
            }
        }
        var4_4.inSampleSize = var8_6;
        var4_4.inJustDecodeBounds = false;
    }

    static void a(int n2, int n3, BitmapFactory.Options options, w w2) {
        y.a(n2, n3, options.outWidth, options.outHeight, options, w2);
    }

    static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static BitmapFactory.Options c(w w2) {
        BitmapFactory.Options options;
        block5 : {
            boolean bl;
            boolean bl2;
            block4 : {
                bl = w2.d();
                bl2 = w2.q != null;
                if (bl) break block4;
                options = null;
                if (!bl2) break block5;
            }
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = bl;
            if (bl2) {
                options.inPreferredConfig = w2.q;
            }
        }
        return options;
    }

    int a() {
        return 0;
    }

    public abstract a a(w var1, int var2) throws IOException;

    public abstract boolean a(w var1);

    boolean a(boolean bl, NetworkInfo networkInfo) {
        return false;
    }

    boolean b() {
        return false;
    }

    public static final class a {
        private final t.d a;
        private final Bitmap b;
        private final InputStream c;
        private final int d;

        public a(Bitmap bitmap, t.d d2) {
            this(ag.a(bitmap, "bitmap == null"), null, d2, 0);
        }

        a(Bitmap bitmap, InputStream inputStream, t.d d2, int n2) {
            boolean bl = bitmap != null;
            boolean bl2 = false;
            if (inputStream != null) {
                bl2 = true;
            }
            if (bl2 ^ bl) {
                this.b = bitmap;
                this.c = inputStream;
                this.a = ag.a(d2, "loadedFrom == null");
                this.d = n2;
                return;
            }
            throw new AssertionError();
        }

        public a(InputStream inputStream, t.d d2) {
            this(null, ag.a(inputStream, "stream == null"), d2, 0);
        }

        public Bitmap a() {
            return this.b;
        }

        public InputStream b() {
            return this.c;
        }

        public t.d c() {
            return this.a;
        }

        int d() {
            return this.d;
        }
    }

}

