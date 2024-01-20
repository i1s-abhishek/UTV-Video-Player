package video.downloader.videodownloader.fragment;

import javax.inject.Provider;

import classesdef.browser.bpn;
import dagger.MembersInjector;

/* renamed from: video.downloader.video.downloader.videodownloader.fragment.e */
public final class PreferenceFragmentMainMembersInjector implements MembersInjector<PreferenceFragmentMain> {

//    static final /* synthetic */ boolean f13813a = true;
    static final boolean f13813a = (!PreferenceFragmentMainMembersInjector.class.desiredAssertionStatus());

    private final Provider<bpn> f13814b;

    public PreferenceFragmentMainMembersInjector(Provider<bpn> provider) {
        if (f13813a || provider != null) {
            this.f13814b = provider;
            return;
        }
        throw new AssertionError();
    }


    public static MembersInjector<PreferenceFragmentMain> m15334a(Provider<bpn> provider) {
        return new PreferenceFragmentMainMembersInjector(provider);
    }


    public void injectMembers(PreferenceFragmentMain dVar) {
        if (dVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        dVar.f13812a = this.f13814b.get();
    }
}
