/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.firebase.ui.auth.a.b
 *  com.firebase.ui.auth.a.c
 *  com.firebase.ui.auth.a.e
 *  com.google.firebase.auth.c
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth.a;

import com.firebase.ui.auth.a.b;
import com.firebase.ui.auth.a.c;
import com.firebase.ui.auth.a.e;

public final class a {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static com.google.firebase.auth.c a(com.firebase.ui.auth.b var0) {
        block9 : {
            block7 : {
                block8 : {
                    var1_1 = var0.a();
                    var2_2 = var1_1.hashCode();
                    if (var2_2 == -1830313082) break block7;
                    if (var2_2 == -1536293812) break block8;
                    if (var2_2 != -364826023 || !var1_1.equals((Object)"facebook.com")) ** GOTO lbl-1000
                    var3_3 = 1;
                    break block9;
                }
                if (!var1_1.equals((Object)"google.com")) ** GOTO lbl-1000
                var3_3 = 0;
                break block9;
            }
            if (var1_1.equals((Object)"twitter.com")) {
                var3_3 = 2;
            } else lbl-1000: // 3 sources:
            {
                var3_3 = -1;
            }
        }
        switch (var3_3) {
            default: {
                return null;
            }
            case 2: {
                return e.a((com.firebase.ui.auth.b)var0);
            }
            case 1: {
                return b.a((com.firebase.ui.auth.b)var0);
            }
            case 0: 
        }
        return c.a((com.firebase.ui.auth.b)var0);
    }
}

