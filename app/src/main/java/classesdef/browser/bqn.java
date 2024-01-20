package classesdef.browser;

import dagger.MembersInjector;
import dagger.internal.Factory;
/* renamed from: bqn */
public final class bqn implements Factory<bqm> {

    /* renamed from: a */
    static final /* synthetic */ boolean f16440a = true;

    /* renamed from: b */
    private final MembersInjector<bqm> f16441b;

    public bqn(MembersInjector<bqm> membersInjector) {
        if (f16440a || membersInjector != null) {
            this.f16441b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public bqm get() {
        return (bqm) bbf.m15892a(this.f16441b, new bqm());
    }

    /* renamed from: a */
    public static Factory<bqm> m18963a(MembersInjector<bqm> membersInjector) {
        return new bqn(membersInjector);
    }
}
