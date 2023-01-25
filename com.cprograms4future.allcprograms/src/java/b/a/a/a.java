/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a;

public final class a
extends Enum<a> {
    public static final /* enum */ a a;
    public static final /* enum */ a b;
    public static final /* enum */ a c;
    public static final /* enum */ a d;
    public static final /* enum */ a e;
    public static final /* enum */ a f;
    public static final /* enum */ a g;
    public static final /* enum */ a h;
    public static final /* enum */ a i;
    public static final /* enum */ a j;
    public static final /* enum */ a k;
    public static final /* enum */ a l;
    public static final /* enum */ a m;
    public static final /* enum */ a n;
    public static final /* enum */ a o;
    public static final /* enum */ a p;
    public static final /* enum */ a q;
    public static final /* enum */ a r;
    private static final /* synthetic */ a[] v;
    public final int s;
    public final int t;
    public final int u;

    static {
        a a2;
        a a3;
        a a4;
        a a5;
        a a6;
        a a7;
        a a8;
        a a9;
        a a10;
        a a11;
        a a12;
        a a13;
        a a14;
        a a15;
        a a16;
        a a17;
        a a18;
        a a19;
        a = a18 = new a(0, -1, 0);
        b = a2 = new a(1, 1, 1);
        c = a17 = new a(1, 2, -1);
        d = a9 = new a(1, 4, -1);
        e = a5 = new a(1, 8, -1);
        f = a13 = new a(1, 9, -1);
        g = a11 = new a(2, 6, 2);
        h = a8 = new a(3, 7, -1);
        i = a12 = new a(5, -1, -1);
        j = a4 = new a(6, 11, -1);
        k = a3 = new a(7, 3, -1);
        l = a7 = new a(8, 5, -1);
        m = a10 = new a(9, -1, -1);
        n = a15 = new a(10, -1, -1);
        o = a6 = new a(11, -1, -1);
        p = a19 = new a(12, -1, -1);
        q = a16 = new a(13, -1, -1);
        r = a14 = new a(-1, 10, -1);
        a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r};
        v = arra;
    }

    private a(int n3, int n4, int n5) {
        this.s = n3;
        this.t = n4;
        this.u = n5;
    }

    public static a a(int n2) {
        for (a a2 : a.values()) {
            if (a2.t != n2) continue;
            return a2;
        }
        return null;
    }

    public static a b(int n2) {
        for (a a2 : a.values()) {
            if (a2.s != n2) continue;
            return a2;
        }
        return null;
    }

    public static a c(int n2) {
        for (a a2 : a.values()) {
            if (a2.u != n2) continue;
            return a2;
        }
        return null;
    }

    public static a valueOf(String string) {
        return (a)Enum.valueOf(a.class, (String)string);
    }

    public static a[] values() {
        return (a[])v.clone();
    }
}

