/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.provider.Settings
 *  android.provider.Settings$Global
 *  java.lang.Object
 *  java.lang.String
 *  miuix.core.util.SystemProperties
 */
package miuix.internal.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.Settings;
import miuix.core.util.SystemProperties;

public class DeviceHelper {
    public static final boolean IS_DEBUGGABLE;

    static {
        int n = SystemProperties.getInt((String)"ro.debuggable", (int)0);
        boolean bl = false;
        if (n == 1) {
            bl = true;
        }
        IS_DEBUGGABLE = bl;
    }

    public static boolean isFeatureWholeAnim() {
        return true;
    }

    public static boolean isHideGestureLine(Context context) {
        int n = Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)"hide_gesture_line", (int)0);
        boolean bl = false;
        if (n != 0) {
            bl = true;
        }
        return bl;
    }

    public static boolean isOled() {
        return false;
    }

    public static boolean isTablet() {
        return Resources.getSystem().getConfiguration().smallestScreenWidthDp >= 600;
    }
}

