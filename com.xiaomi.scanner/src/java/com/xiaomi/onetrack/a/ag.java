/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.onetrack.a.af
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.a.af;
import com.xiaomi.onetrack.h.o;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ag
implements Runnable {
    final /* synthetic */ af a;

    ag(af af2) {
        this.a = af2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        try {
            ConcurrentHashMap concurrentHashMap;
            ConcurrentHashMap concurrentHashMap2 = concurrentHashMap = af.a((af)this.a);
            // MONITORENTER : concurrentHashMap2
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trackCachedEvents: ");
            stringBuilder.append(exception.toString());
            o.a("OneTrackSystemImp", stringBuilder.toString());
            return;
        }
        if (af.a((af)this.a).size() <= 0) {
            // MONITOREXIT : concurrentHashMap2
            return;
        }
        Iterator iterator = af.a((af)this.a).entrySet().iterator();
        do {
            if (!iterator.hasNext()) {
                af.a((af)this.a).clear();
                // MONITOREXIT : concurrentHashMap2
                return;
            }
            Map.Entry entry = (Map.Entry)iterator.next();
            String string2 = (String)entry.getKey();
            String string3 = (String)entry.getValue();
            af.c((af)this.a).b(string3, string2, af.b((af)this.a));
            if (!o.a) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("name:");
            stringBuilder.append(string3);
            stringBuilder.append("data :");
            stringBuilder.append(string2);
            o.a("OneTrackSystemImp", stringBuilder.toString());
        } while (true);
    }
}

