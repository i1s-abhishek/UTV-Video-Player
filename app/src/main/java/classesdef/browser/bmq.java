package classesdef.browser;

import java.util.List;

import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;
import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4927w;
import video.downloader.videodownloader.app.BrowserApp;

/* renamed from: bmq */
public final class bmq {
    /* renamed from: a */
    public static C3659b m18070a() {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                BrowserApp.m15129g().mo21487a().mo23102a();
                eVar.mo23729a();
            }
        });
    }

    /* renamed from: a */
    public static C3659b m18071a(final String str) {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                BrowserApp.m15129g().mo21487a().mo23103a(str);
                eVar.mo23729a();
            }
        });
    }

    /* renamed from: a */
    public static C3659b m18072a(final String str, final String str2) {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                BrowserApp.m15129g().mo21487a().mo23104a(str, str2);
                eVar.mo23729a();
            }
        });
    }

    /* renamed from: b */
    public static C4805t<List<bmg>> m18074b(final String str) {
        return C4805t.m21581a(new C4858u<List<bmg>>() {
            /* renamed from: a */
            public void mo21407a(C4927w<List<bmg>> wVar) {
                wVar.mo25115a(BrowserApp.m15129g().mo21487a().mo23106b(str));
                wVar.mo23729a();
            }
        });
    }

    /* renamed from: b */
    public static C4805t<List<bmg>> m18073b() {
        return C4805t.m21581a(new C4858u<List<bmg>>() {
            /* renamed from: a */
            public void mo21407a(C4927w<List<bmg>> wVar) {
                wVar.mo25115a(BrowserApp.m15129g().mo21487a().mo23105b());
                wVar.mo23729a();
            }
        });
    }
}
