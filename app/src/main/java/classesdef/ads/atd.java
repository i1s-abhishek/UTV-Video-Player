package classesdef.ads;

import android.preference.PreferenceManager;

import com.abhishek.xplayer.application.MyApplication;

/* renamed from: atd */
public class atd {
    /* renamed from: a */
    public static void m18387a(String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt(str, i).apply();
    }

    /* renamed from: b */
    public static int m18390b(String str, int i) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt(str, i);
    }

    /* renamed from: a */
    public static void m18389a(String str, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putBoolean(str, z).apply();
    }

    /* renamed from: b */
    public static boolean adRemoved(String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean(str, z);
    }

    /* renamed from: a */
    public static void m18388a(String str, long j) {
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putLong(str, j).apply();
    }

    /* renamed from: b */
    public static long m18391b(String str, long j) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getLong(str, j);
    }

    /* renamed from: a */
    public static float m18386a(String str, float f) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getFloat(str, f);
    }
}
