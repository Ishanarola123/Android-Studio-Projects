/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.text.Normalizer
 *  java.text.Normalizer$Form
 *  java.util.List
 */
package com.twitter;

import com.twitter.a;
import java.text.Normalizer;
import java.util.List;

public class d {
    protected int a = 23;
    protected int b = 23;
    private a c = new a();

    public int a(String string) {
        String string2 = Normalizer.normalize((CharSequence)string, (Normalizer.Form)Normalizer.Form.NFC);
        int n2 = string2.codePointCount(0, string2.length());
        for (a.a a2 : this.c.a(string2)) {
            int n3 = n2 + (a2.a - a2.b);
            int n4 = a2.c.toLowerCase().startsWith("https://") ? this.b : this.a;
            n2 = n3 + n4;
        }
        return n2;
    }
}

