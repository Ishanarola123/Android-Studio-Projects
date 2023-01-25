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
 */
package com.xiaomi.onetrack.b;

import android.text.TextUtils;
import com.xiaomi.onetrack.d.f;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.p;

public class l {
    private static String a = "ConfigProvider";
    private static volatile boolean b = false;
    private static volatile boolean c = true;

    /*
     * Exception decompiling
     */
    public static int a(int var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20 : GETSTATIC : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public static void a(boolean bl) {
        Class<l> class_ = l.class;
        synchronized (l.class) {
            b = bl;
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a() {
        try {
            String[] arrstring = f.a().b();
            boolean bl = !TextUtils.isEmpty((CharSequence)arrstring[0]) && !TextUtils.isEmpty((CharSequence)arrstring[1]);
            boolean bl2 = p.a(a);
            if (!bl || bl2) return false;
            return true;
        }
        catch (Exception exception) {
            o.a(a, "ConfigProvider.available", exception);
        }
        return false;
    }

    public static void b(boolean bl) {
        Class<l> class_ = l.class;
        synchronized (l.class) {
            c = bl;
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return;
        }
    }

    public static boolean b() {
        Class<l> class_ = l.class;
        synchronized (l.class) {
            boolean bl = b;
            // ** MonitorExit[var2] (shouldn't be in output)
            return bl;
        }
    }

    public static boolean c() {
        Class<l> class_ = l.class;
        synchronized (l.class) {
            boolean bl = c;
            // ** MonitorExit[var2] (shouldn't be in output)
            return bl;
        }
    }
}

