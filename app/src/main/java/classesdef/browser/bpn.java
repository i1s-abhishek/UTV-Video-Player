package classesdef.browser;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* renamed from: bpn */
public class bpn {

    /* renamed from: a */
    private final SharedPreferences f16282a;

    /* renamed from: bpn$a */
    public enum C4016a {
        SUGGESTION_GOOGLE,
        SUGGESTION_DUCK,
        SUGGESTION_BAIDU,
        SUGGESTION_NONE
    }

    @Inject
    bpn(Context context) {
        this.f16282a = context.getSharedPreferences("settings", 0);
    }

    /* renamed from: a */
    public C4016a mo23448a() {
        try {
            return C4016a.valueOf(this.f16282a.getString("searchSuggestions", C4016a.SUGGESTION_GOOGLE.name()));
        } catch (IllegalArgumentException unused) {
            return C4016a.SUGGESTION_NONE;
        }
    }

    /* renamed from: b */
    public boolean mo23455b() {
        return this.f16282a.getBoolean("swapBookmarksAndTabs", false);
    }

    /* renamed from: c */
    public boolean mo23459c() {
        return this.f16282a.getBoolean("AdBlock", true);
    }

    /* renamed from: d */
    public boolean mo23462d() {
        return this.f16282a.getBoolean("blockimages", false);
    }

    /* renamed from: e */
    public boolean mo23464e() {
        return this.f16282a.getBoolean("thirdParty", false);
    }

    /* renamed from: f */
    public boolean mo23466f() {
        return this.f16282a.getBoolean("checkForTor", false);
    }

    /* renamed from: g */
    public boolean mo23468g() {
        return this.f16282a.getBoolean("checkForI2P", false);
    }

    /* renamed from: h */
    public boolean mo23469h() {
        return this.f16282a.getBoolean("cache", false);
    }

    /* renamed from: i */
    public boolean mo23470i() {
        return this.f16282a.getBoolean("clearCookiesExit", false);
    }

    /* renamed from: j */
    public boolean mo23471j() {
        return this.f16282a.getBoolean("clearWebStorageExit", false);
    }

    /* renamed from: k */
    public boolean mo23472k() {
        return this.f16282a.getBoolean("clearHistoryExit", false);
    }

    /* renamed from: l */
    public boolean mo23473l() {
        return this.f16282a.getBoolean("colorMode", true);
    }

    /* renamed from: m */
    public boolean mo23474m() {
        return this.f16282a.getBoolean("cookies", true);
    }

    /* renamed from: n */
    public String mo23475n() {
        return this.f16282a.getString("downloadLocation", bmv.f15797a);
    }

    /* renamed from: o */
    public int mo23476o() {
        return this.f16282a.getInt("enableflash", 0);
    }

    /* renamed from: p */
    public boolean mo23477p() {
        return this.f16282a.getBoolean("fullscreen", true);
    }

    /* renamed from: q */
    public boolean mo23478q() {
        return this.f16282a.getBoolean("hidestatus", false);
    }

    /* renamed from: r */
    public String mo23479r() {
        return this.f16282a.getString("home", "about:home");
    }

    /* renamed from: s */
    public boolean mo23480s() {
        return this.f16282a.getBoolean("incognitocookies", false);
    }

    /* renamed from: t */
    public boolean mo23481t() {
        return this.f16282a.getBoolean("invertColors", false);
    }

    /* renamed from: u */
    public boolean mo23482u() {
        return this.f16282a.getBoolean("java", true);
    }

    /* renamed from: v */
    public boolean mo23483v() {
        return this.f16282a.getBoolean("location", false);
    }

    /* renamed from: w */
    public boolean mo23484w() {
        return this.f16282a.getBoolean("overviewmode", true);
    }

    /* renamed from: x */
    public boolean mo23485x() {
        return this.f16282a.getBoolean("newwindows", false);
    }

    /* renamed from: y */
    public String mo23486y() {
        return this.f16282a.getString("useProxyHost", "localhost");
    }

    /* renamed from: z */
    public int mo23487z() {
        return this.f16282a.getInt("useProxyPort", 8118);
    }

    /* renamed from: A */
    public int mo23428A() {
        return this.f16282a.getInt("readingTextSize", 2);
    }

    /* renamed from: B */
    public int mo23429B() {
        return this.f16282a.getInt("renderMode", 0);
    }

