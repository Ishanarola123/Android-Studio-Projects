/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 *  java.util.List
 */
package b.a.a;

import b.a.a.f;
import b.a.a.g;
import b.a.a.n;
import c.e;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public interface b
extends Closeable {
    public void a() throws IOException;

    public boolean a(a var1) throws IOException;

    public static interface a {
        public void a();

        public void a(int var1, int var2, int var3, boolean var4);

        public void a(int var1, int var2, List<f> var3) throws IOException;

        public void a(int var1, long var2);

        public void a(int var1, b.a.a.a var2);

        public void a(int var1, b.a.a.a var2, c.f var3);

        public void a(boolean var1, int var2, int var3);

        public void a(boolean var1, int var2, e var3, int var4) throws IOException;

        public void a(boolean var1, n var2);

        public void a(boolean var1, boolean var2, int var3, int var4, List<f> var5, g var6);
    }

}

