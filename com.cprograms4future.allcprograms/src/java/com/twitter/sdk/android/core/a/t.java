/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.twitter.sdk.android.core.a;

import com.google.a.a.c;
import java.io.Serializable;
import java.util.List;

public class t
implements Serializable {
    @c(a="duration_millis")
    public final long a;
    @c(a="variants")
    public final List<a> b;

    public static class a
    implements Serializable {
        @c(a="content_type")
        public final String a;
        @c(a="url")
        public final String b;
    }

}

