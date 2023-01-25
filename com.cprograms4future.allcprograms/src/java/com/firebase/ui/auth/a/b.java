/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.util.Log
 *  com.facebook.a
 *  com.facebook.d.m
 *  com.facebook.d.o
 *  com.facebook.e
 *  com.facebook.e$a
 *  com.facebook.g
 *  com.facebook.i
 *  com.facebook.l
 *  com.facebook.m
 *  com.facebook.p
 *  com.facebook.p$c
 *  com.facebook.q
 *  com.facebook.s
 *  com.google.firebase.auth.c
 *  com.google.firebase.auth.g
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.firebase.ui.auth.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import com.facebook.d.o;
import com.facebook.e;
import com.facebook.i;
import com.facebook.l;
import com.facebook.m;
import com.facebook.p;
import com.facebook.q;
import com.facebook.s;
import com.firebase.ui.auth.a;
import com.firebase.ui.auth.a.d;
import com.firebase.ui.auth.c;
import com.google.firebase.auth.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class b
implements com.facebook.g<o>,
d {
    private static e a;
    private final List<String> b;
    private d.a c;

    public b(Context context, a.a a2, int n2) {
        ArrayList arrayList;
        Context context2 = context.getApplicationContext();
        if (context2.getResources().getIdentifier("facebook_permissions", "array", context2.getPackageName()) != 0) {
            Log.w((String)"FacebookProvider", (String)"DEVELOPER WARNING: You have defined R.array.facebook_permissions but that is no longer respected as of FirebaseUI 1.0.0. Please see README for IDP scope configuration instructions.");
        }
        if ((arrayList = a2.b()) == null) {
            arrayList = new ArrayList();
        }
        this.b = arrayList;
        m.a((Context)context2);
        m.a((int)n2);
    }

    private com.firebase.ui.auth.b a(String string, o o2) {
        return new com.firebase.ui.auth.b("facebook.com", string, o2.a().b());
    }

    public static com.google.firebase.auth.c a(com.firebase.ui.auth.b b2) {
        if (!b2.a().equals((Object)"facebook.com")) {
            return null;
        }
        return g.a((String)b2.c());
    }

    private void a(Bundle bundle) {
        this.c();
        this.c.b(bundle);
    }

    private void b(String string, o o2) {
        this.c();
        this.c.a(this.a(string, o2));
    }

    private void c() {
        a = null;
    }

    @Override
    public String a(Context context) {
        return context.getResources().getString(c.h.idp_name_facebook);
    }

    public void a() {
        Bundle bundle = new Bundle();
        bundle.putString("err", "cancelled");
        this.a(bundle);
    }

    @Override
    public void a(int n2, int n3, Intent intent) {
        if (a != null) {
            a.a(n2, n3, intent);
        }
    }

    @Override
    public void a(Activity activity) {
        a = e.a.a();
        com.facebook.d.m m2 = com.facebook.d.m.a();
        m2.a(a, (com.facebook.g)this);
        ArrayList arrayList = new ArrayList(this.b);
        if (!arrayList.contains((Object)"email")) {
            arrayList.add((Object)"email");
        }
        if (!arrayList.contains((Object)"public_profile")) {
            arrayList.add((Object)"public_profile");
        }
        m2.a(activity, (Collection)arrayList);
    }

    public void a(final o o2) {
        p p2 = p.a((com.facebook.a)o2.a(), (p.c)new p.c(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void a(JSONObject jSONObject, s s2) {
                b b2;
                Bundle bundle;
                l l2 = s2.a();
                if (l2 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Received Facebook error: ");
                    stringBuilder.append(l2.e());
                    Log.e((String)"FacebookProvider", (String)stringBuilder.toString());
                    b.this.a(new Bundle());
                    return;
                }
                if (jSONObject == null) {
                    Log.w((String)"FacebookProvider", (String)"Received null response from Facebook GraphRequest");
                    b2 = b.this;
                    bundle = new Bundle();
                } else {
                    try {
                        String string = jSONObject.getString("email");
                        b.this.b(string, o2);
                        return;
                    }
                    catch (JSONException jSONException) {
                        Log.e((String)"FacebookProvider", (String)"JSON Exception reading from Facebook GraphRequest", (Throwable)jSONException);
                        b2 = b.this;
                        bundle = new Bundle();
                    }
                }
                b2.a(bundle);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,email");
        p2.a(bundle);
        p2.j();
    }

    public void a(i i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error logging in with Facebook. ");
        stringBuilder.append(i2.getMessage());
        Log.e((String)"FacebookProvider", (String)stringBuilder.toString());
        Bundle bundle = new Bundle();
        bundle.putString("err", "error");
        bundle.putString("err_msg", i2.getMessage());
        this.a(bundle);
    }

    @Override
    public void a(d.a a2) {
        this.c = a2;
    }

    @Override
    public String b() {
        return "facebook.com";
    }

}

