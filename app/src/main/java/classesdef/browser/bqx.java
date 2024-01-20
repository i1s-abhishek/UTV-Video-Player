package classesdef.browser;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;

/* renamed from: bqx */
public class bqx {
    /* renamed from: a */
    public static void m19027a(Context context) {
        CookieManager instance = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            instance.removeAllCookies((ValueCallback) null);
            return;
        }
        CookieSyncManager.createInstance(context);
        instance.removeAllCookie();
    }

    /* renamed from: a */
    public static void m19026a() {
        WebStorage.getInstance().deleteAllData();
    }

    /* renamed from: b */
    public static void m19029b(Context context) {
        bmq.m18070a().mo21839a(C4740s.m21407e()).mo23839a();
        WebViewDatabase instance = WebViewDatabase.getInstance(context);
        instance.clearFormData();
        instance.clearHttpAuthUsernamePassword();
        if (Build.VERSION.SDK_INT < 18) {
            instance.clearUsernamePassword();
            WebIconDatabase.getInstance().removeAllIcons();
        }
        bqw.m19013a(context);
    }

    /* renamed from: a */
    public static void m19028a(WebView webView) {
        if (webView != null) {
            webView.clearCache(true);
        }
    }
}
