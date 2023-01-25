/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.twitter.sdk.android.core.services.a;

public class a {
    public final double a;
    public final double b;
    public final int c;
    public final a d;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(",");
        stringBuilder.append(this.b);
        stringBuilder.append(",");
        stringBuilder.append(this.c);
        stringBuilder.append(this.d.c);
        return stringBuilder.toString();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("mi");
        public static final /* enum */ a b = new a("km");
        private static final /* synthetic */ a[] d;
        public final String c;

        static {
            a[] arra = new a[]{a, b};
            d = arra;
        }

        private a(String string2) {
            this.c = string2;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])d.clone();
        }
    }

}

