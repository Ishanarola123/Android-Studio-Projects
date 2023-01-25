/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package a.a.a.a.a.g;

import a.a.a.a.a.b.i;
import a.a.a.a.c;
import a.a.a.a.l;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;

public class n {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public n(String string, int n2, int n3, int n4) {
        this.a = string;
        this.b = n2;
        this.c = n3;
        this.d = n4;
    }

    public static n a(Context context, String string) {
        if (string != null) {
            try {
                int n2 = i.f(context);
                l l2 = c.h();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("App icon resource ID is ");
                stringBuilder.append(n2);
                l2.a("Fabric", stringBuilder.toString());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource((Resources)context.getResources(), (int)n2, (BitmapFactory.Options)options);
                n n3 = new n(string, n2, options.outWidth, options.outHeight);
                return n3;
            }
            catch (Exception exception) {
                c.h().d("Fabric", "Failed to load icon", exception);
            }
        }
        return null;
    }
}

