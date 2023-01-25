/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package a.a.a.a;

import a.a.a.a.l;
import android.util.Log;

public class b
implements l {
    private int a;

    public b() {
        this.a = 4;
    }

    public b(int n2) {
        this.a = n2;
    }

    @Override
    public void a(int n2, String string, String string2) {
        this.a(n2, string, string2, false);
    }

    public void a(int n2, String string, String string2, boolean bl) {
        if (bl || this.a(string, n2)) {
            Log.println((int)n2, (String)string, (String)string2);
        }
    }

    @Override
    public void a(String string, String string2) {
        this.a(string, string2, null);
    }

    @Override
    public void a(String string, String string2, Throwable throwable) {
        if (this.a(string, 3)) {
            Log.d((String)string, (String)string2, (Throwable)throwable);
        }
    }

    @Override
    public boolean a(String string, int n2) {
        return this.a <= n2;
    }

    @Override
    public void b(String string, String string2) {
        this.b(string, string2, null);
    }

    public void b(String string, String string2, Throwable throwable) {
        if (this.a(string, 2)) {
            Log.v((String)string, (String)string2, (Throwable)throwable);
        }
    }

    @Override
    public void c(String string, String string2) {
        this.c(string, string2, null);
    }

    @Override
    public void c(String string, String string2, Throwable throwable) {
        if (this.a(string, 5)) {
            Log.w((String)string, (String)string2, (Throwable)throwable);
        }
    }

    @Override
    public void d(String string, String string2) {
        this.d(string, string2, null);
    }

    @Override
    public void d(String string, String string2, Throwable throwable) {
        if (this.a(string, 6)) {
            Log.e((String)string, (String)string2, (Throwable)throwable);
        }
    }
}

