/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.firebase.iid.FirebaseInstanceId
 *  com.google.firebase.iid.FirebaseInstanceIdService
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.cprograms4future.allcprograms;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceServiceId
extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseInsID";

    public void onTokenRefresh() {
        String string = FirebaseInstanceId.a().d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("New Token : ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
    }
}

