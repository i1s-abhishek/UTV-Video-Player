package classesdef.inplayer;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefrence {

    public static SharedPreferences getSharedPrefrence(Context context) {
        return context.getSharedPreferences("instashot", 0);
    }


    public static void m7392a(Context context, boolean z) {
        getSharedPrefrence(context).edit().putBoolean("isRated", z).apply();
    }


    public static int language(Context context) {
        return getSharedPrefrence(context).getInt("language", -1);
    }


    public static void setLangusgeType(Context context, int i) {
        getSharedPrefrence(context).edit().putInt("language", i).apply();
    }


    public static void m7394b(Context context, int i) {
        getSharedPrefrence(context).edit().putInt("ShowUpdateDlgVersion", i).apply();
    }


    public static void m7391a(Context context, int i, int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            String str = "equalizer_effect_" + i;
            String str2 = i + ":";
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (i2 == iArr.length - 1) {
                    str2 = str2 + iArr[i2];
                } else {
                    str2 = str2 + iArr[i2] + ",";
                }
            }
            getSharedPrefrence(context).edit().putString(str, str2).apply();
        }
    }


    public static int[] m7396c(Context context, int i) {
        String e = m7398e(context, i);
        if (e == null) {
            return null;
        }
        String[] split = e.split(":");
        if (split.length < 2) {
            return null;
        }
        String[] split2 = split[1].split(",");
        int[] iArr = new int[split2.length];
        for (int i2 = 0; i2 < split2.length; i2++) {
            iArr[i2] = Integer.valueOf(split2[i2]).intValue();
        }
        return iArr;
    }


    private static String m7398e(Context context, int i) {
        return getSharedPrefrence(context).getString("equalizer_effect_" + i, (String) null);
    }


    public static void m7397d(Context context, int i) {
        getSharedPrefrence(context).edit().putInt("equalizer_effect_current", i).apply();
    }


    public static int m7395c(Context context) {
        return getSharedPrefrence(context).getInt("equalizer_effect_current", -1);
    }
}
