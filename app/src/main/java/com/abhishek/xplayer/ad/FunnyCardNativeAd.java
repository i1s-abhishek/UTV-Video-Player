package com.abhishek.xplayer.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.cc.promote.effects.C1451a;
import com.cc.promote.effects.C1452b;
import com.mopub.nativeads.NativeErrorCode;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import classesdef.ads.DisplayMatrix;
import classesdef.ads.C4781mq;
import classesdef.ads.C4782mr;
import classesdef.ads.AdInterface;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;


public class FunnyCardNativeAd implements AdInterface2, AdInterface {

    public static final int[] f8017a = {0, 1, 2};



    public static int f8018b = 1;
    public Context f8019c;


    private FunnyCardNativeAdLoader funnyCardNativeAdLoader;


    private FunnyCardNativeAdLoader.C2254a f8021e;



    public boolean f8022f;



    public WeakReference<Activity> f8023g;


    private int f8024h = 0;


    private long f8025i;


    private AppAbstractInterface<FunnyCardNativeAd> f8026j;

    public FunnyCardNativeAd(Context context) {
        this.f8019c = context;
        Point c = axw.displaySize(this.f8019c);
        this.f8024h = (int) (((float) Math.min(c.x, c.y)) * 0.8f);
        FunnyAdCoverImageView.f7923a = this.f8024h;
    }


    public boolean mo16905d() {
        return this.f8025i > 0;
    }


    public boolean mo16906e() {
        return m10369i() || (this.f8025i > 0 && System.currentTimeMillis() - this.f8025i > 1800000);
    }
    private boolean m10369i() {
        return this.f8025i == -1;
    }


    public void startLoadAd() {
        if (this.funnyCardNativeAdLoader == null) {
            this.funnyCardNativeAdLoader = new FunnyCardNativeAdLoader(this.f8019c, m10370j(), this);
        }
        this.funnyCardNativeAdLoader.mo16975a(this.f8019c);
    }


    public void mo16995a(Activity activity, FrameLayout frameLayout, boolean z) {
        View findViewById;
        ViewGroup.LayoutParams layoutParams;
        FunnyCardAd.createInstance().mo16928c(this);
        this.f8022f = z;
        this.f8023g = new WeakReference<>(activity);
        if (this.funnyCardNativeAdLoader == null) {
            this.funnyCardNativeAdLoader = new FunnyCardNativeAdLoader(this.f8019c, m10370j(), this);
        }
        this.funnyCardNativeAdLoader.mo16977a((FunnyCardNativeAdLoader.C2256c) new FunnyCardNativeAdLoader.C2256c() {

            public void mo16993a() {
                Activity activity;
                if (FunnyCardNativeAd.this.f8023g != null && (activity = (Activity) FunnyCardNativeAd.this.f8023g.get()) != null && !activity.isFinishing()) {
                    activity.finish();
                }
            }


            public void mo16994b() {
                Activity activity;
                if (FunnyCardNativeAd.this.f8023g != null && (activity = (Activity) FunnyCardNativeAd.this.f8023g.get()) != null && !activity.isFinishing()) {
                    activity.finish();
                }
            }
        });
        this.funnyCardNativeAdLoader.CardAdRequest(frameLayout);
        boolean z2 = frameLayout.getResources().getConfiguration().orientation != 2;
        View findViewById2 = frameLayout.findViewById(R.id.funny_ad_layout);
        if (!(findViewById2 == null || (layoutParams = findViewById2.getLayoutParams()) == null)) {
            layoutParams.width = this.f8024h;
        }
        if (z2 && (findViewById = frameLayout.findViewById(R.id.refresh_btn)) != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams2.gravity = 81;
            layoutParams2.bottomMargin = axw.m7444a(findViewById.getContext(), 56.0f);
            layoutParams2.rightMargin = 0;
        }
    }


    public boolean destroyad() {
        FunnyCardAd.createInstance().mo16929d(this);
        if (this.funnyCardNativeAdLoader != null) {
            this.funnyCardNativeAdLoader.destroyCardAd();
            this.funnyCardNativeAdLoader = null;
            return true;
        }
        this.f8026j = null;
        this.f8025i = -1;
        return false;
    }


