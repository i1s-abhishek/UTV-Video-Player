package classesdef.browser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.Formatter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.mopub.mobileads.VastIconXmlManager;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classesdef.browser.download.boi;
import classesdef.browser.download.bpd;
import classesdef.database.bnm;
import classesdef.xdplayer.bpj;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bnf */
public class DownloadFinishedFileItemFragment {

    /* renamed from: a */
    BaseAdapter f15842a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DownloadFinishedFragment f15843b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Activity f15844c;

    /* renamed from: d */
    private ArrayList<bph> f15845d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PackageManager f15846e;

    /* renamed from: f */
    private final int f15847f = 0;

    /* renamed from: g */
    private final int f15848g = 1;

    /* renamed from: h */
    private final int f15849h = 2;

    /* renamed from: i */
    private final int f15850i = 3;

    /* renamed from: j */
    private final int f15851j = 4;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public HashMap<String, WeakReference<Drawable>> f15852k = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public HashMap<String, bpg> f15853l = new HashMap<>();

    /* renamed from: a */
    public Object mo23160a(int i) {
        return null;
    }

    /* renamed from: b */
    public long mo23161b(int i) {
        return (long) i;
    }

    public DownloadFinishedFileItemFragment(DownloadFinishedFragment bod, ArrayList<bph> arrayList) {
        this.f15843b = bod;
        this.f15844c = bod.getActivity();
        this.f15845d = arrayList;
        this.f15846e = this.f15844c.getPackageManager();
    }

    /* renamed from: a */
    public int mo23158a() {
        return this.f15845d.size();
    }

