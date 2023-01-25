/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 */
package a.a.a.a.a.f;

import a.a.a.a.a.f.b;
import a.a.a.a.a.f.e;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;

public class d<T> {
    private final b a;
    private final e<T> b;
    private final String c;

    public d(b b2, e<T> e2, String string) {
        this.a = b2;
        this.b = e2;
        this.c = string;
    }

    public T a() {
        SharedPreferences sharedPreferences = this.a.a();
        return this.b.b(sharedPreferences.getString(this.c, null));
    }

    @SuppressLint(value={"CommitPrefEdits"})
    public void a(T t2) {
        this.a.a(this.a.b().putString(this.c, this.b.a(t2)));
    }

    public void clear() {
        this.a.b().remove(this.c).commit();
    }
}

