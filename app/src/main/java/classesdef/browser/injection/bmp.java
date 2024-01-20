package classesdef.browser.injection;

import android.app.Application;

import javax.inject.Provider;

import classesdef.browser.bbf;
import classesdef.database.bmo;
import dagger.MembersInjector;
import dagger.internal.Factory;

/* renamed from: bmp */
public final class bmp implements Factory<bmo> {

    /* renamed from: a */
    static final /* synthetic */ boolean f15678a = true;

    /* renamed from: b */
    private final MembersInjector<bmo> f15679b;

    /* renamed from: c */
    private final Provider<Application> f15680c;

    public bmp(MembersInjector<bmo> membersInjector, Provider<Application> provider) {
        if (f15678a || membersInjector != null) {
            this.f15679b = membersInjector;
            if (f15678a || provider != null) {
                this.f15680c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public bmo get() {
        return (bmo) bbf.m15892a(this.f15679b, new bmo(this.f15680c.get()));
    }

    /* renamed from: a */
    public static Factory<bmo> m18067a(MembersInjector<bmo> membersInjector, Provider<Application> provider) {
        return new bmp(membersInjector, provider);
    }
}
