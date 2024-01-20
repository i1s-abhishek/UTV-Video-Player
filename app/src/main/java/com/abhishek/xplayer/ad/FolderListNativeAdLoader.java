package com.abhishek.xplayer.ad;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mopub.nativeads.NativeErrorCode;

import classesdef.ads.AdInterface;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;



public class FolderListNativeAdLoader implements AdInterface2, AdInterface {

    
    private NativeAds nativeAds;

    private Context context;

    private long f7976c = 0;

    private ViewGroup view = null;

    private AppAbstractInterface<FolderListNativeAdLoader> appAbstractInterface;

    public FolderListNativeAdLoader(Context context) {
        Log.e("folderListAds","adload unkwon1");
        this.context = context;
        this.nativeAds = new NativeAds("6f8c1877da064ac8a97ee020457546b2", false, R.layout.folder_list_ad, 2);
        this.nativeAds.setAdInterface((AdInterface) this);
    }

    public boolean destroyad() {
        m10260i();
        FolderListNativeAd.createRefrence().mo16929d(this);
        this.appAbstractInterface = null;
        this.f7976c = -1;
        return false;
    }

    public void mo16952c() {
        Log.e("folderListAds","adload 2");
        destroyad();
        if (nativeAds != null) {
            nativeAds.mo16933a(false);
            this.nativeAds = null;
        }
    }

    public boolean mo16905d() {
        return this.f7976c > 0 && this.nativeAds != null;
    }

    public boolean mo16906e() {
        return m10259h() || (this.f7976c > 0 && System.currentTimeMillis() - this.f7976c > 1800000);
    }

    private boolean m10259h() {
        return this.f7976c == -1;
    }

    public void startLoadAd() {
        this.nativeAds.mo16931a(this.context);
    }

    public View mo16953g() {
        return this.view;
    }

  
    public void mo16951a(AppAbstractInterface<FolderListNativeAdLoader> qVar) {
        this.appAbstractInterface = qVar;
    }

    private void m10260i() {
        this.f7976c = -1;
    }

    public void AdLayout(View view) {
        if (view == null) {
            AdsError((NativeErrorCode) null);
            return;
        }
        this.view = (ViewGroup) view;
        this.f7976c = System.currentTimeMillis();
        AppAbstractInterface<FolderListNativeAdLoader> qVar = this.appAbstractInterface;
        if (qVar != null) {
            qVar.mo16863b(this);
        }
    }

    public void AdsError(NativeErrorCode nativeErrorCode) {
        AppAbstractInterface<FolderListNativeAdLoader> qVar = this.appAbstractInterface;
        if (qVar != null) {
            qVar.mo16860a(this);
        }
        this.f7976c = -1;
    }

    public void AdLogEvent() {
        LogEvents.m18486a(FolderListNativeAd.createRefrence().mo16910a(), "Click", "Mopub");
        m10260i();
        FolderListNativeAd.createRefrence().mo16926b();
    }

    public static void setNativeThemeColor(View view, boolean theme) {
        Boolean bool = (Boolean) view.getTag(R.id.tagID_boolean);
        Log.e("tagID_boolean","__"+String.valueOf(bool));
        if (bool == null) {
            bool = false;
        }
        Log.e("tagID_boolean","__"+String.valueOf(bool.booleanValue()));
        if (theme != bool.booleanValue()) {
            ((TextView) view.findViewById(R.id.admob_native_title)).setTextColor(theme ? -1 : -13421773);
            view.setTag(R.id.tagID_boolean, Boolean.valueOf(theme));
        }
    }
}
