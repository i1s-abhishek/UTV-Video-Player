package com.abhishek.xplayer.ad;

import android.content.Context;

public class AdmobIntertitialAds {

    
    private static AdmobIntertitialAds loadAdmobIntertitial;
    
    private IntertitialAdmobAdLoader intertitialAdmobAd;

    
    public static AdmobIntertitialAds create() {
        if (loadAdmobIntertitial == null) {
            loadAdmobIntertitial = new AdmobIntertitialAds();
        }
        return loadAdmobIntertitial;
    }

    
    public IntertitialAdmobAdLoader mo16896a(Context context, IntertitialAdmobAdLoader.IntertialAdmobInterface aVar) {
        if (intertitialAdmobAd != null && !intertitialAdmobAd.mo17033e()) {
            if (this.intertitialAdmobAd.mo17032d()) {
                this.intertitialAdmobAd.mo17030b();
            } else {
                this.intertitialAdmobAd.mo17029a(aVar);
                return this.intertitialAdmobAd;
            }
        }
        this.intertitialAdmobAd = new IntertitialAdmobAdLoader();
        this.intertitialAdmobAd.mo17029a(aVar);
        this.intertitialAdmobAd.mo17028a(context);
        return this.intertitialAdmobAd;
    }

    
    public boolean mo16898b() {
        if (intertitialAdmobAd == null) {
            return false;
        }
        if (intertitialAdmobAd.mo17032d()) {
            this.intertitialAdmobAd.mo17030b();
            return false;
        } else if (!this.intertitialAdmobAd.AdLoaded()) {
            return false;
        } else {
            this.intertitialAdmobAd.showAd();
            return true;
        }
    }

   
    public void mo16897a(IntertitialAdmobAdLoader zVar) {
        if (this.intertitialAdmobAd == zVar) {
            this.intertitialAdmobAd = null;
        }
    }
}
