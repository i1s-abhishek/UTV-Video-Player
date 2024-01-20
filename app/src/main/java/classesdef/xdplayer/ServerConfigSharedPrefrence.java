package classesdef.xdplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.mopub.common.privacy.ConsentStatus;

import org.json.JSONArray;
import org.json.JSONObject;


public class ServerConfigSharedPrefrence {

    public static SharedPreferences getSharedPrefrenceServerConfig(Context context) {
        try {
            return context.getSharedPreferences("ServerConfig", 0);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return context.getSharedPreferences("ServerConfig", 0);
        }
    }


    public static void m19709a(Context context, String str) {
        if (!str.equals("")) {
            getSharedPrefrenceServerConfig(context).edit().putString("server_url", str).apply();
        }
    }


    public static String m19711b(Context context) {
        return getSharedPrefrenceServerConfig(context).getString("server_url", "");
    }


    public static void m19713b(Context context, String str) {
        if (!str.equals("")) {
            getSharedPrefrenceServerConfig(context).edit().putString("image_save_path", str).apply();
        }
    }


    public static String m19715c(Context context) {
        return getSharedPrefrenceServerConfig(context).getString("image_save_path", "");
    }


    public static void m19717c(Context context, String str) {
        if (!str.equals("")) {
            getSharedPrefrenceServerConfig(context).edit().putString("imgadCode", str).apply();
        }
    }


    public static String m19718d(Context context) {
        return getSharedPrefrenceServerConfig(context).getString("imgadCode", "");
    }


    public static void m19720d(Context context, String str) {
        if (!str.equals("")) {
            getSharedPrefrenceServerConfig(context).edit().putString("textadCode", str).apply();
        }
    }


    public static void m19722e(Context context, String str) {
        if (!str.equals("")) {
            getSharedPrefrenceServerConfig(context).edit().putString("exitadCode", str).apply();
        }
    }


    public static String m19721e(Context context) {
        return getSharedPrefrenceServerConfig(context).getString("exitadCode", "");
    }


    public static void m19724f(Context context, String str) {
        if (!str.equals("")) {
            getSharedPrefrenceServerConfig(context).edit().putString("moreappCode", str).apply();
        }
    }


    public static void m19726g(Context context, String str) {
        if (!str.equals("")) {
            getSharedPrefrenceServerConfig(context).edit().putString("updateinfoCode", str).apply();
        }
    }


    public static void m19708a(Context context, int i) {
        getSharedPrefrenceServerConfig(context).edit().putInt("show", i).apply();
    }
    public static void m19712b(Context context, int i) {
        getSharedPrefrenceServerConfig(context).edit().putInt("version", i).apply();
    }


    public static int m19723f(Context context) {
        return getSharedPrefrenceServerConfig(context).getInt("version", 0);
    }
    public static void m19716c(Context context, int i) {
        getSharedPrefrenceServerConfig(context).edit().putInt("update_interval", i).apply();
    }


    public static int m19725g(Context context) {
        return getSharedPrefrenceServerConfig(context).getInt("update_interval", 5);
    }


    public static void m19727h(Context context) {
        getSharedPrefrenceServerConfig(context).edit().putLong("last_post_time", System.currentTimeMillis()).apply();
    }


    public static long m19729i(Context context) {
        return getSharedPrefrenceServerConfig(context).getLong("last_post_time", 0) + (((long) m19725g(context)) * 86400000);
    }


    public static void m19719d(Context context, int i) {
        getSharedPrefrenceServerConfig(context).edit().putInt("ad_type", i).apply();
    }


    public static void PutSelfAds(Context context, String str) {
        getSharedPrefrenceServerConfig(context).edit().putString("self_ads", str).apply();
    }


    public static String GetSelfAds(Context context) {
        return getSharedPrefrenceServerConfig(context).getString("self_ads", "");
    }


    public static void m19730i(Context context, String str) {
        getSharedPrefrenceServerConfig(context).edit().putString("extends_data", str).apply();
    }


    public static String m19732k(Context context) {
        return getSharedPrefrenceServerConfig(context).getString("extends_data", "");
    }


    public static String m19733l(Context context) {
        String k = m19732k(context);
        if (k.equals("")) {
            return "";
        }
        try {
            return new JSONObject(k).getJSONObject("interstitialad").toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static void m19710a(Context context, String str, int i) {
        String string = getSharedPrefrenceServerConfig(context).getString("ad_click_cache", "");
        try {
            if (!string.equals("")) {
                JSONObject jSONObject = new JSONObject(string);
                JSONArray optJSONArray = jSONObject.optJSONArray("" + i);
                JSONArray jSONArray = new JSONArray();
                if (optJSONArray != null) {
                    jSONArray.put(str);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= optJSONArray.length()) {
                            break;
                        } else if (i2 >= 9) {
                            break;
                        } else {
                            int i3 = i2 + 1;
                            jSONArray.put(i3, optJSONArray.get(i2));
                            i2 = i3;
                        }
                    }
                } else {
                    jSONArray.put(str);
                }
                jSONObject.put("" + i, jSONArray);
                getSharedPrefrenceServerConfig(context).edit().putString("ad_click_cache", jSONObject.toString()).apply();
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(str);
            jSONObject2.put("" + i, jSONArray2);
            getSharedPrefrenceServerConfig(context).edit().putString("ad_click_cache", jSONObject2.toString()).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean m19714b(Context context, String str, int i) {
        String string = getSharedPrefrenceServerConfig(context).getString("ad_click_cache", "");
        if (!string.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                JSONArray optJSONArray = jSONObject.optJSONArray("" + i);
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        if (optJSONArray.get(i2).equals(str)) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void m23680e(Context context, int i) {
        getSharedPrefrenceServerConfig(context).edit().putInt("check_gdpr", i).apply();
    }

    /* renamed from: m */
    public static int m23693m(Context context) {
        return getSharedPrefrenceServerConfig(context).getInt("check_gdpr", -1);
    }

    public static void m23666a(Context context, ConsentStatus consentStatus) {
        getSharedPrefrenceServerConfig(context).edit().putString("gdpr_status", consentStatus.name()).apply();
    }
    /* renamed from: o */
    public static ConsentStatus m19736o(Context context) {
        return ConsentStatus.fromString(getSharedPrefrenceServerConfig(context).getString("gdpr_status", ConsentStatus.UNKNOWN.name()));
    }
}
