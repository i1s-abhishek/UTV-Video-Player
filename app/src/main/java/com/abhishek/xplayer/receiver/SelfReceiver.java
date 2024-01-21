package com.abhishek.xplayer.receiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.abhishek.xplayer.service.C2779a;
import com.abhishek.xplayer.service.NotifyService;
import com.abhishek.xplayer.service.PlayerService;

import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.LogEvents;
import hdplayer.xdplayer.videoplayer.R;


public class SelfReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            char c = 65535;
            switch (action.hashCode()) {
                case -1316099895:
                    if (action.equals("wdle2dfw")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1238044258:
                    if (action.equals("flkdlwasdf")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1195118793:
                    if (action.equals("xvlqefsfvv")) {
                        c = 3;
                        break;
                    }
                    break;
                case 416692295:
                    if (action.equals("oeuortoqwei")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1568073583:
                    if (action.equals("zxcwe2dfwe")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1610371712:
                    if (action.equals("dgoasdf")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1846918930:
                    if (action.equals("sfdavxvv")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    LogEvents.m18492b("Notification", "skip");
                    ((NotificationManager) context.getSystemService("notification")).cancel(328);
                    return;
                case 1:
                    LogEvents.m18492b("Notification", "neverRemind");
                    ((NotificationManager) context.getSystemService("notification")).cancel(328);
                    SharedPrefrence.getSharedPrefrence(context).edit().putBoolean("notifyNew", false).apply();
                    context.stopService(new Intent(context, NotifyService.class));
                    return;
                case 2:
                    LogEvents.m18492b("BackgroundPlayNotification", "Close");
                    if (!C2779a.m12613a().mo18136b(context, true)) {
                        PlayerService.m12599b(context);
                    }
                    LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent("zxcwe2dfwe"));
                    return;
                case 3:
                    LogEvents.m18492b("BackgroundPlayNotification", "Play");
                    C2779a.m12613a().mo18145k();
                    return;
                case 4:
                    LogEvents.m18492b("BackgroundPlayNotification", "Pause");
                    C2779a.m12613a().mo18146l();
                    return;
                case 5:
                    if (intent.getBooleanExtra("ipcldjwsd", false)) {
                        LogEvents.m18492b("BackgroundPlayNotification", "Previous");
                        if (!C2779a.m12613a().mo18149o()) {
                            axv.m7434a((int) R.string.no_previous_video);
                            return;
                        }
                        return;
                    }
                    LogEvents.m18492b("BackgroundPlayNotification", "Next");
                    if (!C2779a.m12613a().mo18148n()) {
                        axv.m7434a((int) R.string.no_next_video);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
