/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;

public class PayReq
extends BaseReq {
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final String TAG = "MicroMsg.PaySdk.PayReq";
    public String appId;
    public String extData;
    public String nonceStr;
    public Options options;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String sign;
    public String signType;
    public String timeStamp;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean checkArgs() {
        String string;
        String string2 = this.appId;
        if (string2 != null && string2.length() != 0) {
            String string3 = this.partnerId;
            if (string3 != null && string3.length() != 0) {
                String string4 = this.prepayId;
                if (string4 != null && string4.length() != 0) {
                    String string5 = this.nonceStr;
                    if (string5 != null && string5.length() != 0) {
                        String string6 = this.timeStamp;
                        if (string6 != null && string6.length() != 0) {
                            String string7 = this.packageValue;
                            if (string7 != null && string7.length() != 0) {
                                String string8 = this.sign;
                                if (string8 != null && string8.length() != 0) {
                                    String string9 = this.extData;
                                    if (string9 == null) return true;
                                    if (string9.length() <= 1024) return true;
                                    string = "checkArgs fail, extData length too long";
                                } else {
                                    string = "checkArgs fail, invalid sign";
                                }
                            } else {
                                string = "checkArgs fail, invalid packageValue";
                            }
                        } else {
                            string = "checkArgs fail, invalid timeStamp";
                        }
                    } else {
                        string = "checkArgs fail, invalid nonceStr";
                    }
                } else {
                    string = "checkArgs fail, invalid prepayId";
                }
            } else {
                string = "checkArgs fail, invalid partnerId";
            }
        } else {
            string = "checkArgs fail, invalid appId";
        }
        Log.e(TAG, string);
        return false;
    }

    @Override
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.appId = a.b(bundle, "_wxapi_payreq_appid");
        this.partnerId = a.b(bundle, "_wxapi_payreq_partnerid");
        this.prepayId = a.b(bundle, "_wxapi_payreq_prepayid");
        this.nonceStr = a.b(bundle, "_wxapi_payreq_noncestr");
        this.timeStamp = a.b(bundle, "_wxapi_payreq_timestamp");
        this.packageValue = a.b(bundle, "_wxapi_payreq_packagevalue");
        this.sign = a.b(bundle, "_wxapi_payreq_sign");
        this.extData = a.b(bundle, "_wxapi_payreq_extdata");
        this.signType = a.b(bundle, "_wxapi_payreq_sign_type");
        this.options = new Object(){
            public static final int INVALID_FLAGS = -1;
            public String callbackClassName;
            public int callbackFlags = -1;

            public void fromBundle(Bundle bundle) {
                this.callbackClassName = a.b(bundle, "_wxapi_payoptions_callback_classname");
                this.callbackFlags = a.a(bundle, "_wxapi_payoptions_callback_flags");
            }

            public void toBundle(Bundle bundle) {
                bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
                bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
            }
        };
        this.options.fromBundle(bundle);
    }

    @Override
    public int getType() {
        return 5;
    }

    @Override
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payreq_appid", this.appId);
        bundle.putString("_wxapi_payreq_partnerid", this.partnerId);
        bundle.putString("_wxapi_payreq_prepayid", this.prepayId);
        bundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
        bundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
        bundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
        bundle.putString("_wxapi_payreq_sign", this.sign);
        bundle.putString("_wxapi_payreq_extdata", this.extData);
        bundle.putString("_wxapi_payreq_sign_type", this.signType);
        Options options = this.options;
        if (options != null) {
            options.toBundle(bundle);
        }
    }

}

