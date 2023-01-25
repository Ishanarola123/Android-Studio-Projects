/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Type
 */
package com.google.a;

import com.google.a.b.j;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.k;
import com.google.a.l;
import com.google.a.r;
import com.google.a.s;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Type;

final class v<T>
extends w<T> {
    private final s<T> a;
    private final k<T> b;
    private final f c;
    private final com.google.a.c.a<T> d;
    private final x e;
    private w<T> f;

    v(s<T> s2, k<T> k2, f f2, com.google.a.c.a<T> a2, x x2) {
        this.a = s2;
        this.b = k2;
        this.c = f2;
        this.d = a2;
        this.e = x2;
    }

    public static x a(com.google.a.c.a<?> a2, Object object) {
        return new a(object, a2, false, null);
    }

    private w<T> b() {
        w<T> w2 = this.f;
        if (w2 != null) {
            return w2;
        }
        w<T> w3 = this.c.a(this.e, this.d);
        this.f = w3;
        return w3;
    }

    public static x b(com.google.a.c.a<?> a2, Object object) {
        boolean bl = a2.b() == a2.a();
        return new a(object, a2, bl, null);
    }

    @Override
    public void a(c c2, T t2) throws IOException {
        if (this.a == null) {
            this.b().a(c2, t2);
            return;
        }
        if (t2 == null) {
            c2.f();
            return;
        }
        j.a(this.a.a(t2, this.d.b(), this.c.b), c2);
    }

    @Override
    public T b(com.google.a.d.a a2) throws IOException {
        if (this.b == null) {
            return this.b().b(a2);
        }
        l l2 = j.a(a2);
        if (l2.j()) {
            return null;
        }
        return this.b.b(l2, this.d.b(), this.c.a);
    }

    private static class a
    implements x {
        private final com.google.a.c.a<?> a;
        private final boolean b;
        private final Class<?> c;
        private final s<?> d;
        private final k<?> e;

        a(Object object, com.google.a.c.a<?> a2, boolean bl, Class<?> class_) {
            s s2 = object instanceof s ? (s)object : null;
            this.d = s2;
            boolean bl2 = object instanceof k;
            k k2 = null;
            if (bl2) {
                k2 = (k)object;
            }
            this.e = k2;
            boolean bl3 = this.d != null || this.e != null;
            com.google.a.b.a.a(bl3);
            this.a = a2;
            this.b = bl;
            this.c = class_;
        }

        @Override
        public <T> w<T> a(f f2, com.google.a.c.a<T> a2) {
            boolean bl = this.a != null ? this.a.equals(a2) || this.b && this.a.b() == a2.a() : this.c.isAssignableFrom(a2.a());
            if (bl) {
                v v2 = new v(this.d, this.e, f2, a2, this);
                return v2;
            }
            return null;
        }
    }

}

