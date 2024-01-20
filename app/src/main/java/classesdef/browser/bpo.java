package classesdef.browser;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: bpo */
public final class bpo implements Factory<bpn> {

    /* renamed from: a */
    static final /* synthetic */ boolean f16288a = true;

    /* renamed from: b */
    private final Provider<Context> f16289b;

    public bpo(Provider<Context> provider) {
        if (f16288a || provider != null) {
            this.f16289b = provider;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public bpn get() {
        return new bpn(this.f16289b.get());
    }

    /* renamed from: a */
    public static Factory<bpn> m18740a(Provider<Context> provider) {
        return new bpo(provider);
    }
}
