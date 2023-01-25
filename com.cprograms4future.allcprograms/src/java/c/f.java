/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.Comparable
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Field
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Arrays
 */
package c;

import c.b;
import c.c;
import c.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class f
implements Serializable,
Comparable<f> {
    static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final f b = f.a(new byte[0]);
    final byte[] c;
    transient int d;
    transient String e;

    f(byte[] arrby) {
        this.c = arrby;
    }

    public static f a(InputStream inputStream, int n2) throws IOException {
        if (inputStream != null) {
            if (n2 >= 0) {
                int n3;
                byte[] arrby = new byte[n2];
                for (int i2 = 0; i2 < n2; i2 += n3) {
                    n3 = inputStream.read(arrby, i2, n2 - i2);
                    if (n3 != -1) {
                        continue;
                    }
                    throw new EOFException();
                }
                return new f(arrby);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("in == null");
    }

    public static f a(String string) {
        if (string != null) {
            f f2 = new f(string.getBytes(t.a));
            f2.e = string;
            return f2;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static /* varargs */ f a(byte ... arrby) {
        if (arrby != null) {
            return new f((byte[])arrby.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private f b(String string) {
        try {
            f f2 = f.a(MessageDigest.getInstance((String)string).digest(this.c));
            return f2;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new AssertionError((Object)noSuchAlgorithmException);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        f f2 = f.a((InputStream)objectInputStream, objectInputStream.readInt());
        try {
            Field field = f.class.getDeclaredField("c");
            field.setAccessible(true);
            field.set((Object)this, (Object)f2.c);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError();
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }

    public byte a(int n2) {
        return this.c[n2];
    }

    public int a(f f2) {
        int n2 = this.f();
        int n3 = f2.f();
        int n4 = Math.min((int)n2, (int)n3);
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5;
            int n6 = 255 & this.a(i2);
            if (n6 == (n5 = 255 & f2.a(i2))) {
                continue;
            }
            if (n6 < n5) {
                return -1;
            }
            return 1;
        }
        if (n2 == n3) {
            return 0;
        }
        if (n2 < n3) {
            return -1;
        }
        return 1;
    }

    public String a() {
        String string;
        String string2 = this.e;
        if (string2 != null) {
            return string2;
        }
        this.e = string = new String(this.c, t.a);
        return string;
    }

    void a(c c2) {
        c2.b(this.c, 0, this.c.length);
    }

    public boolean a(int n2, byte[] arrby, int n3, int n4) {
        return n2 <= this.c.length - n4 && n3 <= arrby.length - n4 && t.a(this.c, n2, arrby, n3, n4);
    }

    public String b() {
        return b.a(this.c);
    }

    public f c() {
        return this.b("MD5");
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((f)object);
    }

    public String d() {
        char[] arrc = new char[2 * this.c.length];
        byte[] arrby = this.c;
        int n2 = arrby.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = arrby[i2];
            int n4 = n3 + 1;
            arrc[n3] = a[15 & by >> 4];
            n3 = n4 + 1;
            arrc[n4] = a[by & 15];
        }
        return new String(arrc);
    }

    public f e() {
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            byte by = this.c[i2];
            if (by < 65 || by > 90) continue;
            byte[] arrby = (byte[])this.c.clone();
            arrby[i2] = (byte)(by + 32);
            for (int i3 = i2 + 1; i3 < arrby.length; ++i3) {
                byte by2 = arrby[i3];
                if (by2 < 65 || by2 > 90) continue;
                arrby[i3] = (byte)(by2 + 32);
            }
            return new f(arrby);
        }
        return this;
    }

    public boolean equals(Object object) {
        f f2;
        if (object == this) {
            return true;
        }
        return object instanceof f && (f2 = (f)object).f() == this.c.length && f2.a(0, this.c, 0, this.c.length);
    }

    public int f() {
        return this.c.length;
    }

    public byte[] g() {
        return (byte[])this.c.clone();
    }

    public int hashCode() {
        int n2;
        int n3 = this.d;
        if (n3 != 0) {
            return n3;
        }
        this.d = n2 = Arrays.hashCode((byte[])this.c);
        return n2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String toString() {
        String string;
        Object[] arrobject;
        if (this.c.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.c.length <= 16) {
            string = "ByteString[size=%s data=%s]";
            arrobject = new Object[]{this.c.length, this.d()};
            do {
                return String.format((String)string, (Object[])arrobject);
                break;
            } while (true);
        }
        string = "ByteString[size=%s md5=%s]";
        arrobject = new Object[]{this.c.length, this.c().d()};
        return String.format((String)string, (Object[])arrobject);
    }
}

