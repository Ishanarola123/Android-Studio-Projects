/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  com.twitter.sdk.android.tweetui.PlayerActivity$1
 *  com.twitter.sdk.android.tweetui.n
 *  com.twitter.sdk.android.tweetui.p
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.twitter.sdk.android.core.internal.scribe.j;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.g;
import com.twitter.sdk.android.tweetui.h;
import com.twitter.sdk.android.tweetui.internal.f;
import com.twitter.sdk.android.tweetui.n;
import com.twitter.sdk.android.tweetui.o;
import com.twitter.sdk.android.tweetui.p;
import java.io.Serializable;

public class PlayerActivity
extends Activity {
    static final o a = new p(n.c());
    g b;

    private void a(j j2) {
        a.a(j2);
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.overridePendingTransition(0, h.a.tw__slide_out);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(h.f.tw__player_activity);
        a a2 = (a)this.getIntent().getSerializableExtra("PLAYER_ITEM");
        this.b = new g(this.findViewById(16908290), (f.a)new 1(this));
        this.b.a(a2);
        this.a((j)this.getIntent().getSerializableExtra("SCRIBE_ITEM"));
    }

    public void onDestroy() {
        this.b.c();
        super.onDestroy();
    }

    protected void onPause() {
        this.b.b();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.b.a();
    }

    public static class a
    implements Serializable {
        public String a;
        public boolean b;
        public String c;
        public String d;

        public a(String string, boolean bl) {
            this.a = string;
            this.b = bl;
        }

        public a(String string, boolean bl, String string2, String string3) {
            this.a = string;
            this.b = bl;
            this.d = string2;
            this.c = string3;
        }
    }

}

