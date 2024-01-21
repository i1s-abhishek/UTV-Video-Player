package video.downloader.videodownloader.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebIconDatabase;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.palette.graphics.Palette;

import com.anthonycr.progress.AnimatedProgressBar;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.liulishuo.filedownloader.FileDownloader;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import classesdef.browser.C4740s;
import classesdef.browser.bbc;
import classesdef.browser.bls;
import classesdef.browser.blt;
import classesdef.browser.blv;
import classesdef.browser.blw;
import classesdef.browser.bmb;
import classesdef.browser.bmf;
import classesdef.browser.bmg;
import classesdef.browser.bmj;
import classesdef.browser.bmq;
import classesdef.browser.bmr;
import classesdef.browser.bms;
import classesdef.browser.bnd;
import classesdef.browser.ManualDrawerDownloadAdapter;
import classesdef.browser.bnn;
import classesdef.browser.bno;
import classesdef.browser.bnq;
import classesdef.browser.bog;
import classesdef.browser.bok;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.bov;
import classesdef.browser.box;
import classesdef.browser.bph;
import classesdef.browser.bpm;
import classesdef.browser.bqb;
import classesdef.browser.bqh;
import classesdef.browser.bqj;
import classesdef.browser.bql;
import classesdef.browser.bqm;
import classesdef.browser.bqt;
import classesdef.browser.bqv;
import classesdef.browser.bqw;
import classesdef.browser.bqx;
import classesdef.browser.download.boi;
import classesdef.browser.download.bol;
import classesdef.browser.download.bpd;
import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4123d;
import classesdef.browser.tab.C4892v;
import classesdef.eventbus.bnr;
import classesdef.eventbus.bns;
import classesdef.eventbus.bnv;
import classesdef.eventbus.bnw;
import classesdef.eventbus.bny;
import classesdef.eventbus.bnz;
import classesdef.eventbus.boa;
import classesdef.eventbus.bob;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.bpe;
import classesdef.xdplayer.bpj;
import es.dmoral.toasty.Toasty;
import me.shaohui.bottomdialog.BottomDialog;
import hdplayer.xdplayer.videoplayer.R;
import q.rorbin.badgeview.QBadgeView;
import video.downloader.videodownloader.app.BrowserApp;
import video.downloader.videodownloader.five.activity.FilesActivity;
import video.downloader.videodownloader.five.activity.HelpActivity;
import video.downloader.videodownloader.five.activity.NoWebViewActivity;
import video.downloader.videodownloader.five.service.ManualParseService;
import video.downloader.videodownloader.five.view.FixedDrawerLayout;
import video.downloader.videodownloader.fragment.BookmarksFragment;
import video.downloader.videodownloader.fragment.TabsFragment;
import video.downloader.videodownloader.receiver.NetworkReceiver;
import video.downloader.videodownloader.view.Main_Looper;
import video.downloader.videodownloader.view.WebViewBrowser;
import video.downloader.videodownloader.view.SearchView;

public abstract class BrowserActivity extends ThemableBrowserActivity implements View.OnClickListener, blv, bmf {


    public static String f13354a;

    private static final int f13355af = Build.VERSION.SDK_INT;

    private static final ViewGroup.LayoutParams f13356ag = new ViewGroup.LayoutParams(-1, -1);

    private static final FrameLayout.LayoutParams f13357ah = new FrameLayout.LayoutParams(-1, -1);
    /* access modifiers changed from: private */

    public bqb f13358A;

    private WebChromeClient.CustomViewCallback f13359B;

    private ValueCallback<Uri> f13360C;

    private ValueCallback<Uri[]> f13361D;

    private boolean f13362E;

    private boolean f13363F;

    private boolean f13364G = false;


    private boolean f13365H = false;
    /* access modifiers changed from: private */

    public boolean f13366I;


    private boolean f13367J;


    private int f13368K;

    private int f13369L;

    private int f13370M;


    private int f13371N;
    /* access modifiers changed from: private */

    public int f13372O = -16777216;


    private long f13373P;


    private String f13374Q;


    private String f13375R;
    /* access modifiers changed from: private */


    public boolean f13376S;
    /* access modifiers changed from: private */


    public boolean f13377T;


    private boolean f13378U = false;
    /* access modifiers changed from: private */


    public TabsManager f13379V;

    private Bitmap f13380W;
    /* access modifiers changed from: private */


    public final ColorDrawable f13381X = new ColorDrawable();


    private Drawable f13382Y;


    private Drawable f13383Z;
    /* access modifiers changed from: private */


    public Drawable f13384aa;
    /* access modifiers changed from: private */


    public Drawable f13385ab;
    /* access modifiers changed from: private */


    public blt f13386ac;


    private blw f13387ad;
    /* access modifiers changed from: private */

    public bls f13388ae;


    private MenuItem f13389ai;


    private MenuItem f13390aj;


    private final int f13391ak = 0;


    private final int f13392al = 1;


    private final int f13393am = 2;

    private BottomDialog f13394an;


    private BottomDialog f13395ao;
    /* access modifiers changed from: private */

    public bnd f13396ap;


    private LinearLayout f13397aq;


    private ManualDrawerDownloadAdapter f13398ar;


    private ImageView f13399as;


    private Handler f13400at = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (BrowserActivity.this.f13411m != null) {
                        BrowserActivity.this.f13411m.start();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: au */
    private final NetworkReceiver f13401au = new NetworkReceiver() {
        /* renamed from: a */
        public void check(boolean z) {
            Log.d("BrowserActivity", "Network Connected: " + z);
            BrowserActivity.this.f13379V.mo21455a(z);
        }
    };
    @Inject

    /* renamed from: b */
            bmj f13402b;
    @Inject

    /* renamed from: c */
            bms f13403c;
    @Inject

    /* renamed from: d */
            bqm f13404d;

    /* renamed from: g */
    private final int f13405g = 0;

    /* renamed from: h */
    private final int f13406h = 1;

    /* renamed from: i */
    private View f13407i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f13408j;

    /* renamed from: k */
    private ImageView f13409k;

    /* renamed from: l */
    private ImageView f13410l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public AnimationDrawable f13411m;
    @BindView(R.id.content_frame)
    FrameLayout mBrowserFrame;
    @BindView(R.id.drawer_layout)
    FixedDrawerLayout mDrawerLayout;
    @BindView(R.id.left_drawer)
    ViewGroup mDrawerLeft;
    @BindView(R.id.right_drawer)
    ViewGroup mDrawerRight;
    @BindView(R.id.progress_view)
    AnimatedProgressBar mProgressBar;
    @BindView(R.id.search_bar)
    RelativeLayout mSearchBar;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_layout)
    ViewGroup mToolbarLayout;
    @BindView(R.id.ui_layout)
    ViewGroup mUiLayout;

    /* renamed from: n */
    private BottomNavigationViewEx f13412n;

    /* renamed from: o */
    private QBadgeView f13413o;

    /* renamed from: p */
    private View f13414p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public BottomNavigationItemView f13415q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public float f13416r;

    /* renamed from: s */
    private QBadgeView f13417s;

    /* renamed from: t */
    private View f13418t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public SearchView f13419u;

    /* renamed from: v */
    private ImageView f13420v;

    /* renamed from: w */
    private View f13421w;

    /* renamed from: x */
    private FrameLayout f13422x;

    /* renamed from: y */
    private View f13423y;

    /* renamed from: z */
    private PopupWindow f13424z;

    /* renamed from: U */
    private void m14846U() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo21307a();

