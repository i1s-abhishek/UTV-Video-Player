package classesdef.browser;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import classesdef.inplayer.awt;

/* renamed from: boq */
public class boq {

    /* renamed from: a */
    private static boq f16076a;

    private boq() {
    }

    /* renamed from: a */
    public static synchronized boq m18382a() {
        boq boq;
        synchronized (boq.class) {
            if (f16076a == null) {
                f16076a = new boq();
            }
            boq = f16076a;
        }
        return boq;
    }

    /* renamed from: a */
    public void mo23296a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + str));
            intent.setFlags(268435456);
            if (awt.m7202a(context, "com.android.vending")) {
                intent.setPackage("com.android.vending");
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
