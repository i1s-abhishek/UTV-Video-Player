package com.abhishek.xplayer.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mopub.nativeads.NativeErrorCode;

import classesdef.ads.AdInterface;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;



public class DownloadNativeAdLoader implements AdInterface2, AdInterface {


    private NativeAds f7957a;


    private Context f7958b;


    private long f7959c = 0;


    private ViewGroup f7960d = null;


    private AppAbstractInterface<DownloadNativeAdLoader> f7961e;

    public DownloadNativeAdLoader(Context context) {
        this.f7958b = context;
        this.f7957a = new NativeAds("247167f8307e49728dbb668ca6fece27", false, R.layout.folder_list_ad, 2);
        this.f7957a.setAdInterface((AdInterface) this);
    }


    public boolean destroyad() {
        m10224i();
        DownloadListNativeAds.m10235e().mo16929d(this);
        this.f7961e = null;
        this.f7959c = -1;
        return false;
    }


    public void mo16938c() {
        destroyad();
        NativeAds eVar = this.f7957a;
        if (eVar != null) {
            eVar.mo16933a(false);
            this.f7957a = null;
        }
    }


    public boolean mo16905d() {
        return this.f7959c > 0 && this.f7957a != null;
    }


    public boolean mo16906e() {
        return m10223h() || (this.f7959c > 0 && System.currentTimeMillis() - this.f7959c > 1800000);
    }


    private boolean m10223h() {
        return this.f7959c == -1;
    }


    public void startLoadAd() {
        this.f7957a.mo16931a(this.f7958b);
    }


    public View mo16939g() {
        return this.f7960d;
    }


    public void mo16937a(AppAbstractInterface<DownloadNativeAdLoader> qVar) {
        this.f7961e = qVar;
    }


    private void m10224i() {
        this.f7959c = -1;
    }


    public void AdLayout(View view) {
        if (view == null) {
            AdsError((NativeErrorCode) null);
            return;
        }
        this.f7960d = (ViewGroup) view;
        this.f7959c = System.currentTimeMillis();
        AppAbstractInterface<DownloadNativeAdLoader> qVar = this.f7961e;
        if (qVar != null) {
            qVar.mo16863b(this);
        }
    }


    public void AdsError(NativeErrorCode nativeErrorCode) {
        AppAbstractInterface<DownloadNativeAdLoader> qVar = this.f7961e;
        if (qVar != null) {
            qVar.mo16860a(this);
        }
        this.f7959c = -1;
    }


    public void AdLogEvent() {
        LogEvents.m18486a(DownloadListNativeAds.m10235e().mo16910a(), "Click", "Mopub");
        m10224i();
        DownloadListNativeAds.m10235e().mo16926b();
    }
}
