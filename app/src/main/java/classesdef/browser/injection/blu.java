package classesdef.browser.injection;

import javax.inject.Provider;

import classesdef.browser.blt;
import classesdef.browser.bpn;
import dagger.MembersInjector;

/* renamed from: blu */
public final class blu implements MembersInjector<blt> {

    /* renamed from: a */
    static final /* synthetic */ boolean f15595a = true;

    /* renamed from: b */
    private final Provider<bpn> f15596b;

    public blu(Provider<bpn> provider) {
        if (f15595a || provider != null) {
            this.f15596b = provider;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static MembersInjector<blt> m17856a(Provider<bpn> provider) {
        return new blu(provider);
    }

    /* renamed from: a */
    public void injectMembers(blt blt) {
        if (blt == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        blt.f15582a = this.f15596b.get();
    }
}
