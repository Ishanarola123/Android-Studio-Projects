/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c;

import c.c;
import c.r;
import c.s;
import java.io.IOException;

public abstract class h
implements r {
    private final r a;

    public h(r r2) {
        if (r2 != null) {
            this.a = r2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override
    public long a(c c2, long l2) throws IOException {
        return this.a.a(c2, l2);
    }

    @Override
    public s a() {
        return this.a.a();
    }

    @Override
    public void close() throws IOException {
        this.a.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("(");
        stringBuilder.append(this.a.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

