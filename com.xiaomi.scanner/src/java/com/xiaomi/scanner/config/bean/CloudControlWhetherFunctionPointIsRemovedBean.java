/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.xiaomi.scanner.config.bean;

import com.xiaomi.scanner.config.bean.OneFunctionIsRemovedBean;
import java.util.List;

public class CloudControlWhetherFunctionPointIsRemovedBean {
    private List<OneFunctionIsRemovedBean> homeFunctionPointsIsRemoveList;
    private String mobilePhone3dModelLinkAddress = "";
    private String reset_auto_focus_delay_millis = "";
    private String scanMiLogoThreshold = "";

    public List<OneFunctionIsRemovedBean> getHomeFunctionPointsIsRemoveList() {
        return this.homeFunctionPointsIsRemoveList;
    }

    public String getMobilePhone3dModelLinkAddress() {
        return this.mobilePhone3dModelLinkAddress;
    }

    public String getReset_auto_focus_delay_millis() {
        return this.reset_auto_focus_delay_millis;
    }

    public String getScanMiLogoThreshold() {
        return this.scanMiLogoThreshold;
    }

    public void setHomeFunctionPointsIsRemoveList(List<OneFunctionIsRemovedBean> list) {
        this.homeFunctionPointsIsRemoveList = list;
    }

    public void setMobilePhone3dModelLinkAddress(String string2) {
        this.mobilePhone3dModelLinkAddress = string2;
    }

    public void setReset_auto_focus_delay_millis(String string2) {
        this.reset_auto_focus_delay_millis = string2;
    }

    public void setScanMiLogoThreshold(String string2) {
        this.scanMiLogoThreshold = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CloudControlWhetherFunctionPointIsRemovedBean{homeFunctionPointsIsRemoveList=");
        stringBuilder.append(this.homeFunctionPointsIsRemoveList);
        stringBuilder.append(", mobilePhone3dModelLinkAddress='");
        stringBuilder.append(this.mobilePhone3dModelLinkAddress);
        stringBuilder.append('\'');
        stringBuilder.append(", scanMiLogoThreshold='");
        stringBuilder.append(this.scanMiLogoThreshold);
        stringBuilder.append('\'');
        stringBuilder.append(", reset_auto_focus_delay_millis='");
        stringBuilder.append(this.reset_auto_focus_delay_millis);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

