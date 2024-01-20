package video.downloader.videodownloader.app;

import dagger.internal.Factory;
import classesdef.browser.bbg;
import classesdef.browser.bgl;

public final class C3552g implements Factory<bgl> {

  //  static final boolean f13612a = true;
    static final boolean f13612a = (!C3552g.class.desiredAssertionStatus());

    private final C3547b f13613b;

    public C3552g(C3547b bVar) {
        if (f13612a || bVar != null) {
            this.f13613b = bVar;
            return;
        }
        throw new AssertionError();
    }

    public bgl get() {
        return (bgl) bbg.m15895a(this.f13613b.mo21515e(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<bgl> m15172a(C3547b bVar) {
        return new C3552g(bVar);
    }
}
