/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Math
 *  java.nio.ByteBuffer
 */
package com.xiaomi.scanner.camera.exif;

import java.io.InputStream;
import java.nio.ByteBuffer;

class ByteBufferInputStream
extends InputStream {
    private ByteBuffer mBuf;

    public ByteBufferInputStream(ByteBuffer byteBuffer) {
        this.mBuf = byteBuffer;
    }

    public int read() {
        if (!this.mBuf.hasRemaining()) {
            return -1;
        }
        return 255 & this.mBuf.get();
    }

    public int read(byte[] arrby, int n2, int n3) {
        if (!this.mBuf.hasRemaining()) {
            return -1;
        }
        int n4 = Math.min((int)n3, (int)this.mBuf.remaining());
        this.mBuf.get(arrby, n2, n4);
        return n4;
    }
}

