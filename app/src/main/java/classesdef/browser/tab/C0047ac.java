package classesdef.browser.tab;

/* renamed from: ac */
class C0047ac<T> extends C4209f<C0002aa<T>> implements C0026ab<T> {
    C0047ac(C0002aa<T> aaVar, C4704r rVar, C4704r rVar2) {
        super(aaVar, rVar, rVar2);
    }

    /* renamed from: a */
    public void mo118a(T t) {
        C0002aa aaVar = (C0002aa) this.f17138c;
        if (this.f16720a) {
            throw new RuntimeException("onNext should not be called after onComplete has been called");
        } else if (aaVar != null && !this.f17137b) {
            mo24147a((Runnable) new C4584o(aaVar, t));
        }
    }
}
