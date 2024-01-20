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
import android.widget.ImageView;
import android.widget.TextView;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import classesdef.browser.download.bpd;
import classesdef.eventbus.bns;
import es.dmoral.toasty.Toasty;
import me.shaohui.bottomdialog.BottomDialog;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.five.activity.FilesActivity;

/* renamed from: bnj */
public class ManualDrawerDownloadAdapter extends BaseAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f15927a;

    /* renamed from: b */
    private ArrayList<bph> f15928b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BottomDialog f15929c;

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public ManualDrawerDownloadAdapter(Activity activity, ArrayList<bph> arrayList, BottomDialog bVar) {
        this.f15927a = activity;
        this.f15928b = arrayList;
        this.f15929c = bVar;
    }

    public int getCount() {
        return this.f15928b.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C3951a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.f15927a).inflate(R.layout.item_manual_drawer, (ViewGroup) null);
            aVar = new C3951a();
            aVar.f15938a = (ImageView) view.findViewById(R.id.downloaded);
            aVar.f15939b = (TextView) view.findViewById(R.id.file_name);
            aVar.f15940c = (TextView) view.findViewById(R.id.size);
            aVar.f15941d = (ImageView) view.findViewById(R.id.re_download);
            aVar.f15942e = (ImageView) view.findViewById(R.id.view);
            aVar.f15943f = (ImageView) view.findViewById(R.id.download);
            view.setTag(aVar);
        } else {
            aVar = (C3951a) view.getTag();
        }
        final bph bph = this.f15928b.get(i);
        if (bph.mo23359n() == 0) {
            aVar.f15939b.setText("480p");
        } else {
            TextView textView = aVar.f15939b;
            textView.setText(bph.mo23359n() + "p");
        }
        if (bph.mo23358m()) {
            aVar.f15938a.setVisibility(0);
            aVar.f15941d.setVisibility(0);
            aVar.f15942e.setVisibility(0);
            aVar.f15943f.setVisibility(8);
            aVar.f15940c.setText(this.f15927a.getString(R.string.already_in_list));
        } else {
            aVar.f15938a.setVisibility(4);
            aVar.f15941d.setVisibility(4);
            aVar.f15942e.setVisibility(8);
            aVar.f15943f.setVisibility(0);
            if (bph.getVideoSize() < 0) {
                aVar.f15940c.setVisibility(0);
                aVar.f15940c.setText(this.f15927a.getString(R.string.loading));
            } else if (bph.getVideoSize() == 0) {
                aVar.f15940c.setVisibility(8);
            } else {
                aVar.f15940c.setVisibility(0);
                aVar.f15940c.setText(Formatter.formatFileSize(this.f15927a, bph.getVideoSize()));
            }
        }
        aVar.f15941d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (box.m18457a(ManualDrawerDownloadAdapter.this.f15927a, new box.C3987a() {
                    /* renamed from: a */
                    public void mo21376a() {
                        ManualDrawerDownloadAdapter.this.m18223a(bph);
                    }
                })) {
                    ManualDrawerDownloadAdapter.this.m18223a(bph);
                }
            }
        });
        aVar.f15942e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (bph.mo23327a((Context) ManualDrawerDownloadAdapter.this.f15927a).exists()) {
                    bpd.m18504a(ManualDrawerDownloadAdapter.this.f15927a, bph);
                } else {
                    Intent intent = new Intent(ManualDrawerDownloadAdapter.this.f15927a, FilesActivity.class);
                    intent.setFlags(131072);
                    intent.putExtra("position", 1);
                    ManualDrawerDownloadAdapter.this.f15927a.startActivity(intent);
                    EventBus.getDefault().post(new bnq(1));
                }
                BrowserLogEvent.downloaderLogEvent(ManualDrawerDownloadAdapter.this.f15927a, "main page", "draw view:click view");
                ManualDrawerDownloadAdapter.this.f15929c.dismissAllowingStateLoss();
                EventBus.getDefault().post(new bns());
            }
        });
        aVar.f15943f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (box.m18457a(ManualDrawerDownloadAdapter.this.f15927a, new box.C3987a() {
                    /* renamed from: a */
                    public void mo21376a() {
                        ManualDrawerDownloadAdapter.this.m18226b(bph);
                    }
                })) {
                    ManualDrawerDownloadAdapter.this.m18226b(bph);
                }
            }
        });
        return view;
    }

    /* renamed from: bnj$a */
    private class C3951a {

        /* renamed from: a */
        ImageView f15938a;

        /* renamed from: b */
        TextView f15939b;

        /* renamed from: c */
        TextView f15940c;

        /* renamed from: d */
        ImageView f15941d;

        /* renamed from: e */
        ImageView f15942e;

        /* renamed from: f */
        ImageView f15943f;

        private C3951a() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18223a(bph bph) {
        BrowserLogEvent.downloaderLogEvent(this.f15927a, "main page", "draw view:re download");
        bpd.m18512c((Context) this.f15927a, bph);
        bph.mo23335b(1);
        bpd.m18506a((Context) this.f15927a, bph);
        notifyDataSetChanged();
        if (this.f15929c != null && this.f15929c.isVisible()) {
            this.f15929c.dismissAllowingStateLoss();
        }
        EventBus.getDefault().post(new bns());
        Toasty.custom(this.f15927a, this.f15927a.getString(R.string.start_downloading), (Drawable) null, this.f15927a.getResources().getColor(R.color.toast_start), 1, false, true).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18226b(bph bph) {
        bpd.m18506a((Context) this.f15927a, bph);
        bph.mo23338b(true);
        Toasty.custom(this.f15927a, this.f15927a.getString(R.string.start_downloading), (Drawable) null, this.f15927a.getResources().getColor(R.color.toast_start), 1, false, true).show();
        this.f15929c.dismissAllowingStateLoss();
        BrowserLogEvent.downloaderLogEvent(this.f15927a, "main page", "draw view:click download");
        EventBus.getDefault().post(new bns());
    }
}
