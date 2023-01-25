/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  java.io.BufferedReader
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map
 *  java.util.TreeMap
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core.internal.oauth;

import a.a.a.a.a.e.j;
import android.net.Uri;
import b.ac;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.i;
import com.twitter.sdk.android.core.internal.d;
import com.twitter.sdk.android.core.internal.oauth.f;
import com.twitter.sdk.android.core.internal.oauth.g;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.o;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.r;
import d.b;
import d.b.s;
import d.l;
import d.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;

public class OAuth1aService
extends g {
    OAuthApi a = this.f().a(OAuthApi.class);

    public OAuth1aService(q q2, SSLSocketFactory sSLSocketFactory, d d2) {
        super(q2, sSLSocketFactory, d2);
    }

    public static f a(String string) {
        TreeMap<String, String> treeMap = j.a(string, false);
        String string2 = (String)treeMap.get((Object)"oauth_token");
        String string3 = (String)treeMap.get((Object)"oauth_token_secret");
        String string4 = (String)treeMap.get((Object)"screen_name");
        long l2 = treeMap.containsKey((Object)"user_id") ? Long.parseLong((String)((String)treeMap.get((Object)"user_id"))) : 0L;
        if (string2 != null && string3 != null) {
            return new f(new p(string2, string3), string4, l2);
        }
        return null;
    }

    String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d().a());
        stringBuilder.append("/oauth/request_token");
        return stringBuilder.toString();
    }

    public String a(n n2) {
        return Uri.parse((String)"twittersdk://callback").buildUpon().appendQueryParameter("version", this.c().a()).appendQueryParameter("app", n2.a()).build().toString();
    }

    public String a(p p2) {
        return this.d().a("oauth", "authorize").appendQueryParameter("oauth_token", p2.b).build().toString();
    }

    public void a(c<f> c2) {
        n n2 = this.c().e();
        String string = this.a();
        this.a.getTempToken(new com.twitter.sdk.android.core.internal.oauth.c().a(n2, null, this.a(n2), "POST", string, null)).a(this.b(c2));
    }

    public void a(c<f> c2, p p2, String string) {
        String string2 = this.b();
        String string3 = new com.twitter.sdk.android.core.internal.oauth.c().a(this.c().e(), p2, null, "POST", string2, null);
        this.a.getAccessToken(string3, string).a(this.b(c2));
    }

    c<ac> b(final c<f> c2) {
        return new c<ac>(){

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void a(i<ac> i2) {
                String string;
                BufferedReader bufferedReader;
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader((Reader)new InputStreamReader(((ac)i2.a).c()));
                while ((string = bufferedReader2.readLine()) != null) {
                    stringBuilder.append(string);
                }
                {
                    catch (Throwable throwable) {
                        bufferedReader = bufferedReader2;
                        break block8;
                    }
                }
                try {
                    void var4_9;
                    block8 : {
                        bufferedReader2.close();
                        String string2 = stringBuilder.toString();
                        f f2 = OAuth1aService.a(string2);
                        if (f2 == null) {
                            c c22 = c2;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Failed to parse auth response: ");
                            stringBuilder2.append(string2);
                            c22.a(new o(stringBuilder2.toString()));
                            return;
                        }
                        c2.a(new i<f>(f2, null));
                        return;
                        catch (Throwable throwable) {
                            bufferedReader = null;
                        }
                    }
                    if (bufferedReader == null) throw var4_9;
                    bufferedReader.close();
                    throw var4_9;
                }
                catch (IOException iOException) {}
                c2.a(new o(iOException.getMessage(), iOException));
            }

            @Override
            public void a(r r2) {
                c2.a(r2);
            }
        };
    }

    String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d().a());
        stringBuilder.append("/oauth/access_token");
        return stringBuilder.toString();
    }

}

