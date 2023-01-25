/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.b.g$1
 *  b.a.b.g$2
 *  b.a.b.g$a
 *  b.a.b.k
 *  b.a.b.n
 *  b.a.c.b
 *  b.w
 *  c.c
 *  c.d
 *  c.e
 *  c.j
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.ProxySelector
 *  java.util.Date
 *  java.util.List
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSocketFactory
 */
package b.a.b;

import b.a.b.b;
import b.a.b.g;
import b.a.b.h;
import b.a.b.k;
import b.a.b.l;
import b.a.b.n;
import b.a.c;
import b.a.d;
import b.a.i;
import b.a.j;
import b.aa;
import b.ab;
import b.ac;
import b.ad;
import b.m;
import b.o;
import b.q;
import b.r;
import b.s;
import b.w;
import b.x;
import b.z;
import c.e;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.Date;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/*
 * Exception performing whole class analysis.
 */
public final class g {
    private static final ac e;
    final w a;
    public final b.a.b.r b;
    long c;
    public final boolean d;
    private final ab f;
    private b.a.b.i g;
    private boolean h;
    private final z i;
    private z j;
    private ab k;
    private ab l;
    private c.q m;
    private c.d n;
    private final boolean o;
    private final boolean p;
    private b.a.b.a q;
    private b r;

    static {
        e = new 1();
    }

    public g(w w2, z z2, boolean bl, boolean bl2, boolean bl3, b.a.b.r r2, n n2, ab ab2) {
        this.c = -1L;
        this.a = w2;
        this.i = z2;
        this.d = bl;
        this.o = bl2;
        this.p = bl3;
        if (r2 == null) {
            r2 = new b.a.b.r(w2.o(), g.a(w2, z2));
        }
        this.b = r2;
        this.m = n2;
        this.f = ab2;
    }

    static /* synthetic */ b.a.b.i a(g g2) {
        return g2.g;
    }

    private static b.a a(w w2, z z2) {
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        b.g g2;
        if (z2.g()) {
            SSLSocketFactory sSLSocketFactory2 = w2.j();
            HostnameVerifier hostnameVerifier2 = w2.k();
            b.g g3 = w2.l();
            hostnameVerifier = hostnameVerifier2;
            sSLSocketFactory = sSLSocketFactory2;
            g2 = g3;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            g2 = null;
        }
        b.a a2 = new b.a(z2.a().f(), z2.a().g(), w2.h(), w2.i(), sSLSocketFactory, hostnameVerifier, g2, w2.n(), w2.d(), (List<x>)w2.t(), (List<b.k>)w2.u(), w2.e());
        return a2;
    }

    private ab a(b.a.b.a a2, ab ab2) throws IOException {
        if (a2 == null) {
            return ab2;
        }
        c.q q2 = a2.a();
        if (q2 == null) {
            return ab2;
        }
        2 var4_4 = new 2(this, ab2.f().d(), a2, c.l.a(q2));
        return ab2.g().a((ac)new k(ab2.e(), c.l.a((c.r)var4_4))).a();
    }

