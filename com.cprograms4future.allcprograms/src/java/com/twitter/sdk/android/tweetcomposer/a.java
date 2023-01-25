/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.twitter.sdk.android.tweetcomposer.k
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a.a.ae;
import com.a.a.t;
import com.a.a.x;
import com.twitter.sdk.android.tweetcomposer.b;
import com.twitter.sdk.android.tweetcomposer.j;
import com.twitter.sdk.android.tweetcomposer.k;

public class a
extends LinearLayout {
    ImageView a;
    ViewGroup b;
    TextView c;
    TextView d;
    TextView e;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context);
    }

    void a() {
        this.a = (ImageView)this.findViewById(j.c.tw__app_image);
        this.d = (TextView)this.findViewById(j.c.tw__app_name);
        this.e = (TextView)this.findViewById(j.c.tw__app_store_name);
        this.c = (TextView)this.findViewById(j.c.tw__app_install_button);
        this.b = (ViewGroup)this.findViewById(j.c.tw__app_info_layout);
    }

    void a(Context context) {
        this.setOrientation(1);
        a.inflate((Context)context, (int)j.d.tw__app_card, (ViewGroup)this);
        this.a();
        this.b();
    }

    void b() {
        int n2 = this.getResources().getColor(j.a.tw__composer_blue_text);
        this.c.setTextColor(n2);
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = this.getResources().getDimensionPixelSize(j.b.tw__card_maximum_width);
        int n5 = View.MeasureSpec.getSize((int)n2);
        if (n4 > 0 && n4 < n5) {
            n2 = View.MeasureSpec.makeMeasureSpec((int)n4, (int)View.MeasureSpec.getMode((int)n2));
        }
        super.onMeasure(n2, n3);
    }

    void setAppName(String string) {
        this.d.setText((CharSequence)string);
    }

    void setCard(b b2) {
        this.setImage(Uri.parse((String)b2.b));
        this.setAppName(b2.c);
    }

    void setImage(Uri uri) {
        int n2 = this.getResources().getDimensionPixelSize(j.b.tw__card_radius_medium);
        k k2 = new k.a().a(n2, n2, 0, 0).a();
        t.a(this.getContext()).a(uri).a((ae)k2).a().c().a(this.a);
    }
}

