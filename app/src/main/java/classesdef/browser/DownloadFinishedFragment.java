package classesdef.browser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;

import com.abhishek.xplayer.ad.FunnyAd;
import com.abhishek.xplayer.ad.DownloadNativeAdLoader;
import com.abhishek.xplayer.ad.DownloadListNativeAds;
import com.abhishek.xplayer.ad.AppAbstractInterface;
import com.abhishek.xplayer.ad.StaticAppAds;
import com.bumptech.glide.Glide;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.fragments.FragmentLifecycle;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import classesdef.browser.download.bnu;
import classesdef.browser.download.bou;
import classesdef.browser.download.bpd;
import classesdef.database.bnm;
import classesdef.eventbus.bnt;
import classesdef.eventbus.bnw;
import classesdef.eventbus.bnx;
import classesdef.eventbus.bnz;
import classesdef.eventbus.boc;
import classesdef.player.DefaultSharedPreferences;
import classesdef.xdplayer.bpe;
import classesdef.xdplayer.bpj;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.activity.SettingsActivity;
import video.downloader.videodownloader.five.activity.FilesActivity;

/* renamed from: bod */
public class DownloadFinishedFragment extends FragmentLifecycle implements View.OnClickListener, AppAbstractInterface<DownloadNativeAdLoader> {
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static HashSet<String> f16021l = new HashSet<>();

    /* renamed from: a */
    public int f16022a = 0;

    /* renamed from: b */
    private LinearLayout f16023b;

    /* renamed from: c */
    private TextView f16024c;

    /* renamed from: d */
    private ArrayList<bph> f16025d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public bne f16026e;

    /* renamed from: f */
    private int f16027f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f16028g = false;

    /* renamed from: h */
    private View f16029h;

    /* renamed from: i */
    private RelativeLayout f16030i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ArrayList<bph> f16031j = new ArrayList<>();

    /* renamed from: k */
    private ListView f16032k;

