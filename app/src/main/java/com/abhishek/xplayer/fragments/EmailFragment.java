package com.abhishek.xplayer.fragments;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputLayout;
import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.application.MyApplication;


import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Locale;

import classesdef.eventbus.awi;
import classesdef.inplayer.awt;
import classesdef.player.DefaultSharedPreferences;
import classesdef.xdplayer.axk;
import classesdef.xdplayer.AllPermission;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;

/* renamed from: com.inshot.xplayer.fragments.b */
public class EmailFragment extends FragmentLifecycle implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener {

    /* renamed from: a */
    private int f10659a;

    /* renamed from: b */
    private int f10660b;

    /* renamed from: c */
    private String f10661c;

    /* renamed from: d */
    private String f10662d;

    /* renamed from: e */
    private TextView f10663e;

    /* renamed from: f */
    private TextView f10664f;

    /* renamed from: g */
    private TextInputLayout f10665g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public EditText f10666h;

    /* renamed from: i */
    private View f10667i;

    /* renamed from: j */
    private View f10668j;

    /* renamed from: k */
    private List<String> f10669k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ProgressDialog f10670l;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* renamed from: a */
    public static EmailFragment m12242a(int i, String str) {
        EmailFragment bVar = new EmailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mode", i);
        bundle.putSerializable("pin", str);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f10659a = arguments.getInt("mode");
            this.f10661c = arguments.getString("pin");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_email, viewGroup, false);
        this.f10660b = 0;
        this.f10663e = (TextView) inflate.findViewById(R.id.current_pin);
        this.f10664f = (TextView) inflate.findViewById(R.id.email_tips);
        this.f10665g = (TextInputLayout) inflate.findViewById(R.id.email_text_layout);
        this.f10666h = (EditText) inflate.findViewById(R.id.email_text);
        this.f10667i = inflate.findViewById(R.id.contact_us);
        this.f10668j = inflate.findViewById(R.id.get_email);
        if (Build.VERSION.SDK_INT >= 26 && this.f10659a == 1) {
            this.f10668j.setVisibility(0);
        }
        this.f10668j.setOnClickListener(this);
        this.f10667i.setOnClickListener(this);
        this.f10666h.setOnEditorActionListener(this);
        this.f10666h.addTextChangedListener(this);
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setHomeAsUpIndicator((int) R.drawable.ic_back);
        supportActionBar.setSubtitle((CharSequence) null);
        switch (this.f10659a) {
            case 0:
                this.f10664f.setText(R.string.email_input_forget);
                supportActionBar.setTitle((int) R.string.pin_forget);
                break;
            case 1:
            case 2:
                this.f10664f.setText(R.string.email_input);
                this.f10663e.setText(Html.fromHtml(getString(R.string.pin_text, String.format(Locale.ENGLISH, "<font color='#FF8000'>%s</font>", new Object[]{this.f10661c}))));
                this.f10663e.setVisibility(0);
                supportActionBar.setTitle((int) R.string.set_email);
                break;
        }
        setHasOptionsMenu(true);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f10666h.post(new Runnable() {
            public void run() {
                EmailFragment.this.f10666h.requestFocus();
                EmailFragment.this.m12247a(true, (View) EmailFragment.this.f10666h);
            }
        });
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 26 && this.f10659a == 1 && this.f10660b < 1 && (this.f10669k == null || this.f10669k.isEmpty())) {
            if (!AllPermission.m7381a(getContext(), "android.permission.GET_ACCOUNTS")) {
                this.f10668j.setVisibility(0);
            } else {
                this.f10668j.setVisibility(8);
                this.f10669k = awt.m7208d(getContext());
                m12255i();
            }
        }
        FileExplorerActivity.fragmentName = "Email";
        super.onResume();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            m12247a(false, (View) this.f10666h);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_email, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem = menu.findItem(R.id.done);
        MenuItem findItem2 = menu.findItem(R.id.next);
        MenuItem findItem3 = menu.findItem(R.id.retrieve);
        if (this.f10659a == 0) {
            if (findItem != null) {
                findItem.setVisible(false);
            }
            if (findItem2 != null) {
                findItem2.setVisible(false);
            }
            if (findItem3 != null) {
                findItem3.setVisible(true);
            }
        } else {
            if (this.f10660b > 0) {
                if (findItem != null) {
                    findItem.setVisible(true);
                }
                if (findItem2 != null) {
                    findItem2.setVisible(false);
                }
            } else {
                if (findItem != null) {
                    findItem.setVisible(false);
                }
                if (findItem2 != null) {
                    findItem2.setVisible(true);
                }
            }
            if (findItem3 != null) {
                findItem3.setVisible(false);
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!mo17989b()) {
            return false;
        }
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId == R.id.done || itemId == R.id.next || itemId == R.id.retrieve) {
                m12252f();
            }
        } else if (!mo17990c()) {
            m12247a(false, (View) this.f10666h);
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onClick(View view) {
        if (mo17989b()) {
            int id = view.getId();
            if (id == R.id.contact_us) {
                m12246a(false);
            } else if (id == R.id.get_email) {
                if (Build.VERSION.SDK_INT >= 26) {
                    startActivityForResult(AccountManager.newChooseAccountIntent((Account) null, (List) null, (String[]) null, (String) null, (String) null, (String[]) null, (Bundle) null), 33651);
                } else {
                    mo17991a();
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 33651) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            intent.getStringExtra("authAccount");
            intent.getStringExtra("accountType");
            this.f10669k = awt.m7208d(getContext());
            m12255i();
        }
    }

    public void afterTextChanged(Editable editable) {
        this.f10665g.setError((CharSequence) null);
        this.f10665g.setErrorEnabled(false);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        if (!axw.m7447a((Activity) getActivity())) {
            m12247a(false, (View) this.f10666h);
        }
        m12252f();
        return true;
    }

    /* renamed from: f */
    private void m12252f() {
        if (mo17989b()) {
            switch (this.f10659a) {
                case 0:
                    this.f10662d = this.f10666h.getText().toString();
                    if (TextUtils.equals(this.f10662d, m12251e())) {
                        m12254h();
                        return;
                    }
                    this.f10665g.setErrorEnabled(true);
                    this.f10665g.setError(getString(R.string.email_error));
                    this.f10667i.setVisibility(0);
                    return;
                case 1:
                case 2:
                    if (this.f10660b == 0) {
                        if (this.f10669k != null && !this.f10669k.isEmpty()) {
                            String obj = this.f10666h.getText().toString();
                            if (this.f10669k.contains(obj)) {
                                this.f10662d = obj;
                                m12253g();
                                return;
                            }
                        }
                        this.f10662d = this.f10666h.getText().toString();
                        if (!m12248a(this.f10662d)) {
                            this.f10665g.setErrorEnabled(true);
                            this.f10665g.setError(getString(R.string.email_format_error));
                            return;
                        }
                        this.f10660b++;
                        if (this.f10668j.getVisibility() == 0) {
                            this.f10668j.setVisibility(8);
                        }
                        this.f10663e.setVisibility(8);
                        this.f10664f.setText(R.string.email_input_again);
                        this.f10666h.setText("");
                        getActivity().invalidateOptionsMenu();
                        return;
                    } else if (TextUtils.equals(this.f10666h.getText().toString(), this.f10662d)) {
                        m12253g();
                        return;
                    } else {
                        this.f10665g.setErrorEnabled(true);
                        this.f10665g.setError(getString(R.string.email_error));
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* renamed from: g */
    private void m12253g() {
        FragmentManager supportFragmentManager;
        m12247a(false, (View) this.f10666h);
        m12245a(this.f10661c, this.f10662d);
        if (!mo17990c() && (supportFragmentManager = getActivity().getSupportFragmentManager()) != null) {
            int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
            if (backStackEntryCount > 1) {
                FragmentManager.BackStackEntry backStackEntryAt = supportFragmentManager.getBackStackEntryAt(backStackEntryCount - 2);
                supportFragmentManager.popBackStack();
                if (backStackEntryAt != null && PasswordFragment.class.getSimpleName().equals(backStackEntryAt.getName())) {
                    supportFragmentManager.popBackStack();
                }
                supportFragmentManager.executePendingTransactions();
            } else {
                getActivity().onBackPressed();
            }
        }
        EventBus.getDefault().post(new awi());
        if (this.f10659a == 2) {
            axv.m7434a((int) R.string.modify_pin_success);
        }
    }

    /* renamed from: h */
    private void m12254h() {
        m12247a(false, (View) this.f10666h);
        if (this.f10670l == null) {
            this.f10670l = new ProgressDialog(getActivity(), R.style.MyAlertStyle);
            ProgressDialog progressDialog = this.f10670l;
            progressDialog.setMessage(getString(R.string.retrieve) + "...");
            this.f10670l.setCancelable(false);
            this.f10670l.setIndeterminate(true);
        }
        this.f10670l.show();
        LogEvents.m18496c("retrievePin", "ServerAPI");
        axk.m7371a(this.f10662d, PasswordFragment.m12276d(), getResources().getConfiguration().locale, new axk.C1357a() {
            /* renamed from: a */
            public void mo10985a(boolean z) {
                if (EmailFragment.this.f10670l != null) {
                    EmailFragment.this.f10670l.dismiss();
                }
                if (EmailFragment.this.mo17989b()) {
                    new AlertDialog.Builder(EmailFragment.this.getActivity(), R.style.MyAlertStyle).setTitle(z ? R.string.email_sent_title : R.string.email_wrong_server).setMessage(z ? R.string.email_sent_desc : R.string.email_wrong_server_desc).setCancelable(false).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (!EmailFragment.this.mo17990c()) {
                                EmailFragment.this.getActivity().onBackPressed();
                            }
                        }
                    }).show();
                }
            }

            /* renamed from: b */
            public void mo10986b(final boolean z) {
                if (EmailFragment.this.f10670l != null) {
                    EmailFragment.this.f10670l.dismiss();
                }
                if (EmailFragment.this.mo17989b()) {
                    new AlertDialog.Builder(EmailFragment.this.getActivity(), R.style.MyAlertStyle).setTitle(z ? R.string.email_wrong_net : R.string.email_wrong_email).setMessage(z ? R.string.email_wrong_net_desc : R.string.email_wrong_email_desc).setPositiveButton(z ? R.string.ok : R.string.contact_us, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (!z) {
                                EmailFragment.this.m12246a(true);
                            }
                        }
                    }).show();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12246a(boolean z) {
        axy.m7465a(getActivity(), z ? "Can not send email successfully" : "Email Don't Match", m12251e(), PasswordFragment.m12276d(), z);
    }

    /* renamed from: i */
    private void m12255i() {
        if (this.f10669k != null && !this.f10669k.isEmpty()) {
            this.f10666h.setText(this.f10669k.get(0));
        }
    }

    /* renamed from: a */
    public void mo17991a() {
        if (!DefaultSharedPreferences.getAdRemoved("CPhNuBnN", false) || shouldShowRequestPermissionRationale("android.permission.GET_ACCOUNTS")) {
            requestPermissions(AllPermission.getAccount, 4);
        } else {
            AllPermission.m7377a((Fragment) this);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 4 && !AllPermission.permissionChek(iArr)) {
            DefaultSharedPreferences.m7385a("CPhNuBnN", true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12247a(boolean z, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (z) {
            inputMethodManager.showSoftInput(view, 0);
        } else {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* renamed from: a */
    private static boolean m12248a(String str) {
        return !TextUtils.isEmpty(str) && Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    /* renamed from: d */
    public static boolean m12250d() {
        return !TextUtils.isEmpty(m12251e());
    }

    /* renamed from: e */
    static String m12251e() {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getString("_email", (String) null);
    }

    /* renamed from: a */
    private static void m12245a(String str, String str2) {
        if (str != null && str2 != null) {
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putString("_pin", str).putString("_email", str2).apply();
        }
    }
}
