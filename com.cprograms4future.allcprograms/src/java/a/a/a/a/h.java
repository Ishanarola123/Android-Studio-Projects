/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 */
package a.a.a.a;

import a.a.a.a.a.b.r;
import a.a.a.a.a.c.e;
import a.a.a.a.a.c.f;
import a.a.a.a.g;
import a.a.a.a.i;

class h<Result>
extends f<Void, Void, Result> {
    final i<Result> a;

    public h(i<Result> i2) {
        this.a = i2;
    }

    private r a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.b());
        stringBuilder.append(".");
        stringBuilder.append(string);
        r r2 = new r(stringBuilder.toString(), "KitInitialization");
        r2.a();
        return r2;
    }

    protected /* varargs */ Result a(Void ... arrvoid) {
        r r2 = this.a("doInBackground");
        Result Result = !this.e() ? (Result)this.a.d() : null;
        r2.b();
        return Result;
    }

    /*
     * Exception decompiling
     */
    @Override
    protected void a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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
    protected void a(Result Result) {
        this.a.a(Result);
        this.a.h.a(Result);
    }

    @Override
    public e b() {
        return e.c;
    }

    @Override
    protected void b(Result Result) {
        this.a.b(Result);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.b());
        stringBuilder.append(" Initialization was cancelled");
        g g2 = new g(stringBuilder.toString());
        this.a.h.a((Exception)((Object)g2));
    }
}

