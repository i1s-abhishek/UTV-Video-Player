package video.downloader.videodownloader.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import com.liulishuo.filedownloader.FileDownloader;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import classesdef.ads.C4786mv;
import classesdef.browser.C4740s;
import classesdef.browser.bmr;
import classesdef.browser.bom;
import classesdef.browser.boo;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.box;
import classesdef.browser.bpb;
import classesdef.browser.bpc;
import classesdef.browser.bpn;
import classesdef.browser.bqw;
import classesdef.browser.bqx;
import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4123d;
import classesdef.browser.tab.C4165e;
import classesdef.eventbus.boc;
import classesdef.xdplayer.ServerConfigSharedPrefrence;
import classesdef.xdplayer.bpj;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;
import video.downloader.videodownloader.five.activity.BasePermissionActivity;
import video.downloader.videodownloader.five.activity.ChooseStorageActivity;
import video.downloader.videodownloader.five.activity.HelpActivity;
import video.downloader.videodownloader.five.activity.PrivacyPolicyActivity;

public class SettingsActivity extends BasePermissionActivity implements View.OnClickListener {

    /* renamed from: a */
    public Toolbar f13524a;
    @Inject

    /* renamed from: b */
            bpn f13525b;

    /* renamed from: c */
    public final int f13526c = 108;

