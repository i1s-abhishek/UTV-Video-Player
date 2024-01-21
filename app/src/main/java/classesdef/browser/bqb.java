package classesdef.browser;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import javax.inject.Inject;

import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;
import classesdef.browser.tab.C4704r;
import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4892v;
import classesdef.browser.tab.C4927w;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

/* renamed from: bqb */
public class bqb extends BaseAdapter implements Filterable {

    /* renamed from: d */
    private static final C4704r f16369d = C4740s.m21404b();
    @Inject
    public

    /* renamed from: a */
    bmj f16370a;
    @Inject
    public

    /* renamed from: b */
    bpn f16371b;
    @Inject
    public

    /* renamed from: c */
            Application f16372c;

    /* renamed from: e */
    private final List<bmg> f16373e = new ArrayList(5);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final List<bmg> f16374f = new ArrayList(5);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final List<bmg> f16375g = new ArrayList(5);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final List<bmg> f16376h = new ArrayList(5);

    /* renamed from: i */
    private final Drawable f16377i;

    /* renamed from: j */
    private final Drawable f16378j;

    /* renamed from: k */
    private final Drawable f16379k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Comparator<bmg> f16380l = new C4036d();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final List<bmg> f16381m = new ArrayList(5);

    /* renamed from: n */
    private final boolean f16382n;

    /* renamed from: o */
    private boolean f16383o;

    /* renamed from: p */
    private final Context f16384p;

    /* renamed from: q */
    private bpn.C4016a f16385q;

    public long getItemId(int i) {
        return 0;
    }

    public bqb(Context context, boolean z, boolean z2) {
        boolean z3 = true;
        this.f16383o = true;
        BrowserApp.m15129g().mo21495a(this);
        this.f16384p = context;
        if (!z && !z2) {
            z3 = false;
        }
        this.f16382n = z3;
        this.f16383o = z2;
        mo23535a();
        mo23537c();
        this.f16377i = bqt.m18993b(context, R.drawable.ic_downloader_search, this.f16382n);
        this.f16379k = bqt.m18993b(context, R.drawable.ic_bookmark, this.f16382n);
        this.f16378j = bqt.m18993b(context, R.drawable.ic_downloader_history, this.f16382n);
    }

    /* renamed from: a */
    public void mo23535a() {
        this.f16385q = this.f16371b.mo23448a();
    }

    /* renamed from: b */
    public void mo23536b() {
        C4740s.m21407e().mo322a(new C4029a(this.f16372c));
    }

    /* renamed from: c */
    public void mo23537c() {
        this.f16370a.mo23061a().mo24966a(C4740s.m21407e()).mo23840a(new C4892v<List<bmg>>() {
            /* renamed from: a */
            public void mo21366a(List<bmg> list) {
                bql.m18952a(list);
                bqb.this.f16381m.clear();
                bqb.this.f16381m.addAll(list);
            }
        });
    }

    public int getCount() {
        return this.f16373e.size();
    }

    public Object getItem(int i) {
        if (i > this.f16373e.size() || i < 0) {
            return null;
        }
        return this.f16373e.get(i);
    }

    /* renamed from: bqb$c */
    private static class C4035c {

        /* renamed from: a */
        final ImageView f16400a;

        /* renamed from: b */
        final TextView f16401b;

        /* renamed from: c */
        final TextView f16402c;

        C4035c(View view) {
            this.f16401b = (TextView) view.findViewById(R.id.title);
            this.f16402c = (TextView) view.findViewById(R.id.url);
            this.f16400a = (ImageView) view.findViewById(R.id.suggestionIcon);
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C4035c cVar;
        Drawable drawable;
        if (view == null) {
            view = LayoutInflater.from(this.f16384p).inflate(R.layout.two_line_autocomplete, viewGroup, false);
            cVar = new C4035c(view);
            view.setTag(cVar);
        } else {
            cVar = (C4035c) view.getTag();
        }
        bmg bmg = this.f16373e.get(i);
        cVar.f16401b.setText(bmg.mo23054f());
        cVar.f16402c.setText(bmg.mo23052e());
        if (this.f16382n) {
            cVar.f16401b.setTextColor(-1);
        }
        int a = bmg.mo23039a();
        if (a != R.drawable.ic_bookmark) {
            switch (a) {
                case R.drawable.ic_downloader_history:
                    drawable = this.f16378j;
                    break;
                case R.drawable.ic_downloader_search:
                    drawable = this.f16377i;
                    break;
                default:
                    drawable = this.f16377i;
                    break;
            }
        } else {
            drawable = this.f16379k;
        }
        cVar.f16400a.setImageDrawable(drawable);
        return view;
    }

