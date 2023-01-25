/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.wifi.WifiManager
 *  androidx.annotation.RequiresPermission
 *  java.lang.Object
 *  java.lang.String
 *  miuix.core.util.SoftReferenceSingleton
 *  miuix.net.ConnectivityHelper$1
 */
package miuix.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import androidx.annotation.RequiresPermission;
import miuix.core.util.SoftReferenceSingleton;
import miuix.net.ConnectivityHelper;

public class ConnectivityHelper {
    private static final SoftReferenceSingleton<ConnectivityHelper> INSTANCE = new 1();
    private static final String TAG = "ConnectivityHelper";
    private ConnectivityManager mConnectivityManager;
    private String mMacAddress;
    private WifiManager mWifiManager;

    private ConnectivityHelper(Context context) {
        this.mConnectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
    }

    public static ConnectivityHelper getInstance(Context context) {
        return (ConnectivityHelper)INSTANCE.get((Object)context);
    }

    public ConnectivityManager getManager() {
        return this.mConnectivityManager;
    }

    @RequiresPermission(value="android.permission.ACCESS_NETWORK_STATE")
    public boolean isNetworkConnected() {
        NetworkInfo networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @RequiresPermission(value="android.permission.ACCESS_NETWORK_STATE")
    public boolean isUnmeteredNetworkConnected() {
        NetworkInfo networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected() && !this.mConnectivityManager.isActiveNetworkMetered();
    }

    @RequiresPermission(value="android.permission.ACCESS_NETWORK_STATE")
    public boolean isWifiConnected() {
        NetworkInfo networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1;
    }
}

