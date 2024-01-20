package video.downloader.videodownloader.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class NetworkReceiver extends BroadcastReceiver {
    /* renamed from: a */
    public abstract void check(boolean z);

    public void onReceive(Context context, Intent intent) {
        check(isConnected(context));
    }

    /* renamed from: a */
    private static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
