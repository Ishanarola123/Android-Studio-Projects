/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.a
 *  com.google.a.b.d
 *  com.google.a.d
 *  com.google.a.u
 *  com.google.a.v
 *  com.google.a.w
 *  com.google.a.x
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.sql.Date
 *  java.sql.Timestamp
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.google.a;

import com.google.a.b.a.m;
import com.google.a.b.d;
import com.google.a.c.a;
import com.google.a.e;
import com.google.a.f;
import com.google.a.h;
import com.google.a.k;
import com.google.a.s;
import com.google.a.u;
import com.google.a.v;
import com.google.a.w;
import com.google.a.x;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {
    private d a = d.a;
    private u b = u.a;
    private e c = com.google.a.d.a;
    private final Map<Type, h<?>> d = new HashMap();
    private final List<x> e = new ArrayList();
    private final List<x> f = new ArrayList();
    private boolean g = false;
    private String h;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    private void a(String string, int n2, int n3, List<x> list) {
        block4 : {
            com.google.a.a a2;
            block3 : {
                block2 : {
                    if (string == null || "".equals((Object)string.trim())) break block2;
                    a2 = new com.google.a.a(string);
                    break block3;
                }
                if (n2 == 2 || n3 == 2) break block4;
                a2 = new com.google.a.a(n2, n3);
            }
            list.add((Object)v.a(a.b(java.util.Date.class), (Object)a2));
            list.add((Object)v.a(a.b(Timestamp.class), (Object)a2));
            list.add((Object)v.a(a.b(Date.class), (Object)a2));
        }
    }

    public f a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.e);
        Collections.reverse((List)arrayList);
        arrayList.addAll(this.f);
        this.a(this.h, this.i, this.j, (List<x>)arrayList);
        f f2 = new f(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.b, (List<x>)arrayList);
        return f2;
    }

    public g a(com.google.a.d d2) {
        this.c = d2;
        return this;
    }

    public g a(x x2) {
        this.e.add((Object)x2);
        return this;
    }

    public g a(Type type, Object object) {
        boolean bl = object instanceof s;
        boolean bl2 = bl || object instanceof k || object instanceof h || object instanceof w;
        com.google.a.b.a.a(bl2);
        if (object instanceof h) {
            this.d.put((Object)type, (Object)((h)object));
        }
        if (bl || object instanceof k) {
            a<?> a2 = a.a(type);
            this.e.add((Object)v.b(a2, (Object)object));
        }
        if (object instanceof w) {
            this.e.add((Object)m.a(a.a(type), (w)object));
        }
        return this;
    }
}

