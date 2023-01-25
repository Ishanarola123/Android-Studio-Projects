/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.scanner.bean;

public class TrackingNumBean {
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
        private String com;
        private String context;
        private Object data;
        private String detailUrl;
        private String icon;
        private String message;
        private String name;
        private String nu;
        private String state;
        private String stateImg;
        private String stateName;
        private String status;
        private String tel;
        private String time;
        private String url;

        public String getCom() {
            return this.com;
        }

        public String getContext() {
            return this.context;
        }

        public Object getData() {
            return this.data;
        }

        public String getDetailUrl() {
            return this.detailUrl;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getNu() {
            return this.nu;
        }

        public String getState() {
            return this.state;
        }

        public String getStateImg() {
            return this.stateImg;
        }

        public String getStateName() {
            return this.stateName;
        }

        public String getStatus() {
            return this.status;
        }

        public String getTel() {
            return this.tel;
        }

        public String getTime() {
            return this.time;
        }

        public String getUrl() {
            return this.url;
        }

        public void setCom(String string2) {
            this.com = string2;
        }

        public void setContext(String string2) {
            this.context = string2;
        }

        public void setData(Object object) {
            this.data = object;
        }

        public void setDetailUrl(String string2) {
            this.detailUrl = string2;
        }

        public void setIcon(String string2) {
            this.icon = string2;
        }

        public void setMessage(String string2) {
            this.message = string2;
        }

        public void setName(String string2) {
            this.name = string2;
        }

        public void setNu(String string2) {
            this.nu = string2;
        }

        public void setState(String string2) {
            this.state = string2;
        }

        public void setStateImg(String string2) {
            this.stateImg = string2;
        }

        public void setStateName(String string2) {
            this.stateName = string2;
        }

        public void setStatus(String string2) {
            this.status = string2;
        }

        public void setTel(String string2) {
            this.tel = string2;
        }

        public void setTime(String string2) {
            this.time = string2;
        }

        public void setUrl(String string2) {
            this.url = string2;
        }
    }

}

