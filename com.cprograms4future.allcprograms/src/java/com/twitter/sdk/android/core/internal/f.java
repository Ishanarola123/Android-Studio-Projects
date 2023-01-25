/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.a.r;

public final class f {
    public static String a(r r2, a a2) {
        if (r2 != null && r2.c != null) {
            String string = r2.c;
            if (a2 != null) {
                if (string == null) {
                    return string;
                }
                switch (1.a[a2.ordinal()]) {
                    default: {
                        return string;
                    }
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                }
                string = string.replace((CharSequence)a.a.a(), (CharSequence)a2.a());
            }
            return string;
        }
        return null;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("_normal");
        public static final /* enum */ a b = new a("_bigger");
        public static final /* enum */ a c = new a("_mini");
        public static final /* enum */ a d = new a("_original");
        public static final /* enum */ a e = new a("_reasonably_small");
        private static final /* synthetic */ a[] g;
        private final String f;

        static {
            a[] arra = new a[]{a, b, c, d, e};
            g = arra;
        }

        private a(String string2) {
            this.f = string2;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])g.clone();
        }

        String a() {
            return this.f;
        }
    }

}

