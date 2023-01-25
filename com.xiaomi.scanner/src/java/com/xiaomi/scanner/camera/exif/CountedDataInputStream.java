/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.charset.Charset
 */
package com.xiaomi.scanner.camera.exif;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

class CountedDataInputStream
extends FilterInputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final byte[] mByteArray = new byte[8];
    private final ByteBuffer mByteBuffer = ByteBuffer.wrap((byte[])this.mByteArray);
    private int mCount = 0;

    protected CountedDataInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public ByteOrder getByteOrder() {
        return this.mByteBuffer.order();
    }

    public int getReadByteCount() {
        return this.mCount;
    }

    public int read() throws IOException {
        int n2 = this.in.read();
        int n3 = this.mCount;
        int n4 = n2 >= 0 ? 1 : 0;
        this.mCount = n3 + n4;
        return n2;
    }

    public int read(byte[] arrby) throws IOException {
        int n2 = this.in.read(arrby);
        int n3 = this.mCount;
        int n4 = n2 >= 0 ? n2 : 0;
        this.mCount = n3 + n4;
        return n2;
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        int n4 = this.in.read(arrby, n2, n3);
        int n5 = this.mCount;
        int n6 = n4 >= 0 ? n4 : 0;
        this.mCount = n5 + n6;
        return n4;
    }

    public int readInt() throws IOException {
        this.readOrThrow(this.mByteArray, 0, 4);
        this.mByteBuffer.rewind();
        return this.mByteBuffer.getInt();
    }

    public long readLong() throws IOException {
        this.readOrThrow(this.mByteArray, 0, 8);
        this.mByteBuffer.rewind();
        return this.mByteBuffer.getLong();
    }

    public void readOrThrow(byte[] arrby) throws IOException {
        this.readOrThrow(arrby, 0, arrby.length);
    }

    public void readOrThrow(byte[] arrby, int n2, int n3) throws IOException {
        if (this.read(arrby, n2, n3) == n3) {
            return;
        }
        throw new EOFException();
    }

    public short readShort() throws IOException {
        this.readOrThrow(this.mByteArray, 0, 2);
        this.mByteBuffer.rewind();
        return this.mByteBuffer.getShort();
    }

    public String readString(int n2) throws IOException {
        byte[] arrby = new byte[n2];
        this.readOrThrow(arrby);
        return new String(arrby, "UTF8");
    }

    public String readString(int n2, Charset charset) throws IOException {
        byte[] arrby = new byte[n2];
        this.readOrThrow(arrby);
        return new String(arrby, charset);
    }

    public long readUnsignedInt() throws IOException {
        return 0xFFFFFFFFL & (long)this.readInt();
    }

    public int readUnsignedShort() throws IOException {
        return 65535 & this.readShort();
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteBuffer.order(byteOrder);
    }

    public long skip(long l2) throws IOException {
        long l3 = this.in.skip(l2);
        this.mCount = (int)(l3 + (long)this.mCount);
        return l3;
    }

    public void skipOrThrow(long l2) throws IOException {
        if (this.skip(l2) == l2) {
            return;
        }
        throw new EOFException();
    }

    public void skipTo(long l2) throws IOException {
        this.skipOrThrow(l2 - (long)this.mCount);
    }
}