    private static r a(r r2, r r3) throws IOException {
        r.a a2 = new r.a();
        int n2 = r2.a();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = r2.a(i2);
            String string2 = r2.b(i2);
            if ("Warning".equalsIgnoreCase(string) && string2.startsWith("1") || b.a.b.j.a(string) && r3.a(string) != null) continue;
            a2.a(string, string2);
        }
        int n4 = r3.a();
        while (n3 < n4) {
            String string = r3.a(n3);
            if (!"Content-Length".equalsIgnoreCase(string) && b.a.b.j.a(string)) {
                a2.a(string, r3.b(n3));
            }
            ++n3;
        }
        return a2.a();
    }

    static /* synthetic */ z a(g g2, z z2) {
        g2.j = z2;
        return z2;
    }

    private String a(List<b.l> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuilder.append("; ");
            }
            b.l l2 = (b.l)list.get(i2);
            stringBuilder.append(l2.a());
            stringBuilder.append('=');
            stringBuilder.append(l2.b());
        }
        return stringBuilder.toString();
    }

    public static boolean a(ab ab2) {
        if (ab2.a().b().equals((Object)"HEAD")) {
            return false;
        }
        int n2 = ab2.b();
        if ((n2 < 100 || n2 >= 200) && n2 != 204 && n2 != 304) {
            return true;
        }
        if (b.a.b.j.a(ab2) == -1L) {
            return "chunked".equalsIgnoreCase(ab2.a("Transfer-Encoding"));
        }
        return true;
    }

    private static boolean a(ab ab2, ab ab3) {
        Date date;
        if (ab3.b() == 304) {
            return true;
        }
        Date date2 = ab2.e().b("Last-Modified");
        return date2 != null && (date = ab3.e().b("Last-Modified")) != null && date.getTime() < date2.getTime();
    }

    static /* synthetic */ ab b(g g2) throws IOException {
        return g2.m();
    }

    private static ab b(ab ab2) {
        if (ab2 != null && ab2.f() != null) {
            ab2 = ab2.g().a((ac)null).a();
        }
        return ab2;
    }

    private z b(z z2) throws IOException {
        List<b.l> list;
        z.a a2 = z2.e();
        if (z2.a("Host") == null) {
            a2.a("Host", i.a(z2.a(), false));
        }
        if (z2.a("Connection") == null) {
            a2.a("Connection", "Keep-Alive");
        }
        if (z2.a("Accept-Encoding") == null) {
            this.h = true;
            a2.a("Accept-Encoding", "gzip");
        }
        if (!(list = this.a.f().a(z2.a())).isEmpty()) {
            a2.a("Cookie", this.a(list));
        }
        if (z2.a("User-Agent") == null) {
            a2.a("User-Agent", j.a());
        }
        return a2.a();
    }

    private ab c(ab ab2) throws IOException {
        if (this.h) {
            if (!"gzip".equalsIgnoreCase(this.l.a("Content-Encoding"))) {
                return ab2;
            }
            if (ab2.f() == null) {
                return ab2;
            }
            c.j j2 = new c.j((c.r)ab2.f().d());
            r r2 = ab2.e().b().b("Content-Encoding").b("Content-Length").a();
            ab2 = ab2.g().a(r2).a((ac)new k(r2, c.l.a((c.r)j2))).a();
        }
        return ab2;
    }

    private boolean j() {
        return this.o && this.a(this.j) && this.m == null;
    }

    private b.a.b.i k() throws b.a.b.o, l, IOException {
        boolean bl = true ^ this.j.b().equals((Object)"GET");
        return this.b.a(this.a.a(), this.a.b(), this.a.c(), this.a.r(), bl);
    }

    /*
     * Exception decompiling
     */
    private void l() throws IOException {
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

    private ab m() throws IOException {
        this.g.c();
        ab ab2 = this.g.b().a(this.j).a(this.b.a().d()).a(b.a.b.j.b, Long.toString((long)this.c)).a(b.a.b.j.c, Long.toString((long)System.currentTimeMillis())).a();
        if (!this.p) {
            ab2 = ab2.g().a(this.g.a(ab2)).a();
        }
        if ("close".equalsIgnoreCase(ab2.a().a("Connection")) || "close".equalsIgnoreCase(ab2.a("Connection"))) {
            this.b.c();
        }
        return ab2;
    }

    public g a(IOException iOException, c.q q2) {
        if (!this.b.a(iOException, q2)) {
            return null;
        }
        if (!this.a.r()) {
            return null;
        }
        b.a.b.r r2 = this.g();
        g g2 = new g(this.a, this.i, this.d, this.o, this.p, r2, (n)q2, this.f);
        return g2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() throws l, b.a.b.o, IOException {
        ab ab2;
        z z2;
        block17 : {
            ab ab3;
            block16 : {
                block15 : {
                    if (this.r != null) {
                        return;
                    }
                    if (this.g != null) {
                        throw new IllegalStateException();
                    }
                    z2 = this.b(this.i);
                    d d2 = c.b.a(this.a);
                    ab2 = d2 != null ? d2.a(z2) : null;
                    this.r = new b.a(System.currentTimeMillis(), z2, ab2).a();
                    this.j = this.r.a;
                    this.k = this.r.b;
                    if (d2 != null) {
                        d2.a(this.r);
                    }
                    if (ab2 != null && this.k == null) {
                        i.a(ab2.f());
                    }
                    if (this.j != null || this.k != null) break block15;
                    ab3 = new ab.a().a(this.i).c(g.b(this.f)).a(x.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(e).a();
                    break block16;
                }
                if (this.j != null) break block17;
                this.l = this.k.g().a(this.i).c(g.b(this.f)).b(g.b(this.k)).a();
                ab3 = this.c(this.l);
            }
            this.l = ab3;
            return;
        }
        try {
            void var7_7;
            this.g = this.k();
            this.g.a(this);
            if (!this.j()) {
                return;
            }
            long l2 = b.a.b.j.a(z2);
            if (this.d) {
                if (l2 > Integer.MAX_VALUE) {
                    throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                }
                if (l2 != -1L) {
                    this.g.a(this.j);
                    this.m = new n((int)l2);
                    return;
                }
                n n2 = new n();
            } else {
                this.g.a(this.j);
                c.q q2 = this.g.a(this.j, l2);
            }
            this.m = var7_7;
            return;
        }
        catch (Throwable throwable) {
            if (ab2 != null) {
                i.a(ab2.f());
            }
            throw throwable;
        }
    }

    public void a(r r2) throws IOException {
        if (this.a.f() == m.a) {
            return;
        }
        List<b.l> list = b.l.a(this.i.a(), r2);
        if (list.isEmpty()) {
            return;
        }
        this.a.f().a(this.i.a(), list);
    }

    public boolean a(s s2) {
        s s3 = this.i.a();
        return s3.f().equals((Object)s2.f()) && s3.g() == s2.g() && s3.b().equals((Object)s2.b());
    }

    boolean a(z z2) {
        return h.c(z2.b());
    }

    public void b() {
        if (this.c == -1L) {
            this.c = System.currentTimeMillis();
            return;
        }
        throw new IllegalStateException();
    }

    public ab c() {
        if (this.l != null) {
            return this.l;
        }
        throw new IllegalStateException();
    }

    public b.i d() {
        return this.b.a();
    }

    public void e() throws IOException {
        this.b.b();
    }

    public void f() {
        this.b.d();
    }

    /*
     * Enabled aggressive block sorting
     */
    public b.a.b.r g() {
        block6 : {
            void var1_2;
            block5 : {
                block4 : {
                    if (this.n == null) break block4;
                    c.d d2 = this.n;
                    break block5;
                }
                if (this.m == null) break block6;
                c.q q2 = this.m;
            }
            i.a((Closeable)var1_2);
        }
        if (this.l != null) {
            i.a(this.l.f());
            return this.b;
        }
        this.b.a((IOException)null);
        return this.b;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void h() throws IOException {
        block14 : {
            if (this.l != null) {
                return;
            }
            if (this.j == null) {
                if (this.k == null) throw new IllegalStateException("call sendRequest() first!");
            }
            if (this.j == null) {
                return;
            }
            if (!this.p) break block14;
            this.g.a(this.j);
            ** GOTO lbl28
        }
        if (!this.o) {
            var1_1 = new /* Unavailable Anonymous Inner Class!! */.a(this.j);
        } else {
            if (this.n != null && this.n.c().b() > 0L) {
                this.n.f();
            }
            if (this.c == -1L) {
                if (b.a.b.j.a(this.j) == -1L && this.m instanceof n) {
                    var3_2 = ((n)this.m).b();
                    this.j = this.j.e().a("Content-Length", Long.toString((long)var3_2)).a();
                }
                this.g.a(this.j);
            }
            if (this.m != null) {
                if (this.n != null) {
                    this.n.close();
                } else {
                    this.m.close();
                }
                if (this.m instanceof n) {
                    this.g.a((n)this.m);
                }
            }
lbl28: // 6 sources:
            var1_1 = this.m();
        }
        this.a(var1_1.e());
        if (this.k != null) {
            if (g.a(this.k, var1_1)) {
                this.l = this.k.g().a(this.i).c(g.b(this.f)).a(g.a(this.k.e(), var1_1.e())).b(g.b(this.k)).a(g.b(var1_1)).a();
                var1_1.f().close();
                this.e();
                var2_3 = c.b.a(this.a);
                var2_3.a();
                var2_3.a(this.k, g.b(this.l));
                this.l = this.c(this.l);
                return;
            }
            i.a(this.k.f());
        }
        this.l = var1_1.g().a(this.i).c(g.b(this.f)).b(g.b(this.k)).a(g.b(var1_1)).a();
        if (g.a(this.l) == false) return;
        this.l();
        this.l = this.c(this.a(this.q, this.l));
    }

    public z i() throws IOException {
        if (this.l != null) {
            b.a.c.b b2 = this.b.a();
            ad ad2 = b2 != null ? b2.a() : null;
            int n2 = this.l.b();
            String string = this.i.b();
            switch (n2) {
                default: {
                    return null;
                }
                case 408: {
                    boolean bl = this.m == null || this.m instanceof n;
                    if (this.o && !bl) {
                        return null;
                    }
                    return this.i;
                }
                case 407: {
                    Proxy proxy = ad2 != null ? ad2.b() : this.a.d();
                    if (proxy.type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                }
                case 401: {
                    return this.a.m().a(ad2, this.l);
                }
                case 307: 
                case 308: {
                    if (string.equals((Object)"GET") || string.equals((Object)"HEAD")) break;
                    return null;
                }
                case 300: 
                case 301: 
                case 302: 
                case 303: 
            }
            if (!this.a.q()) {
                return null;
            }
            String string2 = this.l.a("Location");
            if (string2 == null) {
                return null;
            }
            s s2 = this.i.a().c(string2);
            if (s2 == null) {
                return null;
            }
            if (!s2.b().equals((Object)this.i.a().b()) && !this.a.p()) {
                return null;
            }
            z.a a2 = this.i.e();
            if (h.c(string)) {
                if (h.d(string)) {
                    string = "GET";
                }
                a2.a(string, (aa)null);
                a2.a("Transfer-Encoding");
                a2.a("Content-Length");
                a2.a("Content-Type");
            }
            if (!this.a(s2)) {
                a2.a("Authorization");
            }
            return a2.a(s2).a();
        }
        throw new IllegalStateException();
    }
}

