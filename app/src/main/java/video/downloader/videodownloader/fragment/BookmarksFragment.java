package video.downloader.videodownloader.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import classesdef.browser.C4740s;
import classesdef.browser.bls;
import classesdef.browser.bmf;
import classesdef.browser.bmg;
import classesdef.browser.bmj;
import classesdef.browser.bms;
import classesdef.browser.bmy;
import classesdef.browser.bpn;
import classesdef.browser.bql;
import classesdef.browser.bqs;
import classesdef.browser.bqt;
import classesdef.browser.tab.C0053ad;
import classesdef.browser.tab.C4892v;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.activity.C3524a;
import video.downloader.videodownloader.activity.TabsManager;
import video.downloader.videodownloader.activity.ReadingActivity;
import video.downloader.videodownloader.app.BrowserApp;
import video.downloader.videodownloader.view.WebViewBrowser;

public class BookmarksFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener, bls {
    @Inject
     bmj f13729a;
    @Inject
            bms f13730b;
    @Inject
     bpn f13731c;
    @Inject
     bmy f13732d;

    /* renamed from: e */
    private TabsManager f13733e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public bmf f13734f;

    /* renamed from: g */
    private C3587a f13735g;

    /* renamed from: h */
    private Bitmap f13736h;

    /* renamed from: i */
    private Bitmap f13737i;

    /* renamed from: j */
    private ImageView f13738j;

    /* renamed from: k */
    private Unbinder f13739k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f13740l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f13741m;
    @BindView(R.id.icon_star)
    ImageView mBookmarkImage;
    @BindView(R.id.right_drawer_list)
    RecyclerView mBookmarksListView;

    private boolean f13742n;
    /* access modifiers changed from: private */

    public C0053ad f13743o;
    /* access modifiers changed from: private */

    public C0053ad f13744p;
    /* access modifiers changed from: private */

    public C0053ad f13745q;
    /* access modifiers changed from: private */

    public final C3524a f13746r = new C3524a();

    private final C3590b f13747s = new C3590b() {
        /* renamed from: a */
        public void mo21572a(bmg bmg) {
            if (bmg.mo23055g()) {
                int unused = BookmarksFragment.this.f13741m = ((LinearLayoutManager) BookmarksFragment.this.mBookmarksListView.getLayoutManager()).findFirstVisibleItemPosition();
                BookmarksFragment.this.m15270a(bmg.mo23054f(), true);
                return;
            }
            BookmarksFragment.this.f13734f.mo21299a(bmg);
        }
    };

    private final C3591c f13748t = new C3591c() {
        public boolean mo21573a(bmg bmg) {
            BookmarksFragment.this.m15277b(bmg);
            return true;
        }
    };

    /* renamed from: video.downloader.video.downloader.videodownloader.fragment.BookmarksFragment$b */
    interface C3590b {
        void mo21572a(bmg bmg);
    }

    /* renamed from: video.downloader.video.downloader.videodownloader.fragment.BookmarksFragment$c */
    interface C3591c {
        boolean mo21573a(bmg bmg);
    }

    public boolean onLongClick(View view) {
        return false;
    }

    public class BookmarkViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a */
        private BookmarkViewHolder f13761a;

