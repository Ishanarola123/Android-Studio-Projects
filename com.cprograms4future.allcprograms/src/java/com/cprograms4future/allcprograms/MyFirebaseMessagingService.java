/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.firebase.messaging.FirebaseMessagingService
 *  com.google.firebase.messaging.d
 *  com.google.firebase.messaging.d$a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.cprograms4future.allcprograms;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.d;
import java.util.Map;

public class MyFirebaseMessagingService
extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    /*
     * Exception decompiling
     */
    private void sendNotification(String var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl45 : ALOAD : trying to set 1 previously set to 0
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
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public void onMessageReceived(d d2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("From : ");
        stringBuilder.append(d2.a());
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (d2.b().size() > 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Msg Data : ");
            stringBuilder2.append((Object)d2.b());
            Log.d((String)TAG, (String)stringBuilder2.toString());
        }
        if (d2.c() != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Msg Body : ");
            stringBuilder3.append(d2.c().b());
            Log.d((String)TAG, (String)stringBuilder3.toString());
            this.sendNotification(d2.c().b(), d2.c().a());
        }
    }
}

