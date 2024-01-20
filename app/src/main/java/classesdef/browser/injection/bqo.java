package classesdef.browser.injection;

import javax.inject.Provider;

import classesdef.browser.bgl;
import classesdef.browser.bpn;
import classesdef.browser.bqm;
import dagger.MembersInjector;

/* renamed from: bqo */
public final class bqo implements MembersInjector<bqm> {

    /* renamed from: a */
    static final /* synthetic */ boolean f16442a = true;

    /* renamed from: b */
    private final Provider<bpn> f16443b;

    /* renamed from: c */
    private final Provider<bgl> f16444c;

    public bqo(Provider<bpn> provider, Provider<bgl> provider2) {
        if (f16442a || provider != null) {
            this.f16443b = provider;
            if (f16442a || provider2 != null) {
                this.f16444c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<bqm> m18966a(Provider<bpn> provider, Provider<bgl> provider2) {
        return new bqo(provider, provider2);
    }

    /* renamed from: a */
    public void injectMembers(bqm bqm) {
        if (bqm == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bqm.f16430a = this.f16443b.get();
        bqm.f16431b = this.f16444c.get();
    }
}
