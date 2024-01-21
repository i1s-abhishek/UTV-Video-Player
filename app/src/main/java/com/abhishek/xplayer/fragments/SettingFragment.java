package com.abhishek.xplayer.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.activities.SettingWebViewActivity;
import com.abhishek.xplayer.application.AppActivity;
import com.abhishek.xplayer.application.BaseActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.service.NotifyService;
import com.abhishek.xplayer.utils.widget.RippleView;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import classesdef.ads.C4786mv;
import classesdef.eventbus.awj;
import classesdef.inplayer.awt;
import classesdef.inplayer.awz;
import classesdef.inplayer.SharedPrefrence;
import classesdef.player.aww;
import classesdef.xdplayer.ServerConfigSharedPrefrence;
import classesdef.xdplayer.avt;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.LogEvents;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.fragments.i */
public class SettingFragment extends FragmentLifecycle implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    public static boolean f10817a;

    /* renamed from: b */
    Runnable f10818b = new Runnable() {
        public void run() {
            if (SettingFragment.this.f10836t && SettingFragment.this.mo17989b()) {
                SettingFragment.this.m12378a();
            }
        }
    };

    /* renamed from: c */
    FrameLayout f10819c = null;

    /* renamed from: d */
    private Switch f10820d;

    /* renamed from: e */
    private avt f10821e;

    /* renamed from: f */
    private boolean f10822f;

    /* renamed from: g */
    private ScrollView f10823g;

    /* renamed from: h */
    private TextView f10824h;

    /* renamed from: i */
    private View f10825i;

    /* renamed from: j */
    private View f10826j;

    /* renamed from: k */
    private ActionBar f10827k;

    /* renamed from: l */
    private Switch f10828l;

    /* renamed from: m */
    private Switch f10829m;

    /* renamed from: n */
    private Switch f10830n;

    /* renamed from: o */
    private Switch f10831o;

    /* renamed from: p */
    private Switch f10832p;

    /* renamed from: q */
    private Switch f10833q;

    /* renamed from: r */
    private Switch f10834r;

    /* renamed from: s */
    private int f10835s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f10836t = true;

    /* renamed from: u */
    private boolean f10837u = true;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f10838v;

    /* renamed from: w */
    private ArrayList<Animator> f10839w = new ArrayList<>();

    public void onStart() {
        super.onStart();
        LogEvents.m18498d("Setting");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_setting, viewGroup, false);
        inflate.findViewById(R.id.manage_scan_list).setOnClickListener(this);
        inflate.findViewById(R.id.language).setOnClickListener(this);
        inflate.findViewById(R.id.feedback).setOnClickListener(this);
        inflate.findViewById(R.id.policy).setOnClickListener(this);
        inflate.findViewById(R.id.legal).setOnClickListener(this);
        if (Build.VERSION.SDK_INT < 26) {
            inflate.findViewById(R.id.notify_new).setOnClickListener(this);
        } else {
            inflate.findViewById(R.id.notify_new).setVisibility(View.GONE);
            inflate.findViewById(R.id.notify_new_line).setVisibility(View.GONE);
        }
        inflate.findViewById(R.id.remember_bright).setOnClickListener(this);
        inflate.findViewById(R.id.play_next).setOnClickListener(this);
        inflate.findViewById(R.id.play_resume).setOnClickListener(this);
        inflate.findViewById(R.id.remember_subtitle).setOnClickListener(this);
        inflate.findViewById(R.id.remember_ratio).setOnClickListener(this);
        inflate.findViewById(R.id.show_hidden_file).setOnClickListener(this);
        this.f10825i = inflate.findViewById(R.id.dark_theme);
        this.f10825i.setOnClickListener(this);
        this.f10828l = (Switch) inflate.findViewById(R.id.notify_new_switch);
        this.f10829m = (Switch) inflate.findViewById(R.id.remember_bright_switch);
        this.f10830n = (Switch) inflate.findViewById(R.id.play_next_switch);
        this.f10831o = (Switch) inflate.findViewById(R.id.play_resume_switch);
        this.f10820d = (Switch) inflate.findViewById(R.id.dark_theme_switch);
        this.f10832p = (Switch) inflate.findViewById(R.id.remember_subtitle_switch);
        this.f10833q = (Switch) inflate.findViewById(R.id.remember_ratio_switch);
        this.f10834r = (Switch) inflate.findViewById(R.id.show_hidden_file_switch);
        this.f10823g = (ScrollView) inflate.findViewById(R.id.scrollContent);
        this.f10835s = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getInt("DefaultDecoder", 0);
        boolean z = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("notifyNew", true);
        boolean z2 = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("rememberBright", true);
        boolean z3 = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("playNext", true);
        boolean z4 = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("playResume", true);
        boolean z5 = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("yw1w9Q6K", false);
        boolean z6 = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("w9Q6yw1K", false);
        boolean z7 = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("lH9wboin", false);
        this.f10822f = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false) || VideoFolderFragment.f10956a;
        TextView textView = (TextView) inflate.findViewById(R.id.notify_new_tv_desc);
        int i = R.string.off;
        textView.setText(z ? R.string.on : R.string.off);
        this.f10824h = (TextView) inflate.findViewById(R.id.dark_theme_tv_desc);
        TextView textView2 = this.f10824h;
        if (this.f10822f || VideoFolderFragment.f10956a) {
            i = R.string.on;
        }
        textView2.setText(i);
        int b = SharedPrefrence.language(MyApplication.getApplicationContext_());
        ((TextView) inflate.findViewById(R.id.language_tv_desc)).setText(b < 0 ? getString(R.string.auto) : aww.f6155a[b]);
        this.f10828l.setChecked(z);
        this.f10829m.setChecked(z2);
        this.f10830n.setChecked(z3);
        this.f10831o.setChecked(z4);
        this.f10820d.setChecked(this.f10822f);
        this.f10832p.setChecked(z5);
        this.f10833q.setChecked(z6);
        this.f10834r.setChecked(z7);
        this.f10828l.setOnCheckedChangeListener(this);
        this.f10829m.setOnCheckedChangeListener(this);
        this.f10830n.setOnCheckedChangeListener(this);
        this.f10831o.setOnCheckedChangeListener(this);
        this.f10820d.setOnCheckedChangeListener(this);
        this.f10832p.setOnCheckedChangeListener(this);
        this.f10833q.setOnCheckedChangeListener(this);
        this.f10834r.setOnCheckedChangeListener(this);
        this.f10827k = ((AppCompatActivity) getActivity()).getSupportActionBar();
        this.f10827k.setDisplayHomeAsUpEnabled(true);
        this.f10827k.setDisplayShowHomeEnabled(true);
        this.f10827k.setHomeAsUpIndicator((int) R.drawable.ic_back);
        this.f10827k.setSubtitle((CharSequence) null);
        this.f10827k.setTitle((int) R.string.settings);
        setHasOptionsMenu(true);
      //  this.f10821e = new avx();
        ((TextView) inflate.findViewById(R.id.version)).setText(getString(R.string.version, awt.m7207c(MyApplication.getApplicationContext_())));
        this.f10826j = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getBoolean("hint_visible") && this.f10837u) {
            this.f10837u = false;
            this.f10823g.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return SettingFragment.this.f10836t;
                }
            });
            view.postDelayed(this.f10818b, 500);
        }
    }

    public void onResume() {
        FileExplorerActivity.fragmentName = "Setting";
        super.onResume();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12378a() {
        this.f10838v++;
        final RippleView rippleView = new RippleView(getActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f10825i.getWidth(), this.f10825i.getHeight());
        layoutParams.topMargin = ((ViewGroup) this.f10820d.getParent()).getTop() + ((AppCompatActivity) getActivity()).getSupportActionBar().getHeight() + axw.m7445a(getResources());
        ((FrameLayout) getActivity().getWindow().getDecorView()).addView(rippleView, layoutParams);
        new ObjectAnimator();
        ObjectAnimator duration = ObjectAnimator.ofFloat(rippleView, "radius", new float[]{0.0f, (float) (this.f10825i.getWidth() / 4)}).setDuration(400);
        this.f10839w.add(duration);
        duration.setInterpolator(new LinearInterpolator());
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                rippleView.postInvalidate();
            }
        });
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SettingFragment.this.m12380a(rippleView, 64, 0);
                rippleView.setRadius(0.0f);
                rippleView.postInvalidate();
                rippleView.postDelayed(SettingFragment.this.f10818b, 1000);
                if (SettingFragment.this.f10838v >= 3 && SettingFragment.this.f10818b != null) {
                    rippleView.removeCallbacks(SettingFragment.this.f10818b);
                    boolean unused = SettingFragment.this.f10836t = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                SettingFragment.this.m12380a(rippleView, 0, 64);
            }
        });
        duration.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12380a(final RippleView rippleView, int i, int i2) {
        new ObjectAnimator();
        ObjectAnimator duration = ObjectAnimator.ofInt(rippleView, "bgAlpha", new int[]{i, i2}).setDuration(200);
        this.f10839w.add(duration);
        duration.setInterpolator(new LinearInterpolator());
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                rippleView.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue("bgAlpha")).intValue(), 180, 180, 180));
            }
        });
        duration.start();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f10826j = null;
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
            switch (view.getId()) {
                case R.id.dark_theme /*2131296443*/:
                    this.f10838v = 3;
                    this.f10820d.toggle();
                    return;
                case R.id.feedback /*2131296505*/:
                    LogEvents.m18492b("Setting", "Feedback");
                    awz.m7244c(getActivity());
                    return;
                case R.id.language /*2131296591*/:
                    LogEvents.m18492b("Setting", "Language");
                    m12385d();
                    return;
                case R.id.legal /*2131296603*/:
                    LogEvents.m18492b("Setting", "Legal");
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), SettingWebViewActivity.class);
                    intent.putExtra("content", "Legal");
                    startActivity(intent);
                    return;
                case R.id.manage_scan_list /*2131296622*/:
                    LogEvents.m18492b("Setting", "ScanList");
                    AppActivity.loadFragmet(getActivity().getSupportFragmentManager(), new HideListFragment(), true);
                    return;
                case R.id.notify_new /*2131296659*/:
                    this.f10828l.toggle();
                    return;
                case R.id.play_next /*2131296694*/:
                    this.f10830n.toggle();
                    return;
                case R.id.play_resume /*2131296699*/:
                    this.f10831o.toggle();
                    return;
                case R.id.policy /*2131296705*/:
                    LogEvents.m18492b("Setting", "Policy");
                    if (ServerConfigSharedPrefrence.m23693m(getContext()) == 1) {
                        C4786mv.m23719a(getContext(),getString(R.string.policy),-624595, -28594, "androdeveloper24@gmail.com", "https://inshotapp.com/website/HDPlayer/privacypolicy_eu.html");
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.setClass(getActivity(), SettingWebViewActivity.class);
                    intent2.putExtra("content", "Policy");
                    startActivity(intent2);
                    return;
                case R.id.remember_bright /*2131296736*/:
                    this.f10829m.toggle();
                    return;
                case R.id.remember_ratio /*2131296740*/:
                    this.f10833q.toggle();
                    return;
                case R.id.remember_subtitle /*2131296743*/:
                    this.f10832p.toggle();
                    return;
                case R.id.show_hidden_file /*2131296818*/:
                    this.f10834r.toggle();
                    return;
                default:
                    return;
            }
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (mo17989b()) {
            switch (compoundButton.getId()) {
                case R.id.dark_theme_switch /*2131296444*/:
                    StringBuilder sb = new StringBuilder();
                    sb.append("darkThemeSwitch/");
                    sb.append(z ? "On" : "Off");
                    LogEvents.m18492b("Setting", sb.toString());
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("darkTheme", z).apply();
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("hint_visible", false).apply();
                    FragmentActivity activity = getActivity();
                    activity.finish();
                    Intent intent = new Intent(activity, getActivity().getClass());
                    f10817a = true;
                    startActivity(intent);
                    return;
                case R.id.notify_new_switch /*2131296661*/:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("notifyNew");
                    sb2.append(z ? "On" : "Off");
                    LogEvents.m18492b("Setting", sb2.toString());
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("notifyNew", z).apply();
                    if (this.f10826j != null) {
                        ((TextView) this.f10826j.findViewById(R.id.notify_new_tv_desc)).setText(SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("notifyNew", true) ? R.string.on : R.string.off);
                    }
                    if (z) {
                        getActivity().startService(new Intent(getActivity(), NotifyService.class));
                        return;
                    } else {
                        getActivity().stopService(new Intent(getActivity(), NotifyService.class));
                        return;
                    }
                case R.id.play_next_switch /*2131296695*/:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("playNext");
                    sb3.append(z ? "On" : "Off");
                    LogEvents.m18492b("Setting", sb3.toString());
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("playNext", z).apply();
                    return;
                case R.id.play_resume_switch /*2131296700*/:
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("playResume");
                    sb4.append(z ? "On" : "Off");
                    LogEvents.m18492b("Setting", sb4.toString());
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("playResume", z).apply();
                    return;
                case R.id.remember_bright_switch /*2131296737*/:
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("rememberBright");
                    sb5.append(z ? "On" : "Off");
                    LogEvents.m18492b("Setting", sb5.toString());
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("rememberBright", z).apply();
                    return;
                case R.id.remember_ratio_switch /*2131296741*/:
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("rememberRatio/");
                    sb6.append(z ? "On" : "Off");
                    LogEvents.m18492b("Setting", sb6.toString());
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("w9Q6yw1K", z).apply();
                    return;
                case R.id.remember_subtitle_switch /*2131296744*/:
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("rememberSubtitle/");
                    sb7.append(z ? "On" : "Off");
                    LogEvents.m18492b("Setting", sb7.toString());
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("yw1w9Q6K", z).apply();
                    return;
                case R.id.show_hidden_file_switch /*2131296819*/:
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("showHidden/");
                    sb8.append(z ? "On" : "Off");
                    LogEvents.m18492b("Setting", sb8.toString());
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("lH9wboin", z).apply();
                    EventBus.getDefault().post(new awj());
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: d */
    private void m12385d() {
        AlertDialog.Builder builder;
        final int b = SharedPrefrence.language(getContext()) + 1;
        if (this.f10822f) {
            builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertStyle);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        ArrayList arrayList = new ArrayList(aww.f6155a.length + 1);
        arrayList.add(String.format(Locale.ENGLISH, "%s (%s)", new Object[]{getString(R.string.auto), Resources.getSystem().getConfiguration().locale.getDisplayLanguage(Resources.getSystem().getConfiguration().locale)}));
        arrayList.addAll(Arrays.asList(aww.f6155a));
        builder.setTitle((int) R.string.change_language_title).setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[arrayList.size()]), b, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (b != i && (SettingFragment.this.getActivity() instanceof BaseActivity)) {
                    FragmentActivity activity = SettingFragment.this.getActivity();
                    SharedPrefrence.setLangusgeType((Context) activity, i - 1);
                    MyApplication.myApplication().mo17867a(MyApplication.getApplicationContext_());
                    activity.finish();
                    Intent intent = new Intent(activity, SettingFragment.this.getActivity().getClass());
                    SettingFragment.f10817a = true;
                    SettingFragment.this.startActivity(intent);
                }
            }
        }).show();
    }
}
