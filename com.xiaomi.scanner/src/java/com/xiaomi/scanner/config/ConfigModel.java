/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  com.google.gson.Gson
 *  com.xiaomi.scanner.app.ScanActivity
 *  com.xiaomi.scanner.config.ConfigModel$1
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  com.xiaomi.scanner.module.CodeModule
 *  com.xiaomi.scanner.util.DeviceUtil
 *  com.xiaomi.scanner.util.HttpUtils
 *  com.xiaomi.scanner.util.HttpUtils$ResponseCallback
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.xiaomi.scanner.config;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.xiaomi.scanner.app.ScanActivity;
import com.xiaomi.scanner.app.ScannerApp;
import com.xiaomi.scanner.config.ConfigModel;
import com.xiaomi.scanner.config.bean.CloudControlConfigResult;
import com.xiaomi.scanner.config.bean.ScanRuleListResult;
import com.xiaomi.scanner.debug.Log;
import com.xiaomi.scanner.module.CodeModule;
import com.xiaomi.scanner.util.DeviceUtil;
import com.xiaomi.scanner.util.HttpUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigModel {
    private static final String CACHE_NAME = "configCache";
    private static final String KEY_CACHE = "Config_Scan";
    private static final String KEY_CONFIG_CLOUD_CONTROL = "Config_Cloud_Control";
    private static final Log.Tag TAG = new Log.Tag("ConfigModel");
    public static ConfigModel instance = new ConfigModel();
    private CloudControlConfigResult cloudControlConfigResult;
    private List<Pattern> mAlipayRulePatternList;
    private List<Pattern> mAllCanPayList;
    private List<Pattern> mMiBiPayList;
    private List<Pattern> mMipayList;
    private List<Pattern> mWechatRuleList;
    private ScanRuleListResult scanRuleListResult;

    private ConfigModel() {
    }

    static /* synthetic */ ScanRuleListResult access$002(ConfigModel configModel, ScanRuleListResult scanRuleListResult) {
        configModel.scanRuleListResult = scanRuleListResult;
        return scanRuleListResult;
    }

    static /* synthetic */ void access$100(Object object, String string2) {
        ConfigModel.saveDataToLocal(object, string2);
    }

    private void clearData(List<Pattern> list) {
        if (list != null) {
            list.clear();
        }
    }

    private <T> T getDataFromCache(String string2, Class<T> class_) {
        Object object;
        try {
            String string3 = ScannerApp.getAndroidContext().getSharedPreferences(CACHE_NAME, 0).getString(string2, "");
            object = new Gson().fromJson(string3, class_);
        }
        catch (Exception exception) {
            Log.e((Log.Tag)TAG, (String)"saveDataToLocal", (Throwable)exception);
            return null;
        }
        return (T)object;
    }

    public static String getDataFromCache(String string2) {
        try {
            String string3 = ScannerApp.getAndroidContext().getSharedPreferences(CACHE_NAME, 0).getString(string2, "");
            return string3;
        }
        catch (Exception exception) {
            Log.e((Log.Tag)TAG, (String)"getDataFromCache(String key)", (Throwable)exception);
            return "";
        }
    }

    private static void saveDataToLocal(Object object, String string2) {
        try {
            SharedPreferences.Editor editor = ScannerApp.getAndroidContext().getSharedPreferences(CACHE_NAME, 0).edit();
            editor.putString(string2, new Gson().toJson(object));
            editor.apply();
            CodeModule.setTipView();
            return;
        }
        catch (Exception exception) {
            Log.e((Log.Tag)TAG, (String)"saveDataToLocal", (Throwable)exception);
            return;
        }
    }

    public static void saveDataToLocal(String string2, String string3) {
        try {
            SharedPreferences.Editor editor = ScannerApp.getAndroidContext().getSharedPreferences(CACHE_NAME, 0).edit();
            editor.putString(string2, string3);
            editor.apply();
            return;
        }
        catch (Exception exception) {
            Log.e((Log.Tag)TAG, (String)"saveDataToLocal(String key, String data)", (Throwable)exception);
            return;
        }
    }

    public void clearAllCacheData() {
        this.scanRuleListResult = null;
        this.clearData(this.mAlipayRulePatternList);
        this.clearData(this.mWechatRuleList);
        this.clearData(this.mMiBiPayList);
        this.clearData(this.mMipayList);
        this.clearData(this.mAllCanPayList);
    }

    public CloudControlConfigResult getCloudControlConfigResult() {
        return this.cloudControlConfigResult;
    }

    public List<Pattern> getPaymentRuleList() {
        ScanRuleListResult scanRuleListResult = this.scanRuleListResult;
        if (scanRuleListResult != null && scanRuleListResult.scanAlipayRules != null && this.scanRuleListResult.scanAlipayRules.size() != 0) {
            List<Pattern> list = this.mAlipayRulePatternList;
            if (list != null && !list.isEmpty() && this.mAlipayRulePatternList.size() == this.scanRuleListResult.scanAlipayRules.size()) {
                return this.mAlipayRulePatternList;
            }
            this.mAlipayRulePatternList = new ArrayList();
            for (String string2 : this.scanRuleListResult.scanAlipayRules) {
                this.mAlipayRulePatternList.add((Object)Pattern.compile((String)string2));
            }
            return this.mAlipayRulePatternList;
        }
        return null;
    }

    public String getQrScanTip(ScanActivity scanActivity) {
        String string2 = DeviceUtil.getLanguage();
        if ("zh".equalsIgnoreCase(string2) && !DeviceUtil.isSimpleChinese()) {
            string2 = "zh_tw";
        }
        if (DeviceUtil.isInternationalBuild()) {
            return scanActivity.getResources().getString(2131755405);
        }
        ScanRuleListResult scanRuleListResult = this.scanRuleListResult;
        if (scanRuleListResult != null && scanRuleListResult.scanTipMap != null && !TextUtils.isEmpty((CharSequence)((CharSequence)this.scanRuleListResult.scanTipMap.get((Object)string2)))) {
            if (TextUtils.equals((CharSequence)scanActivity.getIntentAction(), (CharSequence)"com.miui.securitycore")) {
                return scanActivity.getResources().getString(2131755405);
            }
            return (String)this.scanRuleListResult.scanTipMap.get((Object)string2);
        }
        return null;
    }

    public void initCacheCloudControlConfigData() {
        this.cloudControlConfigResult = this.getDataFromCache(KEY_CONFIG_CLOUD_CONTROL, CloudControlConfigResult.class);
    }

    public void initCacheData() {
        this.scanRuleListResult = this.getDataFromCache(KEY_CACHE, ScanRuleListResult.class);
    }

    public boolean isAllCanPayRule(String string2) {
        ScanRuleListResult scanRuleListResult = this.scanRuleListResult;
        if (scanRuleListResult != null && scanRuleListResult.allCanPayRules != null) {
            if (this.scanRuleListResult.allCanPayRules.size() == 0) {
                return false;
            }
            List<Pattern> list = this.mAllCanPayList;
            if (list == null || list.isEmpty() || this.mAllCanPayList.size() != this.scanRuleListResult.allCanPayRules.size()) {
                this.mAllCanPayList = new ArrayList();
                for (String string3 : this.scanRuleListResult.allCanPayRules) {
                    this.mAllCanPayList.add((Object)Pattern.compile((String)string3));
                }
            }
            Iterator iterator = this.mAllCanPayList.iterator();
            while (iterator.hasNext()) {
                if (!((Pattern)iterator.next()).matcher((CharSequence)string2).matches()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isMiBiPayRule(String string2) {
        ScanRuleListResult scanRuleListResult = this.scanRuleListResult;
        if (scanRuleListResult != null && scanRuleListResult.scanMiBiPayRules != null) {
            if (this.scanRuleListResult.scanMiBiPayRules.size() == 0) {
                return false;
            }
            List<Pattern> list = this.mMiBiPayList;
            if (list == null || list.isEmpty() || this.mMiBiPayList.size() != this.scanRuleListResult.scanMiBiPayRules.size()) {
                this.mMiBiPayList = new ArrayList();
                for (String string3 : this.scanRuleListResult.scanMiBiPayRules) {
                    this.mMiBiPayList.add((Object)Pattern.compile((String)string3));
                }
            }
            Iterator iterator = this.mMiBiPayList.iterator();
            while (iterator.hasNext()) {
                if (!((Pattern)iterator.next()).matcher((CharSequence)string2).matches()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isMipayRule(String string2) {
        ScanRuleListResult scanRuleListResult = this.scanRuleListResult;
        if (scanRuleListResult != null && scanRuleListResult.scanMipayRules != null) {
            if (this.scanRuleListResult.scanMipayRules.size() == 0) {
                return false;
            }
            List<Pattern> list = this.mMipayList;
            if (list == null || list.isEmpty() || this.mMipayList.size() != this.scanRuleListResult.scanMipayRules.size()) {
                this.mMipayList = new ArrayList();
                for (String string3 : this.scanRuleListResult.scanMipayRules) {
                    this.mMipayList.add((Object)Pattern.compile((String)string3));
                }
            }
            Iterator iterator = this.mMipayList.iterator();
            while (iterator.hasNext()) {
                if (!((Pattern)iterator.next()).matcher((CharSequence)string2).matches()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isWechatRule(String string2) {
        ScanRuleListResult scanRuleListResult = this.scanRuleListResult;
        if (scanRuleListResult != null && scanRuleListResult.wechatJumpRules != null) {
            if (this.scanRuleListResult.wechatJumpRules.size() == 0) {
                return false;
            }
            List<Pattern> list = this.mWechatRuleList;
            if (list == null || list.isEmpty() || this.mWechatRuleList.size() != this.scanRuleListResult.wechatJumpRules.size()) {
                this.mWechatRuleList = new ArrayList();
                for (String string3 : this.scanRuleListResult.wechatJumpRules) {
                    this.mWechatRuleList.add((Object)Pattern.compile((String)string3));
                }
            }
            Iterator iterator = this.mWechatRuleList.iterator();
            while (iterator.hasNext()) {
                if (!((Pattern)iterator.next()).matcher((CharSequence)string2).matches()) continue;
                return true;
            }
        }
        return false;
    }

    public void querBarcodeRoughRule() {
        HttpUtils.queryTrackingNumInspectorRule();
    }

    public void queryCCSpecialQRRuleJson() {
        HttpUtils.queryInspectorRule();
    }

    public void queryScanRuleConfig() {
        if (DeviceUtil.isInternationalBuild()) {
            return;
        }
        HttpUtils.queryScanRuleConfig((HttpUtils.ResponseCallback)new 1(this));
    }
}

