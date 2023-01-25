/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Map
 */
package com.twitter.sdk.android.core.a;

import java.util.Collections;
import java.util.Map;

public class c {
    private final Map<String, Object> a;

    public c() {
        this((Map<String, Object>)Collections.EMPTY_MAP);
    }

    public c(Map<String, Object> map) {
        this.a = Collections.unmodifiableMap(map);
    }

    public <T> T a(String string) {
        Object object;
        try {
            object = this.a.get((Object)string);
        }
        catch (ClassCastException classCastException) {
            return null;
        }
        return (T)object;
    }
}

