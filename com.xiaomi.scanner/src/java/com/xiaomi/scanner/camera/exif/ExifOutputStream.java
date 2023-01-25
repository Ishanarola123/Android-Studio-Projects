/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.io.BufferedOutputStream
 *  java.io.FilterOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.scanner.camera.exif;

import com.xiaomi.scanner.camera.exif.ExifData;
import com.xiaomi.scanner.camera.exif.ExifInterface;
import com.xiaomi.scanner.camera.exif.ExifTag;
import com.xiaomi.scanner.camera.exif.IfdData;
import com.xiaomi.scanner.camera.exif.JpegHeader;
import com.xiaomi.scanner.camera.exif.OrderedDataOutputStream;
import com.xiaomi.scanner.camera.exif.Rational;
import com.xiaomi.scanner.debug.Log;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

class ExifOutputStream
extends FilterOutputStream {
    private static final boolean DEBUG = false;
    private static final int EXIF_HEADER = 1165519206;
    private static final int MAX_EXIF_SIZE = 65535;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final Log.Tag TAG = new Log.Tag("ExifOutputStream");
    private static final short TAG_SIZE = 12;
    private static final short TIFF_BIG_ENDIAN = 19789;
    private static final short TIFF_HEADER = 42;
    private static final short TIFF_HEADER_SIZE = 8;
    private static final short TIFF_LITTLE_ENDIAN = 18761;
    private ByteBuffer mBuffer = ByteBuffer.allocate((int)4);
    private int mByteToCopy;
    private int mByteToSkip;
    private ExifData mExifData;
    private final ExifInterface mInterface;
    private byte[] mSingleByteArray = new byte[1];
    private int mState = 0;

    protected ExifOutputStream(OutputStream outputStream, ExifInterface exifInterface) {
        super((OutputStream)new BufferedOutputStream(outputStream, 65536));
        this.mInterface = exifInterface;
    }

    private int calculateAllOffset() {
        IfdData ifdData;
        IfdData ifdData2;
        ExifData exifData = this.mExifData;
        int n2 = 0;
        IfdData ifdData3 = exifData.getIfdData(0);
        int n3 = this.calculateOffsetOfIfd(ifdData3, 8);
        ifdData3.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_EXIF_IFD)).setValue(n3);
        IfdData ifdData4 = this.mExifData.getIfdData(2);
        int n4 = this.calculateOffsetOfIfd(ifdData4, n3);
        IfdData ifdData5 = this.mExifData.getIfdData(3);
        if (ifdData5 != null) {
            ifdData4.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_INTEROPERABILITY_IFD)).setValue(n4);
            n4 = this.calculateOffsetOfIfd(ifdData5, n4);
        }
        if ((ifdData = this.mExifData.getIfdData(4)) != null) {
            ifdData3.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_GPS_IFD)).setValue(n4);
            n4 = this.calculateOffsetOfIfd(ifdData, n4);
        }
        if ((ifdData2 = this.mExifData.getIfdData(1)) != null) {
            ifdData3.setOffsetToNextIfd(n4);
            n4 = this.calculateOffsetOfIfd(ifdData2, n4);
        }
        if (this.mExifData.hasCompressedThumbnail()) {
            ifdData2.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)).setValue(n4);
            return n4 + this.mExifData.getCompressedThumbnail().length;
        }
        if (this.mExifData.hasUncompressedStrip()) {
            long[] arrl = new long[this.mExifData.getStripCount()];
            while (n2 < this.mExifData.getStripCount()) {
                arrl[n2] = n4;
                n4 += this.mExifData.getStrip(n2).length;
                ++n2;
            }
            ifdData2.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_OFFSETS)).setValue(arrl);
        }
        return n4;
    }

    private int calculateOffsetOfIfd(IfdData ifdData, int n2) {
        int n3 = n2 + (4 + (2 + 12 * ifdData.getTagCount()));
        for (ExifTag exifTag : ifdData.getAllTags()) {
            if (exifTag.getDataSize() <= 4) continue;
            exifTag.setOffset(n3);
            n3 += exifTag.getDataSize();
        }
        return n3;
    }

    private void createRequiredIfdAndTag() throws IOException {
        ExifTag exifTag;
        ExifData exifData = this.mExifData;
        int n2 = 0;
        IfdData ifdData = exifData.getIfdData(0);
        if (ifdData == null) {
            ifdData = new IfdData(0);
            this.mExifData.addIfdData(ifdData);
        }
        if ((exifTag = this.mInterface.buildUninitializedTag(ExifInterface.TAG_EXIF_IFD)) != null) {
            ifdData.setTag(exifTag);
            IfdData ifdData2 = this.mExifData.getIfdData(2);
            if (ifdData2 == null) {
                ifdData2 = new IfdData(2);
                this.mExifData.addIfdData(ifdData2);
            }
            if (this.mExifData.getIfdData(4) != null) {
                ExifTag exifTag2 = this.mInterface.buildUninitializedTag(ExifInterface.TAG_GPS_IFD);
                if (exifTag2 != null) {
                    ifdData.setTag(exifTag2);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No definition for crucial exif tag: ");
                    stringBuilder.append(ExifInterface.TAG_GPS_IFD);
                    throw new IOException(stringBuilder.toString());
                }
            }
            if (this.mExifData.getIfdData(3) != null) {
                ExifTag exifTag3 = this.mInterface.buildUninitializedTag(ExifInterface.TAG_INTEROPERABILITY_IFD);
                if (exifTag3 != null) {
                    ifdData2.setTag(exifTag3);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No definition for crucial exif tag: ");
                    stringBuilder.append(ExifInterface.TAG_INTEROPERABILITY_IFD);
                    throw new IOException(stringBuilder.toString());
                }
            }
            IfdData ifdData3 = this.mExifData.getIfdData(1);
            if (this.mExifData.hasCompressedThumbnail()) {
                ExifTag exifTag4;
                if (ifdData3 == null) {
                    ifdData3 = new IfdData(1);
                    this.mExifData.addIfdData(ifdData3);
                }
                if ((exifTag4 = this.mInterface.buildUninitializedTag(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
                    ifdData3.setTag(exifTag4);
                    ExifTag exifTag5 = this.mInterface.buildUninitializedTag(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
                    if (exifTag5 != null) {
                        exifTag5.setValue(this.mExifData.getCompressedThumbnail().length);
                        ifdData3.setTag(exifTag5);
                        ifdData3.removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_OFFSETS));
                        ifdData3.removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_BYTE_COUNTS));
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No definition for crucial exif tag: ");
                    stringBuilder.append(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
                    throw new IOException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No definition for crucial exif tag: ");
                stringBuilder.append(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
                throw new IOException(stringBuilder.toString());
            }
            if (this.mExifData.hasUncompressedStrip()) {
                if (ifdData3 == null) {
                    ifdData3 = new IfdData(1);
                    this.mExifData.addIfdData(ifdData3);
                }
                int n3 = this.mExifData.getStripCount();
                ExifTag exifTag6 = this.mInterface.buildUninitializedTag(ExifInterface.TAG_STRIP_OFFSETS);
                if (exifTag6 != null) {
                    ExifTag exifTag7 = this.mInterface.buildUninitializedTag(ExifInterface.TAG_STRIP_BYTE_COUNTS);
                    if (exifTag7 != null) {
                        long[] arrl = new long[n3];
                        while (n2 < this.mExifData.getStripCount()) {
                            arrl[n2] = this.mExifData.getStrip(n2).length;
                            ++n2;
                        }
                        exifTag7.setValue(arrl);
                        ifdData3.setTag(exifTag6);
                        ifdData3.setTag(exifTag7);
                        ifdData3.removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
                        ifdData3.removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No definition for crucial exif tag: ");
                    stringBuilder.append(ExifInterface.TAG_STRIP_BYTE_COUNTS);
                    throw new IOException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No definition for crucial exif tag: ");
                stringBuilder.append(ExifInterface.TAG_STRIP_OFFSETS);
                throw new IOException(stringBuilder.toString());
            }
            if (ifdData3 != null) {
                ifdData3.removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_OFFSETS));
                ifdData3.removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_BYTE_COUNTS));
                ifdData3.removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
                ifdData3.removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No definition for crucial exif tag: ");
        stringBuilder.append(ExifInterface.TAG_EXIF_IFD);
        throw new IOException(stringBuilder.toString());
    }

    private int requestByteToBuffer(int n2, byte[] arrby, int n3, int n4) {
        int n5 = n2 - this.mBuffer.position();
        if (n4 <= n5) {
            n5 = n4;
        }
        this.mBuffer.put(arrby, n3, n5);
        return n5;
    }

    private ArrayList<ExifTag> stripNullValueTags(ExifData exifData) {
        ArrayList arrayList = new ArrayList();
        for (ExifTag exifTag : exifData.getAllTags()) {
            if (exifTag.getValue() != null || ExifInterface.isOffsetTag(exifTag.getTagId())) continue;
            exifData.removeTag(exifTag.getTagId(), exifTag.getIfd());
            arrayList.add((Object)exifTag);
        }
        return arrayList;
    }

    private void writeAllTags(OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        IfdData ifdData;
        this.writeIfd(this.mExifData.getIfdData(0), orderedDataOutputStream);
        this.writeIfd(this.mExifData.getIfdData(2), orderedDataOutputStream);
        IfdData ifdData2 = this.mExifData.getIfdData(3);
        if (ifdData2 != null) {
            this.writeIfd(ifdData2, orderedDataOutputStream);
        }
        if ((ifdData = this.mExifData.getIfdData(4)) != null) {
            this.writeIfd(ifdData, orderedDataOutputStream);
        }
        if (this.mExifData.getIfdData(1) != null) {
            this.writeIfd(this.mExifData.getIfdData(1), orderedDataOutputStream);
        }
    }

    private void writeExifData() throws IOException {
        ExifData exifData = this.mExifData;
        if (exifData == null) {
            return;
        }
        ArrayList<ExifTag> arrayList = this.stripNullValueTags(exifData);
        this.createRequiredIfdAndTag();
        int n2 = 8 + this.calculateAllOffset();
        if (n2 <= 65535) {
            OrderedDataOutputStream orderedDataOutputStream = new OrderedDataOutputStream(this.out);
            orderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
            orderedDataOutputStream.writeShort((short)-31);
            orderedDataOutputStream.writeShort((short)n2);
            orderedDataOutputStream.writeInt(1165519206);
            orderedDataOutputStream.writeShort((short)0);
            if (this.mExifData.getByteOrder() == ByteOrder.BIG_ENDIAN) {
                orderedDataOutputStream.writeShort((short)19789);
            } else {
                orderedDataOutputStream.writeShort((short)18761);
            }
            orderedDataOutputStream.setByteOrder(this.mExifData.getByteOrder());
            orderedDataOutputStream.writeShort((short)42);
            orderedDataOutputStream.writeInt(8);
            this.writeAllTags(orderedDataOutputStream);
            this.writeThumbnail(orderedDataOutputStream);
            for (ExifTag exifTag : arrayList) {
                this.mExifData.addTag(exifTag);
            }
            return;
        }
        throw new IOException("Exif header is too large (>64Kb)");
    }

    private void writeIfd(IfdData ifdData, OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        ExifTag[] arrexifTag = ifdData.getAllTags();
        orderedDataOutputStream.writeShort((short)arrexifTag.length);
        int n2 = arrexifTag.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            ExifTag exifTag = arrexifTag[i2];
            orderedDataOutputStream.writeShort(exifTag.getTagId());
            orderedDataOutputStream.writeShort(exifTag.getDataType());
            orderedDataOutputStream.writeInt(exifTag.getComponentCount());
            if (exifTag.getDataSize() > 4) {
                orderedDataOutputStream.writeInt(exifTag.getOffset());
                continue;
            }
            ExifOutputStream.writeTagValue(exifTag, orderedDataOutputStream);
            int n4 = 4 - exifTag.getDataSize();
            for (int i3 = 0; i3 < n4; ++i3) {
                orderedDataOutputStream.write(0);
            }
        }
        orderedDataOutputStream.writeInt(ifdData.getOffsetToNextIfd());
        int n5 = arrexifTag.length;
        while (n3 < n5) {
            ExifTag exifTag = arrexifTag[n3];
            if (exifTag.getDataSize() > 4) {
                ExifOutputStream.writeTagValue(exifTag, orderedDataOutputStream);
            }
            ++n3;
        }
    }

    static void writeTagValue(ExifTag exifTag, OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        short s2 = exifTag.getDataType();
        switch (s2) {
            int n2;
            default: {
                return;
            }
            case 5: 
            case 10: {
                int n3 = exifTag.getComponentCount();
                for (n2 = 0; n2 < n3; ++n2) {
                    orderedDataOutputStream.writeRational(exifTag.getRational(n2));
                }
                break;
            }
            case 4: 
            case 9: {
                int n4 = exifTag.getComponentCount();
                while (n2 < n4) {
                    orderedDataOutputStream.writeInt((int)exifTag.getValueAt(n2));
                    ++n2;
                }
                break;
            }
            case 3: {
                int n5 = exifTag.getComponentCount();
                while (n2 < n5) {
                    orderedDataOutputStream.writeShort((short)exifTag.getValueAt(n2));
                    ++n2;
                }
                break;
            }
            case 2: {
                byte[] arrby = exifTag.getStringByte();
                if (arrby.length == exifTag.getComponentCount()) {
                    arrby[-1 + arrby.length] = 0;
                    orderedDataOutputStream.write(arrby);
                    return;
                }
                orderedDataOutputStream.write(arrby);
                orderedDataOutputStream.write(0);
                return;
            }
            case 1: 
            case 7: {
                byte[] arrby = new byte[exifTag.getComponentCount()];
                exifTag.getBytes(arrby);
                orderedDataOutputStream.write(arrby);
            }
        }
    }

    private void writeThumbnail(OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        if (this.mExifData.hasCompressedThumbnail()) {
            orderedDataOutputStream.write(this.mExifData.getCompressedThumbnail());
            return;
        }
        if (this.mExifData.hasUncompressedStrip()) {
            for (int i2 = 0; i2 < this.mExifData.getStripCount(); ++i2) {
                orderedDataOutputStream.write(this.mExifData.getStrip(i2));
            }
        }
    }

    protected ExifData getExifData() {
        return this.mExifData;
    }

    protected void setExifData(ExifData exifData) {
        this.mExifData = exifData;
    }

    public void write(int n2) throws IOException {
        byte[] arrby = this.mSingleByteArray;
        arrby[0] = (byte)(n2 & 255);
        this.write(arrby);
    }

    public void write(byte[] arrby) throws IOException {
        this.write(arrby, 0, arrby.length);
    }

    public void write(byte[] arrby, int n2, int n3) throws IOException {
        while ((this.mByteToSkip > 0 || this.mByteToCopy > 0 || this.mState != 2) && n3 > 0) {
            int n4;
            int n5 = this.mByteToSkip;
            if (n5 > 0) {
                if (n3 <= n5) {
                    n5 = n3;
                }
                n3 -= n5;
                this.mByteToSkip -= n5;
                n2 += n5;
            }
            if ((n4 = this.mByteToCopy) > 0) {
                if (n3 <= n4) {
                    n4 = n3;
                }
                this.out.write(arrby, n2, n4);
                n3 -= n4;
                this.mByteToCopy -= n4;
                n2 += n4;
            }
            if (n3 == 0) {
                return;
            }
            int n6 = this.mState;
            if (n6 != 0) {
                if (n6 != 1) continue;
                int n7 = this.requestByteToBuffer(4, arrby, n2, n3);
                n2 += n7;
                n3 -= n7;
                if (this.mBuffer.position() == 2 && this.mBuffer.getShort() == -39) {
                    this.out.write(this.mBuffer.array(), 0, 2);
                    this.mBuffer.rewind();
                }
                if (this.mBuffer.position() < 4) {
                    return;
                }
                this.mBuffer.rewind();
                short s2 = this.mBuffer.getShort();
                if (s2 == -31) {
                    this.mByteToSkip = (65535 & this.mBuffer.getShort()) - 2;
                    this.mState = 2;
                } else if (!JpegHeader.isSofMarker(s2)) {
                    this.out.write(this.mBuffer.array(), 0, 4);
                    this.mByteToCopy = (65535 & this.mBuffer.getShort()) - 2;
                } else {
                    this.out.write(this.mBuffer.array(), 0, 4);
                    this.mState = 2;
                }
                this.mBuffer.rewind();
                continue;
            }
            int n8 = this.requestByteToBuffer(2, arrby, n2, n3);
            n2 += n8;
            n3 -= n8;
            if (this.mBuffer.position() < 2) {
                return;
            }
            this.mBuffer.rewind();
            if (this.mBuffer.getShort() == -40) {
                this.out.write(this.mBuffer.array(), 0, 2);
                this.mState = 1;
                this.mBuffer.rewind();
                this.writeExifData();
                continue;
            }
            throw new IOException("Not a valid jpeg image, cannot write exif");
        }
        if (n3 > 0) {
            this.out.write(arrby, n2, n3);
        }
    }
}

