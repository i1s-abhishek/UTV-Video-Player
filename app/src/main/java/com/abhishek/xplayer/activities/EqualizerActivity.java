package com.abhishek.xplayer.activities;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.Pair;

import com.abhishek.xplayer.application.BaseActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.service.C2779a;
import com.abhishek.xplayer.utils.widget.ArcSeekbar;
import com.abhishek.xplayer.utils.widget.EqualizerView;

import classesdef.inplayer.awd;
import classesdef.inplayer.awe;
import classesdef.inplayer.awg;
import classesdef.inplayer.awh;
import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.awf;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;
import tv.danmaku.ijk.media.player.IMediaPlayer;


public class EqualizerActivity extends BaseActivity implements View.OnClickListener, ArcSeekbar.C2846a, EqualizerView.C2848a {

    /* renamed from: a */
    AdapterView.OnItemClickListener f10212a = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (EqualizerActivity.this.f10228q != null && EqualizerActivity.this.f10228q.isShowing()) {
                EqualizerActivity.this.f10228q.dismiss();
            }
            EqualizerActivity.this.f10219h.setText(EqualizerActivity.this.getResources().getString(EqualizerActivity.this.f10225n[i]));
            if (!SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
                EqualizerActivity.this.m11611m();
                SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("effect_adjusted", true).apply();
            }
            awg.m7142c(i);
            awg.m7145e();
            awg.m7140b(MyApplication.getApplicationContext_());
            EqualizerActivity.this.f10234w.mo17655a(i);
        }
    };

    /* renamed from: b */
    AdapterView.OnItemClickListener f10213b = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (EqualizerActivity.this.f10229r != null && EqualizerActivity.this.f10229r.isShowing()) {
                EqualizerActivity.this.f10229r.dismiss();
            }
            EqualizerActivity.this.f10227p.setText(EqualizerActivity.this.f10230s[i]);
            if (!SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
                EqualizerActivity.this.m11611m();
                SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("effect_adjusted", true).apply();
            }
            if (!awe.m7116b()) {
                EqualizerActivity.this.m11583b(true);
            }
            int i2 = i - 1;
            awe.m7126g(i2);
            awe.m7115b(i2);
            EqualizerActivity.this.m11593e();
            EqualizerActivity.this.f10233v.mo17655a(i);
        }
    };

    /* renamed from: c */
    RadioGroup.OnCheckedChangeListener f10214c = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            EqualizerActivity.this.m11606k();
            int i2 = i - 1;
            if (i2 != -1 || !EqualizerActivity.this.f10235x) {
                boolean unused = EqualizerActivity.this.f10235x = false;
                if (!awe.m7116b()) {
                    EqualizerActivity.this.m11583b(true);
                }
                awe.m7126g(i2);
                awe.m7115b(i2);
                EqualizerActivity.this.m11593e();
                if (!SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
                    EqualizerActivity.this.m11611m();
                    SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("effect_adjusted", true).apply();
                    return;
                }
                return;
            }
            boolean unused2 = EqualizerActivity.this.f10235x = false;
            awe.m7115b(i2);
        }
    };

    /* renamed from: d */
    private RadioGroup f10215d;

    /* renamed from: e */
    private EqualizerView f10216e;

    /* renamed from: f */
    private ArcSeekbar f10217f;

    /* renamed from: g */
    private ArcSeekbar f10218g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f10219h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f10220i;

    /* renamed from: j */
    private int f10221j;

    /* renamed from: k */
    private TextView f10222k;

    /* renamed from: l */
    private TextView f10223l;

    /* renamed from: m */
    private TextView f10224m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int[] f10225n = {R.string.none, R.string.small_room, R.string.medium_room, R.string.large_room, R.string.medium_hall, R.string.large_hall, R.string.plate};

    /* renamed from: o */
    private boolean f10226o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TextView f10227p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public PopupWindow f10228q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public PopupWindow f10229r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String[] f10230s;

    /* renamed from: t */
    private int f10231t;

    /* renamed from: u */
    private int f10232u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public C2538a f10233v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C2538a f10234w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f10235x;

    /* renamed from: b */
    public void mo17644b(ArcSeekbar arcSeekbar, float f) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m11587c();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m11578a();
        m11587c();
    }

    /* renamed from: a */
    private void m11578a() {
        if (this.f10229r != null && this.f10229r.isShowing()) {
            this.f10229r.dismiss();
        }
        if (this.f10228q != null && this.f10228q.isShowing()) {
            this.f10228q.dismiss();
        }
    }

    /* renamed from: b */
    private int m11582b() {
        int n;
        IMediaPlayer c = C2779a.m12613a().mo18137c();
        if (c != null && (n = c.getAudioSessionId()) != 0) {
            return n;
        }
        if (this.f10221j == 0) {
            this.f10221j = awf.m7131a().mo10858b();
        }
        return this.f10221j;
    }

    /* renamed from: c */
    private void m11587c() {
        m11589d();
        setContentView((int) R.layout.activity_equalizer);
        this.f10226o = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("switch", true);
        this.f10231t = axw.m7444a((Context) this, 150.0f);
        this.f10232u = (int) (((((float) Math.min(axw.m7450b((Context) this), axw.m7443a((Context) this))) * 1.0f) * 3.0f) / 4.0f);
        m11608l();
        m11580a(this.f10226o);
        m11583b(this.f10226o);
        if (getResources().getConfiguration().orientation == 2) {
            m11602i();
        } else if (getResources().getConfiguration().orientation == 1) {
            m11605j();
        }
    }

    /* renamed from: d */
    private void m11589d() {
        if (Build.VERSION.SDK_INT > 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.navigation_bar_color));
        }
    }

    /* renamed from: a */
    private void m11580a(boolean z) {
        this.f10216e = (EqualizerView) findViewById(R.id.equalizer_view);
        this.f10217f = (ArcSeekbar) findViewById(R.id.as_bass);
        this.f10218g = (ArcSeekbar) findViewById(R.id.as_vir);
        this.f10219h = (TextView) findViewById(R.id.sp_preset_reverb);
        this.f10220i = findViewById(R.id.v_cover);
        this.f10222k = (TextView) findViewById(R.id.tv_freq_max);
        this.f10223l = (TextView) findViewById(R.id.tv_freq_mid);
        this.f10224m = (TextView) findViewById(R.id.tv_freq_min);
        this.f10216e.setOnEqualizerChangedListener(this);
        this.f10217f.setOnArcSeekChangedListener(this);
        this.f10218g.setOnArcSeekChangedListener(this);
        findViewById(R.id.ver_hint).setOnClickListener(this);
        this.f10220i.setVisibility(z ? View.GONE : View.VISIBLE);
        String[] strArr = new String[this.f10225n.length];
        for (int i = 0; i < this.f10225n.length; i++) {
            strArr[i] = getResources().getString(this.f10225n[i]);
        }
        Boolean[] boolArr = new Boolean[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            boolArr[i2] = new Boolean(false);
        }
        this.f10228q = new PopupWindow(this);
        ListView listView = new ListView(this);
        this.f10234w = new C2538a(Pair.create(strArr, boolArr));
        listView.setAdapter(this.f10234w);
        listView.setOnItemClickListener(this.f10212a);
        listView.setDividerHeight(0);
        this.f10228q.setContentView(listView);
        this.f10228q.setBackgroundDrawable(new ColorDrawable(-1));
        this.f10228q.setFocusable(true);
        this.f10228q.setWidth(this.f10231t);
        int a = m11576a(listView);
        if (getResources().getConfiguration().orientation == 2) {
            this.f10228q.setHeight(m11575a((View) this.f10219h, listView));
        } else {
            this.f10228q.setHeight(a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11583b(boolean z) {
        m11588c(z);
        m11597f(z);
        m11594e(z);
        m11591d(z);
    }

    /* renamed from: c */
    private void m11588c(boolean z) {
        if (z) {
            if (awe.m7120d()) {
                m11593e();
                return;
            }
            awe.m7110a(SharedPrefrence.m7395c(MyApplication.getApplicationContext_()));
            awe.m7118c(m11582b());
            if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
                awe.m7113a(true);
            }
            m11593e();
        } else if (!awe.m7120d()) {
            awe.m7110a(SharedPrefrence.m7395c(MyApplication.getApplicationContext_()));
            awe.m7118c(m11582b());
            m11593e();
            awe.m7117c();
        } else {
            awe.m7128h();
            m11593e();
            awe.m7113a(false);
            awe.m7117c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m11593e() {
        String str;
        int g = awe.m7125g();
        int f = awe.m7123f();
        int e = awe.m7121e();
        this.f10216e.mo18297l(g - f);
        this.f10216e.mo18296k(e);
        String[] strArr = new String[e];
        int[] iArr = new int[e];
        for (int i = 0; i < e; i++) {
            int d = awe.m7119d(i);
            if (d >= 1000) {
                float f2 = (((float) d) * 1.0f) / 1000.0f;
                int i2 = (int) f2;
                if (((float) i2) == f2) {
                    str = i2 + "kHz";
                } else {
                    str = f2 + "kHz";
                }
                strArr[i] = str;
            } else {
                strArr[i] = d + "Hz";
            }
            iArr[i] = awe.m7122e(i) - f;
        }
        this.f10216e.mo18277a(strArr);
        this.f10216e.mo18279a(iArr, true);
        this.f10222k.setText((g / 100) + "");
        this.f10223l.setText("0");
        this.f10224m.setText((f / 100) + "");
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = iArr[i3] + f;
        }
        awe.m7112a(awe.m7130j(), iArr);
    }

    /* renamed from: d */
    private void m11591d(boolean z) {
        if (z) {
            if (awd.m7106c()) {
                m11596f();
                return;
            }
            awd.m7099a(m11582b());
            if (awd.m7104b()) {
                awd.m7100a(MyApplication.getApplicationContext_());
                awd.m7102b(m11582b());
                if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
                    awd.m7101a(true);
                }
                m11596f();
            }
        } else if (!awd.m7106c()) {
            awd.m7100a(MyApplication.getApplicationContext_());
            awd.m7102b(m11582b());
            m11596f();
        } else {
            m11596f();
            awd.m7101a(false);
            awd.m7098a();
        }
    }

    /* renamed from: f */
    private void m11596f() {
        int e = awd.m7108e();
        this.f10217f.setMax((float) awd.m7107d());
        this.f10217f.setProgress((float) e);
    }

    /* renamed from: e */
    private void m11594e(boolean z) {
        if (z) {
            if (awh.m7154c()) {
                m11598g();
                return;
            }
            awh.m7147a(m11582b());
            if (awh.m7152b()) {
                awh.m7148a(MyApplication.getApplicationContext_());
                awh.m7150b(m11582b());
                if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
                    awh.m7149a(true);
                }
                m11598g();
            }
        } else if (!awh.m7154c()) {
            awh.m7148a(MyApplication.getApplicationContext_());
            awh.m7150b(m11582b());
            m11598g();
        } else {
            m11598g();
            awh.m7149a(false);
            awh.m7146a();
        }
    }

    /* renamed from: g */
    private void m11598g() {
        int d = awh.m7155d();
        int e = awh.m7156e();
        this.f10218g.setMax((float) d);
        this.f10218g.setProgress((float) e);
    }

    /* renamed from: f */
    private void m11597f(boolean z) {
        if (z) {
            if (awg.m7143c()) {
                m11601h();
                return;
            }
            awg.m7136a(m11582b());
            if (awg.m7141b()) {
                awg.m7137a(MyApplication.getApplicationContext_());
                awg.m7139b(m11582b());
                if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
                    awg.m7138a(true);
                }
                m11601h();
            }
        } else if (!awg.m7143c()) {
            awg.m7137a(MyApplication.getApplicationContext_());
            awg.m7139b(m11582b());
            m11601h();
        } else {
            m11601h();
            awg.m7138a(false);
            awg.m7135a();
        }
    }

    /* renamed from: h */
    private void m11601h() {
        int d = awg.m7144d();
        this.f10219h.setText(getResources().getString(this.f10225n[d]));
        this.f10234w.mo17655a(d);
    }

    /* renamed from: i */
    private void m11602i() {
        this.f10227p = (TextView) findViewById(R.id.equalizer_effect);
        findViewById(R.id.equalizer_group).setOnClickListener(this);
        int j = awe.m7130j();
        int i = awe.m7129i();
        this.f10230s = new String[(i + 1)];
        this.f10230s[0] = "Custom";
        int i2 = 0;
        while (i2 < i) {
            String h = awe.m7127h(i2);
            i2++;
            this.f10230s[i2] = h;
        }
        m11581a(this.f10230s);
        Boolean[] boolArr = new Boolean[this.f10230s.length];
        for (int i3 = 0; i3 < this.f10230s.length; i3++) {
            boolArr[i3] = new Boolean(false);
        }
        if (j >= -1 && j < i) {
            int i4 = j + 1;
            this.f10227p.setText(this.f10230s[i4]);
            boolArr[i4] = new Boolean(true);
        }
        ListView listView = new ListView(this);
        listView.setOnItemClickListener(this.f10213b);
        this.f10233v = new C2538a(Pair.create(this.f10230s, boolArr));
        listView.setAdapter(this.f10233v);
        listView.setDividerHeight(0);
        int a = m11576a(listView);
        this.f10229r = new PopupWindow(this);
        this.f10229r.setWidth(this.f10231t);
        if (getResources().getConfiguration().orientation == 2) {
            this.f10229r.setHeight(m11575a((View) this.f10227p, listView));
        } else {
            this.f10229r.setHeight(a);
        }
        this.f10229r.setBackgroundDrawable(new ColorDrawable(-1));
        this.f10229r.setFocusable(true);
        this.f10229r.setContentView(listView);
    }

    /* renamed from: a */
    private int m11575a(View view, ListView listView) {
        if (view == null) {
            return m11576a(listView);
        }
        return Math.min((int) (((float) (Math.min(axw.m7450b((Context) this), axw.m7443a((Context) this)) - view.getBottom())) / 1.5f), m11576a(listView));
    }

    /* renamed from: a */
    private int m11576a(ListView listView) {
        if (listView == null || listView.getAdapter() == null) {
            return 0;
        }
        ListAdapter adapter = listView.getAdapter();
        int count = adapter.getCount();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            View view = adapter.getView(i2, (View) null, listView);
            view.measure(0, 0);
            i += view.getMeasuredHeight();
        }
        return i;
    }

    /* renamed from: j */
    private void m11605j() {
        this.f10215d = (RadioGroup) findViewById(R.id.rg_equalizer_title);
        int j = awe.m7130j();
        int i = awe.m7129i();
        String[] strArr = new String[(i + 1)];
        strArr[0] = "Custom";
        int i2 = 0;
        while (i2 < i) {
            String h = awe.m7127h(i2);
            i2++;
            strArr[i2] = h;
        }
        m11581a(strArr);
        LayoutInflater from = LayoutInflater.from(this);
        for (int i3 = 0; i3 < strArr.length; i3++) {
            RadioButton radioButton = (RadioButton) from.inflate(R.layout.item_eq_title, this.f10215d, false);
            radioButton.setText(strArr[i3]);
            radioButton.setId(i3);
            this.f10215d.addView(radioButton);
        }
        if (j >= -1 && j < i) {
            this.f10215d.check(j + 1);
        }
        this.f10215d.setOnCheckedChangeListener(this.f10214c);
        this.f10215d.post(new Runnable() {
            public void run() {
                EqualizerActivity.this.m11606k();
            }
        });
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11581aa(String[] r7) {
        /*
            r6 = this;
            int r0 = r7.length
            java.lang.String[] r0 = new java.lang.String[r0]
            r1 = 0
            r2 = 0
        L_0x0005:
            int r3 = r7.length
            if (r2 >= r3) goto L_0x012c
            r3 = r7[r2]
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case -1955878649: goto L_0x007c;
                case -1931577810: goto L_0x0072;
                case -1708690440: goto L_0x0068;
                case 80433: goto L_0x005d;
                case 2192281: goto L_0x0053;
                case 2195496: goto L_0x0049;
                case 2301655: goto L_0x003e;
                case 2552709: goto L_0x0033;
                case 65798035: goto L_0x0029;
                case 1994885149: goto L_0x001f;
                case 2029746065: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0086
        L_0x0014:
            java.lang.String r5 = "Custom"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 0
            goto L_0x0087
        L_0x001f:
            java.lang.String r5 = "Classical"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 2
            goto L_0x0087
        L_0x0029:
            java.lang.String r5 = "Dance"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 3
            goto L_0x0087
        L_0x0033:
            java.lang.String r5 = "Rock"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 10
            goto L_0x0087
        L_0x003e:
            java.lang.String r5 = "Jazz"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 8
            goto L_0x0087
        L_0x0049:
            java.lang.String r5 = "Folk"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 5
            goto L_0x0087
        L_0x0053:
            java.lang.String r5 = "Flat"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 4
            goto L_0x0087
        L_0x005d:
            java.lang.String r5 = "Pop"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 9
            goto L_0x0087
        L_0x0068:
            java.lang.String r5 = "Hip Hop"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 7
            goto L_0x0087
        L_0x0072:
            java.lang.String r5 = "Heavy Metal"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 6
            goto L_0x0087
        L_0x007c:
            java.lang.String r5 = "Normal"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0086
            r3 = 1
            goto L_0x0087
        L_0x0086:
            r3 = -1
        L_0x0087:
            switch(r3) {
                case 0: goto L_0x011b;
                case 1: goto L_0x010d;
                case 2: goto L_0x00ff;
                case 3: goto L_0x00f1;
                case 4: goto L_0x00e3;
                case 5: goto L_0x00d5;
                case 6: goto L_0x00c7;
                case 7: goto L_0x00b9;
                case 8: goto L_0x00aa;
                case 9: goto L_0x009b;
                case 10: goto L_0x008c;
                default: goto L_0x008a;
            }
        L_0x008a:
            goto L_0x0128
        L_0x008c:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624254(0x7f0e013e, float:1.8875683E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x009b:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624253(0x7f0e013d, float:1.887568E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x00aa:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624251(0x7f0e013b, float:1.8875676E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x00b9:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624250(0x7f0e013a, float:1.8875674E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x00c7:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624249(0x7f0e0139, float:1.8875672E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x00d5:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624248(0x7f0e0138, float:1.887567E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x00e3:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624247(0x7f0e0137, float:1.8875668E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x00f1:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624246(0x7f0e0136, float:1.8875666E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x00ff:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624245(0x7f0e0135, float:1.8875664E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x010d:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624252(0x7f0e013c, float:1.8875678E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
            goto L_0x0128
        L_0x011b:
            android.content.res.Resources r3 = r6.getResources()
            r4 = 2131624053(0x7f0e0075, float:1.8875275E38)
            java.lang.String r3 = r3.getString(r4)
            r0[r2] = r3
        L_0x0128:
            int r2 = r2 + 1
            goto L_0x0005
        L_0x012c:
            int r2 = r0.length
            java.lang.System.arraycopy(r0, r1, r7, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.activities.EqualizerActivity.m11581a(java.lang.String[]):void");
    }
    private void m11581aaa(String[] strArr) {
        char c2;
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            switch (str.hashCode()) {
                case -1955878649:
                    if (str.equals("Normal")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1931577810:
                    if (str.equals("Heavy Metal")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1708690440:
                    if (str.equals("Hip Hop")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 80433:
                    if (str.equals("Pop")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2192281:
                    if (str.equals("Flat")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2195496:
                    if (str.equals("Folk")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2301655:
                    if (str.equals("Jazz")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2552709:
                    if (str.equals("Rock")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 65798035:
                    if (str.equals("Dance")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1994885149:
                    if (str.equals("Classical")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2029746065:
                    if (str.equals("Custom")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    strArr2[i2] = getResources().getString(R.string.custom);
                    break;
                case 1:
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_normal);
                    break;
                case 2:
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_classical);
                    break;
                case 3:
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_dance);
                    break;
                case 4:
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_flat);
                    break;
                case 5:
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_folk);
                    break;
                case 6:
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_heavy_metal);
                    break;
                case 7:
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_hip_hop);
                    break;
                case '\b':
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_jazz);
                    break;
                case '\t':
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_pop);
                    break;
                case '\n':
                    strArr2[i2] = getResources().getString(R.string.music_equlizer_modle_rock);
                    break;
            }
        }
        System.arraycopy(strArr2, 0, strArr, 0, strArr2.length);
    }
    private void m11581a(final String[] array) {
        final String[] array2 = new String[array.length];
        for (int i = 0; i < array.length; ++i) {
            final String s = array[i];
            int n = 0;
            Label_0322: {
                switch (s.hashCode()) {
                    case 2029746065:
                        if (s.equals("Custom")) {
                            n = 0;
                            break Label_0322;
                        }
                        break;
                    case 1994885149:
                        if (s.equals("Classical")) {
                            n = 2;
                            break Label_0322;
                        }
                        break;
                    case 65798035:
                        if (s.equals("Dance")) {
                            n = 3;
                            break Label_0322;
                        }
                        break;
                    case 2552709:
                        if (s.equals("Rock")) {
                            n = 10;
                            break Label_0322;
                        }
                        break;
                    case 2301655:
                        if (s.equals("Jazz")) {
                            n = 8;
                            break Label_0322;
                        }
                        break;
                    case 2195496:
                        if (s.equals("Folk")) {
                            n = 5;
                            break Label_0322;
                        }
                        break;
                    case 2192281:
                        if (s.equals("Flat")) {
                            n = 4;
                            break Label_0322;
                        }
                        break;
                    case 80433:
                        if (s.equals("Pop")) {
                            n = 9;
                            break Label_0322;
                        }
                        break;
                    case -1708690440:
                        if (s.equals("Hip Hop")) {
                            n = 7;
                            break Label_0322;
                        }
                        break;
                    case -1931577810:
                        if (s.equals("Heavy Metal")) {
                            n = 6;
                            break Label_0322;
                        }
                        break;
                    case -1955878649:
                        if (s.equals("Normal")) {
                            n = 1;
                            break Label_0322;
                        }
                        break;
                }
                n = -1;
            }
            switch (n) {
                case 10:
                    array2[i] = this.getResources().getString(R.string.music_equlizer_modle_rock);
                    break;
                case 9:
                    array2[i] = this.getResources().getString(R.string.music_equlizer_modle_pop);
                    break;
                case 8:
                    array2[i] = this.getResources().getString(R.string.music_equlizer_modle_jazz);
                    break;
                case 7:
                    array2[i] = this.getResources().getString(R.string.music_equlizer_modle_hip_hop);
                    break;
                case 6:
                    array2[i] = this.getResources().getString(R.string.music_equlizer_modle_heavy_metal);
                    break;
                case 5:
                    array2[i] = this.getResources().getString(R.string.music_equlizer_modle_folk);
                    break;
                case 4:
                    array2[i] = this.getResources().getString(R.string.music_equlizer_modle_flat);
                    break;
                case 3:
                    array2[i] = this.getResources().getString(R.string.music_equlizer_modle_dance);
                    break;
                case 2:
                    array2[i] = this.getResources().getString(R.string.music_equlizer_modle_classical);
                    break;
                case 1:
                    array2[i] = getResources().getString(R.string.music_equlizer_modle_normal);
                    break;
                case 0:
                    array2[i] = getResources().getString(R.string.custom);
                    break;
            }
        }
        System.arraycopy(array2, 0, array, 0, array2.length);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m11606k() {
        int childCount = this.f10215d.getChildCount();
        int checkedRadioButtonId = this.f10215d.getCheckedRadioButtonId();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f10215d.getChildAt(i);
            if (childAt.getId() == checkedRadioButtonId) {
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) this.f10215d.getParent();
                int a = axw.m7443a((Context) this);
                float x = childAt.getX();
                int width = childAt.getWidth();
                if (width <= 0) {
                    width = axw.m7444a((Context) this, 80.0f);
                }
                horizontalScrollView.smoothScrollTo((int) (x - ((float) ((a - width) / 2))), 0);
                return;
            }
        }
    }

    /* renamed from: l */
    private void m11608l() {
        setTitle(getResources().getString(R.string.equalizer));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.titleStyle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EqualizerActivity.this.finish();
            }
        });
        toolbar.setBackgroundColor(getResources().getColor(R.color.equalizer_pager_bg));
        SwitchCompat switchCompat = new SwitchCompat(this);
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2);
        layoutParams.gravity = 21;
        layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
        switchCompat.setLayoutParams(layoutParams);
        switchCompat.setChecked(SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("switch", true));
        toolbar.addView(switchCompat);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EqualizerActivity.this.m11583b(z);
                SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("switch", z).apply();
                EqualizerActivity.this.f10220i.setVisibility(z ? View.GONE : View.VISIBLE);
                StringBuilder sb = new StringBuilder();
                sb.append("EqualizerSwitch");
                sb.append(z ? "/on" : "/off");
                LogEvents.m18492b("Equalizer", sb.toString());
            }
        });
    }

    /* renamed from: a */
    public void mo17643a(EqualizerView equalizerView, int[] iArr, int i) {
        if (!SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
            m11611m();
            SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("effect_adjusted", true).apply();
        }
        awe.m7111a(i, iArr[i] + awe.m7123f());
        awe.m7124f(i);
    }

    /* renamed from: b */
    public void mo17645b(EqualizerView equalizerView, int[] iArr, int i) {
        int i2 = getResources().getConfiguration().orientation;
        awe.m7112a(awe.m7130j(), awe.m7114a());
        awe.m7115b(-1);
        if (i2 == 2) {
            this.f10227p.setText(R.string.custom);
        } else if (i2 == 1) {
            this.f10235x = true;
            this.f10215d.check(0);
        }
    }

    /* renamed from: c */
    public void mo17647c(EqualizerView equalizerView, int[] iArr, int i) {
        mo17643a(equalizerView, iArr, i);
    }

    /* renamed from: a */
    public void mo17642a(ArcSeekbar arcSeekbar, float f) {
        if (arcSeekbar == this.f10217f) {
            awd.m7103b(MyApplication.getApplicationContext_());
        } else if (arcSeekbar == this.f10218g) {
            awh.m7151b(MyApplication.getApplicationContext_());
        }
    }

    /* renamed from: c */
    public void mo17646c(ArcSeekbar arcSeekbar, float f) {
        if (!SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
            m11611m();
            SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("effect_adjusted", true).apply();
        }
        if (arcSeekbar == this.f10217f) {
            awd.m7105c((int) f);
            awd.m7109f();
        } else if (arcSeekbar == this.f10218g) {
            awh.m7153c((int) f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m11611m() {
        if (!awe.m7120d()) {
            awe.m7113a(true);
        }
        if (!awd.m7106c()) {
            awd.m7101a(true);
        }
        if (!awh.m7154c()) {
            awh.m7149a(true);
        }
        if (!awg.m7143c()) {
            awg.m7138a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (isFinishing() && awf.m7131a().mo10860d()) {
            m11612n();
            awf.m7131a().mo10859c();
        }
        m11578a();
    }

    /* renamed from: n */
    private void m11612n() {
        if (awe.m7120d()) {
            awe.m7113a(false);
        }
        awe.m7117c();
        if (awd.m7106c()) {
            awd.m7101a(false);
        }
        awd.m7098a();
        if (awh.m7154c()) {
            awh.m7149a(false);
        }
        awh.m7146a();
        if (awg.m7143c()) {
            awg.m7138a(false);
        }
        awg.m7135a();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.ver_hint) {
            this.f10228q.showAsDropDown(this.f10219h, 0, 0);
            this.f10234w.notifyDataSetChanged();
        } else if (view.getId() == R.id.equalizer_group) {
            this.f10229r.showAsDropDown(this.f10227p, 0, 0);
            this.f10233v.notifyDataSetChanged();
        }
    }

    /* renamed from: com.inshot.xplayer.activities.EqualizerActivity$a */
    private class C2538a extends BaseAdapter {

        /* renamed from: b */
        private Pair<String[], Boolean[]> f10243b;

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public C2538a(Pair<String[], Boolean[]> pair) {
            this.f10243b = pair;
        }

        public int getCount() {
            if (this.f10243b == null) {
                return 0;
            }
            return ((String[]) this.f10243b.first).length;
        }

        /* renamed from: a */
        public void mo17655a(int i) {
            if (i < 0) {
                i = 0;
            }
            if (i > ((Boolean[]) this.f10243b.second).length - 1) {
                i = ((Boolean[]) this.f10243b.second).length - 1;
            }
            for (int i2 = 0; i2 < ((Boolean[]) this.f10243b.second).length; i2++) {
                ((Boolean[]) this.f10243b.second)[i2] = false;
            }
            for (int i3 = 0; i3 < ((Boolean[]) this.f10243b.second).length; i3++) {
                if (i3 == i) {
                    ((Boolean[]) this.f10243b.second)[i] = true;
                    return;
                }
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C2539b bVar;
            if (view == null) {
                bVar = new C2539b();
                view2 = View.inflate(EqualizerActivity.this, R.layout.text_item, (ViewGroup) null);
                TextView unused = bVar.f10245b = (TextView) view2.findViewById(R.id.text1);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (C2539b) view.getTag();
            }
            bVar.f10245b.setText(((String[]) this.f10243b.first)[i]);
            bVar.f10245b.setBackgroundColor(((Boolean[]) this.f10243b.second)[i].booleanValue() ? Color.parseColor("#e6ebe5") : -1);
            return view2;
        }
    }

    /* renamed from: com.inshot.xplayer.activities.EqualizerActivity$b */
    private class C2539b {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public TextView f10245b;

        private C2539b() {
        }
    }
}
