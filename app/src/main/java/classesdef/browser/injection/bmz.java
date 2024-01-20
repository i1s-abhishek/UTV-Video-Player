package classesdef.browser.injection;

import android.app.Application;

import javax.inject.Provider;

import dagger.internal.Factory;
import classesdef.browser.bmy;

/* renamed from: bmz */
public final class bmz implements Factory<bmy> {

    /* renamed from: a */
    static final /* synthetic */ boolean f15815a = true;

    /* renamed from: b */
    private final Provider<Application> f15816b;

    public bmz(Provider<Application> provider) {
        if (f15815a || provider != null) {
            this.f15816b = provider;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public bmy get() {
        return new bmy(this.f15816b.get());
    }

    /* renamed from: a */
    public static Factory<bmy> m18163a(Provider<Application> provider) {
        return new bmz(provider);
    }
}
