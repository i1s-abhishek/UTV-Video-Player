package com.abhishek.xplayer.subtitle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.abhishek.inplayer.widget.C2481e;
import com.abhishek.xplayer.application.MyApplication;

import classesdef.xdplayer.axw;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.subtitle.e */
public class C2835e implements SeekBar.OnSeekBarChangeListener {
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Integer[] f11254i = {-1, -68352, -6607420, -16728005, -5307012, -12486925, -16717827, -25344, -16746299, -196553, -36864};
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C2839f f11255a;

    /* renamed from: b */
    private C2481e f11256b;

    /* renamed from: c */
    private View f11257c;

    /* renamed from: d */
    private TextView f11258d;

    /* renamed from: e */
    private SeekBar f11259e;

    /* renamed from: f */
    private boolean f11260f;

    /* renamed from: g */
    private C2837a f11261g = new C2837a();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f11262h;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public C2835e(C2839f fVar, C2481e eVar) {
        this.f11255a = fVar;
        this.f11256b = eVar;
    }

    /* renamed from: a */
    public void mo18232a(Activity activity, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        if (this.f11257c == null) {
            this.f11257c = LayoutInflater.from(activity).inflate(R.layout.layout_subtitle_personality, viewGroup, false);
            Point c = axw.displaySize(activity);
            this.f11257c.findViewById(R.id.subtitle_panel_layout).getLayoutParams().width = Math.min(c.x, c.y) - (axw.m7444a((Context) activity, 16.0f) << 1);
            this.f11258d = (TextView) this.f11257c.findViewById(R.id.size);
            this.f11258d.setText(String.valueOf(this.f11255a.mo18247c()));
            this.f11259e = (SeekBar) this.f11257c.findViewById(R.id.subtitle_size_seek_bar);
            this.f11259e.setMax(45);
            this.f11259e.setOnSeekBarChangeListener(this);
            RecyclerView recyclerView = (RecyclerView) this.f11257c.findViewById(R.id.hList);
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 0));
            recyclerView.setAdapter(this.f11261g);
            this.f11257c.findViewById(R.id.panel_close).setOnClickListener(onClickListener);
            this.f11262h = (TextView) this.f11257c.findViewById(R.id.sample);
            viewGroup.addView(this.f11257c);
        }
        this.f11259e.setProgress(this.f11255a.mo18247c() - 15);
        int unused = this.f11261g.f11265c = this.f11255a.mo18244b();
        if (this.f11257c.getVisibility() != 0) {
            this.f11257c.setVisibility(0);
        }
        this.f11255a.mo18243a(false);
        this.f11262h.setTextSize(2, (float) this.f11255a.mo18247c());
        this.f11262h.setTextColor(this.f11255a.mo18244b());
        this.f11262h.setVisibility(0);
        this.f11260f = this.f11256b.mo17544a();
    }

    /* renamed from: a */
    public boolean mo18233a() {
        if (this.f11257c == null || this.f11257c.getVisibility() != 0) {
            return false;
        }
        this.f11257c.setVisibility(8);
        this.f11255a.mo18243a(true);
        this.f11262h.setVisibility(8);
        if (this.f11260f) {
            this.f11256b.mo17543a(0);
        }
        return true;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            int i2 = i + 15;
            this.f11255a.mo18241a(i2);
            this.f11262h.setTextSize(2, (float) i2);
        }
        this.f11258d.setText(String.valueOf(i + 15));
    }

    /* renamed from: com.inshot.xplayer.subtitle.e$a */
    private class C2837a extends RecyclerView.Adapter<C2838b> implements View.OnClickListener {

        /* renamed from: b */
        private final int f11264b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f11265c;

        private C2837a() {
            this.f11264b = axw.m7444a(MyApplication.getApplicationContext_(), 2.0f);
        }

        /* renamed from: a */
        public C2838b onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C2838b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.subtitle_color_item, viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(C2838b bVar, int i) {
            bVar.f11269d.setImageDrawable(m12829a(C2835e.f11254i[i].intValue()));
            bVar.f11268c.setSelected(this.f11265c == C2835e.f11254i[i].intValue());
            bVar.f11268c.setTag(C2835e.f11254i[i]);
            bVar.f11268c.setOnClickListener(this);
            bVar.f11267b.setPadding(i == 0 ? 0 : this.f11264b, 0, 0, 0);
        }

        /* renamed from: a */
        private Drawable m12829a(int i) {
            return new ColorDrawable(i);
        }

        public int getItemCount() {
            return C2835e.f11254i.length;
        }

        public void onClick(View view) {
            if ((view.getTag() instanceof Integer) && !view.getTag().equals(Integer.valueOf(this.f11265c))) {
                this.f11265c = ((Integer) view.getTag()).intValue();
                notifyDataSetChanged();
                C2835e.this.f11255a.mo18245b(this.f11265c);
                C2835e.this.f11262h.setTextColor(this.f11265c);
            }
        }
    }

    /* renamed from: com.inshot.xplayer.subtitle.e$b */
    private class C2838b extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final View f11267b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final View f11268c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final ImageView f11269d;

        private C2838b(View view) {
            super(view);
            this.f11267b = view;
            this.f11268c = view.findViewById(R.id.layout);
            this.f11269d = (ImageView) this.f11268c.findViewById(R.id.item);
        }
    }
}
