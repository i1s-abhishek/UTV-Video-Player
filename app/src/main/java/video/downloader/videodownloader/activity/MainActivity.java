package video.downloader.videodownloader.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import androidx.appcompat.view.menu.MenuBuilder;

import com.abhishek.xplayer.ad.MopubIntertitialAd;
import com.abhishek.xplayer.ad.AdmobIntertitialAds;

import java.util.Locale;

import classesdef.browser.bbc;
import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;


public class MainActivity extends BrowserActivity {
    public boolean mo21307a() {
        return false;
    }
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
       if (MopubIntertitialAd.createInstance2().mo16969g() || AdmobIntertitialAds.create().mo16898b()) {
            LogEvents.m18486a("SplashAd", "Show", "Downloader");
        }
    }

    public C3659b mo21314c() {
        return C3659b.m15696a((C4067c) new C4067c() {
            public void mo21407a(C4165e eVar) {
                CookieManager instance = CookieManager.getInstance();
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(MainActivity.this);
                }
                instance.setAcceptCookie(MainActivity.this.f13548e.mo23474m());
                eVar.mo23729a();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        LogEvents.m18498d("BrowserPage");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        boolean z = true;
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        MenuItem findItem = menu.findItem(R.id.agent_desktop);
        if (findItem != null) {
            findItem.setChecked(this.f13548e.mo23441N() == 2);
        }
        try {
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                z = false;
            }
            if (z) {
                MenuItem findItem2 = menu.findItem(R.id.action_new_tab);
                if (findItem2 != null) {
                    findItem2.setIcon((Drawable) null);
                }
                MenuItem findItem3 = menu.findItem(R.id.action_share);
                if (findItem3 != null) {
                    findItem3.setIcon((Drawable) null);
                }
                MenuItem findItem4 = menu.findItem(R.id.action_history);
                if (findItem4 != null) {
                    findItem4.setIcon((Drawable) null);
                }
                MenuItem findItem5 = menu.findItem(R.id.action_copy);
                if (findItem5 != null) {
                    findItem5.setIcon((Drawable) null);
                }
                MenuItem findItem6 = menu.findItem(R.id.action_bookmarks);
                if (findItem6 != null) {
                    findItem6.setIcon((Drawable) null);
                }
                MenuItem findItem7 = menu.findItem(R.id.action_add_bookmark);
                if (findItem7 != null) {
                    findItem7.setIcon((Drawable) null);
                }
                MenuItem findItem8 = menu.findItem(R.id.agent_desktop);
                if (findItem8 != null) {
                    findItem8.setIcon((Drawable) null);
                }
                MenuItem findItem9 = menu.findItem(R.id.action_settings);
                if (findItem9 != null) {
                    findItem9.setIcon((Drawable) null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (m14866a(intent)) {
            mo21318e();
            return;
        }
        mo21310b(intent);
        super.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        mo21349r();
    }

    /* renamed from: b */
    public void mo21405b(String str, String str2) {
        mo21302a(str, str2);
    }

    /* renamed from: b */
    public void mo21308b() {
        mo21301a((Runnable) new Runnable() {
            public void run() {
                MainActivity.this.mo21331o();
                MainActivity.this.mo21348q();
                MainActivity.this.finish();
            }
        });
    }
}
