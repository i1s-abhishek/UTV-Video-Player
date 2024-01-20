package classesdef.browser.tab;

/* renamed from: x */
class C4968x<T> extends C4209f<C4892v<T>> implements C4927w<T> {

    /* renamed from: d */
    private volatile boolean f18883d = false;

    C4968x(C4892v<T> vVar, C4704r rVar, C4704r rVar2) {
        super(vVar, rVar, rVar2);
    }

    /* renamed from: a */
    public void mo25115a(T t) {
        C4892v vVar = (C4892v) this.f17138c;
        if (this.f16720a) {
            throw new RuntimeException("onItem should not be called after onComplete has been called");
        } else if (this.f18883d) {
            throw new RuntimeException("onItem should not be called multiple times");
        } else {
            if (vVar != null && !this.f17137b) {
                mo24147a((Runnable) new C4535n(vVar, t));
            }
            this.f18883d = true;
        }
    }
}
