package classesdef.browser;

import android.app.Application;

import java.util.List;

import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4927w;

/* renamed from: bqd */
class bqd {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile boolean f16407a;

    /* renamed from: a */
    static boolean m18920a() {
        return f16407a;
    }

    /* renamed from: a */
    static C4805t<List<bmg>> m18919a(final String str, final Application application) {
        return C4805t.m21581a(new C4858u<List<bmg>>() {
            /* renamed from: a */
            public void mo21407a(C4927w<List<bmg>> wVar) {
                boolean unused = bqd.f16407a = true;
                wVar.mo25115a(new bqa(application).mo23532a(str));
                wVar.mo23729a();
                boolean unused2 = bqd.f16407a = false;
            }
        });
    }

    /* renamed from: b */
    static C4805t<List<bmg>> m18922b(final String str, final Application application) {
        return C4805t.m21581a(new C4858u<List<bmg>>() {
            /* renamed from: a */
            public void mo21407a(C4927w<List<bmg>> wVar) {
                boolean unused = bqd.f16407a = true;
                wVar.mo25115a(new bpx(application).mo23532a(str));
                wVar.mo23729a();
                boolean unused2 = bqd.f16407a = false;
            }
        });
    }

    /* renamed from: c */
    static C4805t<List<bmg>> m18923c(final String str, final Application application) {
        return C4805t.m21581a(new C4858u<List<bmg>>() {
            /* renamed from: a */
            public void mo21407a(C4927w<List<bmg>> wVar) {
                boolean unused = bqd.f16407a = true;
                wVar.mo25115a(new bpz(application).mo23532a(str));
                wVar.mo23729a();
                boolean unused2 = bqd.f16407a = false;
            }
        });
    }
}
