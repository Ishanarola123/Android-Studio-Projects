/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Type
 */
package com.twitter.sdk.android.core;

import a.a.a.a.a.f.e;
import a.a.a.a.c;
import a.a.a.a.l;
import android.text.TextUtils;
import com.google.a.f;
import com.google.a.g;
import com.twitter.sdk.android.core.b;
import com.twitter.sdk.android.core.j;
import java.lang.reflect.Type;

public class d
extends j<com.twitter.sdk.android.core.internal.oauth.a> {
    public d(com.twitter.sdk.android.core.internal.oauth.a a2) {
        super(a2, 0L);
    }

    public static class a
    implements e<d> {
        private final f a = new g().a((Type)com.twitter.sdk.android.core.internal.oauth.a.class, new b()).a();

        public d a(String string) {
            if (!TextUtils.isEmpty((CharSequence)string)) {
                try {
                    d d2 = this.a.a(string, d.class);
                    return d2;
                }
                catch (Exception exception) {
                    l l2 = c.h();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to deserialize session ");
                    stringBuilder.append(exception.getMessage());
                    l2.a("Twitter", stringBuilder.toString());
                }
            }
            return null;
        }

        @Override
        public String a(d d2) {
            if (d2 != null && d2.a() != null) {
                try {
                    String string = this.a.b(d2);
                    return string;
                }
                catch (Exception exception) {
                    l l2 = c.h();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to serialize session ");
                    stringBuilder.append(exception.getMessage());
                    l2.a("Twitter", stringBuilder.toString());
                }
            }
            return "";
        }

        @Override
        public /* synthetic */ Object b(String string) {
            return this.a(string);
        }
    }

}

