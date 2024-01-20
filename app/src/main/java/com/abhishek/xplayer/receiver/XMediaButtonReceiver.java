package com.abhishek.xplayer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class XMediaButtonReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 21) {
            if (isOrderedBroadcast()) {
                abortBroadcast();
            }
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("lqeuoilkljvvoaso").putExtras(intent));
        }
    }
}
