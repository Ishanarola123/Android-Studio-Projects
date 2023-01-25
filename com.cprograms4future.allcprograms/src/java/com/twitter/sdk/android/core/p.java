/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.c;
import com.twitter.sdk.android.core.a;
import com.twitter.sdk.android.core.p;

public class p
extends a
implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new Parcelable.Creator<p>(){

        public p a(Parcel parcel) {
            return new p(parcel);
        }

        public p[] a(int n2) {
            return new p[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    @c(a="token")
    public final String b;
    @c(a="secret")
    public final String c;

    private p(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public p(String string, String string2) {
        this.b = string;
        this.c = string2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof p)) {
            return false;
        }
        p p2 = (p)object;
        if (this.c != null ? !this.c.equals((Object)p2.c) : p2.c != null) {
            return false;
        }
        return !(this.b != null ? !this.b.equals((Object)p2.b) : p2.b != null);
    }

    public int hashCode() {
        int n2 = this.b != null ? this.b.hashCode() : 0;
        int n3 = n2 * 31;
        String string = this.c;
        int n4 = 0;
        if (string != null) {
            n4 = this.c.hashCode();
        }
        return n3 + n4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("token=");
        stringBuilder.append(this.b);
        stringBuilder.append(",secret=");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}

