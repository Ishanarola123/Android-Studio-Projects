/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.e;

import com.xiaomi.onetrack.b.f;
import com.xiaomi.onetrack.f.b;
import com.xiaomi.onetrack.h.o;
import org.json.JSONObject;

public class a
extends b {
    private static final String d = "CustomEvent";

    public a(String string, String string2, String string3, String string4) {
        try {
            this.a(string);
            this.c(string3);
            this.b(string2);
            this.b(System.currentTimeMillis());
            this.a(new JSONObject(string4));
            this.a(f.a().a(string, string3, "level", 1));
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CustomEvent error:");
            stringBuilder.append(exception.toString());
            o.b(d, stringBuilder.toString());
            return;
        }
    }
}

