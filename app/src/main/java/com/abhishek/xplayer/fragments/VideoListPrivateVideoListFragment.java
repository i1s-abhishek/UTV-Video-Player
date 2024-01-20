package com.abhishek.xplayer.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.abhishek.xplayer.ad.AdmobIntertitialAds;
import com.abhishek.xplayer.ad.VideoListNativeAdLoader;
import com.abhishek.xplayer.ad.VideoListNativeAd;
import com.abhishek.xplayer.ad.C2231b;
import com.abhishek.xplayer.ad.MopubIntertitialAd;
import com.abhishek.xplayer.ad.AppAbstractInterface;
import com.abhishek.xplayer.ad.StaticAppAds;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.application.AppActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.C2624a;
import com.abhishek.xplayer.content.C2625b;
import com.abhishek.xplayer.content.C2636d;
import com.abhishek.xplayer.content.VideoManager;
import com.abhishek.xplayer.content.MediaFileInfo;
import com.abhishek.xplayer.content.RecentMediaStorage;
import com.mopub.common.util.Views;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

import classesdef.eventbus.awi;
import classesdef.eventbus.awj;
import classesdef.eventbus.awk;
import classesdef.inplayer.awt;
import classesdef.inplayer.axi;
import classesdef.inplayer.SharedPrefrence;
import classesdef.player.aww;
import classesdef.player.DefaultSharedPreferences;
import classesdef.xdplayer.PermissionHelper;
import classesdef.xdplayer.avt;
import classesdef.xdplayer.awl;
import classesdef.xdplayer.awu;
import classesdef.xdplayer.awy;
import classesdef.xdplayer.axa;
import classesdef.xdplayer.axb;
import classesdef.xdplayer.axe;
import classesdef.xdplayer.axr;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.axx;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.fragments.j */
public class VideoListPrivateVideoListFragment extends FragmentLifecycle implements SwipeRefreshLayout.OnRefreshListener, AppAbstractInterface<VideoListNativeAdLoader>, AppActivity.Toolbarinterface {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public String f10850A = new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis()));

    /* renamed from: B */
    private View f10851B;

    /* renamed from: C */
    private View f10852C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public axa f10853D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public axb f10854E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C2625b f10855F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f10856G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public MediaFileInfo f10857H;

    /* renamed from: I */
    private PopupMenu f10858I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public List<MediaFileInfo> f10859J;

    /* renamed from: K */
    private ProgressDialog f10860K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public View f10861L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f10862M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f10863N = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C2751c f10864a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SwipeRefreshLayout f10865b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecyclerView f10866c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2624a f10867d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f10868e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f10869f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f10870g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f10871h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AtomicBoolean f10872i = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ActionBar f10873j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Set<String> f10874k = new HashSet();

    /* renamed from: l */
    private boolean f10875l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f10876m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f10877n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f10878o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f10879p = 0;

    /* renamed from: q */
    private int[] f10880q = {R.drawable.ic_layout_list, R.drawable.ic_layout_grid, R.drawable.ic_layout_fulltitle};

    /* renamed from: r */
    private int[] f10881r = {R.string.layout_style_list_toast, R.string.layout_style_grid_toast, R.string.layout_style_title_toast};
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f10882s = 0;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f10883t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f10884u = 0;

    /* renamed from: v */
    private int f10885v = 3;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public axr f10886w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public awu f10887x;

    /* renamed from: y */
    private boolean f10888y = false;

    /* renamed from: z */
    private avt f10889z;

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static int m12426c(int i) {
        switch (i) {
            case R.id.sort_by_date /*2131296831*/:
                return 1;
            case R.id.sort_by_length /*2131296833*/:
                return 3;
            case R.id.sort_by_name /*2131296834*/:
                return 0;
            case R.id.sort_by_order /*2131296836*/:
                return 2;
            default:
                return -1;
        }
    }

    /* renamed from: a */
    public int mo18062a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* renamed from: a */
    public static VideoListPrivateVideoListFragment m12406a(C2624a aVar, boolean z) {
        VideoListPrivateVideoListFragment jVar = new VideoListPrivateVideoListFragment();
        jVar.f10867d = aVar;
        jVar.f10868e = z;
        return jVar;
    }

    /* renamed from: a */
    public void mo18064a(MediaFileInfo mediaFileInfo) {
        this.f10857H = mediaFileInfo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10869f = new Handler(Looper.myLooper()) {
            public void handleMessage(Message message) {
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    super.handleMessage(message);
                    if (message.obj instanceof C2624a) {
                        C2624a unused = VideoListPrivateVideoListFragment.this.f10867d = (C2624a) message.obj;
                        VideoListPrivateVideoListFragment.this.m12462r();
                    } else if (!(!(message.obj instanceof HashMap) || VideoListPrivateVideoListFragment.this.f10867d == null || VideoListPrivateVideoListFragment.this.f10867d.f10547c == null)) {
                        HashMap hashMap = (HashMap) message.obj;
                        for (MediaFileInfo next : VideoListPrivateVideoListFragment.this.f10867d.f10547c) {
                            String d = next.mo17890d();
                            if (d != null) {
                                Object obj = hashMap.get(d);
                                if (obj instanceof RecentMediaStorage.DBBean) {
                                    next.mo17883a((RecentMediaStorage.DBBean) obj);
                                }
                            }
                        }
                    }
                    if (VideoListPrivateVideoListFragment.this.f10870g) {
                        VideoListPrivateVideoListFragment.this.m12442h();
                        if (VideoListPrivateVideoListFragment.this.f10867d.mo17924a() == 0) {
                            VideoListPrivateVideoListFragment.this.m12464s();
                        } else {
                            VideoListPrivateVideoListFragment.this.m12465t();
                        }
                    }
                    if (VideoListPrivateVideoListFragment.this.f10865b != null && VideoListPrivateVideoListFragment.this.f10865b.isRefreshing()) {
                        VideoListPrivateVideoListFragment.this.f10865b.setRefreshing(false);
                    }
                }
            }
        };
        this.f10856G = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false);
        EventBus.getDefault().register((Object) this);
        if (!DefaultSharedPreferences.getAdRemoved("adRemoved", false)) {
            if (MopubIntertitialAd.createInstance2().mo16969g() || AdmobIntertitialAds.create().mo16898b()) {
                LogEvents.m18486a("SplashAd", "Show", m12431d());
            }
            if (C2231b.m10188a().mo16920c()) {
                VideoListNativeAd.m10175e().mo16912a((AppAbstractInterface<VideoListNativeAdLoader>) this);
                VideoListNativeAdLoader f = VideoListNativeAd.m10175e().mo16918f();
                if (f != null && f.mo16905d()) {
                    this.f10861L = f.mo16908g();
                    VideoListNativeAd.m10175e().mo16916c(f);
                }
                if (this.f10861L == null) {
                    this.f10861L = StaticAppAds.create(MyApplication.getApplicationContext_(), (int) R.layout.video_list_ad);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        LogEvents.m18498d(m12431d());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m12431d() {
        return this.f10868e ? "PrivateList" : "VideoList";
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f10868e ? R.layout.fragment_list_refresh_private : R.layout.fragment_list_refresh, viewGroup, false);
        this.f10866c = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.f10885v = getResources().getInteger(R.integer.grid_mode_item_count);
        this.f10884u = (mo18062a((Context) getActivity()) - (axw.m7444a((Context) getActivity(), 3.0f) * (this.f10885v + 1))) / this.f10885v;
        this.f10865b = (SwipeRefreshLayout) inflate.findViewById(R.id.SwipeRefreshLayout);
        this.f10865b.setEnabled(this.f10868e);
        this.f10865b.setOnRefreshListener(this);
        this.f10865b.setColorSchemeResources(R.color.refresh_color_1, R.color.refresh_color_2, R.color.refresh_color_3);
        this.f10879p = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("layoutStyleIndex", 0);
        if (this.f10867d == null || !this.f10867d.f10548d) {
            this.f10882s = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("sort_by", 0);
            this.f10883t = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean("sort_by_desc", false);
        } else {
            this.f10882s = 1;
        }
        if (this.f10867d != null) {
            m12462r();
        }
        this.f10864a = new C2751c();
        this.f10864a.setHasStableIds(true);
        if (!this.f10868e) {
            m12442h();
            this.f10878o = true;
        } else if (this.f10867d == null) {
            m12440g();
        } else {
            m12442h();
        }
        if (!this.f10868e) {
            this.f10865b = null;
        } else {
            inflate.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    LogEvents.m18492b(VideoListPrivateVideoListFragment.this.m12431d(), "Add");
                    boolean unused = VideoListPrivateVideoListFragment.this.f10876m = true;
                    Intent intent = new Intent("android.intent.action.PICK");
                    intent.setType("video/*");
                    try {
                        VideoListPrivateVideoListFragment.this.startActivityForResult(intent, 52129);
                    } catch (ActivityNotFoundException unused2) {
                    }
                }
            });
        }
        this.f10873j = ((AppCompatActivity) getActivity()).getSupportActionBar();
        this.f10873j.setDisplayHomeAsUpEnabled(true);
        this.f10873j.setDisplayShowHomeEnabled(true);
        this.f10873j.setHomeAsUpIndicator((int) R.drawable.ic_back);
        this.f10873j.setSubtitle((CharSequence) null);
        if (this.f10868e) {
            this.f10873j.setTitle((int) R.string.private_videos);
        } else if (this.f10867d != null) {
            if (this.f10867d.f10548d) {
                this.f10873j.setTitle((int) R.string.recent_added);
            } else {
                this.f10873j.setTitle((CharSequence) this.f10867d.f10546b);
            }
        }
        setHasOptionsMenu(true);
        long unused = this.f10864a.f10942b = System.currentTimeMillis();
        this.f10870g = true;
        //  this.f10889z = new avy();
        this.f10851B = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!this.f10872i.get()) {
            if (this.f10867d == null || this.f10867d.mo17924a() == 0) {
                m12464s();
            } else {
                m12465t();
            }
        } else if (this.f10865b != null) {
            this.f10865b.post(new Runnable() {
                public void run() {
                    if (VideoListPrivateVideoListFragment.this.f10865b != null && VideoListPrivateVideoListFragment.this.f10872i.get()) {
                        VideoListPrivateVideoListFragment.this.f10865b.setRefreshing(true);
                    }
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 52130) {
            if (i2 == 323) {
                this.f10875l = true;
            }
        } else if (i == 52129) {
            if (i2 == -1 && intent != null) {
                Uri data = intent.getData();
                if (data == null || !m12425b(axx.m7454a(MyApplication.getApplicationContext_(), data))) {
                    LogEvents.m18496c("Import2Private", "No");
                    axv.m7434a((int) R.string.cant_load_video);
                } else {
                    LogEvents.m18496c("Import2Private", "Yes");
                    return;
                }
            }
        } else if (i == 52131) {
            if (this.f10855F != null) {
                this.f10855F.mo17931a(i2, intent);
            } else if (this.f10853D != null) {
                this.f10853D.mo10928a(i2, intent);
            } else if (this.f10854E != null) {
                this.f10854E.mo10942a(i2, intent);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(this.f10868e ? R.menu.menu_locked_list : R.menu.menu_file_list, menu);
        menu.findItem(R.id.style).setIcon(this.f10880q[this.f10879p]);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem;
        if (this.f10871h) {
            menu.setGroupVisible(R.id.group_normal, false);
            menu.setGroupVisible(R.id.group_select_mode, true);
        } else {
            menu.setGroupVisible(R.id.group_normal, true);
            menu.setGroupVisible(R.id.group_select_mode, false);
        }
        if (!(this.f10867d == null || !this.f10867d.f10548d || (findItem = menu.findItem(R.id.sort)) == null)) {
            findItem.setVisible(false);
        }
        super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!mo17989b()) {
            return false;
        }
        switch (menuItem.getItemId()) {
            case 16908332:
                if (!this.f10871h) {
                    if (!mo17990c()) {
                        getActivity().onBackPressed();
                        break;
                    }
                } else {
                    m12446j();
                    break;
                }
                break;
            case R.id.delete /*2131296450*/:
                TreeMap treeMap = new TreeMap();
                treeMap.put("fileCount", String.valueOf(this.f10874k.size()));
                LogEvents.m18487a(m12431d(), "Delete", (Map<String, String>) treeMap);
                if (!this.f10874k.isEmpty()) {
                    m12448k();
                }
                return true;
            case R.id.info /*2131296561*/:
                TreeMap treeMap2 = new TreeMap();
                treeMap2.put("fileCount", String.valueOf(this.f10874k.size()));
                LogEvents.m18487a(m12431d(), "Info", (Map<String, String>) treeMap2);
                if (!this.f10874k.isEmpty()) {
                    m12455o();
                }
                return true;
            case R.id.lock /*2131296618*/:
                if (!Environment.isExternalStorageManager()) {
                    new AlertDialog.Builder(getActivity()).setTitle(R.string.allow).setMessage(R.string.manage_all_file_permission_description)
                            .setPositiveButton((int) R.string.open_setting, (DialogInterface.OnClickListener)
                                    (dialogInterface, i) -> PermissionHelper.manageAppFilesAccessPermission(requireActivity())).show();
                } else {
                    TreeMap treeMap3 = new TreeMap();
                    treeMap3.put("fileCount", String.valueOf(this.f10874k.size()));
                    LogEvents.m18487a(m12431d(), "Lock", (Map<String, String>) treeMap3);
                    if (!this.f10874k.isEmpty()) {
                        m12451m();
                    }
                }
                return true;
            case R.id.modify_pin /*2131296633*/:
                LogEvents.m18492b(m12431d(), "ModifyPin");
                this.f10876m = true;
                AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), PasswordFragment.m12270a(1), true);
                return true;
            case R.id.select /*2131296807*/:
                LogEvents.m18492b(m12431d(), "Select");
                m12414a((String) null);
                return true;
            case R.id.share /*2131296812*/:
                TreeMap treeMap4 = new TreeMap();
                treeMap4.put("fileCount", String.valueOf(this.f10874k.size()));
                LogEvents.m18487a(m12431d(), "MultiShare", (Map<String, String>) treeMap4);
                if (!this.f10874k.isEmpty()) {
                    if (this.f10874k.size() == 1) {
                        axy.m7463a((Activity) getActivity(), this.f10874k.iterator().next(), "video/*");
                    } else {
                        axy.m7466a((Activity) getActivity(), (Collection<String>) this.f10874k, "video/*");
                    }
                }
                return true;
            case R.id.sort /*2131296828*/:
                LogEvents.m18492b(m12431d(), "Sort");
                m12459q();
                return true;
            case R.id.style /*2131296854*/:
                LogEvents.m18492b(m12431d(), "LayoutStyle");
                this.f10879p = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("layoutStyleIndex", 0);
                this.f10879p++;
                if (this.f10879p % 3 == 0) {
                    this.f10879p = 0;
                }
                axv.m7434a(this.f10881r[this.f10879p]);
                PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt("layoutStyleIndex", this.f10879p).apply();
                menuItem.setIcon(this.f10880q[this.f10879p]);
                m12442h();
                return true;
            case R.id.unlock /*2131296968*/:
                TreeMap treeMap5 = new TreeMap();
                treeMap5.put("fileCount", String.valueOf(this.f10874k.size()));
                LogEvents.m18487a(m12431d(), "Unlock", (Map<String, String>) treeMap5);
                if (!this.f10874k.isEmpty()) {
                    m12453n();
                }
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        FileExplorerActivity.fragmentName = m12431d();
        super.onResume();
        if (VideoFolderFragment.f10956a) {
            m12434e();
        }
        this.f10876m = false;
        if (!this.f10868e || !this.f10875l) {
            if (getActivity() instanceof AppActivity) {
                ((AppActivity) getActivity()).setToolbarInstance(this);
            }
            if (this.f10878o) {
                this.f10878o = false;
                m12416a(true);
            }
            if (!DefaultSharedPreferences.getAdRemoved("adRemoved", false)) {
                VideoListNativeAd.m10175e().mo16926b();
                return;
            }
            return;
        }
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        supportFragmentManager.popBackStack();
        AppActivity.loadFragmet(supportFragmentManager, PasswordFragment.m12270a(0), true);
    }

    /* renamed from: e */
    private void m12434e() {
        m12437f();
    }

    /* renamed from: f */
    private void m12437f() {
        getActivity().setTheme(R.style.DarkTheme);
        ((FileExplorerActivity) getActivity()).mo17667b();
        this.f10889z.mo10824a(getActivity(), (ViewGroup) this.f10851B);
    }

    public void onPause() {
        super.onPause();
        if (getActivity() instanceof AppActivity) {
            ((AppActivity) getActivity()).setToolbarInstance((AppActivity.Toolbarinterface) null);
        }
        if (this.f10865b != null) {
            this.f10865b.setRefreshing(false);
            this.f10865b.destroyDrawingCache();
            this.f10865b.clearAnimation();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.f10868e && !this.f10876m) {
            this.f10875l = true;
        }
    }

    public void onDestroyView() {
        this.f10870g = false;
        this.f10865b = null;
        this.f10852C = null;
        super.onDestroyView();
    }

    public void onDestroy() {
        VideoListNativeAd.m10175e().mo16915b((AppAbstractInterface<VideoListNativeAdLoader>) this);
        Views.removeFromParent(this.f10861L);
        this.f10861L = null;
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int integer = getResources().getInteger(R.integer.grid_mode_item_count);
        if (integer != this.f10885v) {
            this.f10885v = integer;
            int i = integer + 1;
            this.f10884u = (mo18062a((Context) getActivity()) - (axw.m7444a((Context) getActivity(), 3.0f) * i)) / integer;
            if (this.f10866c != null && this.f10879p == 1 && (this.f10866c.getLayoutManager() instanceof GridLayoutManager)) {
                this.f10863N = i;
                ((GridLayoutManager) this.f10866c.getLayoutManager()).setSpanCount(integer);
                if (this.f10886w != null) {
                    this.f10866c.removeItemDecoration(this.f10886w);
                    this.f10886w = null;
                }
                RecyclerView recyclerView = this.f10866c;
                axr axr = new axr(axw.m7444a((Context) getActivity(), 4.0f), integer);
                this.f10886w = axr;
                recyclerView.addItemDecoration(axr);
                int i2 = -1;
                this.f10886w.mo10998a(this.f10861L != null ? this.f10863N : -1);
                this.f10864a.m12501a(this.f10866c);
                if (this.f10887x != null) {
                    this.f10887x.mo10893a(integer);
                    awu awu = this.f10887x;
                    if (this.f10861L != null) {
                        i2 = this.f10863N;
                    }
                    awu.mo10894b(i2);
                }
            }
        }
        this.f10864a.notifyDataSetChanged();
        if (this.f10858I != null) {
            this.f10858I.dismiss();
        }
    }

    /* renamed from: a */
    public boolean setToolbar() {
        if (!this.f10871h) {
            return false;
        }
        m12446j();
        return true;
    }

    public void onRefresh() {
        m12440g();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPinSet(awi awi) {
        if (mo17989b() && this.f10877n && getActivity() != null) {
            if (this.f10859J != null) {
                m12423b(this.f10859J);
                this.f10859J = null;
            }
            this.f10877n = false;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onOnRefreshNextResume(awk awk) {
        this.f10878o = true;
    }

    /* renamed from: g */
    private void m12440g() {
        m12416a(false);
    }

    /* renamed from: a */
    private void m12416a(boolean z) {
        Runnable runnable;
        this.f10872i.set(true);
        if (this.f10868e) {
            runnable = new Runnable() {
                public void run() {
                    C2624a a = C2636d.m12138a();
                    if (a != null) {
                        RecentMediaStorage recentMediaStorage = new RecentMediaStorage(MyApplication.getApplicationContext_());
                        if (a.f10547c != null) {
                            for (MediaFileInfo next : a.f10547c) {
                                next.mo17883a(recentMediaStorage.mo17901a(next.mo17890d()));
                            }
                        }
                    }
                    VideoListPrivateVideoListFragment.this.f10872i.set(false);
                    VideoListPrivateVideoListFragment.this.f10869f.obtainMessage(0, a).sendToTarget();
                }
            };
        } else if (this.f10867d == null || this.f10867d.f10547c == null || this.f10867d.f10547c.isEmpty()) {
            this.f10872i.set(false);
            runnable = null;
        } else {
            final ArrayList arrayList = new ArrayList(this.f10867d.f10547c.size());
            for (MediaFileInfo d : this.f10867d.f10547c) {
                arrayList.add(d.mo17890d());
            }
            runnable = new Runnable() {
                public void run() {
                    RecentMediaStorage recentMediaStorage = new RecentMediaStorage(MyApplication.getApplicationContext_());
                    HashMap hashMap = new HashMap();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        RecentMediaStorage.DBBean a = recentMediaStorage.mo17901a(str);
                        if (a != null) {
                            hashMap.put(str, a);
                        }
                    }
                    VideoListPrivateVideoListFragment.this.f10872i.set(false);
                    VideoListPrivateVideoListFragment.this.f10869f.obtainMessage(0, hashMap).sendToTarget();
                }
            };
        }
        if (runnable == null) {
            return;
        }
        if (z) {
            RecentMediaStorage.m12069a().execute(runnable);
        } else {
            new Thread(runnable).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m12442h() {
        int i;
        int i2 = -1;
        if (this.f10879p == 1) {
            this.f10863N = this.f10885v + 1;
            if (this.f10866c.getLayoutManager() == null || !(this.f10866c.getLayoutManager() instanceof GridLayoutManager)) {
                this.f10866c.setLayoutManager(new GridLayoutManager(MyApplication.getApplicationContext_(), this.f10885v));
                if (this.f10886w != null) {
                    this.f10866c.removeItemDecoration(this.f10886w);
                    this.f10886w = null;
                }
                RecyclerView recyclerView = this.f10866c;
                axr axr = new axr(axw.m7444a((Context) getActivity(), 4.0f), this.f10885v);
                this.f10886w = axr;
                recyclerView.addItemDecoration(axr);
                this.f10886w.mo10998a(this.f10861L != null ? this.f10863N : -1);
                i = this.f10885v;
            } else {
                this.f10864a.notifyDataSetChanged();
                return;
            }
        } else {
            if (this.f10879p == 2) {
                this.f10863N = 2;
                if (this.f10866c.getLayoutManager() == null || (this.f10866c.getLayoutManager() instanceof GridLayoutManager)) {
                    this.f10866c.setLayoutManager(new LinearLayoutManager(MyApplication.getApplicationContext_(), 1, false));
                    if (this.f10886w != null) {
                        this.f10866c.removeItemDecoration(this.f10886w);
                        this.f10886w = null;
                    }
                } else {
                    this.f10864a.notifyDataSetChanged();
                    return;
                }
            } else {
                this.f10863N = 2;
                if (this.f10866c.getLayoutManager() == null || (this.f10866c.getLayoutManager() instanceof GridLayoutManager)) {
                    this.f10866c.setLayoutManager(new LinearLayoutManager(MyApplication.getApplicationContext_(), 1, false));
                    if (this.f10886w != null) {
                        this.f10866c.removeItemDecoration(this.f10886w);
                        this.f10886w = null;
                    }
                } else {
                    this.f10864a.notifyDataSetChanged();
                    return;
                }
            }
            i = 1;
        }
        if (this.f10868e) {
            if (this.f10887x != null) {
                this.f10887x.mo10893a(i);
            } else {
                RecyclerView recyclerView2 = this.f10866c;
                awu awu = new awu(axw.m7444a(MyApplication.getApplicationContext_(), 72.0f), i);
                this.f10887x = awu;
                recyclerView2.addItemDecoration(awu);
            }
            awu awu2 = this.f10887x;
            if (this.f10861L != null) {
                i2 = this.f10863N;
            }
            awu2.mo10894b(i2);
        }
        this.f10866c.setAdapter(this.f10864a);
        if (m12443i() > 0) {
            this.f10866c.scrollToPosition(m12443i() + 1);
            this.f10866c.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    MediaFileInfo unused = VideoListPrivateVideoListFragment.this.f10857H = null;
                    VideoListPrivateVideoListFragment.this.f10864a.notifyDataSetChanged();
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public int m12443i() {
        if (this.f10857H == null) {
            return -1;
        }
        for (int i = 0; i < this.f10867d.f10547c.size(); i++) {
            if (this.f10857H.mo17890d().equals(this.f10867d.f10547c.get(i).mo17890d())) {
                return i;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12414a(String str) {
        this.f10871h = true;
        this.f10874k.clear();
        if (str != null) {
            this.f10874k.add(str);
        }
        if (this.f10865b != null) {
            this.f10865b.setEnabled(false);
        }
        this.f10873j.setHomeAsUpIndicator((int) R.drawable.ic_close_round);
        this.f10873j.setTitle((CharSequence) getString(R.string.n_selected, Integer.valueOf(this.f10874k.size())));
        if (getActivity() != null) {
            getActivity().invalidateOptionsMenu();
        }
        this.f10864a.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m12446j() {
        this.f10871h = false;
        this.f10874k.clear();
        if (this.f10865b != null) {
            this.f10865b.setEnabled(true);
        }
        this.f10873j.setHomeAsUpIndicator((int) R.drawable.ic_back);
        if (this.f10868e) {
            this.f10873j.setTitle((int) R.string.private_videos);
        } else if (this.f10867d != null) {
            this.f10873j.setTitle((CharSequence) this.f10867d.f10546b);
        }
        if (getActivity() != null) {
            getActivity().invalidateOptionsMenu();
        }
        this.f10864a.notifyDataSetChanged();
        if (this.f10867d == null || this.f10867d.mo17924a() == 0) {
            m12464s();
        } else {
            m12465t();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m12448k() {
        AlertDialog.Builder builder;
        if (mo17989b()) {
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setTitle((int) R.string.delete_video_dialog_title).setMessage((int) R.string.delete_video_dialog_desc).setPositiveButton((int) R.string.delete, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("fileCount", String.valueOf(VideoListPrivateVideoListFragment.this.f10874k.size()));
                    LogEvents.m18487a(VideoListPrivateVideoListFragment.this.m12431d(), "Delete/Yes", (Map<String, String>) treeMap);
                    dialogInterface.dismiss();
                    VideoListPrivateVideoListFragment.this.m12450l();
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m12450l() {
        if (mo17989b() && this.f10874k != null) {
            final ArrayList arrayList = new ArrayList(this.f10874k);
            final Runnable r1 = new Runnable() {
                public void run() {
                    if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                        VideoListPrivateVideoListFragment.this.m12458p();
                        if (!(VideoListPrivateVideoListFragment.this.f10867d == null || VideoListPrivateVideoListFragment.this.f10867d.f10547c == null)) {
                            Iterator<MediaFileInfo> it = VideoListPrivateVideoListFragment.this.f10867d.f10547c.iterator();
                            while (it.hasNext()) {
                                if (VideoListPrivateVideoListFragment.this.f10874k.contains(it.next().mo17890d())) {
                                    it.remove();
                                }
                            }
                        }
                        VideoListPrivateVideoListFragment.this.m12446j();
                        axv.m7436a(VideoListPrivateVideoListFragment.this.getView(), (int) R.string.delete_success);
                        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt("media_size", PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("media_size", 0) - VideoListPrivateVideoListFragment.this.f10874k.size()).apply();
                    }
                }
            };
            if (this.f10868e) {
                this.f10853D = new axa(arrayList, new axa.C1330a() {
                    /* renamed from: a */
                    public void mo10938a() {
                        axa unused = VideoListPrivateVideoListFragment.this.f10853D = null;
                        C2636d.m12145a((List<String>) arrayList, r1);
                    }

                    /* renamed from: b */
                    public void mo10939b() {
                        AlertDialog.Builder builder;
                        axa unused = VideoListPrivateVideoListFragment.this.f10853D = null;
                        if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                            VideoListPrivateVideoListFragment.this.m12458p();
                            VideoListPrivateVideoListFragment.this.m12446j();
                            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                                builder = new AlertDialog.Builder(VideoListPrivateVideoListFragment.this.getActivity(), R.style.MyAlertStyle);
                            } else {
                                builder = new AlertDialog.Builder(VideoListPrivateVideoListFragment.this.getActivity());
                            }
                            builder.setTitle((int) R.string.delete_failed).setMessage((int) R.string.delete_failed_cant_write).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                        }
                    }

                    /* renamed from: c */
                    public void mo10940c() {
                        if (VideoListPrivateVideoListFragment.this.mo17989b() && VideoListPrivateVideoListFragment.this.f10853D != null) {
                            VideoListPrivateVideoListFragment.this.m12458p();
                            boolean unused = VideoListPrivateVideoListFragment.this.f10876m = true;
                            VideoListPrivateVideoListFragment.this.f10853D.mo10929a((Fragment) VideoListPrivateVideoListFragment.this, 52131);
                        }
                    }

                    /* renamed from: d */
                    public void mo10941d() {
                        if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                            VideoListPrivateVideoListFragment.this.m12407a((int) R.string.delete, true);
                        }
                    }
                });
                this.f10853D.mo10930a(true);
                return;
            }
            EventBus.getDefault().post(new awj());
            this.f10853D = new axa(arrayList, new axa.C1330a() {
                /* renamed from: a */
                public void mo10938a() {
                    axa unused = VideoListPrivateVideoListFragment.this.f10853D = null;
                    r1.run();
                }

                /* renamed from: b */
                public void mo10939b() {
                    AlertDialog.Builder builder;
                    axa unused = VideoListPrivateVideoListFragment.this.f10853D = null;
                    if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                        VideoListPrivateVideoListFragment.this.m12458p();
                        VideoListPrivateVideoListFragment.this.m12446j();
                        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                            builder = new AlertDialog.Builder(VideoListPrivateVideoListFragment.this.getActivity(), R.style.MyAlertStyle);
                        } else {
                            builder = new AlertDialog.Builder(VideoListPrivateVideoListFragment.this.getActivity());
                        }
                        builder.setTitle((int) R.string.delete_failed).setMessage((int) R.string.delete_failed_cant_write).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                    }
                }

                /* renamed from: c */
                public void mo10940c() {
                    if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                        VideoListPrivateVideoListFragment.this.m12458p();
                        if (VideoListPrivateVideoListFragment.this.f10853D != null) {
                            VideoListPrivateVideoListFragment.this.f10853D.mo10929a((Fragment) VideoListPrivateVideoListFragment.this, 52131);
                        }
                    }
                }

                /* renamed from: d */
                public void mo10941d() {
                    if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                        VideoListPrivateVideoListFragment.this.m12407a((int) R.string.delete, true);
                    }
                }
            });
            this.f10853D.mo10930a(true);
        }
    }

    /* renamed from: b */
    private boolean m12425b(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        long b = axi.m7359b(str);
        if (b <= 0) {
            return false;
        }
        MediaFileInfo mediaFileInfo = new MediaFileInfo();
        mediaFileInfo.mo17888b(file.getName());
        mediaFileInfo.mo17884a(str);
        mediaFileInfo.mo17881a(1);
        mediaFileInfo.mo17882a(b);
        mediaFileInfo.f10496a = file.length();
        mediaFileInfo.f10497b = str;
        mediaFileInfo.mo17887b(file.lastModified());
        this.f10874k.clear();
        this.f10874k.add(str);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(mediaFileInfo);
        m12415a((List<MediaFileInfo>) arrayList);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m12451m() {
        ArrayList arrayList = new ArrayList();
        if (!(this.f10867d == null || this.f10867d.f10547c == null)) {
            for (MediaFileInfo next : this.f10867d.f10547c) {
                if (this.f10874k.contains(next.mo17890d())) {
                    arrayList.add(next);
                }
            }
        }
        m12415a((List<MediaFileInfo>) arrayList);
    }

    /* renamed from: a */
    private void m12415a(final List<MediaFileInfo> list) {
        AlertDialog.Builder builder;
        if (mo17989b()) {
            int size = list.size();
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setTitle((CharSequence) getString(size > 1 ? R.string.lock_videos_title : R.string.lock_video_title, Integer.valueOf(list.size()))).setMessage((CharSequence) getString(R.string.lock_video_desc).concat(" ").concat(getString(R.string.lock_video_desc2))).setPositiveButton((int) R.string.lock, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("fileCount", String.valueOf(VideoListPrivateVideoListFragment.this.f10874k.size()));
                        LogEvents.m18487a(VideoListPrivateVideoListFragment.this.m12431d(), "Lock/Yes", (Map<String, String>) treeMap);
                        dialogInterface.dismiss();
                        if (PasswordFragment.m12273a()) {
                            VideoListPrivateVideoListFragment.this.m12423b((List<MediaFileInfo>) list);
                            return;
                        }
                        boolean unused = VideoListPrivateVideoListFragment.this.f10877n = true;
                        List unused2 = VideoListPrivateVideoListFragment.this.f10859J = list;
                        AppActivity.loadFragmet(VideoListPrivateVideoListFragment.this.getActivity().getSupportFragmentManager(), PasswordFragment.m12270a(2), true);
                    }
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12423b(List<MediaFileInfo> list) {
        this.f10855F = new C2625b();
        this.f10855F.mo17933a(list, (C2625b.C2630d) new C2625b.C2630d() {
            /* renamed from: a */
            public void mo17939a(Set<String> set, int i, int i2, String str, boolean z) {
                String str2;
                AlertDialog.Builder builder;
                C2625b unused = VideoListPrivateVideoListFragment.this.f10855F = null;
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    VideoListPrivateVideoListFragment.this.m12458p();
                    if (!(VideoListPrivateVideoListFragment.this.f10867d == null || VideoListPrivateVideoListFragment.this.f10867d.f10547c == null)) {
                        Iterator<MediaFileInfo> it = VideoListPrivateVideoListFragment.this.f10867d.f10547c.iterator();
                        while (it.hasNext()) {
                            if (set.contains(it.next().mo17890d())) {
                                it.remove();
                            }
                        }
                    }
                    VideoListPrivateVideoListFragment.this.m12446j();
                    if (VideoListPrivateVideoListFragment.this.f10868e) {
                        VideoListPrivateVideoListFragment.this.onRefresh();
                        EventBus.getDefault().post(new awj());
                    } else {
                        EventBus.getDefault().post(new awj());
                    }
                    if (i2 > 0) {
                        str2 = VideoListPrivateVideoListFragment.this.getString(R.string.lock_video_success_failed, Integer.valueOf(i), Integer.valueOf(i2));
                    } else {
                        str2 = VideoListPrivateVideoListFragment.this.getString(R.string.lock_video_success, Integer.valueOf(i)) + " " + VideoListPrivateVideoListFragment.this.getString(R.string.lock_video_success_desc);
                    }
                    if (!z) {
                        if (str != null) {
                            str2 = str2 + "\n" + str;
                        }
                        axv.m7438a(VideoListPrivateVideoListFragment.this.getView(), str2);
                        return;
                    }
                    if (str != null) {
                        str2 = str2 + "\n\n" + str;
                    }
                    if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                        builder = new AlertDialog.Builder(VideoListPrivateVideoListFragment.this.getActivity(), R.style.MyAlertStyle);
                    } else {
                        builder = new AlertDialog.Builder(VideoListPrivateVideoListFragment.this.getActivity());
                    }
                    builder.setMessage((CharSequence) str2).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                }
            }

            /* renamed from: a */
            public void mo17938a(String str) {
                AlertDialog.Builder builder;
                C2625b unused = VideoListPrivateVideoListFragment.this.f10855F = null;
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    if (str != null) {
                        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                            builder = new AlertDialog.Builder(VideoListPrivateVideoListFragment.this.getActivity(), R.style.MyAlertStyle);
                        } else {
                            builder = new AlertDialog.Builder(VideoListPrivateVideoListFragment.this.getActivity());
                        }
                        builder.setTitle((CharSequence) VideoListPrivateVideoListFragment.this.getString(R.string.lock_failed)).setMessage((CharSequence) str).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                    } else {
                        axv.m7434a((int) R.string.lock_failed);
                    }
                    VideoListPrivateVideoListFragment.this.m12458p();
                }
            }

            /* renamed from: a */
            public void mo17937a() {
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    VideoListPrivateVideoListFragment.this.m12407a((int) R.string.lock, true);
                }
            }

            /* renamed from: c */
            public void mo17943c(String str) {
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    VideoListPrivateVideoListFragment.this.m12458p();
                    if (VideoListPrivateVideoListFragment.this.f10855F != null) {
                        boolean unused = VideoListPrivateVideoListFragment.this.f10876m = true;
                        VideoListPrivateVideoListFragment.this.f10855F.mo17932a((Fragment) VideoListPrivateVideoListFragment.this, 52131);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m12453n() {
        AlertDialog.Builder builder;
        if (mo17989b()) {
            final ArrayList arrayList = new ArrayList();
            if (!(this.f10867d == null || this.f10867d.f10547c == null)) {
                for (MediaFileInfo next : this.f10867d.f10547c) {
                    if (this.f10874k.contains(next.mo17890d())) {
                        arrayList.add(next);
                    }
                }
            }
            int size = arrayList.size();
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setTitle((CharSequence) getString(size > 1 ? R.string.unlock_videos_title : R.string.unlock_video_title, Integer.valueOf(arrayList.size()))).setMessage((CharSequence) getString(R.string.unlock_video_desc)).setPositiveButton((int) R.string.unlock, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("fileCount", String.valueOf(VideoListPrivateVideoListFragment.this.f10874k.size()));
                    LogEvents.m18487a(VideoListPrivateVideoListFragment.this.m12431d(), "Unlock/Yes", (Map<String, String>) treeMap);
                    dialogInterface.dismiss();
                    VideoListPrivateVideoListFragment.this.m12428c((List<MediaFileInfo>) arrayList);
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12428c(List<MediaFileInfo> list) {
        this.f10855F = new C2625b();
        this.f10855F.mo17934a(list, (C2625b.C2631e) new C2625b.C2631e() {
            /* renamed from: b */
            public void mo17942b(List<MediaFileInfo> list) {
                Log.e("abhi_private_vid", "one");
                C2625b unused = VideoListPrivateVideoListFragment.this.f10855F = null;
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    Log.e("abhi_private_vid", "two");
                    VideoListPrivateVideoListFragment.this.m12458p();
                    if (!(VideoListPrivateVideoListFragment.this.f10867d == null || VideoListPrivateVideoListFragment.this.f10867d.f10547c == null)) {
                        Iterator<MediaFileInfo> it = VideoListPrivateVideoListFragment.this.f10867d.f10547c.iterator();
                        while (it.hasNext()) {
                            if (VideoListPrivateVideoListFragment.this.f10874k.contains(it.next().mo17890d())) {
                                it.remove();
                            }
                        }
                    }
                    VideoListPrivateVideoListFragment.this.m12446j();
                    View view = VideoListPrivateVideoListFragment.this.getView();
                    axv.m7438a(view, VideoListPrivateVideoListFragment.this.getString(R.string.unlock_video_success, Integer.valueOf(list.size())) + " " + VideoListPrivateVideoListFragment.this.getString(R.string.unlock_video_desc2));
                    EventBus.getDefault().post(new awj());
                }
            }

            /* renamed from: b */
            public void mo17941b(String str) {
                Log.e("abhi_private_vid", "three");
                C2625b unused = VideoListPrivateVideoListFragment.this.f10855F = null;
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    axv.m7434a((int) R.string.unlock_failed);
                    VideoListPrivateVideoListFragment.this.m12458p();
                }
            }

            /* renamed from: b */
            public void mo17940b() {
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    VideoListPrivateVideoListFragment.this.m12407a((int) R.string.unlock, true);
                }
            }

            /* renamed from: c */
            public void mo17943c(String str) {
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    VideoListPrivateVideoListFragment.this.m12458p();
                    if (VideoListPrivateVideoListFragment.this.f10855F != null) {
                        boolean unused = VideoListPrivateVideoListFragment.this.f10876m = true;
                        VideoListPrivateVideoListFragment.this.f10855F.mo17932a((Fragment) VideoListPrivateVideoListFragment.this, 52131);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m12455oo() {
        /*
            r15 = this;
            boolean r0 = r15.mo17989b()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.util.Set<java.lang.String> r0 = r15.f10874k
            int r0 = r0.size()
            r1 = 2131624278(0x7f0e0156, float:1.8875731E38)
            r2 = 2131624319(0x7f0e017f, float:1.8875814E38)
            r3 = 2131689654(0x7f0f00b6, float:1.900833E38)
            r4 = 2
            r5 = 2131296981(0x7f0902d5, float:1.8211894E38)
            r6 = 1
            r7 = 0
            r8 = 0
            if (r0 != r6) goto L_0x0164
            com.inshot.xplayer.content.a r0 = r15.f10867d
            if (r0 == 0) goto L_0x004a
            com.inshot.xplayer.content.a r0 = r15.f10867d
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r0 = r0.f10547c
            if (r0 == 0) goto L_0x004a
            com.inshot.xplayer.content.a r0 = r15.f10867d
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r0 = r0.f10547c
            java.util.Iterator r0 = r0.iterator()
        L_0x0031:
            boolean r9 = r0.hasNext()
            if (r9 == 0) goto L_0x004a
            java.lang.Object r9 = r0.next()
            com.inshot.xplayer.content.MediaFileInfo r9 = (com.inshot.xplayer.content.MediaFileInfo) r9
            java.util.Set<java.lang.String> r10 = r15.f10874k
            java.lang.String r11 = r9.mo17890d()
            boolean r10 = r10.contains(r11)
            if (r10 == 0) goto L_0x0031
            goto L_0x004b
        L_0x004a:
            r9 = r7
        L_0x004b:
            if (r9 != 0) goto L_0x004e
            return
        L_0x004e:
            android.support.v4.app.FragmentActivity r0 = r15.getActivity()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r10 = 2131427459(0x7f0b0083, float:1.8476535E38)
            android.view.View r0 = r0.inflate(r10, r7, r8)
            r10 = 2131296979(0x7f0902d3, float:1.821189E38)
            android.view.View r10 = r0.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            java.lang.String r11 = r9.mo17892e()
            r10.setText(r11)
            r10 = 2131296978(0x7f0902d2, float:1.8211888E38)
            android.view.View r10 = r0.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            boolean r11 = r15.f10868e
            if (r11 == 0) goto L_0x0082
            r11 = 2131624316(0x7f0e017c, float:1.8875808E38)
            java.lang.String r11 = r15.getString(r11)
            goto L_0x008f
        L_0x0082:
            java.io.File r11 = new java.io.File
            java.lang.String r12 = r9.mo17890d()
            r11.<init>(r12)
            java.lang.String r11 = r11.getParent()
        L_0x008f:
            r10.setText(r11)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r11 = "%s (%s bytes)"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            long r12 = r9.f10496a
            java.lang.String r12 = p000.awt.m7196a((long) r12)
            r4[r8] = r12
            java.util.Locale r12 = java.util.Locale.US
            java.text.NumberFormat r12 = java.text.NumberFormat.getNumberInstance(r12)
            long r13 = r9.f10496a
            java.lang.String r12 = r12.format(r13)
            r4[r6] = r12
            java.lang.String r4 = java.lang.String.format(r10, r11, r4)
            r5.setText(r4)
            r4 = 2131296975(0x7f0902cf, float:1.8211882E38)
            android.view.View r4 = r0.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.text.DateFormat r5 = java.text.DateFormat.getDateInstance(r8)
            java.util.Date r6 = new java.util.Date
            long r10 = r9.mo17895h()
            r6.<init>(r10)
            java.lang.String r5 = r5.format(r6)
            r4.setText(r5)
            r4 = 2131296977(0x7f0902d1, float:1.8211886E38)
            android.view.View r4 = r0.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            long r5 = r9.mo17893f()
            java.lang.String r5 = p000.axy.m7459a((long) r5)
            r4.setText(r5)
            java.lang.String r4 = r9.mo17892e()
            java.lang.String r4 = p000.axe.m7324e(r4)
            r5 = 8
            if (r4 != 0) goto L_0x0103
            r4 = 2131296522(0x7f09010a, float:1.8210963E38)
            android.view.View r4 = r0.findViewById(r4)
            r4.setVisibility(r5)
            goto L_0x010f
        L_0x0103:
            r6 = 2131296976(0x7f0902d0, float:1.8211884E38)
            android.view.View r6 = r0.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r6.setText(r4)
        L_0x010f:
            java.lang.String r4 = r9.mo17890d()
            java.lang.String r4 = p000.axi.m7360c(r4)
            if (r4 != 0) goto L_0x0124
            r4 = 2131296750(0x7f0901ee, float:1.8211425E38)
            android.view.View r4 = r0.findViewById(r4)
            r4.setVisibility(r5)
            goto L_0x0130
        L_0x0124:
            r5 = 2131296980(0x7f0902d4, float:1.8211892E38)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r5.setText(r4)
        L_0x0130:
            android.content.Context r4 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            android.content.SharedPreferences r4 = p000.axn.getSharedPrefrence(r4)
            java.lang.String r5 = "darkTheme"
            boolean r4 = r4.getBoolean(r5, r8)
            if (r4 == 0) goto L_0x014a
            android.support.v7.app.AlertDialog$Builder r4 = new android.support.v7.app.AlertDialog$Builder
            android.support.v4.app.FragmentActivity r5 = r15.getActivity()
            r4.<init>(r5, r3)
            goto L_0x0153
        L_0x014a:
            android.support.v7.app.AlertDialog$Builder r4 = new android.support.v7.app.AlertDialog$Builder
            android.support.v4.app.FragmentActivity r3 = r15.getActivity()
            r4.<init>(r3)
        L_0x0153:
            android.support.v7.app.AlertDialog$Builder r2 = r4.setTitle((int) r2)
            android.support.v7.app.AlertDialog$Builder r0 = r2.setView((android.view.View) r0)
            android.support.v7.app.AlertDialog$Builder r0 = r0.setPositiveButton((int) r1, (android.content.DialogInterface.OnClickListener) r7)
            r0.show()
            goto L_0x021b
        L_0x0164:
            r9 = 0
            com.inshot.xplayer.content.a r0 = r15.f10867d
            if (r0 == 0) goto L_0x0194
            com.inshot.xplayer.content.a r0 = r15.f10867d
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r0 = r0.f10547c
            if (r0 == 0) goto L_0x0194
            com.inshot.xplayer.content.a r0 = r15.f10867d
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r0 = r0.f10547c
            java.util.Iterator r0 = r0.iterator()
        L_0x0178:
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x0194
            java.lang.Object r11 = r0.next()
            com.inshot.xplayer.content.MediaFileInfo r11 = (com.inshot.xplayer.content.MediaFileInfo) r11
            java.util.Set<java.lang.String> r12 = r15.f10874k
            java.lang.String r13 = r11.mo17890d()
            boolean r12 = r12.contains(r13)
            if (r12 == 0) goto L_0x0178
            long r11 = r11.f10496a
            long r9 = r9 + r11
            goto L_0x0178
        L_0x0194:
            android.support.v4.app.FragmentActivity r0 = r15.getActivity()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r11 = 2131427460(0x7f0b0084, float:1.8476537E38)
            android.view.View r0 = r0.inflate(r11, r7, r8)
            r11 = 2131296974(0x7f0902ce, float:1.821188E38)
            android.view.View r11 = r0.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r12 = 2131624260(0x7f0e0144, float:1.8875695E38)
            java.lang.Object[] r13 = new java.lang.Object[r6]
            java.util.Set<java.lang.String> r14 = r15.f10874k
            int r14 = r14.size()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r13[r8] = r14
            java.lang.String r12 = r15.getString(r12, r13)
            r11.setText(r12)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r12 = "%s (%s bytes)"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r13 = p000.awt.m7196a((long) r9)
            r4[r8] = r13
            java.util.Locale r13 = java.util.Locale.US
            java.text.NumberFormat r13 = java.text.NumberFormat.getNumberInstance(r13)
            java.lang.String r9 = r13.format(r9)
            r4[r6] = r9
            java.lang.String r4 = java.lang.String.format(r11, r12, r4)
            r5.setText(r4)
            android.content.Context r4 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            android.content.SharedPreferences r4 = p000.axn.getSharedPrefrence(r4)
            java.lang.String r5 = "darkTheme"
            boolean r4 = r4.getBoolean(r5, r8)
            if (r4 == 0) goto L_0x0203
            android.support.v7.app.AlertDialog$Builder r4 = new android.support.v7.app.AlertDialog$Builder
            android.support.v4.app.FragmentActivity r5 = r15.getActivity()
            r4.<init>(r5, r3)
            goto L_0x020c
        L_0x0203:
            android.support.v7.app.AlertDialog$Builder r4 = new android.support.v7.app.AlertDialog$Builder
            android.support.v4.app.FragmentActivity r3 = r15.getActivity()
            r4.<init>(r3)
        L_0x020c:
            android.support.v7.app.AlertDialog$Builder r2 = r4.setTitle((int) r2)
            android.support.v7.app.AlertDialog$Builder r0 = r2.setView((android.view.View) r0)
            android.support.v7.app.AlertDialog$Builder r0 = r0.setPositiveButton((int) r1, (android.content.DialogInterface.OnClickListener) r7)
            r0.show()
        L_0x021b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.fragments.C2729j.m12455o():void");
    }

    private void m12455o() {
        AlertDialog.Builder builder;
        MediaFileInfo mediaFileInfo = null;
        AlertDialog.Builder builder2;
        if (mo17989b()) {
            if (this.f10874k.size() == 1) {
                if (!(this.f10867d == null || this.f10867d.f10547c == null)) {
                    Iterator<MediaFileInfo> it = this.f10867d.f10547c.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        mediaFileInfo = it.next();
                        if (this.f10874k.contains(mediaFileInfo.mo17890d())) {
                            break;
                        }
                    }
                    if (mediaFileInfo != null) {
                        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_property, (ViewGroup) null, false);
                        ((TextView) inflate.findViewById(R.id.value_name)).setText(mediaFileInfo.mo17892e());
                        ((TextView) inflate.findViewById(R.id.value_location)).setText(this.f10868e ? getString(R.string.private_videos) : new File(mediaFileInfo.mo17890d()).getParent());
                        ((TextView) inflate.findViewById(R.id.value_size)).setText(String.format(Locale.ENGLISH, "%s (%s bytes)", awt.m7196a(mediaFileInfo.f10496a), NumberFormat.getNumberInstance(Locale.US).format(mediaFileInfo.f10496a)));
                        ((TextView) inflate.findViewById(R.id.value_date)).setText(DateFormat.getDateInstance(0).format(new Date(mediaFileInfo.mo17895h())));
                        ((TextView) inflate.findViewById(R.id.value_length)).setText(axy.m7459a(mediaFileInfo.mo17893f()));
                        String e2 = axe.m7324e(mediaFileInfo.mo17892e());
                        if (e2 == null) {
                            inflate.findViewById(R.id.format_layout).setVisibility(View.GONE);
                        } else {
                            ((TextView) inflate.findViewById(R.id.value_format)).setText(e2);
                        }
                        String c2 = axi.m7360c(mediaFileInfo.mo17890d());
                        if (c2 == null) {
                            inflate.findViewById(R.id.resolution_layout).setVisibility(View.GONE);
                        } else {
                            ((TextView) inflate.findViewById(R.id.value_resolution)).setText(c2);
                        }
                        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                            builder2 = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
                        } else {
                            builder2 = new AlertDialog.Builder(getActivity());
                        }
                        builder2.setTitle(R.string.properties).setView(inflate).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                    return;
                }
                mediaFileInfo = null;
                if (mediaFileInfo == null) {
                }
            } else {
                long j2 = 0;
                if (!(this.f10867d == null || this.f10867d.f10547c == null)) {
                    for (MediaFileInfo mediaFileInfo2 : this.f10867d.f10547c) {
                        if (this.f10874k.contains(mediaFileInfo2.mo17890d())) {
                            j2 += mediaFileInfo2.f10496a;
                        }
                    }
                }
                View inflate2 = LayoutInflater.from(getActivity()).inflate(R.layout.layout_property_mutil, (ViewGroup) null, false);
                ((TextView) inflate2.findViewById(R.id.value_contains)).setText(getString(R.string.n_videos, Integer.valueOf(this.f10874k.size())));
                ((TextView) inflate2.findViewById(R.id.value_size)).setText(String.format(Locale.ENGLISH, "%s (%s bytes)", awt.m7196a(j2), NumberFormat.getNumberInstance(Locale.US).format(j2)));
                if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                    builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
                } else {
                    builder = new AlertDialog.Builder(getActivity());
                }
                builder.setTitle(R.string.properties).setView(inflate2).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12421b(MediaFileInfo mediaFileInfo) {
        this.f10854E = new axb(mediaFileInfo.mo17890d(), mediaFileInfo, new axb.C1341a() {
            /* renamed from: a */
            public void mo10958a(String str, String str2, Object obj) {
                axb unused = VideoListPrivateVideoListFragment.this.f10854E = null;
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    VideoListPrivateVideoListFragment.this.m12458p();
                    if (!(VideoListPrivateVideoListFragment.this.f10867d == null || str == null || str2 == null || VideoListPrivateVideoListFragment.this.f10867d.f10547c == null)) {
                        for (MediaFileInfo next : VideoListPrivateVideoListFragment.this.f10867d.f10547c) {
                            String d = next.mo17890d();
                            if (d != null && d.equalsIgnoreCase(str)) {
                                d = str2;
                            }
                            next.mo17884a(d);
                            next.mo17888b(axy.m7460a(d));
                        }
                    }
                    EventBus.getDefault().post(new awl(str, str2, false));
                    if (VideoListPrivateVideoListFragment.this.f10864a != null) {
                        VideoListPrivateVideoListFragment.this.f10864a.notifyDataSetChanged();
                    }
                }
            }

            /* renamed from: a */
            public void mo10957a() {
                axb unused = VideoListPrivateVideoListFragment.this.f10854E = null;
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    VideoListPrivateVideoListFragment.this.m12458p();
                    axv.m7434a((int) R.string.rename_failed);
                }
            }

            /* renamed from: b */
            public void mo10959b() {
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    VideoListPrivateVideoListFragment.this.m12458p();
                    if (VideoListPrivateVideoListFragment.this.f10854E != null) {
                        VideoListPrivateVideoListFragment.this.f10854E.mo10943a((Fragment) VideoListPrivateVideoListFragment.this, 52131);
                    }
                }
            }

            /* renamed from: c */
            public void mo10960c() {
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    VideoListPrivateVideoListFragment.this.m12407a((int) R.string.rename, true);
                }
            }
        });
        this.f10854E.mo10944a((FragmentLifecycle) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12407a(int i, boolean z) {
        if (mo17989b()) {
            if (this.f10860K == null) {
                if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                    this.f10860K = new ProgressDialog(getActivity(), R.style.MyAlertStyle);
                } else {
                    this.f10860K = new ProgressDialog(getActivity());
                }
                this.f10860K.setCancelable(false);
                this.f10860K.setIndeterminate(true);
            }
            String string = getString(i);
            if (z) {
                string = string + "...";
            }
            this.f10860K.setMessage(string);
            this.f10860K.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m12458p() {
        if (this.f10860K != null) {
            this.f10860K.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12408a(View view, final MediaFileInfo mediaFileInfo) {
        this.f10858I = new PopupMenu(view.getContext(), view);
        this.f10858I.getMenuInflater().inflate(this.f10868e ? R.menu.menu_file_locked_item : R.menu.menu_file_item, this.f10858I.getMenu());
        this.f10858I.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (!VideoListPrivateVideoListFragment.this.mo17989b()) {
                    return true;
                }
                TreeMap treeMap = new TreeMap();
                treeMap.put("fileCount", String.valueOf(1));
                switch (menuItem.getItemId()) {
                    case R.id.delete /*2131296450*/:
                        LogEvents.m18487a(VideoListPrivateVideoListFragment.this.m12431d(), "Delete", (Map<String, String>) treeMap);
                        VideoListPrivateVideoListFragment.this.f10874k.clear();
                        VideoListPrivateVideoListFragment.this.f10874k.add(mediaFileInfo.mo17890d());
                        VideoListPrivateVideoListFragment.this.m12448k();
                        break;
                    case R.id.info /*2131296561*/:
                        LogEvents.m18487a(VideoListPrivateVideoListFragment.this.m12431d(), "Info", (Map<String, String>) treeMap);
                        VideoListPrivateVideoListFragment.this.f10874k.clear();
                        VideoListPrivateVideoListFragment.this.f10874k.add(mediaFileInfo.mo17890d());
                        VideoListPrivateVideoListFragment.this.m12455o();
                        break;
                    case R.id.lock /*2131296618*/:
                        LogEvents.m18487a(VideoListPrivateVideoListFragment.this.m12431d(), "Lock", (Map<String, String>) treeMap);
                        VideoListPrivateVideoListFragment.this.f10874k.clear();
                        VideoListPrivateVideoListFragment.this.f10874k.add(mediaFileInfo.mo17890d());
                        VideoListPrivateVideoListFragment.this.m12451m();
                        break;
                    case R.id.rename /*2131296746*/:
                        LogEvents.m18492b(VideoListPrivateVideoListFragment.this.m12431d(), "Rename");
                        VideoListPrivateVideoListFragment.this.m12421b(mediaFileInfo);
                        break;
                    case R.id.share /*2131296812*/:
                        LogEvents.m18487a(VideoListPrivateVideoListFragment.this.m12431d(), "Share", (Map<String, String>) treeMap);
                        axy.m7463a((Activity) VideoListPrivateVideoListFragment.this.getActivity(), mediaFileInfo.mo17890d(), "video/*");
                        break;
                    case R.id.unlock /*2131296968*/:
                        LogEvents.m18487a(VideoListPrivateVideoListFragment.this.m12431d(), "Unlock", (Map<String, String>) treeMap);
                        VideoListPrivateVideoListFragment.this.f10874k.clear();
                        VideoListPrivateVideoListFragment.this.f10874k.add(mediaFileInfo.mo17890d());
                        VideoListPrivateVideoListFragment.this.m12453n();
                        break;
                }
                return true;
            }
        });
        this.f10858I.show();
    }

    /* renamed from: q */
    private void m12459q() {
        AlertDialog.Builder builder;
        final awt.C1309a aVar = new awt.C1309a(Integer.valueOf(this.f10882s));
        final awt.C1309a aVar2 = new awt.C1309a(Integer.valueOf(this.f10883t ? 1 << this.f10882s : 0));
        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
            builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        AlertDialog show = builder.setTitle((int) R.string.sort_by).setView((int) R.layout.dialog_sort).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                    int unused = VideoListPrivateVideoListFragment.this.f10882s = ((Integer) aVar.f6151a).intValue();
                    VideoListPrivateVideoListFragment jVar = VideoListPrivateVideoListFragment.this;
                    boolean z = true;
                    if ((((Integer) aVar2.f6151a).intValue() & (1 << ((Integer) aVar.f6151a).intValue())) <= 0) {
                        z = false;
                    }
                    boolean unused2 = jVar.f10883t = z;
                    VideoListPrivateVideoListFragment.this.m12462r();

                    int a = VideoListPrivateVideoListFragment.this.f10883t ? 1 : 0;
                    axv.m7434a(aww.f6157c[VideoListPrivateVideoListFragment.this.f10882s][a]);
                    VideoListPrivateVideoListFragment.this.f10864a.notifyDataSetChanged();
                    PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt("sort_by", VideoListPrivateVideoListFragment.this.f10882s).apply();
                    PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putBoolean("sort_by_desc", VideoListPrivateVideoListFragment.this.f10883t).apply();
                }
            }
        }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        RadioGroup radioGroup = (RadioGroup) show.findViewById(R.id.sort_by);
        RadioGroup radioGroup2 = (RadioGroup) show.findViewById(R.id.sort_by_order);
        final RadioButton radioButton = (RadioButton) radioGroup2.findViewById(R.id.sort_by_asc);
        final RadioButton radioButton2 = (RadioButton) radioGroup2.findViewById(R.id.sort_by_desc);
        RadioGroup.OnCheckedChangeListener r11 = new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.sort_by_desc) {
                    aVar2.f6151a = Integer.valueOf((1 << ((Integer) aVar.f6151a).intValue()) | ((Integer) aVar2.f6151a).intValue());
                } else {
                    aVar2.f6151a = Integer.valueOf((~(1 << ((Integer) aVar.f6151a).intValue())) & ((Integer) aVar2.f6151a).intValue());
                }
            }
        };
        final awt.C1309a aVar3 = aVar;
        final RadioGroup radioGroup3 = radioGroup2;
        final RadioGroup.OnCheckedChangeListener r7 = r11;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int a = VideoListPrivateVideoListFragment.m12426c(i);
                radioButton.setText(aww.f6157c[a][0]);
                radioButton2.setText(aww.f6157c[a][1]);
                aVar3.f6151a = Integer.valueOf(a);
                radioGroup3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                radioGroup3.check((((Integer) aVar2.f6151a).intValue() & (1 << ((Integer) aVar3.f6151a).intValue())) > 0 ? R.id.sort_by_desc : R.id.sort_by_asc);
                radioGroup3.setOnCheckedChangeListener(r7);
            }
        });
        radioGroup2.setOnCheckedChangeListener(r11);
        radioGroup.check(m12418b(((Integer) aVar.f6151a).intValue()));
    }

    /* renamed from: b */
    private static int m12418b(int i) {
        return aww.f6156b[i];
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m12462r() {
        if (this.f10867d != null) {
            VideoManager.m12183a(this.f10867d.f10547c, this.f10882s, this.f10883t);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m12464s() {
        if (this.f10852C == null) {
            View view = getView();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                this.f10852C = LayoutInflater.from(getContext()).inflate((this.f10868e || this.f10856G) ? R.layout.empty_layout_black : R.layout.empty_layout, viewGroup, false);
                if (this.f10868e) {
                    ((TextView) this.f10852C.findViewById(R.id.empty_hint)).setText(R.string.empty_video_import);
                    viewGroup.addView(this.f10852C, viewGroup.getChildCount() - 1);
                } else {
                    if (this.f10856G) {
                        ((TextView) this.f10852C.findViewById(R.id.empty_hint)).setText(R.string.empty_video);
                    }
                    viewGroup.addView(this.f10852C);
                }
            }
        }
        if (this.f10852C != null && this.f10852C.getVisibility() != 0) {
            this.f10852C.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m12465t() {
        if (this.f10852C != null) {
            this.f10852C.setVisibility(8);
        }
    }

    @Override
    public void mo16860a(VideoListNativeAdLoader c2229ab) {

    }

    /* renamed from: a */
    public void mo16863b(VideoListNativeAdLoader abVar) {
        if (mo17989b() && !this.f10862M) {
            StaticAppAds.removeSelfListedAD(this.f10861L);
            this.f10861L = abVar != null ? abVar.mo16908g() : null;
            int i = -1;
            if (this.f10886w != null) {
                this.f10886w.mo10998a(this.f10861L != null ? this.f10863N : -1);
            }
            if (this.f10887x != null) {
                awu awu = this.f10887x;
                if (this.f10861L != null) {
                    i = this.f10863N;
                }
                awu.mo10894b(i);
            }
            if (this.f10870g && this.f10864a != null) {
                this.f10864a.notifyDataSetChanged();
                VideoListNativeAd.m10175e().mo16916c(abVar);
            }
        }
    }


    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: com.inshot.xplayer.fragments.j$c */
    private class C2751c extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public long f10942b;

        /* renamed from: c */
        private final SimpleDateFormat f10943c;

        /* renamed from: d */
        private final SimpleDateFormat f10944d;

        /* renamed from: e */
        private final SimpleDateFormat f10945e;

        private C2751c() {
            this.f10943c = new SimpleDateFormat("yyyy");
            this.f10944d = new SimpleDateFormat("MM-dd");
            this.f10945e = new SimpleDateFormat("yyyy-MM-dd");
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            int i2;
            switch (i) {
                case 1:
                    return new C2750b(LayoutInflater.from(viewGroup.getContext()).inflate(VideoListPrivateVideoListFragment.this.f10868e ? R.layout.item_video_grid_black : R.layout.item_video_grid, viewGroup, false));
                case 2:
                    return new C2750b(LayoutInflater.from(viewGroup.getContext()).inflate(VideoListPrivateVideoListFragment.this.f10868e ? R.layout.item_video_fulltitle_black : R.layout.item_video_fulltitle, viewGroup, false));
                case 3:
                    if (VideoListPrivateVideoListFragment.this.f10866c.getLayoutManager() instanceof GridLayoutManager) {
                        view = LayoutInflater.from(viewGroup.getContext()).inflate(VideoListPrivateVideoListFragment.this.f10868e ? R.layout.item_total_video_grid_info_black : R.layout.item_total_video_grid_info, viewGroup, false);
                    } else {
                        view = LayoutInflater.from(viewGroup.getContext()).inflate(VideoListPrivateVideoListFragment.this.f10868e ? R.layout.item_total_video_info_black : R.layout.item_total_video_info, viewGroup, false);
                    }
                    return new C2756d(view);
                case 4:
                    Context context = viewGroup.getContext();
                    if (VideoListPrivateVideoListFragment.this.f10868e) {
                        context = new ContextThemeWrapper(context, R.style.DarkTheme);
                    }
                    return new C2749a(LayoutInflater.from(context).inflate(R.layout.video_list_ad_container, viewGroup, false));
                default:
                    LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
                    if (VideoListPrivateVideoListFragment.this.f10868e) {
                        i2 = R.layout.item_video_black;
                    } else {
                        i2 = R.layout.item_video;
                    }
                    return new C2750b(from.inflate(i2, viewGroup, false));
            }
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int i2;
            int i3;
            int i4;
            VideoListPrivateVideoListFragment jVar;
            int i5;
            Object[] objArr;
            RecyclerView.ViewHolder viewHolder2 = viewHolder;
            int i6 = i;
            if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                C2751c cVar = null;
                boolean z = true;
                if (viewHolder2 instanceof C2756d) {
                    C2756d dVar = (C2756d) viewHolder2;
                    if (VideoListPrivateVideoListFragment.this.f10867d != null) {
                        TextView textView = dVar.f10952a;
                        if (VideoListPrivateVideoListFragment.this.f10867d.mo17924a() < 2) {
                            jVar = VideoListPrivateVideoListFragment.this;
                            i5 = R.string.n_video;
                            objArr = new Object[]{Integer.valueOf(VideoListPrivateVideoListFragment.this.f10867d.mo17924a())};
                        } else {
                            jVar = VideoListPrivateVideoListFragment.this;
                            i5 = R.string.n_videos;
                            objArr = new Object[]{Integer.valueOf(VideoListPrivateVideoListFragment.this.f10867d.mo17924a())};
                        }
                        textView.setText(jVar.getString(i5, objArr));
                        dVar.f10953b.setText(awt.m7196a(VideoListPrivateVideoListFragment.this.f10867d.mo17927c()));
                    }
                    if (VideoListPrivateVideoListFragment.this.f10871h) {
                        dVar.f10954c.setVisibility(0);
                        if (VideoListPrivateVideoListFragment.this.f10867d != null) {
                            dVar.f10954c.setTag(VideoListPrivateVideoListFragment.this.f10867d.f10547c);
                        }
                        dVar.f10954c.setOnCheckedChangeListener(this);
                        dVar.f10954c.setOnClickListener(this);
                        AppCompatCheckBox appCompatCheckBox = dVar.f10954c;
                        if (VideoListPrivateVideoListFragment.this.f10874k.size() != VideoListPrivateVideoListFragment.this.f10867d.f10547c.size()) {
                            z = false;
                        }
                        appCompatCheckBox.setChecked(z);
                    } else {
                        dVar.f10954c.setVisibility(8);
                        dVar.f10954c.setTag((Object) null);
                        dVar.f10954c.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                        dVar.f10954c.setOnClickListener((View.OnClickListener) null);
                    }
                    dVar.itemView.setOnClickListener(this);
                } else if (!(viewHolder2 instanceof C2749a)) {
                    if (VideoListPrivateVideoListFragment.this.f10861L != null && i6 > VideoListPrivateVideoListFragment.this.f10863N) {
                        i6--;
                    }
                    MediaFileInfo mediaFileInfo = VideoListPrivateVideoListFragment.this.f10867d.f10547c.get(i6 - 1);
                    C2750b bVar = (C2750b) viewHolder2;
                    bVar.f10930c.setText(mediaFileInfo.mo17892e());
                    bVar.f10929b.setText(mediaFileInfo.mo17894g());
                    if (VideoListPrivateVideoListFragment.this.f10879p == 1) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.f10928a.getLayoutParams();
                        i3 = VideoListPrivateVideoListFragment.this.f10884u;
                        layoutParams.width = i3;
                        i2 = (VideoListPrivateVideoListFragment.this.f10884u * 3) / 4;
                        layoutParams.height = i2;
                    } else {
                        i3 = -1;
                        i2 = -1;
                    }
                    if (VideoListPrivateVideoListFragment.this.f10871h) {
                        bVar.f10937j.setVisibility(View.GONE);
                        bVar.f10938k.setVisibility(View.GONE);
                        bVar.f10933f.setVisibility(View.VISIBLE);
                        bVar.f10935h.setVisibility(View.VISIBLE);
                        bVar.f10931d.setVisibility(View.GONE);
                        bVar.f10934g.setVisibility(View.GONE);
                        bVar.f10932e.setVisibility(View.GONE);
                        bVar.f10936i.setVisibility(View.INVISIBLE);
                        bVar.f10933f.setText(awt.m7196a(mediaFileInfo.f10496a));
                        bVar.f10935h.setOnCheckedChangeListener(this);
                        bVar.f10935h.setTag(mediaFileInfo.mo17890d());
                        bVar.f10935h.setChecked(VideoListPrivateVideoListFragment.this.f10874k.contains(mediaFileInfo.mo17890d()));
                        bVar.itemView.setTag(bVar.f10935h);
                        bVar.f10936i.setTag((Object) null);
                        bVar.f10936i.setOnClickListener((View.OnClickListener) null);
                        i4 = i3;
                    } else {
                        bVar.f10933f.setVisibility(View.GONE);
                        bVar.f10935h.setVisibility(View.GONE);
                        bVar.f10936i.setVisibility(View.VISIBLE);
                        if (VideoListPrivateVideoListFragment.this.f10882s == 1) {
                            bVar.f10938k.setVisibility(View.VISIBLE);
                            if (this.f10943c.format(new Date(mediaFileInfo.mo17895h())).equals(VideoListPrivateVideoListFragment.this.f10850A)) {
                                i4 = i3;
                                bVar.f10938k.setText(this.f10944d.format(new Date(mediaFileInfo.mo17895h())));
                            } else {
                                i4 = i3;
                                bVar.f10938k.setText(this.f10945e.format(new Date(mediaFileInfo.mo17895h())));
                            }
                        } else {
                            i4 = i3;
                            if (VideoListPrivateVideoListFragment.this.f10882s == 2) {
                                bVar.f10938k.setVisibility(0);
                                bVar.f10938k.setText(awt.m7196a(mediaFileInfo.f10496a));
                            } else if (VideoListPrivateVideoListFragment.this.f10882s == 3 && VideoListPrivateVideoListFragment.this.f10879p == 2) {
                                bVar.f10938k.setVisibility(0);
                                bVar.f10938k.setText(mediaFileInfo.mo17894g());
                            } else {
                                bVar.f10938k.setVisibility(8);
                            }
                        }
                        if (mediaFileInfo.mo17886b() > 0) {
                            if (VideoListPrivateVideoListFragment.this.f10879p == 1) {
                                bVar.f10931d.setVisibility(8);
                            } else {
                                bVar.f10931d.setVisibility(0);
                            }
                            bVar.f10934g.setVisibility(0);
                            bVar.f10932e.setVisibility(8);
                            int b = mediaFileInfo.mo17893f() == 0 ? 0 : (int) ((mediaFileInfo.mo17886b() * 100) / mediaFileInfo.mo17893f());
                            if (b < 0) {
                                b = 0;
                            }
                            if (b > 100) {
                                b = 100;
                            }
                            bVar.f10934g.setMax(100);
                            bVar.f10934g.setProgress(b);
                            bVar.f10931d.setText(String.format(Locale.ENGLISH, "%s%%", new Object[]{String.valueOf(b)}));
                        } else {
                            bVar.f10931d.setVisibility(View.GONE);
                            bVar.f10934g.setVisibility(View.GONE);
                            if (this.f10942b - mediaFileInfo.mo17895h() < 86400000) {
                                bVar.f10932e.setVisibility(View.VISIBLE);
                            } else {
                                bVar.f10932e.setVisibility(View.GONE);
                            }
                        }
                        bVar.f10935h.setTag((Object) null);
                        bVar.f10935h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                        bVar.itemView.setTag(mediaFileInfo);
                        bVar.f10936i.setTag(mediaFileInfo);
                        bVar.f10936i.setOnClickListener(this);
                        bVar.itemView.setOnClickListener(this);
                    }
                    if (!mediaFileInfo.mo17890d().equals(bVar.f10928a.getTag(bVar.f10928a.getId()))) {
                        bVar.f10928a.setTag(bVar.f10928a.getId(), mediaFileInfo.mo17890d());
                        if (VideoListPrivateVideoListFragment.this.getActivity() != null) {
                            BitmapRequestBuilder a = Glide.with(getActivity()).load(mediaFileInfo.mo17890d()).asBitmap()
                                    .centerCrop().skipMemoryCache(false).decoder((ResourceDecoder<ImageVideoWrapper, Bitmap>) new awy(mediaFileInfo.mo17890d(), VideoListPrivateVideoListFragment.this.getContext(), mediaFileInfo.mo17893f()));
                            int i7 = i4;
                            if (i7 != -1) {
                                a.into(i7, i2);
                            }
                            a.into(bVar.f10928a);
                        }
                    }
                    bVar.itemView.setOnClickListener(this);
                    View view = bVar.itemView;
                    if (!VideoListPrivateVideoListFragment.this.f10871h) {
                        cVar = this;
                    }
                    view.setOnLongClickListener(cVar);
                    if (VideoListPrivateVideoListFragment.this.m12443i() + 1 != i6) {
                        bVar.itemView.setBackgroundColor(0);
                    } else if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                        bVar.itemView.setBackgroundColor(Color.argb(25, 255, 255, 255));
                    } else {
                        bVar.itemView.setBackgroundColor(Color.argb(8, 0, 0, 0));
                    }
                } else if (!VideoListPrivateVideoListFragment.this.f10862M) {
                    ((C2749a) viewHolder2).m12498a(VideoListPrivateVideoListFragment.this.f10861L);
                }
            }
        }

        public int getItemViewType(int i) {
            if (i == 0) {
                return 3;
            }
            if (VideoListPrivateVideoListFragment.this.f10861L == null || i != VideoListPrivateVideoListFragment.this.f10863N) {
                return VideoListPrivateVideoListFragment.this.f10879p;
            }
            return 4;
        }

        public long getItemId(int i) {
            if (VideoListPrivateVideoListFragment.this.f10861L == null) {
                return (long) i;
            }
            if (i < VideoListPrivateVideoListFragment.this.f10863N) {
                return (long) i;
            }
            if (i > VideoListPrivateVideoListFragment.this.f10863N) {
                return (long) (i - 1);
            }
            return (long) (getItemCount() - 1);
        }

        public int getItemCount() {
            int size = ((VideoListPrivateVideoListFragment.this.f10867d == null || VideoListPrivateVideoListFragment.this.f10867d.f10547c == null) ? 0 : VideoListPrivateVideoListFragment.this.f10867d.f10547c.size()) + 1;
            return (VideoListPrivateVideoListFragment.this.f10861L == null || size < VideoListPrivateVideoListFragment.this.f10863N) ? size : size + 1;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            m12501a(recyclerView);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m12501a(RecyclerView recyclerView) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    public int getSpanSize(int i) {
                        if (i == 0) {
                            return gridLayoutManager.getSpanCount();
                        }
                        if (VideoListPrivateVideoListFragment.this.f10886w == null || i != VideoListPrivateVideoListFragment.this.f10886w.mo10997a()) {
                            return 1;
                        }
                        return gridLayoutManager.getSpanCount();
                    }
                });
            }
        }

        public void onClick(final View view) {
            if (VideoListPrivateVideoListFragment.this.mo17989b()) {
                if (view.getId() == R.id.close) {
                    LogEvents.m18492b(VideoListPrivateVideoListFragment.this.m12431d(), "CloseAd");
                    C2749a aVar = (C2749a) view.getTag();
                    if (aVar != null) {
                        aVar.f10926a.setVisibility(8);
                        aVar.f10926a.removeAllViews();
                        view.postDelayed(new Runnable() {
                            public void run() {
                                view.removeCallbacks(this);
                                View unused = VideoListPrivateVideoListFragment.this.f10861L = null;
                                if (VideoListPrivateVideoListFragment.this.f10870g && VideoListPrivateVideoListFragment.this.f10864a != null) {
                                    if (VideoListPrivateVideoListFragment.this.f10886w != null) {
                                        VideoListPrivateVideoListFragment.this.f10886w.mo10998a(-1);
                                    }
                                    if (VideoListPrivateVideoListFragment.this.f10887x != null) {
                                        VideoListPrivateVideoListFragment.this.f10887x.mo10894b(-1);
                                    }
                                    VideoListPrivateVideoListFragment.this.f10864a.notifyDataSetChanged();
                                }
                            }
                        }, 3000);
                    }
                    boolean unused = VideoListPrivateVideoListFragment.this.f10862M = true;
                    return;
                }
                MediaFileInfo unused2 = VideoListPrivateVideoListFragment.this.f10857H = null;
                VideoListPrivateVideoListFragment.this.f10864a.notifyDataSetChanged();
                if (view.getTag() instanceof MediaFileInfo) {
                    if (view.getId() == R.id.more) {
                        LogEvents.m18492b(VideoListPrivateVideoListFragment.this.m12431d(), "FileMore");
                        VideoListPrivateVideoListFragment.this.m12408a(view, (MediaFileInfo) view.getTag());
                        return;
                    }
                    LogEvents.m18492b(VideoListPrivateVideoListFragment.this.m12431d(), "Play");
                    MediaFileInfo mediaFileInfo = (MediaFileInfo) view.getTag();
                    boolean unused3 = VideoListPrivateVideoListFragment.this.f10878o = true;
                    boolean unused4 = VideoListPrivateVideoListFragment.this.f10876m = true;
                    ((FileExplorerActivity) VideoListPrivateVideoListFragment.this.getActivity()).mo17664a(VideoListPrivateVideoListFragment.this.f10867d, mediaFileInfo, VideoListPrivateVideoListFragment.this, VideoListPrivateVideoListFragment.this.f10868e ? 52130 : 0);
                } else if (view.getTag() instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) view.getTag();
                    checkBox.setChecked(!checkBox.isChecked());
                } else if ((view instanceof AppCompatCheckBox) && (view.getTag() instanceof List)) {
                    if (!((AppCompatCheckBox) view).isChecked()) {
                        VideoListPrivateVideoListFragment.this.f10874k.clear();
                        LogEvents.m18492b("VideoList", "unSelectAll");
                    } else {
                        List<MediaFileInfo> list = (List) view.getTag();
                        if (VideoListPrivateVideoListFragment.this.f10874k.size() > 0) {
                            VideoListPrivateVideoListFragment.this.f10874k.clear();
                        }
                        for (MediaFileInfo d : list) {
                            VideoListPrivateVideoListFragment.this.f10874k.add(d.mo17890d());
                        }
                        LogEvents.m18492b("VideoList", "selectAll");
                    }
                    VideoListPrivateVideoListFragment.this.f10866c.post(new Runnable() {
                        public void run() {
                            VideoListPrivateVideoListFragment.this.f10866c.removeCallbacks(this);
                            VideoListPrivateVideoListFragment.this.f10864a.notifyDataSetChanged();
                        }
                    });
                }
            }
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.getTag() instanceof String) {
                String str = (String) compoundButton.getTag();
                if (z) {
                    VideoListPrivateVideoListFragment.this.f10874k.add(str);
                } else {
                    VideoListPrivateVideoListFragment.this.f10874k.remove(str);
                }
                if (VideoListPrivateVideoListFragment.this.f10873j != null) {
                    VideoListPrivateVideoListFragment.this.f10873j.setTitle((CharSequence) VideoListPrivateVideoListFragment.this.getString(R.string.n_selected, Integer.valueOf(VideoListPrivateVideoListFragment.this.f10874k.size())));
                }
                if (VideoListPrivateVideoListFragment.this.f10867d.f10547c.size() <= VideoListPrivateVideoListFragment.this.f10874k.size() + 1) {
                    VideoListPrivateVideoListFragment.this.f10866c.post(new Runnable() {
                        public void run() {
                            VideoListPrivateVideoListFragment.this.f10866c.removeCallbacks(this);
                            VideoListPrivateVideoListFragment.this.f10864a.notifyDataSetChanged();
                        }
                    });
                }
            }
        }

        public boolean onLongClick(View view) {
            if (VideoListPrivateVideoListFragment.this.f10871h) {
                return false;
            }
            LogEvents.m18492b(VideoListPrivateVideoListFragment.this.m12431d(), "LongClick");
            String str = null;
            if (view.getTag() instanceof MediaFileInfo) {
                str = ((MediaFileInfo) view.getTag()).mo17890d();
            }
            VideoListPrivateVideoListFragment.this.m12414a(str);
            return true;
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.j$b */
    private class C2750b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final ImageView f10928a;

        /* renamed from: b */
        final TextView f10929b;

        /* renamed from: c */
        final TextView f10930c;

        /* renamed from: d */
        final TextView f10931d;

        /* renamed from: e */
        final View f10932e;

        /* renamed from: f */
        final TextView f10933f;

        /* renamed from: g */
        final ProgressBar f10934g;

        /* renamed from: h */
        final CheckBox f10935h;

        /* renamed from: i */
        final View f10936i;

        /* renamed from: j */
        final TextView f10937j;

        /* renamed from: k */
        final TextView f10938k;

        /* renamed from: l */
        final View f10939l;

        C2750b(View view) {
            super(view);
            this.f10928a = (ImageView) view.findViewById(R.id.icon);
            this.f10929b = (TextView) view.findViewById(R.id.duration);
            this.f10930c = (TextView) view.findViewById(R.id.name);
            this.f10931d = (TextView) view.findViewById(R.id.play_progress);
            this.f10932e = view.findViewById(R.id.ic_new);
            this.f10933f = (TextView) view.findViewById(R.id.video_size);
            this.f10934g = (ProgressBar) view.findViewById(R.id.play_seek);
            this.f10935h = (CheckBox) view.findViewById(R.id.checkbox);
            this.f10936i = view.findViewById(R.id.more);
            this.f10939l = view.findViewById(R.id.space);
            this.f10937j = (TextView) view.findViewById(R.id.video_resolution);
            this.f10938k = (TextView) view.findViewById(R.id.video_size_or_date);
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.j$d */
    private class C2756d extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final TextView f10952a;

        /* renamed from: b */
        final TextView f10953b;

        /* renamed from: c */
        final AppCompatCheckBox f10954c;

        C2756d(View view) {
            super(view);
            this.f10952a = (TextView) view.findViewById(R.id.video_count);
            this.f10953b = (TextView) view.findViewById(R.id.video_size);
            this.f10954c = (AppCompatCheckBox) view.findViewById(R.id.select_all);
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.j$a */
    private class C2749a extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final ViewGroup f10926a;

        C2749a(View view) {
            super(view);
            this.f10926a = (ViewGroup) view.findViewById(R.id.ad_container);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m12498a(View view) {
            if (this.f10926a != null && this.f10926a.getChildCount() == 0) {
                Views.removeFromParent(view);
                if (view != null) {
                    this.f10926a.addView(view);
                    VideoListNativeAdLoader.m10162a(view, VideoListPrivateVideoListFragment.this.f10856G || VideoListPrivateVideoListFragment.this.f10868e);
                }
            }
        }
    }
}
