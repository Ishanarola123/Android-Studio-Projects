/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.twitter.sdk.android.core.a.j
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.twitter.sdk.android.tweetui.internal;

import android.os.Build;
import com.twitter.sdk.android.core.a.j;
import com.twitter.sdk.android.core.a.t;
import java.util.List;

public final class g {
    static boolean a(j j2) {
        return "photo".equals((Object)j2.c);
    }

    static boolean a(t.a a2) {
        if (Build.VERSION.SDK_INT >= 21 && "application/x-mpegURL".equals((Object)a2.a)) {
            return true;
        }
        return "video/mp4".equals((Object)a2.a);
    }

    static boolean b(j j2) {
        return "video".equals((Object)j2.c) || "animated_gif".equals((Object)j2.c);
        {
        }
    }

    public static t.a c(j j2) {
        for (t.a a2 : j2.d.b) {
            if (!g.a(a2)) continue;
            return a2;
        }
        return null;
    }

    public static boolean d(j j2) {
        return "animated_gif".equals((Object)j2.c);
    }
}

