/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Process
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.xiaomi.onetrack.a;

import android.content.Context;
import android.os.Process;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.a.ag;
import com.xiaomi.onetrack.a.ah;
import com.xiaomi.onetrack.a.d;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.o;
import java.util.concurrent.ConcurrentHashMap;

public class af
implements ah.b,
d {
    private static final String a = "OneTrackSystemImp";
    private static final int b = 102400;
    private static final int c = 2;
    private final ConcurrentHashMap<String, String> d = new ConcurrentHashMap();
    private Configuration e;
    private ah f;

    public af(Context context, Configuration configuration) {
        this.e = configuration;
        this.f = ah.a();
        this.f.a(this);
    }

    static /* synthetic */ ConcurrentHashMap a(af af2) {
        return af2.d;
    }

    private boolean a(String string) {
        if (OneTrack.isDisable()) {
            return false;
        }
        return string == null || 2 * string.length() <= 102400;
    }

    static /* synthetic */ Configuration b(af af2) {
        return af2.e;
    }

    private void b() {
        h.a(new ag(this));
    }

    static /* synthetic */ ah c(af af2) {
        return af2.f;
    }

    @Override
    public void a() {
        if (!g.b()) {
            return;
        }
        this.b();
    }

    @Override
    public void a(int n) {
        this.f.a(n);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(String string, String string2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!this.a(string2)) {
            return;
        }
        if (!g.b() && !"onetrack_cta_status".equalsIgnoreCase(string)) {
            g.a(string, string2);
            return;
        }
        if (o.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("track name:");
            stringBuilder.append(string);
            stringBuilder.append(" data :");
            stringBuilder.append(string2);
            stringBuilder.append(" tid");
            stringBuilder.append(Process.myTid());
            o.a(a, stringBuilder.toString());
        }
        ConcurrentHashMap<String, String> concurrentHashMap2 = concurrentHashMap = this.d;
        synchronized (concurrentHashMap2) {
            if (!this.f.a(string, string2, this.e)) {
                this.d.put((Object)string2, (Object)string);
                if (o.a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("track mIOneTrackService is null!");
                    stringBuilder.append(this.d.size());
                    stringBuilder.append("  ");
                    stringBuilder.append(string2);
                    o.a(a, stringBuilder.toString());
                }
            }
            return;
        }
    }
}

