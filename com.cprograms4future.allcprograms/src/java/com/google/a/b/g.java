/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.b.g$a$1
 *  com.google.a.b.g$b$1
 *  java.io.ObjectStreamException
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Comparable
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.AbstractMap
 *  java.util.AbstractSet
 *  java.util.Comparator
 *  java.util.ConcurrentModificationException
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package com.google.a.b;

import com.google.a.b.g;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class g<K, V>
extends AbstractMap<K, V>
implements Serializable {
    static final /* synthetic */ boolean f;
    private static final Comparator<Comparable> g;
    Comparator<? super K> a;
    d<K, V> b;
    int c = 0;
    int d = 0;
    final d<K, V> e = new d();
    private g<K, V> h;
    private g<K, V> i;

    static {
        f = true ^ g.class.desiredAssertionStatus();
        g = new Comparator<Comparable>(){

            public int a(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo((Object)comparable2);
            }

            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((Comparable)object, (Comparable)object2);
            }
        };
    }

    public g() {
        this(g);
    }

    public g(Comparator<? super K> comparator) {
        if (comparator == null) {
            comparator = g;
        }
        this.a = comparator;
    }

    private void a(d<K, V> d2) {
        d d3 = d2.b;
        d d4 = d2.c;
        d d5 = d4.b;
        d d6 = d4.c;
        d2.c = d5;
        if (d5 != null) {
            d5.a = d2;
        }
        this.a(d2, d4);
        d4.b = d2;
        d2.a = d4;
        int n2 = d3 != null ? d3.h : 0;
        int n3 = d5 != null ? d5.h : 0;
        int n4 = d2.h = 1 + Math.max((int)n2, (int)n3);
        int n5 = 0;
        if (d6 != null) {
            n5 = d6.h;
        }
        d4.h = 1 + Math.max((int)n4, (int)n5);
    }

    private void a(d<K, V> d2, d<K, V> d3) {
        d d4 = d2.a;
        d2.a = null;
        if (d3 != null) {
            d3.a = d4;
        }
        if (d4 != null) {
            if (d4.b == d2) {
                d4.b = d3;
                return;
            }
            if (!f && d4.c != d2) {
                throw new AssertionError();
            }
            d4.c = d3;
            return;
        }
        this.b = d3;
    }

    private boolean a(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    private void b(d<K, V> d2) {
        d d3 = d2.b;
        d d4 = d2.c;
        d d5 = d3.b;
        d d6 = d3.c;
        d2.b = d6;
        if (d6 != null) {
            d6.a = d2;
        }
        this.a(d2, d3);
        d3.c = d2;
        d2.a = d3;
        int n2 = d4 != null ? d4.h : 0;
        int n3 = d6 != null ? d6.h : 0;
        int n4 = d2.h = 1 + Math.max((int)n2, (int)n3);
        int n5 = 0;
        if (d5 != null) {
            n5 = d5.h;
        }
        d3.h = 1 + Math.max((int)n4, (int)n5);
    }

    private void b(d<K, V> d2, boolean bl) {
        while (d2 != null) {
            int n2;
            d d3;
            d d4 = d2.b;
            int n3 = d4 != null ? d4.h : 0;
            int n4 = n3 - (n2 = (d3 = d2.c) != null ? d3.h : 0);
            if (n4 == -2) {
                int n5;
                d d5 = d3.b;
                d d6 = d3.c;
                int n6 = d6 != null ? d6.h : 0;
                int n7 = 0;
                if (d5 != null) {
                    n7 = d5.h;
                }
                if ((n5 = n7 - n6) != -1 && (n5 != 0 || bl)) {
                    if (!f && n5 != 1) {
                        throw new AssertionError();
                    }
                    this.b(d3);
                }
                this.a(d2);
                if (bl) {
                    return;
                }
            } else if (n4 == 2) {
                int n8;
                d d7 = d4.b;
                d d8 = d4.c;
                int n9 = d8 != null ? d8.h : 0;
                int n10 = 0;
                if (d7 != null) {
                    n10 = d7.h;
                }
                if ((n8 = n10 - n9) != 1 && (n8 != 0 || bl)) {
                    if (!f && n8 != -1) {
                        throw new AssertionError();
                    }
                    this.a(d4);
                }
                this.b(d2);
                if (bl) {
                    return;
                }
            } else if (n4 == 0) {
                d2.h = n3 + 1;
                if (bl) {
                    return;
                }
            } else {
                if (!f && n4 != -1 && n4 != 1) {
                    throw new AssertionError();
                }
                d2.h = 1 + Math.max((int)n3, (int)n2);
                if (!bl) {
                    return;
                }
            }
            d2 = d2.a;
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap((Map)this);
    }

    d<K, V> a(Object object) {
        if (object != null) {
            try {
                d<Object, V> d2 = this.a((K)object, false);
                return d2;
            }
            catch (ClassCastException classCastException) {
                return null;
            }
        }
        return null;
    }

    d<K, V> a(K k2, boolean bl) {
        int n2;
        d<K, V> d2;
        Comparator<? super K> comparator = this.a;
        d<K, V> d3 = this.b;
        if (d3 != null) {
            Comparable comparable = comparator == g ? (Comparable)k2 : null;
            do {
                if ((n2 = comparable != null ? comparable.compareTo(d3.f) : comparator.compare(k2, d3.f)) == 0) {
                    return d3;
                }
                d d4 = n2 < 0 ? d3.b : d3.c;
                if (d4 != null) {
                    d3 = d4;
                    continue;
                }
                break;
            } while (true);
        } else {
            n2 = 0;
        }
        if (!bl) {
            return null;
        }
        d<K, V> d5 = this.e;
        if (d3 == null) {
            if (comparator == g && !(k2 instanceof Comparable)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(k2.getClass().getName());
                stringBuilder.append(" is not Comparable");
                throw new ClassCastException(stringBuilder.toString());
            }
            d2 = new d<K, V>(d3, k2, d5, d5.e);
            this.b = d2;
        } else {
            d2 = new d<K, V>(d3, k2, d5, d5.e);
            if (n2 < 0) {
                d3.b = d2;
            } else {
                d3.c = d2;
            }
            this.b(d3, true);
        }
        this.c = 1 + this.c;
        this.d = 1 + this.d;
        return d2;
    }

    d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> d2 = this.a(entry.getKey());
        boolean bl = d2 != null && this.a(d2.g, entry.getValue());
        if (bl) {
            return d2;
        }
        return null;
    }

    void a(d<K, V> d2, boolean bl) {
        if (bl) {
            d2.e.d = d2.d;
            d2.d.e = d2.e;
        }
        d d3 = d2.b;
        d d4 = d2.c;
        d d5 = d2.a;
        if (d3 != null && d4 != null) {
            int n2;
            d d6 = d3.h > d4.h ? d3.b() : d4.a();
            this.a((d<K, V>)d6, false);
            d d7 = d2.b;
            if (d7 != null) {
                n2 = d7.h;
                d6.b = d7;
                d7.a = d6;
                d2.b = null;
            } else {
                n2 = 0;
            }
            d d8 = d2.c;
            int n3 = 0;
            if (d8 != null) {
                n3 = d8.h;
                d6.c = d8;
                d8.a = d6;
                d2.c = null;
            }
            d6.h = 1 + Math.max((int)n2, (int)n3);
            this.a(d2, d6);
            return;
        }
        if (d3 != null) {
            this.a(d2, d3);
            d2.b = null;
        } else if (d4 != null) {
            this.a(d2, d4);
            d2.c = null;
        } else {
            this.a(d2, null);
        }
        this.b(d5, false);
        this.c = -1 + this.c;
        this.d = 1 + this.d;
    }

    d<K, V> b(Object object) {
        d<K, V> d2 = this.a(object);
        if (d2 != null) {
            this.a(d2, true);
        }
        return d2;
    }

    public void clear() {
        this.b = null;
        this.c = 0;
        this.d = 1 + this.d;
        d<K, V> d2 = this.e;
        d2.e = d2;
        d2.d = d2;
    }

    public boolean containsKey(Object object) {
        return this.a(object) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V> g2 = this.h;
        if (g2 != null) {
            return g2;
        }
        a a2 = new a();
        this.h = a2;
        return a2;
    }

    public V get(Object object) {
        d<K, V> d2 = this.a(object);
        if (d2 != null) {
            return d2.g;
        }
        return null;
    }

    public Set<K> keySet() {
        g<K, V> g2 = this.i;
        if (g2 != null) {
            return g2;
        }
        b b2 = new b();
        this.i = b2;
        return b2;
    }

    public V put(K k2, V v2) {
        if (k2 != null) {
            d<K, V> d2 = this.a(k2, true);
            Object v3 = d2.g;
            d2.g = v2;
            return v3;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object object) {
        d<K, V> d2 = this.b(object);
        if (d2 != null) {
            return d2.g;
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    class a
    extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        public void clear() {
            g.this.clear();
        }

        public boolean contains(Object object) {
            return object instanceof Map.Entry && g.this.a((Map.Entry)object) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new 1(this);
        }

        public boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            d d2 = g.this.a((Map.Entry)object);
            if (d2 == null) {
                return false;
            }
            g.this.a(d2, true);
            return true;
        }

        public int size() {
            return g.this.c;
        }
    }

    final class b
    extends AbstractSet<K> {
        b() {
        }

        public void clear() {
            g.this.clear();
        }

        public boolean contains(Object object) {
            return g.this.containsKey(object);
        }

        public Iterator<K> iterator() {
            return new 1(this);
        }

        public boolean remove(Object object) {
            return g.this.b(object) != null;
        }

        public int size() {
            return g.this.c;
        }
    }

    private abstract class c<T>
    implements Iterator<T> {
        d<K, V> b;
        d<K, V> c;
        int d;

        c() {
            this.b = g.this.e.d;
            this.c = null;
            this.d = g.this.d;
        }

        final d<K, V> b() {
            d<K, V> d2 = this.b;
            if (d2 != g.this.e) {
                if (g.this.d == this.d) {
                    this.b = d2.d;
                    this.c = d2;
                    return d2;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        public final boolean hasNext() {
            return this.b != g.this.e;
        }

        public final void remove() {
            if (this.c != null) {
                g.this.a(this.c, true);
                this.c = null;
                this.d = g.this.d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static final class d<K, V>
    implements Map.Entry<K, V> {
        d<K, V> a;
        d<K, V> b;
        d<K, V> c;
        d<K, V> d;
        d<K, V> e;
        final K f;
        V g;
        int h;

        d() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        d(d<K, V> d2, K k2, d<K, V> d3, d<K, V> d4) {
            this.a = d2;
            this.f = k2;
            this.h = 1;
            this.d = d3;
            this.e = d4;
            d4.d = this;
            d3.e = this;
        }

        public d<K, V> a() {
            d<K, V> d2 = this.b;
            d<K, V> d3 = this;
            while (d2 != null) {
                d<K, V> d4 = d2.b;
                d3 = d2;
                d2 = d4;
            }
            return d3;
        }

        public d<K, V> b() {
            d<K, V> d2 = this.c;
            d<K, V> d3 = this;
            while (d2 != null) {
                d<K, V> d4 = d2.c;
                d3 = d2;
                d2 = d4;
            }
            return d3;
        }

        public boolean equals(Object object) {
            boolean bl;
            block2 : {
                block6 : {
                    Map.Entry entry;
                    block5 : {
                        block4 : {
                            block3 : {
                                boolean bl2 = object instanceof Map.Entry;
                                bl = false;
                                if (!bl2) break block2;
                                entry = (Map.Entry)object;
                                if (this.f != null) break block3;
                                Object object2 = entry.getKey();
                                bl = false;
                                if (object2 != null) break block2;
                                break block4;
                            }
                            boolean bl3 = this.f.equals(entry.getKey());
                            bl = false;
                            if (!bl3) break block2;
                        }
                        if (this.g != null) break block5;
                        Object object3 = entry.getValue();
                        bl = false;
                        if (object3 != null) break block2;
                        break block6;
                    }
                    boolean bl4 = this.g.equals(entry.getValue());
                    bl = false;
                    if (!bl4) break block2;
                }
                bl = true;
            }
            return bl;
        }

        public K getKey() {
            return this.f;
        }

        public V getValue() {
            return this.g;
        }

        public int hashCode() {
            int n2 = this.f == null ? 0 : this.f.hashCode();
            int n3 = this.g == null ? 0 : this.g.hashCode();
            return n2 ^ n3;
        }

        public V setValue(V v2) {
            V v3 = this.g;
            this.g = v2;
            return v3;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f);
            stringBuilder.append("=");
            stringBuilder.append(this.g);
            return stringBuilder.toString();
        }
    }

}

