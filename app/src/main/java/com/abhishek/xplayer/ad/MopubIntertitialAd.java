package com.abhishek.xplayer.ad;

import android.content.Context;

import classesdef.ads.atd;


public class MopubIntertitialAd extends AppAbstractAds<MopubInterstitialAdLoader> {


    private static MopubIntertitialAd f7993b;


    private static MopubIntertitialAd f7994c;


    private long f7995d;


    private final boolean f7996e;


    private AppAbstractInterface<MopubInterstitialAdLoader> f7997f;


    public static MopubIntertitialAd createInstance1() {
        if (f7993b == null) {
            f7993b = new MopubIntertitialAd(false);
        }
        return f7993b;
    }


    public static MopubIntertitialAd createInstance2() {
        if (f7994c == null) {
            f7994c = new MopubIntertitialAd(true);
        }
        return f7994c;
    }

    MopubIntertitialAd(boolean z) {
        this.f7996e = z;
        this.f7995d = atd.m18391b(z ? "QUQA7jhq" : "kZYyeQdS", 0);
    }
    public boolean mo16926b() {
        if (System.currentTimeMillis() < this.f7995d + (this.f7996e ? C2231b.m10188a().mo16924g() : C2231b.m10188a().mo16922e())) {
            return false;
        }
        return super.mo16926b();
    }


    public MopubInterstitialAdLoader mo16909a(Context context, AppAbstractInterface<MopubInterstitialAdLoader> qVar) {
        return new MopubInterstitialAdLoader(context, this, this, this.f7996e ? "a1450f696a624df0bdc8019eb21eb320" : "259053b2dd714940916cec42ccb69bfe");
    }


    public String mo16910a() {
        return this.f7996e ? "SplashAd" : "Full";
    }


    public boolean mo16969g() {
        return mo16965a((Runnable) null, false);
    }


    public boolean mo16964a(Runnable runnable) {
        return mo16965a(runnable, false);
    }


    public boolean mo16965a(Runnable runnable, boolean z) {
        MopubInterstitialAdLoader kVar;
        if (atd.adRemoved("adRemoved", false)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f7995d + (this.f7996e ? C2231b.m10188a().mo16924g() : C2231b.m10188a().mo16922e()) || (kVar = (MopubInterstitialAdLoader) mo16927c()) == null || !kVar.mo16905d() || !kVar.InterstitialAdDone()) {
            return false;
        }
        kVar.runnable = runnable;
        if (!z) {
            String str = this.f7996e ? "QUQA7jhq" : "kZYyeQdS";
            this.f7995d = currentTimeMillis;
            atd.m18388a(str, currentTimeMillis);
        }
        mo16928c(kVar);
        return true;
    }


    public void mo16863b(MopubInterstitialAdLoader kVar) {
        super.mo16863b(kVar);
        AppAbstractInterface<MopubInterstitialAdLoader> qVar = this.f7997f;
        if (qVar != null) {
            qVar.mo16863b(kVar);
        }
    }


    public void mo16860a(MopubInterstitialAdLoader kVar) {
        super.mo16860a(kVar);
        AppAbstractInterface<MopubInterstitialAdLoader> qVar = this.f7997f;
        if (qVar != null) {
            qVar.mo16860a(kVar);
        }
    }


    public void mo16963a(AppAbstractInterface<MopubInterstitialAdLoader> qVar) {
        this.f7997f = qVar;
    }

    public void mo16968b(AppAbstractInterface<MopubInterstitialAdLoader> qVar) {
        if (this.f7997f == qVar) {
            this.f7997f = null;
        }
    }

    /* renamed from: h */
    public long mo16970h() {
        return this.f7995d;
    }
}
