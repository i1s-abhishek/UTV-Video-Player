package classesdef.player;

import android.preference.PreferenceManager;

import com.abhishek.xplayer.application.MyApplication;


public class DefaultSharedPreferences {
    
    public static void m7383a(String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt(str, i).apply();
    }


    public static int m7386b(String str, int i) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt(str, i);
    }


    public static void m7385a(String str, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putBoolean(str, z).apply();
    }


    public static boolean getAdRemoved(String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean(str, z);
    }


    public static void m7384a(String str, long j) {
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putLong(str, j).apply();
    }


    public static long m7387b(String str, long j) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getLong(str, j);
    }
}
