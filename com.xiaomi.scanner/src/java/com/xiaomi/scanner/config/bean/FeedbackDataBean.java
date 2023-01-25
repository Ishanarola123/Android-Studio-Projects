/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.scanner.config.bean;

import java.util.List;

public class FeedbackDataBean {
    private String app_v;
    private String comment;
    private String contact;
    private List<String> imageList;
    private String m_v;
    private String mode;
    private String model;
    private String time;

    public String getApp_v() {
        return this.app_v;
    }

    public String getComment() {
        return this.comment;
    }

    public String getContact() {
        return this.contact;
    }

    public List<String> getImageList() {
        return this.imageList;
    }

    public String getM_v() {
        return this.m_v;
    }

    public String getMode() {
        return this.mode;
    }

    public String getModel() {
        return this.model;
    }

    public String getTime() {
        return this.time;
    }

    public void setApp_v(String string2) {
        this.app_v = string2;
    }

    public void setContact(String string2) {
        this.contact = string2;
    }

    public void setFeedbackContent(String string2) {
        this.comment = string2;
    }

    public void setImageList(List<String> list) {
        this.imageList = list;
    }

    public void setM_v(String string2) {
        this.m_v = string2;
    }

    public void setMode(String string2) {
        this.mode = string2;
    }

    public void setModel(String string2) {
        this.model = string2;
    }

    public void setTime(String string2) {
        this.time = string2;
    }
}

