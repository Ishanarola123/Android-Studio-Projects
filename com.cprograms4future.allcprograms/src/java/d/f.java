/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 */
package d;

import d.b;
import d.c;
import d.m;
import d.o;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class f
extends c.a {
    static final c.a a = new f();

    f() {
    }

    @Override
    public c<?> a(Type type, Annotation[] arrannotation, m m2) {
        if (f.a(type) != b.class) {
            return null;
        }
        return new c<b<?>>(o.e(type)){
            final /* synthetic */ Type a;
            {
                this.a = type;
            }

            @Override
            public /* synthetic */ Object a(b b2) {
                return this.b(b2);
            }

            @Override
            public Type a() {
                return this.a;
            }

            public <R> b<R> b(b<R> b2) {
                return b2;
            }
        };
    }

}

