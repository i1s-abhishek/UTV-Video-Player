package com.abhishek.xplayer.ad;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;

import classesdef.ads.RemoteCloudConfig;
import classesdef.ads.atd;

/* renamed from: com.inshot.xplayer.ad.b */
public class C2231b {

    /* renamed from: a */
    private static final C2231b f7935a = new C2231b();

    /* renamed from: b */
    private long f7936b;

    /* renamed from: c */
    private boolean f7937c;

    /* renamed from: d */
    private boolean f7938d;

    /* renamed from: e */
    private long f7939e;

    /* renamed from: f */
    private long f7940f;

    /* renamed from: g */
    private boolean f7941g;

    /* renamed from: h */
    private long f7942h;

    /* renamed from: i */
    private long f7943i;

    /* renamed from: a */
    public static C2231b m10188a() {
        return f7935a;
    }

    private C2231b() {
    }

    /* renamed from: b */
    public void mo16919b() {
        int a;
        this.f7936b = atd.m18391b("FirstOpenTime", -1);
        if (this.f7936b == -1) {
            this.f7936b = System.currentTimeMillis();
            atd.m18388a("FirstOpenTime", this.f7936b);
        }
        m10191i();
        this.f7937c = m10190a("videoListAd", true);
        this.f7941g = m10190a("splashAdEnable", true);
        if (this.f7941g && (a = RemoteCloudConfig.m18215a("splashAdPercent", -1)) >= 0 && ((int) (Math.random() * 100.0d)) > a) {
            this.f7941g = false;
        }
        this.f7942h = ((long) RemoteCloudConfig.m18215a("splashAdSpace", 0)) * 60000;
        this.f7943i = (long) RemoteCloudConfig.m18215a("splashTime", 5000);
    }

    /* renamed from: i */
    private void m10191i() {
        this.f7938d = m10190a("fullAdEnable", true);
        this.f7939e = ((long) RemoteCloudConfig.m18215a("fullAdSpace", 0)) * 60000;
        this.f7940f = ((long) RemoteCloudConfig.m18215a("fullAdMinWatchTime", 0)) * 60000;
        MopubIntertitialAd.createInstance1();
    }

    /* renamed from: c */
    public boolean mo16920c() {
        return this.f7937c;
    }

    /* renamed from: d */
    public boolean mo16921d() {
        return this.f7938d;
    }

    /* renamed from: e */
    public long mo16922e() {
        return this.f7939e;
    }

    /* renamed from: f */
    public long mo16923f() {
        return this.f7940f;
    }

    /* renamed from: g */
    public long mo16924g() {
        return this.f7942h;
    }

    /* renamed from: h */
    public long mo16925h() {
        return this.f7943i;
    }

    /* renamed from: a */
    private boolean m10190a(String str, boolean z) {
        switch (RemoteCloudConfig.m18215a(str, -1)) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                String a = RemoteCloudConfig.m18216a(str + "After", (String) null);
                if (TextUtils.isEmpty(a)) {
                    a = RemoteCloudConfig.m18216a("ShowAdAfter", (String) null);
                    if (TextUtils.isEmpty(a)) {
                        return z;
                    }
                }
                return m10189a(this.f7936b, a, z);
            default:
                return z;
        }
    }

    /* renamed from: a */
    private static boolean m10189a(long j, String str, boolean z) {
        try {
            return j >= new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }
}
