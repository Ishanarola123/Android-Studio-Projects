/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 */
package com.tencent.mm.opensdk.channel.a;

public final class b {
    public static byte[] a(String string2, int n2, String string3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (string2 != null) {
            stringBuffer.append(string2);
        }
        stringBuffer.append(n2);
        stringBuffer.append(string3);
        stringBuffer.append("mMcShCsTr");
        return com.tencent.mm.opensdk.utils.b.c(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}

