/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.scanner.bean;

public class ItemCHooseOpenCodeListBean {
    private String appName;
    private boolean isChecked = false;
    private String packageName;

    public ItemCHooseOpenCodeListBean(String string2, String string3) {
        this.appName = string2;
        this.packageName = string3;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setAppName(String string2) {
        this.appName = string2;
    }

    public void setChecked(boolean bl) {
        this.isChecked = bl;
    }

    public void setPackageName(String string2) {
        this.packageName = string2;
    }
}