    /* renamed from: b */
    public abstract void mo21308b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract C3659b mo21314c();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT <= 19 || bpd.m18517g(this, "com.android.webview") || bpd.m18517g(this, "com.google.android.webview")) {
            try {
                new WebView(this);
                BrowserApp.m15129g().mo21497a(this);
                this.f13377T = true;
                setContentView((int) R.layout.activity_main);
                ButterKnife.bind((Activity) this);
                EventBus.getDefault().register((Object) this);
                if (!FileDownloader.getImpl().isServiceConnected()) {
                    FileDownloader.getImpl().bindService();
                }
                if (!FileDownloader.isEnabledAvoidDropFrame()) {
                    FileDownloader.enableAvoidDropFrame();
                }
                FileDownloader.setGlobalPost2UIInterval(15);
                this.f13407i = findViewById(R.id.help_layout);
                if (bpj.m18578a((Context) this).mo23413t()) {
                    this.f13407i.setVisibility(0);
                    this.f13407i.setOnClickListener(this);
                    this.f13407i.findViewById(R.id.help_close).setOnClickListener(this);
                } else {
                    this.f13407i.setVisibility(8);
                }
                this.f13408j = findViewById(R.id.rl_download_fab);
                this.f13410l = (ImageView) findViewById(R.id.download_fab_no_found);
                this.f13410l.setOnClickListener(this);
                this.f13409k = (ImageView) findViewById(R.id.download_fab);
                this.f13409k.setOnClickListener(this);
                this.f13412n = (BottomNavigationViewEx) findViewById(R.id.bottom_nav_view);
                this.f13412n.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
                    /* renamed from: a */
                    public void onNavigationItemReselected(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.menu_tab) {
                            Logger.e("select tab reselected", new Object[0]);
                            try {
                                if (BrowserActivity.this.mDrawerLayout != null && !BrowserActivity.this.f13376S && !BrowserActivity.this.f13377T) {
                                    if (BrowserActivity.this.mDrawerLayout.isDrawerOpen(BrowserActivity.this.m14840O())) {
                                        BrowserActivity.this.mDrawerLayout.closeDrawer(BrowserActivity.this.m14840O());
                                    } else {
                                        BrowserActivity.this.mDrawerLayout.openDrawer(BrowserActivity.this.m14840O());
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                bbc.m15886a().mo21879a((Context) BrowserActivity.this, (Throwable) e);
                            }
                        }
                    }
                });
                this.f13412n.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    /* renamed from: a */
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu_progress /*2131296628*/:
                                Intent intent = new Intent(BrowserActivity.this, FilesActivity.class);
                                intent.setFlags(131072);
                                intent.putExtra("position", 1);
                                BrowserActivity.this.startActivity(intent);
                                EventBus.getDefault().post(new bnq(1));
                                BrowserLogEvent.downloaderLogEvent(BrowserActivity.this, "main page", "bottom menu:click progress");
                                break;
                        }
                        return true;
                    }
                });
                this.f13415q = (BottomNavigationItemView) this.f13412n.findViewById(R.id.menu_progress);
                this.f13415q.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        float unused = BrowserActivity.this.f13416r = (float) BrowserActivity.this.f13415q.getWidth();
                        BrowserActivity.this.m14845T();
                    }
                });
                this.f13379V = new TabsManager();
                this.f13386ac = new blt(this, mo21307a());
                m14855a(bundle);
                if (bpj.m18578a((Context) this).mo23411r() == 0) {
                    bpj.m18578a((Context) this).mo23390e(System.currentTimeMillis());
                    bpj.m18578a((Context) this).mo23375b((Context) this);
                }
                this.f13400at.sendEmptyMessageDelayed(0, 300);
                bog.m18300a(this, new bog.C3979a() {
                    /* renamed from: a */
                    public void mo21383a(boolean z) {
                        if (z || bqv.m19001a(BrowserActivity.this.m14843R())) {
                            BrowserActivity.this.f13408j.setVisibility(8);
                        } else {
                            BrowserActivity.this.f13408j.setVisibility(0);
                        }
                    }
                });
                box.m18457a(this, (box.C3987a) null);
            } catch (Exception e) {
                this.f13378U = true;
                finish();
                bbc.m15886a().mo21879a((Context) this, (Throwable) e);
            }
        } else {
            this.f13378U = true;
            startActivity(new Intent(this, NoWebViewActivity.class));
            finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0298  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m14855aa(Bundle r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            android.content.res.Resources r0 = r10.getResources()     // Catch:{ all -> 0x02aa }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ all -> 0x02aa }
            r10.m14853a((android.content.res.Configuration) r0)     // Catch:{ all -> 0x02aa }
            android.support.v7.widget.Toolbar r0 = r10.mToolbar     // Catch:{ all -> 0x02aa }
            r10.setSupportActionBar(r0)     // Catch:{ all -> 0x02aa }
            android.support.v7.app.ActionBar r0 = r10.getSupportActionBar()     // Catch:{ all -> 0x02aa }
            bpn r1 = r10.f13548e     // Catch:{ all -> 0x02aa }
            int r1 = r1.mo23438K()     // Catch:{ all -> 0x02aa }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0028
            boolean r1 = r10.mo21307a()     // Catch:{ all -> 0x02aa }
            if (r1 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = 0
            goto L_0x0029
        L_0x0028:
            r1 = 1
        L_0x0029:
            r10.f13363F = r1     // Catch:{ all -> 0x02aa }
            boolean r1 = r10.f13363F     // Catch:{ all -> 0x02aa }
            if (r1 == 0) goto L_0x0034
            int r1 = p000.bqt.m18998f(r10)     // Catch:{ all -> 0x02aa }
            goto L_0x0038
        L_0x0034:
            int r1 = p000.bqt.m18997e(r10)     // Catch:{ all -> 0x02aa }
        L_0x0038:
            r10.f13370M = r1     // Catch:{ all -> 0x02aa }
            boolean r1 = r10.f13363F     // Catch:{ all -> 0x02aa }
            if (r1 == 0) goto L_0x0046
            r1 = 2131099768(0x7f060078, float:1.7811899E38)
            int r1 = android.support.p001v4.content.ContextCompat.getColor(r10, r1)     // Catch:{ all -> 0x02aa }
            goto L_0x004d
        L_0x0046:
            r1 = 2131099770(0x7f06007a, float:1.7811903E38)
            int r1 = android.support.p001v4.content.ContextCompat.getColor(r10, r1)     // Catch:{ all -> 0x02aa }
        L_0x004d:
            r10.f13371N = r1     // Catch:{ all -> 0x02aa }
            bpn r1 = r10.f13548e     // Catch:{ all -> 0x02aa }
            boolean r4 = r10.mo21438D()     // Catch:{ all -> 0x02aa }
            r4 = r4 ^ r2
            boolean r1 = r1.mo23451a((boolean) r4)     // Catch:{ all -> 0x02aa }
            r10.f13366I = r1     // Catch:{ all -> 0x02aa }
            bpn r1 = r10.f13548e     // Catch:{ all -> 0x02aa }
            boolean r1 = r1.mo23455b()     // Catch:{ all -> 0x02aa }
            r10.f13367J = r1     // Catch:{ all -> 0x02aa }
            int r1 = p000.bqt.m18986a((android.content.Context) r10)     // Catch:{ all -> 0x02aa }
            android.graphics.drawable.ColorDrawable r4 = r10.f13381X     // Catch:{ all -> 0x02aa }
            r4.setColor(r1)     // Catch:{ all -> 0x02aa }
            android.view.ViewGroup r1 = r10.mDrawerLeft     // Catch:{ all -> 0x02aa }
            r4 = 0
            r1.setLayerType(r3, r4)     // Catch:{ all -> 0x02aa }
            android.view.ViewGroup r1 = r10.mDrawerRight     // Catch:{ all -> 0x02aa }
            r1.setLayerType(r3, r4)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.five.view.FixedDrawerLayout r1 = r10.mDrawerLayout     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.activity.BrowserActivity$33 r5 = new video.downloader.video.downloader.videodownloader.activity.BrowserActivity$33     // Catch:{ all -> 0x02aa }
            r5.<init>()     // Catch:{ all -> 0x02aa }
            r1.addDrawerListener(r5)     // Catch:{ all -> 0x02aa }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02aa }
            r5 = 21
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r1 < r5) goto L_0x0095
            boolean r1 = r10.f13366I     // Catch:{ all -> 0x02aa }
            if (r1 != 0) goto L_0x0095
            android.view.Window r1 = r10.getWindow()     // Catch:{ all -> 0x02aa }
            r1.setStatusBarColor(r6)     // Catch:{ all -> 0x02aa }
        L_0x0095:
            r10.m14834I()     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.five.view.FixedDrawerLayout r1 = r10.mDrawerLayout     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.activity.BrowserActivity$a r5 = new video.downloader.video.downloader.videodownloader.activity.BrowserActivity$a     // Catch:{ all -> 0x02aa }
            r5.<init>()     // Catch:{ all -> 0x02aa }
            r1.addDrawerListener(r5)     // Catch:{ all -> 0x02aa }
            r1 = 2131231076(0x7f080164, float:1.8078223E38)
            boolean r5 = r10.f13363F     // Catch:{ all -> 0x02aa }
            android.graphics.Bitmap r1 = p000.bqt.m18990a(r10, r1, r5)     // Catch:{ all -> 0x02aa }
            r10.f13380W = r1     // Catch:{ all -> 0x02aa }
            android.support.v4.app.FragmentManager r1 = r10.getSupportFragmentManager()     // Catch:{ all -> 0x02aa }
            java.lang.String r5 = "TAG_TABS_FRAGMENT"
            android.support.v4.app.Fragment r5 = r1.findFragmentByTag(r5)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.fragment.TabsFragment r5 = (video.downloader.video.downloader.videodownloader.fragment.TabsFragment) r5     // Catch:{ all -> 0x02aa }
            java.lang.String r7 = "TAG_BOOKMARK_FRAGMENT"
            android.support.v4.app.Fragment r7 = r1.findFragmentByTag(r7)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.fragment.BookmarksFragment r7 = (video.downloader.video.downloader.videodownloader.fragment.BookmarksFragment) r7     // Catch:{ all -> 0x02aa }
            if (r5 == 0) goto L_0x00ce
            android.support.v4.app.FragmentTransaction r8 = r1.beginTransaction()     // Catch:{ all -> 0x02aa }
            android.support.v4.app.FragmentTransaction r5 = r8.remove(r5)     // Catch:{ all -> 0x02aa }
            r5.commit()     // Catch:{ all -> 0x02aa }
        L_0x00ce:
            boolean r5 = r10.mo21307a()     // Catch:{ all -> 0x02aa }
            boolean r8 = r10.f13366I     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.fragment.TabsFragment r5 = video.downloader.video.downloader.videodownloader.fragment.TabsFragment.m15312a(r5, r8)     // Catch:{ all -> 0x02aa }
            r10.f13387ad = r5     // Catch:{ all -> 0x02aa }
            if (r7 == 0) goto L_0x00e7
            android.support.v4.app.FragmentTransaction r8 = r1.beginTransaction()     // Catch:{ all -> 0x02aa }
            android.support.v4.app.FragmentTransaction r7 = r8.remove(r7)     // Catch:{ all -> 0x02aa }
            r7.commit()     // Catch:{ all -> 0x02aa }
        L_0x00e7:
            boolean r7 = r10.mo21307a()     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.fragment.BookmarksFragment r7 = video.downloader.video.downloader.videodownloader.fragment.BookmarksFragment.m15268a((boolean) r7)     // Catch:{ all -> 0x02aa }
            r10.f13388ae = r7     // Catch:{ all -> 0x02aa }
            r1.executePendingTransactions()     // Catch:{ all -> 0x02aa }
            android.support.v4.app.FragmentTransaction r1 = r1.beginTransaction()     // Catch:{ all -> 0x02aa }
            int r8 = r10.m14833H()     // Catch:{ all -> 0x02aa }
            java.lang.String r9 = "TAG_TABS_FRAGMENT"
            android.support.v4.app.FragmentTransaction r1 = r1.replace(r8, r5, r9)     // Catch:{ all -> 0x02aa }
            int r5 = r10.m14832G()     // Catch:{ all -> 0x02aa }
            java.lang.String r8 = "TAG_BOOKMARK_FRAGMENT"
            android.support.v4.app.FragmentTransaction r1 = r1.replace(r5, r7, r8)     // Catch:{ all -> 0x02aa }
            r1.commit()     // Catch:{ all -> 0x02aa }
            boolean r1 = r10.f13366I     // Catch:{ all -> 0x02aa }
            if (r1 == 0) goto L_0x011f
            android.view.ViewGroup r1 = r10.mToolbarLayout     // Catch:{ all -> 0x02aa }
            r5 = 2131296875(0x7f09026b, float:1.821168E38)
            android.view.View r5 = r10.findViewById(r5)     // Catch:{ all -> 0x02aa }
            r1.removeView(r5)     // Catch:{ all -> 0x02aa }
        L_0x011f:
            p000.bql.m18952a(r0)     // Catch:{ all -> 0x02aa }
            r0.setDisplayShowTitleEnabled(r3)     // Catch:{ all -> 0x02aa }
            r0.setDisplayShowHomeEnabled(r3)     // Catch:{ all -> 0x02aa }
            r0.setDisplayShowCustomEnabled(r2)     // Catch:{ all -> 0x02aa }
            r1 = 2131427533(0x7f0b00cd, float:1.8476685E38)
            r0.setCustomView((int) r1)     // Catch:{ all -> 0x02aa }
            android.view.View r0 = r0.getCustomView()     // Catch:{ all -> 0x02aa }
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()     // Catch:{ all -> 0x02aa }
            r5 = -1
            r1.width = r5     // Catch:{ all -> 0x02aa }
            r1.height = r5     // Catch:{ all -> 0x02aa }
            r0.setLayoutParams(r1)     // Catch:{ all -> 0x02aa }
            r1 = 2131296358(0x7f090066, float:1.821063E38)
            android.view.View r1 = r0.findViewById(r1)     // Catch:{ all -> 0x02aa }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ all -> 0x02aa }
            r10.f13420v = r1     // Catch:{ all -> 0x02aa }
            boolean r1 = r10.f13366I     // Catch:{ all -> 0x02aa }
            if (r1 == 0) goto L_0x016b
            android.widget.ImageView r1 = r10.f13420v     // Catch:{ all -> 0x02aa }
            int r1 = r1.getWidth()     // Catch:{ all -> 0x02aa }
            if (r1 > 0) goto L_0x015d
            android.widget.ImageView r1 = r10.f13420v     // Catch:{ all -> 0x02aa }
            r1.measure(r3, r3)     // Catch:{ all -> 0x02aa }
        L_0x015d:
            r10.mo21321f((int) r3)     // Catch:{ all -> 0x02aa }
            android.os.Handler r1 = video.downloader.video.downloader.videodownloader.view.C3604b.f13821a     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.activity.BrowserActivity$34 r7 = new video.downloader.video.downloader.videodownloader.activity.BrowserActivity$34     // Catch:{ all -> 0x02aa }
            r7.<init>()     // Catch:{ all -> 0x02aa }
            r1.post(r7)     // Catch:{ all -> 0x02aa }
            goto L_0x0186
        L_0x016b:
            android.os.Handler r1 = video.downloader.video.downloader.videodownloader.view.C3604b.f13821a     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.activity.BrowserActivity$35 r7 = new video.downloader.video.downloader.videodownloader.activity.BrowserActivity$35     // Catch:{ all -> 0x02aa }
            r7.<init>()     // Catch:{ all -> 0x02aa }
            r1.post(r7)     // Catch:{ all -> 0x02aa }
            android.widget.ImageView r1 = r10.f13420v     // Catch:{ all -> 0x02aa }
            r7 = 2131230922(0x7f0800ca, float:1.807791E38)
            r1.setImageResource(r7)     // Catch:{ all -> 0x02aa }
            android.widget.ImageView r1 = r10.f13420v     // Catch:{ all -> 0x02aa }
            int r7 = r10.f13370M     // Catch:{ all -> 0x02aa }
            android.graphics.PorterDuff$Mode r8 = android.graphics.PorterDuff.Mode.SRC_IN     // Catch:{ all -> 0x02aa }
            r1.setColorFilter(r7, r8)     // Catch:{ all -> 0x02aa }
        L_0x0186:
            android.os.Handler r1 = video.downloader.video.downloader.videodownloader.view.C3604b.f13821a     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.activity.BrowserActivity$36 r7 = new video.downloader.video.downloader.videodownloader.activity.BrowserActivity$36     // Catch:{ all -> 0x02aa }
            r7.<init>()     // Catch:{ all -> 0x02aa }
            r1.post(r7)     // Catch:{ all -> 0x02aa }
            android.widget.ImageView r1 = r10.f13420v     // Catch:{ all -> 0x02aa }
            r1.setOnClickListener(r10)     // Catch:{ all -> 0x02aa }
            r1 = 2131296414(0x7f09009e, float:1.8210744E38)
            android.view.View r1 = r0.findViewById(r1)     // Catch:{ all -> 0x02aa }
            r1.setOnClickListener(r10)     // Catch:{ all -> 0x02aa }
            r1 = 2131296790(0x7f090216, float:1.8211507E38)
            android.view.View r1 = r0.findViewById(r1)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r1 = (video.downloader.video.downloader.videodownloader.view.SearchView) r1     // Catch:{ all -> 0x02aa }
            r10.f13419u = r1     // Catch:{ all -> 0x02aa }
            r1 = 2131296795(0x7f09021b, float:1.8211517E38)
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ all -> 0x02aa }
            r10.f13418t = r0     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r0 = r10.f13419u     // Catch:{ all -> 0x02aa }
            boolean r1 = r10.f13363F     // Catch:{ all -> 0x02aa }
            int r1 = p000.bqt.m18989a((boolean) r1)     // Catch:{ all -> 0x02aa }
            r0.setHintTextColor(r1)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r0 = r10.f13419u     // Catch:{ all -> 0x02aa }
            boolean r1 = r10.f13363F     // Catch:{ all -> 0x02aa }
            if (r1 == 0) goto L_0x01c5
            r6 = -1
        L_0x01c5:
            r0.setTextColor(r6)     // Catch:{ all -> 0x02aa }
            r0 = 2131624475(0x7f0e021b, float:1.887613E38)
            java.lang.String r0 = r10.getString(r0)     // Catch:{ all -> 0x02aa }
            r10.f13374Q = r0     // Catch:{ all -> 0x02aa }
            r10.f13369L = r5     // Catch:{ all -> 0x02aa }
            boolean r0 = r10.f13363F     // Catch:{ all -> 0x02aa }
            r1 = 2131230918(0x7f0800c6, float:1.8077902E38)
            android.graphics.drawable.Drawable r0 = p000.bqt.m18993b(r10, r1, r0)     // Catch:{ all -> 0x02aa }
            r10.f13382Y = r0     // Catch:{ all -> 0x02aa }
            r0 = 2131231045(0x7f080145, float:1.807816E38)
            boolean r5 = r10.f13363F     // Catch:{ all -> 0x02aa }
            android.graphics.drawable.Drawable r0 = p000.bqt.m18993b(r10, r0, r5)     // Catch:{ all -> 0x02aa }
            r10.f13383Z = r0     // Catch:{ all -> 0x02aa }
            boolean r0 = r10.f13363F     // Catch:{ all -> 0x02aa }
            android.graphics.drawable.Drawable r0 = p000.bqt.m18993b(r10, r1, r0)     // Catch:{ all -> 0x02aa }
            r10.f13384aa = r0     // Catch:{ all -> 0x02aa }
            r0 = 1103101952(0x41c00000, float:24.0)
            int r0 = p000.bqw.m19007a((float) r0)     // Catch:{ all -> 0x02aa }
            android.graphics.drawable.Drawable r1 = r10.f13382Y     // Catch:{ all -> 0x02aa }
            r1.setBounds(r3, r3, r0, r0)     // Catch:{ all -> 0x02aa }
            android.graphics.drawable.Drawable r1 = r10.f13383Z     // Catch:{ all -> 0x02aa }
            r1.setBounds(r3, r3, r0, r0)     // Catch:{ all -> 0x02aa }
            android.graphics.drawable.Drawable r1 = r10.f13384aa     // Catch:{ all -> 0x02aa }
            r1.setBounds(r3, r3, r0, r0)     // Catch:{ all -> 0x02aa }
            android.graphics.drawable.Drawable r0 = r10.f13383Z     // Catch:{ all -> 0x02aa }
            r10.f13385ab = r0     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.activity.BrowserActivity$b r0 = new video.downloader.video.downloader.videodownloader.activity.BrowserActivity$b     // Catch:{ all -> 0x02aa }
            r0.<init>()     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r1 = r10.f13419u     // Catch:{ all -> 0x02aa }
            r5 = 1077936128(0x40400000, float:3.0)
            int r5 = p000.bqw.m19007a((float) r5)     // Catch:{ all -> 0x02aa }
            r1.setCompoundDrawablePadding(r5)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r1 = r10.f13419u     // Catch:{ all -> 0x02aa }
            android.graphics.drawable.Drawable r5 = r10.f13383Z     // Catch:{ all -> 0x02aa }
            r1.setCompoundDrawables(r4, r4, r5, r4)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r1 = r10.f13419u     // Catch:{ all -> 0x02aa }
            r1.setOnKeyListener(r0)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r1 = r10.f13419u     // Catch:{ all -> 0x02aa }
            r1.setOnFocusChangeListener(r0)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r1 = r10.f13419u     // Catch:{ all -> 0x02aa }
            r1.setOnEditorActionListener(r0)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r1 = r10.f13419u     // Catch:{ all -> 0x02aa }
            r1.setOnTouchListener(r0)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r1 = r10.f13419u     // Catch:{ all -> 0x02aa }
            r1.setOnPreFocusListener(r0)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r0 = r10.f13419u     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.activity.BrowserActivity$37 r1 = new video.downloader.video.downloader.videodownloader.activity.BrowserActivity$37     // Catch:{ all -> 0x02aa }
            r1.<init>()     // Catch:{ all -> 0x02aa }
            r0.addTextChangedListener(r1)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.view.SearchView r0 = r10.f13419u     // Catch:{ all -> 0x02aa }
            r10.m14859a((android.widget.AutoCompleteTextView) r0)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.five.view.FixedDrawerLayout r0 = r10.mDrawerLayout     // Catch:{ all -> 0x02aa }
            r1 = 2131230907(0x7f0800bb, float:1.807788E38)
            r5 = 8388613(0x800005, float:1.175495E-38)
            r0.setDrawerShadow((int) r1, (int) r5)     // Catch:{ all -> 0x02aa }
            video.downloader.video.downloader.videodownloader.five.view.FixedDrawerLayout r0 = r10.mDrawerLayout     // Catch:{ all -> 0x02aa }
            r1 = 2131230906(0x7f0800ba, float:1.8077878E38)
            r5 = 8388611(0x800003, float:1.1754948E-38)
            r0.setDrawerShadow((int) r1, (int) r5)     // Catch:{ all -> 0x02aa }
            int r0 = f13355af     // Catch:{ all -> 0x02aa }
            r1 = 18
            if (r0 > r1) goto L_0x0276
            android.webkit.WebIconDatabase r0 = android.webkit.WebIconDatabase.getInstance()     // Catch:{ all -> 0x02aa }
            java.lang.String r1 = "icons"
            java.io.File r1 = r10.getDir(r1, r3)     // Catch:{ all -> 0x02aa }
            java.lang.String r1 = r1.getPath()     // Catch:{ all -> 0x02aa }
            r0.open(r1)     // Catch:{ all -> 0x02aa }
        L_0x0276:
            if (r11 != 0) goto L_0x027d
            android.content.Intent r11 = r10.getIntent()     // Catch:{ all -> 0x02aa }
            goto L_0x027e
        L_0x027d:
            r11 = r4
        L_0x027e:
            if (r11 == 0) goto L_0x028a
            int r0 = r11.getFlags()     // Catch:{ all -> 0x02aa }
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x028a
            goto L_0x028b
        L_0x028a:
            r2 = 0
        L_0x028b:
            boolean r0 = m14866a((android.content.Intent) r11)     // Catch:{ all -> 0x02aa }
            if (r0 == 0) goto L_0x0298
            r10.setIntent(r4)     // Catch:{ all -> 0x02aa }
            r10.mo21318e()     // Catch:{ all -> 0x02aa }
            goto L_0x02a8
        L_0x0298:
            if (r2 == 0) goto L_0x029b
            r11 = r4
        L_0x029b:
            blt r0 = r10.f13386ac     // Catch:{ all -> 0x02aa }
            r0.mo23011a((android.content.Intent) r11)     // Catch:{ all -> 0x02aa }
            r10.setIntent(r4)     // Catch:{ all -> 0x02aa }
            bqm r11 = r10.f13404d     // Catch:{ all -> 0x02aa }
            r11.mo23575a((android.app.Activity) r10)     // Catch:{ all -> 0x02aa }
        L_0x02a8:
            monitor-exit(r10)
            return
        L_0x02aa:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.activity.BrowserActivity.m14855a(android.os.Bundle):void");
    }
    private synchronized void m14855a(Bundle bundle) {
        boolean z2;
        int i2;
        TabsFragment tabsFragment;
        BookmarksFragment bookmarksFragment;
        Intent intent;
        m14853a(getResources().getConfiguration());
        setSupportActionBar(this.mToolbar);
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        boolean z3 = true;
        if (this.f13548e.mo23438K() == 0) {
            if (!mo21307a()) {
                z2 = false;
                this.f13363F = z2;
                this.f13370M = !this.f13363F ? bqt.m18998f(this) : bqt.m18997e(this);
                if (!this.f13363F) {
                    i2 = ContextCompat.getColor(this, R.color.icon_dark_theme_disabled);
                } else {
                    i2 = ContextCompat.getColor(this, R.color.icon_light_theme_disabled);
                }
                this.f13371N = i2;
                this.f13366I = this.f13548e.mo23451a(!mo21438D());
                this.f13367J = this.f13548e.mo23455b();
                this.f13381X.setColor(bqt.m18986a(this));
                this.mDrawerLeft.setLayerType(0, null);
                this.mDrawerRight.setLayerType(0, null);
                this.mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
                    /* class video.downloader.videodownloader.activity.BrowserActivity.AnonymousClass33 */

                    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
                    public void onDrawerSlide(View view, float f) {
                    }

                    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
                    public void onDrawerOpened(View view) {
                        BrowserActivity.this.f13408j.setVisibility(8);
                    }

                    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
                    public void onDrawerClosed(View view) {
                        BrowserActivity.this.f13408j.setVisibility(0);
                    }

                    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
                    public void onDrawerStateChanged(int i) {
                        if (i == 1) {
                            BrowserActivity.this.mDrawerLeft.setLayerType(2, null);
                            BrowserActivity.this.mDrawerRight.setLayerType(2, null);
                        } else if (i == 0) {
                            BrowserActivity.this.mDrawerLeft.setLayerType(0, null);
                            BrowserActivity.this.mDrawerRight.setLayerType(0, null);
                        }
                    }
                });
                int i3 = -16777216;
                if (Build.VERSION.SDK_INT >= 21 && !this.f13366I) {
                    getWindow().setStatusBarColor(-16777216);
                }
                m14834I();
                this.mDrawerLayout.addDrawerListener(new C3495a());
                this.f13380W = bqt.m18990a(this, R.drawable.ic_webpage, this.f13363F);
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                tabsFragment = (TabsFragment) supportFragmentManager.findFragmentByTag("TAG_TABS_FRAGMENT");
                bookmarksFragment = (BookmarksFragment) supportFragmentManager.findFragmentByTag("TAG_BOOKMARK_FRAGMENT");
                if (tabsFragment != null) {
                    supportFragmentManager.beginTransaction().remove(tabsFragment).commit();
                }
                TabsFragment a2 = TabsFragment.m15312a(mo21307a(), this.f13366I);
                this.f13387ad = a2;
                if (bookmarksFragment != null) {
                    supportFragmentManager.beginTransaction().remove(bookmarksFragment).commit();
                }
                BookmarksFragment a3 = BookmarksFragment.m15268a(mo21307a());
                this.f13388ae = a3;
                supportFragmentManager.executePendingTransactions();
                supportFragmentManager.beginTransaction().replace(m14833H(), a2, "TAG_TABS_FRAGMENT").replace(m14832G(), a3, "TAG_BOOKMARK_FRAGMENT").commit();
                if (this.f13366I) {
                    this.mToolbarLayout.removeView(findViewById(R.id.tabs_toolbar_container));
                }
                bql.m18952a(supportActionBar);
                supportActionBar.setDisplayShowTitleEnabled(false);
                supportActionBar.setDisplayShowHomeEnabled(false);
                supportActionBar.setDisplayShowCustomEnabled(true);
                supportActionBar.setCustomView(R.layout.toolbar_content);
                View customView = supportActionBar.getCustomView();
                ViewGroup.LayoutParams layoutParams = customView.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                customView.setLayoutParams(layoutParams);
                this.f13420v= (ImageView) customView.findViewById(R.id.arrow_button);
                if (!this.f13366I) {
                    if (this.f13420v.getWidth() <= 0) {
                        this.f13420v.measure(0, 0);
                    }
                    mo21321f(0);
                    Main_Looper.f13821a.post(new Runnable() {
                        /* class video.downloader.videodownloader.activity.BrowserActivity.AnonymousClass34 */

                        public void run() {
                            BrowserActivity.this.mDrawerLayout.setDrawerLockMode(0, BrowserActivity.this.m14840O());
                        }
                    });
                } else {
                    Main_Looper.f13821a.post(new Runnable() {
                        /* class video.downloader.videodownloader.activity.BrowserActivity.AnonymousClass35 */

                        public void run() {
                            BrowserActivity.this.mDrawerLayout.setDrawerLockMode(1, BrowserActivity.this.m14840O());
                        }
                    });
                    this.f13420v.setImageResource(R.drawable.ic_action_home);
                    this.f13420v.setColorFilter(this.f13370M, PorterDuff.Mode.SRC_IN);
                }
                Main_Looper.f13821a.post(new Runnable() {
                    /* class video.downloader.videodownloader.activity.BrowserActivity.AnonymousClass36 */

                    public void run() {
                        BrowserActivity.this.mDrawerLayout.setDrawerLockMode(0, BrowserActivity.this.m14839N());
                    }
                });
                this.f13420v.setOnClickListener(this);
                customView.findViewById(R.id.close_browser).setOnClickListener(this);
                this.f13419u = (SearchView) customView.findViewById(R.id.search);
                this.f13418t = customView.findViewById(R.id.search_container);
                this.f13419u.setHintTextColor(bqt.m18989a(this.f13363F));
                SearchView searchView = this.f13419u;
                if (this.f13363F) {
                    i3 = -1;
                }
                searchView.setTextColor(i3);
                this.f13374Q = getString(R.string.untitled);
                this.f13369L = -1;
                this.f13382Y = bqt.m18993b(this, R.drawable.ic_action_delete, this.f13363F);
                this.f13383Z = bqt.m18993b(this, R.drawable.ic_refresh_black_24dp, this.f13363F);
                this.f13384aa = bqt.m18993b(this, R.drawable.ic_action_delete, this.f13363F);
                int a4 = bqw.m19007a(24.0f);
                this.f13382Y.setBounds(0, 0, a4, a4);
                this.f13383Z.setBounds(0, 0, a4, a4);
                this.f13384aa.setBounds(0, 0, a4, a4);
                this.f13385ab = this.f13383Z;
                C3496b bVar = new C3496b();
                this.f13419u.setCompoundDrawablePadding(bqw.m19007a(3.0f));
                this.f13419u.setCompoundDrawables(null, null, this.f13383Z, null);
                this.f13419u.setOnKeyListener(bVar);
                this.f13419u.setOnFocusChangeListener(bVar);
                this.f13419u.setOnEditorActionListener(bVar);
                this.f13419u.setOnTouchListener(bVar);
                this.f13419u.setOnPreFocusListener(bVar);
                this.f13419u.addTextChangedListener(new TextWatcher() {
                    /* class video.downloader.videodownloader.activity.BrowserActivity.AnonymousClass37 */

                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void afterTextChanged(Editable editable) {
                        String b = bqw.m19021b(BrowserActivity.this);
                        if (!TextUtils.isEmpty(b)) {
                            BrowserActivity.this.mo21306a(BrowserActivity.this.f13419u.getText().toString().length() == 0 && BrowserActivity.this.f13419u.isFocused() && bqw.m19025d(b), b);
                        }
                    }
                });
                m14859a((AutoCompleteTextView) this.f13419u);
                this.mDrawerLayout.setDrawerShadow(R.mipmap.drawer_right_shadow, GravityCompat.END);
                this.mDrawerLayout.setDrawerShadow(R.mipmap.drawer_left_shadow, GravityCompat.START);
                if (f13355af <= 18) {
                    WebIconDatabase.getInstance().open(getDir("icons", 0).getPath());
                }
                intent = bundle != null ? getIntent() : null;
                if (intent != null ) {
                    z3 = false;
                }
                if (m14866a(intent)) {
                    setIntent(null);
                    mo21318e();
                } else {
                    if (z3) {
                        intent = null;
                    }
                    this.f13386ac.mo23011a(intent);
                    setIntent(null);
                    this.f13404d.mo23575a(this);
                }
            }
        }
   /*     z2 = true;
        this.F = z2;
        this.M = !this.F ? bqt.f(this) : bqt.e(this);
        if (!this.F) {
        }
        this.N = i2;
        this.I = this.e.a(!D());
        this.J = this.e.b();
        this.X.setColor(bqt.a(this));
        this.mDrawerLeft.setLayerType(0, null);
        this.mDrawerRight.setLayerType(0, null);
        this.mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {

            public void onDrawerSlide(View view, float f) {
            }

            public void onDrawerOpened(View view) {
                BrowserActivity.this.j.setVisibility(8);
            }

            public void onDrawerClosed(View view) {
                BrowserActivity.this.j.setVisibility(0);
            }

            public void onDrawerStateChanged(int i) {
                if (i == 1) {
                    BrowserActivity.this.mDrawerLeft.setLayerType(2, null);
                    BrowserActivity.this.mDrawerRight.setLayerType(2, null);
                } else if (i == 0) {
                    BrowserActivity.this.mDrawerLeft.setLayerType(0, null);
                    BrowserActivity.this.mDrawerRight.setLayerType(0, null);
                }
            }
        });*/
       /* int i32 = -16777216;
        getWindow().setStatusBarColor(-16777216);
        I();
        this.mDrawerLayout.addDrawerListener(new a());
        this.W = bqt.a(this, R.drawable.fk, this.F);
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        tabsFragment = (TabsFragment) supportFragmentManager2.findFragmentByTag("TAG_TABS_FRAGMENT");
        bookmarksFragment = (BookmarksFragment) supportFragmentManager2.findFragmentByTag("TAG_BOOKMARK_FRAGMENT");
        if (tabsFragment != null) {
        }
        TabsFragment a22 = TabsFragment.a(a(), this.I);
        this.ad = a22;
        if (bookmarksFragment != null) {
        }
        BookmarksFragment a32 = BookmarksFragment.a(a());
        this.ae = a32;
        supportFragmentManager2.executePendingTransactions();
        supportFragmentManager2.beginTransaction().replace(H(), a22, "TAG_TABS_FRAGMENT").replace(G(), a32, "TAG_BOOKMARK_FRAGMENT").commit();
        if (this.I) {
        }
        bql.a(supportActionBar);
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setDisplayShowHomeEnabled(false);
        supportActionBar.setDisplayShowCustomEnabled(true);
        supportActionBar.setCustomView(R.layout.eu);
        View customView2 = supportActionBar.getCustomView();
        ViewGroup.LayoutParams layoutParams2 = customView2.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        customView2.setLayoutParams(layoutParams2);
        this.v = (ImageView) customView2.findViewById(R.id.c2);
        if (!this.I) {
        }
        video.downloader.videodownloader.view.b.a.post(new Runnable() {

            public void run() {
                BrowserActivity.this.mDrawerLayout.setDrawerLockMode(0, BrowserActivity.this.N());
            }
        });
        this.v.setOnClickListener(this);
        customView2.findViewById(R.id.dk).setOnClickListener(this);
        this.u = (SearchView) customView2.findViewById(R.id.nq);
        this.t = customView2.findViewById(R.id.nv);
        this.u.setHintTextColor(bqt.a(this.F));
        SearchView searchView2 = this.u;
        if (this.F) {
        }
        searchView2.setTextColor(i32);
        this.Q = getString(R.string.np);
        this.L = -1;
        this.Y = bqt.b(this, R.drawable.c9, this.F);
        this.Z = bqt.b(this, R.drawable.ev, this.F);
        this.aa = bqt.b(this, R.drawable.c9, this.F);
        int a42 = bqw.a(24.0f);
        this.Y.setBounds(0, 0, a42, a42);
        this.Z.setBounds(0, 0, a42, a42);
        this.aa.setBounds(0, 0, a42, a42);
        this.ab = this.Z;
        b bVar2 = new b();
        this.u.setCompoundDrawablePadding(bqw.a(3.0f));
        this.u.setCompoundDrawables(null, null, this.Z, null);
        this.u.setOnKeyListener(bVar2);
        this.u.setOnFocusChangeListener(bVar2);
        this.u.setOnEditorActionListener(bVar2);
        this.u.setOnTouchListener(bVar2);
        this.u.setOnPreFocusListener(bVar2);
        this.u.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                String b = bqw.b(BrowserActivity.this);
                if (!TextUtils.isEmpty(b)) {
                    BrowserActivity.this.a(BrowserActivity.this.u.getText().toString().length() == 0 && BrowserActivity.this.u.isFocused() && bqw.d(b), b);
                }
            }
        });
        a((AutoCompleteTextView) this.u);
        this.mDrawerLayout.setDrawerShadow(R.drawable.i5, GravityCompat.END);
        this.mDrawerLayout.setDrawerShadow(R.drawable.i4, GravityCompat.START);
        if (af <= 18) {
        }
        if (bundle != null) {
        }
        if (intent != null) {
        }
        z3 = false;
        if (!a(intent)) {
        }
    */}

    /* renamed from: a */
    public void mo21306a(boolean z, final String str) {
        if (z) {
            mo21316d();
            View inflate = LayoutInflater.from(this).inflate(R.layout.popupwindow_paste, (ViewGroup) null);
            this.f13424z = new PopupWindow(this);
            this.f13424z.setContentView(inflate);
            this.f13424z.setWidth(-1);
            this.f13424z.setHeight(-2);
            this.f13424z.setBackgroundDrawable((Drawable) null);
            this.f13424z.showAsDropDown(this.f13419u);
            ((TextView) inflate.findViewById(R.id.tv_url)).setText(str);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BrowserActivity.this.mo21316d();
                    BrowserActivity.this.m14860a(str);
                    WebViewBrowser k = BrowserActivity.this.f13379V.mo21469k();
                    if (k != null) {
                        k.mo21656q();
                    }
                }
            });
            return;
        }
        mo21316d();
    }

    /* renamed from: d */
    public void mo21316d() {
        try {
            if (this.f13424z != null) {
                this.f13424z.dismiss();
            }
            this.f13424z = null;
        } catch (Exception e) {
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
        }
    }

    /* renamed from: G */
    private int m14832G() {
        return this.f13367J ? R.id.left_drawer : R.id.right_drawer;
    }

    /* renamed from: H */
    private int m14833H() {
        if (this.f13366I) {
            return this.f13367J ? R.id.right_drawer : R.id.left_drawer;
        }
        return R.id.tabs_toolbar_container;
    }

    /* renamed from: a */
    static boolean m14866a(Intent intent) {
        return intent != null && "info.guardianproject.panic.action.TRIGGER".equals(intent.getAction());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo21318e() {
        Log.d("BrowserActivity", "Closing browser");
        this.f13379V.mo21450a((Activity) this, "", false);
        this.f13379V.mo21461d(0);
        this.f13379V.mo21467i();
        bmb.m17912a(getApplication()).mo23839a();
        mo21347p();
        System.exit(1);
    }

    /* renamed from: video.downloader.video.downloader.videodownloader.activity.BrowserActivity$b */
    private class C3496b implements View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, TextView.OnEditorActionListener, SearchView.C3602a {
        private C3496b() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66) {
                return false;
            }
            ((InputMethodManager) BrowserActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(BrowserActivity.this.f13419u.getWindowToken(), 0);
            BrowserActivity.this.m14860a(BrowserActivity.this.f13419u.getText().toString());
            WebViewBrowser k = BrowserActivity.this.f13379V.mo21469k();
            if (k == null) {
                return true;
            }
            k.mo21656q();
            return true;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (!(i == 2 || i == 6 || i == 5 || i == 4 || i == 3)) {
                if (keyEvent != null) {
                    try {
                        if (keyEvent.getAction() == 66) {
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        bbc.m15886a().mo21879a((Context) BrowserActivity.this, (Throwable) e);
                        return false;
                    }
                }
                return false;
            }
            ((InputMethodManager) BrowserActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(BrowserActivity.this.f13419u.getWindowToken(), 0);
            BrowserActivity.this.m14860a(BrowserActivity.this.f13419u.getText().toString());
            WebViewBrowser k = BrowserActivity.this.f13379V.mo21469k();
            if (k == null) {
                return true;
            }
            k.mo21656q();
            return true;
        }

        public void onFocusChange(View view, boolean z) {
            WebViewBrowser k = BrowserActivity.this.f13379V.mo21469k();
            if (!z && k != null) {
                BrowserActivity.this.m14880c(k.mo21652m() < 100);
                BrowserActivity.this.mo21303a(k.mo21633E(), true);
            } else if (z && k != null) {
                SearchView searchView = (SearchView) view;
                if (searchView.getText().length() > 0) {
                    searchView.selectAll();
                } else {
                    String b = bqw.m19021b((Context) BrowserActivity.this);
                    if (!TextUtils.isEmpty(b) && bqw.m19025d(b)) {
                        BrowserActivity.this.mo21306a(true, b);
                    }
                }
                Drawable unused = BrowserActivity.this.f13385ab = BrowserActivity.this.f13384aa;
                BrowserActivity.this.f13419u.setCompoundDrawables((Drawable) null, (Drawable) null, BrowserActivity.this.f13384aa, (Drawable) null);
            }
            if (!z) {
                ((InputMethodManager) BrowserActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(BrowserActivity.this.f13419u.getWindowToken(), 0);
                BrowserActivity.this.mo21306a(false, (String) null);
            }
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (BrowserActivity.this.f13419u.getCompoundDrawables()[2] != null) {
                if (motionEvent.getX() > ((float) ((BrowserActivity.this.f13419u.getWidth() - BrowserActivity.this.f13419u.getPaddingRight()) - BrowserActivity.this.f13385ab.getIntrinsicWidth()))) {
                    if (motionEvent.getAction() == 1) {
                        if (BrowserActivity.this.f13419u.hasFocus()) {
                            BrowserActivity.this.f13419u.setText("");
                        } else {
                            BrowserActivity.this.m14842Q();
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        public void mo21395a() {
            WebViewBrowser k = BrowserActivity.this.f13379V.mo21469k();
            if (k != null) {
                String E = k.mo21633E();
                if (!bqv.m19001a(E) && !BrowserActivity.this.f13419u.hasFocus()) {
                    BrowserActivity.this.f13419u.setText(E);
                }
            }
        }
    }

    /* renamed from: video.downloader.video.downloader.videodownloader.activity.BrowserActivity$a */
    private class C3495a implements DrawerLayout.DrawerListener {
        public void onDrawerSlide(View view, float f) {
        }

        public void onDrawerStateChanged(int i) {
        }

        private C3495a() {
        }

        public void onDrawerClosed(View view) {
            View c = BrowserActivity.this.m14840O();
            View h = BrowserActivity.this.m14839N();
            if (view == c) {
                BrowserActivity.this.mDrawerLayout.setDrawerLockMode(0, h);
            } else if (BrowserActivity.this.f13366I) {
                BrowserActivity.this.mDrawerLayout.setDrawerLockMode(0, c);
            }
        }

        public void onDrawerOpened(View view) {
            View c = BrowserActivity.this.m14840O();
            View h = BrowserActivity.this.m14839N();
            if (view == c) {
                BrowserActivity.this.mDrawerLayout.setDrawerLockMode(1, h);
            } else {
                BrowserActivity.this.mDrawerLayout.setDrawerLockMode(1, c);
            }
        }
    }

    /* renamed from: I */
    private void m14834I() {
        int i;
        int a = getResources().getDisplayMetrics().widthPixels - bqw.m19007a(56.0f);
        if (mo21438D()) {
            i = bqw.m19007a(320.0f);
        } else {
            i = bqw.m19007a(300.0f);
        }
        if (a > i) {
            DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) this.mDrawerLeft.getLayoutParams();
            layoutParams.width = i;
            this.mDrawerLeft.setLayoutParams(layoutParams);
            this.mDrawerLeft.requestLayout();
            DrawerLayout.LayoutParams layoutParams2 = (DrawerLayout.LayoutParams) this.mDrawerRight.getLayoutParams();
            layoutParams2.width = i;
            this.mDrawerRight.setLayoutParams(layoutParams2);
            this.mDrawerRight.requestLayout();
            return;
        }
        DrawerLayout.LayoutParams layoutParams3 = (DrawerLayout.LayoutParams) this.mDrawerLeft.getLayoutParams();
        layoutParams3.width = a;
        this.mDrawerLeft.setLayoutParams(layoutParams3);
        this.mDrawerLeft.requestLayout();
        DrawerLayout.LayoutParams layoutParams4 = (DrawerLayout.LayoutParams) this.mDrawerRight.getLayoutParams();
        layoutParams4.width = a;
        this.mDrawerRight.setLayoutParams(layoutParams4);
        this.mDrawerRight.requestLayout();
    }

    /* renamed from: J */
    private void m14835J() {
        WebViewBrowser k = this.f13379V.mo21469k();
        this.f13362E = this.f13548e.mo23477p();
        boolean l = this.f13548e.mo23473l() & (!this.f13363F);
        if (!mo21307a() && !l && !this.f13363F && this.f13380W != null) {
            mo21294a(this.f13380W, (Drawable) null);
        } else if (!mo21307a() && k != null && !this.f13363F) {
            mo21294a(k.mo21631C(), (Drawable) null);
        } else if (!mo21307a() && !this.f13363F && this.f13380W != null) {
            mo21294a(this.f13380W, (Drawable) null);
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag("TAG_TABS_FRAGMENT");
        if (findFragmentByTag instanceof TabsFragment) {
            ((TabsFragment) findFragmentByTag).mo21594c();
        }
        Fragment findFragmentByTag2 = supportFragmentManager.findFragmentByTag("TAG_BOOKMARK_FRAGMENT");
        if (findFragmentByTag2 instanceof BookmarksFragment) {
            ((BookmarksFragment) findFragmentByTag2).mo21569b();
        }
        m14865a(this.f13548e.mo23478q(), false);
        switch (this.f13548e.mo23433F()) {
            case 0:
                f13354a = this.f13548e.mo23434G();
                if (!f13354a.startsWith("http://") && !f13354a.startsWith("https://")) {
                    f13354a = "https://www.google.com/search?client=lightning&ie=UTF-8&oe=UTF-8&q=";
                    break;
                }
            case 1:
                f13354a = "https://www.google.com/search?client=lightning&ie=UTF-8&oe=UTF-8&q=";
                break;
            case 2:
                f13354a = "http://www.ask.com/web?qsrc=0&o=0&l=dir&qo=LightningBrowser&q=";
                break;
            case 3:
                f13354a = "https://www.bing.com/search?q=";
                break;
            case 4:
                f13354a = "https://search.yahoo.com/search?p=";
                break;
            case 5:
                f13354a = "https://startpage.com/do/search?language=english&query=";
                break;
            case 6:
                f13354a = "https://startpage.com/do/m/mobilesearch?language=english&query=";
                break;
            case 7:
                f13354a = "https://duckduckgo.com/?t=lightning&q=";
                break;
            case 8:
                f13354a = "https://duckduckgo.com/lite/?t=lightning&q=";
                break;
            case 9:
                f13354a = "https://www.baidu.com/s?wd=";
                break;
            case 10:
                f13354a = "https://yandex.ru/yandsearch?lr=21411&text=";
                break;
        }
        mo21314c().mo21839a(C4740s.m21405c()).mo23839a();
        this.f13404d.mo23577c(this);
    }

    /* renamed from: f */
    public void mo21320f() {
        super.mo21320f();
        this.mToolbarLayout.setTranslationY(0.0f);
        m14852a((float) this.mToolbarLayout.getHeight());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 66) {
            if (this.f13419u.hasFocus()) {
                m14860a(this.f13419u.getText().toString());
            }
        } else if (i == 82 && Build.VERSION.SDK_INT <= 16 && Build.MANUFACTURER.compareTo("LGE") == 0) {
            return true;
        } else {
            if (i == 4) {
                this.f13373P = System.currentTimeMillis();
                EventBus.getDefault().post(new bns());
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82 && Build.VERSION.SDK_INT <= 16 && Build.MANUFACTURER.compareTo("LGE") == 0) {
            openOptionsMenu();
            return true;
        } else if (i != 4 || System.currentTimeMillis() - this.f13373P <= ((long) ViewConfiguration.getLongPressTimeout())) {
            return super.onKeyUp(i, keyEvent);
        } else {
            return true;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i;
        if (keyEvent.isCtrlPressed() && keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 48) {
                m14874b((String) null, true);
                return true;
            } else if (keyCode == 51) {
                this.f13386ac.mo23010a(this.f13379V.mo21468j());
                return true;
            } else if (keyCode != 61) {
                switch (keyCode) {
                    case 45:
                        mo21347p();
                        return true;
                    case 46:
                        WebViewBrowser k = this.f13379V.mo21469k();
                        if (k != null) {
                            k.mo21657r();
                        }
                        return true;
                }
            } else {
                if (keyEvent.isShiftPressed()) {
                    i = this.f13379V.mo21468j() > 0 ? this.f13379V.mo21468j() - 1 : this.f13379V.mo21464f();
                } else {
                    i = this.f13379V.mo21468j() < this.f13379V.mo21464f() ? this.f13379V.mo21468j() + 1 : 0;
                }
                this.f13386ac.mo23016b(i);
                return true;
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 84) {
            this.f13419u.requestFocus();
            this.f13419u.selectAll();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        WebViewBrowser k = this.f13379V.mo21469k();
        String str = null;
        String E = k != null ? k.mo21633E() : null;
        switch (menuItem.getItemId()) {
            case 16908332:
                if (this.mDrawerLayout.isDrawerOpen(m14839N())) {
                    this.mDrawerLayout.closeDrawer(m14839N());
                }
                return true;
            case R.id.action_add_bookmark /*2131296265*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click add bookmark");
                if (E != null && !bqv.m19001a(E)) {
                    m14878c(k.mo21632D(), E);
                }
                return true;
            case R.id.action_back /*2131296266*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click back");
                if (k != null && k.mo21665z()) {
                    k.mo21659t();
                }
                return true;
            case R.id.action_bookmarks /*2131296274*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click bookmark");
                m14841P();
                return true;
            case R.id.action_copy /*2131296277*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click copy link");
                if (E != null && !bqv.m19001a(E)) {
                    ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", E));
                    bqw.m19012a((Activity) this, (int) R.string.message_link_copied);
                }
                return true;
            case R.id.action_forward /*2131296280*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click forward");
                if (k != null && k.mo21629A()) {
                    k.mo21660u();
                }
                return true;
            case R.id.action_history /*2131296281*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click history");
                m14838M();
                return true;
            case R.id.action_new_tab /*2131296291*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click new tab");
                m14874b((String) null, true);
                return true;
            case R.id.action_reading_mode /*2131296293*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click read mode");
                if (E != null) {
                    Intent intent = new Intent(this, ReadingActivity.class);
                    intent.putExtra("ReadingUrl", E);
                    startActivity(intent);
                }
                return true;
            case R.id.action_settings /*2131296294*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click setting");
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_share /*2131296295*/:
                BrowserLogEvent.downloaderLogEvent(this, "main page", "menu:click share");
                bqj bqj = new bqj(this);
                if (k != null) {
                    str = k.mo21632D();
                }
                bqj.mo23567a(E, str);
                return true;
            case R.id.agent_desktop /*2131296324*/:
                int N = this.f13548e.mo23441N();
                int i = (N == 1 || N == 3) ? 2 : 1;
                this.f13548e.mo23460d(i);
                menuItem.setChecked(i == 2);
                WebViewBrowser k2 = this.f13379V.mo21469k();
                if (k2 != null) {
                    k2.mo21640b((Context) this);
                    k2.mo21657r();
                }
                BrowserLogEvent.downloaderLogEvent(this, "main page", "select agent");
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public boolean onMenuOpened(int i, Menu menu) {
        MenuItem findItem;
        if (!(menu == null || (findItem = menu.findItem(R.id.action_share)) == null)) {
            WebViewBrowser k = this.f13379V.mo21469k();
            String E = k != null ? k.mo21633E() : null;
            if (E == null || bqv.m19001a(E)) {
                findItem.setEnabled(false);
            } else {
                findItem.setEnabled(true);
            }
        }
        return super.onMenuOpened(i, menu);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14878c(String str, final String str2) {
        this.f13402b.mo23062a(new bmg(str2, str)).mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<Boolean>() {
            /* renamed from: a */
            public void mo21366a(Boolean bool) {
                if (Boolean.TRUE.equals(bool)) {
                    BrowserActivity.this.f13358A.mo23537c();
                    BrowserActivity.this.f13388ae.mo21568a(str2);
                    Toast.makeText(BrowserActivity.this, BrowserActivity.this.getString(R.string.added_success), 0).show();
                    return;
                }
                Toast.makeText(BrowserActivity.this, BrowserActivity.this.getString(R.string.exist_bookmark), 0).show();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m14882d(String str, final String str2) {
        this.f13402b.mo23065b(new bmg(str2, str)).mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<Boolean>() {
            /* renamed from: a */
            public void mo21366a(Boolean bool) {
                if (Boolean.TRUE.equals(bool)) {
                    BrowserActivity.this.f13358A.mo23537c();
                    BrowserActivity.this.f13388ae.mo21568a(str2);
                }
            }
        });
    }

    /* renamed from: K */
    private void m14836K() {
        if (this.mToolbarLayout.getParent() != this.mUiLayout) {
            if (this.mToolbarLayout.getParent() != null) {
                ((ViewGroup) this.mToolbarLayout.getParent()).removeView(this.mToolbarLayout);
            }
            this.mUiLayout.addView(this.mToolbarLayout, 0);
            this.mUiLayout.requestLayout();
        }
        m14852a(0.0f);
    }

    /* renamed from: L */
    private void m14837L() {
        if (this.mToolbarLayout.getParent() != this.mBrowserFrame) {
            if (this.mToolbarLayout.getParent() != null) {
                ((ViewGroup) this.mToolbarLayout.getParent()).removeView(this.mToolbarLayout);
            }
            this.mBrowserFrame.addView(this.mToolbarLayout);
            this.mBrowserFrame.requestLayout();
        }
        m14852a((float) this.mToolbarLayout.getHeight());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14852a(float f) {
        if (this.f13362E && this.f13421w != null) {
            this.f13421w.setTranslationY(f);
        } else if (this.f13421w != null) {
            this.f13421w.setTranslationY(0.0f);
        }
    }

    /* renamed from: g */
    public TabsManager mo21322g() {
        return this.f13379V;
    }

    /* renamed from: a */
    public void mo21291a(final int i) {
        if (i >= 0) {
            bmr.m18086a((Activity) this, (int) R.string.dialog_title_close_browser, new bmr.C3878b(R.string.close_tab) {
                /* renamed from: a */
                public void mo21391a() {
                    BrowserActivity.this.f13386ac.mo23010a(i);
                }
            }, new bmr.C3878b(R.string.close_other_tabs) {
                /* renamed from: a */
                public void mo21391a() {
                    BrowserActivity.this.f13386ac.mo23009a();
                }
            });
        }
    }

    /* renamed from: b */
    public void mo21309b(int i) {
        Log.d("BrowserActivity", "Notify Tab Removed: " + i);
        this.f13387ad.mo21591a(i);
    }

    /* renamed from: h */
    public void mo21324h() {
        Log.d("BrowserActivity", "Notify Tab Added");
        this.f13387ad.mo21590a();
    }

    /* renamed from: c */
    public void mo21315c(int i) {
        Log.d("BrowserActivity", "Notify Tab Changed: " + i);
        this.f13387ad.mo21593b(i);
    }

    /* renamed from: i */
    public void mo21325i() {
        Log.d("BrowserActivity", "Notify Tabs Initialized");
        this.f13387ad.mo21592b();
    }

    /* renamed from: a */
    public void mo21304a(WebViewBrowser eVar) {
        this.f13386ac.mo23013a(eVar);
    }

    /* renamed from: j */
    public void mo21326j() {
        Log.d("BrowserActivity", "Remove the tab view");
        this.mBrowserFrame.setBackgroundColor(this.f13369L);
        m14856a(this.f13421w);
        this.f13421w = null;
        Main_Looper.f13821a.postDelayed(new Runnable() {
            public void run() {
                BrowserActivity.this.mDrawerLayout.closeDrawers();
            }
        }, 200);
    }

    public void setTabView(View view) {
        if (this.f13421w != view) {
            Log.d("BrowserActivity", "Setting the tab view");
            this.mBrowserFrame.setBackgroundColor(this.f13369L);
            m14856a(view);
            m14856a(this.f13421w);
            this.mBrowserFrame.addView(view, 0, f13356ag);
            if (this.f13362E) {
                view.setTranslationY(((float) this.mToolbarLayout.getHeight()) + this.mToolbarLayout.getTranslationY());
            } else {
                view.setTranslationY(0.0f);
            }
            view.requestFocus();
            this.f13421w = view;
            mo21288A();
            Main_Looper.f13821a.postDelayed(new Runnable() {
                public void run() {
                    BrowserActivity.this.mDrawerLayout.closeDrawers();
                }
            }, 200);
        }
    }

    /* renamed from: a */
    public void mo21293a(DialogInterface.OnClickListener onClickListener) {
        bmr.m18088a(this, new AlertDialog.Builder(this).setCancelable(true).setTitle((int) R.string.title_warning).setMessage((int) R.string.message_blocked_local).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton((int) R.string.action_open, onClickListener).show());
    }

    /* renamed from: d */
    public void mo21317d(int i) {
        this.f13386ac.mo23010a(i);
    }

    /* renamed from: e */
    public void mo21319e(int i) {
        m14887h(i);
    }

    /* renamed from: k */
    public void mo21327k() {
        this.f13386ac.mo23014a((String) null, true);
    }

    /* renamed from: l */
    public void mo21328l() {
        String D = this.f13548e.mo23431D();
        if (D != null) {
            m14874b(D, true);
            bqw.m19012a((Activity) this, (int) R.string.deleted_tab);
        }
        this.f13548e.mo23453b((String) null);
    }

    /* renamed from: m */
    public void mo21329m() {
        WebViewBrowser k = this.f13379V.mo21469k();
        String str = null;
        final String E = k != null ? k.mo21633E() : null;
        if (k != null) {
            str = k.mo21632D();
        }
        if (E != null && !bqv.m19001a(E)) {
            String finalStr = str;
            this.f13402b.mo23066b(E).mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<Boolean>() {
                /* renamed from: a */
                public void mo21366a(Boolean bool) {
                    if (Boolean.TRUE.equals(bool)) {
                        BrowserActivity.this.m14882d(finalStr, E);
                    } else {
                        BrowserActivity.this.m14878c(finalStr, E);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo21299a(bmg bmg) {
        this.f13386ac.mo23012a(bmg.mo23052e());
        Main_Looper.f13821a.postDelayed(new Runnable() {
            public void run() {
                BrowserActivity.this.mo21301a((Runnable) null);
            }
        }, 150);
    }

    /* renamed from: n */
    public void mo21330n() {
        m14838M();
    }

    /* renamed from: h */
    private synchronized void m14887h(int i) {
        this.f13386ac.mo23016b(i);
    }

    /* renamed from: a */
    private static void m14856a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo21310b(Intent intent) {
        this.f13386ac.mo23017b(intent);
        m14845T();
    }

    public void onTrimMemory(int i) {
        if (i > 60 && Build.VERSION.SDK_INT < 19) {
            Log.d("BrowserActivity", "Low Memory, Free Memory");
            this.f13386ac.mo23019d();
        }
    }

    /* renamed from: b */
    private synchronized boolean m14874b(String str, boolean z) {
        return this.f13386ac.mo23014a(str, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo21331o() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (this.f13548e.mo23469h() && k != null && !mo21307a()) {
            bqx.m19028a(k.mo21630B());
            Log.d("BrowserActivity", "Cache Cleared");
        }
        if (this.f13548e.mo23472k() && !mo21307a()) {
            bqx.m19029b(this);
            Log.d("BrowserActivity", "History Cleared");
        }
        if (this.f13548e.mo23470i() && !mo21307a()) {
            bqx.m19027a((Context) this);
            Log.d("BrowserActivity", "Cookies Cleared");
        }
        if (this.f13548e.mo23471j() && !mo21307a()) {
            bqx.m19026a();
            Log.d("BrowserActivity", "WebStorage Cleared");
        } else if (mo21307a()) {
            bqx.m19026a();
        }
        this.f13358A.mo23536b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d("BrowserActivity", "onConfigurationChanged");
        if (this.f13362E) {
            mo21288A();
            this.mToolbarLayout.setTranslationY(0.0f);
            m14852a((float) this.mToolbarLayout.getHeight());
        }
        supportInvalidateOptionsMenu();
        m14853a(configuration);
    }

    /* renamed from: a */
    private void m14853a(final Configuration configuration) {
        m14869b((View) this.mUiLayout, (Runnable) new Runnable() {
            public void run() {
                int i;
                if (configuration.orientation == 1) {
                    i = bqw.m19007a(56.0f);
                } else {
                    i = bqw.m19007a(52.0f);
                }
                BrowserActivity.this.mToolbar.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
                BrowserActivity.this.mToolbar.setMinimumHeight(i);
                BrowserActivity.m14869b((View) BrowserActivity.this.mToolbar, (Runnable) new Runnable() {
                    public void run() {
                        BrowserActivity.this.m14852a((float) BrowserActivity.this.mToolbarLayout.getHeight());
                    }
                });
                BrowserActivity.this.mToolbar.requestLayout();
            }
        });
    }

    /* renamed from: p */
    public void mo21347p() {
        this.mBrowserFrame.setBackgroundColor(this.f13369L);
        m14856a(this.f13421w);
        mo21331o();
        int e = this.f13379V.mo21463e();
        this.f13379V.mo21462d();
        this.f13421w = null;
        for (int i = 0; i < e; i++) {
            this.f13387ad.mo21591a(0);
        }
        mo21348q();
        finish();
    }

    /* renamed from: q */
    public void mo21348q() {
        try {
            ManualParseService.m14410e();
            boi.m18319b().mo23265a();
            bpe.m18520a().mo23317b();
            bok.m18339a((Context) this);
            Logger.e("finished me", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
        }
    }

    public synchronized void onBackPressed() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (this.mDrawerLayout.isDrawerOpen(m14840O())) {
            this.mDrawerLayout.closeDrawer(m14840O());
        } else if (this.mDrawerLayout.isDrawerOpen(m14839N())) {
            this.f13388ae.mo21566a();
        } else if (k != null) {
            Log.d("BrowserActivity", "onBackPressed");
            if (this.f13419u.hasFocus()) {
                k.mo21656q();
            } else if (!k.mo21665z()) {
                if (this.f13423y == null) {
                    if (this.f13359B == null) {
                        this.f13386ac.mo23010a(this.f13379V.mo21447a(k));
                    }
                }
                mo21354v();
            } else if (!k.mo21647h()) {
                mo21354v();
            } else {
                k.mo21659t();
            }
        } else {
            Log.e("BrowserActivity", "This shouldn't happen ever");
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (!this.f13378U) {
            Log.d("BrowserActivity", "onPause");
            this.f13379V.mo21457b();
            try {
                getApplication().unregisterReceiver(this.f13401au);
            } catch (IllegalArgumentException e) {
                Log.e("BrowserActivity", "Receiver was not registered", e);
            }
            if (mo21307a() && isFinishing()) {
                overridePendingTransition(R.anim.fade_in_scale, R.anim.slide_down_out);
            }
            try {
                if (this.f13394an != null && this.f13394an.isVisible()) {
                    this.f13394an.dismissAllowingStateLoss();
                    EventBus.getDefault().post(new bns());
                }
                if (this.f13395ao != null && this.f13395ao.isVisible()) {
                    this.f13395ao.dismissAllowingStateLoss();
                    EventBus.getDefault().post(new bns());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                bbc.m15886a().mo21879a((Context) this, (Throwable) e2);
            } catch (Error e3) {
                e3.printStackTrace();
                bbc.m15886a().mo21879a((Context) this, (Throwable) e3);
            }
            this.f13376S = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo21349r() {
        if (this.f13548e.mo23430C()) {
            this.f13379V.mo21466h();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (!this.f13378U) {
            this.f13404d.mo23574a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (!this.f13378U) {
            Log.d("BrowserActivity", "onDestroy");
            EventBus.getDefault().unregister(this);
            Main_Looper.f13821a.removeCallbacksAndMessages((Object) null);
            this.f13386ac.mo23015b();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (!this.f13378U) {
            this.f13404d.mo23578d(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f13379V.mo21462d();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f13378U) {
            Log.d("BrowserActivity", "onResume");
            if (this.f13412n != null) {
                this.f13412n.setCurrentItem(0);
            }
            if (this.f13367J != this.f13548e.mo23455b()) {
                mo21439E();
            }
            if (this.f13358A != null) {
                this.f13358A.mo23535a();
                this.f13358A.mo23537c();
            }
            this.f13379V.mo21452a((Context) this);
            m14835J();
            supportInvalidateOptionsMenu();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getApplication().registerReceiver(this.f13401au, intentFilter);
            if (this.f13362E) {
                m14837L();
            } else {
                m14836K();
            }
            m14846U();
            this.f13376S = false;
            this.f13377T = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14860a(String str) {
        BrowserLogEvent.downloaderLogEvent(this, "顶部输入框内容", str + "");
        WebViewBrowser k = this.f13379V.mo21469k();
        if (!str.isEmpty()) {
            String str2 = f13354a + "%s";
            String trim = str.trim();
            if (k != null) {
                k.mo21653n();
                this.f13386ac.mo23012a(bqv.m19000a(trim, true, str2));
            }
        }
    }

    /* renamed from: a */
    public void mo21294a(Bitmap bitmap, Drawable drawable) {
        int color = ContextCompat.getColor(this, R.color.primary_color);
        if (this.f13372O == -16777216) {
            this.f13372O = color;
        }
        if (Build.VERSION.SDK_INT == 22) {
            try {
                m14854a(bitmap, drawable, color);
            } catch (Exception e) {
                e.printStackTrace();
                bbc.m15886a().mo21879a((Context) this, (Throwable) e);
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                m14854a(bitmap, drawable, color);
            } catch (Exception e3) {
                e3.printStackTrace();
                bbc.m15886a().mo21879a((Context) this, (Throwable) e3);
            }
        }
    }

    /* renamed from: a */
    private void m14854a(Bitmap bitmap, final Drawable drawable, final int i) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                 int vibrantColor = palette.getVibrantColor(i) | -16777216;
                if (!BrowserActivity.this.f13366I || bqw.m19018a(vibrantColor)) {
                    vibrantColor = bqw.m19008a(i, vibrantColor, 0.25f);
                }
                final Window window = BrowserActivity.this.getWindow();
                if (!BrowserActivity.this.f13366I) {
                    window.setBackgroundDrawable(new ColorDrawable(-16777216));
                }
                int unused = BrowserActivity.this.m14848a(BrowserActivity.this.f13372O, i);
                int unused2 = BrowserActivity.this.m14848a(vibrantColor, i);
                int finalVibrantColor = vibrantColor;
                Animation r0 = new Animation() {
                    /* access modifiers changed from: protected */
                    public void applyTransformation(float f, Transformation transformation) {
                        int a = bqh.m18942a(f, BrowserActivity.this.f13372O, finalVibrantColor);
                        if (BrowserActivity.this.f13366I) {
                            BrowserActivity.this.f13381X.setColor(a);
                            Main_Looper.f13821a.post(new Runnable() {
                                public void run() {
                                    window.setBackgroundDrawable(BrowserActivity.this.f13381X);
                                }
                            });
                        } else if (drawable != null) {
                            drawable.setColorFilter(a, PorterDuff.Mode.SRC_IN);
                        }
                        int unused = BrowserActivity.this.f13372O = a;
                    }
                };
                r0.setDuration(300);
                BrowserActivity.this.mToolbarLayout.startAnimation(r0);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m14848a(int i, int i2) {
        if (i != i2) {
            return bqh.m18942a(0.25f, i, -1);
        }
        if (this.f13363F) {
            return bqh.m18942a(0.25f, i2, -1);
        }
        return -1;
    }

    /* renamed from: s */
    public boolean mo21350s() {
        return this.f13363F;
    }

    /* renamed from: t */
    public int mo21352t() {
        return this.f13372O;
    }

    /* renamed from: a */
    public void mo21303a(String str, boolean z) {
        if (str != null && this.f13419u != null && !this.f13419u.hasFocus()) {
            WebViewBrowser k = this.f13379V.mo21469k();
            this.f13388ae.mo21568a(str);
            if (z && !bqv.m19001a(str)) {
                switch (this.f13548e.mo23437J()) {
                    case 0:
                        str = bqw.m19011a(str.replaceFirst("http://", ""));
                        this.f13419u.setText(str);
                        break;
                    case 1:
                        this.f13419u.setText(str);
                        break;
                    case 2:
                        if (k != null && !k.mo21632D().isEmpty()) {
                            this.f13419u.setText(k.mo21632D());
                            break;
                        } else {
                            this.f13419u.setText(this.f13374Q);
                            break;
                        }
                }
            } else {
                if (bqv.m19001a(str)) {
                    str = "";
                    this.f13408j.setVisibility(8);
                }
                else if (ManualParseService.m14411e(this, str)) {
                this.f13408j.setVisibility(8);
                }
            else {
                    this.f13408j.setVisibility(0);
                }
                this.f13419u.setText(str);
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("twitter.com") || str.contains("drive.google.com")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13408j.getLayoutParams();
                    layoutParams.bottomMargin = axw.m7444a((Context) this, 60.0f);
                    this.f13408j.setLayoutParams(layoutParams);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f13408j.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                this.f13408j.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: f */
    public void mo21321f(int i) {
        if (this.f13420v != null && this.f13366I) {
            this.f13420v.setImageBitmap(bqh.m18943a(i, bqw.m19007a(24.0f), bqw.m19007a(24.0f), -1, bqw.m19007a(2.5f)));
        }
    }

    /* renamed from: g */
    public void mo21323g(int i) {
        m14880c(i < 100);
        this.mProgressBar.setProgress(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo21302a(String str, String str2) {
        if (!bqv.m19001a(str2)) {
            bmq.m18072a(str2, str).mo21839a(C4740s.m21407e()).mo23840a(new C4123d() {
                /* renamed from: a */
                public void mo21364a(Throwable th) {
                    Log.e("BrowserActivity", "Exception while updating history", th);
                }
            });
        }
    }

    /* renamed from: a */
    private void m14859a(final AutoCompleteTextView autoCompleteTextView) {
        this.f13358A = new bqb(this, this.f13363F, mo21307a());
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setDropDownWidth(-1);
        autoCompleteTextView.setDropDownAnchor(R.id.toolbar_layout);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                CharSequence text;
                CharSequence text2 = ((TextView) view.findViewById(R.id.url)).getText();
                String charSequence = text2 != null ? text2.toString() : null;
                if ((charSequence == null || charSequence.startsWith(BrowserActivity.this.getString(R.string.suggestion))) && (text = ((TextView) view.findViewById(R.id.title)).getText()) != null) {
                    charSequence = text.toString();
                }
                if (charSequence != null) {
                    autoCompleteTextView.setText(charSequence);
                    BrowserActivity.this.m14860a(charSequence);
                    ((InputMethodManager) BrowserActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(autoCompleteTextView.getWindowToken(), 0);
                    BrowserActivity.this.f13386ac.mo23018c();
                }
            }
        });
        autoCompleteTextView.setSelectAllOnFocus(true);
        autoCompleteTextView.setAdapter(this.f13358A);
    }

    /* renamed from: M */
    private void m14838M() {
        new bmb().mo23031a().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<String>() {
            /* renamed from: a */
            public void mo21366a(String str) {
                bql.m18952a(str);
                WebViewBrowser k = BrowserActivity.this.f13379V.mo21469k();
                if (k != null) {
                    k.mo21636a(str);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public View m14839N() {
        return this.f13367J ? this.mDrawerLeft : this.mDrawerRight;
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public View m14840O() {
        return this.f13367J ? this.mDrawerRight : this.mDrawerLeft;
    }

    /* renamed from: P */
    private void m14841P() {
        if (this.mDrawerLayout.isDrawerOpen(m14840O())) {
            this.mDrawerLayout.closeDrawers();
        }
        this.mDrawerLayout.openDrawer(m14839N());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo21301a(final Runnable runnable) {
        if (this.mDrawerLayout.isDrawerOpen((View) this.mDrawerLeft) || this.mDrawerLayout.isDrawerOpen((View) this.mDrawerRight) || runnable == null) {
            this.mDrawerLayout.closeDrawers();
            this.mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
                public void onDrawerOpened(View view) {
                }

                public void onDrawerSlide(View view, float f) {
                }

                public void onDrawerStateChanged(int i) {
                }

                public void onDrawerClosed(View view) {
                    if (runnable != null) {
                        runnable.run();
                    }
                    BrowserActivity.this.mDrawerLayout.removeDrawerListener(this);
                }
            });
            return;
        }
        runnable.run();
    }

    /* renamed from: a */
    public void mo21305a(boolean z) {
        int i;
        if (this.f13390aj != null && this.f13390aj.getIcon() != null) {
            if (z) {
                i = this.f13370M;
            } else {
                i = this.f13371N;
            }
            this.f13390aj.getIcon().setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.f13390aj.setIcon(this.f13390aj.getIcon());
        }
    }

    /* renamed from: b */
    public void mo21313b(boolean z) {
        int i;
        if (this.f13389ai != null && this.f13389ai.getIcon() != null) {
            if (z) {
                i = this.f13370M;
            } else {
                i = this.f13371N;
            }
            this.f13389ai.getIcon().setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.f13389ai.setIcon(this.f13389ai.getIcon());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.f13389ai = menu.findItem(R.id.action_back);
        this.f13390aj = menu.findItem(R.id.action_forward);
        if (!(this.f13389ai == null || this.f13389ai.getIcon() == null)) {
            this.f13389ai.getIcon().setColorFilter(this.f13370M, PorterDuff.Mode.SRC_IN);
        }
        if (!(this.f13390aj == null || this.f13390aj.getIcon() == null)) {
            this.f13390aj.getIcon().setColorFilter(this.f13370M, PorterDuff.Mode.SRC_IN);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (f13355af < 21 && i == 1) {
            if (this.f13360C != null) {
                this.f13360C.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                this.f13360C = null;
            } else {
                return;
            }
        }
        if (i != 1 || this.f13361D == null) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (i2 == -1) {
            if (intent != null) {
                String dataString = intent.getDataString();
                if (dataString != null) {
                    uriArr = new Uri[]{Uri.parse(dataString)};
                    this.f13361D.onReceiveValue(uriArr);
                    this.f13361D = null;
                }
            } else if (this.f13375R != null) {
                uriArr = new Uri[]{Uri.parse(this.f13375R)};
                this.f13361D.onReceiveValue(uriArr);
                this.f13361D = null;
            }
        }
        uriArr = null;
        this.f13361D.onReceiveValue(uriArr);
        this.f13361D = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo21298aa(ValueCallback<Uri[]> r6) {
        /*
            r5 = this;
            android.webkit.ValueCallback<android.net.Uri[]> r0 = r5.f13361D
            r1 = 0
            if (r0 == 0) goto L_0x000a
            android.webkit.ValueCallback<android.net.Uri[]> r0 = r5.f13361D
            r0.onReceiveValue(r1)
        L_0x000a:
            r5.f13361D = r6
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r0 = "android.media.action.IMAGE_CAPTURE"
            r6.<init>(r0)
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            android.content.ComponentName r0 = r6.resolveActivity(r0)
            if (r0 == 0) goto L_0x0058
            java.io.File r0 = p000.bqw.m19020b()     // Catch:{ IOException -> 0x002b }
            java.lang.String r2 = "PhotoPath"
            java.lang.String r3 = r5.f13375R     // Catch:{ IOException -> 0x0029 }
            r6.putExtra(r2, r3)     // Catch:{ IOException -> 0x0029 }
            goto L_0x0034
        L_0x0029:
            r2 = move-exception
            goto L_0x002d
        L_0x002b:
            r2 = move-exception
            r0 = r1
        L_0x002d:
            java.lang.String r3 = "BrowserActivity"
            java.lang.String r4 = "Unable to create Image File"
            android.util.Log.e(r3, r4, r2)
        L_0x0034:
            if (r0 == 0) goto L_0x0057
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "file:"
            r1.append(r2)
            java.lang.String r2 = r0.getAbsolutePath()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r5.f13375R = r1
            java.lang.String r1 = "output"
            android.net.Uri r0 = p000.bpd.m18500a((android.content.Context) r5, (java.io.File) r0)
            r6.putExtra(r1, r0)
            goto L_0x0058
        L_0x0057:
            r6 = r1
        L_0x0058:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.GET_CONTENT"
            r0.<init>(r1)
            java.lang.String r1 = "android.intent.category.OPENABLE"
            r0.addCategory(r1)
          //  java.lang.String r1 = "
         /*   r0.setType(r1)
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0072
            Intent[] r3 = new Intent[r2]
            r3[r1] = r6
            goto L_0x0074
        L_0x0072:
            Intent[] r3 = new Intent[r1]
        L_0x0074:
            Intent r6 = new Intent
            String r1 = "android.intent.action.CHOOSER"
            r6.<init>(r1)
            java.lang.String r1 = "android.intent.extra.INTENT"
            r6.putExtra(r1, r0)
            String r0 = "android.intent.extra.TITLE"
            String r1 = "Image Chooser"
            r6.putExtra(r0, r1)
            String r0 = "android.intent.extra.INITIAL_INTENTS"
            r6.putExtra(r0, r3)
            r5.startActivityForResult(r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.activity.BrowserActivity.mo21298a(android.webkit.ValueCallback):void");
    }
    public void mo21298a(ValueCallback<Uri[]> valueCallback) {
        File file;
        IOException e = null;
        if (this.f13361D != null) {
            this.f13361D.onReceiveValue(null);
        }
        this.f13361D = valueCallback;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
          //  try {
                file = bqw.m19020b();
               // try {
                    intent.putExtra("PhotoPath", this.f13375R);
                /*} catch (IOException e2) {
                    e = e2;
                }*/
          //  } catch (IOException e3) {
             //   e = e3;
                file = null;
                Log.e("BrowserActivity", "Unable to create Image File", e);
                if (file == null) {
                }
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                intent2.addCategory("android.intent.category.OPENABLE");
                intent2.setType("*/*");
                if (intent == null) {
                }
                Intent intent3 = new Intent("android.intent.action.CHOOSER");
                intent3.putExtra("android.intent.extra.INTENT", intent2);
                intent3.putExtra("android.intent.extra.TITLE", "Image Chooser");
                intent3.putExtra("android.intent.extra.INITIAL_INTENTS", intent);
                startActivityForResult(intent3, 1);
        //    }
            if (file == null) {
                this.f13375R = "file:" + file.getAbsolutePath();
                intent.putExtra("output", bpd.m18500a(this, file));
            } else {
                intent = null;
            }
        }
        Intent intent22 = new Intent("android.intent.action.GET_CONTENT");
        intent22.addCategory("android.intent.category.OPENABLE");
        intent22.setType("*/*");
        Parcelable[] parcelableArr = intent == null ? new Intent[]{intent} : new Intent[0];
        Intent intent32 = new Intent("android.intent.action.CHOOSER");
        intent32.putExtra("android.intent.extra.INTENT", intent22);
        intent32.putExtra("android.intent.extra.TITLE", "Image Chooser");
        intent32.putExtra("android.intent.extra.INITIAL_INTENTS", parcelableArr);
        startActivityForResult(intent32, 1);
    }

    /* renamed from: a */
    public synchronized void mo21296a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        int requestedOrientation = getRequestedOrientation();
        this.f13368K = requestedOrientation;
        mo21297a(view, customViewCallback, requestedOrientation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo21297aa(View r5, WebChromeClient.CustomViewCallback r6, int r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            video.downloader.video.downloader.videodownloader.activity.e r0 = r4.f13379V     // Catch:{ all -> 0x0081 }
            video.downloader.video.downloader.videodownloader.view.e r0 = r0.mo21469k()     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x0071
            android.view.View r1 = r4.f13423y     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0071
        L_0x000e:
            r1 = 1
            r5.setKeepScreenOn(r1)     // Catch:{ SecurityException -> 0x0013 }
            goto L_0x001a
        L_0x0013:
            java.lang.String r2 = "BrowserActivity"
            java.lang.String r3 = "WebView is not allowed to keep the screen on"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x0081 }
        L_0x001a:
            int r2 = r4.getRequestedOrientation()     // Catch:{ all -> 0x0081 }
            r4.f13368K = r2     // Catch:{ all -> 0x0081 }
            r4.f13359B = r6     // Catch:{ all -> 0x0081 }
            r4.f13423y = r5     // Catch:{ all -> 0x0081 }
            r4.setRequestedOrientation(r7)     // Catch:{ all -> 0x0081 }
            android.view.Window r6 = r4.getWindow()     // Catch:{ all -> 0x0081 }
            android.view.View r6 = r6.getDecorView()     // Catch:{ all -> 0x0081 }
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6     // Catch:{ all -> 0x0081 }
            android.widget.FrameLayout r7 = new android.widget.FrameLayout     // Catch:{ all -> 0x0081 }
            r7.<init>(r4)     // Catch:{ all -> 0x0081 }
            r4.f13422x = r7     // Catch:{ all -> 0x0081 }
            android.widget.FrameLayout r7 = r4.f13422x     // Catch:{ all -> 0x0081 }
            r2 = 17170444(0x106000c, float:2.4611947E-38)
            int r2 = android.support.p001v4.content.ContextCompat.getColor(r4, r2)     // Catch:{ all -> 0x0081 }
            r7.setBackgroundColor(r2)     // Catch:{ all -> 0x0081 }
            boolean r7 = r5 instanceof android.widget.FrameLayout     // Catch:{ all -> 0x0081 }
            if (r7 == 0) goto L_0x0051
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5     // Catch:{ all -> 0x0081 }
            android.view.View r5 = r5.getFocusedChild()     // Catch:{ all -> 0x0081 }
            boolean r5 = r5 instanceof android.widget.VideoView     // Catch:{ all -> 0x0081 }
            goto L_0x0053
        L_0x0051:
            boolean r5 = r5 instanceof android.widget.VideoView     // Catch:{ all -> 0x0081 }
        L_0x0053:
            android.widget.FrameLayout r5 = r4.f13422x     // Catch:{ all -> 0x0081 }
            android.widget.FrameLayout$LayoutParams r7 = f13357ah     // Catch:{ all -> 0x0081 }
            r6.addView(r5, r7)     // Catch:{ all -> 0x0081 }
            android.widget.FrameLayout r5 = r4.f13422x     // Catch:{ all -> 0x0081 }
            android.view.View r7 = r4.f13423y     // Catch:{ all -> 0x0081 }
            android.widget.FrameLayout$LayoutParams r2 = f13357ah     // Catch:{ all -> 0x0081 }
            r5.addView(r7, r2)     // Catch:{ all -> 0x0081 }
            r6.requestLayout()     // Catch:{ all -> 0x0081 }
            r4.m14865a((boolean) r1, (boolean) r1)     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x006f
            r5 = 4
            r0.mo21634a((int) r5)     // Catch:{ all -> 0x0081 }
        L_0x006f:
            monitor-exit(r4)
            return
        L_0x0071:
            if (r6 == 0) goto L_0x007f
            r6.onCustomViewHidden()     // Catch:{ Exception -> 0x0077 }
            goto L_0x007f
        L_0x0077:
            r5 = move-exception
            java.lang.String r6 = "BrowserActivity"
            java.lang.String r7 = "Error hiding custom view"
            android.util.Log.e(r6, r7, r5)     // Catch:{ all -> 0x0081 }
        L_0x007f:
            monitor-exit(r4)
            return
        L_0x0081:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.activity.BrowserActivity.mo21297a(android.view.View, android.webkit.WebChromeClient$CustomViewCallback, int):void");
    }
    public synchronized void mo21297a(View view, WebChromeClient.CustomViewCallback customViewCallback, int i2) {
        WebViewBrowser k2 = this.f13379V.mo21469k();
        if (view == null || this.f13423y != null) {
            if (customViewCallback != null) {
                try {
                    customViewCallback.onCustomViewHidden();
                } catch (Exception e) {
                    Log.e("BrowserActivity", "Error hiding custom view", e);
                }
            }
            return;
        }
        try {
            view.setKeepScreenOn(true);
        } catch (SecurityException unused) {
            Log.e("BrowserActivity", "WebView is not allowed to keep the screen on");
        }
        this.f13368K = getRequestedOrientation();
        this.f13359B = customViewCallback;
        this.f13423y = view;
        setRequestedOrientation(i2);
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        this.f13422x = new FrameLayout(this);
        this.f13422x.setBackgroundColor(ContextCompat.getColor(this, 17170444));
        if (view instanceof FrameLayout) {
            boolean z2 = ((FrameLayout) view).getFocusedChild() instanceof VideoView;
        } else {
            boolean z3 = view instanceof VideoView;
        }
        frameLayout.addView(this.f13422x, f13357ah);
        this.f13422x.addView(this.f13423y, f13357ah);
        frameLayout.requestLayout();
        m14865a(true, true);
        if (k2 != null) {
            k2.mo21634a(4);
        }
    }

    /* renamed from: u */
    public void mo21353u() {
        this.mDrawerLayout.closeDrawer(m14839N());
    }

    /* renamed from: v */
    public void mo21354v_() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (this.f13423y != null && this.f13359B != null && k != null) {
            Log.d("BrowserActivity", "onHideCustomView");
            k.mo21634a(0);
            try {
                this.f13423y.setKeepScreenOn(false);
            } catch (SecurityException unused) {
                Log.e("BrowserActivity", "WebView is not allowed to keep the screen on");
            }
            m14865a(this.f13548e.mo23478q(), false);
            if (this.f13422x != null) {
                ViewGroup viewGroup = (ViewGroup) this.f13422x.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f13422x);
                }
                this.f13422x.removeAllViews();
            }
            this.f13422x = null;
            this.f13423y = null;
            if (this.f13359B != null) {
                try {
                    this.f13359B.onCustomViewHidden();
                } catch (Exception e) {
                    Log.e("BrowserActivity", "Error hiding custom view", e);
                }
            }
            this.f13359B = null;
            setRequestedOrientation(this.f13368K);
        } else if (this.f13359B != null) {
            try {
                this.f13359B.onCustomViewHidden();
            } catch (Exception e2) {
                Log.e("BrowserActivity", "Error hiding custom view", e2);
            }
            this.f13359B = null;
        }
    }
    public void mo21354v() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (this.f13423y == null || this.f13359B == null || k == null) {
            WebChromeClient.CustomViewCallback customViewCallback = this.f13359B;
            if (customViewCallback != null) {
                try {
                    customViewCallback.onCustomViewHidden();
                } catch (Exception e) {
                    Log.e("BrowserActivity", "Error hiding custom view", e);
                }
                this.f13359B = null;
                return;
            }
            return;
        }
        Log.d("BrowserActivity", "onHideCustomView");
        k.mo21634a(0);
        try {
            this.f13423y.setKeepScreenOn(false);
        } catch (SecurityException unused) {
            Log.e("BrowserActivity", "WebView is not allowed to keep the screen on");
        }
        m14865a(this.f13548e.mo23478q(), false);
        FrameLayout frameLayout = this.f13422x;
        if (frameLayout != null) {
            ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f13422x);
            }
            this.f13422x.removeAllViews();
        }
        this.f13422x = null;
        this.f13423y = null;
        WebChromeClient.CustomViewCallback customViewCallback2 = this.f13359B;
        if (customViewCallback2 != null) {
            try {
                customViewCallback2.onCustomViewHidden();
            } catch (Exception e2) {
                Log.e("BrowserActivity", "Error hiding custom view", e2);
            }
        }
        this.f13359B = null;
        setRequestedOrientation(this.f13368K);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Log.d("BrowserActivity", "onWindowFocusChanged");
        if (z) {
            m14865a(this.f13364G, this.f13365H);
        }
    }

    /* renamed from: w */
    public void mo21355w() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (k == null) {
            return;
        }
        if (k.mo21665z()) {
            k.mo21659t();
            mo21301a((Runnable) null);
            return;
        }
        this.f13386ac.mo23010a(this.f13379V.mo21447a(k));
    }

    /* renamed from: x */
    public void mo21356x() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (k != null && k.mo21629A()) {
            k.mo21660u();
            mo21301a((Runnable) null);
        }
    }

    /* renamed from: y */
    public void mo21357y() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (k != null) {
            k.mo21639b();
            mo21301a((Runnable) null);
        }
    }

    /* renamed from: a */
    private void m14865a(boolean z, boolean z2) {
        this.f13364G = z;
        this.f13365H = z2;
        Window window = getWindow();
        View decorView = window.getDecorView();
        if (z) {
            if (z2) {
                decorView.setSystemUiVisibility(5894);
            } else {
                decorView.setSystemUiVisibility(0);
            }
            window.setFlags(1024, 1024);
            return;
        }
        window.clearFlags(1024);
        decorView.setSystemUiVisibility(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo21295aa(Message r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            java.lang.String r0 = ""
            r1 = 1
            boolean r0 = r3.m14874b((java.lang.String) r0, (boolean) r1)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            video.downloader.video.downloader.videodownloader.activity.e r0 = r3.f13379V     // Catch:{ all -> 0x002f }
            video.downloader.video.downloader.videodownloader.activity.e r2 = r3.f13379V     // Catch:{ all -> 0x002f }
            int r2 = r2.mo21463e()     // Catch:{ all -> 0x002f }
            int r2 = r2 - r1
            video.downloader.video.downloader.videodownloader.view.e r0 = r0.mo21449a((int) r2)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            android.webkit.WebView r0 = r0.mo21630B()     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            java.lang.Object r1 = r4.obj     // Catch:{ all -> 0x002f }
            android.webkit.WebView$WebViewTransport r1 = (android.webkit.WebView.WebViewTransport) r1     // Catch:{ all -> 0x002f }
            r1.setWebView(r0)     // Catch:{ all -> 0x002f }
            r4.sendToTarget()     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r3)
            return
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.activity.BrowserActivity.mo21295a(android.os.Message):void");
    }
    public synchronized void mo21295a(Message message) {
        WebViewBrowser a2;
        WebView B2;
        if (message != null) {
            if (!(!m14874b("", true) || (a2 = this.f13379V.mo21449a(this.f13379V.mo21463e() - 1)) == null || (B2 = a2.mo21630B()) == null)) {
                ((WebView.WebViewTransport) message.obj).setWebView(B2);
                message.sendToTarget();
            }
        }
    }
    /* renamed from: b */
    public void mo21312b(WebViewBrowser eVar) {
        this.f13386ac.mo23010a(this.f13379V.mo21447a(eVar));
    }

    /* renamed from: z */
    public void mo21358z() {
        if (this.f13362E && this.mToolbarLayout != null && this.mBrowserFrame != null) {
            final int height = this.mToolbarLayout.getHeight();
            if (this.mToolbarLayout.getTranslationY() > -0.01f) {
                Animation r1 = new Animation() {
                    /* access modifiers changed from: protected */
                    public void applyTransformation(float f, Transformation transformation) {
                        float f2 = f * ((float) height);
                        BrowserActivity.this.mToolbarLayout.setTranslationY(-f2);
                        BrowserActivity.this.m14852a(((float) height) - f2);
                    }
                };
                r1.setDuration(250);
                r1.setInterpolator(new bpm());
                this.mBrowserFrame.startAnimation(r1);
            }
        }
    }

    /* renamed from: A */
    public void mo21288A() {
        if (this.f13362E) {
            Log.d("BrowserActivity", "showActionBar");
            if (this.mToolbarLayout != null) {
                 int height = this.mToolbarLayout.getHeight();
                if (height == 0) {
                    this.mToolbarLayout.measure(0, 0);
                    height = this.mToolbarLayout.getMeasuredHeight();
                }
                if (this.mToolbarLayout.getTranslationY() < (-(((float) height) - 0.01f))) {
                    int finalHeight = height;
                    Animation r1 = new Animation() {
                        /* access modifiers changed from: protected */
                        public void applyTransformation(float f, Transformation transformation) {
                            float f2 = f * ((float) finalHeight);
                            BrowserActivity.this.mToolbarLayout.setTranslationY(f2 - ((float) finalHeight));
                            BrowserActivity.this.m14852a(f2);
                        }
                    };
                    r1.setDuration(250);
                    r1.setInterpolator(new bpm());
                    this.mBrowserFrame.startAnimation(r1);
                }
            }
        }
    }

    /* renamed from: B */
    public void mo21289B() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (k != null && k.mo21633E().startsWith("file://") && k.mo21633E().endsWith("bookmarks.html")) {
            k.mo21642c();
        }
        if (k != null) {
            this.f13388ae.mo21568a(k.mo21633E());
        }
    }

    /* renamed from: C */
    public void mo21290C() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (k != null && k.mo21633E().startsWith("file://") && k.mo21633E().endsWith("downloads.html")) {
            k.mo21643d();
        }
        if (k != null) {
            this.f13388ae.mo21568a(k.mo21633E());
        }
    }

    /* renamed from: b */
    public void mo21311b(bmg bmg) {
        this.f13388ae.mo21567a(bmg);
        mo21289B();
    }

    /* renamed from: a */
    public void mo21300a(bms.C3912a aVar, String str) {
        this.mDrawerLayout.closeDrawers();
        switch (aVar) {
            case FOREGROUND:
                m14874b(str, true);
                return;
            case BACKGROUND:
                m14874b(str, false);
                return;
            case INCOGNITO:
                Intent intent = new Intent(this, IncognitoActivity.class);
                intent.setData(Uri.parse(str));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up_in, R.anim.fade_out_scale);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m14869b(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= 16) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                runnable.run();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14880c(boolean z) {
        if (!this.f13419u.hasFocus()) {
            this.f13385ab = z ? this.f13382Y : this.f13383Z;
            this.f13419u.setCompoundDrawables((Drawable) null, (Drawable) null, this.f13385ab, (Drawable) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m14842Q() {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (k == null) {
            return;
        }
        if (k.mo21652m() < 100) {
            k.mo21653n();
        } else {
            k.mo21657r();
        }
    }

    public void onClick(View view) {
        WebViewBrowser k = this.f13379V.mo21469k();
        if (k != null) {
            switch (view.getId()) {
                case R.id.action_reading /*2131296292*/:
                    Intent intent = new Intent(this, ReadingActivity.class);
                    intent.putExtra("ReadingUrl", k.mo21633E());
                    startActivity(intent);
                    return;
                case R.id.action_toggle_desktop /*2131296297*/:
                    k.mo21640b((Context) this);
                    k.mo21657r();
                    mo21301a((Runnable) null);
                    return;
                case R.id.arrow_button /*2131296358*/:
                    if (this.f13419u != null && this.f13419u.hasFocus()) {
                        k.mo21656q();
                        return;
                    } else if (this.f13366I) {
                        this.mDrawerLayout.openDrawer(m14840O());
                        return;
                    } else {
                        k.mo21639b();
                        return;
                    }
                case R.id.button_back /*2131296400*/:
                    k.mo21662w();
                    return;
                case R.id.button_next /*2131296401*/:
                    k.mo21661v();
                    return;
                case R.id.button_quit /*2131296402*/:
                    k.mo21663x();
                    this.mSearchBar.setVisibility(8);
                    return;
                case R.id.close_browser /*2131296414*/:
                    mo21308b();
                    return;
                case R.id.download_fab /*2131296473*/:
                case R.id.download_fab_no_found /*2131296474*/:
                    BrowserLogEvent.downloaderLogEvent(this, "main page click download fab", bqw.m19011a(m14843R()));
                    if (m14843R().toLowerCase().contains(bol.m18346a().mo23282b())) {
                        new bnn(0).mo23226a((Context) this);
                        return;
                    } else if (m14843R().toLowerCase().contains(bol.m18346a().mo23284c())) {
                        new bnn(1).mo23226a((Context) this);
                        return;
                    } else if (boi.m18319b().mo23264a(m14843R()) == 0) {
                        if (ManualParseService.m15237a((Context) this, m14843R())) {
                            ManualParseService.m15234a((Context) this, m14843R(), "", m14844S());
                            m14868b((int) R.layout.download_progress_drawer, 0);
                            return;
                        }
                        new bno().mo23231a(this, m14843R());
                        return;
                    } else if (ManualParseService.m15237a((Context) this, m14843R())) {
                        m14868b((int) R.layout.download_manual_drawer, 1);
                        return;
                    } else {
                        m14868b((int) R.layout.download_drawer, 2);
                        return;
                    }
                case R.id.help_close /*2131296533*/:
                    bpj.m18578a((Context) this).mo23395f(false);
                    bpj.m18578a((Context) this).mo23375b((Context) this);
                    this.f13407i.setVisibility(8);
                    BrowserLogEvent.downloaderLogEvent(this, "main page", "click help close");
                    return;
                case R.id.help_layout /*2131296535*/:
                    bpj.m18578a((Context) this).mo23395f(false);
                    bpj.m18578a((Context) this).mo23375b((Context) this);
                    this.f13407i.setVisibility(8);
                    BrowserLogEvent.downloaderLogEvent(this, "main page", "click help button");
                    startActivity(new Intent(this, HelpActivity.class));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    public void m14868b(int i, final int i2) {
        final BottomDialog b = BottomDialog.create(getSupportFragmentManager());
        if (i2 == 0) {
            this.f13394an = b;
        } else {
            this.f13395ao = b;
        }
        b.setLayoutRes(i);
        b.setDimAmount(0.4f);
        b.setViewListener((BottomDialog.ViewListener) new BottomDialog.ViewListener() {
            /* renamed from: a */
            public void bindView(View view) {
                switch (i2) {
                    case 0:
                        BrowserActivity.this.m14877c(view, b);
                        return;
                    case 1:
                        BrowserActivity.this.m14870b(view, b);
                        return;
                    case 2:
                        BrowserActivity.this.m14858a(view, b);
                        return;
                    default:
                        return;
                }
            }
        });
        try {
            b.show();
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public String m14843R() {
        if (this.f13379V == null || this.f13379V.mo21469k() == null) {
            return "";
        }
        return this.f13379V.mo21469k().mo21633E();
    }

    /* renamed from: S */
    private String m14844S() {
        if (this.f13379V == null || this.f13379V.mo21469k() == null) {
            return "";
        }
        return this.f13379V.mo21469k().mo21632D();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14858a(View view, final BottomDialog bVar) {
        ListView listView = (ListView) view.findViewById(R.id.download_list);
        TextView textView = (TextView) view.findViewById(R.id.select);
        Button button = (Button) view.findViewById(R.id.check_all);
        TextView textView2 = (TextView) view.findViewById(R.id.download);
        this.f13397aq = (LinearLayout) view.findViewById(R.id.native_ad_layout);
        final ArrayList<bph> e = boi.m18319b().mo23276e(m14843R());
        if (e.size() == 0) {
            bVar.dismiss();
            EventBus.getDefault().post(new bns());
            bbc.m15886a().mo21878a((Context) this, "BrowserActivity/setDownloadDrawView/recordArray==0");
            return;
        }
        int i = 0;
        synchronized (new Object()) {
            Iterator<bph> it = e.iterator();
            while (it.hasNext()) {
                if (!it.next().mo23358m()) {
                    i++;
                }
            }
            if (i == 0) {
                button.setVisibility(8);
                textView.setVisibility(8);
                textView2.setVisibility(8);
            } else if (i == 1) {
                button.setVisibility(8);
                textView.setVisibility(8);
            }
            this.f13396ap = new bnd(this, e, bVar, textView2);
            listView.setAdapter(this.f13396ap);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                bph bph = (bph) e.get(i);
                if (!(bph == null || bph.mo23358m() || BrowserActivity.this.f13396ap == null)) {
                    bph.mo23332a(!bph.mo23356k());
                    BrowserActivity.this.f13396ap.notifyDataSetChanged();
                }
                BrowserLogEvent.downloaderLogEvent(BrowserActivity.this, "main page", "draw view:click item");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Iterator it = e.iterator();
                while (it.hasNext()) {
                    bph bph = (bph) it.next();
                    if (!bph.mo23358m()) {
                        bph.mo23332a(true);
                    }
                }
                if (BrowserActivity.this.f13396ap != null) {
                    BrowserActivity.this.f13396ap.notifyDataSetChanged();
                }
                BrowserLogEvent.downloaderLogEvent(BrowserActivity.this, "main page", "draw view:check all");
            }
        });
        int finalI = i;
        int finalI1 = i;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (box.m18457a(BrowserActivity.this, new box.C3987a() {
                    /* renamed from: a */
                    public void mo21376a() {
                        BrowserActivity.this.mo21292a(finalI, (ArrayList<bph>) e, bVar);
                    }
                })) {
                    BrowserActivity.this.mo21292a(finalI1, (ArrayList<bph>) e, bVar);
                }
            }
        });
        view.findViewById(R.id.download_drawer_layout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bVar.dismissAllowingStateLoss();
                EventBus.getDefault().post(new bns());
                BrowserLogEvent.downloaderLogEvent(BrowserActivity.this, "main page", "draw view:click drawer close dialog");
            }
        });
    }

    /* renamed from: a */
    public void mo21292a(int i, ArrayList<bph> arrayList, BottomDialog bVar) {
        BrowserLogEvent.downloaderLogEvent(this, "main page", "draw view:click download");
        if (i == 1) {
            Iterator<bph> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                bph next = it.next();
                if (!next.mo23358m()) {
                    bpd.m18506a((Context) this, next);
                    boi.m18319b().mo23272a(next);
                    Toasty.custom(this, getString(R.string.start_downloading), (Drawable) null, getResources().getColor(R.color.toast_start), 1, false, true).show();
                    break;
                }
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                bph bph = arrayList.get(i2);
                if (bph.mo23356k() && !bph.mo23358m()) {
                    arrayList2.add(bph);
                    bpd.m18506a((Context) this, bph);
                }
            }
            if (arrayList2.size() == 0) {
                Toast.makeText(this, getString(R.string.please_select_one), 1).show();
            } else {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    boi.m18319b().mo23272a((bph) it2.next());
                }
                Toasty.custom(this, getString(R.string.start_downloading), (Drawable) null, getResources().getColor(R.color.toast_start), 1, false, true).show();
            }
        }
        if (bVar != null && bVar.isVisible()) {
            bVar.dismissAllowingStateLoss();
        }
        EventBus.getDefault().post(new bns());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14870b(View view, final BottomDialog bVar) {
        ListView listView = (ListView) view.findViewById(R.id.download_list);
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView textView2 = (TextView) view.findViewById(R.id.video_length);
        this.f13399as = (ImageView) view.findViewById(R.id.wifi);
        this.f13399as.setImageResource(bov.m18446a(this) ? R.drawable.ic_wifi_white_24dp : R.drawable.ic_signal_wifi_off_white_24dp);
        this.f13397aq = (LinearLayout) view.findViewById(R.id.native_ad_layout);
        ArrayList<bph> e = boi.m18319b().mo23276e(m14843R());
        try {
            bph bph = e.get(0);
            this.f13398ar = new ManualDrawerDownloadAdapter(this, e, bVar);
            listView.setAdapter(this.f13398ar);
            textView.setText(bph.mo23348f());
            if (bph.mo23360o() > 0) {
                textView2.setText(bpd.m18502a(bph.mo23360o()));
            } else {
                textView2.setVisibility(8);
            }
            view.findViewById(R.id.download_drawer_layout).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    bVar.dismissAllowingStateLoss();
                    EventBus.getDefault().post(new bns());
                    BrowserLogEvent.downloaderLogEvent(BrowserActivity.this, "main page", "draw view:click drawer close dialog");
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            bbc.m15886a().mo21879a((Context) this, (Throwable) e2);
            bVar.dismiss();
            EventBus.getDefault().post(new bns());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14877c(View view, final BottomDialog bVar) {
        ((TextView) view.findViewById(R.id.title)).setText(m14844S());
        this.f13397aq = (LinearLayout) view.findViewById(R.id.native_ad_layout);
        view.findViewById(R.id.download_drawer_layout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bVar.dismiss();
                EventBus.getDefault().post(new bns());
                BrowserLogEvent.downloaderLogEvent(BrowserActivity.this, "main page", "draw view:click drawer close dialog");
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bny bny) {
        if (bny.f16015a.equals(m14843R())) {
            switch (bny.f16016b) {
                case 1:
                    if (this.f13394an != null) {
                        this.f13394an.dismiss();
                    }
                    if (this.f13394an != null && !this.f13394an.isVisible() && boi.m18319b().mo23264a(m14843R()) > 0) {
                        m14868b((int) R.layout.download_manual_drawer, 1);
                    }
                    this.f13394an = null;
                    return;
                case 2:
                    if (this.f13394an != null && this.f13394an.isVisible()) {
                        Toast.makeText(this, getString(R.string.parse_failed), 1).show();
                    }
                    if (this.f13394an != null) {
                        this.f13394an.dismiss();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnz bnz) {
        if (this.f13399as != null) {
            this.f13399as.setImageResource(bov.m18446a(this) ? R.drawable.ic_wifi_white_24dp : R.drawable.ic_signal_wifi_off_white_24dp);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bob bob) {
        if (this.f13409k != null) {
            if (bob.f16018a != 0) {
                if (this.f13396ap != null) {
                    this.f13396ap.notifyDataSetChanged();
                }
                if (this.f13398ar != null) {
                    this.f13398ar.notifyDataSetChanged();
                }
            }
            if (TextUtils.isEmpty(m14843R()) || TextUtils.isEmpty(bob.f16019b) || !bob.f16019b.equals(m14843R())) {
                this.f13409k.setVisibility(8);
                this.f13410l.setVisibility(0);
                return;
            }
            if (bob.f16018a == 0) {
                this.f13409k.setVisibility(8);
                this.f13410l.setVisibility(0);
            } else {
                this.f13409k.setVisibility(0);
                this.f13410l.setVisibility(8);
            }
            if (bob.f16020c == 1) {
                Logger.e("add download task", new Object[0]);
                this.f13409k.setImageResource(R.drawable.download_anim_0);
                this.f13411m = (AnimationDrawable) this.f13409k.getDrawable();
                this.f13411m.setOneShot(true);
                this.f13400at.sendEmptyMessageDelayed(1, 100);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bns bns) {
        this.f13396ap = null;
        this.f13398ar = null;
        this.f13397aq = null;
        this.f13399as = null;
        this.f13394an = null;
        this.f13395ao = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(boa boa) {
        m14874b(boa.mo23242a(), true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnw bnw) {
        mo21347p();
        if (bnw.f16013a) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m14845T() {
        if (this.f13413o == null) {
            this.f13413o = new QBadgeView(this);
        }
        int c = bpe.m18520a().mo23318c();
        this.f13413o.bindTarget((View) this.f13415q).setBadgeGravity(8388661).setGravityOffset(this.f13416r * 0.3f, 0.0f, false).setBadgeNumber(c);
        int i = 8;
        if (c <= 0) {
            boolean z = bpj.m18578a((Context) this).mo23406m() > 0;
            if (z && this.f13414p == null) {
                FrameLayout frameLayout = new FrameLayout(this);
                this.f13414p = new View(this);
                this.f13414p.setBackgroundResource(R.drawable.red_dot);
                int a = axw.m7444a((Context) this, 8.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a);
                layoutParams.gravity = 8388661;
                layoutParams.topMargin = a;
                layoutParams.setMarginEnd((int) ((this.f13416r * 0.3f) + ((float) a)));
                ((ViewGroup) this.f13415q.getParent()).addView(frameLayout);
                frameLayout.addView(this.f13414p, layoutParams);
            }
            if (this.f13414p != null) {
                View view = this.f13414p;
                if (z) {
                    i = 0;
                }
                view.setVisibility(i);
            }
        } else if (this.f13414p != null) {
            this.f13414p.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnv bnv) {
        if (this.f13413o != null) {
            m14845T();
        }
        if (this.f13417s != null) {
            m14846U();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnr bnr) {
        try {
            this.f13386ac.mo23010a(this.f13379V.mo21447a(this.f13379V.mo21469k()));
        } catch (Exception e) {
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
        }
    }


}
