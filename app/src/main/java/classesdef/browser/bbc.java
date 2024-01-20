package classesdef.browser;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/* renamed from: bbc */
public class bbc {

    /* renamed from: a */
    private static bbc f14117a;

    private bbc() {
    }

    /* renamed from: a */
    public static bbc m15886a() {
        if (f14117a == null) {
            f14117a = new bbc();
        }
        return f14117a;
    }

    /* renamed from: a */
    public void mo21878a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Log.e("ad_log", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo21879a(Context context, Throwable th) {
        try {
            th.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
