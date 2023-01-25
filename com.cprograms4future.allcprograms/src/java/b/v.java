/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.UUID
 */
package b;

import b.a.i;
import b.aa;
import b.r;
import b.u;
import c.c;
import c.d;
import c.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class v
extends aa {
    public static final u a = u.a("multipart/mixed");
    public static final u b = u.a("multipart/alternative");
    public static final u c = u.a("multipart/digest");
    public static final u d = u.a("multipart/parallel");
    public static final u e = u.a("multipart/form-data");
    private static final byte[] f = new byte[]{58, 32};
    private static final byte[] g = new byte[]{13, 10};
    private static final byte[] h = new byte[]{45, 45};
    private final f i;
    private final u j;
    private final u k;
    private final List<b> l;
    private long m = -1L;

    v(f f2, u u2, List<b> list) {
        this.i = f2;
        this.j = u2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)u2);
        stringBuilder.append("; boundary=");
        stringBuilder.append(f2.a());
        this.k = u.a(stringBuilder.toString());
        this.l = i.a(list);
    }

    private long a(d d2, boolean bl) throws IOException {
        d d3 = bl ? (d2 = new c()) : null;
        int n2 = this.l.size();
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l3;
            u u2;
            b b2 = this.l.get(i2);
            r r2 = b2.a;
            aa aa2 = b2.b;
            d2.c(h);
            d2.b(this.i);
            d2.c(g);
            if (r2 != null) {
                int n3 = r2.a();
                for (int i3 = 0; i3 < n3; ++i3) {
                    d2.b(r2.a(i3)).c(f).b(r2.b(i3)).c(g);
                }
            }
            if ((u2 = aa2.b()) != null) {
                d2.b("Content-Type: ").b(u2.toString()).c(g);
            }
            if ((l3 = aa2.c()) != -1L) {
                d2.b("Content-Length: ").k(l3).c(g);
            } else if (bl) {
                d3.clear();
                return -1L;
            }
            d2.c(g);
            if (bl) {
                l2 += l3;
            } else {
                aa2.a(d2);
            }
            d2.c(g);
        }
        d2.c(h);
        d2.b(this.i);
        d2.c(h);
        d2.c(g);
        if (bl) {
            l2 += d3.b();
            d3.clear();
        }
        return l2;
    }

    @Override
    public void a(d d2) throws IOException {
        this.a(d2, false);
    }

    @Override
    public u b() {
        return this.k;
    }

    @Override
    public long c() throws IOException {
        long l2;
        long l3 = this.m;
        if (l3 != -1L) {
            return l3;
        }
        this.m = l2 = this.a(null, true);
        return l2;
    }

}

