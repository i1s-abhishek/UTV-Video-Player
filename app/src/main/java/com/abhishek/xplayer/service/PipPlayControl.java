package com.abhishek.xplayer.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.GestureDetectorCompat;

import com.abhishek.inplayer.bean.VideoPlayListBean;
import com.abhishek.inplayer.widget.XVideoView;
import com.abhishek.xplayer.activities.PlayerActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.RecentMediaStorage;
import com.abhishek.xplayer.subtitle.C2822c;

import java.util.List;
import java.util.Map;

import classesdef.inplayer.avp;
import classesdef.inplayer.axc;
import classesdef.inplayer.axi;
import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axw;
import hdplayer.vlcplayer.videoplayer.R;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;

//use pop player
/* renamed from: com.inshot.xplayer.service.c */
public class PipPlayControl implements ScaleGestureDetector.OnScaleGestureListener, View.OnClickListener, View.OnTouchListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnPreparedListener {

    /* renamed from: v */
    private static final int[] f11095v = {R.mipmap.ic_pip_s, R.mipmap.ic_pip_m, R.mipmap.ic_pip_l};
    /* access modifiers changed from: private */

    /* renamed from: A */
    public String f11096A;

    /* renamed from: B */
    private int f11097B = -2;

    /* renamed from: C */
    private String f11098C;

    /* renamed from: D */
    private int f11099D = -2;

    /* renamed from: E */
    private String f11100E;

    /* renamed from: F */
    private RecentMediaStorage f11101F;

    /* renamed from: G */
    private double f11102G = 1.0d;

    /* renamed from: a */
    private PipPlayerService f11103a;

    /* renamed from: b */
    private WindowManager f11104b;

    /* renamed from: c */
    private GestureDetectorCompat f11105c;

    /* renamed from: d */
    private ScaleGestureDetector f11106d;

    /* renamed from: e */
    private WindowManager.LayoutParams f11107e;

    /* renamed from: f */
    private View f11108f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f11109g;

    /* renamed from: h */
    private ImageView f11110h;

    /* renamed from: i */
    private ImageView f11111i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public XVideoView f11112j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TextView f11113k;

    /* renamed from: l */
    private C2787b f11114l;

    /* renamed from: m */
    private boolean f11115m;

    /* renamed from: n */
    private int f11116n;

    /* renamed from: o */
    private int f11117o;

    /* renamed from: p */
    private int f11118p;

    /* renamed from: q */
    private int f11119q;

    /* renamed from: r */
    private float f11120r;

    /* renamed from: s */
    private float f11121s;

    /* renamed from: t */
    private int f11122t;

    /* renamed from: u */
    private int[][] f11123u;

    /* renamed from: w */
    private Handler f11124w = new Handler(Looper.getMainLooper());

    /* renamed from: x */
    private Runnable f11125x = new Runnable() {
        public void run() {
            if (PipPlayControl.this.f11112j != null && PipPlayControl.this.f11112j.isPlaying() && PipPlayControl.this.f11109g.getVisibility() == 0) {
                PipPlayControl.this.f11109g.setVisibility(8);
            }
        }
    };

