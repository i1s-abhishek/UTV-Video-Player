package video.downloader.videodownloader.app;

import android.content.Context;

import dagger.internal.Factory;
import classesdef.browser.bbg;

public final class C3550e implements Factory<Context> {

    //static final boolean f13608a = true;
    static final /* synthetic */ boolean f13608a = (!C3550e.class.desiredAssertionStatus());

    private final C3547b f13609b;

    public C3550e(C3547b bVar) {
        if (f13608a || bVar != null) {
            this.f13609b = bVar;
            return;
        }
        throw new AssertionError();
    }

    public Context get() {
        return (Context) bbg.m15895a(this.f13609b.mo21512b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Context> m15166a(C3547b bVar) {
        return new C3550e(bVar);
    }
}
