package classesdef.browser;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.provider.FontsContractCompat;

import com.bumptech.glide.Glide;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadUtils;

import java.io.File;
import java.util.ArrayList;

import classesdef.browser.download.bnu;
import classesdef.browser.download.bou;
import classesdef.browser.download.bpa;
import classesdef.browser.download.bpd;
import classesdef.database.bnm;
import classesdef.xdplayer.bpj;
import es.dmoral.toasty.Toasty;
import hdplayer.xdplayer.videoplayer.R;

/* renamed from: bnk */
public class bnk {

    /* renamed from: a */
    BaseAdapter f15945a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DownloadFinishedFragment f15946b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Activity f15947c;

    /* renamed from: d */
    private ArrayList<bph> f15948d;

    /* renamed from: a */
    public Object mo23205a(int i) {
        return null;
    }

    /* renamed from: b */
    public long mo23207b(int i) {
        return (long) i;
    }

    public bnk(DownloadFinishedFragment bod, ArrayList<bph> arrayList) {
        this.f15946b = bod;
        this.f15947c = bod.getActivity();
        this.f15948d = arrayList;
    }

    /* renamed from: a */
    public int mo23203a() {
        return this.f15948d.size();
    }

    /* renamed from: a */
    public View mo23204a(int i, View view, ViewGroup viewGroup) {
        View view2;
        C3960a aVar;
        final int i2 = i;
        if (view == null || !(view.getTag() instanceof C3960a)) {
            View inflate = LayoutInflater.from(this.f15947c).inflate(R.layout.item_progress_file, (ViewGroup) null);
            aVar = new C3960a();
            aVar.f15965a = (RelativeLayout) inflate.findViewById(R.id.item_layout);
            aVar.f15966b = (ImageView) inflate.findViewById(R.id.thumb);
            aVar.f15967c = (ImageView) inflate.findViewById(R.id.flag);
            aVar.f15968d = (TextView) inflate.findViewById(R.id.file_name);
            aVar.f15969e = (ProgressBar) inflate.findViewById(R.id.number_progress_bar);
            aVar.f15970f = (TextView) inflate.findViewById(R.id.size);
            aVar.f15971g = (TextView) inflate.findViewById(R.id.speed);
            aVar.f15972h = (CheckBox) inflate.findViewById(R.id.checkbox);
            aVar.f15973i = (ImageView) inflate.findViewById(R.id.delete);
            aVar.f15974j = (ImageView) inflate.findViewById(R.id.website);
            aVar.f15975k = (ImageView) inflate.findViewById(R.id.download);
            inflate.setTag(aVar);
            view2 = inflate;
        } else {
            aVar = (C3960a) view.getTag();
            view2 = view;
        }
        C3960a aVar2 = aVar;
        final bph bph = this.f15948d.get(i2);
        aVar2.f15965a.setVisibility(8);
        aVar2.f15965a.setVisibility(0);
        aVar2.f15968d.setText(bph.mo23348f());
        int b = FileDownloadUtils.generateId(bph.mo23339c(), bph.mo23334b((Context) this.f15947c));
        long d = FileDownloader.getImpl().getTotal(b);
        long c = FileDownloader.getImpl().getSoFar(b);
        long j = c;
        m18230a(aVar2, FileDownloader.getImpl().getStatus(b, bph.mo23334b((Context) this.f15947c)), c, d, bpa.m18486b(bph.mo23334b((Context) this.f15947c), c), bph);
        aVar2.f15966b.setVisibility(4);
        int h = bph.mo23352h();
        if (h != 100) {
            switch (h) {
                case 2:
                    aVar2.f15967c.setImageResource(R.drawable.ic_movie_black_24dp);
                    if (TextUtils.isEmpty(bph.mo23361p())) {
                        if (!(j == 0 || d == 0 || j <= d / 2)) {
                            aVar2.f15966b.setVisibility(0);
                            Glide.with(this.f15947c).load(FileDownloadUtils.getTempPath(bph.mo23334b((Context) this.f15947c))).placeholder((int) R.color.transparent).error((int) R.color.transparent).dontAnimate().into(aVar2.f15966b);
                            break;
                        }
                    } else {
                        aVar2.f15966b.setVisibility(0);
                        Glide.with(this.f15947c).load(bph.mo23361p()).placeholder((int) R.color.transparent).error((int) R.color.transparent).dontAnimate().into(aVar2.f15966b);
                        break;
                    }
                case 3:
                    aVar2.f15967c.setImageResource(R.drawable.ic_image_black_24dp);
                    aVar2.f15966b.setVisibility(0);
                    Glide.with(this.f15947c).load(bph.mo23339c()).placeholder((int) R.color.transparent).error((int) R.color.transparent).dontAnimate().into(aVar2.f15966b);
                    break;
                case 4:
                    aVar2.f15967c.setImageResource(R.drawable.ic_audiotrack_black_24dp);
                    break;
                case 5:
                    aVar2.f15967c.setImageResource(R.drawable.ic_android_black_24dp);
                    break;
                case 6:
                    aVar2.f15967c.setImageResource(R.drawable.ic_archive_black_24dp);
                    break;
                case 7:
                    aVar2.f15967c.setImageResource(R.drawable.ic_description_black_24dp);
                    break;
                default:
                    aVar2.f15967c.setImageResource(R.drawable.ic_help_black_24dp);
                    break;
            }
        } else {
            aVar2.f15967c.setImageResource(R.drawable.ic_help_black_24dp);
        }
        int i3 = this.f15946b.f16022a;
        DownloadFinishedFragment bod = this.f15946b;
        if (i3 == 0) {
            aVar2.f15973i.setVisibility(0);
            aVar2.f15972h.setVisibility(4);
        } else {
            aVar2.f15973i.setVisibility(4);
            aVar2.f15972h.setVisibility(0);
            aVar2.f15972h.setChecked(bph.mo23356k());
        }
        aVar2.f15973i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bnk.this.m18236b(bph);
                BrowserLogEvent.downloaderLogEvent(bnk.this.f15947c, "progress fragment", "click delete");
            }
        });
        aVar2.f15972h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bph.mo23332a(!bph.mo23356k());
                bnk.this.f15946b.mo23245a(true);
                bnk.this.f15945a.notifyDataSetChanged();
                BrowserLogEvent.downloaderLogEvent(bnk.this.f15947c, "progress fragment", "click checkbox");
            }
        });
        aVar2.f15965a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int i = bnk.this.f15946b.f16022a;
                DownloadFinishedFragment unused = bnk.this.f15946b;
                if (i == 1) {
                    bph.mo23332a(!bph.mo23356k());
                    bnk.this.f15946b.mo23245a(true);
                    bnk.this.f15945a.notifyDataSetChanged();
                }
            }
        });
        if (TextUtils.isEmpty(bph.mo23354i())) {
            aVar2.f15974j.setVisibility(8);
        } else {
            aVar2.f15974j.setVisibility(0);
        }
        aVar2.f15974j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (bok.m18343b(bnk.this.f15947c, bph.mo23334b((Context) bnk.this.f15947c))) {
                    Toast.makeText(bnk.this.f15947c, bnk.this.f15947c.getString(R.string.link_expired), 1).show();
                    bpd.m18512c((Context) bnk.this.f15947c, bph);
                }
                bpd.m18515e(bnk.this.f15947c, bph.mo23354i());
                BrowserLogEvent.downloaderLogEvent(bnk.this.f15947c, "progress fragment", "click website");
            }
        });
        aVar2.f15975k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bnk.this.m18237c(i2);
                BrowserLogEvent.downloaderLogEvent(bnk.this.f15947c, "progress fragment", "click download");
            }
        });
        aVar2.f15971g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (view instanceof TextView) {
                    String lowerCase = ((TextView) view).getText().toString().toLowerCase();
                    if (lowerCase.equals(bnk.this.f15947c.getString(R.string.network_error).toLowerCase())) {
                        try {
                            Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                            intent.setFlags(268435456);
                            bnk.this.f15947c.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                            bnk.this.m18233a(bph);
                        }
                    } else if (lowerCase.equals(bnk.this.f15947c.getString(R.string.waiting_for_wifi).toLowerCase())) {
                        bnk.this.f15946b.mo23243a();
                    } else {
                        bnk.this.m18233a(bph);
                    }
                    BrowserLogEvent.downloaderLogEvent(bnk.this.f15947c, "progress fragment", "click speed");
                }
            }
        });
        return view2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18233a(bph bph) {
        String d = bok.m18345d(this.f15947c, bph.mo23334b((Context) this.f15947c));
        if (!TextUtils.isEmpty(d)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f15947c);
            builder.setTitle((CharSequence) this.f15947c.getString(R.string.failed));
            builder.setMessage((CharSequence) d);
            builder.setPositiveButton((CharSequence) this.f15947c.getString(17039370), (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18236b(final bph bph) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f15947c);
        builder.setMessage((CharSequence) this.f15947c.getString(R.string.delete_tip));
        builder.setNegativeButton((CharSequence) this.f15947c.getString(R.string.action_cancel), (DialogInterface.OnClickListener) null);
        builder.setPositiveButton((CharSequence) this.f15947c.getString(R.string.delete), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                bpd.m18512c((Context) bnk.this.f15947c, bph);
            }
        });
        builder.show();
    }

    /* renamed from: a */
    public void mo23206a(bnu bnu, ListView listView) {
        View childAt;
        C3960a aVar;
        String str = bnu.f16007c;
        if (!TextUtils.isEmpty(str)) {
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f15948d.size()) {
                    break;
                } else if (this.f15948d.get(i2).mo23334b((Context) this.f15947c).equals(str)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            int a = ((bne) this.f15945a).mo23148a(i);
            if (a >= firstVisiblePosition && a <= lastVisiblePosition && (childAt = listView.getChildAt(a - firstVisiblePosition)) != null && (childAt.getTag() instanceof C3960a) && (aVar = (C3960a) childAt.getTag()) != null) {
                byte b = bnu.f16008d;
                long j = bnu.f16009e;
                long j2 = bnu.f16010f;
                m18230a(aVar, b, j, j2, bnu.f16011g, this.f15948d.get(i));
            }
        }
    }

    /* renamed from: a */
    private void m18230a(C3960a aVar, byte b, long j, long j2, long j3, bph bph) {
        if (j2 <= 0) {
            j2 = bph.getVideoSize();
        }
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        aVar.f15969e.setProgress((i <= 0 || j <= 0) ? 0 : (int) ((((double) j) * 100.0d) / ((double) j2)));
        if (i > 0) {
            aVar.f15970f.setVisibility(0);
            TextView textView = aVar.f15970f;
            textView.setText(Formatter.formatFileSize(this.f15947c, j) + "/" + Formatter.formatFileSize(this.f15947c, j2));
        } else {
            aVar.f15970f.setVisibility(4);
        }
        aVar.f15971g.setTextColor(this.f15947c.getResources().getColor(R.color.sub_title_color));
        aVar.f15975k.setColorFilter(this.f15947c.getResources().getColor(R.color.accent_color), PorterDuff.Mode.SRC_ATOP);
        switch (b) {
            case -4:
            case 1:
            case 2:
            case 5:
            case 6:
                aVar.f15975k.setImageResource(R.drawable.ic_downloader_history);
                aVar.f15971g.setText(this.f15947c.getString(R.string.waiting).toLowerCase());
                return;
            case FontsContractCompat.FontRequestCallback.FAIL_REASON_FONT_LOAD_ERROR:
                if (bph.mo23327a((Context) this.f15947c).exists()) {
                    bnm.m18246a().mo23222a((Context) this.f15947c, bph.mo23346e(), 2);
                    this.f15948d.remove(bph);
                    this.f15946b.mo23246d();
                } else {
                    aVar.f15971g.setText(this.f15947c.getString(R.string.paused).toLowerCase());
                    aVar.f15975k.setImageResource(R.drawable.ic_file_download_black_24dp);
                    FileDownloader.getImpl().clear(FileDownloadUtils.generateId(bph.mo23339c(), bph.mo23334b((Context) this.f15947c)), FileDownloadUtils.getTempPath(bph.mo23334b((Context) this.f15947c)));
                }
                this.f15945a.notifyDataSetChanged();
                return;
            case -2:
            case 0:
                aVar.f15971g.setText(this.f15947c.getString(R.string.paused).toLowerCase());
                aVar.f15975k.setImageResource(R.drawable.ic_file_download_black_24dp);
                return;
            case -1:
                aVar.f15975k.setColorFilter(this.f15947c.getResources().getColor(R.color.error_red), PorterDuff.Mode.SRC_ATOP);
                aVar.f15975k.setImageResource(R.drawable.ic_refresh_black_24dp);
                aVar.f15971g.setTextColor(this.f15947c.getResources().getColor(R.color.error_red));
                switch (bok.m18338a(this.f15947c, bph.mo23334b((Context) this.f15947c))) {
                    case 1:
                        aVar.f15971g.setText(this.f15947c.getString(R.string.network_error).toLowerCase());
                        return;
                    case 2:
                        aVar.f15971g.setText(this.f15947c.getString(R.string.not_enough_space).toLowerCase());
                        return;
                    case 3:
                        aVar.f15971g.setText(this.f15947c.getString(R.string.connection_failed).toLowerCase());
                        return;
                    case 4:
                        aVar.f15971g.setText(this.f15947c.getString(R.string.waiting_for_wifi).toLowerCase());
                        aVar.f15975k.setColorFilter(this.f15947c.getResources().getColor(R.color.accent_color), PorterDuff.Mode.SRC_ATOP);
                        aVar.f15975k.setImageResource(R.drawable.ic_downloader_history);
                        return;
                    default:
                        aVar.f15971g.setText(this.f15947c.getString(R.string.connection_failed).toLowerCase());
                        return;
                }
            case 3:
            case 4:
                aVar.f15975k.setColorFilter(this.f15947c.getResources().getColor(R.color.tab_un_select), PorterDuff.Mode.SRC_ATOP);
                aVar.f15975k.setImageResource(R.drawable.ic_pause_black_24dp);
                TextView textView2 = aVar.f15971g;
                textView2.setText(Formatter.formatFileSize(this.f15947c, j3) + "/S");
                return;
            case 10:
            case 11:
                aVar.f15971g.setText(this.f15947c.getString(R.string.paused).toLowerCase());
                aVar.f15975k.setImageResource(R.drawable.ic_file_download_black_24dp);
                return;
            default:
                aVar.f15971g.setText(this.f15947c.getString(R.string.paused).toLowerCase());
                aVar.f15975k.setImageResource(R.drawable.ic_file_download_black_24dp);
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18237c(int i) {
        if (i >= 0 && i < this.f15948d.size()) {
            final bph bph = this.f15948d.get(i);
            byte a = FileDownloader.getImpl().getStatus(bph.mo23339c(), bph.mo23334b((Context) this.f15947c));
            Activity activity = this.f15947c;
            BrowserData.m18388a(activity, "touchItem position = " + i + ".. status = " + a + ".. downloadLink = " + bph.mo23339c());
            switch (a) {
                case -2:
                case -1:
                case 0:
                case 10:
                case 11:
                    if (box.m18457a(this.f15947c, new box.C3987a() {
                        /* renamed from: a */
                        public void mo21376a() {
                            bnk.this.m18239c(bph);
                        }
                    })) {
                        m18239c(bph);
                        return;
                    }
                    return;
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                    FileDownloader.getImpl().pause(FileDownloadUtils.generateId(bph.mo23339c(), bph.mo23334b((Context) this.f15947c)));
                    this.f15945a.notifyDataSetChanged();
                    if (DownloadFinishedFragment.m18279g() != null) {
                        DownloadFinishedFragment.m18279g().add(bph.mo23339c());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18239c(bph bph) {
        if (DownloadFinishedFragment.m18279g() != null) {
            DownloadFinishedFragment.m18279g().remove(bph.mo23339c());
        }
        if (bok.m18338a(this.f15947c, bph.mo23334b((Context) this.f15947c)) == 2 && bph.mo23350g() != null && !bph.mo23350g().equals(boo.m18379c(this.f15947c))) {
            String substring = bph.mo23346e().substring(bph.mo23346e().lastIndexOf("."), bph.mo23346e().length());
            String substring2 = bph.mo23346e().substring(0, bph.mo23346e().lastIndexOf("."));
            String e = bph.mo23346e();
            File file = new File(boo.m18379c(this.f15947c), bph.mo23346e());
            while (file.exists()) {
                e = substring2 + "_" + (System.currentTimeMillis() + ((long) 0)) + substring;
                file = new File(boo.m18379c(this.f15947c), e);
            }
            if (!bph.mo23346e().equals(e)) {
                bph.mo23342c(e);
                bnm.m18246a().mo23225c(this.f15947c, bph);
            }
            bph.mo23345d(bpj.m18578a((Context) this.f15947c).mo23414u());
            bnm.m18246a().mo23223b((Context) this.f15947c, bph);
        }
        bou.m18412a().mo23299a((Context) this.f15947c, bph, true);
        this.f15945a.notifyDataSetChanged();
        Toasty.custom(this.f15947c, this.f15947c.getString(R.string.start_downloading), (Drawable) null, this.f15947c.getResources().getColor(R.color.toast_start), 1, false, true).show();
    }

    /* renamed from: bnk$a */
    private class C3960a {

        /* renamed from: a */
        RelativeLayout f15965a;

        /* renamed from: b */
        ImageView f15966b;

        /* renamed from: c */
        ImageView f15967c;

        /* renamed from: d */
        TextView f15968d;

        /* renamed from: e */
        ProgressBar f15969e;

        /* renamed from: f */
        TextView f15970f;

        /* renamed from: g */
        TextView f15971g;

        /* renamed from: h */
        CheckBox f15972h;

        /* renamed from: i */
        ImageView f15973i;

        /* renamed from: j */
        ImageView f15974j;

        /* renamed from: k */
        ImageView f15975k;

        private C3960a() {
        }
    }
}
