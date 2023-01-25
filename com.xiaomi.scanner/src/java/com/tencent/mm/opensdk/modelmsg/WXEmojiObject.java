/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public class WXEmojiObject
implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
        this.emojiData = null;
        this.emojiPath = null;
    }

    public WXEmojiObject(String string2) {
        this.emojiPath = string2;
    }

    public WXEmojiObject(byte[] arrby) {
        this.emojiData = arrby;
    }

    private int getFileSize(String string2) {
        if (string2 != null) {
            if (string2.length() == 0) {
                return 0;
            }
            File file = new File(string2);
            if (!file.exists()) {
                return 0;
            }
            return (int)file.length();
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean checkArgs() {
        String string2;
        String string3;
        byte[] arrby = this.emojiData;
        if (arrby != null && arrby.length != 0 || (string3 = this.emojiPath) != null && string3.length() != 0) {
            byte[] arrby2 = this.emojiData;
            if (arrby2 != null && arrby2.length > 10485760) {
                string2 = "checkArgs fail, emojiData is too large";
            } else {
                String string4 = this.emojiPath;
                if (string4 == null) return true;
                if (this.getFileSize(string4) <= 10485760) return true;
                string2 = "checkArgs fail, emojiSize is too large";
            }
        } else {
            string2 = "checkArgs fail, both arguments is null";
        }
        Log.e(TAG, string2);
        return false;
    }

    @Override
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
    }

    public void setEmojiData(byte[] arrby) {
        this.emojiData = arrby;
    }

    public void setEmojiPath(String string2) {
        this.emojiPath = string2;
    }

    @Override
    public int type() {
        return 8;
    }

    @Override
    public void unserialize(Bundle bundle) {
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }
}

