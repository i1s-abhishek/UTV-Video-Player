package classesdef.browser.download;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebView;

import javax.inject.Inject;

import classesdef.browser.bpn;
import video.downloader.videodownloader.activity.TabsManager;
import video.downloader.videodownloader.app.BrowserApp;
import video.downloader.videodownloader.five.activity.BrowserDownloaderActivity;

/* renamed from: bmw */
public class bmw implements DownloadListener {
    @Inject
    public

    /* renamed from: a */
            bpn f15798a;
    @Inject
    public

    /* renamed from: b */
    bmn f15799b;

    /* renamed from: c */
    private final Activity f15800c;

    /* renamed from: d */
    private WebView f15801d;

    public bmw(Activity activity, WebView webView) {
        BrowserApp.m15129g().mo21494a(this);
        this.f15800c = activity;
        this.f15801d = webView;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (!TextUtils.isEmpty(str)) {
            if (TabsManager.f13561a) {
                Intent intent = new Intent(this.f15800c, BrowserDownloaderActivity.class);
                intent.putExtra("url", str);
                this.f15800c.startActivity(intent);
            } else if (this.f15801d == null) {
                boi.m18319b().mo23269a((Context) this.f15800c, str, "", "");
            } else {
                boi.m18319b().mo23269a((Context) this.f15800c, str, this.f15801d.getUrl(), this.f15801d.getTitle());
            }
        }
    }
}
