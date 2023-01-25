/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 */
package com.xiaomi.onetrack.h;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class l {
    public static final int a = -1;
    private static final String b = "onetrack";
    private static final int c = 4096;

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return l.a(inputStream, outputStream, 4096);
    }

    public static long a(InputStream inputStream, OutputStream outputStream, int n2) throws IOException {
        int n3;
        byte[] arrby = new byte[n2];
        long l2 = 0L;
        while (-1 != (n3 = inputStream.read(arrby))) {
            outputStream.write(arrby, 0, n3);
            l2 += (long)n3;
        }
        return l2;
    }

    public static String a(byte[] arrby) {
        if (arrby == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = arrby.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = Integer.toHexString((int)(255 & arrby[i2]));
            while (string2.length() < 2) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("0");
                stringBuilder2.append(string2);
                string2 = stringBuilder2.toString();
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    /*
     * Exception decompiling
     */
    public static void a(Closeable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public static void a(InputStream inputStream) {
        l.a((Closeable)inputStream);
    }

    public static void a(OutputStream outputStream) {
        l.a((Closeable)outputStream);
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null && closeable instanceof Closeable) {
            try {
                closeable.close();
                return;
            }
            catch (Exception exception) {
                Log.e((String)b, (String)"closeSafely e", (Throwable)exception);
            }
        }
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l.a(inputStream, (OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

