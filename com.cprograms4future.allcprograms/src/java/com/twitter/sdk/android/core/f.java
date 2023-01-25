/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  java.lang.Object
 *  java.util.List
 */
package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

public class f {
    public static boolean a(Context context, Intent intent) {
        return true ^ context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public static boolean b(Context context, Intent intent) {
        if (f.a(context, intent)) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }
}

