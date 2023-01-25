/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.h.a;

import android.content.Context;
import com.xiaomi.onetrack.h.a.a.c;
import com.xiaomi.onetrack.h.a.a.j;
import com.xiaomi.onetrack.h.m;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.t;

public class a {
    private static final String a = "a";
    private static volatile a b;
    private volatile boolean c = false;
    private volatile String d = "";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        if (b != null) return b;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (b != null) return b;
            b = new a();
            // ** MonitorExit[var1] (shouldn't be in output)
            return b;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a(Context context) {
        String string2;
        String string3 = string2 = this.d;
        synchronized (string3) {
            if (t.a()) {
                if (o.a) throw new IllegalStateException("Don't use it on the main thread");
                o.b(a, "getOaid() throw exception : Don't use it on the main thread");
                return "";
            }
            if (this.d != null && !this.d.equals((Object)"")) {
                return this.d;
            }
            if (this.c) {
                return this.d;
            }
            if (p.a()) {
                this.d = m.b(context);
                return this.d;
            }
            String string4 = new j().a(context);
            if (string4 != null && !string4.equals((Object)"")) {
                this.d = string4;
                return string4;
            }
            String string5 = new c().a(context);
            if (string5 != null && !string5.equals((Object)"")) {
                this.d = string5;
                return string5;
            }
            this.c = true;
            return this.d;
        }
    }
}

