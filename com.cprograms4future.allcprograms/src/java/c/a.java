/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 */
package c;

import c.c;
import c.q;
import c.r;
import c.s;
import java.io.IOException;
import java.io.InterruptedIOException;

public class a
extends s {
    private static a a;
    private boolean c;
    private a d;
    private long e;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(a a2, long l2, boolean bl) {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
                new Thread(){
                    {
                        this.setDaemon(true);
                    }

                    /*
                     * Exception decompiling
                     */
                    public void run() {
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
                        // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                        // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
                }.start();
            }
            long l3 = System.nanoTime();
            if (l2 != 0L && bl) {
                a2.e = l3 + Math.min((long)l2, (long)(a2.d() - l3));
            } else if (l2 != 0L) {
                a2.e = l2 + l3;
            } else {
                if (!bl) {
                    throw new AssertionError();
                }
                a2.e = a2.d();
            }
            long l4 = a2.b(l3);
            a a3 = a;
            while (a3.d != null && l4 >= a3.d.b(l3)) {
                a3 = a3.d;
            }
            a2.d = a3.d;
            a3.d = a2;
            if (a3 == a) {
                a.class.notify();
            }
            // ** MonitorExit[var10_3] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(a a2) {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            a a3 = a;
            while (a3 != null) {
                block6 : {
                    if (a3.d != a2) break block6;
                    a3.d = a2.d;
                    a2.d = null;
                    return false;
                }
                a3 = a3.d;
            }
            return true;
        }
    }

    private long b(long l2) {
        return this.e - l2;
    }

    static /* synthetic */ a e() throws InterruptedException {
        return a.h();
    }

    private static a h() throws InterruptedException {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            a a2;
            block8 : {
                block7 : {
                    a2 = a.a.d;
                    if (a2 != null) break block7;
                    a.class.wait();
                    // ** MonitorExit[var6] (shouldn't be in output)
                    return null;
                }
                long l2 = a2.b(System.nanoTime());
                if (l2 <= 0L) break block8;
                long l3 = l2 / 1000000L;
                a.class.wait(l3, (int)(l2 - 1000000L * l3));
                // ** MonitorExit[var6] (shouldn't be in output)
                return null;
            }
            a.a.d = a2.d;
            a2.d = null;
            // ** MonitorExit[var6] (shouldn't be in output)
            return a2;
        }
    }

    public final q a(final q q2) {
        return new q(){

            @Override
            public s a() {
                return a.this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void a_(c c2, long l2) throws IOException {
                Throwable throwable2222;
                a.this.c();
                q2.a_(c2, l2);
                a.this.a(true);
                return;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (IOException iOException) {}
                    {
                        throw a.this.b(iOException);
                    }
                }
                a.this.a(false);
                throw throwable2222;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void close() throws IOException {
                Throwable throwable2222;
                a.this.c();
                q2.close();
                a.this.a(true);
                return;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (IOException iOException) {}
                    {
                        throw a.this.b(iOException);
                    }
                }
                a.this.a(false);
                throw throwable2222;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void flush() throws IOException {
                Throwable throwable2222;
                a.this.c();
                q2.flush();
                a.this.a(true);
                return;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (IOException iOException) {}
                    {
                        throw a.this.b(iOException);
                    }
                }
                a.this.a(false);
                throw throwable2222;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AsyncTimeout.sink(");
                stringBuilder.append((Object)q2);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    public final r a(final r r2) {
        return new r(){

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public long a(c c2, long l2) throws IOException {
                Throwable throwable2222;
                a.this.c();
                long l3 = r2.a(c2, l2);
                a.this.a(true);
                return l3;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (IOException iOException) {}
                    {
                        throw a.this.b(iOException);
                    }
                }
                a.this.a(false);
                throw throwable2222;
            }

            @Override
            public s a() {
                return a.this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void close() throws IOException {
                Throwable throwable2222;
                r2.close();
                a.this.a(true);
                return;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (IOException iOException) {}
                    {
                        throw a.this.b(iOException);
                    }
                }
                a.this.a(false);
                throw throwable2222;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AsyncTimeout.source(");
                stringBuilder.append((Object)r2);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    protected IOException a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause((Throwable)iOException);
        }
        return interruptedIOException;
    }

    protected void a() {
    }

    final void a(boolean bl) throws IOException {
        if (this.z_()) {
            if (!bl) {
                return;
            }
            throw this.a((IOException)null);
        }
    }

    final IOException b(IOException iOException) throws IOException {
        if (!this.z_()) {
            return iOException;
        }
        return this.a(iOException);
    }

    public final void c() {
        if (!this.c) {
            long l2 = this.A_();
            boolean bl = this.B_();
            if (l2 == 0L && !bl) {
                return;
            }
            this.c = true;
            a.a(this, l2, bl);
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean z_() {
        if (!this.c) {
            return false;
        }
        this.c = false;
        return a.a(this);
    }

}

