/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.a.c;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.o;
import org.json.JSONObject;

class y
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ f f;

    y(f f2, String string2, String string3, String string4, String string5, String string6) {
        this.f = f2;
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = string5;
        this.e = string6;
    }

    public void run() {
        try {
            JSONObject jSONObject = f.b(this.f, "onetrack_bug_report");
            f.d(this.f).a("onetrack_bug_report", c.a(this.a, this.b, this.c, this.d, this.e, f.a(this.f), f.c(this.f), jSONObject));
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trackException error: ");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

