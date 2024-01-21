package com.abhishek.xplayer.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mopub.nativeads.NativeErrorCode;

import classesdef.ads.AdInterface;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.LogEvents;
import hdplayer.xdplayer.videoplayer.R;



public class PauseNativeAdLoader implements AdInterface2, AdInterface {

    /* renamed from: a */
    boolean f8044a;

    /* renamed from: b */
    private NativeAds f8045b;

    /* renamed from: c */
    private Context f8046c;

    /* renamed from: d */
    private long f8047d = 0;

    /* renamed from: e */
    private boolean f8048e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ViewGroup f8049f = null;

    /* renamed from: g */
    private ImageView f8050g = null;

    /* renamed from: h */
    private AppAbstractInterface<PauseNativeAdLoader> f8051h;

    public PauseNativeAdLoader(Context context) {
        this.f8046c = context;
        this.f8045b = new NativeAds("d8dd9a1d5a5f439b9db9fda6ddcff54c", true, R.layout.pause_native_ad);
        this.f8045b.setAdInterface((AdInterface) this);
    }

    /* renamed from: b */
    public boolean destroyad() {
        m10403i();
        PauseNativeAd.m10414e().mo16929d(this);
        NativeAds eVar = this.f8045b;
        if (eVar != null) {
            eVar.mo16936d();
            this.f8045b = null;
            return true;
        }
        this.f8051h = null;
        this.f8047d = -1;
        return false;
    }

    /* renamed from: d */
    public boolean mo16905d() {
        return this.f8047d > 0 && this.f8045b != null;
    }

    /* renamed from: e */
    public boolean mo16906e() {
        return m10402h() || (this.f8047d > 0 && System.currentTimeMillis() - this.f8047d > 1800000);
    }

    /* renamed from: h */
    private boolean m10402h() {
        return this.f8047d == -1;
    }

    /* renamed from: c */
    public boolean mo17007c() {
        return this.f8048e;
    }

    /* renamed from: f */
    public void startLoadAd() {
        this.f8045b.mo16931a(this.f8046c);
    }

    /* renamed from: g */
    public View mo17008g() {
        return this.f8049f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo17006a(AppAbstractInterface<PauseNativeAdLoader> qVar) {
        this.f8051h = qVar;
    }

    /* renamed from: i */
    private void m10403i() {
        ViewGroup viewGroup = this.f8049f;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.f8049f.removeAllViews();
            this.f8049f = null;
        }
        ImageView imageView = this.f8050g;
        if (imageView != null) {
            imageView.setImageBitmap((Bitmap) null);
        }
        this.f8047d = -1;
    }

    /* renamed from: a */
    public void AdLayout(View view) {
        if (view == null) {
            AdsError((NativeErrorCode) null);
            return;
        }
        this.f8049f = (ViewGroup) LayoutInflater.from(view.getContext()).inflate(R.layout.pause_native_ad_layout, (ViewGroup) null);
        this.f8049f.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PauseNativeAdLoader.this.f8049f != null) {
                    PauseNativeAdLoader.this.f8049f.setVisibility(8);
                    PauseNativeAdLoader.this.destroyad();
                }
            }
        });
        int a = axw.m7444a(this.f8046c, 12.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f8046c.getResources().getDimensionPixelOffset(R.dimen.pause_ad_width), -2);
        layoutParams.topMargin = a;
        layoutParams.leftMargin = a;
        this.f8049f.addView(view, 0, layoutParams);
        this.f8047d = System.currentTimeMillis();
        AppAbstractInterface<PauseNativeAdLoader> qVar = this.f8051h;
        if (qVar != null) {
            qVar.mo16863b(this);
        }
    }

    /* renamed from: a */
    public void AdsError(NativeErrorCode nativeErrorCode) {
        AppAbstractInterface<PauseNativeAdLoader> qVar = this.f8051h;
        if (qVar != null) {
            qVar.mo16860a(this);
        }
        this.f8047d = -1;
    }

    /* renamed from: a */
    public void AdLogEvent() {
        LogEvents.m18486a("PauseAd", "Click", "Mopub");
        m10403i();
        this.f8048e = true;
    }
}
