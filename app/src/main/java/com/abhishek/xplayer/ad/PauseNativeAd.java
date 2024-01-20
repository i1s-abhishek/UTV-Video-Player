package com.abhishek.xplayer.ad;

import android.content.Context;



import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.inshot.xplayer.ad.u */
public class PauseNativeAd extends AppAbstractAds<PauseNativeAdLoader> {

    /* renamed from: b */
    private static PauseNativeAd f8053b;

    /* renamed from: c */
    private LinkedList<AppAbstractInterface<PauseNativeAdLoader>> f8054c = new LinkedList<>();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo16910a() {
        return "Pause";
    }

    /* renamed from: e */
    public static PauseNativeAd m10414e() {
        if (f8053b == null) {
            f8053b = new PauseNativeAd();
        }
        return f8053b;
    }

    private PauseNativeAd() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public PauseNativeAdLoader mo16909a(Context context, AppAbstractInterface<PauseNativeAdLoader> qVar) {
        PauseNativeAdLoader tVar = new PauseNativeAdLoader(context);
        tVar.mo17006a(qVar);
        return tVar;
    }

    /* renamed from: a */
    public void mo16863b(PauseNativeAdLoader tVar) {
        super.mo16863b(tVar);
        Iterator it = this.f8054c.iterator();
        while (it.hasNext()) {
            ((AppAbstractInterface) it.next()).mo16863b(tVar);
        }
    }

    /* renamed from: b */
    public void mo16860a(PauseNativeAdLoader tVar) {
        super.mo16860a(tVar);
        Iterator it = this.f8054c.iterator();
        while (it.hasNext()) {
            ((AppAbstractInterface) it.next()).mo16860a(tVar);
        }
    }

    /* renamed from: c */
    public void mo16928c(PauseNativeAdLoader tVar) {
        if (tVar != null) {
            tVar.f8044a = true;
        }
        super.mo16928c(tVar);
    }

    /* renamed from: a */
    public void mo17010a(AppAbstractInterface<PauseNativeAdLoader> qVar) {
        this.f8054c.add(qVar);
    }

    /* renamed from: b */
    public void mo17013b(AppAbstractInterface<PauseNativeAdLoader> qVar) {
        this.f8054c.remove(qVar);
    }
}
