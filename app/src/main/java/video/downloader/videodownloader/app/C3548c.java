package video.downloader.videodownloader.app;

import android.app.Application;

import classesdef.browser.bbg;
import dagger.internal.Factory;

public final class C3548c implements Factory<Application> {

  //  static final /*  */ boolean f13604a = true;
    static final /* */ boolean f13604a = (!C3548c.class.desiredAssertionStatus());

    private final C3547b f13605b;

    public C3548c(C3547b bVar) {
        if (f13604a || bVar != null) {
            this.f13605b = bVar;
            return;
        }
        throw new AssertionError();
    }

    public Application get() {
        return (Application) bbg.m15895a(this.f13605b.mo21511a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Application> m15160a(C3547b bVar) {
        return new C3548c(bVar);
    }
}
