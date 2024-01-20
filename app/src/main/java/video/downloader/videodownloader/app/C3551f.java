package video.downloader.videodownloader.app;

import dagger.internal.Factory;
import classesdef.browser.bbg;
import classesdef.browser.download.bmn;

public final class C3551f implements Factory<bmn> {

 //   static final  boolean f13610a = true;
    static final boolean f13610a = (!C3551f.class.desiredAssertionStatus());

    private final C3547b f13611b;

    public C3551f(C3547b bVar) {
        if (f13610a || bVar != null) {
            this.f13611b = bVar;
            return;
        }
        throw new AssertionError();
    }

    public bmn get() {
        return (bmn) bbg.m15895a(this.f13611b.mo21514d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<bmn> m15169a(C3547b bVar) {
        return new C3551f(bVar);
    }
}
