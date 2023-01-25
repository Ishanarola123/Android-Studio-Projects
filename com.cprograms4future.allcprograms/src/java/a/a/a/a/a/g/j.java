/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package a.a.a.a.a.g;

import a.a.a.a.a.f.b;
import a.a.a.a.a.g.g;
import a.a.a.a.a.g.r;
import a.a.a.a.a.g.s;
import a.a.a.a.a.g.t;
import a.a.a.a.a.g.v;
import a.a.a.a.a.g.w;
import a.a.a.a.a.g.x;
import a.a.a.a.c;
import a.a.a.a.i;
import a.a.a.a.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

class j
implements s {
    private final w a;
    private final v b;
    private final a.a.a.a.a.b.j c;
    private final g d;
    private final x e;
    private final i f;
    private final b g;

    public j(i i2, w w2, a.a.a.a.a.b.j j2, v v2, g g2, x x2) {
        this.f = i2;
        this.a = w2;
        this.c = j2;
        this.b = v2;
        this.d = g2;
        this.e = x2;
        this.g = new a.a.a.a.a.f.c(this.f);
    }

    private void a(JSONObject jSONObject, String string) throws JSONException {
        l l2 = c.h();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(jSONObject.toString());
        l2.a("Fabric", stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private t b(r var1_1) {
        block7 : {
            var2_2 = null;
            try {
                var4_3 = r.b.equals((Object)var1_1);
                var2_2 = null;
                if (var4_3 != false) return var2_2;
                var5_4 = this.d.a();
                if (var5_4 == null) ** GOTO lbl26
                var6_5 = this.b.a(this.c, var5_4);
                if (var6_5 == null) ** GOTO lbl24
                this.a(var5_4, "Loaded cached settings: ");
                var7_6 = this.c.a();
                if (!r.c.equals((Object)var1_1) && var6_5.a(var7_6)) {
                    var9_7 = c.h();
                    var10_8 = "Fabric";
                    var11_9 = "Cached settings have expired.";
                } else {
                    try {
                        c.h().a("Fabric", "Returning cached settings.");
                        return var6_5;
                    }
                    catch (Exception var3_10) {
                        var2_2 = var6_5;
                        break block7;
                    }
lbl24: // 2 sources:
                    c.h().d("Fabric", "Failed to transform cached settings data.", null);
                    return null;
lbl26: // 1 sources:
                    var9_7 = c.h();
                    var10_8 = "Fabric";
                    var11_9 = "No cached settings data found.";
                }
                var9_7.a(var10_8, var11_9);
                return null;
            }
            catch (Exception var3_11) {
                // empty catch block
            }
        }
        c.h().d("Fabric", "Failed to get cached settings", (Throwable)var3_12);
        return var2_2;
    }

    @Override
    public t a() {
        return this.a(r.a);
    }

    @Override
    public t a(r r2) {
        t t2;
        block14 : {
            void var3_9;
            block13 : {
                block12 : {
                    block11 : {
                        t2 = null;
                        boolean bl = c.i();
                        t2 = null;
                        if (bl) break block11;
                        boolean bl2 = this.d();
                        t2 = null;
                        if (bl2) break block11;
                        try {
                            t2 = this.b(r2);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    if (t2 == null) {
                        JSONObject jSONObject = this.e.a(this.a);
                        if (jSONObject == null) break block12;
                        t t3 = this.b.a(this.c, jSONObject);
                        try {
                            this.d.a(t3.g, jSONObject);
                            this.a(jSONObject, "Loaded settings: ");
                            this.a(this.b());
                            t2 = t3;
                        }
                        catch (Exception exception) {
                            t2 = t3;
                            break block13;
                        }
                    }
                }
                if (t2 == null) {
                    t t4 = this.b(r.c);
                    return t4;
                }
                break block14;
            }
            c.h().d("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", (Throwable)var3_9);
        }
        return t2;
    }

    @SuppressLint(value={"CommitPrefEdits"})
    boolean a(String string) {
        SharedPreferences.Editor editor = this.g.b();
        editor.putString("existing_instance_identifier", string);
        return this.g.a(editor);
    }

    String b() {
        String[] arrstring = new String[]{a.a.a.a.a.b.i.g(this.f.m())};
        return a.a.a.a.a.b.i.a(arrstring);
    }

    String c() {
        return this.g.a().getString("existing_instance_identifier", "");
    }

    boolean d() {
        return true ^ this.c().equals((Object)this.b());
    }
}

