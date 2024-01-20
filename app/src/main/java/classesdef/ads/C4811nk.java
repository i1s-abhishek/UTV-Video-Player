package classesdef.ads;

import android.content.Context;
import android.widget.FrameLayout;

/* renamed from: nk */
public class C4811nk {
    /* renamed from: a */
    private static int m23795a(Context context, float f) {
        return DisplayMatrix.getdisplayDensity(context, f);
    }

    /* renamed from: b */
    private static int m23797b(Context context, float f) {
        if (f >= 0.0f) {
            f = (float) m23795a(context, f);
        }
        return (int) f;
    }

    /* renamed from: a */
    public static FrameLayout.LayoutParams m23796a(Context context, int i, float f) {
        return new FrameLayout.LayoutParams(m23797b(context, (float) i), m23797b(context, f));
    }
}
