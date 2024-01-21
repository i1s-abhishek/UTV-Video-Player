package video.downloader.videodownloader.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import classesdef.browser.bbc;
import classesdef.browser.blw;
import classesdef.browser.bmf;
import classesdef.browser.bpn;
import classesdef.browser.bqh;
import classesdef.browser.bqt;
import classesdef.browser.bqw;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.activity.TabsManager;
import video.downloader.videodownloader.app.BrowserApp;
import video.downloader.videodownloader.view.Transition;
import video.downloader.videodownloader.view.WebViewBrowser;

public class TabsFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener, blw {
    @Inject
     bpn f13776a;

    public boolean f13777b;

    private boolean f13778c;
    
    public int f13779d;
    
    public boolean f13780e = true;

    private boolean f13781f;
    
    public C3594a f13782g;
    
    public bmf f13783h;
    
    private Unbinder unbinder;

    /* renamed from: j */
    private TabsManager f13785j;
    @BindView(R.id.tabs_list)
    RecyclerView mRecyclerView;

    /* renamed from: a */
    public static TabsFragment m15312a(boolean z, boolean z2) {
        TabsFragment tabsFragment = new TabsFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("TabsFragment.IS_INCOGNITO", z);
        bundle.putBoolean("TabsFragment.VERTICAL_MODE", z2);
        tabsFragment.setArguments(bundle);
        return tabsFragment;
    }

