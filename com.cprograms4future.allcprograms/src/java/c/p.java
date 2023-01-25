/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package c;

import c.o;

final class p {
    static o a;
    static long b;

    private p() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static o a() {
        Class<p> class_ = p.class;
        synchronized (p.class) {
            if (a != null) {
                o o2 = a;
                a = o2.f;
                o2.f = null;
                b -= 2048L;
                // ** MonitorExit[var2] (shouldn't be in output)
                return o2;
            }
            // ** MonitorExit[var2] (shouldn't be in output)
            return new o();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void a(o o2) {
        if (o2.f == null && o2.g == null) {
            if (o2.d) {
                return;
            }
            Class<p> class_ = p.class;
            synchronized (p.class) {
                if (2048L + b > 65536L) {
                    // ** MonitorExit[var2_1] (shouldn't be in output)
                    return;
                }
                b = 2048L + b;
                o2.f = a;
                o2.c = 0;
                o2.b = 0;
                a = o2;
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}

