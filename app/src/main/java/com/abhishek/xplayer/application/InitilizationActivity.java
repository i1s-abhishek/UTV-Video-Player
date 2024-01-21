package com.abhishek.xplayer.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.abhishek.xplayer.ad.C2231b;
import com.abhishek.xplayer.ad.SelfLoadedServerAds;
import com.abhishek.xplayer.service.NotifyService;
import com.google.android.gms.ads.MobileAds;

import classesdef.ads.C4786mv;
import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.FirebaseStup;
import classesdef.xdplayer.axy;

import static com.abhishek.xplayer.ad.MopubInterstitialAdLoader.Initilize;


public class InitilizationActivity {


    private static boolean once;


    public static void initilizeFirebase(Application application) {
        FirebaseStup.firebaseAppInitilize((Context) application);
        C2231b.m10188a().mo16919b();
    }


    public static void addInitilize(Activity activity) {
        Initilize( activity);
        if (!once) {
            Log.e("addInitilize",String.valueOf(once));
            once = true;
            C4786mv.m23718a().mo26045a((Context) activity, "d8dd9a1d5a5f439b9db9fda6ddcff54c");
//   AudienceNetworkAds.initialize(activity.getApplicationContext());
            MobileAds.initialize(activity.getApplicationContext(), "ca-app-pub-8178279133979191~8178279133");
            Log.e("addInitilize done",String.valueOf(once));
            MobileAds.setAppMuted(true);
            SelfLoadedServerAds.m10398a(activity.getApplicationContext(), "http://ad.myinstashot.com/hd3____", axy.cacheFolderAddresh(activity.getApplicationContext()));
            if (Build.VERSION.SDK_INT < 26 && SharedPrefrence.getSharedPrefrence(activity).getBoolean("notifyNew", true)) {
                activity.startService(new Intent(activity, NotifyService.class));
            }
        }
    }
}
