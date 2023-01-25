/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  com.twitter.sdk.android.core.a.j
 *  com.twitter.sdk.android.tweetui.internal.TweetMediaView$b
 *  com.twitter.sdk.android.tweetui.n
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.List
 */
package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.a.a.t;
import com.a.a.x;
import com.twitter.sdk.android.core.a.t;
import com.twitter.sdk.android.core.f;
import com.twitter.sdk.android.tweetui.GalleryActivity;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.h;
import com.twitter.sdk.android.tweetui.internal.TweetMediaView;
import com.twitter.sdk.android.tweetui.internal.e;
import com.twitter.sdk.android.tweetui.internal.g;
import com.twitter.sdk.android.tweetui.j;
import com.twitter.sdk.android.tweetui.n;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public class TweetMediaView
extends ViewGroup
implements View.OnClickListener {
    final float[] a;
    int b;
    int c;
    final a d;
    boolean e;
    j f;
    com.twitter.sdk.android.core.a.n g;
    private final e[] h;
    private List<com.twitter.sdk.android.core.a.j> i;
    private final Path j;
    private final RectF k;
    private final int l;
    private int m;

    public TweetMediaView(Context context) {
        this(context, null);
    }

    public TweetMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new a());
    }

    TweetMediaView(Context context, AttributeSet attributeSet, a a2) {
        super(context, attributeSet);
        this.h = new e[4];
        this.i = Collections.emptyList();
        this.j = new Path();
        this.k = new RectF();
        this.a = new float[8];
        this.b = -16777216;
        this.d = a2;
        this.l = this.getResources().getDimensionPixelSize(h.c.tw__media_view_divider_size);
        this.c = h.d.tw__ic_tweet_photo_error_dark;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    c a(int var1_1, int var2_2) {
        var3_3 = View.MeasureSpec.getSize((int)var1_1);
        var4_4 = View.MeasureSpec.getSize((int)var2_2);
        var5_5 = var3_3 - this.l;
        var6_6 = 2;
        var7_7 = var5_5 / var6_6;
        var8_8 = (var4_4 - this.l) / var6_6;
        switch (this.m) {
            default: {
                return c.a(var3_3, var4_4);
            }
            case 4: {
                this.a(0, var7_7, var8_8);
                this.a(1, var7_7, var8_8);
                this.a(var6_6, var7_7, var8_8);
                var6_6 = 3;
                ** GOTO lbl19
            }
            case 3: {
                this.a(0, var7_7, var4_4);
                this.a(1, var7_7, var8_8);
lbl19: // 2 sources:
                this.a(var6_6, var7_7, var8_8);
                return c.a(var3_3, var4_4);
            }
            case 2: {
                this.a(0, var7_7, var4_4);
                this.a(1, var7_7, var4_4);
                return c.a(var3_3, var4_4);
            }
            case 1: 
        }
        this.a(0, var3_3, var4_4);
        return c.a(var3_3, var4_4);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void a() {
        block7 : {
            block6 : {
                var1_1 = this.getMeasuredWidth();
                var2_2 = this.getMeasuredHeight();
                var3_3 = (var1_1 - this.l) / 2;
                var4_4 = (var2_2 - this.l) / 2;
                var5_5 = var3_3 + this.l;
                switch (this.m) {
                    default: {
                        return;
                    }
                    case 4: {
                        this.a(0, 0, 0, var3_3, var4_4);
                        this.a(2, 0, var4_4 + this.l, var3_3, var2_2);
                        var7_6 = var5_5;
                        var10_7 = var1_1;
                        this.a(1, var7_6, 0, var10_7, var4_4);
                        var6_8 = 3;
                        ** GOTO lbl23
                    }
                    case 3: {
                        this.a(0, 0, 0, var3_3, var2_2);
                        var7_6 = var5_5;
                        var10_7 = var1_1;
                        this.a(1, var7_6, 0, var10_7, var4_4);
                        var6_8 = 2;
lbl23: // 2 sources:
                        var8_9 = var4_4 + this.l;
                        var9_10 = this;
                        break block6;
                    }
                    case 2: {
                        var11_11 = var2_2;
                        this.a(0, 0, 0, var3_3, var11_11);
                        var6_8 = 1;
                        var7_6 = var3_3 + this.l;
                        var9_10 = this;
                        var10_7 = var1_1;
                        var8_9 = 0;
                        break block7;
                    }
                    case 1: 
                }
                var6_8 = 0;
                var7_6 = 0;
                var8_9 = 0;
                var9_10 = this;
                var10_7 = var1_1;
            }
            var11_11 = var2_2;
        }
        var9_10.a(var6_8, var7_6, var8_9, var10_7, var11_11);
    }

    public void a(int n2) {
        Intent intent = new Intent(this.getContext(), GalleryActivity.class);
        intent.putExtra("GALLERY_ITEM", (Serializable)new GalleryActivity.a(this.g.i, n2, this.i));
        f.b(this.getContext(), intent);
    }

    void a(int n2, int n3, int n4) {
        this.h[n2].measure(View.MeasureSpec.makeMeasureSpec((int)n3, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)n4, (int)1073741824));
    }

    void a(int n2, int n3, int n4, int n5, int n6) {
        e e2 = this.h[n2];
        if (e2.getLeft() == n3 && e2.getTop() == n4 && e2.getRight() == n5 && e2.getBottom() == n6) {
            return;
        }
        e2.layout(n3, n4, n5, n6);
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(ImageView imageView, String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = this.getResources().getString(h.g.tw__tweet_media);
        }
        imageView.setContentDescription((CharSequence)string);
    }

    void a(com.twitter.sdk.android.core.a.e e2) {
        this.m = 1;
        e e3 = this.b(0);
        com.twitter.sdk.android.core.a.h h2 = com.twitter.sdk.android.core.internal.g.e(e2);
        this.a((ImageView)e3, h2.b);
        this.b(e3, h2.a);
        this.a(e3, true);
    }

    public void a(com.twitter.sdk.android.core.a.j j2) {
        if (g.c(j2) != null) {
            Intent intent = new Intent(this.getContext(), PlayerActivity.class);
            boolean bl = g.d(j2);
            intent.putExtra("PLAYER_ITEM", (Serializable)new PlayerActivity.a(g.c((com.twitter.sdk.android.core.a.j)j2).b, bl));
            f.b(this.getContext(), intent);
        }
    }

    public void a(com.twitter.sdk.android.core.a.n n2) {
        com.twitter.sdk.android.core.a.e e2 = n2.H;
        Intent intent = new Intent(this.getContext(), PlayerActivity.class);
        String string = com.twitter.sdk.android.core.internal.g.c(e2);
        String string2 = com.twitter.sdk.android.core.internal.g.d(e2);
        intent.putExtra("PLAYER_ITEM", (Serializable)new PlayerActivity.a(string, true, this.getContext().getResources().getString(h.g.tw__cta_text), string2));
        intent.putExtra("SCRIBE_ITEM", (Serializable)com.twitter.sdk.android.core.internal.scribe.j.a(n2.i, e2));
        f.b(this.getContext(), intent);
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(e e2, boolean bl) {
        Drawable drawable = bl ? this.getContext().getResources().getDrawable(h.d.tw__player_overlay) : null;
        e2.setOverlayDrawable(drawable);
    }

    e b(int n2) {
        e e2 = this.h[n2];
        if (e2 == null) {
            e2 = new e(this.getContext());
            e2.setLayoutParams(this.generateDefaultLayoutParams());
            e2.setOnClickListener((View.OnClickListener)this);
            this.h[n2] = e2;
            this.addView((View)e2, n2);
        } else {
            this.a(n2, 0, 0);
            this.a(n2, 0, 0, 0, 0);
        }
        e2.setVisibility(0);
        e2.setBackgroundColor(this.b);
        e2.setTag(h.e.tw__entity_index, (Object)n2);
        return e2;
    }

    void b() {
        for (int i2 = 0; i2 < this.m; ++i2) {
            e e2 = this.h[i2];
            if (e2 == null) continue;
            e2.setVisibility(8);
        }
        this.m = 0;
    }

    void b(ImageView imageView, String string) {
        t t2 = this.d.a();
        if (t2 == null) {
            return;
        }
        t2.a(string).a().c().a(this.c).a(imageView, (com.a.a.e)new /* Unavailable Anonymous Inner Class!! */);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.e && Build.VERSION.SDK_INT >= 18) {
            int n2 = canvas.save();
            canvas.clipPath(this.j);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(n2);
            return;
        }
        super.dispatchDraw(canvas);
    }

    public void onClick(View view) {
        Integer n2 = (Integer)view.getTag(h.e.tw__entity_index);
        if (this.f != null) {
            com.twitter.sdk.android.core.a.j j2 = !this.i.isEmpty() ? (com.twitter.sdk.android.core.a.j)this.i.get(n2.intValue()) : null;
            this.f.a(this.g, j2);
            return;
        }
        if (!this.i.isEmpty()) {
            com.twitter.sdk.android.core.a.j j3 = (com.twitter.sdk.android.core.a.j)this.i.get(n2.intValue());
            if (g.b(j3)) {
                this.a(j3);
                return;
            }
            if (g.a(j3)) {
                this.a(n2);
                return;
            }
        } else {
            this.a(this.g);
        }
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        if (this.m > 0) {
            this.a();
        }
    }

    protected void onMeasure(int n2, int n3) {
        c c2 = this.m > 0 ? this.a(n2, n3) : c.a;
        this.setMeasuredDimension(c2.b, c2.c);
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        this.j.reset();
        this.k.set(0.0f, 0.0f, (float)n2, (float)n3);
        this.j.addRoundRect(this.k, this.a, Path.Direction.CW);
        this.j.close();
    }

    public void setMediaBgColor(int n2) {
        this.b = n2;
    }

    public void setPhotoErrorResId(int n2) {
        this.c = n2;
    }

    public void setTweetMediaClickListener(j j2) {
        this.f = j2;
    }

    public void setVineCard(com.twitter.sdk.android.core.a.n n2) {
        if (n2 != null && n2.H != null) {
            if (!com.twitter.sdk.android.core.internal.g.a(n2.H)) {
                return;
            }
            this.g = n2;
            this.i = Collections.emptyList();
            this.b();
            this.a(n2.H);
            this.e = false;
            this.requestLayout();
        }
    }

    static class a {
        a() {
        }

        t a() {
            return n.c().h();
        }
    }

    static class c {
        static final c a = new c();
        final int b;
        final int c;

        private c() {
            this(0, 0);
        }

        private c(int n2, int n3) {
            this.b = n2;
            this.c = n3;
        }

        static c a(int n2, int n3) {
            int n4 = Math.max((int)n2, (int)0);
            int n5 = Math.max((int)n3, (int)0);
            if (n4 == 0 && n5 == 0) {
                return a;
            }
            return new c(n4, n5);
        }
    }

}

