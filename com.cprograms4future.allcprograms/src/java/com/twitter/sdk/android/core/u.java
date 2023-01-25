/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core;

import a.a.a.a.a.f.e;
import a.a.a.a.c;
import android.text.TextUtils;
import com.google.a.f;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.p;

public class u
extends j<p> {
    @com.google.a.a.c(a="user_name")
    private final String a;

    public u(p p2, long l2, String string) {
        super(p2, l2);
        this.a = string;
    }

    public String c() {
        return this.a;
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
            u u2 = (u)object;
            if (this.a != null) {
                return this.a.equals((Object)u2.a);
            }
            return u2.a == null;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = 31 * super.hashCode();
        int n3 = this.a != null ? this.a.hashCode() : 0;
        return n2 + n3;
    }

    static class a
    implements e<u> {
        private final f a = new f();

        public u a(String string) {
            if (!TextUtils.isEmpty((CharSequence)string)) {
                try {
                    u u2 = this.a.a(string, u.class);
                    return u2;
                }
                catch (Exception exception) {
                    c.h().a("Twitter", exception.getMessage());
                }
            }
            return null;
        }

        @Override
        public String a(u u2) {
            if (u2 != null && u2.a() != null) {
                try {
                    String string = this.a.b(u2);
                    return string;
                }
                catch (Exception exception) {
                    c.h().a("Twitter", exception.getMessage());
                }
            }
            return "";
        }

        @Override
        public /* synthetic */ Object b(String string) {
            return this.a(string);
        }
    }

}

