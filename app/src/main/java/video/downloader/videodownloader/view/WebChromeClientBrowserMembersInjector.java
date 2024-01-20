package video.downloader.videodownloader.view;

import javax.inject.Provider;

import classesdef.browser.bmy;
import dagger.MembersInjector;

public final class WebChromeClientBrowserMembersInjector implements MembersInjector<WebChromeClientBrowser> {

  //  static final  boolean f13826a = true;
    static final /* synthetic */ boolean f13826a = (!WebChromeClientBrowserMembersInjector.class.desiredAssertionStatus());

    private final Provider<bmy> f13827b;

    public WebChromeClientBrowserMembersInjector(Provider<bmy> provider) {
        if (f13826a || provider != null) {
            this.f13827b = provider;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<WebChromeClientBrowser> m15345a(Provider<bmy> provider) {
        return new WebChromeClientBrowserMembersInjector(provider);
    }

    /* renamed from: a */
    public void injectMembers(WebChromeClientBrowser cVar) {
        if (cVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        cVar.f13822a = this.f13827b.get();
    }
}
