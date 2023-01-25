/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.ScrollView
 *  java.lang.Object
 */
package com.twitter.sdk.android.tweetcomposer.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ObservableScrollView
extends ScrollView {
    a a;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    @TargetApi(value=21)
    public ObservableScrollView(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
    }

    protected void onScrollChanged(int n2, int n3, int n4, int n5) {
        super.onScrollChanged(n2, n3, n4, n5);
        if (this.a != null) {
            this.a.a(n3);
        }
    }

    public void setScrollViewListener(a a2) {
        this.a = a2;
    }

    public static interface a {
        public void a(int var1);
    }

}

