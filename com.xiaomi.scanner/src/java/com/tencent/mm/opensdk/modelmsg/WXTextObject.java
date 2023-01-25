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

public class WXTextObject
implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXTextObject";
    public String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String string) {
        this.text = string;
    }

    @Override
    public boolean checkArgs() {
        String string = this.text;
        if (string != null && string.length() != 0 && this.text.length() <= 10240) {
            return true;
        }
        Log.e(TAG, "checkArgs fail, text is invalid");
        return false;
    }

    @Override
    public void serialize(Bundle bundle) {
        bundle.putString("_wxtextobject_text", this.text);
    }

    @Override
    public int type() {
        return 1;
    }

    @Override
    public void unserialize(Bundle bundle) {
        this.text = bundle.getString("_wxtextobject_text");
    }
}

