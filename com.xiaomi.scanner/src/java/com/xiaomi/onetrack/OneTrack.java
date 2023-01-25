/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.xiaomi.onetrack.DefaultEventHook
 *  com.xiaomi.onetrack.OnMainThreadException
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.xiaomi.onetrack;

import android.content.Context;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.CrashAnalysis;
import com.xiaomi.onetrack.DefaultEventHook;
import com.xiaomi.onetrack.OnMainThreadException;
import com.xiaomi.onetrack.OneTrack$1;
import com.xiaomi.onetrack.ServiceQualityEvent;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.o;
import java.util.Map;

public class OneTrack {
    private static boolean a;
    private static boolean b;
    private f c;

    private OneTrack(Context context, Configuration configuration) {
        a.a(context.getApplicationContext());
        this.c = new f(context, configuration);
        this.setEventHook((IEventHook)new DefaultEventHook());
    }

    private static void a(Context context) {
        if (context != null) {
            a.a(context.getApplicationContext());
            return;
        }
        throw new IllegalStateException("context is null!");
    }

    public static OneTrack createInstance(Context context, Configuration configuration) {
        return new OneTrack(context, configuration);
    }

    public static boolean isDisable() {
        return a;
    }

    public static boolean isUseSystemNetTrafficOnly() {
        return b;
    }

    public static void registerCrashHook(Context context) {
        CrashAnalysis.a(context);
    }

    public static void setAccessNetworkEnable(Context context, boolean bl) {
        OneTrack.a(context);
        h.a(new OneTrack$1(bl));
    }

    public static void setDebugMode(boolean bl) {
        o.a = bl;
    }

    public static void setDisable(boolean bl) {
        a = bl;
    }

    public static void setUseSystemNetTrafficOnly() {
        b = true;
    }

    public void clearCommonProperty() {
        this.c.a();
    }

    public String getInstanceId() throws OnMainThreadException {
        return this.c.b();
    }

    public String getOAID(Context context) throws OnMainThreadException {
        return this.c.a(context);
    }

    public void login(String string2, UserIdType userIdType, Map<String, Object> map) {
        this.login(string2, userIdType, map, false);
    }

    public void login(String string2, UserIdType userIdType, Map<String, Object> map, boolean bl) {
        this.c.a(string2, userIdType, map, bl);
    }

    public void logout() {
        this.logout(null, false);
    }

    public void logout(Map<String, Object> map, boolean bl) {
        this.c.a(map, bl);
    }

    public void removeCommonProperty(String string2) {
        this.c.a(string2);
    }

    public void setCommonProperty(Map<String, Object> map) {
        this.c.c(map);
    }

    public void setDynamicCommonProperty(ICommonPropertyProvider iCommonPropertyProvider) {
        this.c.a(iCommonPropertyProvider);
    }

    public void setEventHook(IEventHook iEventHook) {
        this.c.a(iEventHook);
    }

    public void setInstanceId(String string2) {
        this.c.b(string2);
    }

    public void setUserProfile(String string2, Object object) {
        this.c.a(string2, object);
    }

    public void setUserProfile(Map<String, Object> map) {
        this.c.a(map);
    }

    public void track(String string2, Map<String, Object> map) {
        this.c.a(string2, map);
    }

    public void trackPluginEvent(String string2, String string3, Map<String, Object> map) {
        this.c.a(string2, string3, map);
    }

    public void trackServiceQualityEvent(ServiceQualityEvent serviceQualityEvent) {
        this.c.a(serviceQualityEvent);
    }

    public void userProfileIncrement(String string2, Number number) {
        this.c.a(string2, number);
    }

    public void userProfileIncrement(Map<String, ? extends Number> map) {
        this.c.b(map);
    }

