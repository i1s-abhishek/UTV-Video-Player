package com.abhishek.xplayer.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.mopub.common.util.Views;
import com.mopub.mobileads.GooglePlayServicesBanner;
import com.mopub.nativeads.GooglePlayServicesNative;
import com.mopub.nativeads.NativeErrorCode;

import java.util.HashMap;

import classesdef.ads.AdInterface;
import hdplayer.xdplayer.videoplayer.R;

public class NativeAds implements AdInterface {

    private MopubNativeAdLoader nativeAds;

    private boolean f7949b;

    private AdInterface adInterface;

    private View adView;

    private String nativeAdUnit;

    private final int nativeAdLayout;

    private final boolean adOrientation;

    private final int f7955h;

    private AdmobNativeAdLoader admobNativeAdLoader;

    NativeAds(String str, boolean z, int i) {
        this(str, z, i, 1);
    }

    NativeAds(String str, boolean z, int i, int i2) {
     Log.e("ad_container_","load native");
        this.nativeAdUnit = str;
        this.adOrientation = z;
        this.nativeAdLayout = i;
        this.f7955h = i2;
    }

    public void setAdInterface(AdInterface ncVar) {
        this.adInterface = ncVar;
    }

    public void mo16931a(Context context) {
        if (this.nativeAds == null) {
            try {
                this.nativeAds = m10213a(context, this);
                this.f7949b = false;
            } catch (Throwable th) {
               // ats.m18490a(th);
            }
        }
    }

    public boolean mo16934b() {
        return (this.nativeAds == null || this.adView == null || !this.f7949b) ? false : true;
    }

    public Bitmap mo16935c() {
        View view = this.adView;
        if (view == null) {
            return null;
        }
        View findViewById = view.findViewById(R.id.admob_native_icon);
        if (!(findViewById instanceof ImageView)) {
            return null;
        }
        Drawable drawable = ((ImageView) findViewById).getDrawable();
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    public void mo16936d() {
        mo16933a(true);
    }

    public void mo16933a(boolean z) {
        Log.e("folderListAds","adload 3");
        this.adInterface = null;
        if (z) {
            Views.removeFromParent(this.adView);
        }
        if (nativeAds != null) {
            this.f7949b = false;
            nativeAds.onInvalidate();
            this.nativeAds = null;
        }
        if (admobNativeAdLoader != null) {
            admobNativeAdLoader.unifiedNativeAdDestroy();
            this.admobNativeAdLoader = null;
        }
    }

    private MopubNativeAdLoader m10213a(Context context, AdInterface ncVar) {
        Log.e("folderListAds","adload unkwon2a");
        HashMap hashMap = new HashMap();
        hashMap.put("adChoicePosition", Integer.valueOf(this.f7955h));
        hashMap.put(GooglePlayServicesBanner.AD_WIDTH_KEY, -2);
        hashMap.put(GooglePlayServicesBanner.AD_HEIGHT_KEY, -2);
        hashMap.put("LayoutId", Integer.valueOf(this.nativeAdLayout));
        if (this.adOrientation) {
            hashMap.put(GooglePlayServicesNative.KEY_EXTRA_ORIENTATION_PREFERENCE, 1);
            hashMap.put("adLoadCover", true);
        }
        MopubNativeAdLoader rVar = new MopubNativeAdLoader(context, this.nativeAdUnit, hashMap, ncVar);
        rVar.loadNativeAdd(this.nativeAdUnit);
        return rVar;
    }

    public void AdLayout(View view) {
        this.f7949b = true;
        this.adView = view;
        View findViewById = view.findViewById(R.id.admob_native_icon);
        if (findViewById instanceof ImageView) {
            ImageView imageView = (ImageView) findViewById;
            if (imageView.getDrawable() == null && imageView.getBackground() == null) {
                imageView.setVisibility(8);
            } else if (imageView.getVisibility() == 8) {
                imageView.setVisibility(0);
            }
        }
        if (adInterface != null) {
            adInterface.AdLayout(view);
        }
    }

    public void AdsError(NativeErrorCode nativeErrorCode) {
        Log.e("folderListAdse","adload unkwon ad error"+String.valueOf(nativeErrorCode));
        Log.e("folderListAdse","adload unkwon ad null er"+String.valueOf(this.nativeAds == null));
        if (this.admobNativeAdLoader != null || this.nativeAds == null) {
            if (adInterface != null) {
                Log.e("folderListAdse","adload unkwon ad error1"+String.valueOf(nativeErrorCode));
                adInterface.AdsError(nativeErrorCode);
                return;
            }
            Log.e("folderListAdse","adload unkwon ad error2"+String.valueOf(nativeErrorCode));
            return;
        }
        Log.e("folderListAdse","adload unkwon ad error2a"+String.valueOf(nativeErrorCode));
        this.admobNativeAdLoader = new AdmobNativeAdLoader(nativeAds.mo17000b(), this.nativeAdLayout, this.f7955h, this.adOrientation, nativeErrorCode, this);
        this.admobNativeAdLoader.loadUnifiedNativeAds();
    }

    public void AdLogEvent() {
        if (adInterface != null) {
            adInterface.AdLogEvent();
        }
    }
}
