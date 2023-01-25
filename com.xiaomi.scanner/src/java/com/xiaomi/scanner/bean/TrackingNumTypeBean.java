/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.scanner.bean;

public class TrackingNumTypeBean {
    private DataBean data;
    private String message;
    private int status;
    private String type;

    public DataBean getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public String getType() {
        return this.type;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMessage(String string2) {
        this.message = string2;
    }

    public void setStatus(int n2) {
        this.status = n2;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public static class DataBean {
    }

}

