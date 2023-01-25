/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tencent.mm.opensdk.utils;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

public final class a {
    public static int a(Bundle bundle, String string2) {
        if (bundle == null) {
            return -1;
        }
        try {
            int n2 = bundle.getInt(string2, -1);
            return n2;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("getIntExtra exception:");
            stringBuilder.append(exception.getMessage());
            Log.e("MicroMsg.IntentUtil", stringBuilder.toString());
            return -1;
        }
    }

    public static String b(Bundle bundle, String string2) {
        if (bundle == null) {
            return null;
        }
        try {
            String string3 = bundle.getString(string2);
            return string3;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("getStringExtra exception:");
            stringBuilder.append(exception.getMessage());
            Log.e("MicroMsg.IntentUtil", stringBuilder.toString());
            return null;
        }
    }
}

