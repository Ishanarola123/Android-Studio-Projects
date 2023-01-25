/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.diffdev.a.c;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class b
implements OAuthListener {
    final /* synthetic */ a f;

    b(a a2) {
        this.f = a2;
    }

    @Override
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String string2) {
        Object[] arrobject = new Object[]{oAuthErrCode.toString(), string2};
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format((String)"onAuthFinish, errCode = %s, authCode = %s", (Object[])arrobject));
        a.c(this.f);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection)a.a(this.f));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((OAuthListener)iterator.next()).onAuthFinish(oAuthErrCode, string2);
        }
    }

    @Override
    public final void onAuthGotQrcode(String string2, byte[] arrby) {
        StringBuilder stringBuilder = new StringBuilder("onAuthGotQrcode, qrcodeImgPath = ");
        stringBuilder.append(string2);
        Log.d("MicroMsg.SDK.ListenerWrapper", stringBuilder.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection)a.a(this.f));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((OAuthListener)iterator.next()).onAuthGotQrcode(string2, arrby);
        }
    }

    @Override
    public final void onQrcodeScanned() {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (a.b(this.f) != null) {
            a.b(this.f).post((Runnable)new c(this));
        }
    }
}

