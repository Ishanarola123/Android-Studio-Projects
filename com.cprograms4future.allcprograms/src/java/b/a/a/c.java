/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 *  java.util.List
 */
package b.a.a;

import b.a.a.a;
import b.a.a.f;
import b.a.a.n;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public interface c
extends Closeable {
    public void a() throws IOException;

    public void a(int var1, int var2, List<f> var3) throws IOException;

    public void a(int var1, long var2) throws IOException;

    public void a(int var1, a var2) throws IOException;

    public void a(int var1, a var2, byte[] var3) throws IOException;

    public void a(n var1) throws IOException;

    public void a(boolean var1, int var2, int var3) throws IOException;

    public void a(boolean var1, int var2, c.c var3, int var4) throws IOException;

    public void a(boolean var1, boolean var2, int var3, int var4, List<f> var5) throws IOException;

    public void b() throws IOException;

    public void b(n var1) throws IOException;

    public int c();
}

