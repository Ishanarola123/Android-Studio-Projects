/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.Void
 *  java.lang.reflect.Type
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
package com.google.a.b;

import com.google.a.b.a;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class i {
    private static final Map<Class<?>, Class<?>> a;
    private static final Map<Class<?>, Class<?>> b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        i.a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        i.a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        i.a(hashMap, hashMap2, Character.TYPE, Character.class);
        i.a(hashMap, hashMap2, Double.TYPE, Double.class);
        i.a(hashMap, hashMap2, Float.TYPE, Float.class);
        i.a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        i.a(hashMap, hashMap2, Long.TYPE, Long.class);
        i.a(hashMap, hashMap2, Short.TYPE, Short.class);
        i.a(hashMap, hashMap2, Void.TYPE, Void.class);
        a = Collections.unmodifiableMap((Map)hashMap);
        b = Collections.unmodifiableMap((Map)hashMap2);
    }

    public static <T> Class<T> a(Class<T> class_) {
        Class class_2 = (Class)a.get(a.a(class_));
        if (class_2 == null) {
            return class_;
        }
        return class_2;
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> class_, Class<?> class_2) {
        map.put(class_, class_2);
        map2.put(class_2, class_);
    }

    public static boolean a(Type type) {
        return a.containsKey((Object)type);
    }
}

