/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  androidx.annotation.NonNull
 */
package com.xiaomi.scanner.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;

public class ScanContextWrapper
extends ContextWrapper {
    public ScanContextWrapper(Context context) {
        super(context);
    }

    @NonNull
    public static ContextWrapper wrap(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = new Configuration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setToDefaults();
        configuration.densityDpi = displayMetrics.densityDpi;
        if (Build.VERSION.SDK_INT > 17) {
            context = context.createConfigurationContext(configuration);
        } else {
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return new ScanContextWrapper(context);
    }
}

