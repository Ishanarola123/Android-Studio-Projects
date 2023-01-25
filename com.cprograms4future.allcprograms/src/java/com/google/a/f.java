/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.b.a.a
 *  com.google.a.b.a.b
 *  com.google.a.b.a.c
 *  com.google.a.b.a.d
 *  com.google.a.b.a.e
 *  com.google.a.b.a.f
 *  com.google.a.b.a.g
 *  com.google.a.b.a.h
 *  com.google.a.b.a.i
 *  com.google.a.b.a.j
 *  com.google.a.b.a.k
 *  com.google.a.b.d
 *  com.google.a.d
 *  com.google.a.f$1
 *  com.google.a.f$2
 *  com.google.a.f$3
 *  com.google.a.f$4
 *  com.google.a.f$5
 *  com.google.a.f$6
 *  com.google.a.f$7
 *  com.google.a.f$a
 *  com.google.a.m
 *  com.google.a.n
 *  com.google.a.t
 *  com.google.a.u
 *  com.google.a.w
 *  com.google.a.x
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Appendable
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.concurrent.atomic.AtomicLongArray
 */
package com.google.a;

import com.google.a.b.a.g;
import com.google.a.b.a.k;
import com.google.a.b.d;
import com.google.a.b.i;
import com.google.a.b.j;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.e;
import com.google.a.f;
import com.google.a.h;
import com.google.a.l;
import com.google.a.m;
import com.google.a.n;
import com.google.a.r;
import com.google.a.t;
import com.google.a.u;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/*
 * Exception performing whole class analysis.
 */
public final class f {
    final com.google.a.j a;
    final r b;
    private final ThreadLocal<Map<com.google.a.c.a<?>, a<?>>> c;
    private final Map<com.google.a.c.a<?>, w<?>> d;
    private final List<x> e;
    private final com.google.a.b.c f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;

    public f() {
        this(d.a, (e)com.google.a.d.a, Collections.emptyMap(), false, false, false, true, false, false, false, u.a, (List<x>)Collections.emptyList());
    }

