/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentProviderClient
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.h.a.a;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

public class k {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a(Context context) {
        Uri uri = Uri.parse((String)"content://cn.nubia.identity/identity");
        try {
            Bundle bundle;
            int n2 = Build.VERSION.SDK_INT;
            if (n2 > 17) {
                ContentProviderClient contentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                bundle = contentProviderClient.call("getOAID", null, null);
                if (contentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    } else {
                        contentProviderClient.release();
                    }
                }
            } else {
                bundle = context.getContentResolver().call(uri, "getOAID", null, null);
            }
            if (bundle.getInt("code", -1) != 0) return "";
            return bundle.getString("id");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return "";
    }
}

