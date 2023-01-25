/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.a.b
 *  a.a.a.a.a.b.n$1
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package a.a.a.a.a.b;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.d;
import a.a.a.a.a.b.n;
import a.a.a.a.c;
import android.content.Context;

public class n {
    private final d<String> a = new 1(this);
    private final b<String> b = new b();

    public String a(Context context) {
        try {
            String string = (String)this.b.a(context, this.a);
            boolean bl = "".equals((Object)string);
            if (bl) {
                string = null;
            }
            return string;
        }
        catch (Exception exception) {
            c.h().d("Fabric", "Failed to determine installer package name", exception);
            return null;
        }
    }
}

