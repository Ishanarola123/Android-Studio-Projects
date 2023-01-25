/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Short
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Map
 */
package com.xiaomi.scanner.camera.exif;

import com.xiaomi.scanner.camera.exif.ExifInterface;
import com.xiaomi.scanner.camera.exif.ExifTag;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class IfdData {
    private static final int[] sIfds = new int[]{0, 1, 2, 3, 4};
    private final Map<Short, ExifTag> mExifTags = new HashMap();
    private final int mIfdId;
    private int mOffsetToNextIfd = 0;

    IfdData(int n2) {
        this.mIfdId = n2;
    }

    protected static int[] getIfds() {
        return sIfds;
    }

    protected boolean checkCollision(short s2) {
        return this.mExifTags.get((Object)s2) != null;
    }

    public boolean equals(Object object) {
        IfdData ifdData;
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof IfdData && (ifdData = (IfdData)object).getId() == this.mIfdId && ifdData.getTagCount() == this.getTagCount()) {
            for (ExifTag exifTag : ifdData.getAllTags()) {
                if (ExifInterface.isOffsetTag(exifTag.getTagId()) || exifTag.equals((ExifTag)this.mExifTags.get((Object)exifTag.getTagId()))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    protected ExifTag[] getAllTags() {
        return (ExifTag[])this.mExifTags.values().toArray((Object[])new ExifTag[this.mExifTags.size()]);
    }

    protected int getId() {
        return this.mIfdId;
    }

    protected int getOffsetToNextIfd() {
        return this.mOffsetToNextIfd;
    }

    protected ExifTag getTag(short s2) {
        return (ExifTag)this.mExifTags.get((Object)s2);
    }

    protected int getTagCount() {
        return this.mExifTags.size();
    }

    protected void removeTag(short s2) {
        this.mExifTags.remove((Object)s2);
    }

    protected void setOffsetToNextIfd(int n2) {
        this.mOffsetToNextIfd = n2;
    }

    protected ExifTag setTag(ExifTag exifTag) {
        exifTag.setIfd(this.mIfdId);
        return (ExifTag)this.mExifTags.put((Object)exifTag.getTagId(), (Object)exifTag);
    }
}

