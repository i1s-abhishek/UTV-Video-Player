package com.abhishek.xplayer.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;


import org.greenrobot.eventbus.EventBus;

import java.util.Locale;

import classesdef.eventbus.awn;
import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.axy;
import video.downloader.videodownloader.app.BrowserApp;


public class MyApplication extends BrowserApp {


    private static MyApplication myApplication;


    private Handler handler;
    public CountDownTimer countDownTimer;
    public boolean f10492f = false;


    private Locale locale;


    public static Context getApplicationContext_() {
        return myApplication.getApplicationContext();
    }


    public static MyApplication myApplication() {
        return myApplication;
    }

    public void onCreate() {
        this.handler = new Handler(Looper.getMainLooper());
        myApplication = this;
        super.onCreate();
        InitilizationActivity.initilizeFirebase((Application) this);
    }


    public void runnable(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.handler.post(runnable);
        }
    }


    public void runnableDelay(Runnable runnable, long j) {
        this.handler.postDelayed(runnable, j);
    }


    public void mo17871b(Runnable runnable) {
        this.handler.removeCallbacks(runnable);
    }


    public void mo17866a(long j) {
        this.countDownTimer = new CountDownTimer(j, 1000) {
            public void onTick(long j) {
                boolean unused = MyApplication.this.f10492f = true;
                EventBus.getDefault().post(new awn(j, false));
            }

            public void onFinish() {
                boolean unused = MyApplication.this.f10492f = false;
                EventBus.getDefault().post(new awn(0, true));
                CountDownTimer unused2 = MyApplication.this.countDownTimer = null;
            }
        };
        this.countDownTimer.start();
    }


    public boolean mo17872c() {
        return this.f10492f;
    }


    public void mo17870a(boolean z) {
        this.f10492f = z;
    }


    public void mo17873d() {
        if (this.countDownTimer != null) {
            this.countDownTimer.cancel();
        }
        this.countDownTimer = null;
    }


    public boolean mo17874e() {
        return this.countDownTimer == null;
    }
    public Locale mo17875f() {
        return this.locale;
    }


    public void mo17867a(Context context) {
        this.locale = axy.getLocal(context, SharedPrefrence.language(context));
    }

    public void attachBaseContext(Context context) {
        mo17867a(context);
        m12033a(context.getResources(), this.locale);
        super.attachBaseContext(context);
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        m12033a(resources, this.locale);
        return resources;
    }


    public static void m12033a(Resources resources, Locale locale) {
        if (resources != null && locale != null) {
            Configuration configuration = resources.getConfiguration();
            if (!locale.equals(configuration.locale)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    configuration.setLocale(locale);
                    LocaleList localeList = new LocaleList(new Locale[]{locale});
                    LocaleList.setDefault(localeList);
                    configuration.setLocales(localeList);
                } else {
                    configuration.setLocale(locale);
                }
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
        }
    }
}
