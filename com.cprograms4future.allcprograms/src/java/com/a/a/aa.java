/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.AssertionError
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.a.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.a.a.ab;
import com.a.a.ag;
import com.a.a.d;
import com.a.a.t;

class aa {
    final HandlerThread a;
    final d b;
    final Handler c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    aa(d d2) {
        this.b = d2;
        this.a = new HandlerThread("Picasso-Stats", 10);
        this.a.start();
        ag.a(this.a.getLooper());
        this.c = new a(this.a.getLooper(), this);
    }

    private static long a(int n2, long l2) {
        return l2 / (long)n2;
    }

    private void a(Bitmap bitmap, int n2) {
        int n3 = ag.a(bitmap);
        this.c.sendMessage(this.c.obtainMessage(n2, n3, 0));
    }

    void a() {
        this.c.sendEmptyMessage(0);
    }

    void a(long l2) {
        this.c.sendMessage(this.c.obtainMessage(4, (Object)l2));
    }

    void a(Bitmap bitmap) {
        this.a(bitmap, 2);
    }

    void a(Long l2) {
        this.l = 1 + this.l;
        this.f += l2.longValue();
        this.i = aa.a(this.l, this.f);
    }

    void b() {
        this.c.sendEmptyMessage(1);
    }

    void b(long l2) {
        this.m = 1 + this.m;
        this.g = l2 + this.g;
        this.j = aa.a(this.m, this.g);
    }

    void b(Bitmap bitmap) {
        this.a(bitmap, 3);
    }

    void c() {
        this.d = 1L + this.d;
    }

    void c(long l2) {
        this.n = 1 + this.n;
        this.h = l2 + this.h;
        this.k = aa.a(this.m, this.h);
    }

    void d() {
        this.e = 1L + this.e;
    }

    ab e() {
        ab ab2 = new ab(this.b.b(), this.b.a(), this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
        return ab2;
    }

    private static class a
    extends Handler {
        private final aa a;

        public a(Looper looper, aa aa2) {
            super(looper);
            this.a = aa2;
        }

        public void handleMessage(final Message message) {
            switch (message.what) {
                default: {
                    t.a.post(new Runnable(){

                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unhandled stats message.");
                            stringBuilder.append(message.what);
                            throw new AssertionError((Object)stringBuilder.toString());
                        }
                    });
                    return;
                }
                case 4: {
                    this.a.a((Long)message.obj);
                    return;
                }
                case 3: {
                    this.a.c(message.arg1);
                    return;
                }
                case 2: {
                    this.a.b(message.arg1);
                    return;
                }
                case 1: {
                    this.a.d();
                    return;
                }
                case 0: 
            }
            this.a.c();
        }

    }

}

