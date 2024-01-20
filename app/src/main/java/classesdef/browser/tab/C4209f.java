package classesdef.browser.tab;

/* renamed from: f */
class C4209f<T extends C4123d> extends C4392k<T> implements C4165e {

    /* renamed from: a */
    protected volatile boolean f16720a;

    C4209f(T t, C4704r rVar, C4704r rVar2) {
        super(t, rVar, rVar2);
    }

    /* renamed from: a */
    public void mo23729a() {
        C4123d dVar = (C4123d) this.f17138c;
        if (this.f16720a) {
            throw new RuntimeException("onComplete called more than once");
        }
        if (dVar != null && !this.f17137b) {
            mo24147a((Runnable) new C4457l(dVar));
        }
        this.f16720a = true;
        mo281c();
    }
}
