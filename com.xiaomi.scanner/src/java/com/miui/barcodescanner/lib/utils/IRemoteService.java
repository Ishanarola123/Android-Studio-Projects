/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.IInterface
 *  android.os.RemoteException
 *  java.lang.Object
 *  java.lang.String
 */
package com.miui.barcodescanner.lib.utils;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;

public interface IRemoteService
extends IInterface {
    public Bitmap createQRImage(String var1, int var2) throws RemoteException;

    public String recogniseQRImage(Uri var1) throws RemoteException;
}

