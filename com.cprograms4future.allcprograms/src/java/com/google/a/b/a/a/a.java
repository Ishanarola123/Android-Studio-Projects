/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.TimeZone
 */
package com.google.a.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class a {
    private static final TimeZone a = TimeZone.getTimeZone((String)"UTC");

    private static int a(String string, int n2) {
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (c2 >= '0') {
                if (c2 > '9') {
                    return n2;
                }
                ++n2;
                continue;
            }
            return n2;
        }
        return string.length();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int a(String string, int n2, int n3) throws NumberFormatException {
        if (n2 >= 0 && n3 <= string.length() && n2 <= n3) {
            int n4;
            int n5;
            if (n2 < n3) {
                n4 = n2 + 1;
                int n6 = Character.digit((char)string.charAt(n2), (int)10);
                if (n6 < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid number: ");
                    stringBuilder.append(string.substring(n2, n3));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                n5 = -n6;
            } else {
                n4 = n2;
                n5 = 0;
            }
            do {
                if (n4 >= n3) {
                    return -n5;
                }
                int n7 = n4 + 1;
                int n8 = Character.digit((char)string.charAt(n4), (int)10);
                if (n8 < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid number: ");
                    stringBuilder.append(string.substring(n2, n3));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                n5 = n5 * 10 - n8;
                n4 = n7;
            } while (true);
        }
        throw new NumberFormatException(string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Date a(String string, ParsePosition parsePosition) throws ParseException {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        block31 : {
            block29 : {
                int n10;
                block26 : {
                    int n11;
                    block30 : {
                        char c2;
                        block28 : {
                            int n12;
                            block27 : {
                                int n13;
                                block25 : {
                                    int n14;
                                    block24 : {
                                        int n15 = parsePosition.getIndex();
                                        n14 = n15 + 4;
                                        n5 = a.a(string, n15, n14);
                                        if (!a.a(string, n14, '-')) break block24;
                                        ++n14;
                                    }
                                    n13 = n14 + 2;
                                    n6 = a.a(string, n14, n13);
                                    if (!a.a(string, n13, '-')) break block25;
                                    ++n13;
                                }
                                n10 = n13 + 2;
                                n7 = a.a(string, n13, n10);
                                boolean bl = a.a(string, n10, 'T');
                                if (!bl && string.length() <= n10) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(n5, n6 - 1, n7);
                                    parsePosition.setIndex(n10);
                                    return gregorianCalendar.getTime();
                                }
                                if (!bl) break block26;
                                int n16 = n10 + 1;
                                n12 = n16 + 2;
                                n9 = a.a(string, n16, n12);
                                if (!a.a(string, n12, ':')) break block27;
                                ++n12;
                            }
                            n3 = n12 + 2;
                            n4 = a.a(string, n12, n3);
                            if (!a.a(string, n3, ':')) break block28;
                            ++n3;
                        }
                        if (string.length() <= n3 || (c2 = string.charAt(n3)) == 'Z' || c2 == '+' || c2 == '-') break block29;
                        n11 = n3 + 2;
                        int n17 = a.a(string, n3, n11);
                        if (n17 <= (n8 = 59) || n17 >= 63) {
                            n8 = n17;
                        }
                        if (!a.a(string, n11, '.')) break block30;
                        int n18 = n11 + 1;
                        n3 = a.a(string, n18 + 1);
                        int n19 = Math.min((int)n3, (int)(n18 + 3));
                        int n20 = a.a(string, n18, n19);
                        switch (n19 - n18) {
                            default: {
                                break;
                            }
                            case 2: {
                                n20 *= 10;
                                break;
                            }
                            case 1: {
                                n20 *= 100;
                            }
                        }
                        n2 = n20;
                        break block31;
                    }
                    n3 = n11;
                    n2 = 0;
                    break block31;
                }
                n3 = n10;
                n9 = 0;
                n4 = 0;
            }
            n2 = 0;
            n8 = 0;
        }
        try {
            TimeZone timeZone;
            int n21;
            if (string.length() <= n3) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char c3 = string.charAt(n3);
            if (c3 == 'Z') {
                timeZone = a;
                n21 = n3 + 1;
            } else {
                if (c3 != '+' && c3 != '-') {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid time zone indicator '");
                    stringBuilder.append(c3);
                    stringBuilder.append("'");
                    throw new IndexOutOfBoundsException(stringBuilder.toString());
                }
                String string2 = string.substring(n3);
                if (string2.length() < 5) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append("00");
                    string2 = stringBuilder.toString();
                }
                n21 = n3 + string2.length();
                if ("+0000".equals((Object)string2) || "+00:00".equals((Object)string2)) {
                    timeZone = a;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("GMT");
                    stringBuilder.append(string2);
                    String string3 = stringBuilder.toString();
                    TimeZone timeZone2 = TimeZone.getTimeZone((String)string3);
                    String string4 = timeZone2.getID();
                    if (!string4.equals((Object)string3) && !string4.replace((CharSequence)":", (CharSequence)"").equals((Object)string3)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Mismatching time zone indicator: ");
                        stringBuilder2.append(string3);
                        stringBuilder2.append(" given, resolves to ");
                        stringBuilder2.append(timeZone2.getID());
                        throw new IndexOutOfBoundsException(stringBuilder2.toString());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, n5);
            gregorianCalendar.set(2, n6 - 1);
            gregorianCalendar.set(5, n7);
            gregorianCalendar.set(11, n9);
            gregorianCalendar.set(12, n4);
            gregorianCalendar.set(13, n8);
            gregorianCalendar.set(14, n2);
            parsePosition.setIndex(n21);
            return gregorianCalendar.getTime();
        }
        catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException throwable) {
            String string5;
            if (string == null) {
                string5 = null;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('\"');
                stringBuilder.append(string);
                stringBuilder.append("'");
                string5 = stringBuilder.toString();
            }
            String string6 = throwable.getMessage();
            if (string6 == null || string6.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("(");
                stringBuilder.append(throwable.getClass().getName());
                stringBuilder.append(")");
                string6 = stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to parse date [");
            stringBuilder.append(string5);
            stringBuilder.append("]: ");
            stringBuilder.append(string6);
            ParseException parseException = new ParseException(stringBuilder.toString(), parsePosition.getIndex());
            parseException.initCause(throwable);
            throw parseException;
        }
    }

    private static boolean a(String string, int n2, char c2) {
        return n2 < string.length() && string.charAt(n2) == c2;
    }
}

