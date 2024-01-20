package classesdef.browser.injection;

import android.app.Application;

import javax.inject.Provider;

import dagger.internal.Factory;
import classesdef.browser.bpn;
import classesdef.browser.bqe;

/* renamed from: bqf */
public final class bqf implements Factory<bqe> {

    /* renamed from: a */
    static final /* synthetic */ boolean f16419a = true;

    /* renamed from: b */
    private final Provider<Application> f16420b;

    /* renamed from: c */
    private final Provider<bpn> f16421c;

    public bqf(Provider<Application> provider, Provider<bpn> provider2) {
        if (f16419a || provider != null) {
            this.f16420b = provider;
            if (f16419a || provider2 != null) {
                this.f16421c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public bqe get() {
        return new bqe(this.f16420b.get(), this.f16421c.get());
    }

    /* renamed from: a */
    public static Factory<bqe> m18938a(Provider<Application> provider, Provider<bpn> provider2) {
        return new bqf(provider, provider2);
    }
}
