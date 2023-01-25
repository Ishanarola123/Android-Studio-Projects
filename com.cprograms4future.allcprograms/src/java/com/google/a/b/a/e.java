/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.google.a.b.a;

import com.google.a.b.a.e;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.i;
import com.google.a.l;
import com.google.a.n;
import com.google.a.o;
import com.google.a.q;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class e
extends a {
    private static final Reader b = new Reader(){

        public void close() throws IOException {
            throw new AssertionError();
        }

        public int read(char[] arrc, int n2, int n3) throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object c = new Object();
    private final List<Object> d = new ArrayList();

    public e(l l2) {
        super(b);
        this.d.add((Object)l2);
    }

    private void a(b b2) throws IOException {
        if (this.f() == b2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected ");
        stringBuilder.append((Object)b2);
        stringBuilder.append(" but was ");
        stringBuilder.append((Object)this.f());
        throw new IllegalStateException(stringBuilder.toString());
    }

    private Object u() {
        return this.d.get(-1 + this.d.size());
    }

    private Object v() {
        return this.d.remove(-1 + this.d.size());
    }

    @Override
    public void a() throws IOException {
        this.a(b.a);
        i i2 = (i)this.u();
        this.d.add(i2.iterator());
    }

    @Override
    public void b() throws IOException {
        this.a(b.b);
        this.v();
        this.v();
    }

    @Override
    public void c() throws IOException {
        this.a(b.c);
        o o2 = (o)this.u();
        this.d.add((Object)o2.o().iterator());
    }

    @Override
    public void close() throws IOException {
        this.d.clear();
        this.d.add(c);
    }

    @Override
    public void d() throws IOException {
        this.a(b.d);
        this.v();
        this.v();
    }

    @Override
    public boolean e() throws IOException {
        b b2 = this.f();
        return b2 != b.d && b2 != b.b;
    }

    @Override
    public b f() throws IOException {
        if (this.d.isEmpty()) {
            return b.j;
        }
        Object object = this.u();
        if (object instanceof Iterator) {
            boolean bl = this.d.get(-2 + this.d.size()) instanceof o;
            Iterator iterator = (Iterator)object;
            if (iterator.hasNext()) {
                if (bl) {
                    return b.e;
                }
                this.d.add(iterator.next());
                return this.f();
            }
            if (bl) {
                return b.d;
            }
            return b.b;
        }
        if (object instanceof o) {
            return b.c;
        }
        if (object instanceof i) {
            return b.a;
        }
        if (object instanceof q) {
            q q2 = (q)object;
            if (q2.q()) {
                return b.f;
            }
            if (q2.o()) {
                return b.h;
            }
            if (q2.p()) {
                return b.g;
            }
            throw new AssertionError();
        }
        if (object instanceof n) {
            return b.i;
        }
        if (object == c) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    @Override
    public String g() throws IOException {
        this.a(b.e);
        Map.Entry entry = (Map.Entry)((Iterator)this.u()).next();
        this.d.add(entry.getValue());
        return (String)entry.getKey();
    }

    @Override
    public String h() throws IOException {
        b b2 = this.f();
        if (b2 != b.f && b2 != b.g) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)b.f);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        return ((q)this.v()).b();
    }

    @Override
    public boolean i() throws IOException {
        this.a(b.h);
        return ((q)this.v()).f();
    }

    @Override
    public void j() throws IOException {
        this.a(b.i);
        this.v();
    }

    @Override
    public double k() throws IOException {
        b b2 = this.f();
        if (b2 != b.g && b2 != b.f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)b.g);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        double d2 = ((q)this.u()).c();
        if (!this.p() && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d2);
            throw new NumberFormatException(stringBuilder.toString());
        }
        this.v();
        return d2;
    }

    @Override
    public long l() throws IOException {
        b b2 = this.f();
        if (b2 != b.g && b2 != b.f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)b.g);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        long l2 = ((q)this.u()).d();
        this.v();
        return l2;
    }

    @Override
    public int m() throws IOException {
        b b2 = this.f();
        if (b2 != b.g && b2 != b.f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)b.g);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        int n2 = ((q)this.u()).e();
        this.v();
        return n2;
    }

    @Override
    public void n() throws IOException {
        if (this.f() == b.e) {
            this.g();
            return;
        }
        this.v();
    }

    public void o() throws IOException {
        this.a(b.e);
        Map.Entry entry = (Map.Entry)((Iterator)this.u()).next();
        this.d.add(entry.getValue());
        this.d.add((Object)new q((String)entry.getKey()));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

