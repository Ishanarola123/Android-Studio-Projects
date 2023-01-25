/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.twitter.sdk.android.core.internal.scribe.k
 *  com.twitter.sdk.android.core.internal.scribe.l
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.twitter.sdk.android.core.internal.scribe;

import com.twitter.sdk.android.core.internal.scribe.c;
import com.twitter.sdk.android.core.internal.scribe.f;
import com.twitter.sdk.android.core.internal.scribe.j;
import com.twitter.sdk.android.core.internal.scribe.k;
import com.twitter.sdk.android.core.internal.scribe.l;
import java.util.List;

public class g {
    public static f a(c c2, String string, long l2, String string2, String string3, List<j> list) {
        String string4 = c2.a;
        int n2 = string4.hashCode() == 114757 && string4.equals((Object)"tfw") ? 0 : -1;
        if (n2 != 0) {
            k k2 = new k(c2, l2, string2, string3, list);
            return k2;
        }
        l l3 = new l(c2, string, l2, string2, string3, list);
        return l3;
    }
}

