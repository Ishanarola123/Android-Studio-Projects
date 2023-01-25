/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 */
package d.a.a;

import b.aa;
import b.ac;
import com.google.a.f;
import com.google.a.w;
import d.a.a.b;
import d.a.a.c;
import d.e;
import d.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public final class a
extends e.a {
    private final f a;

    private a(f f2) {
        if (f2 != null) {
            this.a = f2;
            return;
        }
        throw new NullPointerException("gson == null");
    }

    public static a a() {
        return a.a(new f());
    }

    public static a a(f f2) {
        return new a(f2);
    }

    @Override
    public e<ac, ?> a(Type type, Annotation[] arrannotation, m m2) {
        w<?> w2 = this.a.a(com.google.a.c.a.a(type));
        return new c(this.a, w2);
    }

    @Override
    public e<?, aa> a(Type type, Annotation[] arrannotation, Annotation[] arrannotation2, m m2) {
        w<?> w2 = this.a.a(com.google.a.c.a.a(type));
        return new b(this.a, w2);
    }
}

