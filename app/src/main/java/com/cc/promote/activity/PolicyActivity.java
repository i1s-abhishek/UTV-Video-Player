package com.cc.promote.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.mopub.common.MoPub;
import com.mopub.common.privacy.ConsentStatus;
import com.mopub.common.privacy.PersonalInfoManager;


import org.json.JSONObject;

import hdplayer.xdplayer.videoplayer.R;

/* renamed from: com.cc.promote.activity.PolicyActivity */
public class PolicyActivity extends AppCompatActivity {

    /* renamed from: a */
    private ActionBar f6507a = null;

    /* renamed from: b */
    private WebView f6508b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ProgressBar f6509c;

    /* renamed from: d */
    private String f6510d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (this.f6507a == null) {
                this.f6507a = getSupportActionBar();
            }
            this.f6507a.setDisplayHomeAsUpEnabled(true);
            this.f6507a.setBackgroundDrawable(new ColorDrawable(getIntent().getIntExtra("color", -16777216)));
            this.f6507a.show();
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(getIntent().getIntExtra("statusBarColor", -16777216));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentView(R.layout.ad_policy_activity);
        this.f6510d = getIntent().getStringExtra(NotificationCompat.CATEGORY_EMAIL);
        String str = getIntent().getStringExtra("url") + "?pkg=" + getPackageName();
        try {
            setTitle(getIntent().getStringExtra("title"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        m8013a(str);
    }

    /* renamed from: a */
    private void m8013a(String str) {
        this.f6509c = (ProgressBar) findViewById(R.id.progress_bar);
        this.f6508b = (WebView) findViewById(R.id.ad_consent_webview);
        this.f6508b.getSettings().setJavaScriptEnabled(true);
        this.f6508b.addJavascriptInterface(new C1436a(), "getPrivacyPolicy");
        this.f6508b.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return super.shouldOverrideUrlLoading(webView, str);
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                PolicyActivity.this.f6509c.setVisibility(0);
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageFinished(WebView webView, String str) {
                PolicyActivity.this.f6509c.setVisibility(8);
                super.onPageFinished(webView, str);
                PolicyActivity.this.m8012a();
            }
        });
        this.f6508b.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    PolicyActivity.this.f6509c.setVisibility(8);
                    return;
                }
                PolicyActivity.this.f6509c.setVisibility(0);
                PolicyActivity.this.f6509c.setProgress(i);
            }
        });
        this.f6508b.loadUrl(str);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f6508b != null) {
                this.f6508b.removeAllViews();
                this.f6508b.setTag((Object) null);
                this.f6508b.clearCache(true);
                this.f6508b.clearHistory();
                this.f6508b.destroy();
                this.f6508b = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8012a() {
        if (this.f6508b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, this.f6510d);
                if (MoPub.getPersonalInformationManager().getPersonalInfoConsentStatus() == ConsentStatus.EXPLICIT_YES) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, "agree");
                } else {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, "disagree");
                }
                WebView webView = this.f6508b;
                webView.loadUrl("javascript:setStyle(" + jSONObject + ")");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.cc.promote.activity.PolicyActivity$a */
    class C1436a {
        C1436a() {
        }

        @JavascriptInterface
        public void getStatus(String str) {
            Log.e("result", str);
            try {
                String string = new JSONObject(str).getString(NotificationCompat.CATEGORY_STATUS);
                PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
                if (string.equals("disagree")) {
                    personalInformationManager.revokeConsent();
                } else {
                    personalInformationManager.grantConsent();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