    public static class Event {
        public static final String ANCHOR_STATUS = "anchor_status";
        public static final String CART = "cart";
        public static final String CLICK = "click";
        public static final String COMMENT = "comment";
        public static final String DOWNLOAD = "download";
        public static final String EXPOSE = "expose";
        public static final String FAVORITE = "favorite";
        public static final String FOLLOW = "follow";
        public static final String GIFT_INTERACTION = "gift_interaction";
        public static final String LIKE = "like";
        public static final String LOGIN = "login";
        public static final String ORDER = "order";
        public static final String PLAY = "play";
        public static final String ROOM_SEATING = "room_seating";
        public static final String SEARCH = "search";
        public static final String SEND_MESSAGE = "send_message";
        public static final String UNLOCK = "unlock";
        public static final String VIEW = "view";
        public static final String VIEWER_STATUS = "viewer_status";
    }

    public static interface ICommonPropertyProvider {
        public Map<String, Object> getDynamicProperty(String var1);
    }

    public static interface IEventHook {
        public boolean fillGAID(String var1);
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode APP = new Mode("app");
        public static final /* enum */ Mode PLUGIN = new Mode("plugin");
        public static final /* enum */ Mode SDK = new Mode("sdk");
        private static final /* synthetic */ Mode[] b;
        private String a;

        static {
            Mode[] arrmode = new Mode[]{APP, PLUGIN, SDK};
            b = arrmode;
        }

        private Mode(String string3) {
            this.a = string3;
        }

        public static Mode valueOf(String string2) {
            return (Mode)Enum.valueOf(Mode.class, (String)string2);
        }

        public static Mode[] values() {
            return (Mode[])b.clone();
        }

        public String getType() {
            return this.a;
        }
    }

    public static final class NetType
    extends Enum<NetType> {
        public static final /* enum */ NetType ETHERNET;
        public static final /* enum */ NetType MOBILE_2G;
        public static final /* enum */ NetType MOBILE_3G;
        public static final /* enum */ NetType MOBILE_4G;
        public static final /* enum */ NetType MOBILE_5G;
        public static final /* enum */ NetType NOT_CONNECTED;
        public static final /* enum */ NetType UNKNOWN;
        public static final /* enum */ NetType WIFI;
        private static final /* synthetic */ NetType[] b;
        private String a;

        static {
            NOT_CONNECTED = new NetType("NONE");
            MOBILE_2G = new NetType("2G");
            MOBILE_3G = new NetType("3G");
            MOBILE_4G = new NetType("4G");
            MOBILE_5G = new NetType("5G");
            WIFI = new NetType("WIFI");
            ETHERNET = new NetType("ETHERNET");
            UNKNOWN = new NetType("UNKNOWN");
            NetType[] arrnetType = new NetType[]{NOT_CONNECTED, MOBILE_2G, MOBILE_3G, MOBILE_4G, MOBILE_5G, WIFI, ETHERNET, UNKNOWN};
            b = arrnetType;
        }

        private NetType(String string3) {
            this.a = string3;
        }

        public static NetType valueOf(String string2) {
            return (NetType)Enum.valueOf(NetType.class, (String)string2);
        }

        public static NetType[] values() {
            return (NetType[])b.clone();
        }

        public String toString() {
            return this.a;
        }
    }

