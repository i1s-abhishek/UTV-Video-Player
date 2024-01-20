package com.abhishek.xplayer.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.VideoManager;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import classesdef.eventbus.awj;
import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.fragments.f */
public class HideListFragment extends FragmentLifecycle implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: a */
    public static final Map<String, String> f10725a = new HashMap(3);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C2694b f10726b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SwipeRefreshLayout f10727c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<C2695c> f10728d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f10729e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f10730f;

    /* renamed from: g */
    private ActionBar f10731g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f10732h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f10733i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Set<String> f10734j = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10729e = new Handler(Looper.myLooper()) {
            public void handleMessage(Message message) {
                if (HideListFragment.this.mo17989b()) {
                    super.handleMessage(message);
                    if (message.obj != null) {
                        List unused = HideListFragment.this.f10728d = (List) message.obj;
                        if (HideListFragment.this.f10730f) {
                            HideListFragment.this.f10726b.notifyDataSetChanged();
                        }
                        if (HideListFragment.this.f10727c != null && HideListFragment.this.f10727c.isRefreshing()) {
                            HideListFragment.this.f10727c.setRefreshing(false);
                        }
                    }
                }
            }
        };
        this.f10733i = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false);
        this.f10726b = new C2694b();
        if (this.f10728d == null) {
            m12295d();
        }
    }

    public void onStart() {
        super.onStart();
        LogEvents.m18498d("HideList");
    }

    public void onResume() {
        FileExplorerActivity.fragmentName = "HideList";
        super.onResume();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_list_refresh, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getApplicationContext_(), 1, false));
        recyclerView.setAdapter(this.f10726b);
        this.f10727c = (SwipeRefreshLayout) inflate.findViewById(R.id.SwipeRefreshLayout);
        this.f10727c.setEnabled(true);
        this.f10727c.setOnRefreshListener(this);
        this.f10727c.setColorSchemeResources(R.color.refresh_color_1, R.color.refresh_color_2, R.color.refresh_color_3);
        this.f10731g = ((AppCompatActivity) getActivity()).getSupportActionBar();
        this.f10731g.setDisplayHomeAsUpEnabled(true);
        this.f10731g.setDisplayShowHomeEnabled(true);
        this.f10731g.setHomeAsUpIndicator((int) R.drawable.ic_back);
        this.f10731g.setSubtitle((CharSequence) null);
        this.f10731g.setTitle((int) R.string.manage_scan_list);
        setHasOptionsMenu(true);
        this.f10730f = true;
        return inflate;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!mo17989b()) {
            return false;
        }
        if (menuItem.getItemId() == 16908332 && !mo17990c()) {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super.onPause();
        if (this.f10727c != null) {
            this.f10727c.setRefreshing(false);
            this.f10727c.destroyDrawingCache();
            this.f10727c.clearAnimation();
        }
    }

    public void onDestroyView() {
        this.f10730f = false;
        super.onDestroyView();
        if (this.f10732h) {
            EventBus.getDefault().post(new awj());
        }
    }

    public void onRefresh() {
        m12295d();
    }

    /* renamed from: d */
    private void m12295d() {
        final HashMap hashMap = new HashMap(f10725a);
        new Thread(new Runnable() {
            public void run() {
                HashSet<String> hashSet;
                ArrayList<C2695c> arrayList = new ArrayList<>(HideListFragment.this.f10728d == null ? 0 : HideListFragment.this.f10728d.size());
                Set<String> a = HideListFragment.m12284a();
                if (a == null) {
                    hashSet = new HashSet<>();
                } else {
                    hashSet = new HashSet<>(a);
                }
                if (HideListFragment.this.f10734j == null) {
                    Set unused = HideListFragment.this.f10734j = new HashSet(hashSet);
                } else {
                    hashSet.addAll(HideListFragment.this.f10734j);
                }
                List<String> b = VideoManager.m12192b();
                if (b != null) {
                    for (String next : b) {
                        boolean z = a == null || !a.contains(next.toLowerCase(Locale.ENGLISH));
                        arrayList.add(new C2695c(next, z));
                        if (!z) {
                            hashSet.remove(next.toLowerCase(Locale.ENGLISH));
                        }
                    }
                }
                if (!hashSet.isEmpty()) {
                    for (String str : hashSet) {
                        arrayList.add(new C2695c(str, a == null || !a.contains(str.toLowerCase(Locale.ENGLISH))));
                    }
                }
                if (!hashMap.isEmpty()) {
                    for (C2695c cVar : arrayList) {
                        String str2 = (String) hashMap.get(cVar.f10745a);
                        if (str2 != null) {
                            cVar.f10745a = str2;
                        }
                    }
                }
                Collections.sort(arrayList);
                HideListFragment.this.f10729e.obtainMessage(0, arrayList).sendToTarget();
            }
        }).start();
    }

    /* renamed from: com.inshot.xplayer.fragments.f$b */
    private class C2694b extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

        /* renamed from: b */
        private int f10742b;

        /* renamed from: c */
        private int f10743c;

        /* renamed from: d */
        private int f10744d;

        private C2694b() {
            this.f10742b = -13421773;
            this.f10743c = -32768;
            this.f10744d = HideListFragment.this.getResources().getColor(R.color.dark_theme_home_sub_text_color);
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C2693a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_scan_list, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            C2695c cVar = (C2695c) HideListFragment.this.f10728d.get(i);
            C2693a aVar = (C2693a) viewHolder;
            aVar.f10738a.setText(cVar.f10745a);
            if (cVar.f10746b) {
                aVar.f10739b.setText(R.string.hide);
                aVar.f10739b.setTextColor(HideListFragment.this.f10733i ? this.f10744d : this.f10742b);
                aVar.f10738a.getPaint().setFlags(aVar.f10739b.getPaint().getFlags() & -17);
            } else {
                aVar.f10739b.setText(R.string.show);
                aVar.f10739b.setTextColor(this.f10743c);
                aVar.f10738a.getPaint().setFlags(aVar.f10739b.getPaint().getFlags() | 16);
            }
            aVar.f10739b.setTag(Integer.valueOf(i));
            aVar.f10739b.setOnClickListener(this);
        }

        public int getItemCount() {
            if (HideListFragment.this.f10728d != null) {
                return HideListFragment.this.f10728d.size();
            }
            return 0;
        }

        public void onClick(View view) {
            if (HideListFragment.this.mo17989b() && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (HideListFragment.this.f10728d != null && intValue >= 0 && intValue < HideListFragment.this.f10728d.size()) {
                    C2695c cVar = (C2695c) HideListFragment.this.f10728d.get(intValue);
                    cVar.f10746b = !cVar.f10746b;
                    if (!cVar.f10746b) {
                        HideListFragment.m12296d(cVar.f10745a);
                    } else {
                        HideListFragment.m12298e(cVar.f10745a);
                    }
                    if (HideListFragment.this.f10726b != null) {
                        HideListFragment.this.f10726b.notifyItemRangeChanged(intValue, 1);
                    }
                    boolean unused = HideListFragment.this.f10732h = true;
                }
            }
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.f$a */
    private class C2693a extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final TextView f10738a;

        /* renamed from: b */
        final TextView f10739b;

        C2693a(View view) {
            super(view);
            this.f10738a = (TextView) view.findViewById(R.id.name);
            this.f10739b = (TextView) view.findViewById(R.id.hide);
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.f$c */
    private class C2695c implements Comparable<C2695c> {

        /* renamed from: a */
        public String f10745a;

        /* renamed from: b */
        public boolean f10746b;

        C2695c(String str, boolean z) {
            this.f10745a = str;
            this.f10746b = z;
        }

        /* renamed from: a */
        public int compareTo(C2695c cVar) {
            return VideoManager.m12164a(this.f10745a, cVar.f10745a);
        }
    }

    /* renamed from: a */
    public static boolean m12289a(String str) {
        Set<String> a;
        if (str == null || (a = m12284a()) == null || !a.contains(str.toLowerCase(Locale.ENGLISH))) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static Set<String> m12284a() {
        return MyApplication.getApplicationContext_().getSharedPreferences("scanList", 0).getStringSet("blackList", (Set) null);
    }

    /* renamed from: a */
    public static void m12286a(Set<String> set) {
        HashSet hashSet;
        if (set != null) {
            Set<String> a = m12284a();
            if (a == null) {
                hashSet = new HashSet();
            } else {
                hashSet = new HashSet(a);
            }
            for (String lowerCase : set) {
                hashSet.add(lowerCase.toLowerCase(Locale.ENGLISH));
            }
            MyApplication.getApplicationContext_().getSharedPreferences("scanList", 0).edit().putStringSet("blackList", hashSet).apply();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m12296d(String str) {
        HashSet hashSet;
        if (str != null) {
            Set<String> a = m12284a();
            if (a == null) {
                hashSet = new HashSet();
            } else {
                hashSet = new HashSet(a);
            }
            hashSet.add(str.toLowerCase(Locale.ENGLISH));
            MyApplication.getApplicationContext_().getSharedPreferences("scanList", 0).edit().putStringSet("blackList", hashSet).apply();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m12298e(String str) {
        Set<String> a;
        if (str != null && (a = m12284a()) != null) {
            HashSet hashSet = new HashSet(a);
            hashSet.remove(str.toLowerCase(Locale.ENGLISH));
            MyApplication.getApplicationContext_().getSharedPreferences("scanList", 0).edit().putStringSet("blackList", hashSet).apply();
        }
    }
}
