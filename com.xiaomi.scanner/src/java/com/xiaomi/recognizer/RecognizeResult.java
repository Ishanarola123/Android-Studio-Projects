/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package com.xiaomi.recognizer;

import java.util.Arrays;

public class RecognizeResult {
    public float[] quadrangleCorners;
    public boolean resultValid = false;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecognizeResult{quadrangleCorners=");
        stringBuilder.append(Arrays.toString((float[])this.quadrangleCorners));
        stringBuilder.append(", resultValid=");
        stringBuilder.append(this.resultValid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

