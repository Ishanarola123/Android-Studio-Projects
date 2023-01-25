/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.DecimalFormatSymbols
 *  java.util.Locale
 *  miuix.core.util.Pools
 */
package miuix.pickerwidget.internal.util;

import java.text.DecimalFormatSymbols;
import java.util.Locale;
import miuix.core.util.Pools;

public class SimpleNumberFormatter {
    private static Locale sLocale = Locale.getDefault();
    private static char sZeroDigit = new DecimalFormatSymbols(sLocale).getZeroDigit();

    private static String convertInt(int n, int n2) {
        StringBuilder stringBuilder = (StringBuilder)Pools.getStringBuilderPool().acquire();
        if (n2 < 0) {
            n2 = -n2;
            --n;
            stringBuilder.append('-');
        }
        if (n2 >= 10000) {
            String string2 = Integer.toString((int)n2);
            for (int i = string2.length(); i < n; ++i) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string2);
        } else {
            for (int i = n2 >= 1000 ? 4 : (n2 >= 100 ? 3 : (n2 >= 10 ? 2 : 1)); i < n; ++i) {
                stringBuilder.append('0');
            }
            stringBuilder.append(n2);
        }
        String string3 = stringBuilder.toString();
        Pools.getStringBuilderPool().release((Object)stringBuilder);
        return string3;
    }

    public static String format(int n) {
        return SimpleNumberFormatter.format(-1, n);
    }

    public static String format(int n, int n2) {
        char c2 = SimpleNumberFormatter.getZeroDigit(Locale.getDefault());
        String string2 = SimpleNumberFormatter.convertInt(n, n2);
        if (c2 != '0') {
            string2 = SimpleNumberFormatter.localizeDigits(c2, string2);
        }
        return string2;
    }

    private static char getZeroDigit(Locale locale) {
        if (locale != null) {
            if (!locale.equals((Object)sLocale)) {
                sZeroDigit = new DecimalFormatSymbols(locale).getZeroDigit();
                sLocale = locale;
            }
            return sZeroDigit;
        }
        throw new NullPointerException("locale == null");
    }

    private static String localizeDigits(char c2, String string2) {
        int n = string2.length();
        int n2 = c2 - 48;
        StringBuilder stringBuilder = (StringBuilder)Pools.getStringBuilderPool().acquire();
        for (int i = 0; i < n; ++i) {
            char c3 = string2.charAt(i);
            if (c3 >= '0' && c3 <= '9') {
                c3 = (char)(c3 + n2);
            }
            stringBuilder.append(c3);
        }
        String string3 = stringBuilder.toString();
        Pools.getStringBuilderPool().release((Object)stringBuilder);
        return string3;
    }
}

