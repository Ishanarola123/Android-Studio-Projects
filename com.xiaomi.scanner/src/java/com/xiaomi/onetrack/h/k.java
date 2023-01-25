/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.LruCache
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.h;

import android.text.TextUtils;
import android.util.LruCache;
import com.xiaomi.onetrack.h.j;

final class k
extends LruCache<String, j.a> {
    k(int n2) {
        super(n2);
    }

    protected int a(String string2, j.a a2) {
        if (a2 != null && !TextUtils.isEmpty((CharSequence)a2.a)) {
            return a2.a.length();
        }
        return 0;
    }

    protected /* synthetic */ int sizeOf(Object object, Object object2) {
        return this.a((String)object, (j.a)object2);
    }
}

