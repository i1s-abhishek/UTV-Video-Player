package com.abhishek.xplayer.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.core.app.NotificationCompat;

import com.abhishek.xplayer.application.MyApplication;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import classesdef.eventbus.awn;
import classesdef.player.axg;
import classesdef.xdplayer.awl;
import hdplayer.vlcplayer.videoplayer.R;


public class PipPlayerService extends Service implements AudioManager.OnAudioFocusChangeListener, axg.C1345a {

    /* renamed from: a */
    private PipPlayControl f11027a;

    /* renamed from: b */
    private PowerManager.WakeLock f11028b;

    /* renamed from: c */
    private String f11029c;

    /* renamed from: d */
    private boolean f11030d;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRename(awl awl) {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public void onCreate() {
        Notification notification;
        super.onCreate();
        this.f11027a = new PipPlayControl(this, LayoutInflater.from(this).inflate(R.layout.layout_pip_player, (ViewGroup) null));
        StartPipPlayService.m12716a().mo18171a(this.f11027a);
        EventBus.getDefault().register((Object) this);
        axg.m7327a((axg.C1345a) this).mo10964a((Context) this);
        int i = Build.VERSION.SDK_INT;
        int i2 = R.mipmap.ic_notification;
        if (i >= 26) {
            notification = new Notification.Builder(this, m12586a()).setSmallIcon(R.mipmap.ic_notification).setAutoCancel(false).setOngoing(true).setContentTitle(getString(R.string.pip_play_notification)).build();
        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            if (Build.VERSION.SDK_INT < 21) {
                i2 = R.mipmap.ic_launcher;
            }
            notification = builder.setSmallIcon(i2).setAutoCancel(false).setOngoing(true).setContentTitle(getString(R.string.pip_play_notification)).build();
        }
        startForeground(313, notification);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(this, 3, 2);
        }
        PowerManager powerManager = (PowerManager) MyApplication.getApplicationContext_().getSystemService("power");
        if (powerManager != null) {
            this.f11028b = powerManager.newWakeLock(1, "XPlayerPipService");
            this.f11028b.acquire();
        }
        m12587b();
    }

    /* renamed from: a */
    private String m12586a() {
        if (this.f11029c != null) {
            return this.f11029c;
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager == null) {
            return "";
        }
        this.f11029c = "pip";
        NotificationChannel notificationChannel = new NotificationChannel("pip", "PIP", 2);
        notificationChannel.setDescription("Pip Player.");
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        notificationManager.createNotificationChannel(notificationChannel);
        return this.f11029c;
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        axg.m7328a((Context) this, (axg.C1345a) this);
        axg.m7336b((axg.C1345a) this);
        if (this.f11027a != null) {
            this.f11027a.mo18154a();
            this.f11027a = null;
        }
        if (this.f11028b != null && this.f11028b.isHeld()) {
            this.f11028b.release();
        }
        StartPipPlayService.m12716a().mo18171a((PipPlayControl) null);
    }

    /* renamed from: b */
    private void m12587b() {
        C2787b b = StartPipPlayService.m12716a().mo18172b();
        if (b != null) {
            this.f11027a.mo18155a(b);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTick(awn awn) {
        if (awn.f6092b) {
            stopSelf();
        }
    }

    /* renamed from: l */
    public void mo10966l() {
        this.f11027a.mo18158d();
    }

    /* renamed from: m */
    public void mo10967m() {
        this.f11027a.mo18159e();
    }

    /* renamed from: n */
    public void mo10968n() {
        this.f11027a.mo18157c();
    }

    /* renamed from: o */
    public void mo10969o() {
        this.f11027a.mo18159e();
    }

    /* renamed from: p */
    public void mo10970p() {
        this.f11027a.mo18161g();
    }

    /* renamed from: q */
    public void mo10971q() {
        this.f11027a.mo18160f();
    }

    public void onAudioFocusChange(int i) {
        if (this.f11027a != null) {
            if (i <= 0) {
                this.f11030d = this.f11027a.mo18158d();
            } else if (this.f11030d) {
                this.f11027a.mo18157c();
                this.f11030d = false;
            }
        }
    }
}
