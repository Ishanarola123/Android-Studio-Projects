/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.i$1
 *  d.i$2
 *  java.io.IOException
 *  java.lang.Iterable
 *  java.lang.Object
 */
package d;

import d.i;
import d.k;
import java.io.IOException;

abstract class i<T> {
    i() {
    }

    final i<Iterable<T>> a() {
        return new 1(this);
    }

    abstract void a(k var1, T var2) throws IOException;

    final i<Object> b() {
        return new 2(this);
    }
}

