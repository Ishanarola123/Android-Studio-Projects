/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.b;

import org.json.JSONObject;

public class j {
    public String a;
    public long b;
    public String c;
    public JSONObject d;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConfigModel{appId='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", timeStamp=");
        stringBuilder.append(this.b);
        stringBuilder.append(", eventsHash='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", events='");
        stringBuilder.append((Object)this.d);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

