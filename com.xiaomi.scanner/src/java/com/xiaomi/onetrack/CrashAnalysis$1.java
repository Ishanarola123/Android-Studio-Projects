/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.xiaomi.onetrack;

import android.content.Context;
import com.xiaomi.onetrack.CrashAnalysis;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.o;

final class CrashAnalysis$1
implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ f b;

    CrashAnalysis$1(Context context, f f2) {
        this.a = context;
        this.b = f2;
    }

    public void run() {
        try {
            CrashAnalysis crashAnalysis = new CrashAnalysis(this.a, this.b, null);
            o.a("CrashAnalysis", "CrashAnalysis create success");
            if (CrashAnalysis.a(crashAnalysis)) {
                CrashAnalysis.b(crashAnalysis);
                return;
            }
            o.a("CrashAnalysis", "no crash file found");
            return;
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("processCrash error: ");
            stringBuilder.append(throwable.toString());
            o.b("CrashAnalysis", stringBuilder.toString());
            return;
        }
    }
}

