package classesdef.ads;

import android.content.Context;
import android.graphics.Rect;

import com.cc.promote.effects.C1451a;

/* renamed from: mr */
public class C4782mr implements C4294ho {

    /* renamed from: a */
    private C1451a f17933a;

    /* renamed from: b */
    private Context f17934b;

    public C4782mr(Context context, C1451a aVar) {
        this.f17933a = aVar;
        this.f17934b = context.getApplicationContext();
    }

    /* renamed from: a */
    public C4297hr[] mo17845a(Rect rect) {
        C4297hr[] msVarArr = new C4297hr[25];
        for (int i = 0; i < msVarArr.length; i++) {
            msVarArr[i] = C4299ht.m19750a(this.f17933a, rect, this.f17934b);
        }
        return msVarArr;
    }
}
