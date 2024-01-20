package classesdef.browser;

import dagger.MembersInjector;

/* renamed from: bbf */
public final class bbf {
    /* renamed from: a */
    public static <T> T m15892a(MembersInjector<T> membersInjector, T t) {
        membersInjector.injectMembers(t);
        return t;
    }

    /* renamed from: a */
    public static <T> MembersInjector<T> m15891a() {
        return (MembersInjector<T>) C3676a.INSTANCE;
    }

    /* renamed from: bbf$a */
    private enum C3676a implements MembersInjector<Object> {
        INSTANCE;

        /* renamed from: a */
        public void injectMembers(Object obj) {
            bbg.m15894a(obj);
        }
    }
}
