package classesdef.browser;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* renamed from: bok */
public class bok {

    /* renamed from: a */
    private static final String[] f16065a = {"301", "302", "400", "401", "403", "404", "405", "410", "412", "503"};

    /* renamed from: a */
    public static int m18338a(Context context, String str) {
        String d = m18345d(context, str);
        if (!TextUtils.isEmpty(d)) {
            if (d.contains("The file is too large to store")) {
                return 2;
            }
            if (d.contains("Unable to resolve host")) {
                return 1;
            }
            if (d.contains("Only allows downloading this task on the wifi network type")) {
                return 4;
            }
            if (m18341a(d)) {
                return 5;
            }
        }
        return 3;
    }

    /* renamed from: b */
    public static boolean m18343b(Context context, String str) {
        try {
            String d = m18345d(context, str);
            if (TextUtils.isEmpty(d) || TextUtils.isEmpty("Connection refused")) {
                return false;
            }
            if (!d.contains("Connection refused")) {
                String[] strArr = f16065a;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str2 = strArr[i];
                    if (!d.startsWith("response code error: " + str2)) {
                        i++;
                    }
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            //bor.m18385a().mo23297a((Throwable) e);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m18341a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String contains : f16065a) {
                if (str.contains(contains)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            //bor.m18385a().mo23297a((Throwable) e);
            return false;
        }
    }

    /* renamed from: b */
    private static SharedPreferences m18342b(Context context) {
        return context.getSharedPreferences("error_msg", 0);
    }

    /* renamed from: a */
    public static void m18339a(Context context) {
        m18342b(context).edit().clear().commit();
    }

    /* renamed from: a */
    public static void m18340a(Context context, String str, String str2) {
        SharedPreferences b;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (b = m18342b(context)) != null) {
            b.edit().putString(str, str2).commit();
        }
    }

    /* renamed from: c */
    public static void m18344c(Context context, String str) {
        SharedPreferences b;
        if (!TextUtils.isEmpty(str) && (b = m18342b(context)) != null) {
            b.edit().remove(str).apply();
        }
    }

    /* renamed from: d */
    public static String m18345d(Context context, String str) {
        SharedPreferences b;
        if (!TextUtils.isEmpty(str) && (b = m18342b(context)) != null) {
            return b.getString(str, "");
        }
        return "";
    }
}
