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

/* renamed from: ht */
public class C4299ht extends C4297hr {

    /* renamed from: c */
    private final C1453c f16893c;

    /* renamed from: d */
    private final Point f16894d;

    /* renamed from: e */
    private final float f16895e;

    /* renamed from: f */
    private float f16896f;

    /* renamed from: g */
    private float f16897g;

    /* renamed from: h */
    private Bitmap f16898h;

    /* renamed from: i */
    private int f16899i = 0;

    /* renamed from: j */
    private Matrix f16900j;

    /* renamed from: k */
    private Context f16901k;

    /* renamed from: l */
    private C1451a f16902l;

    /* renamed from: m */
    private Rect f16903m;

    C4299ht(C1453c cVar, C1451a aVar, Point point, float f, float f2, Rect rect, Context context) {
        this.f16893c = cVar;
        this.f16894d = point;
        this.f16896f = f;
        this.f16895e = f2;
        this.f16901k = context;
        this.f16902l = aVar;
        this.f16903m = rect;
        m19754b();
    }

    /* renamed from: a */
    public static C4299ht m19750a(C1451a aVar, Rect rect, Context context) {
        C1453c cVar = new C1453c();
        return new C4299ht(cVar, aVar, new Point(cVar.mo11397a(rect.width()), cVar.mo11397a(rect.height())), (((cVar.mo11395a(25.0f) / 25.0f) * 0.1f) + 1.5707964f) - 0.05f, (float) (DisplayMatrix.getdisplayDensity(context, cVar.mo11396a(2.0f, 4.0f)) / 2), rect, context);
    }

    /* renamed from: a */
    private void m19752a(int i) {
        this.f16894d.x = this.f16893c.mo11397a(i);
        this.f16894d.y = -1;
        this.f16896f = (((this.f16893c.mo11395a(25.0f) / 25.0f) * 0.1f) + 1.5707964f) - 0.05f;
    }

    /* renamed from: a */
    private void m19751a() {
        this.f16896f += this.f16893c.mo11396a(-25.0f, 25.0f) / 10000.0f;
        this.f16894d.set((int) (((double) this.f16894d.x) + (((double) this.f16895e) * Math.cos((double) this.f16896f)) + ((double) this.f16897g)), (int) (((double) this.f16894d.y) + (((double) this.f16895e) * 2.0d * Math.sin((double) this.f16896f))));
        if (!m19753a(this.f16903m.width(), this.f16903m.height())) {
            m19752a(this.f16903m.width());
        }
    }

    /* renamed from: b */
    private void m19754b() {
        this.f16900j = new Matrix();
        this.f16898h = this.f16902l.mo11391a((int) this.f16893c.mo11396a(0.0f, (float) this.f16902l.mo11390a()));
        this.f16897g = this.f16893c.mo11396a(0.0f, 10.0f) / 10.0f;
    }

    /* renamed from: a */
    private boolean m19753a(int i, int i2) {
        int i3 = this.f16894d.x;
        int i4 = this.f16894d.y;
        return i3 >= -1 && i3 <= i && i4 >= -1 && i4 < i2;
    }

    /* renamed from: a */
    public void mo17844a(Canvas canvas, Paint paint) {
        if (this.f16898h == null) {
            m19754b();
        }
        canvas.drawBitmap(this.f16898h, this.f16900j, paint);
    }

    /* renamed from: a */
    public void mo17843a(float f) {
        m19751a();
        this.f16899i++;
        this.f16900j.reset();
        this.f16900j.postRotate((float) this.f16899i);
        this.f16900j.postTranslate((float) this.f16894d.x, (float) this.f16894d.y);
    }
}
