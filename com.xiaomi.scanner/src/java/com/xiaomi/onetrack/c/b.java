/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.database.DatabaseUtils
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.c;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.onetrack.c.c;
import com.xiaomi.onetrack.c.d;
import com.xiaomi.onetrack.c.e;
import com.xiaomi.onetrack.c.f;
import com.xiaomi.onetrack.c.l;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.w;
import java.util.ArrayList;
import org.json.JSONObject;

public class b {
    private static final String a = "EventManager";
    private static final boolean b = false;
    private static final int c = 204800;
    private static final int d = 307200;
    private static final int e = 300;
    private static final String f = "priority ASC, _id ASC";
    private static final int g = 7;
    private static b h;
    private static BroadcastReceiver j;
    private a i = new a(com.xiaomi.onetrack.f.a.a());

    static {
        j = new c();
    }

    private b() {
        this.b();
    }

    static /* synthetic */ a a(b b2) {
        return b2.i;
    }

    public static b a() {
        if (h == null) {
            b.a(com.xiaomi.onetrack.f.a.a());
        }
        return h;
    }

    public static String a(byte[] arrby) {
        return new String(com.xiaomi.onetrack.d.a.b(arrby, com.xiaomi.onetrack.d.d.a(com.xiaomi.onetrack.d.c.a(), true).getBytes()));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void a(Context context) {
        if (h == null) {
            Class<b> class_ = b.class;
            // MONITORENTER : com.xiaomi.onetrack.c.b.class
            if (h == null) {
                h = new b();
            }
            // MONITOREXIT : class_
        }
        b.b(context);
        l.b();
    }

    static /* synthetic */ void a(b b2, com.xiaomi.onetrack.f.b b3) {
        b2.b(b3);
    }

    public static byte[] a(String string2) {
        String string3 = com.xiaomi.onetrack.d.d.a(com.xiaomi.onetrack.d.c.a(), true);
        return com.xiaomi.onetrack.d.a.a(string2.getBytes(), string3.getBytes());
    }

    private static void b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(j, intentFilter);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(com.xiaomi.onetrack.f.b b2) {
        a a2;
        a a3 = a2 = this.i;
        synchronized (a3) {
            if (!b2.h()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("addEventToDatabase event is inValid, event:");
                stringBuilder.append(b2.d());
                o.c(a, stringBuilder.toString());
                return;
            }
            SQLiteDatabase sQLiteDatabase = this.i.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("appid", b2.b());
            contentValues.put("package", b2.c());
            contentValues.put("event_name", b2.d());
            contentValues.put("priority", Integer.valueOf((int)b2.e()));
            contentValues.put("timestamp", Long.valueOf((long)System.currentTimeMillis()));
            byte[] arrby = b.a(b2.f().toString());
            if (arrby.length > 204800) {
                o.b(a, "Too large data, discard ***");
                return;
            }
            contentValues.put("data", arrby);
            long l2 = sQLiteDatabase.insert("events", null, contentValues);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DB-Thread: EventManager.addEventToDatabase , row=");
            stringBuilder.append(l2);
            o.a(a, stringBuilder.toString());
            if (l2 != -1L) {
                if (o.a) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("\u6dfb\u52a0\u540e\uff0cDB \u4e2d\u4e8b\u4ef6\u4e2a\u6570\u4e3a ");
                    stringBuilder2.append(this.c());
                    o.a(a, stringBuilder2.toString());
                }
                long l3 = System.currentTimeMillis();
                if ("onetrack_active".equals((Object)b2.d())) {
                    w.a(l3);
                }
                com.xiaomi.onetrack.b.l.a(false);
            }
            return;
        }
    }

    private void d() {
        try {
            this.i.getWritableDatabase().delete("events", null, null);
            o.a(a, "delete table events");
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public int a(ArrayList<Long> arrayList) {
        int n2;
        boolean bl;
        long l2;
        block10 : {
            block9 : {
                a a2;
                a a3 = a2 = this.i;
                // MONITORENTER : a3
                if (arrayList == null) {
                    // MONITOREXIT : a3
                    return 0;
                }
                int n3 = arrayList.size();
                if (n3 == 0) {
                    return 0;
                }
                try {
                    SQLiteDatabase sQLiteDatabase = this.i.getWritableDatabase();
                    int n4 = Long.toString((long)((Long)arrayList.get(0))).length();
                    bl = true;
                    StringBuilder stringBuilder = new StringBuilder(16 + (n4 + bl) * arrayList.size());
                    stringBuilder.append("_id");
                    stringBuilder.append(" in (");
                    stringBuilder.append(arrayList.get(0));
                    int n5 = arrayList.size();
                    for (int i2 = 1; i2 < n5; ++i2) {
                        stringBuilder.append(",");
                        stringBuilder.append(arrayList.get(i2));
                    }
                    stringBuilder.append(")");
                    n2 = sQLiteDatabase.delete("events", stringBuilder.toString(), null);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("deleted events count ");
                    stringBuilder2.append(n2);
                    o.a(a, stringBuilder2.toString());
                    l2 = b.a().c();
                    if (l2 != 0L) break block9;
                    break block10;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("e=");
                    stringBuilder.append((Object)exception);
                    o.b(a, stringBuilder.toString());
                    // MONITOREXIT : a3
                    return 0;
                }
            }
            bl = false;
        }
        com.xiaomi.onetrack.b.l.a(bl);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("after delete DB record remains=");
        stringBuilder.append(l2);
        o.a(a, stringBuilder.toString());
        // MONITOREXIT : a3
        return n2;
    }

    /*
     * Exception decompiling
     */
    public f a(int var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 8[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
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

    public void a(com.xiaomi.onetrack.f.b b2) {
        b b3 = this;
        synchronized (b3) {
            com.xiaomi.onetrack.c.a.a(new d(this, b2));
            return;
        }
    }

    public void b() {
        com.xiaomi.onetrack.c.a.a(new e(this));
    }

    public long c() {
        return DatabaseUtils.queryNumEntries((SQLiteDatabase)this.i.getReadableDatabase(), (String)"events");
    }

    private static class a
    extends SQLiteOpenHelper {
        public static final String a = "onetrack";
        public static final String b = "events";
        public static final String c = "_id";
        public static final String d = "appid";
        public static final String e = "package";
        public static final String f = "event_name";
        public static final String g = "priority";
        public static final String h = "data";
        public static final String i = "timestamp";
        private static final int j = 1;
        private static final String k = "CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT,appid TEXT,package TEXT,event_name TEXT,priority INTEGER,data BLOB,timestamp INTEGER)";

        public a(Context context) {
            super(context, a, null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(k);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        }
    }

}

