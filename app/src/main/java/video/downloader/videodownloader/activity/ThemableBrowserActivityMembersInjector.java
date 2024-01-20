package video.downloader.videodownloader.activity;

import javax.inject.Provider;

import classesdef.browser.bpn;
import dagger.MembersInjector;

/* renamed from: video.downloader.video.downloader.videodownloader.activity.g */
public final class ThemableBrowserActivityMembersInjector implements MembersInjector<ThemableBrowserActivity> {

    /* renamed from: a */
   // static final /* synthetic */ boolean f13592a = true;
    static final /* synthetic */ boolean f13592a = (!ThemableBrowserActivityMembersInjector.class.desiredAssertionStatus());

    /* renamed from: b */
    private final Provider<bpn> f13593b;

    public ThemableBrowserActivityMembersInjector(Provider<bpn> provider) {
        if (f13592a || provider != null) {
            this.f13593b = provider;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<ThemableBrowserActivity> m15122a(Provider<bpn> provider) {
        return new ThemableBrowserActivityMembersInjector(provider);
    }

    /* renamed from: a */
    public void injectMembers(ThemableBrowserActivity themableBrowserActivity) {
        if (themableBrowserActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        themableBrowserActivity.f13548e = this.f13593b.get();
    }
}
