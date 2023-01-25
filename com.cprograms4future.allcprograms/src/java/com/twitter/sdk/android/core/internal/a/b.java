/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package com.twitter.sdk.android.core.internal.a;

import b.ab;
import b.t;
import b.z;
import java.io.IOException;

public class b
implements t {
    @Override
    public ab a(t.a a2) throws IOException {
        ab ab2 = a2.a(a2.a());
        if (ab2.b() == 403) {
            ab2 = ab2.g().a(401).a();
        }
        return ab2;
    }
}

