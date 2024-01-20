package video.downloader.videodownloader.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;


import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.ItemTouchHelper;

import com.mopub.mobileads.resource.DrawableConstants;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

import javax.inject.Inject;

import classesdef.browser.C4740s;
import classesdef.browser.blx;
import classesdef.browser.blz;
import classesdef.browser.bmd;
import classesdef.browser.bmf;
import classesdef.browser.bms;
import classesdef.browser.bpn;
import classesdef.browser.bql;
import classesdef.browser.bqm;
import classesdef.browser.bqq;
import classesdef.browser.bqv;
import classesdef.browser.bqw;
import classesdef.browser.download.bmw;
import classesdef.browser.download.boi;
import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4892v;
import classesdef.browser.tab.C4927w;
import classesdef.eventbus.bob;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.activity.BrowserActivity;
import video.downloader.videodownloader.app.BrowserApp;

public class WebViewBrowser {
    public static final int f13828d = Build.VERSION.SDK_INT;
    public static final int f13829e = bqw.m19007a(10.0f);
    private static String f13830f;

    private static String f13831g;
    public static float f13832h;

    private static final float[] f13833i = {-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    private static final float[] f13834j = {2.0f, 0.0f, 0.0f, 0.0f, -160.0f, 0.0f, 2.0f, 0.0f, 0.0f, -160.0f, 0.0f, 0.0f, 2.0f, 0.0f, -160.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    @Inject
      bpn f13835a;
    @Inject
     bms f13836b;
    @Inject
     bqm f13837c;

    private final NewTab f13838k;
    public WebView webView;
    public final bmf f13840m;
    public final GestureDetector gestureDetector;
    public final Activity activity;

    private final Paint paint = new Paint();

    private boolean f13844q;

    private final boolean f13845r;

    private boolean f13846s;

    private boolean f13847t = false;
    public final C3619d f13848u = new C3619d(this);

    private final Map<String, String> f13849v = new ArrayMap();

    public WebViewBrowser(Activity activity, String str, boolean z) {
        BrowserApp.m15129g().mo21509a(this);
        this.activity = activity;
        this.f13840m = (bmf) activity;
        this.webView = new ScrollListenerWebView(activity);
        if (Build.VERSION.SDK_INT > 16) {
            this.webView.setId(View.generateViewId());
        }
        this.f13845r = z;
        this.f13838k = new NewTab(activity);
        f13832h = (float) ViewConfiguration.get(activity).getScaledMaximumFlingVelocity();
        this.webView.setDrawingCacheBackgroundColor(-1);
        this.webView.setFocusableInTouchMode(true);
        this.webView.setFocusable(true);
        this.webView.setDrawingCacheEnabled(false);
        this.webView.setWillNotCacheDrawing(true);
        if (Build.VERSION.SDK_INT <= 22) {
            this.webView.setAnimationCacheEnabled(false);
            this.webView.setAlwaysDrawnWithCacheEnabled(false);
        }
        this.webView.setBackgroundColor(-1);
        this.webView.setScrollbarFadingEnabled(true);
        this.webView.setSaveEnabled(true);
        this.webView.setNetworkAvailable(true);
        this.webView.setWebChromeClient(new WebChromeClientBrowser(activity, this));
        this.webView.setWebViewClient(new WebViewClientBrowser(activity, this));
        this.webView.setDownloadListener(new bmw(activity, this.webView));
        this.gestureDetector = new GestureDetector(activity, new C3615a());
        this.webView.setOnTouchListener(new WebViewTouchListener());
        f13831g = this.webView.getSettings().getUserAgentString();
        m15352J();
        mo21635a((Context) activity);
        C3370c cVar = new C3370c(this.activity, this.webView);
        cVar.mo21371a((C3370c.C3374a) new C3370c.C3374a() {

            public void mo21379a() {
                if (activity instanceof BrowserActivity) {
                    ((BrowserActivity) activity).m14868b((int) R.layout.download_progress_drawer, 0);
                }
            }


            public void mo21380b() {
                if (activity instanceof BrowserActivity) {
                    ((BrowserActivity) activity).m14868b((int) R.layout.download_drawer, 2);
                }
            }
        });
        this.webView.addJavascriptInterface(cVar, "GetPear");
        this.webView.addJavascriptInterface(new C3616b(), "InJavaScriptLocalObj");
        if (str == null) {
            mo21639b();
        } else if (!str.trim().isEmpty()) {
            this.webView.loadUrl(str, this.f13849v);
        }
    }


    private class C3616b {
        private C3616b() {
        }

        @JavascriptInterface
        public void onUrlClick(final String str) {
            WebViewBrowser.this.activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (WebViewBrowser.this.webView != null && !TextUtils.isEmpty(str)) {
                        WebViewBrowser.this.webView.loadUrl(bqv.m19000a(str, true, BrowserActivity.f13354a));
                    }
                }
            });
        }
    }

    public void mo21637a(boolean z) {
        this.f13844q = z;
    }

    public boolean mo21638a() {
        return this.f13844q;
    }

    public void mo21639b() {
        if (this.webView != null) {
            bql.m18952a(f13830f);
            String str = f13830f;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1145275824) {
                if (hashCode == 1396069548 && str.equals("about:home")) {
                    c = 0;
                }
            } else if (str.equals("about:bookmarks")) {
                c = 1;
            }
            switch (c) {
                case 0:
                    if (Build.VERSION.SDK_INT < 21) {
                        m15351I();
                        return;
                    } else {
                        this.webView.loadUrl("file:///android_asset/web/index.html");
                        return;
                    }
                case 1:
                    mo21642c();
                    return;
                default:
                    this.webView.loadUrl(f13830f, this.f13849v);
                    return;
            }
        }
    }

    /* renamed from: I */
    private void m15351I() {
        new bmd().mo23036a().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<String>() {
            /* renamed from: a */
            public void mo21366a(String str) {
                bql.m18952a(str);
                WebViewBrowser.this.mo21636a(str);
            }
        });
    }

    /* renamed from: c */
    public void mo21642c() {
        new blx(this.activity).mo23023a().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<String>() {
            /* renamed from: a */
            public void mo21366a(String str) {
                bql.m18952a(str);
                WebViewBrowser.this.mo21636a(str);
            }
        });
    }

    /* renamed from: d */
    public void mo21643d() {
        new blz().mo23027a().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<String>() {
            /* renamed from: a */
            public void mo21366a(String str) {
                bql.m18952a(str);
                WebViewBrowser.this.mo21636a(str);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017a, code lost:
        return;
     */
    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo21635aa(Context r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.webkit.WebView r0 = r5.webView     // Catch:{ all -> 0x017b }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r5)
            return
        L_0x0007:
            android.webkit.WebView r0 = r5.webView     // Catch:{ all -> 0x017b }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ all -> 0x017b }
            bpn r1 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r1 = r1.mo23444Q()     // Catch:{ all -> 0x017b }
            if (r1 == 0) goto L_0x001f
            java.util.Map<java.lang.String, java.lang.String> r1 = r5.f13849v     // Catch:{ all -> 0x017b }
            java.lang.String r2 = "DNT"
            java.lang.String r3 = "1"
            r1.put(r2, r3)     // Catch:{ all -> 0x017b }
            goto L_0x0026
        L_0x001f:
            java.util.Map<java.lang.String, java.lang.String> r1 = r5.f13849v     // Catch:{ all -> 0x017b }
            java.lang.String r2 = "DNT"
            r1.remove(r2)     // Catch:{ all -> 0x017b }
        L_0x0026:
            bpn r1 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r1 = r1.mo23445R()     // Catch:{ all -> 0x017b }
            if (r1 == 0) goto L_0x0041
            java.util.Map<java.lang.String, java.lang.String> r1 = r5.f13849v     // Catch:{ all -> 0x017b }
            java.lang.String r2 = "X-Requested-With"
            java.lang.String r3 = ""
            r1.put(r2, r3)     // Catch:{ all -> 0x017b }
            java.util.Map<java.lang.String, java.lang.String> r1 = r5.f13849v     // Catch:{ all -> 0x017b }
            java.lang.String r2 = "X-Wap-Profile"
            java.lang.String r3 = ""
            r1.put(r2, r3)     // Catch:{ all -> 0x017b }
            goto L_0x004f
        L_0x0041:
            java.util.Map<java.lang.String, java.lang.String> r1 = r5.f13849v     // Catch:{ all -> 0x017b }
            java.lang.String r2 = "X-Requested-With"
            r1.remove(r2)     // Catch:{ all -> 0x017b }
            java.util.Map<java.lang.String, java.lang.String> r1 = r5.f13849v     // Catch:{ all -> 0x017b }
            java.lang.String r2 = "X-Wap-Profile"
            r1.remove(r2)     // Catch:{ all -> 0x017b }
        L_0x004f:
            bpn r1 = r5.f13835a     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r1.mo23443P()     // Catch:{ all -> 0x017b }
            r0.setDefaultTextEncodingName(r1)     // Catch:{ all -> 0x017b }
            bpn r1 = r5.f13835a     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r1.mo23479r()     // Catch:{ all -> 0x017b }
            f13830f = r1     // Catch:{ all -> 0x017b }
            bpn r1 = r5.f13835a     // Catch:{ all -> 0x017b }
            int r1 = r1.mo23429B()     // Catch:{ all -> 0x017b }
            r5.m15361b((int) r1)     // Catch:{ all -> 0x017b }
            boolean r1 = r5.f13845r     // Catch:{ all -> 0x017b }
            r2 = 0
            if (r1 != 0) goto L_0x0078
            bpn r1 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r1 = r1.mo23483v()     // Catch:{ all -> 0x017b }
            r0.setGeolocationEnabled(r1)     // Catch:{ all -> 0x017b }
            goto L_0x007b
        L_0x0078:
            r0.setGeolocationEnabled(r2)     // Catch:{ all -> 0x017b }
        L_0x007b:
            int r1 = f13828d     // Catch:{ all -> 0x017b }
            r3 = 19
            if (r1 >= r3) goto L_0x009c
            bpn r1 = r5.f13835a     // Catch:{ all -> 0x017b }
            int r1 = r1.mo23476o()     // Catch:{ all -> 0x017b }
            switch(r1) {
                case 0: goto L_0x0097;
                case 1: goto L_0x0091;
                case 2: goto L_0x008b;
                default: goto L_0x008a;
            }     // Catch:{ all -> 0x017b }
        L_0x008a:
            goto L_0x009c
        L_0x008b:
            android.webkit.WebSettings$PluginState r1 = android.webkit.WebSettings.PluginState.ON     // Catch:{ all -> 0x017b }
            r0.setPluginState(r1)     // Catch:{ all -> 0x017b }
            goto L_0x009c
        L_0x0091:
            android.webkit.WebSettings$PluginState r1 = android.webkit.WebSettings.PluginState.ON_DEMAND     // Catch:{ all -> 0x017b }
            r0.setPluginState(r1)     // Catch:{ all -> 0x017b }
            goto L_0x009c
        L_0x0097:
            android.webkit.WebSettings$PluginState r1 = android.webkit.WebSettings.PluginState.OFF     // Catch:{ all -> 0x017b }
            r0.setPluginState(r1)     // Catch:{ all -> 0x017b }
        L_0x009c:
            bpn r1 = r5.f13835a     // Catch:{ all -> 0x017b }
            int r1 = r1.mo23441N()     // Catch:{ all -> 0x017b }
            r5.m15357a((android.content.Context) r6, (int) r1)     // Catch:{ all -> 0x017b }
            bpn r6 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r6 = r6.mo23432E()     // Catch:{ all -> 0x017b }
            r1 = 18
            r4 = 1
            if (r6 == 0) goto L_0x00bf
            boolean r6 = r5.f13845r     // Catch:{ all -> 0x017b }
            if (r6 != 0) goto L_0x00bf
            int r6 = f13828d     // Catch:{ all -> 0x017b }
            if (r6 >= r1) goto L_0x00bb
            r0.setSavePassword(r4)     // Catch:{ all -> 0x017b }
        L_0x00bb:
            r0.setSaveFormData(r4)     // Catch:{ all -> 0x017b }
            goto L_0x00c9
        L_0x00bf:
            int r6 = f13828d     // Catch:{ all -> 0x017b }
            if (r6 >= r1) goto L_0x00c6
            r0.setSavePassword(r2)     // Catch:{ all -> 0x017b }
        L_0x00c6:
            r0.setSaveFormData(r2)     // Catch:{ all -> 0x017b }
        L_0x00c9:
            bpn r6 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r6 = r6.mo23482u()     // Catch:{ all -> 0x017b }
            if (r6 == 0) goto L_0x00d8
            r0.setJavaScriptEnabled(r4)     // Catch:{ all -> 0x017b }
            r0.setJavaScriptCanOpenWindowsAutomatically(r4)     // Catch:{ all -> 0x017b }
            goto L_0x00de
        L_0x00d8:
            r0.setJavaScriptEnabled(r2)     // Catch:{ all -> 0x017b }
            r0.setJavaScriptCanOpenWindowsAutomatically(r2)     // Catch:{ all -> 0x017b }
        L_0x00de:
            bpn r6 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r6 = r6.mo23435H()     // Catch:{ all -> 0x017b }
            if (r6 == 0) goto L_0x00fd
            android.webkit.WebSettings$LayoutAlgorithm r6 = android.webkit.WebSettings.LayoutAlgorithm.NARROW_COLUMNS     // Catch:{ all -> 0x017b }
            r0.setLayoutAlgorithm(r6)     // Catch:{ all -> 0x017b }
            int r6 = f13828d     // Catch:{ all -> 0x017b }
            if (r6 < r3) goto L_0x0102
            android.webkit.WebSettings$LayoutAlgorithm r6 = android.webkit.WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING     // Catch:{ Exception -> 0x00f5 }
            r0.setLayoutAlgorithm(r6)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x0102
        L_0x00f5:
            java.lang.String r6 = "LightningView"
            java.lang.String r1 = "Problem setting LayoutAlgorithm to TEXT_AUTOSIZING"
            android.util.Log.e(r6, r1)     // Catch:{ all -> 0x017b }
            goto L_0x0102
        L_0x00fd:
            android.webkit.WebSettings$LayoutAlgorithm r6 = android.webkit.WebSettings.LayoutAlgorithm.NORMAL     // Catch:{ all -> 0x017b }
            r0.setLayoutAlgorithm(r6)     // Catch:{ all -> 0x017b }
        L_0x0102:
            bpn r6 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r6 = r6.mo23462d()     // Catch:{ all -> 0x017b }
            r0.setBlockNetworkImage(r6)     // Catch:{ all -> 0x017b }
            boolean r6 = r5.f13845r     // Catch:{ all -> 0x017b }
            if (r6 != 0) goto L_0x0119
            bpn r6 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r6 = r6.mo23485x()     // Catch:{ all -> 0x017b }
            r0.setSupportMultipleWindows(r6)     // Catch:{ all -> 0x017b }
            goto L_0x011c
        L_0x0119:
            r0.setSupportMultipleWindows(r2)     // Catch:{ all -> 0x017b }
        L_0x011c:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x017b }
            if (r6 > r3) goto L_0x0124
            r0.setUseWideViewPort(r2)     // Catch:{ all -> 0x017b }
            goto L_0x012d
        L_0x0124:
            bpn r6 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r6 = r6.mo23442O()     // Catch:{ all -> 0x017b }
            r0.setUseWideViewPort(r6)     // Catch:{ all -> 0x017b }
        L_0x012d:
            bpn r6 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r6 = r6.mo23484w()     // Catch:{ all -> 0x017b }
            r0.setLoadWithOverviewMode(r6)     // Catch:{ all -> 0x017b }
            bpn r6 = r5.f13835a     // Catch:{ all -> 0x017b }
            int r6 = r6.mo23436I()     // Catch:{ all -> 0x017b }
            switch(r6) {
                case 0: goto L_0x015e;
                case 1: goto L_0x0158;
                case 2: goto L_0x0152;
                case 3: goto L_0x014c;
                case 4: goto L_0x0146;
                case 5: goto L_0x0140;
                default: goto L_0x013f;
            }     // Catch:{ all -> 0x017b }
        L_0x013f:
            goto L_0x0163
        L_0x0140:
            r6 = 50
            r0.setTextZoom(r6)     // Catch:{ all -> 0x017b }
            goto L_0x0163
        L_0x0146:
            r6 = 75
            r0.setTextZoom(r6)     // Catch:{ all -> 0x017b }
            goto L_0x0163
        L_0x014c:
            r6 = 100
            r0.setTextZoom(r6)     // Catch:{ all -> 0x017b }
            goto L_0x0163
        L_0x0152:
            r6 = 125(0x7d, float:1.75E-43)
            r0.setTextZoom(r6)     // Catch:{ all -> 0x017b }
            goto L_0x0163
        L_0x0158:
            r6 = 150(0x96, float:2.1E-43)
            r0.setTextZoom(r6)     // Catch:{ all -> 0x017b }
            goto L_0x0163
        L_0x015e:
            r6 = 200(0xc8, float:2.8E-43)
            r0.setTextZoom(r6)     // Catch:{ all -> 0x017b }
        L_0x0163:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x017b }
            r0 = 21
            if (r6 < r0) goto L_0x0179
            android.webkit.CookieManager r6 = android.webkit.CookieManager.getInstance()     // Catch:{ all -> 0x017b }
            android.webkit.WebView r0 = r5.webView     // Catch:{ all -> 0x017b }
            bpn r1 = r5.f13835a     // Catch:{ all -> 0x017b }
            boolean r1 = r1.mo23464e()     // Catch:{ all -> 0x017b }
            r1 = r1 ^ r4
            r6.setAcceptThirdPartyCookies(r0, r1)     // Catch:{ all -> 0x017b }
        L_0x0179:
            monitor-exit(r5)
            return
        L_0x017b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.view.C3607e.mo21635a(android.content.Context):void");
    }
    public synchronized void mo21635a(Context context) {
        if (this.webView != null) {
            WebSettings settings = this.webView.getSettings();
            if (this.f13835a.mo23444Q()) {
                this.f13849v.put("DNT", "1");
            } else {
                this.f13849v.remove("DNT");
            }
            if (this.f13835a.mo23445R()) {
                this.f13849v.put("X-Requested-With", "");
                this.f13849v.put("X-Wap-Profile", "");
            } else {
                this.f13849v.remove("X-Requested-With");
                this.f13849v.remove("X-Wap-Profile");
            }
            settings.setDefaultTextEncodingName(this.f13835a.mo23443P());
            f13830f = this.f13835a.mo23479r();
            m15361b(this.f13835a.mo23429B());
            if (!this.f13845r) {
                settings.setGeolocationEnabled(this.f13835a.mo23483v());
            } else {
                settings.setGeolocationEnabled(false);
            }
            if (f13828d < 19) {
                switch (this.f13835a.mo23476o()) {
                    case 0:
                        settings.setPluginState(WebSettings.PluginState.OFF);
                        break;
                    case 1:
                        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
                        break;
                    case 2:
                        settings.setPluginState(WebSettings.PluginState.ON);
                        break;
                }
            }
            m15357a(context, this.f13835a.mo23441N());
            if (!this.f13835a.mo23432E() || this.f13845r) {
                if (f13828d < 18) {
                    settings.setSavePassword(false);
                }
                settings.setSaveFormData(false);
            } else {
                if (f13828d < 18) {
                    settings.setSavePassword(true);
                }
                settings.setSaveFormData(true);
            }
            if (this.f13835a.mo23482u()) {
                settings.setJavaScriptEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
            } else {
                settings.setJavaScriptEnabled(false);
                settings.setJavaScriptCanOpenWindowsAutomatically(false);
            }
            if (this.f13835a.mo23435H()) {
                settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                if (f13828d >= 19) {
                    try {
                        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
                    } catch (Exception unused) {
                        Log.e("LightningView", "Problem setting LayoutAlgorithm to TEXT_AUTOSIZING");
                    }
                }
            } else {
                settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            }
            settings.setBlockNetworkImage(this.f13835a.mo23462d());
            if (!this.f13845r) {
                settings.setSupportMultipleWindows(this.f13835a.mo23485x());
            } else {
                settings.setSupportMultipleWindows(false);
            }
            if (Build.VERSION.SDK_INT <= 19) {
                settings.setUseWideViewPort(false);
            } else {
                settings.setUseWideViewPort(this.f13835a.mo23442O());
            }
            settings.setLoadWithOverviewMode(this.f13835a.mo23484w());
            switch (this.f13835a.mo23436I()) {
                case 0:
                    settings.setTextZoom(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                    break;
                case 1:
                    settings.setTextZoom(DrawableConstants.CtaButton.WIDTH_DIPS);
                    break;
                case 2:
                    settings.setTextZoom(125);
                    break;
                case 3:
                    settings.setTextZoom(100);
                    break;
                case 4:
                    settings.setTextZoom(75);
                    break;
                case 5:
                    settings.setTextZoom(50);
                    break;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, !this.f13835a.mo23464e());
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: J */
    private void m15352J() {
        if (this.webView != null) {
            final WebSettings settings = this.webView.getSettings();
            if (f13828d < 18) {
                settings.setAppCacheMaxSize(Long.MAX_VALUE);
            }
            if (f13828d < 17) {
                settings.setEnableSmoothTransition(true);
            }
            if (f13828d > 16) {
                settings.setMediaPlaybackRequiresUserGesture(true);
            }
            if (f13828d >= 21 && !this.f13845r) {
                settings.setMixedContentMode(2);
            } else if (f13828d >= 21) {
                settings.setMixedContentMode(1);
            }
            if (!this.f13845r) {
                settings.setDomStorageEnabled(true);
                settings.setAppCacheEnabled(true);
                settings.setCacheMode(-1);
                settings.setDatabaseEnabled(true);
            } else {
                settings.setDomStorageEnabled(false);
                settings.setAppCacheEnabled(false);
                settings.setDatabaseEnabled(false);
                settings.setCacheMode(2);
            }
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setAllowContentAccess(true);
            settings.setAllowFileAccess(true);
            if (f13828d >= 16) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            m15360b("appcache").mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<File>() {
                /* renamed from: a */
                public void mo21366a(File file) {
                    bql.m18952a(file);
                    settings.setAppCachePath(file.getPath());
                }
            });
            if (Build.VERSION.SDK_INT < 24) {
                m15360b("geolocation").mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<File>() {
                    /* renamed from: a */
                    public void mo21366a(File file) {
                        bql.m18952a(file);
                        settings.setGeolocationDatabasePath(file.getPath());
                    }
                });
            }
            m15360b("databases").mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<File>() {
                /* renamed from: a */
                public void mo21414a() {
                }

                /* renamed from: a */
                public void mo21366a(File file) {
                    if (WebViewBrowser.f13828d < 19) {
                        bql.m18952a(file);
                        settings.setDatabasePath(file.getPath());
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private C4805t<File> m15360b(final String str) {
        return C4805t.m21581a(new C4858u<File>() {
            /* renamed from: a */
            public void mo21407a(C4927w<File> wVar) {
                wVar.mo25115a(WebViewBrowser.this.activity.getDir(str, 0));
                wVar.mo23729a();
            }
        });
    }

    /* renamed from: e */
    public NewTab mo21644e() {
        return this.f13838k;
    }

    /* renamed from: f */
    public boolean mo21645f() {
        return this.f13845r;
    }

    /* renamed from: b */
    public void mo21640b(Context context) {
        if (this.webView != null) {
            m15357a(context, this.f13835a.mo23441N());
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m15357a(Context context, int i) {
        if (this.webView != null) {
            WebSettings settings = this.webView.getSettings();
            if (i == 2) {
                settings.setUserAgentString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2049.0 Safari/537.36");
            } else if (!TextUtils.isEmpty(bqq.m18973b(this.activity))) {
                settings.setUserAgentString(bqq.m18973b(this.activity));
            } else if (Build.VERSION.SDK_INT >= 23) {
                settings.setUserAgentString("Mozilla/5.0 (Linux; U; Android 6.0.1; en-us; Nexus 4 Build/JOP24G) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Chrome/47.0.2526.27 Mobile Safari/534.30");
            } else {
                settings.setUserAgentString("Mozilla/5.0 (Linux; U; Android 4.4; en-us; Nexus 4 Build/JOP24G) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Map<String, String> mo21646g() {
        return this.f13849v;
    }

    /* renamed from: h */
    public boolean mo21647h() {
        return this.webView != null && this.webView.isShown();
    }

    /* renamed from: i */
    public synchronized void mo21648i() {
        if (this.webView != null) {
            this.webView.onPause();
            Log.d("LightningView", "WebView onPause: " + this.webView.getId());
        }
    }

    /* renamed from: j */
    public synchronized void mo21649j() {
        if (this.webView != null) {
            this.webView.onResume();
            Log.d("LightningView", "WebView onResume: " + this.webView.getId());
        }
    }

    @Deprecated
    /* renamed from: k */
    public synchronized void mo21650k() {
        if (this.webView != null && Build.VERSION.SDK_INT < 19) {
            this.webView.freeMemory();
        }
    }

    /* renamed from: b */
    public void mo21641b(boolean z) {
        this.f13846s = z;
        this.f13840m.mo21304a(this);
    }

    /* renamed from: l */
    public boolean mo21651l() {
        return this.f13846s;
    }

    /* renamed from: m */
    public int mo21652m() {
        if (this.webView != null) {
            return this.webView.getProgress();
        }
        return 100;
    }

    /* renamed from: n */
    public synchronized void mo21653n() {
        if (this.webView != null) {
            this.webView.stopLoading();
        }
    }

    /* renamed from: K */
    private void m15353K() {
        if (this.webView != null) {
            this.webView.setLayerType(2, this.paint);
        }
    }

    /* renamed from: L */
    private void m15354L() {
        if (this.webView != null) {
            this.webView.setLayerType(0, (Paint) null);
        }
    }

    /* renamed from: b */
    private void m15361b(int i) {
        this.f13847t = false;
        switch (i) {
            case 0:
                this.paint.setColorFilter((ColorFilter) null);
                m15354L();
                this.f13847t = false;
                return;
            case 1:
                this.paint.setColorFilter(new ColorMatrixColorFilter(f13833i));
                m15353K();
                this.f13847t = true;
                return;
            case 2:
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0.0f);
                this.paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                m15353K();
                return;
            case 3:
                ColorMatrix colorMatrix2 = new ColorMatrix();
                colorMatrix2.set(f13833i);
                ColorMatrix colorMatrix3 = new ColorMatrix();
                colorMatrix3.setSaturation(0.0f);
                ColorMatrix colorMatrix4 = new ColorMatrix();
                colorMatrix4.setConcat(colorMatrix2, colorMatrix3);
                this.paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix4));
                m15353K();
                this.f13847t = true;
                return;
            case 4:
                this.paint.setColorFilter(new ColorMatrixColorFilter(f13834j));
                m15353K();
                return;
            default:
                return;
        }
    }

    /* renamed from: o */
    public synchronized void mo21654o() {
        if (this.webView != null) {
            this.webView.pauseTimers();
            Log.d("LightningView", "Pausing JS timers");
        }
    }

    /* renamed from: p */
    public synchronized void mo21655p() {
        if (this.webView != null) {
            this.webView.resumeTimers();
            Log.d("LightningView", "Resuming JS timers");
        }
    }

    /* renamed from: q */
    public void mo21656q() {
        if (this.webView != null && !this.webView.hasFocus()) {
            this.webView.requestFocus();
        }
    }

    /* renamed from: a */
    public void mo21634a(int i) {
        if (this.webView != null) {
            this.webView.setVisibility(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo21657rr() {
        /*
            r2 = this;
            monitor-enter(r2)
            bqm r0 = r2.f13837c     // Catch:{ all -> 0x0018 }
            android.app.Activity r1 = r2.activity     // Catch:{ all -> 0x0018 }
            boolean r0 = r0.mo23576b(r1)     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r2)
            return
        L_0x000d:
            android.webkit.WebView r0 = r2.webView     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            android.webkit.WebView r0 = r2.webView     // Catch:{ all -> 0x0018 }
            r0.reload()     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r2)
            return
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.view.C3607e.mo21657r():void");
    }
    public synchronized void mo21657r() {
        if (this.f13837c.mo23576b(this.activity)) {
            if (this.webView != null) {
                this.webView.reload();
            }
        }
    }

    /* renamed from: s */
    public synchronized void mo21658s() {
        if (this.webView != null) {
            ViewGroup viewGroup = (ViewGroup) this.webView.getParent();
            if (viewGroup != null) {
                Log.e("LightningView", "WebView was not detached from window before onDestroy");
                viewGroup.removeView(this.webView);
            }
            this.webView.stopLoading();
            this.webView.onPause();
            this.webView.clearHistory();
            this.webView.setVisibility(8);
            this.webView.removeAllViews();
            this.webView.destroyDrawingCache();
            if (Build.VERSION.SDK_INT >= 18) {
                this.webView.destroy();
            }
            this.webView = null;
        }
    }

    /* renamed from: t */
    public synchronized void mo21659t() {
        if (this.webView != null) {
            this.webView.goBack();
            EventBus.getDefault().post(new bob(boi.m18319b().mo23264a(mo21633E()), this.webView.getUrl()));
        }
    }

    /* renamed from: u */
    public synchronized void mo21660u() {
        if (this.webView != null) {
            this.webView.goForward();
            EventBus.getDefault().post(new bob(boi.m18319b().mo23264a(mo21633E()), this.webView.getUrl()));
        }
    }

    /* renamed from: M */
    private String m15355M() {
        return this.webView != null ? this.webView.getSettings().getUserAgentString() : "";
    }

    /* renamed from: v */
    public synchronized void mo21661v() {
        if (this.webView != null) {
            this.webView.findNext(true);
        }
    }

    /* renamed from: w */
    public synchronized void mo21662w() {
        if (this.webView != null) {
            this.webView.findNext(false);
        }
    }

    /* renamed from: x */
    public synchronized void mo21663x() {
        if (this.webView != null) {
            this.webView.clearMatches();
        }
    }

    /* renamed from: y */
    public boolean mo21664y() {
        return this.f13847t;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15363c(String str) {
        if (this.webView != null) {
            WebView.HitTestResult hitTestResult = this.webView.getHitTestResult();
            String url = this.webView.getUrl();
            if (url == null || !bqv.m19001a(url)) {
                if (str != null) {
                    if (hitTestResult == null) {
                        this.f13836b.mo23123d(this.activity, this.f13840m, str);
                    } else if (hitTestResult.getType() == 8 || hitTestResult.getType() == 5) {
                        this.f13836b.mo23119a(this.activity, this.f13840m, str, m15355M(), this.webView);
                    } else {
                        this.f13836b.mo23123d(this.activity, this.f13840m, str);
                    }
                } else if (hitTestResult != null && hitTestResult.getExtra() != null) {
                    String extra = hitTestResult.getExtra();
                    if (hitTestResult.getType() == 8 || hitTestResult.getType() == 5) {
                        this.f13836b.mo23119a(this.activity, this.f13840m, extra, m15355M(), this.webView);
                    } else {
                        this.f13836b.mo23123d(this.activity, this.f13840m, extra);
                    }
                }
            } else if (url.endsWith("history.html")) {
                if (str != null) {
                    this.f13836b.mo23122c(this.activity, this.f13840m, str);
                } else if (hitTestResult != null && hitTestResult.getExtra() != null) {
                    this.f13836b.mo23122c(this.activity, this.f13840m, hitTestResult.getExtra());
                }
            } else if (url.endsWith("bookmarks.html")) {
                if (str != null) {
                    this.f13836b.mo23118a(this.activity, this.f13840m, str);
                } else if (hitTestResult != null && hitTestResult.getExtra() != null) {
                    this.f13836b.mo23118a(this.activity, this.f13840m, hitTestResult.getExtra());
                }
            } else if (!url.endsWith("downloads.html")) {
            } else {
                if (str != null) {
                    this.f13836b.mo23121b(this.activity, this.f13840m, str);
                } else if (hitTestResult != null && hitTestResult.getExtra() != null) {
                    this.f13836b.mo23121b(this.activity, this.f13840m, hitTestResult.getExtra());
                }
            }
        }
    }

    /* renamed from: z */
    public boolean mo21665z() {
        return this.webView != null && this.webView.canGoBack();
    }

    /* renamed from: A */
    public boolean mo21629A() {
        return this.webView != null && this.webView.canGoForward();
    }

    /* renamed from: B */
    public synchronized WebView mo21630B() {
        return this.webView;
    }

    /* renamed from: C */
    public Bitmap mo21631C() {
        return this.f13838k.mo21681a(this.f13840m.mo21350s());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo21636aa(String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            bqm r0 = r2.f13837c     // Catch:{ all -> 0x001a }
            android.app.Activity r1 = r2.activity     // Catch:{ all -> 0x001a }
            boolean r0 = r0.mo23576b(r1)     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r2)
            return
        L_0x000d:
            android.webkit.WebView r0 = r2.webView     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0018
            android.webkit.WebView r0 = r2.webView     // Catch:{ all -> 0x001a }
            java.util.Map<java.lang.String, java.lang.String> r1 = r2.f13849v     // Catch:{ all -> 0x001a }
            r0.loadUrl(r3, r1)     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r2)
            return
        L_0x001a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.view.C3607e.mo21636a(java.lang.String):void");
    }

    public synchronized void mo21636a(String str) {
        if (this.f13837c.mo23576b(this.activity)) {
            if (this.webView != null) {
                this.webView.loadUrl(str, this.f13849v);
            }
        }
    }
    /* renamed from: D */
    public String mo21632D() {
        return this.f13838k.mo21682a();
    }

    /* renamed from: E */
    public String mo21633E() {
        return (this.webView == null || this.webView.getUrl() == null) ? "" : this.webView.getUrl();
    }

    private class WebViewTouchListener implements View.OnTouchListener {

        float f13866a;

        float f13867b;

        int f13868c;

        private WebViewTouchListener() {
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view == null) {
                return false;
            }
            if (!view.hasFocus()) {
                view.requestFocus();
            }
            this.f13868c = motionEvent.getAction();
            this.f13867b = motionEvent.getY();
            if (this.f13868c == 0) {
                this.f13866a = this.f13867b;
            } else if (this.f13868c == 1) {
                float f = this.f13867b - this.f13866a;
                if (f > ((float) WebViewBrowser.f13829e) && view.getScrollY() < WebViewBrowser.f13829e) {
                    WebViewBrowser.this.f13840m.mo21288A();
                } else if (f < ((float) (-WebViewBrowser.f13829e))) {
                    WebViewBrowser.this.f13840m.mo21358z();
                }
                this.f13866a = 0.0f;
            }
            WebViewBrowser.this.gestureDetector.onTouchEvent(motionEvent);
            return false;
        }
    }

    private class C3615a extends GestureDetector.SimpleOnGestureListener {

        private boolean f13862b;

        private C3615a() {
            this.f13862b = true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int H = (int) ((100.0f * f2) / WebViewBrowser.f13832h);
            if (H < -10) {
                WebViewBrowser.this.f13840m.mo21358z();
            } else if (H > 15) {
                WebViewBrowser.this.f13840m.mo21288A();
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public void onLongPress(MotionEvent motionEvent) {
            Message obtainMessage;
            if (this.f13862b && (obtainMessage = WebViewBrowser.this.f13848u.obtainMessage()) != null) {
                obtainMessage.setTarget(WebViewBrowser.this.f13848u);
                if (WebViewBrowser.this.webView != null) {
                    WebViewBrowser.this.webView.requestFocusNodeHref(obtainMessage);
                }
            }
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            this.f13862b = false;
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
            this.f13862b = true;
        }
    }

    private static class C3619d extends Handler {

        private final WeakReference<WebViewBrowser> f13870a;

        C3619d(WebViewBrowser eVar) {
            this.f13870a = new WeakReference<>(eVar);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            String string = message.getData().getString("url");
            WebViewBrowser eVar = (WebViewBrowser) this.f13870a.get();
            if (eVar != null) {
                eVar.m15363c(string);
            }
        }
    }
}
