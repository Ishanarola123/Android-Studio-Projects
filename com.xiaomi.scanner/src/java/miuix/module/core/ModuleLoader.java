/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package miuix.module.core;

import android.content.Context;
import android.content.pm.PackageManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import miuix.module.core.ContextHelper;
import miuix.module.core.DependencyLoader;

public class ModuleLoader {
    private Context mBaseContext;
    private ClassLoader mClassLoader;
    private Map<Class<?>, String> mClasses;
    private Context mModuleContext;

    private ModuleLoader(Context context, Map<Class<?>, String> map, Context context2, String[] arrstring) {
        this.mBaseContext = context;
        this.mModuleContext = context2;
        this.mClasses = map;
        DependencyLoader dependencyLoader = new DependencyLoader(context.getClassLoader());
        dependencyLoader.add(context2.getClassLoader(), arrstring);
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            dependencyLoader.ignore((String)((Map.Entry)iterator.next()).getValue());
        }
        this.mClassLoader = ContextHelper.cloneClassLoader(context, dependencyLoader);
    }

    public Context getBaseContext() {
        return this.mBaseContext;
    }

    public ClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Context getModuleContext() {
        return this.mModuleContext;
    }

    public <I> I instantiate(Class<I> class_) {
        return this.instantiate(class_, new Class[0], new Object[0]);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <I> I instantiate(Class<I> class_, Class<?>[] arrclass, Object[] arrobject) {
        void var4_11;
        try {
            String string2 = (String)this.mClasses.get(class_);
            if (string2 != null) {
                return (I)this.mClassLoader.loadClass(string2).asSubclass(class_).getConstructor(arrclass).newInstance(arrobject);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("no implementation for ");
            stringBuilder.append(class_);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException((Throwable)var4_11);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException((Throwable)var4_11);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException((Throwable)var4_11);
        }
        catch (InstantiationException instantiationException) {
            throw new RuntimeException((Throwable)var4_11);
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        throw new RuntimeException((Throwable)var4_11);
    }

    public static class Builder {
        private Context mBaseContext;
        private Map<Class<?>, String> mClasses = new HashMap();
        private Set<String> mDependencies = new HashSet();
        private Context mModuleContext;
        private String mPackageName;

        public Builder(Context context, Context context2) {
            this.mBaseContext = context;
            this.mModuleContext = context2;
        }

        public Builder(Context context, String string2) {
            this.mBaseContext = context;
            this.mPackageName = string2;
        }

        public ModuleLoader build() {
            Context context = this.mModuleContext;
            if (context == null) {
                try {
                    context = this.mBaseContext.createPackageContext(this.mPackageName, 3);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    throw new RuntimeException((Throwable)nameNotFoundException);
                }
            }
            Context context2 = context;
            ModuleLoader moduleLoader = new ModuleLoader(this.mBaseContext, this.mClasses, context2, (String[])this.mDependencies.toArray((Object[])new String[0]));
            return moduleLoader;
        }

        public Builder register(Class<?> class_, String string2) {
            this.mClasses.put(class_, (Object)string2);
            return this;
        }

        public Builder require(String string2) {
            this.mDependencies.add((Object)string2);
            return this;
        }
    }

}

