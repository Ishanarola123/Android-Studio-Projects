/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  com.xiaomi.scanner.util.AppUtil
 *  com.xiaomi.scanner.util.CameraUtil
 *  com.xiaomi.scanner.util.SPUtils
 *  com.xiaomi.scanner.util.ScannerThreadPool
 *  com.xiaomi.scanner.util.ScreenUtils
 *  com.xiaomi.scanner.util.Util
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.xiaomi.scanner.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.xiaomi.scanner.util.AppUtil;
import com.xiaomi.scanner.util.CameraUtil;
import com.xiaomi.scanner.util.SPUtils;
import com.xiaomi.scanner.util.ScannerThreadPool;
import com.xiaomi.scanner.util.ScreenUtils;
import com.xiaomi.scanner.util.Util;

import javax.naming.Context;

public class ScannerApp
extends Application {
    private static ScannerApp scannerApp;

    public static Context getAndroidContext() {
        return scannerApp.getApplicationContext();
    }

    public void onCreate() {
        super.onCreate();
        scannerApp = this;
        ScannerThreadPool.poolExecute((Runnable)new Runnable(){

            public void run() {
                Util.initialize((Context)scannerApp);
                AppUtil.checkDeviceHasNavigationBar();
                CameraUtil.getDefaultDisplaySize();
            }
        });
        if (ScreenUtils.isPad((int)this.getResources().getConfiguration().screenLayout)) {
            SPUtils.saveToLocal((String)"save_module_tab", (Object)-100);
        }
    }

}

