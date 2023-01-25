/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.aa$1
 *  b.aa$2
 *  b.aa$3
 *  c.d
 *  java.io.File
 *  java.io.IOException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package b;

import b.a.i;
import b.aa;
import b.u;
import c.d;
import c.f;
import java.io.File;
import java.io.IOException;

public abstract class aa {
    public static aa a(u u2, f f2) {
        return new 1(u2, f2);
    }

    public static aa a(u u2, File file) {
        if (file != null) {
            return new 3(u2, file);
        }
        throw new NullPointerException("content == null");
    }

    public static aa a(u u2, byte[] arrby) {
        return aa.a(u2, arrby, 0, arrby.length);
    }

    public static aa a(u u2, byte[] arrby, int n2, int n3) {
        if (arrby != null) {
            i.a(arrby.length, (long)n2, (long)n3);
            return new 2(u2, n3, arrby, n2);
        }
        throw new NullPointerException("content == null");
    }

    public abstract void a(d var1) throws IOException;

    public abstract u b();

    public long c() throws IOException {
        return -1L;
    }
}

