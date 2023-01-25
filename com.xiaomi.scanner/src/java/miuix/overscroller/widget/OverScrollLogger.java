/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package miuix.overscroller.widget;

import android.util.Log;
import java.util.Locale;

class OverScrollLogger {
    private static final boolean DEBUG = false;
    private static final String TAG = "OverScroll";
    private static final boolean VERBOSE;

    static {
        DEBUG = Log.isLoggable((String)TAG, (int)3);
        VERBOSE = Log.isLoggable((String)TAG, (int)2);
    }

    OverScrollLogger() {
    }

    public static void debug(String string2) {
        if (DEBUG) {
            Log.d((String)TAG, (String)string2);
        }
    }

    public static /* varargs */ void debug(String string2, Object ... arrobject) {
        if (DEBUG) {
            Log.d((String)TAG, (String)String.format((Locale)Locale.US, (String)string2, (Object[])arrobject));
        }
    }

    public static void verbose(String string2) {
        if (VERBOSE) {
            Log.v((String)TAG, (String)string2);
        }
    }

    public static /* varargs */ void verbose(String string2, Object ... arrobject) {
        if (VERBOSE) {
            Log.v((String)TAG, (String)String.format((Locale)Locale.US, (String)string2, (Object[])arrobject));
        }
    }
}

