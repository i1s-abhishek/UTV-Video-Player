package classesdef.browser;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import androidx.collection.ArrayMap;

import java.util.Map;

import javax.inject.Inject;

import classesdef.browser.tab.C4123d;
import video.downloader.videodownloader.activity.TabsManager;
import video.downloader.videodownloader.app.BrowserApp;
import video.downloader.videodownloader.view.WebViewBrowser;

/* renamed from: blt */
public class blt {
    @Inject
    public

    /* renamed from: a */
    bpn f15582a;

    /* renamed from: b */
    final Map<WebViewBrowser, Long> f15583b = new ArrayMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final TabsManager f15584c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final blv f15585d;

    /* renamed from: e */
    private WebViewBrowser f15586e;

    /* renamed from: f */
    private final boolean f15587f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f15588g;

    public blt(blv blv, boolean z) {
        BrowserApp.m15129g().mo21488a(this);
        this.f15584c = ((bmf) blv).mo21322g();
        this.f15585d = blv;
        this.f15587f = z;
        this.f15584c.mo21454a((TabsManager.C3539a) new TabsManager.C3539a() {
            /* renamed from: a */
            public void mo21480a(int i) {
                blt.this.f15585d.mo21321f(i);
            }
        });
    }

    /* renamed from: a */
    public void mo23011a(Intent intent) {
        this.f15584c.mo21448a((Activity) this.f15585d, intent, this.f15587f).mo21839a(C4740s.m21406d()).mo23840a(new C4123d() {
            /* renamed from: a */
            public void mo21414a() {
                blt.this.f15585d.mo21325i();
                blt.this.f15585d.mo21321f(blt.this.f15584c.mo21463e());
                blt.this.mo23016b(blt.this.f15584c.mo21464f());
                for (int i = 0; i < blt.this.f15584c.mo21463e(); i++) {
                    blt.this.f15583b.put(blt.this.f15584c.mo21449a(i), Long.valueOf(System.currentTimeMillis() + ((long) (i * 10))));
                }
            }
        });
    }

    /* renamed from: a */
    public void mo23013a(WebViewBrowser eVar) {
        this.f15585d.mo21315c(this.f15584c.mo21456b(eVar));
    }

    /* renamed from: b */
    private void m17841b(WebViewBrowser eVar) {
        Log.d("BrowserPresenter", "On tab changed");
        if (eVar == null) {
            this.f15585d.mo21326j();
            if (this.f15586e != null) {
                this.f15586e.mo21654o();
                this.f15586e.mo21658s();
            }
        } else {
            this.f15583b.put(eVar, Long.valueOf(System.currentTimeMillis()));
            if (eVar.mo21630B() == null) {
                this.f15585d.mo21326j();
                if (this.f15586e != null) {
                    this.f15586e.mo21654o();
                    this.f15586e.mo21658s();
                }
            } else {
                if (this.f15586e != null) {
                    this.f15586e.mo21641b(false);
                }
                eVar.mo21655p();
                eVar.mo21649j();
                eVar.mo21641b(true);
                this.f15585d.mo21323g(eVar.mo21652m());
                this.f15585d.mo21313b(eVar.mo21665z());
                this.f15585d.mo21305a(eVar.mo21629A());
                this.f15585d.mo21303a(eVar.mo21633E(), true);
                this.f15585d.setTabView(eVar.mo21630B());
                if (this.f15584c.mo21456b(eVar) >= 0) {
                    this.f15585d.mo21315c(this.f15584c.mo21456b(eVar));
                }
            }
        }
        this.f15586e = eVar;
    }

    /* renamed from: a */
    public void mo23009a() {
        while (this.f15584c.mo21464f() != this.f15584c.mo21468j()) {
            mo23010a(this.f15584c.mo21464f());
        }
        while (this.f15584c.mo21468j() != 0) {
            mo23010a(0);
        }
    }

    /* renamed from: a */
    public void mo23010a(int i) {
        Log.d("BrowserPresenter", "delete Tab");
        WebViewBrowser a = this.f15584c.mo21449a(i);
        if (a != null) {
            this.f15583b.remove(a);
            if (!bqv.m19001a(a.mo21633E()) && !this.f15587f) {
                this.f15582a.mo23453b(a.mo21633E());
            }
            boolean h = a.mo21647h();
            boolean z = this.f15588g && h && a.mo21638a();
            WebViewBrowser k = this.f15584c.mo21469k();
            if (this.f15584c.mo21463e() != 1 || k == null || (!bqv.m19005e(k.mo21633E()) && !k.mo21633E().equals(this.f15582a.mo23479r()))) {
                if (h) {
                    this.f15585d.mo21326j();
                }
                if (this.f15584c.mo21458b(i)) {
                    mo23016b(this.f15584c.mo21468j());
                }
                WebViewBrowser k2 = this.f15584c.mo21469k();
                this.f15585d.mo21309b(i);
                if (k2 == null) {
                    this.f15585d.mo21347p();
                    return;
                }
                if (k2 != k) {
                    this.f15585d.mo21315c(this.f15584c.mo21468j());
                }
                if (z) {
                    this.f15588g = false;
                    this.f15585d.mo21308b();
                }
                this.f15585d.mo21321f(this.f15584c.mo21463e());
                Log.d("BrowserPresenter", "deleted tab");
                return;
            }
            this.f15585d.mo21308b();
        }
    }

