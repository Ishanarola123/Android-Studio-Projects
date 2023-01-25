/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.util.Comparator
 */
package com.xiaomi.onetrack;

import com.xiaomi.onetrack.CrashAnalysis;
import java.io.File;
import java.util.Comparator;

class CrashAnalysis$2
implements Comparator<File> {
    final /* synthetic */ CrashAnalysis a;

    CrashAnalysis$2(CrashAnalysis crashAnalysis) {
        this.a = crashAnalysis;
    }

    public int compare(File file, File file2) {
        return (int)(file.lastModified() - file2.lastModified());
    }
}

