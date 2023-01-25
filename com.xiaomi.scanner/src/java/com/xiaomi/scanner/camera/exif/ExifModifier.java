/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.scanner.camera.exif;

import com.xiaomi.scanner.camera.exif.ByteBufferInputStream;
import com.xiaomi.scanner.camera.exif.ExifData;
import com.xiaomi.scanner.camera.exif.ExifInterface;
import com.xiaomi.scanner.camera.exif.ExifInvalidFormatException;
import com.xiaomi.scanner.camera.exif.ExifParser;
import com.xiaomi.scanner.camera.exif.ExifTag;
import com.xiaomi.scanner.camera.exif.Rational;
import com.xiaomi.scanner.debug.Log;
import java.io.Closeable;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

class ExifModifier {
    public static final boolean DEBUG;
    public static final Log.Tag TAG;
    private final ByteBuffer mByteBuffer;
    private final ExifInterface mInterface;
    private int mOffsetBase;
    private final List<TagOffset> mTagOffsets;
    private final ExifData mTagToModified;

    static {
        TAG = new Log.Tag("ExifModifier");
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected ExifModifier(ByteBuffer byteBuffer, ExifInterface exifInterface) throws IOException, ExifInvalidFormatException {
        void var4_7;
        ByteBufferInputStream byteBufferInputStream;
        block4 : {
            this.mTagOffsets = new ArrayList();
            this.mByteBuffer = byteBuffer;
            this.mOffsetBase = byteBuffer.position();
            this.mInterface = exifInterface;
            byteBufferInputStream = new ByteBufferInputStream(byteBuffer);
            try {
                ExifParser exifParser = ExifParser.parse(byteBufferInputStream, this.mInterface);
                this.mTagToModified = new ExifData(exifParser.getByteOrder());
                this.mOffsetBase += exifParser.getTiffStartPosition();
                this.mByteBuffer.position(0);
            }
            catch (Throwable throwable) {}
            ExifInterface.closeSilently((Closeable)byteBufferInputStream);
            return;
            break block4;
            catch (Throwable throwable) {
                byteBufferInputStream = null;
            }
        }
        ExifInterface.closeSilently((Closeable)byteBufferInputStream);
        throw var4_7;
    }

    private void modify() {
        this.mByteBuffer.order(this.getByteOrder());
        for (TagOffset tagOffset : this.mTagOffsets) {
            this.writeTagValue(tagOffset.mTag, tagOffset.mOffset);
        }
    }

    private void writeTagValue(ExifTag exifTag, int n2) {
        this.mByteBuffer.position(n2 + this.mOffsetBase);
        short s2 = exifTag.getDataType();
        switch (s2) {
            int n3;
            default: {
                return;
            }
            case 5: 
            case 10: {
                int n4 = exifTag.getComponentCount();
                for (n3 = 0; n3 < n4; ++n3) {
                    Rational rational = exifTag.getRational(n3);
                    this.mByteBuffer.putInt((int)rational.getNumerator());
                    this.mByteBuffer.putInt((int)rational.getDenominator());
                }
                break;
            }
            case 4: 
            case 9: {
                int n5 = exifTag.getComponentCount();
                while (n3 < n5) {
                    this.mByteBuffer.putInt((int)exifTag.getValueAt(n3));
                    ++n3;
                }
                break;
            }
            case 3: {
                int n6 = exifTag.getComponentCount();
                while (n3 < n6) {
                    this.mByteBuffer.putShort((short)exifTag.getValueAt(n3));
                    ++n3;
                }
                break;
            }
            case 2: {
                byte[] arrby = exifTag.getStringByte();
                if (arrby.length == exifTag.getComponentCount()) {
                    arrby[-1 + arrby.length] = 0;
                    this.mByteBuffer.put(arrby);
                    return;
                }
                this.mByteBuffer.put(arrby);
                this.mByteBuffer.put((byte)0);
                return;
            }
            case 1: 
            case 7: {
                byte[] arrby = new byte[exifTag.getComponentCount()];
                exifTag.getBytes(arrby);
                this.mByteBuffer.put(arrby);
            }
        }
    }

    /*
     * Exception decompiling
     */
    protected boolean commit() throws IOException, ExifInvalidFormatException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: CONTINUE without a while class org.benf.cfr.reader.b.a.b.e.e
        // org.benf.cfr.reader.b.a.b.e.p.k(GotoStatement.java:87)
        // org.benf.cfr.reader.b.a.b.e.r.f(IfStatement.java:103)
        // org.benf.cfr.reader.b.a.a.i.z(Op03SimpleStatement.java:503)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:598)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    protected ByteOrder getByteOrder() {
        return this.mTagToModified.getByteOrder();
    }

    public void modifyTag(ExifTag exifTag) {
        this.mTagToModified.addTag(exifTag);
    }

    private static class TagOffset {
        final int mOffset;
        final ExifTag mTag;

        TagOffset(ExifTag exifTag, int n2) {
            this.mTag = exifTag;
            this.mOffset = n2;
        }
    }

}

