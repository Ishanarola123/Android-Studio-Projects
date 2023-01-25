/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.TreeSet
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package a.a.a.a.a.d;

import a.a.a.a.a.b.i;
import a.a.a.a.a.b.j;
import a.a.a.a.a.d.c;
import a.a.a.a.a.d.g;
import a.a.a.a.a.d.h;
import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class d<T> {
    protected final Context a;
    protected final c<T> b;
    protected final j c;
    protected final g d;
    protected volatile long e;
    protected final List<h> f = new CopyOnWriteArrayList();
    private final int g;

    public d(Context context, c<T> c2, j j2, g g2, int n2) throws IOException {
        this.a = context.getApplicationContext();
        this.b = c2;
        this.d = g2;
        this.c = j2;
        this.e = this.c.a();
        this.g = n2;
    }

    private void a(int n2) throws IOException {
        if (!this.d.a(n2, this.d())) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.d.a(), n2, this.d()};
            String string = String.format((Locale)locale, (String)"session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", (Object[])arrobject);
            i.a(this.a, 4, "Fabric", string);
            this.b();
        }
    }

    private void b(String string) {
        for (h h2 : this.f) {
            try {
                h2.a(string);
            }
            catch (Exception exception) {
                i.a(this.a, "One of the roll over listeners threw an exception", exception);
            }
        }
    }

    public long a(String string) {
        String[] arrstring = string.split("_");
        if (arrstring.length != 3) {
            return 0L;
        }
        try {
            long l2 = Long.valueOf((String)arrstring[2]);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            return 0L;
        }
    }

    protected abstract String a();

    public void a(h h2) {
        if (h2 != null) {
            this.f.add((Object)h2);
        }
    }

    public void a(T t2) throws IOException {
        byte[] arrby = this.b.a(t2);
        this.a(arrby.length);
        this.d.a(arrby);
    }

    public void a(List<File> list) {
        this.d.a(list);
    }

    public boolean b() throws IOException {
        String string;
        boolean bl = this.d.b();
        int n2 = 1;
        if (!bl) {
            string = this.a();
            this.d.a(string);
            Context context = this.a;
            Locale locale = Locale.US;
            Object[] arrobject = new Object[n2];
            arrobject[0] = string;
            i.a(context, 4, "Fabric", String.format((Locale)locale, (String)"generated new file %s", (Object[])arrobject));
            this.e = this.c.a();
        } else {
            string = null;
            n2 = 0;
        }
        this.b(string);
        return (boolean)n2;
    }

    protected int c() {
        return this.g;
    }

    protected int d() {
        return 8000;
    }

    public List<File> e() {
        return this.d.a(1);
    }

    public void f() {
        List<File> list = this.d.c();
        int n2 = this.c();
        if (list.size() <= n2) {
            return;
        }
        int n3 = list.size() - n2;
        Context context = this.a;
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{list.size(), n2, n3};
        i.a(context, String.format((Locale)locale, (String)"Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", (Object[])arrobject));
        TreeSet treeSet = new TreeSet((Comparator)new Comparator<a>(){

            public int a(a a2, a a3) {
                return (int)(a2.b - a3.b);
            }

            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((a)object, (a)object2);
            }
        });
        for (File file : list) {
            treeSet.add((Object)new a(file, this.a(file.getName())));
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((a)iterator.next()).a);
            if (arrayList.size() != n3) continue;
        }
        this.d.a((List<File>)arrayList);
    }

    static class a {
        final File a;
        final long b;

        public a(File file, long l2) {
            this.a = file;
            this.b = l2;
        }
    }

}

