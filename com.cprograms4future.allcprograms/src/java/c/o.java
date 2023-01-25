/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.System
 */
package c;

import c.p;

final class o {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    o f;
    o g;

    o() {
        this.a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    o(o o2) {
        this(o2.a, o2.b, o2.c);
        o2.d = true;
    }

    o(byte[] arrby, int n2, int n3) {
        this.a = arrby;
        this.b = n2;
        this.c = n3;
        this.e = false;
        this.d = true;
    }

    public o a() {
        o o2 = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return o2;
    }

    public o a(int n2) {
        if (n2 > 0 && n2 <= this.c - this.b) {
            o o2 = new o(this);
            o2.c = n2 + o2.b;
            this.b = n2 + this.b;
            this.g.a(o2);
            return o2;
        }
        throw new IllegalArgumentException();
    }

    public o a(o o2) {
        o2.g = this;
        o2.f = this.f;
        this.f.g = o2;
        this.f = o2;
        return o2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(o o2, int n2) {
        if (!o2.e) throw new IllegalArgumentException();
        if (n2 + o2.c > 2048) {
            if (o2.d) throw new IllegalArgumentException();
            if (n2 + o2.c - o2.b > 2048) throw new IllegalArgumentException();
            System.arraycopy((Object)o2.a, (int)o2.b, (Object)o2.a, (int)0, (int)(o2.c - o2.b));
            o2.c -= o2.b;
            o2.b = 0;
        }
        System.arraycopy((Object)this.a, (int)this.b, (Object)o2.a, (int)o2.c, (int)n2);
        o2.c = n2 + o2.c;
        this.b = n2 + this.b;
    }

    public void b() {
        if (this.g != this) {
            if (!this.g.e) {
                return;
            }
            int n2 = this.c - this.b;
            int n3 = 2048 - this.g.c;
            int n4 = this.g.d ? 0 : this.g.b;
            if (n2 > n3 + n4) {
                return;
            }
            this.a(this.g, n2);
            this.a();
            p.a(this);
            return;
        }
        throw new IllegalStateException();
    }
}

