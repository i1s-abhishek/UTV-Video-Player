package com.abhishek.xplayer.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mopub.nativeads.NativeErrorCode;

import classesdef.ads.AdInterface;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;



public class VideoListNativeAdLoader implements AdInterface2, AdInterface {

    /* renamed from: a */
    private NativeAds f7927a;

    /* renamed from: b */
    private Context f7928b;

    /* renamed from: c */
    private long f7929c = 0;

    /* renamed from: d */
    private ViewGroup f7930d = null;

    /* renamed from: e */
    private AppAbstractInterface<VideoListNativeAdLoader> f7931e;

    public VideoListNativeAdLoader(Context context) {
        this.f7928b = context;
        this.f7927a = new NativeAds("daab15a606af4d809c1afd40e2216268", false, R.layout.video_list_ad, 2);
        this.f7927a.setAdInterface((AdInterface) this);
    }

    /* renamed from: b */
    public boolean destroyad() {
        m10164i();
        VideoListNativeAd.m10175e().mo16929d(this);
        this.f7931e = null;
        this.f7929c = -1;
        return false;
    }

    /* renamed from: c */
    public void mo16904c() {
        destroyad();
        NativeAds eVar = this.f7927a;
        if (eVar != null) {
            eVar.mo16933a(false);
            this.f7927a = null;
        }
    }

    /* renamed from: d */
    public boolean mo16905d() {
        return this.f7929c > 0 && this.f7927a != null;
    }

    /* renamed from: e */
    public boolean mo16906e() {
        return m10163h() || (this.f7929c > 0 && System.currentTimeMillis() - this.f7929c > 1800000);
    }

    /* renamed from: h */
    private boolean m10163h() {
        return this.f7929c == -1;
    }

    /* renamed from: f */
    public void startLoadAd() {
        this.f7927a.mo16931a(this.f7928b);
    }

    /* renamed from: g */
    public View mo16908g() {
        return this.f7930d;
    }

    /* access modifiers changed from: package-private */
    public void mo16901a(AppAbstractInterface<VideoListNativeAdLoader> qVar) {
        this.f7931e = qVar;
    }


    private void m10164i() {
        this.f7929c = -1;
    }


    public void AdLayout(View view) {
        if (view == null) {
            AdsError((NativeErrorCode) null);
            return;
        }
        this.f7930d = (ViewGroup) view;
        this.f7929c = System.currentTimeMillis();
        AppAbstractInterface<VideoListNativeAdLoader> qVar = this.f7931e;
        if (qVar != null) {
            qVar.mo16863b(this);
        }
    }


    public void AdsError(NativeErrorCode nativeErrorCode) {
        AppAbstractInterface<VideoListNativeAdLoader> qVar = this.f7931e;
        if (qVar != null) {
            qVar.mo16860a(this);
        }
        this.f7929c = -1;
    }

    /* renamed from: a */
    public void AdLogEvent() {
        LogEvents.m18486a(VideoListNativeAd.m10175e().mo16910a(), "Click", "Mopub");
        m10164i();
        VideoListNativeAd.m10175e().mo16926b();
    }

    /* renamed from: a */
    public static void m10162a(View view, boolean z) {
        Boolean bool = (Boolean) view.getTag(R.id.tagID_boolean);
        if (bool == null) {
            bool = false;
        }
        if (z != bool.booleanValue()) {
            ((TextView) view.findViewById(R.id.admob_native_title)).setTextColor(z ? -1 : -13421773);
            view.setTag(R.id.tagID_boolean, Boolean.valueOf(z));
        }
    }
}
