package video.downloader.videodownloader.activity;

import javax.inject.Provider;

import classesdef.browser.bpn;
import dagger.MembersInjector;

public final class ThemableSettingsActivityMembersInjector implements MembersInjector<ThemableSettingsActivity> {

    //static final /* synthetic */ boolean f13594a = true;
    static final /* synthetic */ boolean f13594a = (!ThemableSettingsActivityMembersInjector.class.desiredAssertionStatus());

    private final Provider<bpn> f13595b;

    public ThemableSettingsActivityMembersInjector(Provider<bpn> provider) {
        if (f13594a || provider != null) {
            this.f13595b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<ThemableSettingsActivity> m15125a(Provider<bpn> provider) {
        return new ThemableSettingsActivityMembersInjector(provider);
    }

    public void injectMembers(ThemableSettingsActivity themableSettingsActivity) {
        if (themableSettingsActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        themableSettingsActivity.f13549a = this.f13595b.get();
    }
}
