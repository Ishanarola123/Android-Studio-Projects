/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.ByteOrder
 *  java.nio.charset.Charset
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.TreeMap
 */
package com.xiaomi.scanner.camera.exif;

import android.util.SparseIntArray;
import com.xiaomi.scanner.camera.exif.CountedDataInputStream;
import com.xiaomi.scanner.camera.exif.ExifInterface;
import com.xiaomi.scanner.camera.exif.ExifInvalidFormatException;
import com.xiaomi.scanner.camera.exif.ExifTag;
import com.xiaomi.scanner.camera.exif.JpegHeader;
import com.xiaomi.scanner.camera.exif.Rational;
import com.xiaomi.scanner.debug.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

class ExifParser {
    protected static final short BIG_ENDIAN_TAG = 19789;
    protected static final int DEFAULT_IFD0_OFFSET = 8;
    public static final int EVENT_COMPRESSED_IMAGE = 3;
    public static final int EVENT_END = 5;
    public static final int EVENT_NEW_TAG = 1;
    public static final int EVENT_START_OF_IFD = 0;
    public static final int EVENT_UNCOMPRESSED_STRIP = 4;
    public static final int EVENT_VALUE_OF_REGISTERED_TAG = 2;
    protected static final int EXIF_HEADER = 1165519206;
    protected static final short EXIF_HEADER_TAIL = 0;
    protected static final short LITTLE_ENDIAN_TAG = 18761;
    private static final boolean LOGV = false;
    protected static final int OFFSET_SIZE = 2;
    public static final int OPTION_IFD_0 = 1;
    public static final int OPTION_IFD_1 = 2;
    public static final int OPTION_IFD_EXIF = 4;
    public static final int OPTION_IFD_GPS = 8;
    public static final int OPTION_IFD_INTEROPERABILITY = 16;
    public static final int OPTION_THUMBNAIL = 32;
    private static final Log.Tag TAG = new Log.Tag("ExifParser");
    private static final short TAG_EXIF_IFD = 0;
    private static final short TAG_GPS_IFD = 0;
    private static final short TAG_INTEROPERABILITY_IFD = 0;
    private static final short TAG_JPEG_INTERCHANGE_FORMAT = 0;
    private static final short TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = 0;
    protected static final int TAG_SIZE = 12;
    private static final short TAG_STRIP_BYTE_COUNTS = 0;
    private static final short TAG_STRIP_OFFSETS = 0;
    protected static final short TIFF_HEADER_TAIL = 42;
    private static final Charset US_ASCII = Charset.forName((String)"US-ASCII");
    private int mApp1End;
    private boolean mContainExifData = false;
    private final TreeMap<Integer, Object> mCorrespondingEvent = new TreeMap();
    private byte[] mDataAboveIfd0;
    private int mIfd0Position;
    private int mIfdStartOffset = 0;
    private int mIfdType;
    private ImageEvent mImageEvent;
    private final ExifInterface mInterface;
    private ExifTag mJpegSizeTag;
    private boolean mNeedToParseOffsetsInCurrentIfd;
    private int mNumOfTagInIfd = 0;
    private int mOffsetToApp1EndFromSOF = 0;
    private final int mOptions;
    private int mStripCount;
    private ExifTag mStripSizeTag;
    private ExifTag mTag;
    private int mTiffStartPosition;
    private final CountedDataInputStream mTiffStream;

