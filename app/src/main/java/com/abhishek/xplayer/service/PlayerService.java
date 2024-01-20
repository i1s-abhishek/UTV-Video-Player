package com.abhishek.xplayer.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.receiver.SelfReceiver;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import classesdef.eventbus.awn;
import classesdef.inplayer.awt;
import classesdef.player.axg;
import classesdef.xdplayer.awl;
import classesdef.xdplayer.awy;
import classesdef.xdplayer.axd;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.LogEvents;

import hdplayer.vlcplayer.videoplayer.R;
import tv.danmaku.ijk.media.player.IMediaPlayer;


public class PlayerService extends Service implements AudioManager.OnAudioFocusChangeListener, axd.C1342a, axg.C1345a {

    /* renamed from: a */
    private long f11031a;

    /* renamed from: b */
    private boolean f11032b;

    /* renamed from: c */
    private boolean f11033c;

    /* renamed from: d */
    private PowerManager.WakeLock f11034d;

    /* renamed from: e */
    private boolean f11035e;

    /* renamed from: f */
    private C2779a.C2786a f11036f = new C2779a.C2786a() {
        /* renamed from: a */
        public void mo17672a(long j) {
        }

        /* renamed from: d */
        public boolean mo17675d() {
            return false;
        }

        /* renamed from: a */
        public void mo17671a() {
            PlayerService.this.m12597a(false);
        }

        /* renamed from: b */
        public void mo17673b() {
            PlayerService.this.m12597a(false);
        }

        /* renamed from: c */
        public void mo17674c() {
            PlayerService.this.stopSelf();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f11037g = false;

    /* renamed from: h */
    private Runnable f11038h = new Runnable() {
        public void run() {
            if (PlayerService.this.f11037g) {
                boolean unused = PlayerService.this.f11037g = false;
                PlayerService.this.m12597a(false);
            }
        }
    };

    /* renamed from: i */
    private long f11039i = 0;

    /* renamed from: j */
    private PendingIntent f11040j;

    /* renamed from: k */
    private PendingIntent f11041k;

    /* renamed from: l */
    private String f11042l;

    /* renamed from: m */
    private RemoteViews f11043m;

    /* renamed from: n */
    private RemoteViews f11044n;

    /* renamed from: o */
    private Notification f11045o;

    /* renamed from: p */
    private String f11046p;

    /* renamed from: q */
    private String f11047q;

    /* renamed from: r */
    private boolean f11048r;

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: a */
    public static void m12595a(Context context) {
        awt.m7197a(context, new Intent(context, PlayerService.class));
        ///ayc.m7501a("StartService:Player");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        //ayc.m7501a("PlayerService:OnStart");
        this.f11033c = true;
        if (this.f11035e) {
            m12597a(false);
            this.f11035e = false;
            return 2;
        }
        m12597a(true);
        return 2;
    }

    public void onCreate() {
     //   ayc.m7501a("PlayerService:OnCreate");
        super.onCreate();
        this.f11035e = true;
        m12597a(true);
        C2779a.m12613a().mo18133a(this.f11036f);
        EventBus.getDefault().register((Object) this);
        axg.m7327a((axg.C1345a) this).mo10964a((Context) this);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(this, 3, 2);
        }
        this.f11032b = axw.m7453d(this);
        if (this.f11032b) {
            this.f11031a = System.currentTimeMillis();
        }
        this.f11034d = ((PowerManager) MyApplication.getApplicationContext_().getSystemService("power")).newWakeLock(1, "XPlayerService");
        this.f11034d.acquire();
    }

    public void onDestroy() {
        this.f11033c = true;
        this.f11048r = false;
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this);
        }
        this.f11043m = null;
        this.f11045o = null;
        this.f11031a = 0;
        EventBus.getDefault().unregister(this);
        C2779a.m12613a().mo18134b(this.f11036f);
        axg.m7328a((Context) this, (axg.C1345a) this);
        axg.m7336b((axg.C1345a) this);
        m12599b(this);
        if (this.f11034d.isHeld()) {
            this.f11034d.release();
        }
    }

    /* renamed from: b */
    public static void m12599b(Context context) {
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(428);
        } catch (Exception e) {
            e.printStackTrace();
            LogEvents.m18488a("Notification/Cancel", e.getLocalizedMessage(), true);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTick(awn awn) {
        if (awn.f6092b) {
            C2779a.m12613a().mo18146l();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRename(awl awl) {
        C2779a.m12613a().mo18132a(awl);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12597a(boolean z) {
        long j;
        String str;
        String str2;
        boolean z2 = z && Build.VERSION.SDK_INT >= 26;
        if (!z2 && !this.f11033c) {
            return;
        }
        if (z2 || this.f11032b) {
            long currentTimeMillis = System.currentTimeMillis();
            if (z2 || currentTimeMillis - this.f11039i >= 900) {
                if (this.f11037g) {
                    this.f11037g = false;
                    MyApplication.myApplication().mo17871b(this.f11038h);
                }
                this.f11039i = currentTimeMillis;
                IMediaPlayer c = C2779a.m12613a().mo18137c();
                if (z2 || c != null) {
                    String e = C2779a.m12613a().mo18139e();
                    boolean z3 = (this.f11045o == null || this.f11043m == null || this.f11044n == null || !TextUtils.equals(e, this.f11047q)) ? false : true;
                    PendingIntent activity = PendingIntent.getActivity(this, (int) (Math.random() * 9999.0d), C2779a.m12613a().mo18128a((Context) this, true), 167772160);
                    if (this.f11041k == null) {
                        this.f11041k = PendingIntent.getBroadcast(this, (int) (Math.random() * 9999.0d), new Intent(this, SelfReceiver.class).setAction("xvlqefsfvv"), 167772160);
                    }
                    if (this.f11040j == null) {
                        this.f11040j = PendingIntent.getBroadcast(this, (int) (Math.random() * 9999.0d), new Intent(this, SelfReceiver.class).setAction("oeuortoqwei"), 167772160);
                    }
                    if (c == null) {
                        j = 0;
                    } else {
                        j = c.getDuration();
                    }
                    boolean z4 = c != null && c.isPlaying();
                    if (this.f11043m == null || this.f11044n == null) {
                        this.f11043m = new RemoteViews(getPackageName(), R.layout.layout_player_notification);
                        this.f11044n = new RemoteViews(getPackageName(), R.layout.layout_player_notification_big);
                        PendingIntent broadcast = PendingIntent.getBroadcast(this, (int) (Math.random() * 9999.0d), new Intent(this, SelfReceiver.class).setAction("flkdlwasdf"), 167772160);
                        str = e;
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(this, (int) (Math.random() * 9999.0d), new Intent(this, SelfReceiver.class).setAction("zxcwe2dfwe"), 167772160);
                        PendingIntent broadcast3 = PendingIntent.getBroadcast(this, (int) (Math.random() * 9999.0d), new Intent(this, SelfReceiver.class).setAction("flkdlwasdf").putExtra("ipcldjwsd", true), 167772160);
                        this.f11043m.setOnClickPendingIntent(R.id.close, broadcast2);
                        this.f11043m.setOnClickPendingIntent(R.id.next, broadcast);
                        this.f11044n.setOnClickPendingIntent(R.id.close, broadcast2);
                        this.f11044n.setOnClickPendingIntent(R.id.next, broadcast);
                        this.f11044n.setOnClickPendingIntent(R.id.previous, broadcast3);
                    } else {
                        str = e;
                    }
                    if (!z3) {
                        String d = C2779a.m12613a().mo18138d();
                        this.f11043m.setTextViewText(R.id.name, d);
                        this.f11043m.setOnClickPendingIntent(R.id.layout, activity);
                        this.f11044n.setTextViewText(R.id.name, d);
                        this.f11044n.setOnClickPendingIntent(R.id.layout, activity);
                        str2 = str;
                        this.f11047q = str2;
                    } else {
                        str2 = str;
                    }
                    RemoteViews remoteViews = this.f11043m;
                    int i = R.mipmap.ic_notify_play;
                    remoteViews.setImageViewResource(R.id.play, z4 ? R.mipmap.ic_notify_pause : R.mipmap.ic_notify_play);
                    this.f11043m.setOnClickPendingIntent(R.id.play, z4 ? this.f11040j : this.f11041k);
                    RemoteViews remoteViews2 = this.f11044n;
                    if (z4) {
                        i = R.mipmap.ic_notify_pause;
                    }
                    remoteViews2.setImageViewResource(R.id.play, i);
                    this.f11044n.setOnClickPendingIntent(R.id.play, z4 ? this.f11040j : this.f11041k);
                    if (this.f11045o == null) {
                        int i2 = Build.VERSION.SDK_INT;
                        int i3 = R.mipmap.ic_notification;
                        if (i2 >= 26) {
                            this.f11045o = new Notification.Builder(this, m12594a()).setSmallIcon(R.mipmap.ic_notification).setAutoCancel(false).setOngoing(true).setCustomContentView(this.f11043m).setCustomBigContentView(this.f11044n).build();
                        } else {
                            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                            if (Build.VERSION.SDK_INT < 21) {
                                i3 = R.mipmap.ic_launcher;
                            }
                            this.f11045o = builder.setSmallIcon(i3).setAutoCancel(false).setOngoing(true).setContent(this.f11043m).setCustomBigContentView(this.f11044n).build();
                        }
                    }
                    if (j <= 0 || str2 == null || !str2.startsWith("/")) {
                        this.f11043m.setImageViewResource(R.id.icon, R.mipmap.video_default_thumb);
                        this.f11044n.setImageViewResource(R.id.icon, R.mipmap.video_default_thumb);
                        this.f11046p = null;
                    } else if (!TextUtils.equals(str2, this.f11046p)) {
                        this.f11046p = str2;
                        int a = axw.m7444a((Context) this, 64.0f);
                        int i4 = a > 192 ? 128 : a;
                      //  axd axd = r1;
                        axd axd = new axd(this, str2, R.id.icon, i4, i4, this.f11045o, 428, this, this.f11043m, this.f11044n);
                        Glide.with(this).load(str2).asBitmap().override(i4, i4).decoder((ResourceDecoder<ImageVideoWrapper, Bitmap>) new awy(str2, this, j)).into(axd);
                    }
                    try {
                        startForeground(428, this.f11045o);
                    } catch (RuntimeException e2) {
                        RuntimeException runtimeException = e2;
                        runtimeException.printStackTrace();
                        C2779a.m12613a().mo18129a((Context) this);
                        LogEvents.m18488a("Notification/notify", runtimeException.getLocalizedMessage(), true);
                    }
                }
            } else if (!this.f11037g) {
                this.f11037g = true;
                MyApplication.myApplication().runnableDelay(this.f11038h, (this.f11039i + 1000) - currentTimeMillis);
            }
        }
    }

    /* renamed from: a */
    private String m12594a() {
        if (this.f11042l != null) {
            return this.f11042l;
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager == null) {
            return "";
        }
        this.f11042l = "player";
        NotificationChannel notificationChannel = new NotificationChannel("player", "Player", 2);
        notificationChannel.setDescription("Notify play progress.");
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        notificationManager.createNotificationChannel(notificationChannel);
        return this.f11042l;
    }

    /* renamed from: a */
    public boolean mo10963a(String str) {
        return this.f11045o != null && TextUtils.equals(str, this.f11047q);
    }

    /* renamed from: l */
    public void mo10966l() {
        C2779a.m12613a().mo18146l();
    }

    /* renamed from: m */
    public void mo10967m() {
        C2779a.m12613a().mo18147m();
    }

    /* renamed from: n */
    public void mo10968n() {
        C2779a.m12613a().mo18145k();
    }

    /* renamed from: o */
    public void mo10969o() {
        C2779a.m12613a().mo18146l();
    }

    /* renamed from: p */
    public void mo10970p() {
        C2779a.m12613a().mo18148n();
    }

    /* renamed from: q */
    public void mo10971q() {
        C2779a.m12613a().mo18149o();
    }

    public void onAudioFocusChange(int i) {
        if (i <= 0) {
            this.f11048r = C2779a.m12613a().mo18146l();
        } else if (this.f11048r) {
            C2779a.m12613a().mo18145k();
            this.f11048r = false;
        }
    }
}
