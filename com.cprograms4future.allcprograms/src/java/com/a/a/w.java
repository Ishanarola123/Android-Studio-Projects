/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.net.Uri
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 */
package com.a.a;

import android.graphics.Bitmap;
import android.net.Uri;
import com.a.a.ae;
import com.a.a.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class w {
    private static final long s = TimeUnit.SECONDS.toNanos(5L);
    int a;
    long b;
    int c;
    public final Uri d;
    public final int e;
    public final String f;
    public final List<ae> g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final float m;
    public final float n;
    public final float o;
    public final boolean p;
    public final Bitmap.Config q;
    public final t.e r;

    /*
     * Enabled aggressive block sorting
     */
    private w(Uri uri, int n2, String string, List<ae> list, int n3, int n4, boolean bl, boolean bl2, boolean bl3, float f2, float f3, float f4, boolean bl4, Bitmap.Config config, t.e e2) {
        this.d = uri;
        this.e = n2;
        this.f = string;
        List list2 = list == null ? null : Collections.unmodifiableList(list);
        this.g = list2;
        this.h = n3;
        this.i = n4;
        this.j = bl;
        this.k = bl2;
        this.l = bl3;
        this.m = f2;
        this.n = f3;
        this.o = f4;
        this.p = bl4;
        this.q = config;
        this.r = e2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    String a() {
        StringBuilder stringBuilder;
        long l2 = System.nanoTime() - this.b;
        if (l2 > s) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.b());
            stringBuilder.append('+');
            stringBuilder.append(TimeUnit.NANOSECONDS.toSeconds(l2));
            stringBuilder.append('s');
            do {
                return stringBuilder.toString();
                break;
            } while (true);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.b());
        stringBuilder.append('+');
        stringBuilder.append(TimeUnit.NANOSECONDS.toMillis(l2));
        stringBuilder.append("ms");
        return stringBuilder.toString();
    }

    String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[R");
        stringBuilder.append(this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    String c() {
        if (this.d != null) {
            return String.valueOf((Object)this.d.getPath());
        }
        return Integer.toHexString((int)this.e);
    }

    public boolean d() {
        return this.h != 0 || this.i != 0;
        {
        }
    }

    boolean e() {
        return this.f() || this.g();
        {
        }
    }

    boolean f() {
        return this.d() || this.m != 0.0f;
        {
        }
    }

    boolean g() {
        return this.g != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.e > 0) {
            stringBuilder.append(this.e);
        } else {
            stringBuilder.append((Object)this.d);
        }
        if (this.g != null && !this.g.isEmpty()) {
            for (ae ae2 : this.g) {
                stringBuilder.append(' ');
                stringBuilder.append(ae2.a());
            }
        }
        if (this.f != null) {
            stringBuilder.append(" stableKey(");
            stringBuilder.append(this.f);
            stringBuilder.append(')');
        }
        if (this.h > 0) {
            stringBuilder.append(" resize(");
            stringBuilder.append(this.h);
            stringBuilder.append(',');
            stringBuilder.append(this.i);
            stringBuilder.append(')');
        }
        if (this.j) {
            stringBuilder.append(" centerCrop");
        }
        if (this.k) {
            stringBuilder.append(" centerInside");
        }
        if (this.m != 0.0f) {
            stringBuilder.append(" rotation(");
            stringBuilder.append(this.m);
            if (this.p) {
                stringBuilder.append(" @ ");
                stringBuilder.append(this.n);
                stringBuilder.append(',');
                stringBuilder.append(this.o);
            }
            stringBuilder.append(')');
        }
        if (this.q != null) {
            stringBuilder.append(' ');
            stringBuilder.append((Object)this.q);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static final class a {
        private Uri a;
        private int b;
        private String c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private float i;
        private float j;
        private float k;
        private boolean l;
        private List<ae> m;
        private Bitmap.Config n;
        private t.e o;

        a(Uri uri, int n2, Bitmap.Config config) {
            this.a = uri;
            this.b = n2;
            this.n = config;
        }

        public a a(int n2, int n3) {
            if (n2 >= 0) {
                if (n3 >= 0) {
                    if (n3 == 0 && n2 == 0) {
                        throw new IllegalArgumentException("At least one dimension has to be positive number.");
                    }
                    this.d = n2;
                    this.e = n3;
                    return this;
                }
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            throw new IllegalArgumentException("Width must be positive number or 0.");
        }

        public a a(ae ae2) {
            if (ae2 != null) {
                if (ae2.a() != null) {
                    if (this.m == null) {
                        this.m = new ArrayList(2);
                    }
                    this.m.add((Object)ae2);
                    return this;
                }
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
            throw new IllegalArgumentException("Transformation must not be null.");
        }

        boolean a() {
            return this.a != null || this.b != 0;
            {
            }
        }

        boolean b() {
            return this.d != 0 || this.e != 0;
            {
            }
        }

        public a c() {
            if (!this.g) {
                this.f = true;
                return this;
            }
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }

        public w d() {
            if (this.g && this.f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f && this.d == 0 && this.e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (this.g && this.d == 0 && this.e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.o == null) {
                this.o = t.e.b;
            }
            w w2 = new w(this.a, this.b, this.c, this.m, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o);
            return w2;
        }
    }

}

