/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.google.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class c
implements Closeable,
Flushable {
    private static final String[] a = new String[128];
    private static final String[] b;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i2 = 0; i2 <= 31; ++i2) {
            String[] arrstring = a;
            Object[] arrobject = new Object[]{i2};
            arrstring[i2] = String.format((String)"\\u%04x", (Object[])arrobject);
        }
        c.a[34] = "\\\"";
        c.a[92] = "\\\\";
        c.a[9] = "\\t";
        c.a[8] = "\\b";
        c.a[10] = "\\n";
        c.a[13] = "\\r";
        c.a[12] = "\\f";
        b = (String[])a.clone();
        c.b[60] = "\\u003c";
        c.b[62] = "\\u003e";
        c.b[38] = "\\u0026";
        c.b[61] = "\\u003d";
        c.b[39] = "\\u0027";
    }

    public c(Writer writer) {
        this.a(6);
        this.g = ":";
        this.k = true;
        if (writer != null) {
            this.c = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private int a() {
        if (this.e != 0) {
            return this.d[-1 + this.e];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private c a(int n2, int n3, String string) throws IOException {
        int n4 = this.a();
        if (n4 != n3 && n4 != n2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j == null) {
            this.e = -1 + this.e;
            if (n4 == n3) {
                this.k();
            }
            this.c.write(string);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dangling name: ");
        stringBuilder.append(this.j);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private c a(int n2, String string) throws IOException {
        this.m();
        this.a(n2);
        this.c.write(string);
        return this;
    }

    private void a(int n2) {
        if (this.e == this.d.length) {
            int[] arrn = new int[2 * this.e];
            System.arraycopy((Object)this.d, (int)0, (Object)arrn, (int)0, (int)this.e);
            this.d = arrn;
        }
        int[] arrn = this.d;
        int n3 = this.e;
        this.e = n3 + 1;
        arrn[n3] = n2;
    }

    private void b(int n2) {
        this.d[-1 + this.e] = n2;
    }

    private void d(String string) throws IOException {
        String[] arrstring = this.i ? b : a;
        this.c.write("\"");
        int n2 = string.length();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2;
            char c2 = string.charAt(i2);
            if (c2 < '') {
                string2 = arrstring[c2];
                if (string2 == null) {
                    continue;
                }
            } else if (c2 == '\u2028') {
                string2 = "\\u2028";
            } else {
                if (c2 != '\u2029') continue;
                string2 = "\\u2029";
            }
            if (n3 < i2) {
                this.c.write(string, n3, i2 - n3);
            }
            this.c.write(string2);
            n3 = i2 + 1;
        }
        if (n3 < n2) {
            this.c.write(string, n3, n2 - n3);
        }
        this.c.write("\"");
    }

    private void j() throws IOException {
        if (this.j != null) {
            this.l();
            this.d(this.j);
            this.j = null;
        }
    }

    private void k() throws IOException {
        if (this.f == null) {
            return;
        }
        this.c.write("\n");
        int n2 = this.e;
        for (int i2 = 1; i2 < n2; ++i2) {
            this.c.write(this.f);
        }
    }

    private void l() throws IOException {
        block4 : {
            block3 : {
                int n2;
                block2 : {
                    n2 = this.a();
                    if (n2 != 5) break block2;
                    this.c.write(44);
                    break block3;
                }
                if (n2 != 3) break block4;
            }
            this.k();
            this.b(4);
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void m() throws IOException {
        block7 : {
            switch (this.a()) {
                default: {
                    throw new IllegalStateException("Nesting problem.");
                }
                case 7: {
                    if (this.h == false) throw new IllegalStateException("JSON must have only one top-level value.");
                }
                case 6: {
                    var3_1 = 7;
                    ** GOTO lbl12
                }
                case 4: {
                    this.c.append((CharSequence)this.g);
                    var3_1 = 5;
lbl12: // 2 sources:
                    this.b(var3_1);
                    return;
                }
                case 2: {
                    this.c.append(',');
                    break block7;
                }
                case 1: 
            }
            this.b(2);
        }
        this.k();
    }

    public c a(long l2) throws IOException {
        this.j();
        this.m();
        this.c.write(Long.toString((long)l2));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return this.f();
        }
        this.j();
        String string = number.toString();
        if (!this.h && (string.equals((Object)"-Infinity") || string.equals((Object)"Infinity") || string.equals((Object)"NaN"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append((Object)number);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.m();
        this.c.append((CharSequence)string);
        return this;
    }

    public c a(String string) throws IOException {
        if (string != null) {
            if (this.j == null) {
                if (this.e != 0) {
                    this.j = string;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public c a(boolean bl) throws IOException {
        this.j();
        this.m();
        Writer writer = this.c;
        String string = bl ? "true" : "false";
        writer.write(string);
        return this;
    }

    public c b() throws IOException {
        this.j();
        return this.a(1, "[");
    }

    public c b(String string) throws IOException {
        if (string == null) {
            return this.f();
        }
        this.j();
        this.m();
        this.d(string);
        return this;
    }

    public final void b(boolean bl) {
        this.h = bl;
    }

    public c c() throws IOException {
        return this.a(1, 2, "]");
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void c(String string) {
        String string2;
        if (string.length() == 0) {
            this.f = null;
            string2 = ":";
        } else {
            this.f = string;
            string2 = ": ";
        }
        this.g = string2;
    }

    public final void c(boolean bl) {
        this.i = bl;
    }

    public void close() throws IOException {
        this.c.close();
        int n2 = this.e;
        if (n2 <= 1 && (n2 != 1 || this.d[n2 - 1] == 7)) {
            this.e = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public c d() throws IOException {
        this.j();
        return this.a(3, "{");
    }

    public final void d(boolean bl) {
        this.k = bl;
    }

    public c e() throws IOException {
        return this.a(3, 5, "}");
    }

    public c f() throws IOException {
        if (this.j != null) {
            if (this.k) {
                this.j();
            } else {
                this.j = null;
                return this;
            }
        }
        this.m();
        this.c.write("null");
        return this;
    }

    public void flush() throws IOException {
        if (this.e != 0) {
            this.c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public boolean g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }

    public final boolean i() {
        return this.k;
    }
}

