package video.downloader.videodownloader.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import javax.inject.Inject;

import classesdef.browser.bpn;
import video.downloader.videodownloader.app.BrowserApp;

/* renamed from: video.downloader.video.downloader.videodownloader.fragment.d */
public class PreferenceFragmentMain extends PreferenceFragment {
    @Inject

    /* renamed from: a */
            bpn f13812a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BrowserApp.m15129g().mo21507a(this);
    }
}
