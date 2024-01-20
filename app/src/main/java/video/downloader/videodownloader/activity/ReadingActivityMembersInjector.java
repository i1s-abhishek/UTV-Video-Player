package video.downloader.videodownloader.activity;

import javax.inject.Provider;

import classesdef.browser.bpn;
import dagger.MembersInjector;

/* renamed from: video.downloader.video.downloader.videodownloader.activity.c */
public final class ReadingActivityMembersInjector implements MembersInjector<ReadingActivity> {

    static final boolean f13557a = (!ReadingActivityMembersInjector.class.desiredAssertionStatus());
  //  static final /* synthetic */ boolean f13557a = true;

    private final Provider<bpn> f13558b;

    public ReadingActivityMembersInjector(Provider<bpn> provider) {
        if (f13557a || provider != null) {
            this.f13558b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<ReadingActivity> m15066a(Provider<bpn> provider) {
        return new ReadingActivityMembersInjector(provider);
    }

    public void injectMembers(ReadingActivity readingActivity) {
        if (readingActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        readingActivity.f13510a = this.f13558b.get();
    }
}
