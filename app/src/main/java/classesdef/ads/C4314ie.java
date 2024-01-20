package classesdef.ads;

import android.content.Context;
import android.content.pm.PackageInfo;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ie */
public class C4314ie {

    /* renamed from: a */
    private static C4314ie f16940a;

    /* renamed from: b */
    private Map<String, Boolean> f16941b = new HashMap();

    private C4314ie() {
    }

    /* renamed from: a */
    public static synchronized C4314ie m19804a() {
        C4314ie ieVar;
        synchronized (C4314ie.class) {
            if (f16940a == null) {
                f16940a = new C4314ie();
            }
            ieVar = f16940a;
        }
        return ieVar;
    }

    /* renamed from: a */
    public boolean mo23980a(Context context, String str) {
        if (this.f16941b != null && this.f16941b.containsKey(str)) {
            return this.f16941b.get(str).booleanValue();
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
        } catch (Exception unused) {
        } catch (Error e) {
            e.printStackTrace();
        }
        if (packageInfo == null) {
            if (this.f16941b != null) {
                this.f16941b.put(str, false);
            }
            return false;
        }
        if (this.f16941b != null) {
            this.f16941b.put(str, true);
        }
        return true;
    }
}
