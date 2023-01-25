/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.twitter.sdk.android.core.p
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.twitter.sdk.android.core.p;

public class f
implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>(){

        public f a(Parcel parcel) {
            return new f(parcel);
        }

        public f[] a(int n2) {
            return new f[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    public final p a;
    public final String b;
    public final long c;

    private f(Parcel parcel) {
        this.a = (p)parcel.readParcelable(p.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readLong();
    }

    public f(p p2, String string, long l2) {
        this.a = p2;
        this.b = string;
        this.c = l2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("authToken=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(",userName=");
        stringBuilder.append(this.b);
        stringBuilder.append(",userId=");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.a, n2);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
    }

}

