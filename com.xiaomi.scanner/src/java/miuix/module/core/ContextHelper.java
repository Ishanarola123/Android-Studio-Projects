/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  dalvik.system.PathClassLoader
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.ClassLoader
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 */
package miuix.module.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class ContextHelper {
    ContextHelper() {
    }

    static ClassLoader cloneClassLoader(Context context, ClassLoader classLoader) {
        return new PathClassLoader(ContextHelper.getDexPath(context), classLoader);
    }

    private static String getDexPath(Context context) {
        ArrayList arrayList = new ArrayList();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if ((4 & applicationInfo.flags) != 0) {
            arrayList.add((Object)applicationInfo.sourceDir);
        }
        if (Build.VERSION.SDK_INT >= 21 && applicationInfo.splitSourceDirs != null) {
            Collections.addAll((Collection)arrayList, (Object[])applicationInfo.splitSourceDirs);
        }
        if (arrayList.size() == 1) {
            return (String)arrayList.get(0);
        }
        return TextUtils.join((CharSequence)File.pathSeparator, (Iterable)arrayList);
    }
}

