/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a
 *  d.a$e
 *  d.h
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Executor
 */
package d;

import b.aa;
import b.ac;
import b.e;
import b.s;
import b.w;
import d.a;
import d.b;
import d.c;
import d.e;
import d.h;
import d.j;
import d.n;
import d.o;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public final class m {
    private final Map<Method, n> a = new LinkedHashMap();
    private final e.a b;
    private final s c;
    private final List<e.a> d;
    private final List<c.a> e;
    private final Executor f;
    private final boolean g;

    m(e.a a2, s s2, List<e.a> list, List<c.a> list2, Executor executor, boolean bl) {
        this.b = a2;
        this.c = s2;
        this.d = Collections.unmodifiableList(list);
        this.e = Collections.unmodifiableList(list2);
        this.f = executor;
        this.g = bl;
    }

    private void b(Class<?> class_) {
        j j2 = j.a();
        for (Method method : class_.getDeclaredMethods()) {
            if (j2.a(method)) continue;
            this.a(method);
        }
    }

    public e.a a() {
        return this.b;
    }

    public c<?> a(c.a a2, Type type, Annotation[] arrannotation) {
        o.a(type, "returnType == null");
        o.a(arrannotation, "annotations == null");
        int n2 = 1 + this.e.indexOf((Object)a2);
        int n3 = this.e.size();
        for (int i2 = n2; i2 < n3; ++i2) {
            c<?> c2 = ((c.a)this.e.get(i2)).a(type, arrannotation, this);
            if (c2 == null) continue;
            return c2;
        }
        StringBuilder stringBuilder = new StringBuilder("Could not locate call adapter for ");
        stringBuilder.append((Object)type);
        stringBuilder.append(".\n");
        if (a2 != null) {
            stringBuilder.append("  Skipped:");
            for (int i3 = 0; i3 < n2; ++i3) {
                stringBuilder.append("\n   * ");
                stringBuilder.append(((c.a)this.e.get(i3)).getClass().getName());
            }
            stringBuilder.append('\n');
        }
        stringBuilder.append("  Tried:");
        int n4 = this.e.size();
        while (n2 < n4) {
            stringBuilder.append("\n   * ");
            stringBuilder.append(((c.a)this.e.get(n2)).getClass().getName());
            ++n2;
        }
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public c<?> a(Type type, Annotation[] arrannotation) {
        return this.a((c.a)null, type, arrannotation);
    }

    public <T> e<ac, T> a(e.a a2, Type type, Annotation[] arrannotation) {
        o.a(type, "type == null");
        o.a(arrannotation, "annotations == null");
        int n2 = 1 + this.d.indexOf((Object)a2);
        int n3 = this.d.size();
        for (int i2 = n2; i2 < n3; ++i2) {
            e<ac, ?> e2 = ((e.a)this.d.get(i2)).a(type, arrannotation, this);
            if (e2 == null) continue;
            return e2;
        }
        StringBuilder stringBuilder = new StringBuilder("Could not locate ResponseBody converter for ");
        stringBuilder.append((Object)type);
        stringBuilder.append(".\n");
        if (a2 != null) {
            stringBuilder.append("  Skipped:");
            for (int i3 = 0; i3 < n2; ++i3) {
                stringBuilder.append("\n   * ");
                stringBuilder.append(((e.a)this.d.get(i3)).getClass().getName());
            }
            stringBuilder.append('\n');
        }
        stringBuilder.append("  Tried:");
        int n4 = this.d.size();
        while (n2 < n4) {
            stringBuilder.append("\n   * ");
            stringBuilder.append(((e.a)this.d.get(n2)).getClass().getName());
            ++n2;
        }
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public <T> e<T, aa> a(e.a a2, Type type, Annotation[] arrannotation, Annotation[] arrannotation2) {
        o.a(type, "type == null");
        o.a(arrannotation, "parameterAnnotations == null");
        o.a(arrannotation2, "methodAnnotations == null");
        int n2 = 1 + this.d.indexOf((Object)a2);
        int n3 = this.d.size();
        for (int i2 = n2; i2 < n3; ++i2) {
            e<?, aa> e2 = ((e.a)this.d.get(i2)).a(type, arrannotation, arrannotation2, this);
            if (e2 == null) continue;
            return e2;
        }
        StringBuilder stringBuilder = new StringBuilder("Could not locate RequestBody converter for ");
        stringBuilder.append((Object)type);
        stringBuilder.append(".\n");
        if (a2 != null) {
            stringBuilder.append("  Skipped:");
            for (int i3 = 0; i3 < n2; ++i3) {
                stringBuilder.append("\n   * ");
                stringBuilder.append(((e.a)this.d.get(i3)).getClass().getName());
            }
            stringBuilder.append('\n');
        }
        stringBuilder.append("  Tried:");
        int n4 = this.d.size();
        while (n2 < n4) {
            stringBuilder.append("\n   * ");
            stringBuilder.append(((e.a)this.d.get(n2)).getClass().getName());
            ++n2;
        }
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public <T> e<T, aa> a(Type type, Annotation[] arrannotation, Annotation[] arrannotation2) {
        return this.a(null, type, arrannotation, arrannotation2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    n a(Method method) {
        Map<Method, n> map;
        Map<Method, n> map2 = map = this.a;
        synchronized (map2) {
            n n2 = (n)this.a.get((Object)method);
            if (n2 == null) {
                n2 = new n.a(this, method).a();
                this.a.put((Object)method, (Object)n2);
            }
            return n2;
        }
    }

    public <T> T a(final Class<T> class_) {
        o.a(class_);
        if (this.g) {
            this.b(class_);
        }
        return (T)Proxy.newProxyInstance((ClassLoader)class_.getClassLoader(), (Class[])new Class[]{class_}, (InvocationHandler)new InvocationHandler(){
            private final j c = j.a();

            public /* varargs */ Object invoke(Object object, Method method, Object ... arrobject) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke((Object)this, arrobject);
                }
                if (this.c.a(method)) {
                    return this.c.a(method, class_, object, arrobject);
                }
                n n2 = m.this.a(method);
                h h2 = new h(n2, arrobject);
                return n2.d.a(h2);
            }
        });
    }

    public s b() {
        return this.c;
    }

    public <T> e<ac, T> b(Type type, Annotation[] arrannotation) {
        return this.a((e.a)null, type, arrannotation);
    }

    public <T> e<T, String> c(Type type, Annotation[] arrannotation) {
        o.a(type, "type == null");
        o.a(arrannotation, "annotations == null");
        int n2 = this.d.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            e<?, String> e2 = ((e.a)this.d.get(i2)).b(type, arrannotation, this);
            if (e2 == null) continue;
            return e2;
        }
        return a.e.a;
    }

    public static final class a {
        private j a;
        private e.a b;
        private s c;
        private List<e.a> d = new ArrayList();
        private List<c.a> e = new ArrayList();
        private Executor f;
        private boolean g;

        public a() {
            this(j.a());
        }

        a(j j2) {
            this.a = j2;
            this.d.add((Object)new d.a());
        }

        public a a(e.a a2) {
            this.b = o.a(a2, "factory == null");
            return this;
        }

        public a a(s s2) {
            o.a(s2, "baseUrl == null");
            List<String> list = s2.j();
            if ("".equals(list.get(-1 + list.size()))) {
                this.c = s2;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("baseUrl must end in /: ");
            stringBuilder.append((Object)s2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public a a(w w2) {
            return this.a((e.a)o.a(w2, "client == null"));
        }

        public a a(e.a a2) {
            this.d.add((Object)o.a(a2, "factory == null"));
            return this;
        }

        public a a(String string) {
            o.a(string, "baseUrl == null");
            s s2 = s.e(string);
            if (s2 != null) {
                return this.a(s2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal URL: ");
            stringBuilder.append(string);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public m a() {
            if (this.c != null) {
                e.a a2 = this.b;
                if (a2 == null) {
                    a2 = new w();
                }
                e.a a3 = a2;
                Executor executor = this.f;
                if (executor == null) {
                    executor = this.a.b();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.e);
                arrayList.add((Object)this.a.a(executor2));
                ArrayList arrayList2 = new ArrayList(this.d);
                m m2 = new m(a3, this.c, (List<e.a>)arrayList2, (List<c.a>)arrayList, executor2, this.g);
                return m2;
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

}