    /* renamed from: d */
    private String f13527d;
    @BindView(R.id.ll_home_page)
    View ll_home_page;
    @BindView(R.id.rl_active_downloads)
    View rl_active_downloads;
    @BindView(R.id. rl_ad_block)
    View rl_ad_block;
    @BindView(R.id. rl_clear_cache)
    View rl_clear_cache;
    @BindView(R.id. rl_clear_cookies)
    View rl_clear_cookies;
    @BindView(R.id.rl_clear_history)
    View rl_clear_history;
    @BindView(R.id. rl_download_location)
    View rl_download_location;
    @BindView(R.id.rl_download_wifi)
    View rl_download_wifi;
    @BindView(R.id.rl_save_password)
    View rl_save_password;
    @BindView(R.id.rl_search_engine)
    View rl_search_engine;
    @BindView(R.id.rl_sync_gallery)
    View rl_sync_gallery;
    @BindView(R.id.sc_ad_block)
    SwitchCompat sc_ad_block;
    @BindView(R.id.sc_sync_gallery)
    SwitchCompat sc_sync_gallery;
    @BindView(R.id.sc_wifi)
    SwitchCompat sc_wifi;
    @BindView(R.id.tb_save_password)
    SwitchCompat tb_save_password;
    @BindView(R.id.tv_active_downloads)
    TextView tv_active_downloads;
    @BindView(R.id.tv_ad_block)
    TextView tv_ad_block;
    @BindView(R.id.tv_download_location)
    TextView tv_download_location;
    @BindView(R.id.tv_feedback)
    TextView tv_feedback;
    @BindView(R.id.tv_home_page)
    TextView tv_home_page;
    @BindView(R.id.tv_howto_download)
    TextView tv_howto_download;
    @BindView(R.id.tv_privacy_policy)
    TextView tv_privacy_policy;
    @BindView(R.id.tv_search_engine)
    TextView tv_search_engine;
    @BindView(R.id.tv_sync_gallery)
    TextView tv_sync_gallery;
    @BindView(R.id.tv_version)
    TextView tv_version;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.e("SettingActivity onCreate", new Object[0]);
        BrowserApp.m15129g().mo21499a(this);
        setContentView((int) R.layout.toolbar_settings);
        ButterKnife.bind((Activity) this);
        this.rl_download_location.setOnClickListener(this);
        this.tv_download_location.setText(boo.m18379c(this));
        this.tv_active_downloads.setText(String.valueOf(bpj.m18578a((Context) this).mo23405l()));
        this.rl_active_downloads.setOnClickListener(this);
        this.rl_download_wifi.setOnClickListener(this);
        this.sc_wifi.setChecked(!bpj.m18578a((Context) this).mo23412s());
        this.ll_home_page.setOnClickListener(this);
        this.f13527d = this.f13525b.mo23479r();
        if (this.f13527d.contains("about:home")) {
            this.tv_home_page.setText(getResources().getString(R.string.action_homepage));
        } else if (this.f13527d.contains("about:blank")) {
            this.tv_home_page.setText(getResources().getString(R.string.action_blank));
        } else if (this.f13527d.contains("about:bookmarks")) {
            this.tv_home_page.setText(getResources().getString(R.string.action_bookmarks));
        } else {
            this.tv_home_page.setText(this.f13527d);
        }
        this.rl_ad_block.setOnClickListener(this);
        if (this.f13525b.mo23459c()) {
            this.sc_ad_block.setChecked(true);
            this.tv_ad_block.setText(getResources().getString(R.string.on));
        } else {
            this.sc_ad_block.setChecked(false);
            this.tv_ad_block.setText(getResources().getString(R.string.off));
        }
        this.rl_save_password.setOnClickListener(this);
        this.tb_save_password.setChecked(this.f13525b.mo23432E());
        this.rl_clear_cache.setOnClickListener(this);
        this.rl_clear_history.setOnClickListener(this);
        this.rl_clear_cookies.setOnClickListener(this);
        m15017a(this.f13525b.mo23433F(), false);
        this.rl_search_engine.setOnClickListener(this);
        this.rl_sync_gallery.setOnClickListener(this);
        if (bpj.m18578a((Context) this).mo23404k()) {
            this.sc_sync_gallery.setChecked(true);
            this.tv_sync_gallery.setText(getResources().getString(R.string.on));
        } else {
            this.sc_sync_gallery.setChecked(false);
            this.tv_sync_gallery.setText(getResources().getString(R.string.off));
        }
        this.tv_howto_download.setOnClickListener(this);
        this.tv_feedback.setOnClickListener(this);
        this.tv_privacy_policy.setOnClickListener(this);
        this.tv_version.setText(bpc.m18490a((Context) this));
        this.tv_version.setOnClickListener(this);
        this.f13524a = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.f13524a);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home_page /*2131296615*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click home page");
                if (this.f13525b.mo23479r().equals("about:bookmarks") || bpj.m18578a((Context) this).mo23415v()) {
                    if (!bpj.m18578a((Context) this).mo23415v()) {
                        bpj.m18578a((Context) this).mo23398g(true);
                        bpj.m18578a((Context) this).mo23375b((Context) this);
                    }
                    m15024d();
                    return;
                }
                m15026e();
                return;
            case R.id.rl_active_downloads /*2131296758*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click max download numbers");
                m15021b();
                return;
            case R.id.rl_ad_block /*2131296759*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click ad block");
                m15030g();
                return;
            case R.id.rl_clear_cache /*2131296761*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "clear cache");
                m15032i();
                return;
            case R.id.rl_clear_cookies /*2131296762*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "clear cookies");
                m15035l();
                return;
            case R.id.rl_clear_history /*2131296763*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "clear history");
                m15033j();
                return;
            case R.id.rl_download_location /*2131296765*/:
                if (box.m18457a(this, new box.C3987a() {
                    /* renamed from: a */
                    public void mo21376a() {
                        SettingsActivity.this.mo21307a();
                    }
                })) {
                    mo21307a();
                    return;
                }
                return;
            case R.id.rl_download_wifi /*2131296766*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click download with wifi only");
                m15023c();
                return;
            case R.id.rl_save_password /*2131296768*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click save password");
                m15031h();
                return;
            case R.id.rl_search_engine /*2131296770*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click search engine");
                m15038o();
                return;
            case R.id.rl_sync_gallery /*2131296771*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click sync to gallery");
                m15036m();
                return;
            case R.id.tv_feedback /*2131296938*/:
                bom.m18358a(this);
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click feedback");
                return;
            case R.id.tv_howto_download /*2131296948*/:
                startActivity(new Intent(this, HelpActivity.class));
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click how to download");
                return;
            case R.id.tv_privacy_policy /*2131296953*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click privacy policy");
                if (ServerConfigSharedPrefrence.m23693m(this) == 1) {
                    C4786mv.m23719a(this,getString(R.string.policy),-624595, -28594, "androdeveloper24@gmail.com", "https://inshotapp.com/website/HDPlayer/privacypolicy_eu.html");
                    return;
                }
                startActivity(new Intent(this, PrivacyPolicyActivity.class));
                return;
            case R.id.tv_version /*2131296963*/:
                BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click version");
                if (bpj.m18578a((Context) this).f16161a) {
                    m15040q();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo21307a() {
        BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click download location");
        ArrayList<String> a = bpb.m18488a(this);
        if (a.size() > 1) {
            Intent intent = new Intent(this, ChooseStorageActivity.class);
            BrowserLogEvent.downloaderLogEvent(this, "setting activity", "has sd card");
            intent.putStringArrayListExtra("allPath", a);
            startActivityForResult(intent, 108);
            return;
        }
        Intent intent2 = new Intent(this, FolderSelectActivity.class);
        BrowserLogEvent.downloaderLogEvent(this, "setting activity", "no sd card");
        startActivityForResult(intent2, 108);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 108 && i2 == -1) {
            this.tv_download_location.setText(bpj.m18578a((Context) this).mo23414u());
        }
    }

    /* renamed from: b */
    private void m15021b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getString(R.string.max_number_of_downloads));
        builder.setSingleChoiceItems((CharSequence[]) new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}, bpj.m18578a((Context) this).mo23405l() - 1, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                int i2 = i + 1;
                bpj.m18578a((Context) SettingsActivity.this).mo23373b(i2);
                bpj.m18578a((Context) SettingsActivity.this).mo23375b((Context) SettingsActivity.this);
                SettingsActivity.this.tv_active_downloads.setText(String.valueOf(i2));
                FileDownloader.getImpl().setMaxNetworkThreadCount(i2);
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    /* renamed from: c */
    private void m15023c() {
        bpj.m18578a((Context) this).mo23391e(!bpj.m18578a((Context) this).mo23412s());
        bpj.m18578a((Context) this).mo23375b((Context) this);
        this.sc_wifi.setChecked(!bpj.m18578a((Context) this).mo23412s());
        EventBus.getDefault().post(new boc());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15024d() {
        /*
            r7 = this;
            android.support.v7.app.AlertDialog$Builder r0 = new android.support.v7.app.AlertDialog$Builder
            r0.<init>(r7)
            r1 = 2131624153(0x7f0e00d9, float:1.8875478E38)
            r0.setTitle((int) r1)
            bpn r1 = r7.f13525b
            java.lang.String r1 = r1.mo23479r()
            r7.f13527d = r1
            java.lang.String r1 = r7.f13527d
            int r2 = r1.hashCode()
            r3 = -1145275824(0xffffffffbbbc7a50, float:-0.0057518855)
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == r3) goto L_0x0040
            r3 = 322841383(0x133e2b27, float:2.4002647E-27)
            if (r2 == r3) goto L_0x0036
            r3 = 1396069548(0x533654ac, float:7.8310461E11)
            if (r2 == r3) goto L_0x002c
            goto L_0x004a
        L_0x002c:
            java.lang.String r2 = "about:home"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x004a
            r1 = 0
            goto L_0x004b
        L_0x0036:
            java.lang.String r2 = "about:blank"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x004a
            r1 = 1
            goto L_0x004b
        L_0x0040:
            java.lang.String r2 = "about:bookmarks"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x004a
            r1 = 2
            goto L_0x004b
        L_0x004a:
            r1 = -1
        L_0x004b:
            switch(r1) {
                case 0: goto L_0x0052;
                case 1: goto L_0x0050;
                case 2: goto L_0x0053;
                default: goto L_0x004e;
            }
        L_0x004e:
            r4 = 3
            goto L_0x0053
        L_0x0050:
            r4 = 1
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            r1 = 2130903042(0x7f030002, float:1.741289E38)
            video.downloader.video.downloader.videodownloader.activity.SettingsActivity$8 r2 = new video.downloader.video.downloader.videodownloader.activity.SettingsActivity$8
            r2.<init>()
            r0.setSingleChoiceItems((int) r1, (int) r4, (android.content.DialogInterface.OnClickListener) r2)
            android.content.res.Resources r1 = r7.getResources()
            r2 = 2131623982(0x7f0e002e, float:1.887513E38)
            java.lang.String r1 = r1.getString(r2)
            r2 = 0
            r0.setPositiveButton((java.lang.CharSequence) r1, (android.content.DialogInterface.OnClickListener) r2)
            android.support.v7.app.AlertDialog r0 = r0.show()
            p000.bmr.m18088a(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.activity.SettingsActivity.m15024d():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15026e() {
        /*
            r6 = this;
            android.support.v7.app.AlertDialog$Builder r0 = new android.support.v7.app.AlertDialog$Builder
            r0.<init>(r6)
            r1 = 2131624153(0x7f0e00d9, float:1.8875478E38)
            r0.setTitle((int) r1)
            bpn r1 = r6.f13525b
            java.lang.String r1 = r1.mo23479r()
            r6.f13527d = r1
            java.lang.String r1 = r6.f13527d
            int r2 = r1.hashCode()
            r3 = 322841383(0x133e2b27, float:2.4002647E-27)
            r4 = 1
            r5 = 0
            if (r2 == r3) goto L_0x0030
            r3 = 1396069548(0x533654ac, float:7.8310461E11)
            if (r2 == r3) goto L_0x0026
            goto L_0x003a
        L_0x0026:
            java.lang.String r2 = "about:home"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003a
            r1 = 0
            goto L_0x003b
        L_0x0030:
            java.lang.String r2 = "about:blank"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003a
            r1 = 1
            goto L_0x003b
        L_0x003a:
            r1 = -1
        L_0x003b:
            switch(r1) {
                case 0: goto L_0x0040;
                case 1: goto L_0x0041;
                default: goto L_0x003e;
            }
        L_0x003e:
            r4 = 2
            goto L_0x0041
        L_0x0040:
            r4 = 0
        L_0x0041:
            r1 = 2130903043(0x7f030003, float:1.7412893E38)
            video.downloader.video.downloader.videodownloader.activity.SettingsActivity$9 r2 = new video.downloader.video.downloader.videodownloader.activity.SettingsActivity$9
            r2.<init>()
            r0.setSingleChoiceItems((int) r1, (int) r4, (android.content.DialogInterface.OnClickListener) r2)
            android.content.res.Resources r1 = r6.getResources()
            r2 = 2131623982(0x7f0e002e, float:1.887513E38)
            java.lang.String r1 = r1.getString(r2)
            r2 = 0
            r0.setPositiveButton((java.lang.CharSequence) r1, (android.content.DialogInterface.OnClickListener) r2)
            android.support.v7.app.AlertDialog r0 = r0.show()
            p000.bmr.m18088a(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.activity.SettingsActivity.m15026e():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m15028f() {
        this.f13527d = this.f13525b.mo23479r();
        bmr.m18085a(this, R.string.title_custom_homepage, R.string.title_custom_homepage, !this.f13527d.startsWith("about:") ? this.f13527d : "https://www.google.com", R.string.action_ok, new bmr.C3877a() {
            /* renamed from: a */
            public void mo21426a(String str) {
                SettingsActivity.this.f13525b.mo23450a(str);
                SettingsActivity.this.tv_home_page.setText(str);
            }
        });
    }

    /* renamed from: g */
    private void m15030g() {
        this.f13525b.mo23454b(!this.f13525b.mo23459c());
        if (this.f13525b.mo23459c()) {
            this.sc_ad_block.setChecked(true);
            this.tv_ad_block.setText(getResources().getString(R.string.on));
            return;
        }
        this.sc_ad_block.setChecked(false);
        this.tv_ad_block.setText(getResources().getString(R.string.off));
    }

    /* renamed from: h */
    private void m15031h() {
        this.f13525b.mo23465f(!this.f13525b.mo23432E());
        this.tb_save_password.setChecked(this.f13525b.mo23432E());
    }

    /* renamed from: i */
    private void m15032i() {
        WebView webView = new WebView(this);
        webView.clearCache(true);
        webView.destroy();
        bqw.m19012a((Activity) this, (int) R.string.message_cache_cleared);
    }

    /* renamed from: j */
    private void m15033j() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getResources().getString(R.string.title_clear_history));
        bmr.m18088a(this, builder.setMessage((CharSequence) getResources().getString(R.string.dialog_history)).setPositiveButton((CharSequence) getResources().getString(R.string.action_yes), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SettingsActivity.this.m15034k().mo21839a(C4740s.m21407e()).mo21842b(C4740s.m21406d()).mo23840a(new C4123d() {
                    /* renamed from: a */
                    public void mo21414a() {
                        bqw.m19012a((Activity) SettingsActivity.this, (int) R.string.message_clear_history);
                    }
                });
            }
        }).setNegativeButton((CharSequence) getResources().getString(R.string.action_no), (DialogInterface.OnClickListener) null).show());
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public C3659b m15034k() {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                bqx.m19029b(SettingsActivity.this);
                eVar.mo23729a();
                eVar.mo24022a(new RuntimeException("Activity was null in clearHistory"));
            }
        });
    }

    /* renamed from: l */
    private void m15035l() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getResources().getString(R.string.title_clear_cookies));
        builder.setMessage((CharSequence) getResources().getString(R.string.dialog_cookies)).setPositiveButton((CharSequence) getResources().getString(R.string.action_yes), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SettingsActivity.this.m15037n().mo21839a(C4740s.m21407e()).mo21842b(C4740s.m21406d()).mo23840a(new C4123d() {
                    /* renamed from: a */
                    public void mo21414a() {
                        bqw.m19012a((Activity) SettingsActivity.this, (int) R.string.message_cookies_cleared);
                    }
                });
            }
        }).setNegativeButton((CharSequence) getResources().getString(R.string.action_no), (DialogInterface.OnClickListener) null).show();
    }

    /* renamed from: m */
    private void m15036m() {
        bpj.m18578a((Context) this).mo23387d(!bpj.m18578a((Context) this).mo23404k());
        bpj.m18578a((Context) this).mo23375b((Context) this);
        if (bpj.m18578a((Context) this).mo23404k()) {
            this.sc_sync_gallery.setChecked(true);
            this.tv_sync_gallery.setText(getResources().getString(R.string.on));
            return;
        }
        this.sc_sync_gallery.setChecked(false);
        this.tv_sync_gallery.setText(getResources().getString(R.string.off));
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public C3659b m15037n() {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                bqx.m19027a((Context) SettingsActivity.this);
                eVar.mo23729a();
                eVar.mo24022a(new RuntimeException("Activity was null in clearCookies"));
            }
        });
    }

    /* renamed from: o */
    private void m15038o() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getResources().getString(R.string.title_search_engine));
        builder.setSingleChoiceItems(new CharSequence[]{getResources().getString(R.string.custom_url), "Google", "Ask", "Bing", "Yahoo", "StartPage", "StartPage (Mobile)", "DuckDuckGo (Privacy)", "DuckDuckGo Lite (Privacy)", "Baidu (Chinese)", "Yandex (Russian)"}, this.f13525b.mo23433F(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SettingsActivity.this.f13525b.mo23452b(i);
                SettingsActivity.this.m15017a(i, true);
            }
        });
        builder.setPositiveButton((int) R.string.action_ok, (DialogInterface.OnClickListener) null);
        bmr.m18088a(this, builder.show());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15017a(int i, boolean z) {
        switch (i) {
            case 0:
                if (z) {
                    m15039p();
                    return;
                }
                TextView textView = this.tv_search_engine;
                textView.setText(getString(R.string.custom_url) + ": " + this.f13525b.mo23434G());
                return;
            case 1:
                this.tv_search_engine.setText("Google");
                return;
            case 2:
                this.tv_search_engine.setText("Ask");
                return;
            case 3:
                this.tv_search_engine.setText("Bing");
                return;
            case 4:
                this.tv_search_engine.setText("Yahoo");
                return;
            case 5:
                this.tv_search_engine.setText("StartPage");
                return;
            case 6:
                this.tv_search_engine.setText("StartPage (Mobile)");
                return;
            case 7:
                this.tv_search_engine.setText("DuckDuckGo");
                return;
            case 8:
                this.tv_search_engine.setText("DuckDuckGo Lite");
                return;
            case 9:
                this.tv_search_engine.setText("Baidu");
                return;
            case 10:
                this.tv_search_engine.setText("Yandex");
                return;
            default:
                return;
        }
    }

    /* renamed from: p */
    private void m15039p() {
        bmr.m18085a(this, R.string.custom_url, R.string.custom_url, this.f13525b.mo23434G(), R.string.action_ok, new bmr.C3877a() {
            /* renamed from: a */
            public void mo21426a(String str) {
                SettingsActivity.this.f13525b.mo23457c(str);
                TextView textView = SettingsActivity.this.tv_search_engine;
                textView.setText(SettingsActivity.this.getString(R.string.custom_url) + ": " + str);
            }
        });
    }

    /* renamed from: q */
    private void m15040q() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "切换广告类型测试");
        builder.setItems((CharSequence[]) new String[]{"卡片", "全屏"}, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        SettingsActivity.this.m15041r();
                        break;
                    case 1:
                        SettingsActivity.this.m15042s();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m15041r() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "切换卡片测试");
        builder.setItems((CharSequence[]) new String[]{"所有广告", "Admob Advance", "Fan", "vk", "Self"}, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = "";
                switch (i) {
                    case 0:
                        str = "";
                        break;
                    case 1:
                        str = "[\"a-n-h\",\"a-n-r\"]";
                        break;
                    case 2:
                        str = "[\"f-n-h\"]";
                        break;
                    case 3:
                        str = "[\"vk\"]";
                        break;
                    case 4:
                        str = "[\"s\"]";
                        break;
                }
                bpj.m18578a((Context) SettingsActivity.this).mo23376b(str);
                bpj.m18578a((Context) SettingsActivity.this).mo23375b((Context) SettingsActivity.this);
                SettingsActivity.this.m15043t();
                Toast.makeText(SettingsActivity.this, "广告已切换，请杀死程序以清除缓存，再测试", 1).show();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m15042s() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "切换全屏测试");
        builder.setItems((CharSequence[]) new String[]{"所有广告", "Admob", "Fan", "vk"}, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = "";
                switch (i) {
                    case 0:
                        str = "";
                        break;
                    case 1:
                        str = "[\"a-i-h\",\"a-i-r\"]";
                        break;
                    case 2:
                        str = "[\"f-i-h\"]";
                        break;
                    case 3:
                        str = "[\"vk\"]";
                        break;
                }
                bpj.m18578a((Context) SettingsActivity.this).mo23370a(str);
                bpj.m18578a((Context) SettingsActivity.this).mo23375b((Context) SettingsActivity.this);
                SettingsActivity.this.m15043t();
                Toast.makeText(SettingsActivity.this, "广告已切换，请杀死程序以清除缓存，再测试", 1).show();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m15043t() {
        if (this.tv_version != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(bpc.m18490a((Context) this));
            sb.append(" ");
            if (!TextUtils.isEmpty(bpj.m18578a((Context) this).mo23403j())) {
                sb.append("卡片 ");
                sb.append(bpj.m18578a((Context) this).mo23403j());
                sb.append(" ");
            }
            if (!TextUtils.isEmpty(bpj.m18578a((Context) this).mo23401i())) {
                sb.append("全屏 ");
                sb.append(bpj.m18578a((Context) this).mo23401i());
            }
            this.tv_version.setText(sb.toString());
        }
    }
}
