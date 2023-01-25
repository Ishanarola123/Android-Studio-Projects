/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core;

import com.google.a.a.c;
import com.twitter.sdk.android.core.a;

public class j<T extends a> {
    @c(a="auth_token")
    private final T a;
    @c(a="id")
    private final long b;

    public j(T t2, long l2) {
        if (t2 != null) {
            this.a = t2;
            this.b = l2;
            return;
        }
        throw new IllegalArgumentException("AuthToken must not be null.");
    }

    public T a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            j j2 = (j)object;
            if (this.b != j2.b) {
                return false;
            }
            if (this.a != null) {
                return this.a.equals(j2.a);
            }
            return j2.a == null;
        }
        return false;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        return n2 * 31 + (int)(this.b ^ this.b >>> 32);
    }
}

