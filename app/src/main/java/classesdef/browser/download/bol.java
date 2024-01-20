package classesdef.browser.download;

import android.text.TextUtils;

/* renamed from: bol */
public class bol {

    /* renamed from: a */
    private static bol f16066a;

    /* renamed from: d */
    private String m18348d() {
        return "spotify.com";
    }

    /* renamed from: e */
    private String m18350e() {
        return "youjizz.com/videos/";
    }

    /* renamed from: b */
    public String mo23282b() {
        return "youtube.com";
    }

    /* renamed from: c */
    public String mo23284c() {
        return "soundcloud.com";
    }

    private bol() {
    }

    /* renamed from: a */
    public static bol m18346a() {
        if (f16066a == null) {
            f16066a = new bol();
        }
        return f16066a;
    }

    /* renamed from: a */
    public boolean mo23281a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.toLowerCase().contains(mo23282b()) || str.toLowerCase().contains(mo23284c()) || str.toLowerCase().contains(m18348d()) || str.toLowerCase().contains(m18350e())) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo23283b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (m18347c(str) || m18349d(str) || m18351e(str) || m18352f(str) || m18353g(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m18347c(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(mo23282b());
    }

    /* renamed from: d */
    private boolean m18349d(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("xvideos") && str.toLowerCase().contains("/videopreview/");
    }

    /* renamed from: e */
    private boolean m18351e(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("xnxx") && str.toLowerCase().contains("/videopreview/");
    }

    /* renamed from: f */
    private boolean m18352f(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("thumb-v") && str.toLowerCase().contains(".xhcdn.com/");
    }

    /* renamed from: g */
    private boolean m18353g(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("/ads_videos/");
    }
}
