package classesdef.xdplayer;

import android.content.Context;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import classesdef.browser.download.bpd;

/* renamed from: bpj */
public class bpj {

    /* renamed from: A */
    private static bpj f16160A;

    /* renamed from: a */
    public boolean f16161a = false;

    /* renamed from: b */
    private String f16162b = "";

    /* renamed from: c */
    private String f16163c = "";

    /* renamed from: d */
    private boolean f16164d = true;

    /* renamed from: e */
    private long f16165e;

    /* renamed from: f */
    private boolean f16166f = true;

    /* renamed from: g */
    private long f16167g;

    /* renamed from: h */
    private long f16168h;

    /* renamed from: i */
    private long f16169i = System.currentTimeMillis();

    /* renamed from: j */
    private int f16170j;

    /* renamed from: k */
    private boolean f16171k = false;

    /* renamed from: l */
    private boolean f16172l = true;

    /* renamed from: m */
    private int f16173m = 3;

    /* renamed from: n */
    private int f16174n;

    /* renamed from: o */
    private int f16175o;

    /* renamed from: p */
    private int f16176p;

    /* renamed from: q */
    private int f16177q = 0;

    /* renamed from: r */
    private int f16178r = -1;

    /* renamed from: s */
    private long f16179s;

    /* renamed from: t */
    private boolean f16180t;

    /* renamed from: u */
    private boolean f16181u = true;

    /* renamed from: v */
    private String f16182v = "";

    /* renamed from: w */
    private boolean f16183w;

    /* renamed from: x */
    private long f16184x;

    /* renamed from: y */
    private int f16185y;

    /* renamed from: z */
    private int f16186z;

    private bpj(Context context) {
        m18580c(context);
    }

    /* renamed from: a */
    public static bpj m18578a(Context context) {
        if (f16160A == null) {
            f16160A = new bpj(context.getApplicationContext());
        }
        return f16160A;
    }

