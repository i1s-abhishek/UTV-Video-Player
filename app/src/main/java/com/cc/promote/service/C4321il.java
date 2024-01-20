package com.cc.promote.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: il */
public class C4321il {
    /* renamed from: a */
    public static boolean m19820a(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
                return false;
            }
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i] != null && allNetworkInfo[i].isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
