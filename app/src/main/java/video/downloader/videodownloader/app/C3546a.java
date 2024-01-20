package video.downloader.videodownloader.app;

import javax.inject.Singleton;

import classesdef.browser.blt;
import classesdef.browser.blx;
import classesdef.browser.blz;
import classesdef.browser.bmb;
import classesdef.browser.bmd;
import classesdef.browser.bms;
import classesdef.browser.bqb;
import classesdef.browser.bqm;
import classesdef.browser.download.bmw;
import classesdef.database.bmo;
import dagger.Component;
import video.downloader.videodownloader.activity.BrowserActivity;
import video.downloader.videodownloader.activity.TabsManager;
import video.downloader.videodownloader.activity.ReadingActivity;
import video.downloader.videodownloader.activity.SettingsActivity;
import video.downloader.videodownloader.activity.ThemableBrowserActivity;
import video.downloader.videodownloader.activity.ThemableSettingsActivity;
import video.downloader.videodownloader.fragment.BookmarksFragment;
import video.downloader.videodownloader.fragment.PreferenceFragment_;
import video.downloader.videodownloader.fragment.PreferenceFragmentMain;
import video.downloader.videodownloader.fragment.TabsFragment;
import video.downloader.videodownloader.view.WebChromeClientBrowser;
import video.downloader.videodownloader.view.WebViewBrowser;
import video.downloader.videodownloader.view.WebViewClientBrowser;

@Singleton
@Component
public interface C3546a {
    bmo mo21487a();

    void mo21488a(blt blt);

    void mo21489a(blx blx);

    void mo21490a(blz blz);

    void mo21491a(bmb bmb);

    void mo21492a(bmd bmd);

    void mo21493a(bms bms);

    void mo21494a(bmw bmw);

    void mo21495a(bqb bqb);

    void mo21496a(bqm bqm);

    void mo21497a(BrowserActivity browserActivity);

    void mo21498a(ReadingActivity readingActivity);

    void mo21499a(SettingsActivity settingsActivity);

    void mo21500a(ThemableBrowserActivity themableBrowserActivity);

    void mo21501a(ThemableSettingsActivity themableSettingsActivity);

    void mo21502a(TabsManager eVar);

    void mo21503a(BrowserApp browserApp);

    void mo21504a(BookmarksFragment bookmarksFragment);

    void mo21505a(TabsFragment tabsFragment);

    void mo21506a(PreferenceFragment_ bVar);

    void mo21507a(PreferenceFragmentMain dVar);

    void mo21508a(WebChromeClientBrowser cVar);

    void mo21509a(WebViewBrowser eVar);

    void mo21510a(WebViewClientBrowser hVar);
}
