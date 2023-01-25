/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.twitter.sdk.android.tweetui.internal;

import java.util.Locale;

final class c {
    static String a(long l2) {
        int n2 = (int)(l2 / 1000L);
        int n3 = n2 % 60;
        int n4 = n2 / 60 % 60;
        int n5 = n2 / 3600;
        if (n5 > 0) {
            Locale locale = Locale.getDefault();
            Object[] arrobject = new Object[]{n5, n4, n3};
            return String.format((Locale)locale, (String)"%1$d:%2$02d:%3$02d", (Object[])arrobject);
        }
        Locale locale = Locale.getDefault();
        Object[] arrobject = new Object[]{n4, n3};
        return String.format((Locale)locale, (String)"%1$d:%2$02d", (Object[])arrobject);
    }
}

