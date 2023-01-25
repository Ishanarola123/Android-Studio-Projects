/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.onetrack.a;

import android.content.Context;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.a.ae;
import com.xiaomi.onetrack.a.d;
import com.xiaomi.onetrack.b.a;
import com.xiaomi.onetrack.b.f;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.o;

public class ad
implements d {
    private static final String a = "OneTrackLocalImp";
    private static final int b = 102400;
    private static final int c = 2;
    private Configuration d;

    public ad(Context context, Configuration configuration) {
        com.xiaomi.onetrack.f.f.a(context);
        this.d = configuration;
    }

    @Override
    public void a(int n) {
        if (!g.b()) {
            return;
        }
        if (n == 2) {
            h.a(new ae(this));
        }
    }

    @Override
    public void a(String string, String string2) {
        if (!this.b(string, string2)) {
            return;
        }
        if (!g.b()) {
            g.a(string, string2);
            return;
        }
        if (o.a && !string.equalsIgnoreCase("onetrack_bug_report")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("track data:");
            stringBuilder.append(string2);
            o.a(a, stringBuilder.toString());
        }
        a.a(this.d.getAppId());
        if (this.a(string)) {
            return;
        }
        com.xiaomi.onetrack.f.d.a(this.d.getAppId(), com.xiaomi.onetrack.f.a.d(), string, string2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean a(String string) {
        boolean bl3;
        boolean bl2;
        block4 : {
            void var2_6;
            block5 : {
                bl2 = f.a().a(this.d.getAppId(), "disable_log");
                try {
                    bl3 = f.a().a(this.d.getAppId(), string, "disable_log", false);
                    break block4;
                }
                catch (Exception exception) {
                    break block5;
                }
                catch (Exception exception) {
                    bl2 = false;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("isDisableTrack: ");
            stringBuilder.append(var2_6.toString());
            o.a(a, stringBuilder.toString());
            bl3 = false;
        }
        if (bl2) return true;
        boolean bl = false;
        if (!bl3) return bl;
        return true;
    }

    public boolean b(String string, String string2) {
        if (!OneTrack.isDisable()) {
            if (OneTrack.isUseSystemNetTrafficOnly()) {
                return false;
            }
            boolean bl = string != null && string.equals((Object)"onetrack_bug_report");
            if (!bl && string2 != null && 2 * string2.length() > 102400) {
                o.a(a, "Event size exceed limitation!");
                return false;
            }
            return true;
        }
        return false;
    }
}