    /* renamed from: y */
    private GestureDetector.SimpleOnGestureListener f11126y = new GestureDetector.SimpleOnGestureListener() {
        public boolean onDoubleTap(MotionEvent motionEvent) {
            PipPlayControl.this.mo18159e();
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            PipPlayControl.this.m12695l();
            return true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C2822c f11127z;

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public PipPlayControl(PipPlayerService pipPlayerService, View view) {
        this.f11103a = pipPlayerService;
        this.f11108f = view;
        this.f11104b = (WindowManager) pipPlayerService.getSystemService("window");
        m12691h();
        this.f11104b.addView(view, this.f11107e);
        view.setOnTouchListener(this);
    }

    /* renamed from: a */
    public void mo18154a() {
        this.f11127z = null;
        if (this.f11124w != null) {
            this.f11124w.removeCallbacksAndMessages((Object) null);
        }
        if (this.f11112j != null) {
            if (!this.f11115m && this.f11114l != null) {
                C2787b bVar = this.f11114l;
                int currentPosition = this.f11112j.getCurrentPosition();
                bVar.f11083c = currentPosition;
                m12675a((long) currentPosition);
            }
            this.f11112j.setOnVideoFrameRenderedListener( null);
            this.f11112j.mo17486f();
            this.f11112j.setKeepScreenOn(false);
            this.f11112j = null;
        }
        if (this.f11104b != null) {
            this.f11104b.removeView(this.f11108f);
        }
        this.f11104b = null;
        this.f11108f = null;
        axi.m7354a();
    }

    /* renamed from: a */
    public void mo18155a(C2787b bVar) {
        if (this.f11112j != null) {
            this.f11114l = bVar;
            m12677a(bVar.f11082b);
            m12698o();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pip_back /*2131296680*/:
                view.getContext().startActivity(new Intent(view.getContext(), PlayerActivity.class).putExtra("fromPip", true).addFlags(268435456));
                return;
            case R.id.pip_close /*2131296681*/:
                this.f11103a.stopSelf();
                return;
            case R.id.pip_play /*2131296684*/:
                mo18159e();
                return;
            case R.id.pip_toggle_size /*2131296685*/:
                m12674a(this.f11122t + 1, true);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void onPrepared(IMediaPlayer avg) {
        if (this.f11100E != null && this.f11100E.equals(this.f11114l.f11082b)) {
            this.f11100E = null;
            if (this.f11099D > -2) {
                m12687c(this.f11099D, true);
            }
            this.f11099D = -2;
        }
        if (this.f11098C != null && this.f11098C.equals(this.f11114l.f11082b)) {
            this.f11098C = null;
            if (this.f11097B >= 0 && this.f11112j.mo17483d(2) != this.f11097B) {
                this.f11112j.mo17477b(this.f11097B);
            }
            this.f11097B = -2;
        }
    }

    /* renamed from: a */
    public void onCompletion(IMediaPlayer avg) {
        m12675a(Long.MAX_VALUE);
        this.f11114l.f11083c = 0;
        if (this.f11114l.f11087g) {
            this.f11114l.f11087g = false;
            MyApplication.myApplication().mo17870a(false);
            this.f11115m = true;
            mo18156b();
            return;
        }
        if (this.f11114l.f11085e != null) {
            if (this.f11114l.f11091k == 2) {
                if (m12684b(this.f11114l.f11084d, false)) {
                    return;
                }
            } else if ((this.f11114l.f11091k != 0 || SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("playNext", true)) && m12680a(false)) {
                return;
            }
        }
        this.f11115m = true;
        mo18156b();
    }

    /* renamed from: b */
    public void mo18156b() {
        this.f11103a.stopSelf();
    }

    /* renamed from: a */
    public boolean onError(IMediaPlayer avg, int i, int i2) {
        this.f11103a.stopSelf();
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f11104b == null) {
            return false;
        }
        if (this.f11106d != null) {
            this.f11106d.onTouchEvent(motionEvent);
        }
        if (this.f11105c != null && this.f11105c.onTouchEvent(motionEvent)) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f11118p = this.f11107e.x;
                this.f11119q = this.f11107e.y;
                this.f11120r = motionEvent.getRawX();
                this.f11121s = motionEvent.getRawY();
                m12694k();
                return true;
            case 1:
                return true;
            case 2:
                if (this.f11106d == null || !this.f11106d.isInProgress()) {
                    this.f11107e.x = this.f11118p + ((int) (motionEvent.getRawX() - this.f11120r));
                    this.f11107e.y = this.f11119q - ((int) (motionEvent.getRawY() - this.f11121s));
                    m12672a(this.f11107e.width, this.f11107e.height);
                    this.f11104b.updateViewLayout(this.f11108f, this.f11107e);
                    return true;
                }
        }
        return false;
    }

    /* renamed from: h */
    private void m12691h() {
        this.f11107e = new WindowManager.LayoutParams(0, 0, Build.VERSION.SDK_INT >= 26 ? 2038 : 2002, 8, -1);
        this.f11107e.gravity = 8388691;
        this.f11107e.x = 50;
        this.f11107e.y = 50;
        this.f11112j = (XVideoView) this.f11108f.findViewById(R.id.video_view);
        this.f11109g = this.f11108f.findViewById(R.id.play_control_layout);
        ImageView imageView = (ImageView) this.f11109g.findViewById(R.id.pip_play);
        this.f11110h = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.f11109g.findViewById(R.id.pip_toggle_size);
        this.f11111i = imageView2;
        imageView2.setOnClickListener(this);
        this.f11109g.findViewById(R.id.pip_back).setOnClickListener(this);
        this.f11109g.findViewById(R.id.pip_close).setOnClickListener(this);
        this.f11112j.f9903a = false;
        m12694k();
        m12693j();
        m12674a(1, false);
        this.f11112j.setOnPreparedListener(this);
        this.f11112j.setOnCompletionListener(this);
        this.f11112j.setOnErrorListener(this);
        this.f11105c = new GestureDetectorCompat(this.f11103a, this.f11126y);
        this.f11105c.setOnDoubleTapListener(this.f11126y);
        this.f11106d = new ScaleGestureDetector(this.f11103a, this);
        m12692i();
        this.f11112j.setOnAudioSessionIdListener(new avp() {
            /* renamed from: a */
            public void mo10817a(int i) {
                axi.m7354a();
                axi.m7355a(PipPlayControl.this.f11112j.getAudioSessionId());
            }
        });
    }

    /* renamed from: i */
    private void m12692i() {
        this.f11113k = (TextView) this.f11108f.findViewById(R.id.subtitle_text);
        this.f11112j.setOnTimedTextListener(new IMediaPlayer.OnTimedTextListener() {
            @Override
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {

            }
        });
       this.f11112j.setOnVideoFrameRenderedListener(new com.abhishek.inplayer.widget.IMediaPlayer.C1283h() {


            private int f11131b = -1;


            public void mo10732a() {
                if (PipPlayControl.this.f11127z != null) {
                    int currentPosition = PipPlayControl.this.f11112j.getCurrentPosition();
                    if (Math.abs(currentPosition - this.f11131b) > 50) {
                        this.f11131b = currentPosition;
                        List<C2822c.C2826b> a = PipPlayControl.this.f11127z.mo18214a((long) currentPosition);
                        if (a == null || a.isEmpty()) {
                            PipPlayControl.this.f11113k.setText((CharSequence) null);
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        for (C2822c.C2826b next : a) {
                            if (sb.length() > 0) {
                                sb.append("<BR/>");
                            }
                            sb.append(next.f11228a);
                        }
                        PipPlayControl.this.f11113k.setText(Html.fromHtml(sb.toString()));
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private void m12674a(int i, boolean z) {
        if (i >= f11095v.length) {
            i = 0;
        }
        this.f11111i.setImageResource(f11095v[i]);
        m12673a(this.f11123u[i][0], this.f11123u[i][1], z);
        this.f11122t = i;
    }

    /* renamed from: a */
    private void m12673a(int i, int i2, boolean z) {
        if (i > this.f11116n) {
            i2 = (i2 * this.f11116n) / i;
            i = this.f11116n;
        }
        if (i2 > this.f11117o) {
            i = (i * this.f11117o) / i2;
            i2 = this.f11117o;
        }
        m12672a(i, i2);
        this.f11107e.width = i;
        this.f11107e.height = i2;
        if (z) {
            this.f11104b.updateViewLayout(this.f11108f, this.f11107e);
        }
    }

    /* renamed from: j */
    private void m12693j() {
        this.f11123u = new int[3][];
        int min = Math.min(this.f11116n, this.f11117o) - axw.m7444a(MyApplication.getApplicationContext_(), 48.0f);
        float f = (float) min;
        int max = Math.max(axw.m7444a((Context) this.f11103a, 160.0f), Math.round(0.5f * f));
        int round = Math.round(f * 0.7f);
        if (round <= max) {
            round = (min + max) / 2;
        }
        this.f11123u[0] = new int[]{max, Math.round(((float) (max * 9)) / 16.0f)};
        this.f11123u[1] = new int[]{round, Math.round(((float) (round * 9)) / 16.0f)};
        this.f11123u[2] = new int[]{min, Math.round(((float) (min * 9)) / 16.0f)};
    }

    /* renamed from: k */
    private void m12694k() {
        Point point = new Point();
        this.f11104b.getDefaultDisplay().getSize(point);
        this.f11116n = point.x;
        this.f11117o = point.y;
    }

    /* renamed from: a */
    private void m12672a(int i, int i2) {
        this.f11107e.x = Math.max(this.f11107e.x, 0);
        this.f11107e.y = Math.max(this.f11107e.y, 0);
        if (this.f11107e.x + i > this.f11116n) {
            this.f11107e.x = this.f11116n - i;
        }
        if (this.f11107e.y + i2 > this.f11117o) {
            this.f11107e.y = this.f11117o - i2;
        }
    }

    /* renamed from: c */
    public void mo18157c() {
        if (this.f11112j != null && !this.f11112j.mo17500h()) {
            this.f11112j.setKeepScreenOn(true);
            this.f11112j.start();
            this.f11110h.setImageResource(R.drawable.ic_pause_audio);
            m12696m();
        }
    }

    /* renamed from: d */
    public boolean mo18158d() {
        if (this.f11112j == null || this.f11112j.mo17500h() || !this.f11112j.isPlaying()) {
            return false;
        }
        this.f11112j.setKeepScreenOn(false);
        this.f11112j.pause();
        this.f11110h.setImageResource(R.drawable.ic_play_audio);
        this.f11109g.setVisibility( View.VISIBLE);
        m12697n();
        return true;
    }

    /* renamed from: e */
    public void mo18159e() {
        if (!mo18158d()) {
            mo18157c();
        }
    }

    /* renamed from: f */
    public void mo18160f() {
        if (!m12685b(true)) {
            axv.m7434a((int) R.string.no_previous_video);
        }
    }

    /* renamed from: g */
    public void mo18161g() {
        if (!m12680a(true)) {
            axv.m7434a((int) R.string.no_next_video);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m12695l() {
        if (this.f11109g.getVisibility() == View.VISIBLE) {
            m12697n();
            this.f11109g.setVisibility(View.GONE);
            return;
        }
        this.f11109g.setVisibility(View.VISIBLE);
        m12696m();
    }

    /* renamed from: m */
    private void m12696m() {
        if (this.f11112j != null) {
            m12697n();
            this.f11124w.postDelayed(this.f11125x, 3000);
        }
    }

    /* renamed from: n */
    private void m12697n() {
        this.f11124w.removeCallbacks(this.f11125x);
    }

    /* renamed from: a */
    private void m12679a(String str, final boolean z, final boolean z2, final int i) {
        this.f11096A = str;
        C2822c.m12788a(str, (C2822c.C2825a) new C2822c.C2825a() {
            /* renamed from: a */
            public void mo17596a(C2822c.C2827c cVar) {
                if (PipPlayControl.this.f11112j != null && TextUtils.equals(PipPlayControl.this.f11096A, cVar.f11231a)) {
                    C2822c unused = PipPlayControl.this.f11127z = new C2822c(cVar, z2, i);
                }
            }

            /* renamed from: a */
            public void mo17597a(String str) {
                if (PipPlayControl.this.f11112j != null && TextUtils.equals(PipPlayControl.this.f11096A, str)) {
                    if (!z) {
                        axv.m7440b(R.string.subtitle_load_failed);
                    }
                    if (PipPlayControl.this.f11127z != null) {
                        String unused = PipPlayControl.this.f11096A = PipPlayControl.this.f11127z.mo18217b();
                    } else {
                        String unused2 = PipPlayControl.this.f11096A = null;
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private void m12678a(String str, int i) {
        this.f11099D = i;
        this.f11100E = str;
    }

    /* renamed from: b */
    private void m12683b(String str, int i) {
        this.f11097B = i;
        this.f11098C = str;
    }

    /* renamed from: a */
    private void m12676a(VideoPlayListBean videoPlayListBean) {
        this.f11114l.f11082b = videoPlayListBean.f9813a;
        this.f11114l.f11081a = videoPlayListBean.f9815c;
        this.f11114l.f11094n = videoPlayListBean.f9818f;
        m12677a(videoPlayListBean.f9813a);
        if (!SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("playResume", true) || videoPlayListBean.f9816d <= 0 || videoPlayListBean.f9816d >= videoPlayListBean.f9814b - 100) {
            this.f11114l.f11083c = 0;
        } else {
            this.f11114l.f11083c = (int) videoPlayListBean.f9816d;
        }
        m12698o();
    }

    /* renamed from: o */
    private void m12698o() {
        this.f11112j.setRender(2);
        this.f11112j.mo17474a(this.f11114l.f11082b, (Map<String, String>) this.f11114l.f11093m, this.f11114l.f11083c);
        this.f11112j.setKeepScreenOn(true);
        this.f11112j.start();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12677aa(String r11) {
        /*
            r10 = this;
            com.inshot.xplayer.service.b r0 = r10.f11114l
            java.lang.String r0 = r0.f11082b
            boolean r0 = android.text.TextUtils.equals(r0, r11)
            r1 = 0
            if (r0 != 0) goto L_0x0012
            r10.f11127z = r1
            android.widget.TextView r0 = r10.f11113k
            r0.setText(r1)
        L_0x0012:
            com.inshot.xplayer.service.b r0 = r10.f11114l
            r0.f11082b = r11
            r10.m12699p()
            com.inshot.xplayer.service.b r0 = r10.f11114l
            int r0 = r0.f11090j
            r2 = 10
            if (r0 == r2) goto L_0x002e
            com.inshot.inplayer.widget.XVideoView r0 = r10.f11112j
            com.inshot.xplayer.service.b r2 = r10.f11114l
            int r2 = r2.f11090j
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            r0.setSpeed(r2)
        L_0x002e:
            com.inshot.inplayer.widget.XVideoView r0 = r10.f11112j
            android.content.Context r2 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            android.content.SharedPreferences r2 = p000.axn.getSharedPrefrence(r2)
            java.lang.String r3 = "DefaultDecoder"
            r4 = 0
            int r2 = r2.getInt(r3, r4)
            r3 = 1
            if (r2 != r3) goto L_0x0044
            r2 = 1
            goto L_0x0045
        L_0x0044:
            r2 = 0
        L_0x0045:
            r0.setUseSw(r2)
            com.inshot.inplayer.widget.XVideoView r0 = r10.f11112j
            r2 = 0
            r0.setAudioDelay(r2)
            com.inshot.xplayer.service.b r0 = r10.f11114l
            java.lang.String r0 = r0.f11081a
            java.lang.String r0 = com.inshot.xplayer.subtitle.C2822c.m12787a((java.lang.String) r11, (java.lang.String) r0)
            com.inshot.xplayer.service.b r5 = r10.f11114l
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r5 = r5.f11094n
            if (r5 == 0) goto L_0x00b2
            boolean r6 = r5.f10538c
            java.lang.String r7 = r5.f10536a
            if (r7 == 0) goto L_0x0067
            java.lang.String r0 = r5.f10536a
            int r7 = r5.f10537b
            goto L_0x0068
        L_0x0067:
            r7 = 0
        L_0x0068:
            int r8 = r5.f10539d
            r9 = -1
            if (r8 != r9) goto L_0x007a
            if (r6 == 0) goto L_0x007a
            boolean r8 = p000.axc.m7301a((java.lang.String) r0)
            if (r8 != 0) goto L_0x007a
            r0 = -2
            r5.f10539d = r0
            r0 = r1
            r7 = 0
        L_0x007a:
            int r1 = r5.f10539d
            if (r1 != r9) goto L_0x0083
            r10.f11099D = r9
            r10.f11100E = r11
            goto L_0x008c
        L_0x0083:
            int r1 = r5.f10539d
            if (r1 < 0) goto L_0x008c
            int r1 = r5.f10539d
            r10.m12678a((java.lang.String) r11, (int) r1)
        L_0x008c:
            int r1 = r5.f10542g
            if (r1 < 0) goto L_0x0095
            int r1 = r5.f10542g
            r10.m12683b((java.lang.String) r11, (int) r1)
        L_0x0095:
            float r11 = r5.f10544i
            int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r11 == 0) goto L_0x00a2
            com.inshot.inplayer.widget.XVideoView r11 = r10.f11112j
            float r1 = r5.f10544i
            r11.setAudioDelay(r1)
        L_0x00a2:
            int r11 = r5.f10543h
            if (r11 == r9) goto L_0x00b0
            com.inshot.inplayer.widget.XVideoView r11 = r10.f11112j
            int r1 = r5.f10543h
            if (r1 != r3) goto L_0x00ad
            r4 = 1
        L_0x00ad:
            r11.setUseSw(r4)
        L_0x00b0:
            r4 = r7
            goto L_0x00b3
        L_0x00b2:
            r6 = 1
        L_0x00b3:
            r10.m12679a(r0, r3, r6, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.service.C2788c.m12677a(java.lang.String):void");
    }
    private void m12677a(String str) {
        boolean z2;
        int i2;
        if (!TextUtils.equals(this.f11114l.f11082b, str)) {
            this.f11127z = null;
            this.f11113k.setText((CharSequence) null);
        }
        this.f11114l.f11082b = str;
        m12699p();
        if (this.f11114l.f11090j != 10) {
            this.f11112j.setSpeed(((float) this.f11114l.f11090j) / 10.0f);
        }
        int i3 = 0;
        boolean z3 = false;
        this.f11112j.setUseSw(SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getInt("DefaultDecoder", 0) == 1);
        this.f11112j.setAudioDelay(0.0f);
        String a2 = com.abhishek.xplayer.subtitle.C2822c.m12787a(str, this.f11114l.f11081a);
        RecentMediaStorage.ExInfo exInfo = this.f11114l.f11094n;
        if (exInfo != null) {
            z2 = exInfo.f10538c;
            if (exInfo.f10536a != null) {
                a2 = exInfo.f10536a;
                i2 = exInfo.f10537b;
            } else {
                i2 = 0;
            }
            if (exInfo.f10539d == -1 && z2 && !axc.chekFileExist(a2)) {
                exInfo.f10539d = -2;
                a2 = null;
                i2 = 0;
            }
            if (exInfo.f10539d == -1) {
                this.f11099D = -1;
                this.f11100E = str;
            } else if (exInfo.f10539d >= 0) {
                m12678a(str, exInfo.f10539d);
            }
            if (exInfo.f10542g >= 0) {
                m12683b(str, exInfo.f10542g);
            }
            if (exInfo.f10544i != 0.0f) {
                this.f11112j.setAudioDelay(exInfo.f10544i);
            }
            if (exInfo.f10543h != -1) {
                XVideoView xVideoView = this.f11112j;
                if (exInfo.f10543h == 1) {
                    z3 = true;
                }
                xVideoView.setUseSw(z3);
            }
            i3 = i2;
        } else {
            z2 = true;
        }
        m12679a(a2, true, z2, i3);
    }

    /* renamed from: p */
    private void m12699p() {
        if (this.f11112j.isPlaying()) {
            this.f11114l.f11083c = this.f11112j.getCurrentPosition();
            this.f11112j.mo17475a(false);
        }
    }

    /* renamed from: a */
    private boolean m12680a(boolean z) {
        if (this.f11114l.f11085e != null) {
            int b = this.f11114l.f11091k == 1 ? m12681b(this.f11114l.f11084d, 1) : this.f11114l.f11084d + 1;
            if (b >= this.f11114l.f11085e.size() && (this.f11114l.f11091k == 3 || this.f11114l.f11091k == 2)) {
                b = 0;
            }
            if (m12684b(b, z)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m12685b(boolean z) {
        if (this.f11114l.f11085e == null) {
            return false;
        }
        int b = this.f11114l.f11091k == 1 ? m12681b(this.f11114l.f11084d, -1) : this.f11114l.f11084d - 1;
        if (b < 0 && (this.f11114l.f11091k == 3 || this.f11114l.f11091k == 2)) {
            b = this.f11114l.f11085e.size() - 1;
        }
        if (m12684b(b, z)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private int m12681b(int i, int i2) {
        if (this.f11114l.f11085e == null || this.f11114l.f11085e.isEmpty()) {
            return 0;
        }
        return axi.m7351a(this.f11114l.f11085e, i, i2);
    }

    /* renamed from: b */
    private boolean m12684b(int i, boolean z) {
        VideoPlayListBean videoPlayListBean;
        if (i < 0 || i >= this.f11114l.f11085e.size() || (videoPlayListBean = this.f11114l.f11085e.get(i)) == null || videoPlayListBean.f9813a == null) {
            return false;
        }
        if (z) {
            m12700q();
        }
        this.f11114l.f11084d = i;
        m12676a(videoPlayListBean);
        return true;
    }

    /* renamed from: q */
    private void m12700q() {
        int currentPosition;
        if (this.f11112j != null && (currentPosition = this.f11112j.getCurrentPosition()) > 0) {
            m12675a((long) currentPosition);
        }
        if (this.f11112j != null) {
            this.f11112j.mo17486f();
        }
    }

    /* renamed from: c */
    private void m12687c(int i, boolean z) {
        if (z) {
            int d = this.f11112j.mo17483d(3);
            if (d != i) {
                this.f11112j.mo17479c(d);
            } else {
                return;
            }
        }
        this.f11112j.mo17477b(i);
        if (i != -1) {
            XVideoView xVideoView = this.f11112j;
            C2787b bVar = this.f11114l;
            int currentPosition = this.f11112j.getCurrentPosition();
            bVar.f11083c = currentPosition;
            xVideoView.seekTo(currentPosition);
        }
    }

    /* renamed from: a */
    private void m12675a(long j) {
        long j2;
        int i;
        if (this.f11101F == null) {
            this.f11101F = new RecentMediaStorage(MyApplication.getApplicationContext_());
        }
        long duration = this.f11112j != null ? (long) this.f11112j.getDuration() : -1;
        long j3 = j > duration ? duration : j;
        VideoPlayListBean a = this.f11114l.mo18153a();
        if (a == null || !a.f9813a.equals(this.f11114l.f11082b)) {
            j2 = duration;
            i = -1;
        } else {
            a.f9816d = j3;
            a.f9818f = this.f11114l.f11094n;
            int i2 = a.f9819g;
            if (duration < 0) {
                duration = a.f9814b;
            }
            i = i2;
            j2 = duration;
        }
        this.f11101F.mo17903a(i, this.f11114l.f11082b, j3, j2, this.f11114l.f11088h ? 2 : this.f11114l.f11092l ? 1 : 0, this.f11114l.f11094n);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.f11102G *= (double) scaleGestureDetector.getScaleFactor();
        if (this.f11102G > 1.2d && this.f11122t + 1 < f11095v.length) {
            m12674a(this.f11122t + 1, true);
            this.f11102G = 1.0d;
        } else if (this.f11102G < 0.86d && this.f11122t > 0) {
            m12674a(this.f11122t - 1, true);
            this.f11102G = 1.0d;
        }
        return true;
    }
}
