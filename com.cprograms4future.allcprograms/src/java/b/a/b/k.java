/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package b.a.b;

import b.a.b.j;
import b.ac;
import b.r;
import b.u;
import c.e;

public final class k
extends ac {
    private final r a;
    private final e b;

    public k(r r2, e e2) {
        this.a = r2;
        this.b = e2;
    }

    @Override
    public u a() {
        String string = this.a.a("Content-Type");
        if (string != null) {
            return u.a(string);
        }
        return null;
    }

    @Override
    public long b() {
        return j.a(this.a);
    }

    @Override
    public e d() {
        return this.b;
    }
}

