/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.twitter.sdk.android.core.internal.oauth;

import com.google.a.a.c;
import com.twitter.sdk.android.core.internal.oauth.e;

public class a
extends e {
    @c(a="guest_token")
    private final String b;

    public a(String string, String string2, String string3) {
        super(string, string2);
        this.b = string3;
    }

    public String a() {
        return this.b;
    }

    @Override
    public boolean b() {
        return System.currentTimeMillis() >= 10800000L + this.a;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            if (!super.equals(object)) {
                return false;
            }
            a a2 = (a)object;
            return !(this.b != null ? !this.b.equals((Object)a2.b) : a2.b != null);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = 31 * super.hashCode();
        int n3 = this.b != null ? this.b.hashCode() : 0;
        return n2 + n3;
    }
}

