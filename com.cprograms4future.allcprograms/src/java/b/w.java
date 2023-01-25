/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Cloneable
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.security.GeneralSecurityException
 *  java.security.SecureRandom
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.X509TrustManager
 */
package b;

import b.a.c;
import b.a.c.b;
import b.a.d;
import b.a.d.f;
import b.a.g;
import b.a.h;
import b.a.i;
import b.e;
import b.g;
import b.j;
import b.k;
import b.m;
import b.n;
import b.o;
import b.r;
import b.t;
import b.x;
import b.y;
import b.z;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class w
implements e.a,
Cloneable {
    private static final List<k> A;
    private static final List<x> z;
    final n a;
    final Proxy b;
    final List<x> c;
    final List<k> d;
    final List<t> e;
    final List<t> f;
    final ProxySelector g;
    final m h;
    final b.c i;
    final d j;
    final SocketFactory k;
    final SSLSocketFactory l;
    final f m;
    final HostnameVerifier n;
    final b.g o;
    final b.b p;
    final b.b q;
    final j r;
    final o s;
    final boolean t;
    final boolean u;
    final boolean v;
    final int w;
    final int x;
    final int y;

    static {
        x[] arrx = new x[]{x.d, x.c, x.b};
        z = i.a(arrx);
        k[] arrk = new k[]{k.a, k.b, k.c};
        A = i.a(arrk);
        c.b = new c(){

            @Override
            public b a(j j2, b.a a2, b.a.b.r r2) {
                return j2.a(a2, r2);
            }

            @Override
            public d a(w w2) {
                return w2.g();
            }

            @Override
            public h a(j j2) {
                return j2.a;
            }

            @Override
            public void a(k k2, SSLSocket sSLSocket, boolean bl) {
                k2.a(sSLSocket, bl);
            }

            @Override
            public void a(r.a a2, String string) {
                a2.a(string);
            }

            @Override
            public boolean a(j j2, b b2) {
                return j2.b(b2);
            }

            @Override
            public void b(j j2, b b2) {
                j2.a(b2);
            }
        };
    }

    public w() {
        this(new Object(){
            n a = new n();
            Proxy b;
            List<x> c = w.x();
            List<k> d = w.y();
            final List<t> e = new ArrayList();
            final List<t> f = new ArrayList();
            ProxySelector g = ProxySelector.getDefault();
            m h = m.a;
            b.c i;
            d j;
            SocketFactory k = SocketFactory.getDefault();
            SSLSocketFactory l;
            f m;
            HostnameVerifier n = b.a.d.d.a;
            b.g o = b.g.a;
            b.b p = b.b.b;
            b.b q = b.b.b;
            j r = new j();
            o s = o.a;
            boolean t = true;
            boolean u = true;
            boolean v = true;
            int w = 10000;
            int x = 10000;
            int y = 10000;

            public a a(b.b b2) {
                if (b2 != null) {
                    this.q = b2;
                    return this;
                }
                throw new NullPointerException("authenticator == null");
            }

            public a a(t t2) {
                this.e.add((Object)t2);
                return this;
            }

            public a a(SSLSocketFactory sSLSocketFactory) {
                if (sSLSocketFactory != null) {
                    this.l = sSLSocketFactory;
                    this.m = null;
                    return this;
                }
                throw new NullPointerException("sslSocketFactory == null");
            }

            public w a() {
                return new w(this);
            }

            public a b(t t2) {
                this.f.add((Object)t2);
                return this;
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private w(a a2) {
        boolean bl;
        b.g g2;
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
        this.e = i.a(a2.e);
        this.f = i.a(a2.f);
        this.g = a2.g;
        this.h = a2.h;
        this.i = a2.i;
        this.j = a2.j;
        this.k = a2.k;
        Iterator iterator = this.d.iterator();
        block2 : do {
            bl = false;
            while (iterator.hasNext()) {
                k k2 = (k)iterator.next();
                if (!bl && !k2.a()) continue block2;
                bl = true;
            }
            break;
        } while (true);
        if (a2.l == null && bl) {
            try {
                SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
                sSLContext.init(null, null, null);
                this.l = sSLContext.getSocketFactory();
            }
            catch (GeneralSecurityException generalSecurityException) {
                throw new AssertionError();
            }
        } else {
            this.l = a2.l;
        }
        if (this.l != null && a2.m == null) {
            X509TrustManager x509TrustManager = g.a().a(this.l);
            if (x509TrustManager == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to extract the trust manager on ");
                stringBuilder.append((Object)g.a());
                stringBuilder.append(", sslSocketFactory is ");
                stringBuilder.append((Object)this.l.getClass());
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.m = g.a().a(x509TrustManager);
            g2 = a2.o.a().a(this.m).a();
        } else {
            this.m = a2.m;
            g2 = a2.o;
        }
        this.o = g2;
        this.n = a2.n;
        this.p = a2.p;
        this.q = a2.q;
        this.r = a2.r;
        this.s = a2.s;
        this.t = a2.t;
        this.u = a2.u;
        this.v = a2.v;
        this.w = a2.w;
        this.x = a2.x;
        this.y = a2.y;
    }

    static /* synthetic */ List x() {
        return z;
    }

    static /* synthetic */ List y() {
        return A;
    }

    public int a() {
        return this.w;
    }

    @Override
    public e a(z z2) {
        return new y(this, z2);
    }

    public int b() {
        return this.x;
    }

    public int c() {
        return this.y;
    }

    public Proxy d() {
        return this.b;
    }

    public ProxySelector e() {
        return this.g;
    }

    public m f() {
        return this.h;
    }

    d g() {
        if (this.i != null) {
            return this.i.a;
        }
        return this.j;
    }

    public o h() {
        return this.s;
    }

    public SocketFactory i() {
        return this.k;
    }

    public SSLSocketFactory j() {
        return this.l;
    }

    public HostnameVerifier k() {
        return this.n;
    }

    public b.g l() {
        return this.o;
    }

    public b.b m() {
        return this.q;
    }

    public b.b n() {
        return this.p;
    }

    public j o() {
        return this.r;
    }

    public boolean p() {
        return this.t;
    }

    public boolean q() {
        return this.u;
    }

    public boolean r() {
        return this.v;
    }

    public n s() {
        return this.a;
    }

    public List<x> t() {
        return this.c;
    }

    public List<k> u() {
        return this.d;
    }

    public List<t> v() {
        return this.e;
    }

    public List<t> w() {
        return this.f;
    }

}

