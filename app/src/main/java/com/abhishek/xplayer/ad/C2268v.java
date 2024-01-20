package com.abhishek.xplayer.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

import com.cc.promote.effects.C1451a;
import com.cc.promote.effects.C1453c;
import classesdef.ads.C4297hr;

import classesdef.ads.DisplayMatrix;

/* renamed from: com.inshot.xplayer.ad.v */
class C2268v extends C4297hr {

    /* renamed from: c */
    private float f8055c;

    /* renamed from: d */
    private float f8056d;

    /* renamed from: e */
    private float f8057e;

    /* renamed from: f */
    private float f8058f;

    /* renamed from: g */
    private Rect f8059g;

    /* renamed from: h */
    private C1451a f8060h;

    /* renamed from: i */
    private C1453c f8061i;

    /* renamed from: j */
    private Context f8062j;

    /* renamed from: k */
    private Bitmap f8063k;

    /* renamed from: l */
    private Matrix f8064l;

    /* renamed from: m */
    private int f8065m;

    private C2268v(Context context, PointF pointF, float f, float f2, float f3, float f4, Rect rect, C1453c cVar, C1451a aVar) {
        this.f8062j = context;
        this.f16880a = pointF;
        this.f16881b = new PointF(pointF.x, pointF.y);
        this.f8056d = f2;
        this.f8057e = f3;
        this.f8058f = f4;
        this.f8059g = rect;
        this.f8061i = cVar;
        this.f8060h = aVar;
        this.f8065m = cVar.mo11397a(360);
        m10427a();
    }

    /* renamed from: a */
    public static C2268v m10426a(Context context, C1451a aVar, Rect rect) {
        C1453c cVar = new C1453c();
        return new C2268v(context, new PointF(-cVar.mo11396a(-20.0f, 5.0f), cVar.mo11396a(((float) rect.height()) / 3.0f, ((float) rect.height()) * 0.8f)), (float) DisplayMatrix.getdisplayDensity(context, cVar.mo11396a(2.5f, 4.0f)), cVar.mo11396a(0.0f, ((float) rect.height()) / 3.0f), (float) DisplayMatrix.getdisplayDensity(context, cVar.mo11396a(1.0f, 2.0f)), ((float) (-DisplayMatrix.getdisplayDensity(context, cVar.mo11396a(0.2f, 0.4f)))) * 0.5f, rect, cVar, aVar);
    }

    /* renamed from: a */
    private void m10427a() {
        this.f8064l = new Matrix();
        this.f8063k = this.f8060h.mo11391a((int) this.f8061i.mo11396a(0.0f, (float) this.f8060h.mo11390a()));
    }

    /* renamed from: b */
    private void m10429b() {
        this.f16880a.x = -this.f8061i.mo11396a(-20.0f, 5.0f);
        this.f16880a.y = this.f8061i.mo11396a(((float) this.f8059g.height()) * 0.3f, ((float) this.f8059g.height()) * 0.8f);
        this.f16881b.x = this.f16880a.x;
        this.f16881b.y = this.f16880a.y;
        this.f8055c = (float) DisplayMatrix.getdisplayDensity(this.f8062j, this.f8061i.mo11396a(2.5f, 4.0f));
        this.f8056d = (float) DisplayMatrix.getdisplayDensity(this.f8062j, this.f8061i.mo11396a(1.25f, 2.25f));
        this.f8057e = (float) (-DisplayMatrix.getdisplayDensity(this.f8062j, this.f8061i.mo11396a(1.0f, 2.0f)));
        this.f8058f = ((float) (-DisplayMatrix.getdisplayDensity(this.f8062j, this.f8061i.mo11396a(0.2f, 0.4f)))) * 0.5f;
        this.f8065m = this.f8061i.mo11397a(360);
        m10427a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo17844a(Canvas canvas, Paint paint) {
        if (this.f8063k == null) {
            m10427a();
        }
        canvas.drawBitmap(this.f8063k, this.f8064l, paint);
    }

    /* renamed from: a */
    private boolean m10428a(int i, int i2) {
        float f = this.f16881b.x;
        float f2 = this.f16881b.y;
        return f >= -1.0f && f <= ((float) i) && f2 >= -1.0f && f2 < ((float) i2);
    }

    /* renamed from: a */
    public void mo17843a(float f) {
        if (!m10428a(this.f8059g.width(), this.f8059g.height())) {
            m10429b();
        }
        this.f16881b.x += this.f8055c;
        this.f8065m = (this.f8065m + ((int) this.f8061i.mo11396a(1.0f, 3.0f))) % 360;
        this.f8057e += this.f8058f;
        this.f16881b.y += this.f8056d + this.f8057e;
        this.f8064l.reset();
        this.f8064l.postRotate((float) this.f8065m, (float) (this.f8063k.getWidth() / 2), (float) (this.f8063k.getHeight() / 2));
        this.f8064l.postScale(1.5f, 1.5f);
        this.f8064l.postTranslate(this.f16881b.x, this.f16881b.y);
    }
}
