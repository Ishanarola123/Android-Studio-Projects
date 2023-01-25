/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.RectF
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.scanner.ui;

import android.graphics.Matrix;
import android.graphics.RectF;

public class CameraCoordinateTransformer {
    private static final RectF CAMERA_DRIVER_RECT = new RectF(-1000.0f, -1000.0f, 1000.0f, 1000.0f);
    private final Matrix mCameraToPreviewTransform;
    private final Matrix mPreviewToCameraTransform;

    public CameraCoordinateTransformer(boolean bl, int n, RectF rectF) {
        if (this.hasNonZeroArea(rectF)) {
            this.mCameraToPreviewTransform = this.cameraToPreviewTransform(bl, n, rectF);
            this.mPreviewToCameraTransform = this.inverse(this.mCameraToPreviewTransform);
            return;
        }
        throw new IllegalArgumentException("previewRect");
    }

    private Matrix cameraToPreviewTransform(boolean bl, int n, RectF rectF) {
        Matrix matrix = new Matrix();
        float f = bl ? -1.0f : 1.0f;
        matrix.setScale(f, 1.0f);
        matrix.postRotate((float)n);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(CAMERA_DRIVER_RECT, rectF, Matrix.ScaleToFit.FILL);
        matrix.setConcat(matrix2, matrix);
        return matrix;
    }

    private boolean hasNonZeroArea(RectF rectF) {
        return rectF.width() != 0.0f && rectF.height() != 0.0f;
    }

    private Matrix inverse(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        return matrix2;
    }

    public RectF toCameraSpace(RectF rectF) {
        RectF rectF2 = new RectF();
        this.mPreviewToCameraTransform.mapRect(rectF2, rectF);
        return rectF2;
    }

    public RectF toPreviewSpace(RectF rectF) {
        RectF rectF2 = new RectF();
        this.mCameraToPreviewTransform.mapRect(rectF2, rectF);
        return rectF2;
    }
}

