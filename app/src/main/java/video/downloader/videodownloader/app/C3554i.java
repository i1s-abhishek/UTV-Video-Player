package video.downloader.videodownloader.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Provider;

import classesdef.browser.bbd;
import classesdef.browser.bbf;
import classesdef.browser.bbg;
import classesdef.browser.bgl;
import classesdef.browser.blt;
import classesdef.browser.blx;
import classesdef.browser.blz;
import classesdef.browser.bmb;
import classesdef.browser.bmd;
import classesdef.browser.bmj;
import classesdef.browser.bms;
import classesdef.browser.bmy;
import classesdef.browser.bpn;
import classesdef.browser.bpo;
import classesdef.browser.bqb;
import classesdef.browser.bqe;
import classesdef.browser.bqm;
import classesdef.browser.bqn;
import classesdef.browser.download.bmn;
import classesdef.browser.download.bmw;
import classesdef.browser.injection.blu;
import classesdef.browser.injection.bly;
import classesdef.browser.injection.bma;
import classesdef.browser.injection.bmc;
import classesdef.browser.injection.bme;
import classesdef.browser.injection.bmp;
import classesdef.browser.injection.bmt;
import classesdef.browser.injection.bmu;
import classesdef.browser.injection.bmx;
import classesdef.browser.injection.bmz;
import classesdef.browser.injection.bqc;
import classesdef.browser.injection.bqf;
import classesdef.browser.injection.bqo;
import classesdef.database.bmo;
import dagger.MembersInjector;
import video.downloader.videodownloader.activity.BrowserActivity;
import video.downloader.videodownloader.activity.BrowserActivityMembersInjector;
import video.downloader.videodownloader.activity.ReadingActivityMembersInjector;
import video.downloader.videodownloader.activity.SettingsActivityMembersInjector;
import video.downloader.videodownloader.activity.TabsManager;
import video.downloader.videodownloader.activity.TabsManagerMembersInjector;
import video.downloader.videodownloader.activity.ThemableBrowserActivityMembersInjector;
import video.downloader.videodownloader.activity.ThemableSettingsActivityMembersInjector;
import video.downloader.videodownloader.activity.ReadingActivity;
import video.downloader.videodownloader.activity.SettingsActivity;
import video.downloader.videodownloader.activity.ThemableBrowserActivity;
import video.downloader.videodownloader.activity.ThemableSettingsActivity;
import video.downloader.videodownloader.fragment.BookmarksFragment;
import video.downloader.videodownloader.fragment.BookmarksFragmentMembersInjector;
import video.downloader.videodownloader.fragment.PreferenceFragment_;
import video.downloader.videodownloader.fragment.PreferenceFragmentMembersInjector;
import video.downloader.videodownloader.fragment.PreferenceFragmentMain;
import video.downloader.videodownloader.fragment.PreferenceFragmentMainMembersInjector;
import video.downloader.videodownloader.fragment.TabsFragmentMembersInjector;
import video.downloader.videodownloader.fragment.TabsFragment;
import video.downloader.videodownloader.view.WebChromeClientBrowser;
import video.downloader.videodownloader.view.WebChromeClientBrowserMembersInjector;
import video.downloader.videodownloader.view.WebViewBrowser;
import video.downloader.videodownloader.view.WebViewBrowserMembersInjector;
import video.downloader.videodownloader.view.WebViewClientBrowser;
import video.downloader.videodownloader.view.WebViewClientBrowserMembersInjector;

public final class C3554i implements C3546a {

   // static final  boolean f13617a = true;
    static final  boolean f13617a = (!C3554i.class.desiredAssertionStatus());

    private MembersInjector<blx> f13618A;


    private MembersInjector<blz> f13619B;


    private MembersInjector<blt> f13620C;


    private MembersInjector<TabsManager> f13621D;


    private MembersInjector<PreferenceFragment_> f13622E;


    private MembersInjector<bqb> f13623F;


    private MembersInjector<WebChromeClientBrowser> f13624G;


