/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.Normalizer
 *  java.text.Normalizer$Form
 */
package com.twitter.sdk.android.core.internal;

import android.net.Uri;
import android.os.Build;
import java.text.Normalizer;

public class d {
    private final String a;

    public d() {
        this("https://api.twitter.com");
    }

    public d(String string) {
        this.a = string;
    }

    static String a(String string) {
        return d.b(Normalizer.normalize((CharSequence)string, (Normalizer.Form)Normalizer.Form.NFD));
    }

    public static String a(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.append('/');
        stringBuilder.append(string2);
        stringBuilder.append(' ');
        stringBuilder.append(Build.MODEL);
        stringBuilder.append('/');
        stringBuilder.append(Build.VERSION.RELEASE);
        stringBuilder.append(" (");
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append(';');
        stringBuilder.append(Build.MODEL);
        stringBuilder.append(';');
        stringBuilder.append(Build.BRAND);
        stringBuilder.append(';');
        stringBuilder.append(Build.PRODUCT);
        stringBuilder.append(')');
        return d.a(stringBuilder.toString());
    }

    static String b(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 <= '\u001f' || c2 >= '') continue;
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public /* varargs */ Uri.Builder a(String ... arrstring) {
        Uri.Builder builder = Uri.parse((String)this.a()).buildUpon();
        if (arrstring != null) {
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                builder.appendPath(arrstring[i2]);
            }
        }
        return builder;
    }

    public String a() {
        return this.a;
    }
}

