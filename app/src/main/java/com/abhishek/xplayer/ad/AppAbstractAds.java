package com.abhishek.xplayer.ad;

import android.content.Context;

import com.abhishek.xplayer.application.MyApplication;

import classesdef.ads.atd;


public abstract class AppAbstractAds<T extends AdInterface2> implements AppAbstractInterface<T> {


    protected T f7944a;


    public int f7945b = 0;


    private final Runnable runnable = new Runnable() {
        public void run() {
            if (AppAbstractAds.this.f7944a != null && !AppAbstractAds.this.f7944a.mo16905d()) {
                if (AppAbstractAds.this.f7945b >= 3) {
                    AppAbstractAds.this.f7944a.destroyad();
                    return;
                }
                AppAbstractAds.m10202b(AppAbstractAds.this);
                T t = AppAbstractAds.this.f7944a;
                AppAbstractAds.this.f7944a = null;
                t.destroyad();
                AppAbstractAds.this.mo16926b();
            }
        }
    };

    public abstract T mo16909a(Context context, AppAbstractInterface<T> qVar);

    public abstract String mo16910a();


    static int m10202b(AppAbstractAds dVar) {
        int i = dVar.f7945b;
        dVar.f7945b = i + 1;
        return i;
    }


    public boolean mo16926b() {
        if (atd.adRemoved("adRemoved", false)) {
            return false;
        }
        m10203e();
        if (this.f7944a != null) {
            return true;
        }
        MyApplication.myApplication().mo17871b(this.runnable);
        MyApplication.myApplication().runnableDelay(this.runnable, 120000);
        this.f7944a = mo16909a(MyApplication.getApplicationContext_(), this);
        this.f7944a.startLoadAd();
        return true;
    }


    public T mo16927c() {
        m10203e();
        return this.f7944a;
    }


    public boolean mo16917d() {
        AdInterface2 c = mo16927c();
        return c != null && c.mo16905d();
    }


    private void m10203e() {
        T t = this.f7944a;
        if (t != null && t.mo16906e()) {
            T t2 = this.f7944a;
            this.f7944a = null;
            t2.destroyad();
        }
    }


    public void mo16928c(T t) {
        if (t == this.f7944a) {
            this.f7944a = null;
        }
    }


    public void mo16929d(T t) {
        if (t == this.f7944a) {
            this.f7944a = null;
        }
    }


    public void mo16863b(T t) {
        if (t == this.f7944a) {
            this.f7945b = 0;
            MyApplication.myApplication().mo17871b(this.runnable);
        }
    }


    public void mo16860a(T t) {
        if (this.f7945b < 3) {
            MyApplication.myApplication().mo17871b(this.runnable);
            MyApplication.myApplication().runnableDelay(this.runnable, 10000);
        }
    }
}
