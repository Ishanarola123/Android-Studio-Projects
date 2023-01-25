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

public class WXVideoFileObject
implements WXMediaMessage.IMediaObject {
    private static final int FILE_SIZE_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXVideoFileObject";
    public static final int WXVideoFileShareSceneCommon = 0;
    public static final int WXVideoFileShareSceneFromWX = 1;
    public String filePath;
    public int shareScene = 0;
    public String shareTicket;

    public WXVideoFileObject() {
        this.filePath = null;
    }

    public WXVideoFileObject(String string) {
        this.filePath = string;
    }

    private int getFileSize(String string) {
        if (string != null) {
            if (string.length() == 0) {
                return 0;
            }
            File file = new File(string);
            if (!file.exists()) {
                return 0;
            }
            return (int)file.length();
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean checkArgs() {
        String string;
        String string2 = this.filePath;
        if (string2 != null && string2.length() != 0) {
            if (this.getFileSize(this.filePath) <= 10485760) {
                return true;
            }
            string = "checkArgs fail, video file size is too large";
        } else {
            string = "checkArgs fail, filePath is null";
        }
        Log.e(TAG, string);
        return false;
    }

    @Override
    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putInt("_wxvideofileobject_shareScene", this.shareScene);
        bundle.putString("_wxvideofileobject_shareTicketh", this.shareTicket);
    }

    @Override
    public int type() {
        return 38;
    }

    @Override
    public void unserialize(Bundle bundle) {
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.shareScene = bundle.getInt("_wxvideofileobject_shareScene", 0);
        this.shareTicket = bundle.getString("_wxvideofileobject_shareTicketh");
    }
}

