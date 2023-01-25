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

public class WXMusicObject
implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXMusicObject";
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean checkArgs() {
        String string;
        String string2;
        String string3 = this.musicUrl;
        if (string3 != null && string3.length() != 0 || (string2 = this.musicLowBandUrl) != null && string2.length() != 0) {
            String string4 = this.musicUrl;
            if (string4 != null && string4.length() > 10240) {
                string = "checkArgs fail, musicUrl is too long";
            } else {
                String string5 = this.musicLowBandUrl;
                if (string5 == null) return true;
                if (string5.length() <= 10240) return true;
                string = "checkArgs fail, musicLowBandUrl is too long";
            }
        } else {
            string = "both arguments are null";
        }
        Log.e(TAG, string);
        return false;
    }

    @Override
    public void serialize(Bundle bundle) {
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
    }

    @Override
    public int type() {
        return 3;
    }

    @Override
    public void unserialize(Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
    }
}

