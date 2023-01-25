/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package a.a.a.a.a.a;

import a.a.a.a.a.a.a;
import a.a.a.a.a.a.c;
import android.content.Context;

public class b<T>
extends a<T> {
    private T a;

    public b() {
        this(null);
    }

    public b(c<T> c2) {
        super(c2);
    }

    @Override
    protected T a(Context context) {
        return this.a;
    }

    @Override
    protected void a(Context context, T t) {
        this.a = t;
    }
}

