package video.downloader.videodownloader.activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import javax.inject.Inject;

import classesdef.browser.bpn;
import classesdef.browser.bqt;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

public abstract class ThemableSettingsActivity extends AppCompatPreferenceActivity {
    @Inject

    /* renamed from: a */
            bpn f13549a;

    /* renamed from: b */
    private int f13550b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        BrowserApp.m15129g().mo21501a(this);
        this.f13550b = this.f13549a.mo23438K();
        if (this.f13550b == 0) {
            setTheme(R.style.Theme_SettingsTheme);
            getWindow().setBackgroundDrawable(new ColorDrawable(bqt.m18986a((Context) this)));
        } else if (this.f13550b == 1) {
            setTheme(R.style.Theme_SettingsTheme_Dark);
            getWindow().setBackgroundDrawable(new ColorDrawable(bqt.m18991b(this)));
        } else if (this.f13550b == 2) {
            setTheme(R.style.Theme_SettingsTheme_Black);
            getWindow().setBackgroundDrawable(new ColorDrawable(bqt.m18991b(this)));
        }
        super.onCreate(bundle);
        m15058a();
    }

    /* renamed from: a */
    private void m15058a() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (this.f13549a.mo23446S()) {
            getWindow().setStatusBarColor(-16777216);
        } else {
            getWindow().setStatusBarColor(bqt.m18996d(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m15058a();
        if (this.f13549a.mo23438K() != this.f13550b) {
            m15059b();
        }
    }

    /* renamed from: b */
    private void m15059b() {
        recreate();
    }
}
