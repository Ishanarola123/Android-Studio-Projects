/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package com.google.a.b;

import com.google.a.a.e;
import com.google.a.b;
import com.google.a.c;
import com.google.a.c.a;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
implements x,
Cloneable {
    public static final d a = new d();
    private double b = -1.0;
    private int c = 136;
    private boolean d = true;
    private boolean e;
    private List<b> f = Collections.emptyList();
    private List<b> g = Collections.emptyList();

    private boolean a(com.google.a.a.d d2) {
        return d2 == null || !(d2.a() > this.b);
    }

    private boolean a(com.google.a.a.d d2, e e2) {
        return this.a(d2) && this.a(e2);
    }

    private boolean a(e e2) {
        return e2 == null || !(e2.a() <= this.b);
    }

    private boolean a(Class<?> class_) {
        return !Enum.class.isAssignableFrom(class_) && (class_.isAnonymousClass() || class_.isLocalClass());
    }

    private boolean b(Class<?> class_) {
        return class_.isMemberClass() && !this.c(class_);
    }

    private boolean c(Class<?> class_) {
        return (8 & class_.getModifiers()) != 0;
    }

    protected d a() {
        try {
            d d2 = (d)super.clone();
            return d2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    @Override
    public <T> w<T> a(final f f2, final a<T> a2) {
        Class<T> class_ = a2.a();
        final boolean bl = this.a(class_, true);
        final boolean bl2 = this.a(class_, false);
        if (!bl && !bl2) {
            return null;
        }
        w w2 = new w<T>(){
            private w<T> f;

            private w<T> b() {
                w<T> w2 = this.f;
                if (w2 != null) {
                    return w2;
                }
                w w3 = f2.a(d.this, a2);
                this.f = w3;
                return w3;
            }

            @Override
            public void a(com.google.a.d.c c2, T t2) throws IOException {
                if (bl) {
                    c2.f();
                    return;
                }
                this.b().a(c2, t2);
            }

            @Override
            public T b(com.google.a.d.a a22) throws IOException {
                if (bl2) {
                    a22.n();
                    return null;
                }
                return this.b().b(a22);
            }
        };
        return w2;
    }

    public boolean a(Class<?> class_, boolean bl) {
        if (this.b != -1.0 && !this.a((com.google.a.a.d)class_.getAnnotation(com.google.a.a.d.class), (e)class_.getAnnotation(e.class))) {
            return true;
        }
        if (!this.d && this.b(class_)) {
            return true;
        }
        if (this.a(class_)) {
            return true;
        }
        List<b> list = bl ? this.f : this.g;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (!((b)iterator.next()).a(class_)) continue;
            return true;
        }
        return false;
    }

    public boolean a(Field field, boolean bl) {
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.b != -1.0 && !this.a((com.google.a.a.d)field.getAnnotation(com.google.a.a.d.class), (e)field.getAnnotation(e.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.e) {
            com.google.a.a.a a2 = (com.google.a.a.a)field.getAnnotation(com.google.a.a.a.class);
            if (a2 != null) {
                if (bl ? !a2.a() : !a2.b()) {
                    return true;
                }
            } else {
                return true;
            }
        }
        if (!this.d && this.b(field.getType())) {
            return true;
        }
        if (this.a(field.getType())) {
            return true;
        }
        List<b> list = bl ? this.f : this.g;
        if (!list.isEmpty()) {
            c c2 = new c(field);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (!((b)iterator.next()).a(c2)) continue;
                return true;
            }
        }
        return false;
    }

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.a();
    }

}

