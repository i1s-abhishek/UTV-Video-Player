package com.abhishek.xplayer.fragments;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.abhishek.xplayer.ad.FolderListNativeAdLoader;
import com.abhishek.xplayer.ad.FolderListNativeAd;
import com.abhishek.xplayer.ad.AppAbstractInterface;
import com.abhishek.xplayer.ad.StaticAppAds;
import com.abhishek.xplayer.purchase.PremiumUpgradeActivitys;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.abhishek.inplayer.bean.VideoPlayListBean;
import com.abhishek.xplayer.activities.EqualizerActivity;
import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.activities.PlayerActivity;
import com.abhishek.xplayer.application.AppActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.C2624a;
import com.abhishek.xplayer.content.C2625b;
import com.abhishek.xplayer.content.C2650e;
import com.abhishek.xplayer.content.VideoManager;
import com.abhishek.xplayer.content.MediaFileInfo;
import com.abhishek.xplayer.content.RecentMediaStorage;
import com.abhishek.xplayer.service.C2779a;
import com.abhishek.xplayer.service.StartPipPlayService;
import com.mopub.common.util.Views;
import com.mopub.mobileads.VastIconXmlManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
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
import classesdef.eventbus.awm;
import classesdef.eventbus.bnt;
import classesdef.eventbus.bnv;
import classesdef.inplayer.SharedPrefrence;
import classesdef.player.DefaultSharedPreferences;
import classesdef.xdplayer.PermissionHelper;
import classesdef.xdplayer.avt;
import classesdef.xdplayer.awl;
import classesdef.xdplayer.awy;
import classesdef.xdplayer.axa;
import classesdef.xdplayer.axb;
import classesdef.xdplayer.axe;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import classesdef.xdplayer.bpe;
import classesdef.xdplayer.bpj;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.activity.MainActivity;


public class VideoFolderFragment extends FragmentLifecycle implements SwipeRefreshLayout.OnRefreshListener, AppAbstractInterface<FolderListNativeAdLoader>, AppActivity.Toolbarinterface {


    public static boolean f10956a;


    private ProgressDialog progressDialog;


    public View view;


    private final int f10959C = 2;


    public VideoFolderAdapter f10960b;
    /* access modifiers changed from: private */

    public SwipeRefreshLayout swipeRefreshLayout;
    /* access modifiers changed from: private */

    public RecentMediaStorage.DBBean f10962d;
    /* access modifiers changed from: private */

    public List<C2624a> f10963e;
    /* access modifiers changed from: private */


    public boolean f10964f;
    /* access modifiers changed from: private */


    public boolean f10965g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ActionBar f10966h;
    /* access modifiers changed from: private */


    public Set<String> f10967i = new HashSet();
    /* access modifiers changed from: private */


    public byte f10968j = 0;


    private boolean f10969k;
    /* access modifiers changed from: private */


    public AtomicBoolean f10970l = new AtomicBoolean(false);
    /* access modifiers changed from: private */


    public axa f10971m;
    /* access modifiers changed from: private */


    public axb f10972n;
    /* access modifiers changed from: private */

