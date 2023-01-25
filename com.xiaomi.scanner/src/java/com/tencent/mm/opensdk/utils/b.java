/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.security.MessageDigest
 */
package com.tencent.mm.opensdk.utils;

import java.security.MessageDigest;

public final class b {
    public static final String c(byte[] arrby) {
        char[] arrc = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
        messageDigest.update(arrby);
        byte[] arrby2 = messageDigest.digest();
        int n2 = arrby2.length;
        char[] arrc2 = new char[n2 * 2];
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = arrby2[i2];
            int n4 = n3 + 1;
            arrc2[n3] = arrc[15 & by >>> 4];
            n3 = n4 + 1;
            arrc2[n4] = arrc[by & 15];
        }
        try {
            String string2 = new String(arrc2);
            return string2;
        }
        catch (Exception exception) {
            return null;
        }
    }
}

