/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Comparator
 */
package com.twitter.sdk.android.core.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

public class a {
    File a(Context context) {
        return new File(context.getApplicationInfo().dataDir, "shared_prefs");
    }

    File a(File file, String string) {
        Object[] arrobject = file.listFiles((FilenameFilter)new b(string));
        Arrays.sort((Object[])arrobject, (Comparator)new a());
        if (arrobject.length > 0) {
            return arrobject[0];
        }
        return null;
    }

    public void a(Context context, String string, String string2) {
        File file = this.a(context);
        if (file.exists()) {
            if (!file.isDirectory()) {
                return;
            }
            File file2 = new File(file, string2);
            if (file2.exists()) {
                return;
            }
            File file3 = this.a(file, string);
            if (file3 != null) {
                file3.renameTo(file2);
            }
        }
    }

    static class a
    implements Comparator<File> {
        a() {
        }

        public int a(File file, File file2) {
            return Long.valueOf((long)file2.lastModified()).compareTo(Long.valueOf((long)file.lastModified()));
        }

        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((File)object, (File)object2);
        }
    }

    static class b
    implements FilenameFilter {
        final String a;

        public b(String string) {
            this.a = string;
        }

        public boolean accept(File file, String string) {
            return string.startsWith(this.a);
        }
    }

}

