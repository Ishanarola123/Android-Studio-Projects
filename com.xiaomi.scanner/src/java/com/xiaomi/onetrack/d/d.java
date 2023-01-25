/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
package com.xiaomi.onetrack.d;

import android.text.TextUtils;
import com.xiaomi.onetrack.h.o;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class d {
    private static final String a = "DigestUtil";
    private static final char[] b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] arrby, boolean bl) {
        char[] arrc = bl ? b : c;
        return new String(d.a(arrby, arrc));
    }

    private static MessageDigest a() {
        return d.a("MD5");
    }

    static MessageDigest a(String string2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)string2);
            return messageDigest;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException.getMessage());
        }
    }

    private static byte[] a(String string2, String string3) {
        if (string2 == null) {
            return null;
        }
        try {
            byte[] arrby = string2.getBytes(string3);
            return arrby;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return null;
        }
    }

    public static byte[] a(byte[] arrby) {
        return d.a().digest(arrby);
    }

    private static char[] a(byte[] arrby, char[] arrc) {
        int n2 = arrby.length;
        char[] arrc2 = new char[n2 << 1];
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = n3 + 1;
            arrc2[n3] = arrc[(240 & arrby[i2]) >>> 4];
            n3 = n4 + 1;
            arrc2[n4] = arrc[15 & arrby[i2]];
        }
        return arrc2;
    }

    public static String b(byte[] arrby) {
        return d.a(d.a(arrby), true);
    }

    private static MessageDigest b() {
        return d.a("SHA-256");
    }

    public static byte[] b(String string2) {
        return d.a(d.a(string2, "UTF-8"));
    }

    public static String c(String string2) {
        return d.a(d.b(string2), true);
    }

    private static MessageDigest c() {
        return d.a("SHA1");
    }

    public static byte[] c(byte[] arrby) {
        return d.b().digest(arrby);
    }

    public static String d(String string2) {
        return d.a(d.g(string2), true);
    }

    public static String d(byte[] arrby) {
        return d.a(d.c(arrby), true);
    }

    public static String e(String string2) {
        return d.a(d.f(string2), true);
    }

    public static String e(byte[] arrby) {
        String string2;
        block3 : {
            if (arrby != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
                    messageDigest.update(arrby);
                    string2 = String.format((String)"%1$032X", (Object[])new Object[]{new BigInteger(1, messageDigest.digest())});
                    break block3;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("getMD5 exception: ");
                    stringBuilder.append((Object)exception);
                    o.b(a, stringBuilder.toString());
                }
            }
            string2 = "";
        }
        return string2.toLowerCase();
    }

    public static byte[] f(String string2) {
        return d.c(d.a(string2, "UTF-8"));
    }

    public static byte[] g(String string2) {
        return d.c().digest(d.a(string2, "UTF-8"));
    }

    public static String h(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return "";
        }
        return d.e(string2.getBytes());
    }
}

