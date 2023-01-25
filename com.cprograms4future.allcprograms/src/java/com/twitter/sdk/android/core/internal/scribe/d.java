/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.d.a
 *  android.content.Context
 *  com.twitter.sdk.android.core.internal.scribe.ScribeFilesSender
 *  com.twitter.sdk.android.core.internal.scribe.b
 *  com.twitter.sdk.android.core.internal.scribe.f$a
 *  com.twitter.sdk.android.core.internal.scribe.h
 *  com.twitter.sdk.android.core.internal.scribe.i
 *  com.twitter.sdk.android.core.p
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.ScheduledExecutorService
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core.internal.scribe;

import a.a.a.a.a.b.m;
import a.a.a.a.a.b.q;
import a.a.a.a.a.d.a;
import a.a.a.a.a.d.c;
import a.a.a.a.a.d.l;
import android.content.Context;
import com.twitter.sdk.android.core.internal.scribe.ScribeFilesSender;
import com.twitter.sdk.android.core.internal.scribe.b;
import com.twitter.sdk.android.core.internal.scribe.e;
import com.twitter.sdk.android.core.internal.scribe.f;
import com.twitter.sdk.android.core.internal.scribe.h;
import com.twitter.sdk.android.core.internal.scribe.i;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.p;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLSocketFactory;

public class d {
    final ConcurrentHashMap<Long, i> a;
    private final a.a.a.a.i b;
    private final ScheduledExecutorService c;
    private final e d;
    private final f.a e;
    private final n f;
    private final k<? extends j<p>> g;
    private final com.twitter.sdk.android.core.e h;
    private final SSLSocketFactory i;
    private final m j;

    public d(a.a.a.a.i i2, ScheduledExecutorService scheduledExecutorService, e e2, f.a a2, n n2, k<? extends j<p>> k2, com.twitter.sdk.android.core.e e3, SSLSocketFactory sSLSocketFactory, m m2) {
        this.b = i2;
        this.c = scheduledExecutorService;
        this.d = e2;
        this.e = a2;
        this.f = n2;
        this.g = k2;
        this.h = e3;
        this.i = sSLSocketFactory;
        this.j = m2;
        this.a = new ConcurrentHashMap(2);
    }

    private i d(long l2) throws IOException {
        Context context = this.b.m();
        l l3 = new l(context, new a.a.a.a.a.f.a(this.b).a(), this.b(l2), this.c(l2));
        h h2 = new h(context, (c)this.e, (a.a.a.a.a.b.j)new q(), l3, this.d.g);
        return new i(context, this.a(l2, h2), (a.a.a.a.a.d.d)h2, this.c);
    }

    a.a.a.a.a.d.i<f> a(long l2, h h2) {
        Context context = this.b.m();
        if (this.d.a) {
            a.a.a.a.a.b.i.a(context, "Scribe enabled");
            ScheduledExecutorService scheduledExecutorService = this.c;
            e e2 = this.d;
            ScribeFilesSender scribeFilesSender = new ScribeFilesSender(context, this.d, l2, this.f, this.g, this.h, this.i, (ExecutorService)this.c, this.j);
            b b2 = new b(context, scheduledExecutorService, h2, e2, scribeFilesSender);
            return b2;
        }
        a.a.a.a.a.b.i.a(context, "Scribe disabled");
        return new a();
    }

    i a(long l2) throws IOException {
        if (!this.a.containsKey((Object)l2)) {
            this.a.putIfAbsent((Object)l2, (Object)this.d(l2));
        }
        return (i)this.a.get((Object)l2);
    }

    public boolean a(f f2, long l2) {
        try {
            this.a(l2).a(f2);
            return true;
        }
        catch (IOException iOException) {
            a.a.a.a.a.b.i.a(this.b.m(), "Failed to scribe event", iOException);
            return false;
        }
    }

    String b(long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2);
        stringBuilder.append("_se.tap");
        return stringBuilder.toString();
    }

    String c(long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2);
        stringBuilder.append("_se_to_send");
        return stringBuilder.toString();
    }
}

