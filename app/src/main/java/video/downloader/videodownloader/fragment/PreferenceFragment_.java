package video.downloader.videodownloader.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

import javax.inject.Inject;

import classesdef.browser.bpn;
import classesdef.browser.bqw;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

public class PreferenceFragment_ extends PreferenceFragment implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    @Inject
     bpn f13808a;

    private SwitchPreference f13809b;

    public boolean onPreferenceClick(Preference preference) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BrowserApp.m15129g().mo21506a(this);
        addPreferencesFromResource(R.xml.preference_debug);
        this.f13809b = (SwitchPreference) findPreference("leak_canary_enabled");
        this.f13809b.setChecked(this.f13808a.mo23447T());
        this.f13809b.setOnPreferenceChangeListener(this);
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        String key = preference.getKey();
        if (((key.hashCode() == -45875466 && key.equals("leak_canary_enabled")) ? (char) 0 : 65535) != 0) {
            return false;
        }
        boolean equals = Boolean.TRUE.equals(obj);
        this.f13808a.mo23467g(equals);
        Activity activity = getActivity();
        if (activity != null) {
            bqw.m19012a(activity, (int) R.string.app_restart);
        }
        this.f13809b.setChecked(equals);
        return true;
    }
}
