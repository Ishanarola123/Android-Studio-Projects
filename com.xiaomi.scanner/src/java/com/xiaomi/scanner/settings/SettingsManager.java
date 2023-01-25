/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.preference.PreferenceManager
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  com.xiaomi.scanner.settings.DefaultsStore
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.scanner.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.xiaomi.scanner.debug.Log;
import com.xiaomi.scanner.settings.DefaultsStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsManager {
    public static final String CAMERA_SCOPE_PREFIX = "_preferences_camera_";
    public static final String MODULE_SCOPE_PREFIX = "_preferences_module_";
    public static final String SCOPE_GLOBAL = "default_scope";
    private static final Log.Tag TAG = new Log.Tag("SettingsManager");
    private final Context mContext;
    private SharedPreferences mCustomPreferences;
    private final SharedPreferences mDefaultPreferences;
    private final DefaultsStore mDefaultsStore = new DefaultsStore();
    private final List<OnSettingChangedListener> mListeners = new ArrayList();
    private final String mPackageName;
    private final List<SharedPreferences.OnSharedPreferenceChangeListener> mSharedPreferenceListeners = new ArrayList();

    public SettingsManager(Context context) {
        this.mContext = context;
        this.mPackageName = this.mContext.getPackageName();
        this.mDefaultPreferences = PreferenceManager.getDefaultSharedPreferences((Context)this.mContext);
    }

    static String convert(int n) {
        return Integer.toString((int)n);
    }

    static String convert(long l) {
        return Long.toString((long)l);
    }

    static String convert(boolean bl) {
        if (bl) {
            return "1";
        }
        return "0";
    }

    public static String getCameraSettingScope(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CAMERA_SCOPE_PREFIX);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static String getModuleSettingScope(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MODULE_SCOPE_PREFIX);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    private SharedPreferences getPreferencesFromScope(String string) {
        if (string.equals((Object)SCOPE_GLOBAL)) {
            return this.mDefaultPreferences;
        }
        SharedPreferences sharedPreferences = this.mCustomPreferences;
        if (sharedPreferences != null) {
            this.closePreferences(sharedPreferences);
        }
        this.mCustomPreferences = this.openPreferences(string);
        return this.mCustomPreferences;
    }

    private SharedPreferences.OnSharedPreferenceChangeListener getSharedPreferenceListener(final OnSettingChangedListener onSettingChangedListener) {
        return new SharedPreferences.OnSharedPreferenceChangeListener(){

            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String string) {
                onSettingChangedListener.onSettingChanged(SettingsManager.this, string);
            }
        };
    }

    public void addListener(OnSettingChangedListener onSettingChangedListener) {
        if (onSettingChangedListener != null) {
            if (this.mListeners.contains((Object)onSettingChangedListener)) {
                return;
            }
            this.mListeners.add((Object)onSettingChangedListener);
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.getSharedPreferenceListener(onSettingChangedListener);
            this.mSharedPreferenceListeners.add((Object)onSharedPreferenceChangeListener);
            this.mDefaultPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            SharedPreferences sharedPreferences = this.mCustomPreferences;
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
            Log.Tag tag = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("listeners: ");
            stringBuilder.append(this.mListeners);
            Log.v((Log.Tag)tag, (String)stringBuilder.toString());
            return;
        }
        throw new IllegalArgumentException("OnSettingChangedListener cannot be null.");
    }

    protected void closePreferences(SharedPreferences sharedPreferences) {
        Iterator iterator = this.mSharedPreferenceListeners.iterator();
        while (iterator.hasNext()) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)iterator.next());
        }
    }

    public boolean getBoolean(String string, String string2) {
        return this.getBoolean(string, string2, this.getBooleanDefault(string2));
    }

    public boolean getBoolean(String string, String string2, boolean bl) {
        String string3 = bl ? "1" : "0";
        return Integer.parseInt((String)this.getString(string, string2, string3)) != 0;
    }

    public boolean getBooleanDefault(String string) {
        String string2 = this.mDefaultsStore.getDefaultValue(string);
        if (string2 == null) {
            return false;
        }
        int n = Integer.parseInt((String)string2);
        boolean bl = false;
        if (n != 0) {
            bl = true;
        }
        return bl;
    }

    public SharedPreferences getDefaultPreferences() {
        return this.mDefaultPreferences;
    }

    public int getIndexOfCurrentValue(String string, String string2) {
        String[] arrstring = this.mDefaultsStore.getPossibleValues(string2);
        if (arrstring != null && arrstring.length != 0) {
            String string3 = this.getString(string, string2);
            for (int i = 0; i < arrstring.length; ++i) {
                if (!string3.equals((Object)arrstring[i])) continue;
                return i;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Current value for scope=");
            stringBuilder.append(string);
            stringBuilder.append(" key=");
            stringBuilder.append(string2);
            stringBuilder.append(" not in list of possible values");
            throw new IllegalStateException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No possible values for scope=");
        stringBuilder.append(string);
        stringBuilder.append(" key=");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public Integer getInteger(String string, String string2) {
        return this.getInteger(string, string2, this.getIntegerDefault(string2));
    }

    public Integer getInteger(String string, String string2, Integer n) {
        return Integer.parseInt((String)this.getString(string, string2, Integer.toString((int)n)));
    }

    public Integer getIntegerDefault(String string) {
        String string2 = this.mDefaultsStore.getDefaultValue(string);
        int n = string2 == null ? 0 : Integer.parseInt((String)string2);
        return n;
    }

    public Long getLong(String string, String string2, Long l) {
        String string3 = this.getString(string, string2, Long.toString((long)l));
        try {
            Long l2 = Long.parseLong((String)string3);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            Log.Tag tag = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getLong error, key=");
            stringBuilder.append(string2);
            Log.e((Log.Tag)tag, (String)stringBuilder.toString(), (Throwable)numberFormatException);
            return l;
        }
    }

    public String getString(String string, String string2) {
        return this.getString(string, string2, this.getStringDefault(string2));
    }

    public String getString(String string, String string2, String string3) {
        return this.getPreferencesFromScope(string).getString(string2, string3);
    }

    public String getStringDefault(String string) {
        return this.mDefaultsStore.getDefaultValue(string);
    }

    public boolean isDefault(String string, String string2) {
        String string3 = this.getStringDefault(string2);
        String string4 = this.getString(string, string2);
        if (string4 == null) {
            return false;
        }
        return string4.equals((Object)string3);
    }

    public boolean isSet(String string, String string2) {
        return this.getPreferencesFromScope(string).contains(string2);
    }

    protected SharedPreferences openPreferences(String string) {
        Context context = this.mContext;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mPackageName);
        stringBuilder.append(string);
        SharedPreferences sharedPreferences = context.getSharedPreferences(stringBuilder.toString(), 0);
        Iterator iterator = this.mSharedPreferenceListeners.iterator();
        while (iterator.hasNext()) {
            sharedPreferences.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)iterator.next());
        }
        return sharedPreferences;
    }

    public void remove(String string, String string2) {
        this.getPreferencesFromScope(string).edit().remove(string2).apply();
    }

    public void removeAllListeners() {
        for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.mSharedPreferenceListeners) {
            this.mDefaultPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            SharedPreferences sharedPreferences = this.mCustomPreferences;
            if (sharedPreferences == null) continue;
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
        this.mSharedPreferenceListeners.clear();
        this.mListeners.clear();
    }

    public void removeListener(OnSettingChangedListener onSettingChangedListener) {
        if (onSettingChangedListener != null) {
            if (!this.mListeners.contains((Object)onSettingChangedListener)) {
                return;
            }
            int n = this.mListeners.indexOf((Object)onSettingChangedListener);
            this.mListeners.remove((Object)onSettingChangedListener);
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)this.mSharedPreferenceListeners.get(n);
            this.mSharedPreferenceListeners.remove(n);
            this.mDefaultPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            SharedPreferences sharedPreferences = this.mCustomPreferences;
            if (sharedPreferences != null) {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void set(String string, String string2, int n) {
        this.set(string, string2, SettingsManager.convert(n));
    }

    public void set(String string, String string2, long l) {
        this.set(string, string2, SettingsManager.convert(l));
    }

    public void set(String string, String string2, String string3) {
        this.getPreferencesFromScope(string).edit().putString(string2, string3).apply();
    }

    public void set(String string, String string2, boolean bl) {
        this.set(string, string2, SettingsManager.convert(bl));
    }

    public void setDefaults(String string, int n, int[] arrn) {
        String string2 = Integer.toString((int)n);
        String[] arrstring = new String[arrn.length];
        for (int i = 0; i < arrn.length; ++i) {
            arrstring[i] = Integer.toString((int)arrn[i]);
        }
        this.mDefaultsStore.storeDefaults(string, string2, arrstring);
    }

    public void setDefaults(String string, String string2, String[] arrstring) {
        this.mDefaultsStore.storeDefaults(string, string2, arrstring);
    }

    public void setDefaults(String string, boolean bl) {
        String string2 = bl ? "1" : "0";
        String[] arrstring = new String[]{"0", "1"};
        this.mDefaultsStore.storeDefaults(string, string2, arrstring);
    }

    public void setToDefault(String string, String string2) {
        this.set(string, string2, this.getStringDefault(string2));
    }

    public void setValueByIndex(String string, String string2, int n) {
        String[] arrstring = this.mDefaultsStore.getPossibleValues(string2);
        if (arrstring.length != 0) {
            if (n >= 0 && n < arrstring.length) {
                this.set(string, string2, arrstring[n]);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("For possible values of scope=");
            stringBuilder.append(string);
            stringBuilder.append(" key=");
            stringBuilder.append(string2);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No possible values for scope=");
        stringBuilder.append(string);
        stringBuilder.append(" key=");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static interface OnSettingChangedListener {
        public void onSettingChanged(SettingsManager var1, String var2);
    }

}

