package classesdef.browser.download;

import android.webkit.CookieManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* renamed from: bpf */
public final class bpf implements CookieJar {

    /* renamed from: b */
    private CookieManager f16138b = CookieManager.getInstance();

    /* renamed from: a */
    public void saveFromResponse(HttpUrl bhp, List<Cookie> list) {
        try {
            String bhp2 = bhp.toString();
            for (Cookie bhi : list) {
                this.f16138b.setCookie(bhp2, bhi.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public List<Cookie> loadForRequest(HttpUrl bhp) {
        try {
            String cookie = this.f16138b.getCookie(bhp.toString());
            if (cookie != null && !cookie.isEmpty()) {
                String[] split = cookie.split(";");
                ArrayList arrayList = new ArrayList(split.length);
                for (String a : split) {
                    arrayList.add(Cookie.parse(bhp, a));
                }
                return arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