        public BookmarkViewHolder_ViewBinding(BookmarkViewHolder bookmarkViewHolder, View view) {
            this.f13761a = bookmarkViewHolder;
            bookmarkViewHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.textBookmark, "field 'txtTitle'", TextView.class);
            bookmarkViewHolder.favicon = (ImageView) Utils.findRequiredViewAsType(view, R.id.faviconBookmark, "field 'favicon'", ImageView.class);
        }

        public void unbind() {
            BookmarkViewHolder bookmarkViewHolder = this.f13761a;
            if (bookmarkViewHolder != null) {
                this.f13761a = null;
                bookmarkViewHolder.txtTitle = null;
                bookmarkViewHolder.favicon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");

        }
    }

    /* renamed from: a */
    public static BookmarksFragment m15268a(boolean z) {
        BookmarksFragment bookmarksFragment = new BookmarksFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("BookmarksFragment.INCOGNITO_MODE", z);
        bookmarksFragment.setArguments(bundle);
        return bookmarksFragment;
    }

    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        BrowserApp.m15129g().mo21504a(this);
        Bundle arguments = getArguments();
        Context context = getContext();
        this.f13734f = (bmf) context;
        this.f13733e = this.f13734f.mo21322g();
        boolean z = false;
        this.f13742n = arguments.getBoolean("BookmarksFragment.INCOGNITO_MODE", false);
        if (this.f13731c.mo23438K() != 0 || this.f13742n) {
            z = true;
        }
        this.f13736h = bqt.m18990a(context, R.drawable.ic_webpage, z);
        this.f13737i = bqt.m18990a(context, R.drawable.ic_downloader_folder, z);
        if (z) {
            i = bqt.m18998f(context);
        } else {
            i = bqt.m18997e(context);
        }
        this.f13740l = i;
    }

    /* renamed from: c */
    private TabsManager m15281c() {
        if (this.f13733e == null) {
            this.f13733e = this.f13734f.mo21322g();
        }
        return this.f13733e;
    }

    public void onResume() {
        super.onResume();
        if (this.f13735g != null) {
            m15270a((String) null, false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.bookmark_drawer, viewGroup, false);
        this.f13739k = ButterKnife.bind((Object) this, inflate);
        this.f13738j = (ImageView) inflate.findViewById(R.id.starIcon);
        this.f13738j.setColorFilter(this.f13740l, PorterDuff.Mode.SRC_IN);
        inflate.findViewById(R.id.bookmark_back_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!BookmarksFragment.this.f13746r.mo21442a()) {
                    BookmarksFragment.this.m15270a((String) null, true);
                    BookmarksFragment.this.mBookmarksListView.getLayoutManager().scrollToPosition(BookmarksFragment.this.f13741m);
                }
            }
        });
        m15269a(inflate, (int) R.id.action_add_bookmark, (int) R.id.icon_star);
        m15269a(inflate, (int) R.id.action_reading, (int) R.id.icon_reading);
        m15269a(inflate, (int) R.id.action_toggle_desktop, (int) R.id.icon_desktop);
        this.f13735g = new C3587a(this.f13732d, this.f13737i, this.f13736h);
        this.f13735g.mo21587a(this.f13747s);
        this.f13735g.mo21588a(this.f13748t);
        this.mBookmarksListView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mBookmarksListView.setAdapter(this.f13735g);
        m15270a((String) null, true);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        bqs.m18985a(this.f13743o);
        bqs.m18985a(this.f13744p);
        bqs.m18985a(this.f13745q);
        if (this.f13735g != null) {
            this.f13735g.mo21582a();
        }
        if (this.f13739k != null) {
            this.f13739k.unbind();
            this.f13739k = null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        bqs.m18985a(this.f13743o);
        bqs.m18985a(this.f13744p);
        bqs.m18985a(this.f13745q);
        if (this.f13735g != null) {
            this.f13735g.mo21582a();
        }
    }

    /* renamed from: b */
    public void mo21569b() {
        int i;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            boolean z = this.f13731c.mo23438K() != 0 || this.f13742n;
            this.f13736h = bqt.m18990a(activity, R.drawable.ic_webpage, z);
            this.f13737i = bqt.m18990a(activity, R.drawable.ic_downloader_folder, z);
            if (z) {
                i = bqt.m18998f(activity);
            } else {
                i = bqt.m18997e(activity);
            }
            this.f13740l = i;
        }
    }

    /* renamed from: b */
    private void m15278b(String str) {
        bqs.m18985a(this.f13745q);
        this.f13745q = this.f13729a.mo23066b(str).mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<Boolean>() {
            /* renamed from: a */
            public void mo21366a(Boolean bool) {
                C0053ad unused = BookmarksFragment.this.f13745q = null;
                bql.m18952a(bool);
                FragmentActivity activity = BookmarksFragment.this.getActivity();
                if (BookmarksFragment.this.mBookmarkImage != null && activity != null) {
                    if (!bool.booleanValue()) {
                        BookmarksFragment.this.mBookmarkImage.setImageResource(R.drawable.ic_bookmark);
                        BookmarksFragment.this.mBookmarkImage.setColorFilter(BookmarksFragment.this.f13740l, PorterDuff.Mode.SRC_IN);
                        return;
                    }
                    BookmarksFragment.this.mBookmarkImage.setImageResource(R.drawable.ic_bookmark);
                    BookmarksFragment.this.mBookmarkImage.setColorFilter(bqt.m18994c(activity), PorterDuff.Mode.SRC_IN);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo21567a(bmg bmg) {
        if (bmg.mo23055g()) {
            m15270a((String) null, false);
        } else {
            this.f13735g.mo21583a(bmg);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15270a(final String str, final boolean z) {
        bqs.m18985a(this.f13743o);
        this.f13743o = this.f13729a.mo23070d(str).mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<List<bmg>>() {
            /* renamed from: a */
            public void mo21366a(final List<bmg> list) {
                C0053ad unused = BookmarksFragment.this.f13743o = null;
                bql.m18952a(list);
                BookmarksFragment.this.f13746r.mo21441a(str);
                if (str == null) {
                    bqs.m18985a(BookmarksFragment.this.f13744p);
                    C0053ad unused2 = BookmarksFragment.this.f13744p = BookmarksFragment.this.f13729a.mo23064b().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<List<bmg>>() {
                        /* renamed from: a */
                        public void mo21366a(List<bmg> list) {
                            C0053ad unused = BookmarksFragment.this.f13744p = null;
                            bql.m18952a(list);
                            list.addAll(list);
                            BookmarksFragment.this.m15271a((List<bmg>) list, z);
                        }
                    });
                    return;
                }
                BookmarksFragment.this.m15271a(list, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15271a(List<bmg> list, boolean z) {
        this.f13735g.mo21584a(list);
        int i = this.f13746r.mo21442a() ? R.drawable.ic_bookmark : R.drawable.ic_action_back;
        if (this.f13738j != null) {
            this.f13738j.setImageResource(i);
        }
    }

    /* renamed from: a */
    private void m15269a(View view, int i, int i2) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
        frameLayout.setOnClickListener(this);
        frameLayout.setOnLongClickListener(this);
        ((ImageView) view.findViewById(i2)).setColorFilter(this.f13740l, PorterDuff.Mode.SRC_IN);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15277b(bmg bmg) {
        if (bmg.mo23055g()) {
            this.f13730b.mo23120b((Activity) getActivity(), this.f13734f, bmg);
        } else {
            this.f13730b.mo23117a((Activity) getActivity(), this.f13734f, bmg);
        }
    }

    public void onClick(View view) {
        WebViewBrowser k;
        int id = view.getId();
        if (id == R.id.action_add_bookmark) {
            this.f13734f.mo21329m();
        } else if (id == R.id.action_reading) {
            WebViewBrowser k2 = m15281c().mo21469k();
            if (k2 != null) {
                Intent intent = new Intent(getActivity(), ReadingActivity.class);
                intent.putExtra("ReadingUrl", k2.mo21633E());
                startActivity(intent);
            }
        } else if (id == R.id.action_toggle_desktop && (k = m15281c().mo21469k()) != null) {
            k.mo21640b((Context) getActivity());
            k.mo21657r();
        }
    }

    /* renamed from: a */
    public void mo21566a() {
        if (this.f13746r.mo21442a()) {
            this.f13734f.mo21353u();
            return;
        }
        m15270a((String) null, true);
        this.mBookmarksListView.getLayoutManager().scrollToPosition(this.f13741m);
    }

    /* renamed from: a */
    public void mo21568a(String str) {
        m15278b(str);
        m15270a(this.f13746r.mo21443b(), false);
    }

    static class BookmarkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private final C3587a f13758a;

        private final C3591c f13759b;

        private final C3590b f13760c;
        @BindView(R.id.faviconBookmark)
        ImageView favicon;
        @BindView(R.id.textBookmark)
        TextView txtTitle;

        BookmarkViewHolder(View view, C3587a aVar, C3591c cVar, C3590b bVar) {
            super(view);
            ButterKnife.bind((Object) this, view);
            this.f13758a = aVar;
            this.f13760c = bVar;
            this.f13759b = cVar;
            view.setOnLongClickListener(this);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.f13760c != null && ((long) adapterPosition) != -1) {
                this.f13760c.mo21572a(this.f13758a.mo21580a(adapterPosition));
            }
        }

        public boolean onLongClick(View view) {
            int adapterPosition = getAdapterPosition();
            return (adapterPosition == -1 || this.f13759b == null || !this.f13759b.mo21573a(this.f13758a.mo21580a(adapterPosition))) ? false : true;
        }
    }

    /* renamed from: video.downloader.video.downloader.videodownloader.fragment.BookmarksFragment$a */
    private static class C3587a extends RecyclerView.Adapter<BookmarkViewHolder> {

        public List<bmg> f13762a = new ArrayList();

        private final bmy f13763b;

        private final Bitmap f13764c;


        private final Bitmap f13765d;
        public final Map<String, C0053ad> f13766e = new ConcurrentHashMap();

        private C3591c f13767f;

        private C3590b f13768g;

        C3587a(bmy bmy, Bitmap bitmap, Bitmap bitmap2) {
            this.f13763b = bmy;
            this.f13764c = bitmap;
            this.f13765d = bitmap2;
        }

        /* access modifiers changed from: package-private */
        public void mo21588a(C3591c cVar) {
            this.f13767f = cVar;
        }

        public void mo21587a(C3590b bVar) {
            this.f13768g = bVar;
        }

        public bmg mo21580a(int i) {
            return this.f13762a.get(i);
        }

        public void mo21583a(bmg bmg) {
            ArrayList arrayList = new ArrayList(this.f13762a);
            arrayList.remove(bmg);
            mo21584a((List<bmg>) arrayList);
        }

        public void mo21584a(List<bmg> list) {
            final List<bmg> list2 = this.f13762a;
            this.f13762a = list;
            DiffUtil.calculateDiff(new DiffUtil.Callback() {
                public int getOldListSize() {
                    return list2.size();
                }

                public int getNewListSize() {
                    return C3587a.this.f13762a.size();
                }

                public boolean areItemsTheSame(int i, int i2) {
                    return ((bmg) list2.get(i)).equals(C3587a.this.f13762a.get(i2));
                }

                public boolean areContentsTheSame(int i, int i2) {
                    return ((bmg) list2.get(i)).equals(C3587a.this.f13762a.get(i2));
                }
            }).dispatchUpdatesTo((RecyclerView.Adapter) this);
        }

        public void mo21582a() {
            for (C0053ad c : this.f13766e.values()) {
                c.mo281c();
            }
            this.f13766e.clear();
        }

        public BookmarkViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new BookmarkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bookmark_list_item, viewGroup, false), this, this.f13767f, this.f13768g);
        }

        public void onViewRecycled(BookmarkViewHolder bookmarkViewHolder) {
            super.onViewRecycled(bookmarkViewHolder);
        }

        public void onBindViewHolder(final BookmarkViewHolder bookmarkViewHolder, int i) {
            ViewCompat.jumpDrawablesToCurrentState(bookmarkViewHolder.itemView);
            final bmg bmg = this.f13762a.get(i);
            bookmarkViewHolder.txtTitle.setText(bmg.mo23054f());
            if (bmg.mo23055g()) {
                bookmarkViewHolder.favicon.setImageBitmap(this.f13764c);
            } else if (bmg.mo23051d() == null) {
                bookmarkViewHolder.favicon.setImageBitmap(this.f13765d);
                bookmarkViewHolder.favicon.setTag(Integer.valueOf(bmg.mo23052e().hashCode()));
                final String e = bmg.mo23052e();
                bqs.m18985a(this.f13766e.get(e));
                this.f13766e.put(e, this.f13763b.mo23133a(e, this.f13765d, true).mo24966a(C4740s.m21405c()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<Bitmap>() {
                    /* renamed from: a */
                    public void mo21366a(Bitmap bitmap) {
                        C3587a.this.f13766e.remove(e);
                        Object tag = bookmarkViewHolder.favicon.getTag();
                        if (tag != null && tag.equals(Integer.valueOf(e.hashCode()))) {
                            bookmarkViewHolder.favicon.setImageBitmap(bitmap);
                        }
                        bmg.mo23042a(bitmap);
                    }
                }));
            } else {
                bookmarkViewHolder.favicon.setImageBitmap(bmg.mo23051d());
            }
        }

        public int getItemCount() {
            return this.f13762a.size();
        }
    }
}
