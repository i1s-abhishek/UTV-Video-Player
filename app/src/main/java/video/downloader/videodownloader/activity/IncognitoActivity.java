package video.downloader.videodownloader.activity;

import android.content.Intent;
import android.os.Build;
import android.view.Menu;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;
import hdplayer.xdplayer.videoplayer.R;


public class IncognitoActivity extends BrowserActivity {
    public boolean mo21307a() {
        return true;
    }

    public void mo21405b(String str, String str2) {
    }

    /* renamed from: c */
    public C3659b mo21314c() {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                CookieManager instance = CookieManager.getInstance();
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(IncognitoActivity.this);
                }
                instance.setAcceptCookie(IncognitoActivity.this.f13548e.mo23480s());
                eVar.mo23729a();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.incognito, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void mo21308b() {
        mo21301a((Runnable) new Runnable() {
            public void run() {
                IncognitoActivity.this.mo21347p();
            }
        });
    }
}
