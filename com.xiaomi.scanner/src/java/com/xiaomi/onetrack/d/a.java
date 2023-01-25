/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Key
 *  javax.crypto.Cipher
 *  javax.crypto.KeyGenerator
 *  javax.crypto.SecretKey
 *  javax.crypto.spec.SecretKeySpec
 */
package com.xiaomi.onetrack.d;

import android.util.Base64;
import com.xiaomi.onetrack.d.b;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.h.l;
import com.xiaomi.onetrack.h.o;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class a {
    private static final String a = "AES";
    private static final String b = "AES/ECB/PKCS5Padding";
    private static final String c = "AES";
    private static KeyGenerator d;

    static {
        try {
            d = KeyGenerator.getInstance((String)"AES");
            d.init(128);
        }
        catch (Exception exception) {
            o.b(o.a("AES"), "AesUtil e", exception);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(b.a);
        char[] arrc = stringBuilder.toString().toCharArray();
        int n2 = 0;
        while (n2 < arrc.length) {
            int n3 = 0;
            do {
                try {
                    if (n3 >= -1 + arrc.length) break;
                    if (arrc[n2] < arrc[n3]) {
                        char c2 = arrc[n2];
                        arrc[n2] = arrc[n3];
                        arrc[n3] = c2;
                    }
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("encodeFromSalt ");
                    stringBuilder2.append("");
                    o.b("AES", stringBuilder2.toString());
                    return "";
                }
                ++n3;
            } while (true);
            ++n2;
        }
        return d.h(new String(arrc));
    }

    public static String a(String string2, String string3) {
        return l.a(a.e(string2, string3));
    }

    public static byte[] a() {
        return d.generateKey().getEncoded();
    }

    private static byte[] a(byte[] arrby, String string2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a.b(string2), "AES");
            Cipher cipher = Cipher.getInstance((String)b);
            cipher.init(2, (Key)secretKeySpec);
            byte[] arrby2 = cipher.doFinal(arrby);
            return arrby2;
        }
        catch (Exception exception) {
            o.b(o.a("AES"), "decrypt exception:", exception);
            return null;
        }
    }

    public static byte[] a(byte[] arrby, byte[] arrby2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(arrby2, "AES");
            Cipher cipher = Cipher.getInstance((String)b);
            cipher.init(1, (Key)secretKeySpec);
            byte[] arrby3 = cipher.doFinal(arrby);
            return arrby3;
        }
        catch (Exception exception) {
            o.b(o.a("AES"), "encrypt exception:", exception);
            return null;
        }
    }

    public static String b(String string2, String string3) {
        return Base64.encodeToString((byte[])a.e(string2, string3), (int)10);
    }

    private static byte[] b(String string2) {
        if (string2 != null) {
            return string2.getBytes();
        }
        return null;
    }

    public static byte[] b(byte[] arrby, byte[] arrby2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(arrby2, "AES");
            Cipher cipher = Cipher.getInstance((String)b);
            cipher.init(2, (Key)secretKeySpec);
            byte[] arrby3 = cipher.doFinal(arrby);
            return arrby3;
        }
        catch (Exception exception) {
            o.b("AES", "decrypt exception:", exception);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("content len=");
            stringBuilder.append(arrby.length);
            stringBuilder.append(", passwd len=");
            stringBuilder.append(arrby2.length);
            o.b("AES", stringBuilder.toString());
            return null;
        }
    }

    public static String c(String string2, String string3) {
        return new String(a.a(a.c(string2), string3));
    }

    private static byte[] c(String string2) {
        if (string2 != null && string2.length() >= 1) {
            byte[] arrby = new byte[string2.length() / 2];
            for (int i2 = 0; i2 < string2.length() / 2; ++i2) {
                int n2 = i2 * 2;
                int n3 = n2 + 1;
                int n4 = Integer.parseInt((String)string2.substring(n2, n3), (int)16);
                arrby[i2] = (byte)(Integer.parseInt((String)string2.substring(n3, n2 + 2), (int)16) + n4 * 16);
            }
            return arrby;
        }
        return null;
    }

    public static String d(String string2, String string3) {
        return new String(a.a(Base64.decode((String)string2, (int)10), string3));
    }

    private static byte[] e(String string2, String string3) {
        return a.a(string2.getBytes(), string3.getBytes());
    }
}

