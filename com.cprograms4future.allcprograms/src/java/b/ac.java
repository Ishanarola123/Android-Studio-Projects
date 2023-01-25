/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.ac$1
 *  c.e
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package b;

import b.a.i;
import b.ac;
import b.u;
import c.e;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ac
implements Closeable {
    private Reader a;

    public static ac a(u u2, long l2, e e2) {
        if (e2 != null) {
            return new 1(u2, l2, e2);
        }
        throw new NullPointerException("source == null");
    }

    private Charset f() {
        u u2 = this.a();
        if (u2 != null) {
            return u2.a(i.c);
        }
        return i.c;
    }

    public abstract u a();

    public abstract long b();

    public final InputStream c() {
        return this.d().h();
    }

    public void close() {
        i.a((Closeable)this.d());
    }

    public abstract e d();

    public final Reader e() {
        Reader reader = this.a;
        if (reader != null) {
            return reader;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(this.c(), this.f());
        this.a = inputStreamReader;
        return inputStreamReader;
    }
}