    /* renamed from: c */
    private void m18580c(Context context) {
        String d = m18581d(context);
        if (!TextUtils.isEmpty(d)) {
            try {
                JSONObject jSONObject = new JSONObject(d);
                mo23376b(jSONObject.optString("big_card"));
                mo23370a(jSONObject.optString("full"));
                mo23377b(jSONObject.optBoolean("enable_ga", true));
                mo23386d(jSONObject.optLong("ga_error_time", 0));
                mo23371a(jSONObject.optBoolean("enable_fabric", true));
                mo23381c(jSONObject.optLong("fabric_error_time", 0));
                mo23369a(jSONObject.optLong("last_show_full_ad_time", 0));
                mo23374b(jSONObject.optLong("last_request_full_ad_time", 0));
                mo23368a(jSONObject.optInt("download_finished_number", 0));
                mo23383c(jSONObject.optBoolean("mute", false));
                mo23387d(jSONObject.optBoolean("sync_to_gallery", true));
                mo23373b(jSONObject.optInt("same_time_download_number", 3));
                mo23380c(jSONObject.optInt("download_finished_not_seen", 0));
                mo23385d(jSONObject.optInt("screen_orientation", 0));
                mo23389e(jSONObject.optInt("show_rate_us", 0));
                mo23393f(jSONObject.optInt("rate_us_download_num", 0));
                mo23397g(jSONObject.optInt("language", -1));
                mo23390e(jSONObject.optLong("first_open_app_time", 0));
                mo23391e(jSONObject.optBoolean("use_mobile_data", false));
                mo23395f(jSONObject.optBoolean("new_user", true));
                mo23382c(jSONObject.optString("file_dir"));
                mo23398g(jSONObject.optBoolean("use_bookmark", false));
                mo23394f(jSONObject.optLong("review_sound_cloud", 0));
                mo23399h(jSONObject.optInt("play_with_mp3player", 0));
                mo23402i(jSONObject.optInt("show_update_dialog_number", 0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void mo23375b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("big_card", mo23403j());
            jSONObject.put("full", mo23401i());
            jSONObject.put("enable_ga", mo23378b());
            jSONObject.put("ga_error_time", mo23396g());
            jSONObject.put("enable_fabric", mo23372a());
            jSONObject.put("fabric_error_time", mo23392f());
            jSONObject.put("last_show_full_ad_time", mo23384d());
            jSONObject.put("last_request_full_ad_time", mo23388e());
            jSONObject.put("download_finished_number", mo23379c());
            jSONObject.put("mute", mo23400h());
            jSONObject.put("sync_to_gallery", mo23404k());
            jSONObject.put("same_time_download_number", mo23405l());
            jSONObject.put("download_finished_not_seen", mo23406m());
            jSONObject.put("screen_orientation", mo23407n());
            jSONObject.put("show_rate_us", mo23408o());
            jSONObject.put("rate_us_download_num", mo23409p());
            jSONObject.put("language", mo23410q());
            jSONObject.put("first_open_app_time", mo23411r());
            jSONObject.put("use_mobile_data", mo23412s());
            jSONObject.put("new_user", mo23413t());
            jSONObject.put("file_dir", mo23414u());
            jSONObject.put("use_bookmark", mo23415v());
            jSONObject.put("review_sound_cloud", mo23416w());
            jSONObject.put("play_with_mp3player", mo23417x());
            jSONObject.put("show_update_dialog_number", mo23418y());
            m18579a(context, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m18579a(Context context, String str) {
        bpd.m18499a(context).edit().putString("user_info", str).apply();
    }

    /* renamed from: d */
    private String m18581d(Context context) {
        return bpd.m18499a(context).getString("user_info", "");
    }

    /* renamed from: a */
    public boolean mo23372a() {
        if (System.currentTimeMillis() - mo23392f() > 604800000) {
            this.f16166f = true;
        }
        return this.f16166f;
    }

    /* renamed from: a */
    public void mo23371a(boolean z) {
        this.f16166f = z;
    }

    /* renamed from: b */
    public boolean mo23378b() {
        if (System.currentTimeMillis() - mo23396g() > 604800000) {
            this.f16164d = true;
        }
        return this.f16164d;
    }

    /* renamed from: b */
    public void mo23377b(boolean z) {
        this.f16164d = z;
    }

    /* renamed from: c */
    public int mo23379c() {
        return this.f16170j;
    }

    /* renamed from: a */
    public void mo23368a(int i) {
        this.f16170j = i;
    }

    /* renamed from: d */
    public long mo23384d() {
        return this.f16168h;
    }

    /* renamed from: a */
    public void mo23369a(long j) {
        this.f16168h = j;
    }

    /* renamed from: e */
    public long mo23388e() {
        return this.f16169i;
    }

    /* renamed from: b */
    public void mo23374b(long j) {
        this.f16169i = j;
    }

    /* renamed from: f */
    public long mo23392f() {
        return this.f16167g;
    }

    /* renamed from: c */
    public void mo23381c(long j) {
        this.f16167g = j;
    }

    /* renamed from: g */
    public long mo23396g() {
        return this.f16165e;
    }

    /* renamed from: d */
    public void mo23386d(long j) {
        this.f16165e = j;
    }

    /* renamed from: h */
    public boolean mo23400h() {
        return this.f16171k;
    }

    /* renamed from: c */
    public void mo23383c(boolean z) {
        this.f16171k = z;
    }

    /* renamed from: i */
    public String mo23401i() {
        return this.f16163c;
    }

    /* renamed from: a */
    public void mo23370a(String str) {
        this.f16163c = str;
    }

    /* renamed from: j */
    public String mo23403j() {
        return this.f16162b;
    }

    /* renamed from: b */
    public void mo23376b(String str) {
        this.f16162b = str;
    }

    /* renamed from: k */
    public boolean mo23404k() {
        return this.f16172l;
    }

    /* renamed from: d */
    public void mo23387d(boolean z) {
        this.f16172l = z;
    }

    /* renamed from: l */
    public int mo23405l() {
        return this.f16173m;
    }

    /* renamed from: b */
    public void mo23373b(int i) {
        this.f16173m = i;
    }

    /* renamed from: m */
    public int mo23406m() {
        return this.f16176p;
    }

    /* renamed from: c */
    public void mo23380c(int i) {
        this.f16176p = i;
    }

    /* renamed from: n */
    public int mo23407n() {
        return this.f16177q;
    }

    /* renamed from: d */
    public void mo23385d(int i) {
        this.f16177q = i;
    }

    /* renamed from: o */
    public int mo23408o() {
        return this.f16174n;
    }

    /* renamed from: e */
    public void mo23389e(int i) {
        this.f16174n = i;
    }

    /* renamed from: p */
    public int mo23409p() {
        return this.f16175o;
    }

    /* renamed from: f */
    public void mo23393f(int i) {
        this.f16175o = i;
    }

    /* renamed from: q */
    public int mo23410q() {
        return this.f16178r;
    }

    /* renamed from: g */
    public void mo23397g(int i) {
        this.f16178r = i;
    }

    /* renamed from: r */
    public long mo23411r() {
        return this.f16179s;
    }

    /* renamed from: e */
    public void mo23390e(long j) {
        this.f16179s = j;
    }

    /* renamed from: s */
    public boolean mo23412s() {
        return this.f16180t;
    }

    /* renamed from: e */
    public void mo23391e(boolean z) {
        this.f16180t = z;
    }

    /* renamed from: t */
    public boolean mo23413t() {
        return this.f16181u;
    }

    /* renamed from: f */
    public void mo23395f(boolean z) {
        this.f16181u = z;
    }

    /* renamed from: u */
    public String mo23414u() {
        return this.f16182v;
    }

    /* renamed from: c */
    public void mo23382c(String str) {
        this.f16182v = str;
    }

    /* renamed from: v */
    public boolean mo23415v() {
        return this.f16183w;
    }

    /* renamed from: g */
    public void mo23398g(boolean z) {
        this.f16183w = z;
    }

    /* renamed from: w */
    public long mo23416w() {
        return this.f16184x;
    }

    /* renamed from: f */
    public void mo23394f(long j) {
        this.f16184x = j;
    }

    /* renamed from: x */
    public int mo23417x() {
        return this.f16185y;
    }

    /* renamed from: h */
    public void mo23399h(int i) {
        this.f16185y = i;
    }

    /* renamed from: y */
    public int mo23418y() {
        return this.f16186z;
    }

    /* renamed from: i */
    public void mo23402i(int i) {
        this.f16186z = i;
    }
}
