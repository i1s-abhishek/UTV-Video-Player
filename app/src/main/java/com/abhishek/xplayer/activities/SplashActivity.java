package com.abhishek.xplayer.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.abhishek.xplayer.ad.AdmobIntertitialAds;
import com.abhishek.xplayer.ad.C2231b;
import com.abhishek.xplayer.ad.MopubInterstitialAdLoader;
import com.abhishek.xplayer.ad.MopubIntertitialAd;
import com.abhishek.xplayer.ad.AppAbstractInterface;
import com.abhishek.xplayer.ad.IntertitialAdmobAdLoader;
import com.abhishek.xplayer.application.InitilizationActivity;
import com.abhishek.xplayer.content.C2650e;
import com.abhishek.xplayer.content.VideoManager;

import java.lang.ref.WeakReference;
import java.util.List;

import classesdef.ads.atd;
import classesdef.xdplayer.AllPermission;
import classesdef.xdplayer.FirebaseStup;
import classesdef.xdplayer.LogEvents;

import static com.abhishek.xplayer.ad.MopubInterstitialAdLoader.Initilize;

public class SplashActivity extends AppCompatActivity  {


    private boolean splashUseMoPub;

    public boolean f7911l;

    public long f7912m = 0;

    public final Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 294) {
                C2650e.m12160a((List) message.obj);
                if (!SplashActivity.this.f7911l) {
                    removeMessages(0);
                    SplashActivity.this.openFileExplorerActivity();
                    return;
                }
                return;
            }
            SplashActivity.this.openFileExplorerActivity();
        }
    };

    public IntertitialAdmobAdLoader f7914o;


    private final IntertitialAdmobAdLoader.IntertialAdmobInterface f7915p = new IntertitialAdmobAdLoader.IntertialAdmobInterface() {
        public void showAd() {
            if (SplashActivity.this.f7914o != null) {
                SplashActivity.this.f7914o.showAd();
                LogEvents.m18486a("SplashAd", "Show", "SplashPage");
            }
        }

        public void errorAd(int i) {
            if (SplashActivity.this.f7912m > 0) {
                long currentTimeMillis = System.currentTimeMillis() - SplashActivity.this.f7912m;
                if (currentTimeMillis < 1500 && currentTimeMillis > 0) {
                    SplashActivity.this.handler.sendEmptyMessageDelayed(0, 1500 - currentTimeMillis);
                    return;
                }
            }
            SplashActivity.this.openFileExplorerActivity();
        }

        public void openAd() {
            SplashActivity.this.handler.removeMessages(0);
        }

        public void closeAd() {
            SplashActivity.this.openFileExplorerActivity();
        }
    };

    private final AppAbstractInterface<MopubInterstitialAdLoader> f7916q = new AppAbstractInterface<MopubInterstitialAdLoader>() {
        public void mo16863b(MopubInterstitialAdLoader kVar) {
            LogEvents.m18486a("SplashAd", "Show", "SplashPage");
            if (MopubIntertitialAd.createInstance2().mo16964a((Runnable) SplashActivity.this.f7917r)) {
                SplashActivity.this.handler.removeMessages(0);
            }
        }

        public void mo16860a(MopubInterstitialAdLoader kVar) {
            if (SplashActivity.this.f7912m > 0) {
                long currentTimeMillis = System.currentTimeMillis() - SplashActivity.this.f7912m;
                if (currentTimeMillis < 1500 && currentTimeMillis > 0) {
                    SplashActivity.this.handler.sendEmptyMessageDelayed(0, 1500 - currentTimeMillis);
                    return;
                }
            }
            SplashActivity.this.openFileExplorerActivity();
        }
    };

    public final C2224a f7917r = new C2224a(SplashActivity.this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Initilize( this);
    //    Toast.makeText(this, "splashUseMoPub__="+String.valueOf(FirebaseStup.splashUseMoPub("splashUseMoPub")), Toast.LENGTH_SHORT).show();
        Log.e("splashUseMoPub",String.valueOf(FirebaseStup.splashUseMoPub("splashUseMoPub")));
        this.splashUseMoPub =FirebaseStup.splashUseMoPub("splashUseMoPub");
        LogEvents.m18483a("OpenApp");
        VideoManager.m12177a(this.handler);
        if (getIntent() != null && getIntent().getBooleanExtra("fromNotification", false)) {
            LogEvents.m18492b("Notification", "click");
        }
        InitilizationActivity.addInitilize((Activity) this);
        boolean z = AllPermission.m7381a(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") && C2650e.m12161b();
        this.f7911l = m10141n();
        if (z) {
            m10139l();
        }
        if (this.f7911l) {
            this.handler.sendEmptyMessageDelayed(0, C2231b.m10188a().mo16925h());
            if (!this.splashUseMoPub) {
                this.f7914o = AdmobIntertitialAds.create().mo16896a(getApplicationContext(), this.f7915p);
                if (this.f7914o.AdLoaded()) {
                    this.f7914o.showAd();
                }
            } else if (!MopubIntertitialAd.createInstance2().mo16917d()) {
                MopubIntertitialAd.createInstance2().mo16963a(this.f7916q);
                MopubIntertitialAd.createInstance2().mo16926b();
            } else if (MopubIntertitialAd.createInstance2().mo16964a((Runnable) this.f7917r)) {
                this.handler.removeMessages(0);
            }
        } else {
            this.handler.sendEmptyMessageDelayed(0, 500);
        }
    }

    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            MopubIntertitialAd.createInstance2().mo16968b(this.f7916q);
            IntertitialAdmobAdLoader zVar = this.f7914o;
            if (zVar != null) {
                zVar.mo17029a((IntertitialAdmobAdLoader.IntertialAdmobInterface) null);
                this.f7914o = null;
            }
            this.handler.removeMessages(0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        MopubIntertitialAd.createInstance2().mo16968b(this.f7916q);
        IntertitialAdmobAdLoader zVar = this.f7914o;
        if (zVar != null) {
            zVar.mo17029a((IntertitialAdmobAdLoader.IntertialAdmobInterface) null);
            this.f7914o = null;
        }
        this.handler.removeMessages(0);
        VideoManager.m12177a(this.handler);
    }


    private void m10139l() {
        if (!this.f7911l) {
            this.handler.sendEmptyMessageDelayed(0, 1500);
        }
        this.f7912m = System.currentTimeMillis();
        VideoManager.m12174a();
    }

    public void openFileExplorerActivity() {
        if (!isFinishing()) {
            startActivity(new Intent(this, FileExplorerActivity.class));
            finish();
            overridePendingTransition(0, 0);
        }
    }

    private static class C2224a implements Runnable {

        private final WeakReference<SplashActivity> f7921a;

        private C2224a(SplashActivity splashActivity) {
            this.f7921a = new WeakReference<>(splashActivity);
        }

        public void run() {
            SplashActivity splashActivity = (SplashActivity) this.f7921a.get();
            if (splashActivity != null && !splashActivity.isFinishing()) {
                splashActivity.openFileExplorerActivity();
            }
        }
    }


    private boolean m10141n() {
        if (atd.adRemoved("adRemoved", false)) {
            return false;
        }
        if (this.splashUseMoPub) {
            return true;
        }
        if (System.currentTimeMillis() - atd.m18391b("QUQA7jhq", 0) > C2231b.m10188a().mo16924g()) {
            return true;
        }
        return false;
    }

}
