/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.util.concurrent.TimeUnit
 */
package c;

import c.s;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class i
extends s {
    private s a;

    public i(s s2) {
        if (s2 != null) {
            this.a = s2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override
    public long A_() {
        return this.a.A_();
    }

    @Override
    public boolean B_() {
        return this.a.B_();
    }

    @Override
    public s C_() {
        return this.a.C_();
    }

    public final i a(s s2) {
        if (s2 != null) {
            this.a = s2;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final s a() {
        return this.a;
    }

    @Override
    public s a(long l2) {
        return this.a.a(l2);
    }

    @Override
    public s a(long l2, TimeUnit timeUnit) {
        return this.a.a(l2, timeUnit);
    }

    @Override
    public long d() {
        return this.a.d();
    }

    @Override
    public s f() {
        return this.a.f();
    }

    @Override
    public void g() throws IOException {
        this.a.g();
    }
}

