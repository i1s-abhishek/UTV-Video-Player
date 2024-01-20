package classesdef.browser;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import javax.inject.Inject;
import javax.inject.Singleton;

import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

@Singleton
/* renamed from: bqm */
public class bqm {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static boolean f16428c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f16429d;
    @Inject
    public

    /* renamed from: a */
    bpn f16430a;
    @Inject
    public

    /* renamed from: b */
    bgl f16431b;

    @Inject
    public bqm() {
        BrowserApp.m15129g().mo21496a(this);
    }

    /* renamed from: a */
    public void mo23575a(final Activity activity) {
        boolean L = this.f16430a.mo23439L();
        final boolean b = bcj.m15982b(activity);
        boolean z = false;
        boolean z2 = b && !this.f16430a.mo23466f();
        boolean c = this.f16431b.mo22267c();
        boolean g = this.f16430a.mo23468g();
        if (c && !g) {
            z = true;
        }
        if (L) {
            return;
        }
        if (z2 || z) {
            if (z2) {
                this.f16430a.mo23458c(true);
            }
            if (z) {
                this.f16430a.mo23461d(true);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            if (!b || !c) {
                DialogInterface.OnClickListener r2 = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -2:
                                bqm.this.f16430a.mo23456c(0);
                                return;
                            case -1:
                                bqm.this.f16430a.mo23456c(b ? 1 : 2);
                                bqm.this.m18956e(activity);
                                return;
                            default:
                                return;
                        }
                    }
                };
                builder.setMessage(b ? R.string.use_tor_prompt : R.string.use_i2p_prompt).setPositiveButton((int) R.string.yes, (DialogInterface.OnClickListener) r2).setNegativeButton((int) R.string.no, (DialogInterface.OnClickListener) r2);
            } else {
                builder.setTitle((CharSequence) activity.getResources().getString(R.string.http_proxy)).setSingleChoiceItems((CharSequence[]) activity.getResources().getStringArray(R.array.proxy_choices_array), this.f16430a.mo23440M(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        bqm.this.f16430a.mo23456c(i);
                    }
                }).setPositiveButton((CharSequence) activity.getResources().getString(R.string.action_ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (bqm.this.f16430a.mo23439L()) {
                            bqm.this.m18956e(activity);
                        }
                    }
                });
            }
            bmr.m18088a(activity, builder.show());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m18956e(Activity activity) {
        int i;
        String str;
        switch (this.f16430a.mo23440M()) {
            case 0:
                return;
            case 1:
                if (!bcj.m15980a(activity)) {
                    bcj.m15983c(activity);
                }
                str = "localhost";
                i = 8118;
                break;
            case 2:
                f16429d = true;
                if (f16428c && !this.f16431b.mo22268d()) {
                    this.f16431b.mo22264a(activity);
                }
                str = "localhost";
                i = 4444;
                break;
            case 3:
                str = this.f16430a.mo23486y();
                i = this.f16430a.mo23487z();
                break;
            default:
                str = this.f16430a.mo23486y();
                i = this.f16430a.mo23487z();
                break;
        }
        try {
          //  bcl.m15998a(BrowserApp.class.getName(), activity.getApplicationContext(), (WebView) null, str, i);
        } catch (Exception e) {
            Log.d("ProxyUtils", "error enabling web proxying", e);
        }
    }

    /* renamed from: b */
    public boolean mo23576b(Activity activity) {
        if (this.f16430a.mo23440M() != 2) {
            return true;
        }
        if (!this.f16431b.mo22268d()) {
            bqw.m19012a(activity, (int) R.string.i2p_not_running);
            return false;
        } else if (this.f16431b.mo22269e()) {
            return true;
        } else {
            bqw.m19012a(activity, (int) R.string.i2p_tunnels_not_ready);
            return false;
        }
    }

    /* renamed from: c */
    public void mo23577c(Activity activity) {
        if (this.f16430a.mo23439L()) {
            m18956e(activity);
            return;
        }
        try {
          //  bcl.m16002b(BrowserApp.class.getName(), activity.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        f16429d = false;
    }

    /* renamed from: a */
    public void mo23574a() {
        this.f16431b.mo22266b();
        f16428c = false;
    }

    /* renamed from: d */
    public void mo23578d(final Activity activity) {
        if (this.f16430a.mo23440M() == 2) {
            this.f16431b.mo22265a((bgl.C3740a) new bgl.C3740a() {
                /* renamed from: a */
                public void mo22274a() {
                    boolean unused = bqm.f16428c = true;
                    if (bqm.f16429d && !bqm.this.f16431b.mo22268d()) {
                        bqm.this.f16431b.mo22264a(activity);
                    }
                }
            });
        }
    }
}
