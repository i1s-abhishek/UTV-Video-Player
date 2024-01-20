package video.downloader.videodownloader.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;


import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import classesdef.browser.bpc;
import classesdef.browser.bph;
import classesdef.browser.download.boi;
import classesdef.browser.download.bpd;
import classesdef.eventbus.bny;
import video.downloader.videodownloader.five.service.C3344a;

public class C3370c {


    public static String f11781a;
    /* access modifiers changed from: private */

    public Activity activity;
    /* access modifiers changed from: private */

    public WebView webView;
    /* access modifiers changed from: private */

    public C3374a f11784d;

    public interface C3374a {
        void mo21379a();

        void mo21380b();
    }

    public C3370c(Activity activity, WebView webView) {
        this.activity = activity;
        this.webView = webView;
    }

    public void mo21371a(C3374a aVar) {
        this.f11784d = aVar;
    }

    @JavascriptInterface
    public void getTikTokUrl(final String str) {
        if (this.activity != null && this.webView != null && !TextUtils.isEmpty(str)) {
            this.activity.runOnUiThread(new Runnable() {
                public void run() {
                    boi.m18319b().mo24553a((Context) C3370c.this.activity, str, C3370c.this.webView.getUrl());
                }
            });
        }
    }

    @JavascriptInterface
    public void torch() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        if (C3370c.this.f11784d != null) {
                            C3370c.this.f11784d.mo21379a();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void candy(String str) {
        if (this.activity != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("fatherUrl");
                boi.m18319b().mo23274c(optString);
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("imageUrl");
                ArrayList arrayList = new ArrayList();
                boolean has = jSONObject.has("videoArray");
                boolean z = false;
                if (has) {
                    JSONArray jSONArray = jSONObject.getJSONArray("videoArray");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        arrayList.add(bpd.m21193a(this.activity, jSONObject2.optString("downloadLink"), optString, optString2, 0, m14543a(jSONObject2.optString("quality")), optString3));
                    }
                } else {
                    arrayList.add(bpd.m18501a(this.activity, optString3, optString, 3, bpc.m18492a(this.activity, optString3, 3, "image/jpg", "", optString2, true)));
                }
                int i2 = 1;
                if (arrayList.size() > 0) {
                    z = true;
                }
                EventBus a = EventBus.getDefault();
                if (!z) {
                    i2 = 2;
                }
                a.post(new bny(optString, i2));
                boi.m18319b().mo24556a((Context) this.activity, optString, (List<bph>) arrayList);
                if (!has) {
                    this.activity.runOnUiThread(new Runnable() {
                        public void run() {
                            try {
                                if (C3370c.this.f11784d != null) {
                                    C3370c.this.f11784d.mo21380b();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void getToken(String str) {
        f11781a = str;
    }

    /* renamed from: a */
    private int m14543a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 480;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1957302332) {
            if (hashCode != 2313) {
                if (hashCode == 1379043793 && str.equals("original")) {
                    c = 1;
                }
            } else if (str.equals("HQ")) {
                c = 2;
            }
        } else if (str.equals("Automatico")) {
            c = 0;
        }
        switch (c) {
            case 0:
            case 1:
                return 1080;
            case 2:
                return 720;
            default:
                return C3344a.m14438b(str);
        }
    }
}
