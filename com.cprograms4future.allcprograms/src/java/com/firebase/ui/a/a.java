/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.firebase.a.a
 *  com.google.firebase.a.b
 *  com.google.firebase.a.c
 *  com.google.firebase.a.l
 *  com.google.firebase.a.o
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.firebase.ui.a;

import com.google.firebase.a.b;
import com.google.firebase.a.c;
import com.google.firebase.a.l;
import com.google.firebase.a.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class a
implements com.google.firebase.a.a,
o {
    private l a;
    private a b;
    private List<b> c = new ArrayList();

    public a(l l2) {
        this.a = l2;
        this.a.a((com.google.firebase.a.a)this);
        this.a.a((o)this);
    }

    private int a(String string) {
        Iterator iterator = this.c.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            if (((b)iterator.next()).b().equals((Object)string)) {
                return n2;
            }
            ++n2;
        }
        throw new IllegalArgumentException("Key not found");
    }

    public b a(int n2) {
        return (b)this.c.get(n2);
    }

    public void a() {
        this.a.b((o)this);
        this.a.b((com.google.firebase.a.a)this);
    }

    protected void a(a a2, int n2) {
        this.a(a2, n2, -1);
    }

    protected void a(a a2, int n2, int n3) {
        if (this.b != null) {
            this.b.a(a2, n2, n3);
        }
    }

    public void a(a a2) {
        this.b = a2;
    }

    public void a(b b2) {
        int n2 = this.a(b2.b());
        this.c.remove(n2);
        this.a(a.c, n2);
    }

    public void a(b b2, String string) {
        int n2 = string != null ? 1 + this.a(string) : 0;
        this.c.add(n2, (Object)b2);
        this.a(a.a, n2);
    }

    public void a(c c2) {
        this.b(c2);
    }

    public int b() {
        return this.c.size();
    }

    public void b(b b2) {
        this.b.a();
    }

    public void b(b b2, String string) {
        int n2 = this.a(b2.b());
        this.c.set(n2, (Object)b2);
        this.a(a.b, n2);
    }

    protected void b(c c2) {
        if (this.b != null) {
            this.b.a(c2);
        }
    }

    public void c(b b2, String string) {
        int n2 = this.a(b2.b());
        this.c.remove(n2);
        int n3 = string == null ? 0 : 1 + this.a(string);
        this.c.add(n3, (Object)b2);
        this.a(a.d, n3, n2);
    }

}

