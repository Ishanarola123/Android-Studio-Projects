/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.PrintWriter
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.a.a;

import java.io.PrintWriter;

public class ab {
    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;

    public ab(int n2, int n3, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, int n4, int n5, int n6, long l10) {
        this.a = n2;
        this.b = n3;
        this.c = l2;
        this.d = l3;
        this.e = l4;
        this.f = l5;
        this.g = l6;
        this.h = l7;
        this.i = l8;
        this.j = l9;
        this.k = n4;
        this.l = n5;
        this.m = n6;
        this.n = l10;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int)Math.ceil((double)(100.0f * ((float)this.b / (float)this.a))));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StatsSnapshot{maxSize=");
        stringBuilder.append(this.a);
        stringBuilder.append(", size=");
        stringBuilder.append(this.b);
        stringBuilder.append(", cacheHits=");
        stringBuilder.append(this.c);
        stringBuilder.append(", cacheMisses=");
        stringBuilder.append(this.d);
        stringBuilder.append(", downloadCount=");
        stringBuilder.append(this.k);
        stringBuilder.append(", totalDownloadSize=");
        stringBuilder.append(this.e);
        stringBuilder.append(", averageDownloadSize=");
        stringBuilder.append(this.h);
        stringBuilder.append(", totalOriginalBitmapSize=");
        stringBuilder.append(this.f);
        stringBuilder.append(", totalTransformedBitmapSize=");
        stringBuilder.append(this.g);
        stringBuilder.append(", averageOriginalBitmapSize=");
        stringBuilder.append(this.i);
        stringBuilder.append(", averageTransformedBitmapSize=");
        stringBuilder.append(this.j);
        stringBuilder.append(", originalBitmapCount=");
        stringBuilder.append(this.l);
        stringBuilder.append(", transformedBitmapCount=");
        stringBuilder.append(this.m);
        stringBuilder.append(", timeStamp=");
        stringBuilder.append(this.n);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

