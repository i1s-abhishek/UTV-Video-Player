package classesdef.ads;

import android.content.Context;
import android.graphics.Rect;

import com.cc.promote.effects.C1451a;

/* renamed from: mq */
public class C4781mq implements C4294ho {

    /* renamed from: a */
    private C1451a f17931a;

    /* renamed from: b */
    private Context f17932b;

    public C4781mq(Context context, C1451a aVar) {
        this.f17931a = aVar;
        this.f17932b = context.getApplicationContext();
    }

    /* renamed from: a */
    public C4297hr[] mo17845a(Rect rect) {
        C4297hr[] msVarArr = new C4297hr[8];
        for (int i = 0; i < msVarArr.length; i++) {
            msVarArr[i] =  C4298hs.m19743a(this.f17931a, rect, this.f17932b);
        }
        return msVarArr;
    }
}
