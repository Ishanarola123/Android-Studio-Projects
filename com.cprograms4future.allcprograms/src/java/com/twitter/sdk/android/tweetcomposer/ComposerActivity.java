/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  com.twitter.sdk.android.core.p
 *  com.twitter.sdk.android.core.u
 *  com.twitter.sdk.android.tweetcomposer.ComposerActivity$b
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetcomposer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.u;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;
import com.twitter.sdk.android.tweetcomposer.ComposerView;
import com.twitter.sdk.android.tweetcomposer.f;
import com.twitter.sdk.android.tweetcomposer.j;
import java.io.Serializable;

/*
 * Exception performing whole class analysis.
 */
public class ComposerActivity
extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = this.getIntent();
        u u2 = new u((p)intent.getParcelableExtra("EXTRA_USER_TOKEN"), -1L, "");
        com.twitter.sdk.android.tweetcomposer.b b2 = (com.twitter.sdk.android.tweetcomposer.b)intent.getSerializableExtra("EXTRA_CARD");
        String string = intent.getStringExtra("EXTRA_HASHTAGS");
        this.setTheme(intent.getIntExtra("EXTRA_THEME", j.e.ComposerLight));
        this.setContentView(j.d.tw__activity_composer);
        new f((ComposerView)this.findViewById(j.c.tw__composer_view), u2, b2, string, (a)new /* Unavailable Anonymous Inner Class!! */);
    }

    static interface a {
        public void a();
    }

}

