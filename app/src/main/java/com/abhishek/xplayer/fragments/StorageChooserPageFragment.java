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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.application.MyApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import classesdef.player.awr;
import classesdef.xdplayer.axy;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.fragments.h */
public class StorageChooserPageFragment extends FragmentLifecycle implements SwipeRefreshLayout.OnRefreshListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C2720b f10799a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SwipeRefreshLayout f10800b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<C2721c> f10801c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Handler f10802d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f10803e;

    /* renamed from: f */
    private ActionBar f10804f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10802d = new Handler(Looper.myLooper()) {
            public void handleMessage(Message message) {
                if (StorageChooserPageFragment.this.mo17989b()) {
                    super.handleMessage(message);
                    if (message.obj != null) {
                        List unused = StorageChooserPageFragment.this.f10801c = (List) message.obj;
                        if (StorageChooserPageFragment.this.f10803e) {
                            StorageChooserPageFragment.this.f10799a.notifyDataSetChanged();
                        }
                        if (StorageChooserPageFragment.this.f10800b != null && StorageChooserPageFragment.this.f10800b.isRefreshing()) {
                            StorageChooserPageFragment.this.f10800b.setRefreshing(false);
                        }
                    }
                }
            }
        };
        this.f10799a = new C2720b();
        if (this.f10801c == null) {
            m12369a();
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        FileExplorerActivity.fragmentName = "StorageChooserPage";
        super.onResume();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_list_refresh, viewGroup, false);
        this.f10800b = (SwipeRefreshLayout) inflate.findViewById(R.id.SwipeRefreshLayout);
        this.f10800b.setEnabled(true);
        this.f10800b.setOnRefreshListener(this);
        this.f10800b.setColorSchemeResources(R.color.refresh_color_1, R.color.refresh_color_2, R.color.refresh_color_3);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getApplicationContext_(), 1, false));
        recyclerView.setAdapter(this.f10799a);
        this.f10804f = ((AppCompatActivity) getActivity()).getSupportActionBar();
        this.f10804f.setDisplayHomeAsUpEnabled(true);
        this.f10804f.setDisplayShowHomeEnabled(true);
        this.f10804f.setHomeAsUpIndicator((int) R.drawable.ic_back);
        this.f10804f.setSubtitle((CharSequence) null);
        this.f10804f.setTitle((int) R.string.directories);
        setHasOptionsMenu(true);
        this.f10803e = true;
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
        if (this.f10800b != null) {
            this.f10800b.setRefreshing(false);
            this.f10800b.destroyDrawingCache();
            this.f10800b.clearAnimation();
        }
    }

    public void onDestroyView() {
        this.f10803e = false;
        this.f10800b = null;
        super.onDestroyView();
    }

    public void onRefresh() {
        m12369a();
    }

    /* renamed from: a */
    private void m12369a() {
        final String string = getString(R.string.internal_sd);
        new Thread(new Runnable() {
            public void run() {
                ArrayList<String> d = awr.m7190d();
                ArrayList arrayList = new ArrayList(d.size() + 1);
                arrayList.add(new C2721c(awr.f6137a, string, false));
                Iterator<String> it = d.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null && new File(next).exists()) {
                        arrayList.add(new C2721c(next, axy.m7461a(next, next), true));
                    }
                }
                StorageChooserPageFragment.this.f10802d.obtainMessage(0, arrayList).sendToTarget();
            }
        }).start();
    }

    /* renamed from: com.inshot.xplayer.fragments.h$b */
    private class C2720b extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
        C2720b() {
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C2719a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_folder_explorer, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            C2721c cVar = (C2721c) StorageChooserPageFragment.this.f10801c.get(i);
            C2719a aVar = (C2719a) viewHolder;
            aVar.f10808a.setText(cVar.f10815c);
            aVar.f10809b.setVisibility(8);
            aVar.f10810c.setImageResource(cVar.f10816d ? R.mipmap.ic_folder_sd : R.mipmap.ic_folder);
            aVar.itemView.setTag(cVar);
            aVar.itemView.setOnClickListener(this);
        }

        public int getItemCount() {
            if (StorageChooserPageFragment.this.f10801c != null) {
                return StorageChooserPageFragment.this.f10801c.size();
            }
            return 0;
        }

        public void onClick(View view) {
            if (StorageChooserPageFragment.this.mo17989b() && (view.getTag() instanceof C2721c)) {
                ((FileExplorerActivity) StorageChooserPageFragment.this.getActivity()).mo17666a(((C2721c) view.getTag()).f10814b);
            }
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.h$a */
    private class C2719a extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final TextView f10808a;

        /* renamed from: b */
        final TextView f10809b;

        /* renamed from: c */
        final ImageView f10810c;

        C2719a(View view) {
            super(view);
            this.f10808a = (TextView) view.findViewById(R.id.name);
            this.f10809b = (TextView) view.findViewById(R.id.count);
            this.f10810c = (ImageView) view.findViewById(R.id.icon);
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.h$c */
    private class C2721c {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f10814b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f10815c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f10816d;

        private C2721c(String str, String str2, boolean z) {
            this.f10814b = str;
            this.f10815c = str2;
            this.f10816d = z;
        }
    }
}
