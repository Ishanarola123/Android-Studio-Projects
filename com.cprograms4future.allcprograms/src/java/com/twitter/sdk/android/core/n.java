/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;

public class n
implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new Parcelable.Creator<n>(){

        public n a(Parcel parcel) {
            return new n(parcel);
        }

        public n[] a(int n2) {
            return new n[n2];
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

    private n(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public n(String string, String string2) {
        if (string != null && string2 != null) {
            this.a = n.a(string);
            this.b = n.a(string2);
            return;
        }
        throw new IllegalArgumentException("TwitterAuthConfig must not be created with null consumer key or secret.");
    }

    static String a(String string) {
        if (string != null) {
            return string.trim();
        }
        return null;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return 140;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

}

