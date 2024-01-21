package com.abhishek.xplayer.ad;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.mopub.common.privacy.ConsentStatus;
import com.mopub.nativeads.NativeErrorCode;

import classesdef.ads.AdInterface;
import classesdef.xdplayer.ServerConfigSharedPrefrence;
import hdplayer.xdplayer.videoplayer.R;



class AdmobNativeAdLoader {
    public final NativeErrorCode nativeErrorCode;
    public final AdInterface adInterface;

    private final int layout;


    private final int f7968d;


    private final boolean adOrientation;



    public Context context;



    public UnifiedNativeAd unifiedNativeAd;

    public AdmobNativeAdLoader(Context context, int layout, int i2, boolean z, NativeErrorCode nativeErrorCode, AdInterface ncVar) {
        Log.e("folderListAds","adload unkwon admob load1");
        this.context = context;
        this.nativeErrorCode = nativeErrorCode;
        this.adInterface = ncVar;
        this.layout = layout;
        this.adOrientation = z;
        this.f7968d = i2;
    }



    public void loadUnifiedNativeAds() {
        Log.e("folderListAds","adload unkwon admob load1"+String.valueOf("x"));
        UnifiedAdListener unifiedAdListener = new UnifiedAdListener();
        AdLoader build = new AdLoader.Builder(this.context, "ca-app-pub-8178279133979191/9385435541")
                .forUnifiedNativeAd(unifiedAdListener)
                .withAdListener(unifiedAdListener)
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        .setReturnUrlsForImageAssets(false)
                        .setRequestMultipleImages(false)
                        .setAdChoicesPlacement(this.f7968d)
                        .setMediaAspectRatio(this.adOrientation ? 2 : 1).build())
                .build();

        AdRequest.Builder builder = new AdRequest.Builder();
        if (ServerConfigSharedPrefrence.m19736o(this.context) == ConsentStatus.EXPLICIT_NO) {
            Bundle bundle = new Bundle();
            bundle.putString("npa", "1");
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        build.loadAd(builder.addTestDevice("111111EAC93034622A3902158A1E4E6D8B6F20").build());
    }

    public void unifiedNativeAdDestroy() {
        if (unifiedNativeAd != null) {
            unifiedNativeAd.destroy();
        }
        this.unifiedNativeAd = null;
        this.context = null;
    }

    public void nativeAdError() {
        Log.e("folderListAds","adload unkwon admob load1"+String.valueOf(nativeErrorCode));
        if (adInterface != null) {
            adInterface.AdsError(this.nativeErrorCode);
        }
        unifiedNativeAdDestroy();
    }


    public View loadAdmobNativeAdView() {
        if (this.unifiedNativeAd == null) {
            return null;
        }
        UnifiedNativeAdView unifiedNativeAdView = new UnifiedNativeAdView(this.context);
        try {
            View inflate = LayoutInflater.from(this.context.getApplicationContext()).inflate(this.layout, unifiedNativeAdView, false);
            if (inflate == null) {
                return null;
            }
            TextView textView = (TextView) inflate.findViewById(R.id.admob_native_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.admob_native_desc);
            View findViewById = inflate.findViewById(R.id.admob_native_btn);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.admob_native_icon);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.admob_native_cover);
            ImageView imageView3 = (ImageView) inflate.findViewById(R.id.admob_native_ad_sign);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.ad_cover_container);
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            if (textView != null) {
                textView.setText(this.unifiedNativeAd.getHeadline());
            }
            if (textView2 != null) {
                textView2.setText(this.unifiedNativeAd.getBody());
            }
            if (findViewById instanceof TextView) {
                ((TextView) findViewById).setText(this.unifiedNativeAd.getCallToAction());
            }
            try {
                if (this.adOrientation) {
                    if (frameLayout == null) {
                        return null;
                    }
                    MediaView mediaView = new MediaView(this.context);
                    mediaView.setVisibility(0);
                    frameLayout.addView(mediaView, new FrameLayout.LayoutParams(-1, -2, 17));
                    mediaView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
                        public void onChildViewRemoved(View view, View view2) {
                        }

                        public void onChildViewAdded(View view, View view2) {
                            if (view2 instanceof ImageView) {
                                ((ImageView) view2).setAdjustViewBounds(true);
                            }
                        }
                    });
                    unifiedNativeAdView.setMediaView(mediaView);
                }
                if (imageView2 != null && imageView2.getVisibility() == 0) {
                    imageView2.setVisibility(8);
                }
                if (textView != null) {
                    unifiedNativeAdView.setHeadlineView(textView);
                }
                if (textView2 != null) {
                    unifiedNativeAdView.setBodyView(textView2);
                }
                if (imageView != null) {
                    unifiedNativeAdView.setIconView(imageView);
                    NativeAd.Image icon = this.unifiedNativeAd.getIcon();
                    if (icon == null || icon.getDrawable() == null) {
                        imageView.setVisibility(8);
                    } else {
                        imageView.setImageDrawable(icon.getDrawable());
                    }
                }
                unifiedNativeAdView.setCallToActionView(inflate);
                unifiedNativeAdView.setNativeAd(this.unifiedNativeAd);
                unifiedNativeAdView.addView(inflate, new FrameLayout.LayoutParams(-1, -2));
                return unifiedNativeAdView;
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private class UnifiedAdListener extends AdListener implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        public void onAdLoaded() {
        }

        private UnifiedAdListener() {
        }

        public void onAdFailedToLoad(int i) {
            if (AdmobNativeAdLoader.this.adInterface != null) {
                AdmobNativeAdLoader.this.adInterface.AdsError(AdmobNativeAdLoader.this.nativeErrorCode);
            }
        }

        public void onAdClicked() {
            if (AdmobNativeAdLoader.this.adInterface != null) {
                AdmobNativeAdLoader.this.adInterface.AdLogEvent();
            }
        }

        public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            if (AdmobNativeAdLoader.this.context != null) {
                UnifiedNativeAd unused = AdmobNativeAdLoader.this.unifiedNativeAd = unifiedNativeAd;
                View d =loadAdmobNativeAdView();
                if (d == null) {
                    AdmobNativeAdLoader.this.nativeAdError();
                } else if (AdmobNativeAdLoader.this.adInterface != null) {
                    AdmobNativeAdLoader.this.adInterface.AdLayout(d);
                }
            }
        }
    }
}
