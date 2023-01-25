/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Collections
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.ScheduledExecutorService
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core.internal.scribe;

import a.a.a.a.a.b.l;
import a.a.a.a.a.b.m;
import a.a.a.a.a.g.b;
import a.a.a.a.a.g.t;
import a.a.a.a.i;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.twitter.sdk.android.core.internal.scribe.c;
import com.twitter.sdk.android.core.internal.scribe.d;
import com.twitter.sdk.android.core.internal.scribe.e;
import com.twitter.sdk.android.core.internal.scribe.f;
import com.twitter.sdk.android.core.internal.scribe.g;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.q;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLSocketFactory;

public class a
extends d {
    private static volatile ScheduledExecutorService b;
    private final i c;
    private final k<? extends j<p>> d;
    private final String e;

    a(i i2, String string, com.google.a.f f2, k<? extends j<p>> k2, com.twitter.sdk.android.core.e e2, m m2) {
        super(i2, a.d(), a.a(a.a.a.a.a.g.q.a().b(), a.a(string, i2)), new f.a(f2), q.c().e(), k2, e2, q.c().f(), m2);
        this.d = k2;
        this.c = i2;
        this.e = m2.i();
    }

    public a(i i2, String string, k<? extends j<p>> k2, com.twitter.sdk.android.core.e e2, m m2) {
        this(i2, string, a.c(), k2, e2, m2);
    }

    static e a(t t2, String string) {
        int n2;
        int n3;
        if (t2 != null && t2.e != null) {
            int n4 = t2.e.e;
            n2 = t2.e.b;
            n3 = n4;
        } else {
            n3 = 100;
            n2 = 600;
        }
        String string2 = a.a("https://syndication.twitter.com", "");
        e e2 = new e(a.e(), string2, "i", "sdk", "", string, n3, n2);
        return e2;
    }

    static String a(String string, i i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fabric/");
        stringBuilder.append(i2.n().b());
        stringBuilder.append(" (Android ");
        stringBuilder.append(Build.VERSION.SDK_INT);
        stringBuilder.append(") ");
        stringBuilder.append(string);
        stringBuilder.append("/");
        stringBuilder.append(i2.a());
        return stringBuilder.toString();
    }

    static String a(String string, String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            return string2;
        }
        return string;
    }

    private String b() {
        if (this.c.m() != null) {
            return this.c.m().getResources().getConfiguration().locale.getLanguage();
        }
        return "";
    }

    private static com.google.a.f c() {
        return new com.google.a.g().a(com.google.a.d.d).a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ScheduledExecutorService d() {
        if (b != null) return b;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (b != null) return b;
            b = l.a("scribe");
            // ** MonitorExit[var1] (shouldn't be in output)
            return b;
        }
    }

    private static boolean e() {
        return true ^ "release".equals((Object)"debug");
    }

    long a(j j2) {
        if (j2 != null) {
            return j2.b();
        }
        return 0L;
    }

    j a() {
        return this.d.b();
    }

    public void a(c c2, List<com.twitter.sdk.android.core.internal.scribe.j> list) {
        String string = this.b();
        this.a(g.a(c2, "", System.currentTimeMillis(), string, this.e, list));
    }

    public void a(f f2) {
        super.a(f2, this.a(this.a()));
    }

    public /* varargs */ void a(c ... arrc) {
        int n2 = arrc.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a(arrc[i2], (List<com.twitter.sdk.android.core.internal.scribe.j>)Collections.emptyList());
        }
    }
}

