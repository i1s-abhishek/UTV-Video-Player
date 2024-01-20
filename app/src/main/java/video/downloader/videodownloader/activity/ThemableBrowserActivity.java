package video.downloader.videodownloader.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import javax.inject.Inject;

import classesdef.browser.bpn;
import classesdef.browser.bqt;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;
import video.downloader.videodownloader.five.activity.BasePermissionActivity;

public abstract class ThemableBrowserActivity extends BasePermissionActivity {

    private int f13545a;

    private boolean f13546b;

    private boolean f13547c = false;
    @Inject
            bpn f13548e;

    /* access modifiers changed from: package-private */
    public void mo21320f() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        BrowserApp.m15129g().mo21500a(this);
        this.f13545a = this.f13548e.mo23438K();
        this.f13546b = this.f13548e.mo23451a(!mo21438D());
        if (this.f13545a == 1) {
            setTheme(R.style.Theme_DarkTheme);
        } else if (this.f13545a == 2) {
            setTheme(R.style.Theme_BlackTheme);
        }
        super.onCreate(bundle);
        mo21307a();
    }

    /* renamed from: a */
    private void mo21307a() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (this.f13548e.mo23446S()) {
            getWindow().setStatusBarColor(-16777216);
        } else {
            getWindow().setStatusBarColor(bqt.m18996d(this));
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.f13547c) {
            this.f13547c = false;
            mo21320f();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        mo21307a();
        this.f13547c = true;
        int K = this.f13548e.mo23438K();
        boolean a = this.f13548e.mo23451a(true ^ mo21438D());
        if (K != this.f13545a || this.f13546b != a) {
            mo21439E();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean mo21438D() {
        return (getResources().getConfiguration().screenLayout & 15) == 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public void mo21439E() {
        finish();
        startActivity(new Intent(this, getClass()));
    }
}
