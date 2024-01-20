package com.abhishek.xplayer.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.abhishek.xplayer.ad.MopubIntertitialAd;
import com.abhishek.xplayer.ad.AppAbstractInterface;
import com.abhishek.xplayer.ad.PauseNativeAdLoader;
import com.abhishek.xplayer.ad.PauseNativeAd;

import com.abhishek.inplayer.bean.VideoPlayListBean;
import com.abhishek.inplayer.widget.C2483g;
import com.abhishek.xplayer.application.BaseActivity;
import com.abhishek.xplayer.application.InitilizationActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.RecentMediaStorage;
import com.abhishek.xplayer.service.C2779a;
import com.abhishek.xplayer.service.C2787b;
import com.abhishek.xplayer.service.StartPipPlayService;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import classesdef.ads.atd;
import classesdef.eventbus.awk;
import classesdef.inplayer.awt;
import classesdef.inplayer.axc;
import classesdef.inplayer.SharedPrefrence;
import classesdef.player.avs;
import classesdef.player.axg;
import classesdef.player.DefaultSharedPreferences;
import classesdef.player.axt;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;
import tv.danmaku.ijk.media.player.IMediaPlayer;

import static com.abhishek.xplayer.ad.MopubInterstitialAdLoader.Initilize;

public class PlayerActivity extends BaseActivity implements AppAbstractInterface<PauseNativeAdLoader> {
    /* access modifiers changed from: private */
    public boolean f7878k;

    /* renamed from: a */
    public C2483g f10258a;
    /* renamed from: b */
    private boolean f10259b;

    /* renamed from: c */
    private final boolean f10260c = false;

    /* renamed from: d */
    private String f10261d = null;

    /* renamed from: e */
    private boolean f10262e = false;

    /* renamed from: f */
    private Bundle f10263f;

    /* renamed from: g */
    private Runnable f10264g = new Runnable() {
        public void run() {
            MopubIntertitialAd.createInstance1().mo16926b();
        }
    };

    /* renamed from: h */
    private boolean f10265h;

