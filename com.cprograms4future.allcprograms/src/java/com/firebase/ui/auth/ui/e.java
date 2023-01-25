/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.firebase.ui.auth.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.firebase.ui.auth.a;
import java.util.ArrayList;
import java.util.List;

public class e
implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>(){

        public e a(Parcel parcel) {
            String string = parcel.readString();
            ArrayList arrayList = parcel.createTypedArrayList(a.a.CREATOR);
            int n2 = parcel.readInt();
            int n3 = parcel.readInt();
            String string2 = parcel.readString();
            boolean bl = parcel.readInt() != 0;
            e e2 = new e(string, (List<a.a>)arrayList, n2, n3, string2, bl);
            return e2;
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
    public final String a;
    public final List<a.a> b;
    public final int c;
    public final int d;
    public final String e;
    public final boolean f;

    public e(String string, List<a.a> list, int n2, int n3, String string2, boolean bl) {
        this.a = com.firebase.ui.auth.b.e.a(string, "appName cannot be null", new Object[0]);
        this.b = com.firebase.ui.auth.b.e.a(list, "providerInfo cannot be null", new Object[0]);
        this.c = n2;
        this.d = n3;
        this.e = string2;
        this.f = bl;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeInt((int)this.f);
    }

}

