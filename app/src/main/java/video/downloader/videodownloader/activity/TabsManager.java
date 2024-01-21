package video.downloader.videodownloader.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;


import androidx.appcompat.app.AlertDialog;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import classesdef.browser.C4740s;
import classesdef.browser.blx;
import classesdef.browser.blz;
import classesdef.browser.bmb;
import classesdef.browser.bmd;
import classesdef.browser.bmr;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.bpn;
import classesdef.browser.bqi;
import classesdef.browser.bql;
import classesdef.browser.bqv;
import classesdef.browser.download.boi;
import classesdef.browser.tab.C0002aa;
import classesdef.browser.tab.C0026ab;
import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;
import classesdef.browser.tab.C4892v;
import classesdef.browser.tab.C5019y;
import classesdef.browser.tab.C5072z;
import classesdef.eventbus.bob;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;
import video.downloader.videodownloader.view.WebViewBrowser;

public class TabsManager {

    public static boolean f13561a = false;
    @Inject

            bpn f13562b;
    @Inject

            Application f13563c;
    /* access modifiers changed from: private */

    public final List<WebViewBrowser> f13564d = new ArrayList(1);
    /* access modifiers changed from: private */

    public WebViewBrowser f13565e;

    private C3539a f13566f;

    private boolean f13567g = false;

    private final List<Runnable> f13568h = new ArrayList();

    @Deprecated
    public interface C3539a {
        void mo21480a(int i);
    }

    public TabsManager() {
        BrowserApp.m15129g().mo21502a(this);
    }

    public void mo21454a(C3539a aVar) {
        this.f13566f = aVar;
    }


    public void mo21451a() {
        this.f13568h.clear();
    }

