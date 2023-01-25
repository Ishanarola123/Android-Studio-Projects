/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXEmojiSharedObject
implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public int packageflag;
    public String packageid;
    public String thumburl;
    public String url;

    public WXEmojiSharedObject() {
    }

    public WXEmojiSharedObject(String string2, int n, String string3, String string4) {
        this.thumburl = string2;
        this.packageflag = n;
        this.packageid = string3;
        this.url = string4;
    }

    @Override
    public boolean checkArgs() {
        if (!(TextUtils.isEmpty((CharSequence)this.packageid) || TextUtils.isEmpty((CharSequence)this.thumburl) || TextUtils.isEmpty((CharSequence)this.url) || this.packageflag == -1)) {
            return true;
        }
        Log.e(TAG, "checkArgs fail, packageid or thumburl is invalid");
        return false;
    }

    @Override
    public void serialize(Bundle bundle) {
        bundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
        bundle.putInt("_wxemojisharedobject_packageflag", this.packageflag);
        bundle.putString("_wxemojisharedobject_packageid", this.packageid);
        bundle.putString("_wxemojisharedobject_url", this.url);
    }

    @Override
    public int type() {
        return 15;
    }

    @Override
    public void unserialize(Bundle bundle) {
        this.thumburl = bundle.getString("_wxwebpageobject_thumburl");
        this.packageflag = bundle.getInt("_wxwebpageobject_packageflag");
        this.packageid = bundle.getString("_wxwebpageobject_packageid");
        this.url = bundle.getString("_wxwebpageobject_url");
    }
}

