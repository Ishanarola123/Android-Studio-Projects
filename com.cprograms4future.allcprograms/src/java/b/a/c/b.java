/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.net.ConnectException
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.Socket
 *  java.net.UnknownServiceException
 *  java.security.Principal
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLSession
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 */
package b.a.c;

import b.a.a;
import b.a.a.d;
import b.a.a.e;
import b.a.b.o;
import b.a.g;
import b.a.i;
import b.a.j;
import b.ab;
import b.ad;
import b.h;
import b.k;
import b.q;
import b.r;
import b.s;
import b.x;
import b.z;
import c.c;
import c.l;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class b
extends d.b
implements b.i {
    public Socket b;
    public volatile d c;
    public int d;
    public c.e e;
    public c.d f;
    public int g;
    public final List<Reference<b.a.b.r>> h = new ArrayList();
    public boolean i;
    public long j = Long.MAX_VALUE;
    private final ad k;
    private Socket l;
    private q m;
    private x n;

    public b(ad ad2) {
        this.k = ad2;
    }

    private void a(int n2, int n3) throws IOException {
        block3 : {
            ab ab2;
            block4 : {
                z z2 = this.e();
                s s2 = z2.a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CONNECT ");
                stringBuilder.append(i.a(s2, true));
                stringBuilder.append(" HTTP/1.1");
                String string = stringBuilder.toString();
                do {
                    b.a.b.d d2 = new b.a.b.d(null, this.e, this.f);
                    this.e.a().a(n2, TimeUnit.MILLISECONDS);
                    this.f.a().a(n3, TimeUnit.MILLISECONDS);
                    d2.a(z2.c(), string);
                    d2.c();
                    ab2 = d2.d().a(z2).a();
                    long l2 = b.a.b.j.a(ab2);
                    if (l2 == -1L) {
                        l2 = 0L;
                    }
                    c.r r2 = d2.b(l2);
                    i.b(r2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
                    r2.close();
                    int n4 = ab2.b();
                    if (n4 == 200) break block3;
                    if (n4 != 407) break block4;
                } while ((z2 = this.k.a().d().a(this.k, ab2)) != null);
                throw new IOException("Failed to authenticate with proxy");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected response code for CONNECT: ");
            stringBuilder.append(ab2.b());
            throw new IOException(stringBuilder.toString());
        }
        if (this.e.c().g() && this.f.c().g()) {
            return;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private void a(int n2, int n3, int n4, a a2) throws IOException {
        this.l.setSoTimeout(n3);
        try {
            g.a().a(this.l, this.k.c(), n2);
        }
        catch (ConnectException connectException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to connect to ");
            stringBuilder.append((Object)this.k.c());
            throw new ConnectException(stringBuilder.toString());
        }
        this.e = l.a(l.b(this.l));
        this.f = l.a(l.a(this.l));
        if (this.k.a().i() != null) {
            this.a(n3, n4, a2);
        } else {
            this.n = x.b;
            this.b = this.l;
        }
        if (this.n != x.c && this.n != x.d) {
            this.g = 1;
            return;
        }
        this.b.setSoTimeout(0);
        d d2 = new d.a(true).a(this.b, this.k.a().a().f(), this.e, this.f).a(this.n).a(this).a();
        d2.d();
        this.g = d2.b();
        this.c = d2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(int var1_1, int var2_2, a var3_3) throws IOException {
        block14 : {
            block13 : {
                if (this.k.d()) {
                    this.a(var1_1, var2_2);
                }
                var4_4 = this.k.a();
                var5_5 = var4_4.i();
                var6_6 = null;
                var9_7 = (SSLSocket)var5_5.createSocket(this.l, var4_4.a().f(), var4_4.a().g(), true);
                var10_8 = var3_3.a(var9_7);
                if (var10_8.d()) {
                    g.a().a(var9_7, var4_4.a().f(), var4_4.e());
                }
                var9_7.startHandshake();
                var11_9 = q.a(var9_7.getSession());
                if (!var4_4.j().verify(var4_4.a().f(), var9_7.getSession())) break block13;
                var4_4.k().a(var4_4.a().f(), var11_9.b());
                var23_10 = var10_8.d();
                var24_11 = null;
                if (var23_10) {
                    var24_11 = g.a().b(var9_7);
                }
                this.b = var9_7;
                this.e = l.a(l.b(this.b));
                this.f = l.a(l.a(this.b));
                this.m = var11_9;
                var25_12 = var24_11 != null ? x.a(var24_11) : x.b;
                this.n = var25_12;
                if (var9_7 == null) return;
                g.a().a(var9_7);
                return;
            }
            try {
                var12_13 = (X509Certificate)var11_9.b().get(0);
                var13_14 = new StringBuilder();
                var13_14.append("Hostname ");
                var13_14.append(var4_4.a().f());
                var13_14.append(" not verified:");
                var13_14.append("\n    certificate: ");
                var13_14.append(b.g.a((Certificate)var12_13));
                var13_14.append("\n    DN: ");
                var13_14.append(var12_13.getSubjectDN().getName());
                var13_14.append("\n    subjectAltNames: ");
                var13_14.append(b.a.d.d.a(var12_13));
                throw new SSLPeerUnverifiedException(var13_14.toString());
            }
            catch (Throwable var8_15) {}
            catch (AssertionError var7_18) {
                var6_6 = var9_7;
            }
            ** finally { 
lbl47: // 1 sources:
            break block14;
            catch (Throwable var8_16) {
                var9_7 = var6_6;
                break block14;
            }
            catch (AssertionError var7_19) {
                // empty catch block
            }
            {
                if (i.a((AssertionError)var7_20) == false) throw var7_20;
                throw new IOException((Throwable)var7_20);
            }
        }
        if (var9_7 != null) {
            g.a().a(var9_7);
        }
        i.a(var9_7);
        throw var8_17;
    }

    private z e() throws IOException {
        return new z.a().a(this.k.a().a()).a("Host", i.a(this.k.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", j.a()).a();
    }

    @Override
    public ad a() {
        return this.k;
    }

    public void a(int n2, int n3, int n4, List<k> list, boolean bl) throws o {
        if (this.n == null) {
            a a2 = new a(list);
            Proxy proxy = this.k.b();
            b.a a3 = this.k.a();
            if (this.k.a().i() == null && !list.contains((Object)k.c)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CLEARTEXT communication not supported: ");
                stringBuilder.append(list);
                throw new o((IOException)new UnknownServiceException(stringBuilder.toString()));
            }
            o o2 = null;
            while (this.n == null) {
                try {
                    Socket socket = proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.HTTP ? new Socket(proxy) : a3.c().createSocket();
                    this.l = socket;
                    this.a(n2, n3, n4, a2);
                }
                catch (IOException iOException) {
                    i.a(this.b);
                    i.a(this.l);
                    this.b = null;
                    this.l = null;
                    this.e = null;
                    this.f = null;
                    this.m = null;
                    this.n = null;
                    if (o2 == null) {
                        o2 = new o(iOException);
                    } else {
                        o2.a(iOException);
                    }
                    if (bl && a2.a(iOException)) continue;
                    throw o2;
                }
            }
            return;
        }
        throw new IllegalStateException("already connected");
    }

    @Override
    public void a(d d2) {
        this.g = d2.b();
    }

    @Override
    public void a(e e2) throws IOException {
        e2.a(b.a.a.a.k);
    }

    /*
     * Exception decompiling
     */
    public boolean a(boolean var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl57.1 : ICONST_1 : trying to set 0 previously set to 1
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

    public void b() {
        i.a(this.l);
    }

    public Socket c() {
        return this.b;
    }

    public q d() {
        return this.m;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection{");
        stringBuilder.append(this.k.a().a().f());
        stringBuilder.append(":");
        stringBuilder.append(this.k.a().a().g());
        stringBuilder.append(", proxy=");
        stringBuilder.append((Object)this.k.b());
        stringBuilder.append(" hostAddress=");
        stringBuilder.append((Object)this.k.c());
        stringBuilder.append(" cipherSuite=");
        Object object = this.m != null ? this.m.a() : "none";
        stringBuilder.append(object);
        stringBuilder.append(" protocol=");
        stringBuilder.append((Object)this.n);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