    private MembersInjector<SettingsActivity> f13625H;


    private Provider<bmo> f13626I;


    private Provider<Context> f13627b;

    /* renamed from: c */
    private Provider<bpn> f13628c;


    private Provider<bmj> f13629d;


    private Provider<bmn> f13630e;


    private MembersInjector<bms> f13631f;


    private Provider<bms> f13632g;


    private Provider<bgl> f13633h;


    private MembersInjector<bqm> f13634i;


    private Provider<bqm> f13635j;


    private MembersInjector<BrowserActivity> f13636k;


    private Provider<Application> f13637l;


    private Provider<bmy> f13638m;


    private MembersInjector<BookmarksFragment> f13639n;


    private MembersInjector<TabsFragment> f13640o;


    private MembersInjector<WebViewBrowser> f13641p;

    private MembersInjector<ThemableBrowserActivity> f13642q;


    private MembersInjector<PreferenceFragmentMain> f13643r;


    private MembersInjector<BrowserApp> f13644s;


    private MembersInjector<ReadingActivity> f13645t;


    private Provider<bqe> f13646u;


    private MembersInjector<WebViewClientBrowser> f13647v;


    private MembersInjector<ThemableSettingsActivity> f13648w;


    private MembersInjector<bmw> f13649x;


    private MembersInjector<bmd> f13650y;


    private MembersInjector<bmb> f13651z;

    private C3554i(C3556a aVar) {
        if (f13617a || aVar != null) {
            m15178a(aVar);
            return;
        }
        throw new AssertionError();
    }

    public static C3556a m15179b() {
        return new C3556a();
    }

    private void m15178a(C3556a aVar) {
        this.f13627b = C3550e.m15166a(aVar.f13652a);
        this.f13628c = bbd.m15889a(bpo.m18740a(this.f13627b));
        this.f13629d = bbd.m15889a(C3549d.m15163a(aVar.f13652a));
        this.f13630e = bbd.m15889a(C3551f.m15169a(aVar.f13652a));
        this.f13631f = bmu.m18144a(this.f13629d, this.f13630e, this.f13628c);
        this.f13632g = bmt.m18141a(this.f13631f);
        this.f13633h = bbd.m15889a(C3552g.m15172a(aVar.f13652a));
        this.f13634i = bqo.m18966a(this.f13628c, this.f13633h);
        this.f13635j = bbd.m15889a(bqn.m18963a(this.f13634i));
        this.f13636k = BrowserActivityMembersInjector.m15063a(this.f13628c, this.f13629d, this.f13632g, this.f13635j);
        this.f13637l = C3548c.m15160a(aVar.f13652a);
        this.f13638m = bbd.m15889a(bmz.m18163a(this.f13637l));
        this.f13639n = BookmarksFragmentMembersInjector.m15328a(this.f13629d, this.f13632g, this.f13628c, this.f13638m);
        this.f13640o = TabsFragmentMembersInjector.m15337a(this.f13628c);
        this.f13641p = WebViewBrowserMembersInjector.m15423a(this.f13628c, this.f13632g, this.f13635j);
        this.f13642q = ThemableBrowserActivityMembersInjector.m15122a(this.f13628c);
        this.f13643r = PreferenceFragmentMainMembersInjector.m15334a(this.f13628c);
        this.f13644s = C3553h.m15175a(this.f13628c, this.f13629d);
        this.f13645t = ReadingActivityMembersInjector.m15066a(this.f13628c);
        this.f13646u = bbd.m15889a(bqf.m18938a(this.f13637l, this.f13628c));
        this.f13647v = WebViewClientBrowserMembersInjector.m15433a(this.f13635j, this.f13646u);
        this.f13648w = ThemableSettingsActivityMembersInjector.m15125a(this.f13628c);
        this.f13649x = bmx.m18147a(this.f13628c, this.f13630e);
        this.f13650y = bme.m17928a(this.f13637l, this.f13628c);
        this.f13651z = bmc.m17921a(this.f13637l);
        this.f13618A = bly.m17890a(this.f13637l, this.f13629d);
        this.f13619B = bma.m17909a(this.f13637l, this.f13628c, this.f13630e);
        this.f13620C = blu.m17856a(this.f13628c);
        this.f13621D = TabsManagerMembersInjector.m15119a(this.f13628c, this.f13637l);
        this.f13622E = PreferenceFragmentMembersInjector.m15331a(this.f13628c);
        this.f13623F = bqc.m18916a(this.f13629d, this.f13628c, this.f13637l);
        this.f13624G = WebChromeClientBrowserMembersInjector.m15345a(this.f13638m);
        this.f13625H = SettingsActivityMembersInjector.m15069a(this.f13628c);
        this.f13626I = bbd.m15889a(bmp.m18067a(bbf.m15891a(), this.f13637l));
    }

