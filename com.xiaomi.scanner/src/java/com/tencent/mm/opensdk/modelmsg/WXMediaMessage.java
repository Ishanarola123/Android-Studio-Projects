/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.os.Bundle
 *  java.io.ByteArrayOutputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
    private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    public static final int THUMB_LENGTH_LIMIT = 32768;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    /*
     * Enabled aggressive block sorting
     */
    final boolean checkArgs() {
        block11 : {
            String string2;
            block3 : {
                block10 : {
                    block9 : {
                        block8 : {
                            block7 : {
                                block6 : {
                                    block5 : {
                                        byte[] arrby;
                                        block4 : {
                                            byte[] arrby2;
                                            block2 : {
                                                byte[] arrby3;
                                                if (this.getType() != 8 || (arrby3 = this.thumbData) != null && arrby3.length != 0) break block2;
                                                string2 = "checkArgs fail, thumbData should not be null when send emoji";
                                                break block3;
                                            }
                                            if (this.getType() != 36 || (arrby2 = this.thumbData) != null && arrby2.length <= 131072) break block4;
                                            string2 = "checkArgs fail, thumbData should not be null or exceed 128kb";
                                            break block3;
                                        }
                                        if (this.getType() == 36 || (arrby = this.thumbData) == null || arrby.length <= 32768) break block5;
                                        string2 = "checkArgs fail, thumbData is invalid";
                                        break block3;
                                    }
                                    String string3 = this.title;
                                    if (string3 == null || string3.length() <= 512) break block6;
                                    string2 = "checkArgs fail, title is invalid";
                                    break block3;
                                }
                                String string4 = this.description;
                                if (string4 == null || string4.length() <= 1024) break block7;
                                string2 = "checkArgs fail, description is invalid";
                                break block3;
                            }
                            if (this.mediaObject != null) break block8;
                            string2 = "checkArgs fail, mediaObject is null";
                            break block3;
                        }
                        String string5 = this.mediaTagName;
                        if (string5 == null || string5.length() <= 64) break block9;
                        string2 = "checkArgs fail, mediaTagName is too long";
                        break block3;
                    }
                    String string6 = this.messageAction;
                    if (string6 == null || string6.length() <= 2048) break block10;
                    string2 = "checkArgs fail, messageAction is too long";
                    break block3;
                }
                String string7 = this.messageExt;
                if (string7 == null || string7.length() <= 2048) break block11;
                string2 = "checkArgs fail, messageExt is too long";
            }
            Log.e(TAG, string2);
            return false;
        }
        return this.mediaObject.checkArgs();
    }

    public final int getType() {
        IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("setThumbImage exception:");
            stringBuilder.append(exception.getMessage());
            Log.e(TAG, stringBuilder.toString());
            return;
        }
    }

    public static class Builder {
        public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

        public static WXMediaMessage fromBundle(Bundle bundle) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            wXMediaMessage.messageAction = bundle.getString("_wxobject_message_action");
            wXMediaMessage.messageExt = bundle.getString("_wxobject_message_ext");
            String string2 = Builder.pathOldToNew(bundle.getString(KEY_IDENTIFIER));
            if (string2 != null) {
                if (string2.length() <= 0) {
                    return wXMediaMessage;
                }
                try {
                    wXMediaMessage.mediaObject = (IMediaObject)Class.forName((String)string2).newInstance();
                    wXMediaMessage.mediaObject.unserialize(bundle);
                    return wXMediaMessage;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder("get media object from bundle failed: unknown ident ");
                    stringBuilder.append(string2);
                    stringBuilder.append(", ex = ");
                    stringBuilder.append(exception.getMessage());
                    Log.e(WXMediaMessage.TAG, stringBuilder.toString());
                }
            }
            return wXMediaMessage;
        }

        private static String pathNewToOld(String string2) {
            if (string2 != null && string2.length() != 0) {
                return string2.replace((CharSequence)"com.tencent.mm.opensdk.modelmsg", (CharSequence)"com.tencent.mm.sdk.openapi");
            }
            Log.e(WXMediaMessage.TAG, "pathNewToOld fail, newPath is null");
            return string2;
        }

        private static String pathOldToNew(String string2) {
            StringBuilder stringBuilder = new StringBuilder("pathOldToNew, oldPath = ");
            stringBuilder.append(string2);
            Log.i(WXMediaMessage.TAG, stringBuilder.toString());
            if (string2 != null && string2.length() != 0) {
                int n2 = string2.lastIndexOf(46);
                if (n2 == -1) {
                    StringBuilder stringBuilder2 = new StringBuilder("pathOldToNew fail, invalid pos, oldPath = ");
                    stringBuilder2.append(string2);
                    Log.e(WXMediaMessage.TAG, stringBuilder2.toString());
                    return string2;
                }
                StringBuilder stringBuilder3 = new StringBuilder("com.tencent.mm.opensdk.modelmsg");
                stringBuilder3.append(string2.substring(n2));
                return stringBuilder3.toString();
            }
            Log.e(WXMediaMessage.TAG, "pathOldToNew fail, oldPath is null");
            return string2;
        }

        public static Bundle toBundle(WXMediaMessage wXMediaMessage) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            if (wXMediaMessage.mediaObject != null) {
                bundle.putString(KEY_IDENTIFIER, Builder.pathNewToOld(wXMediaMessage.mediaObject.getClass().getName()));
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
            bundle.putString("_wxobject_message_action", wXMediaMessage.messageAction);
            bundle.putString("_wxobject_message_ext", wXMediaMessage.messageExt);
            return bundle;
        }
    }

    public static interface IMediaObject {
        public static final int TYPE_APPBRAND = 33;
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_CARD_SHARE = 16;
        public static final int TYPE_DESIGNER_SHARED = 25;
        public static final int TYPE_DEVICE_ACCESS = 12;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_EMOJILIST_SHARED = 27;
        public static final int TYPE_EMOTICON_GIFT = 11;
        public static final int TYPE_EMOTICON_SHARED = 15;
        public static final int TYPE_EMOTIONLIST_SHARED = 26;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_GAME_VIDEO_FILE = 39;
        public static final int TYPE_GIFTCARD = 34;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_LOCATION = 30;
        public static final int TYPE_LOCATION_SHARE = 17;
        public static final int TYPE_MALL_PRODUCT = 13;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_NOTE = 24;
        public static final int TYPE_OLD_TV = 14;
        public static final int TYPE_OPENSDK_APPBRAND = 36;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_RECORD = 19;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_TV = 20;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;
        public static final int TYPE_VIDEO_FILE = 38;

        public boolean checkArgs();

        public void serialize(Bundle var1);

        public int type();

        public void unserialize(Bundle var1);
    }

}

