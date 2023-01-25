/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.IllegalAccessError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
package c;

import c.c;
import c.d;
import c.e;
import c.f;
import c.o;
import c.p;
import c.q;
import c.r;
import c.s;
import c.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
implements d,
e,
Cloneable {
    private static final byte[] c = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    o a;
    long b;

    public int a(byte[] arrby, int n2, int n3) {
        t.a(arrby.length, n2, n3);
        o o2 = this.a;
        if (o2 == null) {
            return -1;
        }
        int n4 = Math.min((int)n3, (int)(o2.c - o2.b));
        System.arraycopy((Object)o2.a, (int)o2.b, (Object)arrby, (int)n2, (int)n4);
        o2.b = n4 + o2.b;
        this.b -= (long)n4;
        if (o2.b == o2.c) {
            this.a = o2.a();
            p.a(o2);
        }
        return n4;
    }

    @Override
    public long a(byte by) {
        return this.a(by, 0L);
    }

    public long a(byte by, long l2) {
        if (l2 >= 0L) {
            o o2 = this.a;
            if (o2 == null) {
                return -1L;
            }
            long l3 = 0L;
            do {
                long l4;
                if (l2 >= (l4 = (long)(o2.c - o2.b))) {
                    l2 -= l4;
                } else {
                    byte[] arrby = o2.a;
                    int n2 = o2.c;
                    for (int i2 = (int)(l2 + (long)o2.b); i2 < n2; ++i2) {
                        if (arrby[i2] != by) continue;
                        return l3 + (long)i2 - (long)o2.b;
                    }
                    l2 = 0L;
                }
                l3 += l4;
            } while ((o2 = o2.f) != this.a);
            return -1L;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override
    public long a(c c2, long l2) {
        if (c2 != null) {
            if (l2 >= 0L) {
                if (this.b == 0L) {
                    return -1L;
                }
                if (l2 > this.b) {
                    l2 = this.b;
                }
                c2.a_(this, l2);
                return l2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override
    public long a(q q2) throws IOException {
        long l2 = this.b;
        if (l2 > 0L) {
            q2.a_(this, l2);
        }
        return l2;
    }

    @Override
    public long a(r r2) throws IOException {
        if (r2 != null) {
            long l2;
            long l3 = 0L;
            while ((l2 = r2.a(this, 2048L)) != -1L) {
                l3 += l2;
            }
            return l3;
        }
        throw new IllegalArgumentException("source == null");
    }

    /*
     * Enabled aggressive block sorting
     */
    public c a(int n2) {
        if (n2 >= 128) {
            int n3;
            if (n2 < 2048) {
                n3 = 192 | n2 >> 6;
            } else {
                int n4;
                if (n2 < 65536) {
                    if (n2 >= 55296 && n2 <= 57343) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected code point: ");
                        stringBuilder.append(Integer.toHexString((int)n2));
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    n4 = 224 | n2 >> 12;
                } else {
                    if (n2 > 1114111) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected code point: ");
                        stringBuilder.append(Integer.toHexString((int)n2));
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    this.b(240 | n2 >> 18);
                    n4 = 128 | 63 & n2 >> 12;
                }
                this.b(n4);
                n3 = 128 | 63 & n2 >> 6;
            }
            this.b(n3);
            n2 = 128 | n2 & 63;
        }
        this.b(n2);
        return this;
    }

    public c a(c c2, long l2, long l3) {
        if (c2 != null) {
            t.a(this.b, l2, l3);
            if (l3 == 0L) {
                return this;
            }
            c2.b = l3 + c2.b;
            o o2 = this.a;
            while (l2 >= (long)(o2.c - o2.b)) {
                l2 -= (long)(o2.c - o2.b);
                o2 = o2.f;
            }
            while (l3 > 0L) {
                o o3 = new o(o2);
                o3.b = (int)(l2 + (long)o3.b);
                o3.c = Math.min((int)(o3.b + (int)l3), (int)o3.c);
                if (c2.a == null) {
                    o3.g = o3;
                    o3.f = o3;
                    c2.a = o3;
                } else {
                    c2.a.g.a(o3);
                }
                l3 -= (long)(o3.c - o3.b);
                o2 = o2.f;
                l2 = 0L;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public c a(f f2) {
        if (f2 != null) {
            f2.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public c a(String string) {
        return this.a(string, 0, string.length());
    }

    /*
     * Enabled aggressive block sorting
     */
    public c a(String string, int n2, int n3) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("beginIndex < 0: ");
            stringBuilder.append(n2);
            throw new IllegalAccessError(stringBuilder.toString());
        }
        if (n3 < n2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex < beginIndex: ");
            stringBuilder.append(n3);
            stringBuilder.append(" < ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n3 > string.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > string.length: ");
            stringBuilder.append(n3);
            stringBuilder.append(" > ");
            stringBuilder.append(string.length());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        while (n2 < n3) {
            int n4;
            o o2;
            int n5;
            int n6;
            char c2;
            char c3 = string.charAt(n2);
            if (c3 < '') {
                o2 = this.e(1);
                byte[] arrby = o2.a;
                n4 = o2.c - n2;
                n6 = Math.min((int)n3, (int)(2048 - n4));
                n5 = n2 + 1;
                arrby[n2 + n4] = (byte)c3;
            } else {
                int n7;
                if (c3 < '\u0800') {
                    n7 = 192 | c3 >> 6;
                } else {
                    if (c3 >= '\ud800' && c3 <= '\udfff') {
                        int n8 = n2 + 1;
                        char c4 = n8 < n3 ? string.charAt(n8) : (char)'\u0000';
                        if (c3 <= '\udbff' && c4 >= '\udc00' && c4 <= '\udfff') {
                            int n9 = 65536 + ((c3 & -55297) << 10 | -56321 & c4);
                            this.b(240 | n9 >> 18);
                            this.b(128 | 63 & n9 >> 12);
                            this.b(128 | 63 & n9 >> 6);
                            this.b(128 | n9 & 63);
                            n2 += 2;
                            continue;
                        }
                        this.b(63);
                        n2 = n8;
                        continue;
                    }
                    this.b(224 | c3 >> 12);
                    n7 = 128 | 63 & c3 >> 6;
                }
                this.b(n7);
                this.b(128 | c3 & 63);
                ++n2;
                continue;
            }
            while (n5 < n6 && (c2 = string.charAt(n5)) < '') {
                int n10 = n5 + 1;
                arrby[n5 + n4] = (byte)c2;
                n5 = n10;
            }
            int n11 = n4 + n5 - o2.c;
            o2.c = n11 + o2.c;
            this.b += (long)n11;
            n2 = n5;
        }
        return this;
    }

    @Override
    public s a() {
        return s.b;
    }

    public String a(long l2, Charset charset) throws EOFException {
        t.a(this.b, 0L, l2);
        if (charset != null) {
            if (l2 <= Integer.MAX_VALUE) {
                if (l2 == 0L) {
                    return "";
                }
                o o2 = this.a;
                if (l2 + (long)o2.b > (long)o2.c) {
                    return new String(this.f(l2), charset);
                }
                String string = new String(o2.a, o2.b, (int)l2, charset);
                o2.b = (int)(l2 + (long)o2.b);
                this.b -= l2;
                if (o2.b == o2.c) {
                    this.a = o2.a();
                    p.a(o2);
                }
                return string;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override
    public void a(long l2) throws EOFException {
        if (this.b >= l2) {
            return;
        }
        throw new EOFException();
    }

    public void a(byte[] arrby) throws EOFException {
        int n2;
        for (int i2 = 0; i2 < arrby.length; i2 += n2) {
            n2 = this.a(arrby, i2, arrby.length - i2);
            if (n2 != -1) {
                continue;
            }
            throw new EOFException();
        }
    }

    @Override
    public void a_(c c2, long l2) {
        if (c2 != null) {
            if (c2 != this) {
                t.a(c2.b, 0L, l2);
                while (l2 > 0L) {
                    if (l2 < (long)(c2.a.c - c2.a.b)) {
                        int n2;
                        long l3;
                        o o2 = this.a != null ? this.a.g : null;
                        if (o2 != null && o2.e && (l3 = l2 + (long)o2.c) - (long)(n2 = o2.d ? 0 : o2.b) <= 2048L) {
                            c2.a.a(o2, (int)l2);
                            c2.b -= l2;
                            this.b = l2 + this.b;
                            return;
                        }
                        c2.a = c2.a.a((int)l2);
                    }
                    o o3 = c2.a;
                    long l4 = o3.c - o3.b;
                    c2.a = o3.a();
                    if (this.a == null) {
                        o o4;
                        o o5 = this.a = o3;
                        o o6 = this.a;
                        o6.g = o4 = this.a;
                        o5.f = o4;
                    } else {
                        this.a.g.a(o3).b();
                    }
                    c2.b -= l4;
                    this.b = l4 + this.b;
                    l2 -= l4;
                }
                return;
            }
            throw new IllegalArgumentException("source == this");
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte b(long l2) {
        t.a(this.b, l2, 1L);
        o o2 = this.a;
        long l3;
        while (l2 >= (l3 = (long)(o2.c - o2.b))) {
            l2 -= l3;
            o2 = o2.f;
        }
        return o2.a[o2.b + (int)l2];
    }

    public long b() {
        return this.b;
    }

    public c b(int n2) {
        o o2 = this.e(1);
        byte[] arrby = o2.a;
        int n3 = o2.c;
        o2.c = n3 + 1;
        arrby[n3] = (byte)n2;
        this.b = 1L + this.b;
        return this;
    }

    public c b(byte[] arrby) {
        if (arrby != null) {
            return this.b(arrby, 0, arrby.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public c b(byte[] arrby, int n2, int n3) {
        if (arrby != null) {
            long l2 = arrby.length;
            long l3 = n2;
            long l4 = n3;
            t.a(l2, l3, l4);
            int n4 = n3 + n2;
            while (n2 < n4) {
                o o2 = this.e(1);
                int n5 = Math.min((int)(n4 - n2), (int)(2048 - o2.c));
                System.arraycopy((Object)arrby, (int)n2, (Object)o2.a, (int)o2.c, (int)n5);
                n2 += n5;
                o2.c = n5 + o2.c;
            }
            this.b = l4 + this.b;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override
    public /* synthetic */ d b(f f2) throws IOException {
        return this.a(f2);
    }

    @Override
    public /* synthetic */ d b(String string) throws IOException {
        return this.a(string);
    }

    @Override
    public c c() {
        return this;
    }

    public c c(int n2) {
        o o2 = this.e(2);
        byte[] arrby = o2.a;
        int n3 = o2.c;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(255 & n2 >>> 8);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(n2 & 255);
        o2.c = n5;
        this.b = 2L + this.b;
        return this;
    }

    @Override
    public /* synthetic */ d c(byte[] arrby) throws IOException {
        return this.b(arrby);
    }

    @Override
    public /* synthetic */ d c(byte[] arrby, int n2, int n3) throws IOException {
        return this.b(arrby, n2, n3);
    }

    @Override
    public f c(long l2) throws EOFException {
        return new f(this.f(l2));
    }

    public void clear() {
        try {
            this.g(this.b);
            return;
        }
        catch (EOFException eOFException) {
            throw new AssertionError((Object)eOFException);
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.t();
    }

    @Override
    public void close() {
    }

    public c d(int n2) {
        o o2 = this.e(4);
        byte[] arrby = o2.a;
        int n3 = o2.c;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(255 & n2 >>> 24);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(255 & n2 >>> 16);
        int n6 = n5 + 1;
        arrby[n5] = (byte)(255 & n2 >>> 8);
        int n7 = n6 + 1;
        arrby[n6] = (byte)(n2 & 255);
        o2.c = n7;
        this.b = 4L + this.b;
        return this;
    }

    public OutputStream d() {
        return new OutputStream(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void close() {
            }

            public void flush() {
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)((Object)this));
                stringBuilder.append(".outputStream()");
                return stringBuilder.toString();
            }

            public void write(int n2) {
                this.a.b((byte)n2);
            }

            public void write(byte[] arrby, int n2, int n3) {
                this.a.b(arrby, n2, n3);
            }
        };
    }

    public String d(long l2) throws EOFException {
        return this.a(l2, t.a);
    }

    public c e() {
        return this;
    }

    o e(int n2) {
        if (n2 >= 1 && n2 <= 2048) {
            if (this.a == null) {
                o o2;
                o o3 = this.a = p.a();
                o o4 = this.a;
                o4.g = o2 = this.a;
                o3.f = o2;
                return o2;
            }
            o o5 = this.a.g;
            if (n2 + o5.c > 2048 || !o5.e) {
                o5 = o5.a(p.a());
            }
            return o5;
        }
        throw new IllegalArgumentException();
    }

    /*
     * Enabled aggressive block sorting
     */
    String e(long l2) throws EOFException {
        long l3;
        String string;
        long l4 = 1L;
        if (l2 > 0L && this.b(l3 = l2 - l4) == 13) {
            string = this.d(l3);
            l4 = 2L;
        } else {
            string = this.d(l2);
        }
        this.g(l4);
        return string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        c c2 = (c)object;
        if (this.b != c2.b) {
            return false;
        }
        long l2 = this.b;
        long l3 = 0L;
        if (l2 == l3) {
            return true;
        }
        o o2 = this.a;
        o o3 = c2.a;
        int n2 = o2.b;
        int n3 = o3.b;
        while (l3 < this.b) {
            long l4 = Math.min((int)(o2.c - n2), (int)(o3.c - n3));
            int n4 = n3;
            int n5 = n2;
            int n6 = 0;
            while ((long)n6 < l4) {
                byte[] arrby = o2.a;
                int n7 = n5 + 1;
                byte by = arrby[n5];
                byte[] arrby2 = o3.a;
                int n8 = n4 + 1;
                if (by != arrby2[n4]) {
                    return false;
                }
                ++n6;
                n5 = n7;
                n4 = n8;
            }
            if (n5 == o2.c) {
                o2 = o2.f;
                n2 = o2.b;
            } else {
                n2 = n5;
            }
            if (n4 == o3.c) {
                o3 = o3.f;
                n3 = o3.b;
            } else {
                n3 = n4;
            }
            l3 += l4;
        }
        return true;
    }

    @Override
    public d f() {
        return this;
    }

    @Override
    public /* synthetic */ d f(int n2) throws IOException {
        return this.d(n2);
    }

    @Override
    public byte[] f(long l2) throws EOFException {
        t.a(this.b, 0L, l2);
        if (l2 <= Integer.MAX_VALUE) {
            byte[] arrby = new byte[(int)l2];
            this.a(arrby);
            return arrby;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public void flush() {
    }

    @Override
    public /* synthetic */ d g(int n2) throws IOException {
        return this.c(n2);
    }

    @Override
    public void g(long l2) throws EOFException {
        while (l2 > 0L) {
            if (this.a != null) {
                int n2 = (int)Math.min((long)l2, (long)(this.a.c - this.a.b));
                long l3 = this.b;
                long l4 = n2;
                this.b = l3 - l4;
                l2 -= l4;
                o o2 = this.a;
                o2.b = n2 + o2.b;
                if (this.a.b != this.a.c) continue;
                o o3 = this.a;
                this.a = o3.a();
                p.a(o3);
                continue;
            }
            throw new EOFException();
        }
    }

    @Override
    public boolean g() {
        return this.b == 0L;
    }

    public c h(long l2) {
        if (l2 == 0L) {
            return this.b(48);
        }
        int n2 = 1;
        long l3 = l2 LCMP 0L;
        boolean bl = false;
        if (l3 < 0) {
            if ((l2 = -l2) < 0L) {
                return this.a("-9223372036854775808");
            }
            bl = true;
        }
        if (l2 < 100000000L) {
            if (l2 < 10000L) {
                if (l2 < 100L) {
                    if (l2 >= 10L) {
                        n2 = 2;
                    }
                } else {
                    n2 = l2 < 1000L ? 3 : 4;
                }
            } else {
                n2 = l2 < 1000000L ? (l2 < 100000L ? 5 : 6) : (l2 < 10000000L ? 7 : 8);
            }
        } else {
            n2 = l2 < 1000000000000L ? (l2 < 10000000000L ? (l2 < 1000000000L ? 9 : 10) : (l2 < 100000000000L ? 11 : 12)) : (l2 < 1000000000000000L ? (l2 < 10000000000000L ? 13 : (l2 < 100000000000000L ? 14 : 15)) : (l2 < 100000000000000000L ? (l2 < 10000000000000000L ? 16 : 17) : (l2 < 1000000000000000000L ? 18 : 19)));
        }
        if (bl) {
            ++n2;
        }
        o o2 = this.e(n2);
        byte[] arrby = o2.a;
        int n3 = n2 + o2.c;
        while (l2 != 0L) {
            int n4 = (int)(l2 % 10L);
            arrby[--n3] = c[n4];
            l2 /= 10L;
        }
        if (bl) {
            arrby[n3 - 1] = 45;
        }
        o2.c = n2 + o2.c;
        this.b += (long)n2;
        return this;
    }

    @Override
    public /* synthetic */ d h(int n2) throws IOException {
        return this.b(n2);
    }

    @Override
    public InputStream h() {
        return new InputStream(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public int available() {
                return (int)Math.min((long)this.a.b, (long)Integer.MAX_VALUE);
            }

            public void close() {
            }

            public int read() {
                if (this.a.b > 0L) {
                    return 255 & this.a.j();
                }
                return -1;
            }

            public int read(byte[] arrby, int n2, int n3) {
                return this.a.a(arrby, n2, n3);
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this.a);
                stringBuilder.append(".inputStream()");
                return stringBuilder.toString();
            }
        };
    }

    public int hashCode() {
        o o2 = this.a;
        if (o2 == null) {
            return 0;
        }
        int n2 = 1;
        do {
            int n3 = o2.c;
            for (int i2 = o2.b; i2 < n3; ++i2) {
                n2 = n2 * 31 + o2.a[i2];
            }
        } while ((o2 = o2.f) != this.a);
        return n2;
    }

    public long i() {
        long l2 = this.b;
        if (l2 == 0L) {
            return 0L;
        }
        o o2 = this.a.g;
        if (o2.c < 2048 && o2.e) {
            l2 -= (long)(o2.c - o2.b);
        }
        return l2;
    }

    public c i(long l2) {
        if (l2 == 0L) {
            return this.b(48);
        }
        int n2 = 1 + Long.numberOfTrailingZeros((long)Long.highestOneBit((long)l2)) / 4;
        o o2 = this.e(n2);
        byte[] arrby = o2.a;
        int n3 = o2.c;
        for (int i2 = -1 + (n2 + o2.c); i2 >= n3; --i2) {
            arrby[i2] = c[(int)(15L & l2)];
            l2 >>>= 4;
        }
        o2.c = n2 + o2.c;
        this.b += (long)n2;
        return this;
    }

    @Override
    public byte j() {
        if (this.b != 0L) {
            o o2 = this.a;
            int n2 = o2.b;
            int n3 = o2.c;
            byte[] arrby = o2.a;
            int n4 = n2 + 1;
            byte by = arrby[n2];
            --this.b;
            if (n4 == n3) {
                this.a = o2.a();
                p.a(o2);
                return by;
            }
            o2.b = n4;
            return by;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override
    public /* synthetic */ d j(long l2) throws IOException {
        return this.i(l2);
    }

    @Override
    public /* synthetic */ d k(long l2) throws IOException {
        return this.h(l2);
    }

    @Override
    public short k() {
        if (this.b >= 2L) {
            o o2 = this.a;
            int n2 = o2.c;
            int n3 = o2.b;
            if (n2 - n3 < 2) {
                return (short)((255 & this.j()) << 8 | 255 & this.j());
            }
            byte[] arrby = o2.a;
            int n4 = n3 + 1;
            int n5 = (255 & arrby[n3]) << 8;
            int n6 = n4 + 1;
            int n7 = n5 | 255 & arrby[n4];
            this.b -= 2L;
            if (n6 == n2) {
                this.a = o2.a();
                p.a(o2);
            } else {
                o2.b = n6;
            }
            return (short)n7;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 2: ");
        stringBuilder.append(this.b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public int l() {
        if (this.b >= 4L) {
            o o2 = this.a;
            int n2 = o2.c;
            int n3 = o2.b;
            if (n2 - n3 < 4) {
                return (255 & this.j()) << 24 | (255 & this.j()) << 16 | (255 & this.j()) << 8 | 255 & this.j();
            }
            byte[] arrby = o2.a;
            int n4 = n3 + 1;
            int n5 = (255 & arrby[n3]) << 24;
            int n6 = n4 + 1;
            int n7 = n5 | (255 & arrby[n4]) << 16;
            int n8 = n6 + 1;
            int n9 = n7 | (255 & arrby[n6]) << 8;
            int n10 = n8 + 1;
            int n11 = n9 | 255 & arrby[n8];
            this.b -= 4L;
            if (n10 == n2) {
                this.a = o2.a();
                p.a(o2);
                return n11;
            }
            o2.b = n10;
            return n11;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 4: ");
        stringBuilder.append(this.b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public short m() {
        return t.a(this.k());
    }

    @Override
    public int n() {
        return t.a(this.l());
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public long o() {
        if (this.b == 0L) {
            throw new IllegalStateException("size == 0");
        }
        int n2 = 0;
        long l2 = 0L;
        boolean bl = false;
        do {
            int n3;
            o o2 = this.a;
            byte[] arrby = o2.a;
            int n4 = o2.c;
            for (n3 = o2.b; n3 < n4; ++n3, ++n2) {
                byte by;
                block13 : {
                    int n5;
                    block10 : {
                        int n6;
                        block12 : {
                            block11 : {
                                block9 : {
                                    by = arrby[n3];
                                    if (by < 48 || by > 57) break block9;
                                    n5 = by - 48;
                                    break block10;
                                }
                                if (by < 97 || by > 102) break block11;
                                n6 = by - 97;
                                break block12;
                            }
                            if (by < 65 || by > 70) break block13;
                            n6 = by - 65;
                        }
                        n5 = n6 + 10;
                    }
                    if ((-1152921504606846976L & l2) != 0L) {
                        c c2 = new c().i(l2).b(by);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Number too large: ");
                        stringBuilder.append(c2.q());
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                    l2 = l2 << 4 | (long)n5;
                    continue;
                }
                if (n2 == 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected leading [0-9a-fA-F] character but was 0x");
                    stringBuilder.append(Integer.toHexString((int)by));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                bl = true;
                break;
            }
            if (n3 == n4) {
                this.a = o2.a();
                p.a(o2);
                continue;
            }
            o2.b = n3;
        } while (!bl && this.a != null);
        this.b -= (long)n2;
        return l2;
    }

    public f p() {
        return new f(this.s());
    }

    public String q() {
        try {
            String string = this.a(this.b, t.a);
            return string;
        }
        catch (EOFException eOFException) {
            throw new AssertionError((Object)eOFException);
        }
    }

    @Override
    public String r() throws EOFException {
        long l2 = this.a((byte)10);
        if (l2 != -1L) {
            return this.e(l2);
        }
        c c2 = new c();
        this.a(c2, 0L, Math.min((long)32L, (long)this.b));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\n not found: size=");
        stringBuilder.append(this.b());
        stringBuilder.append(" content=");
        stringBuilder.append(c2.p().d());
        stringBuilder.append("...");
        throw new EOFException(stringBuilder.toString());
    }

    public byte[] s() {
        try {
            byte[] arrby = this.f(this.b);
            return arrby;
        }
        catch (EOFException eOFException) {
            throw new AssertionError((Object)eOFException);
        }
    }

    public c t() {
        o o2;
        c c2 = new c();
        if (this.b == 0L) {
            return c2;
        }
        o o3 = c2.a = new o(this.a);
        o o4 = c2.a;
        o4.g = o2 = c2.a;
        o3.f = o2;
        o o5 = this.a;
        while ((o5 = o5.f) != this.a) {
            c2.a.g.a(new o(o5));
        }
        c2.b = this.b;
        return c2;
    }

    public String toString() {
        if (this.b == 0L) {
            return "Buffer[size=0]";
        }
        if (this.b <= 16L) {
            f f2 = this.t().p();
            Object[] arrobject = new Object[]{this.b, f2.d()};
            return String.format((String)"Buffer[size=%s data=%s]", (Object[])arrobject);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
            messageDigest.update(this.a.a, this.a.b, this.a.c - this.a.b);
            o o2 = this.a;
            while ((o2 = o2.f) != this.a) {
                messageDigest.update(o2.a, o2.b, o2.c - o2.b);
            }
            Object[] arrobject = new Object[]{this.b, f.a(messageDigest.digest()).d()};
            String string = String.format((String)"Buffer[size=%s md5=%s]", (Object[])arrobject);
            return string;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new AssertionError();
        }
    }

    @Override
    public /* synthetic */ d u() throws IOException {
        return this.e();
    }
}

