/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.twitter.sdk.android.core.a;

import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.o;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import com.twitter.sdk.android.core.a.c;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class d
implements k<c>,
s<c> {
    @Override
    public l a(c c2, Type type, r r2) {
        return null;
    }

    public c a(l l2, Type type, j j2) throws p {
        if (!l2.h()) {
            return new c();
        }
        Set<Map.Entry<String, l>> set = l2.k().o();
        HashMap hashMap = new HashMap(32);
        for (Map.Entry entry : set) {
            hashMap.put((Object)((String)entry.getKey()), this.a(((l)entry.getValue()).k(), j2));
        }
        return new c((Map<String, Object>)hashMap);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    Object a(o o2, j j2) {
        void var8_9;
        l l2;
        l l3 = o2.a("type");
        if (l3 == null) return null;
        if (!l3.i()) {
            return null;
        }
        String string = l3.b();
        int n2 = -1;
        int n3 = string.hashCode();
        if (n3 != -1838656495) {
            if (n3 != 2614219) {
                if (n3 != 69775675) {
                    if (n3 == 782694408 && string.equals((Object)"BOOLEAN")) {
                        n2 = 3;
                    }
                } else if (string.equals((Object)"IMAGE")) {
                    n2 = 1;
                }
            } else if (string.equals((Object)"USER")) {
                n2 = 2;
            }
        } else if (string.equals((Object)"STRING")) {
            n2 = 0;
        }
        switch (n2) {
            default: {
                return null;
            }
            case 3: {
                l2 = o2.a("boolean_value");
                return j2.a(l2, (Type)var8_9);
            }
            case 2: {
                l2 = o2.a("user_value");
                return j2.a(l2, (Type)var8_9);
            }
            case 1: {
                l2 = o2.a("image_value");
                return j2.a(l2, (Type)var8_9);
            }
            case 0: 
        }
        l2 = o2.a("string_value");
        return j2.a(l2, (Type)var8_9);
    }

    @Override
    public /* synthetic */ Object b(l l2, Type type, j j2) throws p {
        return this.a(l2, type, j2);
    }
}

