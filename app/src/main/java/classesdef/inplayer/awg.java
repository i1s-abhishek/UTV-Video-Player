package classesdef.inplayer;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: awg */
public final class awg {

    /* renamed from: a */
    private static int f6077a;

    /* renamed from: b */
    private static boolean f6078b;

    /* renamed from: c */
    private static boolean f6079c;

    /* renamed from: d */
    private static awb f6080d;

    /* renamed from: a */
    public static void m7137a(Context context) {
        f6077a = axo.m7399a(context).mo10987a().getInt("aux_reverb_preset", 0);
    }

    /* renamed from: b */
    public static void m7140b(Context context) {
        SharedPreferences.Editor edit = axo.m7399a(context).mo10987a().edit();
        edit.putInt("aux_reverb_preset", f6077a);
        edit.putBoolean("aux_reverb_enable", f6078b);
        edit.apply();
    }

    /* renamed from: a */
    public static void m7136a(int i) {
        m7139b(i);
        m7135a();
    }

    /* renamed from: b */
    public static void m7139b(int i) {
        if (f6080d != null) {
            m7135a();
        }
        try {
            f6080d = new awb(i);
            f6079c = true;
        } catch (Throwable unused) {
            m7135a();
            f6079c = false;
        }
    }

    /* renamed from: a */
    public static void m7135a() {
        if (f6080d != null) {
            try {
                f6080d.mo10851b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f6080d = null;
        }
    }

    /* renamed from: b */
    public static boolean m7141b() {
        return f6079c;
    }

    /* renamed from: c */
    public static boolean m7143c() {
        return f6078b;
    }

    /* renamed from: d */
    public static int m7144d() {
        return f6077a;
    }

    /* renamed from: c */
    public static void m7142c(int i) {
        f6077a = i;
    }

    /* renamed from: a */
    public static void m7138a(boolean z) {
        f6078b = z;
        if (f6080d != null) {
            if (!z) {
                try {
                    f6080d.mo10848a(false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                m7145e();
                f6080d.mo10848a(true);
            }
            f6078b = f6080d.mo10850a();
        }
    }

    /* renamed from: e */
    public static void m7145e() {
        if (f6080d != null) {
            try {
                f6080d.mo10849a((short) f6077a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
