/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.twitter.sdk.android.core.p
 *  java.io.UnsupportedEncodingException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.URI
 *  java.security.InvalidKeyException
 *  java.security.Key
 *  java.security.NoSuchAlgorithmException
 *  java.security.SecureRandom
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 *  javax.crypto.Mac
 *  javax.crypto.spec.SecretKeySpec
 */
package com.twitter.sdk.android.core.internal.oauth;

import a.a.a.a.a.e.d;
import a.a.a.a.a.e.j;
import a.a.a.a.c;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.p;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

class d {
    private static final SecureRandom a = new SecureRandom();
    private final n b;
    private final p c;
    private final String d;
    private final String e;
    private final String f;
    private final Map<String, String> g;

    public d(n n2, p p2, String string, String string2, String string3, Map<String, String> map) {
        this.b = n2;
        this.c = p2;
        this.d = string;
        this.e = string2;
        this.f = string3;
        this.g = map;
    }

    private String a(TreeMap<String, String> treeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = treeMap.size();
        Iterator iterator = treeMap.entrySet().iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            stringBuilder.append(j.c(j.c((String)entry.getKey())));
            stringBuilder.append("%3D");
            stringBuilder.append(j.c(j.c((String)entry.getValue())));
            if (++n3 >= n2) continue;
            stringBuilder.append("%26");
        }
        return stringBuilder.toString();
    }

    private void a(StringBuilder stringBuilder, String string, String string2) {
        if (string2 != null) {
            stringBuilder.append(' ');
            stringBuilder.append(j.c(string));
            stringBuilder.append("=\"");
            stringBuilder.append(j.c(string2));
            stringBuilder.append("\",");
        }
    }

    private String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf((long)System.nanoTime()));
        stringBuilder.append(String.valueOf((long)Math.abs((long)a.nextLong())));
        return stringBuilder.toString();
    }

    private String c() {
        return Long.toString((long)(System.currentTimeMillis() / 1000L));
    }

    private String d() {
        String string = this.c != null ? this.c.c : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.a(this.b.b()));
        stringBuilder.append('&');
        stringBuilder.append(j.a(string));
        return stringBuilder.toString();
    }

    public String a() {
        String string = this.b();
        String string2 = this.c();
        return this.a(string, string2, this.a(this.a(string, string2)));
    }

    String a(String string) {
        try {
            String string2 = this.d();
            byte[] arrby = string.getBytes("UTF8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes("UTF8"), "HmacSHA1");
            Mac mac = Mac.getInstance((String)"HmacSHA1");
            mac.init((Key)secretKeySpec);
            byte[] arrby2 = mac.doFinal(arrby);
            String string3 = new String(d.a.b(arrby2, 0, arrby2.length), "UTF8");
            return string3;
        }
        catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException throwable) {
            c.h().d("Twitter", "Failed to calculate signature", throwable);
            return "";
        }
    }

    String a(String string, String string2) {
        URI uRI = URI.create((String)this.f);
        TreeMap<String, String> treeMap = j.a(uRI, true);
        if (this.g != null) {
            treeMap.putAll(this.g);
        }
        if (this.d != null) {
            treeMap.put((Object)"oauth_callback", (Object)this.d);
        }
        treeMap.put((Object)"oauth_consumer_key", (Object)this.b.a());
        treeMap.put((Object)"oauth_nonce", (Object)string);
        treeMap.put((Object)"oauth_signature_method", (Object)"HMAC-SHA1");
        treeMap.put((Object)"oauth_timestamp", (Object)string2);
        if (this.c != null && this.c.b != null) {
            treeMap.put((Object)"oauth_token", (Object)this.c.b);
        }
        treeMap.put((Object)"oauth_version", (Object)"1.0");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uRI.getScheme());
        stringBuilder.append("://");
        stringBuilder.append(uRI.getHost());
        stringBuilder.append(uRI.getPath());
        String string3 = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.e.toUpperCase(Locale.ENGLISH));
        stringBuilder2.append('&');
        stringBuilder2.append(j.c(string3));
        stringBuilder2.append('&');
        stringBuilder2.append(this.a(treeMap));
        return stringBuilder2.toString();
    }

    String a(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder("OAuth");
        this.a(stringBuilder, "oauth_callback", this.d);
        this.a(stringBuilder, "oauth_consumer_key", this.b.a());
        this.a(stringBuilder, "oauth_nonce", string);
        this.a(stringBuilder, "oauth_signature", string3);
        this.a(stringBuilder, "oauth_signature_method", "HMAC-SHA1");
        this.a(stringBuilder, "oauth_timestamp", string2);
        String string4 = this.c != null ? this.c.b : null;
        this.a(stringBuilder, "oauth_token", string4);
        this.a(stringBuilder, "oauth_version", "1.0");
        return stringBuilder.substring(0, -1 + stringBuilder.length());
    }
}

