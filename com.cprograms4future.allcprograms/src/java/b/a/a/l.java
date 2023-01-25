/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.System
 *  java.util.concurrent.CountDownLatch
 */
package b.a.a;

import java.util.concurrent.CountDownLatch;

public final class l {
    private final CountDownLatch a = new CountDownLatch(1);
    private long b = -1L;
    private long c = -1L;

    l() {
    }

    void a() {
        if (this.b == -1L) {
            this.b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    void b() {
        if (this.c == -1L && this.b != -1L) {
            this.c = System.nanoTime();
            this.a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    void c() {
        if (this.c == -1L && this.b != -1L) {
            this.c = this.b - 1L;
            this.a.countDown();
            return;
        }
        throw new IllegalStateException();
    }
}

