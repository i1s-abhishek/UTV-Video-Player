package com.abhishek.inplayer.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;

import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.subtitle.SubtitleImageView;

import java.io.IOException;
import java.util.Map;

import classesdef.inplayer.avp;
import classesdef.inplayer.axi;
import tv.danmaku.ijk.media.exo.IjkExoMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;


public class XVideoView extends FrameLayout implements MediaController.MediaPlayerControl {

    /* renamed from: W */
    private static final int[] s_allAspectRatio = {0, 1, 2, 3, 4, 5, 6};

    /* renamed from: A */
    private boolean f9881A = true;

    /* renamed from: B */
    private boolean f9882B = true;

    /* renamed from: C */
    private boolean f9883C = true;

    /* renamed from: D */
    private Context f9884D;

    /* renamed from: E */
    private C2482f f9885E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C2477c mRenderView;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int mVideoSarNum;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int mVideoSarDen;

    /* renamed from: I */
    private long f9889I = 0;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f9890J = 0;

    /* renamed from: K */
    private long f9891K = 0;

    /* renamed from: L */
    private long f9892L = 0;

    /* renamed from: M */
    private float f9893M = 1.0f;

    /* renamed from: N */
    private float f9894N = 1.0f;

    /* renamed from: O */
    private float f9895O = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public boolean f9896P = true;

    /* renamed from: Q */
    private IMediaPlayer.OnCompletionListener f9897Q = new IMediaPlayer.OnCompletionListener() {
        /* renamed from: a */
        public void onCompletion(IMediaPlayer IMediaPlayer) {
            int unused = XVideoView.this.f9916i = 305;
            int unused2 = XVideoView.this.f9917j = 305;
            if (XVideoView.this.f9925r != null) {
                XVideoView.this.f9925r.hide();
            }
            if (XVideoView.this.f9926s != null) {
                XVideoView.this.f9926s.onCompletion(XVideoView.this.f9919l);
            }
            if (XVideoView.this.f9932y != null) {
                XVideoView.this.f9932y.onInfo(XVideoView.this.f9919l, 305, 0);
            }
        }
    };

    /* renamed from: R */
    private IMediaPlayer.OnInfoListener f9898R = new IMediaPlayer.OnInfoListener() {
        /* renamed from: a */
        public boolean onInfo(IMediaPlayer IMediaPlayer, int i, int i2) {
            if (XVideoView.this.f9932y != null) {
                XVideoView.this.f9932y.onInfo(IMediaPlayer, i, i2);
            }
            if (i == 3) {
                return true;
            }
            if (i != 10001) {
                switch (i) {
                    case 700:
                    case 701:
                    case 702:
                    case 703:
                        return true;
                    default:
                        switch (i) {
                            case 800:
                            case 801:
                            case 802:
                                return true;
                            default:
                                switch (i) {
                                }
                                return true;
                        }
                }
            } else {
                int unused = XVideoView.this.f9924q = i2;
                if (XVideoView.this.mRenderView == null) {
                    return true;
                }
                XVideoView.this.mRenderView.setVideoRotation(i2);
                return true;
            }
        }
    };

    /* renamed from: S */
    private IMediaPlayer.OnErrorListener f9899S = new IMediaPlayer.OnErrorListener() {
        /* renamed from: a */
        public boolean onError(IMediaPlayer IMediaPlayer, int i, int i2) {
            int unused = XVideoView.this.f9916i = 299;
            int unused2 = XVideoView.this.f9917j = 299;
            if (XVideoView.this.f9925r != null) {
                XVideoView.this.f9925r.hide();
            }
            return (XVideoView.this.f9931x == null || XVideoView.this.f9931x.onError(XVideoView.this.f9919l, i, i2)) ? true : true;
        }
    };

