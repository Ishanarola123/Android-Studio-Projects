/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 */
package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.a.r;
import d.b;
import d.b.f;
import d.b.s;

public interface AccountService {
    @f(a="/1.1/account/verify_credentials.json")
    public b<r> verifyCredentials(@s(a="include_entities") Boolean var1, @s(a="skip_status") Boolean var2);
}

