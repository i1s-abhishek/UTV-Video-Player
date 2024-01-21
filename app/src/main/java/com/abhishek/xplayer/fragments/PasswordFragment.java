package com.abhishek.xplayer.fragments;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.application.AppActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.C2624a;

import classesdef.inplayer.awz;
import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.aya;
import classesdef.xdplayer.LogEvents;
import hdplayer.xdplayer.videoplayer.R;

/* renamed from: com.inshot.xplayer.fragments.d */
public class PasswordFragment extends FragmentLifecycle implements View.OnClickListener {

    /* renamed from: a */
    private int f10703a;

    /* renamed from: b */
    private int f10704b;

    /* renamed from: c */
    private String f10705c;

    /* renamed from: d */
    private StringBuilder f10706d;

    /* renamed from: e */
    private TextView f10707e;

    /* renamed from: f */
    private ImageView[] f10708f;

    /* renamed from: g */
    private ViewGroup f10709g;

    /* renamed from: h */
    private int f10710h = 0;

    /* renamed from: i */
    private View f10711i;

    /* renamed from: j */
    private View f10712j;

    /* renamed from: k */
    private LinearLayout f10713k;

    /* renamed from: l */
    private View f10714l;

    /* renamed from: m */
    private boolean f10715m = true;

    /* renamed from: a */
    public static PasswordFragment m12270a(int i) {
        PasswordFragment dVar = new PasswordFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mode", i);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f10703a = arguments.getInt("mode");
        }
        this.f10706d = new StringBuilder();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = true;
        if (configuration.orientation != 1) {
            z = false;
        }
        m12272a(z);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_password, viewGroup, false);
        this.f10715m = true;
        this.f10713k = (LinearLayout) inflate;
        this.f10711i = inflate.findViewById(R.id.layout_top);
        this.f10712j = inflate.findViewById(R.id.layout_bottom);
        this.f10714l = inflate.findViewById(R.id.pin_forgot);
        this.f10714l.setOnClickListener(this);
        this.f10708f = new ImageView[4];
        this.f10709g = (ViewGroup) this.f10711i.findViewById(R.id.pin_layout);
        for (int i = 0; i < 4; i++) {
            this.f10708f[i] = (ImageView) this.f10709g.getChildAt(i);
        }
        m12277e();
        this.f10707e = (TextView) this.f10711i.findViewById(R.id.pin_title);
        this.f10712j.findViewById(R.id.key_0).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_1).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_2).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_3).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_4).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_5).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_6).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_7).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_8).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_9).setOnClickListener(this);
        this.f10712j.findViewById(R.id.key_back).setOnClickListener(this);
        this.f10704b = 0;
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setHomeAsUpIndicator((int) R.drawable.ic_back);
        supportActionBar.setSubtitle((CharSequence) null);
        switch (this.f10703a) {
            case 0:
                this.f10707e.setText(R.string.pin_enter);
                supportActionBar.setTitle((int) R.string.private_videos);
                break;
            case 1:
                this.f10707e.setText(R.string.modify_pin_current);
                supportActionBar.setTitle((int) R.string.modify_pin);
                break;
            case 2:
                this.f10707e.setText(R.string.set_pin);
                supportActionBar.setTitle((int) R.string.set_pin);
                break;
        }
        setHasOptionsMenu(true);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        boolean z = true;
        if (getResources().getConfiguration().orientation != 1) {
            z = false;
        }
        m12272a(z);
    }

    public void onResume() {
        FileExplorerActivity.fragmentName = "Password";
        super.onResume();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!mo17989b()) {
            return false;
        }
        if (menuItem.getItemId() == 16908332 && !mo17990c()) {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onClick(View view) {
        if (mo17989b()) {
            int id = view.getId();
            if (id != R.id.pin_forgot) {
                switch (id) {
                    case R.id.key_0 /*2131296579*/:
                        m12274b(0);
                        return;
                    case R.id.key_1 /*2131296580*/:
                        m12274b(1);
                        return;
                    case R.id.key_2 /*2131296581*/:
                        m12274b(2);
                        return;
                    case R.id.key_3 /*2131296582*/:
                        m12274b(3);
                        return;
                    case R.id.key_4 /*2131296583*/:
                        m12274b(4);
                        return;
                    case R.id.key_5 /*2131296584*/:
                        m12274b(5);
                        return;
                    case R.id.key_6 /*2131296585*/:
                        m12274b(6);
                        return;
                    case R.id.key_7 /*2131296586*/:
                        m12274b(7);
                        return;
                    case R.id.key_8 /*2131296587*/:
                        m12274b(8);
                        return;
                    case R.id.key_9 /*2131296588*/:
                        m12274b(9);
                        return;
                    case R.id.key_back /*2131296589*/:
                        m12274b(-1);
                        return;
                    default:
                        return;
                }
            } else {
                AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), EmailFragment.m12242a(0, (String) null), true);
                this.f10706d.delete(0, this.f10706d.length());
            }
        }
    }

    /* renamed from: a */
    private void m12272a(boolean z) {
        if (this.f10715m != z) {
            this.f10715m = z;
            if (z) {
                ViewGroup.LayoutParams layoutParams = this.f10711i.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = 0;
                ViewGroup.LayoutParams layoutParams2 = this.f10712j.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = getResources().getDimensionPixelSize(R.dimen.password_size);
                this.f10713k.setOrientation(1);
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = this.f10711i.getLayoutParams();
            layoutParams3.height = -1;
            layoutParams3.width = 0;
            ViewGroup.LayoutParams layoutParams4 = this.f10712j.getLayoutParams();
            layoutParams4.height = -1;
            layoutParams4.width = getResources().getDimensionPixelSize(R.dimen.password_size);
            this.f10713k.setOrientation(0);
        }
    }

    /* renamed from: e */
    private void m12277e() {
        if (this.f10708f != null && this.f10706d != null) {
            int i = 0;
            int length = this.f10706d.length();
            while (i < this.f10708f.length) {
                this.f10708f[i].setImageResource(i < length ? R.mipmap.pin_dot : R.drawable.bg_pin);
                i++;
            }
        }
    }

    /* renamed from: b */
    private void m12274b(int i) {
        if (i >= 0) {
            if (this.f10706d.length() < 4) {
                this.f10706d.append(String.valueOf(i));
                m12277e();
                if (this.f10706d.length() == 4) {
                    m12278f();
                }
            }
        } else if (this.f10706d.length() > 0) {
            this.f10706d.deleteCharAt(this.f10706d.length() - 1);
            m12277e();
        }
    }

    /* renamed from: f */
    private void m12278f() {
        if (mo17989b()) {
            switch (this.f10703a) {
                case 0:
                case 3:
                    if (!TextUtils.equals(this.f10706d, m12276d())) {
                        this.f10710h++;
                        if (this.f10710h == 3) {
                            this.f10710h = 0;
                            if (EmailFragment.m12250d()) {
                                m12275c(R.string.pin_error);
                                this.f10714l.setVisibility(0);
                                return;
                            }
                            m12279g();
                            m12275c(0);
                            return;
                        }
                        m12275c(R.string.pin_error);
                        return;
                    } else if (!mo17990c()) {
                        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
                        supportFragmentManager.popBackStack();
                        if (this.f10703a == 0) {
                            AppActivity.loadFragmet(supportFragmentManager, VideoListPrivateVideoListFragment.m12406a((C2624a) null, true), true);
                            return;
                        }
                        FragmentActivity activity = getActivity();
                        activity.setResult(-1);
                        activity.finish();
                        return;
                    } else {
                        return;
                    }
                case 1:
                    if (this.f10704b == 0) {
                        if (TextUtils.equals(this.f10706d, m12276d())) {
                            this.f10704b++;
                            this.f10707e.setText(R.string.modify_pin_new);
                            this.f10706d.delete(0, this.f10706d.length());
                            m12277e();
                            return;
                        }
                        this.f10710h++;
                        if (this.f10710h == 3) {
                            this.f10710h = 0;
                            if (EmailFragment.m12250d()) {
                                AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), EmailFragment.m12242a(0, (String) null), true);
                                this.f10706d.delete(0, this.f10706d.length());
                                return;
                            }
                            m12279g();
                            m12275c(0);
                            return;
                        }
                        m12275c(R.string.pin_error);
                        return;
                    } else if (this.f10704b == 1) {
                        if (EmailFragment.m12250d()) {
                            this.f10704b++;
                            this.f10705c = this.f10706d.toString();
                            this.f10707e.setText(R.string.modify_pin_again);
                            this.f10706d.delete(0, this.f10706d.length());
                            m12277e();
                            return;
                        }
                        AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), EmailFragment.m12242a(2, this.f10706d.toString()), true);
                        this.f10706d.delete(0, this.f10706d.length());
                        m12277e();
                        return;
                    } else if (TextUtils.equals(this.f10706d, this.f10705c)) {
                        m12271a(this.f10705c);
                        if (!mo17990c()) {
                            getActivity().onBackPressed();
                        }
                        axv.m7434a((int) R.string.modify_pin_success);
                        return;
                    } else {
                        this.f10704b = 1;
                        this.f10707e.setText(R.string.modify_pin_new);
                        m12275c(R.string.modify_pin_error);
                        return;
                    }
                case 2:
                    if (this.f10704b == 0) {
                        AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), EmailFragment.m12242a(1, this.f10706d.toString()), true);
                        this.f10706d.delete(0, this.f10706d.length());
                        m12277e();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: c */
    private void m12275c(int i) {
        int a = axw.m7444a(MyApplication.getApplicationContext_(), 5.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation((float) a, (float) (-a), 0.0f, 0.0f);
        translateAnimation.setDuration(100);
        translateAnimation.setRepeatCount(3);
        translateAnimation.setRepeatMode(2);
        this.f10709g.startAnimation(translateAnimation);
        aya.m7484a(MyApplication.getApplicationContext_(), 50);
        if (i != 0) {
            axv.m7440b(i);
        }
        this.f10706d.delete(0, this.f10706d.length());
        m12277e();
    }

    /* renamed from: g */
    private void m12279g() {
        AlertDialog.Builder builder;
        if (mo17989b()) {
            LogEvents.m18492b("Password", "ErrorDialog/Show");
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
            } else {
                builder = new AlertDialog.Builder(getActivity());
            }
            builder.setMessage((int) R.string.pin_error_dialog).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null).setNegativeButton((int) R.string.contact_us, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    LogEvents.m18492b("Password", "ErrorDialog/ContactUS");
                    awz.m7244c(PasswordFragment.this.getActivity());
                }
            }).show();
        }
    }

    /* renamed from: a */
    public static boolean m12273a() {
        return !TextUtils.isEmpty(m12276d());
    }

    /* renamed from: d */
    static String m12276d() {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getString("_pin", (String) null);
    }

    /* renamed from: a */
    private static void m12271a(String str) {
        if (str != null) {
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putString("_pin", str).apply();
        }
    }
}
