package classesdef.browser;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import classesdef.xdplayer.ServerConfigSharedPrefrence;

public class bqq {

    private static String f16445a = "";

    private static String f16446b = "";

    private static ArrayList<String> f16447c = new ArrayList<>();

    private static int f16448d;

    private static int f16449e;


    private static int f16450f;

    private static int f16451g;

    private static String f16452h;

    private static int f16725i;

    /* renamed from: j */
    private static String f16726j;

    /* renamed from: k */
    private static int f16727k;

    /* renamed from: l */
    private static String f16728l;

    /* renamed from: m */
    private static String f16729m;

    public static boolean m18971a(Context context, String str) {
        return m18972a(context, str, m18977d(context));
    }

    /* renamed from: b */
    public static boolean m18974b(Context context, String str) {
        return m18972a(context, str, m18975c(context));
    }

    /* renamed from: a */
    private static boolean m18972a(Context context, String str, String str2) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        JSONArray jSONArray = new JSONArray(str2);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string) && str.toLowerCase().contains(string)) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                bbc.m15886a().mo21879a(context, (Throwable) e);
                return false;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static String m18975c(Context context) {
        try {
            if (TextUtils.isEmpty(f16445a)) {
                String k = ServerConfigSharedPrefrence.m19732k(context);
                if (!TextUtils.isEmpty(k)) {
                    JSONObject jSONObject = new JSONObject(k);
                    if (jSONObject.has("exclude_manual_list")) {
                        f16445a = jSONObject.optString("exclude_manual_list", "");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
        }
        return f16445a;
    }

    /* renamed from: d */
    private static String m18977d(Context context) {
        try {
            if (TextUtils.isEmpty(f16446b)) {
                String k = ServerConfigSharedPrefrence.m19732k(context);
                if (!TextUtils.isEmpty(k)) {
                    JSONObject jSONObject = new JSONObject(k);
                    if (jSONObject.has("exclude_auto_list")) {
                        f16446b = jSONObject.optString("exclude_auto_list", "");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
        }
        return f16446b;
    }

    /* renamed from: c */
    public static boolean m18976c(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (f16447c == null) {
                        f16447c = new ArrayList<>();
                    }
                    if (f16447c.size() == 0) {
                        String k = ServerConfigSharedPrefrence.m19732k(context);
                        if (!TextUtils.isEmpty(k)) {
                            JSONObject jSONObject = new JSONObject(k);
                            if (jSONObject.has("exclude_download_link")) {
                                JSONArray jSONArray = new JSONArray(jSONObject.getString("exclude_download_link"));
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    f16447c.add(jSONArray.getString(i));
                                }
                            }
                        }
                    }
                    if (f16447c.size() == 0) {
                        f16447c.add("xx.fbcdn.net/rsrc.php");
                    }
                    Iterator<String> it = f16447c.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && str.toLowerCase().contains(next.toLowerCase())) {
                            return true;
                        }
                    }
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                bbc.m15886a().mo21879a(context, (Throwable) e);
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static int m18970a(Context context) {
        if (f16451g == 0) {
            try {
                String k = ServerConfigSharedPrefrence.m19732k(context);
                if (!TextUtils.isEmpty(k)) {
                    JSONObject jSONObject = new JSONObject(k);
                    if (jSONObject.has("download_thread_number")) {
                        f16451g = jSONObject.optInt("download_thread_number", 2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                bbc.m15886a().mo21879a(context, (Throwable) e);
            }
        }
        if (f16451g <= 0) {
            f16451g = 2;
        }
        return f16451g;
    }

    /* renamed from: b */
    public static String m18973b(Context context) {
        if (f16452h == null) {
            String k = ServerConfigSharedPrefrence.m19732k(context);
            if (!TextUtils.isEmpty(k)) {
                try {
                    JSONObject jSONObject = new JSONObject(k);
                    if (jSONObject.has("user_agent")) {
                        f16452h = jSONObject.optString("user_agent", "");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(f16452h)) {
            f16452h = "";
        }
        return f16452h;
    }
    /* renamed from: c */
    public static boolean m21726c(Context context) {
        if (f16725i == 0) {
            String k = ServerConfigSharedPrefrence.m19732k(context);
            if (!TextUtils.isEmpty(k)) {
                try {
                    JSONObject jSONObject = new JSONObject(k);
                    if (jSONObject.has("enable_method_13")) {
                        f16725i = jSONObject.optBoolean("enable_method_13") ? 1 : -1;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (f16725i == 0) {
                f16725i = 1;
            }
        }
        if (f16725i == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public static String m21728d(Context context) {
        if (f16726j == null) {
            String k = ServerConfigSharedPrefrence.m19732k(context);
            if (!TextUtils.isEmpty(k)) {
                try {
                    f16726j = new JSONObject(k).optString("method_14", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(f16726j)) {
            f16726j = BrowserData.m21107p(context);
        }
        return f16726j;
    }

    /* renamed from: e */
    public static boolean m21730e(Context context) {
        if (f16727k == 0) {
            String k = ServerConfigSharedPrefrence.m19732k(context);
            if (!TextUtils.isEmpty(k)) {
                try {
                    JSONObject jSONObject = new JSONObject(k);
                    if (jSONObject.has("enable_method_15")) {
                        f16727k = jSONObject.optBoolean("enable_method_15") ? 1 : -1;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (f16727k == 0) {
                f16727k = 1;
            }
        }
        if (f16727k == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public static String m21731f(Context context) {
        if (f16728l == null) {
            String k = ServerConfigSharedPrefrence.m19732k(context);
            if (!TextUtils.isEmpty(k)) {
                try {
                    f16728l = new JSONObject(k).optString("method_16", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(f16728l)) {
            f16728l = BrowserData.m21109r(context);
        }
        return f16728l;
    }

    /* renamed from: d */
    private static String m21729d(Context context, String str) {
        String str2 = "";
        if (context != null) {
            String k = ServerConfigSharedPrefrence.m19732k(context);
            if (!TextUtils.isEmpty(k)) {
                try {
                    JSONObject jSONObject = new JSONObject(k);
                    if (jSONObject.has(str)) {
                        str2 = jSONObject.optString(str, "");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return TextUtils.isEmpty(str2) ? m21721a() : str2;
    }

    /* renamed from: g */
    public static String m21732g(Context context) {
        return m21729d(context, "method_4");
    }

    /* renamed from: h */
    public static String m21733h(Context context) {
        return m21729d(context, "method_8");
    }

    /* renamed from: i */
    public static String m21734i(Context context) {
        return m21729d(context, "method_52");
    }

    /* renamed from: a */
    private static String m21721a() {
        if (f16729m == null) {
            f16729m = "Mozilla/5.0 (Linux; U; Android 6.0.1; en-us; Nexus 4 Build/JOP24G) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Chrome/47.0.2526.27 Mobile Safari/534.30";
            if (!TextUtils.isEmpty(Build.MODEL)) {
                f16729m = f16729m.replace("Nexus 4", Build.MODEL);
            }
        }
        return f16729m;
    }
}
