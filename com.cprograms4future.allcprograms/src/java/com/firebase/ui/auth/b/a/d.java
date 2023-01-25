/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.widget.Toast
 *  com.google.android.gms.common.api.f
 *  com.google.android.gms.common.api.f$b
 *  com.google.android.gms.common.api.f$c
 *  com.google.android.gms.common.api.k
 *  com.google.android.gms.common.api.l
 *  com.google.android.gms.common.b
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth.b.a;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.f;
import com.firebase.ui.auth.ui.g;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.b;

public abstract class d<R extends k>
extends f
implements f.b,
f.c,
l<R> {
    protected com.google.android.gms.common.api.f b;
    private boolean c;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static String b(String var0) {
        block10 : {
            block7 : {
                block8 : {
                    block9 : {
                        var1_1 = var0.hashCode();
                        if (var1_1 == -1830313082) break block7;
                        if (var1_1 == -1536293812) break block8;
                        if (var1_1 == -364826023) break block9;
                        if (var1_1 != 1216985755 || !var0.equals((Object)"password")) ** GOTO lbl-1000
                        var2_2 = 3;
                        break block10;
                    }
                    if (!var0.equals((Object)"facebook.com")) ** GOTO lbl-1000
                    var2_2 = 1;
                    break block10;
                }
                if (!var0.equals((Object)"google.com")) ** GOTO lbl-1000
                var2_2 = 0;
                break block10;
            }
            if (var0.equals((Object)"twitter.com")) {
                var2_2 = 2;
            } else lbl-1000: // 4 sources:
            {
                var2_2 = -1;
            }
        }
        switch (var2_2) {
            default: {
                return null;
            }
            case 2: {
                return "https://twitter.com";
            }
            case 1: {
                return "https://www.facebook.com";
            }
            case 0: 
        }
        return "https://accounts.google.com";
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static String c(String var0) {
        block9 : {
            block7 : {
                block8 : {
                    var1_1 = var0.hashCode();
                    if (var1_1 == -376862683) break block7;
                    if (var1_1 == 746549591) break block8;
                    if (var1_1 != 1721158175 || !var0.equals((Object)"https://www.facebook.com")) ** GOTO lbl-1000
                    var2_2 = 1;
                    break block9;
                }
                if (!var0.equals((Object)"https://twitter.com")) ** GOTO lbl-1000
                var2_2 = 2;
                break block9;
            }
            if (var0.equals((Object)"https://accounts.google.com")) {
                var2_2 = 0;
            } else lbl-1000: // 3 sources:
            {
                var2_2 = -1;
            }
        }
        switch (var2_2) {
            default: {
                return null;
            }
            case 2: {
                return "twitter.com";
            }
            case 1: {
                return "facebook.com";
            }
            case 0: 
        }
        return "google.com";
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
    }

    public void a(b b2) {
        Toast.makeText((Context)this.j(), (int)c.h.general_error, (int)0).show();
    }

    public void a_(int n2) {
    }

    @Override
    public void b_(Bundle bundle) {
        super.b_(bundle);
        this.d(true);
    }

    public void d() {
        super.d();
        if (this.c) {
            this.a.a(c.h.progress_dialog_loading);
            this.c = false;
        }
    }

    public void e() {
        super.e();
        this.c = this.a.e();
        this.a.d();
    }

    @Override
    public void x() {
        super.x();
        this.a();
    }
}

