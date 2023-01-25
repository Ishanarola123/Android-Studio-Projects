/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.twitter.sdk.android.core;

import a.a.a.a.a.f.b;
import a.a.a.a.a.f.d;
import a.a.a.a.a.f.e;
import android.content.SharedPreferences;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.k;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class g<T extends j>
implements k<T> {
    private final b a;
    private final e<T> b;
    private final ConcurrentHashMap<Long, T> c;
    private final ConcurrentHashMap<Long, d<T>> d;
    private final d<T> e;
    private final AtomicReference<T> f;
    private final String g;
    private volatile boolean h = true;

    public g(b b2, e<T> e2, String string, String string2) {
        this(b2, e2, new ConcurrentHashMap(1), new ConcurrentHashMap(1), new d<T>(b2, e2, string), string2);
    }

    g(b b2, e<T> e2, ConcurrentHashMap<Long, T> concurrentHashMap, ConcurrentHashMap<Long, d<T>> concurrentHashMap2, d<T> d2, String string) {
        this.a = b2;
        this.b = e2;
        this.c = concurrentHashMap;
        this.d = concurrentHashMap2;
        this.e = d2;
        this.f = new AtomicReference();
        this.g = string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(long l2, T t2, boolean bl) {
        this.c.put((Object)l2, t2);
        d<T> d2 = (d<T>)this.d.get((Object)l2);
        if (d2 == null) {
            d2 = new d<T>(this.a, this.b, this.b(l2));
            this.d.putIfAbsent((Object)l2, d2);
        }
        d2.a(t2);
        j j2 = (j)this.f.get();
        if (j2 != null && j2.b() != l2 && !bl) {
            return;
        }
        g g2 = this;
        synchronized (g2) {
            this.f.compareAndSet((Object)j2, t2);
            this.e.a(t2);
            return;
        }
    }

    private void d() {
        g g2 = this;
        synchronized (g2) {
            if (this.h) {
                this.f();
                this.e();
                this.h = false;
            }
            return;
        }
    }

    private void e() {
        for (Map.Entry entry : this.a.a().getAll().entrySet()) {
            j j2;
            if (!this.a((String)entry.getKey()) || (j2 = (j)this.b.b((String)entry.getValue())) == null) continue;
            this.a(j2.b(), j2, false);
        }
    }

    private void f() {
        j j2 = (j)this.e.a();
        if (j2 != null) {
            this.a(j2.b(), j2, false);
        }
    }

    @Override
    public T a(long l2) {
        this.a();
        return (T)((j)this.c.get((Object)l2));
    }

    void a() {
        if (this.h) {
            this.d();
        }
    }

    @Override
    public void a(T t2) {
        if (t2 != null) {
            this.a();
            this.a(((j)t2).b(), t2, true);
            return;
        }
        throw new IllegalArgumentException("Session must not be null!");
    }

    boolean a(String string) {
        return string.startsWith(this.g);
    }

    @Override
    public T b() {
        this.a();
        return (T)((j)this.f.get());
    }

    String b(long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.g);
        stringBuilder.append("_");
        stringBuilder.append(l2);
        return stringBuilder.toString();
    }

    @Override
    public Map<Long, T> c() {
        this.a();
        return Collections.unmodifiableMap(this.c);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c(long l2) {
        this.a();
        if (this.f.get() != null && ((j)this.f.get()).b() == l2) {
            g g2 = this;
            synchronized (g2) {
                this.f.set(null);
                this.e.clear();
            }
        }
        this.c.remove((Object)l2);
        d d2 = (d)this.d.remove((Object)l2);
        if (d2 != null) {
            d2.clear();
        }
    }
}

