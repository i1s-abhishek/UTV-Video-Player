package classesdef.browser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

/* renamed from: bcj */
public class bcj {
    @Deprecated
    /* renamed from: a */
    public static boolean m15980a(Context context) {
        return bck.m15985a(context) != -1;
    }

    /* renamed from: b */
    public static boolean m15982b(Context context) {
        return m15981a(context, "org.torproject.android");
    }

    /* renamed from: a */
    private static boolean m15981a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m15983c(Context context) {
        if (!m15982b(context)) {
            return false;
        }
        Log.i("OrbotHelper", "requestStartTor " + context.getPackageName());
        context.sendBroadcast(m15984d(context));
        return true;
    }

    /* renamed from: d */
    public static Intent m15984d(Context context) {
        Intent intent = new Intent("org.torproject.android.intent.action.START");
        intent.setPackage("org.torproject.android");
        intent.putExtra("org.torproject.android.intent.extra.PACKAGE_NAME", context.getPackageName());
        return intent;
    }
}
