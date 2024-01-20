package classesdef.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Iterator;

import classesdef.browser.download.boi;
import classesdef.browser.download.bpd;
import classesdef.eventbus.bns;
import es.dmoral.toasty.Toasty;
import me.shaohui.bottomdialog.BottomDialog;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.five.activity.FilesActivity;

/* renamed from: bnd */
public class bnd extends BaseAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f15820a;

    /* renamed from: b */
    private ArrayList<bph> f15821b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BottomDialog f15822c;

    /* renamed from: d */
    private TextView f15823d;

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public bnd(Activity activity, ArrayList<bph> arrayList, BottomDialog bVar, TextView textView) {
        this.f15820a = activity;
        this.f15821b = arrayList;
        this.f15822c = bVar;
        this.f15823d = textView;
    }

    public int getCount() {
        return this.f15821b.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C3920a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.f15820a).inflate(R.layout.item_download_drawer, (ViewGroup) null);
            aVar = new C3920a();
            aVar.f15829a = (TextView) view.findViewById(R.id.file_name);
            aVar.f15830b = (ImageView) view.findViewById(R.id.flag);
            aVar.f15831c = (TextView) view.findViewById(R.id.size);
            aVar.f15832d = (CheckBox) view.findViewById(R.id.checkbox);
            aVar.f15833e = (ImageView) view.findViewById(R.id.downloaded);
            aVar.f15834f = (TextView) view.findViewById(R.id.re_download);
            aVar.f15835g = (TextView) view.findViewById(R.id.view);
            view.setTag(aVar);
        } else {
            aVar = (C3920a) view.getTag();
        }
        final bph bph = this.f15821b.get(i);
        aVar.f15829a.setText(bph.mo23348f());
        if (bph.mo23358m()) {
            aVar.f15830b.setVisibility(8);
            aVar.f15831c.setVisibility(8);
            aVar.f15832d.setVisibility(8);
            aVar.f15833e.setVisibility(0);
            aVar.f15834f.setVisibility(0);
            aVar.f15835g.setVisibility(0);
            aVar.f15834f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (box.m18457a(bnd.this.f15820a, new box.C3987a() {
                        /* renamed from: a */
                        public void mo21376a() {
                            bnd.this.m18176a(bph);
                        }
                    })) {
                        bnd.this.m18176a(bph);
                    }
                }
            });
            aVar.f15835g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (bph.mo23327a((Context) bnd.this.f15820a).exists()) {
                        bpd.m18504a(bnd.this.f15820a, bph);
                    } else {
                        Intent intent = new Intent(bnd.this.f15820a, FilesActivity.class);
                        intent.setFlags(131072);
                        intent.putExtra("position", 1);
                        bnd.this.f15820a.startActivity(intent);
                        EventBus.getDefault().post(new bnq(1));
                    }
                    BrowserLogEvent.downloaderLogEvent(bnd.this.f15820a, "main page", "draw view:click view");
                    bnd.this.f15822c.dismiss();
                    EventBus.getDefault().post(new bns());
                }
            });
        } else {
            aVar.f15830b.setVisibility(0);
            aVar.f15831c.setVisibility(0);
            aVar.f15832d.setVisibility(0);
            aVar.f15833e.setVisibility(8);
            aVar.f15834f.setVisibility(8);
            aVar.f15835g.setVisibility(8);
            Iterator<bph> it = this.f15821b.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (!it.next().mo23358m()) {
                    i2++;
                }
            }
            if (i2 == 1) {
                aVar.f15832d.setVisibility(8);
            } else {
                aVar.f15832d.setVisibility(0);
            }
            if (i2 == 0) {
                this.f15823d.setVisibility(8);
            } else {
                this.f15823d.setVisibility(0);
            }
            if (bph.getVideoSize() < 0) {
                aVar.f15831c.setVisibility(0);
                aVar.f15831c.setText(this.f15820a.getString(R.string.loading));
            } else if (bph.getVideoSize() == 0) {
                aVar.f15831c.setVisibility(8);
            } else {
                aVar.f15831c.setVisibility(0);
                aVar.f15831c.setText(Formatter.formatFileSize(this.f15820a, bph.getVideoSize()));
            }
            int h = bph.mo23352h();
            if (h != 100) {
                switch (h) {
                    case 2:
                        aVar.f15830b.setImageResource(R.drawable.ic_movie_black_24dp);
                        break;
                    case 3:
                        aVar.f15830b.setImageResource(R.drawable.ic_image_black_24dp);
                        break;
                    case 4:
                        aVar.f15830b.setImageResource(R.drawable.ic_audiotrack_black_24dp);
                        break;
                    case 5:
                        aVar.f15830b.setImageResource(R.drawable.ic_android_black_24dp);
                        break;
                    case 6:
                        aVar.f15830b.setImageResource(R.drawable.ic_archive_black_24dp);
                        break;
                    case 7:
                        aVar.f15830b.setImageResource(R.drawable.ic_description_black_24dp);
                        break;
                    default:
                        aVar.f15830b.setImageResource(R.drawable.ic_help_black_24dp);
                        break;
                }
            } else {
                aVar.f15830b.setImageResource(R.drawable.ic_help_black_24dp);
            }
            aVar.f15832d.setChecked(bph.mo23356k());
        }
        return view;
    }

    /* renamed from: bnd$a */
    private class C3920a {

        /* renamed from: a */
        TextView f15829a;

        /* renamed from: b */
        ImageView f15830b;

        /* renamed from: c */
        TextView f15831c;

        /* renamed from: d */
        CheckBox f15832d;

        /* renamed from: e */
        ImageView f15833e;

        /* renamed from: f */
        TextView f15834f;

        /* renamed from: g */
        TextView f15835g;

        private C3920a() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18176a(bph bph) {
        BrowserLogEvent.downloaderLogEvent(this.f15820a, "main page", "draw view:re download");
        bpd.m18512c((Context) this.f15820a, bph);
        bph.mo23335b(1);
        bpd.m18506a((Context) this.f15820a, bph);
        this.f15821b.remove(bph);
        boi.m18319b().mo23272a(bph);
        notifyDataSetChanged();
        this.f15822c.dismiss();
        EventBus.getDefault().post(new bns());
        Toasty.custom(this.f15820a, this.f15820a.getString(R.string.start_downloading), (Drawable) null, this.f15820a.getResources().getColor(R.color.toast_start), 1, false, true).show();
    }
}
