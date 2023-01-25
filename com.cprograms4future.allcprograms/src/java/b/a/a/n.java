/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Arrays
 */
package b.a.a;

import java.util.Arrays;

public final class n {
    private int a;
    private int b;
    private int c;
    private final int[] d = new int[10];

    int a() {
        return Integer.bitCount((int)this.a);
    }

    /*
     * Enabled aggressive block sorting
     */
    n a(int n2, int n3, int n4) {
        if (n2 >= this.d.length) {
            return this;
        }
        int n5 = 1 << n2;
        this.a = n5 | this.a;
        int n6 = (n3 & 1) != 0 ? n5 | this.b : this.b & ~n5;
        this.b = n6;
        int n7 = (n3 & 2) != 0 ? n5 | this.c : this.c & ~n5;
        this.c = n7;
        this.d[n2] = n4;
        return this;
    }

    void a(n n2) {
        for (int i2 = 0; i2 < 10; ++i2) {
            if (!n2.a(i2)) continue;
            this.a(i2, n2.c(i2), n2.b(i2));
        }
    }

    boolean a(int n2) {
        return (1 << n2 & this.a) != 0;
    }

    int b() {
        if ((2 & this.a) != 0) {
            return this.d[1];
        }
        return -1;
    }

    int b(int n2) {
        return this.d[n2];
    }

    int c(int n2) {
        int n3 = this.h(n2) ? 2 : 0;
        if (this.g(n2)) {
            n3 |= 1;
        }
        return n3;
    }

    void clear() {
        this.c = 0;
        this.b = 0;
        this.a = 0;
        Arrays.fill((int[])this.d, (int)0);
    }

    int d(int n2) {
        if ((16 & this.a) != 0) {
            n2 = this.d[4];
        }
        return n2;
    }

    int e(int n2) {
        if ((32 & this.a) != 0) {
            n2 = this.d[5];
        }
        return n2;
    }

    int f(int n2) {
        if ((128 & this.a) != 0) {
            n2 = this.d[7];
        }
        return n2;
    }

    boolean g(int n2) {
        return (1 << n2 & this.b) != 0;
    }

    boolean h(int n2) {
        return (1 << n2 & this.c) != 0;
    }
}

