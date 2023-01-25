/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.b.o$1
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  java.nio.channels.WritableByteChannel
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package a.a.a.a.a.b;

import a.a.a.a.a.b.o;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class o
implements Closeable {
    private static final Logger b = Logger.getLogger((String)o.class.getName());
    int a;
    private final RandomAccessFile c;
    private int d;
    private a e;
    private a f;
    private final byte[] g = new byte[16];

    public o(File file) throws IOException {
        if (!file.exists()) {
            o.a(file);
        }
        this.c = o.b(file);
        this.c();
    }

    private static int a(byte[] arrby, int n2) {
        return ((255 & arrby[n2]) << 24) + ((255 & arrby[n2 + 1]) << 16) + ((255 & arrby[n2 + 2]) << 8) + (255 & arrby[n2 + 3]);
    }

    private a a(int n2) throws IOException {
        if (n2 == 0) {
            return a.a;
        }
        this.c.seek((long)n2);
        return new a(n2, this.c.readInt());
    }

    private void a(int n2, int n3, int n4, int n5) throws IOException {
        o.a(this.g, n2, n3, n4, n5);
        this.c.seek(0L);
        this.c.write(this.g);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(int n2, byte[] arrby, int n3, int n4) throws IOException {
        RandomAccessFile randomAccessFile;
        int n5 = this.b(n2);
        if (n5 + n4 <= this.a) {
            this.c.seek((long)n5);
            randomAccessFile = this.c;
        } else {
            int n6 = this.a - n5;
            this.c.seek((long)n5);
            this.c.write(arrby, n3, n6);
            this.c.seek(16L);
            randomAccessFile = this.c;
            n3 += n6;
            n4 -= n6;
        }
        randomAccessFile.write(arrby, n3, n4);
    }

    private static void a(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        block3 : {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getPath());
            stringBuilder.append(".tmp");
            File file2 = new File(stringBuilder.toString());
            randomAccessFile = o.b(file2);
            randomAccessFile.setLength(4096L);
            randomAccessFile.seek(0L);
            byte[] arrby = new byte[16];
            o.a(arrby, 4096, 0, 0, 0);
            randomAccessFile.write(arrby);
            if (!file2.renameTo(file)) break block3;
            return;
        }
        throw new IOException("Rename failed!");
        finally {
            randomAccessFile.close();
        }
    }

    private static /* varargs */ void a(byte[] arrby, int ... arrn) {
        int n2 = arrn.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            o.b(arrby, n3, arrn[i2]);
            n3 += 4;
        }
    }

    private int b(int n2) {
        if (n2 < this.a) {
            return n2;
        }
        return n2 + 16 - this.a;
    }

    private static RandomAccessFile b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private static <T> T b(T t2, String string) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(string);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(int n2, byte[] arrby, int n3, int n4) throws IOException {
        RandomAccessFile randomAccessFile;
        int n5 = this.b(n2);
        if (n5 + n4 <= this.a) {
            this.c.seek((long)n5);
            randomAccessFile = this.c;
        } else {
            int n6 = this.a - n5;
            this.c.seek((long)n5);
            this.c.readFully(arrby, n3, n6);
            this.c.seek(16L);
            randomAccessFile = this.c;
            n3 += n6;
            n4 -= n6;
        }
        randomAccessFile.readFully(arrby, n3, n4);
    }

    private static void b(byte[] arrby, int n2, int n3) {
        arrby[n2] = (byte)(n3 >> 24);
        arrby[n2 + 1] = (byte)(n3 >> 16);
        arrby[n2 + 2] = (byte)(n3 >> 8);
        arrby[n2 + 3] = (byte)n3;
    }

    private void c() throws IOException {
        this.c.seek(0L);
        this.c.readFully(this.g);
        this.a = o.a(this.g, 0);
        if ((long)this.a <= this.c.length()) {
            this.d = o.a(this.g, 4);
            int n2 = o.a(this.g, 8);
            int n3 = o.a(this.g, 12);
            this.e = this.a(n2);
            this.f = this.a(n3);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File is truncated. Expected length: ");
        stringBuilder.append(this.a);
        stringBuilder.append(", Actual length: ");
        stringBuilder.append(this.c.length());
        throw new IOException(stringBuilder.toString());
    }

    private void c(int n2) throws IOException {
        int n3 = n2 + 4;
        int n4 = this.d();
        if (n4 >= n3) {
            return;
        }
        int n5 = this.a;
        while ((n4 += (n5 <<= 1)) < n3) {
        }
        this.d(n5);
        int n6 = this.b(4 + this.f.b + this.f.c);
        if (n6 < this.e.b) {
            FileChannel fileChannel = this.c.getChannel();
            fileChannel.position((long)this.a);
            long l2 = n6 - 4;
            if (fileChannel.transferTo(16L, l2, (WritableByteChannel)fileChannel) != l2) {
                throw new AssertionError((Object)"Copied insufficient number of bytes!");
            }
        }
        if (this.f.b < this.e.b) {
            int n7 = -16 + (this.a + this.f.b);
            this.a(n5, this.d, this.e.b, n7);
            this.f = new a(n7, this.f.c);
        } else {
            this.a(n5, this.d, this.e.b, this.f.b);
        }
        this.a = n5;
    }

    private int d() {
        return this.a - this.a();
    }

    private void d(int n2) throws IOException {
        this.c.setLength((long)n2);
        this.c.getChannel().force(true);
    }

    public int a() {
        if (this.d == 0) {
            return 16;
        }
        if (this.f.b >= this.e.b) {
            return 16 + (4 + (this.f.b - this.e.b) + this.f.c);
        }
        return 4 + this.f.b + this.f.c + this.a - this.e.b;
    }

    public void a(c c2) throws IOException {
        o o2 = this;
        synchronized (o2) {
            int n2 = this.e.b;
            int n3 = 0;
            do {
                if (n3 >= this.d) break;
                a a2 = this.a(n2);
                c2.a(new b(a2), a2.c);
                n2 = this.b(4 + a2.b + a2.c);
                ++n3;
            } while (true);
            return;
        }
    }

    public void a(byte[] arrby) throws IOException {
        this.a(arrby, 0, arrby.length);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(byte[] arrby, int n2, int n3) throws IOException {
        o o2 = this;
        synchronized (o2) {
            o.b(arrby, "buffer");
            if ((n2 | n3) >= 0 && n3 <= arrby.length - n2) {
                this.c(n3);
                boolean bl = this.b();
                int n4 = bl ? 16 : this.b(4 + this.f.b + this.f.c);
                a a2 = new a(n4, n3);
                o.b(this.g, 0, n3);
                this.a(a2.b, this.g, 0, 4);
                this.a(4 + a2.b, arrby, n2, n3);
                int n5 = bl ? a2.b : this.e.b;
                this.a(this.a, 1 + this.d, n5, a2.b);
                this.f = a2;
                this.d = 1 + this.d;
                if (bl) {
                    this.e = this.f;
                }
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean a(int n2, int n3) {
        return n2 + (4 + this.a()) <= n3;
    }

    public boolean b() {
        o o2 = this;
        synchronized (o2) {
            int n2 = this.d;
            boolean bl = n2 == 0;
            return bl;
        }
    }

    public void clear() throws IOException {
        o o2 = this;
        synchronized (o2) {
            this.a(4096, 0, 0, 0);
            this.d = 0;
            this.e = a.a;
            this.f = a.a;
            if (this.a > 4096) {
                this.d(4096);
            }
            this.a = 4096;
            return;
        }
    }

    public void close() throws IOException {
        o o2 = this;
        synchronized (o2) {
            this.c.close();
            return;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append('[');
        stringBuilder.append("fileLength=");
        stringBuilder.append(this.a);
        stringBuilder.append(", size=");
        stringBuilder.append(this.d);
        stringBuilder.append(", first=");
        stringBuilder.append((Object)this.e);
        stringBuilder.append(", last=");
        stringBuilder.append((Object)this.f);
        stringBuilder.append(", element lengths=[");
        try {
            this.a((c)new 1(this, stringBuilder));
        }
        catch (IOException iOException) {
            b.log(Level.WARNING, "read error", (Throwable)iOException);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    static class a {
        static final a a = new a(0, 0);
        final int b;
        final int c;

        a(int n2, int n3) {
            this.b = n2;
            this.c = n3;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getSimpleName());
            stringBuilder.append("[");
            stringBuilder.append("position = ");
            stringBuilder.append(this.b);
            stringBuilder.append(", length = ");
            stringBuilder.append(this.c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private final class b
    extends InputStream {
        private int b;
        private int c;

        private b(a a2) {
            this.b = o.this.b(4 + a2.b);
            this.c = a2.c;
        }

        public int read() throws IOException {
            if (this.c == 0) {
                return -1;
            }
            o.this.c.seek((long)this.b);
            int n2 = o.this.c.read();
            this.b = o.this.b(1 + this.b);
            this.c = -1 + this.c;
            return n2;
        }

        public int read(byte[] arrby, int n2, int n3) throws IOException {
            o.b((Object)arrby, "buffer");
            if ((n2 | n3) >= 0 && n3 <= arrby.length - n2) {
                if (this.c > 0) {
                    if (n3 > this.c) {
                        n3 = this.c;
                    }
                    o.this.b(this.b, arrby, n2, n3);
                    this.b = o.this.b(n3 + this.b);
                    this.c -= n3;
                    return n3;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static interface c {
        public void a(InputStream var1, int var2) throws IOException;
    }

}

