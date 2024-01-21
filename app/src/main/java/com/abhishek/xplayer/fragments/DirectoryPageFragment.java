package com.abhishek.xplayer.fragments;

import android.os.Bundle;
import android.os.Environment;
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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.RecentMediaStorage;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import classesdef.inplayer.axi;
import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.fragments.c */
public class DirectoryPageFragment extends FragmentLifecycle implements SwipeRefreshLayout.OnRefreshListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C2686c f10676a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SwipeRefreshLayout f10677b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<C2684a> f10678c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Handler f10679d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f10680e;

    /* renamed from: f */
    private ActionBar f10681f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f10682g;

    /* renamed from: h */
    private boolean f10683h;

    /* renamed from: a */
    public static DirectoryPageFragment m12259a(String str, boolean z) {
        DirectoryPageFragment cVar = new DirectoryPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("path", str);
        bundle.putBoolean("sendPV", z);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10679d = new Handler(Looper.myLooper()) {
            public void handleMessage(Message message) {
                if (DirectoryPageFragment.this.mo17989b()) {
                    super.handleMessage(message);
                    if (message.obj != null) {
                        List unused = DirectoryPageFragment.this.f10678c = (List) message.obj;
                        if (DirectoryPageFragment.this.f10680e) {
                            DirectoryPageFragment.this.f10676a.notifyDataSetChanged();
                        }
                        if (DirectoryPageFragment.this.f10677b != null && DirectoryPageFragment.this.f10677b.isRefreshing()) {
                            DirectoryPageFragment.this.f10677b.setRefreshing(false);
                        }
                    }
                }
            }
        };
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f10682g = arguments.getString("path");
            this.f10683h = arguments.getBoolean("sendPV");
            if (!TextUtils.isEmpty(this.f10682g)) {
                this.f10682g = new File(this.f10682g).getAbsolutePath();
            }
        }
        this.f10676a = new C2686c();
        if (this.f10678c == null) {
            m12261a();
        }
    }

    public void onStart() {
        super.onStart();
        if (this.f10683h) {
            LogEvents.m18498d("DirectoryPage");
        }
    }

    public void onResume() {
        FileExplorerActivity.fragmentName = "DirectoryPage";
        super.onResume();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_list_refresh, viewGroup, false);
        if (TextUtils.isEmpty(this.f10682g)) {
            getActivity().onBackPressed();
            return inflate;
        }
        this.f10677b = (SwipeRefreshLayout) inflate.findViewById(R.id.SwipeRefreshLayout);
        this.f10677b.setEnabled(true);
        this.f10677b.setOnRefreshListener(this);
        this.f10677b.setColorSchemeResources(R.color.refresh_color_1, R.color.refresh_color_2, R.color.refresh_color_3);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getApplicationContext_(), 1, false));
        recyclerView.setAdapter(this.f10676a);
        this.f10681f = ((AppCompatActivity) getActivity()).getSupportActionBar();
        this.f10681f.setDisplayHomeAsUpEnabled(true);
        this.f10681f.setDisplayShowHomeEnabled(true);
        this.f10681f.setHomeAsUpIndicator((int) R.drawable.ic_back);
        this.f10681f.setSubtitle((CharSequence) this.f10682g);
        if (this.f10682g.equals(Environment.getExternalStorageDirectory().getAbsolutePath())) {
            this.f10681f.setTitle((int) R.string.internal_sd);
        } else {
            this.f10681f.setTitle((CharSequence) axy.m7460a(this.f10682g));
        }
        setHasOptionsMenu(true);
        this.f10680e = true;
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
        if (this.f10677b != null) {
            this.f10677b.setRefreshing(false);
            this.f10677b.destroyDrawingCache();
            this.f10677b.clearAnimation();
        }
    }

    public void onDestroyView() {
        this.f10680e = false;
        this.f10677b = null;
        super.onDestroyView();
    }

    public void onRefresh() {
        m12261a();
    }

    /* renamed from: a */
    private void m12261a() {
        new Thread(new Runnable() {
            public void run() {
                if (DirectoryPageFragment.this.f10682g != null) {
                    final boolean z = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("lH9wboin", false);
                    File[] listFiles = new File(DirectoryPageFragment.this.f10682g).listFiles(new FileFilter() {
                        public boolean accept(File file) {
                            if (file.isDirectory()) {
                                return z || !file.getName().startsWith(".");
                            }
                            return axi.m7358a(file.getName());
                        }
                    });
                    if (listFiles == null) {
                        DirectoryPageFragment.this.f10679d.obtainMessage(0, new ArrayList(0)).sendToTarget();
                        return;
                    }
                    RecentMediaStorage recentMediaStorage = new RecentMediaStorage(MyApplication.getApplicationContext_());
                    ArrayList<C2684a> arrayList = new ArrayList<>(listFiles.length);
                    boolean z2 = false;
                    for (File file : listFiles) {
                        if (file.exists()) {
                            C2684a aVar = new C2684a();
                            aVar.f10689a = file.getAbsolutePath();
                            aVar.f10690b = file.getName();
                            aVar.f10691c = file.isDirectory();
                            if (aVar.f10691c) {
                                z2 = true;
                            } else if (axi.m7358a(aVar.f10690b)) {
                                aVar.f10695g = true;
                                aVar.f10696h = recentMediaStorage.mo17901a(aVar.f10689a);
                            }
                            arrayList.add(aVar);
                        }
                    }
                    Collections.sort(arrayList, new Comparator<C2684a>() {
                        /* renamed from: a */
                        public int compare(C2684a aVar, C2684a aVar2) {
                            if (aVar.f10691c && !aVar2.f10691c) {
                                return -1;
                            }
                            if (!aVar.f10691c && aVar2.f10691c) {
                                return 1;
                            }
                            String str = aVar.f10690b;
                            String str2 = aVar2.f10690b;
                            if (aVar.f10690b != null) {
                                str = aVar.f10690b.toLowerCase(Locale.ENGLISH);
                            }
                            if (aVar2.f10690b != null) {
                                str2 = aVar2.f10690b.toLowerCase(Locale.ENGLISH);
                            }
                            if (!str.equals(str2)) {
                                return str.compareTo(str2);
                            }
                            if (aVar.f10690b == null) {
                                return -1;
                            }
                            return aVar.f10690b.compareTo(aVar2.f10690b);
                        }
                    });
                    DirectoryPageFragment.this.f10679d.obtainMessage(0, arrayList).sendToTarget();
                    if (z2) {
                        ArrayList arrayList2 = new ArrayList(arrayList.size());
                        for (C2684a a : arrayList) {
                            C2684a a2 = a.mo18005a();
                            arrayList2.add(a2);
                            if (a2.f10691c) {
                                a2.f10693e = 0;
                                a2.f10694f = 0;
                                a2.f10692d = true;
                                File[] listFiles2 = new File(a2.f10689a).listFiles();
                                if (!(listFiles2 == null || listFiles2.length == 0)) {
                                    a2.f10692d = false;
                                    for (File file2 : listFiles2) {
                                        if ((z || !file2.getName().startsWith(".")) && file2.exists()) {
                                            if (file2.isDirectory()) {
                                                a2.f10693e++;
                                            } else if (axi.m7358a(file2.getName())) {
                                                a2.f10694f++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        DirectoryPageFragment.this.f10679d.obtainMessage(0, arrayList2).sendToTarget();
                    }
                }
            }
        }).start();
    }

    /* renamed from: com.inshot.xplayer.fragments.c$c */
    private class C2686c extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
        C2686c() {
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C2685b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_folder_explorer, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            C2684a aVar = (C2684a) DirectoryPageFragment.this.f10678c.get(i);
            C2685b bVar = (C2685b) viewHolder;
            bVar.f10698a.setText(aVar.f10690b);
            if (!aVar.f10691c) {
                bVar.f10699b.setVisibility(8);
                bVar.f10700c.setImageResource(aVar.f10695g ? R.drawable.ic_video : R.drawable.ic_unknow);
            } else {
                bVar.f10699b.setVisibility(0);
                bVar.f10700c.setImageResource(R.mipmap.ic_folder);
                bVar.f10699b.setText("");
                if (aVar.f10692d) {
                    bVar.f10699b.setText(R.string.directory_empty);
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (aVar.f10693e > 0) {
                        sb.append(DirectoryPageFragment.this.getString(aVar.f10693e == 1 ? R.string.count_sub_folder : R.string.count_sub_folders, Integer.valueOf(aVar.f10693e)));
                    }
                    if (aVar.f10694f > 0) {
                        if (sb.length() > 0) {
                            sb.append(", ");
                        }
                        sb.append(DirectoryPageFragment.this.getString(aVar.f10694f == 1 ? R.string.count_media_file : R.string.count_media_files, Integer.valueOf(aVar.f10694f)));
                    }
                    if (sb.length() == 0 && aVar.f10694f == 0) {
                        sb.append(DirectoryPageFragment.this.getString(R.string.count_media_file, 0));
                    }
                    bVar.f10699b.setText(sb);
                }
            }
            bVar.itemView.setTag(aVar);
            bVar.itemView.setOnClickListener(this);
        }

        public int getItemCount() {
            if (DirectoryPageFragment.this.f10678c != null) {
                return DirectoryPageFragment.this.f10678c.size();
            }
            return 0;
        }

        public void onClick(View view) {
            if (DirectoryPageFragment.this.mo17989b() && (view.getTag() instanceof C2684a)) {
                ((FileExplorerActivity) DirectoryPageFragment.this.getActivity()).mo17665a((C2684a) view.getTag());
            }
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.c$b */
    private class C2685b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final TextView f10698a;

        /* renamed from: b */
        final TextView f10699b;

        /* renamed from: c */
        final ImageView f10700c;

        C2685b(View view) {
            super(view);
            this.f10698a = (TextView) view.findViewById(R.id.name);
            this.f10699b = (TextView) view.findViewById(R.id.count);
            this.f10700c = (ImageView) view.findViewById(R.id.icon);
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.c$a */
    public class C2684a {

        /* renamed from: a */
        public String f10689a;

        /* renamed from: b */
        public String f10690b;

        /* renamed from: c */
        public boolean f10691c;

        /* renamed from: d */
        public boolean f10692d;

        /* renamed from: e */
        public int f10693e = -1;

        /* renamed from: f */
        public int f10694f = -1;

        /* renamed from: g */
        public boolean f10695g;

        /* renamed from: h */
        public RecentMediaStorage.DBBean f10696h;

        public C2684a() {
        }

        /* renamed from: a */
        public C2684a mo18005a() {
            C2684a aVar = new C2684a();
            aVar.f10689a = this.f10689a;
            aVar.f10690b = this.f10690b;
            aVar.f10691c = this.f10691c;
            aVar.f10692d = this.f10692d;
            aVar.f10693e = this.f10693e;
            aVar.f10694f = this.f10694f;
            aVar.f10695g = this.f10695g;
            aVar.f10696h = this.f10696h;
            return aVar;
        }
    }
}
