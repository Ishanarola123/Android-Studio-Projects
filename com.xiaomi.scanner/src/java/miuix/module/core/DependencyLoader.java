/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 */
package miuix.module.core;

import android.util.ArrayMap;
import android.util.Log;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class DependencyLoader
extends ClassLoader {
    private static final String TAG = "DependencyLoader";
    private Map<String, ClassLoader> mDependencies = new ArrayMap();
    private Map<String, Class<?>> mDependencyClasses = new ArrayMap();
    private Set<String> mIgnoredClasses = new HashSet();

    public DependencyLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    /* varargs */ void add(ClassLoader classLoader, String ... arrstring) {
        for (String string2 : arrstring) {
            this.mDependencies.put((Object)string2, (Object)classLoader);
        }
    }

    void ignore(String string2) {
        this.mIgnoredClasses.add((Object)string2);
    }

    protected Class<?> loadClass(String string2, boolean bl) throws ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loading class: ");
        stringBuilder.append(string2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        Class class_ = (Class)this.mDependencyClasses.get((Object)string2);
        if (class_ != null) {
            return class_;
        }
        ClassLoader classLoader = (ClassLoader)this.mDependencies.get((Object)string2);
        if (classLoader != null) {
            return classLoader.loadClass(string2);
        }
        if (this.mIgnoredClasses.contains((Object)string2)) {
            return null;
        }
        return super.loadClass(string2, bl);
    }

    /* varargs */ void preload(Class<?> ... arrclass) {
        for (Class<?> class_ : arrclass) {
            this.mDependencyClasses.put((Object)class_.getCanonicalName(), class_);
        }
    }
}

