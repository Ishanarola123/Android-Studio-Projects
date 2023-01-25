/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.b.c$1
 *  com.google.a.b.c$10
 *  com.google.a.b.c$11
 *  com.google.a.b.c$12
 *  com.google.a.b.c$13
 *  com.google.a.b.c$14
 *  com.google.a.b.c$2
 *  com.google.a.b.c$3
 *  com.google.a.b.c$4
 *  com.google.a.b.c$5
 *  com.google.a.b.c$6
 *  com.google.a.b.c$7
 *  com.google.a.b.c$8
 *  com.google.a.b.c$9
 *  java.lang.Class
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.Map
 *  java.util.Queue
 *  java.util.Set
 *  java.util.SortedMap
 *  java.util.SortedSet
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.ConcurrentNavigableMap
 */
package com.google.a.b;

import com.google.a.b.c;
import com.google.a.b.h;
import com.google.a.c.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

public final class c {
    private final Map<Type, com.google.a.h<?>> a;

    public c(Map<Type, com.google.a.h<?>> map) {
        this.a = map;
    }

    private <T> h<T> a(Class<? super T> class_) {
        try {
            Constructor constructor = class_.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            8 var3_3 = new 8(this, constructor);
            return var3_3;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    private <T> h<T> a(Type type, Class<? super T> class_) {
        if (Collection.class.isAssignableFrom(class_)) {
            if (SortedSet.class.isAssignableFrom(class_)) {
                return new 9(this);
            }
            if (EnumSet.class.isAssignableFrom(class_)) {
                return new 10(this, type);
            }
            if (Set.class.isAssignableFrom(class_)) {
                return new 11(this);
            }
            if (Queue.class.isAssignableFrom(class_)) {
                return new 12(this);
            }
            return new 13(this);
        }
        if (Map.class.isAssignableFrom(class_)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(class_)) {
                return new 14(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(class_)) {
                return new 2(this);
            }
            if (SortedMap.class.isAssignableFrom(class_)) {
                return new 3(this);
            }
            if (type instanceof ParameterizedType && !String.class.isAssignableFrom(a.a(((ParameterizedType)type).getActualTypeArguments()[0]).a())) {
                return new 4(this);
            }
            return new 5(this);
        }
        return null;
    }

    private <T> h<T> b(Type type, Class<? super T> class_) {
        return new 6(this, class_, type);
    }

    public <T> h<T> a(a<T> a2) {
        Type type = a2.b();
        Class<T> class_ = a2.a();
        com.google.a.h h2 = (com.google.a.h)this.a.get((Object)type);
        if (h2 != null) {
            return new 1(this, h2, type);
        }
        com.google.a.h h3 = (com.google.a.h)this.a.get(class_);
        if (h3 != null) {
            return new 7(this, h3, type);
        }
        h<T> h4 = this.a(class_);
        if (h4 != null) {
            return h4;
        }
        h<T> h5 = this.a(type, class_);
        if (h5 != null) {
            return h5;
        }
        return this.b(type, class_);
    }

    public String toString() {
        return this.a.toString();
    }
}

