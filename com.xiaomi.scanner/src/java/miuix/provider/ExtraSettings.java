/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.provider.Settings$SettingNotFoundException
 *  android.provider.Settings$System
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 */
package miuix.provider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;

public class ExtraSettings {
    protected ExtraSettings() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static class Secure {
        public static final String PRIVACY_MODE_ENABLED = "privacy_mode_enabled";
        public static final String UPLOAD_LOG = "upload_log_pref";

        protected Secure() throws InstantiationException {
            throw new InstantiationException("Cannot instantiate utility class");
        }

        public static boolean getBoolean(ContentResolver contentResolver, String string2) throws Settings.SettingNotFoundException {
            return Secure.getInt(contentResolver, string2) != 0;
        }

        public static boolean getBoolean(ContentResolver contentResolver, String string2, boolean bl) {
            return Secure.getInt(contentResolver, string2, (int)bl) != 0;
        }

        public static float getFloat(ContentResolver contentResolver, String string2) throws Settings.SettingNotFoundException {
            return Settings.Secure.getFloat((ContentResolver)contentResolver, (String)string2);
        }

        public static float getFloat(ContentResolver contentResolver, String string2, float f) {
            return Settings.Secure.getFloat((ContentResolver)contentResolver, (String)string2, (float)f);
        }

        public static int getInt(ContentResolver contentResolver, String string2) throws Settings.SettingNotFoundException {
            return Settings.Secure.getInt((ContentResolver)contentResolver, (String)string2);
        }

        public static int getInt(ContentResolver contentResolver, String string2, int n) {
            return Settings.Secure.getInt((ContentResolver)contentResolver, (String)string2, (int)n);
        }

        public static long getLong(ContentResolver contentResolver, String string2) throws Settings.SettingNotFoundException {
            return Settings.Secure.getLong((ContentResolver)contentResolver, (String)string2);
        }

        public static long getLong(ContentResolver contentResolver, String string2, long l) {
            return Settings.Secure.getLong((ContentResolver)contentResolver, (String)string2, (long)l);
        }

        public static String getString(ContentResolver contentResolver, String string2) {
            return Settings.Secure.getString((ContentResolver)contentResolver, (String)string2);
        }

        public static String getString(ContentResolver contentResolver, String string2, String string3) {
            String string4 = Settings.Secure.getString((ContentResolver)contentResolver, (String)string2);
            if (string4 == null) {
                string4 = string3;
            }
            return string4;
        }

        public static Uri getUriFor(String string2) {
            return Settings.Secure.getUriFor((String)string2);
        }

        public static boolean putBoolean(ContentResolver contentResolver, String string2, boolean bl) {
            return Secure.putInt(contentResolver, string2, (int)bl);
        }

        public static boolean putFloat(ContentResolver contentResolver, String string2, float f) {
            return Settings.Secure.putFloat((ContentResolver)contentResolver, (String)string2, (float)f);
        }

        public static boolean putInt(ContentResolver contentResolver, String string2, int n) {
            return Settings.Secure.putInt((ContentResolver)contentResolver, (String)string2, (int)n);
        }

        public static boolean putLong(ContentResolver contentResolver, String string2, long l) {
            return Settings.Secure.putLong((ContentResolver)contentResolver, (String)string2, (long)l);
        }

        public static boolean putString(ContentResolver contentResolver, String string2, String string3) {
            return Settings.Secure.putString((ContentResolver)contentResolver, (String)string2, (String)string3);
        }
    }

    public static class System {
        public static final String DEFAULT_ALARM_ALERT = "default_alarm_alert";

        protected System() throws InstantiationException {
            throw new InstantiationException("Cannot instantiate utility class");
        }

        public static boolean getBoolean(ContentResolver contentResolver, String string2) throws Settings.SettingNotFoundException {
            return System.getInt(contentResolver, string2) != 0;
        }

        public static boolean getBoolean(ContentResolver contentResolver, String string2, boolean bl) {
            return System.getInt(contentResolver, string2, (int)bl) != 0;
        }

        public static float getFloat(ContentResolver contentResolver, String string2) throws Settings.SettingNotFoundException {
            return Settings.System.getFloat((ContentResolver)contentResolver, (String)string2);
        }

        public static float getFloat(ContentResolver contentResolver, String string2, float f) {
            return Settings.System.getFloat((ContentResolver)contentResolver, (String)string2, (float)f);
        }

        public static int getInt(ContentResolver contentResolver, String string2) throws Settings.SettingNotFoundException {
            return Settings.System.getInt((ContentResolver)contentResolver, (String)string2);
        }

        public static int getInt(ContentResolver contentResolver, String string2, int n) {
            return Settings.System.getInt((ContentResolver)contentResolver, (String)string2, (int)n);
        }

        public static long getLong(ContentResolver contentResolver, String string2) throws Settings.SettingNotFoundException {
            return Settings.System.getLong((ContentResolver)contentResolver, (String)string2);
        }

        public static long getLong(ContentResolver contentResolver, String string2, long l) {
            return Settings.System.getLong((ContentResolver)contentResolver, (String)string2, (long)l);
        }

        public static String getString(ContentResolver contentResolver, String string2) {
            return Settings.System.getString((ContentResolver)contentResolver, (String)string2);
        }

        public static String getString(ContentResolver contentResolver, String string2, String string3) {
            String string4 = Settings.System.getString((ContentResolver)contentResolver, (String)string2);
            if (string4 == null) {
                string4 = string3;
            }
            return string4;
        }

        public static Uri getUriFor(String string2) {
            return Settings.System.getUriFor((String)string2);
        }

        public static boolean putBoolean(ContentResolver contentResolver, String string2, boolean bl) {
            return System.putInt(contentResolver, string2, (int)bl);
        }

        public static boolean putFloat(ContentResolver contentResolver, String string2, float f) {
            return Settings.System.putFloat((ContentResolver)contentResolver, (String)string2, (float)f);
        }

        public static boolean putInt(ContentResolver contentResolver, String string2, int n) {
            return Settings.System.putInt((ContentResolver)contentResolver, (String)string2, (int)n);
        }

        public static boolean putLong(ContentResolver contentResolver, String string2, long l) {
            return Settings.System.putLong((ContentResolver)contentResolver, (String)string2, (long)l);
        }

        public static boolean putString(ContentResolver contentResolver, String string2, String string3) {
            return Settings.System.putString((ContentResolver)contentResolver, (String)string2, (String)string3);
        }
    }

}

