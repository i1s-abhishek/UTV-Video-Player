package classesdef.browser.injection;

import android.app.Application;

import javax.inject.Provider;

import classesdef.browser.bmj;
import classesdef.browser.bpn;
import classesdef.browser.bqb;
import dagger.MembersInjector;

/* renamed from: bqc */
public final class bqc implements MembersInjector<bqb> {

    /* renamed from: a */
    static final /* synthetic */ boolean f16403a = true;

    /* renamed from: b */
    private final Provider<bmj> f16404b;

    /* renamed from: c */
    private final Provider<bpn> f16405c;

    /* renamed from: d */
    private final Provider<Application> f16406d;

    public bqc(Provider<bmj> provider, Provider<bpn> provider2, Provider<Application> provider3) {
        if (f16403a || provider != null) {
            this.f16404b = provider;
            if (f16403a || provider2 != null) {
                this.f16405c = provider2;
                if (f16403a || provider3 != null) {
                    this.f16406d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<bqb> m18916a(Provider<bmj> provider, Provider<bpn> provider2, Provider<Application> provider3) {
        return new bqc(provider, provider2, provider3);
    }

    /* renamed from: a */
    public void injectMembers(bqb bqb) {
        if (bqb == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bqb.f16370a = this.f16404b.get();
        bqb.f16371b = this.f16405c.get();
        bqb.f16372c = this.f16406d.get();
    }
}
