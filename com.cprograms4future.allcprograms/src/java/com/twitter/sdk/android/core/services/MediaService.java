/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.twitter.sdk.android.core.services;

import b.aa;
import com.twitter.sdk.android.core.a.i;
import d.b;
import d.b.k;
import d.b.n;
import d.b.p;

public interface MediaService {
    @k
    @n(a="https://upload.twitter.com/1.1/media/upload.json")
    public b<i> upload(@p(a="media") aa var1, @p(a="media_data") aa var2, @p(a="additional_owners") aa var3);
}

