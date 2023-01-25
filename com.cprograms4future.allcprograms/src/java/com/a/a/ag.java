/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Process
 *  android.util.Log
 *  com.a.a.af
 *  com.a.a.s
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.List
 *  java.util.concurrent.ThreadFactory
 */
package com.a.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.a.a.ae;
import com.a.a.af;
import com.a.a.j;
import com.a.a.s;
import com.a.a.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

final class ag {
    static final StringBuilder a = new StringBuilder();

    static int a(Resources resources, w w2) throws FileNotFoundException {
        if (w2.e == 0 && w2.d != null) {
            String string = w2.d.getAuthority();
            if (string != null) {
                List list = w2.d.getPathSegments();
                if (list != null && !list.isEmpty()) {
                    if (list.size() == 1) {
                        try {
                            int n2 = Integer.parseInt((String)((String)list.get(0)));
                            return n2;
                        }
                        catch (NumberFormatException numberFormatException) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Last path segment is not a resource ID: ");
                            stringBuilder.append((Object)w2.d);
                            throw new FileNotFoundException(stringBuilder.toString());
                        }
                    }
                    if (list.size() == 2) {
                        String string2 = (String)list.get(0);
                        return resources.getIdentifier((String)list.get(1), string2, string);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("More than two path segments: ");
                    stringBuilder.append((Object)w2.d);
                    throw new FileNotFoundException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No path segments: ");
                stringBuilder.append((Object)w2.d);
                throw new FileNotFoundException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No package provided: ");
            stringBuilder.append((Object)w2.d);
            throw new FileNotFoundException(stringBuilder.toString());
        }
        return w2.e;
    }

    static int a(Bitmap bitmap) {
        int n2 = Build.VERSION.SDK_INT >= 12 ? b.a(bitmap) : bitmap.getRowBytes() * bitmap.getHeight();
        if (n2 >= 0) {
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append((Object)bitmap);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*
     * Exception decompiling
     */
    static long a(File var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20 : LLOAD_2 : trying to set 1 previously set to 0
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

    static Resources a(Context context, w w2) throws FileNotFoundException {
        if (w2.e == 0 && w2.d != null) {
            String string = w2.d.getAuthority();
            if (string != null) {
                try {
                    Resources resources = context.getPackageManager().getResourcesForApplication(string);
                    return resources;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to obtain resources for package: ");
                    stringBuilder.append((Object)w2.d);
                    throw new FileNotFoundException(stringBuilder.toString());
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No package provided: ");
            stringBuilder.append((Object)w2.d);
            throw new FileNotFoundException(stringBuilder.toString());
        }
        return context.getResources();
    }

    static j a(Context context) {
        try {
            Class.forName((String)"com.squareup.okhttp.OkHttpClient");
            j j2 = c.a(context);
            return j2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return new af(context);
        }
    }

    static <T> T a(Context context, String string) {
        return (T)context.getSystemService(string);
    }

    static <T> T a(T t2, String string) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(string);
    }

    static String a(com.a.a.c c2) {
        return ag.a(c2, "");
    }

    static String a(com.a.a.c c2, String string) {
        List<com.a.a.a> list;
        StringBuilder stringBuilder = new StringBuilder(string);
        com.a.a.a a2 = c2.i();
        if (a2 != null) {
            stringBuilder.append(a2.b.a());
        }
        if ((list = c2.k()) != null) {
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (i2 > 0 || a2 != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((com.a.a.a)list.get((int)i2)).b.a());
            }
        }
        return stringBuilder.toString();
    }

    static String a(w w2) {
        String string = ag.a(w2, a);
        a.setLength(0);
        return string;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static String a(w var0, StringBuilder var1_1) {
        block12 : {
            block11 : {
                block10 : {
                    block9 : {
                        if (var0.f == null) break block9;
                        var1_1.ensureCapacity(50 + var0.f.length());
                        var23_2 = var0.f;
                        ** GOTO lbl9
                    }
                    if (var0.d != null) {
                        var23_2 = var0.d.toString();
                        var1_1.ensureCapacity(50 + var23_2.length());
lbl9: // 2 sources:
                        var1_1.append(var23_2);
                    } else {
                        var1_1.ensureCapacity(50);
                        var1_1.append(var0.e);
                    }
                    var1_1.append('\n');
                    if (var0.m != 0.0f) {
                        var1_1.append("rotation:");
                        var1_1.append(var0.m);
                        if (var0.p) {
                            var1_1.append('@');
                            var1_1.append(var0.n);
                            var1_1.append('x');
                            var1_1.append(var0.o);
                        }
                        var1_1.append('\n');
                    }
                    if (var0.d()) {
                        var1_1.append("resize:");
                        var1_1.append(var0.h);
                        var1_1.append('x');
                        var1_1.append(var0.i);
                        var1_1.append('\n');
                    }
                    if (!var0.j) break block10;
                    var8_3 = "centerCrop";
                    break block11;
                }
                if (!var0.k) break block12;
                var8_3 = "centerInside";
            }
            var1_1.append(var8_3);
            var1_1.append('\n');
        }
        if (var0.g == null) return var1_1.toString();
        var4_4 = 0;
        var5_5 = var0.g.size();
        while (var4_4 < var5_5) {
            var1_1.append(((ae)var0.g.get(var4_4)).a());
            var1_1.append('\n');
            ++var4_4;
        }
        return var1_1.toString();
    }

    static void a() {
        if (ag.b()) {
            return;
        }
        throw new IllegalStateException("Method call should happen from the main thread.");
    }

    static void a(Looper looper) {
        Handler handler = new Handler(looper){

            public void handleMessage(Message message) {
                this.sendMessageDelayed(this.obtainMessage(), 1000L);
            }
        };
        handler.sendMessageDelayed(handler.obtainMessage(), 1000L);
    }

    static void a(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        }
        catch (IOException iOException) {}
    }

    static void a(String string, String string2, String string3) {
        ag.a(string, string2, string3, "");
    }

    static void a(String string, String string2, String string3, String string4) {
        Log.d((String)"Picasso", (String)String.format((String)"%1$-11s %2$-12s %3$s %4$s", (Object[])new Object[]{string, string2, string3, string4}));
    }

    /*
     * Exception decompiling
     */
    static boolean a(String var0) {
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
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static boolean b(Context context, String string) {
        return context.checkCallingOrSelfPermission(string) == 0;
    }

    static byte[] b(InputStream inputStream) throws IOException {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[4096];
        while (-1 != (n2 = inputStream.read(arrby))) {
            byteArrayOutputStream.write(arrby, 0, n2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    static int c(Context context) {
        ActivityManager activityManager = (ActivityManager)ag.a(context, "activity");
        boolean bl = (1048576 & context.getApplicationInfo().flags) != 0;
        int n2 = activityManager.getMemoryClass();
        if (bl && Build.VERSION.SDK_INT >= 11) {
            n2 = a.a(activityManager);
        }
        return n2 * 1048576 / 7;
    }

    static boolean c(InputStream inputStream) throws IOException {
        byte[] arrby = new byte[12];
        int n2 = inputStream.read(arrby, 0, 12);
        boolean bl = false;
        if (n2 == 12) {
            boolean bl2 = "RIFF".equals((Object)new String(arrby, 0, 4, "US-ASCII"));
            bl = false;
            if (bl2) {
                boolean bl3 = "WEBP".equals((Object)new String(arrby, 8, 4, "US-ASCII"));
                bl = false;
                if (bl3) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    /*
     * Exception decompiling
     */
    static boolean d(Context var0) {
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
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    @TargetApi(value=11)
    private static class a {
        static int a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(value=12)
    private static class b {
        static int a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    private static class c {
        static j a(Context context) {
            return new s(context);
        }
    }

    private static class d
    extends Thread {
        public d(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority((int)10);
            super.run();
        }
    }

    static class e
    implements ThreadFactory {
        e() {
        }

        public Thread newThread(Runnable runnable) {
            return new d(runnable);
        }
    }

}

