/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.b;

public final class c {
    public static int a(String string, int n2) {
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (c2 != ' ' && c2 != '\t') {
                return n2;
            }
            ++n2;
        }
        return n2;
    }

    public static int a(String string, int n2, String string2) {
        while (n2 < string.length()) {
            if (string2.indexOf((int)string.charAt(n2)) != -1) {
                return n2;
            }
            ++n2;
        }
        return n2;
    }

    public static int b(String string, int n2) {
        long l2;
        block3 : {
            try {
                l2 = Long.parseLong((String)string);
                if (l2 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (l2 >= 0L) break block3;
                return 0;
            }
            catch (NumberFormatException numberFormatException) {
                return n2;
            }
        }
        return (int)l2;
    }
}

