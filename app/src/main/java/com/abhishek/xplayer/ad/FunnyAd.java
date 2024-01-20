package com.abhishek.xplayer.ad;

import android.app.Activity;
import android.content.Intent;

import classesdef.xdplayer.LogEvents;

public class FunnyAd {

    public static void loadFunnyAd(Activity activity, boolean z, String str) {
        loadFunnyAdIntent(activity, z, str);
    }

    private static void loadFunnyAdIntent(Activity activity, boolean z, String str) {
        Intent intent = new Intent(activity, FunnyAdActivity.class);
        if (z) {
            intent.putExtra("blackStyle", true);
        }
        activity.startActivity(intent);
        LogEvents.m18492b(str, "FunnyAd/Funny");
    }
}
