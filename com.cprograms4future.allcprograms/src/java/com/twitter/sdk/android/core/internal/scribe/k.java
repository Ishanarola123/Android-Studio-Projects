/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.twitter.sdk.android.core.internal.scribe;

import com.twitter.sdk.android.core.internal.scribe.c;
import com.twitter.sdk.android.core.internal.scribe.f;
import com.twitter.sdk.android.core.internal.scribe.j;
import java.util.List;

public class k
extends f {
    @com.google.a.a.c(a="external_ids")
    public final a f;
    @com.google.a.a.c(a="device_id_created_at")
    public final long g;
    @com.google.a.a.c(a="language")
    public final String h;

    public k(c c2, long l2, String string, String string2, List<j> list) {
        super("syndicated_sdk_impression", c2, l2, list);
        this.h = string;
        this.f = new Object(string2){
            @com.google.a.a.c(a="AD_ID")
            public final String a;
            {
                this.a = string;
            }
        };
        this.g = 0L;
    }

}

