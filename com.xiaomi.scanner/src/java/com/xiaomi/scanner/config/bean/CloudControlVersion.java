/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.scanner.config.bean;

import com.google.gson.annotations.SerializedName;

public class CloudControlVersion {
    @SerializedName(value="barcode_rough_rule.json")
    private String _$Barcode_rough_ruleJson284;
    @SerializedName(value="special_qr_rule.json")
    private String _$Special_qr_ruleJson284;
    private String cloud_control_config_all;
    private String scan_payment_rule;

    public String getCloud_control_config_all() {
        return this.cloud_control_config_all;
    }

    public String getScan_payment_rule() {
        return this.scan_payment_rule;
    }

    public String get_$Barcode_rough_ruleJson284() {
        return this._$Barcode_rough_ruleJson284;
    }

    public String get_$Special_qr_ruleJson284() {
        return this._$Special_qr_ruleJson284;
    }

    public void setCloud_control_config_all(String string2) {
        this.cloud_control_config_all = string2;
    }

    public void setScan_payment_rule(String string2) {
        this.scan_payment_rule = string2;
    }

    public void set_$Barcode_rough_ruleJson284(String string2) {
        this._$Barcode_rough_ruleJson284 = string2;
    }

    public void set_$Special_qr_ruleJson284(String string2) {
        this._$Special_qr_ruleJson284 = string2;
    }
}

