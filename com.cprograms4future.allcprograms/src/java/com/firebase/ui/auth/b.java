/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class b
implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>(){

        public b a(Parcel parcel) {
            b b2 = new b(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
            return b2;
        }

        public b[] a(int n2) {
            return new b[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;

    private b(int n2) {
        this(null, null, null, null, n2);
    }

    public b(String string, String string2) {
        this(string, string2, null, null, -1);
    }

    public b(String string, String string2, String string3) {
        this(string, string2, string3, null, -1);
    }

    public b(String string, String string2, String string3, String string4) {
        this(string, string2, string3, string4, -1);
    }

    private b(String string, String string2, String string3, String string4, int n2) {
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = n2;
    }

    public static Intent a(int n2) {
        return b.a(new b(n2));
    }

    public static Intent a(b b2) {
        return new Intent().putExtra("extra_idp_response", (Parcelable)b2);
    }

    public static b a(Intent intent) {
        if (intent != null) {
            return (b)intent.getParcelableExtra("extra_idp_response");
        }
        return null;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
    }

}

