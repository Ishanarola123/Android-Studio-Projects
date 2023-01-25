/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Process
 *  android.widget.ImageView
 *  com.a.a.b
 *  com.a.a.f
 *  com.a.a.g
 *  com.a.a.k
 *  com.a.a.m
 *  com.a.a.o
 *  com.a.a.r
 *  com.a.a.t$f$1
 *  com.a.a.z
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.lang.ref.ReferenceQueue
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 *  java.util.WeakHashMap
 *  java.util.concurrent.ExecutorService
 */
package com.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.a.a.a;
import com.a.a.aa;
import com.a.a.ac;
import com.a.a.ag;
import com.a.a.g;
import com.a.a.h;
import com.a.a.i;
import com.a.a.j;
import com.a.a.k;
import com.a.a.m;
import com.a.a.o;
import com.a.a.p;
import com.a.a.r;
import com.a.a.t;
import com.a.a.v;
import com.a.a.w;
import com.a.a.x;
import com.a.a.y;
import com.a.a.z;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class t {
    static final Handler a = new Handler(Looper.getMainLooper()){

        /*
         * Enabled aggressive block sorting
         */
        public void handleMessage(Message message) {
            int n2 = message.what;
            if (n2 != 3) {
                int n3;
                if (n2 != 8) {
                    if (n2 != 13) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown handler message received: ");
                        stringBuilder.append(message.what);
                        throw new AssertionError((Object)stringBuilder.toString());
                    }
                    List list = (List)message.obj;
                    int n4 = list.size();
                    for (n3 = 0; n3 < n4; ++n3) {
                        com.a.a.a a2 = (com.a.a.a)list.get(n3);
                        a2.a.c(a2);
                    }
                    return;
                } else {
                    List list = (List)message.obj;
                    int n5 = list.size();
                    while (n3 < n5) {
                        com.a.a.c c2 = (com.a.a.c)list.get(n3);
                        c2.b.a(c2);
                        ++n3;
                    }
                }
                return;
            } else {
                com.a.a.a a3 = (com.a.a.a)message.obj;
                if (a3.j().l) {
                    ag.a("Main", "canceled", a3.b.a(), "target got garbage collected");
                }
                a3.a.a(a3.d());
            }
        }
    };
    static volatile t b = null;
    final Context c;
    final i d;
    final com.a.a.d e;
    final aa f;
    final Map<Object, com.a.a.a> g;
    final Map<ImageView, h> h;
    final ReferenceQueue<Object> i;
    final Bitmap.Config j;
    boolean k;
    volatile boolean l;
    boolean m;
    private final c n;
    private final f o;
    private final b p;
    private final List<y> q;

    t(Context context, i i2, com.a.a.d d2, c c2, f f2, List<y> list, aa aa2, Bitmap.Config config, boolean bl, boolean bl2) {
        this.c = context;
        this.d = i2;
        this.e = d2;
        this.n = c2;
        this.o = f2;
        this.j = config;
        int n2 = list != null ? list.size() : 0;
        ArrayList arrayList = new ArrayList(n2 + 7);
        arrayList.add((Object)new z(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add((Object)new com.a.a.f(context));
        arrayList.add((Object)new o(context));
        arrayList.add((Object)new g(context));
        arrayList.add((Object)new com.a.a.b(context));
        arrayList.add((Object)new k(context));
        arrayList.add((Object)new r(i2.d, aa2));
        this.q = Collections.unmodifiableList((List)arrayList);
        this.f = aa2;
        this.g = new WeakHashMap();
        this.h = new WeakHashMap();
        this.k = bl;
        this.l = bl2;
        this.i = new ReferenceQueue();
        this.p = new b(this.i, a);
        this.p.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static t a(Context context) {
        if (b != null) return b;
        Class<t> class_ = t.class;
        synchronized (t.class) {
            if (b != null) return b;
            b = new a(context).a();
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return b;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(Bitmap bitmap, d d2, com.a.a.a a2) {
        if (a2.f()) {
            return;
        }
        if (!a2.g()) {
            this.g.remove(a2.d());
        }
        if (bitmap != null) {
            if (d2 == null) throw new AssertionError((Object)"LoadedFrom cannot be null.");
            a2.a(bitmap, d2);
            if (!this.l) return;
            String string = a2.b.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("from ");
            stringBuilder.append((Object)d2);
            ag.a("Main", "completed", string, stringBuilder.toString());
            return;
        }
        a2.a();
        if (!this.l) return;
        ag.a("Main", "errored", a2.b.a());
    }

    private void a(Object object) {
        ImageView imageView;
        h h2;
        ag.a();
        com.a.a.a a2 = (com.a.a.a)this.g.remove(object);
        if (a2 != null) {
            a2.b();
            this.d.b(a2);
        }
        if (object instanceof ImageView && (h2 = (h)this.h.remove((Object)(imageView = (ImageView)object))) != null) {
            h2.a();
        }
    }

    w a(w w2) {
        w w3 = this.o.a(w2);
        if (w3 != null) {
            return w3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request transformer ");
        stringBuilder.append(this.o.getClass().getCanonicalName());
        stringBuilder.append(" returned null for ");
        stringBuilder.append((Object)w2);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public x a(Uri uri) {
        return new x(this, uri, 0);
    }

    public x a(String string) {
        if (string == null) {
            return new x(this, null, 0);
        }
        if (string.trim().length() != 0) {
            return this.a(Uri.parse((String)string));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    List<y> a() {
        return this.q;
    }

    public void a(ImageView imageView) {
        this.a((Object)imageView);
    }

    void a(ImageView imageView, h h2) {
        this.h.put((Object)imageView, (Object)h2);
    }

    void a(com.a.a.a a2) {
        Object t2 = a2.d();
        if (t2 != null && this.g.get(t2) != a2) {
            this.a(t2);
            this.g.put(t2, (Object)a2);
        }
        this.b(a2);
    }

    public void a(ac ac2) {
        this.a((Object)ac2);
    }

    void a(com.a.a.c c2) {
        com.a.a.a a2 = c2.i();
        List<com.a.a.a> list = c2.k();
        boolean bl = true;
        int n2 = 0;
        boolean bl2 = list != null && !list.isEmpty();
        if (a2 == null && !bl2) {
            bl = false;
        }
        if (!bl) {
            return;
        }
        Uri uri = c2.h().d;
        Exception exception = c2.l();
        Bitmap bitmap = c2.e();
        d d2 = c2.m();
        if (a2 != null) {
            this.a(bitmap, d2, a2);
        }
        if (bl2) {
            int n3 = list.size();
            while (n2 < n3) {
                this.a(bitmap, d2, (com.a.a.a)list.get(n2));
                ++n2;
            }
        }
        if (this.n != null && exception != null) {
            this.n.a(this, uri, exception);
        }
    }

    Bitmap b(String string) {
        Bitmap bitmap = this.e.a(string);
        if (bitmap != null) {
            this.f.a();
            return bitmap;
        }
        this.f.b();
        return bitmap;
    }

    void b(com.a.a.a a2) {
        this.d.a(a2);
    }

    void c(com.a.a.a a2) {
        Bitmap bitmap = p.a(a2.e) ? this.b(a2.e()) : null;
        if (bitmap != null) {
            this.a(bitmap, d.a, a2);
            if (this.l) {
                String string = a2.b.a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("from ");
                stringBuilder.append((Object)d.a);
                ag.a("Main", "completed", string, stringBuilder.toString());
                return;
            }
        } else {
            this.a(a2);
            if (this.l) {
                ag.a("Main", "resumed", a2.b.a());
            }
        }
    }

    public static class a {
        private final Context a;
        private j b;
        private ExecutorService c;
        private com.a.a.d d;
        private c e;
        private f f;
        private List<y> g;
        private Bitmap.Config h;
        private boolean i;
        private boolean j;

        public a(Context context) {
            if (context != null) {
                this.a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public t a() {
            Context context = this.a;
            if (this.b == null) {
                this.b = ag.a(context);
            }
            if (this.d == null) {
                this.d = new m(context);
            }
            if (this.c == null) {
                this.c = new v();
            }
            if (this.f == null) {
                this.f = f.a;
            }
            aa aa2 = new aa(this.d);
            i i2 = new i(context, this.c, t.a, this.b, this.d, aa2);
            t t2 = new t(context, i2, this.d, this.e, this.f, this.g, aa2, this.h, this.i, this.j);
            return t2;
        }
    }

    private static class b
    extends Thread {
        private final ReferenceQueue<Object> a;
        private final Handler b;

        b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.a = referenceQueue;
            this.b = handler;
            this.setDaemon(true);
            this.setName("Picasso-refQueue");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void run() {
            Process.setThreadPriority((int)10);
            try {
                do {
                    a.a a2 = (a.a)this.a.remove(1000L);
                    Message message = this.b.obtainMessage();
                    if (a2 != null) {
                        message.what = 3;
                        message.obj = a2.a;
                        this.b.sendMessage(message);
                        continue;
                    }
                    message.recycle();
                } while (true);
            }
            catch (Exception exception) {
                this.b.post(new Runnable(){

                    public void run() {
                        throw new RuntimeException((Throwable)exception);
                    }
                });
                return;
            }
            catch (InterruptedException interruptedException) {}
        }

    }

    public static interface c {
        public void a(t var1, Uri var2, Exception var3);
    }

    public static final class d
    extends Enum<d> {
        public static final /* enum */ d a = new d(-16711936);
        public static final /* enum */ d b = new d(-16776961);
        public static final /* enum */ d c = new d(-65536);
        private static final /* synthetic */ d[] e;
        final int d;

        static {
            d[] arrd = new d[]{a, b, c};
            e = arrd;
        }

        private d(int n3) {
            this.d = n3;
        }

        public static d valueOf(String string) {
            return (d)Enum.valueOf(d.class, (String)string);
        }

        public static d[] values() {
            return (d[])e.clone();
        }
    }

    public static final class e
    extends Enum<e> {
        public static final /* enum */ e a = new e();
        public static final /* enum */ e b = new e();
        public static final /* enum */ e c = new e();
        private static final /* synthetic */ e[] d;

        static {
            e[] arre = new e[]{a, b, c};
            d = arre;
        }

        public static e valueOf(String string) {
            return (e)Enum.valueOf(e.class, (String)string);
        }

        public static e[] values() {
            return (e[])d.clone();
        }
    }

    public static interface f {
        public static final f a = new 1();

        public w a(w var1);
    }

}

