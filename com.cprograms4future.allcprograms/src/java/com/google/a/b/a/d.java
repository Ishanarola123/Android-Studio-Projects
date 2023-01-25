/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 */
package com.google.a.b.a;

import com.google.a.a.b;
import com.google.a.b.c;
import com.google.a.b.h;
import com.google.a.c.a;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.lang.annotation.Annotation;

public final class d
implements x {
    private final c a;

    public d(c c2) {
        this.a = c2;
    }

    static w<?> a(c c2, f f2, a<?> a2, b b2) {
        block4 : {
            w<?> w2;
            block3 : {
                Class<?> class_;
                block2 : {
                    class_ = b2.a();
                    if (!w.class.isAssignableFrom(class_)) break block2;
                    w2 = (w<?>)c2.a(a.b(class_)).a();
                    break block3;
                }
                if (!x.class.isAssignableFrom(class_)) break block4;
                w2 = ((x)c2.a(a.b(class_)).a()).a(f2, a2);
            }
            return w2.a();
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    @Override
    public <T> w<T> a(f f2, a<T> a2) {
        b b2 = (b)a2.a().getAnnotation(b.class);
        if (b2 == null) {
            return null;
        }
        return d.a(this.a, f2, a2, b2);
    }
}

