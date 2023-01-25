/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.lang.reflect.Type
 *  java.util.Collection
 *  java.util.LinkedHashMap
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 */
package com.google.a.b.a;

import com.google.a.b.a.l;
import com.google.a.b.c;
import com.google.a.b.d;
import com.google.a.b.h;
import com.google.a.e;
import com.google.a.f;
import com.google.a.t;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
implements x {
    private final c a;
    private final e b;
    private final d c;

    public i(c c2, e e2, d d2) {
        this.a = c2;
        this.b = e2;
        this.c = d2;
    }

    private b a(final f f2, final Field field, String string, final com.google.a.c.a<?> a2, boolean bl, boolean bl2) {
        final boolean bl3 = com.google.a.b.i.a(a2.a());
        b b2 = new b(string, bl, bl2){
            final w<?> a;
            {
                super(string, bl, bl2);
                this.a = i.this.a(f2, field, a2);
            }

            @Override
            void a(com.google.a.d.a a22, Object object) throws IOException, IllegalAccessException {
                Object obj = this.a.b(a22);
                if (obj != null || !bl3) {
                    field.set(object, obj);
                }
            }

            @Override
            void a(com.google.a.d.c c2, Object object) throws IOException, IllegalAccessException {
                Object object2 = field.get(object);
                ((w)new l(f2, this.a, a2.b())).a(c2, object2);
            }

            @Override
            public boolean a(Object object) throws IOException, IllegalAccessException {
                if (!this.h) {
                    return false;
                }
                Object object2 = field.get(object);
                boolean bl = false;
                if (object2 != object) {
                    bl = true;
                }
                return bl;
            }
        };
        return b2;
    }

    static List<String> a(e e2, Field field) {
        com.google.a.a.c c2 = (com.google.a.a.c)field.getAnnotation(com.google.a.a.c.class);
        LinkedList linkedList = new LinkedList();
        if (c2 == null) {
            linkedList.add((Object)e2.a(field));
            return linkedList;
        }
        linkedList.add((Object)c2.a());
        String[] arrstring = c2.b();
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            linkedList.add((Object)arrstring[i2]);
        }
        return linkedList;
    }

    private List<String> a(Field field) {
        return i.a(this.b, field);
    }

    private Map<String, b> a(f f2, com.google.a.c.a<?> a2, Class<?> class_) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (class_.isInterface()) {
            return linkedHashMap;
        }
        Type type = a2.b();
        com.google.a.c.a<?> a3 = a2;
        Class<?> class_2 = class_;
        while (class_2 != Object.class) {
            for (Field field : class_2.getDeclaredFields()) {
                boolean bl = this.a(field, true);
                boolean bl2 = this.a(field, false);
                if (!bl && !bl2) continue;
                field.setAccessible(true);
                Type type2 = com.google.a.b.b.a(a3.b(), class_2, field.getGenericType());
                List<String> list = this.a(field);
                b b2 = null;
                int n2 = 0;
                while (n2 < list.size()) {
                    String string = (String)list.get(n2);
                    boolean bl3 = n2 != 0 ? false : bl;
                    com.google.a.c.a<?> a4 = com.google.a.c.a.a(type2);
                    Field field2 = field;
                    b b3 = b2;
                    int n3 = n2;
                    List<String> list2 = list;
                    boolean bl4 = bl3;
                    Field field3 = field;
                    b b4 = linkedHashMap.put((Object)string, (Object)this.a(f2, field2, string, a4, bl4, bl2));
                    b2 = b3 == null ? b4 : b3;
                    n2 = n3 + 1;
                    bl = bl3;
                    list = list2;
                    field = field3;
                }
                b b5 = b2;
                if (b5 == null) {
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)type);
                stringBuilder.append(" declares multiple JSON fields named ");
                stringBuilder.append(b5.g);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            a3 = com.google.a.c.a.a(com.google.a.b.b.a(a3.b(), class_2, class_2.getGenericSuperclass()));
            class_2 = a3.a();
        }
        return linkedHashMap;
    }

    static boolean a(Field field, boolean bl, d d2) {
        return !d2.a(field.getType(), bl) && !d2.a(field, bl);
    }

    @Override
    public <T> w<T> a(f f2, com.google.a.c.a<T> a2) {
        Class<T> class_ = a2.a();
        if (!Object.class.isAssignableFrom(class_)) {
            return null;
        }
        return new a<T>(this.a.a(a2), this.a(f2, a2, class_));
    }

    w<?> a(f f2, Field field, com.google.a.c.a<?> a2) {
        w<?> w2;
        com.google.a.a.b b2 = (com.google.a.a.b)field.getAnnotation(com.google.a.a.b.class);
        if (b2 != null && (w2 = com.google.a.b.a.d.a(this.a, f2, a2, b2)) != null) {
            return w2;
        }
        return f2.a(a2);
    }

    public boolean a(Field field, boolean bl) {
        return i.a(field, bl, this.c);
    }

    public static final class a<T>
    extends w<T> {
        private final h<T> a;
        private final Map<String, b> b;

        a(h<T> h2, Map<String, b> map) {
            this.a = h2;
            this.b = map;
        }

        @Override
        public void a(com.google.a.d.c c2, T t2) throws IOException {
            if (t2 == null) {
                c2.f();
                return;
            }
            c2.d();
            try {
                for (b b2 : this.b.values()) {
                    if (!b2.a(t2)) continue;
                    c2.a(b2.g);
                    b2.a(c2, t2);
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError((Object)illegalAccessException);
            }
            c2.e();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public T b(com.google.a.d.a a2) throws IOException {
            if (a2.f() == com.google.a.d.b.i) {
                a2.j();
                return null;
            }
            T t2 = this.a.a();
            try {
                a2.c();
                while (a2.e()) {
                    String string = a2.g();
                    b b2 = this.b.get((Object)string);
                    if (b2 != null && b2.i) {
                        b2.a(a2, t2);
                        continue;
                    }
                    a2.n();
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError((Object)illegalAccessException);
            }
            catch (IllegalStateException illegalStateException) {
                throw new t(illegalStateException);
            }
            a2.d();
            return t2;
        }
    }

}

