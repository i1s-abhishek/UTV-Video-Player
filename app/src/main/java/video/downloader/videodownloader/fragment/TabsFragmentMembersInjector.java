package video.downloader.videodownloader.fragment;

import javax.inject.Provider;

import classesdef.browser.bpn;
import dagger.MembersInjector;

/* renamed from: video.downloader.video.downloader.videodownloader.fragment.f */
public final class TabsFragmentMembersInjector implements MembersInjector<TabsFragment> {

    /* renamed from: a */
    static final /* synthetic */ boolean f13815a = true;

    /* renamed from: b */
    private final Provider<bpn> f13816b;

    public TabsFragmentMembersInjector(Provider<bpn> provider) {
        if (f13815a || provider != null) {
            this.f13816b = provider;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<TabsFragment> m15337a(Provider<bpn> provider) {
        return new TabsFragmentMembersInjector(provider);
    }

    /* renamed from: a */
    public void injectMembers(TabsFragment tabsFragment) {
        if (tabsFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        tabsFragment.f13776a = this.f13816b.get();
    }
}