    private FunnyCardNativeAdLoader.C2254a m10370j() {
        if (this.f8021e == null) {
            this.f8021e = new FunnyCardNativeAdLoader.C2254a() {

                public int mo16990a() {
                    return 60000;
                }


                public List<C1452b> mo16991b() {
                    int unused = FunnyCardNativeAd.f8018b = (byte) ((FunnyCardNativeAd.f8018b + 1) % FunnyCardNativeAd.f8017a.length);
                    if (FunnyCardNativeAd.this.f8022f && FunnyCardNativeAd.f8018b == 0) {
                        int unused2 = FunnyCardNativeAd.f8018b = (byte) ((FunnyCardNativeAd.f8018b + 1) % FunnyCardNativeAd.f8017a.length);
                    }
                    switch (FunnyCardNativeAd.f8018b) {
                        case 1:
                            ArrayList arrayList = new ArrayList();
                            if (arrayList.isEmpty()) {
                                Paint paint = new Paint(1);
                                Rect rect = new Rect(0, 0, DisplayMatrix.getDisplayWidth(FunnyCardNativeAd.this.f8019c), DisplayMatrix.getDisplayHeikht(FunnyCardNativeAd.this.f8019c));
                                C1451a aVar = new C1451a(FunnyCardNativeAd.this.f8019c, new int[]{R.mipmap.anim_pepshi_1/*, R.drawable.ip, R.drawable.iq, R.drawable.ir, R.drawable.is, R.drawable.it, R.drawable.iu, R.drawable.iv, R.drawable.iw, R.drawable.ix, R.drawable.iy, R.drawable.iz*/});
                                C1452b bVar = new C1452b(new C4782mr(FunnyCardNativeAd.this.f8019c, aVar), rect, paint);
                                bVar.setRepeatCount(-1);
                                bVar.setRepeatMode(1);
                                arrayList.add(bVar);
                                C1452b bVar2 = new C1452b(new C4781mq(FunnyCardNativeAd.this.f8019c, aVar), rect, paint);
                                bVar2.setRepeatCount(-1);
                                bVar2.setRepeatMode(1);
                                arrayList.add(bVar2);
                            }
                            return arrayList;
                        case 2:
                            ArrayList arrayList2 = new ArrayList();
                            if (arrayList2.isEmpty()) {
                                Paint paint2 = new Paint(1);
                                C1452b bVar3 = new C1452b(new C2269w(FunnyCardNativeAd.this.f8019c, new C1451a(FunnyCardNativeAd.this.f8019c, new int[]{R.mipmap.anim_bubble_one, R.mipmap.anim_bubble_2, R.mipmap.anim_bubble_3})), new Rect(0, 0, DisplayMatrix.getDisplayWidth(FunnyCardNativeAd.this.f8019c), DisplayMatrix.getDisplayHeikht(FunnyCardNativeAd.this.f8019c)), paint2);
                                bVar3.setRepeatCount(-1);
                                bVar3.setRepeatMode(1);
                                arrayList2.add(bVar3);
                            }
                            return arrayList2;
                        default:
                            return null;
                    }
                }
            };
        }
        return this.f8021e;
    }


    public Bitmap mo16997c() {
        if (funnyCardNativeAdLoader != null) {
            return funnyCardNativeAdLoader.mo16980c();
        }
        return null;
    }

    public void mo16996a(AppAbstractInterface<FunnyCardNativeAd> qVar) {
        this.f8026j = qVar;
    }


    public void AdLayout(View view) {
        this.f8025i = System.currentTimeMillis();
        AppAbstractInterface<FunnyCardNativeAd> qVar = this.f8026j;
        if (qVar != null) {
            qVar.mo16863b(this);
        }
    }


    public void AdsError(NativeErrorCode nativeErrorCode) {
        FunnyCardNativeAdLoader nVar;
        this.f8025i = -1;
        WeakReference<Activity> weakReference = this.f8023g;
        if (weakReference != null && weakReference.get() != null && (nVar = this.funnyCardNativeAdLoader) != null) {
            nVar.loadCustumNativeAd(this.f8019c);
        }
    }


    public void AdLogEvent() {
        LogEvents.m18486a("Ad", "Click", "Mopub");
    }
}
