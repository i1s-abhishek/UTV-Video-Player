package video.downloader.videodownloader.activity;

import javax.inject.Provider;

import classesdef.browser.bmj;
import classesdef.browser.bms;
import classesdef.browser.bpn;
import classesdef.browser.bqm;
import dagger.MembersInjector;

/* renamed from: video.downloader.video.downloader.videodownloader.activity.b */
public final class BrowserActivityMembersInjector implements MembersInjector<BrowserActivity> {

   // static final  boolean f13552a = true;
    static final /* synthetic */ boolean f13552a = (!BrowserActivityMembersInjector.class.desiredAssertionStatus());


    private final Provider<bpn> f13553b;

    private final Provider<bmj> f13554c;

    private final Provider<bms> f13555d;

    private final Provider<bqm> f13556e;

    public BrowserActivityMembersInjector(Provider<bpn> provider, Provider<bmj> provider2, Provider<bms> provider3, Provider<bqm> provider4) {
        if (f13552a || provider != null) {
            this.f13553b = provider;
            if (f13552a || provider2 != null) {
                this.f13554c = provider2;
                if (f13552a || provider3 != null) {
                    this.f13555d = provider3;
                    if (f13552a || provider4 != null) {
                        this.f13556e = provider4;
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

    public static MembersInjector<BrowserActivity> m15063a(Provider<bpn> provider, Provider<bmj> provider2, Provider<bms> provider3, Provider<bqm> provider4) {
        return new BrowserActivityMembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(BrowserActivity browserActivity) {
        if (browserActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        browserActivity.f13548e = this.f13553b.get();
        browserActivity.f13402b = this.f13554c.get();
        browserActivity.f13403c = this.f13555d.get();
        browserActivity.f13404d = this.f13556e.get();
    }
}
