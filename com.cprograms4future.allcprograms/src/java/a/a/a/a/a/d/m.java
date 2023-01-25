/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 */
package a.a.a.a.a.d;

import a.a.a.a.a.b.i;
import a.a.a.a.a.d.j;
import android.content.Context;

public class m
implements Runnable {
    private final Context a;
    private final j b;

    public m(Context context, j j2) {
        this.a = context;
        this.b = j2;
    }

    public void run() {
        try {
            i.a(this.a, "Performing time based file roll over.");
            if (!this.b.d()) {
                this.b.c();
                return;
            }
        }
        catch (Exception exception) {
            i.a(this.a, "Failed to roll over file", exception);
        }
    }
}

