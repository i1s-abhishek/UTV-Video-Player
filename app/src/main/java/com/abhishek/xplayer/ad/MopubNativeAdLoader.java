package com.abhishek.xplayer.ad;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mopub.common.util.Views;
import com.mopub.mobileads.GooglePlayServicesBanner;
import com.mopub.nativeads.GooglePlayServicesAdRenderer;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.RequestParameters;
import com.mopub.nativeads.ViewBinder;

import java.util.EnumSet;
import java.util.Map;

import classesdef.ads.DisplayMatrix;
import classesdef.ads.C4796mz;
import classesdef.ads.C4798na;
import classesdef.ads.C4799nb;
import classesdef.ads.AdInterface;
import hdplayer.xdplayer.videoplayer.R;



public class MopubNativeAdLoader implements MoPubNative.MoPubNativeNetworkListener, com.mopub.nativeads.NativeAd.MoPubNativeEventListener {


    public int admobLayout = R.layout.native_admob_banner;


    public int facebookLayout = this.admobLayout;


    public int f8031c = -1;


    private int f8032d = -1;


    private int displayDensity = -1;


    private boolean f8034f = false;


    private String nativeAdUnit = null;


    private Context context;


    private C4796mz f8037i;


    private MoPubNative moPubNative;

    private com.mopub.nativeads.NativeAd nativeAd;


    private ViewGroup viewGroup;


    private AdInterface adInterface;


    private Map<String, Object> map;

    public void onImpression(View view) {
    }

    public MopubNativeAdLoader(Context context, String str, Map<String, Object> map, AdInterface ncVar) {
        Log.e("folderListAds","adload unkwon3");
        this.nativeAdUnit = str;
        this.context = context;
        this.adInterface = ncVar;
        this.displayDensity = DisplayMatrix.getdisplayDensity(context, 50.0f);
        this.map = map;
        checkLocalExtras(map);
    }

    public void onNativeLoad(com.mopub.nativeads.NativeAd nativeAd) {
        Log.e("folderListAds","nativeAd loaded");
        nativeAd.setMoPubNativeEventListener(this);
        this.nativeAd = nativeAd;
        View c = loadMopubNativeView();
        if (adInterface == null) {
            return;
        }
        if (c != null) {
            if (this.nativeAdUnit != null) {
                C4799nb.m23760a().mo26065a(this.nativeAdUnit, C4798na.MOPUB_NATIVE);
            }
            this.adInterface.AdLayout((View) this.viewGroup);
            return;
        }
        adInterface.AdsError(NativeErrorCode.UNSPECIFIED);
    }

    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        Log.e("folderListAds","adload nativeErrorCode "+String.valueOf(nativeErrorCode.getIntCode())+String.valueOf(nativeErrorCode));

