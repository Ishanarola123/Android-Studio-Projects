/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.security.Key
 *  java.security.KeyFactory
 *  java.security.PublicKey
 *  java.security.interfaces.RSAPublicKey
 *  java.security.spec.KeySpec
 *  java.security.spec.X509EncodedKeySpec
 *  javax.crypto.Cipher
 */
package com.xiaomi.onetrack.d;

import android.os.Build;
import com.xiaomi.onetrack.d.c;
import com.xiaomi.onetrack.h.o;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class e {
    public static final String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiH0r18h2G+lOzZz0mSZT9liZY\r6ibWUv/biAioduf0zuRbWUYGb3pHobyCOaw2LpVnlf8CeCYtbRJhxL9skOyoU1Qa\rwGtoJzvVR4GbCo1MBTmZ8XThMprr0unRfzsu9GNV4+twciOdS2cNJB7INcwAYBFQ\r9vKpgXFoEjWRhIgwMwIDAQAB\r";
    private static final String b = "RsaUtils";
    private static final String c = "RSA/ECB/PKCS1Padding";
    private static final String d = "BC";
    private static final String e = "RSA";

    private static RSAPublicKey a(String string2) throws Exception {
        KeyFactory keyFactory = Build.VERSION.SDK_INT >= 28 ? KeyFactory.getInstance((String)e) : KeyFactory.getInstance((String)e, (String)d);
        return (RSAPublicKey)keyFactory.generatePublic((KeySpec)new X509EncodedKeySpec(c.a(string2)));
    }

    public static byte[] a(byte[] arrby) throws Exception {
        try {
            RSAPublicKey rSAPublicKey = e.a(a);
            Cipher cipher = Cipher.getInstance((String)c, (String)d);
            cipher.init(1, (Key)rSAPublicKey);
            byte[] arrby2 = cipher.doFinal(arrby);
            return arrby2;
        }
        catch (Exception exception) {
            o.b(o.a(b), "RsaUtils encrypt exception:", exception);
            return null;
        }
    }

    public static byte[] a(byte[] arrby, byte[] arrby2) {
        try {
            RSAPublicKey rSAPublicKey = e.b(arrby);
            Cipher cipher = Cipher.getInstance((String)c);
            cipher.init(1, (Key)rSAPublicKey);
            byte[] arrby3 = cipher.doFinal(arrby2);
            return arrby3;
        }
        catch (Exception exception) {
            o.b(b, "RsaUtil encrypt exception:", exception);
            return null;
        }
    }

    private static RSAPublicKey b(byte[] arrby) throws Exception {
        return (RSAPublicKey)KeyFactory.getInstance((String)e).generatePublic((KeySpec)new X509EncodedKeySpec(arrby));
    }
}