    public static class Param {
        public static final String ANCHOR_UID = "anchor_uid";
        public static final String ANDROID_ID = "android_id";
        public static final String APPID = "appid";
        public static final String APP_PLATFORM = "app_platform";
        public static final String APP_VER = "app_ver";
        public static final String ASSET_ID = "asset_id";
        public static final String ASSET_NAME = "asset_name";
        public static final String BIRTHDAY = "birthday";
        public static final String BUILD = "build";
        public static final String CHANNEL = "channel";
        public static final String CITY = "city";
        public static final String CLASS = "class";
        public static final String DEVICE_LANG = "device_lang";
        public static final String DURATION = "duration";
        public static final String ELEMENT_ID = "element_id";
        public static final String ELEMENT_NAME = "element_name";
        public static final String EXCEPTION = "exception";
        public static final String EXP_ID = "exp_id";
        public static final String E_TS = "e_ts";
        public static final String FIRST_LOGIN_TIME = "first_login_time";
        public static final String FIRST_OPEN = "first_open";
        public static final String FIRST_ORDER_TIME = "first_order_time";
        public static final String FIRST_VISIT_TIME = "first_visit_time";
        public static final String GENDER = "gender";
        public static final String GIFT_ID = "gift_id";
        public static final String GIFT_NUM = "gift_num";
        public static final String HOBBY = "hobby";
        public static final String IMEI_MD5 = "imei";
        public static final String INSTANCE_ID = "instance_id";
        public static final String JOB = "job";
        public static final String LINK = "link";
        public static final String LOGIN_METHOD = "login_method";
        public static final String LOGIN_RESULT = "login_result";
        public static final String LOGIN_TYPE = "login_type";
        public static final String MESSAGE = "message";
        public static final String MESSAGE_EMOJI = "message_emoji";
        public static final String MESSAGE_GIF = "message_gif";
        public static final String MESSAGE_PIC = "message_pic";
        public static final String MESSAGE_TEXT = "message_text";
        public static final String MESSAGE_VOICE = "message_voice";
        public static final String MFRS = "mfrs";
        public static final String MIUI = "miui";
        public static final String MODEL = "model";
        public static final String NAME = "name";
        public static final String NET = "net";
        public static final String OAID = "oaid";
        public static final String ORDER_ACT_TYPE = "order_act_type";
        public static final String ORDER_ID = "order_id";
        public static final String OS_VER = "os_ver";
        public static final String PHONE = "phone";
        public static final String PKG = "pkg";
        public static final String PLATFORM = "platform";
        public static final String PROVINCE = "province";
        public static final String REF_TIP = "ref_tip";
        public static final String REGION = "region";
        public static final String ROOM_ID = "room_id";
        public static final String SESSION_ID = "session_id";
        public static final String SKU_ID = "sku_id";
        public static final String SKU_NUM = "sku_num";
        public static final String TO_UID = "to_uid";
        public static final String TZ = "tz";
        public static final String UID = "uid";
        public static final String USER_ID = "user_id";
        public static final String UTM_CAMPAIGN = "utm_campaign";
        public static final String UTM_CONTENT = "utm_content";
        public static final String UTM_MEDIUM = "utm_medium";
        public static final String UTM_SOURCE = "utm_source";
        public static final String UTM_TERM = "utm_term";
        public static final String VIP_LEVEL = "vip_level";
    }

    public static final class UserIdType
    extends Enum<UserIdType> {
        public static final /* enum */ UserIdType OTHER;
        public static final /* enum */ UserIdType PHONE_NUMBER;
        public static final /* enum */ UserIdType QQ;
        public static final /* enum */ UserIdType WEIBO;
        public static final /* enum */ UserIdType WEIXIN;
        public static final /* enum */ UserIdType XIAOMI;
        private static final /* synthetic */ UserIdType[] b;
        private String a;

        static {
            XIAOMI = new UserIdType("xiaomi");
            PHONE_NUMBER = new UserIdType("phone_number");
            WEIXIN = new UserIdType("weixin");
            WEIBO = new UserIdType("weibo");
            QQ = new UserIdType("qq");
            OTHER = new UserIdType("other");
            UserIdType[] arruserIdType = new UserIdType[]{XIAOMI, PHONE_NUMBER, WEIXIN, WEIBO, QQ, OTHER};
            b = arruserIdType;
        }

        private UserIdType(String string3) {
            this.a = string3;
        }

        public static UserIdType valueOf(String string2) {
            return (UserIdType)Enum.valueOf(UserIdType.class, (String)string2);
        }

        public static UserIdType[] values() {
            return (UserIdType[])b.clone();
        }

        public String getUserIdType() {
            return this.a;
        }
    }

}

