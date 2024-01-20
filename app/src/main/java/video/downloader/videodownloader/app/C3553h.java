package video.downloader.videodownloader.app;

import javax.inject.Provider;

import classesdef.browser.bmj;
import classesdef.browser.bpn;
import dagger.MembersInjector;

public final class C3553h implements MembersInjector<BrowserApp> {

    //static final boolean f13614a = true;
    static final  boolean f13614a = (!C3553h.class.desiredAssertionStatus());

    /* renamed from: b */
    private final Provider<bpn> f13615b;

    /* renamed from: c */
    private final Provider<bmj> f13616c;

    public C3553h(Provider<bpn> provider, Provider<bmj> provider2) {
        if (f13614a || provider != null) {
            this.f13615b = provider;
            if (f13614a || provider2 != null) {
                this.f13616c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<BrowserApp> m15175a(Provider<bpn> provider, Provider<bmj> provider2) {
        return new C3553h(provider, provider2);
    }

    /* renamed from: a */
    public void injectMembers(BrowserApp browserApp) {
        if (browserApp == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        browserApp.f13597a = this.f13615b.get();
        browserApp.f13598b = this.f13616c.get();
    }
}