    public synchronized void mo21453a(Runnable runnable) {
        if (this.f13567g) {
            runnable.run();
        } else {
            this.f13568h.add(runnable);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void m15078l() {
        this.f13567g = true;
        for (Runnable run : this.f13568h) {
            run.run();
        }
    }

    /* renamed from: a */
    public synchronized C3659b mo21448a(final Activity activity, final Intent intent, final boolean z) {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                String str;
                TabsManager.this.mo21462d();
                if (intent != null) {
                    str = intent.getDataString();
                    if (!TextUtils.isEmpty(str)) {
                        BrowserLogEvent.downloaderLogEvent(activity, "intent browser", str);
                        TabsManager.f13561a = true;
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                TabsManager.f13561a = false;
                            }
                        }, 10000);
                    }
                } else {
                    str = null;
                }
                if (z) {
                    TabsManager.this.mo21450a(activity, str, true);
                    eVar.mo23729a();
                    return;
                }
                Log.d("TabsManager", "URL from intent: " + str);
                WebViewBrowser unused = TabsManager.this.f13565e = null;
                if (TabsManager.this.f13562b.mo23430C()) {
                    TabsManager.this.m15073a(str, activity, eVar);
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    TabsManager.this.mo21450a(activity, str, false);
                } else {
                    TabsManager.this.mo21450a(activity, (String) null, false);
                }
                TabsManager.this.m15078l();
                eVar.mo23729a();
            }
        });
    }

    /* access modifiers changed from: private */
    public void m15073a(final String str, final Activity activity, final C4165e eVar) {
        m15079m().mo25259a(C4740s.m21407e()).mo25260b(C4740s.m21406d()).mo23840a(new C0002aa<Bundle>() {
            /* renamed from: a */
            public void mo12a(Bundle bundle) {
                final WebViewBrowser a = TabsManager.this.mo21450a(activity, "", false);
                bql.m18952a(bundle);
                String string = bundle.getString("URL_KEY");
                if (string == null || a.mo21630B() == null) {
                    if (a.mo21630B() != null) {
                        a.mo21630B().restoreState(bundle);
                    }
                } else if (bqv.m19002b(string)) {
                    new blx(activity).mo23023a().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<String>() {
                        /* renamed from: a */
                        public void mo21366a(String str) {
                            bql.m18952a(str);
                            a.mo21636a(str);
                        }
                    });
                } else if (bqv.m19003c(string)) {
                    new blz().mo23027a().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<String>() {
                        /* renamed from: a */
                        public void mo21366a(String str) {
                            bql.m18952a(str);
                            a.mo21636a(str);
                        }
                    });
                } else if (bqv.m19005e(string)) {
                    new bmd().mo23036a().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<String>() {
                        /* renamed from: a */
                        public void mo21366a(String str) {
                            bql.m18952a(str);
                            a.mo21636a(str);
                        }
                    });
                } else if (bqv.m19004d(string)) {
                    new bmb().mo23031a().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<String>() {
                        /* renamed from: a */
                        public void mo21366a(String str) {
                            bql.m18952a(str);
                            a.mo21636a(str);
                        }
                    });
                } else if (bqv.m19006f(string)) {
                    a.mo21636a(string);
                }
            }

            /* renamed from: a */
            public void mo21414a() {
                if (str == null) {
                    if (TabsManager.this.f13564d.isEmpty()) {
                        TabsManager.this.mo21450a(activity, (String) null, false);
                    }
                    TabsManager.this.m15078l();
                    eVar.mo23729a();
                } else if (str.startsWith("file://")) {
                    bmr.m18088a(activity, new AlertDialog.Builder(activity).setCancelable(true).setTitle((int) R.string.title_warning).setMessage((int) R.string.message_blocked_local).setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (TabsManager.this.f13564d.isEmpty()) {
                                TabsManager.this.mo21450a(activity, (String) null, false);
                            }
                            TabsManager.this.m15078l();
                            eVar.mo23729a();
                        }
                    }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton((int) R.string.action_open, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            TabsManager.this.mo21450a(activity, str, false);
                        }
                    }).show());
                } else {
                    TabsManager.this.mo21450a(activity, str, false);
                    if (TabsManager.this.f13564d.isEmpty()) {
                        TabsManager.this.mo21450a(activity, (String) null, false);
                    }
                    TabsManager.this.m15078l();
                    eVar.mo23729a();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo21452a(Context context) {
        WebViewBrowser k = mo21469k();
        if (k != null) {
            k.mo21655p();
        }
        for (WebViewBrowser next : this.f13564d) {
            if (next != null) {
                next.mo21649j();
                next.mo21635a(context);
            }
        }
    }

    /* renamed from: b */
    public void mo21457b() {
        WebViewBrowser k = mo21469k();
        if (k != null) {
            k.mo21654o();
        }
        for (WebViewBrowser next : this.f13564d) {
            if (next != null) {
                next.mo21648i();
            }
        }
    }

    /* renamed from: a */
    public synchronized WebViewBrowser mo21449a(int i) {
        if (i >= 0) {
            if (i < this.f13564d.size()) {
                return this.f13564d.get(i);
            }
        }
        return null;
    }

    /* renamed from: c */
    public synchronized void mo21460c() {
        for (WebViewBrowser k : this.f13564d) {
            k.mo21650k();
        }
    }

    /* renamed from: d */
    public synchronized void mo21462d() {
        for (WebViewBrowser s : this.f13564d) {
            s.mo21658s();
        }
        this.f13564d.clear();
        this.f13567g = false;
        this.f13565e = null;
    }

    /* renamed from: a */
    public synchronized void mo21455a(boolean z) {
        for (WebViewBrowser B : this.f13564d) {
            WebView B2 = B.mo21630B();
            if (B2 != null) {
                B2.setNetworkAvailable(z);
            }
        }
    }

    /* renamed from: e */
    public synchronized int mo21463e() {
        return this.f13564d.size();
    }

    /* renamed from: f */
    public synchronized int mo21464f() {
        return this.f13564d.size() - 1;
    }

    /* renamed from: g */
    public synchronized WebViewBrowser mo21465g() {
        if (mo21464f() < 0) {
            return null;
        }
        return this.f13564d.get(mo21464f());
    }

    /* renamed from: a */
    public synchronized WebViewBrowser mo21450a(Activity activity, String str, boolean z) {
        WebViewBrowser eVar;
        Log.d("TabsManager", "New tab");
        eVar = new WebViewBrowser(activity, str, z);
        this.f13564d.add(eVar);
        if (this.f13566f != null) {
            this.f13566f.mo21480a(mo21463e());
        }
        return eVar;
    }

    /* renamed from: e */
    private synchronized void m15077e(int i) {
        if (i < this.f13564d.size()) {
            WebViewBrowser remove = this.f13564d.remove(i);
            if (this.f13565e == remove) {
                this.f13565e = null;
            }
            remove.mo21658s();
        }
    }

    /* renamed from: b */
    public synchronized boolean mo21458b(int i) {
        boolean z;
        Log.d("TabsManager", "Delete tab: " + i);
        int a = mo21447a(mo21469k());
        z = true;
        if (a == i) {
            if (mo21463e() == 1) {
                this.f13565e = null;
            } else if (a < mo21463e() - 1) {
                mo21461d(a + 1);
            } else {
                mo21461d(a - 1);
            }
        }
        m15077e(i);
        if (this.f13566f != null) {
            this.f13566f.mo21480a(mo21463e());
        }
        if (a != i) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized int mo21447a(WebViewBrowser eVar) {
        return this.f13564d.indexOf(eVar);
    }

    /* renamed from: h */
    public void mo21466h() {
        Bundle bundle = new Bundle(ClassLoader.getSystemClassLoader());
        Log.d("TabsManager", "Saving tab state");
        for (int i = 0; i < this.f13564d.size(); i++) {
            WebViewBrowser eVar = this.f13564d.get(i);
            if (!TextUtils.isEmpty(eVar.mo21633E()) && !eVar.mo21633E().contains("gigya.com")) {
                Bundle bundle2 = new Bundle(ClassLoader.getSystemClassLoader());
                if (eVar.mo21630B() != null && !bqv.m19001a(eVar.mo21633E())) {
                    eVar.mo21630B().saveState(bundle2);
                    bundle.putBundle("WEBVIEW_" + i, bundle2);
                } else if (eVar.mo21630B() != null) {
                    bundle2.putString("URL_KEY", eVar.mo21633E());
                    bundle.putBundle("WEBVIEW_" + i, bundle2);
                }
            }
        }
        bqi.m18947a(this.f13563c, bundle, "SAVED_TABS.parcel");
    }

    public void mo21467i() {
        bqi.m18948a(this.f13563c, "SAVED_TABS.parcel");
    }

    private C5019y<Bundle> m15079m() {
        return C5019y.m22195a(new C5072z<Bundle>() {
            /* renamed from: a */
            public void mo21407a(C0026ab<Bundle> abVar) {
                Bundle b = bqi.m18949b(TabsManager.this.f13563c, "SAVED_TABS.parcel");
                if (b != null) {
                    Log.d("TabsManager", "Restoring previous WebView state now");
                    for (String str : b.keySet()) {
                        if (str.startsWith("WEBVIEW_")) {
                            abVar.mo118a(b.getBundle(str));
                        }
                    }
                }
                bqi.m18948a(TabsManager.this.f13563c, "SAVED_TABS.parcel");
                abVar.mo23729a();
            }
        });
    }

    public synchronized int mo21468j() {
        return this.f13564d.indexOf(this.f13565e);
    }
    public synchronized int mo21456b(WebViewBrowser eVar) {
        return this.f13564d.indexOf(eVar);
    }

    public synchronized WebViewBrowser mo21469k() {
        return this.f13565e;
    }

    public synchronized WebViewBrowser mo21459c(int i) {
        for (WebViewBrowser next : this.f13564d) {
            if (next.mo21630B() != null && next.mo21630B().hashCode() == i) {
                return next;
            }
        }
        return null;
    }

    public synchronized WebViewBrowser mo21461d(int i) {
        WebViewBrowser eVar = null;
        Log.d("TabsManager", "switch to tab: " + i);
        if (i >= 0) {
            if (i < this.f13564d.size()) {
                eVar = this.f13564d.get(i);
                if (eVar != null) {
                    this.f13565e = eVar;
                }
                try {
                    String E = eVar.mo21633E();
                    EventBus.getDefault().post(new bob(boi.m18319b().mo23264a(E), E));
                    Logger.e("switch tab : " + E, new Object[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Log.e("TabsManager", "Returning a null LightningView requested for position: " + i);
        //return null;
        return eVar;
    }
}
