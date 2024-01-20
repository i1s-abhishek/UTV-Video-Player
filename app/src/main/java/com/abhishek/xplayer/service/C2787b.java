package com.abhishek.xplayer.service;

import com.abhishek.inplayer.bean.VideoPlayListBean;
import com.abhishek.xplayer.content.RecentMediaStorage;

import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.inshot.xplayer.service.b */
public class C2787b {

    /* renamed from: a */
    public String f11081a;

    /* renamed from: b */
    public String f11082b;

    /* renamed from: c */
    public int f11083c;

    /* renamed from: d */
    public int f11084d;

    /* renamed from: e */
    public final ArrayList<VideoPlayListBean> f11085e;

    /* renamed from: f */
    public final String f11086f;

    /* renamed from: g */
    public boolean f11087g;

    /* renamed from: h */
    public final boolean f11088h;

    /* renamed from: i */
    public final boolean f11089i;

    /* renamed from: j */
    public final int f11090j;

    /* renamed from: k */
    public final int f11091k;

    /* renamed from: l */
    public final boolean f11092l;

    /* renamed from: m */
    public final HashMap<String, String> f11093m;

    /* renamed from: n */
    public RecentMediaStorage.ExInfo f11094n;

    public C2787b(String str, String str2, int i, int i2, ArrayList<VideoPlayListBean> arrayList, String str3, boolean z, boolean z2, boolean z3, int i3, int i4, boolean z4, HashMap<String, String> hashMap, RecentMediaStorage.ExInfo exInfo) {
        VideoPlayListBean a;
        this.f11081a = str;
        this.f11082b = str2;
        this.f11083c = i;
        this.f11084d = i2;
        this.f11085e = arrayList;
        this.f11086f = str3;
        this.f11087g = z;
        this.f11088h = z2;
        this.f11089i = z3;
        this.f11090j = i3;
        this.f11091k = i4;
        this.f11092l = z4;
        this.f11093m = hashMap;
        this.f11094n = exInfo;
        if (exInfo == null && (a = mo18153a()) != null) {
            this.f11094n = a.f9818f;
        }
    }

    /* renamed from: a */
    public VideoPlayListBean mo18153a() {
        if (this.f11085e == null || this.f11084d < 0 || this.f11084d >= this.f11085e.size()) {
            return null;
        }
        return this.f11085e.get(this.f11084d);
    }
}
