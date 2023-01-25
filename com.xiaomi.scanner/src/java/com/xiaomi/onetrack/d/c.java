/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 */
package com.xiaomi.onetrack.d;

import com.xiaomi.onetrack.h.o;
import java.io.UnsupportedEncodingException;

public class c {
    private static final String a = "Base64Util";
    private static char[] b = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] c = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(byte[] arrby) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = arrby.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n3 + 1;
            int n5 = 255 & arrby[n3];
            if (n4 == n2) {
                stringBuffer.append(b[n5 >>> 2]);
                stringBuffer.append(b[(n5 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int n6 = n4 + 1;
            int n7 = 255 & arrby[n4];
            if (n6 == n2) {
                stringBuffer.append(b[n5 >>> 2]);
                stringBuffer.append(b[(n5 & 3) << 4 | (n7 & 240) >>> 4]);
                stringBuffer.append(b[(n7 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int n8 = n6 + 1;
            int n9 = 255 & arrby[n6];
            stringBuffer.append(b[n5 >>> 2]);
            stringBuffer.append(b[(n5 & 3) << 4 | (n7 & 240) >>> 4]);
            stringBuffer.append(b[(n7 & 15) << 2 | (n9 & 192) >>> 6]);
            stringBuffer.append(b[n9 & 63]);
            n3 = n8;
        }
        return stringBuffer.toString();
    }

    public static byte[] a() {
        return new byte[]{84, 123, 100, 101, 118, 33, 80, 100, 101, 116, 116, 37, 94, 52, 77, 73};
    }

    public static byte[] a(String string2) {
        try {
            byte[] arrby = c.b(string2);
            return arrby;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            o.b(o.a(a), "decode e", unsupportedEncodingException);
            return new byte[0];
        }
    }

    private static byte[] b(String string2) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] arrby = string2.getBytes("US-ASCII");
        int n2 = arrby.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4;
            int n5;
            int n6;
            byte by;
            int n7;
            byte by2;
            byte by3;
            byte by4;
            do {
                byte[] arrby2 = c;
                n6 = n3 + 1;
                by2 = arrby2[arrby[n3]];
                if (n6 >= n2 || by2 != -1) break;
                n3 = n6;
            } while (true);
            if (by2 == -1) break;
            do {
                byte[] arrby3 = c;
                n7 = n6 + 1;
                by3 = arrby3[arrby[n6]];
                if (n7 >= n2 || by3 != -1) break;
                n6 = n7;
            } while (true);
            if (by3 == -1) break;
            stringBuffer.append((char)(by2 << 2 | (by3 & 48) >>> 4));
            do {
                n5 = n7 + 1;
                byte by5 = arrby[n7];
                if (by5 == 61) {
                    return stringBuffer.toString().getBytes("iso8859-1");
                }
                by4 = c[by5];
                if (n5 >= n2 || by4 != -1) break;
                n7 = n5;
            } while (true);
            if (by4 == -1) break;
            stringBuffer.append((char)((by3 & 15) << 4 | (by4 & 60) >>> 2));
            do {
                n4 = n5 + 1;
                byte by6 = arrby[n5];
                if (by6 == 61) {
                    return stringBuffer.toString().getBytes("iso8859-1");
                }
                by = c[by6];
                if (n4 >= n2 || by != -1) break;
                n5 = n4;
            } while (true);
            if (by == -1) break;
            stringBuffer.append((char)(by | (by4 & 3) << 6));
            n3 = n4;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }
}

