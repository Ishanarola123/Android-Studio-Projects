/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tencent.mm.opensdk.diffdev;

public final class OAuthErrCode
extends Enum<OAuthErrCode> {
    private static final /* synthetic */ OAuthErrCode[] $VALUES;
    public static final /* enum */ OAuthErrCode WechatAuth_Err_Auth_Stopped;
    public static final /* enum */ OAuthErrCode WechatAuth_Err_Cancel;
    public static final /* enum */ OAuthErrCode WechatAuth_Err_JsonDecodeErr;
    public static final /* enum */ OAuthErrCode WechatAuth_Err_NetworkErr;
    public static final /* enum */ OAuthErrCode WechatAuth_Err_NormalErr;
    public static final /* enum */ OAuthErrCode WechatAuth_Err_OK;
    public static final /* enum */ OAuthErrCode WechatAuth_Err_Timeout;
    private int code;

    static {
        WechatAuth_Err_OK = new OAuthErrCode(0);
        WechatAuth_Err_NormalErr = new OAuthErrCode(-1);
        WechatAuth_Err_NetworkErr = new OAuthErrCode(-2);
        WechatAuth_Err_JsonDecodeErr = new OAuthErrCode(-3);
        WechatAuth_Err_Cancel = new OAuthErrCode(-4);
        WechatAuth_Err_Timeout = new OAuthErrCode(-5);
        WechatAuth_Err_Auth_Stopped = new OAuthErrCode(-6);
        OAuthErrCode[] arroAuthErrCode = new OAuthErrCode[]{WechatAuth_Err_OK, WechatAuth_Err_NormalErr, WechatAuth_Err_NetworkErr, WechatAuth_Err_JsonDecodeErr, WechatAuth_Err_Cancel, WechatAuth_Err_Timeout, WechatAuth_Err_Auth_Stopped};
        $VALUES = arroAuthErrCode;
    }

    private OAuthErrCode(int n3) {
        this.code = n3;
    }

    public static OAuthErrCode valueOf(String string2) {
        return (OAuthErrCode)Enum.valueOf(OAuthErrCode.class, (String)string2);
    }

    public static OAuthErrCode[] values() {
        return (OAuthErrCode[])$VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("OAuthErrCode:");
        stringBuilder.append(this.code);
        return stringBuilder.toString();
    }
}

