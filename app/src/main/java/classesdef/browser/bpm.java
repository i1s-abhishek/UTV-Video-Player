package classesdef.browser;

import android.os.Build;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* renamed from: bpm */
public class bpm implements Interpolator {

    /* renamed from: a */
    private static final Interpolator f16281a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f16281a = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        } else {
            f16281a = new DecelerateInterpolator();
        }
    }

    public float getInterpolation(float f) {
        return f16281a.getInterpolation(f);
    }
}
