/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.a.k$1
 *  b.a.a.o
 *  c.e
 *  c.k
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.zip.DataFormatException
 *  java.util.zip.Inflater
 */
package b.a.a;

import b.a.a.f;
import b.a.a.k;
import b.a.a.o;
import c.e;
import c.l;
import c.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

class k {
    private final c.k a;
    private int b;
    private final e c;

    public k(e e2) {
        this.a = new c.k((r)new 1(this, (r)e2), new Inflater(){

            public int inflate(byte[] arrby, int n2, int n3) throws DataFormatException {
                int n4 = super.inflate(arrby, n2, n3);
                if (n4 == 0 && this.needsDictionary()) {
                    this.setDictionary(o.a);
                    n4 = super.inflate(arrby, n2, n3);
                }
                return n4;
            }
        });
        this.c = l.a((r)this.a);
    }

    static /* synthetic */ int a(k k2) {
        return k2.b;
    }

    static /* synthetic */ int a(k k2, int n2) {
        k2.b = n2;
        return n2;
    }

    private c.f b() throws IOException {
        int n2 = this.c.l();
        return this.c.c((long)n2);
    }

    private void c() throws IOException {
        if (this.b > 0) {
            this.a.b();
            if (this.b == 0) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("compressedLimit > 0: ");
            stringBuilder.append(this.b);
            throw new IOException(stringBuilder.toString());
        }
    }

    public List<f> a(int n2) throws IOException {
        this.b = n2 + this.b;
        int n3 = this.c.l();
        if (n3 >= 0) {
            if (n3 <= 1024) {
                ArrayList arrayList = new ArrayList(n3);
                for (int i2 = 0; i2 < n3; ++i2) {
                    c.f f2 = this.b().e();
                    c.f f3 = this.b();
                    if (f2.f() != 0) {
                        arrayList.add((Object)new f(f2, f3));
                        continue;
                    }
                    throw new IOException("name.size == 0");
                }
                this.c();
                return arrayList;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("numberOfPairs > 1024: ");
            stringBuilder.append(n3);
            throw new IOException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("numberOfPairs < 0: ");
        stringBuilder.append(n3);
        throw new IOException(stringBuilder.toString());
    }

    public void a() throws IOException {
        this.c.close();
    }

}

