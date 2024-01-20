package classesdef.browser.injection;

import javax.inject.Provider;

import classesdef.browser.bpn;
import classesdef.browser.download.bmn;
import classesdef.browser.download.bmw;
import dagger.MembersInjector;

/* renamed from: bmx */
public final class bmx implements MembersInjector<bmw> {

    /* renamed from: a */
    static final /* synthetic */ boolean f15802a = true;

    /* renamed from: b */
    private final Provider<bpn> f15803b;

    /* renamed from: c */
    private final Provider<bmn> f15804c;

    public bmx(Provider<bpn> provider, Provider<bmn> provider2) {
        if (f15802a || provider != null) {
            this.f15803b = provider;
            if (f15802a || provider2 != null) {
                this.f15804c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<bmw> m18147a(Provider<bpn> provider, Provider<bmn> provider2) {
        return new bmx(provider, provider2);
    }

    /* renamed from: a */
    public void injectMembers(bmw bmw) {
        if (bmw == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bmw.f15798a = this.f15803b.get();
        bmw.f15799b = this.f15804c.get();
    }
}
