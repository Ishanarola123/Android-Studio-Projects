/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.NetworkInfo
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Future
 *  java.util.concurrent.FutureTask
 *  java.util.concurrent.PriorityBlockingQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package com.a.a;

import android.net.NetworkInfo;
import com.a.a.ag;
import com.a.a.c;
import com.a.a.t;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class v
extends ThreadPoolExecutor {
    v() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)new PriorityBlockingQueue(), (ThreadFactory)new ag.e());
    }

    private void a(int n2) {
        this.setCorePoolSize(n2);
        this.setMaximumPoolSize(n2);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    void a(NetworkInfo var1_1) {
        block13 : {
            if (var1_1 == null || !var1_1.isConnectedOrConnecting()) break block13;
            var2_2 = var1_1.getType();
            if (var2_2 == 6 || var2_2 == 9) ** GOTO lbl-1000
            block0 : switch (var2_2) lbl-1000: // 3 sources:
            {
                do {
                    default: {
                        this.a(3);
                        return;
                    }
                    break;
                } while (true);
                case 0: {
                    var4_3 = var1_1.getSubtype();
                    switch (var4_3) {
                        default: {
                            switch (var4_3) {
                                case 13: 
                                case 14: 
                                case 15: {
                                    ** GOTO lbl-1000
                                }
                                default: {
                                    ** continue;
                                }
                                case 12: 
                            }
                        }
                        case 3: 
                        case 4: 
                        case 5: 
                        case 6: {
                            var3_4 = 2;
                            break block0;
                        }
                        case 1: 
                        case 2: 
                    }
                    var3_4 = 1;
                    break;
                }
                case 1: lbl-1000: // 2 sources:
                {
                    var3_4 = 4;
                }
            }
            this.a(var3_4);
            return;
        }
        this.a(3);
    }

    public Future<?> submit(Runnable runnable) {
        a a2 = new a((c)runnable);
        this.execute((Runnable)a2);
        return a2;
    }

    private static final class a
    extends FutureTask<c>
    implements Comparable<a> {
        private final c a;

        public a(c c2) {
            super((Runnable)c2, null);
            this.a = c2;
        }

        public int a(a a2) {
            t.e e2;
            t.e e3 = this.a.n();
            if (e3 == (e2 = a2.a.n())) {
                return this.a.a - a2.a.a;
            }
            return e2.ordinal() - e3.ordinal();
        }

        public /* synthetic */ int compareTo(Object object) {
            return this.a((a)((Object)object));
        }
    }

}

