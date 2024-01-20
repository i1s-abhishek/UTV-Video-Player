package classesdef.browser;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

/* renamed from: bov */
public class bov {
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r2 = r2.getActiveNetworkInfo();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m18446aa(Context r2) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r0)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            android.net.NetworkInfo r0 = r2.getActiveNetworkInfo()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r0.isAvailable()
            if (r0 == 0) goto L_0x0028
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()
            if (r2 == 0) goto L_0x0028
            int r0 = r2.getType()
            r1 = 1
            if (r0 != r1) goto L_0x0028
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x0028
            return r1
        L_0x0028:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.bov.m18446a(android.content.Context):boolean");
    }
    public static boolean m18446a(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo2 = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo2 != null && activeNetworkInfo2.isAvailable() && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected();
    }
    /* renamed from: b */
    public static boolean m18447b(Context context) {
        boolean z;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 21) {
                NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo != null) {
                    int i = 0;
                    while (true) {
                        if (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i] != null && allNetworkInfo[i].isConnected()) {
                                z = true;
                                return true;

                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                return z;
            }
            Network[] allNetworks = connectivityManager.getAllNetworks();
            if (allNetworks == null) {
                return false;
            }
            for (Network networkInfo : allNetworks) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(networkInfo);
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean m18447bb(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 21) {
                NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo == null) {
                    return false;
                }
                int i = 0;
                while (i < allNetworkInfo.length) {
                    if (allNetworkInfo[i] == null || !allNetworkInfo[i].isConnected()) {
                        i++;
                    }
                }
                return false;
            }
            Network[] allNetworks = connectivityManager.getAllNetworks();
            if (allNetworks == null) {
                return false;
            }
            int i2 = 0;
            while (i2 < allNetworks.length) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i2]);
                if (networkInfo == null || !networkInfo.isConnected()) {
                    i2++;
                }
            }
           // return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
