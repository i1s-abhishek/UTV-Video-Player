package com.abhishek.xplayer.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;

import androidx.core.app.NotificationCompat;

import com.abhishek.inplayer.bean.VideoPlayListBean;
import com.abhishek.inplayer.widget.C2475a;
import com.abhishek.inplayer.widget.C2482f;
import com.abhishek.inplayer.widget.XVideoView;
import com.abhishek.xplayer.activities.PlayerActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.mopub.common.Constants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import classesdef.inplayer.avp;
import classesdef.inplayer.axi;
import classesdef.xdplayer.awl;
import classesdef.xdplayer.axe;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

/* renamed from: com.inshot.xplayer.service.a */
public class C2779a {

    /* renamed from: a */
    private static C2779a f11051a;

    /* renamed from: b */
    private String f11052b;

    /* renamed from: c */
    private String f11053c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f11054d = -1;

    /* renamed from: e */
    private boolean f11055e;

    /* renamed from: f */
    private int f11056f = 10;

    /* renamed from: g */
    private boolean f11057g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f11058h;

    /* renamed from: i */
    private boolean f11059i;

    /* renamed from: j */
    private String f11060j;

    /* renamed from: k */
    private ArrayList<VideoPlayListBean> f11061k;

    /* renamed from: l */
    private IMediaPlayer f11062l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f11063m;

    /* renamed from: n */
    private IMediaPlayer.OnInfoListener f11064n = new IMediaPlayer.OnInfoListener() {
        /* renamed from: a */
        public boolean onInfo(IMediaPlayer avg, int i, int i2) {
            if (i != 3) {
                switch (i) {
                    case 303:
                        break;
                    case 304:
                        C2779a.this.m12625b(1);
                        return false;
                    default:
                        return false;
                }
            }
            C2779a.this.m12625b(2);
            return false;
        }
    };

