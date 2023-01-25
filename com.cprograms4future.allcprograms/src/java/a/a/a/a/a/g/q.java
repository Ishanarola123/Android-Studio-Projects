/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.b.q
 *  a.a.a.a.a.g.i
 *  a.a.a.a.a.g.j
 *  a.a.a.a.a.g.k
 *  a.a.a.a.a.g.l
 *  android.content.Context
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.atomic.AtomicReference
 */
package a.a.a.a.a.g;

import a.a.a.a.a.b.m;
import a.a.a.a.a.e.e;
import a.a.a.a.a.g.g;
import a.a.a.a.a.g.j;
import a.a.a.a.a.g.k;
import a.a.a.a.a.g.l;
import a.a.a.a.a.g.r;
import a.a.a.a.a.g.s;
import a.a.a.a.a.g.t;
import a.a.a.a.a.g.v;
import a.a.a.a.a.g.w;
import a.a.a.a.a.g.x;
import a.a.a.a.c;
import a.a.a.a.i;
import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class q {
    private final AtomicReference<t> a = new AtomicReference();
    private final CountDownLatch b = new CountDownLatch(1);
    private s c;
    private boolean d = false;

    private q() {
    }

    public static q a() {
        return a.a;
    }

    private void a(t t2) {
        this.a.set((Object)t2);
        this.b.countDown();
    }

    public q a(i i2, m m2, e e2, String string, String string2, String string3) {
        q q2 = this;
        synchronized (q2) {
            block5 : {
                boolean bl = this.d;
                if (!bl) break block5;
                return this;
            }
            if (this.c == null) {
                Context context = i2.m();
                String string4 = m2.b();
                String string5 = new a.a.a.a.a.b.g().a(context);
                String string6 = m2.g();
                a.a.a.a.a.b.q q3 = new a.a.a.a.a.b.q();
                k k2 = new k();
                a.a.a.a.a.g.i i3 = new a.a.a.a.a.g.i(i2);
                String string7 = a.a.a.a.a.b.i.e(context);
                l l2 = new l(i2, string3, String.format((Locale)Locale.US, (String)"https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", (Object[])new Object[]{string4}), e2);
                String string8 = m2.e();
                String string9 = m2.d();
                String string10 = m2.c();
                String string11 = m2.i();
                String string12 = m2.a();
                String string13 = m2.j();
                String[] arrstring = new String[]{a.a.a.a.a.b.i.g(context)};
                String string14 = a.a.a.a.a.b.i.a(arrstring);
                int n2 = a.a.a.a.a.b.k.a(string6).a();
                w w2 = new w(string5, string8, string9, string10, string11, string12, string13, string14, string2, string, n2, string7);
                j j2 = new j(i2, w2, (a.a.a.a.a.b.j)q3, (v)k2, (g)i3, (x)l2);
                this.c = j2;
            }
            this.d = true;
            return this;
        }
    }

    public t b() {
        try {
            this.b.await();
            t t2 = (t)this.a.get();
            return t2;
        }
        catch (InterruptedException interruptedException) {
            c.h().d("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public boolean c() {
        q q2 = this;
        synchronized (q2) {
            t t2 = this.c.a();
            this.a(t2);
            boolean bl = t2 != null;
            return bl;
        }
    }

    public boolean d() {
        q q2 = this;
        synchronized (q2) {
            t t2;
            block4 : {
                t2 = this.c.a(r.b);
                this.a(t2);
                if (t2 != null) break block4;
                c.h().d("Fabric", "Failed to force reload of settings from Crashlytics.", null);
            }
            boolean bl = t2 != null;
            return bl;
        }
    }

    static class a {
        private static final q a = new q();
    }

}

