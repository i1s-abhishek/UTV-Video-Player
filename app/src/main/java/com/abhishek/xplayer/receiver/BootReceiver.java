package com.abhishek.xplayer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.service.NotifyService;

import classesdef.inplayer.SharedPrefrence;

public class BootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 26 && intent != null && intent.getAction() != null && "android.intent.action.BOOT_COMPLETED".equals(intent.getAction()) && SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("notifyNew", true)) {
            context.startService(new Intent(context, NotifyService.class));
        }
    }
}
