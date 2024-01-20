package classesdef.browser.injection;

import android.app.Application;

import javax.inject.Provider;

import classesdef.browser.blx;
import classesdef.browser.bmj;
import dagger.MembersInjector;

/* renamed from: bly */
public final class bly implements MembersInjector<blx> {

    /* renamed from: a */
    static final /* synthetic */ boolean f15606a = true;

    /* renamed from: b */
    private final Provider<Application> f15607b;

    /* renamed from: c */
    private final Provider<bmj> f15608c;

    public bly(Provider<Application> provider, Provider<bmj> provider2) {
        if (f15606a || provider != null) {
            this.f15607b = provider;
            if (f15606a || provider2 != null) {
                this.f15608c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<blx> m17890a(Provider<Application> provider, Provider<bmj> provider2) {
        return new bly(provider, provider2);
    }

    /* renamed from: a */
    public void injectMembers(blx blx) {
        if (blx == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        blx.f15597a = this.f15607b.get();
        blx.f15598b = this.f15608c.get();
    }
}
