/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.util.concurrent.ScheduledExecutorService
 */
package com.twitter.sdk.android.core.internal.scribe;

import a.a.a.a.a.d.d;
import a.a.a.a.a.d.k;
import android.content.Context;
import com.twitter.sdk.android.core.internal.scribe.ScribeFilesSender;
import com.twitter.sdk.android.core.internal.scribe.e;
import com.twitter.sdk.android.core.internal.scribe.f;
import com.twitter.sdk.android.core.internal.scribe.h;
import java.util.concurrent.ScheduledExecutorService;

class b
extends a.a.a.a.a.d.b<f> {
    private final k f;

    public b(Context context, ScheduledExecutorService scheduledExecutorService, h h2, e e2, ScribeFilesSender scribeFilesSender) {
        super(context, scheduledExecutorService, h2);
        this.f = scribeFilesSender;
        this.a(e2.h);
    }

    @Override
    public k a() {
        return this.f;
    }
}

