package com.abhishek.xplayer.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.PopupMenu;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.application.AppActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.C2624a;
import com.abhishek.xplayer.content.C2625b;
import com.abhishek.xplayer.content.MediaFileInfo;
import com.abhishek.xplayer.content.RecentMediaStorage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import classesdef.eventbus.awi;
import classesdef.eventbus.awj;
import classesdef.inplayer.awt;
import classesdef.inplayer.axi;
import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.avt;
import classesdef.xdplayer.awy;
import classesdef.xdplayer.axa;
import classesdef.xdplayer.axe;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import hdplayer.xdplayer.videoplayer.R;

/* renamed from: com.inshot.xplayer.fragments.g */
public class SearchPageFragment extends FragmentLifecycle implements AdapterView.OnItemClickListener, AppActivity.Toolbarinterface {

    /* renamed from: a */
    axa f10748a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ListView f10749b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AppCompatEditText f10750c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ArrayList<String> f10751d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2624a f10752e;

    /* renamed from: f */
    private ArrayList<MediaFileInfo> f10753f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C2713b f10754g;

    /* renamed from: h */
    private List<C2624a> f10755h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f10756i;

    /* renamed from: j */
    private avt f10757j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f10758k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f10759l = "searchPage";

    /* renamed from: m */
    private PopupMenu f10760m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Handler f10761n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public View.OnTouchListener f10762o = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!SearchPageFragment.this.f10763p) {
                return false;
            }
            SearchPageFragment.this.m12316a(false, (View) SearchPageFragment.this.f10750c);
            boolean unused = SearchPageFragment.this.f10763p = false;
            return true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f10763p;

    /* renamed from: q */
    private View.OnClickListener f10764q = new View.OnClickListener() {
        public void onClick(View view) {
            if (view.getId() == R.id.back_search) {
                if (SearchPageFragment.this.mo17989b()) {
                    if (!SearchPageFragment.this.mo17990c()) {
                        SearchPageFragment.this.getActivity().onBackPressed();
                    }
                    LogEvents.m18492b(SearchPageFragment.this.f10759l, "back");
                }
            } else if (view.getId() == R.id.close_search) {
                if (SearchPageFragment.this.f10750c != null) {
                    SearchPageFragment.this.f10750c.setText("");
                }
                LogEvents.m18492b(SearchPageFragment.this.f10759l, "clearKeyword");
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: r */
    public List<MediaFileInfo> f10765r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C2625b f10766s;

    /* renamed from: t */
    private ProgressDialog f10767t;

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10761n = new Handler(Looper.myLooper()) {
            public void handleMessage(Message message) {
                if (SearchPageFragment.this.mo17989b()) {
                    super.handleMessage(message);
                    if (SearchPageFragment.this.f10752e != null && SearchPageFragment.this.f10752e.f10547c != null) {
                        HashMap hashMap = (HashMap) message.obj;
                        for (MediaFileInfo next : SearchPageFragment.this.f10752e.f10547c) {
                            String d = next.mo17890d();
                            if (d != null) {
                                Object obj = hashMap.get(d);
                                if (obj instanceof RecentMediaStorage.DBBean) {
                                    next.mo17883a((RecentMediaStorage.DBBean) obj);
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m12330d();
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.search_panel, (ViewGroup) null, false);
        m12306a(inflate);
        if (getActivity() != null && (getActivity() instanceof AppActivity)) {
            ((AppActivity) getActivity()).setToolbarInstance(this);
        }
        if (this.f10751d == null) {
            this.f10751d = new ArrayList<>();
        }
        if (this.f10753f == null) {
            this.f10753f = new ArrayList<>();
        }
        if (m12338f() != null && m12338f().size() > 0) {
            this.f10751d = m12338f();
            m12334e();
        }
        if (this.f10757j == null) {
         //   this.f10757j = new avw();
        }
        this.f10754g = new C2713b();
        this.f10758k = inflate;
        this.f10758k.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (SearchPageFragment.this.mo17989b()) {
                    Rect rect = new Rect();
                    SearchPageFragment.this.f10758k.getWindowVisibleDisplayFrame(rect);
                    int a = axw.m7445a(SearchPageFragment.this.getResources());
                    int height = SearchPageFragment.this.f10758k.getRootView().getHeight() - (rect.bottom - rect.top);
                    if (SearchPageFragment.this.f10763p) {
                        if (height - a < 150) {
                            boolean unused = SearchPageFragment.this.f10763p = false;
                        }
                    } else if (height - a > 150) {
                        boolean unused2 = SearchPageFragment.this.f10763p = true;
                    }
                }
            }
        });
        return this.f10758k;
    }

    /* renamed from: d */
    private void m12330d() {
        if (mo17989b() && getActivity() != null) {
            ((AppActivity) getActivity()).getSupportActionBar().hide();
        }
    }

    /* renamed from: a */
    private void m12306a(final View view) {
        if (mo17989b()) {
            this.f10749b = (ListView) view.findViewById(R.id.search_result);
            this.f10749b.setOnItemClickListener(this);
            view.findViewById(R.id.back_search).setOnClickListener(this.f10764q);
            view.findViewById(R.id.close_search).setOnClickListener(this.f10764q);
            this.f10750c = (AppCompatEditText) view.findViewById(R.id.search_keyword);
            this.f10750c.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (SearchPageFragment.this.f10749b.getAdapter() == null || (SearchPageFragment.this.f10749b.getAdapter() instanceof C2711a)) {
                        SearchPageFragment.this.f10749b.setEmptyView(view.findViewById(R.id.empty_result_hint));
                        SearchPageFragment.this.f10749b.setAdapter(SearchPageFragment.this.f10754g);
                        SearchPageFragment.this.f10749b.setOnTouchListener(SearchPageFragment.this.f10762o);
                    }
                    SearchPageFragment.this.m12313a(charSequence);
                }
            });
            this.f10750c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        SearchPageFragment.this.m12316a(false, (View) SearchPageFragment.this.f10750c);
                    }
                }
            });
            this.f10750c.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 3) {
                        return false;
                    }
                    SearchPageFragment.this.m12316a(false, (View) SearchPageFragment.this.f10750c);
                    return true;
                }
            });
            this.f10750c.post(new Runnable() {
                public void run() {
                    SearchPageFragment.this.f10750c.requestFocus();
                    SearchPageFragment.this.m12316a(true, (View) SearchPageFragment.this.f10750c);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12313a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (this.f10749b.getEmptyView() != null) {
                ((TextView) this.f10749b.getEmptyView()).setText("");
            }
            this.f10749b.setAdapter(new C2711a());
        } else if (this.f10749b.getEmptyView() != null) {
            ((TextView) this.f10749b.getEmptyView()).setText(R.string.search_no_result);
        }
        m12344h();
        m12314a(charSequence.toString());
        if (this.f10749b.getAdapter() != null && (this.f10749b.getAdapter() instanceof C2713b)) {
            ((C2713b) this.f10749b.getAdapter()).mo18039a(charSequence);
            ((C2713b) this.f10749b.getAdapter()).notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    private void m12314a(String str) {
        if (this.f10752e != null && this.f10752e.f10547c != null) {
            if (this.f10753f.size() > 0) {
                this.f10752e.f10547c.addAll(this.f10753f);
            }
            this.f10753f.clear();
            if (TextUtils.isEmpty(str)) {
                this.f10753f.addAll(this.f10752e.f10547c);
                this.f10752e.f10547c.clear();
                return;
            }
            for (int i = 0; i < this.f10752e.f10547c.size(); i++) {
                MediaFileInfo mediaFileInfo = this.f10752e.f10547c.get(i);
                if (!mediaFileInfo.mo17892e().contains(str) && !mediaFileInfo.mo17892e().toLowerCase().contains(str.toLowerCase())) {
                    this.f10753f.add(mediaFileInfo);
                }
            }
            this.f10752e.f10547c.removeAll(this.f10753f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12316a(boolean z, View view) {
        if (getActivity() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (z) {
                inputMethodManager.showSoftInput(view, 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* renamed from: e */
    private void m12334e() {
        this.f10749b.setAdapter(new C2711a());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12322b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f10751d.contains(str)) {
                this.f10751d.remove(str);
            }
            if (this.f10751d.size() >= 5) {
                this.f10751d.remove(this.f10751d.size() - 1);
            }
            this.f10751d.add(0, str);
        }
    }

    /* renamed from: f */
    private ArrayList<String> m12338f() {
        ArrayList<String> arrayList = null;
        String string = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getString("search_history", (String) null);
        if (!TextUtils.isEmpty(string)) {
            arrayList = new ArrayList<>();
            if (string.contains(":")) {
                String[] split = string.split(":");
                for (String add : split) {
                    arrayList.add(add);
                }
            } else {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    private void m12341g() {
        if (this.f10751d != null) {
            String str = "";
            for (int i = 0; i < this.f10751d.size(); i++) {
                if (i == this.f10751d.size() - 1) {
                    str = str + this.f10751d.get(i);
                } else {
                    str = str + this.f10751d.get(i) + ":";
                }
            }
            SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putString("search_history", str).apply();
        }
    }

    public void onPause() {
        super.onPause();
        m12341g();
        if (this.f10760m != null) {
            this.f10760m.dismiss();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        m12344h();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f10756i) {
            this.f10756i = false;
            EventBus.getDefault().unregister(this);
        }
    }

    public void onStop() {
        super.onStop();
        setToolbar();
    }

    public void onResume() {
        FileExplorerActivity.fragmentName = this.f10759l;
        super.onResume();
        if (mo17989b()) {
            ((FileExplorerActivity) getActivity()).getSupportActionBar().hide();
        }
    }

    /* renamed from: a */
    private void m12315a(boolean z) {
        Runnable r1;
        if (this.f10752e == null || this.f10752e.f10547c == null || this.f10752e.f10547c.isEmpty()) {
            r1 = null;
        } else {
            final ArrayList arrayList = new ArrayList(this.f10752e.f10547c.size());
            for (MediaFileInfo d : this.f10752e.f10547c) {
                arrayList.add(d.mo17890d());
            }
            r1 = new Runnable() {
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
                    SearchPageFragment.this.f10761n.obtainMessage(0, hashMap).sendToTarget();
                }
            };
        }
        if (r1 == null) {
            return;
        }
        if (z) {
            RecentMediaStorage.m12069a().execute(r1);
        } else {
            new Thread(r1).start();
        }
    }

    /* renamed from: a */
    public void mo18015a(C2624a aVar) {
        this.f10752e = aVar;
    }

    /* renamed from: a */
    public void mo18016a(List<C2624a> list) {
        this.f10755h = list;
    }

    /* renamed from: h */
    private void m12344h() {
        if (this.f10753f != null && this.f10753f.size() > 0) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<MediaFileInfo> it = this.f10753f.iterator();
            while (it.hasNext()) {
                MediaFileInfo next = it.next();
                for (int i = 0; i < this.f10752e.f10547c.size(); i++) {
                    MediaFileInfo mediaFileInfo = this.f10752e.f10547c.get(i);
                    if (mediaFileInfo.mo17890d().equals(next.mo17890d())) {
                        linkedHashSet.add(mediaFileInfo);
                    }
                }
            }
            if (linkedHashSet.size() > 0) {
                this.f10752e.f10547c.removeAll(linkedHashSet);
            }
            this.f10752e.f10547c.addAll(this.f10753f);
            this.f10753f.clear();
        }
    }

    /* renamed from: a */
    public boolean setToolbar() {
        if (!mo17989b()) {
            return false;
        }
        ((AppActivity) getActivity()).getSupportActionBar().show();
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView.getAdapter() != null) {
            if (!(adapterView.getAdapter() instanceof C2711a)) {
                MediaFileInfo mediaFileInfo = this.f10752e.f10547c.get(i);
                C2624a a = m12302a(mediaFileInfo);
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) getActivity();
                if (a == null) {
                    a = this.f10752e;
                }
                fileExplorerActivity.mo17664a(a, mediaFileInfo, this, 1365);
                m12322b(this.f10750c.getText().toString());
                LogEvents.m18492b(this.f10759l, "searchResult");
            } else if (view.getTag() != null) {
                this.f10750c.setText(view.getTag().toString());
                this.f10750c.setSelection(this.f10750c.getText().toString().length());
                LogEvents.m18492b(this.f10759l, "searchHistory");
            }
        }
    }

    /* renamed from: a */
    private C2624a m12302a(MediaFileInfo mediaFileInfo) {
        if (this.f10755h == null || this.f10752e == null) {
            return null;
        }
        for (C2624a next : this.f10755h) {
            Iterator<MediaFileInfo> it = next.f10547c.iterator();
            while (true) {
                if (it.hasNext()) {
                    MediaFileInfo next2 = it.next();
                    if (!next.equals(this.f10752e) && mediaFileInfo.mo17890d().equals(next2.mo17890d())) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (mo17989b() && i == 1365) {
            m12315a(true);
        } else if (i != 52131) {
        } else {
            if (this.f10766s != null) {
                this.f10766s.mo17931a(i2, intent);
            } else if (this.f10748a != null) {
                this.f10748a.mo10928a(i2, intent);
            }
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.g$a */
    private class C2711a extends BaseAdapter {
        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        private C2711a() {
        }

        public int getCount() {
            if (SearchPageFragment.this.f10751d == null || SearchPageFragment.this.f10751d.size() == 0) {
                return 0;
            }
            return SearchPageFragment.this.f10751d.size() + 1;
        }

        public int getItemViewType(int i) {
            if (i == 0) {
                return 1;
            }
            return super.getItemViewType(i);
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            if (getItemViewType(i) == 1) {
                return new C2715c(View.inflate(SearchPageFragment.this.getActivity(), R.layout.history_title, (ViewGroup) null)).mo18046a();
            }
            C2715c cVar = new C2715c(View.inflate(SearchPageFragment.this.getActivity(), R.layout.history_item, (ViewGroup) null));
            int i2 = i - 1;
            cVar.mo18048b(R.id.history_title).setText(SearchPageFragment.this.f10751d.toArray()[i2].toString());
            cVar.mo18046a().setTag(SearchPageFragment.this.f10751d.toArray()[i2].toString());
            cVar.mo18049c(R.id.history_close).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SearchPageFragment.this.f10751d.remove(SearchPageFragment.this.f10751d.toArray()[i - 1].toString());
                    C2711a.this.notifyDataSetChanged();
                    LogEvents.m18492b(SearchPageFragment.this.f10759l, "clearHistory");
                }
            });
            return cVar.mo18046a();
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.g$b */
    class C2713b extends BaseAdapter implements View.OnClickListener {

        /* renamed from: b */
        private CharSequence f10792b;

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        C2713b() {
        }

        /* renamed from: a */
        public void mo18039a(CharSequence charSequence) {
            this.f10792b = charSequence;
        }

        public int getCount() {
            if (SearchPageFragment.this.f10752e == null || SearchPageFragment.this.f10752e.f10547c == null) {
                return 0;
            }
            return SearchPageFragment.this.f10752e.f10547c.size();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C2715c cVar = new C2715c(View.inflate(SearchPageFragment.this.getActivity(), R.layout.search_result_item, (ViewGroup) null));
            MediaFileInfo mediaFileInfo = SearchPageFragment.this.f10752e.f10547c.get(i);
            String e = mediaFileInfo.mo17892e();
            if (TextUtils.isEmpty(this.f10792b) || !e.toLowerCase().contains(this.f10792b.toString().toLowerCase())) {
                TextView b = cVar.mo18048b(R.id.play_list_title);
                b.setText(e + "");
            } else {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SearchPageFragment.this.getResources().getColor(R.color.colorAccent));
                SpannableString spannableString = new SpannableString(e);
                spannableString.setSpan(foregroundColorSpan, e.toLowerCase().indexOf(this.f10792b.toString().toLowerCase()), e.toLowerCase().indexOf(this.f10792b.toString().toLowerCase()) + this.f10792b.length(), 18);
                cVar.mo18048b(R.id.play_list_title).setText(spannableString);
            }
            cVar.mo18048b(R.id.duration).setText(mediaFileInfo.mo17894g());
            cVar.mo18047a(R.id.more).setOnClickListener(this);
            cVar.mo18047a(R.id.more).setTag(mediaFileInfo);
            cVar.mo18046a().setTag(mediaFileInfo);
            Glide.with(getActivity()).load(mediaFileInfo.mo17890d()).asBitmap().centerCrop().decoder((ResourceDecoder<ImageVideoWrapper, Bitmap>) new awy(mediaFileInfo.mo17890d(), SearchPageFragment.this.getContext(), mediaFileInfo.mo17893f())).into(cVar.mo18049c(R.id.icon));
            return cVar.mo18046a();
        }

        public void onClick(View view) {
            LogEvents.m18492b(SearchPageFragment.this.f10759l, "more");
            m12362a(view, (MediaFileInfo) view.getTag());
        }

        /* renamed from: a */
        private void m12362a(View view, final MediaFileInfo mediaFileInfo) {
            SearchPageFragment.this.m12316a(false, (View) SearchPageFragment.this.f10750c);
            final BottomSheetDialog cVar = new BottomSheetDialog(view.getContext());
            View inflate = View.inflate(view.getContext(), R.layout.bottom_sheet_search, (ViewGroup) null);
            View.OnClickListener r1 = new View.OnClickListener() {
                public void onClick(View view) {
                    int id = view.getId();
                    if (id == R.id.locate) {
                        SearchPageFragment.this.m12320b(mediaFileInfo);
                        LogEvents.m18492b(SearchPageFragment.this.f10759l, "locateVideo");
                    } else if (id == R.id.info) {
                        SearchPageFragment.this.m12331d(mediaFileInfo);
                        LogEvents.m18492b(SearchPageFragment.this.f10759l, "properties");
                    } else if (id == R.id.lock) {
                        SearchPageFragment.this.m12335e(mediaFileInfo);
                        LogEvents.m18492b(SearchPageFragment.this.f10759l, "lockVideo");
                    } else if (id == R.id.delete) {
                        SearchPageFragment.this.m12339f(mediaFileInfo);
                        LogEvents.m18492b(SearchPageFragment.this.f10759l, "deleteVideo");
                    } else if (id == R.id.share) {
                        axy.m7463a((Activity) SearchPageFragment.this.getActivity(), mediaFileInfo.mo17890d(), "video/*");
                        LogEvents.m18492b(SearchPageFragment.this.f10759l, "share");
                    }
                    SearchPageFragment.this.m12322b(SearchPageFragment.this.f10750c.getText().toString());
                    cVar.dismiss();
                }
            };
            inflate.findViewById(R.id.locate).setOnClickListener(r1);
            inflate.findViewById(R.id.lock).setOnClickListener(r1);
            inflate.findViewById(R.id.delete).setOnClickListener(r1);
            inflate.findViewById(R.id.info).setOnClickListener(r1);
            inflate.findViewById(R.id.share).setOnClickListener(r1);
            ((TextView) inflate.findViewById(R.id.sheet_title)).setText(mediaFileInfo.mo17892e());
            cVar.setContentView(inflate);
            View view2 = (View) inflate.getParent();
            BottomSheetBehavior b = BottomSheetBehavior.from(view2);
            inflate.measure(0, 0);
            b.setExpandedOffset(inflate.getMeasuredHeight());
            CoordinatorLayout.LayoutParams cVar2 = (CoordinatorLayout.LayoutParams) view2.getLayoutParams();
            cVar2.anchorGravity = 49;
            view2.setLayoutParams(cVar2);
            cVar.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12320b(MediaFileInfo mediaFileInfo) {
        if (mo17989b()) {
            VideoListPrivateVideoListFragment a = VideoListPrivateVideoListFragment.m12406a(m12325c(mediaFileInfo), false);
            a.mo18064a(mediaFileInfo);
            AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), a, true);
        }
    }

    /* renamed from: c */
    private C2624a m12325c(MediaFileInfo mediaFileInfo) {
        C2624a aVar = null;
        if (this.f10755h == null) {
            return null;
        }
        for (int i = 0; i < this.f10755h.size(); i++) {
            for (MediaFileInfo d : this.f10755h.get(i).f10547c) {
                if (mediaFileInfo.mo17890d().equals(d.mo17890d())) {
                    aVar = this.f10755h.get(i);
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m12331d(MediaFileInfo mediaFileInfo) {
        AlertDialog.Builder builder;
        if (mo17989b() && mediaFileInfo != null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_property, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(R.id.value_name)).setText(mediaFileInfo.mo17892e());
            ((TextView) inflate.findViewById(R.id.value_location)).setText(new File(mediaFileInfo.mo17890d()).getParent());
            ((TextView) inflate.findViewById(R.id.value_size)).setText(String.format(Locale.ENGLISH, "%s (%s bytes)", new Object[]{awt.m7196a(mediaFileInfo.f10496a), NumberFormat.getNumberInstance(Locale.US).format(mediaFileInfo.f10496a)}));
            ((TextView) inflate.findViewById(R.id.value_date)).setText(DateFormat.getDateInstance(0).format(new Date(mediaFileInfo.mo17895h())));
            ((TextView) inflate.findViewById(R.id.value_length)).setText(axy.m7459a(mediaFileInfo.mo17893f()));
            String e = axe.m7324e(mediaFileInfo.mo17892e());
            if (e == null) {
                inflate.findViewById(R.id.format_layout).setVisibility(8);
            } else {
                ((TextView) inflate.findViewById(R.id.value_format)).setText(e);
            }
            String c = axi.m7360c(mediaFileInfo.mo17890d());
            if (c == null) {
                inflate.findViewById(R.id.resolution_layout).setVisibility(8);
            } else {
                ((TextView) inflate.findViewById(R.id.value_resolution)).setText(c);
            }
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setTitle((int) R.string.properties).setView(inflate).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f10760m != null) {
            this.f10760m.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m12335e(MediaFileInfo mediaFileInfo) {
        ArrayList arrayList = new ArrayList();
        if (!(this.f10752e == null || this.f10752e.f10547c == null)) {
            arrayList.add(mediaFileInfo);
        }
        m12323b((List<MediaFileInfo>) arrayList);
    }

    /* renamed from: b */
    private void m12323b(final List<MediaFileInfo> list) {
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
                    if (SearchPageFragment.this.mo17989b()) {
                        dialogInterface.dismiss();
                        if (PasswordFragment.m12273a()) {
                            SearchPageFragment.this.m12327c((List<MediaFileInfo>) list);
                            return;
                        }
                        if (!SearchPageFragment.this.f10756i) {
                            boolean unused = SearchPageFragment.this.f10756i = true;
                            EventBus.getDefault().post((Object) SearchPageFragment.this);
                        }
                        List unused2 = SearchPageFragment.this.f10765r = list;
                        AppActivity.loadFragmet(SearchPageFragment.this.getActivity().getSupportFragmentManager(), PasswordFragment.m12270a(2), true);
                    }
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPinSet(awi awi) {
        if (mo17989b() && this.f10765r != null) {
            m12327c(this.f10765r);
            this.f10765r = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12327c(List<MediaFileInfo> list) {
        this.f10766s = new C2625b();
        this.f10766s.mo17933a(list, (C2625b.C2630d) new C2625b.C2630d() {
            /* renamed from: a */
            public void mo17939a(Set<String> set, int i, int i2, String str, boolean z) {
                String str2;
                AlertDialog.Builder builder;
                C2625b unused = SearchPageFragment.this.f10766s = null;
                if (SearchPageFragment.this.mo17989b()) {
                    SearchPageFragment.this.m12346i();
                    if (!(SearchPageFragment.this.f10752e == null || SearchPageFragment.this.f10752e.f10547c == null)) {
                        Iterator<MediaFileInfo> it = SearchPageFragment.this.f10752e.f10547c.iterator();
                        while (it.hasNext()) {
                            if (set.contains(it.next().mo17890d())) {
                                it.remove();
                            }
                        }
                        SearchPageFragment.this.f10754g.notifyDataSetChanged();
                    }
                    EventBus.getDefault().post(new awj());
                    if (i2 > 0) {
                        str2 = SearchPageFragment.this.getString(R.string.lock_video_success_failed, Integer.valueOf(i), Integer.valueOf(i2));
                    } else {
                        str2 = SearchPageFragment.this.getString(R.string.lock_video_success, Integer.valueOf(i)) + " " + SearchPageFragment.this.getString(R.string.lock_video_success_desc);
                    }
                    if (!z) {
                        if (str != null) {
                            str2 = str2 + "\n" + str;
                        }
                        axv.m7438a(SearchPageFragment.this.getView(), str2);
                        return;
                    }
                    if (str != null) {
                        str2 = str2 + "\n\n" + str;
                    }
                    if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                        builder = new AlertDialog.Builder(SearchPageFragment.this.getActivity(), R.style.MyAlertStyle);
                    } else {
                        builder = new AlertDialog.Builder(SearchPageFragment.this.getActivity());
                    }
                    builder.setMessage((CharSequence) str2).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                }
            }

            /* renamed from: a */
            public void mo17938a(String str) {
                AlertDialog.Builder builder;
                C2625b unused = SearchPageFragment.this.f10766s = null;
                if (SearchPageFragment.this.mo17989b()) {
                    if (str != null) {
                        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                            builder = new AlertDialog.Builder(SearchPageFragment.this.getActivity(), R.style.MyAlertStyle);
                        } else {
                            builder = new AlertDialog.Builder(SearchPageFragment.this.getActivity());
                        }
                        builder.setTitle((CharSequence) SearchPageFragment.this.getString(R.string.lock_failed)).setMessage((CharSequence) str).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                    } else {
                        axv.m7434a((int) R.string.lock_failed);
                    }
                    SearchPageFragment.this.m12346i();
                }
            }

            /* renamed from: a */
            public void mo17937a() {
                if (SearchPageFragment.this.mo17989b()) {
                    SearchPageFragment.this.m12305a((int) R.string.lock, true);
                }
            }

            /* renamed from: c */
            public void mo17943c(String str) {
                if (SearchPageFragment.this.mo17989b()) {
                    SearchPageFragment.this.m12346i();
                    if (SearchPageFragment.this.f10766s != null) {
                        SearchPageFragment.this.f10766s.mo17932a((Fragment) SearchPageFragment.this, 52131);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12305a(int i, boolean z) {
        if (mo17989b()) {
            if (this.f10767t == null) {
                if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                    this.f10767t = new ProgressDialog(getActivity(), R.style.MyAlertStyle);
                } else {
                    this.f10767t = new ProgressDialog(getActivity());
                }
                this.f10767t.setCancelable(false);
                this.f10767t.setIndeterminate(true);
            }
            String string = getString(i);
            if (z) {
                string = string + "...";
            }
            this.f10767t.setMessage(string);
            this.f10767t.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m12346i() {
        if (this.f10767t != null) {
            this.f10767t.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m12339f(final MediaFileInfo mediaFileInfo) {
        AlertDialog.Builder builder;
        if (mo17989b()) {
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setTitle((int) R.string.delete_video_dialog_title).setMessage((int) R.string.delete_video_dialog_desc).setPositiveButton((int) R.string.delete, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    SearchPageFragment.this.m12342g(mediaFileInfo);
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m12342g(final MediaFileInfo mediaFileInfo) {
        if (mo17989b()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediaFileInfo.mo17890d());
            final Runnable r1 = new Runnable() {
                public void run() {
                    if (SearchPageFragment.this.mo17989b()) {
                        SearchPageFragment.this.m12346i();
                        if (!(SearchPageFragment.this.f10752e == null || SearchPageFragment.this.f10752e.f10547c == null)) {
                            Iterator<MediaFileInfo> it = SearchPageFragment.this.f10752e.f10547c.iterator();
                            while (it.hasNext()) {
                                if (mediaFileInfo.mo17890d().equals(it.next().mo17890d())) {
                                    it.remove();
                                }
                            }
                            SearchPageFragment.this.f10754g.notifyDataSetChanged();
                        }
                        axv.m7436a(SearchPageFragment.this.getView(), (int) R.string.delete_success);
                        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt("media_size", PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("media_size", 0) - 1).apply();
                    }
                }
            };
            EventBus.getDefault().post(new awj());
            this.f10748a = new axa(arrayList, new axa.C1330a() {
                /* renamed from: a */
                public void mo10938a() {
                    SearchPageFragment.this.f10748a = null;
                    r1.run();
                }

                /* renamed from: b */
                public void mo10939b() {
                    AlertDialog.Builder builder;
                    SearchPageFragment.this.f10748a = null;
                    if (SearchPageFragment.this.mo17989b()) {
                        SearchPageFragment.this.m12346i();
                        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                            builder = new AlertDialog.Builder(SearchPageFragment.this.getActivity(), R.style.MyAlertStyle);
                        } else {
                            builder = new AlertDialog.Builder(SearchPageFragment.this.getActivity());
                        }
                        builder.setTitle((int) R.string.delete_failed).setMessage((int) R.string.delete_failed_cant_write).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).show();
                    }
                }

                /* renamed from: c */
                public void mo10940c() {
                    if (SearchPageFragment.this.mo17989b()) {
                        SearchPageFragment.this.m12346i();
                        if (SearchPageFragment.this.f10748a != null) {
                            SearchPageFragment.this.f10748a.mo10929a((Fragment) SearchPageFragment.this, 52131);
                        }
                    }
                }

                /* renamed from: d */
                public void mo10941d() {
                    if (SearchPageFragment.this.mo17989b()) {
                        SearchPageFragment.this.m12305a((int) R.string.delete, true);
                    }
                }
            });
            this.f10748a.mo10930a(true);
        }
    }

    /* renamed from: com.inshot.xplayer.fragments.g$c */
    private class C2715c {

        /* renamed from: b */
        private SparseArray<View> f10797b;

        /* renamed from: c */
        private View f10798c;

        public C2715c(View view) {
            if (this.f10797b == null) {
                this.f10797b = new SparseArray<>();
            }
            this.f10798c = view;
        }

        /* renamed from: a */
        public View mo18046a() {
            return this.f10798c;
        }

        /* renamed from: a */
        public <T extends View> T mo18047a(int i) {
            T t = (T) this.f10797b.get(i);
            if (t == null && (t = this.f10798c.findViewById(i)) != null) {
                this.f10797b.put(i, t);
            }
            return t;
        }

        /* renamed from: b */
        public TextView mo18048b(int i) {
            return (TextView) mo18047a(i);
        }

        /* renamed from: c */
        public ImageView mo18049c(int i) {
            return (ImageView) mo18047a(i);
        }
    }
}
