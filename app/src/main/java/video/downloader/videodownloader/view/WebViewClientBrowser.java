package video.downloader.videodownloader.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.abhishek.xplayer.ShareProvider;
import com.orhanobut.logger.Logger;


import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Map;

import javax.inject.Inject;

import classesdef.browser.bbc;
import classesdef.browser.bmf;
import classesdef.browser.bmr;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.bqe;
import classesdef.browser.bqj;
import classesdef.browser.bql;
import classesdef.browser.bqm;
import classesdef.browser.bqq;
import classesdef.browser.bqw;
import classesdef.browser.download.boi;
import classesdef.browser.download.bol;
import classesdef.browser.download.bpd;
import classesdef.eventbus.bnr;
import classesdef.eventbus.bob;
import classesdef.xdplayer.bpj;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;
import video.downloader.videodownloader.five.service.ManualParseService;

public class WebViewClientBrowser extends WebViewClient {
    @Inject
     bqm f13880a;
    @Inject
     bqe f13881b;

    public final Activity f13882c;

    private final WebViewBrowser f13883d;

    private final bmf f13884e;

    private final bqj f13885f;

    /* renamed from: g */
    public volatile boolean f13886g = false;

    public float f13887h = 0.0f;

    WebViewClientBrowser(Activity activity, WebViewBrowser eVar) {
        BrowserApp.m15129g().mo21510a(this);
        bql.m18952a(activity);
        bql.m18952a(eVar);
        this.f13882c = activity;
        this.f13884e = (bmf) activity;
        this.f13883d = eVar;
        this.f13881b.mo23562a();
        this.f13885f = new bqj(activity);
    }

