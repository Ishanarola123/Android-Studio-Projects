/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.f
 *  d.g
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Method
 *  java.util.concurrent.Executor
 */
package d;

import d.c;
import d.f;
import d.g;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

class j {
    private static final j a = j.c();

    j() {
    }

    static j a() {
        return a;
    }

    /*
     * Exception decompiling
     */
    private static j c() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl12.3 : FAKE_TRY : trying to set 1 previously set to 0
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

    c.a a(Executor executor) {
        if (executor != null) {
            return new g(executor);
        }
        return f.a;
    }

    /* varargs */ Object a(Method method, Class<?> class_, Object object, Object ... arrobject) throws Throwable {
        throw new UnsupportedOperationException();
    }

    boolean a(Method method) {
        return false;
    }

    Executor b() {
        return null;
    }
}

