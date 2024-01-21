package com.abhishek.xplayer.subtitle;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.abhishek.inplayer.widget.C2481e;
import com.abhishek.xplayer.application.MyApplication;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import classesdef.inplayer.axc;
import classesdef.player.awr;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.LogEvents;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.subtitle.d */
public class SubtitleSelectorFragment implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener {

    /* renamed from: l */
    private static final Comparator<C2831a> f11233l = new Comparator<C2831a>() {
        /* renamed from: a */
        public int compare(C2831a aVar, C2831a aVar2) {
            return aVar.f11246a.compareToIgnoreCase(aVar2.f11246a);
        }
    };

    /* renamed from: a */
    private View f11234a;

    /* renamed from: b */
    private Context f11235b;

    /* renamed from: c */
    private List<C2831a> f11236c;

    /* renamed from: d */
    private TextView f11237d;

    /* renamed from: e */
    private C2832b f11238e;

    /* renamed from: f */
    private ListView f11239f;

    /* renamed from: g */
    private C2834c f11240g;

    /* renamed from: h */
    private C2481e f11241h;

    /* renamed from: i */
    private Dialog f11242i;

    /* renamed from: j */
    private boolean f11243j;

    /* renamed from: k */
    private List<C2831a> f11244k;

    /* renamed from: com.inshot.xplayer.subtitle.d$c */
    public interface C2834c {
        /* renamed from: a */
        void mo17599a(String str);
    }

    /* renamed from: a */
    public static void m12811a(Context context, String str, C2834c cVar, C2481e eVar) {
        new SubtitleSelectorFragment(context, str, cVar, eVar).m12810a();
    }

    private SubtitleSelectorFragment(Context context, String str, C2834c cVar, C2481e eVar) {
        this.f11235b = context;
        this.f11240g = cVar;
        this.f11241h = eVar;
        m12813b();
        m12812a(!axc.chekFileExist(str) ? axc.appFolder() : str);
    }

    /* renamed from: a */
    private void m12810a() {
        if (this.f11241h != null) {
            this.f11243j = this.f11241h.mo17544a();
        }
        this.f11242i = new AlertDialog.Builder(this.f11235b).setView(this.f11234a).setOnDismissListener(this).show();
        Point c = axw.displaySize(this.f11235b);
        if (this.f11242i.getWindow() != null) {
            this.f11242i.getWindow().setLayout(-2, (int) (((float) Math.min(c.x, c.y)) * 0.95f));
        }
    }

    /* renamed from: b */
    private void m12813b() {
        this.f11234a = LayoutInflater.from(this.f11235b).inflate(R.layout.subtitle_selector, (ViewGroup) null);
        this.f11239f = (ListView) this.f11234a.findViewById(16908298);
        this.f11237d = (TextView) this.f11234a.findViewById(R.id.mPath);
        this.f11239f.setOnItemClickListener(this);
    }