    /* renamed from: b */
    public void mo23017b(final Intent intent) {
        this.f15584c.mo21453a((Runnable) new Runnable() {
            public void run() {
                final String dataString = intent != null ? intent.getDataString() : null;
                int i = 0;
                if (!(intent == null || intent.getExtras() == null)) {
                    i = intent.getExtras().getInt("URL_INTENT_ORIGIN");
                }
                if (i != 0) {
                    WebViewBrowser c = blt.this.f15584c.mo21459c(i);
                    if (c != null) {
                        c.mo21636a(dataString);
                    }
                } else if (dataString == null) {
                } else {
                    if (dataString.startsWith("file://")) {
                        blt.this.f15585d.mo21293a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                blt.this.mo23014a(dataString, true);
                                boolean unused = blt.this.f15588g = true;
                                WebViewBrowser g = blt.this.f15584c.mo21465g();
                                if (g != null) {
                                    g.mo21637a(true);
                                }
                            }
                        });
                        return;
                    }
                    blt.this.mo23014a(dataString, true);
                    boolean unused = blt.this.f15588g = true;
                    WebViewBrowser g = blt.this.f15584c.mo21465g();
                    if (g != null) {
                        g.mo21637a(true);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void mo23012a(String str) {
        WebViewBrowser k = this.f15584c.mo21469k();
        if (k != null) {
            k.mo21636a(str);
        }
    }

    /* renamed from: b */
    public void mo23015b() {
        m17841b((WebViewBrowser) null);
        this.f15584c.mo21454a((TabsManager.C3539a) null);
        this.f15584c.mo21451a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo2301b6b(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "BrowserPresenter"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r1.<init>()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "tabChanged: "
            r1.append(r2)     // Catch:{ all -> 0x002f }
            r1.append(r4)     // Catch:{ all -> 0x002f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x002f }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x002f }
            if (r4 < 0) goto L_0x002d
            video.downloader.videodownloader.activity.e r0 = r3.f15584c     // Catch:{ all -> 0x002f }
            int r0 = r0.mo21463e()     // Catch:{ all -> 0x002f }
            if (r4 < r0) goto L_0x0022
            goto L_0x002d
        L_0x0022:
            video.downloader.videodownloader.activity.e r0 = r3.f15584c     // Catch:{ all -> 0x002f }
            video.downloader.videodownloader.view.e r4 = r0.mo21461d(r4)     // Catch:{ all -> 0x002f }
            r3.m17841b((video.downloader.videodownloader.view.C3607e) r4)     // Catch:{ all -> 0x002f }
            monitor-exit(r3)
            return
        L_0x002d:
            monitor-exit(r3)
            return
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: blt.mo23016b(int):void");
    }
    public synchronized void mo23016b(int i) {
        Log.d("BrowserPresenter", "tabChanged: " + i);
        if (i >= 0) {
            if (i < this.f15584c.mo21463e()) {
                m17841b(this.f15584c.mo21461d(i));
            }
        }
    }
    /* renamed from: a */
    public synchronized boolean mo23014a(String str, boolean z) {
        if (this.f15584c.mo21463e() >= 10) {
            m17842e();
        }
        Log.d("BrowserPresenter", "New tab, show: " + z);
        WebViewBrowser a = this.f15584c.mo21450a((Activity) this.f15585d, str, this.f15587f);
        if (this.f15584c.mo21463e() == 1) {
            a.mo21655p();
        }
        this.f15585d.mo21324h();
        if (z) {
            m17841b(this.f15584c.mo21461d(this.f15584c.mo21464f()));
        }
        this.f15585d.mo21321f(this.f15584c.mo21463e());
        return true;
    }

    /* renamed from: c */
    public void mo23018c() {
        WebViewBrowser k = this.f15584c.mo21469k();
        if (k != null) {
            k.mo21656q();
        }
    }

    /* renamed from: d */
    public void mo23019d() {
        this.f15584c.mo21460c();
    }

    /* renamed from: e */
    private void m17842e() {
        Long l = Long.MAX_VALUE;
        WebViewBrowser eVar = null;
        for (WebViewBrowser next : this.f15583b.keySet()) {
            Long l2 = this.f15583b.get(next);
            if (l2.longValue() < l.longValue()) {
                eVar = next;
                l = l2;
            }
        }
        if (eVar != null) {
            mo23010a(this.f15584c.mo21456b(eVar));
        }
    }
}
