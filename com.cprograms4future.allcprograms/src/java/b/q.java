/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.security.cert.Certificate
 *  java.util.List
 *  javax.net.ssl.SSLSession
 */
package b;

import b.a.i;
import b.ae;
import b.h;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLSession;

public final class q {
    private final ae a;
    private final h b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private q(ae ae2, h h2, List<Certificate> list, List<Certificate> list2) {
        this.a = ae2;
        this.b = h2;
        this.c = list;
        this.d = list2;
    }

    /*
     * Exception decompiling
     */
    public static q a(SSLSession var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl23 : ALOAD : trying to set 1 previously set to 0
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

    public h a() {
        return this.b;
    }

    public List<Certificate> b() {
        return this.c;
    }

    public boolean equals(Object object) {
        if (!(object instanceof q)) {
            return false;
        }
        q q2 = (q)object;
        boolean bl = i.a((Object)this.b, (Object)q2.b);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.b.equals((Object)q2.b);
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.c.equals(q2.c);
                bl2 = false;
                if (bl4) {
                    boolean bl5 = this.d.equals(q2.d);
                    bl2 = false;
                    if (bl5) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        return 31 * (31 * (31 * (527 + n2) + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode();
    }
}

