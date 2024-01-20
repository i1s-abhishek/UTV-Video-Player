package video.downloader.videodownloader.activity;

import android.app.Application;

import javax.inject.Provider;

import classesdef.browser.bpn;
import dagger.MembersInjector;


public final class TabsManagerMembersInjector implements MembersInjector<TabsManager> {

    //static final  boolean f13589a = true;
    static final  boolean f13589a = (!TabsManagerMembersInjector.class.desiredAssertionStatus());

    private final Provider<bpn> f13590b;

    private final Provider<Application> f13591c;

    public TabsManagerMembersInjector(Provider<bpn> provider, Provider<Application> provider2) {
        if (f13589a || provider != null) {
            this.f13590b = provider;
            if (f13589a || provider2 != null) {
                this.f13591c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }
    public static MembersInjector<TabsManager> m15119a(Provider<bpn> provider, Provider<Application> provider2) {
        return new TabsManagerMembersInjector(provider, provider2);
    }

    public void injectMembers(TabsManager eVar) {
        if (eVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        eVar.f13562b = this.f13590b.get();
        eVar.f13563c = this.f13591c.get();
    }
}
