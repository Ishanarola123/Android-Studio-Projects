/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  com.firebase.ui.a.a
 *  com.firebase.ui.a.b$1
 *  com.google.firebase.a.b
 *  com.google.firebase.a.c
 *  com.google.firebase.a.d
 *  com.google.firebase.a.e
 *  com.google.firebase.a.l
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.firebase.ui.a;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.firebase.ui.a.a;
import com.firebase.ui.a.b;
import com.google.firebase.a.c;
import com.google.firebase.a.d;
import com.google.firebase.a.e;
import com.google.firebase.a.l;

public abstract class b<T>
extends BaseAdapter {
    private static final String TAG = "b";
    protected Activity mActivity;
    protected int mLayout;
    private final Class<T> mModelClass;
    private a mSnapshots;

    b(Activity activity, Class<T> class_, int n2, a a2) {
        this.mActivity = activity;
        this.mModelClass = class_;
        this.mLayout = n2;
        this.mSnapshots = a2;
        this.mSnapshots.a((a.a)new 1(this));
    }

    public b(Activity activity, Class<T> class_, int n2, l l2) {
        this(activity, class_, n2, new a(l2));
    }

    public void cleanup() {
        this.mSnapshots.a();
    }

    public int getCount() {
        return this.mSnapshots.b();
    }

    public T getItem(int n2) {
        return this.parseSnapshot(this.mSnapshots.a(n2));
    }

    public long getItemId(int n2) {
        return this.mSnapshots.a(n2).b().hashCode();
    }

    public e getRef(int n2) {
        return this.mSnapshots.a(n2).a();
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mActivity.getLayoutInflater().inflate(this.mLayout, viewGroup, false);
        }
        this.populateView(view, this.getItem(n2), n2);
        return view;
    }

    protected void onCancelled(c c2) {
        Log.w((String)TAG, (Throwable)c2.b());
    }

    protected void onDataChanged() {
    }

    protected T parseSnapshot(com.google.firebase.a.b b2) {
        return (T)b2.a(this.mModelClass);
    }

    protected abstract void populateView(View var1, T var2, int var3);
}

