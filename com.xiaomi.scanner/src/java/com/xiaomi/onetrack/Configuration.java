/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.onetrack;

import android.text.TextUtils;
import com.xiaomi.onetrack.Configuration$1;
import com.xiaomi.onetrack.OneTrack;

public class Configuration {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private String e;
    private OneTrack.Mode f = OneTrack.Mode.APP;
    private boolean g = true;
    private boolean h = true;
    private boolean i = true;
    private boolean j;
    private boolean k = true;
    private boolean l = false;
    private String m;
    private OneTrack.IEventHook n;

    private Configuration(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.i = builder.i;
        this.h = builder.h;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
    }

    /* synthetic */ Configuration(Builder builder, Configuration$1 configuration$1) {
        this(builder);
    }

    private String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)string2) && string2.length() > 4) {
            for (int i2 = 0; i2 < string2.length(); ++i2) {
                if (i2 != 0 && i2 != 1 && i2 != -2 + string2.length() && i2 != string2.length() - 1) {
                    stringBuilder.append("*");
                    continue;
                }
                stringBuilder.append(string2.charAt(i2));
            }
        } else {
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public String getAppId() {
        return this.a;
    }

    public String getChannel() {
        return this.c;
    }

    public String getInstanceId() {
        return this.m;
    }

    public OneTrack.Mode getMode() {
        return this.f;
    }

    public String getPluginId() {
        return this.b;
    }

    public String getRegion() {
        return this.e;
    }

    public boolean isAutoTrackActivityAction() {
        return this.k;
    }

    public boolean isExceptionCatcherEnable() {
        return this.j;
    }

    @Deprecated
    public boolean isGAIDEnable() {
        return this.g;
    }

    public boolean isIMEIEnable() {
        return this.i;
    }

    public boolean isIMSIEnable() {
        return this.h;
    }

    public boolean isInternational() {
        return this.d;
    }

    public boolean isOverrideMiuiRegionSetting() {
        return this.l;
    }

    public String toString() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Configuration{appId='");
            stringBuilder.append(this.a(this.a));
            stringBuilder.append('\'');
            stringBuilder.append(", pluginId='");
            stringBuilder.append(this.a(this.b));
            stringBuilder.append('\'');
            stringBuilder.append(", channel='");
            stringBuilder.append(this.c);
            stringBuilder.append('\'');
            stringBuilder.append(", international=");
            stringBuilder.append(this.d);
            stringBuilder.append(", region='");
            stringBuilder.append(this.e);
            stringBuilder.append('\'');
            stringBuilder.append(", overrideMiuiRegionSetting=");
            stringBuilder.append(this.l);
            stringBuilder.append(", mode=");
            stringBuilder.append((Object)this.f);
            stringBuilder.append(", GAIDEnable=");
            stringBuilder.append(this.g);
            stringBuilder.append(", IMSIEnable=");
            stringBuilder.append(this.h);
            stringBuilder.append(", IMEIEnable=");
            stringBuilder.append(this.i);
            stringBuilder.append(", ExceptionCatcherEnable=");
            stringBuilder.append(this.j);
            stringBuilder.append(", instanceId=");
            stringBuilder.append(this.a(this.m));
            stringBuilder.append('}');
            String string2 = stringBuilder.toString();
            return string2;
        }
        catch (Exception exception) {
            return "";
        }
    }

    public static class Builder {
        private String a;
        private String b;
        private String c;
        private boolean d;
        private String e;
        private OneTrack.Mode f = OneTrack.Mode.APP;
        private boolean g = true;
        private boolean h = true;
        private boolean i = true;
        private boolean j = false;
        private boolean k = true;
        private boolean l = false;
        private String m;

        public Configuration build() {
            return new Configuration(this, null);
        }

        public Builder setAppId(String string2) {
            this.a = string2;
            return this;
        }

        public Builder setAutoTrackActivityAction(boolean bl) {
            this.k = bl;
            return this;
        }

        public Builder setChannel(String string2) {
            this.c = string2;
            return this;
        }

        public Builder setExceptionCatcherEnable(boolean bl) {
            this.j = bl;
            return this;
        }

        @Deprecated
        public Builder setGAIDEnable(boolean bl) {
            this.g = bl;
            return this;
        }

        public Builder setImeiEnable(boolean bl) {
            this.i = bl;
            return this;
        }

        public Builder setImsiEnable(boolean bl) {
            this.h = bl;
            return this;
        }

        public Builder setInstanceId(String string2) {
            this.m = string2;
            return this;
        }

        public Builder setInternational(boolean bl) {
            this.d = bl;
            return this;
        }

        public Builder setMode(OneTrack.Mode mode) {
            this.f = mode;
            return this;
        }

        public Builder setOverrideMiuiRegionSetting(boolean bl) {
            this.l = bl;
            return this;
        }

        public Builder setPluginId(String string2) {
            this.b = string2;
            return this;
        }

        public Builder setRegion(String string2) {
            this.e = string2;
            return this;
        }
    }

}

