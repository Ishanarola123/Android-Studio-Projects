/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Locale
 */
package a.a.a.a.a.g;

import a.a.a.a.a.b.p;
import a.a.a.a.a.e.e;
import a.a.a.a.a.g.d;
import a.a.a.a.a.g.n;
import a.a.a.a.c;
import a.a.a.a.i;
import a.a.a.a.k;
import a.a.a.a.l;
import android.content.Context;
import android.content.res.Resources;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

abstract class a
extends a.a.a.a.a.b.a {
    public a(i i2, String string, String string2, e e2, a.a.a.a.a.e.c c2) {
        super(i2, string, string2, e2, c2);
    }

    private a.a.a.a.a.e.d a(a.a.a.a.a.e.d d2, d d3) {
        return d2.a("X-CRASHLYTICS-API-KEY", d3.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private a.a.a.a.a.e.d b(a.a.a.a.a.e.d d2, d d3) {
        a.a.a.a.a.e.d d4;
        block13 : {
            d4 = d2.e("app[identifier]", d3.b).e("app[name]", d3.f).e("app[display_version]", d3.c).e("app[build_version]", d3.d).a("app[source]", (Number)d3.g).e("app[minimum_sdk_version]", d3.h).e("app[built_sdk_version]", d3.i);
            if (!a.a.a.a.a.b.i.b(d3.e)) {
                d4.e("app[instance_identifier]", d3.e);
            }
            if (d3.j != null) {
                void var11_9;
                InputStream inputStream;
                block12 : {
                    block10 : {
                        inputStream = this.a.m().getResources().openRawResource(d3.j.b);
                        try {
                            Resources.NotFoundException notFoundException;
                            block11 : {
                                try {
                                    d4.e("app[icon][hash]", d3.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", inputStream).a("app[icon][width]", (Number)d3.j.c).a("app[icon][height]", (Number)d3.j.d);
                                    break block10;
                                }
                                catch (Resources.NotFoundException notFoundException2) {
                                    break block11;
                                }
                                catch (Throwable throwable) {
                                    inputStream = null;
                                    break block12;
                                }
                                catch (Resources.NotFoundException notFoundException3) {
                                    inputStream = null;
                                    notFoundException = notFoundException3;
                                }
                            }
                            l l2 = c.h();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Failed to find app icon with resource ID: ");
                            stringBuilder.append(d3.j.b);
                            l2.d("Fabric", stringBuilder.toString(), notFoundException);
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    a.a.a.a.a.b.i.a((Closeable)inputStream, "Failed to close app icon InputStream.");
                    break block13;
                }
                a.a.a.a.a.b.i.a(inputStream, "Failed to close app icon InputStream.");
                throw var11_9;
            }
        }
        if (d3.k == null) return d4;
        Iterator iterator = d3.k.iterator();
        while (iterator.hasNext()) {
            k k2 = (k)iterator.next();
            d4.e(this.a(k2), k2.b());
            d4.e(this.b(k2), k2.c());
        }
        return d4;
    }

    String a(k k2) {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{k2.a()};
        return String.format((Locale)locale, (String)"app[build][libraries][%s][version]", (Object[])arrobject);
    }

    public boolean a(d d2) {
        a.a.a.a.a.e.d d3 = this.b(this.a(this.b(), d2), d2);
        l l2 = c.h();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending app info to ");
        stringBuilder.append(this.a());
        l2.a("Fabric", stringBuilder.toString());
        if (d2.j != null) {
            l l3 = c.h();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("App icon hash is ");
            stringBuilder2.append(d2.j.a);
            l3.a("Fabric", stringBuilder2.toString());
            l l4 = c.h();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("App icon size is ");
            stringBuilder3.append(d2.j.c);
            stringBuilder3.append("x");
            stringBuilder3.append(d2.j.d);
            l4.a("Fabric", stringBuilder3.toString());
        }
        int n2 = d3.b();
        String string = "POST".equals((Object)d3.o()) ? "Create" : "Update";
        l l5 = c.h();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(string);
        stringBuilder4.append(" app request ID: ");
        stringBuilder4.append(d3.b("X-REQUEST-ID"));
        l5.a("Fabric", stringBuilder4.toString());
        l l6 = c.h();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("Result was ");
        stringBuilder5.append(n2);
        l6.a("Fabric", stringBuilder5.toString());
        return p.a(n2) == 0;
    }

    String b(k k2) {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{k2.a()};
        return String.format((Locale)locale, (String)"app[build][libraries][%s][type]", (Object[])arrobject);
    }
}

