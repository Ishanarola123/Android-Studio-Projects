/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package a.a.a.a.a.f;

import a.a.a.a.c;
import a.a.a.a.i;
import android.content.Context;
import java.io.File;

public class a {
    private final Context a;
    private final String b;
    private final String c;

    public a(i i2) {
        if (i2.m() != null) {
            this.a = i2.m();
            this.b = i2.o();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Android/");
            stringBuilder.append(this.a.getPackageName());
            this.c = stringBuilder.toString();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    public File a() {
        return this.a(this.a.getFilesDir());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    File a(File file) {
        if (file != null) {
            if (file.exists()) return file;
            if (file.mkdirs()) {
                return file;
            }
            c.h().c("Fabric", "Couldn't create file");
            return null;
        } else {
            c.h().a("Fabric", "Null File");
        }
        return null;
    }
}

