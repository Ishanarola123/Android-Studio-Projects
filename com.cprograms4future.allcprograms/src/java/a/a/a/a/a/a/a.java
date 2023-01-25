/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 */
package a.a.a.a.a.a;

import a.a.a.a.a.a.c;
import a.a.a.a.a.a.d;
import android.content.Context;

public abstract class a<T>
implements c<T> {
    private final c<T> a;

    public a(c<T> c2) {
        this.a = c2;
    }

    private void b(Context context, T t2) {
        if (t2 != null) {
            this.a(context, t2);
            return;
        }
        throw new NullPointerException();
    }

    protected abstract T a(Context var1);

    @Override
    public final T a(Context context, d<T> d2) throws Exception {
        a a2 = this;
        synchronized (a2) {
            T t2;
            block5 : {
                t2 = this.a(context);
                if (t2 != null) break block5;
                T t3 = this.a != null ? this.a.a(context, d2) : d2.a(context);
                t2 = t3;
                this.b(context, t2);
            }
            return t2;
        }
    }

    protected abstract void a(Context var1, T var2);
}

