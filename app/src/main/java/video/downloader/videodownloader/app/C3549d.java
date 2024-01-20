package video.downloader.videodownloader.app;

import dagger.internal.Factory;
import classesdef.browser.bbg;
import classesdef.browser.bmj;

public final class C3549d implements Factory<bmj> {

//    static final  boolean f13606a = true;
    static final  boolean f13606a = (!C3549d.class.desiredAssertionStatus());

    private final C3547b f13607b;

    public C3549d(C3547b bVar) {
        if (f13606a || bVar != null) {
            this.f13607b = bVar;
            return;
        }
        throw new AssertionError();
    }

    public bmj get() {
        return (bmj) bbg.m15895a(this.f13607b.mo21513c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<bmj> m15163a(C3547b bVar) {
        return new C3549d(bVar);
    }
}