    public void onLoadResource(WebView webView, final String str) {
        if (!bol.m18346a().mo23281a(webView.getUrl()) && !bqq.m18971a(this.f13882c, webView.getUrl()) && !bqq.m18976c(this.f13882c, str) && this.f13883d != null && this.f13883d.mo21651l() && !TextUtils.isEmpty(str)) {
            if (str.contains("skyfire") && str.contains("vimeo") && str.endsWith("master.json?base64_init=1")) {
                final String url = webView.getUrl();
                final String title = webView.getTitle();
                new Thread(new Runnable() {
                    public void run() {
                        ManualParseService.m15232a(WebViewClientBrowser.this.f13882c, str, url, title);
                    }
                }).start();
            } else if (str.contains("www.dailymotion.com/player/metadata/video/")) {
                ManualParseService.m15233a((Context) this.f13882c, webView);
            } else {
                boi.m18319b().mo23271a(this.f13882c, str, webView.getUrl(), webView.getTitle(), false);
            }
            ((ScrollListenerWebView) webView).mo21364a();

        }
    }

    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.f13881b.mo23563a(webResourceRequest.getUrl().toString())) {
            return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream("".getBytes()));
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @TargetApi(20)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.f13881b.mo23563a(str)) {
            return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream("".getBytes()));
        }
        return null;
    }

    @TargetApi(19)
    public void onPageFinished(WebView webView, String str) {
        if (webView.isShown()) {
            this.f13884e.mo21303a(str, true);
            this.f13884e.mo21313b(webView.canGoBack());
            this.f13884e.mo21305a(webView.canGoForward());
            webView.postInvalidate();
        }
        if (webView.getTitle() == null || webView.getTitle().isEmpty()) {
            this.f13883d.mo21644e().mo21684a(this.f13882c.getString(R.string.untitled));
        } else {
            this.f13883d.mo21644e().mo21684a(webView.getTitle());
        }
        if (Build.VERSION.SDK_INT >= 19 && this.f13883d.mo21664y()) {
            webView.evaluateJavascript("javascript:(function(){var e='img {-webkit-filter: invert(100%);'+'-moz-filter: invert(100%);'+'-o-filter: invert(100%);'+'-ms-filter: invert(100%); }',t=document.getElementsByTagName('head')[0],n=document.createElement('style');if(!window.counter){window.counter=1}else{window.counter++;if(window.counter%2==0){var e='html {-webkit-filter: invert(0%); -moz-filter: invert(0%); -o-filter: invert(0%); -ms-filter: invert(0%); }'}}n.type='text/css';if(n.styleSheet){n.styleSheet.cssText=e}else{n.appendChild(document.createTextNode(e))}t.appendChild(n)})();", (ValueCallback) null);
        }
        this.f13884e.mo21304a(this.f13883d);
        ManualParseService.m15233a((Context) this.f13882c, webView);
        BrowserLogEvent.downloaderLogEvent(this.f13882c, "web_collect", bqw.m19011a(str));
        bpd.m18516f(this.f13882c, str);
        if (bpj.m18578a((Context) this.f13882c).mo23416w() == 0 && str.toLowerCase().contains(bol.m18346a().mo23284c())) {
            bpj.m18578a((Context) this.f13882c).mo23394f(System.currentTimeMillis());
            bpj.m18578a((Context) this.f13882c).mo23375b((Context) this.f13882c);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f13883d.mo21644e().mo21683a((Bitmap) null);
        if (this.f13883d.mo21647h()) {
            this.f13884e.mo21303a(str, false);
            this.f13884e.mo21288A();
        }
        this.f13884e.mo21304a(this.f13883d);
        Logger.e("onPageStarted = " + webView.getUrl(), new Object[0]);
        EventBus.getDefault().post(new bob(boi.m18319b().mo23264a(webView.getUrl()), webView.getUrl()));
    }

    public void onReceivedHttpAuthRequest(WebView webView, final HttpAuthHandler httpAuthHandler, String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f13882c);
        View inflate = LayoutInflater.from(this.f13882c).inflate(R.layout.dialog_auth_request, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.auth_request_username_edittext);
        final EditText editText2 = (EditText) inflate.findViewById(R.id.auth_request_password_edittext);
        ((TextView) inflate.findViewById(R.id.auth_request_realm_textview)).setText(this.f13882c.getString(R.string.label_realm, new Object[]{str2}));
        builder.setView(inflate).setTitle((int) R.string.title_sign_in).setCancelable(true).setPositiveButton((int) R.string.title_sign_in, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                httpAuthHandler.proceed(editText.getText().toString().trim(), editText2.getText().toString().trim());
                Log.d("LightningWebClient", "Attempting HTTP Authentication");
            }
        }).setNegativeButton((int) R.string.action_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                httpAuthHandler.cancel();
            }
        });
        AlertDialog create = builder.create();
        create.show();
        bmr.m18088a(this.f13882c, create);
    }

    @TargetApi(19)
    public void onScaleChanged(final WebView webView, float f, final float f2) {
        if (webView.isShown() && this.f13883d.f13835a.mo23435H() && Build.VERSION.SDK_INT >= 19 && !this.f13886g && Math.abs(100.0f - ((100.0f / this.f13887h) * f2)) > 2.5f && !this.f13886g) {
            this.f13886g = webView.postDelayed(new Runnable() {
                public void run() {
                    float unused = WebViewClientBrowser.this.f13887h = f2;
                    webView.evaluateJavascript("javascript:document.getElementsByTagName('body')[0].style.width=window.innerWidth+'px';", new ValueCallback<String>() {
                        /* renamed from: a */
                        public void onReceiveValue(String str) {
                            boolean unused = WebViewClientBrowser.this.f13886g = false;
                        }
                    });
                }
            }, 100);
        }
    }

    public void onFormResubmission(WebView webView, final Message message, final Message message2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f13882c);
        builder.setTitle((CharSequence) this.f13882c.getString(R.string.title_form_resubmission));
        builder.setMessage((CharSequence) this.f13882c.getString(R.string.message_form_resubmission)).setCancelable(true).setPositiveButton((CharSequence) this.f13882c.getString(R.string.action_yes), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                message2.sendToTarget();
            }
        }).setNegativeButton((CharSequence) this.f13882c.getString(R.string.action_no), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                message.sendToTarget();
            }
        });
        AlertDialog create = builder.create();
        create.show();
        bmr.m18088a(this.f13882c, create);
    }

    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return m15428a(webView, webResourceRequest.getUrl().toString()) || super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return m15428a(webView, str) || super.shouldOverrideUrlLoading(webView, str);
    }

    private boolean m15428a(WebView webView, String str) {
        Logger.e("shouldOverrideLoading : " + webView.getUrl(), new Object[0]);
        EventBus.getDefault().post(new bob(boi.m18319b().mo23264a(webView.getUrl()), webView.getUrl()));
        if (!this.f13880a.mo23576b(this.f13882c)) {
            return true;
        }
        Map<String, String> g = this.f13883d.mo21646g();
        if (this.f13883d.mo21645f()) {
            return m15429a(webView, str, g);
        }
        if (str.startsWith("about:")) {
            return m15429a(webView, str, g);
        }
        if (m15430a(str, webView)) {
            return true;
        }
        return m15429a(webView, str, g);
    }

    private boolean m15429a(WebView webView, String str, Map<String, String> map) {
        if (map.isEmpty() || !bqw.m19017a()) {
            return false;
        }
        webView.loadUrl(str, map);
        return true;
    }

    private boolean m15430a(String str, WebView webView) {
        Intent intent;
        if (str.startsWith("mailto:")) {
            MailTo parse = MailTo.parse(str);
            this.f13882c.startActivity(bqw.m19009a(parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc()));
            webView.reload();
            return true;
        }
        if (str.startsWith("intent://")) {
            try {
                intent = Intent.parseUri(str, 1);
            } catch (URISyntaxException unused) {
                intent = null;
            }
            if (intent != null) {
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent((ComponentName) null);
                if (Build.VERSION.SDK_INT >= 15) {
                    intent.setSelector((Intent) null);
                }
                try {
                    this.f13882c.startActivity(intent);
                } catch (ActivityNotFoundException unused2) {
                    Log.e("LightningWebClient", "ActivityNotFoundException");
                }
                return true;
            }
        } else if (str.startsWith("file://")) {
            File file = new File(str.replace("file://", ""));
            if (file.exists()) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(bqw.getFileType(file.toString()));
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW");
                intent2.setFlags(1);
                intent2.setDataAndType(ShareProvider.m11567a(file), mimeTypeFromExtension);
                try {
                    this.f13882c.startActivity(intent2);
                } catch (Exception unused3) {
                    System.out.println("LightningWebClient: cannot open downloaded file");
                }
                return true;
            }
        } else if (!TextUtils.isEmpty(str) && !str.startsWith("http")) {
            try {
                int indexOf = str.indexOf("://");
                if (indexOf > 0) {
                    if (bpd.m18517g(this.f13882c, str.substring(0, indexOf))) {
                        this.f13882c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        EventBus.getDefault().post(new bnr());
                        return true;
                    }
                }
            } catch (Exception e) {
                bbc.m15886a().mo21879a((Context) this.f13882c, (Throwable) e);
            }
        }
        return false;
    }
}
