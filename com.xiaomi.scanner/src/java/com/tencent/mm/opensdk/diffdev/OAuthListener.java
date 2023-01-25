/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.OAuthErrCode;

public interface OAuthListener {
    public void onAuthFinish(OAuthErrCode var1, String var2);

    public void onAuthGotQrcode(String var1, byte[] var2);

    public void onQrcodeScanned();
}

