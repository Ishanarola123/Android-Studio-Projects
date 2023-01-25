/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tencent.mm.opensdk.diffdev.a.a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return DiffDevOAuthFactory.getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int n2) {
        StringBuilder stringBuilder = new StringBuilder("getDiffDevOAuth, version = ");
        stringBuilder.append(n2);
        Log.v(TAG, stringBuilder.toString());
        if (n2 > 1) {
            StringBuilder stringBuilder2 = new StringBuilder("getDiffDevOAuth fail, unsupported version = ");
            stringBuilder2.append(n2);
            Log.e(TAG, stringBuilder2.toString());
            return null;
        }
        if (n2 != 1) {
            return null;
        }
        if (v1Instance == null) {
            v1Instance = new a();
        }
        return v1Instance;
    }
}

