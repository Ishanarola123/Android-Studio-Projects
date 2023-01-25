/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.lang.Object
 */
package b;

import b.a.b;
import b.a.d;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public final class c
implements Closeable,
Flushable {
    final d a;
    private final b b;

    public void close() throws IOException {
        this.b.close();
    }

    public void flush() throws IOException {
        this.b.flush();
    }
}

