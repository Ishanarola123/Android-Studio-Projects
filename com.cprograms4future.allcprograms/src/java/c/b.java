/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 */
package c;

import java.io.UnsupportedEncodingException;

final class b {
    private static final byte[] a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static String a(byte[] arrby) {
        return b.a(arrby, a);
    }

    private static String a(byte[] arrby, byte[] arrby2) {
        byte[] arrby3 = new byte[4 * (2 + arrby.length) / 3];
        int n2 = arrby.length - arrby.length % 3;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; i2 += 3) {
            int n4 = n3 + 1;
            arrby3[n3] = arrby2[(255 & arrby[i2]) >> 2];
            int n5 = n4 + 1;
            int n6 = (3 & arrby[i2]) << 4;
            int n7 = i2 + 1;
            arrby3[n4] = arrby2[n6 | (255 & arrby[n7]) >> 4];
            int n8 = n5 + 1;
            int n9 = (15 & arrby[n7]) << 2;
            int n10 = i2 + 2;
            arrby3[n5] = arrby2[n9 | (255 & arrby[n10]) >> 6];
            n3 = n8 + 1;
            arrby3[n8] = arrby2[63 & arrby[n10]];
        }
        switch (arrby.length % 3) {
            default: {
                break;
            }
            case 2: {
                int n11 = n3 + 1;
                arrby3[n3] = arrby2[(255 & arrby[n2]) >> 2];
                int n12 = n11 + 1;
                int n13 = (3 & arrby[n2]) << 4;
                int n14 = n2 + 1;
                arrby3[n11] = arrby2[n13 | (255 & arrby[n14]) >> 4];
                int n15 = n12 + 1;
                arrby3[n12] = arrby2[(15 & arrby[n14]) << 2];
                n3 = n15 + 1;
                arrby3[n15] = 61;
                break;
            }
            case 1: {
                int n16 = n3 + 1;
                arrby3[n3] = arrby2[(255 & arrby[n2]) >> 2];
                int n17 = n16 + 1;
                arrby3[n16] = arrby2[(3 & arrby[n2]) << 4];
                int n18 = n17 + 1;
                arrby3[n17] = 61;
                n3 = n18 + 1;
                arrby3[n18] = 61;
            }
        }
        try {
            String string = new String(arrby3, 0, n3, "US-ASCII");
            return string;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError((Object)unsupportedEncodingException);
        }
    }
}

