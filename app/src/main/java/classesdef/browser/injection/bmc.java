package classesdef.browser.injection;

import android.app.Application;

import javax.inject.Provider;

import classesdef.browser.bmb;
import dagger.MembersInjector;

/* renamed from: bmc */
public final class bmc implements MembersInjector<bmb> {

    /* renamed from: a */
    static final /* synthetic */ boolean f15630a = true;

    /* renamed from: b */
    private final Provider<Application> f15631b;

    public bmc(Provider<Application> provider) {
        if (f15630a || provider != null) {
            this.f15631b = provider;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<bmb> m17921a(Provider<Application> provider) {
        return new bmc(provider);
    }

    /* renamed from: a */
    public void injectMembers(bmb bmb) {
        if (bmb == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bmb.f15623a = this.f15631b.get();
    }
}
