package classesdef.inplayer;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: awd */
public final class awd {

    /* renamed from: a */
    private static int f6057a;

    /* renamed from: b */
    private static boolean f6058b;

    /* renamed from: c */
    private static boolean f6059c;

    /* renamed from: d */
    private static boolean f6060d;

    /* renamed from: e */
    private static avz f6061e;

    /* renamed from: d */
    public static int m7107d() {
        return 1000;
    }

    /* renamed from: a */
    public static void m7100a(Context context) {
        f6057a = axo.m7399a(context).mo10987a().getInt("aux_bass_strength", 0);
    }

    /* renamed from: b */
    public static void m7103b(Context context) {
        SharedPreferences.Editor edit = axo.m7399a(context).mo10987a().edit();
        edit.putInt("aux_bass_strength", f6057a);
        edit.putBoolean("aux_bass_enable", f6058b);
        edit.apply();
    }

    /* renamed from: a */
    public static void m7099a(int i) {
        m7102b(i);
        m7098a();
    }

    /* renamed from: b */
    public static void m7102b(int i) {
        if (f6061e != null) {
            m7098a();
        }
        try {
            f6061e = new avz(i);
            f6059c = f6061e.mo10827a();
            f6060d = true;
        } catch (Throwable unused) {
            m7098a();
            f6060d = false;
        }
    }

    /* renamed from: a */
    public static void m7098a() {
        if (f6061e != null) {
            try {
                f6061e.mo10830d();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f6061e = null;
        }
    }

    /* renamed from: b */
    public static boolean m7104b() {
        return f6060d;
    }

    /* renamed from: c */
    public static boolean m7106c() {
        return f6058b;
    }

    /* renamed from: e */
    public static int m7108e() {
        return f6057a;
    }

    /* renamed from: c */
    public static void m7105c(int i) {
        if (i > 1000) {
            i = 1000;
        } else if (i < 0) {
            i = 0;
        }
        f6057a = i;
    }

    /* renamed from: a */
    public static void m7101a(boolean z) {
        f6058b = z;
        if (f6061e != null) {
            if (!z) {
                try {
                    f6061e.mo10825a(false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                if (!f6059c) {
                    f6057a = 1000;
                }
                m7109f();
                f6061e.mo10825a(true);
            }
            f6058b = f6061e.mo10829c();
        }
    }

    /* renamed from: f */
    public static void m7109f() {
        if (f6061e != null) {
            try {
                f6061e.mo10826a((short) (f6059c ? f6057a : f6057a == 0 ? 0 : 1000));
                f6057a = f6061e.mo10828b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
