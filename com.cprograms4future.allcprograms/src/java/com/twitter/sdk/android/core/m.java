/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 */
package com.twitter.sdk.android.core;

import android.text.TextUtils;
import b.ac;
import c.c;
import c.e;
import com.google.a.f;
import com.google.a.g;
import com.google.a.x;
import com.twitter.sdk.android.core.a.a;
import com.twitter.sdk.android.core.a.b;
import com.twitter.sdk.android.core.a.l;
import com.twitter.sdk.android.core.r;
import com.twitter.sdk.android.core.t;
import java.util.List;

public class m
extends r {
    private final a a;
    private final t b;
    private final int c;
    private final d.l d;

    public m(d.l l2) {
        this(l2, m.b(l2), m.a(l2), l2.a());
    }

    m(d.l l2, a a2, t t2, int n2) {
        super(m.a(n2));
        this.a = a2;
        this.b = t2;
        this.c = n2;
        this.d = l2;
    }

    static a a(String string) {
        f f2 = new g().a(new l()).a(new com.twitter.sdk.android.core.a.m()).a();
        try {
            b b2 = f2.a(string, b.class);
            if (!b2.a.isEmpty()) {
                a a2 = (a)b2.a.get(0);
                return a2;
            }
        }
        catch (com.google.a.t t2) {
            a.a.a.a.l l2 = a.a.a.a.c.h();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid json: ");
            stringBuilder.append(string);
            l2.d("Twitter", stringBuilder.toString(), (Throwable)((Object)t2));
        }
        return null;
    }

    public static t a(d.l l2) {
        return new t(l2.b());
    }

    static String a(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP request failed, Status: ");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public static a b(d.l l2) {
        try {
            String string = l2.e().d().c().t().q();
            if (!TextUtils.isEmpty((CharSequence)string)) {
                a a2 = m.a(string);
                return a2;
            }
        }
        catch (Exception exception) {
            a.a.a.a.c.h().d("Twitter", "Unexpected response", exception);
        }
        return null;
    }

    public int a() {
        if (this.a == null) {
            return 0;
        }
        return this.a.a;
    }
}

