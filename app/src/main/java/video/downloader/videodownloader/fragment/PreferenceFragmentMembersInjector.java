package video.downloader.videodownloader.fragment;

import javax.inject.Provider;

import classesdef.browser.bpn;
import dagger.MembersInjector;

public final class PreferenceFragmentMembersInjector implements MembersInjector<PreferenceFragment_> {

  //  static final  boolean f13810a = true;
    static final /* synthetic */ boolean f13810a = (!PreferenceFragmentMembersInjector.class.desiredAssertionStatus());

    private final Provider<bpn> f13811b;

    public PreferenceFragmentMembersInjector(Provider<bpn> provider) {
        if (f13810a || provider != null) {
            this.f13811b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<PreferenceFragment_> m15331a(Provider<bpn> provider) {
        return new PreferenceFragmentMembersInjector(provider);
    }

    /* renamed from: a */
    public void injectMembers(PreferenceFragment_ bVar) {
        if (bVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bVar.f13808a = this.f13811b.get();
    }
}