    public C2625b f10973o;
    private avt f10974p;
    private View f10975q;
    private FileExplorerActivity.C2542a f10976r;
    private FileExplorerActivity.C2543b f10977s;
    private boolean f10978t;
    private View f10979u;
    private TextView f10980v;
    private AnimationDrawable animationDrawable;
    private PopupMenu popupMenu;
    public boolean f10983y;
    public List<MediaFileInfo> f10984z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        VideoManager.m12177a((Handler) new Handler(Looper.myLooper()) {
            public void handleMessage(Message message) {
                if (VideoFolderFragment.this.mo17989b()) {
                    switch (message.what) {
                        case 291:
                            if (message.obj instanceof List) {
                                List unused = VideoFolderFragment.this.f10963e = (List) message.obj;
                                if (message.arg1 == 1) {
                                    VideoManager.m12182a((List<C2624a>) VideoFolderFragment.this.f10963e);
                                }
                                if (VideoFolderFragment.this.f10964f && VideoFolderFragment.this.f10960b != null) {
                                    VideoFolderFragment.this.f10960b.notifyDataSetChanged();
                                    break;
                                }
                            }
                            break;
                        case 292:
                            if (message.obj instanceof Pair) {
                                List list = (List) ((Pair) message.obj).first;
                                C2624a aVar = (C2624a) ((Pair) message.obj).second;
                                if (VideoFolderFragment.this.f10963e == null || VideoFolderFragment.this.f10963e.isEmpty()) {
                                    List unused2 = VideoFolderFragment.this.f10963e = new ArrayList(list.size() + 1);
                                    VideoFolderFragment.this.f10963e.add(aVar);
                                    VideoFolderFragment.this.f10963e.addAll(list);
                                } else {
                                    if (((C2624a) VideoFolderFragment.this.f10963e.get(0)).f10548d) {
                                        VideoFolderFragment.this.f10963e.set(0, aVar);
                                    } else {
                                        VideoFolderFragment.this.f10963e.add(0, aVar);
                                    }
                                    VideoFolderFragment.this.f10963e.addAll(list);
                                }
                                if (VideoFolderFragment.this.f10964f && VideoFolderFragment.this.f10960b != null) {
                                    VideoFolderFragment.this.f10960b.notifyDataSetChanged();
                                    break;
                                }
                            }
                            break;
                        case 293:
                            //    Log.e("swipeRefresh_","one1false");
                            //    Log.e("swipeRefresh_","one1false"+String.valueOf(swipeRefreshLayout != null ));
                            // Log.e("swipeRefresh_","one1false"+String.valueOf(swipeRefreshLayout.isRefreshing()));
                            // Log.e("swipeRefresh","one1false"+String.valueOf());
                            if (VideoFolderFragment.this.swipeRefreshLayout != null && VideoFolderFragment.this.swipeRefreshLayout.isRefreshing()) {
                                Log.e("swipeRefresh", "one1false23");
                                VideoFolderFragment.this.swipeRefreshLayout.setRefreshing(false);
                            }
                            Log.e("swipeRefresh", "one1false2");
                            HideListFragment.f10725a.clear();
                            break;
                        case 294:
                            Log.e("swipeRefresh", "one1false1");
                            if (VideoFolderFragment.this.f10963e == null || VideoFolderFragment.this.f10963e.isEmpty()) {
                                List unused3 = VideoFolderFragment.this.f10963e = (List) message.obj;
                                if (!VideoFolderFragment.this.f10964f || VideoFolderFragment.this.f10960b == null) {
                                    if (VideoFolderFragment.this.f10963e != null && !VideoFolderFragment.this.f10963e.isEmpty()) {
                                        C2650e.m12160a(VideoFolderFragment.this.f10963e);
                                        break;
                                    }
                                } else {
                                    VideoFolderFragment.this.f10960b.notifyDataSetChanged();
                                    break;
                                }
                            }
                            break;
                    }
                    if (!VideoFolderFragment.this.f10983y && VideoFolderFragment.this.f10963e != null && !VideoFolderFragment.this.f10963e.isEmpty()) {
                        boolean unused4 = VideoFolderFragment.this.f10983y = true;
                        VideoFolderFragment.this.getActivity().invalidateOptionsMenu();
                        if (VideoFolderFragment.this.swipeRefreshLayout != null && VideoFolderFragment.this.swipeRefreshLayout.isRefreshing()) {
                            VideoFolderFragment.this.swipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }
            }
        });
        this.f10960b = new VideoFolderAdapter();
        if (this.f10963e == null) {
            this.f10963e = C2650e.m12159a();
            reloadVideoFolder(true);
        }
        EventBus.getDefault().register((Object) this);
        //  this.f10974p = new avv();
    }

    public void onStart() {
        super.onStart();
        LogEvents.m18498d("VideoFolder");
    }

    public void onResume() {
        int i;
        int a;
        FileExplorerActivity.fragmentName = "VideoFolder";
        super.onResume();
        m12538i();
        if (f10956a) {
            m12529d();
        }
        if (this.animationDrawable != null) {
            this.animationDrawable.start();
        }
        if (getActivity() instanceof AppActivity) {
            ((AppActivity) getActivity()).setToolbarInstance(this);
        }
        m12535g();
        if (this.f10969k) {
            this.f10969k = false;
            reloadVideoFolder(false);
        }
        if (!this.f10978t && this.f10970l.get() && this.swipeRefreshLayout != null) {
            this.swipeRefreshLayout.post(new Runnable() {
                public void run() {
                    if (VideoFolderFragment.this.swipeRefreshLayout != null && VideoFolderFragment.this.f10970l.get()) {
                        VideoFolderFragment.this.swipeRefreshLayout.setRefreshing(true);
                    }
                }
            });
        }
        if (!DefaultSharedPreferences.getAdRemoved("adRemoved", false)) {
            FolderListNativeAd.createRefrence().mo16926b();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FileExplorerActivity.C2543b r0 = new FileExplorerActivity.C2543b() {
        };
        this.f10977s = r0;
        this.f10976r = ((FileExplorerActivity) getActivity()).mo17661a((FileExplorerActivity.C2543b) r0);
        View inflate = layoutInflater.inflate(R.layout.fragment_list_refresh_folder, viewGroup, false);
        this.f10979u = inflate.findViewById(R.id.downloader_btn);
        this.f10980v = (TextView) inflate.findViewById(R.id.downloader_new);
        this.f10979u.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (VideoFolderFragment.this.mo17989b()) {
                    LogEvents.m18492b("VideoFolder", "Downloader");
                    Intent intent = new Intent(VideoFolderFragment.this.getActivity(), MainActivity.class);
                    intent.setFlags(131072);
                    VideoFolderFragment.this.startActivity(intent);
                    DefaultSharedPreferences.m7385a("CKl1Oy3w", false);
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getApplicationContext_(), 1, false));
        this.swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.SwipeRefreshLayout);
        this.swipeRefreshLayout.setEnabled(true);
        this.swipeRefreshLayout.setOnRefreshListener(this);
        this.swipeRefreshLayout.setColorSchemeResources(R.color.refresh_color_1, R.color.refresh_color_2, R.color.refresh_color_3);
        this.f10966h = ((AppCompatActivity) getActivity()).getSupportActionBar();
        this.f10966h.setDisplayHomeAsUpEnabled(false);
        this.f10966h.setDisplayShowHomeEnabled(false);
        this.f10966h.setHomeAsUpIndicator((int) R.drawable.ic_back);
        this.f10966h.setSubtitle((CharSequence) null);
        this.f10966h.setTitle((CharSequence) getString(R.string.app_name));
        this.f10983y = this.f10963e != null && !this.f10963e.isEmpty();
        setHasOptionsMenu(true);
        long unused = this.f10960b.f11016c = System.currentTimeMillis();
        this.f10964f = true;
        if (!DefaultSharedPreferences.getAdRemoved("adRemoved", false)) {
            Log.e("folderListAds", "adRemoved fail");
            FolderListNativeAd.createRefrence().mo16955a((AppAbstractInterface<FolderListNativeAdLoader>) this);
            FolderListNativeAdLoader folderListNativeAdLoader = FolderListNativeAd.createRefrence().mo16960f();
            Log.e("folderListAds", "one" + "one__" + String.valueOf(folderListNativeAdLoader != null));
            // Log.e("folderListAds","one"+"one__"+String.valueOf( folderListNativeAdLoader.mo16905d()));
            if (folderListNativeAdLoader != null && folderListNativeAdLoader.mo16905d()) {
                Log.e("folderListAds", "one");
                this.view = folderListNativeAdLoader.mo16953g();
                Log.e("folderListAds", "one__" + String.valueOf(view));
                FolderListNativeAd.createRefrence().mo16959c(folderListNativeAdLoader);
            }
            if (this.view == null) {
                Log.e("folderListAds", "two");
                this.view = StaticAppAds.create(MyApplication.getApplicationContext_(), (int) R.layout.folder_list_ad);
            }
        }
        m12524b(true);
        this.animationDrawable = ((FileExplorerActivity) getActivity()).adButtonAds(0);
        recyclerView.setAdapter(this.f10960b);
        this.f10975q = inflate;
        return inflate;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void temporarilyChangeTheme(awm awm) {
        if (!SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false) && awm.mo10861a()) {
            f10956a = true;
            SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("temp_dark", true).apply();
            SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("darkTheme", false).apply();
        }
    }


