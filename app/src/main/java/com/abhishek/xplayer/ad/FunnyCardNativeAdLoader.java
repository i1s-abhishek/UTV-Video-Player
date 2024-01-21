package com.abhishek.xplayer.ad;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import com.cc.promote.effects.C1452b;
import com.cc.promote.effects.C1454d;
import com.cc.promote.effects.ParticlesView;
import com.mopub.common.util.Views;
import com.mopub.nativeads.NativeErrorCode;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import classesdef.ads.DisplayMatrix;
import classesdef.ads.C4781mq;
import classesdef.ads.C4782mr;
import classesdef.ads.AdInterface;
import classesdef.ads.C4811nk;
import classesdef.xdplayer.ServerConfigSharedPrefrence;
import hdplayer.xdplayer.videoplayer.R;


public class FunnyCardNativeAdLoader implements AdInterface {

    public final C2255b f8000a = new C2255b(this);
    public ParticlesView particlesView;


    private Context context;


    private View view;


    private NativeAds nativeAds;


    public View view2;



    public WeakReference<ViewGroup> weakReference;


    private C2254a f8007h;



    public C2256c f8008i;


    private AdInterface adInterface;


    private SelfCustumFunnyServerAds selfCustumFunnyServerAds;


    private SelfCustumFunnyServerAds.nativeAdInterface nativeAdInterface;

    public interface C2254a {

        int mo16990a();

        List<C1452b> mo16991b();
    }

    public interface C2256c {
        void mo16993a();
        void mo16994b();
    }

    public FunnyCardNativeAdLoader(Context context, C2254a aVar, AdInterface ncVar) {
        this.context = context;
        this.f8007h = aVar;
        this.adInterface = ncVar;
    }

    public void mo16977a(C2256c cVar) {
        this.f8008i = cVar;
    }


    public void CardAdRequestTimeOut() {
        Log.d("FunnyAd", "Card ad request time out.");
        if (this.f8008i != null) {
            this.f8008i.mo16993a();
        }
        destroyCardAd();
    }

    public void CardAdRequest(FrameLayout frameLayout) {
        View view = this.view;
        if (view == null || view.getParent() == null) {
            this.view = LayoutInflater.from(this.context).inflate(R.layout.funny_ad, (ViewGroup) null, false);
            frameLayout.addView(this.view, C4811nk.m23796a(this.context, -1, -1.0f));
            m10336e();
            Log.d("FunnyAd", "Start card ad request.");
            mo16975a(this.context);
            this.f8000a.sendEmptyMessageDelayed(1, (long) this.f8007h.mo16990a());
            m10330a((ViewGroup) this.view.findViewById(R.id.native_ad_layout));
        }
    }

    private void m10336e() {
        this.particlesView = (ParticlesView) this.view.findViewById(R.id.effects_view);
        new Thread(new Runnable() {
            public void run() {
                FunnyCardNativeAdLoader.this.particlesView.mo11383a((List<C1452b>) FunnyCardNativeAdLoader.this.m10339f());
                FunnyCardNativeAdLoader.this.f8000a.sendEmptyMessage(2);
            }
        }).start();
    }


    public List<C1452b> m10339f() {
        List<C1452b> b = this.f8007h.mo16991b();
        if (b == null) {
            b = new ArrayList<>();
        }
        if (b.isEmpty()) {
            Paint paint = new Paint(1);
            Rect rect = new Rect(0, 0, DisplayMatrix.getDisplayWidth(this.context), DisplayMatrix.getDisplayHeikht(this.context));
            C1454d dVar = new C1454d(this.context);
            C1452b bVar = new C1452b(new C4782mr(this.context, dVar), rect, paint);
            bVar.setRepeatCount(-1);
            bVar.setRepeatMode(1);
            b.add(bVar);
            C1452b bVar2 = new C1452b(new C4781mq(this.context, dVar), rect, paint);
            bVar2.setRepeatCount(-1);
            bVar2.setRepeatMode(1);
            b.add(bVar2);
        }
        return b;
    }

