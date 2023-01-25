/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.zip.CRC32
 *  java.util.zip.Inflater
 */
package c;

import c.c;
import c.e;
import c.k;
import c.l;
import c.o;
import c.r;
import c.s;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class j
implements r {
    private int a = 0;
    private final e b;
    private final Inflater c;
    private final k d;
    private final CRC32 e = new CRC32();

    public j(r r2) {
        if (r2 != null) {
            this.c = new Inflater(true);
            this.b = l.a(r2);
            this.d = new k(this.b, this.c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a(c c2, long l2, long l3) {
        o o2 = c2.a;
        while (l2 >= (long)(o2.c - o2.b)) {
            l2 -= (long)(o2.c - o2.b);
            o2 = o2.f;
        }
        while (l3 > 0L) {
            int n2 = (int)(l2 + (long)o2.b);
            int n3 = (int)Math.min((long)(o2.c - n2), (long)l3);
            this.e.update(o2.a, n2, n3);
            l3 -= (long)n3;
            o2 = o2.f;
            l2 = 0L;
        }
    }

    private void a(String string, int n2, int n3) throws IOException {
        if (n3 == n2) {
            return;
        }
        Object[] arrobject = new Object[]{string, n3, n2};
        throw new IOException(String.format((String)"%s: actual 0x%08x != expected 0x%08x", (Object[])arrobject));
    }

    private void b() throws IOException {
        this.b.a(10L);
        byte by = this.b.c().b(3L);
        boolean bl = (1 & by >> 1) == 1;
        if (bl) {
            this.a(this.b.c(), 0L, 10L);
        }
        this.a("ID1ID2", 8075, this.b.k());
        this.b.g(8L);
        if ((1 & by >> 2) == 1) {
            this.b.a(2L);
            if (bl) {
                this.a(this.b.c(), 0L, 2L);
            }
            short s2 = this.b.c().m();
            e e2 = this.b;
            long l2 = s2;
            e2.a(l2);
            if (bl) {
                this.a(this.b.c(), 0L, l2);
            }
            this.b.g(l2);
        }
        if ((1 & by >> 3) == 1) {
            long l3 = this.b.a((byte)0);
            if (l3 != -1L) {
                if (bl) {
                    this.a(this.b.c(), 0L, l3 + 1L);
                }
                this.b.g(l3 + 1L);
            } else {
                throw new EOFException();
            }
        }
        if ((1 & by >> 4) == 1) {
            long l4 = this.b.a((byte)0);
            if (l4 != -1L) {
                if (bl) {
                    this.a(this.b.c(), 0L, l4 + 1L);
                }
                this.b.g(l4 + 1L);
            } else {
                throw new EOFException();
            }
        }
        if (bl) {
            this.a("FHCRC", this.b.m(), (short)this.e.getValue());
            this.e.reset();
        }
    }

    private void c() throws IOException {
        this.a("CRC", this.b.n(), (int)this.e.getValue());
        this.a("ISIZE", this.b.n(), this.c.getTotalOut());
    }

    @Override
    public long a(c c2, long l2) throws IOException {
        if (l2 >= 0L) {
            if (l2 == 0L) {
                return 0L;
            }
            if (this.a == 0) {
                this.b();
                this.a = 1;
            }
            if (this.a == 1) {
                long l3 = c2.b;
                long l4 = this.d.a(c2, l2);
                if (l4 != -1L) {
                    this.a(c2, l3, l4);
                    return l4;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                this.c();
                this.a = 3;
                if (this.b.g()) {
                    return -1L;
                }
                throw new IOException("gzip finished without exhausting source");
            }
            return -1L;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount < 0: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public s a() {
        return this.b.a();
    }

    @Override
    public void close() throws IOException {
        this.d.close();
    }
}

