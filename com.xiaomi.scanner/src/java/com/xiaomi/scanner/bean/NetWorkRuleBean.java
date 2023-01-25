/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.scanner.bean;

import java.util.List;

public class NetWorkRuleBean {
    private List<DataBean> data;
    private String message;
    private int status;
    private int versionCode;

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMessage(String string2) {
        this.message = string2;
    }

    public void setStatus(int n2) {
        this.status = n2;
    }

    public void setVersionCode(int n2) {
        this.versionCode = n2;
    }

    public static class DataBean {
        private List<AppsBean> apps;
        private String id;
        private int type;
        private String validator;

        public List<AppsBean> getApps() {
            return this.apps;
        }

        public String getId() {
            return this.id;
        }

        public int getType() {
            return this.type;
        }

        public String getValidator() {
            return this.validator;
        }

        public void setApps(List<AppsBean> list) {
            this.apps = list;
        }

        public void setId(String string2) {
            this.id = string2;
        }

        public void setType(int n2) {
            this.type = n2;
        }

        public void setValidator(String string2) {
            this.validator = string2;
        }

        public static class AppsBean {
            private String appName;
            private String packageName;

            public String getAppName() {
                return this.appName;
            }

            public String getPackageName() {
                return this.packageName;
            }

            public void setAppName(String string2) {
                this.appName = string2;
            }

            public void setPackageName(String string2) {
                this.packageName = string2;
            }
        }

    }

}

