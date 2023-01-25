/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.zip.DataFormatException
 *  java.util.zip.Inflater
 */
package c;

import c.c;
import c.e;
import c.l;
import c.o;
import c.p;
import c.r;
import c.s;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class k
implements r {
    private final e a;
    private final Inflater b;
    private int c;
    private boolean d;

    k(e e2, Inflater inflater) {
        if (e2 != null) {
            if (inflater != null) {
                this.a = e2;
                this.b = inflater;
                return;
            }
            throw new IllegalArgumentException("inflater == null");
        }
        throw new IllegalArgumentException("source == null");
    }

    public k(r r2, Inflater inflater) {
        this(l.a(r2), inflater);
    }

    private void c() throws IOException {
        if (this.c == 0) {
            return;
        }
        int n2 = this.c - this.b.getRemaining();
        this.c -= n2;
        this.a.g(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public long a(c c2, long l2) throws IOException {
        boolean bl;
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (l2 == 0L) {
            return 0L;
        }
        do {
            bl = this.b();
            try {
                o o2 = c2.e(1);
                int n2 = this.b.inflate(o2.a, o2.c, 2048 - o2.c);
                if (n2 > 0) {
                    o2.c = n2 + o2.c;
                    long l3 = c2.b;
                    long l4 = n2;
                    c2.b = l3 + l4;
                    return l4;
                }
                if (this.b.finished() || this.b.needsDictionary()) {
                    this.c();
                    if (o2.b == o2.c) {
                        c2.a = o2.a();
                        p.a(o2);
                    }
                    return -1L;
                }
            }
            catch (DataFormatException dataFormatException) {
                throw new IOException((Throwable)dataFormatException);
            }
        } while (!bl);
        throw new EOFException("source exhausted prematurely");
    }

    @Override
    public s a() {
        return this.a.a();
    }

    public boolean b() throws IOException {
        if (!this.b.needsInput()) {
            return false;
        }
        this.c();
        if (this.b.getRemaining() == 0) {
            if (this.a.g()) {
                return true;
            }
            o o2 = this.a.c().a;
            this.c = o2.c - o2.b;
            this.b.setInput(o2.a, o2.b, this.c);
            return false;
        }
        throw new IllegalStateException("?");
    }

    @Override
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }
}

