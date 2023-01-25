/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.net.http.HttpResponseCache
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 */
package com.a.a;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import com.a.a.af;
import com.a.a.ag;
import com.a.a.j;
import com.a.a.q;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class af
implements j {
    static volatile Object a;
    private static final Object b;
    private static final ThreadLocal<StringBuilder> c;
    private final Context d;

    static {
        b = new Object();
        c = new ThreadLocal<StringBuilder>(){

            protected StringBuilder a() {
                return new StringBuilder();
            }

            protected /* synthetic */ Object initialValue() {
                return this.a();
            }
        };
    }

    public af(Context context) {
        this.d = context.getApplicationContext();
    }

    /*
     * Exception decompiling
     */
    private static void a(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl22.1 : RETURN : trying to set 0 previously set to 1
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

    @Override
    public j.a a(Uri uri, int n2) throws IOException {
        int n3;
        if (Build.VERSION.SDK_INT >= 14) {
            af.a(this.d);
        }
        HttpURLConnection httpURLConnection = this.a(uri);
        httpURLConnection.setUseCaches(true);
        if (n2 != 0) {
            String string;
            if (q.c(n2)) {
                string = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder stringBuilder = (StringBuilder)c.get();
                stringBuilder.setLength(0);
                if (!q.a(n2)) {
                    stringBuilder.append("no-cache");
                }
                if (!q.b(n2)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append("no-store");
                }
                string = stringBuilder.toString();
            }
            httpURLConnection.setRequestProperty("Cache-Control", string);
        }
        if ((n3 = httpURLConnection.getResponseCode()) < 300) {
            long l2 = httpURLConnection.getHeaderFieldInt("Content-Length", -1);
            boolean bl = ag.a(httpURLConnection.getHeaderField("X-Android-Response-Source"));
            return new j.a(httpURLConnection.getInputStream(), bl, l2);
        }
        httpURLConnection.disconnect();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n3);
        stringBuilder.append(" ");
        stringBuilder.append(httpURLConnection.getResponseMessage());
        throw new j.b(stringBuilder.toString(), n2, n3);
    }

    protected HttpURLConnection a(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

}

