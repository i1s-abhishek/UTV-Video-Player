package classesdef.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.cc.promote.effects.C1451a;
import com.cc.promote.effects.C1453c;

/* renamed from: hs */
public class C4298hs extends C4297hr {

    /* renamed from: c */
    private final C1453c f16882c;

    /* renamed from: d */
    private final Point f16883d;

    /* renamed from: e */
    private float f16884e;

    /* renamed from: f */
    private float f16885f;

    /* renamed from: g */
    private Bitmap f16886g;

    /* renamed from: h */
    private float f16887h = 0.0f;

    /* renamed from: i */
    private int f16888i;

    /* renamed from: j */
    private int f16889j = 0;

    /* renamed from: k */
    private Matrix f16890k;

    /* renamed from: l */
    private C1451a f16891l;

    /* renamed from: m */
    private Rect f16892m;

    C4298hs(C1453c cVar, C1451a aVar, Point point, float f, float f2, Rect rect) {
        this.f16882c = cVar;
        this.f16883d = point;
        this.f16884e = f;
        this.f16885f = f2;
        this.f16888i = point.y;
        this.f16891l = aVar;
        this.f16892m = rect;
        m19747b();
    }

    /* renamed from: a */
    public static C4298hs m19743a(C1451a aVar, Rect rect, Context context) {
        C1453c cVar = new C1453c();
        return new C4298hs(cVar, aVar, new Point((int) ((((double) cVar.mo11397a(rect.width())) * 0.6d) + (((double) rect.width()) * 0.2d)), rect.height()), (((cVar.mo11395a(25.0f) / 25.0f) * 0.1f) + 1.5707964f) - 0.05f, (float) (DisplayMatrix.getdisplayDensity(context, cVar.mo11396a(2.0f, 4.0f)) / 2), rect);
    }

    /* renamed from: a */
    private void m19745a(int i) {
        this.f16883d.x = (int) ((((double) this.f16882c.mo11397a(i)) * 0.6d) + (((double) i) * 0.2d));
        this.f16883d.y = this.f16888i;
        this.f16887h = 0.0f;
        m19747b();
        this.f16884e = (((this.f16882c.mo11395a(25.0f) / 25.0f) * 0.1f) + 1.5707964f) - 0.05f;
    }

    /* renamed from: a */
    private void m19744a() {
        this.f16884e += this.f16882c.mo11396a(-25.0f, 25.0f) / 10000.0f;
        this.f16883d.set((int) (((double) this.f16883d.x) - (((double) this.f16885f) * 0.6d)), (int) (((double) this.f16883d.y) - (((((double) this.f16885f) * Math.sin((double) this.f16884e)) - ((((double) this.f16887h) * 1.5d) * ((double) this.f16887h))) * 1.5d)));
        this.f16887h += 0.02f;
        if (!m19746a(this.f16892m.width(), this.f16892m.height())) {
            m19745a(this.f16892m.width());
        }
    }

    /* renamed from: b */
    private void m19747b() {
        this.f16890k = new Matrix();
        this.f16886g = this.f16891l.mo11391a((int) this.f16882c.mo11396a(0.0f, (float) this.f16891l.mo11390a()));
    }

    /* renamed from: a */
    private boolean m19746a(int i, int i2) {
        int i3 = this.f16883d.x;
        int i4 = this.f16883d.y;
        return i3 >= -1 && i3 <= i && i4 >= -1 && i4 < i2;
    }

    /* renamed from: a */
    public void mo17844a(Canvas canvas, Paint paint) {
        if (this.f16886g == null) {
            m19747b();
        }
        canvas.drawBitmap(this.f16886g, this.f16890k, paint);
    }

    /* renamed from: a */
    public void mo17843a(float f) {
        m19744a();
        this.f16890k.reset();
        this.f16889j--;
        this.f16890k.postRotate((float) this.f16889j);
        this.f16890k.postTranslate((float) this.f16883d.x, (float) this.f16883d.y);
    }
}
