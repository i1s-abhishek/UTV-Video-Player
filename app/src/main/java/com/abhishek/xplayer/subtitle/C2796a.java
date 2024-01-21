package com.abhishek.xplayer.subtitle;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.abhishek.inplayer.widget.C2481e;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.utils.widget.SpanClickableTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import classesdef.inplayer.awt;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.LogEvents;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.subtitle.a */
public class C2796a implements DialogInterface.OnCancelListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String[] f11144a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String[] f11145b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f11146c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Set<String> f11147d = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Set<String> f11148e = new TreeSet();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SpanClickableTextView f11149f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C2814b f11150g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f11151h;

    /* renamed from: i */
    private String f11152i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C2810a f11153j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C2481e f11154k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f11155l;

    /* renamed from: com.inshot.xplayer.subtitle.a$a */
    public interface C2810a {
        /* renamed from: a */
        void mo17600a();

        /* renamed from: a */
        void mo17601a(String str, String str2);

        /* renamed from: b */
        void mo17602b();
    }

    /* renamed from: a */
    private static void m12724a(Context context) {
        if (f11145b == null || f11144a == null) {
            String[] stringArray = context.getResources().getStringArray(R.array.all_locale_names);
            String[] stringArray2 = context.getResources().getStringArray(R.array.all_locales);
            Pair[] pairArr = new Pair[stringArray.length];
            int length = stringArray.length;
            for (int i = 0; i < length; i++) {
                pairArr[i] = new Pair(stringArray2[i], stringArray[i]);
            }
            Arrays.sort(pairArr, new Comparator<Pair>() {
                /* renamed from: a */
                public int compare(Pair pair, Pair pair2) {
                    return ((String) pair.second).compareTo((String) pair2.second);
                }
            });
            f11145b = new String[stringArray.length];
            f11144a = new String[stringArray.length];
            int length2 = pairArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                f11144a[i2] = (String) pairArr[i2].first;
                f11145b[i2] = (String) pairArr[i2].second;
            }
        }
    }

    public C2796a(Context context) {
        this.f11146c = context;
        m12724a(context);
    }

    /* renamed from: a */
    public void mo18179a() {
        m12742e();
        this.f11150g = null;
        this.f11153j = null;
        this.f11154k = null;
    }

    /* renamed from: a */
    public void mo18180a(final String str, String str2, String str3, C2810a aVar, C2481e eVar) {
        this.f11151h = str2;
        this.f11152i = str3;
        this.f11153j = aVar;
        this.f11154k = eVar;
        m12745g();
        View inflate = LayoutInflater.from(this.f11146c).inflate(R.layout.subtitle_download, (ViewGroup) null);
        this.f11149f = (SpanClickableTextView) inflate.findViewById(R.id.search_title);
        final EditText editText = (EditText) inflate.findViewById(R.id.search_text);
        this.f11149f.setSpanText(m12743f());
        editText.setText(str);
        if (eVar != null) {
            this.f11155l = eVar.mo17544a();
        }
        new AlertDialog.Builder(this.f11146c).setTitle((int) R.string.subtitle_download).setView(inflate).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 2);
                C2796a.this.m12729a(String.valueOf(editText.getText()));
                if (!TextUtils.equals(str, String.valueOf(editText.getText()))) {
                    LogEvents.m18492b("Subtitle", "Search/Custom");
                } else {
                    LogEvents.m18492b("Subtitle", "Search/Default");
                }
            }
        }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (C2796a.this.f11155l && C2796a.this.f11154k != null) {
                    C2796a.this.f11154k.mo17543a(0);
                }
            }
        }).setOnCancelListener(this).show();
        this.f11149f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C2796a.this.m12740d();
                LogEvents.m18492b("Subtitle", "Language");
            }
        });
    }

    public void onCancel(DialogInterface dialogInterface) {
        m12742e();
        if (this.f11155l && this.f11154k != null) {
            this.f11154k.mo17543a(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m12740d() {
        boolean[] zArr = new boolean[f11145b.length];
        for (int i = 0; i < f11144a.length; i++) {
            if (this.f11147d.contains(f11144a[i])) {
                zArr[i] = true;
            }
        }
        final HashSet hashSet = new HashSet(this.f11147d);
        final TreeSet treeSet = new TreeSet(this.f11148e);
        ArrayList arrayList = new ArrayList(this.f11148e);
        View inflate = LayoutInflater.from(this.f11146c).inflate(R.layout.subtitle_language_header, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.language_selected_list);
        AlertDialog.Builder customTitle = new AlertDialog.Builder(this.f11146c).setTitle((int) R.string.language).setCustomTitle(inflate);
        final HashSet hashSet2 = hashSet;
        final TreeSet treeSet2 = treeSet;
    //    C28088 r7 = r0;
        final ArrayList arrayList2 = arrayList;
        String[] strArr = f11145b;
        final RecyclerView recyclerView2 = recyclerView;
        DialogInterface.OnMultiChoiceClickListener r7 = new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    hashSet2.add(C2796a.f11144a[i]);
                    treeSet2.add(C2796a.f11145b[i]);
                    arrayList2.add(C2796a.f11145b[i]);
                } else {
                    hashSet2.remove(C2796a.f11144a[i]);
                    treeSet2.remove(C2796a.f11145b[i]);
                    arrayList2.remove(C2796a.f11145b[i]);
                }
                recyclerView2.getAdapter().notifyDataSetChanged();
            }
        };
        AlertDialog create = customTitle.setMultiChoiceItems((CharSequence[]) strArr, zArr, (DialogInterface.OnMultiChoiceClickListener) r7).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Set unused = C2796a.this.f11147d = hashSet;
                Set unused2 = C2796a.this.f11148e = treeSet;
                if (C2796a.this.f11149f != null) {
                    C2796a.this.f11149f.setText(R.string.subtitle_search_language);
                    C2796a.this.f11149f.setSpanText(C2796a.this.m12743f());
                    LogEvents.m18492b("Subtitle", "Language/Change");
                }
                C2796a.this.m12731a((Set<String>) C2796a.this.f11147d);
            }
        }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).create();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 0));
        recyclerView.setAdapter(new C2811b(arrayList, treeSet2, hashSet, zArr, create.getListView()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            /* renamed from: b */
            private int f11178b = axw.m7444a(MyApplication.getApplicationContext_(), 10.0f);

            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.getChildLayoutPosition(view) != 0) {
                    rect.left = this.f11178b;
                }
            }
        });
        create.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12729a(String str) {
        m12742e();
        if (this.f11150g == null) {
            this.f11150g = new C2814b();
        }
        final ProgressDialog show = ProgressDialog.show(this.f11146c, (CharSequence) null, this.f11146c.getString(R.string.subtitle_searching), true, true, this);
        this.f11150g.mo18207a(new C2814b.C2819a(this.f11151h, this.f11152i, str, this.f11147d), (C2814b.C2820b) new C2814b.C2820b() {
            /* renamed from: a */
            public void mo18185a(List<C2814b.C2821c> list) {
                show.dismiss();
                C2796a.this.m12730a(list);
                StringBuilder sb = new StringBuilder();
                sb.append("Search/HasResult/");
                sb.append(!list.isEmpty());
                LogEvents.m18492b("Subtitle", sb.toString());
            }

            /* renamed from: a */
            public void mo18184a(int i) {
                show.dismiss();
                axv.m7440b(i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12730a(List<C2814b.C2821c> list) {
        if (list.isEmpty()) {
            m12742e();
            axv.m7440b(R.string.subtitle_not_found);
            return;
        }
        C2812c cVar = new C2812c(list);
        cVar.m12762a(new AlertDialog.Builder(this.f11146c).setSingleChoiceItems((ListAdapter) cVar, -1, (DialogInterface.OnClickListener) null).setTitle((int) R.string.subtitle_search_result).setPositiveButton((int) R.string.action_download, (DialogInterface.OnClickListener) cVar).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                C2796a.this.m12742e();
            }
        }).setCancelable(false).setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (C2796a.this.f11155l && C2796a.this.f11154k != null) {
                    C2796a.this.f11154k.mo17543a(0);
                }
            }
        }).show().getButton(-1));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12728a(final C2814b.C2821c cVar) {
        if (cVar != null) {
            if (this.f11153j != null) {
                this.f11153j.mo17600a();
            }
            new Thread() {
                public void run() {
                    C2814b h = C2796a.this.f11150g;
                    if (h == null) {
                        return;
                    }
                    if (h.mo18208a(cVar, C2822c.m12794d())) {
                        if (C2796a.this.f11153j != null) {
                            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                                public void run() {
                                    if (C2796a.this.f11153j != null) {
                                        C2796a.this.f11153j.mo17601a(cVar.f11218e, C2796a.this.f11151h);
                                    }
                                }
                            });
                        }
                    } else if (C2796a.this.f11153j != null) {
                        MyApplication.myApplication().runnable((Runnable) new Runnable() {
                            public void run() {
                                if (C2796a.this.f11153j != null) {
                                    C2796a.this.f11153j.mo17602b();
                                }
                            }
                        });
                    }
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m12742e() {
        if (this.f11150g != null) {
            this.f11150g.mo18206a();
            this.f11150g = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m12743f() {
        if (this.f11148e.isEmpty()) {
            m12745g();
        }
        StringBuilder sb = new StringBuilder();
        for (String next : this.f11148e) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(next);
        }
        return sb.toString();
    }

    /* renamed from: g */
    private void m12745g() {
        this.f11147d.clear();
        this.f11148e.clear();
        Set<String> h = m12748h();
        if (h.isEmpty()) {
            h.add(this.f11146c.getResources().getConfiguration().locale.getLanguage());
        }
        for (int i = 0; i < f11144a.length; i++) {
            if (h.contains(f11144a[i])) {
                this.f11147d.add(f11144a[i]);
                this.f11148e.add(f11145b[i]);
            }
        }
        if (this.f11147d.isEmpty()) {
            this.f11147d.add("en");
            this.f11148e.add("English");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12731a(Set<String> set) {
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putStringSet("subSearchLan", set).apply();
    }

    /* renamed from: h */
    private Set<String> m12748h() {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getStringSet("subSearchLan", new HashSet(1));
    }

    /* renamed from: com.inshot.xplayer.subtitle.a$c */
    private class C2812c extends BaseAdapter implements DialogInterface.OnClickListener, CompoundButton.OnCheckedChangeListener {

        /* renamed from: b */
        private int f11186b;

        /* renamed from: c */
        private CompoundButton f11187c;

        /* renamed from: d */
        private Button f11188d;

        /* renamed from: e */
        private List<C2814b.C2821c> f11189e;

        public long getItemId(int i) {
            return (long) i;
        }

        private C2812c(List<C2814b.C2821c> list) {
            this.f11186b = -1;
            this.f11189e = list;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m12762a(Button button) {
            this.f11188d = button;
            if (this.f11188d != null) {
                this.f11188d.setEnabled(false);
            }
        }

        public int getCount() {
            return this.f11189e.size();
        }

        /* renamed from: a */
        public C2814b.C2821c getItem(int i) {
            return this.f11189e.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout;
            AppCompatRadioButton appCompatRadioButton;
            boolean z = false;
            if (view == null) {
                FrameLayout frameLayout2 = new FrameLayout(C2796a.this.f11146c);
                appCompatRadioButton = new AppCompatRadioButton(C2796a.this.f11146c);
                appCompatRadioButton.setTextSize(2, 15.0f);
                appCompatRadioButton.setTextColor(-855638017);
                appCompatRadioButton.setSingleLine(false);
                int a = axw.m7444a(C2796a.this.f11146c, 12.0f);
                appCompatRadioButton.setPadding(a, a, a, a);
                int i2 = a * 2;
                frameLayout2.setPadding(i2, 0, i2, 0);
                frameLayout2.addView(appCompatRadioButton);
                frameLayout = frameLayout2;
            } else {
                appCompatRadioButton = (AppCompatRadioButton) ((ViewGroup) view).getChildAt(0);
                frameLayout = (FrameLayout) view;
            }
            C2814b.C2821c a2 = getItem(i);
            appCompatRadioButton.setText(a2.f11214a);
            appCompatRadioButton.append(" ");
            SpannableString spannableString = new SpannableString(String.format(Locale.ENGLISH, "%s, %s", new Object[]{a2.f11217d, awt.m7196a((long) a2.f11216c)}));
            spannableString.setSpan(new RelativeSizeSpan(0.85f), 0, spannableString.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(872415231), 0, spannableString.length(), 33);
            appCompatRadioButton.append(spannableString);
            appCompatRadioButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            if (i == this.f11186b) {
                z = true;
            }
            appCompatRadioButton.setChecked(z);
            appCompatRadioButton.setOnCheckedChangeListener(this);
            appCompatRadioButton.setTag(Integer.valueOf(i));
            return frameLayout;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if ((compoundButton.getTag() instanceof Integer) && z) {
                this.f11186b = ((Integer) compoundButton.getTag()).intValue();
                if (!(this.f11187c == null || this.f11187c == compoundButton)) {
                    this.f11187c.setChecked(false);
                }
                this.f11187c = compoundButton;
                if (this.f11188d != null) {
                    this.f11188d.setEnabled(true);
                }
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1 && this.f11186b >= 0) {
                C2796a.this.m12728a(this.f11186b < this.f11189e.size() ? this.f11189e.get(this.f11186b) : null);
            }
        }
    }

    /* renamed from: com.inshot.xplayer.subtitle.a$b */
    private class C2811b extends RecyclerView.Adapter<C2813d> implements View.OnClickListener {

        /* renamed from: a */
        final Set<String> f11179a;

        /* renamed from: b */
        final Set<String> f11180b;

        /* renamed from: d */
        private final List<String> f11182d;

        /* renamed from: e */
        private final boolean[] f11183e;

        /* renamed from: f */
        private final ListView f11184f;

        private C2811b(List<String> list, Set<String> set, Set<String> set2, boolean[] zArr, ListView listView) {
            this.f11182d = list;
            this.f11179a = set2;
            this.f11180b = set;
            this.f11183e = zArr;
            this.f11184f = listView;
        }

        /* renamed from: a */
        public C2813d onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C2813d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_subtitle_language, viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(C2813d dVar, int i) {
            String str = this.f11182d.get(i);
            dVar.f11191b.setText(str);
            dVar.f11192c.setTag(str);
            dVar.f11192c.setOnClickListener(this);
        }

        public int getItemCount() {
            return this.f11182d.size();
        }

        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                String str = (String) view.getTag();
                for (int i = 0; i < C2796a.f11145b.length; i++) {
                    if (C2796a.f11145b[i].equals(str)) {
                        this.f11184f.setItemChecked(i, false);
                        this.f11183e[i] = false;
                        this.f11179a.remove(C2796a.f11144a[i]);
                        this.f11180b.remove(C2796a.f11145b[i]);
                        this.f11182d.remove(C2796a.f11145b[i]);
                        notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: com.inshot.xplayer.subtitle.a$d */
    private class C2813d extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final TextView f11191b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final View f11192c;

        private C2813d(View view) {
            super(view);
            this.f11191b = (TextView) view.findViewById(R.id.language);
            this.f11192c = view.findViewById(R.id.close);
        }
    }
}
