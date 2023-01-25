/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.KeyguardManager
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.UserManager
 *  android.os.storage.StorageManager
 *  android.preference.PreferenceManager
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 */
package com.xiaomi.onetrack.h;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.preference.PreferenceManager;
import com.xiaomi.onetrack.h.o;
import java.lang.reflect.Method;

public class i {
    private static final String a = "FbeUtil";

    private i() {
    }

    public static Context a(Context context) {
        if (i.e(context)) {
            o.a(a, "getSafeContext return origin ctx");
            return context;
        }
        o.a(a, "getSafeContext , create the safe ctx");
        return context.createDeviceProtectedStorageContext();
    }

    public static void a(PreferenceManager preferenceManager) {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = true;
        boolean bl2 = n2 == 24 && i.a();
        boolean bl3 = Build.VERSION.SDK_INT == 25 && i.a();
        if (Build.VERSION.SDK_INT <= 25) {
            bl = false;
        }
        if (bl2 || bl3 || bl) {
            preferenceManager.setStorageDeviceProtected();
        }
    }

    public static boolean a() {
        try {
            Class class_ = StorageManager.class.getDeclaredMethod("isFileEncryptedNativeOrEmulated", new Class[0]).invoke(null, new Object[0]).getClass();
            Class[] arrclass = new Class[]{Boolean.TYPE};
            boolean bl = (Boolean)class_.getDeclaredMethod("isFileEncryptedNativeOrEmulated", arrclass).invoke(null, new Object[0]);
            return bl;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("*** ");
            stringBuilder.append((Object)exception);
            o.b(a, stringBuilder.toString());
            return false;
        }
    }

    public static boolean b(Context context) {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n2 >= 24) {
            KeyguardManager keyguardManager = (KeyguardManager)context.getSystemService("keyguard");
            boolean bl2 = i.a();
            bl = false;
            if (bl2) {
                bl = false;
                if (keyguardManager != null) {
                    boolean bl3 = keyguardManager.isKeyguardSecure();
                    bl = false;
                    if (bl3) {
                        bl = true;
                    }
                }
            }
        }
        return bl;
    }

    public static boolean c(Context context) {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n2 >= 24) {
            boolean bl2 = i.b(context);
            bl = false;
            if (bl2) {
                boolean bl3 = i.e(context);
                bl = false;
                if (!bl3) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public static boolean d(Context context) {
        return Build.VERSION.SDK_INT >= 24 && !i.e(context);
        {
        }
    }

    private static boolean e(Context context) {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n2 >= 24) {
            UserManager userManager = (UserManager)context.getSystemService("user");
            bl = false;
            if (userManager != null) {
                boolean bl2 = userManager.isUserUnlocked();
                bl = false;
                if (bl2) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    private static boolean f(Context context) {
        boolean bl;
        block5 : {
            block4 : {
                if (Build.VERSION.SDK_INT != 24 && Build.VERSION.SDK_INT != 25) {
                    return Build.VERSION.SDK_INT <= 25;
                }
                if (context.isDeviceProtectedStorage()) break block4;
                boolean bl2 = i.a();
                bl = false;
                if (bl2) break block5;
            }
            bl = true;
        }
        return bl;
    }
}

