/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.lang.Object
 */
package c;

import c.c;
import c.s;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface q
extends Closeable,
Flushable {
    public s a();

    public void a_(c var1, long var2) throws IOException;

    public void close() throws IOException;

    public void flush() throws IOException;
}

