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

public class WXFileObject
implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXFileObject";
    private int contentLengthLimit = 10485760;
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String string) {
        this.filePath = string;
    }

    public WXFileObject(byte[] arrby) {
        this.fileData = arrby;
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
     * Lifted jumps to return sites
     */
    @Override
    public boolean checkArgs() {
        String string;
        String string2;
        byte[] arrby = this.fileData;
        if (arrby != null && arrby.length != 0 || (string2 = this.filePath) != null && string2.length() != 0) {
            byte[] arrby2 = this.fileData;
            if (arrby2 != null && arrby2.length > this.contentLengthLimit) {
                string = "checkArgs fail, fileData is too large";
            } else {
                String string3 = this.filePath;
                if (string3 == null) return true;
                if (this.getFileSize(string3) <= this.contentLengthLimit) return true;
                string = "checkArgs fail, fileSize is too large";
            }
        } else {
            string = "checkArgs fail, both arguments is null";
        }
        Log.e(TAG, string);
        return false;
    }

    @Override
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
    }

    public void setContentLengthLimit(int n) {
        this.contentLengthLimit = n;
    }

    public void setFileData(byte[] arrby) {
        this.fileData = arrby;
    }

    public void setFilePath(String string) {
        this.filePath = string;
    }

    @Override
    public int type() {
        return 6;
    }

    @Override
    public void unserialize(Bundle bundle) {
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
    }
}