    f(d d2, e e2, Map<Type, h<?>> map, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, u u2, List<x> list) {
        this.c = new ThreadLocal();
        this.d = Collections.synchronizedMap((Map)new HashMap());
        this.a = new 1(this);
        this.b = new 2(this);
        this.f = new com.google.a.b.c(map);
        this.g = bl;
        this.i = bl3;
        this.h = bl4;
        this.j = bl5;
        this.k = bl6;
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)com.google.a.b.a.m.Y);
        arrayList.add((Object)com.google.a.b.a.h.a);
        arrayList.add((Object)d2);
        arrayList.addAll(list);
        arrayList.add((Object)com.google.a.b.a.m.D);
        arrayList.add((Object)com.google.a.b.a.m.m);
        arrayList.add((Object)com.google.a.b.a.m.g);
        arrayList.add((Object)com.google.a.b.a.m.i);
        arrayList.add((Object)com.google.a.b.a.m.k);
        w<Number> w2 = f.a(u2);
        arrayList.add((Object)com.google.a.b.a.m.a(Long.TYPE, Long.class, w2));
        arrayList.add((Object)com.google.a.b.a.m.a(Double.TYPE, Double.class, this.a(bl7)));
        arrayList.add((Object)com.google.a.b.a.m.a(Float.TYPE, Float.class, this.b(bl7)));
        arrayList.add((Object)com.google.a.b.a.m.x);
        arrayList.add((Object)com.google.a.b.a.m.o);
        arrayList.add((Object)com.google.a.b.a.m.q);
        arrayList.add((Object)com.google.a.b.a.m.a(AtomicLong.class, f.a(w2)));
        arrayList.add((Object)com.google.a.b.a.m.a(AtomicLongArray.class, f.b(w2)));
        arrayList.add((Object)com.google.a.b.a.m.s);
        arrayList.add((Object)com.google.a.b.a.m.z);
        arrayList.add((Object)com.google.a.b.a.m.F);
        arrayList.add((Object)com.google.a.b.a.m.H);
        arrayList.add((Object)com.google.a.b.a.m.a(BigDecimal.class, com.google.a.b.a.m.B));
        arrayList.add((Object)com.google.a.b.a.m.a(BigInteger.class, com.google.a.b.a.m.C));
        arrayList.add((Object)com.google.a.b.a.m.J);
        arrayList.add((Object)com.google.a.b.a.m.L);
        arrayList.add((Object)com.google.a.b.a.m.P);
        arrayList.add((Object)com.google.a.b.a.m.R);
        arrayList.add((Object)com.google.a.b.a.m.W);
        arrayList.add((Object)com.google.a.b.a.m.N);
        arrayList.add((Object)com.google.a.b.a.m.d);
        arrayList.add((Object)com.google.a.b.a.c.a);
        arrayList.add((Object)com.google.a.b.a.m.U);
        arrayList.add((Object)k.a);
        arrayList.add((Object)com.google.a.b.a.j.a);
        arrayList.add((Object)com.google.a.b.a.m.S);
        arrayList.add((Object)com.google.a.b.a.a.a);
        arrayList.add((Object)com.google.a.b.a.m.b);
        arrayList.add((Object)new com.google.a.b.a.b(this.f));
        arrayList.add((Object)new g(this.f, bl2));
        arrayList.add((Object)new com.google.a.b.a.d(this.f));
        arrayList.add((Object)com.google.a.b.a.m.Z);
        arrayList.add((Object)new com.google.a.b.a.i(this.f, e2, d2));
        this.e = Collections.unmodifiableList((List)arrayList);
    }

    private static w<Number> a(u u2) {
        if (u2 == u.a) {
            return com.google.a.b.a.m.t;
        }
        return new 5();
    }

    private static w<AtomicLong> a(w<Number> w2) {
        return new 6(w2).a();
    }

    private w<Number> a(boolean bl) {
        if (bl) {
            return com.google.a.b.a.m.v;
        }
        return new 3(this);
    }

    static void a(double d2) {
        if (!Double.isNaN((double)d2) && !Double.isInfinite((double)d2)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d2);
        stringBuilder.append(" is not a valid double value as per JSON specification. To override this");
        stringBuilder.append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static void a(Object object, com.google.a.d.a a2) {
        if (object != null) {
            try {
                if (a2.f() == b.j) {
                    return;
                }
                throw new m("JSON document was not fully consumed.");
            }
            catch (IOException iOException) {
                throw new m((Throwable)iOException);
            }
            catch (com.google.a.d.d d2) {
                throw new t((Throwable)((Object)d2));
            }
        }
    }

    private static w<AtomicLongArray> b(w<Number> w2) {
        return new 7(w2).a();
    }

    private w<Number> b(boolean bl) {
        if (bl) {
            return com.google.a.b.a.m.u;
        }
        return new 4(this);
    }

    public com.google.a.d.a a(Reader reader) {
        com.google.a.d.a a2 = new com.google.a.d.a(reader);
        a2.a(this.k);
        return a2;
    }

    public c a(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        c c2 = new c(writer);
        if (this.j) {
            c2.c("  ");
        }
        c2.d(this.g);
        return c2;
    }

    public l a(Object object) {
        if (object == null) {
            return n.a;
        }
        return this.a(object, (Type)object.getClass());
    }

    public l a(Object object, Type type) {
        com.google.a.b.a.f f2 = new com.google.a.b.a.f();
        this.a(object, type, (c)f2);
        return f2.a();
    }

    public <T> w<T> a(com.google.a.c.a<T> a2) {
        a a3;
        w w2 = (w)this.d.get(a2);
        if (w2 != null) {
            return w2;
        }
        Map map = (Map)this.c.get();
        boolean bl = false;
        if (map == null) {
            map = new HashMap();
            this.c.set((Object)map);
            bl = true;
        }
        if ((a3 = map.get(a2)) != null) {
            return a3;
        }
        try {
            a a4 = new /* Unavailable Anonymous Inner Class!! */;
            map.put(a2, (Object)a4);
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                w w3 = ((x)iterator.next()).a(this, a2);
                if (w3 == null) continue;
                a4.a(w3);
                this.d.put(a2, (Object)w3);
                return w3;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GSON cannot handle ");
            stringBuilder.append(a2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        finally {
            map.remove(a2);
            if (bl) {
                this.c.remove();
            }
        }
    }

    public <T> w<T> a(x x2, com.google.a.c.a<T> a2) {
        boolean bl = true ^ this.e.contains((Object)x2);
        for (x x3 : this.e) {
            if (!bl) {
                if (x3 != x2) continue;
                bl = true;
                continue;
            }
            w w2 = x3.a(this, a2);
            if (w2 == null) continue;
            return w2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GSON cannot serialize ");
        stringBuilder.append(a2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public <T> w<T> a(Class<T> class_) {
        return this.a(com.google.a.c.a.b(class_));
    }

    /*
     * Exception decompiling
     */
    public <T> T a(com.google.a.d.a var1_1, Type var2_2) throws m, t {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public <T> T a(l l2, Class<T> class_) throws t {
        T t2 = this.a(l2, (Type)class_);
        return (T)i.a(class_).cast(t2);
    }

    public <T> T a(l l2, Type type) throws t {
        if (l2 == null) {
            return null;
        }
        return this.a((com.google.a.d.a)new com.google.a.b.a.e(l2), type);
    }

    public <T> T a(Reader reader, Type type) throws m, t {
        com.google.a.d.a a2 = this.a(reader);
        T t2 = this.a(a2, type);
        f.a(t2, a2);
        return t2;
    }

    public <T> T a(String string, Class<T> class_) throws t {
        T t2 = this.a(string, (Type)class_);
        return (T)i.a(class_).cast(t2);
    }

    public <T> T a(String string, Type type) throws t {
        if (string == null) {
            return null;
        }
        return this.a((Reader)new StringReader(string), type);
    }

    public String a(l l2) {
        StringWriter stringWriter = new StringWriter();
        this.a(l2, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(l l2, c c2) throws m {
        Throwable throwable2222;
        boolean bl = c2.g();
        c2.b(true);
        boolean bl2 = c2.h();
        c2.c(this.h);
        boolean bl3 = c2.i();
        c2.d(this.g);
        j.a(l2, c2);
        c2.b(bl);
        c2.c(bl2);
        c2.d(bl3);
        return;
        {
            catch (Throwable throwable2222) {
            }
            catch (IOException iOException) {}
            {
                throw new m((Throwable)iOException);
            }
        }
        c2.b(bl);
        c2.c(bl2);
        c2.d(bl3);
        throw throwable2222;
    }

    public void a(l l2, Appendable appendable) throws m {
        try {
            this.a(l2, this.a(j.a(appendable)));
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(Object object, Type type, c c2) throws m {
        Throwable throwable2222;
        w<?> w2 = this.a(com.google.a.c.a.a(type));
        boolean bl = c2.g();
        c2.b(true);
        boolean bl2 = c2.h();
        c2.c(this.h);
        boolean bl3 = c2.i();
        c2.d(this.g);
        w2.a(c2, object);
        c2.b(bl);
        c2.c(bl2);
        c2.d(bl3);
        return;
        {
            catch (Throwable throwable2222) {
            }
            catch (IOException iOException) {}
            {
                throw new m((Throwable)iOException);
            }
        }
        c2.b(bl);
        c2.c(bl2);
        c2.d(bl3);
        throw throwable2222;
    }

    public void a(Object object, Type type, Appendable appendable) throws m {
        try {
            this.a(object, type, this.a(j.a(appendable)));
            return;
        }
        catch (IOException iOException) {
            throw new m((Throwable)iOException);
        }
    }

    public String b(Object object) {
        if (object == null) {
            return this.a((l)n.a);
        }
        return this.b(object, (Type)object.getClass());
    }

    public String b(Object object, Type type) {
        StringWriter stringWriter = new StringWriter();
        this.a(object, type, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{serializeNulls:");
        stringBuilder.append(this.g);
        stringBuilder.append("factories:");
        stringBuilder.append(this.e);
        stringBuilder.append(",instanceCreators:");
        stringBuilder.append((Object)this.f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

