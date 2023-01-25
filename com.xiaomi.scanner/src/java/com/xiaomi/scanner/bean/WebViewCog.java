/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.xiaomi.scanner.bean;

import java.io.Serializable;
import java.util.List;

public class WebViewCog
implements Serializable {
    private List<ListEntity> list;
    private String openType;

    public List<ListEntity> getList() {
        return this.list;
    }

    public String getOpenType() {
        return this.openType;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public void setOpenType(String string2) {
        this.openType = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WebViewCog{list=");
        stringBuilder.append(this.list);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public class ListEntity
    implements Serializable {
        private String urlStr;

        public String getUrlStr() {
            return this.urlStr;
        }

        public void setUrlStr(String string2) {
            this.urlStr = string2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ListEntity{urlStr='");
            stringBuilder.append(this.urlStr);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

}

