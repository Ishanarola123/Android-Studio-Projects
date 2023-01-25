/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.os.IBinder
 *  com.xiaomi.scanner.app.RemoteService$ServiceStub
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.lang.String
 */
package com.xiaomi.scanner.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.xiaomi.scanner.app.RemoteService;
import com.xiaomi.scanner.debug.Log;

/*
 * Exception performing whole class analysis.
 */
public class RemoteService
extends Service {
    private static final Log.Tag TAG;
    private IBinder mBinder;

    static {
        TAG = new Log.Tag("RemoteService");
    }

    public RemoteService() {
        this.mBinder = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ Log.Tag access$000() {
        return TAG;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}

