package com.abhishek.xplayer.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;

import com.abhishek.xplayer.application.AppActivity;

import java.util.Locale;

import classesdef.ads.RemoteCloudConfig;
import classesdef.inplayer.awz;
import classesdef.inplayer.SharedPrefrence;

import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;


public class SettingWebViewActivity extends AppActivity {

    /* renamed from: d */
    private static boolean f10282d = false;

    /* renamed from: a */
    private WebView f10283a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ProgressBar f10284c;

    /* renamed from: e */
    private String f10285e;

    /* renamed from: f */
    private String f10286f;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int loadActivity() {
        return R.layout.settings_webview;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str = null;
        super.onCreate(bundle);
        this.f10284c = (ProgressBar) findViewById(R.id.web_loading_progress);
        this.f10283a = (WebView) findViewById(R.id.webview);
        this.f10286f = getIntent().getStringExtra("content");
        if (this.f10286f == null) {
            this.f10286f = "Help";
        }
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setHomeAsUpIndicator((int) R.drawable.ic_back);
        String str2 = null;
        supportActionBar.setSubtitle((CharSequence) null);
        if (this.f10286f.equals("Help")) {
            //this.f10285e = "https://inshot.cc/website/HDPlayer/help.html";
            this.f10285e = "https://sites.google.com/view/videoplayer-help/home";
            supportActionBar.setTitle((int) R.string.help);
            str2 = "ja,ko,ru";
        } else if (this.f10286f.equals("CastHelp")) {
           // this.f10285e = "https://inshot.cc/website/HDPlayer/help.html#cast";
            this.f10285e = "https://sites.google.com/view/videoplayer-help/home";
            supportActionBar.setTitle((int) R.string.help);
            str2 = "ja,ko,ru";
        } else if (this.f10286f.equals("Policy")) {
            //this.f10285e = "https://inshot.cc/website/policy.html?app=HD%20Video%20Player";
            this.f10285e = "https://sites.google.com/view/videoplayer-privacypolicys/home";
            supportActionBar.setTitle((int) R.string.policy);
        } else if (this.f10286f.equals("Legal")) {
          //  this.f10285e = "https://inshot.cc/website/HDPlayer/legal.html";
            this.f10285e = "https://sites.google.com/view/videoplayer-legal/home";
            supportActionBar.setTitle((int) R.string.legal);
        }
        String a = RemoteCloudConfig.m18216a("lang_" + this.f10286f, str2);
        if (a != null) {
            String[] split = a.split(",");
            Locale a2 = axy.getLocal((Context) this, SharedPrefrence.language(this));
            if (split.length > 0 && a2 != null) {
                String language = a2.getLanguage();
                String str3 = language + "_" + a2.getCountry();
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    str = split[i];
                    if (language.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str)) {
                        int lastIndexOf = this.f10285e.lastIndexOf(46);
                    } else {
                        i++;
                    }
                }
                int lastIndexOf2 = this.f10285e.lastIndexOf(46);
                if (lastIndexOf2 >= 0) {
                    this.f10285e = this.f10285e.substring(0, lastIndexOf2) + "_" + str + this.f10285e.substring(lastIndexOf2);
                }
            }
        }
        this.f10283a.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    SettingWebViewActivity.this.f10284c.setVisibility(8);
                }
            }
        });
        this.f10283a.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str == null || !str.toLowerCase(Locale.ENGLISH).startsWith("http") || (!str.contains("inshot") && !str.contains("instashot") && !str.contains("xplayer"))) {
                    SettingWebViewActivity.this.mo17687a(str);
                    return true;
                }
                webView.loadUrl(str);
                return true;
            }
        });
        WebSettings settings = this.f10283a.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        this.f10283a.loadUrl(this.f10285e);
        if (f10282d) {
            mo17687a(this.f10285e);
            f10282d = false;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (isFinishing()) {
            return false;
        }
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f10283a != null) {
            this.f10283a.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f10283a != null) {
            this.f10283a.onResume();
        }
    }

    /* renamed from: a */
    public void mo17687a(String str) {
        if (str == null || !str.startsWith("mailto")) {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(parse);
            try {
                startActivity(intent);
            } catch (Exception unused) {
            }
        } else {
            awz.m7244c(this);
        }
    }

    public void onStart() {
        super.onStart();
        StringBuilder sb = new StringBuilder();
        sb.append("Setting/");
        sb.append(this.f10286f != null ? this.f10286f : "Null");
        LogEvents.m18498d(sb.toString());
    }
}
