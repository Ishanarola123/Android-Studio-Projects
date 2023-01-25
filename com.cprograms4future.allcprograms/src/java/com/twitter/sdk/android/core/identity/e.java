/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.ConsoleMessage
 *  android.webkit.WebChromeClient
 */
package com.twitter.sdk.android.core.identity;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

class e
extends WebChromeClient {
    e() {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }
}