    /* renamed from: C */
    public boolean mo23430C() {
        return this.f16282a.getBoolean("restoreclosed", true);
    }

    /* renamed from: D */
    public String mo23431D() {
        return this.f16282a.getString("saveUrl", (String) null);
    }

    /* renamed from: E */
    public boolean mo23432E() {
        return this.f16282a.getBoolean("passwords", true);
    }

    /* renamed from: F */
    public int mo23433F() {
        return this.f16282a.getInt("search", 1);
    }

    /* renamed from: G */
    public String mo23434G() {
        return this.f16282a.getString("searchurl", "https://www.google.com/search?client=lightning&ie=UTF-8&oe=UTF-8&q=");
    }

    /* renamed from: H */
    public boolean mo23435H() {
        return this.f16282a.getBoolean("textreflow", false);
    }

    /* renamed from: I */
    public int mo23436I() {
        return this.f16282a.getInt("textsize", 3);
    }

    /* renamed from: J */
    public int mo23437J() {
        return this.f16282a.getInt("urlContent", 0);
    }

    /* renamed from: K */
    public int mo23438K() {
        return this.f16282a.getInt("Theme", 0);
    }

    /* renamed from: L */
    public boolean mo23439L() {
        return this.f16282a.getBoolean("useProxy", false);
    }

    /* renamed from: M */
    public int mo23440M() {
        int i = this.f16282a.getInt("proxyChoice", 0);
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return i;
            default:
                return 0;
        }
    }

    /* renamed from: N */
    public int mo23441N() {
        return this.f16282a.getInt("agentchoose", 3);
    }

    /* renamed from: O */
    public boolean mo23442O() {
        return this.f16282a.getBoolean("wideviewport", true);
    }

    /* renamed from: P */
    public String mo23443P() {
        return this.f16282a.getString("textEncoding", "UTF-8");
    }

    /* renamed from: a */
    public boolean mo23451a(boolean z) {
        return this.f16282a.getBoolean("showTabsInDrawer", z);
    }

    /* renamed from: Q */
    public boolean mo23444Q() {
        return this.f16282a.getBoolean("doNotTrack", false);
    }

    /* renamed from: R */
    public boolean mo23445R() {
        return this.f16282a.getBoolean("removeIdentifyingHeaders", false);
    }

    /* renamed from: S */
    public boolean mo23446S() {
        return this.f16282a.getBoolean("blackStatusBar", false);
    }

    /* renamed from: a */
    private void m18679a(String str, boolean z) {
        this.f16282a.edit().putBoolean(str, z).apply();
    }

    /* renamed from: a */
    private void m18677a(String str, int i) {
        this.f16282a.edit().putInt(str, i).apply();
    }

    /* renamed from: a */
    private void m18678a(String str, String str2) {
        this.f16282a.edit().putString(str, str2).apply();
    }

    /* renamed from: b */
    public void mo23454b(boolean z) {
        m18679a("AdBlock", z);
    }

    /* renamed from: c */
    public void mo23458c(boolean z) {
        m18679a("checkForTor", z);
    }

    /* renamed from: d */
    public void mo23461d(boolean z) {
        m18679a("checkForI2P", z);
    }

    /* renamed from: a */
    public void mo23450a(String str) {
        m18678a("home", str);
    }

    /* renamed from: e */
    public void mo23463e(boolean z) {
        m18679a("invertColors", z);
    }

    /* renamed from: a */
    public void mo23449a(int i) {
        m18677a("readingTextSize", i);
    }

    /* renamed from: b */
    public void mo23453b(String str) {
        m18678a("saveUrl", str);
    }

    /* renamed from: f */
    public void mo23465f(boolean z) {
        m18679a("passwords", z);
    }

    /* renamed from: b */
    public void mo23452b(int i) {
        m18677a("search", i);
    }

    /* renamed from: c */
    public void mo23457c(String str) {
        m18678a("searchurl", str);
    }

    /* renamed from: g */
    public void mo23467g(boolean z) {
        m18679a("leakCanary", z);
    }

    /* renamed from: T */
    public boolean mo23447T() {
        return this.f16282a.getBoolean("leakCanary", false);
    }

    /* renamed from: c */
    public void mo23456c(int i) {
        m18679a("useProxy", i != 0);
        m18677a("proxyChoice", i);
    }

    /* renamed from: d */
    public void mo23460d(int i) {
        m18677a("agentchoose", i);
    }
}
