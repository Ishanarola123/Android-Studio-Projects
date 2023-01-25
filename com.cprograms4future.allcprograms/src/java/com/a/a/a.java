/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.ReferenceQueue
 *  java.lang.ref.WeakReference
 */
package com.a.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.a.a.t;
import com.a.a.w;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class a<T> {
    final t a;
    final w b;
    final WeakReference<T> c;
    final boolean d;
    final int e;
    final int f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    a(t t2, T t3, w w2, int n2, int n3, int n4, Drawable drawable, String string, Object object, boolean bl) {
        this.a = t2;
        this.b = w2;
        a<Object> a2 = t3 == null ? null : new a<Object>(this, t3, t2.i);
        this.c = a2;
        this.e = n2;
        this.f = n3;
        this.d = bl;
        this.g = n4;
        this.h = drawable;
        this.i = string;
        if (object == null) {
            object = this;
        }
        this.j = object;
    }

    abstract void a();

    abstract void a(Bitmap var1, t.d var2);

    void b() {
        this.l = true;
    }

    w c() {
        return this.b;
    }

    T d() {
        if (this.c == null) {
            return null;
        }
        return (T)this.c.get();
    }

    String e() {
        return this.i;
    }

    boolean f() {
        return this.l;
    }

    boolean g() {
        return this.k;
    }

    int h() {
        return this.e;
    }

    int i() {
        return this.f;
    }

    t j() {
        return this.a;
    }

    t.e k() {
        return this.b.r;
    }

    Object l() {
        return this.j;
    }

    static class a<M>
    extends WeakReference<M> {
        final a a;

        public a(a a2, M m2, ReferenceQueue<? super M> referenceQueue) {
            super(m2, referenceQueue);
            this.a = a2;
        }
    }

}

