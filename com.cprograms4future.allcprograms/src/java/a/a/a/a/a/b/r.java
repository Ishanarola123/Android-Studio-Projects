/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package a.a.a.a.a.b;

import android.os.SystemClock;
import android.util.Log;

public class r {
    private final String a;
    private final String b;
    private final boolean c;
    private long d;
    private long e;

    public r(String string, String string2) {
        this.a = string;
        this.b = string2;
        this.c = true ^ Log.isLoggable((String)string2, (int)2);
    }

    private void c() {
        String string = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(": ");
        stringBuilder.append(this.e);
        stringBuilder.append("ms");
        Log.v((String)string, (String)stringBuilder.toString());
    }

    public void a() {
        r r2 = this;
        synchronized (r2) {
            block4 : {
                boolean bl = this.c;
                if (!bl) break block4;
                return;
            }
            this.d = SystemClock.elapsedRealtime();
            this.e = 0L;
            return;
        }
    }

    public void b() {
        r r2 = this;
        synchronized (r2) {
            block6 : {
                block5 : {
                    boolean bl = this.c;
                    if (!bl) break block5;
                    return;
                }
                long l2 = this.e;
                if (l2 == 0L) break block6;
                return;
            }
            this.e = SystemClock.elapsedRealtime() - this.d;
            this.c();
            return;
        }
    }
}

