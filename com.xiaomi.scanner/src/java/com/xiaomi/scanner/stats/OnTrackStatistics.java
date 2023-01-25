/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  com.xiaomi.scanner.util.AppUtil
 *  com.xiaomi.scanner.util.ScannerThreadPool
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 */
package com.xiaomi.scanner.stats;

import android.content.Context;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.scanner.app.ScannerApp;
import com.xiaomi.scanner.debug.Log;
import com.xiaomi.scanner.util.AppUtil;
import com.xiaomi.scanner.util.ScannerThreadPool;
import java.util.HashMap;
import java.util.Map;

public class OnTrackStatistics {
    private static final String DEFAULT_CATEGORY = "Scanner";
    private static final String KEY_CAMERA_FAILURE = "camera_failure";
    private static final String PARAM_CAMERA_FAILURE_ACTION = "action";
    private static final String PARAM_CAMERA_FAILURE_CAUSE = "cause";
    private static final String PARAM_CAMERA_FAILURE_INFO = "info";
    private static final String PARAM_CAMERA_FAILURE_STATE = "state";
    private static final String PARAM_VERSION_CODE = "param_version_code";
    private static final String PARAM_VERSION_NAME = "param_version_name";
    private static final Log.Tag TAG = new Log.Tag("GUsageStatistics");
    private static boolean sInitialized;
    private static OneTrack sOneTrack;

    private static void appendVersions(Map<String, Object> map) {
        map.put((Object)PARAM_VERSION_NAME, (Object)"13.2202.18");
        map.put((Object)PARAM_VERSION_CODE, (Object)String.valueOf((int)13220218));
    }

    public static void cameraFailure(int n) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)PARAM_CAMERA_FAILURE_CAUSE, (Object)String.valueOf((int)n));
        OnTrackStatistics.recordCountEvent(DEFAULT_CATEGORY, KEY_CAMERA_FAILURE, (Map<String, Object>)hashMap);
    }

    public static void cameraFailure(int n, String string, int n2, int n3) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)PARAM_CAMERA_FAILURE_CAUSE, (Object)String.valueOf((int)n));
        hashMap.put((Object)PARAM_CAMERA_FAILURE_INFO, (Object)string);
        hashMap.put((Object)PARAM_CAMERA_FAILURE_ACTION, (Object)String.valueOf((int)n2));
        hashMap.put((Object)PARAM_CAMERA_FAILURE_STATE, (Object)String.valueOf((int)n3));
        OnTrackStatistics.recordCountEvent(DEFAULT_CATEGORY, KEY_CAMERA_FAILURE, (Map<String, Object>)hashMap);
    }

    public static void initialize(ScannerApp scannerApp) {
        if (!AppUtil.isUserAgreeToRun()) {
            return;
        }
        if (sInitialized) {
            return;
        }
        try {
            sOneTrack = OneTrack.createInstance((Context)scannerApp, new Configuration.Builder().setAppId("2882303761518366397").setChannel("xiaomi").setInternational(true).setMode(OneTrack.Mode.APP).setExceptionCatcherEnable(true).build());
            OneTrack.setDebugMode(false);
            sInitialized = true;
            return;
        }
        catch (Exception exception) {
            Log.e((Log.Tag)TAG, (String)exception.getMessage(), (Throwable)exception);
            sInitialized = false;
            return;
        }
    }

    private static void recordCountEvent(final String string, String string2, Map<String, Object> hashMap) {
        if (!sInitialized) {
            return;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        OnTrackStatistics.appendVersions(hashMap);
        ScannerThreadPool.poolExecute((Runnable)new Runnable((Map)hashMap, string2){
            final /* synthetic */ String val$category;
            final /* synthetic */ Map val$param;
            {
                this.val$param = map;
                this.val$category = string2;
            }

            public void run() {
                try {
                    OnTrackStatistics.trackCameraFailure(string, (Map<String, Object>)this.val$param, this.val$category);
                    Log.Tag tag = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("event ");
                    stringBuilder.append(string);
                    stringBuilder.append(", params = ");
                    stringBuilder.append(this.val$param.toString());
                    Log.d((Log.Tag)tag, (String)stringBuilder.toString());
                    return;
                }
                catch (Exception exception) {
                    Log.e((Log.Tag)TAG, (String)exception.getMessage(), (Throwable)exception);
                    return;
                }
            }
        });
    }

    public static void recordWithParamEvent(String string, String string2) {
        if (!sInitialized) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"typeValue", (Object)string2);
        sOneTrack.track(string, (Map<String, Object>)hashMap);
    }

    public static void track(String string) {
        if (!sInitialized) {
            return;
        }
        sOneTrack.track(string, null);
    }

    public static void track(String string, Object object, Map<String, Object> map) {
        if (!sInitialized) {
            return;
        }
        map.put((Object)"time", object);
        sOneTrack.track(string, map);
    }

    public static void track(String string, Map<String, Object> map) {
        if (!sInitialized) {
            return;
        }
        sOneTrack.track(string, map);
    }

    private static void trackCameraFailure(String string, Map<String, Object> map, Object object) {
        if (!sInitialized) {
            return;
        }
        map.put((Object)KEY_CAMERA_FAILURE, object);
        sOneTrack.track(string, map);
    }

    public static void trackFromApp(String string, Map<String, Object> map) {
        if (!sInitialized) {
            return;
        }
        sOneTrack.track(string, map);
    }

    public static void trackTypeValue(String string, Object object) {
        if (!sInitialized) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"type_value", object);
        sOneTrack.track(string, (Map<String, Object>)hashMap);
    }

}

