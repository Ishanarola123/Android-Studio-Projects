/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.a.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class n
extends InputStream {
    private final InputStream a;
    private long b;
    private long c;
    private long d;
    private long e = -1L;

    public n(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public n(InputStream inputStream, int n2) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, n2);
        }
        this.a = inputStream;
    }

    private void a(long l2, long l3) throws IOException {
        while (l2 < l3) {
            long l4 = this.a.skip(l3 - l2);
            if (l4 == 0L) {
                if (this.read() == -1) {
                    return;
                }
                l4 = 1L;
            }
            l2 += l4;
        }
    }

    private void b(long l2) {
        try {
            if (this.c < this.b && this.b <= this.d) {
                this.a.reset();
                this.a.mark((int)(l2 - this.c));
                this.a(this.c, this.b);
            } else {
                this.c = this.b;
                this.a.mark((int)(l2 - this.b));
            }
            this.d = l2;
            return;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to mark: ");
            stringBuilder.append((Object)iOException);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public long a(int n2) {
        long l2 = this.b + (long)n2;
        if (this.d < l2) {
            this.b(l2);
        }
        return this.b;
    }

    public void a(long l2) throws IOException {
        if (this.b <= this.d && l2 >= this.c) {
            this.a.reset();
            this.a(this.c, l2);
            this.b = l2;
            return;
        }
        throw new IOException("Cannot reset");
    }

    public int available() throws IOException {
        return this.a.available();
    }

    public void close() throws IOException {
        this.a.close();
    }

    public void mark(int n2) {
        this.e = this.a(n2);
    }

    public boolean markSupported() {
        return this.a.markSupported();
    }

    public int read() throws IOException {
        int n2 = this.a.read();
        if (n2 != -1) {
            this.b = 1L + this.b;
        }
        return n2;
    }

    public int read(byte[] arrby) throws IOException {
        int n2 = this.a.read(arrby);
        if (n2 != -1) {
            this.b += (long)n2;
        }
        return n2;
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        int n4 = this.a.read(arrby, n2, n3);
        if (n4 != -1) {
            this.b += (long)n4;
        }
        return n4;
    }

    public void reset() throws IOException {
        this.a(this.e);
    }

    public long skip(long l2) throws IOException {
        long l3 = this.a.skip(l2);
        this.b = l3 + this.b;
        return l3;
    }
}

