package classesdef.xdplayer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.C2636d;
import com.abhishek.xplayer.fragments.FragmentLifecycle;

import java.io.File;
import java.util.regex.Pattern;

import classesdef.inplayer.axi;
import classesdef.inplayer.SharedPrefrence;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: axb */
public class axb implements axq.C1362a {

    /* renamed from: k */
    private static final Pattern f6224k = Pattern.compile("[*\\\\/\":?<>|]");
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Object f6225a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f6226b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f6227c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1341a f6228d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f6229e;

    /* renamed from: f */
    private axq f6230f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f6231g;

    /* renamed from: h */
    private String f6232h = "";

    /* renamed from: i */
    private String f6233i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f6234j;

    /* renamed from: axb$a */
    public interface C1341a {
        /* renamed from: a */
        void mo10957a();

        /* renamed from: a */
        void mo10958a(String str, String str2, Object obj);

        /* renamed from: b */
        void mo10959b();

        /* renamed from: c */
        void mo10960c();
    }

    public axb(String str, Object obj, C1341a aVar) {
        this.f6228d = aVar;
        this.f6226b = str;
        this.f6225a = obj;
        m7277a();
    }

    /* renamed from: a */
    private void m7277a() {
        int lastIndexOf;
        File file = new File(this.f6226b);
        this.f6231g = file.getName();
        this.f6233i = file.getParent();
        if (!file.isDirectory() && (lastIndexOf = this.f6231g.lastIndexOf(46)) > 0 && lastIndexOf + 1 < this.f6231g.length()) {
            this.f6232h = this.f6231g.substring(lastIndexOf);
            this.f6231g = this.f6231g.substring(0, lastIndexOf);
        }
    }

    /* renamed from: a */
    public void mo10944a(FragmentLifecycle aVar) {
        AlertDialog.Builder builder;
        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
            builder = new AlertDialog.Builder(aVar.getActivity(), R.style.MyAlertStyle);
        } else {
            builder = new AlertDialog.Builder(aVar.getActivity());
        }
        final AlertDialog show = builder.setTitle((int) R.string.rename).setView((int) R.layout.layout_rename).setPositiveButton((int) R.string.rename, (DialogInterface.OnClickListener) null).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
        final TextInputLayout textInputLayout = (TextInputLayout) show.findViewById(R.id.textInputLayout);
        final EditText editText = (EditText) textInputLayout.findViewById(R.id.file_name);
        editText.setText(this.f6231g);
        final Button button = show.getButton(-1);
        button.setEnabled(false);
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
        //        Button button = button;
                if (!TextUtils.isEmpty(trim) && !TextUtils.equals(trim,axb.this.f6231g)) {
                    z = true;
                }
                button.setEnabled(z);
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
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
        final FragmentLifecycle aVar2 = aVar;
        final EditText editText2 = editText;
        final AlertDialog alertDialog = show;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean unused =axb.this.m7279a(textInputLayout2, aVar2, editText2, alertDialog);
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return i == 2 &&axb.this.m7279a(textInputLayout2, aVar2, editText2, alertDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7279a(TextInputLayout textInputLayout, FragmentLifecycle aVar, EditText editText, Dialog dialog) {
        if (!aVar.mo17989b()) {
            return false;
        }
        String a = m7276a(editText.getText().toString().trim());
        if (a != null) {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError(a);
            return false;
        }
        m7278a(true);
        dialog.dismiss();
        return true;
    }

    /* renamed from: a */
    private String m7276a(String str) {
        if (f6224k.matcher(str).find()) {
            return MyApplication.getApplicationContext_().getString(R.string.rename_invalid_char, new Object[]{"*\\/\":?<>|"});
        }
        String str2 = this.f6233i;
        File file = new File(str2, str + this.f6232h);
        if (file.exists()) {
            return MyApplication.getApplicationContext_().getString(R.string.rename_in_use);
        }
        this.f6234j = file.getAbsolutePath();
        return null;
    }

    /* renamed from: a */
    private void m7278a(boolean z) {
        this.f6227c = z && Build.VERSION.SDK_INT >= 21;
        this.f6228d.mo10960c();
        new Thread() {
            public void run() {
                File file = new File(axb.this.f6226b);
                File file2 = new File(axb.this.f6234j);
                boolean isDirectory = file.isDirectory();
                if (file.renameTo(file2) || awx.m7222a(MyApplication.getApplicationContext_(), file, file2.getName())) {
                    axi.m7356a(MyApplication.getApplicationContext_(),axb.this.f6226b);
                    axi.m7356a(MyApplication.getApplicationContext_(),axb.this.f6234j);
                    if (isDirectory) {
                        C2636d.m12143a(axb.this.f6226b,axb.this.f6234j);
                    }
                    MyApplication.myApplication().runnable((Runnable) new Runnable() {
                        public void run() {
                           axb.this.f6228d.mo10958a(axb.this.f6226b,axb.this.f6234j,axb.this.f6225a);
                        }
                    });
                } else if (axb.this.f6227c) {
                    String unused =axb.this.f6229e =axb.this.f6226b;
                    MyApplication.myApplication().runnable((Runnable) new Runnable() {
                        public void run() {
                           axb.this.f6228d.mo10959b();
                        }
                    });
                } else {
                    MyApplication.myApplication().runnable((Runnable) new Runnable() {
                        public void run() {
                           axb.this.f6228d.mo10957a();
                        }
                    });
                }
            }
        }.start();
    }

    /* renamed from: a */
    public void mo10943a(Fragment fragment, int i) {
        if (this.f6230f == null) {
            this.f6230f = new axq(this, this.f6229e);
        }
        this.f6230f.mo10993a(fragment, i);
    }

    /* renamed from: a */
    public void mo10942a(int i, Intent intent) {
        if (this.f6230f != null) {
            this.f6230f.mo10992a(i, intent);
        }
    }

    /* renamed from: c */
    public void mo10931c() {
        m7278a(false);
    }

    /* renamed from: d */
    public void mo10932d() {
        this.f6228d.mo10957a();
    }

    /* renamed from: e */
    public void mo10933e() {
        this.f6228d.mo10957a();
    }
}
