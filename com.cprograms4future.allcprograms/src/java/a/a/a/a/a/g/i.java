/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileWriter
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
package a.a.a.a.a.g;

import a.a.a.a.a.f.a;
import a.a.a.a.a.g.g;
import a.a.a.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

class i
implements g {
    private final a.a.a.a.i a;

    public i(a.a.a.a.i i2) {
        this.a = i2;
    }

    @Override
    public JSONObject a() {
        Throwable throwable;
        FileInputStream fileInputStream;
        block11 : {
            FileInputStream fileInputStream2;
            block10 : {
                JSONObject jSONObject;
                FileInputStream fileInputStream3;
                block9 : {
                    block8 : {
                        c.h().a("Fabric", "Reading cached settings...");
                        fileInputStream3 = null;
                        File file = new File(new a(this.a).a(), "com.crashlytics.settings.json");
                        if (!file.exists()) break block8;
                        fileInputStream2 = new FileInputStream(file);
                        try {
                            jSONObject = new JSONObject(a.a.a.a.a.b.i.a((InputStream)fileInputStream2));
                            fileInputStream3 = fileInputStream2;
                            break block9;
                        }
                        catch (Exception exception) {
                            break block10;
                        }
                    }
                    try {
                        c.h().a("Fabric", "No cached settings found.");
                        jSONObject = null;
                    }
                    catch (Throwable throwable2) {
                        fileInputStream = null;
                        break block11;
                    }
                    catch (Exception exception) {
                        fileInputStream2 = null;
                    }
                }
                a.a.a.a.a.b.i.a(fileInputStream3, "Error while closing settings cache file.");
                return jSONObject;
            }
            try {
                void var3_7;
                c.h().d("Fabric", "Failed to fetch cached settings", (Throwable)var3_7);
            }
            catch (Throwable throwable3) {
                throwable = throwable3;
                fileInputStream = fileInputStream2;
            }
            a.a.a.a.a.b.i.a(fileInputStream2, "Error while closing settings cache file.");
            return null;
        }
        a.a.a.a.a.b.i.a(fileInputStream, "Error while closing settings cache file.");
        throw throwable;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void a(long var1_1, JSONObject var3_2) {
        block7 : {
            c.h().a("Fabric", "Writing settings to cache file...");
            if (var3_2 == null) return;
            var4_3 = null;
            var3_2.put("expires_at", var1_1);
            var8_4 = new FileWriter(new File(new a(this.a).a(), "com.crashlytics.settings.json"));
            try {
                var8_4.write(var3_2.toString());
                var8_4.flush();
            }
            catch (Throwable var6_5) {
                var4_3 = var8_4;
                break block7;
            }
            catch (Exception var5_8) {
                var4_3 = var8_4;
                ** GOTO lbl-1000
            }
            a.a.a.a.a.b.i.a((Closeable)var8_4, "Failed to close settings writer.");
            return;
            catch (Throwable var6_6) {
                break block7;
            }
            catch (Exception var5_9) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                c.h().d("Fabric", "Failed to cache settings", (Throwable)var5_10);
            }
            a.a.a.a.a.b.i.a(var4_3, "Failed to close settings writer.");
            return;
        }
        a.a.a.a.a.b.i.a(var4_3, "Failed to close settings writer.");
        throw var6_7;
    }
}