    /* renamed from: m */
    private boolean f16033m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Handler f16034n = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    boy.m18459a(DownloadFinishedFragment.this.getContext());
                    if (DownloadFinishedFragment.this.f16026e != null) {
                        DownloadFinishedFragment.this.m18282i();
                        DownloadFinishedFragment.this.mo23246d();
                        return;
                    }
                    return;
                case 2:
                    try {
                        for (String str : bpe.m18520a().mo23319d().keySet()) {
                            BaseDownloadTask aye = bpe.m18520a().mo23319d().get(str);
                            if (aye != null && aye.getStatus() == 3) {
                                EventBus.getDefault().post(new bnu(aye, true));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        DownloadFinishedFragment.this.f16034n.sendEmptyMessageDelayed(2, 1000);
                        throw th;
                    }
                    DownloadFinishedFragment.this.f16034n.sendEmptyMessageDelayed(2, 1000);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: d */
    public void mo23246d() {
    }

    /* renamed from: b */
    static /* synthetic */ int m18273b(DownloadFinishedFragment bod) {
        int i = bod.f16027f;
        bod.f16027f = i + 1;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        View inflate = layoutInflater.inflate(R.layout.fragment_finished, (ViewGroup) null);
        this.f16031j = bnm.m18246a().mo23219a((Context) getActivity());
        Iterator<bph> it = this.f16031j.iterator();
        while (it.hasNext()) {
            bph next = it.next();
            if (FileDownloader.getImpl().getStatus(next.mo23339c(), next.mo23334b(getContext())) == -2) {
                f16021l.add(next.mo23339c());
            }
        }
        this.f16025d = bnm.m18246a().mo23220a((Context) getActivity(), 8, this.f16027f);
        boolean z = false;
        this.f16022a = 0;
        this.f16029h = inflate.findViewById(R.id.action_more);
        this.f16030i = (RelativeLayout) inflate.findViewById(R.id.no_wifi_tip_layout);
        this.f16030i.setOnClickListener(this);
        this.f16024c = (TextView) inflate.findViewById(R.id.space);
        this.f16023b = (LinearLayout) inflate.findViewById(R.id.space_layout);
        this.f16032k = (ListView) inflate.findViewById(R.id.list_view);
        Glide.with(getActivity()).load(Integer.valueOf(R.mipmap.no_history)).into((ImageView) inflate.findViewById(R.id.tv_empty));
        this.f16032k.setEmptyView(inflate.findViewById(R.id.empty_layout));
        this.f16026e = new bne(new bnk(this, this.f16031j), new DownloadFinishedFileItemFragment(this, this.f16025d));
        this.f16032k.setAdapter(this.f16026e);
        mo23246d();
        EventBus.getDefault().register((Object) this);
        this.f16032k.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (DownloadFinishedFragment.this.f16028g && i == 0) {
                    DownloadFinishedFragment.m18273b(DownloadFinishedFragment.this);
                    DownloadFinishedFragment.this.m18282i();
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                boolean unused = DownloadFinishedFragment.this.f16028g = i + i2 == i3;
            }
        });
        if (!bov.m18447b(getContext()) || (!bpj.m18578a(getContext()).mo23412s() && !bov.m18446a(getContext()))) {
            this.f16030i.setVisibility(0);
        }
        if (this.f16026e.isEmpty() || DefaultSharedPreferences.getAdRemoved("adRemoved", false)) {
            z = true;
        }
        this.f16033m = z;
        if (!this.f16033m) {
            DownloadListNativeAds.m10235e().mo16941a((AppAbstractInterface<DownloadNativeAdLoader>) this);
            DownloadNativeAdLoader e = DownloadListNativeAds.m10235e().mo16946f();
            if (e != null && e.mo16905d()) {
                bne bne = this.f16026e;
                View g = e.mo16939g();
                bne.mo23150a(g);
                DownloadListNativeAds.m10235e().mo16945c(e);
                view = g;
            }
            if (view == null) {
                this.f16026e.mo23150a(StaticAppAds.create(MyApplication.getApplicationContext_(), (int) R.layout.folder_list_ad));
            }
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (this.f16034n != null && !this.f16034n.hasMessages(2)) {
            this.f16034n.sendEmptyMessageDelayed(2, 1000);
        }
        if (!this.f16033m) {
            DownloadListNativeAds.m10235e().mo16926b();
        }
        if (!FileDownloader.getImpl().isServiceConnected()) {
            FileDownloader.getImpl().bindService();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.no_wifi_tip_layout) {
            if (bov.m18447b(getContext())) {
                mo23243a();
                return;
            }
            try {
                Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                intent.setFlags(268435456);
                getContext().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo23243a() {
        startActivity(new Intent(getContext(), SettingsActivity.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public synchronized void m18282i() {
        ArrayList<bph> a = bnm.m18246a().mo23220a((Context) getActivity(), 8, this.f16027f);
        Iterator<bph> it = this.f16025d.iterator();
        while (it.hasNext()) {
            bph next = it.next();
            Iterator<bph> it2 = a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                bph next2 = it2.next();
                if (next.mo23333b() == next2.mo23333b()) {
                    a.remove(next2);
                    break;
                }
            }
        }
        if (a.size() != 0) {
            this.f16025d.addAll(a);
            this.f16026e.notifyDataSetChanged();
            mo23246d();
        }
    }

    /* renamed from: b */
    private void m18274b(boolean z) {
        if (!z) {
            this.f16023b.setVisibility(8);
            return;
        }
        String a = bot.m18410a(getContext());
        if (!TextUtils.isEmpty(a) && z) {
            this.f16023b.setVisibility(0);
            this.f16024c.setText(a);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (!this.f16033m) {
            DownloadListNativeAds.m10235e().mo16944b((AppAbstractInterface<DownloadNativeAdLoader>) this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        this.f16027f = 0;
        if (this.f16034n != null) {
            this.f16034n.removeMessages(2);
        }
        if (this.f16026e != null) {
            this.f16026e.mo23151b();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnt bnt) {
        if (getActivity() != null && bnt.f16003a != 0) {
            if (!(this.f16031j == null || this.f16026e == null)) {
                Iterator<bph> it = this.f16031j.iterator();
                while (it.hasNext()) {
                    bph next = it.next();
                    if (next.mo23333b() == bnt.f16003a) {
                        this.f16031j.remove(next);
                        this.f16026e.notifyDataSetChanged();
                        mo23246d();
                        return;
                    }
                }
            }
            if (this.f16025d != null && this.f16026e != null) {
                Iterator<bph> it2 = this.f16025d.iterator();
                while (it2.hasNext()) {
                    bph next2 = it2.next();
                    if (next2.mo23333b() == bnt.f16003a) {
                        this.f16025d.remove(next2);
                        this.f16026e.notifyDataSetChanged();
                        mo23246d();
                        return;
                    }
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnu bnu) {
        String str = bnu.f16007c;
        if (getActivity() != null && !TextUtils.isEmpty(str) && this.f16026e != null && this.f16032k != null) {
            byte b = bnu.f16008d;
            if (b != -3) {
                switch (b) {
                    case 2:
                        if (this.f16031j != null) {
                            mo23246d();
                            this.f16026e.f15837a.mo23206a(bnu, this.f16032k);
                            return;
                        }
                        return;
                    case 3:
                        if (this.f16031j != null && bnu.f16012h) {
                            this.f16026e.f15837a.mo23206a(bnu, this.f16032k);
                            return;
                        }
                        return;
                    default:
                        if (this.f16031j != null) {
                            this.f16026e.f15837a.mo23206a(bnu, this.f16032k);
                            return;
                        }
                        return;
                }
            } else {
                bph bph = (bph) bnu.f16005a.getTag();
                if (bph != null) {
                    if (this.f16031j != null) {
                        Iterator<bph> it = this.f16031j.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            bph next = it.next();
                            if (next.mo23333b() == bph.mo23333b()) {
                                this.f16031j.remove(next);
                                this.f16026e.notifyDataSetChanged();
                                mo23246d();
                                break;
                            }
                        }
                    }
                    if (this.f16025d != null && !this.f16025d.contains(bph)) {
                        this.f16025d.add(0, bph);
                        this.f16026e.notifyDataSetChanged();
                        mo23246d();
                    }
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnx bnx) {
        boolean z;
        if (getActivity() != null && bnx.f16014a != null && this.f16031j != null && this.f16026e != null) {
            Iterator<bph> it = this.f16031j.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().mo23333b() == bnx.f16014a.mo23333b()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                this.f16031j.add(0, bnx.f16014a);
                this.f16026e.notifyDataSetChanged();
                mo23246d();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnz bnz) {
        mo23247e();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(boc boc) {
        mo23247e();
    }

    /* renamed from: e */
    public void mo23247e() {
        if (this.f16030i != null && getContext() != null) {
            if (!bov.m18447b(getContext()) || (!bpj.m18578a(getContext()).mo23412s() && !bov.m18446a(getContext()))) {
                this.f16030i.setVisibility(0);
            } else {
                this.f16030i.setVisibility(8);
            }
            if (getContext() != null && bov.m18447b(getContext()) && ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                Iterator<bph> it = this.f16031j.iterator();
                while (it.hasNext()) {
                    bph next = it.next();
                    byte a = FileDownloader.getImpl().getStatus(next.mo23339c(), next.mo23334b(getContext()));
                    if ((a == -2 || a == -1) && !f16021l.contains(next.mo23339c()) && bok.m18338a(getContext(), next.mo23334b(getContext())) != 2 && bok.m18338a(getContext(), next.mo23334b(getContext())) != 5) {
                        bou.m18412a().mo23299a(getContext(), next, true);
                        BrowserLogEvent.downloaderLogEvent(getContext(), "download_retry", "network_ok_retry");
                    }
                }
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 7) {
            FunnyAd.loadFunnyAd(getActivity(), false, "DownloadPage");
        } else if (itemId != 16908332) {
            switch (itemId) {
                case 1:
                    m18283j();
                    BrowserLogEvent.downloaderLogEvent(getContext(), "DownloadFragment", "click action menu");
                    break;
                case 2:
                    BrowserLogEvent.downloaderLogEvent(getActivity(), "DownloadFragment", "Multi Select Delete");
                    this.f16022a = 0;
                    m18274b(false);
                    mo23245a(false);
                    this.f16026e.notifyDataSetChanged();
                    getActivity().supportInvalidateOptionsMenu();
                    final ArrayList arrayList = new ArrayList();
                    Iterator<bph> it = this.f16025d.iterator();
                    while (it.hasNext()) {
                        bph next = it.next();
                        if (next.mo23356k() && next.mo23352h() != 1000) {
                            arrayList.add(next);
                        }
                    }
                    Iterator<bph> it2 = this.f16031j.iterator();
                    while (it2.hasNext()) {
                        bph next2 = it2.next();
                        if (next2.mo23356k() && next2.mo23352h() != 1000) {
                            arrayList.add(next2);
                        }
                    }
                    if (arrayList.size() != 0) {
                        Context context = getContext();
                        boy.m18460a(context, getString(R.string.delete).toLowerCase() + "...", false);
                        new Thread() {
                            public void run() {
                                try {
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        bph bph = (bph) it.next();
                                        if (bph.mo23352h() != 1000) {
                                            bpd.m18512c(DownloadFinishedFragment.this.getContext(), bph);
                                        }
                                    }
                                    if (DownloadFinishedFragment.this.f16034n == null) {
                                        return;
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    if (DownloadFinishedFragment.this.f16034n == null) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    if (DownloadFinishedFragment.this.f16034n != null) {
                                        DownloadFinishedFragment.this.f16034n.sendEmptyMessage(1);
                                    }
                                    throw th;
                                }
                                DownloadFinishedFragment.this.f16034n.sendEmptyMessage(1);
                            }
                        }.start();
                        break;
                    }
                    break;
                case 3:
                    BrowserLogEvent.downloaderLogEvent(getActivity(), "DownloadFragment", "Select All");
                    Iterator<bph> it3 = this.f16025d.iterator();
                    int i = 0;
                    int i2 = 0;
                    while (it3.hasNext()) {
                        bph next3 = it3.next();
                        if (next3.mo23352h() != 1000) {
                            i++;
                            if (next3.mo23356k()) {
                                i2++;
                            }
                        }
                    }
                    Iterator<bph> it4 = this.f16031j.iterator();
                    while (it4.hasNext()) {
                        bph next4 = it4.next();
                        if (next4.mo23352h() != 1000) {
                            i++;
                            if (next4.mo23356k()) {
                                i2++;
                            }
                        }
                    }
                    if (i == i2) {
                        Iterator<bph> it5 = this.f16025d.iterator();
                        while (it5.hasNext()) {
                            bph next5 = it5.next();
                            if (next5.mo23352h() != 1000) {
                                next5.mo23332a(false);
                            }
                        }
                        Iterator<bph> it6 = this.f16031j.iterator();
                        while (it6.hasNext()) {
                            bph next6 = it6.next();
                            if (next6.mo23352h() != 1000) {
                                next6.mo23332a(false);
                            }
                        }
                    } else {
                        Iterator<bph> it7 = this.f16025d.iterator();
                        while (it7.hasNext()) {
                            bph next7 = it7.next();
                            if (next7.mo23352h() != 1000) {
                                next7.mo23332a(true);
                            }
                        }
                        Iterator<bph> it8 = this.f16031j.iterator();
                        while (it8.hasNext()) {
                            bph next8 = it8.next();
                            if (next8.mo23352h() != 1000) {
                                next8.mo23332a(true);
                            }
                        }
                    }
                    mo23245a(true);
                    this.f16026e.notifyDataSetChanged();
                    break;
            }
        } else if (this.f16022a == 0) {
            EventBus.getDefault().post(new bnw(false));
            getActivity().finish();
        } else {
            mo23248f();
            BrowserLogEvent.downloaderLogEvent(getActivity(), "DownloadFragment", "click home back");
        }
        return true;
    }

    /* renamed from: f */
    public void mo23248f() {
        this.f16022a = 0;
        Iterator<bph> it = this.f16025d.iterator();
        while (it.hasNext()) {
            it.next().mo23332a(false);
        }
        Iterator<bph> it2 = this.f16031j.iterator();
        while (it2.hasNext()) {
            it2.next().mo23332a(false);
        }
        m18274b(false);
        mo23245a(false);
        this.f16026e.notifyDataSetChanged();
        getActivity().supportInvalidateOptionsMenu();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (isAdded()) {
            if (this.f16022a == 0) {
                MenuItem add = menu.add(0, 1, 0, "");
                add.setIcon(R.drawable.ic_more);
                MenuItemCompat.setShowAsAction(add, 2);
            } else {
                MenuItem add2 = menu.add(0, 3, 0, getString(R.string.select).toLowerCase());
                add2.setIcon(R.drawable.ic_multicheck);
                MenuItemCompat.setShowAsAction(add2, 2);
                MenuItem add3 = menu.add(0, 2, 0, getString(R.string.delete).toLowerCase());
                add3.setIcon(R.drawable.ic_delete);
                MenuItemCompat.setShowAsAction(add3, 2);
            }
            super.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    /* renamed from: j */
    private void m18283j() {
        PopupMenu popupMenu = new PopupMenu(getContext(), this.f16029h);
        if (this.f16031j != null && !this.f16031j.isEmpty()) {
            popupMenu.getMenu().add(0, 4, 0, getString(R.string.pause_all));
            popupMenu.getMenu().add(0, 5, 0, getString(R.string.resume_all));
        }
        popupMenu.getMenu().add(0, 6, 0, getString(R.string.batch_delete));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case 4:
                        BrowserLogEvent.downloaderLogEvent(DownloadFinishedFragment.this.getContext(), "progress fragment", "pause all");
                        FileDownloader.getImpl().pauseAll();
                        DownloadFinishedFragment.this.f16026e.notifyDataSetChanged();
                        Toast.makeText(DownloadFinishedFragment.this.getContext(), DownloadFinishedFragment.this.getString(R.string.pause_all), 1).show();
                        Iterator it = DownloadFinishedFragment.this.f16031j.iterator();
                        while (it.hasNext()) {
                            DownloadFinishedFragment.f16021l.add(((bph) it.next()).mo23339c());
                        }
                        break;
                    case 5:
                        if (box.m18457a(DownloadFinishedFragment.this.getActivity(), new box.C3987a() {
                            /* renamed from: a */
                            public void mo21376a() {
                                DownloadFinishedFragment.this.m18284k();
                            }
                        })) {
                            DownloadFinishedFragment.this.m18284k();
                            break;
                        }
                        break;
                    case 6:
                        BrowserLogEvent.downloaderLogEvent(DownloadFinishedFragment.this.getContext(), "progress fragment", "click batch delete");
                        DownloadFinishedFragment.this.f16022a = 1;
                        DownloadFinishedFragment.this.mo23245a(true);
                        DownloadFinishedFragment.this.f16026e.notifyDataSetChanged();
                        DownloadFinishedFragment.this.getActivity().supportInvalidateOptionsMenu();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m18284k() {
        f16021l.clear();
        BrowserLogEvent.downloaderLogEvent(getContext(), "progress fragment", "resume all");
        Iterator<bph> it = this.f16031j.iterator();
        while (it.hasNext()) {
            bph next = it.next();
            byte a = FileDownloader.getImpl().getStatus(next.mo23339c(), next.mo23334b(getContext()));
            if (a == -2 || a == -1 || a == 0 || a == 11 || a == 10) {
                bou.m18412a().mo23299a(getContext(), next, true);
            }
        }
        Toast.makeText(getContext(), getString(R.string.resume_all), 1).show();
    }

    /* renamed from: a */
    public void mo23245a(boolean z) {
        Toolbar toolbar = (getActivity() == null || !(getActivity() instanceof FilesActivity)) ? null : ((FilesActivity) getActivity()).toolbar;
        if (toolbar != null) {
            if (z) {
                Iterator<bph> it = this.f16025d.iterator();
                int i = 0;
                while (it.hasNext()) {
                    bph next = it.next();
                    if (next.mo23356k() && next.mo23352h() != 1000) {
                        i++;
                    }
                }
                Iterator<bph> it2 = this.f16031j.iterator();
                while (it2.hasNext()) {
                    bph next2 = it2.next();
                    if (next2.mo23356k() && next2.mo23352h() != 1000) {
                        i++;
                    }
                }
                toolbar.setTitle((CharSequence) getString(R.string.selected, i + ""));
                return;
            }
            toolbar.setTitle((CharSequence) getString(R.string.downloads));
        }
    }

    @Override
    public void mo16860a(DownloadNativeAdLoader c2236f) {

    }

    /* renamed from: a */
    public void mo16863b(DownloadNativeAdLoader gVar) {
        if (mo17989b() && this.f16026e != null) {
            StaticAppAds.removeSelfListedAD(this.f16026e.mo23149a());
            this.f16026e.mo23150a(gVar != null ? gVar.mo16939g() : null);
            this.f16026e.notifyDataSetChanged();
            DownloadListNativeAds.m10235e().mo16945c(gVar);
        }
    }



    /* renamed from: g */
    public static Set<String> m18279g() {
        return f16021l;
    }
}
