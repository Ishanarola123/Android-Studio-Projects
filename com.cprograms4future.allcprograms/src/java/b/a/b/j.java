/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.a.b;

import b.a.g;
import b.ab;
import b.r;
import b.z;

public final class j {
    static final String a = g.a().b();
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("-Sent-Millis");
        b = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(a);
        stringBuilder2.append("-Received-Millis");
        c = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(a);
        stringBuilder3.append("-Selected-Protocol");
        d = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(a);
        stringBuilder4.append("-Response-Source");
        e = stringBuilder4.toString();
    }

    public static long a(ab ab2) {
        return j.a(ab2.e());
    }

    public static long a(r r2) {
        return j.b(r2.a("Content-Length"));
    }

    public static long a(z z2) {
        return j.a(z2.c());
    }

    static boolean a(String string) {
        return !"Connection".equalsIgnoreCase(string) && !"Keep-Alive".equalsIgnoreCase(string) && !"Proxy-Authenticate".equalsIgnoreCase(string) && !"Proxy-Authorization".equalsIgnoreCase(string) && !"TE".equalsIgnoreCase(string) && !"Trailers".equalsIgnoreCase(string) && !"Transfer-Encoding".equalsIgnoreCase(string) && !"Upgrade".equalsIgnoreCase(string);
    }

    private static long b(String string) {
        if (string == null) {
            return -1L;
        }
        try {
            long l2 = Long.parseLong((String)string);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            return -1L;
        }
    }
}

