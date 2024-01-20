package classesdef.browser.tab;

import classesdef.browser.C4740s;

/* renamed from: g */
public abstract class C4242g<ActionT extends C4276h<SubscriberT>, OnSubscribeT extends C4308i, SubscriberT extends C4344j> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ActionT f16770a;

    /* renamed from: b */
    private C4704r f16771b;

    /* renamed from: c */
    private C4704r f16772c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract SubscriberT mo21841a(OnSubscribeT onsubscribet, C4704r rVar, C4704r rVar2);

    protected C4242g(ActionT actiont) {
        this.f16770a = actiont;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo23841c(C4704r rVar) {
        this.f16771b = rVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo23842d(C4704r rVar) {
        this.f16772c = rVar;
    }

    /* renamed from: a */
    public final C0053ad mo23839a() {
        return m19513b((OnSubscribeT) null);
    }

    /* renamed from: a */
    public final C0053ad mo23840a(OnSubscribeT onsubscribet) {
        C4660q.m21030a(onsubscribet);
        return m19513b(onsubscribet);
    }

    /* renamed from: b */
    private C0053ad m19513b(OnSubscribeT onsubscribet) {
        C4704r a = C4740s.m21403a();
        final C4344j a2 = mo21841a(onsubscribet, this.f16772c, a);
        C4660q.m21030a(a2);
        a2.mo24023b();
        m19512a(new Runnable() {
            public void run() {
                try {
                   C4242g.this.f16770a.mo21407a((SubscriberT) a2);
                } catch (Exception e) {
                    a2.mo24022a(e);
                }
            }
        }, a);
        return a2;
    }

    /* renamed from: a */
    private void m19512a(Runnable runnable, C4704r rVar) {
        if (this.f16771b != null) {
            this.f16771b.mo322a(runnable);
        } else {
            rVar.mo322a(runnable);
        }
    }
}