        AdInterface ncVar = this.adInterface;
        if (ncVar != null) {
            ncVar.AdsError(nativeErrorCode);
        }
    }


    public void loadNativeAdd(String str) {
        Log.e("folderListAds","adload unkwon4");
        EnumSet enumSet;
        ViewBinder viewBinder;
        this.moPubNative = new MoPubNative(this.context, str, this);
        if (this.f8034f) {
            Log.e("folderListAds","nativeAd load1");
            Log.e("folderListAds","nativeAd load1 ti"+String.valueOf(RequestParameters.NativeAdAsset.TITLE));
            enumSet = EnumSet.of(RequestParameters.NativeAdAsset.TITLE, RequestParameters.NativeAdAsset.TEXT, RequestParameters.NativeAdAsset.MAIN_IMAGE, RequestParameters.NativeAdAsset.ICON_IMAGE, RequestParameters.NativeAdAsset.CALL_TO_ACTION_TEXT);
            viewBinder = new ViewBinder.Builder(this.admobLayout)
                    .titleId(R.id.admob_native_title)
                    .textId(R.id.admob_native_desc)
                    .mainImageId(R.id.admob_native_cover)
                    .callToActionId(R.id.admob_native_btn)
                    .iconImageId(R.id.admob_native_icon)
                    .privacyInformationIconImageId(R.id.admob_native_mopub_privacy_icon)
                    .build();
        } else {
            Log.e("folderListAds","nativeAd load2 ti"+String.valueOf(RequestParameters.NativeAdAsset.TITLE));
            enumSet = EnumSet.of(RequestParameters.NativeAdAsset.TITLE, RequestParameters.NativeAdAsset.TEXT, RequestParameters.NativeAdAsset.ICON_IMAGE, RequestParameters.NativeAdAsset.CALL_TO_ACTION_TEXT);
            viewBinder = new ViewBinder.Builder(this.admobLayout)
                    .titleId(R.id.admob_native_title)
                    .textId(R.id.admob_native_desc)
                    .callToActionId(R.id.admob_native_btn)
                    .iconImageId(R.id.admob_native_icon)
                    .privacyInformationIconImageId(R.id.admob_native_mopub_privacy_icon)
                    .build();
        }
        this.moPubNative.registerAdRenderer(new MoPubStaticNativeAdRenderer(viewBinder));
        this.moPubNative.registerAdRenderer(new GooglePlayServicesAdRenderer(viewBinder));
        this.moPubNative.setLocalExtras(this.map);
        this.moPubNative.makeRequest(new RequestParameters.Builder().desiredAssets(enumSet).build());
    }
    private void checkLocalExtras(Map<String, Object> map) {
        if (map != null) {
            if (map.containsKey("LayoutId")) {
                this.admobLayout = ((Integer) map.get("LayoutId")).intValue();
            }
            if (map.containsKey("facebookLayoutId")) {
                this.facebookLayout = ((Integer) map.get("facebookLayoutId")).intValue();
            }
            if (map.containsKey(GooglePlayServicesBanner.AD_WIDTH_KEY)) {
                this.f8032d = ((Integer) map.get(GooglePlayServicesBanner.AD_WIDTH_KEY)).intValue();
            }
            if (map.containsKey(GooglePlayServicesBanner.AD_HEIGHT_KEY)) {
                this.displayDensity = ((Integer) map.get(GooglePlayServicesBanner.AD_HEIGHT_KEY)).intValue();
            }
            if (map.containsKey("adChoicePosition")) {
                this.f8031c = ((Integer) map.get("adChoicePosition")).intValue();
            }
            if (map.containsKey("adLoadCover")) {
                this.f8034f = ((Boolean) map.get("adLoadCover")).booleanValue();
            }
            if (map.containsKey("adMopubId")) {
                this.nativeAdUnit = (String) map.get("adMopubId");
            }
            if (map.containsKey("coverSizeListener")) {
                this.f8037i = (C4796mz) map.get("coverSizeListener");
            }
        }
    }


    private View loadMopubNativeView() {
        ImageView imageView;
        try {
            this.viewGroup = new FrameLayout(this.context);
            View createAdView = this.nativeAd.createAdView(this.context, (ViewGroup) null);
            this.viewGroup.addView(createAdView, new FrameLayout.LayoutParams(-1, this.displayDensity));
            if (!(!this.f8034f || (imageView = (ImageView) createAdView.findViewById(R.id.admob_native_cover)) == null || this.f8037i == null)) {
                this.f8037i.mo26064a(imageView, -1, -1);
            }
            this.nativeAd.prepare(createAdView);
            this.nativeAd.renderAdView(createAdView);
            return this.viewGroup;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void onInvalidate() {
        Log.e("folderListAds","adload 4");
        Views.removeFromParent(this.viewGroup);
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        MoPubNative moPubNative = this.moPubNative;
        if (moPubNative != null) {
            moPubNative.destroy();
        }
    }

    public void onClick(View view) {
        AdInterface ncVar = this.adInterface;
        if (ncVar != null) {
            ncVar.AdLogEvent();
        }
    }


    public Context mo17000b() {
        return this.context;
    }
}
