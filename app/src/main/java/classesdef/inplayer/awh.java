package classesdef.inplayer;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: awh */
public final class awh {

    /* renamed from: a */
    private static int f6081a;

    /* renamed from: b */
    private static boolean f6082b;

    /* renamed from: c */
    private static boolean f6083c;

    /* renamed from: d */
    private static boolean f6084d;

    /* renamed from: e */
    private static awc f6085e;

    /* renamed from: d */
    public static int m7155d() {
        return 1000;
    }

    /* renamed from: a */
    public static void m7148a(Context context) {
        f6081a = axo.m7399a(context).mo10987a().getInt("aux_virtualizer_strength", 0);
    }

    /* renamed from: b */
    public static void m7151b(Context context) {
        SharedPreferences.Editor edit = axo.m7399a(context).mo10987a().edit();
        edit.putInt("aux_virtualizer_strength", f6081a);
        edit.putBoolean("aux_virtualizer_enable", f6082b);
        edit.apply();
    }

    /* renamed from: a */
    public static void m7147a(int i) {
        m7150b(i);
        m7146a();
    }

    /* renamed from: b */
    public static void m7150b(int i) {
        if (f6085e != null) {
            m7146a();
        }
        try {
            f6085e = new awc(i);
            f6083c = f6085e.mo10854a();
            f6084d = true;
        } catch (Throwable unused) {
            m7146a();
            f6084d = false;
        }
    }

    /* renamed from: a */
    public static void m7146a() {
        if (f6085e != null) {
            try {
                f6085e.mo10857d();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f6085e = null;
        }
    }

    /* renamed from: b */
    public static boolean m7152b() {
        return f6084d;
    }

    /* renamed from: c */
    public static boolean m7154c() {
        return f6082b;
    }

    /* renamed from: e */
    public static int m7156e() {
        return f6081a;
    }

    /* renamed from: c */
    public static void m7153c(int i) {
        if (i > 1000) {
            i = 1000;
        } else if (i < 0) {
            i = 0;
        }
        f6081a = i;
        m7157f();
    }

    /* renamed from: a */
    public static void m7149a(boolean z) {
        f6082b = z;
        if (f6085e != null) {
            if (!z) {
                try {
                    f6085e.mo10852a(false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                if (!f6083c) {
                    f6081a = 1000;
                }
                m7157f();
                f6085e.mo10852a(true);
            }
            f6082b = f6085e.mo10856c();
        }
    }

    /* renamed from: f */
    static void m7157f() {
        if (f6085e != null) {
            try {
                f6085e.mo10853a((short) (f6083c ? f6081a : f6081a == 0 ? 0 : 1000));
                f6081a = f6085e.mo10855b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