    public void mo21497a(BrowserActivity browserActivity) {
        this.f13636k.injectMembers(browserActivity);
    }

    public void mo21504a(BookmarksFragment bookmarksFragment) {
        this.f13639n.injectMembers(bookmarksFragment);
    }

    public void mo21493a(bms bms) {
        this.f13631f.injectMembers(bms);
    }

    public void mo21505a(TabsFragment tabsFragment) {
        this.f13640o.injectMembers(tabsFragment);
    }

    public void mo21509a(WebViewBrowser eVar) {
        this.f13641p.injectMembers(eVar);
    }

    public void mo21500a(ThemableBrowserActivity themableBrowserActivity) {
        this.f13642q.injectMembers(themableBrowserActivity);
    }

    public void mo21507a(PreferenceFragmentMain dVar) {
        this.f13643r.injectMembers(dVar);
    }

    public void mo21503a(BrowserApp browserApp) {
        this.f13644s.injectMembers(browserApp);
    }

    public void mo21496a(bqm bqm) {
        this.f13634i.injectMembers(bqm);
    }

    public void mo21498a(ReadingActivity readingActivity) {
        this.f13645t.injectMembers(readingActivity);
    }

    public void mo21510a(WebViewClientBrowser hVar) {
        this.f13647v.injectMembers(hVar);
    }

    public void mo21501a(ThemableSettingsActivity themableSettingsActivity) {
        this.f13648w.injectMembers(themableSettingsActivity);
    }

    public void mo21494a(bmw bmw) {
        this.f13649x.injectMembers(bmw);
    }

    public void mo21492a(bmd bmd) {
        this.f13650y.injectMembers(bmd);
    }

    public void mo21491a(bmb bmb) {
        this.f13651z.injectMembers(bmb);
    }

    public void mo21489a(blx blx) {
        this.f13618A.injectMembers(blx);
    }

    public void mo21490a(blz blz) {
        this.f13619B.injectMembers(blz);
    }

    public void mo21488a(blt blt) {
        this.f13620C.injectMembers(blt);
    }

    public void mo21502a(TabsManager eVar) {
        this.f13621D.injectMembers(eVar);
    }

    public void mo21506a(PreferenceFragment_ bVar) {
        this.f13622E.injectMembers(bVar);
    }


    public void mo21495a(bqb bqb) {
        this.f13623F.injectMembers(bqb);
    }

    public void mo21508a(WebChromeClientBrowser cVar) {
        this.f13624G.injectMembers(cVar);
    }

    public void mo21499a(SettingsActivity settingsActivity) {
        this.f13625H.injectMembers(settingsActivity);
    }

    public bmo mo21487a() {
        return this.f13626I.get();
    }

    public static final class C3556a {
        public C3547b f13652a;

        private C3556a() {
        }

        public C3546a mo21522a() {
            if (this.f13652a != null) {
                return new C3554i(this);
            }
            throw new IllegalStateException(C3547b.class.getCanonicalName() + " must be set");
        }

        public C3556a mo21523a(C3547b bVar) {
            this.f13652a = (C3547b) bbg.m15894a(bVar);
            return this;
        }
    }
}