    /* renamed from: a */
    public View mo23159a(int i, View view, ViewGroup viewGroup) {
        final C3940d dVar;
        Drawable drawable = null;
        if (view == null || !(view.getTag() instanceof C3940d)) {
            view = LayoutInflater.from(this.f15844c).inflate(R.layout.item_finished_file, (ViewGroup) null);
            dVar = new C3940d();
            dVar.f15904a = (RelativeLayout) view.findViewById(R.id.item_layout);
            dVar.f15905b = (RelativeLayout) view.findViewById(R.id.icon_layout);
            dVar.f15906c = (ImageView) view.findViewById(R.id.thumb);
            dVar.f15907d = (ImageView) view.findViewById(R.id.flag);
            dVar.f15908e = (TextView) view.findViewById(R.id.duration);
            dVar.f15909f = (TextView) view.findViewById(R.id.file_name);
            dVar.f15910g = (CheckBox) view.findViewById(R.id.checkbox);
            dVar.f15911h = (ImageView) view.findViewById(R.id.action_more);
            dVar.f15912i = (TextView) view.findViewById(R.id.size);
            dVar.f15913j = (ImageView) view.findViewById(R.id.label);
            view.setTag(dVar);
        } else {
            dVar = (C3940d) view.getTag();
        }
        final bph bph = this.f15845d.get(i);
        dVar.f15904a.setVisibility(8);
        dVar.f15904a.setVisibility(0);
        dVar.f15909f.setText(bph.mo23348f());
        if (bph.getVideoSize() <= 0 && bph.mo23327a((Context) this.f15844c).exists()) {
            bph.setVideoSize(bph.mo23327a((Context) this.f15844c).length());
        }
        if (bph.getVideoSize() <= 0) {
            dVar.f15912i.setVisibility(8);
        } else {
            dVar.f15912i.setVisibility(0);
            dVar.f15912i.setText(Formatter.formatFileSize(this.f15844c, bph.getVideoSize()));
            Log.e("getVideoSize3","++"+String.valueOf(bph.getVideoSize()));
            Log.e("getVideoSize3_","++"+String.valueOf(Formatter.formatFileSize(this.f15844c, bph.getVideoSize())));
        }
        dVar.f15905b.setBackgroundDrawable(this.f15844c.getResources().getDrawable(R.color.thumb_backg_color));
        dVar.f15906c.setVisibility(4);
        dVar.f15908e.setVisibility(8);
        int h = bph.mo23352h();
        if (h != 100) {
            switch (h) {
                case 2:
                    dVar.f15907d.setImageResource(R.drawable.ic_movie_black_24dp);
                    dVar.f15913j.setImageResource(R.drawable.ic_movie_black_24dp);
                    if (!TextUtils.isEmpty(bph.mo23361p())) {
                        dVar.f15906c.setVisibility(0);
                        Glide.with(this.f15844c).load(bph.mo23361p()).placeholder((int) R.color.transparent).error((int) R.color.transparent).dontAnimate().into(dVar.f15906c);
                    } else if (bph.mo23327a((Context) this.f15844c).exists()) {
                        dVar.f15906c.setVisibility(0);
                        Glide.with(this.f15844c).load(bph.mo23327a((Context) this.f15844c)).placeholder((int) R.color.transparent).error((int) R.color.transparent).dontAnimate().into(dVar.f15906c);
                    }
                    if (bph.mo23360o() == 0) {
                        if (bph.mo23327a((Context) this.f15844c).exists()) {
                            dVar.f15908e.setTag(bph.mo23334b((Context) this.f15844c));
                            new C3939c(dVar.f15908e, bph).execute(new String[0]);
                            break;
                        }
                    } else {
                        dVar.f15908e.setVisibility(0);
                        dVar.f15908e.setText(bpd.m18502a(bph.mo23360o()));
                        break;
                    }
                    break;
                case 3:
                    dVar.f15907d.setImageResource(R.drawable.ic_image_black_24dp);
                    dVar.f15913j.setImageResource(R.drawable.ic_image_black_24dp);
                    dVar.f15906c.setVisibility(0);
                    if (!bph.mo23327a((Context) this.f15844c).exists()) {
                        Glide.with(this.f15844c).load(bph.mo23339c()).placeholder((int) R.color.transparent).error((int) R.color.transparent).dontAnimate().into(dVar.f15906c);
                        break;
                    } else {
                        Glide.with(this.f15844c).load(bph.mo23327a((Context) this.f15844c)).placeholder((int) R.color.transparent).error((int) R.color.transparent).dontAnimate().into(dVar.f15906c);
                        break;
                    }
                case 4:
                    dVar.f15907d.setImageResource(R.drawable.ic_audiotrack_black_24dp);
                    dVar.f15913j.setImageResource(R.drawable.ic_audiotrack_black_24dp);
                    bpg bpg = this.f15853l.get(bph.mo23334b((Context) this.f15844c));
                    if (bpg != null) {
                        if (!TextUtils.isEmpty(bpg.mo23323b())) {
                            dVar.f15909f.setText(bpg.mo23323b());
                        }
                        dVar.f15906c.setVisibility(0);
                        Glide.with(this.f15844c).load(bpg.mo23325c()).placeholder((int) R.drawable.transparent).error((int) R.drawable.round_corner_bg).dontAnimate().into(dVar.f15906c);
                        if (!TextUtils.isEmpty(bpg.mo23326d())) {
                            dVar.f15908e.setVisibility(0);
                            dVar.f15908e.setText(bpg.mo23326d());
                            break;
                        }
                    } else {
                        dVar.f15909f.setText(bph.mo23346e());
                        if (bph.mo23327a((Context) this.f15844c).exists()) {
                            dVar.f15909f.setTag(bph.mo23334b((Context) this.f15844c));
                            new C3937a(dVar.f15906c, dVar.f15909f, dVar.f15908e, bph.mo23334b((Context) this.f15844c)).execute(new String[0]);
                            break;
                        }
                    }
                    break;
                case 5:
                    dVar.f15907d.setImageResource(R.drawable.ic_android_black_24dp);
                    dVar.f15913j.setImageResource(R.drawable.ic_android_black_24dp);
                    WeakReference weakReference = this.f15852k.get(bph.mo23334b((Context) this.f15844c));
                    if (weakReference != null) {
                        drawable = (Drawable) weakReference.get();
                    }
                    if (drawable == null) {
                        if (bph.mo23327a((Context) this.f15844c).exists()) {
                            dVar.f15905b.setTag(bph.mo23334b((Context) this.f15844c));
                            new C3938b(dVar.f15906c, dVar.f15905b, bph.mo23334b((Context) this.f15844c)).execute(new String[0]);
                            break;
                        }
                    } else {
                        dVar.f15905b.setBackgroundColor(-1);
                        dVar.f15906c.setVisibility(0);
                        dVar.f15906c.setImageDrawable(drawable);
                        break;
                    }
                    break;
                case 6:
                    dVar.f15907d.setImageResource(R.drawable.ic_archive_black_24dp);
                    dVar.f15913j.setImageResource(R.drawable.ic_archive_black_24dp);
                    break;
                case 7:
                    dVar.f15907d.setImageResource(R.drawable.ic_description_black_24dp);
                    dVar.f15913j.setImageResource(R.drawable.ic_description_black_24dp);
                    break;
                default:
                    dVar.f15907d.setImageResource(R.drawable.ic_help_black_24dp);
                    dVar.f15913j.setImageResource(R.drawable.ic_help_black_24dp);
                    break;
            }
        } else {
            dVar.f15907d.setImageResource(R.drawable.ic_help_black_24dp);
            dVar.f15913j.setImageResource(R.drawable.ic_help_black_24dp);
        }
        int i2 = this.f15843b.f16022a;
        DownloadFinishedFragment bod = this.f15843b;
        if (i2 == 0) {
            dVar.f15911h.setVisibility(0);
            dVar.f15910g.setVisibility(4);
        } else {
            dVar.f15911h.setVisibility(4);
            dVar.f15910g.setVisibility(0);
            dVar.f15910g.setChecked(bph.mo23356k());
        }
        dVar.f15911h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DownloadFinishedFileItemFragment.this.m18187a((View) dVar.f15911h, bph);
            }
        });
        dVar.f15910g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bph.mo23332a(!bph.mo23356k());
                DownloadFinishedFileItemFragment.this.f15843b.mo23245a(true);
                DownloadFinishedFileItemFragment.this.f15842a.notifyDataSetChanged();
            }
        });
        dVar.f15904a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int i = DownloadFinishedFileItemFragment.this.f15843b.f16022a;
                DownloadFinishedFragment unused = DownloadFinishedFileItemFragment.this.f15843b;
                if (i == 0) {
                    BrowserLogEvent.downloaderLogEvent(DownloadFinishedFileItemFragment.this.f15844c, "Finished Fragment", "click item to play");
                    DownloadFinishedFileItemFragment.this.m18190a(bph);
                    return;
                }
                bph.mo23332a(!bph.mo23356k());
                DownloadFinishedFileItemFragment.this.f15843b.mo23245a(true);
                DownloadFinishedFileItemFragment.this.f15842a.notifyDataSetChanged();
            }
        });
        return view;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18187a(View view, final bph bph) {
        PopupMenu popupMenu = new PopupMenu(this.f15844c, view);
        popupMenu.getMenu().add(0, 0, 0, this.f15844c.getString(R.string.action_share));
        popupMenu.getMenu().add(0, 1, 0, this.f15844c.getString(R.string.action_rename));
        if (!TextUtils.isEmpty(bph.mo23354i())) {
            popupMenu.getMenu().add(0, 2, 0, this.f15844c.getString(R.string.go_to_website));
        }
        popupMenu.getMenu().add(0, 4, 0, this.f15844c.getString(R.string.title_download_location));
        popupMenu.getMenu().add(0, 3, 0, this.f15844c.getString(R.string.delete));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case 0:
                        BrowserLogEvent.downloaderLogEvent(DownloadFinishedFileItemFragment.this.f15844c, "Finished Fragment", "click share");
                        if (!box.m18457a(DownloadFinishedFileItemFragment.this.f15844c, new box.C3987a() {
                            /* renamed from: a */
                            public void mo21376a() {
                                bpc.m18495a(DownloadFinishedFileItemFragment.this.f15844c, bph);
                            }
                        })) {
                            return true;
                        }
                        bpc.m18495a(DownloadFinishedFileItemFragment.this.f15844c, bph);
                        return true;
                    case 1:
                        BrowserLogEvent.downloaderLogEvent(DownloadFinishedFileItemFragment.this.f15844c, "Finished Fragment", "rename");
                        DownloadFinishedFileItemFragment.this.m18201d(bph);
                        return true;
                    case 2:
                        BrowserLogEvent.downloaderLogEvent(DownloadFinishedFileItemFragment.this.f15844c, "Finished Fragment", "go to website");
                        bpd.m18515e(DownloadFinishedFileItemFragment.this.f15844c, bph.mo23354i());
                        return true;
                    case 3:
                        BrowserLogEvent.downloaderLogEvent(DownloadFinishedFileItemFragment.this.f15844c, "Finished Fragment", "delete");
                        DownloadFinishedFileItemFragment.this.m18198c(bph);
                        return true;
                    case 4:
                        BrowserLogEvent.downloaderLogEvent(DownloadFinishedFileItemFragment.this.f15844c, "Finished Fragment", "download location");
                        AlertDialog.Builder builder = new AlertDialog.Builder(DownloadFinishedFileItemFragment.this.f15844c);
                        builder.setTitle((CharSequence) DownloadFinishedFileItemFragment.this.f15844c.getString(R.string.title_download_location));
                        builder.setMessage((CharSequence) bph.mo23334b((Context) DownloadFinishedFileItemFragment.this.f15844c));
                        builder.setPositiveButton((CharSequence) DownloadFinishedFileItemFragment.this.f15844c.getString(R.string.action_ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        builder.setNegativeButton((CharSequence) DownloadFinishedFileItemFragment.this.f15844c.getString(R.string.copy), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                bpc.m18496a((Context) DownloadFinishedFileItemFragment.this.f15844c, "path", bph.mo23334b((Context) DownloadFinishedFileItemFragment.this.f15844c));
                            }
                        });
                        builder.show();
                        return true;
                    default:
                        return true;
                }
            }
        });
        popupMenu.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18190a(final bph bph) {
        if (bph.mo23327a((Context) this.f15844c).exists()) {
            bpd.m18505a(this.f15844c, bph, (List<bph>) this.f15845d);
        } else if (box.m18457a(this.f15844c, new box.C3987a() {
            /* renamed from: a */
            public void mo21376a() {
                DownloadFinishedFileItemFragment.this.m18195b(bph);
            }
        })) {
            m18195b(bph);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18195b(bph bph) {
        Toast.makeText(this.f15844c, this.f15844c.getString(R.string.file_not_exist), 1).show();
        this.f15845d.remove(bph);
        this.f15842a.notifyDataSetChanged();
        bnm.m18246a().mo23221a((Context) this.f15844c, bph.mo23333b());
        bph.mo23335b(1);
        bpd.m18506a((Context) this.f15844c, bph);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18198c(final bph bph) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f15844c);
        builder.setMessage((CharSequence) this.f15844c.getString(R.string.delete_tip));
        builder.setNegativeButton((CharSequence) this.f15844c.getString(R.string.action_cancel), (DialogInterface.OnClickListener) null);
        builder.setPositiveButton((CharSequence) this.f15844c.getString(R.string.delete), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                bpd.m18512c((Context) DownloadFinishedFileItemFragment.this.f15844c, bph);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18201d(bph bph) {
        BrowserLogEvent.m18381a(this.f15844c, "rename", bqw.m19011a(bph.mo23354i()), bph.mo23339c());
        String str = "";
        String str2 = "";
        int lastIndexOf = bph.mo23346e().lastIndexOf(46);
        if (lastIndexOf > 0 && lastIndexOf + 1 < bph.mo23346e().length()) {
            str = bph.mo23346e().substring(lastIndexOf);
            str2 = bph.mo23346e().substring(0, lastIndexOf);
        }
        final AlertDialog show = new AlertDialog.Builder(this.f15844c).setTitle((int) R.string.action_rename).setView((int) R.layout.dialog_rename).setPositiveButton((int) R.string.action_rename, (DialogInterface.OnClickListener) null).setNegativeButton((int) R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
        final TextInputLayout textInputLayout = (TextInputLayout) show.findViewById(R.id.textInputLayout);
        final EditText editText = (EditText) textInputLayout.findViewById(R.id.file_name);
        editText.setText(str2);
        final Button button = show.getButton(-1);
        button.setEnabled(false);
        String finalStr = str2;
        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                textInputLayout.setError((CharSequence) null);
                boolean z = false;
                textInputLayout.setErrorEnabled(false);
                String trim = editable.toString().trim();
               // Button button = button;
                if (!TextUtils.isEmpty(trim) && !TextUtils.equals(trim, finalStr)) {
                    z = true;
                }
                button.setEnabled(z);
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z && show.getWindow() != null) {
                    show.getWindow().setSoftInputMode(5);
                }
            }
        });
        show.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                editText.requestFocus();
            }
        });
        show.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        });
        final TextInputLayout textInputLayout2 = textInputLayout;
        final EditText editText2 = editText;
        final AlertDialog alertDialog = show;
        final bph bph2 = bph;
        final String str3 = str;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean unused = DownloadFinishedFileItemFragment.this.m18191a(textInputLayout2, editText2, alertDialog, bph2, str3);
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return i == 2 && DownloadFinishedFileItemFragment.this.m18191a(textInputLayout2, editText2, alertDialog, bph2, str3);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m18191a(TextInputLayout textInputLayout, EditText editText, Dialog dialog, bph bph, String str) {
        String a = bpc.m18493a(editText.getText().toString().trim());
        String g = bph.mo23350g();
        File file = new File(g, a + str);
        if (file.exists() || boi.m18319b().mo23275d(file.getName()) || bnm.m18246a().mo23224b((Context) this.f15844c, file.getName())) {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError(this.f15844c.getString(R.string.already_in_use));
            return false;
        }
        File file2 = new File(bph.mo23350g(), bph.mo23346e());
        boolean renameTo = file2.renameTo(file);
        if (renameTo) {
            dialog.dismiss();
            bph.mo23342c(a + str);
            bnm.m18246a().mo23225c(this.f15844c, bph);
            this.f15842a.notifyDataSetChanged();
            if (bpj.m18578a((Context) this.f15844c).mo23404k()) {
                bpd.m18511b((Context) this.f15844c, file2.getAbsolutePath());
                bpd.m18508a((Context) this.f15844c, file.getAbsolutePath());
            }
            BrowserLogEvent.downloaderLogEvent(this.f15844c, "Rename", "success");
        } else {
            BrowserLogEvent.downloaderLogEvent(this.f15844c, "Rename", "failed");
        }
        return renameTo;
    }

    /* renamed from: bnf$d */
    private class C3940d {

        /* renamed from: a */
        RelativeLayout f15904a;

        /* renamed from: b */
        RelativeLayout f15905b;

        /* renamed from: c */
        ImageView f15906c;

        /* renamed from: d */
        ImageView f15907d;

        /* renamed from: e */
        TextView f15908e;

        /* renamed from: f */
        TextView f15909f;

        /* renamed from: g */
        CheckBox f15910g;

        /* renamed from: h */
        ImageView f15911h;

        /* renamed from: i */
        TextView f15912i;

        /* renamed from: j */
        ImageView f15913j;

        private C3940d() {
        }
    }

    /* renamed from: bnf$b */
    private class C3938b extends AsyncTask<String, Void, Drawable> {

        /* renamed from: b */
        private ImageView f15898b;

        /* renamed from: c */
        private RelativeLayout f15899c;

        /* renamed from: d */
        private String f15900d;

        public C3938b(ImageView imageView, RelativeLayout relativeLayout, String str) {
            this.f15898b = imageView;
            this.f15899c = relativeLayout;
            this.f15900d = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Drawable doInBackground(String... strArr) {
            return bqu.m18999a(DownloadFinishedFileItemFragment.this.f15844c, DownloadFinishedFileItemFragment.this.f15846e, this.f15900d);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Drawable drawable) {
            if (drawable != null && !TextUtils.isEmpty(this.f15900d) && this.f15899c.getTag() != null && this.f15899c.getTag().toString().equals(this.f15900d)) {
                DownloadFinishedFileItemFragment.this.f15852k.put(this.f15900d, new WeakReference(drawable));
                this.f15899c.setBackgroundColor(-1);
                this.f15898b.setVisibility(0);
                this.f15898b.setImageDrawable(drawable);
            }
        }
    }

    /* renamed from: bnf$c */
    private class C3939c extends AsyncTask<String, Void, Long> {

        /* renamed from: b */
        private TextView f15902b;

        /* renamed from: c */
        private bph f15903c;

        private C3939c(TextView textView, bph bph) {
            this.f15902b = textView;
            this.f15903c = bph;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Long doInBackground(String... strArr) {
            long a = bpd.m18498a(this.f15903c.mo23334b((Context) DownloadFinishedFileItemFragment.this.f15844c));
            if (a > 0) {
                this.f15903c.mo23344d(a);
                bnm.m18246a().mo23223b((Context) DownloadFinishedFileItemFragment.this.f15844c, this.f15903c);
            }
            return Long.valueOf(a);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Long l) {
            if (l.longValue() > 0 && this.f15903c != null && this.f15902b.getTag() != null && this.f15902b.getTag().equals(this.f15903c.mo23334b((Context) DownloadFinishedFileItemFragment.this.f15844c))) {
                String a = bpd.m18502a(l.longValue());
                if (!TextUtils.isEmpty(a) && !a.equals("00:00")) {
                    this.f15902b.setVisibility(0);
                    this.f15902b.setText(a);
                }
            }
        }
    }

    /* renamed from: bnf$a */
    private class C3937a extends AsyncTask<String, Void, bpg> {

        /* renamed from: b */
        private ImageView f15893b;

        /* renamed from: c */
        private TextView f15894c;

        /* renamed from: d */
        private TextView f15895d;

        /* renamed from: e */
        private String f15896e;

        public C3937a(ImageView imageView, TextView textView, TextView textView2, String str) {
            this.f15893b = imageView;
            this.f15894c = textView;
            this.f15895d = textView2;
            this.f15896e = str;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0079 A[SYNTHETIC, Splitter:B:21:0x0079] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x008b A[SYNTHETIC, Splitter:B:30:0x008b] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public bpg doInBackgroundd(String... r11) {
            /*
                r10 = this;
                bpg r11 = new bpg
                r11.<init>()
                java.lang.String r0 = "title"
                java.lang.String r1 = "album_id"
                java.lang.String r2 = "duration"
                java.lang.String[] r5 = new java.lang.String[]{r0, r1, r2}
                r0 = 0
                bnf r1 = bnf.this     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                android.app.Activity r1 = r1.f15844c     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                android.content.ContentResolver r3 = r1.getContentResolver()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                android.net.Uri r4 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                java.lang.String r6 = "_data= ?"
                r1 = 1
                java.lang.String[] r7 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                r1 = 0
                java.lang.String r2 = r10.f15896e     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                r7[r1] = r2     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                r8 = 0
                android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                if (r1 == 0) goto L_0x0061
                boolean r0 = r1.moveToNext()     // Catch:{ Exception -> 0x005f }
                if (r0 == 0) goto L_0x0061
                java.lang.String r0 = "title"
                int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x005f }
                java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x005f }
                r11.mo23322a((java.lang.String) r0)     // Catch:{ Exception -> 0x005f }
                java.lang.String r0 = "album_id"
                int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x005f }
                long r2 = r1.getLong(r0)     // Catch:{ Exception -> 0x005f }
                r11.mo23321a((long) r2)     // Catch:{ Exception -> 0x005f }
                java.lang.String r0 = "duration"
                int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x005f }
                long r2 = r1.getLong(r0)     // Catch:{ Exception -> 0x005f }
                java.lang.String r0 = bpd.m18502a((long) r2)     // Catch:{ Exception -> 0x005f }
                r11.mo23324b(r0)     // Catch:{ Exception -> 0x005f }
                goto L_0x0061
            L_0x005f:
                r0 = move-exception
                goto L_0x0074
            L_0x0061:
                if (r1 == 0) goto L_0x0087
                boolean r0 = r1.isClosed()     // Catch:{ Exception -> 0x0083 }
                if (r0 != 0) goto L_0x0087
                r1.close()     // Catch:{ Exception -> 0x0083 }
                goto L_0x0087
            L_0x006d:
                r11 = move-exception
                r1 = r0
                goto L_0x0089
            L_0x0070:
                r1 = move-exception
                r9 = r1
                r1 = r0
                r0 = r9
            L_0x0074:
                r0.printStackTrace()     // Catch:{ all -> 0x0088 }
                if (r1 == 0) goto L_0x0087
                boolean r0 = r1.isClosed()     // Catch:{ Exception -> 0x0083 }
                if (r0 != 0) goto L_0x0087
                r1.close()     // Catch:{ Exception -> 0x0083 }
                goto L_0x0087
            L_0x0083:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0087:
                return r11
            L_0x0088:
                r11 = move-exception
            L_0x0089:
                if (r1 == 0) goto L_0x0099
                boolean r0 = r1.isClosed()     // Catch:{ Exception -> 0x0095 }
                if (r0 != 0) goto L_0x0099
                r1.close()     // Catch:{ Exception -> 0x0095 }
                goto L_0x0099
            L_0x0095:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0099:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: bnf.C3937a.doInBackground(java.lang.String[]):bpg");
        }
        public bpg doInBackground(String... strArr) {
            Throwable th;
            Cursor cursor;
            Exception e2;
            bpg bpg = new bpg();
            try {
                cursor = DownloadFinishedFileItemFragment.this.f15844c.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"title", "album_id", VastIconXmlManager.DURATION}, "_data= ?", new String[]{this.f15896e}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            bpg.mo23322a(cursor.getString(cursor.getColumnIndexOrThrow("title")));
                            bpg.mo23321a(cursor.getLong(cursor.getColumnIndexOrThrow("album_id")));
                            bpg.mo23324b(bpd.m18502a(cursor.getLong(cursor.getColumnIndexOrThrow(VastIconXmlManager.DURATION))));
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            e2.printStackTrace();
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return bpg;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                }
                if (cursor != null) {
                    try {
                        if (!cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                cursor = null;
                e2 = e5;
                e2.printStackTrace();
                cursor.close();
                return bpg;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                    try {
                        if (!cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
               // throw th;
            }
            return bpg;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(bpg bpg) {
            try {
                if (DownloadFinishedFileItemFragment.this.f15844c != null && !TextUtils.isEmpty(this.f15896e) && this.f15894c.getTag() != null && this.f15894c.getTag().toString().equals(this.f15896e)) {
                    if (!TextUtils.isEmpty(bpg.mo23323b())) {
                        this.f15894c.setText(bpg.mo23323b());
                    }
                    if (!TextUtils.isEmpty(bpg.mo23326d())) {
                        this.f15895d.setVisibility(0);
                        this.f15895d.setText(bpg.mo23326d());
                    }
                    this.f15893b.setVisibility(0);
                    Glide.with(DownloadFinishedFileItemFragment.this.f15844c).load(bpg.mo23325c()).placeholder((int) R.drawable.transparent).error((int) R.drawable.transparent).dontAnimate().into(this.f15893b);
                    DownloadFinishedFileItemFragment.this.f15853l.put(this.f15896e, bpg);
                }
            } catch (Exception e) {
                e.printStackTrace();
                bbc.m15886a().mo21879a((Context) DownloadFinishedFileItemFragment.this.f15844c, (Throwable) e);
            }
        }
    }
}
