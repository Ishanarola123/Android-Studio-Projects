/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package b;

import b.a.i;
import b.aa;
import b.p;
import b.s;
import b.u;
import c.c;
import c.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class p
extends aa {
    private static final u a = u.a("application/x-www-form-urlencoded");
    private final List<String> b;
    private final List<String> c;

    private p(List<String> list, List<String> list2) {
        this.b = i.a(list);
        this.c = i.a(list2);
    }

    private long a(d d2, boolean bl) {
        c c2 = bl ? new c() : d2.c();
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                c2.b(38);
            }
            c2.a((String)this.b.get(i2));
            c2.b(61);
            c2.a((String)this.c.get(i2));
        }
        if (bl) {
            long l2 = c2.b();
            c2.clear();
            return l2;
        }
        return 0L;
    }

    public int a() {
        return this.b.size();
    }

    public String a(int n2) {
        return (String)this.b.get(n2);
    }

    @Override
    public void a(d d2) throws IOException {
        this.a(d2, false);
    }

    @Override
    public u b() {
        return a;
    }

    public String b(int n2) {
        return (String)this.c.get(n2);
    }

    @Override
    public long c() {
        return this.a(null, true);
    }

    public String c(int n2) {
        return s.a(this.b(n2), true);
    }

}

