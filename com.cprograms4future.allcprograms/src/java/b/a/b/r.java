/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.b.d
 *  b.a.b.e
 *  b.a.b.n
 *  b.a.c.b
 *  c.d
 *  c.e
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.lang.ref.WeakReference
 *  java.net.ProtocolException
 *  java.net.Socket
 *  java.net.SocketTimeoutException
 *  java.security.cert.CertificateException
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.ssl.SSLHandshakeException
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package b.a.b;

import b.a;
import b.a.b.d;
import b.a.b.e;
import b.a.b.n;
import b.a.b.o;
import b.a.b.p;
import b.a.c;
import b.a.c.b;
import b.a.h;
import b.a.i;
import b.ad;
import b.j;
import b.k;
import c.q;
import c.s;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class r {
    public final a a;
    private ad b;
    private final j c;
    private p d;
    private b e;
    private boolean f;
    private boolean g;
    private b.a.b.i h;

    public r(j j2, a a2) {
        this.c = j2;
        this.a = a2;
        this.d = new p(a2, this.e());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private b a(int n2, int n3, int n4, boolean bl) throws IOException, o {
        j j2;
        j j3;
        j j4 = j3 = this.c;
        // MONITORENTER : j4
        if (this.f) throw new IllegalStateException("released");
        if (this.h != null) throw new IllegalStateException("stream != null");
        if (this.g) throw new IOException("Canceled");
        b b2 = this.e;
        if (b2 != null && !b2.i) {
            // MONITOREXIT : j4
            return b2;
        }
        b b3 = c.b.a(this.c, this.a, this);
        if (b3 != null) {
            this.e = b3;
            // MONITOREXIT : j4
            return b3;
        }
        ad ad2 = this.b;
        // MONITOREXIT : j4
        if (ad2 == null) {
            j j5;
            ad2 = this.d.b();
            j j6 = j5 = this.c;
            // MONITORENTER : j6
            this.b = ad2;
            // MONITOREXIT : j6
        }
        b b4 = new b(ad2);
        this.a(b4);
        j j7 = j2 = this.c;
        // MONITORENTER : j7
        c.b.b(this.c, b4);
        this.e = b4;
        if (this.g) throw new IOException("Canceled");
        // MONITOREXIT : j7
        b4.a(n2, n3, n4, this.a.f(), bl);
        this.e().b(b4.a());
        return b4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(boolean var1_1, boolean var2_2, boolean var3_3) {
        block9 : {
            block8 : {
                var7_5 = var4_4 = this.c;
                // MONITORENTER : var7_5
                if (!var3_3) ** GOTO lbl6
                this.h = null;
lbl6: // 2 sources:
                if (var2_2) {
                    this.f = true;
                }
                if (this.e == null) break block8;
                if (var1_1) {
                    this.e.i = true;
                }
                if (this.h != null || !this.f && !this.e.i) break block8;
                this.b(this.e);
                if (!this.e.h.isEmpty()) ** GOTO lbl-1000
                this.e.j = System.nanoTime();
                if (c.b.a(this.c, this.e)) {
                    var5_6 = this.e;
                } else lbl-1000: // 2 sources:
                {
                    var5_6 = null;
                }
                this.e = null;
                // MONITOREXIT : var7_5
                break block9;
            }
            var5_6 = null;
        }
        if (var5_6 == null) return;
        i.a(var5_6.c());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private b b(int n2, int n3, int n4, boolean bl, boolean bl2) throws IOException, o {
        do {
            j j2;
            b b2 = this.a(n2, n3, n4, bl);
            j j3 = j2 = this.c;
            // MONITORENTER : j3
            if (b2.d == 0) {
                // MONITOREXIT : j3
                return b2;
            }
            // MONITOREXIT : j3
            if (b2.a(bl2)) {
                return b2;
            }
            this.a(new IOException());
        } while (true);
    }

    private void b(b b2) {
        int n2 = b2.h.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (((Reference)b2.h.get(i2)).get() != this) continue;
            b2.h.remove(i2);
            return;
        }
        throw new IllegalStateException();
    }

    private boolean b(IOException iOException) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return iOException instanceof SocketTimeoutException;
        }
        if (iOException instanceof SSLHandshakeException && iOException.getCause() instanceof CertificateException) {
            return false;
        }
        return !(iOException instanceof SSLPeerUnverifiedException);
    }

    private h e() {
        return c.b.a(this.c);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public b.a.b.i a(int n2, int n3, int n4, boolean bl, boolean bl2) throws o, IOException {
        e e2;
        try {
            j j2;
            b b2 = this.b(n2, n3, n4, bl, bl2);
            if (b2.c != null) {
                e2 = new e(this, b2.c);
            } else {
                b2.c().setSoTimeout(n3);
                b2.e.a().a(n3, TimeUnit.MILLISECONDS);
                b2.f.a().a(n4, TimeUnit.MILLISECONDS);
                e2 = new d(this, b2.e, b2.f);
            }
            j j3 = j2 = this.c;
            // MONITORENTER : j3
        }
        catch (IOException iOException) {
            throw new o(iOException);
        }
        this.h = e2;
        // MONITOREXIT : j3
        return e2;
    }

    public b a() {
        r r2 = this;
        synchronized (r2) {
            b b2 = this.e;
            return b2;
        }
    }

    public void a(b b2) {
        b2.h.add((Object)new WeakReference((Object)this));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(IOException iOException) {
        j j2;
        j j3 = j2 = this.c;
        synchronized (j3) {
            if (this.e != null && this.e.d == 0) {
                if (this.b != null && iOException != null) {
                    this.d.a(this.b, iOException);
                }
                this.b = null;
            }
        }
        this.a(true, false, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl, b.a.b.i i2) {
        j j2;
        j j3 = j2 = this.c;
        synchronized (j3) {
            block6 : {
                if (i2 != null) {
                    if (i2 != this.h) break block6;
                    if (!bl) {
                        b b2 = this.e;
                        b2.d = 1 + b2.d;
                    }
                    // MONITOREXIT [0, 2, 5] lbl9 : w: MONITOREXIT : var11_4
                    this.a(bl, false, true);
                    return;
                }
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("expected ");
                stringBuilder.append((Object)this.h);
                stringBuilder.append(" but was ");
                stringBuilder.append((Object)i2);
                throw new IllegalStateException(stringBuilder.toString());
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public boolean a(IOException iOException, q q2) {
        if (this.e != null) {
            this.a(iOException);
        }
        boolean bl = q2 == null || q2 instanceof n;
        if ((this.d == null || this.d.a()) && this.b(iOException)) {
            return bl;
        }
        return false;
    }

    public void b() {
        this.a(false, true, false);
    }

    public void c() {
        this.a(true, false, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void d() {
        j j2;
        j j3 = j2 = this.c;
        // MONITORENTER : j3
        this.g = true;
        b.a.b.i i2 = this.h;
        b b2 = this.e;
        // MONITOREXIT : j3
        if (i2 != null) {
            i2.a();
            return;
        }
        if (b2 == null) return;
        b2.b();
    }

    public String toString() {
        return this.a.toString();
    }
}

