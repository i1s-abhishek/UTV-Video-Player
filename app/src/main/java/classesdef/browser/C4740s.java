package classesdef.browser;

import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import classesdef.browser.tab.C0070ae;
import classesdef.browser.tab.C4704r;

/* renamed from: s */
public final class C4740s {

    /* renamed from: a */
    private static C4704r f18218a;

    /* renamed from: b */
    private static C4704r f18219b;

    /* renamed from: c */
    private static C4704r f18220c;

    /* renamed from: d */
    private static C4704r f18221d;

    /* renamed from: s$c */
    private static class C4744c implements C4704r {

        /* renamed from: a */
        private final Executor f18223a;

        private C4744c() {
            this.f18223a = Executors.newFixedThreadPool(4);
        }

        /* renamed from: a */
        public void mo322a(Runnable runnable) {
            this.f18223a.execute(runnable);
        }
    }

    /* renamed from: s$b */
    private static class C4743b implements C4704r {

        /* renamed from: a */
        private final Executor f18222a;

        private C4743b() {
            this.f18222a = Executors.newSingleThreadExecutor();
        }

        /* renamed from: a */
        public void mo322a(Runnable runnable) {
            this.f18222a.execute(runnable);
        }
    }

    /* renamed from: s$a */
    private static class C4742a implements C4704r {
        private C4742a() {
        }

        /* renamed from: a */
        public void mo322a(Runnable runnable) {
            runnable.run();
        }
    }

    /* renamed from: a */
    public static C4704r m21403a() {
        if (f18221d == null) {
            f18221d = new C4742a();
        }
        return f18221d;
    }

    /* renamed from: b */
    public static C4704r m21404b() {
        return new C4743b();
    }

    /* renamed from: c */
    public static C4704r m21405c() {
        if (f18219b == null) {
            f18219b = new C4744c();
        }
        return f18219b;
    }

    /* renamed from: d */
    public static C4704r m21406d() {
        if (f18218a == null) {
            f18218a = new C0070ae(Looper.getMainLooper());
        }
        return f18218a;
    }

    /* renamed from: e */
    public static C4704r m21407e() {
        if (f18220c == null) {
            f18220c = new C4743b();
        }
        return f18220c;
    }
}
