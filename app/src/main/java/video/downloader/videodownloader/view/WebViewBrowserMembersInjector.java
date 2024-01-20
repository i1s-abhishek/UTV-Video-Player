package video.downloader.videodownloader.view;

import javax.inject.Provider;

import classesdef.browser.bms;
import classesdef.browser.bpn;
import classesdef.browser.bqm;
import dagger.MembersInjector;

public final class WebViewBrowserMembersInjector implements MembersInjector<WebViewBrowser> {

  //  static final  boolean f13876a = true;
    static final  boolean f13876a = (!WebViewBrowserMembersInjector.class.desiredAssertionStatus());

    private final Provider<bpn> f13877b;

    private final Provider<bms> f13878c;

    private final Provider<bqm> f13879d;

    public WebViewBrowserMembersInjector(Provider<bpn> provider, Provider<bms> provider2, Provider<bqm> provider3) {
        if (f13876a || provider != null) {
            this.f13877b = provider;
            if (f13876a || provider2 != null) {
                this.f13878c = provider2;
                if (f13876a || provider3 != null) {
                    this.f13879d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<WebViewBrowser> m15423a(Provider<bpn> provider, Provider<bms> provider2, Provider<bqm> provider3) {
        return new WebViewBrowserMembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(WebViewBrowser eVar) {
        if (eVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        eVar.f13835a = this.f13877b.get();
        eVar.f13836b = this.f13878c.get();
        eVar.f13837c = this.f13879d.get();
    }
}
