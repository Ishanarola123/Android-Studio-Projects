/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package b;

import b.a.b.g;
import b.a.c;
import b.a.e;
import b.ab;
import b.f;
import b.n;
import b.s;
import b.t;
import b.w;
import b.y;
import b.z;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class y
implements b.e {
    volatile boolean a;
    z b;
    g c;
    private final w d;
    private boolean e;

    protected y(w w2, z z2) {
        this.d = w2;
        this.b = z2;
    }

    static /* synthetic */ ab a(y y2, boolean bl) throws IOException {
        return y2.a(bl);
    }

    private ab a(boolean bl) throws IOException {
        return new a(0, this.b, bl).a(this.b);
    }

    static /* synthetic */ String a(y y2) {
        return y2.c();
    }

    private String c() {
        String string = this.a ? "canceled call" : "call";
        s s2 = this.b.a().c("/...");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" to ");
        stringBuilder.append((Object)s2);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public ab a() throws IOException {
        y y2 = this;
        synchronized (y2) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        try {
            this.d.s().a(this);
            ab ab2 = this.a(false);
            if (ab2 != null) {
                return ab2;
            }
            throw new IOException("Canceled");
        }
        finally {
            this.d.s().a((b.e)this);
        }
    }

    /*
     * Exception decompiling
     */
    ab a(z var1_1, boolean var2_2) throws IOException {
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
    public void a(f f2) {
        this.a(f2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(f f2, boolean bl) {
        y y2 = this;
        synchronized (y2) {
            if (!this.e) {
                this.e = true;
                // MONITOREXIT [2, 3] lbl5 : w: MONITOREXIT : var4_3
                this.d.s().a(new b(f2, bl));
                return;
            }
            throw new IllegalStateException("Already Executed");
        }
    }

    @Override
    public void b() {
        this.a = true;
        if (this.c != null) {
            this.c.f();
        }
    }

    class a
    implements t.a {
        private final int b;
        private final z c;
        private final boolean d;

        a(int n2, z z2, boolean bl) {
            this.b = n2;
            this.c = z2;
            this.d = bl;
        }

        @Override
        public ab a(z z2) throws IOException {
            if (this.b < y.this.d.v().size()) {
                a a2 = new a(1 + this.b, z2, this.d);
                t t2 = (t)y.this.d.v().get(this.b);
                ab ab2 = t2.a(a2);
                if (ab2 != null) {
                    return ab2;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("application interceptor ");
                stringBuilder.append((Object)t2);
                stringBuilder.append(" returned null");
                throw new NullPointerException(stringBuilder.toString());
            }
            return y.this.a(z2, this.d);
        }

        @Override
        public z a() {
            return this.c;
        }
    }

    final class b
    extends e {
        private final f c;
        private final boolean d;

        private b(f f2, boolean bl) {
            Object[] arrobject = new Object[]{y.this.b.a().toString()};
            super("OkHttp %s", arrobject);
            this.c = f2;
            this.d = bl;
        }

        String a() {
            return y.this.b.a().f();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @Override
        protected void b() {
            block7 : {
                var1_1 = true;
                try {
                    var10_2 = y.a(y.this, this.d);
                    var11_3 = y.this.a;
                    if (!var11_3) ** GOTO lbl10
                    this.c.a((b.e)y.this, new IOException("Canceled"));
                    break block7;
lbl10: // 1 sources:
                    this.c.a((b.e)y.this, var10_2);
                    break block7;
                }
                catch (Throwable var4_4) {
                    ** GOTO lbl18
                }
                catch (IOException var2_5) {
                    block8 : {
                        var3_6 = var2_5;
                        var1_1 = false;
                        break block8;
lbl18: // 1 sources:
                        y.b(y.this).s().b(this);
                        throw var4_4;
                        catch (IOException var3_7) {}
                    }
                    if (var1_1) {
                        var5_8 = c.a;
                        var6_9 = Level.INFO;
                        var7_10 = new StringBuilder();
                        var7_10.append("Callback failure for ");
                        var7_10.append(y.a(y.this));
                        var5_8.log(var6_9, var7_10.toString(), (Throwable)var3_6);
                    }
                    this.c.a((b.e)y.this, var3_6);
                }
            }
            y.b(y.this).s().b(this);
        }
    }

}

