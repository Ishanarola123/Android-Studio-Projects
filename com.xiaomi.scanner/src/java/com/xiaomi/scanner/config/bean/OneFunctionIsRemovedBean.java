/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.scanner.config.bean;

public class OneFunctionIsRemovedBean {
    private Boolean functionIsRemoved = false;
    private String functionName;

    public Boolean getFunctionIsRemoved() {
        return this.functionIsRemoved;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setFunctionIsRemoved(Boolean bl) {
        this.functionIsRemoved = bl;
    }

    public void setFunctionName(String string2) {
        this.functionName = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OneFunctionIsRemovedBean{functionName='");
        stringBuilder.append(this.functionName);
        stringBuilder.append('\'');
        stringBuilder.append(", functionIsRemoved=");
        stringBuilder.append((Object)this.functionIsRemoved);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

