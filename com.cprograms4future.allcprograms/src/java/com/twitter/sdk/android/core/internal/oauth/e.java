/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.c;
import com.twitter.sdk.android.core.a;
import com.twitter.sdk.android.core.internal.oauth.e;

public class e
extends a
implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>(){

        public e a(Parcel parcel) {
            return new e(parcel);
        }

        public e[] a(int n2) {
            return new e[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    @c(a="token_type")
    private final String b;
    @c(a="access_token")
    private final String c;

    private e(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public e(String string, String string2) {
        this.b = string;
        this.c = string2;
    }

    public boolean b() {
        return false;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            e e2 = (e)object;
            if (this.c != null ? !this.c.equals((Object)e2.c) : e2.c != null) {
                return false;
            }
            return !(this.b != null ? !this.b.equals((Object)e2.b) : e2.b != null);
        }
        return false;
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

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}

