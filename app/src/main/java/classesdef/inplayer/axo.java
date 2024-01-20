package classesdef.inplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* renamed from: axo */
public final class axo {

    /* renamed from: a */
    private static axo f6299a;

    /* renamed from: b */
    private static SharedPreferences f6300b;

    public axo(Context context) {
        f6300b = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /* renamed from: a */
    public static final axo m7399a(Context context) {
        if (f6299a == null) {
            f6299a = new axo(context.getApplicationContext());
        }
        return f6299a;
    }

    /* renamed from: a */
    public SharedPreferences mo10987a() {
        return f6300b;
    }
}
