package video.downloader.videodownloader.activity;

import javax.inject.Provider;

import classesdef.browser.bpn;
import dagger.MembersInjector;
public final class SettingsActivityMembersInjector implements MembersInjector<SettingsActivity> {

  //  static final  boolean f13559a = true;
    static final /* synthetic */ boolean f13559a = (!SettingsActivityMembersInjector.class.desiredAssertionStatus());

    private final Provider<bpn> f13560b;

    public SettingsActivityMembersInjector(Provider<bpn> provider) {
        if (f13559a || provider != null) {
            this.f13560b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<SettingsActivity> m15069a(Provider<bpn> provider) {
        return new SettingsActivityMembersInjector(provider);
    }

    public void injectMembers(SettingsActivity settingsActivity) {
        if (settingsActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        settingsActivity.f13525b = this.f13560b.get();
    }
}
