/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tencent.mm.opensdk.constants;

public final class Build {
    public static final int CHECK_TOKEN_SDK_INT = 620824064;
    public static final int CHOOSE_INVOICE_TILE_SUPPORT_SDK_INT = 620822528;
    public static final int EMOJI_SUPPORTED_SDK_INT = 553844737;
    public static final int FAVORITE_SUPPPORTED_SDK_INT = 570425345;
    public static final int INVOICE_AUTH_INSERT_SDK_INT = 620823552;
    public static final int LAUNCH_MINIPROGRAM_SUPPORTED_SDK_INT = 620757000;
    public static final int MESSAGE_ACTION_SUPPPORTED_SDK_INT = 570490883;
    public static final int MINIPROGRAM_SUPPORTED_SDK_INT = 620756993;
    public static final int MIN_SDK_INT = 553713665;
    public static final int MUSIC_DATA_URL_SUPPORTED_SDK_INT = 553910273;
    public static final int NON_TAX_PAY_SDK_INT = 620823552;
    public static final int OFFLINE_PAY_SDK_INT = 620823808;
    public static final int OPENID_SUPPORTED_SDK_INT = 570425345;
    public static final int OPEN_BUSINESS_WEBVIEW_SDK_INT = 620824064;
    public static final int PAY_INSURANCE_SDK_INT = 620823552;
    public static final int PAY_SUPPORTED_SDK_INT = 570425345;
    public static final int SCAN_QRCODE_AUTH_SUPPORTED_SDK_INT = 587268097;
    public static final int SDK_INT = 620824064;
    public static final String SDK_VERSION_NAME = "android 5.1.6";
    public static final int SEND_TO_SPECIFIED_CONTACT_SDK_INT = 620824064;
    public static final int SUBSCRIBE_MESSAGE_SUPPORTED_SDK_INT = 620756998;
    public static final int SUBSCRIBE_MINI_PROGRAM_MSG_SUPPORTED_SDK_INT = 620823808;
    public static final int TIMELINE_SUPPORTED_SDK_INT = 553779201;
    public static final int VIDEO_FILE_SUPPORTED_SDK_INT = 620756996;

    private Build() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(" should not be instantiated");
        throw new RuntimeException(stringBuilder.toString());
    }

    public static int getMajorVersion() {
        return 5;
    }

    public static int getMinorVersion() {
        return 1;
    }
}

