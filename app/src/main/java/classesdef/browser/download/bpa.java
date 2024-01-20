package classesdef.browser.download;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;

import com.orhanobut.logger.Logger;

import java.util.HashMap;

/* renamed from: bpa */
public class bpa {

    /* renamed from: a */
    private static HashMap<String, bpi> f16129a;

    /* renamed from: a */
    private static void m18483a() {
        if (f16129a == null) {
            f16129a = new HashMap<>(3);
        }
    }

    /* renamed from: a */
    public static void m18485a(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            m18483a();
            bpi bpi = f16129a.get(str);
            if (bpi == null) {
                f16129a.put(str, new bpi(System.currentTimeMillis(), j));
            } else if (System.currentTimeMillis() - bpi.mo23364a() > 6000) {
                bpi.mo23365a(System.currentTimeMillis());
                bpi.mo23367b(j);
            }
        }
    }

    /* renamed from: b */
    public static long m18486b(String str, long j) {
        long j2 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        m18483a();
        bpi bpi = f16129a.get(str);
        if (bpi == null) {
            return 0;
        }
        if (bpi.mo23364a() != 0) {
            long currentTimeMillis = System.currentTimeMillis() - bpi.mo23364a();
            if (currentTimeMillis != 0) {
                j2 = (long) (((((double) (j - bpi.mo23366b())) * 1.0d) / ((double) currentTimeMillis)) + 0.5d);
            }
        }
        long j3 = j2 * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        Logger.e("speedValue = " + j3, new Object[0]);
        return j3;
    }

    /* renamed from: a */
    public static void m18484a(String str) {
        if (f16129a != null && !TextUtils.isEmpty(str)) {
            f16129a.remove(str);
        }
    }

    /* renamed from: b */
    public static boolean m18487b(String str) {
        return !TextUtils.isEmpty(str) && f16129a != null && f16129a.containsKey(str);
    }
}
