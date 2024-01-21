package video.downloader.videodownloader.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import classesdef.browser.C4740s;
import classesdef.browser.bmf;
import classesdef.browser.bmy;
import classesdef.browser.bql;
import classesdef.browser.download.boi;
import classesdef.eventbus.bob;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

public class WebChromeClientBrowser extends WebChromeClient {
    @Inject
     bmy f13822a;

    private final Activity f13823b;

    private final WebViewBrowser f13824c;

    private final bmf f13825d;

    WebChromeClientBrowser(Activity activity, WebViewBrowser eVar) {
        bql.m18952a(activity);
        bql.m18952a(eVar);
        BrowserApp.m15129g().mo21508a(this);
        this.f13823b = activity;
        this.f13825d = (bmf) activity;
        this.f13824c = eVar;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (this.f13824c.mo21647h()) {
            this.f13825d.mo21323g(i);
        }
        EventBus.getDefault().post(new bob(boi.m18319b().mo23264a(webView.getUrl()), webView.getUrl()));
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        this.f13824c.mo21644e().mo21683a(bitmap);
        this.f13825d.mo21304a(this.f13824c);
        m15344a(webView.getUrl(), bitmap);
    }


    private void m15344a(String str, Bitmap bitmap) {
        if (bitmap != null && str != null && Uri.parse(str).getHost() != null) {
            this.f13822a.mo23132a(bitmap, str).mo21839a(C4740s.m21407e()).mo23839a();
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (str == null || str.isEmpty()) {
            this.f13824c.mo21644e().mo21684a(this.f13823b.getString(R.string.untitled));
        } else {
            this.f13824c.mo21644e().mo21684a(str);
        }
        this.f13825d.mo21304a(this.f13824c);
        if (webView != null && webView.getUrl() != null && !webView.getUrl().contains("gigya.com")) {
            this.f13825d.mo21405b(str, webView.getUrl());
        }
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        this.f13825d.mo21295a(message);
        return true;
    }

    public void onCloseWindow(WebView webView) {
        this.f13825d.mo21312b(this.f13824c);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        this.f13825d.mo21298a(valueCallback);
        return true;
    }

    public Bitmap getDefaultVideoPoster() {
        return BitmapFactory.decodeResource(this.f13823b.getResources(), 17301616);
    }

    public View getVideoLoadingProgressView() {
        return LayoutInflater.from(this.f13823b).inflate(R.layout.video_loading_progress, (ViewGroup) null);
    }

    public void onHideCustomView() {
        this.f13825d.mo21354v();
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        this.f13825d.mo21296a(view, customViewCallback);
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        this.f13825d.mo21297a(view, customViewCallback, i);
    }
}
