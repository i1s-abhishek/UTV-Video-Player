package com.abhishek.xplayer.ad;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.abhishek.xplayer.application.MyApplication;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.firebase.FirebaseApp;
import com.mopub.common.MoPub;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

public class MopubInterstitialAdLoader implements AdInterface2 {

    
    Runnable runnable;
    private MoPubInterstitial moPubInterstitial;
    private com.google.android.gms.ads.InterstitialAd interstitialAd;
    private long aLong;
    private final MopubIntertitialAd f7986e;
    private final Context context;
    private AppAbstractInterface<MopubInterstitialAdLoader> f7988g;
    private final String intersitialAdUnit;

    public MopubInterstitialAdLoader(Context context, MopubIntertitialAd lVar, AppAbstractInterface<MopubInterstitialAdLoader> qVar, String str) {
        this.f7986e = lVar;
        this.context = context;
        this.intersitialAdUnit = str;
        this.f7988g = qVar;
    }

    
    public boolean InterstitialAdDone() {
        if (moPubInterstitial != null && moPubInterstitial.isReady() && this.moPubInterstitial.show()) {
            return true;
        }
        if (interstitialAd == null || !interstitialAd.isLoaded()) {
            return false;
        }
        this.interstitialAd.show();
        return true;
    }

    
    public boolean destroyad() {
        m10293g();
        this.f7986e.mo16929d(this);
        this.runnable = null;
        this.f7988g = null;
        setAdListenerMopub();
        setAdListenerAdmob();
        return true;
    }

    
    public void startLoadAd() {
        if (!MoPub.isSdkInitialized()) {
            MyApplication.myApplication().runnableDelay((Runnable) new Runnable() {
                public final void run() {
                    MopubInterstitialAdLoader.this.LoadMopubInterstitial();
                }
            }, 500);
        } else {
            InterstitialMoPub(this.context);
        }
    }

    public  void LoadMopubInterstitial() {
        InterstitialMoPub(this.context);
    }

    
    public boolean mo16905dd() {
        /*
            r1 = this;
            com.mopub.mobileads.MoPubInterstitial r0 = r1.moPubInterstitial
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isReady()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            com.google.android.gms.ads.InterstitialAd r0 = r1.interstitialAd
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isLoaded()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.p005ad.C2243k.mo16905d():boolean");
    }
    @Override
    public boolean mo16905d() {
        com.google.android.gms.ads.InterstitialAd interstitialAd;
        MoPubInterstitial moPubInterstitial = this.moPubInterstitial;
        return (moPubInterstitial != null && moPubInterstitial.isReady()) || ((interstitialAd = this.interstitialAd) != null && interstitialAd.isLoaded());
    }
    @Override
    public boolean mo16906e() {
        return m10292c() || (this.aLong > 0 && System.currentTimeMillis() - this.aLong > 1800000);
    }

    
    private boolean m10292c() {
        return this.aLong == -1;
    }

    
    private void m10293g() {
        this.aLong = -1;
    }

    public void m10294h() {
        this.aLong = System.currentTimeMillis();
        AppAbstractInterface<MopubInterstitialAdLoader> qVar = this.f7988g;
        if (qVar != null) {
            qVar.mo16863b(this);
        }
    }

    public void m10288a(String str) {
        AppAbstractInterface<MopubInterstitialAdLoader> qVar = this.f7988g;
        if (qVar != null) {
            qVar.mo16860a(this);
        }
        destroyad();
    }
 public  static  Activity activity;
    public static void Initilize(Activity context) {
        if (context != null) {
            activity=context;
        }
    }
    private void InterstitialMoPub(final Context context) {
        if (activity != null && !m10292c()) {
            try {
                this.moPubInterstitial = new MoPubInterstitial( activity, this.intersitialAdUnit);
                this.moPubInterstitial.setInterstitialAdListener(new MoPubInterstitial.InterstitialAdListener() {
                    public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {
                    }

                    public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {
                        Log.e("onInterstitialshown1","show");
                    }

                    public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
                        Log.e("onInterstitialloaded1","loadede");
                        MopubInterstitialAdLoader.this.m10294h();
                    }

                    public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {
                        Log.e("onInterstitialfail1","fail");
                        MopubInterstitialAdLoader.this.setAdListenerMopub();
                        MopubInterstitialAdLoader.this.InterstitialAdmob(context);
                    }

                    public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
                        if (MopubInterstitialAdLoader.this.runnable != null) {
                            MopubInterstitialAdLoader.this.runnable.run();
                            MopubInterstitialAdLoader.this.runnable = null;
                        }
                        MopubInterstitialAdLoader.this.destroyad();
                    }
                });
                this.moPubInterstitial.load();
            } catch (Exception e) {
                e.printStackTrace();
                InterstitialAdmob(context);
            }
        }
    }

    public void InterstitialAdmob(Context context) {
        if (context != null && !m10292c()) {
            try {
                this.interstitialAd = new com.google.android.gms.ads.InterstitialAd(context);
                this.interstitialAd.setAdUnitId("ca-app-pub-4292474654371508/7689210490");
                this.interstitialAd.setAdListener(new AdListener() {
                    public void onAdFailedToLoad(int i) {
                        super.onAdFailedToLoad(i);
                        Log.e("onInterstitialfail2","fail");
                        MopubInterstitialAdLoader.this.setAdListenerAdmob();
                        MopubInterstitialAdLoader kVar = MopubInterstitialAdLoader.this;
                        kVar.m10288a("AdmobError:" + i);
                    }

                    public void onAdLoaded() {
                        super.onAdLoaded();
                        Log.e("onInterstitialshown2","show");
                        MopubInterstitialAdLoader.this.m10294h();
                    }

                    public void onAdOpened() {
                        Log.e("onInterstitialshown2","loaded");
                        super.onAdOpened();
                    }

                    public void onAdClosed() {
                        super.onAdClosed();
                        if (MopubInterstitialAdLoader.this.runnable != null) {
                            MopubInterstitialAdLoader.this.runnable.run();
                            MopubInterstitialAdLoader.this.runnable = null;
                        }
                        MopubInterstitialAdLoader.this.destroyad();
                    }
                });
                this.interstitialAd.loadAd(new AdRequest.Builder().addTestDevice("111111111EAC93034622A3902158A1E4E6D8B6F20").build());
            } catch (Exception e) {
                e.printStackTrace();
                m10288a(e.getMessage());
            }
        }
    }

    public void setAdListenerMopub() {
        if (moPubInterstitial != null) {
            moPubInterstitial.setInterstitialAdListener((MoPubInterstitial.InterstitialAdListener) null);
            this.moPubInterstitial = null;
        }
    }

    public void setAdListenerAdmob() {
        if (interstitialAd != null) {
            interstitialAd.setAdListener((AdListener) null);
            this.interstitialAd = null;
        }
    }
}
