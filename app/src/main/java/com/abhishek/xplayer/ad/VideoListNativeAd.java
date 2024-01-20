package com.abhishek.xplayer.ad;

import android.content.Context;

import java.util.Iterator;
import java.util.LinkedList;


public class VideoListNativeAd extends AppAbstractAds<VideoListNativeAdLoader> {


    private static VideoListNativeAd f7932b;


    private VideoListNativeAdLoader f7933c;


    private LinkedList<AppAbstractInterface<VideoListNativeAdLoader>> f7934d = new LinkedList<>();

    public String mo16910a() {
        return "VideoList";
    }


    public static VideoListNativeAd m10175e() {
        if (f7932b == null) {
            f7932b = new VideoListNativeAd();
        }
        return f7932b;
    }

    private VideoListNativeAd() {
    }

    public VideoListNativeAdLoader mo16909a(Context context, AppAbstractInterface<VideoListNativeAdLoader> qVar) {
        VideoListNativeAdLoader abVar = new VideoListNativeAdLoader(context);
        abVar.mo16901a(qVar);
        return abVar;
    }


    public void mo16863b(VideoListNativeAdLoader abVar) {
        super.mo16863b(abVar);
        VideoListNativeAdLoader abVar2 = this.f7933c;
        if (abVar2 != null) {
            abVar2.mo16904c();
        }
        this.f7933c = abVar;
        Iterator it = this.f7934d.iterator();
        while (it.hasNext()) {
            ((AppAbstractInterface) it.next()).mo16863b(abVar);
        }
    }
    public void mo16860a(VideoListNativeAdLoader abVar) {
        super.mo16860a(abVar);
        Iterator it = this.f7934d.iterator();
        while (it.hasNext()) {
            ((AppAbstractInterface) it.next()).mo16860a(abVar);
        }
    }
    public boolean mo16917d() {
        return super.mo16917d() || this.f7933c != null;
    }


    public VideoListNativeAdLoader mo16918f() {
        VideoListNativeAdLoader abVar = this.f7933c;
        if (abVar != null && abVar.mo16906e()) {
            this.f7933c.mo16904c();
            this.f7933c = null;
        }
        return this.f7933c;
    }


    public void mo16916c(VideoListNativeAdLoader abVar) {
        mo16928c(abVar);
    }


    public void mo16912a(AppAbstractInterface<VideoListNativeAdLoader> qVar) {
        this.f7934d.add(qVar);
    }


    public void mo16915b(AppAbstractInterface<VideoListNativeAdLoader> qVar) {
        this.f7934d.remove(qVar);
    }
}
