/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.s$1
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.concurrent.TimeUnit
 */
package c;

import c.s;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class s {
    public static final s b = new 1();
    private boolean a;
    private long c;
    private long d;

    public long A_() {
        return this.d;
    }

    public boolean B_() {
        return this.a;
    }

    public s C_() {
        this.d = 0L;
        return this;
    }

    public s a(long l2) {
        this.a = true;
        this.c = l2;
        return this;
    }

    public s a(long l2, TimeUnit timeUnit) {
        if (l2 >= 0L) {
            if (timeUnit != null) {
                this.d = timeUnit.toNanos(l2);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("timeout < 0: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public long d() {
        if (this.a) {
            return this.c;
        }
        throw new IllegalStateException("No deadline");
    }

    public s f() {
        this.a = false;
        return this;
    }

    public void g() throws IOException {
        if (!Thread.interrupted()) {
            if (this.a) {
                if (this.c - System.nanoTime() > 0L) {
                    return;
                }
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("thread interrupted");
    }
}