    public TabsFragment() {
        BrowserApp.m15129g().mo21505a(this);
    }

    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Context context = getContext();
        this.f13783h = (bmf) getActivity();
        this.f13785j = this.f13783h.mo21322g();
        boolean z = false;
        this.f13777b = arguments.getBoolean("TabsFragment.IS_INCOGNITO", false);
        this.f13781f = arguments.getBoolean("TabsFragment.VERTICAL_MODE", true);
        if (this.f13776a.mo23438K() != 0 || this.f13777b) {
            z = true;
        }
        this.f13778c = z;
        this.f13780e = this.f13776a.mo23473l();
        this.f13780e &= !this.f13778c;
        if (this.f13778c) {
            i = bqt.m18998f(context);
        } else {
            i = bqt.m18997e(context);
        }
        this.f13779d = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayoutManager linearLayoutManager;
        View view;
        SimpleItemAnimator simpleItemAnimator;
        if (this.f13781f) {
            view = layoutInflater.inflate(R.layout.tab_drawer, viewGroup, false);
            linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
            m15313a(view, R.id.tab_header_button, R.id.plusIcon);
            m15313a(view, R.id.new_tab_button, R.id.icon_plus);
            m15313a(view, R.id.action_back, R.id.icon_back);
            m15313a(view, R.id.action_forward, R.id.icon_forward);
            m15313a(view, R.id.action_home, R.id.icon_home);
        } else {
            view = layoutInflater.inflate(R.layout.tab_strip, viewGroup, false);
            linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.new_tab_button);
            imageView.setColorFilter(bqt.m18998f(getActivity()));
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TabsFragment.this.f13783h.mo21327k();
                }
            });
        }
        this.unbinder = ButterKnife.bind((Object) this, view);
        if (this.f13781f) {
            simpleItemAnimator = new DefaultItemAnimator();
        } else {
            simpleItemAnimator = new DefaultItemAnimator();
        }
        simpleItemAnimator.setSupportsChangeAnimations(false);
        simpleItemAnimator.setAddDuration(200);
        simpleItemAnimator.setChangeDuration(0);
        simpleItemAnimator.setRemoveDuration(200);
        simpleItemAnimator.setMoveDuration(200);
        this.mRecyclerView.setLayerType(0, (Paint) null);
        this.mRecyclerView.setItemAnimator(simpleItemAnimator);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.f13782g = new C3594a(this.f13781f);
        this.mRecyclerView.setAdapter(this.f13782g);
        this.mRecyclerView.setHasFixedSize(true);
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.unbinder != null) {
            this.unbinder.unbind();
            this.unbinder = null;
        }
        this.f13782g = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public TabsManager m15316d() {
        if (this.f13785j == null) {
            this.f13785j = this.f13783h.mo21322g();
        }
        return this.f13785j;
    }

    /* renamed from: a */
    private void m15313a(View view, int i, int i2) {
        View findViewById = view.findViewById(i);
        findViewById.setOnClickListener(this);
        findViewById.setOnLongClickListener(this);
        ((ImageView) view.findViewById(i2)).setColorFilter(this.f13779d, PorterDuff.Mode.SRC_IN);
    }

    public void onResume() {
        super.onResume();
        if (this.f13782g != null) {
            this.f13782g.notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public void mo21592b() {
        if (this.f13782g != null) {
            this.f13782g.notifyDataSetChanged();
        }
    }

    /* renamed from: c */
    public void mo21594c() {
        int i;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f13778c = this.f13776a.mo23438K() != 0 || this.f13777b;
            this.f13780e = this.f13776a.mo23473l();
            boolean z = this.f13780e;
            boolean z2 = this.f13778c;
            this.f13780e = z & (!z2);
           // this.f13780e &= true ^ this.f13778c;
            if (this.f13778c) {
                i = bqt.m18998f(activity);
            } else {
                i = bqt.m18997e(activity);
            }
            this.f13779d = i;
            if (this.f13782g != null) {
                this.f13782g.notifyDataSetChanged();
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_back /*2131296266*/:
                this.f13783h.mo21355w();
                return;
            case R.id.action_forward /*2131296280*/:
                this.f13783h.mo21356x();
                return;
            case R.id.action_home /*2131296282*/:
                this.f13783h.mo21357y();
                return;
            case R.id.new_tab_button /*2131296646*/:
                this.f13783h.mo21327k();
                return;
            case R.id.tab_header_button /*2131296872*/:
                this.f13783h.mo21291a(m15316d().mo21468j());
                return;
            default:
                return;
        }
    }

    public boolean onLongClick(View view) {
        if (view.getId() != R.id.action_new_tab) {
            return true;
        }
        this.f13783h.mo21328l();
        return true;
    }

    /* renamed from: a */
    public void mo21590a() {
        if (this.f13782g != null) {
            this.f13782g.notifyItemInserted(m15316d().mo21464f());
            this.mRecyclerView.postDelayed(new Runnable() {
                public void run() {
                    try {
                        TabsFragment.this.mRecyclerView.smoothScrollToPosition(TabsFragment.this.f13782g.getItemCount() - 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                        bbc.m15886a().mo21879a(TabsFragment.this.getContext(), (Throwable) e);
                    }
                }
            }, 500);
        }
    }

    /* renamed from: a */
    public void mo21591a(int i) {
        if (this.f13782g != null) {
            this.f13782g.notifyItemRemoved(i);
        }
    }

    /* renamed from: b */
    public void mo21593b(int i) {
        if (this.f13782g != null) {
            this.f13782g.notifyItemChanged(i);
        }
    }

    /* renamed from: video.downloader.video.downloader.videodownloader.fragment.TabsFragment$a */
    private class C3594a extends RecyclerView.Adapter<C3594a.C3595a> {

        /* renamed from: b */
        private final int f13789b;

        /* renamed from: c */
        private final Drawable f13790c;

        /* renamed from: d */
        private final Bitmap f13791d;

        /* renamed from: e */
        private ColorMatrix f13792e;

        /* renamed from: f */
        private Paint f13793f;

        /* renamed from: g */
        private ColorFilter f13794g;

        /* renamed from: h */
        private final boolean f13795h;

        public C3594a(boolean z) {
            this.f13789b = z ? R.layout.tab_list_item : R.layout.tab_list_item_horizontal;
            this.f13795h = z;
            if (z) {
                this.f13790c = null;
                this.f13791d = null;
                return;
            }
            int a = bqw.m19008a(bqt.m18986a(TabsFragment.this.getContext()), -16777216, 0.75f);
            Bitmap createBitmap = Bitmap.createBitmap(bqw.m19007a(175.0f), bqw.m19007a(30.0f), Bitmap.Config.ARGB_8888);
            bqw.m19015a(new Canvas(createBitmap), a, true);
            this.f13790c = new BitmapDrawable(TabsFragment.this.getResources(), createBitmap);
            int a2 = bqt.m18986a(TabsFragment.this.getContext());
            this.f13791d = Bitmap.createBitmap(bqw.m19007a(175.0f), bqw.m19007a(30.0f), Bitmap.Config.ARGB_8888);
            bqw.m19015a(new Canvas(this.f13791d), a2, false);
        }

        /* renamed from: a */
        public C3595a onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f13789b, viewGroup, false);
            if (this.f13795h) {
                bqh.m18944a(inflate, new Transition(inflate.getContext()));
            }
            return new C3595a(inflate);
        }

        /* renamed from: a */
        public void onBindViewHolder(C3595a aVar, int i) {
            aVar.f13799d.setTag(Integer.valueOf(i));
            ViewCompat.jumpDrawablesToCurrentState(aVar.f13799d);
            WebViewBrowser a = TabsFragment.this.m15316d().mo21449a(i);
            if (a != null) {
                aVar.f13796a.setText(a.mo21632D());
                Bitmap C = a.mo21631C();
                if (a.mo21651l()) {
                    BitmapDrawable bitmapDrawable = null;
                    if (!this.f13795h) {
                        bitmapDrawable = new BitmapDrawable(TabsFragment.this.getResources(), this.f13791d);
                        if (!TabsFragment.this.f13777b && TabsFragment.this.f13780e) {
                            bitmapDrawable.setColorFilter(TabsFragment.this.f13783h.mo21352t(), PorterDuff.Mode.SRC_IN);
                        }
                    }
                    if (!TabsFragment.this.f13777b && TabsFragment.this.f13780e) {
                        TabsFragment.this.f13783h.mo21294a(C, (Drawable) bitmapDrawable);
                    }
                    TextViewCompat.setTextAppearance(aVar.f13796a, R.style.boldText);
                    if (!this.f13795h) {
                        bqh.m18944a(aVar.f13800e, bitmapDrawable);
                    }
                    aVar.f13797b.setImageBitmap(C);
                } else {
                    TextViewCompat.setTextAppearance(aVar.f13796a, R.style.normalText);
                    if (!this.f13795h) {
                        bqh.m18944a(aVar.f13800e, this.f13790c);
                    }
                    aVar.f13797b.setImageBitmap(mo21599a(C));
                }
                if (this.f13795h) {
                    Transition aVar2 = (Transition) aVar.f13800e.getBackground();
                    aVar2.setCrossFadeEnabled(false);
                    if (a.mo21651l()) {
                        aVar2.startTransition(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                    } else {
                        aVar2.reverseTransition(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                    }
                }
            }
        }

        public int getItemCount() {
            return TabsFragment.this.m15316d().mo21463e();
        }

        /* renamed from: a */
        public Bitmap mo21599a(Bitmap bitmap) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            if (this.f13792e == null || this.f13794g == null || this.f13793f == null) {
                this.f13793f = new Paint();
                this.f13792e = new ColorMatrix();
                this.f13792e.setSaturation(0.5f);
                this.f13794g = new ColorMatrixColorFilter(this.f13792e);
                this.f13793f.setColorFilter(this.f13794g);
            }
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f13793f);
            return createBitmap;
        }

        /* renamed from: video.downloader.video.downloader.videodownloader.fragment.TabsFragment$a$a */
        public class C3595a extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

            /* renamed from: a */
            final TextView f13796a;

            /* renamed from: b */
            final ImageView f13797b;

            /* renamed from: c */
            final ImageView f13798c;

            /* renamed from: d */
            final FrameLayout f13799d;

            /* renamed from: e */
            final LinearLayout f13800e;

            public C3595a(View view) {
                super(view);
                this.f13796a = (TextView) view.findViewById(R.id.textTab);
                this.f13797b = (ImageView) view.findViewById(R.id.faviconTab);
                this.f13798c = (ImageView) view.findViewById(R.id.deleteButton);
                this.f13800e = (LinearLayout) view.findViewById(R.id.tab_item_background);
                this.f13799d = (FrameLayout) view.findViewById(R.id.deleteAction);
                this.f13798c.setColorFilter(TabsFragment.this.f13779d, PorterDuff.Mode.SRC_IN);
                this.f13799d.setOnClickListener(this);
                this.f13800e.setOnClickListener(this);
                this.f13800e.setOnLongClickListener(this);
            }

            public void onClick(View view) {
                if (view == this.f13799d) {
                    TabsFragment.this.f13783h.mo21317d(getAdapterPosition());
                }
                if (view == this.f13800e) {
                    TabsFragment.this.f13783h.mo21319e(getAdapterPosition());
                }
            }

            public boolean onLongClick(View view) {
                TabsFragment.this.f13783h.mo21291a(getAdapterPosition());
                return true;
            }
        }
    }
}
