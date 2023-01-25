/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.h.o;

public class c {
    private static final String a = "NetworkUtil";
    private static final int b = 16;
    private static final int c = 17;
    private static final int d = 18;
    private static final int e = 19;
    private static final int f = 20;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static OneTrack.NetType a(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo == null) return OneTrack.NetType.NOT_CONNECTED;
        try {
            if (!networkInfo.isConnected()) return OneTrack.NetType.NOT_CONNECTED;
            if (networkInfo.getType() == 1) {
                return OneTrack.NetType.WIFI;
            }
            if (networkInfo.getType() == 0) {
                switch (networkInfo.getSubtype()) {
                    default: {
                        return OneTrack.NetType.UNKNOWN;
                    }
                    case 20: {
                        return OneTrack.NetType.MOBILE_5G;
                    }
                    case 13: 
                    case 18: 
                    case 19: {
                        return OneTrack.NetType.MOBILE_4G;
                    }
                    case 3: 
                    case 5: 
                    case 6: 
                    case 8: 
                    case 9: 
                    case 10: 
                    case 12: 
                    case 14: 
                    case 15: 
                    case 17: {
                        return OneTrack.NetType.MOBILE_3G;
                    }
                    case 1: 
                    case 2: 
                    case 4: 
                    case 7: 
                    case 11: 
                    case 16: 
                }
                return OneTrack.NetType.MOBILE_2G;
            }
            if (networkInfo.getType() != 9) return OneTrack.NetType.UNKNOWN;
            return OneTrack.NetType.ETHERNET;
        }
        catch (Exception exception) {
            o.b(a, "getNetworkState error", exception);
        }
        return OneTrack.NetType.UNKNOWN;
    }

    /*
     * Exception decompiling
     */
    @SuppressLint(value={"MissingPermission"})
    public static boolean a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl21 : ICONST_0 : trying to set 1 previously set to 0
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
}

