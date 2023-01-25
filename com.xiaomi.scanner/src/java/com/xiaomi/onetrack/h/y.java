/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.text.SimpleDateFormat
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Random
 *  java.util.TimeZone
 */
package com.xiaomi.onetrack.h;

import com.xiaomi.onetrack.h.o;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class y {
    public static final long a = 604800000L;
    public static final int b = 86400000;
    public static final int c = 43200000;
    public static final int d = 3600000;
    public static final int e = 60000;
    public static final int f = 1000;
    private static final String g = "TimeUtil";
    private static final long h = 300000L;
    private static long i;
    private static long j;
    private static long k;

    public static long a() {
        return System.currentTimeMillis();
    }

    public static boolean a(long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("inToday,current ts :");
        stringBuilder.append(y.a());
        o.a(g, stringBuilder.toString());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(y.a());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long l3 = calendar.getTimeInMillis();
        long l4 = l3 + 86400000L;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[start]:");
        stringBuilder2.append(l3);
        stringBuilder2.append("\n[end]:");
        stringBuilder2.append(l4);
        stringBuilder2.append("duration");
        stringBuilder2.append(l4 - l3 - 86400000L);
        o.a(g, stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("is in today:");
        boolean bl = l3 <= l2 && l2 < l4;
        stringBuilder3.append(bl);
        o.a(g, stringBuilder3.toString());
        long l5 = l3 LCMP l2;
        boolean bl2 = false;
        if (l5 <= 0) {
            long l6 = l2 LCMP l4;
            bl2 = false;
            if (l6 < 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public static boolean a(long l2, int n2) {
        long l3 = n2 + new Random().nextInt(n2 / 2);
        return Math.abs((long)(System.currentTimeMillis() - l2)) >= l3;
    }

    public static boolean a(long l2, long l3) {
        return Math.abs((long)(System.currentTimeMillis() - l2)) >= l3;
    }

    /*
     * Exception decompiling
     */
    public static long b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl8 : ALOAD_0 : trying to set 1 previously set to 0
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

    public static boolean b(long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("inTodayClientTime,current ts :");
        stringBuilder.append(System.currentTimeMillis());
        o.a(g, stringBuilder.toString());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long l3 = calendar.getTimeInMillis();
        long l4 = l3 + 86400000L;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[start]:");
        stringBuilder2.append(l3);
        stringBuilder2.append("\n[end]:");
        stringBuilder2.append(l4);
        stringBuilder2.append("duration");
        stringBuilder2.append(l4 - l3 - 86400000L);
        o.a(g, stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("is in today:");
        boolean bl = l3 <= l2 && l2 < l4;
        stringBuilder3.append(bl);
        o.a(g, stringBuilder3.toString());
        long l5 = l3 LCMP l2;
        boolean bl2 = false;
        if (l5 <= 0) {
            long l6 = l2 LCMP l4;
            bl2 = false;
            if (l6 < 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public static String c(long l2) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(l2);
            String string2 = new SimpleDateFormat("HH:mm:ss yy-MM-dd").format(calendar.getTime());
            return string2;
        }
        catch (Exception exception) {
            return "";
        }
    }

    public static boolean d(long l2) {
        Calendar calendar = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC"));
        calendar.add(10, 8);
        Calendar calendar2 = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC"));
        calendar2.setTimeInMillis(l2);
        calendar2.add(10, 8);
        int n2 = calendar2.get(1);
        int n3 = calendar2.get(2);
        int n4 = calendar2.get(5);
        return n2 == calendar.get(1) && n3 == calendar.get(2) && n4 == calendar.get(5);
    }
}