    /* renamed from: i */
    private BroadcastReceiver f10266i = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            PlayerActivity.this.finish();
        }
    };

    /* renamed from: j */
    private int f10267j = 0;

    /* renamed from: k */
    private long f10268k = -1;

    /* renamed from: l */
    private boolean f10269l = false;

    /* renamed from: m */
    private PauseNativeAdLoader f10270m;

    /* renamed from: n */
    private ViewGroup f10271n;
    private void m10115u() {
    }

    /* renamed from: v */
    private void m10116v() {
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(Build.VERSION.SDK_INT < 21);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f10258a != null) {
            this.f10258a.mo17558a(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DefaultSharedPreferences.m7385a("qaU9l5Yt", false);
        StartPipPlayService.m12716a().mo18174d();
        this.f10263f = bundle;
        setContentView((int) R.layout.simple_player_view_player);
        if (C2552a.m11684a((Activity) this, 110)) {
            m11653e();
        }
    }



    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02bd, code lost:
        if (p000.axe.m7319a(r0, false) == false) goto L_0x02c1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0112  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11653ee() {
        /*
            r32 = this;
            r15 = r32
            boolean r0 = r15.f10262e
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r14 = 1
            r15.f10262e = r14
            com.inshot.xplayer.application.C2616a.m12046a((android.app.Activity) r32)
            r15.mo17679a((boolean) r14)
            r0 = 10
            android.content.Intent r1 = r32.getIntent()
            r2 = 0
            if (r1 == 0) goto L_0x0027
            android.content.Intent r1 = r32.getIntent()
            java.lang.String r3 = "backgroundMode"
            boolean r1 = r1.getBooleanExtra(r3, r2)
            if (r1 == 0) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            if (r1 == 0) goto L_0x012a
            com.inshot.xplayer.service.a r0 = com.inshot.xplayer.service.C2779a.m12613a()
            java.lang.String r0 = r0.mo18139e()
            com.inshot.xplayer.service.a r5 = com.inshot.xplayer.service.C2779a.m12613a()
            java.lang.String r5 = r5.mo18138d()
            com.inshot.xplayer.service.a r6 = com.inshot.xplayer.service.C2779a.m12613a()
            java.util.ArrayList r6 = r6.mo18150p()
            com.inshot.xplayer.service.a r7 = com.inshot.xplayer.service.C2779a.m12613a()
            java.lang.String r7 = r7.mo18151q()
            android.content.Intent r8 = r32.getIntent()
            if (r8 == 0) goto L_0x005e
            android.content.Intent r8 = r32.getIntent()
            java.lang.String r9 = "private"
            boolean r8 = r8.getBooleanExtra(r9, r2)
            if (r8 == 0) goto L_0x005e
            r8 = 1
            goto L_0x005f
        L_0x005e:
            r8 = 0
        L_0x005f:
            if (r6 == 0) goto L_0x00b8
            r15.m11651a((java.util.ArrayList<com.inshot.inplayer.bean.VideoPlayListBean>) r6)
            boolean r9 = r6.isEmpty()
            if (r9 == 0) goto L_0x0085
            com.inshot.xplayer.service.a r0 = com.inshot.xplayer.service.C2779a.m12613a()
            boolean r0 = r0.mo18135b()
            if (r0 == 0) goto L_0x007b
            com.inshot.xplayer.service.a r0 = com.inshot.xplayer.service.C2779a.m12613a()
            r0.mo18136b((android.content.Context) r15, (boolean) r14)
        L_0x007b:
            r0 = 2131624014(0x7f0e004e, float:1.8875196E38)
            p000.axv.m7434a((int) r0)
            r32.finish()
            return
        L_0x0085:
            java.util.Iterator r9 = r6.iterator()
            r10 = 0
        L_0x008a:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00a2
            java.lang.Object r11 = r9.next()
            com.inshot.inplayer.bean.VideoPlayListBean r11 = (com.inshot.inplayer.bean.VideoPlayListBean) r11
            java.lang.String r11 = r11.f9813a
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x009f
            goto L_0x00a2
        L_0x009f:
            int r10 = r10 + 1
            goto L_0x008a
        L_0x00a2:
            int r9 = r6.size()
            if (r10 != r9) goto L_0x00b9
            java.lang.Object r0 = r6.get(r2)
            com.inshot.inplayer.bean.VideoPlayListBean r0 = (com.inshot.inplayer.bean.VideoPlayListBean) r0
            java.lang.String r0 = r0.f9813a
            java.lang.Object r5 = r6.get(r2)
            com.inshot.inplayer.bean.VideoPlayListBean r5 = (com.inshot.inplayer.bean.VideoPlayListBean) r5
            java.lang.String r5 = r5.f9815c
        L_0x00b8:
            r10 = 0
        L_0x00b9:
            com.inshot.xplayer.service.a r9 = com.inshot.xplayer.service.C2779a.m12613a()
            avg r9 = r9.mo18137c()
            if (r9 == 0) goto L_0x00ca
            long r11 = r9.mo10720j()
            int r9 = (int) r11
            r11 = 1
            goto L_0x00cc
        L_0x00ca:
            r9 = 0
            r11 = 0
        L_0x00cc:
            com.inshot.xplayer.service.a r12 = com.inshot.xplayer.service.C2779a.m12613a()
            boolean r12 = r12.mo18140f()
            com.inshot.xplayer.service.a r13 = com.inshot.xplayer.service.C2779a.m12613a()
            boolean r13 = r13.mo18141g()
            com.inshot.xplayer.service.a r4 = com.inshot.xplayer.service.C2779a.m12613a()
            int r4 = r4.mo18142h()
            com.inshot.xplayer.service.a r3 = com.inshot.xplayer.service.C2779a.m12613a()
            int r3 = r3.mo18143i()
            com.inshot.xplayer.service.a r14 = com.inshot.xplayer.service.C2779a.m12613a()
            com.inshot.inplayer.bean.VideoPlayListBean r14 = r14.mo18144j()
            if (r14 == 0) goto L_0x00fd
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r2 = r14.f9818f
            int r14 = r14.f9819g
            r23 = r0
            goto L_0x0101
        L_0x00fd:
            r23 = r0
            r2 = 0
            r14 = -1
        L_0x0101:
            android.content.Intent r0 = r32.getIntent()
            r24 = r2
            java.lang.String r2 = "fromNotification"
            r25 = r3
            r3 = 0
            boolean r0 = r0.getBooleanExtra(r2, r3)
            if (r0 == 0) goto L_0x0125
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.C3279c.m14239a()
            awk r2 = new awk
            r2.<init>()
            r0.mo20557d(r2)
            java.lang.String r0 = "BackgroundPlayNotification"
            java.lang.String r2 = "GoToPlay"
            p000.ayb.m18492b((java.lang.String) r0, (java.lang.String) r2)
        L_0x0125:
            r0 = r25
            r25 = r11
            goto L_0x013a
        L_0x012a:
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = -1
            r23 = 0
            r24 = 0
            r25 = 0
        L_0x013a:
            android.content.Intent r2 = r32.getIntent()
            if (r2 == 0) goto L_0x0195
            android.content.Intent r2 = r32.getIntent()
            java.lang.String r3 = "fromPip"
            r11 = 0
            boolean r2 = r2.getBooleanExtra(r3, r11)
            if (r2 == 0) goto L_0x0195
            com.inshot.xplayer.service.d r2 = com.inshot.xplayer.service.C2795d.m12716a()
            com.inshot.xplayer.service.b r2 = r2.mo18172b()
            if (r2 == 0) goto L_0x0195
            com.inshot.xplayer.service.d r0 = com.inshot.xplayer.service.C2795d.m12716a()
            r0.mo18173c()
            java.lang.String r0 = r2.f11082b
            java.lang.String r5 = r2.f11081a
            java.util.ArrayList<com.inshot.inplayer.bean.VideoPlayListBean> r6 = r2.f11085e
            java.lang.String r7 = r2.f11086f
            int r10 = r2.f11084d
            int r9 = r2.f11083c
            boolean r12 = r2.f11088h
            boolean r3 = r2.f11089i
            int r4 = r2.f11091k
            int r8 = r2.f11090j
            java.util.HashMap<java.lang.String, java.lang.String> r11 = r2.f11093m
            boolean r13 = r2.f11092l
            r26 = r0
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r0 = r2.f11094n
            com.inshot.inplayer.bean.VideoPlayListBean r2 = r2.mo18153a()
            if (r2 == 0) goto L_0x0188
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r0 = r2.f9818f
            int r2 = r2.f9819g
            r24 = r0
            r14 = r2
            goto L_0x018a
        L_0x0188:
            r24 = r0
        L_0x018a:
            r16 = r3
            r17 = r4
            r18 = r8
            r23 = r26
            r26 = 1
            goto L_0x019f
        L_0x0195:
            r18 = r0
            r17 = r4
            r16 = r13
            r11 = 0
            r26 = 0
            r13 = r8
        L_0x019f:
            if (r23 != 0) goto L_0x0349
            android.content.Intent r0 = r32.getIntent()
            android.support.v4.util.Pair r0 = m11647a((android.content.Intent) r0)
            if (r0 == 0) goto L_0x01b9
            S r2 = r0.second
            r23 = r2
            java.lang.String r23 = (java.lang.String) r23
            F r0 = r0.first
            r4 = r0
            android.net.Uri r4 = (android.net.Uri) r4
            r0 = r23
            goto L_0x01bc
        L_0x01b9:
            r0 = r23
            r4 = 0
        L_0x01bc:
            r2 = 0
            if (r0 != 0) goto L_0x02ad
            if (r4 == 0) goto L_0x01c4
            goto L_0x02ad
        L_0x01c4:
            android.content.Intent r0 = r32.getIntent()
            if (r0 != 0) goto L_0x01cc
            r4 = 0
            goto L_0x01d6
        L_0x01cc:
            android.content.Intent r0 = r32.getIntent()
            java.lang.String r4 = "path"
            java.lang.String r4 = r0.getStringExtra(r4)
        L_0x01d6:
            android.content.Intent r0 = r32.getIntent()
            if (r0 != 0) goto L_0x01de
            r0 = 0
            goto L_0x01e8
        L_0x01de:
            android.content.Intent r0 = r32.getIntent()
            java.lang.String r5 = "name"
            java.lang.String r0 = r0.getStringExtra(r5)
        L_0x01e8:
            android.content.Intent r5 = r32.getIntent()
            if (r5 == 0) goto L_0x01fd
            android.content.Intent r5 = r32.getIntent()
            java.lang.String r6 = "private"
            r7 = 0
            boolean r5 = r5.getBooleanExtra(r6, r7)
            if (r5 == 0) goto L_0x01fd
            r5 = 1
            goto L_0x01fe
        L_0x01fd:
            r5 = 0
        L_0x01fe:
            android.content.Intent r6 = r32.getIntent()
            if (r6 != 0) goto L_0x0206
            r6 = 0
            goto L_0x0210
        L_0x0206:
            android.content.Intent r6 = r32.getIntent()
            java.lang.String r7 = "playList"
            java.util.ArrayList r6 = r6.getParcelableArrayListExtra(r7)
        L_0x0210:
            android.content.Intent r7 = r32.getIntent()
            if (r7 != 0) goto L_0x0218
            r7 = 0
            goto L_0x0222
        L_0x0218:
            android.content.Intent r7 = r32.getIntent()
            java.lang.String r8 = "listName"
            java.lang.String r7 = r7.getStringExtra(r8)
        L_0x0222:
            if (r4 != 0) goto L_0x022e
            r32.finish()
            r0 = 2131624405(0x7f0e01d5, float:1.8875989E38)
            p000.axv.m7434a((int) r0)
            return
        L_0x022e:
            android.content.Intent r8 = r32.getIntent()
            if (r8 == 0) goto L_0x025e
            android.content.Intent r8 = r32.getIntent()
            java.lang.String r13 = "dbBean"
            android.os.Parcelable r8 = r8.getParcelableExtra(r13)
            com.inshot.xplayer.content.RecentMediaStorage$DBBean r8 = (com.inshot.xplayer.content.RecentMediaStorage.DBBean) r8
            if (r8 == 0) goto L_0x025e
            long r13 = r8.f10533f
            int r2 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0258
            long r2 = r8.f10533f
            long r13 = r8.f10534g
            r23 = 100
            long r13 = r13 - r23
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x0258
            long r2 = r8.f10533f
            int r2 = (int) r2
            r9 = r2
        L_0x0258:
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r2 = r8.f10535h
            int r3 = r8.f10528a
            r14 = r3
            goto L_0x0260
        L_0x025e:
            r2 = r24
        L_0x0260:
            if (r6 == 0) goto L_0x028e
            java.util.Iterator r3 = r6.iterator()
            r8 = 0
        L_0x0267:
            boolean r10 = r3.hasNext()
            if (r10 == 0) goto L_0x028a
            java.lang.Object r10 = r3.next()
            com.inshot.inplayer.bean.VideoPlayListBean r10 = (com.inshot.inplayer.bean.VideoPlayListBean) r10
            java.lang.String r13 = r10.f9813a
            boolean r13 = r4.equalsIgnoreCase(r13)
            if (r13 == 0) goto L_0x0287
            if (r2 == 0) goto L_0x0280
            r10.f9818f = r2
            goto L_0x028a
        L_0x0280:
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r3 = r10.f9818f
            if (r3 == 0) goto L_0x028a
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r2 = r10.f9818f
            goto L_0x028a
        L_0x0287:
            int r8 = r8 + 1
            goto L_0x0267
        L_0x028a:
            r24 = r2
            r10 = r8
            goto L_0x0290
        L_0x028e:
            r24 = r2
        L_0x0290:
            android.content.Intent r2 = r32.getIntent()
            if (r2 == 0) goto L_0x02a1
            android.content.Intent r2 = r32.getIntent()
            java.lang.String r3 = "originalPath"
            java.lang.String r2 = r2.getStringExtra(r3)
            goto L_0x02a2
        L_0x02a1:
            r2 = 0
        L_0x02a2:
            r3 = r2
            r2 = r9
            r29 = r11
            r31 = r4
            r4 = r0
            r0 = r31
            goto L_0x0354
        L_0x02ad:
            java.lang.String r5 = "FromOtherApp"
            java.lang.String r8 = m11649a((android.net.Uri) r4)
            p000.ayb.m18499d(r5, r8)
            if (r0 == 0) goto L_0x02c0
            r8 = 0
            boolean r5 = p000.axe.m7319a((java.lang.String) r0, (boolean) r8)
            if (r5 != 0) goto L_0x02c5
            goto L_0x02c1
        L_0x02c0:
            r8 = 0
        L_0x02c1:
            java.lang.String r0 = r4.toString()
        L_0x02c5:
            android.content.Intent r4 = r32.getIntent()
            java.lang.String r5 = "i3xBVEHM"
            java.lang.String r4 = r4.getStringExtra(r5)
            if (r4 != 0) goto L_0x02e3
            java.lang.String r4 = "%"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x02de
            java.lang.String r4 = android.net.Uri.decode(r0)
            goto L_0x02df
        L_0x02de:
            r4 = r0
        L_0x02df:
            java.lang.String r4 = p000.axy.m7460a((java.lang.String) r4)
        L_0x02e3:
            android.content.Intent r5 = r32.getIntent()
            java.lang.String r11 = "cafPyw9N"
            java.io.Serializable r5 = r5.getSerializableExtra(r11)
            java.util.HashMap r5 = (java.util.HashMap) r5
            java.lang.String r11 = "content://"
            boolean r11 = r0.startsWith(r11)
            if (r11 != 0) goto L_0x033c
            com.inshot.xplayer.content.RecentMediaStorage r11 = new com.inshot.xplayer.content.RecentMediaStorage
            r11.<init>(r15)
            com.inshot.xplayer.content.RecentMediaStorage$DBBean r11 = r11.mo17901a((java.lang.String) r0)
            if (r11 == 0) goto L_0x033c
            r27 = r9
            long r8 = r11.f10533f
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x031a
            long r8 = r11.f10533f
            long r2 = r11.f10534g
            r22 = 100
            long r2 = r2 - r22
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x031a
            long r2 = r11.f10533f
            int r9 = (int) r2
            goto L_0x031c
        L_0x031a:
            r9 = r27
        L_0x031c:
            long r2 = (long) r9
            long r8 = r11.f10534g
            r22 = 5000(0x1388, double:2.4703E-320)
            long r8 = r8 - r22
            r28 = r4
            r29 = r5
            r4 = 0
            long r4 = java.lang.Math.max(r4, r8)
            long r2 = java.lang.Math.min(r2, r4)
            int r9 = (int) r2
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r2 = r11.f10535h
            int r3 = r11.f10528a
            r24 = r2
            r14 = r3
        L_0x0339:
            r27 = r9
            goto L_0x0341
        L_0x033c:
            r28 = r4
            r29 = r5
            goto L_0x0339
        L_0x0341:
            r5 = r13
            r2 = r27
            r4 = r28
            r3 = 0
            r12 = 1
            goto L_0x0354
        L_0x0349:
            r27 = r9
            r4 = r5
            r29 = r11
            r5 = r13
            r0 = r23
            r2 = r27
            r3 = 0
        L_0x0354:
            axt r8 = new axt
            r8.<init>(r15)
            r8.mo10999a()
            r8.mo11004c()
            com.inshot.xplayer.service.a r9 = com.inshot.xplayer.service.C2779a.m12613a()
            boolean r9 = r9.mo18135b()
            com.inshot.xplayer.service.a r11 = com.inshot.xplayer.service.C2779a.m12613a()
            boolean r11 = r11.mo18135b()
            if (r11 == 0) goto L_0x037a
            com.inshot.xplayer.service.a r11 = com.inshot.xplayer.service.C2779a.m12613a()
            r13 = 1
            r11.mo18136b((android.content.Context) r15, (boolean) r13)
            goto L_0x037b
        L_0x037a:
            r13 = 1
        L_0x037b:
            if (r1 != 0) goto L_0x038e
            android.content.Context r1 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            android.content.SharedPreferences r1 = p000.axn.getSharedPrefrence(r1)
            java.lang.String r11 = "playResume"
            boolean r1 = r1.getBoolean(r11, r13)
            if (r1 != 0) goto L_0x038e
            r2 = 0
        L_0x038e:
            android.os.Bundle r1 = r15.f10263f
            if (r1 == 0) goto L_0x03d8
            android.os.Bundle r1 = r15.f10263f
            java.lang.String r11 = "jfkvoonkf1"
            boolean r1 = r1.containsKey(r11)
            if (r1 == 0) goto L_0x03d8
            android.os.Bundle r1 = r15.f10263f
            java.lang.String r11 = "jfkvoonkf1"
            int r2 = r1.getInt(r11, r2)
            if (r6 == 0) goto L_0x03c7
            android.os.Bundle r1 = r15.f10263f
            java.lang.String r11 = "jfkvoonkf2"
            r13 = -1
            int r1 = r1.getInt(r11, r13)
            if (r1 < 0) goto L_0x03c7
            int r11 = r6.size()
            if (r1 >= r11) goto L_0x03c7
            java.lang.Object r0 = r6.get(r1)
            com.inshot.inplayer.bean.VideoPlayListBean r0 = (com.inshot.inplayer.bean.VideoPlayListBean) r0
            java.lang.String r10 = r0.f9813a
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r11 = r0.f9818f
            int r14 = r0.f9819g
            r0 = r10
            r24 = r11
            goto L_0x03c8
        L_0x03c7:
            r1 = r10
        L_0x03c8:
            android.os.Bundle r10 = r15.f10263f
            java.lang.String r11 = "jfkvoonkf3"
            boolean r9 = r10.getBoolean(r11, r9)
            r10 = r1
            r19 = r2
            r13 = r9
            r11 = r14
            r20 = 1
            goto L_0x03de
        L_0x03d8:
            r19 = r2
            r13 = r9
            r11 = r14
            r20 = 0
        L_0x03de:
            r14 = r0
            if (r19 >= 0) goto L_0x03e3
            r9 = 0
            goto L_0x03e5
        L_0x03e3:
            r9 = r19
        L_0x03e5:
            r0 = r15
            r1 = r8
            r2 = r14
            r8 = r10
            r10 = r24
            r21 = 1
            r30 = r14
            r14 = r16
            r15 = r18
            r16 = r17
            r17 = r29
            r18 = r26
            r0.m11650a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            if (r26 != 0) goto L_0x0421
            if (r19 <= 0) goto L_0x0421
            if (r25 != 0) goto L_0x0421
            if (r20 != 0) goto L_0x0421
            r0 = r32
            com.inshot.inplayer.widget.g r1 = r0.f10258a
            android.view.View r1 = r1.mo17577g()
            r2 = 2131624353(0x7f0e01a1, float:1.8875883E38)
            r3 = 2131624420(0x7f0e01e4, float:1.887602E38)
            java.lang.String r3 = r0.getString(r3)
            com.inshot.xplayer.activities.PlayerActivity$1 r4 = new com.inshot.xplayer.activities.PlayerActivity$1
            r5 = r30
            r4.<init>(r5)
            p000.axv.m7437a(r1, r2, r3, r4)
            goto L_0x0423
        L_0x0421:
            r0 = r32
        L_0x0423:
            r1 = 1
            r0.f10265h = r1
            android.content.Context r1 = r32.getApplicationContext()
            android.support.v4.content.LocalBroadcastManager r1 = android.support.p001v4.content.LocalBroadcastManager.getInstance(r1)
            android.content.BroadcastReceiver r2 = r0.f10266i
            android.content.IntentFilter r3 = new android.content.IntentFilter
            java.lang.String r4 = "zxcwe2dfwe"
            r3.<init>(r4)
            r1.registerReceiver(r2, r3)
            com.inshot.xplayer.ad.b r1 = com.inshot.xplayer.p015ad.C2558b.m11723a()
            boolean r1 = r1.mo17734d()
            if (r1 == 0) goto L_0x0447
            r32.m11657i()
        L_0x0447:
            com.inshot.xplayer.ad.b r1 = com.inshot.xplayer.p015ad.C2558b.m11723a()
            r1.mo17732b()
            com.inshot.xplayer.ad.b r1 = com.inshot.xplayer.p015ad.C2558b.m11723a()
            boolean r1 = r1.mo17736f()
            if (r1 == 0) goto L_0x0483
            com.inshot.xplayer.ad.b r1 = com.inshot.xplayer.p015ad.C2558b.m11723a()
            long r1 = r1.mo17738h()
            com.inshot.xplayer.ad.k r3 = com.inshot.xplayer.p015ad.C2572k.m11824d()
            long r3 = r3.mo17780f()
            long r5 = java.lang.System.currentTimeMillis()
            com.inshot.xplayer.ad.b r7 = com.inshot.xplayer.p015ad.C2558b.m11723a()
            long r7 = r7.mo17737g()
            long r3 = r3 + r7
            long r3 = r3 - r5
            long r1 = java.lang.Math.max(r1, r3)
            com.inshot.xplayer.application.MyApplication r3 = com.inshot.xplayer.application.MyApplication.myApplication()
            java.lang.Runnable r4 = r0.f10264g
            r3.mo17869a((java.lang.Runnable) r4, (long) r1)
        L_0x0483:
            boolean r1 = r0.f10259b
            if (r1 == 0) goto L_0x048a
            r32.m11656h()
        L_0x048a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.activities.PlayerActivity.m11653e():void");
    }
    private void m11653e() {
        boolean z;
        RecentMediaStorage.ExInfo exInfo;
        String str = null;
        int i2=0;
        boolean z2;
        boolean z3;
        int i3;
        int i4 = 0;
        boolean z4;
        String str2;
        ArrayList<VideoPlayListBean> arrayList;
        String str3;
        int i5;
        boolean z5;
        int i6;
        int i7;
        boolean z6;
        boolean z7;
        HashMap<String, String> hashMap;
        HashMap<String, String> hashMap2;
        boolean z8;
        String str4;
        String str5;
        int i8;
        String str6=null;
        boolean z9;
        boolean z10;
        int i9;
        boolean z11;
        int i10;
        PlayerActivity playerActivity = null;
        int i11;
        Uri f2;
        String str7;
        RecentMediaStorage.DBBean a2;
        RecentMediaStorage.ExInfo exInfo2;
        RecentMediaStorage.DBBean dBBean;
        C2787b b2;
        IMediaPlayer c2;
        boolean z12 = false;
        VideoPlayListBean j2;
        RecentMediaStorage.ExInfo exInfo3 = null;
        if (!this.f10262e) {
            this.f10262e = true;
            Initilize( this);
            InitilizationActivity.addInitilize(this);
            mo17679a(true);
            int i12 = 10;
               // m11657i();


            boolean z13 = getIntent() != null && getIntent().getBooleanExtra("backgroundMode", false);
            if (z13) {
                String e2 = com.abhishek.xplayer.service.C2779a.m12613a().mo18139e();
                str3 = com.abhishek.xplayer.service.C2779a.m12613a().mo18138d();
                arrayList = com.abhishek.xplayer.service.C2779a.m12613a().mo18150p();
                str2 = com.abhishek.xplayer.service.C2779a.m12613a().mo18151q();
                z4 = getIntent() != null && getIntent().getBooleanExtra("private", false);
                if (arrayList != null) {
                    m11651a(arrayList);
                    if (arrayList.isEmpty()) {
                        if (com.abhishek.xplayer.service.C2779a.m12613a().mo18135b()) {
                            com.abhishek.xplayer.service.C2779a.m12613a().mo18136b((Context) this, true);
                        }
                        axv.m7434a((int) R.string.cant_load_video);
                        finish();
                        return;
                    }
                    Iterator<VideoPlayListBean> it = arrayList.iterator();
                    i3 = 0;
                    while (it.hasNext() && !e2.equalsIgnoreCase(it.next().f9813a)) {
                        i3++;
                    }
                    if (i3 == arrayList.size()) {
                        e2 = arrayList.get(0).f9813a;
                        str3 = arrayList.get(0).f9815c;
                    }
                    c2 = com.abhishek.xplayer.service.C2779a.m12613a().mo18137c();
                    if (c2 == null) {
                        i4 = (int) c2.getCurrentPosition();
                        z12 = true;
                    } else {
                        i4 = 0;
                        z12 = false;
                    }
                    z3 = com.abhishek.xplayer.service.C2779a.m12613a().mo18140f();
                    z2 = com.abhishek.xplayer.service.C2779a.m12613a().mo18140f();
                    i5 = com.abhishek.xplayer.service.C2779a.m12613a().mo18142h();
                    int i13 = com.abhishek.xplayer.service.C2779a.m12613a().mo18143i();
                    j2 = com.abhishek.xplayer.service.C2779a.m12613a().mo18144j();
                    if (j2 == null) {
                        exInfo3 = j2.f9818f;
                        i2 = j2.f9819g;
                        str = e2;
                    } else {
                        str = e2;
                        exInfo3 = null;
                        i2 = -1;
                    }
                    exInfo = exInfo3;
                    if (getIntent().getBooleanExtra("fromNotification", false)) {
                        EventBus.getDefault().post(new awk());
                        LogEvents.m18492b("BackgroundPlayNotification", "GoToPlay");
                    }
                    i12 = i13;
                    z = z12;
                }
                i3 = 0;
                c2 = com.abhishek.xplayer.service.C2779a.m12613a().mo18137c();
                if (c2 == null) {
                }
                z3 = com.abhishek.xplayer.service.C2779a.m12613a().mo18140f();
                z2 = com.abhishek.xplayer.service.C2779a.m12613a().mo18141g();
                i5 = com.abhishek.xplayer.service.C2779a.m12613a().mo18142h();
                int i132 = com.abhishek.xplayer.service.C2779a.m12613a().mo18143i();
                j2 = com.abhishek.xplayer.service.C2779a.m12613a().mo18144j();
                if (j2 == null) {
                }
                exInfo = exInfo3;
                if (getIntent().getBooleanExtra("fromNotification", false)) {
                }
                i12 = i132;
                z = z12;
            } else {
                i5 = -1;
                str3 = null;
                arrayList = null;
                str2 = null;
                z4 = false;
                i4 = 0;
                i3 = 0;
                z3 = false;
                z2 = false;
                i2 = -1;
                str = null;
                exInfo = null;
                z = false;
            }
            if (getIntent() == null || !getIntent().getBooleanExtra("fromPip", false) || (b2 = StartPipPlayService.m12716a().mo18172b()) == null) {
                i6 = i12;
                i7 = i5;
                z6 = z2;
                hashMap = null;
                z5 = false;
                z7 = z4;
            } else {
                StartPipPlayService.m12716a().mo18173c();
                String str8 = b2.f11082b;
                str3 = b2.f11081a;
                arrayList = b2.f11085e;
                str2 = b2.f11086f;
                i3 = b2.f11084d;
                i4 = b2.f11083c;
                z3 = b2.f11088h;
                boolean z14 = b2.f11089i;
                int i14 = b2.f11091k;
                int i15 = b2.f11090j;
                hashMap = b2.f11093m;
                z7 = b2.f11092l;
                RecentMediaStorage.ExInfo exInfo4 = b2.f11094n;
                VideoPlayListBean a3 = b2.mo18153a();
                if (a3 != null) {
                    exInfo = a3.f9818f;
                    i2 = a3.f9819g;
                } else {
                    exInfo = exInfo4;
                }
                z6 = z14;
                i7 = i14;
                i6 = i15;
                str = str8;
                z5 = true;
            }
            if (str == null) {
                Pair<Uri, String> a4 = m11647a(getIntent());
                if (a4 != null) {
                    f2 = a4.first;
                    str6 = a4.second;
                } else {
                    str6 = str;
                    f2 = null;
                }
                if (str6 == null && f2 == null) {
                    String stringExtra = getIntent() == null ? null : getIntent().getStringExtra("path");
                    String stringExtra2 = getIntent() == null ? null : getIntent().getStringExtra("name");
                    z8 = getIntent() != null && getIntent().getBooleanExtra("private", false);
                    arrayList = getIntent() == null ? null : getIntent().getParcelableArrayListExtra("playList");
                    str2 = getIntent() == null ? null : getIntent().getStringExtra("listName");
                    if (stringExtra == null) {
                        finish();
                        axv.m7434a((int) R.string.small_problem);
                        return;
                    }
                    if (getIntent() == null || (dBBean = (RecentMediaStorage.DBBean) getIntent().getParcelableExtra("dbBean")) == null) {
                        exInfo2 = exInfo;
                    } else {
                        if (dBBean.f10533f > 0 && dBBean.f10533f < dBBean.f10534g - 100) {
                            i4 = (int) dBBean.f10533f;
                        }
                        exInfo2 = dBBean.f10535h;
                        i2 = dBBean.f10528a;
                    }
                    if (arrayList != null) {
                        Iterator<VideoPlayListBean> it2 = arrayList.iterator();
                        int i16 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            VideoPlayListBean next = it2.next();
                            if (!stringExtra.equalsIgnoreCase(next.f9813a)) {
                                i16++;
                            } else if (exInfo2 != null) {
                                next.f9818f = exInfo2;
                            } else if (next.f9818f != null) {
                                exInfo2 = next.f9818f;
                            }
                        }
                        exInfo = exInfo2;
                        i3 = i16;
                    } else {
                        exInfo = exInfo2;
                    }
                    str5 = getIntent() != null ? getIntent().getStringExtra("originalPath") : null;
                    i8 = i4;
                    hashMap2 = hashMap;
                    str4 = stringExtra2;
                    str6 = stringExtra;
                } else {
                    LogEvents.m18499d("FromOtherApp", m11649a((Uri) f2));
                    if (str6 != null) {
                    }
                    str6 = f2.toString();
                    String stringExtra3 = getIntent().getStringExtra("i3xBVEHM");
                    if (stringExtra3 == null) {
                        stringExtra3 = axy.m7460a(str6.contains("%") ? Uri.decode(str6) : str6);
                    }
                    HashMap<String, String> hashMap3 = (HashMap) getIntent().getSerializableExtra("cafPyw9N");
                    if (str6.startsWith("content://") || (a2 = new RecentMediaStorage(this).mo17901a(str6)) == null) {
                        str7 = stringExtra3;
                        hashMap2 = hashMap3;
                    } else {
                        str7 = stringExtra3;
                        hashMap2 = hashMap3;
                        i4 = (int) Math.min((long) ((a2.f10533f <= 0 || a2.f10533f >= a2.f10534g - 100) ? i4 : (int) a2.f10533f), Math.max(0L, a2.f10534g - 5000));
                        exInfo = a2.f10535h;
                        i2 = a2.f10528a;
                    }
                    z8 = z7;
                    i8 = i4;
                    str4 = str7;
                    str5 = null;
                    z3 = true;
                }
            } else {
                str4 = str3;
                hashMap2 = hashMap;
                z8 = z7;
                str6 = str;
                i8 = i4;
                str5 = null;
            }
            axt axt = new axt(this);
            axt.mo10999a();
            axt.mo11004c();
            boolean b3 = com.abhishek.xplayer.service.C2779a.m12613a().mo18135b();
            if (com.abhishek.xplayer.service.C2779a.m12613a().mo18135b()) {
                z9 = true;
                com.abhishek.xplayer.service.C2779a.m12613a().mo18136b((Context) this, true);
            } else {
                z9 = true;
            }
            if (!z13 && !SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("playResume", z9)) {
                i8 = 0;
            }
            if (this.f10263f == null || !this.f10263f.containsKey("jfkvoonkf1")) {
                i9 = i8;
                z11 = b3;
                i10 = i2;
                z10 = false;
            } else {
                int i17 = this.f10263f.getInt("jfkvoonkf1", i8);
                if (arrayList == null || (i11 = this.f10263f.getInt("jfkvoonkf2", -1)) < 0 || i11 >= arrayList.size()) {
                    i11 = i3;
                } else {
                    VideoPlayListBean videoPlayListBean = arrayList.get(i11);
                    String str9 = videoPlayListBean.f9813a;
                    RecentMediaStorage.ExInfo exInfo5 = videoPlayListBean.f9818f;
                    i2 = videoPlayListBean.f9819g;
                    str6 = str9;
                    exInfo = exInfo5;
                }
                i3 = i11;
                i9 = i17;
                z11 = this.f10263f.getBoolean("jfkvoonkf3", b3);
                i10 = i2;
                z10 = true;
            }
              m11650a(axt, str6, str5, str4, z8, arrayList, str2, i3, i9 < 0 ? 0 : i9, exInfo, i10, z3, z11, z6, i6, i7, hashMap2, z5);
            if (z5 || i9 <= 0 || z || z10) {
                playerActivity = this;
            }
            else {
                playerActivity = this;
                String finalStr = str6;
                axv.m7437a(playerActivity.f10258a.mo17577g(), R.string.resume_auto, playerActivity.getString(R.string.start_over), new View.OnClickListener() {
                    /* class com.inshot.xplayer.activities.PlayerActivity.AnonymousClass1 */

                    public void onClick(View view) {
                        if (PlayerActivity.this.f10258a != null) {
                            PlayerActivity.this.f10258a.mo17574e(finalStr);
                        }
                    }
                });
            }
            playerActivity.f10265h = true;
            LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(playerActivity.f10266i, new IntentFilter("zxcwe2dfwe"));
                m11657i();
        //    com.abhishek.xplayer.ad.C2231b.m10188a().mo17732b();
            if (com.abhishek.xplayer.ad.C2231b.m10188a().mo16921d()) {
                MyApplication.myApplication().runnableDelay(playerActivity.f10264g, Math.max(com.abhishek.xplayer.ad.C2231b.m10188a().mo16923f(), (MopubIntertitialAd.createInstance1().mo16970h() + com.abhishek.xplayer.ad.C2231b.m10188a().mo16922e()) - System.currentTimeMillis()));
            }
            if (playerActivity.f10259b) {
                m11656h();
            }
        }
    }

    /* renamed from: a */
    private void m11651a(ArrayList<VideoPlayListBean> arrayList) {
        Iterator<VideoPlayListBean> it = arrayList.iterator();
        while (it.hasNext()) {
            VideoPlayListBean next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f9813a) && next.f9813a.charAt(0) == '/' && !axc.chekFileExist(next.f9813a)) {
                it.remove();
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f10258a == null || !this.f10258a.mo17559a(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* renamed from: a */
    private static String m11649a(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return uri.getHost();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private void m11650a(axt axt, String str, String str2, String str3, boolean z, ArrayList<VideoPlayListBean> arrayList, String str4, int i, int i2, RecentMediaStorage.ExInfo exInfo, int i3, boolean z2, boolean z3, boolean z4, int i4, int i5, HashMap<String, String> hashMap, boolean z5) {
          String string = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getString("uvwecu2", (String) null);
        if (string != null) {
            if (Process.myPid() != PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("uvwecu1", 0)) {
                new RecentMediaStorage(this).mo17904a(string, 1);
                LogEvents.m18488a("ANR", string, false);
            } else {
                string = null;
            }
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().remove("uvwecu2").apply();
        }
        this.f10258a = new C2483g(this, axt).mo17565c(str3).mo17555a(z).mo17562b(z2).mo17569d(str2).mo17566c(false).mo17570d(true).mo17572e(true).mo17568d(PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("xuWEdsJa", 0)).mo17564c(i2).mo17553a(str4, arrayList, i).mo17560b(i3).mo17551a(exInfo).mo17552a(string).mo17554a(hashMap).mo17561b(str);
        if (z3) {
            this.f10258a.mo17580j();
        }
        if (z5 || z3) {
            this.f10258a.mo17573e(i5);
            if (z4) {
                this.f10258a.mo17579i();
            }
        }
        this.f10258a.mo17576f();
        if (!PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean("videoGuide", false)) {
            final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.app_video_box);
            final View inflate = LayoutInflater.from(this).inflate(R.layout.guide_layout, viewGroup, false);
            awt.m7198a((ImageView) inflate.findViewById(R.id.ic_help_brightness), (int) R.drawable.ic_help_brightness);
            awt.m7198a((ImageView) inflate.findViewById(R.id.ic_help_progress), (int) R.drawable.ic_help_progress);
            awt.m7198a((ImageView) inflate.findViewById(R.id.ic_help_sound), (int) R.drawable.ic_help_sound);
            viewGroup.addView(inflate);
            this.f10258a.mo17550a((avs) new avs() {
                /* renamed from: a */
                public void mo10823a(boolean z) {
                    if (z && inflate.getVisibility() == 0) {
                        inflate.setVisibility(8);
                        viewGroup.removeView(inflate);
                        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putBoolean("videoGuide", true).apply();
                    }
                }
            });
            inflate.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (inflate.getVisibility() != 0) {
                        return false;
                    }
                    inflate.setVisibility(View.GONE);
                    viewGroup.removeView(inflate);
                    PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putBoolean("videoGuide", true).apply();
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        m10115u();
        if (isFinishing() || !isInMultiWindowMode()) {
            m11654f();
        }
        if (isFinishing() && !this.f7878k && atd.m18390b("showRateCount", 0) < 3) {
            atd.m18387a("wcHRI563", atd.m18390b("wcHRI563", 0) + 1);
        }
    }

    /* renamed from: f */
    private void m11654f() {
        if (this.f10259b) {
            this.f10259b = false;
            if (this.f10262e) {
                if (isFinishing()) {
                    setRequestedOrientation(-1);
                }
                axg.m7328a((Context) this, (axg.C1345a) this.f10258a);
                axg.m7336b((axg.C1345a) this.f10258a);
                if (this.f10258a != null) {
                    this.f10258a.mo17563b();
                    if (this.f10258a.mo17578h() || C2779a.m12613a().mo18135b()) {
                        this.f10258a.mo17571d();
                        this.f10258a = null;
                    }
                }
                mo17680b();
                if (isFinishing()) {
                    LogEvents.m18485a("PlayTime2", String.valueOf(this.f10267j / 1000), (long) (this.f10267j / 1000));
                    this.f10267j = 0;
                    MopubIntertitialAd.createInstance1().mo16969g();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        m11654f();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        LogEvents.m18498d("PlayPage");
        if (isInMultiWindowMode()) {
            m11655g();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m10116v();
        axw.m7446a((Activity) this, Integer.MIN_VALUE);
        axw.m7451b(this, Integer.MIN_VALUE);
        m11655g();
    }

    /* renamed from: g */
    private void m11655g() {
        if (!this.f10259b) {
            this.f10259b = true;
            if (this.f10262e) {
                m11656h();
            }
        }
    }

    /* renamed from: h */
    private void m11656h() {
        if (this.f10258a != null) {
            axg.m7327a((axg.C1345a) this.f10258a).mo10964a((Context) this);
            this.f10258a.mo17567c();
            if (C2779a.m12613a().mo18135b()) {
                C2779a.m12613a().mo18136b((Context) this, false);
                return;
            }
            return;
        }
        if (C2779a.m12613a().mo18135b()) {
            startActivity(C2779a.m12613a().mo18128a((Context) this, false));
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f10262e) {
            this.f10267j = 0;
            m11660l();
            MyApplication.myApplication().mo17871b(this.f10264g);
            if (this.f10265h) {
                LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.f10266i);
                this.f10265h = false;
            }
            if (this.f10258a != null) {
                this.f10258a.mo17571d();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f10258a != null) {
            this.f10258a.mo17557a(configuration);
        }
    }

    public void onBackPressed() {
        if (this.f10258a == null || !this.f10258a.mo17575e()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 110) {
            super.onActivityResult(i, i2, intent);
            if (this.f10258a != null) {
                this.f10258a.mo17556a(i, i2, intent);
            }
        } else if (i2 == -1) {
            m11653e();
        } else {
            finish();
        }
    }

    /* renamed from: a */
    private static Pair<Uri, String> m11647a(Intent intent) {
        Bundle a = C2552a.m11683a(MyApplication.getApplicationContext_(), intent);
        if (a == null) {
            return null;
        }
        LogEvents.m18483a("Share");
        return new Pair<>((Uri) a.getParcelable("6bjQrUMY"), a.getString("a6IfgqKJ"));
    }

    /* renamed from: a */
    public void mo17679a(boolean z) {
        Window window;
        if (!isFinishing() && (window = getWindow()) != null) {
            if (z) {
                window.addFlags(128);
            } else {
                window.clearFlags(128);
            }
        }
    }

    /* renamed from: a */
    public void mo17676a() {
        if (this.f10268k == -1) {
            this.f10268k = System.currentTimeMillis();
        }
    }

    /* renamed from: b */
    public void mo17680b() {
        if (this.f10268k != -1) {
            this.f10267j = (int) (((long) this.f10267j) + (System.currentTimeMillis() - this.f10268k));
            this.f10268k = -1;
        }
    }

    /* renamed from: c */
    public void mo17681c() {
        if (!PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean("adRemoved", false)  && !this.f10269l) {
            boolean z = true;
            this.f10269l = true;
            PauseNativeAdLoader tVar = (PauseNativeAdLoader) PauseNativeAd.m10414e().mo16927c();
            if (tVar != null && tVar.mo16905d()) {
                if (!(this.f10270m == tVar || this.f10270m == null)) {
                    this.f10270m.destroyad();
                }
                this.f10270m = tVar;
            }
            if (this.f10270m == null || !this.f10270m.mo16905d()) {
                PauseNativeAd.m10414e().mo16926b();
                return;
            }
            if (this.f10270m.mo16906e()) {
                this.f10270m.destroyad();
            }
            m11652b(this.f10270m);
        }
    }

    /* renamed from: d */
    public boolean mo17682d() {
        if ( !this.f10269l) {
            return false;
        }
        this.f10271n.setVisibility(View.GONE);
        this.f10269l = false;
        return true;
    }

    /* renamed from: a */
    public void mo16863b(PauseNativeAdLoader tVar) {
            if (this.f10269l && this.f10270m != null) {
                if (this.f10270m.mo17007c()) {
                    return;
                }
                if (this.f10270m.mo16905d() && !this.f10270m.mo16906e()) {
                    return;
                }
            }
            if (!(this.f10270m == null || this.f10270m == tVar)) {
                this.f10270m.destroyad();
            }
            this.f10270m = tVar;
            if (this.f10269l) {
                m11652b(this.f10270m);
            }

    }

    /* renamed from: b */
    private void m11652b(PauseNativeAdLoader tVar) {
        View g;
        if ( this.f10271n != null && (g = tVar.mo17008g()) != null) {
            ViewGroup viewGroup = (ViewGroup) g.getParent();
            if (viewGroup != null) {
                if (viewGroup == this.f10271n) {
                    this.f10271n.setVisibility(View.VISIBLE);
                    if (g.getVisibility() != View.VISIBLE) {
                        g.setVisibility(View.VISIBLE);
                    }
                    PauseNativeAd.m10414e().mo16928c(tVar);
                    return;
                }
                viewGroup.removeView(g);
            }
            this.f10271n.removeAllViews();
            this.f10271n.addView(g);
            this.f10271n.setVisibility(View.VISIBLE);
            if (g.getVisibility() != View.VISIBLE) {
                g.setVisibility(View.VISIBLE);
            }
            PauseNativeAd.m10414e().mo16928c(tVar);
        }
    }

    /* renamed from: i */
    private void m11657i() {
            this.f10271n = (ViewGroup) findViewById(R.id.ad_container);
        PauseNativeAd.m10414e().mo17010a((AppAbstractInterface<PauseNativeAdLoader>) this);

    }


    /* renamed from: l */
    private void m11660l() {
            if (this.f10271n != null) {
                this.f10271n.removeAllViews();
            }
            if (this.f10270m != null) {
                this.f10270m.destroyad();
            }
            this.f10270m = null;
        PauseNativeAd.m10414e().mo17013b(this);

    }

    @Override
    public void mo16860a(PauseNativeAdLoader c2265t) {

    }


}
