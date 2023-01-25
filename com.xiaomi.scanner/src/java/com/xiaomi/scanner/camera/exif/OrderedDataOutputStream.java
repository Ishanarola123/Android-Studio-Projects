/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 */
package com.xiaomi.scanner.camera.exif;

import com.xiaomi.scanner.camera.exif.Rational;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class OrderedDataOutputStream
extends FilterOutputStream {
    private final ByteBuffer mByteBuffer = ByteBuffer.allocate((int)4);

    public OrderedDataOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public OrderedDataOutputStream setByteOrder(ByteOrder byteOrder) {
        this.mByteBuffer.order(byteOrder);
        return this;
    }

    public OrderedDataOutputStream writeInt(int n2) throws IOException {
        this.mByteBuffer.rewind();
        this.mByteBuffer.putInt(n2);
        this.out.write(this.mByteBuffer.array());
        return this;
    }

    public OrderedDataOutputStream writeRational(Rational rational) throws IOException {
        this.writeInt((int)rational.getNumerator());
        this.writeInt((int)rational.getDenominator());
        return this;
    }

    public OrderedDataOutputStream writeShort(short s2) throws IOException {
        this.mByteBuffer.rewind();
        this.mByteBuffer.putShort(s2);
        this.out.write(this.mByteBuffer.array(), 0, 2);
        return this;
    }
}

