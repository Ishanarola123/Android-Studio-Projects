/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.m
 *  com.google.a.n
 *  com.google.a.t
 *  com.google.a.w
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.google.a.b;

import com.google.a.b.a.m;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.d.d;
import com.google.a.l;
import com.google.a.n;
import com.google.a.p;
import com.google.a.t;
import com.google.a.w;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class j {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static l a(com.google.a.d.a a2) throws p {
        boolean bl;
        try {
            try {
                a2.f();
            }
            catch (EOFException eOFException) {
                bl = true;
            }
            try {
                return (l)m.X.b(a2);
            }
            catch (EOFException eOFException) {
                bl = false;
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw new t((Throwable)numberFormatException);
        }
        catch (IOException iOException) {
            throw new com.google.a.m((Throwable)iOException);
        }
        catch (d d2) {
            throw new t((Throwable)((Object)d2));
        }
        if (!bl) void var1_4;
        throw new t((Throwable)var1_4);
        return n.a;
    }

    public static Writer a(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer)appendable;
        }
        return new a(appendable);
    }

    public static void a(l l2, c c2) throws IOException {
        m.X.a(c2, (Object)l2);
    }

    private static final class com.google.a.b.j$a
    extends Writer {
        private final Appendable a;
        private final a b = new a();

        com.google.a.b.j$a(Appendable appendable) {
            this.a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int n2) throws IOException {
            this.a.append((char)n2);
        }

        public void write(char[] arrc, int n2, int n3) throws IOException {
            this.b.a = arrc;
            this.a.append((CharSequence)this.b, n2, n3 + n2);
        }

        static class a
        implements CharSequence {
            char[] a;

            a() {
            }

            public char charAt(int n2) {
                return this.a[n2];
            }

            public int length() {
                return this.a.length;
            }

            public CharSequence subSequence(int n2, int n3) {
                return new String(this.a, n2, n3 - n2);
            }
        }

    }

}