    public Filter getFilter() {
        return new C4031b(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m18883a(List<bmg> list) {
        this.f16373e.clear();
        this.f16373e.addAll(list);
        notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18890d() {
        C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                bqb.this.f16375g.clear();
                bqb.this.f16374f.clear();
                bqb.this.f16376h.clear();
                eVar.mo23729a();
            }
        }).mo21839a(f16369d).mo21842b(C4740s.m21406d()).mo23839a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18884a(final List<bmg> list, final List<bmg> list2, final List<bmg> list3) {
        C4805t.m21581a(new C4858u<List<bmg>>() {
            /* renamed from: a */
            public void mo21407a(C4927w<List<bmg>> wVar) {
                ArrayList arrayList = new ArrayList(5);
                if (list != null) {
                    bqb.this.f16375g.clear();
                    bqb.this.f16375g.addAll(list);
                }
                if (list2 != null) {
                    bqb.this.f16374f.clear();
                    bqb.this.f16374f.addAll(list2);
                }
                if (list3 != null) {
                    bqb.this.f16376h.clear();
                    bqb.this.f16376h.addAll(list3);
                }
                Iterator it = bqb.this.f16375g.iterator();
                Iterator it2 = bqb.this.f16374f.iterator();
                ListIterator listIterator = bqb.this.f16376h.listIterator();
                while (arrayList.size() < 5 && (it.hasNext() || listIterator.hasNext() || it2.hasNext())) {
                    if (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                    if (listIterator.hasNext() && arrayList.size() < 5) {
                        arrayList.add(listIterator.next());
                    }
                    if (it2.hasNext() && arrayList.size() < 5) {
                        arrayList.add(it2.next());
                    }
                }
                Collections.sort(arrayList, bqb.this.f16380l);
                wVar.mo25115a(arrayList);
                wVar.mo23729a();
            }
        }).mo24966a(f16369d).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<List<bmg>>() {
            /* renamed from: a */
            public void mo21366a(List<bmg> list) {
                bql.m18952a(list);
                bqb.this.m18883a(list);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C4805t<List<bmg>> m18880a(final String str) {
        return C4805t.m21581a(new C4858u<List<bmg>>() {
            /* renamed from: a */
            public void mo21407a(C4927w<List<bmg>> wVar) {
                ArrayList arrayList = new ArrayList(5);
                int i = 0;
                for (int i2 = 0; i2 < bqb.this.f16381m.size() && i < 5; i2++) {
                    if (((bmg) bqb.this.f16381m.get(i2)).mo23054f().toLowerCase(Locale.getDefault()).startsWith(str)) {
                        arrayList.add(bqb.this.f16381m.get(i2));
                        i++;
                    } else if (((bmg) bqb.this.f16381m.get(i2)).mo23052e().contains(str)) {
                        arrayList.add(bqb.this.f16381m.get(i2));
                        i++;
                    }
                }
                wVar.mo25115a(arrayList);
                wVar.mo23729a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public C4805t<List<bmg>> m18887b(String str) {
        if (this.f16385q == bpn.C4016a.SUGGESTION_GOOGLE) {
            return bqd.m18919a(str, this.f16372c);
        }
        if (this.f16385q == bpn.C4016a.SUGGESTION_DUCK) {
            return bqd.m18923c(str, this.f16372c);
        }
        if (this.f16385q == bpn.C4016a.SUGGESTION_BAIDU) {
            return bqd.m18922b(str, this.f16372c);
        }
        return C4805t.m21582b();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m18892e() {
        return !this.f16383o && this.f16385q != bpn.C4016a.SUGGESTION_NONE;
    }

    /* renamed from: bqb$b */
    private static class C4031b extends Filter {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final bqb f16396a;

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence charSequence, FilterResults filterResults) {
        }

        C4031b(bqb bqb) {
            this.f16396a = bqb;
        }

        /* access modifiers changed from: protected */
        public FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                this.f16396a.m18890d();
                return filterResults;
            }
            String trim = charSequence.toString().toLowerCase(Locale.getDefault()).trim();
            this.f16396a.m18880a(trim).mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<List<bmg>>() {
                /* renamed from: a */
                public void mo21366a(List<bmg> list) {
                    C4031b.this.f16396a.m18884a(list, (List<bmg>) null, (List<bmg>) null);
                }
            });
            bmq.m18074b(trim).mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<List<bmg>>() {
                /* renamed from: a */
                public void mo21366a(List<bmg> list) {
                    C4031b.this.f16396a.m18884a((List<bmg>) null, list, (List<bmg>) null);
                }
            });
            if (this.f16396a.m18892e() && !bqd.m18920a()) {
                this.f16396a.m18887b(trim).mo24966a(C4740s.m21405c()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<List<bmg>>() {
                    /* renamed from: a */
                    public void mo21366a(List<bmg> list) {
                        C4031b.this.f16396a.m18884a((List<bmg>) null, (List<bmg>) null, list);
                    }
                });
            }
            filterResults.count = 1;
            return filterResults;
        }

        public CharSequence convertResultToString(Object obj) {
            return ((bmg) obj).mo23052e();
        }
    }

    /* renamed from: bqb$a */
    private static class C4029a implements Runnable {

        /* renamed from: a */
        private final Application f16395a;

        C4029a(Application application) {
            this.f16395a = application;
        }

        public void run() {
            File file = new File(this.f16395a.getCacheDir().toString());
            for (String str : file.list(new C4030a())) {
                new File(file.getPath() + str).delete();
            }
        }

        /* renamed from: bqb$a$a */
        private static class C4030a implements FilenameFilter {
            private C4030a() {
            }

            public boolean accept(File file, String str) {
                return str.endsWith(".sgg");
            }
        }
    }

    /* renamed from: bqb$d */
    private static class C4036d implements Comparator<bmg> {
        private C4036d() {
        }

        /* renamed from: a */
        public int compare(bmg bmg, bmg bmg2) {
            if (bmg.mo23039a() == bmg2.mo23039a()) {
                return 0;
            }
            if (bmg.mo23039a() == R.drawable.ic_bookmark) {
                return -1;
            }
            if (bmg2.mo23039a() != R.drawable.ic_bookmark && bmg.mo23039a() == R.drawable.ic_downloader_history) {
                return -1;
            }
            return 1;
        }
    }
}