    public void destroyCardAd() {
        Log.d("FunnyAd", "destroy card ad.");
        m10344i();
        View view = this.view;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.view);
            }
            this.particlesView.mo11384b();
            this.view = null;
        }
        this.f8008i = null;
        this.adInterface = null;
        ParticlesView particlesView = this.particlesView;
        if (particlesView != null) {
            particlesView.mo11384b();
            this.particlesView = null;
        }
    }

    public synchronized void mo16975aa(Context r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.inshot.xplayer.ad.e r0 = r4.nativeAds     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x002d
            if (r5 != 0) goto L_0x0008
            goto L_0x002d
        L_0x0008:
            com.inshot.xplayer.ad.e r0 = new com.inshot.xplayer.ad.e     // Catch:{ all -> 0x002f }
            java.lang.String r1 = "cea1bbd7dbec405b8c40451e5f7dd17c"
            r2 = 1
            r3 = 2131492911(0x7f0c002f, float:1.8609287E38)
            r0.<init>(r1, r2, r3)     // Catch:{ all -> 0x002f }
            r4.nativeAds = r0     // Catch:{ all -> 0x002f }
            android.view.View r0 = r4.view2     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0021
            android.view.View r0 = r4.view2     // Catch:{ all -> 0x002f }
            com.mopub.common.util.Views.removeFromParent(r0)     // Catch:{ all -> 0x002f }
            r0 = 0
            r4.view2 = r0     // Catch:{ all -> 0x002f }
        L_0x0021:
            com.inshot.xplayer.ad.e r0 = r4.nativeAds     // Catch:{ all -> 0x002f }
            r0.mo16932a((p000.C4802nc) r4)     // Catch:{ all -> 0x002f }
            com.inshot.xplayer.ad.e r0 = r4.nativeAds     // Catch:{ all -> 0x002f }
            r0.mo16931a((android.content.Context) r5)     // Catch:{ all -> 0x002f }
            monitor-exit(r4)
            return
        L_0x002d:
            monitor-exit(r4)
            return
        L_0x002f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.p005ad.C2249n.mo16975a(android.content.Context):void");
    }
    public synchronized void mo16975a(Context context) {
        if (this.nativeAds == null) {
            Log.d("FunnyAd1", "Start card ad request.");
            if (context != null) {
                Log.d("FunnyAd2", "Start card ad request.");
                this.nativeAds = new NativeAds("e82c03963fc6493fa49cbef163c2a8e3", true, R.layout.custom_native_ad_layout);
                if (this.view2 != null) {
                    Views.removeFromParent(this.view2);
                    this.view2 = null;
                }
                this.nativeAds.setAdInterface(this);
                this.nativeAds.mo16931a(context);
            }
       }
    }

    /* renamed from: c */
    public Bitmap mo16980c() {
        NativeAds eVar = this.nativeAds;
        if (eVar == null || !eVar.mo16934b()) {
            return null;
        }
        return this.nativeAds.mo16935c();
    }


    public boolean m10330a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        this.weakReference = new WeakReference<>(viewGroup);
        if (this.view2 == null) {
            return false;
        }
        Log.d("FunnyAd", "Show card ad.");
        this.f8000a.removeMessages(1);
        ViewGroup viewGroup2 = (ViewGroup) this.view2.getParent();
        if (viewGroup2 != null) {
            if (viewGroup2 == viewGroup) {
                return false;
            }
            viewGroup2.removeAllViews();
        }
        viewGroup.removeAllViews();
        viewGroup.addView(this.view2);
        if (!viewGroup.isShown()) {
            viewGroup.setVisibility(0);
        }
        this.view.findViewById(R.id.admob_native_title).setVisibility(0);
        this.view2.setVisibility(0);
        ImageView imageView = (ImageView) this.view2.findViewById(R.id.admob_native_cover);
        if (imageView != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(50);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            imageView.startAnimation(scaleAnimation);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        View view = (View) viewGroup.getParent();
        int[] iArr = new int[2];
        viewGroup.getLocationInWindow(iArr);
        animatorSet.play(ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f})).with(ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (-(view.getMeasuredHeight() + iArr[1])), 0.0f}));
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                FunnyCardNativeAdLoader.this.m10341g();
                FunnyCardNativeAdLoader.this.m10342h();
            }
        });
        return true;
    }


    public void m10341g() {
        View view;
        ImageView imageView;
        if (this.view != null && (view = this.view2) != null && (imageView = (ImageView) view.findViewById(R.id.admob_native_cover)) != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(2500);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            imageView.startAnimation(scaleAnimation);
        }
    }


    public void m10342h() {
        View findViewById;
        View view = this.view;
        if (view != null && (findViewById = view.findViewById(R.id.refresh_btn)) != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (FunnyCardNativeAdLoader.this.f8008i != null) {
                        FunnyCardNativeAdLoader.this.f8008i.mo16994b();
                    }
                }
            });
            findViewById.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(findViewById, "scaleX", new float[]{0.1f, 0.75f, 1.0f}), ObjectAnimator.ofFloat(findViewById, "scaleY", new float[]{0.1f, 0.75f, 1.0f}), ObjectAnimator.ofFloat(findViewById, "alpha", new float[]{0.0f, 1.0f, 1.0f})});
            animatorSet.setDuration(200);
            animatorSet.start();
        }
    }

    private void m10344i() {
        ViewGroup viewGroup;
        WeakReference<ViewGroup> weakReference = this.weakReference;
        if (!(weakReference == null || (viewGroup = (ViewGroup) weakReference.get()) == null)) {
            viewGroup.setVisibility(8);
        }
        NativeAds eVar = this.nativeAds;
        if (eVar != null) {
            eVar.mo16936d();
            this.nativeAds = null;
        }
    }

    public void m10346j() {
        ParticlesView particlesView = this.particlesView;
        if (particlesView != null) {
            particlesView.mo11382a();
        }
    }

    public void AdLayout(View view) {
        ViewGroup viewGroup;
        this.view2 = view;
        WeakReference<ViewGroup> weakReference = this.weakReference;
        if (!(weakReference == null || (viewGroup = (ViewGroup) weakReference.get()) == null)) {
            m10330a(viewGroup);
        }
        AdInterface ncVar = this.adInterface;
        if (ncVar != null) {
            ncVar.AdLayout(view);
        }
    }

    public void AdsError(NativeErrorCode nativeErrorCode) {
        AdInterface ncVar = this.adInterface;
        if (ncVar != null) {
            ncVar.AdsError(nativeErrorCode);
        }
    }


    public void loadCustumNativeAd(Context context) {
        if (this.view != null) {
            SelfCustumFunnyServerAds xVar = this.selfCustumFunnyServerAds;
            if (xVar != null) {
                xVar.mo17020a();
            } else {
                this.selfCustumFunnyServerAds = new SelfCustumFunnyServerAds();
            }
            String j = ServerConfigSharedPrefrence.GetSelfAds(context);
            if (!j.equals("")) {
                if (this.nativeAdInterface == null) {
                    this.nativeAdInterface = new SelfCustumFunnyServerAds.nativeAdInterface() {

                        public void exception() {
                        }


                        public void showView(View view) {
                            ViewGroup viewGroup;
                            if (FunnyCardNativeAdLoader.this.weakReference != null && (viewGroup = (ViewGroup) FunnyCardNativeAdLoader.this.weakReference.get()) != null) {
                                View unused = FunnyCardNativeAdLoader.this.view2 = view;
                                boolean unused2 = FunnyCardNativeAdLoader.this.m10330a(viewGroup);
                            }
                        }

                        public void nativeAdLogEvent() {
                            FunnyCardNativeAdLoader.this.AdLogEvent();
                        }
                    };
                }
                this.selfCustumFunnyServerAds.showData(context, j, R.layout.custom_native_ad_layout, this.nativeAdInterface);
            }
        }
    }


    public void AdLogEvent() {
        AdInterface ncVar = this.adInterface;
        if (ncVar != null) {
            ncVar.AdLogEvent();
        }
    }

    private static class C2255b extends Handler {


        WeakReference<FunnyCardNativeAdLoader> f8016a;

        public C2255b(FunnyCardNativeAdLoader nVar) {
            this.f8016a = new WeakReference<>(nVar);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            FunnyCardNativeAdLoader nVar = (FunnyCardNativeAdLoader) this.f8016a.get();
            if (nVar != null) {
                switch (message.what) {
                    case 1:
                        nVar.CardAdRequestTimeOut();
                        break;
                    case 2:
                        break;
                    default:
                        return;
                }
                nVar.m10346j();
            }
        }
    }
}
