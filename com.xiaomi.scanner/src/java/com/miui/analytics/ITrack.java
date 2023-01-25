/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 *  java.lang.Object
 *  java.lang.String
 */
package com.miui.analytics;

import android.os.IInterface;
import android.os.RemoteException;

public interface ITrack
extends IInterface {
    public void trackEvent(String var1, String var2, String var3, String var4) throws RemoteException;
}

