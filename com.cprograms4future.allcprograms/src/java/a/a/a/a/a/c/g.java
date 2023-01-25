/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.concurrent.Callable
 *  java.util.concurrent.FutureTask
 */
package a.a.a.a.a.c;

import a.a.a.a.a.c.b;
import a.a.a.a.a.c.e;
import a.a.a.a.a.c.h;
import a.a.a.a.a.c.i;
import a.a.a.a.a.c.k;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class g<V>
extends FutureTask<V>
implements b<k>,
h,
k {
    final Object b;

    public g(Runnable runnable, V v2) {
        super(runnable, v2);
        this.b = this.a((Object)runnable);
    }

    public g(Callable<V> callable) {
        super(callable);
        this.b = this.a(callable);
    }

    public <T extends b<k> & h> T a() {
        return (T)((b)this.b);
    }

    protected <T extends b<k> & h> T a(Object object) {
        if (i.a(object)) {
            return (T)((b)object);
        }
        return (T)new i();
    }

    public void a(k k2) {
        ((b)((Object)((h)this.a()))).c(k2);
    }

    @Override
    public void a(Throwable throwable) {
        ((k)((Object)((h)this.a()))).a(throwable);
    }

    @Override
    public e b() {
        return ((h)this.a()).b();
    }

    @Override
    public void b(boolean bl) {
        ((k)((Object)((h)this.a()))).b(bl);
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((k)object);
    }

    @Override
    public boolean c() {
        return ((b)((Object)((h)this.a()))).c();
    }

    public int compareTo(Object object) {
        return ((h)this.a()).compareTo(object);
    }

    @Override
    public boolean f() {
        return ((k)((Object)((h)this.a()))).f();
    }
}

