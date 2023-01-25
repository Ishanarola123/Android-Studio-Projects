/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXVideoObject
implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXVideoObject";
    public String videoLowBandUrl;
    public String videoUrl;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean checkArgs() {
        String string;
        String string2;
        String string3 = this.videoUrl;
        if (string3 != null && string3.length() != 0 || (string2 = this.videoLowBandUrl) != null && string2.length() != 0) {
            String string4 = this.videoUrl;
            if (string4 != null && string4.length() > 10240) {
                string = "checkArgs fail, videoUrl is too long";
            } else {
                String string5 = this.videoLowBandUrl;
                if (string5 == null) return true;
                if (string5.length() <= 10240) return true;
                string = "checkArgs fail, videoLowBandUrl is too long";
            }
        } else {
            string = "both arguments are null";
        }
        Log.e(TAG, string);
        return false;
    }

    @Override
    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
        bundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
    }

    @Override
    public int type() {
        return 4;
    }

    @Override
    public void unserialize(Bundle bundle) {
        this.videoUrl = bundle.getString("_wxvideoobject_videoUrl");
        this.videoLowBandUrl = bundle.getString("_wxvideoobject_videoLowBandUrl");
    }
}

