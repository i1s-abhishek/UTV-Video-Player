package classesdef.player;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.receiver.XMediaButtonReceiver;

/* renamed from: axg */
public class axg {

    /* renamed from: a */
    private static axg f6265a;

    /* renamed from: b */
    private BroadcastReceiver f6266b = new C1346b();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f6267c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1345a f6268d;

    /* renamed from: e */
    private MediaSessionCompat f6269e;

    /* renamed from: f */
    private C1346b f6270f;

    /* renamed from: g */
    private boolean f6271g;

    /* renamed from: h */
    private final Runnable f6272h = new Runnable() {
        public void run() {
            if (axg.this.f6267c && axg.this.f6268d != null) {
                axg.this.f6268d.mo10967m();
            }
        }
    };

    /* renamed from: i */
    private long f6273i = 0;

    /* renamed from: axg$a */
    public interface C1345a {
        /* renamed from: l */
        void mo10966l();

        /* renamed from: m */
        void mo10967m();

        /* renamed from: n */
        void mo10968n();

        /* renamed from: o */
        void mo10969o();

        /* renamed from: p */
        void mo10970p();

        /* renamed from: q */
        void mo10971q();
    }

    /* renamed from: a */
    public static axg m7327a(C1345a aVar) {
        if (f6265a == null) {
            f6265a = new axg(aVar);
        } else {
            f6265a.f6268d = aVar;
        }
        return f6265a;
    }

    /* renamed from: a */
    public static boolean m7329a() {
        return f6265a != null && f6265a.f6271g;
    }

    /* renamed from: a */
    public static void m7328a(Context context, C1345a aVar) {
        if (f6265a != null && f6265a.f6268d == aVar) {
            f6265a.m7335b(context);
        }
    }

    /* renamed from: b */
    public static void m7336b(C1345a aVar) {
        if (f6265a != null && f6265a.f6268d == aVar) {
            f6265a.m7334b();
            f6265a = null;
        }
    }

    private axg(C1345a aVar) {
        this.f6268d = aVar;
    }

    /* renamed from: a */
    public void mo10964a(Context context) {
        if (!this.f6267c) {
            Context applicationContext = context.getApplicationContext();
            this.f6267c = true;
            if (this.f6269e == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f6269e = new MediaSessionCompat(applicationContext, "XPlayer");
                } else {
                    if (this.f6270f == null) {
                        this.f6270f = new C1346b();
                    }
                    LocalBroadcastManager.getInstance(applicationContext).registerReceiver(this.f6270f, new IntentFilter("lqeuoilkljvvoaso"));
                    this.f6269e = new MediaSessionCompat(applicationContext, "XPlayer", new ComponentName(applicationContext.getPackageName(), XMediaButtonReceiver.class.getName()), (PendingIntent) null);
                }
                this.f6269e.setCallback(new MediaSessionCompat.Callback() {
                    public void onPause() {
                        if (axg.this.f6267c && axg.this.f6268d != null) {
                            axg.this.f6268d.mo10969o();
                        }
                    }

                    public boolean onMediaButtonEvent(Intent intent) {
                        return axg.this.m7330a(intent);
                    }

                    public void onPlay() {
                        if (axg.this.f6267c && axg.this.f6268d != null) {
                            axg.this.f6268d.mo10968n();
                        }
                    }

                    public void onSkipToNext() {
                        if (axg.this.f6267c && axg.this.f6268d != null) {
                            axg.this.f6268d.mo10970p();
                        }
                    }

                    public void onSkipToPrevious() {
                        if (axg.this.f6267c && axg.this.f6268d != null) {
                            axg.this.f6268d.mo10971q();
                        }
                    }
                });
                this.f6269e.setFlags(3);
            }
            this.f6269e.setActive(true);
            IntentFilter intentFilter = new IntentFilter("android.media.AUDIO_BECOMING_NOISY");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.setPriority(Integer.MAX_VALUE);
            applicationContext.registerReceiver(this.f6266b, intentFilter);
        }
    }

    /* renamed from: b */
    private void m7335b(Context context) {
        if (this.f6267c) {
            Context applicationContext = context.getApplicationContext();
            applicationContext.unregisterReceiver(this.f6266b);
            if (this.f6269e != null && this.f6269e.isActive()) {
                this.f6269e.setActive(false);
            }
            if (this.f6270f != null) {
                LocalBroadcastManager.getInstance(applicationContext).unregisterReceiver(this.f6270f);
            }
            this.f6267c = false;
        }
    }

    /* renamed from: b */
    private void m7334b() {
        if (this.f6269e != null) {
            this.f6269e.release();
        }
        this.f6269e = null;
        this.f6270f = null;
    }

    /* renamed from: axg$b */
    private class C1346b extends BroadcastReceiver {
        private C1346b() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean unused = axg.this.m7330a(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7330a(Intent intent) {
        String action;
        if (this.f6267c && (action = intent.getAction()) != null) {
            if (!"android.intent.action.MEDIA_BUTTON".equals(action) && !"lqeuoilkljvvoaso".equals(action)) {
                if (!"android.media.AUDIO_BECOMING_NOISY".equals(action)) {
                    if ("android.intent.action.HEADSET_PLUG".equals(action)) {
                        switch (intent.getIntExtra("state", -1)) {
                            case 0:
                                this.f6271g = false;
                                break;
                            case 1:
                                this.f6271g = true;
                                break;
                        }
                    }
                } else {
                    if (this.f6268d != null) {
                        this.f6268d.mo10966l();
                    }
                    return true;
                }
            } else {
                KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    switch (keyEvent.getKeyCode()) {
                        case 87:
                            if (this.f6268d != null) {
                                this.f6268d.mo10970p();
                                break;
                            }
                            break;
                        case 88:
                            if (this.f6268d != null) {
                                this.f6268d.mo10971q();
                                break;
                            }
                            break;
                        default:
                            MyApplication.myApplication().mo17871b(this.f6272h);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - this.f6273i <= 400) {
                                this.f6273i = 0;
                                if (this.f6268d != null) {
                                    this.f6268d.mo10970p();
                                    break;
                                }
                            } else {
                                this.f6273i = currentTimeMillis;
                                MyApplication.myApplication().runnableDelay(this.f6272h, 500);
                                break;
                            }
                            break;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
