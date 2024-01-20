package classesdef.database;

import android.content.Context;
import android.text.TextUtils;

import com.orhanobut.logger.Logger;

import classesdef.browser.bbc;
import classesdef.browser.bpc;

/* renamed from: boh */
public class boh {

    /* renamed from: a */
    private static boh f16056a;

    /* renamed from: b */
    private final String f16057b = "porntube.com";

    private boh() {
    }

    /* renamed from: a */
    public static boh m18304a() {
        if (f16056a == null) {
            f16056a = new boh();
        }
        return f16056a;
    }

    /* renamed from: a */
    public boolean mo23263a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (m18313j(context, str, str2) || m18314k(context, str, str2) || m18312i(context, str, str2) || m18307d(context, str, str2) || m18306c(context, str, str2) || m18305b(context, str, str2) || m18308e(context, str, str2) || m18309f(context, str, str2) || m18310g(context, str, str2) || m18311h(context, str, str2)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m18305b(Context context, String str, String str2) {
        try {
            if (!str.toLowerCase().contains("cdn13.com") || !str2.toLowerCase().contains("cdn13.com") || !str.substring(str.indexOf("cdn13.com"), str.lastIndexOf("cdn_creation_time")).equals(str2.substring(str2.indexOf("cdn13.com"), str2.lastIndexOf("cdn_creation_time")))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }

    /* renamed from: c */
    private boolean m18306c(Context context, String str, String str2) {
        try {
            if (!str.toLowerCase().contains("ypncdn.com") || !str2.toLowerCase().contains("ypncdn.com") || !str.substring(str.indexOf("ypncdn.com"), str.lastIndexOf("?")).equals(str2.substring(str2.indexOf("ypncdn.com"), str2.lastIndexOf("?")))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }

    /* renamed from: d */
    private boolean m18307d(Context context, String str, String str2) {
        try {
            if (!str.toLowerCase().contains("phncdn.com") || !str2.toLowerCase().contains("phncdn.com") || !str.substring(str.indexOf("phncdn.com"), str.lastIndexOf("?")).equals(str2.substring(str2.indexOf("phncdn.com"), str2.lastIndexOf("?")))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }

    /* renamed from: e */
    private boolean m18308e(Context context, String str, String str2) {
        try {
            if (!str.toLowerCase().contains("phprcdn.com") || !str2.toLowerCase().contains("phprcdn.com") || !str.substring(str.indexOf("phprcdn.com"), str.lastIndexOf("?")).equals(str2.substring(str2.indexOf("phprcdn.com"), str2.lastIndexOf("?")))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }

    /* renamed from: f */
    private boolean m18309f(Context context, String str, String str2) {
        try {
            if (!str.toLowerCase().contains("dailymotion.com") || !str2.toLowerCase().contains("dailymotion.com") || !str.substring(str.indexOf("dailymotion.com"), str.lastIndexOf("?")).equals(str2.substring(str2.indexOf("dailymotion.com"), str2.lastIndexOf("?")))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }

    /* renamed from: g */
    private boolean m18310g(Context context, String str, String str2) {
        try {
            if (!str.toLowerCase().contains("vimeo.akamaized.net") || !str2.toLowerCase().contains("vimeo.akamaized.net") || !str.substring(str.lastIndexOf("vimeo-prod-skyfire-std-us")).equals(str2.substring(str2.lastIndexOf("vimeo-prod-skyfire-std-us")))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }

    /* renamed from: h */
    private boolean m18311h(Context context, String str, String str2) {
        try {
            if (!str.toLowerCase().contains("rdtcdn.com") || !str2.toLowerCase().contains("rdtcdn.com") || !str.substring(str.indexOf("rdtcdn.com"), str.lastIndexOf("?")).equals(str2.substring(str2.indexOf("rdtcdn.com"), str2.lastIndexOf("?")))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }

    /* renamed from: i */
    private boolean m18312i(Context context, String str, String str2) {
        try {
            if (!str.toLowerCase().contains("xvideos.com") || !str2.toLowerCase().contains("xvideos.com") || !str.substring(0, str.lastIndexOf("?")).equals(str2.substring(0, str2.lastIndexOf("?")))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }

    /* renamed from: j */
    private boolean m18313j(Context context, String str, String str2) {
        try {
            if (!str.contains("cdn.vine.co") || !str2.contains("cdn.vine.co")) {
                return false;
            }
            String a = bpc.m18494a(str, "", "");
            String a2 = bpc.m18494a(str2, "", "");
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2) || !a.equals(a2)) {
                return false;
            }
            Logger.e("exist vine file name", new Object[0]);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }

    /* renamed from: k */
    private boolean m18314k(Context context, String str, String str2) {
        try {
            if (!str.contains("porntube.com") || !str.contains("?") || !str2.contains("porntube.com") || !str2.contains("?")) {
                return false;
            }
            String replace = str.replace("porntube.com", "?");
            String substring = replace.substring(replace.indexOf("?"), replace.lastIndexOf("?"));
            String replace2 = str2.replace("porntube.com", "?");
            String substring2 = replace2.substring(replace2.indexOf("?"), replace2.lastIndexOf("?"));
            if (TextUtils.isEmpty(substring) || TextUtils.isEmpty(substring2) || !substring.equals(substring2)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return false;
        }
    }
}
