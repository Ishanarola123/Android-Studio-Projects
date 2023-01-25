/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.List
 */
package com.twitter.sdk.android.core.internal.scribe;

import android.text.TextUtils;
import com.twitter.sdk.android.core.internal.scribe.c;
import com.twitter.sdk.android.core.internal.scribe.j;
import java.util.Collections;
import java.util.List;

public class f {
    @com.google.a.a.c(a="event_namespace")
    final c a;
    @com.google.a.a.c(a="ts")
    final String b;
    @com.google.a.a.c(a="format_version")
    final String c;
    @com.google.a.a.c(a="_category_")
    final String d;
    @com.google.a.a.c(a="items")
    final List<j> e;

    public f(String string, c c2, long l2, List<j> list) {
        this.d = string;
        this.a = c2;
        this.b = String.valueOf((long)l2);
        this.c = "2";
        this.e = Collections.unmodifiableList(list);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            f f2 = (f)object;
            if (this.d != null ? !this.d.equals((Object)f2.d) : f2.d != null) {
                return false;
            }
            if (this.a != null ? !this.a.equals(f2.a) : f2.a != null) {
                return false;
            }
            if (this.c != null ? !this.c.equals((Object)f2.c) : f2.c != null) {
                return false;
            }
            if (this.b != null ? !this.b.equals((Object)f2.b) : f2.b != null) {
                return false;
            }
            return !(this.e != null ? !this.e.equals(f2.e) : f2.e != null);
        }
        return false;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        int n3 = n2 * 31;
        int n4 = this.b != null ? this.b.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        int n6 = this.c != null ? this.c.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        int n8 = this.d != null ? this.d.hashCode() : 0;
        int n9 = 31 * (n7 + n8);
        List<j> list = this.e;
        int n10 = 0;
        if (list != null) {
            n10 = this.e.hashCode();
        }
        return n9 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("event_namespace=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", ts=");
        stringBuilder.append(this.b);
        stringBuilder.append(", format_version=");
        stringBuilder.append(this.c);
        stringBuilder.append(", _category_=");
        stringBuilder.append(this.d);
        stringBuilder.append(", items=");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[");
        stringBuilder2.append(TextUtils.join((CharSequence)", ", this.e));
        stringBuilder2.append("]");
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
    }
}

