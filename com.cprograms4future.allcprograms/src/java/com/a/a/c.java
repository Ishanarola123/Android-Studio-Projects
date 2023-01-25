/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Matrix
 *  android.net.NetworkInfo
 *  android.os.Handler
 *  com.a.a.c$2
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.Future
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.a.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.os.Handler;
import com.a.a.a;
import com.a.a.aa;
import com.a.a.ae;
import com.a.a.ag;
import com.a.a.c;
import com.a.a.d;
import com.a.a.i;
import com.a.a.n;
import com.a.a.p;
import com.a.a.q;
import com.a.a.t;
import com.a.a.w;
import com.a.a.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class c
implements Runnable {
    private static final Object t = new Object();
    private static final ThreadLocal<StringBuilder> u = new ThreadLocal<StringBuilder>(){

        protected StringBuilder a() {
            return new StringBuilder("Picasso-");
        }

        protected /* synthetic */ Object initialValue() {
            return this.a();
        }
    };
    private static final AtomicInteger v = new AtomicInteger();
    private static final y w = new 2();
    final int a = v.incrementAndGet();
    final t b;
    final i c;
    final d d;
    final aa e;
    final String f;
    final w g;
    final int h;
    int i;
    final y j;
    a k;
    List<a> l;
    Bitmap m;
    Future<?> n;
    t.d o;
    Exception p;
    int q;
    int r;
    t.e s;

    c(t t2, i i2, d d2, aa aa2, a a2, y y2) {
        this.b = t2;
        this.c = i2;
        this.d = d2;
        this.e = aa2;
        this.k = a2;
        this.f = a2.e();
        this.g = a2.c();
        this.s = a2.k();
        this.h = a2.h();
        this.i = a2.i();
        this.j = y2;
        this.r = y2.a();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static Bitmap a(w var0, Bitmap var1_1, int var2_2) {
        var3_3 = var1_1.getWidth();
        var4_4 = var1_1.getHeight();
        var5_5 = var0.l;
        var6_6 = new Matrix();
        var7_7 = var0.f();
        var8_8 = 0;
        if (!var7_7) ** GOTO lbl70
        var14_9 = var0.h;
        var15_10 = var0.i;
        var16_11 = var0.m;
        if (var16_11 != 0.0f) {
            if (var0.p) {
                var6_6.setRotate(var16_11, var0.n, var0.o);
            } else {
                var6_6.setRotate(var16_11);
            }
        }
        if (var0.j) {
            var27_12 = var14_9;
            var28_13 = var3_3;
            var29_14 = var27_12 / var28_13;
            var30_15 = var15_10;
            var31_16 = var4_4;
            var32_17 = var30_15 / var31_16;
            if (var29_14 > var32_17) {
                var40_18 = (int)Math.ceil((double)(var31_16 * (var32_17 / var29_14)));
                var38_19 = (var4_4 - var40_18) / 2;
                var32_17 = var30_15 / (float)var40_18;
                var36_20 = var40_18;
                var35_21 = var29_14;
                var37_22 = var3_3;
                var8_8 = 0;
            } else {
                var33_23 = (int)Math.ceil((double)(var28_13 * (var29_14 / var32_17)));
                var34_24 = (var3_3 - var33_23) / 2;
                var35_21 = var27_12 / (float)var33_23;
                var36_20 = var4_4;
                var8_8 = var34_24;
                var37_22 = var33_23;
                var38_19 = 0;
            }
            if (c.a(var5_5, var3_3, var4_4, var14_9, var15_10)) {
                var6_6.preScale(var35_21, var32_17);
            }
            var11_25 = var38_19;
            var9_26 = var37_22;
            var10_27 = var36_20;
        } else {
            if (var0.k) {
                var24_28 = (float)var14_9 / (float)var3_3;
                var25_29 = (float)var15_10 / (float)var4_4;
                if (!(var24_28 < var25_29)) {
                    var24_28 = var25_29;
                }
                if (c.a(var5_5, var3_3, var4_4, var14_9, var15_10)) {
                    var6_6.preScale(var24_28, var24_28);
                }
            } else if (!(var14_9 == 0 && var15_10 == 0 || var14_9 == var3_3 && var15_10 == var4_4)) {
                if (var14_9 != 0) {
                    var17_30 = var14_9;
                    var18_31 = var3_3;
                } else {
                    var17_30 = var15_10;
                    var18_31 = var4_4;
                }
                var19_32 = var17_30 / var18_31;
                if (var15_10 != 0) {
                    var20_33 = var15_10;
                    var21_34 = var4_4;
                } else {
                    var20_33 = var14_9;
                    var21_34 = var3_3;
                }
                var22_35 = var20_33 / var21_34;
                if (c.a(var5_5, var3_3, var4_4, var14_9, var15_10)) {
                    var6_6.preScale(var19_32, var22_35);
                }
            }
lbl70: // 7 sources:
            var9_26 = var3_3;
            var10_27 = var4_4;
            var11_25 = 0;
        }
        if (var2_2 != 0) {
            var6_6.preRotate((float)var2_2);
        }
        if ((var12_36 = Bitmap.createBitmap((Bitmap)var1_1, (int)var8_8, (int)var11_25, (int)var9_26, (int)var10_27, (Matrix)var6_6, (boolean)true)) == var1_1) return var1_1;
        var1_1.recycle();
        return var12_36;
    }

    static Bitmap a(InputStream inputStream, w w2) throws IOException {
        Bitmap bitmap;
        n n2 = new n(inputStream);
        long l2 = n2.a(65536);
        BitmapFactory.Options options = y.c(w2);
        boolean bl = y.a(options);
        boolean bl2 = ag.c(n2);
        n2.a(l2);
        if (bl2) {
            byte[] arrby = ag.b(n2);
            if (bl) {
                BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, (BitmapFactory.Options)options);
                y.a(w2.h, w2.i, options, w2);
            }
            return BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, (BitmapFactory.Options)options);
        }
        if (bl) {
            BitmapFactory.decodeStream((InputStream)n2, null, (BitmapFactory.Options)options);
            y.a(w2.h, w2.i, options, w2);
            n2.a(l2);
        }
        if ((bitmap = BitmapFactory.decodeStream((InputStream)n2, null, (BitmapFactory.Options)options)) != null) {
            return bitmap;
        }
        throw new IOException("Failed to decode stream.");
    }

    static Bitmap a(List<ae> list, Bitmap bitmap) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Bitmap bitmap2;
            ae ae2;
            block6 : {
                ae2 = (ae)list.get(i2);
                try {
                    bitmap2 = ae2.a(bitmap);
                    if (bitmap2 != null) break block6;
                }
                catch (RuntimeException runtimeException) {
                    t.a.post(new Runnable(){

                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Transformation ");
                            stringBuilder.append(ae2.a());
                            stringBuilder.append(" crashed with exception.");
                            throw new RuntimeException(stringBuilder.toString(), (Throwable)runtimeException);
                        }
                    });
                    return null;
                }
                final StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Transformation ");
                stringBuilder.append(ae2.a());
                stringBuilder.append(" returned null after ");
                stringBuilder.append(i2);
                stringBuilder.append(" previous transformation(s).\n\nTransformation list:\n");
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    stringBuilder.append(((ae)iterator.next()).a());
                    stringBuilder.append('\n');
                }
                t.a.post(new Runnable(){

                    public void run() {
                        throw new NullPointerException(stringBuilder.toString());
                    }
                });
                return null;
            }
            if (bitmap2 == bitmap && bitmap.isRecycled()) {
                t.a.post(new Runnable(){

                    public void run() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Transformation ");
                        stringBuilder.append(ae2.a());
                        stringBuilder.append(" returned input Bitmap but recycled it.");
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                });
                return null;
            }
            if (bitmap2 != bitmap && !bitmap.isRecycled()) {
                t.a.post(new Runnable(){

                    public void run() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Transformation ");
                        stringBuilder.append(ae2.a());
                        stringBuilder.append(" mutated input Bitmap but failed to recycle the original.");
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                });
                return null;
            }
            bitmap = bitmap2;
            continue;
        }
        return bitmap;
    }

    static c a(t t2, i i2, d d2, aa aa2, a a2) {
        w w2 = a2.c();
        List<y> list = t2.a();
        int n2 = list.size();
        for (int i3 = 0; i3 < n2; ++i3) {
            y y2 = (y)list.get(i3);
            if (!y2.a(w2)) continue;
            c c2 = new c(t2, i2, d2, aa2, a2, y2);
            return c2;
        }
        c c3 = new c(t2, i2, d2, aa2, a2, w);
        return c3;
    }

    static void a(w w2) {
        String string = w2.c();
        StringBuilder stringBuilder = (StringBuilder)u.get();
        stringBuilder.ensureCapacity("Picasso-".length() + string.length());
        stringBuilder.replace("Picasso-".length(), stringBuilder.length(), string);
        Thread.currentThread().setName(stringBuilder.toString());
    }

    private static boolean a(boolean bl, int n2, int n3, int n4, int n5) {
        return !bl || n2 > n4 || n3 > n5;
        {
        }
    }

    private t.e o() {
        t.e e2 = t.e.a;
        List<a> list = this.l;
        boolean bl = true;
        int n2 = 0;
        boolean bl2 = list != null && !this.l.isEmpty();
        if (this.k == null && !bl2) {
            bl = false;
        }
        if (!bl) {
            return e2;
        }
        if (this.k != null) {
            e2 = this.k.k();
        }
        if (bl2) {
            int n3 = this.l.size();
            while (n2 < n3) {
                t.e e3 = ((a)this.l.get(n2)).k();
                if (e3.ordinal() > e2.ordinal()) {
                    e2 = e3;
                }
                ++n2;
            }
        }
        return e2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    Bitmap a() throws IOException {
        Object object;
        Bitmap bitmap;
        if (p.a(this.h)) {
            bitmap = this.d.a(this.f);
            if (bitmap != null) {
                this.e.a();
                this.o = t.d.a;
                if (!this.b.l) return bitmap;
                ag.a("Hunter", "decoded", this.g.a(), "from cache");
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        w w2 = this.g;
        int n2 = this.r == 0 ? q.c.d : this.i;
        w2.c = n2;
        y.a a2 = this.j.a(this.g, this.i);
        if (a2 != null) {
            this.o = a2.c();
            this.q = a2.d();
            bitmap = a2.a();
            if (bitmap == null) {
                InputStream inputStream = a2.b();
                try {
                    Bitmap bitmap2 = c.a(inputStream, this.g);
                    bitmap = bitmap2;
                }
                finally {
                    ag.a(inputStream);
                }
            }
        }
        if (bitmap == null) return bitmap;
        if (this.b.l) {
            ag.a("Hunter", "decoded", this.g.a());
        }
        this.e.a(bitmap);
        if (!this.g.e()) {
            if (this.q == 0) return bitmap;
        }
        Object object2 = object = t;
        // MONITORENTER : object2
        if (this.g.f() || this.q != 0) {
            bitmap = c.a(this.g, bitmap, this.q);
            if (this.b.l) {
                ag.a("Hunter", "transformed", this.g.a());
            }
        }
        if (this.g.g()) {
            bitmap = c.a(this.g.g, bitmap);
            if (this.b.l) {
                ag.a("Hunter", "transformed", this.g.a(), "from custom transformations");
            }
        }
        // MONITOREXIT : object2
        if (bitmap == null) return bitmap;
        this.e.b(bitmap);
        return bitmap;
    }

    void a(a a2) {
        t.e e2;
        boolean bl = this.b.l;
        w w2 = a2.b;
        if (this.k == null) {
            this.k = a2;
            if (bl) {
                String string;
                String string2;
                String string3;
                String string4;
                if (this.l != null && !this.l.isEmpty()) {
                    string4 = "Hunter";
                    string2 = "joined";
                    string3 = w2.a();
                    string = ag.a(this, "to ");
                } else {
                    string4 = "Hunter";
                    string2 = "joined";
                    string3 = w2.a();
                    string = "to empty hunter";
                }
                ag.a(string4, string2, string3, string);
            }
            return;
        }
        if (this.l == null) {
            this.l = new ArrayList(3);
        }
        this.l.add((Object)a2);
        if (bl) {
            ag.a("Hunter", "joined", w2.a(), ag.a(this, "to "));
        }
        if ((e2 = a2.k()).ordinal() > this.s.ordinal()) {
            this.s = e2;
        }
    }

    boolean a(boolean bl, NetworkInfo networkInfo) {
        boolean bl2 = this.r > 0;
        if (!bl2) {
            return false;
        }
        --this.r;
        return this.j.a(bl, networkInfo);
    }

    void b(a a2) {
        boolean bl;
        if (this.k == a2) {
            this.k = null;
            bl = true;
        } else {
            bl = this.l != null ? this.l.remove((Object)a2) : false;
        }
        if (bl && a2.k() == this.s) {
            this.s = this.o();
        }
        if (this.b.l) {
            ag.a("Hunter", "removed", a2.b.a(), ag.a(this, "from "));
        }
    }

    boolean b() {
        boolean bl;
        block5 : {
            block6 : {
                a a2 = this.k;
                bl = false;
                if (a2 != null) break block5;
                if (this.l == null) break block6;
                boolean bl2 = this.l.isEmpty();
                bl = false;
                if (!bl2) break block5;
            }
            Future<?> future = this.n;
            bl = false;
            if (future != null) {
                boolean bl3 = this.n.cancel(false);
                bl = false;
                if (bl3) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    boolean c() {
        return this.n != null && this.n.isCancelled();
    }

    boolean d() {
        return this.j.b();
    }

    Bitmap e() {
        return this.m;
    }

    String f() {
        return this.f;
    }

    int g() {
        return this.h;
    }

    w h() {
        return this.g;
    }

    a i() {
        return this.k;
    }

    t j() {
        return this.b;
    }

    List<a> k() {
        return this.l;
    }

    Exception l() {
        return this.p;
    }

    t.d m() {
        return this.o;
    }

    t.e n() {
        return this.s;
    }

    /*
     * Exception decompiling
     */
    public void run() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 8[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

}

