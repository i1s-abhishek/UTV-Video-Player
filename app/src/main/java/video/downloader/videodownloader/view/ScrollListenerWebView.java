package video.downloader.videodownloader.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;

import classesdef.browser.BrowserData;
import classesdef.browser.bqq;
import video.downloader.videodownloader.five.service.ManualParseService;

public class ScrollListenerWebView extends WebView {

    private Handler handler;

    private long aLong;

    public ScrollListenerWebView(Context context) {
        super(context);
        m14539b();
    }

    public ScrollListenerWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14539b();
    }

    public ScrollListenerWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14539b();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.handler.hasMessages(8)) {
            this.handler.removeMessages(8);
        }
        this.handler.sendEmptyMessageDelayed(8, 1000);
    }

    /* renamed from: b */
    private void m14539b() {
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                if (message.what == 8) {
                    ScrollListenerWebView.this.mo21364a();
                }
            }
        };
    }

    /* renamed from: a */
    public void mo21364a() {
        if (System.currentTimeMillis() - this.aLong >= 800) {
            this.aLong = System.currentTimeMillis();
            try {
              if (ManualParseService.m14409d(getContext(), getUrl()) && bqq.m21726c(getContext())) {
                    String d = bqq.m21728d(getContext());
                    if (!TextUtils.isEmpty(d)) {
                        loadUrl(d);
                    }
                } else if (ManualParseService.m14411e(getContext(), getUrl()) && bqq.m21730e(getContext())) {
                    String f = bqq.m21731f(getContext());
                    if (!TextUtils.isEmpty(f)) {
                        loadUrl(f);
                    }
                } else if (TextUtils.isEmpty(C3370c.f11781a) && ManualParseService.m14414f(getContext(), getUrl())) {
                    loadUrl(BrowserData.m21111t(getContext()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Error e2) {
                e2.printStackTrace();
            }
        }
    }
}
