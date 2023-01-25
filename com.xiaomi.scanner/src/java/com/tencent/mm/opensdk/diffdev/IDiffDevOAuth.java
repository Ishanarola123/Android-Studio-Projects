/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.OAuthListener;

public interface IDiffDevOAuth {
    public void addListener(OAuthListener var1);

    public boolean auth(String var1, String var2, String var3, String var4, String var5, OAuthListener var6);

    public void detach();

    public void removeAllListeners();

    public void removeListener(OAuthListener var1);

    public boolean stopAuth();
}

