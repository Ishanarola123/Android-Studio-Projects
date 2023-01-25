/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.d$1
 *  com.google.a.d$2
 *  com.google.a.d$3
 *  com.google.a.d$4
 *  com.google.a.d$5
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.google.a;

import com.google.a.d;
import com.google.a.e;

public abstract class d
extends Enum<d>
implements e {
    public static final /* enum */ d a = new 1("IDENTITY", 0);
    public static final /* enum */ d b = new 2("UPPER_CAMEL_CASE", 1);
    public static final /* enum */ d c = new 3("UPPER_CAMEL_CASE_WITH_SPACES", 2);
    public static final /* enum */ d d = new 4("LOWER_CASE_WITH_UNDERSCORES", 3);
    public static final /* enum */ d e = new 5("LOWER_CASE_WITH_DASHES", 4);
    private static final /* synthetic */ d[] f;

    static {
        d[] arrd = new d[]{a, b, c, d, e};
        f = arrd;
    }

    private d() {
    }

    private static String a(char c2, String string, int n2) {
        if (n2 < string.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c2);
            stringBuilder.append(string.substring(n2));
            return stringBuilder.toString();
        }
        return String.valueOf((char)c2);
    }

    static String a(String string) {
        char c2;
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        do {
            c2 = string.charAt(n2);
            if (n2 >= -1 + string.length() || Character.isLetter((char)c2)) break;
            stringBuilder.append(c2);
            ++n2;
        } while (true);
        if (n2 == string.length()) {
            return stringBuilder.toString();
        }
        if (!Character.isUpperCase((char)c2)) {
            stringBuilder.append(d.a(Character.toUpperCase((char)c2), string, n2 + 1));
            string = stringBuilder.toString();
        }
        return string;
    }

    static String a(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (Character.isUpperCase((char)c2) && stringBuilder.length() != 0) {
                stringBuilder.append(string2);
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public static d valueOf(String string) {
        return (d)Enum.valueOf(d.class, (String)string);
    }

    public static d[] values() {
        return (d[])f.clone();
    }
}

