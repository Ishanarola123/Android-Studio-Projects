/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.widget.ImageView
 *  com.a.a.ad
 *  com.a.a.l
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.a.a.a;
import com.a.a.ac;
import com.a.a.ad;
import com.a.a.ae;
import com.a.a.ag;
import com.a.a.e;
import com.a.a.h;
import com.a.a.l;
import com.a.a.p;
import com.a.a.t;
import com.a.a.u;
import com.a.a.w;
import java.util.concurrent.atomic.AtomicInteger;

public class x {
    private static final AtomicInteger a = new AtomicInteger();
    private final t b;
    private final w.a c;
    private boolean d;
    private boolean e;
    private boolean f = true;
    private int g;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private Object m;

    x() {
        this.b = null;
        this.c = new w.a(null, 0, null);
    }

    x(t t2, Uri uri, int n2) {
        if (!t2.m) {
            this.b = t2;
            this.c = new w.a(uri, n2, t2.j);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    private w a(long l2) {
        w w2;
        int n2 = a.getAndIncrement();
        w w3 = this.c.d();
        w3.a = n2;
        w3.b = l2;
        boolean bl = this.b.l;
        if (bl) {
            ag.a("Main", "created", w3.b(), w3.toString());
        }
        if ((w2 = this.b.a(w3)) != w3) {
            w2.a = n2;
            w2.b = l2;
            if (bl) {
                String string = w2.a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("into ");
                stringBuilder.append((Object)w2);
                ag.a("Main", "changed", string, stringBuilder.toString());
            }
        }
        return w2;
    }

    private Drawable d() {
        if (this.g != 0) {
            return this.b.c.getResources().getDrawable(this.g);
        }
        return this.k;
    }

    public x a() {
        this.e = true;
        return this;
    }

    public x a(int n2) {
        if (n2 != 0) {
            if (this.l == null) {
                this.h = n2;
                return this;
            }
            throw new IllegalStateException("Error image already set.");
        }
        throw new IllegalArgumentException("Error image resource invalid.");
    }

    public x a(int n2, int n3) {
        this.c.a(n2, n3);
        return this;
    }

    public x a(Drawable drawable) {
        if (this.f) {
            if (this.g == 0) {
                this.k = drawable;
                return this;
            }
            throw new IllegalStateException("Placeholder image already set.");
        }
        throw new IllegalStateException("Already explicitly declared as no placeholder.");
    }

    public x a(ae ae2) {
        this.c.a(ae2);
        return this;
    }

    public void a(ImageView imageView) {
        this.a(imageView, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(ImageView imageView, e e2) {
        Bitmap bitmap;
        long l2 = System.nanoTime();
        ag.a();
        if (imageView == null) throw new IllegalArgumentException("Target must not be null.");
        if (!this.c.a()) {
            this.b.a(imageView);
            if (!this.f) return;
            u.a(imageView, this.d());
            return;
        }
        if (this.e) {
            if (this.c.b()) throw new IllegalStateException("Fit cannot be used with resize.");
            int n2 = imageView.getWidth();
            int n3 = imageView.getHeight();
            if (n2 != 0 && n3 != 0) {
                this.c.a(n2, n3);
            } else {
                if (this.f) {
                    u.a(imageView, this.d());
                }
                this.b.a(imageView, new h(this, imageView, e2));
                return;
            }
        }
        w w2 = this.a(l2);
        String string = ag.a(w2);
        if (p.a(this.i) && (bitmap = this.b.b(string)) != null) {
            this.b.a(imageView);
            u.a(imageView, this.b.c, bitmap, t.d.a, this.d, this.b.k);
            if (this.b.l) {
                String string2 = w2.b();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("from ");
                stringBuilder.append((Object)t.d.a);
                ag.a("Main", "completed", string2, stringBuilder.toString());
            }
            if (e2 == null) return;
            e2.a();
            return;
        }
        if (this.f) {
            u.a(imageView, this.d());
        }
        l l3 = new l(this.b, imageView, w2, this.i, this.j, this.h, this.l, string, this.m, e2, this.d);
        this.b.a((a)l3);
    }

    public void a(ac ac2) {
        long l2 = System.nanoTime();
        ag.a();
        if (ac2 != null) {
            if (!this.e) {
                Bitmap bitmap;
                if (!this.c.a()) {
                    this.b.a(ac2);
                    boolean bl = this.f;
                    Drawable drawable = null;
                    if (bl) {
                        drawable = this.d();
                    }
                    ac2.b(drawable);
                    return;
                }
                w w2 = this.a(l2);
                String string = ag.a(w2);
                if (p.a(this.i) && (bitmap = this.b.b(string)) != null) {
                    this.b.a(ac2);
                    ac2.a(bitmap, t.d.a);
                    return;
                }
                boolean bl = this.f;
                Drawable drawable = null;
                if (bl) {
                    drawable = this.d();
                }
                ac2.b(drawable);
                ad ad2 = new ad(this.b, ac2, w2, this.i, this.j, this.l, string, this.m, this.h);
                this.b.a((a)ad2);
                return;
            }
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        throw new IllegalArgumentException("Target must not be null.");
    }

    x b() {
        this.e = false;
        return this;
    }

    public x c() {
        this.c.c();
        return this;
    }
}

