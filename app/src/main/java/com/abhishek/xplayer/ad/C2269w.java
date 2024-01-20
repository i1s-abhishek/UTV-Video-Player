package com.abhishek.xplayer.ad;

import android.content.Context;
import android.graphics.Rect;

import com.cc.promote.effects.C1451a;
import classesdef.ads.C4294ho;
import classesdef.ads.C4297hr;


/* renamed from: com.inshot.xplayer.ad.w */
public class C2269w implements C4294ho {

    /* renamed from: a */
    private C1451a f8066a;

    /* renamed from: b */
    private Context f8067b;

    public C2269w(Context context, C1451a aVar) {
        this.f8066a = aVar;
        this.f8067b = context;
    }

    /* renamed from: a */
    public C4297hr[] mo17845a(Rect rect) {
        C4297hr[] msVarArr = new C4297hr[15];
        for (int i = 0; i < msVarArr.length; i++) {
            msVarArr[i] = C2268v.m10426a(this.f8067b, this.f8066a, rect);
        }
        return msVarArr;
    }
}
