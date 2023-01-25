/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.a.a.ag;
import com.a.a.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class m
implements d {
    final LinkedHashMap<String, Bitmap> b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public m(int n2) {
        if (n2 > 0) {
            this.c = n2;
            this.b = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("Max size must be positive.");
    }

    public m(Context context) {
        this(ag.c(context));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n2) {
        do {
            m m2 = this;
            synchronized (m2) {
                if (this.d < 0 || this.b.isEmpty() && this.d != 0) break block3;
                if (this.d <= n2 || this.b.isEmpty()) break;
                Map.Entry entry = (Map.Entry)this.b.entrySet().iterator().next();
                String string = (String)entry.getKey();
                Bitmap bitmap = (Bitmap)entry.getValue();
                this.b.remove((Object)string);
                this.d -= ag.a(bitmap);
                this.f = 1 + this.f;
            }
        } while (true);
        {
            block3 : {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getName());
            stringBuilder.append(".sizeOf() is reporting inconsistent results!");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    @Override
    public final int a() {
        m m2 = this;
        synchronized (m2) {
            int n2 = this.d;
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Bitmap a(String string) {
        if (string == null) {
            throw new NullPointerException("key == null");
        }
        m m2 = this;
        synchronized (m2) {
            Bitmap bitmap = (Bitmap)this.b.get((Object)string);
            if (bitmap != null) {
                this.g = 1 + this.g;
                return bitmap;
            }
            this.h = 1 + this.h;
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(String string, Bitmap bitmap) {
        if (string != null && bitmap != null) {
            m m2 = this;
            synchronized (m2) {
                this.e = 1 + this.e;
                this.d += ag.a(bitmap);
                Bitmap bitmap2 = (Bitmap)this.b.put((Object)string, (Object)bitmap);
                if (bitmap2 != null) {
                    this.d -= ag.a(bitmap2);
                }
            }
            this.a(this.c);
            return;
        }
        throw new NullPointerException("key == null || bitmap == null");
    }

    @Override
    public final int b() {
        m m2 = this;
        synchronized (m2) {
            int n2 = this.c;
            return n2;
        }
    }

    public final void c() {
        this.a(-1);
    }

    @Override
    public final void clear() {
        m m2 = this;
        synchronized (m2) {
            this.c();
            return;
        }
    }
}

