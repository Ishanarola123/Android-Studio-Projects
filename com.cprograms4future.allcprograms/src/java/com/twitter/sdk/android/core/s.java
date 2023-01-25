/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 */
package com.twitter.sdk.android.core;

import a.a.a.a.a.e.g;
import android.content.Context;
import android.content.res.Resources;
import com.twitter.sdk.android.core.h;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;

class s
implements g {
    private static final String[] a;
    private final Context b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"VERISIGN_CLASS1", (Object)"2343d148a255899b947d461a797ec04cfed170b7");
        hashMap.put((Object)"VERISIGN_CLASS1_G3", (Object)"5519b278acb281d7eda7abc18399c3bb690424b5");
        hashMap.put((Object)"VERISIGN_CLASS2_G2", (Object)"1237ba4517eead2926fdc1cdfebeedf2ded9145c");
        hashMap.put((Object)"VERISIGN_CLASS2_G3", (Object)"5abec575dcaef3b08e271943fc7f250c3df661e3");
        hashMap.put((Object)"VERISIGN_CLASS3_G2", (Object)"1a21b4952b6293ce18b365ec9c0e934cb381e6d4");
        hashMap.put((Object)"VERISIGN_CLASS3_G3", (Object)"22f19e2ec6eaccfc5d2346f4c2e8f6c554dd5e07");
        hashMap.put((Object)"VERISIGN_CLASS3_G4", (Object)"ed663135d31bd4eca614c429e319069f94c12650");
        hashMap.put((Object)"VERISIGN_CLASS3_G5", (Object)"b181081a19a4c0941ffae89528c124c99b34acc7");
        hashMap.put((Object)"VERISIGN_CLASS4_G3", (Object)"3c03436868951cf3692ab8b426daba8fe922e5bd");
        hashMap.put((Object)"VERISIGN_UNIVERSAL", (Object)"bbc23e290bb328771dad3ea24dbdf423bd06b03d");
        hashMap.put((Object)"GEOTRUST_GLOBAL", (Object)"c07a98688d89fbab05640c117daa7d65b8cacc4e");
        hashMap.put((Object)"GEOTRUST_GLOBAL2", (Object)"713836f2023153472b6eba6546a9101558200509");
        hashMap.put((Object)"GEOTRUST_PRIMARY", (Object)"b01989e7effb4aafcb148f58463976224150e1ba");
        hashMap.put((Object)"GEOTRUST_PRIMARY_G2", (Object)"bdbea71bab7157f9e475d954d2b727801a822682");
        hashMap.put((Object)"GEOTRUST_PRIMARY_G3", (Object)"9ca98d00af740ddd8180d21345a58b8f2e9438d6");
        hashMap.put((Object)"GEOTRUST_UNIVERAL", (Object)"87e85b6353c623a3128cb0ffbbf551fe59800e22");
        hashMap.put((Object)"GEOTRUST_UNIVERSAL2", (Object)"5e4f538685dd4f9eca5fdc0d456f7d51b1dc9b7b");
        hashMap.put((Object)"DIGICERT_GLOBAL_ROOT", (Object)"d52e13c1abe349dae8b49594ef7c3843606466bd");
        hashMap.put((Object)"DIGICERT_EV_ROOT", (Object)"83317e62854253d6d7783190ec919056e991b9e3");
        hashMap.put((Object)"DIGICERT_ASSUREDID_ROOT", (Object)"68330e61358521592983a3c8d2d2e1406e7ab3c1");
        hashMap.put((Object)"TWITTER1", (Object)"56fef3c2147d4ed38837fdbd3052387201e5778d");
        Collection collection = hashMap.values();
        a = (String[])collection.toArray((Object[])new String[collection.size()]);
    }

    public s(Context context) {
        this.b = context.getApplicationContext();
    }

    @Override
    public InputStream a() {
        return this.b.getResources().openRawResource(h.c.tw__cacerts);
    }

    @Override
    public String b() {
        return "changeit";
    }

    @Override
    public String[] c() {
        return a;
    }

    @Override
    public long d() {
        return 1481152291015L;
    }
}

