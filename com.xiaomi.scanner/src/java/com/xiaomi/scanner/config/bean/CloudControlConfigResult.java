/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.scanner.config.bean.OtherSetEntity
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.xiaomi.scanner.config.bean;

import com.xiaomi.scanner.config.bean.FunctionPointCloudControlBaseBean;
import com.xiaomi.scanner.config.bean.OtherSetEntity;
import java.util.List;

public class CloudControlConfigResult {
    private FunctionPointCloudControlBaseBean defaultSet;
    private List<OtherSetEntity> otherSet;
    private int version;

    public FunctionPointCloudControlBaseBean getDefaultSet() {
        return this.defaultSet;
    }

    public List<OtherSetEntity> getOtherSet() {
        return this.otherSet;
    }

    public int getVersion() {
        return this.version;
    }

    public void setDefaultSet(FunctionPointCloudControlBaseBean functionPointCloudControlBaseBean) {
        this.defaultSet = functionPointCloudControlBaseBean;
    }

    public void setOtherSet(List<OtherSetEntity> list) {
        this.otherSet = list;
    }

    public void setVersion(int n2) {
        this.version = n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CloudControlConfigResult{defaultSet=");
        stringBuilder.append((Object)this.defaultSet);
        stringBuilder.append(", otherSet=");
        stringBuilder.append(this.otherSet);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

