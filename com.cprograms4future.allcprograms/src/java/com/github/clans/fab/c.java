/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  java.lang.Math
 *  java.lang.Object
 */
package com.github.clans.fab;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

final class c {
    static int a(Context context, float f2) {
        return Math.round((float)(f2 * context.getResources().getDisplayMetrics().density));
    }

    static boolean a() {
        return Build.VERSION.SDK_INT >= 16;
    }

    static boolean b() {
        return Build.VERSION.SDK_INT >= 21;
    }
}