    /* renamed from: o */
    private IMediaPlayer.OnCompletionListener f11065o = new IMediaPlayer.OnCompletionListener() {
        /* renamed from: a */
        public void onCompletion(IMediaPlayer avg) {
            if (C2779a.this.mo18135b() && C2779a.this.mo18137c() == avg) {
                if (C2779a.this.f11058h) {
                    MyApplication.myApplication().mo17870a(false);
                    C2779a.this.mo18136b((Context) MyApplication.myApplication(), true);
                    boolean unused = C2779a.this.f11058h = false;
                } else if (C2779a.this.f11063m == 2) {
                    if (!C2779a.this.m12621a(C2779a.this.f11054d)) {
                        C2779a.this.mo18136b((Context) MyApplication.myApplication(), true);
                    }
                } else if (!C2779a.this.mo18148n()) {
                    C2779a.this.mo18136b((Context) MyApplication.myApplication(), true);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f11066p = -2;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f11067q;

    /* renamed from: r */
    private Handler f11068r = new Handler(MyApplication.getApplicationContext_().getMainLooper()) {
        public void handleMessage(Message message) {
            C2779a.this.m12625b(message.what);
        }
    };

    /* renamed from: s */
    private int f11069s = 0;

    /* renamed from: t */
    private long f11070t = 0;

    /* renamed from: u */
    private boolean f11071u;

    /* renamed from: v */
    private List<C2786a> f11072v = new LinkedList();

    /* renamed from: w */
    private int f11073w = 0;

    /* renamed from: com.inshot.xplayer.service.a$a */
    public interface C2786a {
        /* renamed from: a */
        void mo17671a();

        /* renamed from: a */
        void mo17672a(long j);

        /* renamed from: b */
        void mo17673b();

        /* renamed from: c */
        void mo17674c();

        /* renamed from: d */
        boolean mo17675d();
    }

    /* renamed from: a */
    public static C2779a m12613a() {
        if (f11051a == null) {
            synchronized (C2779a.class) {
                if (f11051a == null) {
                    f11051a = new C2779a();
                }
            }
        }
        return f11051a;
    }

    private C2779a() {
    }

    /* renamed from: a */
    public void mo18130a(Context context, int i, String str, String str2, int i2, ArrayList<VideoPlayListBean> arrayList, String str3, boolean z, boolean z2, boolean z3, int i3, boolean z4, boolean z5) {
        ArrayList<VideoPlayListBean> arrayList2 = arrayList;
        if (z4) {
            this.f11063m = 1;
        } else {
            this.f11063m = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("sKrMspmkr", 0);
        }
        m12620a(str2, str, z, z2, z3, i3, z5);
        if (arrayList2 != null) {
            m12615a(i2, arrayList2, str3);
        }
        m12616a(Uri.parse(str2), i);
        PlayerService.m12595a(context);
        m12625b(2);
    }

    /* renamed from: a */
    public void mo18131a(Context context, ArrayList<VideoPlayListBean> arrayList, String str, boolean z) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                this.f11063m = 1;
            } else {
                this.f11063m = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("sKrMspmkr", 0);
            }
            int a = this.f11063m == 1 ?  axi.m7350a(arrayList) : 0;
            m12631r();
            m12615a(a, arrayList, str);
            this.f11058h = false;
            this.f11055e = false;
            this.f11056f = 10;
            this.f11057g = false;
            m12618a(arrayList.get(a));
            PlayerService.m12595a(context);
            m12625b(2);
        }
    }

    /* renamed from: b */
    public boolean mo18135b() {
        return mo18137c() != null;
    }

    /* renamed from: c */
    public IMediaPlayer mo18137c() {
        return this.f11062l;
    }

    /* renamed from: d */
    public String mo18138d() {
        return this.f11052b;
    }

    /* renamed from: e */
    public String mo18139e() {
        return this.f11053c;
    }

    /* renamed from: f */
    public boolean mo18140f() {
        return this.f11059i;
    }

    /* renamed from: g */
    public boolean mo18141g() {
        return this.f11055e;
    }

    /* renamed from: h */
    public int mo18142h() {
        return this.f11063m;
    }

    /* renamed from: i */
    public int mo18143i() {
        if (this.f11056f == 0) {
            this.f11056f = 10;
        }
        return this.f11056f;
    }

    /* renamed from: j */
    public VideoPlayListBean mo18144j() {
        if (this.f11061k == null || this.f11054d < 0 || this.f11054d >= this.f11061k.size()) {
            return null;
        }
        return this.f11061k.get(this.f11054d);
    }

    /* renamed from: k */
    public void mo18145k() {
        IMediaPlayer c = mo18137c();
        if (c != null && !c.isPlaying()) {
            c.start();
            m12625b(2);
        }
    }

    /* renamed from: l */
    public boolean mo18146l() {
        IMediaPlayer c = mo18137c();
        if (c == null || !c.isPlaying()) {
            return false;
        }
        c.pause();
        m12625b(1);
        return true;
    }

    /* renamed from: a */
    public Intent mo18128a(Context context, boolean z) {
        Intent putExtra = new Intent(context, PlayerActivity.class).putExtra("backgroundMode", true).putExtra("name", this.f11052b).putExtra("path", mo18139e()).putExtra("private", this.f11057g);
        if (z) {
            putExtra.putExtra("fromNotification", true);
            putExtra.addFlags(67108864);
        }
        return putExtra;
    }

    /* renamed from: m */
    public boolean mo18147m() {
        IMediaPlayer c = mo18137c();
        if (c == null) {
            return false;
        }
        if (c.isPlaying()) {
            c.pause();
            m12625b(1);
            return true;
        }
        c.start();
        m12625b(2);
        return false;
    }

    /* renamed from: b */
    public boolean mo18136b(Context context, boolean z) {
        boolean z2 = this.f11062l != null;
        if (z) {
            m12631r();
        } else if (z2) {
            this.f11062l.setOnCompletionListener(this.f11065o);
        }
        m12626b(context);
        m12625b(3);
        m12620a((String) null, (String) null, false, false, false, 10, false);
        m12615a(0, (ArrayList<VideoPlayListBean>) null, (String) null);
        return z2;
    }

    /* renamed from: a */
    public void mo18129a(Context context) {
        if (this.f11062l != null) {
            context.stopService(new Intent(context, PlayerService.class));
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + 1000, PendingIntent.getService(context, 789, new Intent(context, PlayerService.class), 268435456));
            }
        }
    }

    /* renamed from: n */
    public boolean mo18148n() {
        if (this.f11061k == null || !mo18135b()) {
            return false;
        }
        int i = this.f11054d;
        do {
            i = this.f11063m == 1 ? axi.m7351a(this.f11061k, i, 1) : i + 1;
            if (i >= this.f11061k.size()) {
                if (this.f11063m != 3 && this.f11063m != 2) {
                    return false;
                }
                i = 0;
            }
            if (m12621a(i)) {
                return true;
            }
        } while (i != this.f11054d);
        mo18136b(MyApplication.getApplicationContext_(), true);
        return false;
    }

    /* renamed from: o */
    public boolean mo18149o() {
        if (this.f11061k == null || !mo18135b()) {
            return false;
        }
        int i = this.f11054d;
        do {
            i = this.f11063m == 1 ? axi.m7351a(this.f11061k, i, -1) : i - 1;
            if (i < 0) {
                if (this.f11063m != 3 && this.f11063m != 2) {
                    return false;
                }
                i = this.f11061k.size() - 1;
            }
            if (m12621a(i)) {
                return true;
            }
        } while (i != this.f11054d);
        mo18136b(MyApplication.getApplicationContext_(), true);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m12621a(int i) {
        VideoPlayListBean videoPlayListBean;
        if (this.f11061k == null || i < 0 || i >= this.f11061k.size() || (videoPlayListBean = this.f11061k.get(i)) == null || videoPlayListBean.f9813a == null || !axe.m7319a(videoPlayListBean.f9813a, false)) {
            return false;
        }
        m12631r();
        this.f11054d = i;
        m12618a(videoPlayListBean);
        m12625b(2);
        return true;
    }

    /* renamed from: p */
    public ArrayList<VideoPlayListBean> mo18150p() {
        return this.f11061k;
    }

    /* renamed from: q */
    public String mo18151q() {
        return this.f11060j;
    }

    /* renamed from: r */
    private void m12631r() {
        axi.m7354a();
        IMediaPlayer c = mo18137c();
        if (c != null) {
            if (c.isPlaying()) {
                c.stop();
            }
            axi.m7357a(c, this.f11053c, false);
            m12617a((IMediaPlayer) null);
        }
    }

    /* renamed from: a */
    private void m12620a(String str, String str2, boolean z, boolean z2, boolean z3, int i, boolean z4) {
        this.f11052b = str2;
        this.f11053c = str;
        this.f11058h = z;
        this.f11059i = z2;
        this.f11055e = z3;
        this.f11056f = i;
        this.f11057g = z4;
    }

    /* renamed from: a */
    private void m12615a(int i, ArrayList<VideoPlayListBean> arrayList, String str) {
        this.f11061k = arrayList;
        this.f11060j = str;
        this.f11054d = i;
    }

    /* renamed from: a */
    private void m12617a(IMediaPlayer avg) {
        this.f11062l = avg;
        if (this.f11062l != null) {
            this.f11062l.setOnInfoListener(this.f11064n);
            this.f11062l.setOnCompletionListener(this.f11065o/*, false*/);
        }
    }

    /* renamed from: b */
    private void m12626b(Context context) {
        m12617a( null);
        context.stopService(new Intent(context, PlayerService.class));
    }

    /* renamed from: a */
    private void m12618a(VideoPlayListBean videoPlayListBean) {
        m12620a(videoPlayListBean.f9813a, videoPlayListBean.f9815c, this.f11058h, this.f11059i, this.f11055e, this.f11056f, this.f11057g);
        LogEvents.m18495c(videoPlayListBean.f9813a);
        m12616a(Uri.parse(videoPlayListBean.f9813a), 0);
    }

    /* renamed from: a */
    private void m12616a(Uri uri, final int i) {
        try {
            IMediaPlayer a = XVideoView.m11196a(0, (C2482f) null, uri, true, new avp() {
                /* renamed from: a */
                public void mo10817a(int i) {
                    axi.m7355a(i);
                }
            });
            a.setOnErrorListener((IMediaPlayer.OnErrorListener) new IMediaPlayer.OnErrorListener() {
                /* renamed from: a */
                public boolean onError(IMediaPlayer avg, int i, int i2) {
                    C2779a.this.mo18148n();
                    return true;
                }
            });
            a.setOnPreparedListener((IMediaPlayer.OnPreparedListener) new IMediaPlayer.OnPreparedListener() {
                /* renamed from: b */
                public void onPrepared(IMediaPlayer avg) {
                    avg.start();
                    C2779a.this.m12625b(2);
                    if (C2779a.this.f11067q != null && C2779a.this.f11067q.equals(C2779a.this.mo18139e())) {
                        String unused = C2779a.this.f11067q = null;
                        int unused2 = C2779a.this.f11066p = -2;
                    }
                    if (i > 0) {
                        avg.seekTo((long) i);
                    }
                }
            });
            if (uri.toString().startsWith("content://")) {
                a.setDataSource((IMediaDataSource) new C2475a(MyApplication.myApplication().getContentResolver(), uri));
            } else {
                a.setDataSource(MyApplication.myApplication(), uri, (Map<String, String>) null);
            }
            a.setAudioStreamType(3);
            a.setScreenOnWhilePlaying(true);
            if (this.f11056f != 10) {
                ((IjkMediaPlayer) a).setSpeed(((float) this.f11056f) / 10.0f);
            }
            a.prepareAsync();
            m12617a(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12625b(int i) {
        if (this.f11062l != null || i == 3) {
            ArrayList<C2786a> arrayList = new ArrayList<>(this.f11072v);
            switch (i) {
                case 1:
                    this.f11071u = false;
                    for (C2786a a : arrayList) {
                        a.mo17671a();
                    }
                    m12633t();
                    m12632s();
                    return;
                case 2:
                    this.f11071u = true;
                    for (C2786a b : arrayList) {
                        b.mo17673b();
                    }
                    m12633t();
                    m12632s();
                    return;
                case 3:
                    this.f11071u = false;
                    this.f11068r.removeMessages(4);
                    for (C2786a c : arrayList) {
                        c.mo17674c();
                    }
                    return;
                case 4:
                    for (C2786a a2 : arrayList) {
                        a2.mo17672a(-1);
                    }
                    m12633t();
                    m12632s();
                    if (this.f11062l != null && this.f11062l.isPlaying()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.f11070t > 1200) {
                            this.f11069s++;
                            if (this.f11069s > 5) {
                                mo18129a(MyApplication.getApplicationContext_());
                                this.f11069s = 0;
                            }
                        } else {
                            this.f11069s = 0;
                        }
                        this.f11070t = currentTimeMillis;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: s */
    private void m12632s() {
        this.f11072v.isEmpty();
    }

    /* renamed from: t */
    private void m12633t() {
        int i = this.f11071u ? 1000 : Constants.TEN_SECONDS_MILLIS;
        if (this.f11062l != null && this.f11062l.isPlaying()) {
            long j = this.f11062l.getCurrentPosition();
            if (j > 0) {
                i = (int) (1000 - (j % 1000));
            }
        }
        this.f11068r.removeMessages(4);
        if (this.f11073w > 0) {
            this.f11068r.sendEmptyMessageDelayed(4, (long) i);
        }
    }

    /* renamed from: a */
    public void mo18133a(C2786a aVar) {
        if (aVar != null && !this.f11072v.contains(aVar)) {
            this.f11072v.add(aVar);
            if (aVar.mo17675d()) {
                this.f11073w++;
                if (this.f11073w == 1) {
                    m12633t();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo18134b(C2786a aVar) {
        if (this.f11072v.remove(aVar) && aVar.mo17675d()) {
            this.f11073w--;
            if (this.f11073w == 0) {
                this.f11068r.removeMessages(4);
            }
        }
    }

    /* renamed from: a */
    public void mo18132a(awl awl) {
        String str;
        if (this.f11061k != null && awl != null && awl.f6087a != null && awl.f6088b != null) {
            if (!awl.f6089c) {
                Iterator<VideoPlayListBean> it = this.f11061k.iterator();
                while (it.hasNext()) {
                    VideoPlayListBean next = it.next();
                    if (next != null && next.f9813a != null && next.f9813a.equalsIgnoreCase(awl.f6087a)) {
                        next.f9813a = awl.f6088b;
                        next.f9815c = axy.m7460a(next.f9813a);
                        if (awl.f6087a.equalsIgnoreCase(this.f11053c)) {
                            this.f11053c = next.f9813a;
                            this.f11052b = next.f9815c;
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (awl.f6087a.endsWith("/")) {
                str = awl.f6087a;
            } else {
                str = awl.f6087a + "/";
            }
            boolean z = false;
            Iterator<VideoPlayListBean> it2 = this.f11061k.iterator();
            while (it2.hasNext()) {
                VideoPlayListBean next2 = it2.next();
                if (!(next2 == null || next2.f9813a == null || !next2.f9813a.startsWith(str))) {
                    z = true;
                    if (next2.f9813a.equalsIgnoreCase(this.f11053c)) {
                        next2.f9813a = awl.f6088b + next2.f9813a.substring(awl.f6087a.length());
                        this.f11053c = next2.f9813a;
                    } else {
                        next2.f9813a = awl.f6088b + next2.f9813a.substring(awl.f6087a.length());
                    }
                }
            }
            if (z) {
                this.f11060j = axy.m7460a(awl.f6088b);
            }
        }
    }
}
