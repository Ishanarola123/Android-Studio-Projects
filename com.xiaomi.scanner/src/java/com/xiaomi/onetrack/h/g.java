/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Comparator
 */
package com.xiaomi.onetrack.h;

import java.util.Comparator;

final class g
implements Comparator<String> {
    g() {
    }

    public int a(String string2, String string3) {
        return string2.compareToIgnoreCase(string3);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((String)object, (String)object2);
    }
}

