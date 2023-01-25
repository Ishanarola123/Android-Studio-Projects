/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.atomic.AtomicReference
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core.internal.scribe;

import a.a.a.a.a.b.i;
import a.a.a.a.a.b.o;
import android.content.Context;
import android.text.TextUtils;
import b.ab;
import b.ac;
import b.t;
import b.w;
import b.z;
import com.twitter.sdk.android.core.internal.a.d;
import com.twitter.sdk.android.core.internal.scribe.e;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.p;
import d.b;
import d.b.c;
import d.b.r;
import d.l;
import d.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocketFactory;

class ScribeFilesSender
implements a.a.a.a.a.d.k {
    private static final byte[] a = new byte[]{91};
    private static final byte[] b = new byte[]{44};
    private static final byte[] c = new byte[]{93};
    private final Context d;
    private final e e;
    private final long f;
    private final n g;
    private final k<? extends j<p>> h;
    private final com.twitter.sdk.android.core.e i;
    private final SSLSocketFactory j;
    private final AtomicReference<ScribeService> k;
    private final ExecutorService l;
    private final a.a.a.a.a.b.m m;

    public ScribeFilesSender(Context context, e e2, long l2, n n2, k<? extends j<p>> k2, com.twitter.sdk.android.core.e e3, SSLSocketFactory sSLSocketFactory, ExecutorService executorService, a.a.a.a.a.b.m m2) {
        this.d = context;
        this.e = e2;
        this.f = l2;
        this.g = n2;
        this.h = k2;
        this.i = e3;
        this.j = sSLSocketFactory;
        this.l = executorService;
        this.m = m2;
        this.k = new AtomicReference();
    }

    private j a(long l2) {
        return this.h.a(l2);
    }

    private boolean a(j j2) {
        return j2 != null && j2.a() != null;
    }

    private boolean c() {
        return this.a() != null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    ScribeService a() {
        ScribeFilesSender scribeFilesSender = this;
        synchronized (scribeFilesSender) {
            if (this.k.get() != null) return this.k.get();
            j j2 = this.a(this.f);
            w.a a2 = this.a(j2) ? new Object(){
                b.n a;
                java.net.Proxy b;
                List<b.x> c;
                List<b.k> d;
                final List<t> e;
                final List<t> f;
                java.net.ProxySelector g;
                b.m h;
                b.c i;
                b.a.d j;
                javax.net.SocketFactory k;
                SSLSocketFactory l;
                b.a.d.f m;
                javax.net.ssl.HostnameVerifier n;
                b.g o;
                b.b p;
                b.b q;
                b.j r;
                b.o s;
                boolean t;
                boolean u;
                boolean v;
                int w;
                int x;
                int y;
                {
                    this.e = new java.util.ArrayList();
                    this.f = new java.util.ArrayList();
                    this.a = new b.n();
                    this.c = w.x();
                    this.d = w.y();
                    this.g = java.net.ProxySelector.getDefault();
                    this.h = b.m.a;
                    this.k = javax.net.SocketFactory.getDefault();
                    this.n = b.a.d.d.a;
                    this.o = b.g.a;
                    this.p = b.b.b;
                    this.q = b.b.b;
                    this.r = new b.j();
                    this.s = b.o.a;
                    this.t = true;
                    this.u = true;
                    this.v = true;
                    this.w = 10000;
                    this.x = 10000;
                    this.y = 10000;
                }

                public w.a a(b.b b2) {
                    if (b2 != null) {
                        this.q = b2;
                        return this;
                    }
                    throw new java.lang.NullPointerException("authenticator == null");
                }

                public w.a a(t t2) {
                    this.e.add((Object)t2);
                    return this;
                }

                public w.a a(SSLSocketFactory sSLSocketFactory) {
                    if (sSLSocketFactory != null) {
                        this.l = sSLSocketFactory;
                        this.m = null;
                        return this;
                    }
                    throw new java.lang.NullPointerException("sslSocketFactory == null");
                }

                public w a() {
                    return new w(this, null);
                }

                public w.a b(t t2) {
                    this.f.add((Object)t2);
                    return this;
                }
            }.a(this.j).a(new a(this.e, this.m)).a(new d(j2, this.g)) : new /* invalid duplicate definition of identical inner class */.a(this.j).a(new a(this.e, this.m)).a(new com.twitter.sdk.android.core.internal.a.a(this.i));
            w w2 = a2.a();
            m m2 = new m.a().a(this.e.b).a(w2).a();
            this.k.compareAndSet(null, (Object)m2.a(ScribeService.class));
            return this.k.get();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    l<ac> a(String string) throws IOException {
        b<ac> b2;
        ScribeService scribeService = this.a();
        if (!TextUtils.isEmpty((CharSequence)this.e.e)) {
            b2 = scribeService.uploadSequence(this.e.e, string);
            do {
                return b2.a();
                break;
            } while (true);
        }
        b2 = scribeService.upload(this.e.c, this.e.d, string);
        return b2.a();
    }

    @Override
    public boolean a(List<File> list) {
        if (this.c()) {
            l<ac> l2;
            block6 : {
                String string = this.b(list);
                i.a(this.d, string);
                l2 = this.a(string);
                if (l2.a() != 200) break block6;
                return true;
            }
            try {
                int n2;
                i.a(this.d, "Failed sending files", null);
                if (l2.a() == 500 || (n2 = l2.a()) == 400) {
                    return true;
                }
            }
            catch (Exception exception) {
                i.a(this.d, "Failed sending files", exception);
            }
        } else {
            i.a(this.d, "Cannot attempt upload at this time");
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    String b(List<File> list) throws IOException {
        block6 : {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            arrbl = new boolean[1];
            byteArrayOutputStream.write(ScribeFilesSender.a);
            var4_4 = list.iterator();
            do lbl-1000: // 2 sources:
            {
                if (!var4_4.hasNext()) {
                    byteArrayOutputStream.write(ScribeFilesSender.c);
                    return byteArrayOutputStream.toString("UTF-8");
                }
                file = (File)var4_4.next();
                o2 = new o(file);
                o2.a(new o.c(){

                    @Override
                    public void a(InputStream inputStream, int n2) throws IOException {
                        byte[] arrby = new byte[n2];
                        inputStream.read(arrby);
                        if (arrbl[0]) {
                            byteArrayOutputStream.write(b);
                        } else {
                            arrbl[0] = true;
                        }
                        byteArrayOutputStream.write(arrby);
                    }
                });
                break;
            } while (true);
            catch (Throwable throwable) {
                break block6;
            }
            {
                i.a(o2);
                ** while (true)
            }
            catch (Throwable throwable) {
                o2 = null;
            }
        }
        i.a(o2);
        throw var7_9;
    }

    static class a
    implements t {
        private final e a;
        private final a.a.a.a.a.b.m b;

        a(e e2, a.a.a.a.a.b.m m2) {
            this.a = e2;
            this.b = m2;
        }

        @Override
        public ab a(t.a a2) throws IOException {
            z.a a3 = a2.a().e();
            if (!TextUtils.isEmpty((CharSequence)this.a.f)) {
                a3.a("User-Agent", this.a.f);
            }
            if (!TextUtils.isEmpty((CharSequence)this.b.f())) {
                a3.a("X-Client-UUID", this.b.f());
            }
            a3.a("X-Twitter-Polling", "true");
            return a2.a(a3.a());
        }
    }

}

