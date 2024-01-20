package classesdef.browser.injection;

import classesdef.browser.bbf;
import dagger.internal.Factory;
import classesdef.browser.bms;
import dagger.MembersInjector;


public final class bmt implements Factory<bms> {


    static final boolean f15791a = true;


    private final MembersInjector<bms> f15792b;

    public bmt(MembersInjector<bms> membersInjector) {
        if (f15791a || membersInjector != null) {
            this.f15792b = membersInjector;
            return;
        }
        throw new AssertionError();
    }


    public bms get() {
        return (bms) bbf.m15892a(this.f15792b, new bms());
    }


    public static Factory<bms> m18141a(MembersInjector<bms> membersInjector) {
        return new bmt(membersInjector);
    }
}
