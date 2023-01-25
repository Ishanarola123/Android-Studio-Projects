/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteOrder
 */
package com.xiaomi.scanner.camera.exif;

import com.xiaomi.scanner.camera.exif.ExifData;
import com.xiaomi.scanner.camera.exif.ExifInterface;
import com.xiaomi.scanner.camera.exif.ExifInvalidFormatException;
import com.xiaomi.scanner.camera.exif.ExifParser;
import com.xiaomi.scanner.camera.exif.ExifTag;
import com.xiaomi.scanner.camera.exif.IfdData;
import com.xiaomi.scanner.debug.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

class ExifReader {
    private static final Log.Tag TAG = new Log.Tag("ExifReader");
    private final ExifInterface mInterface;

    ExifReader(ExifInterface exifInterface) {
        this.mInterface = exifInterface;
    }

    protected ExifData read(InputStream inputStream) throws ExifInvalidFormatException, IOException {
        ExifParser exifParser = ExifParser.parse(inputStream, this.mInterface);
        ExifData exifData = new ExifData(exifParser.getByteOrder());
        int n2 = exifParser.next();
        while (n2 != 5) {
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 == 4) {
                                byte[] arrby = new byte[exifParser.getStripSize()];
                                if (arrby.length == exifParser.read(arrby)) {
                                    exifData.setStripBytes(exifParser.getStripIndex(), arrby);
                                } else {
                                    Log.w((Log.Tag)TAG, (String)"Failed to read the strip bytes");
                                }
                            }
                        } else {
                            byte[] arrby = new byte[exifParser.getCompressedImageSize()];
                            if (arrby.length == exifParser.read(arrby)) {
                                exifData.setCompressedThumbnail(arrby);
                            } else {
                                Log.w((Log.Tag)TAG, (String)"Failed to read the compressed thumbnail");
                            }
                        }
                    } else {
                        ExifTag exifTag = exifParser.getTag();
                        if (exifTag.getDataType() == 7) {
                            exifParser.readFullTagValue(exifTag);
                        }
                        exifData.getIfdData(exifTag.getIfd()).setTag(exifTag);
                    }
                } else {
                    ExifTag exifTag = exifParser.getTag();
                    if (!exifTag.hasValue()) {
                        exifParser.registerForTagValue(exifTag);
                    } else {
                        exifData.getIfdData(exifTag.getIfd()).setTag(exifTag);
                    }
                }
            } else {
                exifData.addIfdData(new IfdData(exifParser.getCurrentIfd()));
            }
            n2 = exifParser.next();
        }
        return exifData;
    }
}

