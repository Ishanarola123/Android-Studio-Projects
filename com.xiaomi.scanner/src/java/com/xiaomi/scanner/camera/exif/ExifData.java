/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.ByteOrder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 */
package com.xiaomi.scanner.camera.exif;

import com.xiaomi.scanner.camera.exif.ExifInterface;
import com.xiaomi.scanner.camera.exif.ExifTag;
import com.xiaomi.scanner.camera.exif.IfdData;
import com.xiaomi.scanner.debug.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExifData {
    private static final Log.Tag TAG = new Log.Tag("ExifData");
    private static final byte[] USER_COMMENT_ASCII = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
    private static final byte[] USER_COMMENT_JIS = new byte[]{74, 73, 83, 0, 0, 0, 0, 0};
    private static final byte[] USER_COMMENT_UNICODE = new byte[]{85, 78, 73, 67, 79, 68, 69, 0};
    private final ByteOrder mByteOrder;
    private final IfdData[] mIfdDatas = new IfdData[5];
    private ArrayList<byte[]> mStripBytes = new ArrayList();
    private byte[] mThumbnail;

    ExifData(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    protected void addIfdData(IfdData ifdData) {
        this.mIfdDatas[ifdData.getId()] = ifdData;
    }

    protected ExifTag addTag(ExifTag exifTag) {
        if (exifTag != null) {
            return this.addTag(exifTag, exifTag.getIfd());
        }
        return null;
    }

    protected ExifTag addTag(ExifTag exifTag, int n2) {
        if (exifTag != null && ExifTag.isValidIfd(n2)) {
            return this.getOrCreateIfdData(n2).setTag(exifTag);
        }
        return null;
    }

    protected void clearThumbnailAndStrips() {
        this.mThumbnail = null;
        this.mStripBytes.clear();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof ExifData) {
            ExifData exifData = (ExifData)object;
            if (exifData.mByteOrder == this.mByteOrder && exifData.mStripBytes.size() == this.mStripBytes.size()) {
                if (!Arrays.equals((byte[])exifData.mThumbnail, (byte[])this.mThumbnail)) {
                    return false;
                }
                for (int i2 = 0; i2 < this.mStripBytes.size(); ++i2) {
                    if (Arrays.equals((byte[])((byte[])exifData.mStripBytes.get(i2)), (byte[])((byte[])this.mStripBytes.get(i2)))) continue;
                    return false;
                }
                for (int i3 = 0; i3 < 5; ++i3) {
                    IfdData ifdData;
                    IfdData ifdData2 = exifData.getIfdData(i3);
                    if (ifdData2 == (ifdData = this.getIfdData(i3)) || ifdData2 == null || ifdData2.equals(ifdData)) continue;
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    protected List<ExifTag> getAllTags() {
        ArrayList arrayList = new ArrayList();
        for (IfdData ifdData : this.mIfdDatas) {
            ExifTag[] arrexifTag;
            if (ifdData == null || (arrexifTag = ifdData.getAllTags()) == null) continue;
            int n2 = arrexifTag.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrayList.add((Object)arrexifTag[i2]);
            }
        }
        return arrayList;
    }

    protected List<ExifTag> getAllTagsForIfd(int n2) {
        IfdData ifdData = this.mIfdDatas[n2];
        if (ifdData == null) {
            return null;
        }
        ExifTag[] arrexifTag = ifdData.getAllTags();
        if (arrexifTag == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(arrexifTag.length);
        int n3 = arrexifTag.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            arrayList.add((Object)arrexifTag[i2]);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    protected List<ExifTag> getAllTagsForTagId(short s2) {
        ArrayList arrayList = new ArrayList();
        for (IfdData ifdData : this.mIfdDatas) {
            ExifTag exifTag;
            if (ifdData == null || (exifTag = ifdData.getTag(s2)) == null) continue;
            arrayList.add((Object)exifTag);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    protected ByteOrder getByteOrder() {
        return this.mByteOrder;
    }

    protected byte[] getCompressedThumbnail() {
        return this.mThumbnail;
    }

    protected IfdData getIfdData(int n2) {
        if (ExifTag.isValidIfd(n2)) {
            return this.mIfdDatas[n2];
        }
        return null;
    }

    protected IfdData getOrCreateIfdData(int n2) {
        IfdData ifdData = this.mIfdDatas[n2];
        if (ifdData == null) {
            this.mIfdDatas[n2] = ifdData = new IfdData(n2);
        }
        return ifdData;
    }

    protected byte[] getStrip(int n2) {
        return (byte[])this.mStripBytes.get(n2);
    }

    protected int getStripCount() {
        return this.mStripBytes.size();
    }

    protected ExifTag getTag(short s2, int n2) {
        IfdData ifdData = this.mIfdDatas[n2];
        if (ifdData == null) {
            return null;
        }
        return ifdData.getTag(s2);
    }

    protected String getUserComment() {
        IfdData ifdData = this.mIfdDatas[0];
        if (ifdData == null) {
            return null;
        }
        ExifTag exifTag = ifdData.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_USER_COMMENT));
        if (exifTag == null) {
            return null;
        }
        if (exifTag.getComponentCount() < 8) {
            return null;
        }
        byte[] arrby = new byte[exifTag.getComponentCount()];
        exifTag.getBytes(arrby);
        byte[] arrby2 = new byte[8];
        System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)8);
        try {
            if (Arrays.equals((byte[])arrby2, (byte[])USER_COMMENT_ASCII)) {
                return new String(arrby, 8, arrby.length - 8, "US-ASCII");
            }
            if (Arrays.equals((byte[])arrby2, (byte[])USER_COMMENT_JIS)) {
                return new String(arrby, 8, arrby.length - 8, "EUC-JP");
            }
            if (Arrays.equals((byte[])arrby2, (byte[])USER_COMMENT_UNICODE)) {
                String string2 = new String(arrby, 8, arrby.length - 8, "UTF-16");
                return string2;
            }
            return null;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            Log.w((Log.Tag)TAG, (String)"Failed to decode the user comment");
            return null;
        }
    }

    protected boolean hasCompressedThumbnail() {
        return this.mThumbnail != null;
    }

    protected boolean hasUncompressedStrip() {
        return this.mStripBytes.size() != 0;
    }

    protected void removeTag(short s2, int n2) {
        IfdData ifdData = this.mIfdDatas[n2];
        if (ifdData == null) {
            return;
        }
        ifdData.removeTag(s2);
    }

    protected void removeThumbnailData() {
        this.clearThumbnailAndStrips();
        this.mIfdDatas[1] = null;
    }

    protected void setCompressedThumbnail(byte[] arrby) {
        this.mThumbnail = arrby;
    }

    protected void setStripBytes(int n2, byte[] arrby) {
        if (n2 < this.mStripBytes.size()) {
            this.mStripBytes.set(n2, (Object)arrby);
            return;
        }
        for (int i2 = this.mStripBytes.size(); i2 < n2; ++i2) {
            this.mStripBytes.add(null);
        }
        this.mStripBytes.add((Object)arrby);
    }
}

