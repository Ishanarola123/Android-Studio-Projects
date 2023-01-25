/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  java.lang.Object
 *  java.lang.String
 */
package com.tencent.mm.opensdk.openapi;

import android.content.Intent;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.utils.ILog;

public interface IWXAPI {
    public void detach();

    public int getWXAppSupportAPI();

    public boolean handleIntent(Intent var1, IWXAPIEventHandler var2);

    public boolean isWXAppInstalled();

    public boolean openWXApp();

    public boolean registerApp(String var1);

    public boolean registerApp(String var1, long var2);

    public boolean sendReq(BaseReq var1);

    public boolean sendResp(BaseResp var1);

    public void setLogImpl(ILog var1);

    public void unregisterApp();
}

