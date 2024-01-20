package video.downloader.videodownloader.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import classesdef.browser.bgl;
import classesdef.browser.bmj;
import classesdef.browser.download.bmn;
import classesdef.database.bmh;
import classesdef.database.bmm;
import dagger.Module;
import dagger.Provides;

@Module
public class C3547b {

    private final BrowserApp f13603a;

    public C3547b(BrowserApp browserApp) {
        this.f13603a = browserApp;
    }

    @Provides
    public Application mo21511a() {
        return this.f13603a;
    }

    @Provides
    public Context mo21512b() {
        return this.f13603a.getApplicationContext();
    }

    @Singleton
    @Provides
    public bmj mo21513c() {
        return new bmh(this.f13603a);
    }

    @Singleton
    @Provides
    public bmn mo21514d() {
        return new bmm(this.f13603a);
    }

    @Singleton
    @Provides
    public bgl mo21515e() {
        return new bgl(this.f13603a.getApplicationContext());
    }
}
