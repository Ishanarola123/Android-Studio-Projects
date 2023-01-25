/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.scanner.config.bean;

public class FunctionPointControlBean {
    private boolean alpha_enable;
    private boolean dev_enable;
    private int id;
    private boolean stable_enable;

    public int getId() {
        return this.id;
    }

    public boolean isAlpha_enable() {
        return this.alpha_enable;
    }

    public boolean isDev_enable() {
        return this.dev_enable;
    }

    public boolean isStable_enable() {
        return this.stable_enable;
    }

    public void setAlpha_enable(boolean bl) {
        this.alpha_enable = bl;
    }

    public void setDev_enable(boolean bl) {
        this.dev_enable = bl;
    }

    public void setId(int n2) {
        this.id = n2;
    }

    public void setStable_enable(boolean bl) {
        this.stable_enable = bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FunctionPointControlBean{dev_enable=");
        stringBuilder.append(this.dev_enable);
        stringBuilder.append(", alpha_enable=");
        stringBuilder.append(this.alpha_enable);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", stable_enable=");
        stringBuilder.append(this.stable_enable);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

