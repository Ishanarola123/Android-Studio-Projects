/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.google.a;

import com.google.a.b.g;
import com.google.a.l;
import com.google.a.n;
import com.google.a.q;
import java.util.Map;
import java.util.Set;

public final class o
extends l {
    private final g<String, l> a = new g();

    private l a(Object object) {
        if (object == null) {
            return n.a;
        }
        return new q(object);
    }

    public l a(String string) {
        return this.a.get(string);
    }

    public void a(String string, l l2) {
        if (l2 == null) {
            l2 = n.a;
        }
        this.a.put(string, l2);
    }

    public void a(String string, String string2) {
        this.a(string, this.a((Object)string2));
    }

    public q b(String string) {
        return (q)this.a.get(string);
    }

    public boolean equals(Object object) {
        return object == this || object instanceof o && ((o)object).a.equals(this.a);
        {
        }
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Set<Map.Entry<String, l>> o() {
        return this.a.entrySet();
    }
}

