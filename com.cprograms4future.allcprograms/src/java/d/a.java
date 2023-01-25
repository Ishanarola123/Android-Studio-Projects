/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 */
package d;

import b.aa;
import b.ac;
import d.b.u;
import d.e;
import d.m;
import d.o;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class a
extends e.a {
    a() {
    }

    @Override
    public d.e<ac, ?> a(Type type, Annotation[] arrannotation, m m2) {
        if (type == ac.class) {
            if (o.a(arrannotation, u.class)) {
                return c.a;
            }
            return a.a;
        }
        if (type == Void.class) {
            return f.a;
        }
        return null;
    }

    @Override
    public d.e<?, aa> a(Type type, Annotation[] arrannotation, Annotation[] arrannotation2, m m2) {
        if (aa.class.isAssignableFrom(o.a(type))) {
            return b.a;
        }
        return null;
    }

    @Override
    public d.e<?, String> b(Type type, Annotation[] arrannotation, m m2) {
        if (type == String.class) {
            return d.a;
        }
        return null;
    }

    static final class a
    implements d.e<ac, ac> {
        static final a a = new a();

        a() {
        }

        @Override
        public ac a(ac ac2) throws IOException {
            try {
                ac ac3 = o.a(ac2);
                return ac3;
            }
            finally {
                ac2.close();
            }
        }
    }

    static final class b
    implements d.e<aa, aa> {
        static final b a = new b();

        b() {
        }

        @Override
        public aa a(aa aa2) throws IOException {
            return aa2;
        }
    }

    static final class c
    implements d.e<ac, ac> {
        static final c a = new c();

        c() {
        }

        @Override
        public ac a(ac ac2) throws IOException {
            return ac2;
        }
    }

    static final class d
    implements d.e<String, String> {
        static final d a = new d();

        d() {
        }

        @Override
        public String a(String string) throws IOException {
            return string;
        }
    }

    static final class e
    implements d.e<Object, String> {
        static final e a = new e();

        e() {
        }

        @Override
        public /* synthetic */ Object a(Object object) throws IOException {
            return this.b(object);
        }

        public String b(Object object) {
            return object.toString();
        }
    }

    static final class f
    implements d.e<ac, Void> {
        static final f a = new f();

        f() {
        }

        @Override
        public Void a(ac ac2) throws IOException {
            ac2.close();
            return null;
        }
    }

}

