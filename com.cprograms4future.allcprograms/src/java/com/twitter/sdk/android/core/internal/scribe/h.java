/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.IOException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.UUID
 */
package com.twitter.sdk.android.core.internal.scribe;

import a.a.a.a.a.b.j;
import a.a.a.a.a.d.c;
import a.a.a.a.a.d.d;
import a.a.a.a.a.d.g;
import a.a.a.a.a.d.l;
import android.content.Context;
import com.twitter.sdk.android.core.internal.scribe.f;
import java.io.IOException;
import java.util.UUID;

class h
extends d<f> {
    public h(Context context, c<f> c2, j j2, l l2, int n2) throws IOException {
        super(context, c2, j2, l2, n2);
    }

    @Override
    protected String a() {
        UUID uUID = UUID.randomUUID();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("se");
        stringBuilder.append("_");
        stringBuilder.append(uUID.toString());
        stringBuilder.append("_");
        stringBuilder.append(this.c.a());
        stringBuilder.append(".tap");
        return stringBuilder.toString();
    }
}

