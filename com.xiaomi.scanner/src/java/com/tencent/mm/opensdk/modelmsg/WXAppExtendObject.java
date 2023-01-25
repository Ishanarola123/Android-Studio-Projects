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

public class WXAppExtendObject
implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int EXTINFO_LENGTH_LIMIT = 2048;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(String string2, String string3) {
        this.extInfo = string2;
        this.filePath = string3;
    }

    public WXAppExtendObject(String string2, byte[] arrby) {
        this.extInfo = string2;
        this.fileData = arrby;
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
        byte[] arrby;
        String string3;
        String string4 = this.extInfo;
        if (string4 != null && string4.length() != 0 || (string2 = this.filePath) != null && string2.length() != 0 || (arrby = this.fileData) != null && arrby.length != 0) {
            String string5 = this.extInfo;
            if (string5 != null && string5.length() > 2048) {
                string3 = "checkArgs fail, extInfo is invalid";
            } else {
                String string6 = this.filePath;
                if (string6 != null && string6.length() > 10240) {
                    string3 = "checkArgs fail, filePath is invalid";
                } else {
                    String string7 = this.filePath;
                    if (string7 != null && this.getFileSize(string7) > 10485760) {
                        string3 = "checkArgs fail, fileSize is too large";
                    } else {
                        byte[] arrby2 = this.fileData;
                        if (arrby2 == null) return true;
                        if (arrby2.length <= 10485760) return true;
                        string3 = "checkArgs fail, fileData is too large";
                    }
                }
            }
        } else {
            string3 = "checkArgs fail, all arguments is null";
        }
        Log.e(TAG, string3);
        return false;
    }

    @Override
    public void serialize(Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    @Override
    public int type() {
        return 7;
    }

    @Override
    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }
}

