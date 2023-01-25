/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.scanner.config.bean;

public class BaseRequestSuccessBean {
    private String message;
    private int status;

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setMessage(String string2) {
        this.message = string2;
    }

    public void setStatus(int n2) {
        this.status = n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BaseRequestSuccessBean{message='");
        stringBuilder.append(this.message);
        stringBuilder.append('\'');
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

