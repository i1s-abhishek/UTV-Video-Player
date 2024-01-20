package video.downloader.videodownloader.five.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import hdplayer.vlcplayer.videoplayer.R;


public class PrivacyPolicyActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private WebView webView;
    public ProgressBar progressBar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_privacy_policy);
        m15229a();
        m15230b();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: a */
    private void m15229a() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar.setTitle((CharSequence) getString(R.string.privacy_policy));
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.webView = (WebView) findViewById(R.id.webView);
    }

    /* renamed from: b */
    private void m15230b() {
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        this.webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                if (i >= 100) {
                    PrivacyPolicyActivity.this.progressBar.setVisibility(8);
                }
            }
        });
        this.webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView webView, int i, String str, String str2) {
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        WebSettings settings = this.webView.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        this.webView.loadUrl("https://sites.google.com/view/videoplayer-privacypolicys/home");
    }
}
