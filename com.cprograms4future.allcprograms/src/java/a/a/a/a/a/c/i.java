/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicReference
 */
package a.a.a.a.a.c;

import a.a.a.a.a.c.b;
import a.a.a.a.a.c.e;
import a.a.a.a.a.c.h;
import a.a.a.a.a.c.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class i
implements b<k>,
h,
k {
    private final List<k> a = new ArrayList();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> c = new AtomicReference(null);

    /*
     * Exception decompiling
     */
    public static boolean a(Object var0) {
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

    public Collection<k> a() {
        i i2 = this;
        synchronized (i2) {
            Collection collection = Collections.unmodifiableCollection(this.a);
            return collection;
        }
    }

    public void a(k k2) {
        i i2 = this;
        synchronized (i2) {
            this.a.add((Object)k2);
            return;
        }
    }

    @Override
    public void a(Throwable throwable) {
        this.c.set((Object)throwable);
    }

    @Override
    public e b() {
        return e.b;
    }

    @Override
    public void b(boolean bl) {
        i i2 = this;
        synchronized (i2) {
            this.b.set(bl);
            return;
        }
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((k)object);
    }

    @Override
    public boolean c() {
        Iterator iterator = this.a().iterator();
        while (iterator.hasNext()) {
            if (((k)iterator.next()).f()) continue;
            return false;
        }
        return true;
    }

    public int compareTo(Object object) {
        return e.a(this, object);
    }

    @Override
    public boolean f() {
        return this.b.get();
    }
}

