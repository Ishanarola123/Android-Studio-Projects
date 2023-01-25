/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.b.e$a
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 *  java.util.ArrayList
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.TimeUnit
 */
package b.a.b;

import b.a.a.d;
import b.a.a.f;
import b.a.b.e;
import b.a.b.g;
import b.a.b.k;
import b.a.b.m;
import b.a.b.n;
import b.a.b.q;
import b.a.i;
import b.ab;
import b.ac;
import b.r;
import b.s;
import b.w;
import b.x;
import b.z;
import c.l;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis.
 */
public final class e
implements b.a.b.i {
    private static final c.f a;
    private static final c.f b;
    private static final c.f c;
    private static final c.f d;
    private static final c.f e;
    private static final c.f f;
    private static final c.f g;
    private static final c.f h;
    private static final List<c.f> i;
    private static final List<c.f> j;
    private static final List<c.f> k;
    private static final List<c.f> l;
    private final b.a.b.r m;
    private final d n;
    private g o;
    private b.a.a.e p;

    static {
        a = c.f.a("connection");
        b = c.f.a("host");
        c = c.f.a("keep-alive");
        d = c.f.a("proxy-connection");
        e = c.f.a("transfer-encoding");
        f = c.f.a("te");
        g = c.f.a("encoding");
        h = c.f.a("upgrade");
        c.f[] arrf = new c.f[]{a, b, c, d, e, f.b, f.c, f.d, f.e, f.f, f.g};
        i = i.a(arrf);
        c.f[] arrf2 = new c.f[]{a, b, c, d, e};
        j = i.a(arrf2);
        c.f[] arrf3 = new c.f[]{a, b, c, d, f, e, g, h, f.b, f.c, f.d, f.e, f.f, f.g};
        k = i.a(arrf3);
        c.f[] arrf4 = new c.f[]{a, b, c, d, f, e, g, h};
        l = i.a(arrf4);
    }

    public e(b.a.b.r r2, d d2) {
        this.m = r2;
        this.n = d2;
    }

    static /* synthetic */ b.a.b.r a(e e2) {
        return e2.m;
    }

    public static ab.a a(List<f> list) throws IOException {
        r.a a2 = new r.a();
        int n2 = list.size();
        String string = null;
        String string2 = "HTTP/1.1";
        for (int i2 = 0; i2 < n2; ++i2) {
            c.f f2 = ((f)list.get((int)i2)).h;
            String string3 = ((f)list.get((int)i2)).i.a();
            String string4 = string2;
            String string5 = string;
            int n3 = 0;
            while (n3 < string3.length()) {
                int n4 = string3.indexOf(0, n3);
                if (n4 == -1) {
                    n4 = string3.length();
                }
                String string6 = string3.substring(n3, n4);
                if (f2.equals(f.a)) {
                    string5 = string6;
                } else if (f2.equals(f.g)) {
                    string4 = string6;
                } else if (!j.contains((Object)f2)) {
                    a2.a(f2.a(), string6);
                }
                n3 = n4 + 1;
            }
            string = string5;
            string2 = string4;
        }
        if (string != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" ");
            stringBuilder.append(string);
            q q2 = q.a(stringBuilder.toString());
            return new ab.a().a(x.c).a(q2.b).a(q2.c).a(a2.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    private static String a(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.append('\u0000');
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static ab.a b(List<f> list) throws IOException {
        r.a a2 = new r.a();
        int n2 = list.size();
        String string = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            c.f f2 = ((f)list.get((int)i2)).h;
            String string2 = ((f)list.get((int)i2)).i.a();
            if (f2.equals(f.a)) {
                string = string2;
                continue;
            }
            if (l.contains((Object)f2)) continue;
            a2.a(f2.a(), string2);
        }
        if (string != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HTTP/1.1 ");
            stringBuilder.append(string);
            q q2 = q.a(stringBuilder.toString());
            return new ab.a().a(x.d).a(q2.b).a(q2.c).a(a2.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<f> b(z z2) {
        r r2 = z2.c();
        ArrayList arrayList = new ArrayList(5 + r2.a());
        arrayList.add((Object)new f(f.b, z2.b()));
        arrayList.add((Object)new f(f.c, m.a(z2.a())));
        arrayList.add((Object)new f(f.g, "HTTP/1.1"));
        arrayList.add((Object)new f(f.f, i.a(z2.a(), false)));
        arrayList.add((Object)new f(f.d, z2.a().b()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int n2 = r2.a();
        block0 : for (int i2 = 0; i2 < n2; ++i2) {
            c.f f2 = c.f.a(r2.a(i2).toLowerCase(Locale.US));
            if (i.contains((Object)f2)) continue;
            String string = r2.b(i2);
            if (linkedHashSet.add((Object)f2)) {
                arrayList.add((Object)new f(f2, string));
                continue;
            }
            for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                if (!((f)arrayList.get((int)i3)).h.equals(f2)) continue;
                arrayList.set(i3, (Object)new f(f2, e.a(((f)arrayList.get((int)i3)).i.a(), string)));
                continue block0;
            }
        }
        return arrayList;
    }

    public static List<f> c(z z2) {
        r r2 = z2.c();
        ArrayList arrayList = new ArrayList(4 + r2.a());
        arrayList.add((Object)new f(f.b, z2.b()));
        arrayList.add((Object)new f(f.c, m.a(z2.a())));
        c.f f2 = f.e;
        s s2 = z2.a();
        arrayList.add((Object)new f(f2, i.a(s2, false)));
        arrayList.add((Object)new f(f.d, z2.a().b()));
        int n2 = r2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            c.f f3 = c.f.a(r2.a(i2).toLowerCase(Locale.US));
            if (k.contains((Object)f3)) continue;
            arrayList.add((Object)new f(f3, r2.b(i2)));
        }
        return arrayList;
    }

    @Override
    public ac a(ab ab2) throws IOException {
        a a2 = new /* Unavailable Anonymous Inner Class!! */;
        return new k(ab2.e(), l.a((c.r)a2));
    }

    @Override
    public c.q a(z z2, long l2) throws IOException {
        return this.p.h();
    }

    @Override
    public void a() {
        if (this.p != null) {
            this.p.b(b.a.a.a.l);
        }
    }

    @Override
    public void a(g g2) {
        this.o = g2;
    }

    @Override
    public void a(n n2) throws IOException {
        n2.a(this.p.h());
    }

    @Override
    public void a(z z2) throws IOException {
        if (this.p != null) {
            return;
        }
        this.o.b();
        boolean bl = this.o.a(z2);
        List<f> list = this.n.a() == x.d ? e.c(z2) : e.b(z2);
        this.p = this.n.a(list, bl, true);
        this.p.e().a(this.o.a.b(), TimeUnit.MILLISECONDS);
        this.p.f().a(this.o.a.c(), TimeUnit.MILLISECONDS);
    }

    @Override
    public ab.a b() throws IOException {
        if (this.n.a() == x.d) {
            return e.b(this.p.d());
        }
        return e.a(this.p.d());
    }

    @Override
    public void c() throws IOException {
        this.p.h().close();
    }
}

