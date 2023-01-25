/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package d;

import b.ab;
import b.ac;
import b.r;

public final class l<T> {
    private final ab a;
    private final T b;
    private final ac c;

    private l(ab ab2, T t2, ac ac2) {
        this.a = ab2;
        this.b = t2;
        this.c = ac2;
    }

    public static <T> l<T> a(ac ac2, ab ab2) {
        if (ac2 != null) {
            if (ab2 != null) {
                if (!ab2.c()) {
                    return new l<Object>(ab2, null, ac2);
                }
                throw new IllegalArgumentException("rawResponse should not be successful response");
            }
            throw new NullPointerException("rawResponse == null");
        }
        throw new NullPointerException("body == null");
    }

    public static <T> l<T> a(T t2, ab ab2) {
        if (ab2 != null) {
            if (ab2.c()) {
                return new l<T>(ab2, t2, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        throw new NullPointerException("rawResponse == null");
    }

    public int a() {
        return this.a.b();
    }

    public r b() {
        return this.a.e();
    }

    public boolean c() {
        return this.a.c();
    }

    public T d() {
        return this.b;
    }

    public ac e() {
        return this.c;
    }
}

