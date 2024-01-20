package classesdef.browser.tab;

/* renamed from: k */
class C4392k<T extends C4308i> implements C4344j {

    /* renamed from: a */
    private volatile boolean f17136a = false;

    /* renamed from: b */
    volatile boolean f17137b = false;

    /* renamed from: c */
    protected volatile T f17138c;

    /* renamed from: d */
    private final C4704r f17139d;

    /* renamed from: e */
    private final C4704r f17140e;

    public C4392k(T t, C4704r rVar, C4704r rVar2) {
        this.f17138c = t;
        this.f17139d = rVar;
        this.f17140e = rVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24147a(Runnable runnable) {
        if (this.f17139d != null) {
            this.f17139d.mo322a(runnable);
        } else {
            this.f17140e.mo322a(runnable);
        }
    }

    /* renamed from: c */
    public void mo281c() {
        this.f17138c = null;
    }

    /* renamed from: b */
    public void mo24023b() {
        T t = this.f17138c;
        if (this.f17136a) {
            throw new RuntimeException("onStart is called internally, do not call it yourself");
        }
        if (t != null) {
            mo24147a((Runnable) new C4626p(t));
        }
        this.f17136a = true;
    }

    /* renamed from: a */
    public void mo24022a(Throwable th) {
        T t = this.f17138c;
        if (t != null) {
            mo24147a((Runnable) new C4486m(t, th));
        }
        this.f17137b = true;
        mo281c();
    }
}