    static {
        TAG_EXIF_IFD = ExifInterface.getTrueTagKey(ExifInterface.TAG_EXIF_IFD);
        TAG_GPS_IFD = ExifInterface.getTrueTagKey(ExifInterface.TAG_GPS_IFD);
        TAG_INTEROPERABILITY_IFD = ExifInterface.getTrueTagKey(ExifInterface.TAG_INTEROPERABILITY_IFD);
        TAG_JPEG_INTERCHANGE_FORMAT = ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
        TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        TAG_STRIP_OFFSETS = ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_OFFSETS);
        TAG_STRIP_BYTE_COUNTS = ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_BYTE_COUNTS);
    }

    private ExifParser(InputStream inputStream, int n2, ExifInterface exifInterface) throws IOException, ExifInvalidFormatException {
        if (inputStream != null) {
            this.mInterface = exifInterface;
            this.mContainExifData = this.seekTiffData(inputStream);
            this.mTiffStream = new CountedDataInputStream(inputStream);
            this.mOptions = n2;
            if (!this.mContainExifData) {
                return;
            }
            this.parseTiffHeader();
            long l2 = this.mTiffStream.readUnsignedInt();
            if (l2 <= Integer.MAX_VALUE) {
                int n3;
                this.mIfd0Position = n3 = (int)l2;
                this.mIfdType = 0;
                if (this.isIfdRequested(0) || this.needToParseOffsetsInCurrentIfd()) {
                    this.registerIfd(0, l2);
                    if (l2 != 8L) {
                        this.mDataAboveIfd0 = new byte[n3 - 8];
                        this.read(this.mDataAboveIfd0);
                    }
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid offset ");
            stringBuilder.append(l2);
            throw new ExifInvalidFormatException(stringBuilder.toString());
        }
        throw new IOException("Null argument inputStream to ExifParser");
    }

    private boolean checkAllowed(int n2, int n3) {
        int n4 = this.mInterface.getTagInfo().get(n3);
        if (n4 == 0) {
            return false;
        }
        return ExifInterface.isIfdAllowed(n4, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void checkOffsetOrImageTag(ExifTag exifTag) {
        if (exifTag.getComponentCount() == 0) {
            return;
        }
        short s2 = exifTag.getTagId();
        int n2 = exifTag.getIfd();
        if (s2 == TAG_EXIF_IFD && this.checkAllowed(n2, ExifInterface.TAG_EXIF_IFD)) {
            if (!this.isIfdRequested(2) && !this.isIfdRequested(3)) return;
            {
                this.registerIfd(2, exifTag.getValueAt(0));
                return;
            }
        }
        if (s2 == TAG_GPS_IFD && this.checkAllowed(n2, ExifInterface.TAG_GPS_IFD)) {
            if (!this.isIfdRequested(4)) return;
            {
                this.registerIfd(4, exifTag.getValueAt(0));
                return;
            }
        }
        if (s2 == TAG_INTEROPERABILITY_IFD && this.checkAllowed(n2, ExifInterface.TAG_INTEROPERABILITY_IFD)) {
            if (!this.isIfdRequested(3)) return;
            {
                this.registerIfd(3, exifTag.getValueAt(0));
                return;
            }
        }
        if (s2 == TAG_JPEG_INTERCHANGE_FORMAT && this.checkAllowed(n2, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)) {
            if (!this.isThumbnailRequested()) return;
            {
                this.registerCompressedImage(exifTag.getValueAt(0));
                return;
            }
        }
        if (s2 == TAG_JPEG_INTERCHANGE_FORMAT_LENGTH && this.checkAllowed(n2, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH)) {
            if (!this.isThumbnailRequested()) return;
            {
                this.mJpegSizeTag = exifTag;
                return;
            }
        }
        if (s2 == TAG_STRIP_OFFSETS && this.checkAllowed(n2, ExifInterface.TAG_STRIP_OFFSETS)) {
            if (!this.isThumbnailRequested()) return;
            boolean bl = exifTag.hasValue();
            if (!bl) {
                this.mCorrespondingEvent.put((Object)exifTag.getOffset(), (Object)new ExifTagEvent(exifTag, false));
                return;
            }
        } else {
            if (s2 != TAG_STRIP_BYTE_COUNTS || !this.checkAllowed(n2, ExifInterface.TAG_STRIP_BYTE_COUNTS) || !this.isThumbnailRequested() || !exifTag.hasValue()) return;
            this.mStripSizeTag = exifTag;
            return;
        }
        for (int i2 = 0; i2 < exifTag.getComponentCount(); ++i2) {
            if (exifTag.getDataType() == 3) {
                this.registerUncompressedStrip(i2, exifTag.getValueAt(i2));
                continue;
            }
            this.registerUncompressedStrip(i2, exifTag.getValueAt(i2));
        }
    }

    private boolean isIfdRequested(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            return false;
                        }
                        int n3 = 8 & this.mOptions;
                        boolean bl = false;
                        if (n3 != 0) {
                            bl = true;
                        }
                        return bl;
                    }
                    int n4 = 16 & this.mOptions;
                    boolean bl = false;
                    if (n4 != 0) {
                        bl = true;
                    }
                    return bl;
                }
                int n5 = 4 & this.mOptions;
                boolean bl = false;
                if (n5 != 0) {
                    bl = true;
                }
                return bl;
            }
            int n6 = 2 & this.mOptions;
            boolean bl = false;
            if (n6 != 0) {
                bl = true;
            }
            return bl;
        }
        int n7 = 1 & this.mOptions;
        boolean bl = false;
        if (n7 != 0) {
            bl = true;
        }
        return bl;
    }

    private boolean isThumbnailRequested() {
        return (32 & this.mOptions) != 0;
    }

    private boolean needToParseOffsetsInCurrentIfd() {
        boolean bl;
        block7 : {
            block6 : {
                int n2 = this.mIfdType;
                if (n2 != 0) {
                    if (n2 != 1) {
                        if (n2 != 2) {
                            return false;
                        }
                        return this.isIfdRequested(3);
                    }
                    return this.isThumbnailRequested();
                }
                if (this.isIfdRequested(2) || this.isIfdRequested(4) || this.isIfdRequested(3)) break block6;
                boolean bl2 = this.isIfdRequested(1);
                bl = false;
                if (!bl2) break block7;
            }
            bl = true;
        }
        return bl;
    }

    protected static ExifParser parse(InputStream inputStream, int n2, ExifInterface exifInterface) throws IOException, ExifInvalidFormatException {
        return new ExifParser(inputStream, n2, exifInterface);
    }

    protected static ExifParser parse(InputStream inputStream, ExifInterface exifInterface) throws IOException, ExifInvalidFormatException {
        return new ExifParser(inputStream, 63, exifInterface);
    }

    private void parseTiffHeader() throws IOException, ExifInvalidFormatException {
        block6 : {
            block5 : {
                short s2;
                block4 : {
                    s2 = this.mTiffStream.readShort();
                    if (18761 != s2) break block4;
                    this.mTiffStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
                    break block5;
                }
                if (19789 != s2) break block6;
                this.mTiffStream.setByteOrder(ByteOrder.BIG_ENDIAN);
            }
            if (this.mTiffStream.readShort() == 42) {
                return;
            }
            throw new ExifInvalidFormatException("Invalid TIFF header");
        }
        throw new ExifInvalidFormatException("Invalid TIFF header");
    }

    private ExifTag readTag() throws IOException, ExifInvalidFormatException {
        short s2 = this.mTiffStream.readShort();
        short s3 = this.mTiffStream.readShort();
        long l2 = this.mTiffStream.readUnsignedInt();
        if (l2 <= Integer.MAX_VALUE) {
            if (!ExifTag.isValidType(s3)) {
                Log.Tag tag = TAG;
                Object[] arrobject = new Object[]{s2, s3};
                Log.w((Log.Tag)tag, (String)String.format((String)"Tag %04x: Invalid data type %d", (Object[])arrobject));
                this.mTiffStream.skip(4L);
                return null;
            }
            int n2 = (int)l2;
            int n3 = this.mIfdType;
            boolean bl = n2 != 0;
            ExifTag exifTag = new ExifTag(s2, s3, n2, n3, bl);
            int n4 = exifTag.getDataSize();
            if (n4 > 4) {
                long l3 = this.mTiffStream.readUnsignedInt();
                if (l3 <= Integer.MAX_VALUE) {
                    if (l3 < (long)this.mIfd0Position && s3 == 7) {
                        byte[] arrby = new byte[n2];
                        System.arraycopy((Object)this.mDataAboveIfd0, (int)(-8 + (int)l3), (Object)arrby, (int)0, (int)n2);
                        exifTag.setValue(arrby);
                        return exifTag;
                    }
                    exifTag.setOffset((int)l3);
                    return exifTag;
                }
                throw new ExifInvalidFormatException("offset is larger then Integer.MAX_VALUE");
            }
            boolean bl2 = exifTag.hasDefinedCount();
            exifTag.setHasDefinedCount(false);
            this.readFullTagValue(exifTag);
            exifTag.setHasDefinedCount(bl2);
            this.mTiffStream.skip(4 - n4);
            exifTag.setOffset(this.mTiffStream.getReadByteCount() - 4);
            return exifTag;
        }
        throw new ExifInvalidFormatException("Number of component is larger then Integer.MAX_VALUE");
    }

    private void registerCompressedImage(long l2) {
        this.mCorrespondingEvent.put((Object)((int)l2), (Object)new ImageEvent(3));
    }

    private void registerIfd(int n2, long l2) {
        this.mCorrespondingEvent.put((Object)((int)l2), (Object)new IfdEvent(n2, this.isIfdRequested(n2)));
    }

    private void registerUncompressedStrip(int n2, long l2) {
        this.mCorrespondingEvent.put((Object)((int)l2), (Object)new ImageEvent(4, n2));
    }

    private boolean seekTiffData(InputStream inputStream) throws IOException, ExifInvalidFormatException {
        CountedDataInputStream countedDataInputStream = new CountedDataInputStream(inputStream);
        if (countedDataInputStream.readShort() == -40) {
            short s2 = countedDataInputStream.readShort();
            while (s2 != -39 && !JpegHeader.isSofMarker(s2)) {
                long l2;
                int n2 = countedDataInputStream.readUnsignedShort();
                if (s2 == -31 && n2 >= 8) {
                    int n3 = countedDataInputStream.readInt();
                    short s3 = countedDataInputStream.readShort();
                    n2 -= 6;
                    if (n3 == 1165519206 && s3 == 0) {
                        this.mTiffStartPosition = countedDataInputStream.getReadByteCount();
                        this.mApp1End = n2;
                        this.mOffsetToApp1EndFromSOF = this.mTiffStartPosition + this.mApp1End;
                        return true;
                    }
                }
                if (n2 >= 2 && (l2 = (long)(n2 - 2)) == countedDataInputStream.skip(l2)) {
                    s2 = countedDataInputStream.readShort();
                    continue;
                }
                Log.w((Log.Tag)TAG, (String)"Invalid JPEG format.");
                break;
            }
            return false;
        }
        throw new ExifInvalidFormatException("Invalid JPEG format");
    }

    private void skipTo(int n2) throws IOException {
        this.mTiffStream.skipTo(n2);
        while (!this.mCorrespondingEvent.isEmpty() && (Integer)this.mCorrespondingEvent.firstKey() < n2) {
            this.mCorrespondingEvent.pollFirstEntry();
        }
    }

    protected ByteOrder getByteOrder() {
        return this.mTiffStream.getByteOrder();
    }

    protected int getCompressedImageSize() {
        ExifTag exifTag = this.mJpegSizeTag;
        if (exifTag == null) {
            return 0;
        }
        return (int)exifTag.getValueAt(0);
    }

    protected int getCurrentIfd() {
        return this.mIfdType;
    }

    protected int getOffsetToExifEndFromSOF() {
        return this.mOffsetToApp1EndFromSOF;
    }

    protected int getStripCount() {
        return this.mStripCount;
    }

    protected int getStripIndex() {
        return this.mImageEvent.stripIndex;
    }

    protected int getStripSize() {
        ExifTag exifTag = this.mStripSizeTag;
        if (exifTag == null) {
            return 0;
        }
        return (int)exifTag.getValueAt(0);
    }

    protected ExifTag getTag() {
        return this.mTag;
    }

    protected int getTagCountInCurrentIfd() {
        return this.mNumOfTagInIfd;
    }

    protected int getTiffStartPosition() {
        return this.mTiffStartPosition;
    }

    /*
     * Exception decompiling
     */
    protected int next() throws IOException, ExifInvalidFormatException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl133 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    protected int read(byte[] arrby) throws IOException {
        return this.mTiffStream.read(arrby);
    }

    protected int read(byte[] arrby, int n2, int n3) throws IOException {
        return this.mTiffStream.read(arrby, n2, n3);
    }

    protected void readFullTagValue(ExifTag exifTag) throws IOException {
        short s2 = exifTag.getDataType();
        if (s2 == 2 || s2 == 7 || s2 == 1) {
            int n2 = exifTag.getComponentCount();
            if (this.mCorrespondingEvent.size() > 0 && (Integer)this.mCorrespondingEvent.firstEntry().getKey() < n2 + this.mTiffStream.getReadByteCount()) {
                Object object = this.mCorrespondingEvent.firstEntry().getValue();
                if (object instanceof ImageEvent) {
                    Log.Tag tag = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Thumbnail overlaps value for tag: \n");
                    stringBuilder.append(exifTag.toString());
                    Log.w((Log.Tag)tag, (String)stringBuilder.toString());
                    Map.Entry entry = this.mCorrespondingEvent.pollFirstEntry();
                    Log.Tag tag2 = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Invalid thumbnail offset: ");
                    stringBuilder2.append(entry.getKey());
                    Log.w((Log.Tag)tag2, (String)stringBuilder2.toString());
                } else {
                    if (object instanceof IfdEvent) {
                        Log.Tag tag = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Ifd ");
                        stringBuilder.append(((IfdEvent)object).ifd);
                        stringBuilder.append(" overlaps value for tag: \n");
                        stringBuilder.append(exifTag.toString());
                        Log.w((Log.Tag)tag, (String)stringBuilder.toString());
                    } else if (object instanceof ExifTagEvent) {
                        Log.Tag tag = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Tag value for tag: \n");
                        stringBuilder.append(((ExifTagEvent)object).tag.toString());
                        stringBuilder.append(" overlaps value for tag: \n");
                        stringBuilder.append(exifTag.toString());
                        Log.w((Log.Tag)tag, (String)stringBuilder.toString());
                    }
                    int n3 = (Integer)this.mCorrespondingEvent.firstEntry().getKey() - this.mTiffStream.getReadByteCount();
                    Log.Tag tag = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid size of tag: \n");
                    stringBuilder.append(exifTag.toString());
                    stringBuilder.append(" setting count to: ");
                    stringBuilder.append(n3);
                    Log.w((Log.Tag)tag, (String)stringBuilder.toString());
                    exifTag.forceSetComponentCount(n3);
                }
            }
        }
        short s3 = exifTag.getDataType();
        switch (s3) {
            int n4;
            default: {
                return;
            }
            case 10: {
                Rational[] arrrational = new Rational[exifTag.getComponentCount()];
                int n5 = arrrational.length;
                for (n4 = 0; n4 < n5; ++n4) {
                    arrrational[n4] = this.readRational();
                }
                exifTag.setValue(arrrational);
                return;
            }
            case 9: {
                int[] arrn = new int[exifTag.getComponentCount()];
                int n6 = arrn.length;
                while (n4 < n6) {
                    arrn[n4] = this.readLong();
                    ++n4;
                }
                exifTag.setValue(arrn);
                return;
            }
            case 5: {
                Rational[] arrrational = new Rational[exifTag.getComponentCount()];
                int n7 = arrrational.length;
                while (n4 < n7) {
                    arrrational[n4] = this.readUnsignedRational();
                    ++n4;
                }
                exifTag.setValue(arrrational);
                return;
            }
            case 4: {
                long[] arrl = new long[exifTag.getComponentCount()];
                int n8 = arrl.length;
                while (n4 < n8) {
                    arrl[n4] = this.readUnsignedLong();
                    ++n4;
                }
                exifTag.setValue(arrl);
                return;
            }
            case 3: {
                int[] arrn = new int[exifTag.getComponentCount()];
                int n9 = arrn.length;
                while (n4 < n9) {
                    arrn[n4] = this.readUnsignedShort();
                    ++n4;
                }
                exifTag.setValue(arrn);
                return;
            }
            case 2: {
                exifTag.setValue(this.readString(exifTag.getComponentCount()));
                return;
            }
            case 1: 
            case 7: 
        }
        byte[] arrby = new byte[exifTag.getComponentCount()];
        this.read(arrby);
        exifTag.setValue(arrby);
    }

    protected int readLong() throws IOException {
        return this.mTiffStream.readInt();
    }

    protected Rational readRational() throws IOException {
        int n2 = this.readLong();
        int n3 = this.readLong();
        return new Rational(n2, n3);
    }

    protected String readString(int n2) throws IOException {
        return this.readString(n2, US_ASCII);
    }

    protected String readString(int n2, Charset charset) throws IOException {
        if (n2 > 0) {
            return this.mTiffStream.readString(n2, charset);
        }
        return "";
    }

    protected long readUnsignedLong() throws IOException {
        return 0xFFFFFFFFL & (long)this.readLong();
    }

    protected Rational readUnsignedRational() throws IOException {
        return new Rational(this.readUnsignedLong(), this.readUnsignedLong());
    }

    protected int readUnsignedShort() throws IOException {
        return 65535 & this.mTiffStream.readShort();
    }

    protected void registerForTagValue(ExifTag exifTag) {
        if (exifTag.getOffset() >= this.mTiffStream.getReadByteCount()) {
            this.mCorrespondingEvent.put((Object)exifTag.getOffset(), (Object)new ExifTagEvent(exifTag, true));
        }
    }

    protected void skipRemainingTagsInCurrentIfd() throws IOException, ExifInvalidFormatException {
        int n2 = 2 + this.mIfdStartOffset + 12 * this.mNumOfTagInIfd;
        int n3 = this.mTiffStream.getReadByteCount();
        if (n3 > n2) {
            return;
        }
        if (this.mNeedToParseOffsetsInCurrentIfd) {
            while (n3 < n2) {
                this.mTag = this.readTag();
                n3 += 12;
                ExifTag exifTag = this.mTag;
                if (exifTag == null) continue;
                this.checkOffsetOrImageTag(exifTag);
            }
        } else {
            this.skipTo(n2);
        }
        long l2 = this.readUnsignedLong();
        if (this.mIfdType == 0 && (this.isIfdRequested(1) || this.isThumbnailRequested()) && l2 > 0L) {
            this.registerIfd(1, l2);
        }
    }

    private static class ExifTagEvent {
        boolean isRequested;
        ExifTag tag;

        ExifTagEvent(ExifTag exifTag, boolean bl) {
            this.tag = exifTag;
            this.isRequested = bl;
        }
    }

    private static class IfdEvent {
        int ifd;
        boolean isRequested;

        IfdEvent(int n2, boolean bl) {
            this.ifd = n2;
            this.isRequested = bl;
        }
    }

    private static class ImageEvent {
        int stripIndex;
        int type;

        ImageEvent(int n2) {
            this.stripIndex = 0;
            this.type = n2;
        }

        ImageEvent(int n2, int n3) {
            this.type = n2;
            this.stripIndex = n3;
        }
    }

}

