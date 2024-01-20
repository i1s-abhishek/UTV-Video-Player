package video.downloader.videodownloader.view;

import javax.inject.Provider;

import classesdef.browser.bqe;
import classesdef.browser.bqm;
import dagger.MembersInjector;

public final class WebViewClientBrowserMembersInjector implements MembersInjector<WebViewClientBrowser> {

//    static final boolean f13906a = true;
    static final  boolean f13906a = (!WebViewClientBrowserMembersInjector.class.desiredAssertionStatus());

    private final Provider<bqm> f13907b;

    private final Provider<bqe> f13908c;

    public WebViewClientBrowserMembersInjector(Provider<bqm> provider, Provider<bqe> provider2) {
        if (f13906a || provider != null) {
            this.f13907b = provider;
            if (f13906a || provider2 != null) {
                this.f13908c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<WebViewClientBrowser> m15433a(Provider<bqm> provider, Provider<bqe> provider2) {
        return new WebViewClientBrowserMembersInjector(provider, provider2);
    }

    public void injectMembers(WebViewClientBrowser hVar) {
        if (hVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        hVar.f13880a = this.f13907b.get();
        hVar.f13881b = this.f13908c.get();
    }
}
