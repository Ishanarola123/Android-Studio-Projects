/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.twitter.sdk.android.core.a.j
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.twitter.sdk.android.core.a.e;
import com.twitter.sdk.android.core.a.j;
import com.twitter.sdk.android.core.a.t;
import com.twitter.sdk.android.core.internal.g;
import com.twitter.sdk.android.tweetui.h;
import com.twitter.sdk.android.tweetui.internal.c;

public class MediaBadgeView
extends FrameLayout {
    TextView a;
    ImageView b;

    public MediaBadgeView(Context context) {
        this(context, null);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a(context);
    }

    void a() {
        this.a.setVisibility(8);
        this.b.setVisibility(8);
    }

    void a(Context context) {
        View view = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(h.f.tw__media_badge, (ViewGroup)this, true);
        this.a = (TextView)view.findViewById(h.e.tw__video_duration);
        this.b = (ImageView)view.findViewById(h.e.tw__gif_badge);
    }

    void setBadge(Drawable drawable) {
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        this.b.setImageDrawable(drawable);
    }

    public void setCard(e e2) {
        if (g.a(e2)) {
            this.setBadge(this.getResources().getDrawable(h.d.tw__vine_badge));
            return;
        }
        this.a();
    }

    public void setMediaEntity(j j2) {
        if ("animated_gif".equals((Object)j2.c)) {
            this.setBadge(this.getResources().getDrawable(h.d.tw__gif_badge));
            return;
        }
        if ("video".equals((Object)j2.c)) {
            long l2 = j2.d == null ? 0L : j2.d.a;
            this.setText(l2);
            return;
        }
        this.a();
    }

    void setText(long l2) {
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        this.a.setText((CharSequence)c.a(l2));
    }
}

