package classesdef.browser.injection;

import android.app.Application;

import javax.inject.Provider;

import classesdef.browser.blz;
import classesdef.browser.bpn;
import classesdef.browser.download.bmn;
import dagger.MembersInjector;

/* renamed from: bma */
public final class bma implements MembersInjector<blz> {

    /* renamed from: a */
    static final /* synthetic */ boolean f15619a = true;

    /* renamed from: b */
    private final Provider<Application> f15620b;

    /* renamed from: c */
    private final Provider<bpn> f15621c;

    /* renamed from: d */
    private final Provider<bmn> f15622d;

    public bma(Provider<Application> provider, Provider<bpn> provider2, Provider<bmn> provider3) {
        if (f15619a || provider != null) {
            this.f15620b = provider;
            if (f15619a || provider2 != null) {
                this.f15621c = provider2;
                if (f15619a || provider3 != null) {
                    this.f15622d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<blz> m17909a(Provider<Application> provider, Provider<bpn> provider2, Provider<bmn> provider3) {
        return new bma(provider, provider2, provider3);
    }

    /* renamed from: a */
    public void injectMembers(blz blz) {
        if (blz == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        blz.f15609a = this.f15620b.get();
        blz.f15610b = this.f15621c.get();
        blz.f15611c = this.f15622d.get();
    }
}
