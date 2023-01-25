/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.twitter.sdk.android.tweetui;

import android.view.View;
import com.twitter.sdk.android.core.a.o;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.i;
import com.twitter.sdk.android.core.r;
import com.twitter.sdk.android.tweetui.ToggleImageButton;
import com.twitter.sdk.android.tweetui.k;
import com.twitter.sdk.android.tweetui.l;
import com.twitter.sdk.android.tweetui.m;
import com.twitter.sdk.android.tweetui.n;

class e
extends com.twitter.sdk.android.tweetui.a
implements View.OnClickListener {
    final com.twitter.sdk.android.core.a.n b;
    final k c;
    final n d;
    final l e;

    e(com.twitter.sdk.android.core.a.n n2, n n3, c<com.twitter.sdk.android.core.a.n> c2) {
        this(n2, n3, c2, new m(n3));
    }

    e(com.twitter.sdk.android.core.a.n n2, n n3, c<com.twitter.sdk.android.core.a.n> c2, l l2) {
        super(c2);
        this.b = n2;
        this.d = n3;
        this.e = l2;
        this.c = n3.f();
    }

    void b() {
        this.e.b(this.b);
    }

    void c() {
        this.e.c(this.b);
    }

    public void onClick(View view) {
        if (view instanceof ToggleImageButton) {
            ToggleImageButton toggleImageButton = (ToggleImageButton)view;
            if (this.b.g) {
                this.c();
                this.c.b(this.b.i, new a(toggleImageButton, this.b, this.a()));
                return;
            }
            this.b();
            this.c.a(this.b.i, new a(toggleImageButton, this.b, this.a()));
        }
    }

    static class a
    extends c<com.twitter.sdk.android.core.a.n> {
        ToggleImageButton a;
        com.twitter.sdk.android.core.a.n b;
        c<com.twitter.sdk.android.core.a.n> c;

        a(ToggleImageButton toggleImageButton, com.twitter.sdk.android.core.a.n n2, c<com.twitter.sdk.android.core.a.n> c2) {
            this.a = toggleImageButton;
            this.b = n2;
            this.c = c2;
        }

        @Override
        public void a(i<com.twitter.sdk.android.core.a.n> i2) {
            this.c.a(i2);
        }

        @Override
        public void a(r r2) {
            if (r2 instanceof com.twitter.sdk.android.core.m) {
                int n2 = ((com.twitter.sdk.android.core.m)r2).a();
                if (n2 != 139) {
                    if (n2 != 144) {
                        this.a.setToggledOn(this.b.g);
                        this.c.a(r2);
                        return;
                    }
                    com.twitter.sdk.android.core.a.n n3 = new o().a(this.b).a(false).a();
                    this.c.a(new i<com.twitter.sdk.android.core.a.n>(n3, null));
                    return;
                }
                com.twitter.sdk.android.core.a.n n4 = new o().a(this.b).a(true).a();
                this.c.a(new i<com.twitter.sdk.android.core.a.n>(n4, null));
                return;
            }
            this.a.setToggledOn(this.b.g);
            this.c.a(r2);
        }
    }

}

