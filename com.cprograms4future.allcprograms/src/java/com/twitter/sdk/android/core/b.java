/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.twitter.sdk.android.core;

import com.google.a.f;
import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.o;
import com.google.a.q;
import com.google.a.r;
import com.google.a.s;
import com.twitter.sdk.android.core.a;
import com.twitter.sdk.android.core.internal.oauth.e;
import com.twitter.sdk.android.core.p;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class b
implements k<a>,
s<a> {
    static final Map<String, Class<? extends a>> a = new HashMap();
    private final f b = new f();

    static {
        a.put((Object)"oauth1a", p.class);
        a.put((Object)"oauth2", e.class);
        a.put((Object)"guest", com.twitter.sdk.android.core.internal.oauth.a.class);
    }

    static String a(Class<? extends a> class_) {
        for (Map.Entry entry : a.entrySet()) {
            if (!((Class)entry.getValue()).equals(class_)) continue;
            return (String)entry.getKey();
        }
        return "";
    }

    @Override
    public l a(a a2, Type type, r r2) {
        o o2 = new o();
        o2.a("auth_type", b.a((Class<? extends a>)a2.getClass()));
        o2.a("auth_token", this.b.a(a2));
        return o2;
    }

    public a a(l l2, Type type, j j2) throws com.google.a.p {
        o o2 = l2.k();
        String string = o2.b("auth_type").b();
        l l3 = o2.a("auth_token");
        return (a)this.b.a(l3, (Class)a.get((Object)string));
    }

    @Override
    public /* synthetic */ Object b(l l2, Type type, j j2) throws com.google.a.p {
        return this.a(l2, type, j2);
    }
}

