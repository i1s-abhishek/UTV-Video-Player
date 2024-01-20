package classesdef.browser.injection;

import android.app.Application;

import javax.inject.Provider;

import classesdef.browser.bmd;
import classesdef.browser.bpn;
import dagger.MembersInjector;

/* renamed from: bme */
public final class bme implements MembersInjector<bmd> {

    /* renamed from: a */
    static final /* synthetic */ boolean f15636a = true;

    /* renamed from: b */
    private final Provider<Application> f15637b;

    /* renamed from: c */
    private final Provider<bpn> f15638c;

    public bme(Provider<Application> provider, Provider<bpn> provider2) {
        if (f15636a || provider != null) {
            this.f15637b = provider;
            if (f15636a || provider2 != null) {
                this.f15638c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<bmd> m17928a(Provider<Application> provider, Provider<bpn> provider2) {
        return new bme(provider, provider2);
    }

    /* renamed from: a */
    public void injectMembers(bmd bmd) {
        if (bmd == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bmd.f15632a = this.f15637b.get();
        bmd.f15633b = this.f15638c.get();
    }
}
