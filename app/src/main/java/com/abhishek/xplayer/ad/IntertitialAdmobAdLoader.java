package com.abhishek.xplayer.ad;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import classesdef.ads.atd;


public class IntertitialAdmobAdLoader {
    public IntertialAdmobInterface f8098a;


    private InterstitialAd interstitialAd;

    private boolean f8100c;

    private long f8101d;

    public interface IntertialAdmobInterface {

        void showAd();


        void errorAd(int i);


        void openAd();


        void closeAd();
    }


    public void mo17029a(IntertialAdmobInterface aVar) {
        this.f8098a = aVar;
    }


    public void mo17028a(Context context) {
        setAdmobIntersitial(context);
    }


    public void showAd() {
        atd.m18388a("QUQA7jhq", System.currentTimeMillis());
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            this.interstitialAd.show();
        }
    }
    public void mo17030b() {
        this.f8100c = true;
        this.f8098a = null;
        setAdListener();
        AdmobIntertitialAds.create().mo16897a(this);
    }


    public boolean AdLoaded() {
        InterstitialAd interstitialAd = this.interstitialAd;
        return interstitialAd != null && interstitialAd.isLoaded();
    }

    public boolean mo17032d() {
        return this.f8101d > 0 && System.currentTimeMillis() - this.f8101d > 1800000;
    }

    public boolean mo17033e() {
        return this.f8100c;
    }

    public void m10472f() {
        this.f8101d = System.currentTimeMillis();
        IntertialAdmobInterface aVar = this.f8098a;
        if (aVar != null) {
            aVar.showAd();
        }
    }

    public void m10466a(int i) {
        IntertialAdmobInterface aVar = this.f8098a;
        if (aVar != null) {
            aVar.errorAd(i);
        }
        mo17030b();
    }

    private void setAdmobIntersitial(Context context) {
        if (context != null && !this.f8100c) {
            try {
                this.interstitialAd = new InterstitialAd(context);
                this.interstitialAd.setAdUnitId("ca-app-pub-4292474654371508/9193863855");
                this.interstitialAd.setAdListener(new AdListener() {
                    public void onAdFailedToLoad(int i) {
                        super.onAdFailedToLoad(i);
                        IntertitialAdmobAdLoader.this.setAdListener();
                        IntertitialAdmobAdLoader.this.m10466a(i);
                    }

                    public void onAdLoaded() {
                        super.onAdLoaded();
                        IntertitialAdmobAdLoader.this.m10472f();
                    }

                    public void onAdOpened() {
                        super.onAdOpened();
                        if (IntertitialAdmobAdLoader.this.f8098a != null) {
                            IntertitialAdmobAdLoader.this.f8098a.openAd();
                        }
                    }

                    public void onAdClosed() {
                        super.onAdClosed();
                        if (IntertitialAdmobAdLoader.this.f8098a != null) {
                            IntertitialAdmobAdLoader.this.f8098a.closeAd();
                        }
                        IntertitialAdmobAdLoader.this.mo17030b();
                    }
                });
                this.interstitialAd.loadAd(new AdRequest.Builder().build());
            } catch (Exception e) {
                e.printStackTrace();
                m10466a(-100);
            }
        }
    }

    public void setAdListener() {
        if (interstitialAd != null) {
            interstitialAd.setAdListener((AdListener) null);
            interstitialAd = null;
        }
    }
}
