package com.abhishek.xplayer.ad;

import android.content.Context;

import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.inshot.xplayer.ad.g */
public class DownloadListNativeAds extends AppAbstractAds<DownloadNativeAdLoader> {

    /* renamed from: b */
    private static DownloadListNativeAds f7962b;

    /* renamed from: c */
    private DownloadNativeAdLoader f7963c;

    /* renamed from: d */
    private LinkedList<AppAbstractInterface<DownloadNativeAdLoader>> f7964d = new LinkedList<>();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo16910a() {
        return "DownloadList";
    }

    /* renamed from: e */
    public static DownloadListNativeAds m10235e() {
        if (f7962b == null) {
            f7962b = new DownloadListNativeAds();
        }
        return f7962b;
    }

    private DownloadListNativeAds() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public DownloadNativeAdLoader mo16909a(Context context, AppAbstractInterface<DownloadNativeAdLoader> qVar) {
        DownloadNativeAdLoader fVar = new DownloadNativeAdLoader(context);
        fVar.mo16937a(qVar);
        return fVar;
    }

    /* renamed from: a */
    public void mo16863b(DownloadNativeAdLoader fVar) {
        super.mo16863b(fVar);
        DownloadNativeAdLoader fVar2 = this.f7963c;
        if (fVar2 != null) {
            fVar2.mo16938c();
        }
        this.f7963c = fVar;
        Iterator it = this.f7964d.iterator();
        while (it.hasNext()) {
            ((AppAbstractInterface) it.next()).mo16863b(fVar);
        }
    }

    /* renamed from: b */
    public void mo16860a(DownloadNativeAdLoader fVar) {
        super.mo16860a(fVar);
        Iterator it = this.f7964d.iterator();
        while (it.hasNext()) {
            ((AppAbstractInterface) it.next()).mo16860a(fVar);
        }
    }

    /* renamed from: d */
    public boolean mo16917d() {
        return super.mo16917d() || this.f7963c != null;
    }

    /* renamed from: f */
    public DownloadNativeAdLoader mo16946f() {
        DownloadNativeAdLoader fVar = this.f7963c;
        if (fVar != null && fVar.mo16906e()) {
            this.f7963c.mo16938c();
            this.f7963c = null;
        }
        return this.f7963c;
    }

    /* renamed from: c */
    public void mo16945c(DownloadNativeAdLoader fVar) {
        mo16928c(fVar);
    }

    /* renamed from: a */
    public void mo16941a(AppAbstractInterface<DownloadNativeAdLoader> qVar) {
        this.f7964d.add(qVar);
    }

    /* renamed from: b */
    public void mo16944b(AppAbstractInterface<DownloadNativeAdLoader> qVar) {
        this.f7964d.remove(qVar);
    }
}
