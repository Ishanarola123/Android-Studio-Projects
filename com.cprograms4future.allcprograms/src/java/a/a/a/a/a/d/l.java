/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 */
package a.a.a.a.a.d;

import a.a.a.a.a.b.i;
import a.a.a.a.a.b.o;
import a.a.a.a.a.d.g;
import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l
implements g {
    private final Context a;
    private final File b;
    private final String c;
    private final File d;
    private o e;
    private File f;

    public l(Context context, File file, String string, String string2) throws IOException {
        this.a = context;
        this.b = file;
        this.c = string2;
        this.d = new File(this.b, string);
        this.e = new o(this.d);
        this.d();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(File file, File file2) throws IOException {
        OutputStream outputStream;
        Throwable throwable;
        FileInputStream fileInputStream;
        block6 : {
            OutputStream outputStream2;
            outputStream = null;
            fileInputStream = new FileInputStream(file);
            try {
                outputStream2 = this.a(file2);
            }
            catch (Throwable throwable2) {
                outputStream = null;
                break block6;
            }
            try {
                i.a((InputStream)fileInputStream, outputStream2, new byte[1024]);
            }
            catch (Throwable throwable3) {
                outputStream = outputStream2;
                throwable = throwable3;
                break block6;
            }
            i.a((Closeable)fileInputStream, "Failed to close file input stream");
            i.a((Closeable)outputStream2, "Failed to close output stream");
            file.delete();
            return;
            catch (Throwable throwable4) {
                fileInputStream = null;
            }
        }
        i.a((Closeable)fileInputStream, "Failed to close file input stream");
        i.a(outputStream, "Failed to close output stream");
        file.delete();
        throw throwable;
    }

    private void d() {
        this.f = new File(this.b, this.c);
        if (!this.f.exists()) {
            this.f.mkdirs();
        }
    }

    @Override
    public int a() {
        return this.e.a();
    }

    public OutputStream a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    @Override
    public List<File> a(int n2) {
        ArrayList arrayList = new ArrayList();
        File[] arrfile = this.f.listFiles();
        int n3 = arrfile.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            arrayList.add((Object)arrfile[i2]);
            if (arrayList.size() < n2) continue;
            return arrayList;
        }
        return arrayList;
    }

    @Override
    public void a(String string) throws IOException {
        this.e.close();
        this.a(this.d, new File(this.f, string));
        this.e = new o(this.d);
    }

    @Override
    public void a(List<File> list) {
        for (File file : list) {
            Context context = this.a;
            Object[] arrobject = new Object[]{file.getName()};
            i.a(context, String.format((String)"deleting sent analytics file %s", (Object[])arrobject));
            file.delete();
        }
    }

    @Override
    public void a(byte[] arrby) throws IOException {
        this.e.a(arrby);
    }

    @Override
    public boolean a(int n2, int n3) {
        return this.e.a(n2, n3);
    }

    @Override
    public boolean b() {
        return this.e.b();
    }

    @Override
    public List<File> c() {
        return Arrays.asList((Object[])this.f.listFiles());
    }
}

