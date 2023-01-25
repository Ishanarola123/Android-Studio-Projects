/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Calendar
 */
package com.xiaomi.onetrack.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.onetrack.b.l;
import com.xiaomi.onetrack.c.b;
import com.xiaomi.onetrack.h.o;
import java.util.Calendar;

class e
implements Runnable {
    final /* synthetic */ b a;

    e(b b2) {
        this.a = b2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        Cursor cursor;
        Throwable throwable22;
        block10 : {
            block9 : {
                b.a a2;
                b.a a3 = a2 = b.a(this.a);
                // MONITORENTER : a3
                cursor = null;
                SQLiteDatabase sQLiteDatabase = b.a(this.a).getWritableDatabase();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(6, -7 + calendar.get(6));
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                long l2 = calendar.getTimeInMillis();
                String[] arrstring = new String[]{Long.toString((long)l2)};
                cursor = sQLiteDatabase.query("events", new String[]{"timestamp"}, "timestamp < ? ", arrstring, null, null, "timestamp ASC");
                if (cursor.getCount() != 0) {
                    int n2 = sQLiteDatabase.delete("events", "timestamp < ? ", arrstring);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("*** deleted obsolete item count=");
                    stringBuilder.append(n2);
                    o.a("EventManager", stringBuilder.toString());
                }
                long l3 = b.a().c();
                long l4 = l3 LCMP 0L;
                boolean bl = false;
                if (l4 == false) {
                    bl = true;
                }
                l.a(bl);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("after delete obsolete record remains=");
                stringBuilder.append(l3);
                o.a("EventManager", stringBuilder.toString());
                if (cursor == null) break block9;
                {
                    catch (Throwable throwable22) {
                        break block10;
                    }
                    catch (Exception exception) {}
                    {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("remove obsolete events failed with ");
                        stringBuilder2.append((Object)exception);
                        o.d("EventManager", stringBuilder2.toString());
                        if (cursor == null) break block9;
                    }
                }
                cursor.close();
                return;
            }
            // MONITOREXIT : a3
            return;
        }
        if (cursor == null) throw throwable22;
        cursor.close();
        throw throwable22;
    }
}

