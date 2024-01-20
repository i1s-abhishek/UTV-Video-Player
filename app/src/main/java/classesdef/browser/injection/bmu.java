package classesdef.browser.injection;

import javax.inject.Provider;

import classesdef.browser.bmj;
import classesdef.browser.bms;
import classesdef.browser.bpn;
import classesdef.browser.download.bmn;
import dagger.MembersInjector;

/* renamed from: bmu */
public final class bmu implements MembersInjector<bms> {

    /* renamed from: a */
    static final /* synthetic */ boolean f15793a = true;

    /* renamed from: b */
    private final Provider<bmj> f15794b;

    /* renamed from: c */
    private final Provider<bmn> f15795c;

    /* renamed from: d */
    private final Provider<bpn> f15796d;

    public bmu(Provider<bmj> provider, Provider<bmn> provider2, Provider<bpn> provider3) {
        if (f15793a || provider != null) {
            this.f15794b = provider;
            if (f15793a || provider2 != null) {
                this.f15795c = provider2;
                if (f15793a || provider3 != null) {
                    this.f15796d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<bms> m18144a(Provider<bmj> provider, Provider<bmn> provider2, Provider<bpn> provider3) {
        return new bmu(provider, provider2, provider3);
    }

    /* renamed from: a */
    public void injectMembers(bms bms) {
        if (bms == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bms.f15691a = this.f15794b.get();
        bms.f15692b = this.f15795c.get();
        bms.f15693c = this.f15796d.get();
    }
}
