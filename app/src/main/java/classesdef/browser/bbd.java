package classesdef.browser;

import javax.inject.Provider;

import dagger.Lazy;

/* renamed from: bbd */
public final class bbd<T> implements Lazy<T>, Provider<T> {

    /* renamed from: a */
    static final /* synthetic */ boolean f14118a = true;

    /* renamed from: b */
    private static final Object f14119b = new Object();

    /* renamed from: c */
    private volatile Provider<T> f14120c;

    /* renamed from: d */
    private volatile Object f14121d = f14119b;

    private bbd(Provider<T> provider) {
        if (f14118a || provider != null) {
            this.f14120c = provider;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public T get() {
        T t = (T) this.f14121d;
        if (t == f14119b) {
            synchronized (this) {
                t = (T) this.f14121d;
                if (t == f14119b) {
                    t = this.f14120c.get();
                    T t2 = (T) this.f14121d;
                    if (t2 == f14119b || t2 == t) {
                        this.f14121d = t;
                        this.f14120c = null;
                    } else {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + t2 + " & " + t + ". This is likely due to a circular dependency.");
                    }
                }
            }
        }
        return t;
    }

    /* renamed from: a */
    public static <T> Provider<T> m15889a(Provider<T> provider) {
        bbg.m15894a(provider);
        if (provider instanceof bbd) {
            return provider;
        }
        return new bbd(provider);
    }
}