    /* renamed from: a */
    private void m12812a(String str) {
        if (str != null) {
            File file = new File(str);
            if (!file.isDirectory()) {
                file = file.getParentFile();
            }
            if (file == null || file.getAbsolutePath().equals("/") || !file.canRead() || !file.exists() || !file.isDirectory()) {
                if (this.f11244k == null) {
                    ArrayList<String> d = awr.m7190d();
                    this.f11244k = new ArrayList(d.size() + 1);
                    C2831a aVar = new C2831a();
                    String unused = aVar.f11246a = MyApplication.getApplicationContext_().getString(R.string.internal_sd);
                    String unused2 = aVar.f11247b = awr.f6137a;
                    this.f11244k.add(aVar);
                    Iterator<String> it = d.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next != null) {
                            File file2 = new File(next);
                            if (file2.exists()) {
                                C2831a aVar2 = new C2831a();
                                String unused3 = aVar2.f11246a = file2.getName();
                                String unused4 = aVar2.f11247b = file2.getAbsolutePath();
                                this.f11244k.add(aVar2);
                            }
                        }
                    }
                }
                this.f11236c = new ArrayList(this.f11244k);
                this.f11237d.setText(R.string.directories);
            } else {
                if (this.f11236c == null) {
                    this.f11236c = new ArrayList();
                } else {
                    this.f11236c.clear();
                }
                this.f11237d.setText(file.getAbsolutePath());
                File[] listFiles = file.listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        if (file == null) {
                            return false;
                        }
                        if (file.isDirectory()) {
                            return true;
                        }
                        String lowerCase = file.getName().toLowerCase(Locale.ENGLISH);
                        if (lowerCase.endsWith(".srt") || lowerCase.endsWith(".smi") || lowerCase.endsWith(".ass")) {
                            return true;
                        }
                        return false;
                    }
                });
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        C2831a aVar3 = new C2831a();
                        String unused5 = aVar3.f11246a = file3.getName();
                        String unused6 = aVar3.f11247b = file3.getAbsolutePath();
                        boolean unused7 = aVar3.f11248c = !file3.isDirectory();
                        this.f11236c.add(aVar3);
                    }
                }
                Collections.sort(this.f11236c, f11233l);
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    C2831a aVar4 = new C2831a();
                    String unused8 = aVar4.f11246a = null;
                    String unused9 = aVar4.f11247b = parentFile.getAbsolutePath();
                    this.f11236c.add(0, aVar4);
                }
            }
            if (this.f11238e == null) {
                this.f11238e = new C2832b(this.f11235b, this.f11236c);
                this.f11239f.setAdapter(this.f11238e);
                return;
            }
            List unused10 = this.f11238e.f11250b = this.f11236c;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2831a aVar = this.f11236c.get(i);
        if (!aVar.f11248c) {
            m12812a(aVar.f11247b);
            if (this.f11238e != null) {
                this.f11239f.setAdapter(this.f11238e);
            }
        } else if (this.f11240g != null) {
            this.f11240g.mo17599a(aVar.f11247b);
            if (this.f11242i != null) {
                this.f11242i.dismiss();
            }
            LogEvents.m18492b("Subtitle", "OpenFrom/Ok");
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f11243j && this.f11241h != null) {
            this.f11241h.mo17543a(0);
        }
    }


    private static class C2831a {



        public String f11246a;
        /* access modifiers changed from: private */


        public String f11247b;
        /* access modifiers changed from: private */


        public boolean f11248c;

        private C2831a() {
        }
    }

    private static class C2832b extends BaseAdapter {


        private LayoutInflater f11249a;


        public List<C2831a> f11250b;

        public long getItemId(int i) {
            return (long) i;
        }

        public C2832b(Context context, List<C2831a> list) {
            this.f11249a = LayoutInflater.from(context);
            this.f11250b = list;
        }

        private class C2833a {


            TextView f11251a;


            ImageView f11252b;

            private C2833a() {
            }
        }

        public int getCount() {
            return this.f11250b.size();
        }

        public Object getItem(int i) {
            return this.f11250b.get(i).f11246a;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C2833a aVar;
            if (view == null) {
                view = this.f11249a.inflate(R.layout.subtitle_selector_item, viewGroup, false);
                aVar = new C2833a();
                aVar.f11251a = (TextView) view.findViewById(R.id.text);
                aVar.f11252b = (ImageView) view.findViewById(R.id.icon);
                view.setTag(aVar);
            } else {
                aVar = (C2833a) view.getTag();
            }
            C2831a aVar2 = this.f11250b.get(i);
            if (aVar2.f11246a == null) {
                aVar.f11251a.setText(R.string.folder_up);
                aVar.f11251a.setTextColor(-32768);
                aVar.f11252b.setImageResource(R.drawable.ic_return_parent);
            } else {
                aVar.f11251a.setText(aVar2.f11246a);
                aVar.f11251a.setTextColor(-855638017);
                aVar.f11252b.setImageResource(aVar2.f11248c ? R.drawable.ic_srt_file : R.drawable.ic_subtitle_folder);
            }
            return view;
        }
    }
}
