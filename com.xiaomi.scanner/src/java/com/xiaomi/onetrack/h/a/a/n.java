/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.Signature
 *  android.os.IBinder
 *  com.xiaomi.onetrack.h.a.b.e$a
 *  com.xiaomi.onetrack.h.a.b.e$a$a
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 *  java.util.concurrent.LinkedBlockingQueue
 */
package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import com.xiaomi.onetrack.h.a.a.o;
import com.xiaomi.onetrack.h.a.b.e;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

public class n {
    e a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);
    ServiceConnection c = new o(this);
    private String d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(String string2, Context context) {
        String string3 = context.getPackageName();
        if (this.d == null) {
            Signature[] arrsignature;
            try {
                arrsignature = context.getPackageManager().getPackageInfo((String)string3, (int)64).signatures;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                arrsignature = null;
            }
            String string4 = null;
            if (arrsignature != null) {
                int n2 = arrsignature.length;
                string4 = null;
                if (n2 > 0) {
                    byte[] arrby = arrsignature[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA1");
                        string4 = null;
                        if (messageDigest != null) {
                            byte[] arrby2 = messageDigest.digest(arrby);
                            StringBuilder stringBuilder = new StringBuilder();
                            int n3 = arrby2.length;
                            for (int i2 = 0; i2 < n3; ++i2) {
                                stringBuilder.append(Integer.toHexString((int)(256 | 255 & arrby2[i2])).substring(1, 3));
                            }
                            string4 = stringBuilder.toString();
                        }
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
            this.d = string4;
        }
        return ((e.a)this.a).a(string3, this.d, string2);
    }

    private boolean b(Context context) {
        int n2;
        PackageInfo packageInfo;
        block4 : {
            packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (packageInfo != null) break block4;
            return false;
        }
        try {
            n2 = packageInfo.versionCode;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if ((long)n2 < 1L) {
            return false;
        }
        return true;
    }

    /*
     * Exception decompiling
     */
    public String a(Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl79.1 : ALOAD : trying to set 0 previously set to 1
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

