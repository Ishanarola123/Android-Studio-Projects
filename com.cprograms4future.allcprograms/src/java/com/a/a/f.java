/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.UriMatcher
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.ContactsContract
 *  android.provider.ContactsContract$Contacts
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.a.a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import com.a.a.t;
import com.a.a.w;
import com.a.a.y;
import java.io.IOException;
import java.io.InputStream;

class f
extends y {
    private static final UriMatcher a = new UriMatcher(-1);
    private final Context b;

    static {
        a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        a.addURI("com.android.contacts", "contacts/#/photo", 2);
        a.addURI("com.android.contacts", "contacts/#", 3);
        a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    f(Context context) {
        this.b = context;
    }

    private InputStream b(w w2) throws IOException {
        ContentResolver contentResolver = this.b.getContentResolver();
        Uri uri = w2.d;
        switch (a.match(uri)) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid uri: ");
                stringBuilder.append((Object)uri);
                throw new IllegalStateException(stringBuilder.toString());
            }
            case 2: 
            case 4: {
                return contentResolver.openInputStream(uri);
            }
            case 1: {
                uri = ContactsContract.Contacts.lookupContact((ContentResolver)contentResolver, (Uri)uri);
                if (uri != null) break;
                return null;
            }
            case 3: 
        }
        if (Build.VERSION.SDK_INT < 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream((ContentResolver)contentResolver, (Uri)uri);
        }
        return a.a(contentResolver, uri);
    }

    @Override
    public y.a a(w w2, int n2) throws IOException {
        InputStream inputStream = this.b(w2);
        if (inputStream != null) {
            return new y.a(inputStream, t.d.b);
        }
        return null;
    }

    @Override
    public boolean a(w w2) {
        Uri uri = w2.d;
        return "content".equals((Object)uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals((Object)uri.getHost()) && a.match(w2.d) != -1;
    }

}

