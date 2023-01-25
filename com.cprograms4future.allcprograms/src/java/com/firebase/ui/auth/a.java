/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.facebook.d.m
 *  com.facebook.m
 *  com.firebase.ui.auth.KickoffActivity
 *  com.firebase.ui.auth.a$1
 *  com.google.android.gms.auth.api.a
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.a
 *  com.google.android.gms.common.api.a$d
 *  com.google.android.gms.common.api.a$d$c
 *  com.google.android.gms.common.api.f
 *  com.google.android.gms.common.api.f$a
 *  com.google.android.gms.d.a
 *  com.google.android.gms.d.g
 *  com.google.android.gms.d.j
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.c
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.IdentityHashMap
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Set
 */
package com.firebase.ui.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.m;
import com.firebase.ui.auth.KickoffActivity;
import com.firebase.ui.auth.a;
import com.firebase.ui.auth.b.c;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.e;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.d.g;
import com.google.android.gms.d.j;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class a {
    public static final Set<String> a = Collections.unmodifiableSet((Set)new HashSet((Collection)Arrays.asList((Object[])new String[]{"password", "google.com", "facebook.com", "twitter.com"})));
    private static final IdentityHashMap<com.google.firebase.c, a> b = new IdentityHashMap();
    private final com.google.firebase.c c;
    private final FirebaseAuth d;

    private a(com.google.firebase.c c2) {
        this.c = c2;
        this.d = FirebaseAuth.getInstance((com.google.firebase.c)this.c);
    }

    public static a a() {
        return a.a(com.google.firebase.c.d());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a(com.google.firebase.c c2) {
        IdentityHashMap<com.google.firebase.c, a> identityHashMap;
        IdentityHashMap<com.google.firebase.c, a> identityHashMap2 = identityHashMap = b;
        synchronized (identityHashMap2) {
            a a2 = (a)b.get((Object)c2);
            if (a2 == null) {
                a2 = new a(c2);
                b.put((Object)c2, (Object)a2);
            }
            return a2;
        }
    }

    public static int b() {
        return c.i.FirebaseUI;
    }

    public g<Void> a(Activity activity) {
        c c2 = c.a(activity);
        c2.b().a(com.google.android.gms.auth.api.a.d).a(com.google.android.gms.auth.api.a.e, (a.d.c)GoogleSignInOptions.f);
        com.firebase.ui.auth.b.b b2 = com.firebase.ui.auth.b.b.a(c2);
        this.d.d();
        g<Status> g2 = b2.a();
        g g3 = c2.a().a((com.google.android.gms.d.a)new 1(this));
        if (m.a()) {
            com.facebook.d.m.a().b();
        }
        return j.a((g[])new g[]{g2, g3});
    }

    public b c() {
        return new b();
    }

    public static class com.firebase.ui.auth.a$a
    implements Parcelable {
        public static final Parcelable.Creator<com.firebase.ui.auth.a$a> CREATOR = new Parcelable.Creator<com.firebase.ui.auth.a$a>(){

            public com.firebase.ui.auth.a$a a(Parcel parcel) {
                return new com.firebase.ui.auth.a$a(parcel);
            }

            public com.firebase.ui.auth.a$a[] a(int n2) {
                return new com.firebase.ui.auth.a$a[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        private final String a;
        private final List<String> b;

        private com.firebase.ui.auth.a$a(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.createStringArrayList();
        }

        private com.firebase.ui.auth.a$a(String string, List<String> list) {
            this.b = list;
            this.a = string;
        }

        public String a() {
            return this.a;
        }

        public List<String> b() {
            return this.b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeString(this.a);
            parcel.writeStringList(this.b);
        }

        public static class a {
            private String a;
            private List<String> b = new ArrayList();

            public a(String string) {
                if (com.firebase.ui.auth.a.a.contains((Object)string)) {
                    this.a = string;
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unkown provider: ");
                stringBuilder.append(string);
                throw new IllegalArgumentException(stringBuilder.toString());
            }

            public com.firebase.ui.auth.a$a a() {
                return new com.firebase.ui.auth.a$a(this.a, this.b);
            }
        }

    }

    public final class b {
        private int b = -1;
        private int c = a.b();
        private LinkedHashSet<a> d = new LinkedHashSet();
        private String e;
        private boolean f = true;

        private b() {
            this.d.add((Object)new a.a("password").a());
        }

        public Intent a() {
            return KickoffActivity.a((Context)a.this.c.a(), (e)this.b());
        }

        public e b() {
            e e2 = new e(a.this.c.b(), (List<a>)new ArrayList(this.d), this.c, this.b, this.e, this.f);
            return e2;
        }
    }

}

