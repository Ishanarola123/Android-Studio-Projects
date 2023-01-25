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

public class l
extends f {
    @com.google.a.a.c(a="language")
    public final String f;
    @com.google.a.a.c(a="event_info")
    public final String g;
    @com.google.a.a.c(a="external_ids")
    public final a h;

    public l(c c2, String string, long l2, String string2, String string3, List<j> list) {
        super("tfw_client_event", c2, l2, list);
        this.f = string2;
        this.g = string;
        this.h = new Object(string3){
            @com.google.a.a.c(a="6")
            public final String a;
            {
                this.a = string;
            }
        };
    }

}

