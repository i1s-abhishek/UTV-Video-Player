package com.abhishek.xplayer.service;

import android.content.Context;
import android.content.Intent;

import classesdef.inplayer.awt;


/* renamed from: com.inshot.xplayer.service.d */
public class StartPipPlayService {

    /* renamed from: a */
    private static StartPipPlayService f11138a;

    /* renamed from: b */
    private PipPlayControl f11139b;

    /* renamed from: c */
    private C2787b f11140c;

    /* renamed from: a */
    public static StartPipPlayService m12716a() {
        if (f11138a == null) {
            synchronized (StartPipPlayService.class) {
                if (f11138a == null) {
                    f11138a = new StartPipPlayService();
                }
            }
        }
        return f11138a;
    }

    /* renamed from: a */
    public void mo18170a(Context context, C2787b bVar) {
        this.f11140c = bVar;
        awt.m7197a(context, new Intent(context, PipPlayerService.class));
        //ayc.m7501a("StartService:Pip");
    }

    /* renamed from: b */
    public C2787b mo18172b() {
        return this.f11140c;
    }

    /* renamed from: c */
    public void mo18173c() {
        this.f11140c = null;
    }

    /* renamed from: a */
    public void mo18171a(PipPlayControl cVar) {
        this.f11139b = cVar;
    }

    /* renamed from: d */
    public void mo18174d() {
        if (this.f11139b != null) {
            this.f11139b.mo18154a();
            this.f11139b.mo18156b();
        }
    }
}
