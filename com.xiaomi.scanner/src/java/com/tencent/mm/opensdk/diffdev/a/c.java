/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tencent.mm.opensdk.diffdev.a.a
 *  com.tencent.mm.opensdk.diffdev.a.b
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.diffdev.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class c
implements Runnable {
    final /* synthetic */ b g;

    c(b b2) {
        this.g = b2;
    }

    public final void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection)a.a((a)this.g.f));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((OAuthListener)iterator.next()).onQrcodeScanned();
        }
    }
}

