/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.onetrack.h.i;

public class a {
    private static Context a;
    private static Context b;
    private static int c;
    private static String d;
    private static String e;
    private static long f;
    private static volatile boolean g;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Context a() {
        if (!i.d(a)) {
            return a;
        }
        Context context = b;
        if (context != null) {
            return context;
        }
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (b == null) {
                b = i.a(a);
            }
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return b;
        }
    }

    public static PackageInfo a(Context context, String string2, int n2) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(string2, n2);
            return packageInfo;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context) {
        if (g) {
            return;
        }
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (g) {
                // ** MonitorExit[var4_1] (shouldn't be in output)
                return;
            }
            a = context;
            try {
                PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
                c = packageInfo.versionCode;
                d = packageInfo.versionName;
                f = packageInfo.lastUpdateTime;
                e = a.getPackageName();
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                nameNotFoundException.printStackTrace();
            }
            g = true;
            // ** MonitorExit[var4_1] (shouldn't be in output)
            return;
        }
    }

    public static boolean a(Context context, String string2) {
        try {
            boolean bl = a.a(a.a((Context)context, (String)string2, (int)0).applicationInfo);
            return bl;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        return (1 & applicationInfo.flags) != 0;
    }

    public static String b() {
        return d;
    }

    public static boolean b(Context context, String string2) {
        PackageInfo packageInfo = a.a(context, string2, 0);
        boolean bl = false;
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            bl = false;
            if (applicationInfo != null) {
                bl = true;
            }
        }
        return bl;
    }

    public static int c() {
        return c;
    }

    public static String c(Context context, String string2) {
        PackageManager packageManager = context.getPackageManager();
        try {
            String string3 = packageManager.getApplicationInfo(string2, 0).loadLabel(packageManager).toString();
            return string3;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return "";
        }
    }

    public static String d() {
        return e;
    }

    public static long e() {
        return f;
    }
}

