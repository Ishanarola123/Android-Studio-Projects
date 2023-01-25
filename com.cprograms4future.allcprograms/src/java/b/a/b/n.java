/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 */
package b.a.b;

import b.a.i;
import c.c;
import c.q;
import c.s;
import java.io.IOException;
import java.net.ProtocolException;

public final class n
implements q {
    private boolean a;
    private final int b;
    private final c c = new c();

    public n() {
        this(-1);
    }

    public n(int n2) {
        this.b = n2;
    }

    @Override
    public s a() {
        return s.b;
    }

    public void a(q q2) throws IOException {
        c c2 = new c();
        this.c.a(c2, 0L, this.c.b());
        q2.a_(c2, c2.b());
    }

    @Override
    public void a_(c c2, long l2) throws IOException {
        if (!this.a) {
            i.a(c2.b(), 0L, l2);
            if (this.b != -1 && this.c.b() > (long)this.b - l2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("exceeded content-length limit of ");
                stringBuilder.append(this.b);
                stringBuilder.append(" bytes");
                throw new ProtocolException(stringBuilder.toString());
            }
            this.c.a_(c2, l2);
            return;
        }
        throw new IllegalStateException("closed");
    }

    public long b() throws IOException {
        return this.c.b();
    }

    @Override
    public void close() throws IOException {
        if (this.a) {
            return;
        }
        this.a = true;
        if (this.c.b() >= (long)this.b) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("content-length promised ");
        stringBuilder.append(this.b);
        stringBuilder.append(" bytes, but received ");
        stringBuilder.append(this.c.b());
        throw new ProtocolException(stringBuilder.toString());
    }

    @Override
    public void flush() throws IOException {
    }
}