    /* renamed from: T */
    private IMediaPlayer.OnBufferingUpdateListener f9900T = new IMediaPlayer.OnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {

        }
    };

    /* renamed from: U */
    private IMediaPlayer.OnSeekCompleteListener f9901U = new IMediaPlayer.OnSeekCompleteListener() {
        @Override
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {

        }
    };

    /* renamed from: V */
    private IMediaPlayer.OnTimedTextListener f9902V = new IMediaPlayer.OnTimedTextListener() {
        @Override
        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {

        }
    };

    /* renamed from: a */
    public boolean f9903a = true;

    /* renamed from: aa */
    private int mCurrentAspectRatioIndex = 0;

    /* renamed from: ab */
    private int f9905ab = s_allAspectRatio[0];

    /* renamed from: ac */
    private boolean f9906ac = false;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public boolean f9907ad = false;

    /* renamed from: ae */
    private avp f9908ae;

    /* renamed from: b */
    IMediaPlayer.OnVideoSizeChangedListener f9909b = new IMediaPlayer.OnVideoSizeChangedListener() {
        /* renamed from: a */
        public void onVideoSizeChanged(IMediaPlayer IMediaPlayer, int i, int i2, int i3, int i4) {
            int unused = XVideoView.this.mVideoWidth = IMediaPlayer.getVideoWidth();
            int unused2 = XVideoView.this.mVideoHeight = IMediaPlayer.getVideoHeight();
            int unused3 = XVideoView.this.mVideoSarNum = IMediaPlayer.getVideoSarNum();
            int unused4 = XVideoView.this.mVideoSarDen = IMediaPlayer.getVideoSarDen();
            XVideoView.this.m11227n();
        }
    };

    /* renamed from: c */
    IMediaPlayer.OnPreparedListener f9910c = new IMediaPlayer.OnPreparedListener() {
        /* renamed from: b */
        public void onPrepared(IMediaPlayer IMediaPlayer) {
            long unused = XVideoView.this.f9890J = System.currentTimeMillis();
            int unused2 = XVideoView.this.f9916i = 302;
            if (XVideoView.this.f9927t != null) {
                XVideoView.this.f9927t.onPrepared(XVideoView.this.f9919l);
            }
            if (XVideoView.this.f9925r != null) {
                XVideoView.this.f9925r.setEnabled(true);
            }
            int unused3 = XVideoView.this.mVideoWidth = IMediaPlayer.getVideoWidth();
            int unused4 = XVideoView.this.mVideoHeight = IMediaPlayer.getVideoHeight();
            int e = XVideoView.this.f9933z;
            if (e != 0) {
                XVideoView.this.seekTo(e);
            }
            if (XVideoView.this.mVideoWidth == 0 || XVideoView.this.mVideoHeight == 0) {
                if (XVideoView.this.f9917j == 303) {
                    XVideoView.this.start();
                }
            } else if (XVideoView.this.mRenderView != null) {
                XVideoView.this.mRenderView.setVideoSize(XVideoView.this.mVideoWidth, XVideoView.this.mVideoHeight);
                XVideoView.this.mRenderView.setVideoSampleAspectRatio(XVideoView.this.mVideoSarNum, XVideoView.this.mVideoSarDen);
                if (XVideoView.this.mRenderView.mo17441a() && (XVideoView.this.f9922o != XVideoView.this.mVideoWidth || XVideoView.this.f9923p != XVideoView.this.mVideoHeight)) {
                    return;
                }
                if (XVideoView.this.f9917j == 303) {
                    XVideoView.this.start();
                    if (XVideoView.this.f9925r != null) {
                        XVideoView.this.f9925r.show();
                    }
                } else if (XVideoView.this.isPlaying()) {
                } else {
                    if ((e != 0 || XVideoView.this.getCurrentPosition() > 0) && XVideoView.this.f9925r != null) {
                        XVideoView.this.f9925r.show(0);
                    }
                }
            }
        }
    };

    /* renamed from: d */
    C2477c.C2478a f9911d = new C2477c.C2478a() {
        /* renamed from: a */
        public void mo17530a(C2477c.C2479b bVar, int i, int i2, int i3) {
            if (bVar.mo17450a() == XVideoView.this.mRenderView && !XVideoView.this.f9907ad) {
                int unused = XVideoView.this.f9922o = i2;
                int unused2 = XVideoView.this.f9923p = i3;
                boolean z = false;
                boolean z2 = XVideoView.this.f9917j == 303;
                if (!XVideoView.this.mRenderView.mo17441a() || (XVideoView.this.mVideoWidth == i2 && XVideoView.this.mVideoHeight == i3)) {
                    z = true;
                }
                if (XVideoView.this.f9919l != null && z2 && z) {
                    if (XVideoView.this.f9933z != 0) {
                        XVideoView.this.seekTo(XVideoView.this.f9933z);
                    }
                    XVideoView.this.start();
                }
            }
        }

        /* renamed from: a */
        public void mo17529a(C2477c.C2479b bVar, int i, int i2) {
            if (bVar.mo17450a() == XVideoView.this.mRenderView) {
                C2477c.C2479b unused = XVideoView.this.f9918k = bVar;
                if (XVideoView.this.f9919l != null) {
                    XVideoView.this.m11200a(XVideoView.this.f9919l, bVar);
                } else if (XVideoView.this.f9896P) {
                    XVideoView.this.m11223l();
                }
            }
        }

        /* renamed from: a */
        public void mo17528a(C2477c.C2479b bVar) {
            if (bVar.mo17450a() == XVideoView.this.mRenderView) {
                C2477c.C2479b unused = XVideoView.this.f9918k = null;
                XVideoView.this.mo17487g();
            }
        }

        /* renamed from: a */
       public void mo17527a() {
           if (XVideoView.this.mMediaPlayer != null) {
                XVideoView.this.mMediaPlayer.mo10732a();
            }
        }
    };

    /* renamed from: e */
    private String f9912e = "XVideoView";

    /* renamed from: f */
    private Uri f9913f;

    /* renamed from: g */
    private String f9914g;

    /* renamed from: h */
    private Map<String, String> f9915h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f9916i = 300;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f9917j = 300;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C2477c.C2479b f9918k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IMediaPlayer f9919l = null;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int mVideoWidth;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int mVideoHeight;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f9922o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f9923p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f9924q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C2476b f9925r;
    /* access modifiers changed from: private */
    /* renamed from: s */

    public IMediaPlayer.OnCompletionListener f9926s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public IMediaPlayer.OnPreparedListener f9927t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public com.abhishek.inplayer.widget.IMediaPlayer.C1283h mMediaPlayer;

    /* renamed from: v */
    private IMediaPlayer.OnTimedTextListener f9929v;

    /* renamed from: w */
    private int f9930w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public IMediaPlayer.OnErrorListener f9931x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public IMediaPlayer.OnInfoListener f9932y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f9933z;

    /* renamed from: q */
    private void m11232q() {
    }

    /* renamed from: b */
    public void mo17477b(int i) {
    }

    /* renamed from: c */
    public void mo17479c(int i) {
    }

    /* renamed from: d */
    public int mo17483d(int i) {
        return -1;
    }

    public long getTcpSpeed() {
        return -1;
    }

    /* renamed from: i */
    public boolean mo17501i() {
        return true;
    }

    public XVideoView(Context context) {
        super(context);
        m11198a(context);
    }

    public XVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11198a(context);
    }

    public XVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11198a(context);
    }

    public IMediaPlayer getMediaPlayer() {
        return this.f9919l;
    }

    @TargetApi(21)
    public XVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m11198a(context);
    }

    /* renamed from: a */
    private void m11198a(Context context) {
        this.f9884D = context.getApplicationContext();
        this.f9885E = new C2482f(false);
        m11232q();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f9916i = 300;
        this.f9917j = 300;
    }

    public void setUseSw(boolean z) {
        this.f9885E.mo17547a(!z);
    }

    public void setRenderView(C2477c cVar) {
        if (this.mRenderView != null) {
            if (this.f9919l != null) {
                this.f9919l.setDisplay((SurfaceHolder) null);
            }
            View view = this.mRenderView.getView();
            this.mRenderView.mo17443b(this.f9911d);
            this.mRenderView = null;
            removeView(view);
        }
        if (cVar != null) {
            this.mRenderView = cVar;
            cVar.setAspectRatio(this.f9905ab);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                cVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                cVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            View view2 = this.mRenderView.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            addView(view2);
            if (getChildAt(0) instanceof SubtitleImageView) {
                bringChildToFront(getChildAt(0));
            }
            this.mRenderView.mo17440a(this.f9911d);
            this.mRenderView.setVideoRotation(this.f9924q);
        }
    }

    public void setRender(int i) {
        switch (i) {
            case 0:
                setRenderView((C2477c) null);
                return;
            case 1:
                setRenderView(new SurfaceRenderView(getContext()));
                return;
            case 2:
                TextureRenderView textureRenderView = new TextureRenderView(getContext());
                if (this.f9919l != null) {
                    textureRenderView.getSurfaceHolder().mo17451a(this.f9919l);
                    textureRenderView.setVideoSize(this.f9919l.getVideoWidth(), this.f9919l.getVideoHeight());
                    textureRenderView.setVideoSampleAspectRatio(this.f9919l.getVideoSarNum(), this.f9919l.getVideoSarDen());
                    textureRenderView.setAspectRatio(this.f9905ab);
                }
                setRenderView(textureRenderView);
                return;
            default:
                return;
        }
    }

    public void setVolume(float f) {
        this.f9893M = f;
        if (this.f9919l != null) {
            this.f9919l.setVolume(f, f);
        }
    }

    public void setSpeed(float f) {
        this.f9894N = f;
        ((IjkMediaPlayer) this.f9919l).setSpeed(f);
    }

    public void setAudioDelay(float f) {
        this.f9895O = f;
    }

    public float getAudioDelay() {
        return this.f9895O;
    }

    /* renamed from: a */
    public void mo17473a() {
        mo17475a(false);
    }

    /* renamed from: b */
    public void mo17476b() {
        m11223l();
    }

    /* renamed from: c */
    public void mo17478c() {
        this.f9896P = true;
    }

    /* renamed from: d */
    public void mo17484d() {
        this.f9896P = false;
    }

    /* renamed from: e */
    public boolean mo17485e() {
        return this.f9896P;
    }

    /* renamed from: a */
    public void mo17474a(String str, Map<String, String> map, int i) {
        this.f9914g = str;
        Log.e("Uri_parse","1"+str);
        m11199a(Uri.parse(str), map, i);
    }

    private void setVideoURI(Uri uri) {
        m11199a(uri, (Map<String, String>) null, 0);
    }

    /* renamed from: a */
    private void m11199a(Uri uri, Map<String, String> map, int i) {
        this.f9913f = uri;
        this.f9915h = map;
        this.f9933z = i;
        m11223l();
        requestLayout();
        invalidate();
    }

    /* renamed from: f */
    public void mo17486f() {
        if (this.f9919l != null) {
            this.f9919l.stop();
            axi.m7357a(this.f9919l, this.f9914g, false);
            this.f9919l = null;
            this.f9916i = 300;
            this.f9917j = 300;
            if (this.f9903a) {
                ((AudioManager) this.f9884D.getSystemService(Context.AUDIO_SERVICE)).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x012f */
    @TargetApi(23)
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11223l_() {
        /*
            r8 = this;
            android.net.Uri r0 = r8.f9913f
            if (r0 == 0) goto L_0x0148
            com.inshot.inplayer.widget.c$b r0 = r8.f9918k
            if (r0 != 0) goto L_0x000a
            goto L_0x0148
        L_0x000a:
            r0 = 0
            r8.mo17475a((boolean) r0)
            boolean r1 = r8.f9903a
            r2 = 3
            r3 = 1
            if (r1 == 0) goto L_0x0022
            android.content.Context r1 = r8.f9884D
            java.lang.String r4 = "audio"
            java.lang.Object r1 = r1.getSystemService(r4)
            android.media.AudioManager r1 = (android.media.AudioManager) r1
            r4 = 0
            r1.requestAudioFocus(r4, r2, r3)     // Catch:{ SecurityException -> 0x0022 }
        L_0x0022:
            r1 = 299(0x12b, float:4.19E-43)
            com.inshot.inplayer.widget.f r4 = r8.f9885E     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            int r4 = r4.mo17548b()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r4 = r8.m11211e((int) r4)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r8.f9919l = r4     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            android.content.Context r4 = r8.getContext()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer$e r6 = r8.f9910c     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10694a((p000.IMediaPlayer.OnPreparedListener) r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer$i r6 = r8.f9909b     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10697a((p000.IMediaPlayer.C1284i) r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer$b r6 = r8.f9897Q     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10710a((p000.IMediaPlayer.OnCompletionListener) r6, (boolean) r3)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer$c r6 = r8.f9899S     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10692a((p000.IMediaPlayer.OnErrorListener) r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer$d r6 = r8.f9898R     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10693a((p000.IMediaPlayer.OnInfoListener) r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer$a r6 = r8.f9900T     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10691a((p000.IMediaPlayer.C1276a) r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer$f r6 = r8.f9901U     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10695a((p000.IMediaPlayer.C1281f) r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer$g r6 = r8.f9902V     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10696a((p000.IMediaPlayer.OnTimedTextListener) r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            float r6 = r8.f9893M     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            float r7 = r8.f9893M     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10703a((float) r6, (float) r7)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            float r5 = r8.f9894N     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r6 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x0084
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            float r6 = r8.f9894N     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10702a((float) r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
        L_0x0084:
            r8.f9930w = r0     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            com.inshot.inplayer.widget.f r5 = r8.f9885E     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r5 = r5.mo17545a()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            if (r5 != 0) goto L_0x00eb
            android.net.Uri r5 = r8.f9913f     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            java.lang.String r6 = "content://"
            boolean r5 = r5.startsWith(r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            if (r5 == 0) goto L_0x00ad
            IMediaPlayer r5 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            com.inshot.inplayer.widget.a r6 = new com.inshot.inplayer.widget.a     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            android.net.Uri r7 = r8.f9913f     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r6.<init>(r4, r7)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5.mo10698a((com.inshot.inplayer.misc.IMediaDataSource) r6)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            goto L_0x00ca
        L_0x00ad:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r5 = 14
            if (r4 < r5) goto L_0x00bf
            IMediaPlayer r4 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            android.content.Context r5 = r8.f9884D     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            android.net.Uri r6 = r8.f9913f     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            java.util.Map<java.lang.String, java.lang.String> r7 = r8.f9915h     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r4.mo10706a(r5, r6, r7)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            goto L_0x00ca
        L_0x00bf:
            IMediaPlayer r4 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            android.net.Uri r5 = r8.f9913f     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r4.mo10711a((java.lang.String) r5)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
        L_0x00ca:
            IMediaPlayer r4 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            com.inshot.inplayer.widget.c$b r5 = r8.f9918k     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r8.m11200a((p000.IMediaPlayer) r4, (com.inshot.inplayer.widget.C2477c.C2479b) r5)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r4 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r4.mo10704a((int) r2)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r2 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r2.mo10712a((boolean) r3)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r8.f9889I = r4     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r2 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r2.mo10713c()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r2 = 301(0x12d, float:4.22E-43)
            r8.f9916i = r2     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            goto L_0x0129
        L_0x00eb:
            IMediaPlayer r2 = r8.f9919l     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            com.inshot.inplayer.widget.c$b r4 = r8.f9918k     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r8.m11200a((p000.IMediaPlayer) r2, (com.inshot.inplayer.widget.C2477c.C2479b) r4)     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            com.inshot.inplayer.widget.f r2 = r8.f9885E     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r2 = r2.mo17545a()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            int r2 = r2.getVideoWidth()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r8.mVideoWidth = r2     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            com.inshot.inplayer.widget.f r2 = r8.f9885E     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r2 = r2.mo17545a()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            int r2 = r2.getVideoHeight()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r8.mVideoHeight = r2     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            com.inshot.inplayer.widget.f r2 = r8.f9885E     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r2 = r2.mo17545a()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            int r2 = r2.getVideoSarNum()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r8.mVideoSarNum = r2     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            com.inshot.inplayer.widget.f r2 = r8.f9885E     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            IMediaPlayer r2 = r2.mo17545a()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            int r2 = r2.getVideoSarDen()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r8.mVideoSarDen = r2     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r8.m11227n()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            r2 = 303(0x12f, float:4.25E-43)
            r8.f9916i = r2     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
        L_0x0129:
            r8.m11225m()     // Catch:{ IOException -> 0x013b, IllegalArgumentException -> 0x012f }
            goto L_0x0146
        L_0x012d:
            r0 = move-exception
            goto L_0x0147
        L_0x012f:
            r8.f9916i = r1     // Catch:{ all -> 0x012d }
            r8.f9917j = r1     // Catch:{ all -> 0x012d }
            IMediaPlayer$c r1 = r8.f9899S     // Catch:{ all -> 0x012d }
            IMediaPlayer r2 = r8.f9919l     // Catch:{ all -> 0x012d }
            r1.onError(r2, r3, r0)     // Catch:{ all -> 0x012d }
            goto L_0x0146
        L_0x013b:
            r8.f9916i = r1     // Catch:{ all -> 0x012d }
            r8.f9917j = r1     // Catch:{ all -> 0x012d }
            IMediaPlayer$c r1 = r8.f9899S     // Catch:{ all -> 0x012d }
            IMediaPlayer r2 = r8.f9919l     // Catch:{ all -> 0x012d }
            r1.onError(r2, r3, r0)     // Catch:{ all -> 0x012d }
        L_0x0146:
            return
        L_0x0147:
            throw r0
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.inplayer.widget.XVideoView.m11223l():void");
    }
    private void m11223l() {
        if (this.f9913f != null && this.f9918k != null) {
            mo17475a(false);
            if (this.f9903a) {
                try {
                    ((AudioManager) this.f9884D.getSystemService(Context.AUDIO_SERVICE)).requestAudioFocus(null, 3, 1);
                } catch (SecurityException unused) {
                }
            }
            try {
                this.f9919l = m11211e(this.f9885E.mo17548b());
                Context context = getContext();
                this.f9919l.setOnPreparedListener(this.f9910c);
                this.f9919l.setOnVideoSizeChangedListener(this.f9909b);
                this.f9919l.setOnCompletionListener(this.f9897Q/*, true*/);
                this.f9919l.setOnErrorListener(this.f9899S);
                this.f9919l.setOnInfoListener(this.f9898R);
                this.f9919l.setOnBufferingUpdateListener(this.f9900T);
                this.f9919l.setOnSeekCompleteListener(this.f9901U);
                this.f9919l.setOnTimedTextListener(this.f9902V);
                this.f9919l.setVolume(this.f9893M, this.f9893M);
                if (this.f9894N != 1.0f) {
                    ((IjkMediaPlayer) this.f9919l).setSpeed(this.f9894N);
                }
                this.f9930w = 0;
                if (this.f9885E.mo17545a() == null) {
                    if (this.f9913f.toString().startsWith("content://")) {
                        this.f9919l.setDataSource(new C2475a(context.getContentResolver(), this.f9913f));
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        this.f9919l.setDataSource(this.f9884D, this.f9913f, this.f9915h);
                    } else {
                        this.f9919l.setDataSource(this.f9913f.toString());
                    }
                    m11200a(this.f9919l, this.f9918k);
                    this.f9919l.setAudioStreamType(3);
                    this.f9919l.setScreenOnWhilePlaying(true);
                    this.f9889I = System.currentTimeMillis();
                    this.f9919l.prepareAsync();
                    this.f9916i = 301;
                } else {
                    m11200a(this.f9919l, this.f9918k);
                    this.mVideoWidth = this.f9885E.mo17545a().getVideoWidth();
                    this.mVideoHeight = this.f9885E.mo17545a().getVideoHeight();
                    this.mVideoSarNum = this.f9885E.mo17545a().getVideoSarNum();
                    this.mVideoSarDen = this.f9885E.mo17545a().getVideoSarDen();
                    m11227n();
                    this.f9916i = 303;
                }
                m11225m();
            } catch (IllegalArgumentException | IOException unknown) {
                this.f9916i = 299;
                this.f9917j = 299;
                this.f9899S.onError(this.f9919l, 1, 0);
            }
        }
    }

    public void setMediaController(C2476b bVar) {
        if (this.f9925r != null) {
            this.f9925r.hide();
        }
        this.f9925r = bVar;
        m11225m();
    }

    /* renamed from: m */
    private void m11225m() {
        if (this.f9919l != null && this.f9925r != null) {
            this.f9925r.setMediaPlayer(this);
            this.f9925r.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.f9925r.setEnabled(m11231p());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m11227n() {
        if (this.mVideoWidth != 0 && this.mVideoHeight != 0) {
            if (this.mRenderView != null) {
                this.mRenderView.setVideoSize(this.mVideoWidth, this.mVideoHeight);
                this.mRenderView.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            requestLayout();
        }
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public View getRenderView() {
        return this.mRenderView.getView();
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener eVar) {
        this.f9927t = eVar;
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener bVar) {
        this.f9926s = bVar;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener cVar) {
        this.f9931x = cVar;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener dVar) {
        this.f9932y = dVar;
    }

    public void setOnVideoFrameRenderedListener(com.abhishek.inplayer.widget.IMediaPlayer.C1283h hVar) {
        this.mMediaPlayer = hVar;
    }

    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener gVar) {
        this.f9929v = gVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11200a(IMediaPlayer IMediaPlayer, C2477c.C2479b bVar) {
        if (IMediaPlayer != null) {
            if (bVar == null) {
                IMediaPlayer.setDisplay((SurfaceHolder) null);
            } else {
                bVar.mo17451a(IMediaPlayer);
            }
        }
    }

    /* renamed from: g */
    public void mo17487g() {
        if (this.f9919l != null) {
            this.f9919l.setDisplay((SurfaceHolder) null);
        }
    }

    /* renamed from: a */
    public void mo17475a(boolean z) {
        if (this.f9919l != null) {
            axi.m7357a(this.f9919l, this.f9914g, true);
            this.f9919l = null;
            this.f9916i = 300;
            if (z) {
                this.f9917j = 300;
            }
            ((AudioManager) this.f9884D.getSystemService(Context.AUDIO_SERVICE)).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    /* renamed from: h */
    public boolean mo17500h() {
        return this.f9916i == 301;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m11231p() && this.f9925r != null) {
            m11229o();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (m11231p() && this.f9925r != null) {
            m11229o();
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (m11231p() && z && this.f9925r != null) {
            if (i == 79 || i == 85) {
                if (this.f9919l.isPlaying()) {
                    pause();
                    this.f9925r.show();
                } else {
                    start();
                    this.f9925r.hide();
                }
                return true;
            } else if (i == 126) {
                if (!this.f9919l.isPlaying()) {
                    start();
                    this.f9925r.hide();
                }
                return true;
            } else if (i == 86 || i == 127) {
                if (this.f9919l.isPlaying()) {
                    pause();
                    this.f9925r.show();
                }
                return true;
            } else {
                m11229o();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: o */
    private void m11229o() {
        if (this.f9925r.isShowing()) {
            this.f9925r.hide();
        } else {
            this.f9925r.show();
        }
    }

    public void start() {
        if (m11231p()) {
            this.f9919l.start();
            this.f9916i = 303;
        }
        this.f9917j = 303;
    }

    public void pause() {
        if (m11231p() && this.f9919l.isPlaying()) {
            this.f9919l.pause();
            this.f9916i = 304;
        }
        this.f9917j = 304;
    }

    public int getDuration() {
        if (m11231p()) {
            return (int) this.f9919l.getDuration();
        }
        return -1;
    }

    public int getCurrentPosition() {
        if (m11231p()) {
            return (int) this.f9919l.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (m11231p()) {
            this.f9891K = System.currentTimeMillis();
            this.f9919l.seekTo((long) i);
            this.f9933z = 0;
            return;
        }
        this.f9933z = i;
    }

    public void setSeekWhenPrepared(int i) {
        this.f9933z = i;
    }

    public boolean isPlaying() {
        return m11231p() && this.f9919l.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.f9919l != null) {
            return this.f9930w;
        }
        return 0;
    }

    /* renamed from: j */
    public boolean mo17503j() {
        return this.f9918k == null;
    }

    /* renamed from: p */
    private boolean m11231p() {
        return (this.f9919l == null || this.f9916i == 299 || this.f9916i == 300 || this.f9916i == 301) ? false : true;
    }

    public boolean canPause() {
        return this.f9881A;
    }

    public boolean canSeekBackward() {
        return this.f9882B;
    }

    public boolean canSeekForward() {
        return this.f9883C;
    }

    public int getAudioSessionId() {
        if (this.f9919l == null) {
            return 0;
        }
        return this.f9919l.getAudioSessionId();
    }

    public C2482f getSettings() {
        return this.f9885E;
    }

    /* renamed from: k */
    public int toggleAspectRatio() {
        this.mCurrentAspectRatioIndex++;
        this.mCurrentAspectRatioIndex %= s_allAspectRatio.length;
        this.f9905ab = s_allAspectRatio[this.mCurrentAspectRatioIndex];
        if (this.mRenderView != null) {
            this.mRenderView.setAspectRatio(this.f9905ab);
        }
        return this.f9905ab;
    }

    /* renamed from: a */
    public int mo17472a(int i) {
        int[] iArr = s_allAspectRatio;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length && iArr[i3] != i) {
            i4++;
            i3++;
        }
        if (i4 < s_allAspectRatio.length) {
            i2 = i4;
        }
        this.mCurrentAspectRatioIndex = i2;
        this.f9905ab = s_allAspectRatio[i2];
        if (this.mRenderView != null) {
            this.mRenderView.setAspectRatio(this.f9905ab);
        }
        return this.f9905ab;
    }

    /* renamed from: e */
    private IMediaPlayer m11211e(int i) {
        return m11196a(i, this.f9885E, this.f9913f, false, this.f9908ae);
    }

    /* renamed from: a */
    public static IMediaPlayer m11196a(int i, C2482f fVar, Uri uri, boolean z, avp avp) {
        return new IjkExoMediaPlayer(MyApplication.getApplicationContext_());
    }

    public ITrackInfo[] getTrackInfo() {
        if (this.f9919l == null) {
            return null;
        }
        return this.f9919l.getTrackInfo();
    }

    public void setFinishFlag(boolean z) {
        this.f9907ad = true;
    }

    public void setOnAudioSessionIdListener(avp avp) {
        this.f9908ae = avp;
    }
}