    private void m12529d() {
        f10956a = false;
        getActivity().setTheme(R.style.DarkTheme);
        ((FileExplorerActivity) getActivity()).mo17667b();
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) getActivity();
        FileExplorerActivity.loadFragmet(getActivity().getSupportFragmentManager(), new VideoFolderFragment(), false);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 51875) {
            if (this.f10973o != null) {
                this.f10973o.mo17931a(i2, intent);
            } else if (this.f10971m != null) {
                this.f10971m.mo10928a(i2, intent);
            } else if (this.f10972n != null) {
                this.f10972n.mo10942a(i2, intent);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_folder_list, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        boolean z = true;
        if (this.f10965g) {
            menu.setGroupVisible(R.id.group_normal, false);
            menu.setGroupVisible(R.id.group_select_mode, true);
        } else {
            menu.setGroupVisible(R.id.group_normal, true);
            menu.setGroupVisible(R.id.group_select_mode, false);
        }
        MenuItem findItem = menu.findItem(R.id.search);
        if (findItem != null) {
            if (this.f10965g || !this.f10983y) {
                z = false;
            }
            findItem.setVisible(z);
        }
        super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!mo17989b()) {
            return false;
        }
        C2624a aVar = null;
        switch (menuItem.getItemId()) {
            case 16908332:
                if (this.f10965g) {
                    m12537h();
                    break;
                }
                break;
            case R.id.delete /*2131296450*/:
                TreeMap treeMap = new TreeMap();
                treeMap.put("dirCount", String.valueOf(this.f10967i.size()));
                LogEvents.m18487a("VideoFolder", "Delete", (Map<String, String>) treeMap);
                if (!this.f10967i.isEmpty()) {
                    m12544l();
                }
                return true;
            case R.id.equalizer /*2131296493*/:
                LogEvents.m18492b("VideoFolder", "Equalizer");
                m12530e();
                break;
            case R.id.hide /*2131296536*/:
                TreeMap treeMap2 = new TreeMap();
                treeMap2.put("dirCount", String.valueOf(this.f10967i.size()));
                LogEvents.m18487a("VideoFolder", "Hide", (Map<String, String>) treeMap2);
                if (!this.f10967i.isEmpty()) {
                    m12540j();
                }
                return true;
            case R.id.lock /*2131296618*/:
                if (!Environment.isExternalStorageManager()) {
                    new AlertDialog.Builder(getActivity()).setTitle(R.string.allow).setMessage(R.string.manage_all_file_permission_description)
                            .setPositiveButton((int) R.string.open_setting, (DialogInterface.OnClickListener)
                                    (dialogInterface, i) -> PermissionHelper.manageAppFilesAccessPermission(requireActivity())).show();
                } else {
                    TreeMap treeMap3 = new TreeMap();
                    treeMap3.put("dirCount", String.valueOf(this.f10967i.size()));
                    LogEvents.m18487a("VideoFolder", "Lock", (Map<String, String>) treeMap3);
                    if (!this.f10967i.isEmpty()) {
                        m12548n();
                    }
                }
                return true;
            case R.id.private_videos /*2131296710*/:
                LogEvents.m18492b("VideoFolder", "TopPrivate");
                if (!Environment.isExternalStorageManager()) {
                    new AlertDialog.Builder(getActivity()).setTitle(R.string.allow).setMessage(R.string.manage_all_file_permission_description)
                            .setPositiveButton((int) R.string.open_setting, (DialogInterface.OnClickListener)
                                    (dialogInterface, i) -> PermissionHelper.manageAppFilesAccessPermission(requireActivity())).show();
                } else {
                    if (PasswordFragment.m12273a()) {
                        AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), PasswordFragment.m12270a(0), true);
                    } else {
                        this.f10968j = 1;
                        AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), PasswordFragment.m12270a(2), true);
                    }
                }
                return true;
            case R.id.refresh /*2131296734*/:
                if (this.swipeRefreshLayout != null) {
                    LogEvents.m18492b("VideoFolder", "TopRefresh");
                    //     this.swipeRefreshLayout.setRefreshing(true);
                    m12533f();
                    break;
                }
                break;
            case R.id.search /*2131296790*/:
                if (mo17989b()) {
                    SearchPageFragment gVar = new SearchPageFragment();
                    if (!(this.f10963e == null || this.f10963e.size() == 0)) {
                        aVar = this.f10963e.get(0);
                    }
                    gVar.mo18015a(aVar);
                    gVar.mo18016a(this.f10963e);
                    AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), gVar, true);
                    LogEvents.m18492b("VideoFolder", "VideoFolder/search");
                }
                return true;
            case R.id.select /*2131296807*/:
                LogEvents.m18492b("VideoFolder", "Select");
                folderSelect((String) null);
                return true;
            case R.id.setting /*2131296810*/:
                LogEvents.m18492b("VideoFolder", "Setting");
                AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), new SettingFragment(), true);
                return true;
            case R.id.remove_ad /*2131296749*/:
                LogEvents.m18492b("VideoFolder", "RemoveAd");
                startActivity(new Intent(getContext(), PremiumUpgradeActivitys.class));
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }


    private void m12530e() {
        startActivity(new Intent(getActivity(), EqualizerActivity.class));
    }

    public void onPause() {
        super.onPause();
        if (this.animationDrawable != null) {
            this.animationDrawable.stop();
        }
        if (getActivity() instanceof AppActivity) {
            ((AppActivity) getActivity()).setToolbarInstance((AppActivity.Toolbarinterface) null);
        }
        if (this.swipeRefreshLayout != null) {
            this.swipeRefreshLayout.setRefreshing(false);
            this.swipeRefreshLayout.destroyDrawingCache();
            this.swipeRefreshLayout.clearAnimation();
        }
    }

    public void onDestroyView() {
        if (getActivity() instanceof FileExplorerActivity) {
            ((FileExplorerActivity) getActivity()).mo17668b(this.f10977s);
            ((FileExplorerActivity) getActivity()).adButtonAds(8);
        }
        this.f10964f = false;
        this.swipeRefreshLayout = null;
        super.onDestroyView();
        C2650e.m12160a(this.f10963e);
        FolderListNativeAd.createRefrence().mo16958b((AppAbstractInterface<FolderListNativeAdLoader>) this);
        Views.removeFromParent(this.view);
        this.view = null;
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


    public boolean setToolbar() {
        if (!this.f10965g) {
            return false;
        }
        m12537h();
        return true;
    }

    public void onRefresh() {
        LogEvents.m18492b("VideoFolder", "Refresh");
        m12533f();
    }


    public void m12533f() {
        reloadVideoFolder(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnv bnv) {
        m12538i();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPinSet(awi awi) {
        if (mo17989b() && this.f10968j != 0 && getActivity() != null) {
            if (this.f10968j != 2) {
                AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), VideoListPrivateVideoListFragment.m12406a((C2624a) null, true), true);
            } else if (this.f10984z != null) {
                m12519a(this.f10984z);
                this.f10984z = null;
            }
            this.f10968j = 0;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefreshList(awj awj) {
        if (awj == null || awj.f6086a || !this.f10964f || this.swipeRefreshLayout == null) {
            this.f10969k = true;
            return;
        }
        this.swipeRefreshLayout.setRefreshing(true);
        m12535g();
        m12533f();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onThemeChangeApplied(Boolean bool) {
        if (this.f10975q != null) {
            if (f10956a && !bool.booleanValue()) {
                f10956a = bool.booleanValue();
            }
            this.f10974p.mo10824a(getActivity(), (ViewGroup) this.f10975q);
            ((FileExplorerActivity) getActivity()).mo17667b();
            getActivity().invalidateOptionsMenu();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDownloaderDeleteFile(bnt bnt) {
        if (bnt == null) {
            return;
        }
        if (bnt.f16004b == 2 || bnt.f16004b == 1) {
            onRefreshList(new awj());
        }
    }


    public void m12535g() {
        new Thread(new Runnable() {
            public void run() {
                final RecentMediaStorage.DBBean b = new RecentMediaStorage(MyApplication.getApplicationContext_()).mo17906b();
                MyApplication.myApplication().runnable((Runnable) new Runnable() {
                    public void run() {
                        RecentMediaStorage.DBBean unused = VideoFolderFragment.this.f10962d = b;
                        boolean z = false;
                        if (VideoFolderFragment.this.f10962d != null && !axe.m7319a(VideoFolderFragment.this.f10962d.f10529b, false)) {
                            RecentMediaStorage.DBBean unused2 = VideoFolderFragment.this.f10962d = null;
                        }
                        if (VideoFolderFragment.this.f10962d != null && HideListFragment.m12289a(axe.m7320b(VideoFolderFragment.this.f10962d.f10529b))) {
                            RecentMediaStorage.DBBean unused3 = VideoFolderFragment.this.f10962d = null;
                        }
                        boolean a = VideoFolderFragment.this.f10960b.f11015b;
                        VideoFolderAdapter c = VideoFolderFragment.this.f10960b;
                        if (VideoFolderFragment.this.f10962d != null && VideoFolderFragment.this.f10962d.f10533f < VideoFolderFragment.this.f10962d.f10534g) {
                            z = true;
                        }
                        c.f11015b = z;
                        if (a != VideoFolderFragment.this.f10960b.f11015b) {
                            VideoFolderFragment.this.f10960b.notifyDataSetChanged();
                        } else if (VideoFolderFragment.this.f10960b.f11015b) {
                            VideoFolderFragment.this.f10960b.notifyDataSetChanged();
                        }
                    }
                });
            }
        }).start();
    }


    private void reloadVideoFolder(boolean z) {
        this.f10978t = z && this.f10963e != null && !this.f10963e.isEmpty();
        this.f10970l.set(true);
        VideoManager.m12187a(z, true, this.f10970l);
    }

    /* access modifiers changed from: private */

    public void folderSelect(String str) {
        this.f10965g = true;
        this.f10967i.clear();
        if (str != null) {
            this.f10967i.add(str);
        }
        if (this.swipeRefreshLayout != null) {
            this.swipeRefreshLayout.setEnabled(false);
        }
        this.f10966h.setDisplayHomeAsUpEnabled(true);
        this.f10966h.setDisplayShowHomeEnabled(true);
        this.f10966h.setHomeAsUpIndicator((int) R.drawable.ic_close_round);
        this.f10966h.setTitle((CharSequence) getString(R.string.n_selected, Integer.valueOf(this.f10967i.size())));
        if (getActivity() != null) {
            ((FileExplorerActivity) getActivity()).adButtonAds(8);
            getActivity().invalidateOptionsMenu();
        }
        this.f10960b.notifyDataSetChanged();
    }


    public void m12537h() {
        this.f10965g = false;
        this.f10967i.clear();
        if (this.swipeRefreshLayout != null) {
            this.swipeRefreshLayout.setEnabled(true);
        }
        this.f10966h.setDisplayHomeAsUpEnabled(false);
        this.f10966h.setDisplayShowHomeEnabled(false);
        this.f10966h.setTitle((CharSequence) getString(R.string.app_name));
        if (getActivity() != null) {
            ((FileExplorerActivity) getActivity()).adButtonAds(0);
            getActivity().invalidateOptionsMenu();
        }
        this.f10960b.notifyDataSetChanged();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.popupMenu != null) {
            this.popupMenu.dismiss();
        }
    }


    private void m12524b(boolean z) {
        int i = 8;
        this.f10979u.setVisibility(z ? 0 : 8);
        TextView textView = this.f10980v;
        if (z) {
            i = 0;
        }
        textView.setVisibility(i);
    }


    private void m12538i() {
        int i;
        int i2;
        if (this.f10979u != null && this.f10980v != null) {
            int c = bpe.m18520a().mo23318c();
            String str = null;
            if (c > 0) {
                i2 = c < 10 ? 11 : c < 100 ? 9 : 7;
                str = String.valueOf(c);
                i = 20;
            } else if (bpj.m18578a(MyApplication.getApplicationContext_()).mo23406m() > 0) {
                i2 = -1;
                i = 16;
            } else if (DefaultSharedPreferences.getAdRemoved("CKl1Oy3w", true)) {
                i2 = 6;
                str = "New";
                i = 22;
            } else {
                i2 = -1;
                i = -1;
            }
            if (c == -1) {
                this.f10980v.setVisibility(8);
                return;
            }
            if (i2 != -1) {
                this.f10980v.setTextSize(1, (float) i2);
            }
            this.f10980v.setText(str);
            if (this.f10979u.getVisibility() == 0) {
                this.f10980v.setVisibility(0);
            }
            int a = axw.m7444a(MyApplication.getApplicationContext_(), (float) i);
            ViewGroup.LayoutParams layoutParams = this.f10980v.getLayoutParams();
            layoutParams.height = a;
            layoutParams.width = a;
            this.f10980v.setLayoutParams(layoutParams);
        }
    }


    public void m12540j() {
        AlertDialog.Builder builder;
        if (mo17989b()) {
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setTitle((int) R.string.hide_dialog_title).setMessage((int) R.string.hide_dialog_desc).setPositiveButton((int) R.string.hide, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("dirCount", String.valueOf(VideoFolderFragment.this.f10967i.size()));
                    LogEvents.m18487a("VideoFolder", "Hide/Yes", (Map<String, String>) treeMap);
                    dialogInterface.dismiss();
                    VideoFolderFragment.this.m12542k();
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }


    public void m12542k() {
        AlertDialog.Builder builder;
        if (mo17989b() && this.f10967i != null) {
            HideListFragment.m12286a(this.f10967i);
            if (this.f10963e != null) {
                Iterator<C2624a> it = this.f10963e.iterator();
                while (it.hasNext()) {
                    if (this.f10967i.contains(it.next().f10545a)) {
                        it.remove();
                    }
                }
            }
            if (this.f10964f && this.f10960b != null) {
                this.f10960b.notifyDataSetChanged();
            }
            m12535g();
            m12537h();
            if (this.swipeRefreshLayout != null) {
                this.swipeRefreshLayout.setRefreshing(true);
            }
            m12533f();
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setTitle((int) R.string.hide_success_title).setMessage((int) R.string.hide_success_desc).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
        }
    }


    public void m12544l() {
        AlertDialog.Builder builder;
        if (mo17989b()) {
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setTitle((int) R.string.delete_dialog_title).setMessage((int) R.string.delete_dialog_desc).setPositiveButton((int) R.string.delete, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("dirCount", String.valueOf(VideoFolderFragment.this.f10967i.size()));
                    LogEvents.m18487a("VideoFolder", "Delete/Yes", (Map<String, String>) treeMap);
                    dialogInterface.dismiss();
                    VideoFolderFragment.this.m12546m();
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }


    public void m12546m() {
        if (this.f10967i != null) {
            ArrayList arrayList = new ArrayList();
            if (this.f10963e != null) {
                for (C2624a next : this.f10963e) {
                    if (this.f10967i.contains(next.f10545a) && next.f10547c != null) {
                        for (MediaFileInfo d : next.f10547c) {
                            arrayList.add(d.mo17890d());
                        }
                    }
                }
            }
            this.f10971m = new axa(arrayList, new axa.C1330a() {
                /* renamed from: b */
                public void mo10939b() {
                    AlertDialog.Builder builder;
                    axa unused = VideoFolderFragment.this.f10971m = null;
                    if (VideoFolderFragment.this.mo17989b()) {
                        VideoFolderFragment.this.m12551o();
                        VideoFolderFragment.this.m12537h();
                        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                            builder = new AlertDialog.Builder(VideoFolderFragment.this.getActivity(), R.style.MyAlertStyle);
                        } else {
                            builder = new AlertDialog.Builder(VideoFolderFragment.this.getActivity());
                        }
                        builder.setTitle((int) R.string.delete_failed).setMessage((int) R.string.delete_failed_cant_write).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                    }
                }

                /* renamed from: a */
                public void mo10938a() {
                    axa unused = VideoFolderFragment.this.f10971m = null;
                    if (VideoFolderFragment.this.mo17989b()) {
                        VideoFolderFragment.this.m12551o();
                        if (VideoFolderFragment.this.f10963e != null) {
                            Iterator it = VideoFolderFragment.this.f10963e.iterator();
                            while (it.hasNext()) {
                                if (VideoFolderFragment.this.f10967i.contains(((C2624a) it.next()).f10545a)) {
                                    it.remove();
                                }
                            }
                        }
                        if (VideoFolderFragment.this.f10964f && VideoFolderFragment.this.f10960b != null) {
                            VideoFolderFragment.this.f10960b.notifyDataSetChanged();
                        }
                        VideoFolderFragment.this.m12535g();
                        VideoFolderFragment.this.m12537h();
                        if (VideoFolderFragment.this.swipeRefreshLayout != null) {
                            VideoFolderFragment.this.swipeRefreshLayout.setRefreshing(true);
                        }
                        VideoFolderFragment.this.m12533f();
                        axv.m7436a(VideoFolderFragment.this.getView(), (int) R.string.delete_success);
                    }
                }

                /* renamed from: c */
                public void mo10940c() {
                    if (VideoFolderFragment.this.mo17989b()) {
                        VideoFolderFragment.this.m12551o();
                        if (VideoFolderFragment.this.f10971m != null) {
                            VideoFolderFragment.this.f10971m.mo10929a((Fragment) VideoFolderFragment.this, 51875);
                        }
                    }
                }

                /* renamed from: d */
                public void mo10941d() {
                    if (VideoFolderFragment.this.mo17989b()) {
                        VideoFolderFragment.this.m12510a((int) R.string.delete, true);
                    }
                }
            });
            this.f10971m.mo10930a(true);
        }
    }


    public void m12548n() {
        AlertDialog.Builder builder;
        if (mo17989b()) {
            final ArrayList arrayList = new ArrayList();
            if (this.f10963e != null) {
                for (C2624a next : this.f10963e) {
                    if (this.f10967i.contains(next.f10545a) && next.f10547c != null) {
                        for (MediaFileInfo add : next.f10547c) {
                            arrayList.add(add);
                        }
                    }
                }
            }
            int size = arrayList.size();
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setTitle((CharSequence) getString(size > 1 ? R.string.lock_videos_title : R.string.lock_video_title, Integer.valueOf(arrayList.size()))).setMessage((CharSequence) getString(R.string.lock_video_desc).concat(" ").concat(getString(R.string.lock_video_desc2))).setPositiveButton((int) R.string.lock, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (VideoFolderFragment.this.mo17989b()) {
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("dirCount", String.valueOf(VideoFolderFragment.this.f10967i.size()));
                        LogEvents.m18487a("VideoFolder", "Lock/Yes", (Map<String, String>) treeMap);
                        dialogInterface.dismiss();
                        if (PasswordFragment.m12273a()) {
                            VideoFolderFragment.this.m12519a((List<MediaFileInfo>) arrayList);
                            return;
                        }
                        byte unused = VideoFolderFragment.this.f10968j = (byte) 2;
                        List unused2 = VideoFolderFragment.this.f10984z = arrayList;
                        AppActivity.loadFragmet(VideoFolderFragment.this.getActivity().getSupportFragmentManager(), PasswordFragment.m12270a(2), true);
                    }
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }


    public void m12519a(List<MediaFileInfo> list) {
        this.f10973o = new C2625b();
        this.f10973o.mo17933a(list, (C2625b.C2630d) new C2625b.C2630d() {
            /* renamed from: a */
            public void mo17939a(Set<String> set, int i, int i2, String str, boolean z) {
                String str2;
                AlertDialog.Builder builder;
                C2625b unused = VideoFolderFragment.this.f10973o = null;
                if (VideoFolderFragment.this.mo17989b()) {
                    VideoFolderFragment.this.m12551o();
                    HashSet hashSet = new HashSet();
                    for (String b : set) {
                        String b2 = axe.m7320b(b);
                        if (b2 != null) {
                            hashSet.add(b2);
                        }
                    }
                    if (VideoFolderFragment.this.f10963e != null) {
                        Iterator it = VideoFolderFragment.this.f10963e.iterator();
                        while (it.hasNext()) {
                            if (hashSet.contains(((C2624a) it.next()).f10545a)) {
                                it.remove();
                            }
                        }
                    }
                    if (VideoFolderFragment.this.f10964f && VideoFolderFragment.this.f10960b != null) {
                        VideoFolderFragment.this.f10960b.notifyDataSetChanged();
                    }
                    VideoFolderFragment.this.m12535g();
                    VideoFolderFragment.this.m12537h();
                    if (VideoFolderFragment.this.swipeRefreshLayout != null) {
                        VideoFolderFragment.this.swipeRefreshLayout.setRefreshing(true);
                    }
                    VideoFolderFragment.this.m12533f();
                    if (i2 > 0) {
                        str2 = VideoFolderFragment.this.getString(R.string.lock_video_success_failed, Integer.valueOf(i), Integer.valueOf(i2));
                    } else {
                        str2 = VideoFolderFragment.this.getString(R.string.lock_video_success, Integer.valueOf(i)) + " " + VideoFolderFragment.this.getString(R.string.lock_video_success_desc);
                    }
                    if (!z) {
                        if (str != null) {
                            str2 = str2 + "\n" + str;
                        }
                        axv.m7438a(VideoFolderFragment.this.getView(), str2);
                        return;
                    }
                    if (str != null) {
                        str2 = str2 + "\n\n" + str;
                    }
                    if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                        builder = new AlertDialog.Builder(VideoFolderFragment.this.getActivity(), R.style.MyAlertStyle);
                    } else {
                        builder = new AlertDialog.Builder(VideoFolderFragment.this.getActivity());
                    }
                    builder.setMessage((CharSequence) str2).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                }
            }

            public void mo17938a(String str) {
                AlertDialog.Builder builder;
                C2625b unused = VideoFolderFragment.this.f10973o = null;
                if (VideoFolderFragment.this.mo17989b()) {
                    if (str != null) {
                        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                            builder = new AlertDialog.Builder(VideoFolderFragment.this.getActivity(), R.style.MyAlertStyle);
                        } else {
                            builder = new AlertDialog.Builder(VideoFolderFragment.this.getActivity());
                        }
                        builder.setTitle((CharSequence) VideoFolderFragment.this.getString(R.string.lock_failed)).setMessage((CharSequence) str).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                    } else {
                        axv.m7434a((int) R.string.lock_failed);
                    }
                    VideoFolderFragment.this.m12551o();
                }
            }

            public void mo17937a() {
                if (VideoFolderFragment.this.mo17989b()) {
                    VideoFolderFragment.this.m12510a((int) R.string.lock, true);
                }
            }

            public void mo17943c(String str) {
                if (VideoFolderFragment.this.mo17989b()) {
                    VideoFolderFragment.this.m12551o();
                    if (VideoFolderFragment.this.f10973o != null) {
                        VideoFolderFragment.this.f10973o.mo17932a((Fragment) VideoFolderFragment.this, 51875);
                    }
                }
            }
        });
    }


    public void m12513a(C2624a aVar) {
        this.f10972n = new axb(aVar.f10545a, aVar, new axb.C1341a() {
            /* renamed from: a */
            public void mo10958a(String str, String str2, Object obj) {
                String str3;
                axb unused = VideoFolderFragment.this.f10972n = null;
                if (VideoFolderFragment.this.mo17989b()) {
                    VideoFolderFragment.this.m12551o();
                    if (!(VideoFolderFragment.this.f10963e == null || str == null || str2 == null)) {
                        if (str.endsWith("/")) {
                            str3 = str;
                        } else {
                            str3 = str + "/";
                        }
                        for (C2624a aVar : VideoFolderFragment.this.f10963e) {
                            if (!(aVar == null || aVar.f10545a == null)) {
                                if (aVar.f10545a.equals(str)) {
                                    aVar.f10545a = str2;
                                    aVar.f10546b = axy.m7460a(str2);
                                } else if (aVar.f10545a.startsWith(str3)) {
                                    aVar.f10545a = str2 + aVar.f10545a.substring(str.length());
                                }
                                VideoManager.m12181a(aVar.f10545a, false);
                                if (aVar.f10547c != null) {
                                    for (MediaFileInfo next : aVar.f10547c) {
                                        String d = next.mo17890d();
                                        if (d != null && d.startsWith(str)) {
                                            d = str2 + d.substring(str.length());
                                        }
                                        next.mo17884a(d);
                                        next.mo17888b(axy.m7460a(d));
                                    }
                                }
                            }
                        }
                    }
                    HideListFragment.f10725a.put(str, str2);
                    EventBus.getDefault().post(new awl(str, str2, true));
                    if (VideoFolderFragment.this.f10960b != null) {
                        VideoFolderFragment.this.f10960b.notifyDataSetChanged();
                    }
                }
            }

            public void mo10957a() {
                axb unused = VideoFolderFragment.this.f10972n = null;
                if (VideoFolderFragment.this.mo17989b()) {
                    VideoFolderFragment.this.m12551o();
                    axv.m7434a((int) R.string.rename_failed);
                }
            }

            public void mo10959b() {
                if (VideoFolderFragment.this.mo17989b()) {
                    VideoFolderFragment.this.m12551o();
                    if (VideoFolderFragment.this.f10972n != null) {
                        VideoFolderFragment.this.f10972n.mo10943a((Fragment) VideoFolderFragment.this, 51875);
                    }
                }
            }

            public void mo10960c() {
                if (VideoFolderFragment.this.mo17989b()) {
                    VideoFolderFragment.this.m12510a((int) R.string.rename, true);
                }
            }
        });
        this.f10972n.mo10944a((FragmentLifecycle) this);
    }


    public void m12510a(int i, boolean z) {
        if (mo17989b()) {
            if (this.progressDialog == null) {
                if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                    this.progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertStyle);
                } else {
                    this.progressDialog = new ProgressDialog(getActivity());
                }
                this.progressDialog.setCancelable(false);
                this.progressDialog.setIndeterminate(true);
            }
            String string = getString(i);
            if (z) {
                string = string + "...";
            }
            this.progressDialog.setMessage(string);
            this.progressDialog.show();
        }
    }


    public void m12551o() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
        }
    }


    public void m12511a(View view, final C2624a aVar) {
        this.popupMenu = new PopupMenu(view.getContext(), view);
        this.popupMenu.getMenuInflater().inflate(R.menu.menu_folder_item, this.popupMenu.getMenu());
        this.popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (!VideoFolderFragment.this.mo17989b()) {
                    return true;
                }
                TreeMap treeMap = new TreeMap();
                treeMap.put("dirCount", String.valueOf(1));
                switch (menuItem.getItemId()) {
                    case R.id.delete /*2131296450*/:
                        LogEvents.m18487a("VideoFolder", "Delete", (Map<String, String>) treeMap);
                        VideoFolderFragment.this.f10967i.clear();
                        VideoFolderFragment.this.f10967i.add(aVar.f10545a);
                        VideoFolderFragment.this.m12544l();
                        break;
                    case R.id.hide /*2131296536*/:
                        LogEvents.m18487a("VideoFolder", "Hide", (Map<String, String>) treeMap);
                        VideoFolderFragment.this.f10967i.clear();
                        VideoFolderFragment.this.f10967i.add(aVar.f10545a);
                        VideoFolderFragment.this.m12540j();
                        break;
                    case R.id.lock /*2131296618*/:
                        LogEvents.m18487a("VideoFolder", "Lock", (Map<String, String>) treeMap);
                        VideoFolderFragment.this.f10967i.clear();
                        VideoFolderFragment.this.f10967i.add(aVar.f10545a);
                        VideoFolderFragment.this.m12548n();
                        break;
                    case R.id.rename /*2131296746*/:
                        LogEvents.m18492b("VideoFolder", "Rename");
                        VideoFolderFragment.this.m12513a(aVar);
                        break;
                    case R.id.shuffle_play /*2131296821*/:
                        LogEvents.m18487a("VideoFolder", "Shuffle", (Map<String, String>) treeMap);
                        int a = aVar.mo17924a();
                        if (a > 0) {
                            ArrayList arrayList = new ArrayList(a);
                            for (MediaFileInfo next : aVar.f10547c) {
                                VideoPlayListBean videoPlayListBean = new VideoPlayListBean();
                                videoPlayListBean.f9813a = next.mo17890d();
                                videoPlayListBean.f9815c = next.mo17892e();
                                videoPlayListBean.f9814b = next.mo17893f();
                                videoPlayListBean.f9816d = next.mo17886b();
                                videoPlayListBean.f9818f = next.mo17880a() == null ? null : next.mo17880a().f10535h;
                                videoPlayListBean.f9817e = next.f10497b;
                                videoPlayListBean.f9819g = next.mo17880a() == null ? -1 : next.mo17880a().f10528a;
                                arrayList.add(videoPlayListBean);
                            }
                            StartPipPlayService.m12716a().mo18174d();
                            C2779a.m12613a().mo18131a(VideoFolderFragment.this.getActivity(), arrayList, aVar.f10546b, true);
                            break;
                        }
                        break;
                }
                return true;
            }
        });
        this.popupMenu.show();
    }

    @Override
    public void mo16860a(FolderListNativeAdLoader c2241i) {

    }

    public void mo16863b(FolderListNativeAdLoader iVar) {
        if (mo17989b() && !DefaultSharedPreferences.getAdRemoved("adRemoved", false)) {
            StaticAppAds.removeSelfListedAD(this.view);
            this.view = iVar != null ? iVar.mo16953g() : null;
            if (this.f10964f && this.f10960b != null) {
                this.f10960b.notifyDataSetChanged();
                FolderListNativeAd.createRefrence().mo16959c(iVar);
            }
        }
    }


    private class VideoFolderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener {

        public boolean f11015b;

        public long f11016c;

        VideoFolderAdapter() {
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                    return new DirectoryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bottom_button, viewGroup, false));
                case 2:
                    return new ItemRecentVideoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recent_video, viewGroup, false));
                case 3:
                    return new FolderListAdContainerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.folder_list_ad_container, viewGroup, false));
                default:
                    return new ItemfolderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_folder, viewGroup, false));
            }
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            VideoFolderFragment kVar;
            int i2;
            if (viewHolder instanceof DirectoryViewHolder) {
                ((DirectoryViewHolder) viewHolder).directory_btn.setOnClickListener(this);
            } else if (viewHolder instanceof ItemRecentVideoViewHolder) {
                ItemRecentVideoViewHolder eVar = (ItemRecentVideoViewHolder) viewHolder;
                if (VideoFolderFragment.this.f10962d != null) {
                    eVar.name.setText(axy.m7460a(VideoFolderFragment.this.f10962d.f10529b));
                    eVar.time.setText(String.format(Locale.ENGLISH, "%s / %s", new Object[]{axy.m7459a(VideoFolderFragment.this.f10962d.f10533f), axy.m7459a(VideoFolderFragment.this.f10962d.f10534g)}));
                    Glide.with(getActivity()).load(VideoFolderFragment.this.f10962d.f10529b).asBitmap().centerCrop().decoder((ResourceDecoder<ImageVideoWrapper, Bitmap>) new awy(VideoFolderFragment.this.f10962d.f10529b, VideoFolderFragment.this.getContext(), VideoFolderFragment.this.f10962d.f10534g)).into(eVar.icon);
                }
                eVar.f11021c.setTag(VideoFolderFragment.this.f10962d);
                eVar.f11021c.setOnClickListener(this);
            } else if (viewHolder instanceof FolderListAdContainerViewHolder) {
                //Toast.makeText(getContext(), "AddView", Toast.LENGTH_SHORT).show();
                ((FolderListAdContainerViewHolder) viewHolder).addView(VideoFolderFragment.this.view);
            } else {
                if (VideoFolderFragment.this.view != null && i > 2) {
                    i--;
                }
                ItemfolderViewHolder cVar = (ItemfolderViewHolder) viewHolder;
                List a = VideoFolderFragment.this.f10963e;
                if (this.f11015b) {
                    i--;
                }
                C2624a aVar = (C2624a) a.get(i);
                cVar.f11012g.setImageResource(aVar.mo17926b() ? R.mipmap.ic_folder_sd : R.mipmap.ic_folder);
                VideoFolderAdapter dVar = null;
                if (VideoFolderFragment.this.f10965g) {
                    cVar.f11009d.setVisibility(4);
                    cVar.f11008c.setVisibility(0);
                    cVar.f11008c.setOnCheckedChangeListener(this);
                    cVar.f11008c.setTag(aVar.f10545a);
                    cVar.f11008c.setChecked(VideoFolderFragment.this.f10967i.contains(aVar.f10545a));
                    cVar.f11010e.setTag(cVar.f11008c);
                    cVar.f11009d.setTag((Object) null);
                    cVar.f11009d.setOnClickListener((View.OnClickListener) null);
                } else {
                    cVar.f11009d.setVisibility(0);
                    cVar.f11008c.setVisibility(8);
                    cVar.f11008c.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                    cVar.f11008c.setTag((Object) null);
                    cVar.f11010e.setTag(aVar);
                    cVar.f11009d.setTag(aVar);
                    cVar.f11009d.setOnClickListener(this);
                }
                cVar.f11007b.setVisibility(0);
                if (aVar.f10548d) {
                    cVar.f11006a.setText(R.string.recent_added);
                } else {
                    cVar.f11006a.setText(aVar.f10546b);
                }
                cVar.f11007b.setText(VideoFolderFragment.this.getString(aVar.mo17924a() < 1 ? R.string.n_video : R.string.n_videos, Integer.valueOf(aVar.mo17924a())));
                if (aVar.f10548d) {
                    cVar.f11006a.setPadding(cVar.f11006a.getPaddingLeft(), cVar.f11006a.getPaddingTop(), 0, cVar.f11006a.getPaddingBottom());
                    if (aVar.f10549e > 0) {
                        TextView textView = cVar.f11007b;
                        Locale locale = Locale.ENGLISH;
                        StringBuilder sb = new StringBuilder();
                        sb.append("%s ");
                        if (aVar.f10549e == 1) {
                            kVar = VideoFolderFragment.this;
                            i2 = R.string.add_video;
                        } else {
                            kVar = VideoFolderFragment.this;
                            i2 = R.string.add_videos;
                        }
                        sb.append(kVar.getString(i2));
                        textView.setText(String.format(locale, sb.toString(), new Object[]{Integer.valueOf(aVar.f10549e)}));
                    } else {
                        aVar.f10549e = 0;
                    }
                    if (VideoFolderFragment.this.f10965g) {
                        cVar.f11010e.setTag((Object) null);
                    }
                    cVar.f11009d.setVisibility(View.GONE);
                    cVar.f11008c.setVisibility(View.GONE);
                    cVar.f11011f.setVisibility(View.GONE);
                } else if (this.f11016c - aVar.mo17928d() > 86400000) {
                    cVar.f11011f.setVisibility(View.GONE);
                } else {
                    cVar.f11011f.setVisibility(View.VISIBLE);
                }
                cVar.f11010e.setOnClickListener(this);
                View view = cVar.f11010e;
                if (!VideoFolderFragment.this.f10965g) {
                    dVar = this;
                }
                view.setOnLongClickListener(dVar);
            }
        }

        public int getItemViewType(int i) {
            if (i == getItemCount() - 1) {
                return 1;
            }
            if (VideoFolderFragment.this.view != null) {
                if (i == 2) {
                    return 3;
                }
                if (i > 2) {
                    i--;
                }
            }
            if (!this.f11015b || i != 0) {
                return 0;
            }
            return 2;
        }

        public long getItemId(int i) {
            if (VideoFolderFragment.this.view == null) {
                return (long) i;
            }
            if (i < 2) {
                return (long) i;
            }
            if (i > 2) {
                return (long) (i - 1);
            }
            return (long) (getItemCount() - 1);
        }

        public int getItemCount() {
            int size = (VideoFolderFragment.this.f10963e != null ? VideoFolderFragment.this.f10963e.size() : 0) + 1;
            if (this.f11015b) {
                size++;
            }
            return (size <= 2 || VideoFolderFragment.this.view == null || size < 2) ? size : size + 1;
        }

        public void onClick(View view) {
            if (VideoFolderFragment.this.mo17989b()) {
                if (view.getTag() instanceof C2624a) {
                    final C2624a aVar = (C2624a) view.getTag();
                    if (view.getId() == R.id.more) {
                        LogEvents.m18492b("VideoFolder", "FolderMore");
                        VideoFolderFragment.this.m12511a(view, aVar);
                        return;
                    }
                    if (aVar.f10548d) {
                        aVar.f10549e = 0;
                        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putLong("clickRecentTime", System.currentTimeMillis()).apply();
                        LogEvents.m18492b("VideoFolder", "RecentAdded");
                    }
                    ((FileExplorerActivity) VideoFolderFragment.this.getActivity()).mo17663a(aVar);
                    MyApplication.myApplication().runnableDelay((Runnable) new Runnable() {
                        public void run() {
                            if (VideoFolderFragment.this.mo17989b()) {
                                aVar.mo17929e();
                            }
                        }
                    }, 200);
                } else if (view.getTag() instanceof RecentMediaStorage.DBBean) {
                    VideoFolderFragment.this.recentVideoPlay((RecentMediaStorage.DBBean) view.getTag());
                } else if (view.getTag() instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) view.getTag();
                    checkBox.setChecked(!checkBox.isChecked());
                } else if (view.getId() == R.id.directory_btn) {
                    LogEvents.m18492b("VideoFolder", "Directory");
                    AppActivity.loadFragmet(VideoFolderFragment.this.getActivity().getSupportFragmentManager(), new StorageChooserPageFragment(), true);
                }
            }
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.getTag() instanceof String) {
                String str = (String) compoundButton.getTag();
                if (z) {
                    VideoFolderFragment.this.f10967i.add(str);
                } else {
                    VideoFolderFragment.this.f10967i.remove(str);
                }
                if (VideoFolderFragment.this.f10966h != null) {
                    VideoFolderFragment.this.f10966h.setTitle((CharSequence) VideoFolderFragment.this.getString(R.string.n_selected, Integer.valueOf(VideoFolderFragment.this.f10967i.size())));
                }
            }
        }

        public boolean onLongClick(View view) {
            if (VideoFolderFragment.this.f10965g) {
                return false;
            }
            LogEvents.m18492b("VideoFolder", "LongClick");
            String str = null;
            if (view.getTag() instanceof C2624a) {
                str = ((C2624a) view.getTag()).f10545a;
            }
            VideoFolderFragment.this.folderSelect(str);
            return true;
        }
    }


    public void recentVideoPlay(RecentMediaStorage.DBBean dBBean) {
        C2624a aVar;
        LogEvents.m18492b("VideoFolder", "Recent");
        String str = dBBean.f10529b;
        long j = dBBean.f10533f;
        Intent intent = new Intent();
        intent.setClass(getActivity(), PlayerActivity.class);
        intent.putExtra("path", str);
        intent.putExtra("name", axy.m7460a(str));
        intent.putExtra("dbBean", dBBean);
        if (this.f10963e != null) {
            String b = axe.m7320b(str);
            Iterator<C2624a> it = this.f10963e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = it.next();
                if (aVar != null && b.equalsIgnoreCase(aVar.f10545a) && aVar.mo17924a() > 0 && !aVar.f10548d) {
                    break;
                }
            }
            if (aVar != null && aVar.mo17924a() > 0) {
                VideoManager.m12183a(aVar.f10547c, PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("sort_by", 0), PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean("sort_by_desc", false));
                ArrayList arrayList = new ArrayList(aVar.mo17924a());
                for (MediaFileInfo next : aVar.f10547c) {
                    if (next != null) {
                        VideoPlayListBean videoPlayListBean = new VideoPlayListBean();
                        videoPlayListBean.f9813a = next.mo17890d();
                        videoPlayListBean.f9815c = next.mo17892e();
                        videoPlayListBean.f9814b = next.mo17893f();
                        videoPlayListBean.f9816d = next.mo17886b();
                        videoPlayListBean.f9818f = next.mo17880a() == null ? null : next.mo17880a().f10535h;
                        videoPlayListBean.f9817e = next.f10497b;
                        videoPlayListBean.f9819g = next.mo17880a() == null ? -1 : next.mo17880a().f10528a;
                        arrayList.add(videoPlayListBean);
                    }
                }
                intent.putExtra("playList", arrayList);
                intent.putExtra("listName", aVar.f10546b);
            }
        }
        startActivity(intent);
        TreeMap treeMap = new TreeMap();
        treeMap.put("fileExt", axe.m7324e(dBBean.f10530c));
        treeMap.put(VastIconXmlManager.DURATION, String.valueOf(dBBean.f10534g));
        LogEvents.m18494b("VideoInfo", (Map<String, String>) treeMap);
    }

    private class ItemfolderViewHolder extends RecyclerView.ViewHolder {
        final TextView f11006a;
        final TextView f11007b;
        final CheckBox f11008c;
        final View f11009d;
        final View f11010e;
        final View f11011f;
        final ImageView f11012g;

        ItemfolderViewHolder(View view) {
            super(view);
            this.f11006a = (TextView) view.findViewById(R.id.name);
            this.f11007b = (TextView) view.findViewById(R.id.count);
            this.f11008c = (CheckBox) view.findViewById(R.id.checkbox);
            this.f11009d = view.findViewById(R.id.more);
            this.f11010e = view.findViewById(R.id.item_view);
            this.f11011f = view.findViewById(R.id.ic_new);
            this.f11012g = (ImageView) view.findViewById(R.id.icon);
        }
    }

    private class ItemRecentVideoViewHolder extends RecyclerView.ViewHolder {
        final TextView time;
        final TextView name;
        final View f11021c;
        final ImageView icon;

        ItemRecentVideoViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(R.id.icon);
            this.name = (TextView) view.findViewById(R.id.name);
            this.time = (TextView) view.findViewById(R.id.time);
            this.f11021c = view.findViewById(R.id.item_view);
        }
    }

    private class DirectoryViewHolder extends RecyclerView.ViewHolder {


        final View directory_btn;

        DirectoryViewHolder(View view) {
            super(view);
            this.directory_btn = view.findViewById(R.id.directory_btn);
        }
    }


    private class FolderListAdContainerViewHolder extends RecyclerView.ViewHolder {


        private final ViewGroup adView;

        private final boolean appTheme;

        private FolderListAdContainerViewHolder(View view) {
            super(view);
            this.adView = (ViewGroup) view.findViewById(R.id.ad_container);
            this.appTheme = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false);
        }


        public void addView(View view) {
            if (this.adView != null && this.adView.getChildCount() == 0) {
                Views.removeFromParent(view);
                if (view != null) {
                    this.adView.addView(view);
                    FolderListNativeAdLoader.setNativeThemeColor(view, this.appTheme);
                }
            }
        }
    }
}
