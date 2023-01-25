/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class j
implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new Parcelable.Creator<j>(){

        public j a(Parcel parcel) {
            j j2 = new j(parcel.readString(), parcel.readString(), parcel.readString(), (Uri)parcel.readParcelable(Uri.class.getClassLoader()));
            return j2;
        }

        public j[] a(int n2) {
            return new j[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private String a;
    private String b;
    private String c;
    private Uri d;

    private j(String string, String string2, String string3, Uri uri) {
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.d = uri;
    }

    public static j a(Intent intent) {
        return (j)intent.getParcelableExtra("extra_user");
    }

    public static j a(Bundle bundle) {
        return (j)bundle.getParcelable("extra_user");
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

    public Uri d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable((Parcelable)this.d, n2);
    }

    public static final class a {
        private String a;
        private String b;
        private String c;
        private Uri d;

        public a(String string) {
            this.a = string;
        }

        public a a(Uri uri) {
            this.d = uri;
            return this;
        }

        public a a(String string) {
            this.b = string;
            return this;
        }

        public j a() {
            j j2 = new j(this.a, this.b, this.c, this.d);
            return j2;
        }

        public a b(String string) {
            this.c = string;
            return this;
        }
    }

}

