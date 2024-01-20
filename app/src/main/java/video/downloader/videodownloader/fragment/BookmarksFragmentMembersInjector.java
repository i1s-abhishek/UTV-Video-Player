package video.downloader.videodownloader.fragment;

import javax.inject.Provider;

import classesdef.browser.bmj;
import classesdef.browser.bms;
import classesdef.browser.bmy;
import classesdef.browser.bpn;
import dagger.MembersInjector;

public final class BookmarksFragmentMembersInjector implements MembersInjector<BookmarksFragment> {

    static final  boolean f13803a = true;

    private final Provider<bmj> f13804b;

    private final Provider<bms> f13805c;

    private final Provider<bpn> f13806d;

    private final Provider<bmy> f13807e;

    public BookmarksFragmentMembersInjector(Provider<bmj> provider, Provider<bms> provider2, Provider<bpn> provider3, Provider<bmy> provider4) {
        if (f13803a || provider != null) {
            this.f13804b = provider;
            if (f13803a || provider2 != null) {
                this.f13805c = provider2;
                if (f13803a || provider3 != null) {
                    this.f13806d = provider3;
                    if (f13803a || provider4 != null) {
                        this.f13807e = provider4;
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<BookmarksFragment> m15328a(Provider<bmj> provider, Provider<bms> provider2, Provider<bpn> provider3, Provider<bmy> provider4) {
        return new BookmarksFragmentMembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(BookmarksFragment bookmarksFragment) {
        if (bookmarksFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bookmarksFragment.f13729a = this.f13804b.get();
        bookmarksFragment.f13730b = this.f13805c.get();
        bookmarksFragment.f13731c = this.f13806d.get();
        bookmarksFragment.f13732d = this.f13807e.get();
    }
}
