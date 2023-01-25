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

public class WXDesignerSharedObject
implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public String designerName;
    public String designerRediretctUrl;
    public int designerUIN;
    public String thumburl;
    public String url;

    public WXDesignerSharedObject() {
    }

    public WXDesignerSharedObject(String string2, int n, String string3, String string4) {
        this.url = string3;
        this.thumburl = string2;
        this.designerUIN = n;
        this.designerName = string4;
    }

    @Override
    public boolean checkArgs() {
        if (this.designerUIN != 0 && !TextUtils.isEmpty((CharSequence)this.thumburl) && !TextUtils.isEmpty((CharSequence)this.url)) {
            return true;
        }
        Log.e(TAG, "checkArgs fail, packageid or thumburl is invalid");
        return false;
    }

    @Override
    public void serialize(Bundle bundle) {
        bundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
        bundle.putInt("_wxemojisharedobject_designer_uin", this.designerUIN);
        bundle.putString("_wxemojisharedobject_designer_name", this.designerName);
        bundle.putString("_wxemojisharedobject_designer_rediretcturl", this.designerRediretctUrl);
        bundle.putString("_wxemojisharedobject_url", this.url);
    }

    @Override
    public int type() {
        return 25;
    }

    @Override
    public void unserialize(Bundle bundle) {
        this.thumburl = bundle.getString("_wxwebpageobject_thumburl");
        this.designerUIN = bundle.getInt("_wxemojisharedobject_designer_uin");
        this.designerName = bundle.getString("_wxemojisharedobject_designer_name");
        this.designerRediretctUrl = bundle.getString("_wxemojisharedobject_designer_rediretcturl");
        this.url = bundle.getString("_wxwebpageobject_url");
    }
}

