package com.abhishek.inplayer.widget;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.abhishek.inplayer.bean.VideoPlayListBean;
import com.abhishek.xplayer.activities.EqualizerActivity;
import com.abhishek.xplayer.activities.PlayerActivity;
import com.abhishek.xplayer.activities.SimpleFragmentActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.RecentMediaStorage;
import com.abhishek.xplayer.service.C2779a;
import com.abhishek.xplayer.service.C2787b;
import com.abhishek.xplayer.service.StartPipPlayService;
import com.abhishek.xplayer.subtitle.C2796a;
import com.abhishek.xplayer.subtitle.C2822c;
import com.abhishek.xplayer.subtitle.SubtitleSelectorFragment;
import com.abhishek.xplayer.subtitle.C2835e;
import com.abhishek.xplayer.subtitle.C2839f;
import com.abhishek.xplayer.subtitle.C2840g;
import com.abhishek.xplayer.subtitle.SubtitleImageView;
import com.abhishek.xplayer.subtitle.SubtitleTextView;
import com.abhishek.xplayer.utils.widget.PopupWindowView;
import com.mopub.common.Constants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import classesdef.ads.atd;
import classesdef.eventbus.awn;
import classesdef.inplayer.avp;
import classesdef.inplayer.awt;
import classesdef.inplayer.awz;
import classesdef.inplayer.axc;
import classesdef.inplayer.axi;
import classesdef.inplayer.SharedPrefrence;
import classesdef.player.avs;
import classesdef.player.awo;
import classesdef.player.aww;
import classesdef.player.axg;
import classesdef.player.DefaultSharedPreferences;
import classesdef.player.axt;

import classesdef.xdplayer.awy;
import classesdef.xdplayer.axe;
import classesdef.xdplayer.PermissionHelper;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import hdplayer.xdplayer.videoplayer.R;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;


/* renamed from: com.inshot.inplayer.widget.g */
public class C2483g implements awz.C1324b, axg.C1345a, C2481e {

    /* renamed from: a */
    private static final String f9960a = "f";

    /* renamed from: A */
    private final View f9961A;

    /* renamed from: B */
    private final View f9962B;

    /* renamed from: C */
    private final View f9963C;

    /* renamed from: D */
    private final View f9964D;

    /* renamed from: E */
    private final View f9965E;

    /* renamed from: F */
    private final TextView f9966F;

    /* renamed from: G */
    private final ImageView f9967G;

    /* renamed from: H */
    private final View f9968H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public final View f9969I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public final View f9970J;

    /* renamed from: K */
    private final TextView f9971K;

    /* renamed from: L */
    private final ProgressBar f9972L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public final View f9973M;

    /* renamed from: N */
    private final TextView f9974N;

    /* renamed from: O */
    private final TextView f9975O;

    /* renamed from: P */
    private final ImageView f9976P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public final View f9977Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public final View f9978R;

    /* renamed from: S */
    private final TextView f9979S;

    /* renamed from: T */
    private final TextView f9980T;

    /* renamed from: U */
    private final ProgressBar f9981U;

    /* renamed from: V */
    private final TextView f9982V;

    /* renamed from: W */
    private final View f9983W;

    /* renamed from: X */
    private final TextView f9984X;

    /* renamed from: Y */
    private final ImageView f9985Y;

    /* renamed from: Z */
    private final ImageView f9986Z;

    /* renamed from: aA */
    private int f9987aA = -1;
    /* access modifiers changed from: private */

    /* renamed from: aB */
    public final int f9988aB;

    /* renamed from: aC */
    private int f9989aC;

    /* renamed from: aD */
    private float f9990aD = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: aE */
    public String f9991aE;

    /* renamed from: aF */
    private String f9992aF;

    /* renamed from: aG */
    private String f9993aG;

    /* renamed from: aH */
    private Boolean f9994aH = null;
    /* access modifiers changed from: private */

    /* renamed from: aI */
    public boolean f9995aI;
    /* access modifiers changed from: private */

    /* renamed from: aJ */
    public boolean f9996aJ;
    /* access modifiers changed from: private */

    /* renamed from: aK */
    public boolean f9997aK;

    /* renamed from: aL */
    private boolean f9998aL;
    /* access modifiers changed from: private */

    /* renamed from: aM */
    public boolean f9999aM;
    /* access modifiers changed from: private */

    /* renamed from: aN */
    public boolean f10000aN;
    /* access modifiers changed from: private */

    /* renamed from: aO */
    public boolean f10001aO = true;

    /* renamed from: aP */
    private boolean f10002aP;

    /* renamed from: aQ */
    private final AudioManager f10003aQ;

    /* renamed from: aR */
    private boolean f10004aR;
    /* access modifiers changed from: private */

    /* renamed from: aS */
    public boolean f10005aS;

    /* renamed from: aT */
    private int f10006aT = 0;
    /* access modifiers changed from: private */

    /* renamed from: aU */
    public ArrayList<VideoPlayListBean> f10007aU;

    /* renamed from: aV */
    private String f10008aV;
    /* access modifiers changed from: private */

    /* renamed from: aW */
    public int f10009aW;
    /* access modifiers changed from: private */

    /* renamed from: aX */
    public axt f10010aX;


    /* renamed from: aZ */
    private boolean f10012aZ;

    /* renamed from: aa */
    private final AppCompatImageView f10013aa;

    /* renamed from: ab */
    private final View f10014ab;

    /* renamed from: ac */
    private final View f10015ac;

    /* renamed from: ad */
    private final View f10016ad;

    /* renamed from: ae */
    private final View f10017ae;

    /* renamed from: af */
    private int f10018af;

    /* renamed from: ag */
    private final ImageView f10019ag;

    /* renamed from: ah */
    private final AppCompatImageView f10020ah;

    /* renamed from: ai */
    private final AppCompatImageView f10021ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public final AppCompatImageView f10022aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public final TextView f10023ak;

    /* renamed from: al */
    private final View f10024al;

    /* renamed from: am */
    private final SeekBar f10025am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public final View f10026an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public final RecyclerView f10027ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public final ImageView f10028ap;

    /* renamed from: aq */
    private final TextView f10029aq;

    /* renamed from: ar */
    private final int f10030ar;

    /* renamed from: as */
    private final int f10031as;

    /* renamed from: at */
    private int f10032at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public final TextView f10033au;

    /* renamed from: av */
    private final TextView f10034av;
    /* access modifiers changed from: private */

    /* renamed from: aw */
    public int f10035aw = 300;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public int f10036ax;
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public long f10037ay = -1;

    /* renamed from: az */
    private int f10038az = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f10039b;
    /* access modifiers changed from: private */

    /* renamed from: bA */
    public boolean f10040bA;

    /* renamed from: bB */
    private boolean f10041bB = true;

    /* renamed from: bC */
    private boolean f10042bC = false;

    /* renamed from: bD */
    private long f10043bD = 0;
    /* access modifiers changed from: private */

    /* renamed from: bE */
    public boolean f10044bE;
    /* access modifiers changed from: private */

    /* renamed from: bF */
    public boolean f10045bF;
    /* access modifiers changed from: private */

    /* renamed from: bG */
    public boolean f10046bG;
    /* access modifiers changed from: private */

    /* renamed from: bH */
    public int f10047bH;
    /* access modifiers changed from: private */

    /* renamed from: bI */
    public int f10048bI;

    /* renamed from: bJ */
    private long f10049bJ;

    /* renamed from: bK */
    private String f10050bK = null;
    /* access modifiers changed from: private */

    /* renamed from: bL */
    public HashMap<String, String> f10051bL = null;
    /* access modifiers changed from: private */

    /* renamed from: bM */
    public boolean f10052bM;
    /* access modifiers changed from: private */

    /* renamed from: bN */
    public PopupWindow f10053bN;

    /* renamed from: bO */
    private PopupWindowView f10054bO;

    /* renamed from: bP */
    private RecentMediaStorage f10055bP;
    /* access modifiers changed from: private */

    /* renamed from: bQ */
    public PopupWindow f10056bQ;
    /* access modifiers changed from: private */

    /* renamed from: bR */
    public boolean f10057bR = false;
    /* access modifiers changed from: private */

    /* renamed from: bS */
    public PopupWindow f10058bS;
    /* access modifiers changed from: private */

    /* renamed from: bT */
    public String f10059bT;
    /* access modifiers changed from: private */

    /* renamed from: bU */
    public C2796a f10060bU;

    /* renamed from: bV */
    private C2835e f10061bV;

    /* renamed from: bW */
    private boolean f10062bW = false;

    /* renamed from: bX */
    private int f10063bX = 10;

    /* renamed from: bY */
    private boolean f10064bY = false;

    /* renamed from: bZ */
    private boolean f10065bZ = false;
    /* access modifiers changed from: private */

    /* renamed from: ba */
    public boolean f10066ba;

    /* renamed from: bb */
    private boolean f10067bb;
    /* access modifiers changed from: private */

    /* renamed from: bc */
    public C2822c f10068bc;
    /* access modifiers changed from: private */

    /* renamed from: bd */
    public C2840g f10069bd;
    /* access modifiers changed from: private */

    /* renamed from: be */
    public SubtitleTextView f10070be;
    /* access modifiers changed from: private */

    /* renamed from: bf */
    public SubtitleImageView f10071bf;
    /* access modifiers changed from: private */

    /* renamed from: bg */
    public awo f10072bg;

    /* renamed from: bh */
    private int f10073bh;

    /* renamed from: bi */
    private RecentMediaStorage.ExInfo f10074bi;
    /* access modifiers changed from: private */

    /* renamed from: bj */
    public int f10075bj = -2;
    /* access modifiers changed from: private */

    /* renamed from: bk */
    public String f10076bk;

    /* renamed from: bl */
    private C2839f f10077bl;

    /* renamed from: bm */
    private int f10078bm = -1;
    /* access modifiers changed from: private */

    /* renamed from: bn */
    public int f10079bn = -2;
    /* access modifiers changed from: private */

    /* renamed from: bo */
    public String f10080bo;

    /* renamed from: bp */
    private String f10081bp;

    /* renamed from: bq */
    private int f10082bq;
    /* access modifiers changed from: private */

    /* renamed from: br */
    public boolean f10083br;
    /* access modifiers changed from: private */

    /* renamed from: bs */
    public C2526d f10084bs;
    /* access modifiers changed from: private */

    /* renamed from: bt */
    public boolean f10085bt = false;
    /* access modifiers changed from: private */

    /* renamed from: bu */
    public Handler f10086bu = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (!C2483g.this.f10046bG && C2483g.this.f10092c != null && !C2483g.this.f10092c.isFinishing()) {
                int i = message.what;
                if (i == 1) {
                    long J = C2483g.this.m11331V();
                    if (C2483g.this.f9996aJ && !C2483g.this.f9999aM) {
                        sendMessageDelayed(obtainMessage(1), 1000 - (J % 1000));
                        C2483g.this.m11334W();
                    }
                } else if (i != 8) {
                    if (i != 11) {
                        switch (i) {
                            case 3:
                                if (!C2483g.this.f9995aI && C2483g.this.f10037ay >= 0) {
                                    int unused = C2483g.this.f10036ax = (int) C2483g.this.f10037ay;
                                    C2483g.this.f10102d.seekTo((int) C2483g.this.f10037ay);
                                    long unused2 = C2483g.this.f10037ay = -1;
                                    return;
                                }
                                return;
                            case 4:
                                int unused3 = C2483g.this.f10047bH = C2483g.this.f10048bI = 0;
                                C2483g.this.f9977Q.setVisibility(View.GONE);
                                C2483g.this.f9978R.setVisibility(View.GONE);
                                C2483g.this.f9969I.setVisibility(View.GONE);
                                C2483g.this.f9970J.setVisibility(View.GONE);
                                C2483g.this.f9973M.setVisibility(View.GONE);
                                C2483g.this.m11321Q();
                                return;
                            case 5:
                                int unused4 = C2483g.this.f10035aw = 299;
                                C2483g.this.mo17576f();
                                C2483g.this.m11334W();
                                return;
                            default:
                                return;
                        }
                    } else {
                        C2483g.this.m11349a(message.arg1, message.arg2);
                    }
                } else if (C2483g.this.f10083br) {
                    long tcpSpeed = C2483g.this.f10102d.getTcpSpeed();
                    if (tcpSpeed >= 0) {
                        C2483g.this.f10023ak.setText(axi.m7352a(tcpSpeed, 1000));
                    }
                    sendMessageDelayed(obtainMessage(8), 500);
                }
            }
        }
    };

    /* renamed from: bv */
    private Runnable f10087bv = new Runnable() {
        public void run() {
            if (!C2483g.this.f10046bG && !C2483g.this.f9999aM && C2483g.this.f10102d.isPlaying() && C2483g.this.f10026an.getVisibility() != 0) {
                C2483g.this.f10010aX.mo11004c();
            }
        }
    };

    /* renamed from: bw */
    private avs f10088bw;

    /* renamed from: bx */
    private final View.OnClickListener f10089bx = new View.OnClickListener() {
        public void onClick(View view) {
            if (!C2483g.this.f10046bG) {
                if (view.getId() == R.id.app_video_menu) {
                    C2483g.this.m11353a(view);
                    C2483g.this.m11378ab();
                } else if (view.getId() == R.id.app_video_list) {
                    LogEvents.m18492b("PlayPage", "PlayList");
                    if (C2483g.this.f10072bg != null) {
                        C2483g.this.f10072bg.mo10862a();
                    }
                    C2483g.this.m11466n(true);
                    C2483g.this.m11378ab();
                } else if (view.getId() == R.id.rotation) {
                    LogEvents.m18492b("PlayPage", "Rotate");
                    C2483g.this.m11325S();
                } else if (view.getId() == R.id.bg_ripple_night_mode) {
                    LogEvents.m18492b("PlayPage", "NightMode");
                    C2483g.this.m11460l(true);
                    C2483g.this.m11376aa();
                } else if (view.getId() == R.id.mute) {
                    LogEvents.m18492b("PlayPage", "Mute");
                    C2483g.this.m11464m(false);
                    C2483g.this.m11376aa();
                } else if (view.getId() == R.id.bg_ripple_audio_mode) {
                    C2483g.this.m11441g("");
                    C2483g.this.m11376aa();
                } else if (view.getId() == R.id.bg_ripple_pip_mode) {
                    LogEvents.m18492b("PlayPage", "Pip");
                    if (!C2483g.this.m11292B()) {
                        C2483g.this.m11294C();
                    }
                    if (view.getTag() instanceof View) {
                        ((View) view.getTag()).setVisibility(8);
                        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt("pipNew", 1).apply();
                    }
                } else if (view.getId() == R.id.bg_ripple_timer_container) {
                    LogEvents.m18492b("PlayPage", "Timer");
                    C2483g.this.m11289A();
                    boolean unused = C2483g.this.f10057bR = true;
                } else if (view.getId() == R.id.brightness) {
                    LogEvents.m18492b("PlayPage", "Brightness");
                    C2483g.this.m11457k(true);
                    boolean unused2 = C2483g.this.f10057bR = true;
                } else if (view.getId() == R.id.sound) {
                    LogEvents.m18492b("PlayPage", "Volume");
                    C2483g.this.m11457k(false);
                    boolean unused3 = C2483g.this.f10057bR = true;
                } else if (view.getId() == R.id.app_video_scale_type) {
                    LogEvents.m18484a("PlayPage", "ScaleType");
                    C2483g unused4 = C2483g.this.m11488u();
                    C2483g.this.m11376aa();
                } else if (view.getId() == R.id.app_video_play || view.getId() == R.id.play_icon) {
                    if (C2483g.this.f10102d.isPlaying()) {
                        C2483g.this.f10092c.mo17679a(false);
                        C2483g.this.f10092c.mo17680b();
                        C2483g.this.f10092c.mo17681c();
                        LogEvents.m18484a("PlayPage", "Pause");
                        if (C2483g.this.f9995aI) {
                            C2483g.this.f10102d.mo17486f();
                        } else {
                            C2483g.this.m11442g(true);
                        }
                    } else {
                        C2483g.this.f10092c.mo17679a(true);
                        C2483g.this.f10092c.mo17676a();
                        C2483g.this.f10092c.mo17682d();
                        LogEvents.m18484a("PlayPage", "Play");
                        C2483g.this.mo17576f();
                        if (C2483g.this.f10102d.isPlaying()) {
                            int unused5 = C2483g.this.f10035aw = 301;
                            C2483g.this.m11313M();
                        }
                    }
                    C2483g.this.m11334W();
                    C2483g.this.m11376aa();
                } else if (view.getId() == R.id.video_next) {
                    LogEvents.m18484a("PlayPage", "Next");
                    if (!C2483g.this.m11480r(true)) {
                        axv.m7434a((int) R.string.no_next_video);
                    }
                    C2483g.this.m11376aa();
                } else if (view.getId() == R.id.video_previous) {
                    LogEvents.m18484a("PlayPage", "Previous");
                    if (!C2483g.this.m11484s(true)) {
                        axv.m7434a((int) R.string.no_previous_video);
                    }
                    C2483g.this.m11376aa();
                } else if (view.getId() == R.id.app_video_finish) {
                    C2483g.this.f10092c.finish();
                } else if (view.getId() == R.id.app_video_replay_icon) {
                    int unused6 = C2483g.this.f10035aw = 299;
                    C2483g.this.m11313M();
                    C2483g.this.mo17576f();
                    C2483g.this.m11334W();
                } else if (view.getId() == R.id.app_video_lock) {
                    LogEvents.m18484a("PlayPage", "Lock");
                    if (!C2483g.this.f9997aK) {
                        boolean unused7 = C2483g.this.f9997aK = true;
                        C2483g.this.m11450i(true);
                        C2483g.this.f10022aj.setVisibility(0);
                        int i = C2483g.this.f10092c.getResources().getConfiguration().orientation;
                        if (i == 2) {
                            C2483g.this.f10092c.setRequestedOrientation(6);
                        } else if (i == 1) {
                            C2483g.this.f10092c.setRequestedOrientation(7);
                        } else {
                            C2483g.this.f10092c.setRequestedOrientation(14);
                        }
                        C2483g.this.m11376aa();
                        axv.m7434a((int) R.string.locked);
                        C2483g.this.f10010aX.mo11001a(true);
                    }
                } else if (view.getId() == R.id.app_video_locked) {
                    LogEvents.m18484a("PlayPage", "Unlock");
                    boolean unused8 = C2483g.this.f9997aK = false;
                    C2483g.this.f10022aj.setVisibility(8);
                    C2483g.this.f10010aX.mo11005d();
                    C2483g.this.f10092c.setRequestedOrientation(aww.f6159e[C2483g.this.f10093ca]);
                } else if (view.getId() == R.id.down_btn) {
                    boolean unused9 = C2483g.this.m11473p(true);
                } else if (view.getId() == R.id.panel_close) {
                    boolean unused10 = C2483g.this.m11309K();
                } else if (view.getId() == R.id.repeat_mode) {
                    C2483g.this.m11311L();
                }
            }
        }
    };

    /* renamed from: by */
    private final SeekBar.OnSeekBarChangeListener f10090by = new SeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (!C2483g.this.f10046bG && C2483g.this.f9999aM && z) {
                long aa = C2483g.this.m11498y();
                long round = (long) Math.round(((float) (((long) i) * aa)) / 1000.0f);
                C2483g.this.f10033au.setText(C2483g.this.m11406b(round));
                if (C2483g.this.f10085bt) {
                    long j = aa - round;
                    C2483g.this.f10121w.setText(String.format(Locale.ENGLISH, "%02d:%02d", new Object[]{Long.valueOf(j / 60000), Long.valueOf((j / 1000) % 60)}));
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (!C2483g.this.f10046bG) {
                boolean unused = C2483g.this.f9999aM = true;
                C2483g.this.f10086bu.removeMessages(1);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!C2483g.this.f10046bG && C2483g.this.f9999aM) {
                int unused = C2483g.this.f10036ax = (int) ((((double) (C2483g.this.m11498y() * ((long) seekBar.getProgress()))) * 1.0d) / 1000.0d);
                C2483g.this.f10102d.seekTo(C2483g.this.f10036ax);
                boolean unused2 = C2483g.this.f9999aM = false;
                C2483g.this.f10086bu.removeMessages(1);
                C2483g.this.f10086bu.sendEmptyMessageDelayed(1, 1000);
                C2483g.this.m11477r();
            }
        }
    };

    /* renamed from: bz */
    private boolean f10091bz;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final PlayerActivity f10092c;
    /* access modifiers changed from: private */

    /* renamed from: ca */
    public int f10093ca = 0;

    /* renamed from: cb */
    private boolean f10094cb;
    /* access modifiers changed from: private */

    /* renamed from: cc */
    public boolean f10095cc;

    /* renamed from: cd */
    private View f10096cd;

    /* renamed from: ce */
    private boolean f10097ce = false;
    /* access modifiers changed from: private */

    /* renamed from: cf */
    public boolean f10098cf = false;
    /* access modifiers changed from: private */

    /* renamed from: cg */
    public TextView f10099cg;

    /* renamed from: ch */
    private Runnable f10100ch = new Runnable() {
        public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500);
            C2483g.this.f10099cg.setAnimation(alphaAnimation);
            C2483g.this.f10099cg.setVisibility(8);
        }
    };

    /* renamed from: ci */
    private C2525c f10101ci;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final XVideoView f10102d;

    /* renamed from: e */
    private final ViewGroup f10103e;

    /* renamed from: f */
    private final View f10104f;

    /* renamed from: g */
    private final View f10105g;

    /* renamed from: h */
    private final View f10106h;

    /* renamed from: i */
    private final View f10107i;

    /* renamed from: j */
    private final ImageView f10108j;

    /* renamed from: k */
    private final TextView f10109k;

    /* renamed from: l */
    private final ImageView f10110l;

    /* renamed from: m */
    private final ImageView f10111m;

    /* renamed from: n */
    private final ImageView f10112n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final ImageView f10113o;

    /* renamed from: p */
    private final ImageView f10114p;

    /* renamed from: q */
    private final ImageView f10115q;

    /* renamed from: r */
    private final ViewGroup f10116r;

    /* renamed from: s */
    private final ViewGroup f10117s;

    /* renamed from: t */
    private final ViewGroup f10118t;

    /* renamed from: u */
    private final ViewGroup f10119u;

    /* renamed from: v */
    private final ViewGroup f10120v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final TextView f10121w;

    /* renamed from: x */
    private final PlayerToolsBarHorizontalScrollView f10122x;

    /* renamed from: y */
    private final ViewGroup f10123y;

    /* renamed from: z */
    private final View f10124z;

    /* renamed from: f */
    private static String m11432f(int i) {
        switch (i) {
            case 0:
                return "Order";
            case 1:
                return "Shuffle";
            case 2:
                return "Repeat";
            case 3:
                return "Loop";
            default:
                return null;
        }
    }

    /* renamed from: d */
    public C2483g mo17570d(boolean z) {
        return this;
    }

    public C2483g(final PlayerActivity playerActivity, final axt axt) {
        this.f10092c = playerActivity;
        this.f10039b = playerActivity;
        EventBus.getDefault().register((Object) this);
        this.f10003aQ = (AudioManager) this.f10039b.getSystemService("audio");
        this.f9988aB = this.f10003aQ.getStreamMaxVolume(3);
        this.f10103e = (ViewGroup) this.f10092c.findViewById(R.id.app_video_box);
        this.f10104f = this.f10103e.findViewById(R.id.coordinatorLayout);
        this.f10102d = (XVideoView) this.f10092c.findViewById(R.id.video_view);
        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("w9Q6yw1K", false)) {
            this.f10038az = this.f10102d.mo17472a(DefaultSharedPreferences.m7386b("kmgJSgyY", this.f10038az));
        }

     /*   float f = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("rememberBright", true) ? PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getFloat("brightness", 0.5f) : 0.5f;
        if (f > 1.0f) {
            f = 1.0f;
        } else if (((double) f) < 0.01d) {
            f = 0.01f;
        }
        WindowManager.LayoutParams attributes = this.f10092c.getWindow().getAttributes();
        attributes.screenBrightness = f;
      */

     /*   WindowManager.LayoutParams attributes = this.f10092c.getWindow().getAttributes();
        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("rememberBright", true)) {
            double a = (double) atd.m18386a("brightness", 0.5f);
            attributes.screenBrightness = (a > 1.001d || a < 0.009d) ? 0.5f : f;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
*/

        WindowManager.LayoutParams attributes = this.f10092c.getWindow().getAttributes();
        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("rememberBright", true)) {
            float a = atd.m18386a("brightness", 0.5f);
            if (a > 1.0f || ((double) a) < 0.01d) {
                a = 0.5f;
            }
            attributes.screenBrightness = a;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }


        this.f10092c.getWindow().setAttributes(attributes);
        this.f10105g = this.f10092c.findViewById(R.id.app_video_top_box);
        this.f10106h = this.f10092c.findViewById(R.id.ll_bottom_bar);
        this.f10107i = this.f10106h.findViewById(R.id.bottom_bar);
        View findViewById = this.f10092c.findViewById(R.id.app_video_finish);
        this.f9985Y = (ImageView) this.f10092c.findViewById(R.id.app_video_menu);
        this.f9986Z = (ImageView) this.f10092c.findViewById(R.id.app_video_list);
        this.f10013aa = (AppCompatImageView) this.f10092c.findViewById(R.id.app_video_play);
        this.f10014ab = this.f10092c.findViewById(R.id.video_next);
        this.f10015ac = this.f10092c.findViewById(R.id.video_previous);
        this.f10017ae = this.f10092c.findViewById(R.id.video_ff10);
        this.f10016ad = this.f10092c.findViewById(R.id.video_fb10);
        this.f10019ag = (ImageView) this.f10092c.findViewById(R.id.play_icon);
        this.f10108j = (ImageView) this.f10092c.findViewById(R.id.rotation);
        this.f10109k = (TextView) this.f10092c.findViewById(R.id.rotation_text);
        this.f10110l = (ImageView) this.f10092c.findViewById(R.id.night_mode);
        this.f10111m = (ImageView) this.f10092c.findViewById(R.id.mute);
        this.f10112n = (ImageView) this.f10092c.findViewById(R.id.audio_mode);
        this.f10113o = (ImageView) this.f10092c.findViewById(R.id.timer);
        this.f10114p = (ImageView) this.f10092c.findViewById(R.id.brightness);
        this.f10115q = (ImageView) this.f10092c.findViewById(R.id.sound);
        this.f10117s = (ViewGroup) this.f10092c.findViewById(R.id.container_rotate);
        this.f10118t = (ViewGroup) this.f10092c.findViewById(R.id.container_night_mode);
        this.f10119u = (ViewGroup) this.f10092c.findViewById(R.id.container_audio_mode);
        this.f10120v = (ViewGroup) this.f10092c.findViewById(R.id.container_timer);
        this.f10116r = (ViewGroup) this.f10092c.findViewById(R.id.display_container);
        this.f10121w = (TextView) this.f10092c.findViewById(R.id.timer_value);
        this.f10122x = (PlayerToolsBarHorizontalScrollView) this.f10092c.findViewById(R.id.container_scroll);
        if (!aww.f6164j) {
            this.f10122x.findViewById(R.id.pip_mode_layout).setVisibility(8);
        }
        this.f10123y = (ViewGroup) this.f10122x.findViewById(R.id.container_out);
        this.f10124z = this.f10122x.findViewById(R.id.bg_ripple_night_mode);
        this.f9961A = this.f10122x.findViewById(R.id.bg_ripple_audio_mode);
        this.f9962B = this.f10122x.findViewById(R.id.bg_ripple_pip_mode);
        this.f9963C = this.f10122x.findViewById(R.id.bg_ripple_timer_container);
        this.f10020ah = (AppCompatImageView) this.f10092c.findViewById(R.id.app_video_scale_type);
        this.f10021ai = (AppCompatImageView) this.f10092c.findViewById(R.id.app_video_lock);
        this.f10022aj = (AppCompatImageView) this.f10092c.findViewById(R.id.app_video_locked);
        this.f10023ak = (TextView) this.f10092c.findViewById(R.id.app_video_speed);
        this.f10024al = this.f10092c.findViewById(R.id.app_video_loading);
        this.f10025am = (SeekBar) this.f10092c.findViewById(R.id.app_video_seekBar);
        this.f10026an = this.f10092c.findViewById(R.id.play_list_container);
        this.f10027ao = (RecyclerView) this.f10092c.findViewById(R.id.play_list_view);
       // this.f10011aY = (FunnyAdEntryImageView) this.f10092c.findViewById(R.id.funny_ad);
        this.f10070be = (SubtitleTextView) this.f10092c.findViewById(R.id.subtitle_text);
        this.f10099cg = (TextView) this.f10092c.findViewById(R.id.center_toast);
        this.f10033au = (TextView) this.f10092c.findViewById(R.id.app_video_currentTime);
        this.f10034av = (TextView) this.f10092c.findViewById(R.id.app_video_endTime);
        this.f9964D = this.f10092c.findViewById(R.id.thumb_layout);
        this.f9965E = this.f9964D.findViewById(R.id.arrow_down);
        this.f9966F = (TextView) this.f10092c.findViewById(R.id.text_progress);
        this.f9967G = (ImageView) this.f10092c.findViewById(R.id.thumb);
        this.f9968H = this.f10092c.findViewById(R.id.app_video_replay);
        this.f9969I = this.f10092c.findViewById(R.id.app_video_brightness_box);
        this.f9970J = this.f10092c.findViewById(R.id.brightness_progress_layout);
        this.f9983W = this.f10092c.findViewById(R.id.app_video_process_panl);
        View findViewById2 = this.f10092c.findViewById(R.id.app_video_replay_icon);
        this.f9973M = this.f10092c.findViewById(R.id.app_video_fastForward_box);
        this.f9977Q = this.f10092c.findViewById(R.id.app_video_volume_box);
        this.f9978R = this.f10092c.findViewById(R.id.sound_progress_layout);
        this.f9971K = (TextView) this.f10092c.findViewById(R.id.app_video_brightness);
        this.f9974N = (TextView) this.f10092c.findViewById(R.id.app_video_fastForward);
        this.f9975O = (TextView) this.f10092c.findViewById(R.id.app_video_fastForward_all);
        this.f9984X = (TextView) this.f10092c.findViewById(R.id.app_video_status_text);
        this.f9979S = (TextView) this.f10092c.findViewById(R.id.app_video_volume);
        this.f9980T = (TextView) this.f10092c.findViewById(R.id.app_video_volume_boost);
        this.f9982V = (TextView) this.f10092c.findViewById(R.id.app_video_volume_text);
        this.f9981U = (ProgressBar) this.f10092c.findViewById(R.id.sound_progress);
        this.f9972L = (ProgressBar) this.f10092c.findViewById(R.id.brightness_progress);
        this.f9976P = (ImageView) this.f10092c.findViewById(R.id.app_video_volume_icon);
        this.f10028ap = (ImageView) this.f10026an.findViewById(R.id.repeat_mode);
        this.f10029aq = (TextView) this.f10026an.findViewById(R.id.repeat_mode_text);
        this.f10028ap.setOnClickListener(this.f10089bx);
        int min = (int) (((double) Math.min(this.f10092c.getResources().getDisplayMetrics().widthPixels, this.f10092c.getResources().getDisplayMetrics().heightPixels)) * 0.45d);
        this.f10030ar = Math.max(axw.m7444a(MyApplication.getApplicationContext_(), 400.0f), min);
        this.f10031as = Math.max(axw.m7444a(MyApplication.getApplicationContext_(), 300.0f), min);
        this.f10032at = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("sKrMspmkr", 0);
        this.f9981U.setMax(this.f9988aB);
        this.f10020ah.setImageResource(aww.f6163i[this.f10038az]);
        this.f10025am.setMax(1000);
        this.f10025am.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                C2483g.this.m11376aa();
                return false;
            }
        });
        this.f10025am.setOnSeekBarChangeListener(this.f10090by);
        this.f10013aa.setOnClickListener(this.f10089bx);
        this.f10014ab.setOnClickListener(this.f10089bx);
        this.f10015ac.setOnClickListener(this.f10089bx);
        this.f10019ag.setOnClickListener(this.f10089bx);
        this.f10020ah.setOnClickListener(this.f10089bx);
        this.f10108j.setOnClickListener(this.f10089bx);
        this.f10124z.setOnClickListener(this.f10089bx);
        this.f10111m.setOnClickListener(this.f10089bx);
        this.f9961A.setOnClickListener(this.f10089bx);
        this.f9962B.setOnClickListener(this.f10089bx);
        this.f10114p.setOnClickListener(this.f10089bx);
        this.f10115q.setOnClickListener(this.f10089bx);
        this.f9963C.setOnClickListener(this.f10089bx);
        findViewById.setOnClickListener(this.f10089bx);
        this.f9985Y.setOnClickListener(this.f10089bx);
        this.f10021ai.setOnClickListener(this.f10089bx);
        this.f10022aj.setOnClickListener(this.f10089bx);
        findViewById2.setOnClickListener(this.f10089bx);
        this.f10026an.findViewById(R.id.down_btn).setOnClickListener(this.f10089bx);
        this.f10102d.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
            /* renamed from: a */
            public boolean onInfo(IMediaPlayer avg, int i, int i2) {
                C2483g.this.m11449i(i);
                return true;
            }
        });
        this.f10102d.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            /* renamed from: b */
            public void onPrepared(IMediaPlayer avg) {
                if (!C2483g.this.f10046bG) {
                    if (C2483g.this.f10076bk != null && C2483g.this.f10076bk.equals(C2483g.this.f9991aE)) {
                        String unused = C2483g.this.f10076bk = null;
                        if (C2483g.this.f10075bj > -2) {
                            C2483g.this.m11350a(C2483g.this.f10075bj, true);
                        }
                        int unused2 = C2483g.this.f10075bj = -2;
                    }
                    if (C2483g.this.f10080bo != null && C2483g.this.f10080bo.equals(C2483g.this.f9991aE)) {
                        String unused3 = C2483g.this.f10080bo = null;
                        if (C2483g.this.f10079bn >= 0 && C2483g.this.f10102d.mo17483d(2) != C2483g.this.f10079bn) {
                            C2483g.this.f10102d.mo17477b(C2483g.this.f10079bn);
                            if (C2483g.this.f10095cc) {
                                C2483g.this.f10102d.setVolume(0.0f);
                            }
                        }
                        int unused4 = C2483g.this.f10079bn = -2;
                    }
                }
            }
        });
        this.f10102d.setOnAudioSessionIdListener(new avp() {
            /* renamed from: a */
            public void mo10817a(int i) {
                axi.m7354a();
                axi.m7355a(i);
            }
        });
       this.f10102d.setOnVideoFrameRenderedListener(new com.abhishek.inplayer.widget.IMediaPlayer.C1283h() {

            private int f10163b = -1;


            public void mo10732a() {
                Log.e("abhi_render","abhi_ 1 ");
                if (!C2483g.this.f10046bG) {
                    if (C2483g.this.f10044bE) {
                        C2483g.this.m11442g(false);
                        boolean unused = C2483g.this.f10044bE = false;
                        if (C2483g.this.f10045bF && C2483g.this.f10095cc) {
                            C2483g.this.m11464m(true);
                        }
                        boolean unused2 = C2483g.this.f10045bF = false;
                    }
                    if (C2483g.this.f10069bd != null) {
                        C2483g.this.f10069bd.mo18257b();
                    }
                    if (C2483g.this.f10069bd != null && !C2483g.this.f10069bd.mo18258c() && C2483g.this.f10068bc != null && C2483g.this.f10068bc.mo18218c()) {
                        int currentPosition = C2483g.this.f10102d.getCurrentPosition();
                        if (Math.abs(currentPosition - this.f10163b) > 50) {
                            this.f10163b = currentPosition;
                            List<C2822c.C2826b> a = C2483g.this.f10068bc.mo18214a((long) currentPosition);
                            if (a == null || a.isEmpty()) {
                                Log.e("abhi_render","abhi_ 2 "+String.valueOf("null"));
                                C2483g.this.f10070be.setTextCustom((CharSequence) null);
                                if (C2483g.this.f10071bf != null) {
                                    C2483g.this.f10071bf.mo18175a();
                                    return;
                                }
                                return;
                            }
                            StringBuilder sb = new StringBuilder();
                            for (C2822c.C2826b next : a) {
                                if (sb.length() > 0) {
                                    sb.append("<BR/>");
                                }
                                sb.append(next.f11228a);
                            }
                            Log.e("abhi_render","abhi_ 3 "+String.valueOf(Html.fromHtml(sb.toString())));
                            C2483g.this.f10070be.setTextCustom(Html.fromHtml(sb.toString()));
                        }
                    }
                }
            }
        });

        this.f10102d.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            /* renamed from: a */
            public boolean onError(IMediaPlayer avg, int i, int i2) {
                if (C2483g.this.f10046bG || playerActivity.isFinishing()) {
                    return true;
                }
                if (C2483g.this.f10083br) {
                    int size = C2483g.this.f10051bL == null ? 0 : C2483g.this.f10051bL.size();
                    Pair<String, HashMap<String, String>> e = axi.m7362e(C2483g.this.f9991aE);
                    HashMap hashMap = (HashMap) e.second;
                    if (hashMap != null) {
                        if (C2483g.this.f10051bL != null) {
                            hashMap.putAll(C2483g.this.f10051bL);
                        }
                        if (hashMap.size() > size) {
                            HashMap unused = C2483g.this.f10051bL = hashMap;
                            C2483g.this.m11494w();
                            C2483g.this.mo17561b((String) e.first);
                            C2483g.this.f10086bu.sendEmptyMessage(5);
                            return true;
                        }
                    }
                }
                boolean unused2 = C2483g.this.f10098cf = false;
                C2779a.m12613a().mo18136b((Context) C2483g.this.f10092c, true);
                C2483g.this.m11313M();
                if (axt != null) {
                    axt.mo11005d();
                }
                new AlertDialog.Builder(playerActivity).setMessage((int) R.string.VideoView_error_text_unknown).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        C2483g.this.f10092c.finish();
                    }
                }).setNegativeButton((int) R.string.feedback, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        awz.m7242a(playerActivity, true, C2483g.this, new DialogInterface.OnCancelListener() {
                            public void onCancel(DialogInterface dialogInterface) {
                                if (!C2483g.this.f10092c.isFinishing()) {
                                    C2483g.this.f10092c.finish();
                                }
                            }
                        });
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        if (!C2483g.this.f10092c.isFinishing()) {
                            C2483g.this.f10092c.finish();
                        }
                    }
                }).show();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("uri", C2483g.this.f9991aE);
                hashMap2.put("audioMode", String.valueOf(C2483g.this.f10098cf));
                LogEvents.m18493b("PlayFailed", C2483g.this.f10005aS ? "fromOtherApp" : "Local", hashMap2);
                return true;
            }
        });
        this.f10084bs = new C2526d();
        this.f10103e.setClickable(true);
        ViewGroup viewGroup = this.f10103e;
        C2525c cVar = new C2525c();
        this.f10101ci = cVar;
        viewGroup.setOnTouchListener(cVar);
        this.f10001aO = this.f10092c.isInMultiWindowMode() || axw.m7447a((Activity) this.f10092c);
        m11482s();
        m11486t();
        m11324R();
        this.f10010aX = axt;
        this.f10010aX.mo11000a((axt.C1363a) new axt.C1363a() {
            /* renamed from: a */
            public void mo11006a(boolean z) {
                if (!C2483g.this.f10046bG) {
                    int i = 0;
                    if (C2483g.this.f9997aK) {
                        AppCompatImageView y = C2483g.this.f10022aj;
                        if (!z) {
                            i = 8;
                        }
                        y.setVisibility(i);
                    } else if (z) {
                        C2483g.this.m11446h(false);
                    } else {
                        C2483g.this.m11450i(false);
                    }
                    if (z) {
                        C2483g.this.m11376aa();
                    }
                }
            }
        });
        this.f10102d.setOnTimedTextListener(new IMediaPlayer.OnTimedTextListener() {
            @Override
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {

            }
        });
        this.f10077bl = new C2839f(this.f10070be, this.f10001aO);
        this.f10122x.setItemWidth(this.f10092c.getResources().getDimensionPixelOffset(R.dimen.play_tool_width));
        this.f10122x.setSpaceView(this.f10122x.findViewById(R.id.space));
        this.f10122x.setMoreView(this.f10122x.findViewById(R.id.more));
        this.f10122x.setAutoHideViewId(R.id.auto_hide_view);
        this.f10122x.setPlayerToolBarScrollListener(new PlayerToolsBarHorizontalScrollView.C2461a() {
            /* renamed from: a */
            public void mo17438a(int i, int i2, int i3, int i4) {
                C2483g.this.m11376aa();
            }

            /* renamed from: a */
            public void mo17437a() {
                C2483g.this.m11376aa();
            }
        });
        if (awt.m7206b() && !PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).contains("pipNew")) {
            View findViewById3 = this.f9962B.findViewById(R.id.new_pip_dot);
            findViewById3.setVisibility(0);
            this.f9962B.setTag(findViewById3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m11477r() {
        if (this.f9964D.getVisibility() == 0) {
            this.f9964D.clearAnimation();
            this.f9964D.setAnimation(AnimationUtils.loadAnimation(MyApplication.getApplicationContext_(), 17432577));
            this.f9964D.setVisibility(8);
        }
    }

    /* renamed from: b */
    public void mo17563b() {
        if (this.f10092c.isFinishing()) {
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putFloat("brightness", this.f10092c.getWindow().getAttributes().screenBrightness).apply();
            DefaultSharedPreferences.m7383a("kmgJSgyY", this.f10038az);
        }
        if (this.f10043bD > 0) {
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putLong("watchTime", (System.currentTimeMillis() - this.f10043bD) + PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getLong("watchTime", 0)).apply();
        }
        this.f10102d.mo17484d();
        if (this.f10083br) {
            if (this.f10092c.isFinishing()) {
                if (!this.f10091bz) {
                    m11351a((long) m11496x());
                }
                this.f10102d.mo17475a(false);
                return;
            }
            this.f9994aH = Boolean.valueOf(this.f10102d.isPlaying());
            if (this.f9994aH.booleanValue()) {
                this.f10102d.pause();
            }
        } else if (this.f10042bC) {
            this.f10042bC = false;
        } else {
            this.f10042bC = false;
            if (this.f10102d.mo17500h()) {
                m11378ab();
                this.f10102d.mo17473a();
                return;
            }
            this.f10041bB = this.f10102d.mo17501i();
            m11378ab();
            this.f9994aH = Boolean.valueOf(this.f10102d.isPlaying());
            m11496x();
            if (!this.f10091bz) {
                m11351a((long) this.f10036ax);
            }
            this.f10102d.mo17473a();
            if (this.f10004aR && !this.f10066ba) {
                this.f10012aZ = true;
            }
        }
    }

    /* renamed from: c */
    public void mo17567c() {
        boolean z = this.f10067bb;
        this.f10067bb = false;
        this.f9989aC = this.f10003aQ.getStreamVolume(3);
        this.f10040bA = false;
        if (PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("showRateCount", 0) < 3 && !PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean("hasRated", false)) {
            this.f10043bD = System.currentTimeMillis();
        }
        this.f10102d.mo17478c();
        if (!this.f10083br) {
            this.f10066ba = false;
            if (!this.f10004aR || !this.f10012aZ) {
                if (this.f9994aH != null) {
                    if (this.f10074bi != null) {
                        if (this.f10074bi.f10542g >= 0) {
                            m11413b(this.f9991aE, this.f10074bi.f10542g);
                        }
                        if (this.f10074bi.f10539d >= -1) {
                            m11366a(this.f9991aE, this.f10074bi.f10539d);
                        }
                    }
                    this.f10102d.mo17476b();
                    if (!this.f10041bB) {
                        if (this.f9994aH.booleanValue()) {
                            this.f10102d.setRender(2);
                        } else {
                            this.f9998aL = true;
                        }
                    }
                    if (this.f9995aI) {
                        this.f10102d.seekTo(0);
                    } else {
                        this.f10102d.seekTo(this.f10036ax);
                    }
                    if (!this.f9994aH.booleanValue()) {
                        if (!this.f10102d.mo17503j()) {
                            m11442g(false);
                        } else {
                            if (!this.f10095cc) {
                                m11464m(true);
                                this.f10045bF = true;
                            }
                            this.f10044bE = true;
                            m11436f(true);
                        }
                    }
                    if (!this.f9994aH.booleanValue()) {
                        this.f10010aX.mo11005d();
                    } else {
                        this.f10010aX.mo11004c();
                    }
                }
                if (z) {
                    m11292B();
                    return;
                }
                return;
            }
            this.f10042bC = true;
            this.f10092c.startActivityForResult(new Intent(this.f10092c, SimpleFragmentActivity.class).putExtra("_mode", 1), 161);
        } else if (this.f9994aH != null && this.f9994aH.booleanValue()) {
            this.f10092c.mo17679a(true);
            this.f10092c.mo17676a();
            this.f10092c.mo17682d();
        }
    }

    /* renamed from: a */
    public void mo17556a(int i, int i2, Intent intent) {
        if (i == 161) {
            if (i2 != -1) {
                this.f10092c.setResult(323);
                this.f10092c.finish();
                return;
            }
            this.f10012aZ = false;
        } else if (i == 162) {
            this.f10067bb = true;
        }
    }

    /* renamed from: d */
    public void mo17571d() {
        HashMap hashMap = new HashMap();
        hashMap.put("repeat", m11432f(this.f10032at));
        LogEvents.m18497c("PlayerDestroy", this.f10098cf ? "BackPlayOn" : "BackPlayOff", hashMap);
        this.f10046bG = true;
        if (this.f10072bg != null) {
            this.f10072bg.mo10865b();
        }
        if (this.f10060bU != null) {
            this.f10060bU.mo18179a();
        }
        this.f10068bc = null;
        this.f10086bu.removeCallbacksAndMessages((Object) null);
      //  this.f10102d.setOnVideoFrameRenderedListener((IMediaPlayer.C1283h) null);
        EventBus.getDefault().unregister(this);
        boolean z = this.f10085bt;
        if (this.f10085bt) {
            this.f10085bt = false;
            if (!C2779a.m12613a().mo18135b()) {
                MyApplication.myApplication().mo17870a(false);
            }
        }
        axi.m7354a();
        this.f10102d.mo17486f();
        if (this.f10098cf) {
            C2779a.m12613a().mo18130a(this.f10092c, this.f10036ax, this.f9992aF, this.f9991aE, this.f10009aW, this.f10007aU, this.f10008aV, this.f10085bt, this.f10005aS, this.f10094cb, this.f10063bX, this.f10032at == 1, this.f10004aR);
        } else if (this.f10097ce) {
            StartPipPlayService.m12716a().mo18170a(this.f10092c, new C2787b(this.f9992aF, this.f9991aE, this.f10036ax, this.f10009aW, this.f10007aU, this.f10008aV, z, this.f10005aS, this.f10094cb, this.f10063bX, this.f10032at, this.f10004aR, this.f10051bL, this.f10074bi));
        }
    }

    /* renamed from: a */
    public void mo17558a(Bundle bundle) {
        bundle.putInt("jfkvoonkf1", this.f10036ax);
        bundle.putInt("jfkvoonkf2", (this.f10007aU == null || this.f10007aU.isEmpty()) ? -1 : this.f10009aW);
        bundle.putBoolean("jfkvoonkf3", this.f10098cf);
    }

    /* renamed from: a */
    public void mo17557a(Configuration configuration) {
        boolean isInMultiWindowMode = this.f10092c.isInMultiWindowMode();
        boolean z = true;
        if (!this.f10092c.isInMultiWindowMode() && configuration.orientation != 1) {
            z = false;
        }
        if (z != this.f10001aO) {
            this.f10001aO = z;
            if (m11473p(false)) {
                m11466n(false);
                m11378ab();
            }
            if (this.f10053bN != null && this.f10053bN.isShowing()) {
                this.f10053bN.dismiss();
                this.f10053bN = null;
            }
            this.f10077bl.mo18246b(z);
            if (this.f10054bO != null && this.f10054bO.mo18326b()) {
                this.f10054bO.mo18321a();
                this.f10054bO = null;
            }
            int i = aww.f6164j ? 8 : 7;
            int outCount = this.f10122x.getOutCount();
            if (isInMultiWindowMode) {
                i--;
                if (this.f10117s.getVisibility() == 0) {
                    outCount--;
                    this.f10117s.setVisibility(8);
                }
            } else if (this.f10117s.getVisibility() == 8) {
                outCount++;
                this.f10117s.setVisibility(0);
            }
            this.f10122x.mo17423a(i, outCount);
            this.f10122x.mo17422a();
        }
        m11482s();
    }

    /* renamed from: s */
    private void m11482s() {
        int dimensionPixelOffset = this.f10039b.getResources().getDimensionPixelOffset(R.dimen.margin_video_next);
      //  if (this.f10018af != dimensionPixelOffset) {
            this.f10018af = dimensionPixelOffset;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f10014ab.getLayoutParams();
            marginLayoutParams.leftMargin = dimensionPixelOffset;
            this.f10014ab.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f10015ac.getLayoutParams();
            marginLayoutParams2.rightMargin = dimensionPixelOffset;
            this.f10015ac.setLayoutParams(marginLayoutParams2);
            if (this.f10001aO) {
                this.f10017ae.setVisibility(8);
                this.f10016ad.setVisibility(8);
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.f10017ae.getLayoutParams();
            marginLayoutParams3.leftMargin = dimensionPixelOffset;
            this.f10017ae.setLayoutParams(marginLayoutParams3);
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.f10016ad.getLayoutParams();
            marginLayoutParams4.rightMargin = dimensionPixelOffset;
            this.f10016ad.setLayoutParams(marginLayoutParams4);
            this.f10017ae.setVisibility(0);
            this.f10016ad.setVisibility(0);
      //  }
    }

    /* renamed from: t */
    private void m11486t() {
        this.f10017ae.setClickable(true);
        this.f10017ae.setLongClickable(true);
        this.f10016ad.setClickable(true);
        this.f10016ad.setLongClickable(true);
        View.OnTouchListener r0 = new View.OnTouchListener() {

            /* renamed from: b */
            private boolean f10178b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (C2483g.this.f10046bG) {
                    return true;
                }
                switch (motionEvent.getAction()) {
                    case 0:
                        C2483g.this.m11378ab();
                        view.setPressed(true);
                        boolean z = view.getId() == R.id.video_ff10;
                        if (this.f10178b != z) {
                            this.f10178b = z;
                            int unused = C2483g.this.f10047bH = C2483g.this.f10048bI = 0;
                        }
                        int i = this.f10178b ? Constants.TEN_SECONDS_MILLIS : -10000;
                        boolean unused2 = C2483g.this.f10000aN = true;
                        C2483g.this.m11349a(i, 1);
                        break;
                    case 1:
                    case 3:
                    case 4:
                        if (C2483g.this.f10000aN) {
                            C2483g.this.f10086bu.removeMessages(11);
                            C2483g.this.m11475q(false);
                            view.setPressed(false);
                            boolean unused3 = C2483g.this.f10000aN = false;
                            C2483g.this.m11376aa();
                            LogEvents.m18484a("PlayPage", this.f10178b ? "FastForward" : "FastBackward");
                            break;
                        } else {
                            return false;
                        }
                }
                return true;
            }
        };
        this.f10017ae.setOnTouchListener(r0);
        this.f10016ad.setOnTouchListener(r0);
    }

    /* renamed from: e */
    public boolean mo17575e() {
        if (m11309K() || m11473p(true)) {
            return true;
        }
        if (!this.f9997aK) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f10049bJ <= 2000) {
            return false;
        }
        axv.m7434a((int) R.string.exit_tip);
        this.f10049bJ = currentTimeMillis;
        return true;
    }

    /* renamed from: a */
    public boolean mo17559a(int i, KeyEvent keyEvent) {
        int i2 = 0;
        if (i != 25 && i != 24) {
            return false;
        }
        m11296D();
        int i3 = (i == 25 ? -1 : 1) + this.f9989aC;
        if (i3 > this.f9988aB) {
            i2 = this.f9988aB;
        } else if (i3 >= 0) {
            i2 = i3;
        }
        m11439g(i2);
        m11444h(i2);
        this.f10086bu.removeMessages(4);
        this.f10086bu.sendEmptyMessageDelayed(4, 1000);
        return true;
    }

    /* renamed from: a */
    public C2483g mo17550a(avs avs) {
        this.f10088bw = avs;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public C2483g m11488u() {
        if (this.f10102d != null) {
            this.f10038az = this.f10102d.toggleAspectRatio();
            this.f10020ah.setImageResource(aww.f6163i[this.f10038az]);
            this.f10084bs.m11563a();
            m11339Z();
        }
        return this;
    }

    /* renamed from: a */
    public C2483g mo17552a(String str) {
        this.f10050bK = str;
        return this;
    }

    /* renamed from: a */
    public C2483g mo17554a(HashMap<String, String> hashMap) {
        this.f10051bL = hashMap;
        return this;
    }

    /* renamed from: b */
    public C2483g mo17561b(String str) {
        int i;
        boolean z;
        if (this.f10055bP == null) {
            this.f10055bP = new RecentMediaStorage(this.f10039b);
        }
        this.f10055bP.mo17902a(this.f10073bh, str, System.currentTimeMillis());
        if (!TextUtils.equals(this.f9991aE, str)) {
            this.f10068bc = null;
            this.f10070be.setText((CharSequence) null);
            if (this.f10071bf != null) {
                this.f10071bf.mo18175a();
            }
            if (this.f10072bg != null) {
                this.f10072bg.mo10862a();
            }
        }
        this.f9991aE = str;
        m11491v();
        if (this.f10083br) {
            this.f10086bu.obtainMessage(8).sendToTarget();
            m11316N();
        }
        this.f10102d.setUseSw(SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getInt("DefaultDecoder", 0) == 1);
        this.f10102d.setAudioDelay(0.0f);
        this.f10077bl.mo18240a();
        this.f10069bd = new C2840g(this.f10102d);
        String a = this.f10083br ? null : C2822c.m12787a(str, this.f9992aF);
        if (this.f10074bi != null) {
            z = this.f10074bi.f10538c;
            if (this.f10074bi.f10536a != null) {
                a = this.f10074bi.f10536a;
                i = this.f10074bi.f10537b;
            } else {
                i = 0;
            }
            if (this.f10074bi.f10539d == -1 && z && !axc.chekFileExist(a)) {
                this.f10074bi.f10539d = -2;
                a = null;
                i = 0;
            }
            if (this.f10074bi.f10539d == -1) {
                this.f10069bd.mo18254a();
                this.f10075bj = -1;
                this.f10076bk = str;
            } else if (this.f10074bi.f10539d >= 0) {
                m11366a(str, this.f10074bi.f10539d);
            }
            this.f10077bl.mo18242a(this.f10074bi.f10540e, this.f10074bi.f10541f);
            if (this.f10074bi.f10542g >= 0) {
                m11413b(str, this.f10074bi.f10542g);
            }
            if (this.f10074bi.f10544i != 0.0f) {
                this.f10102d.setAudioDelay(this.f10074bi.f10544i);
            }
            if (this.f10074bi.f10543h != -1) {
                this.f10102d.setUseSw(this.f10074bi.f10543h == 1);
            }
        } else {
            z = true;
            i = 0;
        }
        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("yw1w9Q6K", false)) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_());
            int i2 = defaultSharedPreferences.getInt("subTextSize", -1);
            float f = defaultSharedPreferences.getFloat("subPosition", -1.0f);
            if (i2 > 0 && f > 0.0f) {
                this.f10077bl.mo18242a(i2, f);
            }
        }
        if (this.f10050bK != null && this.f10050bK.equalsIgnoreCase(this.f9991aE)) {
            this.f10102d.setUseSw(true);
        }
        m11367a(a, true, z, i);
        this.f10078bm = -1;
        this.f10062bW = false;
        this.f10081bp = str;
        this.f10082bq = 0;
        return this;
    }

    /* renamed from: a */
    private void m11366a(String str, int i) {
        this.f10075bj = i;
        this.f10076bk = str;
    }

    /* renamed from: b */
    private void m11413b(String str, int i) {
        this.f10079bn = i;
        this.f10080bo = str;
    }

    /* renamed from: a */
    public C2483g mo17553a(String str, ArrayList<VideoPlayListBean> arrayList, int i) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f9986Z.setVisibility(0);
            this.f9986Z.setOnClickListener(this.f10089bx);
            this.f10007aU = arrayList;
            this.f10008aV = str;
            this.f10009aW = i;
            if (this.f10026an != null) {
                TextView textView = (TextView) this.f10026an.findViewById(R.id.play_list_name);
                TextView textView2 = (TextView) this.f10026an.findViewById(R.id.play_list_count);
                if (this.f10004aR) {
                    textView.setText(R.string.private_videos);
                } else {
                    textView.setText(str);
                }
                textView2.setText(String.valueOf(arrayList.size()));
            }
        }
        return this;
    }

    /* renamed from: b */
    public C2483g mo17560b(int i) {
        this.f10073bh = i;
        return this;
    }

    /* renamed from: a */
    public C2483g mo17551a(RecentMediaStorage.ExInfo exInfo) {
        this.f10074bi = exInfo;
        return this;
    }

    /* renamed from: f */
    public void mo17576f() {
        m11436f(false);
    }

    /* renamed from: f */
    private void m11436f(boolean z) {
        if (this.f9995aI) {
            this.f10102d.mo17474a(this.f9991aE, (Map<String, String>) this.f10051bL, 0);
        } else if (this.f9998aL || this.f10035aw == 299) {
            this.f10102d.setRender(2);
            this.f10102d.mo17474a(this.f9991aE, (Map<String, String>) this.f10051bL, this.f10036ax);
            this.f9998aL = false;
        }
        if (!this.f10083br) {
            m11313M();
        }
        this.f10092c.mo17679a(true);
        this.f10092c.mo17676a();
        if (!z) {
            this.f10092c.mo17682d();
        }
        this.f10102d.start();
    }

    /* renamed from: c */
    public C2483g mo17565c(String str) {
        this.f9992aF = str;
        ((TextView) this.f10092c.findViewById(R.id.app_video_title)).setText(str);
        return this;
    }

    /* renamed from: d */
    public C2483g mo17569d(String str) {
        this.f9993aG = str;
        return this;
    }

    /* renamed from: v */
    private void m11491v() {
        m11500z();
        this.f9999aM = false;
        m11477r();
        boolean unused = this.f10101ci.f10193d = true;
        if (this.f10102d.isPlaying()) {
            m11496x();
            this.f10102d.mo17475a(false);
        }
        this.f9998aL = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m11442g(boolean z) {
        this.f10035aw = 304;
        if (z && this.f10102d.isPlaying()) {
            m11496x();
        }
        this.f10102d.pause();
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m11494w() {
        int currentPosition;
        if (!(this.f10102d == null || this.f10102d.getSettings().mo17545a() == null)) {
            this.f10102d.getSettings().mo17546a((IMediaPlayer) null);
            C2779a.m12613a().mo18136b((Context) this.f10092c, false);
        }
        if (!(this.f9991aE == null || this.f10102d == null || (currentPosition = this.f10102d.getCurrentPosition()) <= 0)) {
            m11351a((long) currentPosition);
        }
        if (this.f10102d != null) {
            this.f10044bE = false;
            this.f10102d.mo17486f();
        }
        if (this.f10086bu != null) {
            this.f10086bu.removeMessages(5);
        }
    }

    /* renamed from: e */
    public void mo17574e(String str) {
        if (TextUtils.equals(this.f9991aE, str)) {
            if (this.f10102d != null) {
                this.f10102d.seekTo(0);
            }
            this.f10010aX.mo11005d();
            m11376aa();
        }
    }

    /* renamed from: c */
    public C2483g mo17564c(int i) {
        this.f10036ax = i;
        return this;
    }

    /* renamed from: a */
    public C2483g mo17555a(boolean z) {
        this.f10004aR = z;
        return this;
    }

    /* renamed from: b */
    public C2483g mo17562b(boolean z) {
        this.f10005aS = z;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public int m11496x() {
        if (!this.f9995aI) {
            this.f10036ax = this.f10102d.getCurrentPosition();
        } else {
            this.f10036ax = -1;
        }
        return this.f10036ax;
    }

    /* renamed from: g */
    public View mo17577g() {
        return this.f10104f;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public long m11498y() {
        return (long) this.f10102d.getDuration();
    }

    /* renamed from: z */
    private void m11500z() {
        boolean z = false;
        if (!this.f10005aS) {
            this.f10083br = false;
            this.f9995aI = false;
            return;
        }
        if (this.f9991aE == null || !this.f9991aE.startsWith("rtmp://")) {
            this.f9995aI = false;
        } else {
            this.f9995aI = true;
        }
        if (this.f9991aE != null && !this.f9991aE.startsWith("/") && !this.f9991aE.startsWith("file://") && !this.f9991aE.startsWith("content:")) {
            z = true;
        }
        this.f10083br = z;
        m11454j(this.f10083br);
    }

    /* renamed from: c */
    public C2483g mo17566c(boolean z) {
        this.f9985Y.setVisibility(z ? 8 : 0);
        return this;
    }

    /* renamed from: e */
    public C2483g mo17572e(boolean z) {
        this.f10002aP = z;
        this.f10019ag.setVisibility(this.f10002aP ? 8 : 0);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m11446h(boolean z) {
        m11344a(z, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m11450i(boolean z) {
        m11344a(z, false);
    }

    /* renamed from: a */
    private C2483g m11344a(boolean z, boolean z2) {
        this.f9996aJ = z2;
        int i = 8;
        if (this.f9996aJ) {
            if (!this.f10057bR) {
                m11327T();
            } else {
                this.f9963C.setVisibility(0);
                this.f10114p.setVisibility(0);
                this.f10115q.setVisibility(0);
                this.f10057bR = false;
            }
            this.f10105g.setVisibility(0);
            this.f10106h.setVisibility(0);
            if (this.f9995aI) {
                this.f9983W.setVisibility(4);
            } else {
                this.f9983W.setVisibility(0);
            }
            if (this.f10088bw != null) {
                this.f10088bw.mo10823a(true);
            }
            if (this.f10035aw != 303 && this.f10035aw != 302 && this.f10035aw != 301 && this.f10035aw != 304) {
                this.f10019ag.setVisibility(8);
            } else if (this.f10002aP) {
                this.f10019ag.setVisibility(8);
            } else {
                ImageView imageView = this.f10019ag;
                if (!this.f9995aI) {
                    i = 0;
                }
                imageView.setVisibility(i);
            }
            m11334W();
            this.f10086bu.sendEmptyMessage(1);
        } else {
            this.f10105g.setVisibility(8);
            this.f10106h.setVisibility(8);
            if (this.f9995aI || this.f10035aw != 304 || this.f10102d.isPlaying()) {
                this.f10019ag.setVisibility(8);
            } else if (this.f10002aP) {
                this.f10019ag.setVisibility(8);
            } else {
                this.f10019ag.setVisibility(0);
            }

            this.f10086bu.removeMessages(1);
            if (this.f10088bw != null) {
                this.f10088bw.mo10823a(false);
            }
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11353a(final View view) {
        m11473p(true);
        this.f10054bO = new PopupWindowView(this.f10092c, new String[]{this.f10092c.getString(R.string.equalizer), this.f10092c.getString(R.string.subtitle), this.f10092c.getString(R.string.properties), this.f10092c.getString(R.string.share)}, 1);
        this.f10054bO.mo18325a((PopupWindowView.C2855c) new PopupWindowView.C2855c() {
            /* renamed from: a */
            public void mo17620a(int i, int i2, int i3) {
                if (!C2483g.this.f10046bG) {
                    switch (i) {
                        case 0:
                            LogEvents.m18492b("PlayPage", "Equalizer");
                            boolean unused = C2483g.this.f10066ba = true;
                            C2483g.this.f10092c.startActivity(new Intent(C2483g.this.f10092c, EqualizerActivity.class));
                            return;
                        case 1:
                            LogEvents.m18492b("PlayPage", "Subtitle");
                            C2483g.this.m11410b(view);
                            return;
                        case 2:
                            LogEvents.m18492b("PlayPage", "Property");
                            C2483g.this.m11379ac();
                            return;
                        case 3:
                            LogEvents.m18492b("PlayPage", "Share");
                            if (C2483g.this.f9991aE != null) {
                                File file = new File(C2483g.this.f9991aE);
                                if (file.exists()) {
                                    axy.m7463a((Activity) C2483g.this.f10092c, file.getAbsolutePath(), "video/*");
                                    return;
                                }
                                Uri parse = Uri.parse(C2483g.this.f9991aE);
                                Intent intent = new Intent("android.intent.action.SEND");
                                intent.putExtra("android.intent.extra.STREAM", parse);
                                intent.setType("video/*");
                                try {
                                    C2483g.this.f10092c.startActivity(intent);
                                    return;
                                } catch (ActivityNotFoundException e) {
                                    e.printStackTrace();
                                    return;
                                } catch (SecurityException unused2) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        });
        this.f10054bO.mo18322a(view, 0);
    }

    /* renamed from: j */
    private void m11454j(boolean z) {
        this.f10023ak.setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    private void m11351a(long j) {
        if (this.f9991aE != null) {
            if (this.f10055bP == null) {
                this.f10055bP = new RecentMediaStorage(this.f10039b);
            }
            long y = m11498y();
            if (j > y) {
                j = y;
            }
            boolean z = this.f10074bi == null;
            if (z) {
                this.f10074bi = new RecentMediaStorage.ExInfo();
                if (this.f10007aU != null && this.f10009aW >= 0 && this.f10009aW < this.f10007aU.size()) {
                    this.f10007aU.get(this.f10009aW).f9818f = this.f10074bi;
                }
            }
            int i = -1;
            if (this.f10068bc != null || (this.f10069bd != null && this.f10069bd.mo18258c())) {
                RecentMediaStorage.ExInfo exInfo = this.f10074bi;
                if (this.f10069bd != null && this.f10069bd.mo18258c()) {
                    i = this.f10069bd.mo18259d();
                }
                exInfo.f10539d = i;
                if (this.f10068bc != null) {
                    this.f10074bi.f10536a = this.f10068bc.mo18217b();
                    this.f10074bi.f10538c = this.f10068bc.mo18218c();
                    this.f10074bi.f10537b = this.f10068bc.mo18213a();
                } else {
                    this.f10074bi.f10536a = null;
                    this.f10074bi.f10538c = false;
                    this.f10074bi.f10537b = 0;
                }
                this.f10074bi.f10541f = this.f10077bl.mo18248d();
                this.f10074bi.f10540e = this.f10077bl.mo18247c();
                PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putFloat("subPosition", this.f10074bi.f10541f).putInt("subTextSize", this.f10074bi.f10540e).apply();
            } else if (this.f10074bi != null) {
                if (z) {
                    this.f10074bi.f10538c = true;
                }
                this.f10074bi.f10537b = 0;
                this.f10074bi.f10536a = null;
                this.f10074bi.f10539d = -1;
                this.f10074bi.f10541f = -1.0f;
                this.f10074bi.f10540e = -1;
            }
            if (this.f10078bm >= 0) {
                this.f10074bi.f10542g = this.f10078bm;
            }
            this.f10074bi.f10544i = this.f10102d.getAudioDelay();
            if (this.f10062bW) {
                this.f10074bi.f10543h = this.f10102d.mo17501i() ^ true ? 1 : 0;
            }
            this.f10055bP.mo17903a(this.f10073bh, this.f9991aE, j, y, this.f10005aS ? 2 : this.f10004aR ? 1 : 0, this.f10074bi);
        }
        if (this.f10007aU != null && this.f10009aW >= 0 && this.f10009aW < this.f10007aU.size()) {
            VideoPlayListBean videoPlayListBean = this.f10007aU.get(this.f10009aW);
            videoPlayListBean.f9816d = j;
            videoPlayListBean.f9818f = this.f10074bi;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m11457k(boolean z) {
        this.f10010aX.mo11004c();
        View inflate = LayoutInflater.from(this.f10092c).inflate(R.layout.dialog_brightness_volume, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(inflate, axw.m7444a((Context) this.f10092c, 328.0f), -2, true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                C2483g.this.f10010aX.mo11005d();
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.close);
        final TextView textView = (TextView) inflate.findViewById(R.id.title);
        if (z) {
            ((ViewGroup) inflate).getChildAt(2).setVisibility(8);
            SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.brightness_seekbar);
            final TextView textView2 = (TextView) inflate.findViewById(R.id.brightness_value);
            ((ImageView) inflate.findViewById(R.id.btightness_icon)).setAlpha(0.6f);
            seekBar.setMax(100);
            int i = (int) (this.f10092c.getWindow().getAttributes().screenBrightness * 100.0f);
            seekBar.setProgress(i);
            textView2.setText(String.valueOf(i));
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (!C2483g.this.f10046bG) {
                        textView2.setText(String.valueOf(i));
                        WindowManager.LayoutParams attributes = C2483g.this.f10092c.getWindow().getAttributes();
                        attributes.screenBrightness = ((float) i) * 0.01f;
                        if (attributes.screenBrightness > 1.0f) {
                            attributes.screenBrightness = 1.0f;
                        } else if (attributes.screenBrightness < 0.01f) {
                            attributes.screenBrightness = 0.01f;
                        }
                        C2483g.this.f10092c.getWindow().setAttributes(attributes);
                    }
                }
            });
            textView.setText(this.f10092c.getString(R.string.brightness_simple));
        } else {
            ((ViewGroup) inflate).getChildAt(1).setVisibility(8);
            SeekBar seekBar2 = (SeekBar) inflate.findViewById(R.id.volume_seekbar);
            final TextView textView3 = (TextView) inflate.findViewById(R.id.volume_value);
            final ImageView imageView2 = (ImageView) inflate.findViewById(R.id.volume_icon);
            imageView2.setAlpha(0.6f);
            seekBar2.setMax(this.f9988aB);
            m11296D();
            int i2 = this.f9989aC;
            textView.setText(i2 > this.f9988aB ? R.string.volume_boost : R.string.volume);
            imageView2.setImageResource(i2 == 0 ? R.drawable.ic_mute : R.drawable.ic_sound);
            seekBar2.setProgress(i2);
            textView3.setText(String.valueOf(i2));
            seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (!C2483g.this.f10046bG) {
                        textView3.setText(String.valueOf(i));
                        imageView2.setImageResource(i == 0 ? R.drawable.ic_mute : R.drawable.ic_sound);
                        C2483g.this.m11439g(i);
                        textView.setText(i > C2483g.this.f9988aB ? R.string.volume_boost : R.string.volume);
                    }
                }
            });
        }
        imageView.setAlpha(0.6f);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAtLocation(this.f10092c.getWindow().getDecorView(), 17, 0, 0);
        this.f10115q.setVisibility(4);
        this.f10114p.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m11289A() {
        final boolean a = mo17544a();
        this.f10010aX.mo11004c();
        Locale locale = Locale.ENGLISH;
        Locale locale2 = Locale.ENGLISH;
        Locale locale3 = Locale.ENGLISH;
        Locale locale4 = Locale.ENGLISH;
        String[] strArr = {this.f10092c.getString(R.string.off), String.format(locale, "%d " + this.f10092c.getString(R.string.minutes), new Object[]{15}), String.format(locale2, "%d " + this.f10092c.getString(R.string.minutes), new Object[]{30}), String.format(locale3, "%d " + this.f10092c.getString(R.string.minutes), new Object[]{45}), String.format(locale4, "%d " + this.f10092c.getString(R.string.minutes), new Object[]{60}), this.f10092c.getString(R.string.timer_stop_end)};
        View inflate = LayoutInflater.from(this.f10092c).inflate(R.layout.dialog_timer_layout, (ViewGroup) null, false);
        this.f10056bQ = new PopupWindow(inflate, axw.m7444a((Context) this.f10092c, 300.0f), -2, true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.close);
        imageView.setAlpha(0.6f);
        ListView listView = (ListView) inflate.findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter(this.f10092c, R.layout.list_timer_item, strArr));
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C2483g.this.f10056bQ.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!C2483g.this.f10046bG) {
                    switch (i) {
                        case 0:
                            MyApplication.myApplication().mo17873d();
                            MyApplication.myApplication().mo17870a(false);
                            if (C2483g.this.f10056bQ != null) {
                                C2483g.this.f10056bQ.dismiss();
                            }
                            boolean unused = C2483g.this.f10085bt = false;
                            C2483g.this.f10121w.setVisibility(8);
                            C2483g.this.f10113o.setVisibility(0);
                            return;
                        case 1:
                            C2483g.this.m11352a(900000, false);
                            return;
                        case 2:
                            C2483g.this.m11352a(1800000, false);
                            return;
                        case 3:
                            C2483g.this.m11352a(2700000, false);
                            return;
                        case 4:
                            C2483g.this.m11352a(3600000, false);
                            return;
                        case 5:
                            boolean unused2 = C2483g.this.f10085bt = true;
                            C2483g.this.m11352a(C2483g.this.m11498y() - ((long) C2483g.this.m11496x()), true);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        this.f10056bQ.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                if (!C2483g.this.f10046bG) {
                    if (a) {
                        C2483g.this.mo17543a(0);
                    }
                    C2483g.this.f10010aX.mo11005d();
                }
            }
        });
        this.f10056bQ.setBackgroundDrawable(new ColorDrawable());
        this.f10056bQ.showAtLocation(this.f10092c.getWindow().getDecorView(), 17, 0, 0);
        this.f9963C.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11352a(final long j, boolean z) {
        MyApplication.myApplication().mo17873d();
        MyApplication.myApplication().mo17870a(true);
        if (z) {
            this.f10085bt = true;
            this.f10121w.setText(String.format(Locale.ENGLISH, "%02d:%02d", new Object[]{Long.valueOf(j / 60000), Long.valueOf((j / 1000) % 60)}));
        } else {
            this.f10085bt = false;
            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                public void run() {
                    if (!C2483g.this.f10046bG) {
                        MyApplication.myApplication().mo17866a(j);
                    }
                }
            });
        }
        if (this.f10056bQ != null) {
            this.f10056bQ.dismiss();
        }
        this.f10121w.setVisibility(0);
        this.f10113o.setVisibility(8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTick(awn awn) {
        if (awn.f6092b) {
            this.f10121w.setVisibility(8);
            this.f10113o.setVisibility(0);
            if (mo17544a()) {
                this.f10092c.mo17679a(false);
                this.f10092c.mo17680b();
                this.f10092c.mo17681c();
                return;
            }
            return;
        }
        this.f10121w.setText(String.format(Locale.ENGLISH, "%02d:%02d", new Object[]{Long.valueOf(awn.f6091a / 60000), Long.valueOf((awn.f6091a / 1000) % 60)}));
    }

    /* renamed from: h */
    public boolean mo17578h() {
        return this.f10097ce;
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public boolean m11292B() {
        if (!PermissionHelper.canDrawOverlays(MyApplication.getApplicationContext_())) {
            return false;
        }
        if (this.f10098cf) {
            this.f10098cf = false;
            C2779a.m12613a().mo18136b((Context) this.f10092c, false);
        }
        this.f10097ce = true;
        this.f10092c.finish();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m11294C() {
        new AlertDialog.Builder(this.f10092c).setView((int) R.layout.dialog_overlay_permission).setPositiveButton((int) R.string.allow, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PermissionHelper.overlayPermission((Activity) C2483g.this.f10092c, 162);
            }
        }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|(3:10|11|12)|13|14|15|16|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        p000.ayb.m18488a("ChangeVolumeError", r5.getLocalizedMessage(), false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0021 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11439gg(int r5) {
        /*
            r4 = this;
            boolean r0 = r4.f10095cc
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r4.m11464m((boolean) r1)
        L_0x0008:
            int r0 = r4.f9988aB
            if (r5 <= r0) goto L_0x000e
            int r5 = r4.f9988aB
        L_0x000e:
            int r0 = r4.f9989aC
            if (r0 == r5) goto L_0x003e
            boolean r0 = p000.axg.m7329a()
            r2 = 3
            if (r0 != 0) goto L_0x0021
            android.media.AudioManager r0 = r4.f10003aQ     // Catch:{ SecurityException -> 0x0021 }
            r0.setStreamVolume(r2, r5, r1)     // Catch:{ SecurityException -> 0x0021 }
            r4.f9989aC = r5     // Catch:{ SecurityException -> 0x0021 }
            return
        L_0x0021:
            android.media.AudioManager r0 = r4.f10003aQ     // Catch:{ SecurityException -> 0x002a }
            r3 = 1
            r0.setStreamVolume(r2, r5, r3)     // Catch:{ SecurityException -> 0x002a }
            r4.f9989aC = r5     // Catch:{ SecurityException -> 0x002a }
            goto L_0x003e
        L_0x002a:
            android.media.AudioManager r0 = r4.f10003aQ     // Catch:{ SecurityException -> 0x0034 }
            r3 = 512(0x200, float:7.175E-43)
            r0.setStreamVolume(r2, r5, r3)     // Catch:{ SecurityException -> 0x0034 }
            r4.f9989aC = r5     // Catch:{ SecurityException -> 0x0034 }
            goto L_0x003e
        L_0x0034:
            r5 = move-exception
            java.lang.String r0 = "ChangeVolumeError"
            java.lang.String r5 = r5.getLocalizedMessage()
            p000.ayb.m18488a((java.lang.String) r0, (java.lang.String) r5, (boolean) r1)
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.inplayer.widget.C2483g.m11439g(int):void");
    }
    private void m11439ga(int i2) {
        if (this.f10095cc) {
            m11464m(false);
        }
        if (i2 > this.f9988aB) {
            i2 = this.f9988aB;
        }
        if (this.f9989aC != i2) {
            if (!axg.m7329a()) {
                this.f10003aQ.setStreamVolume(3, i2, 0);
                this.f9989aC = i2;
                return;
            }
            this.f10003aQ.setStreamVolume(3, i2, 1);
            this.f9989aC = i2;
            this.f10003aQ.setStreamVolume(3, i2, 512);
            this.f9989aC = i2;
        }
    }
    private void m11439g(int var1) {
        if (this.f10095cc) {
            this.m11464m(false);
        }

        int var2 = var1;
        if (var1 > this.f9988aB) {
            var2 = this.f9988aB;
        }

        if (this.f9989aC != var2) {
            if (!axg.m7329a()) {
                try {
                    this.f10003aQ.setStreamVolume(3, var2, 0);
                    this.f9989aC = var2;
                    return;
                } catch (SecurityException var6) {
                }
            }

            try {
                this.f10003aQ.setStreamVolume(3, var2, 1);
                this.f9989aC = var2;
            } catch (SecurityException var5) {
                try {
                    this.f10003aQ.setStreamVolume(3, var2, 512);
                    this.f9989aC = var2;
                } catch (SecurityException var4) {
                    LogEvents.m18488a("ChangeVolumeError", var4.getLocalizedMessage(), false);
                }
            }
        }

    }

    private void m11439gc(int n) {
        if (this.f10095cc) {
            this.m11464m((boolean)false);
        }
        int n2 = n;
        if (n > this.f9988aB) {
            n2 = this.f9988aB;
        }
        if (this.f9989aC != n2) {
            if (!axg.m7329a()) {
                try {
                    this.f10003aQ.setStreamVolume((int)3, (int)n2, (int)0);
                    this.f9989aC = n2;
                    return;
                }
                catch (SecurityException securityException) {}
            }
            try {
                this.f10003aQ.setStreamVolume((int)3, (int)n2, (int)1);
                this.f9989aC = n2;
            }
            catch (SecurityException securityException) {
                try {
                    this.f10003aQ.setStreamVolume((int)3, (int)n2, (int)512);
                    this.f9989aC = n2;
                }
                catch (SecurityException securityException2) {
                    LogEvents.m18488a((String)"ChangeVolumeError", (String)securityException2.getLocalizedMessage(), (boolean)false);
                }
            }
        }
    }


    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m11296D() {
        int streamVolume = this.f10003aQ.getStreamVolume(3);
        if (this.f9989aC != streamVolume) {
            this.f9989aC = streamVolume;
        }
    }

    /* renamed from: h */
    private void m11444h(int i) {
        if (i > this.f9988aB) {
            this.f9979S.setText(String.valueOf(this.f9988aB));
            this.f9980T.setVisibility(0);
            TextView textView = this.f9980T;
            textView.setText("+" + (i - this.f9988aB));
            this.f9982V.setText(R.string.volume_boost);
        } else {
            if (i == 0) {
                this.f9979S.setText(R.string.off);
            } else {
                this.f9979S.setText(String.valueOf(i));
            }
            this.f9980T.setVisibility(8);
            this.f9982V.setText(R.string.volume);
        }
        this.f9982V.append(" :");
        this.f9976P.setImageResource(i == 0 ? R.drawable.ic_mute : R.drawable.ic_sound);
        this.f9969I.setVisibility(View.GONE);
        this.f9970J.setVisibility(View.GONE);
        this.f9977Q.setVisibility(View.VISIBLE);
        this.f9978R.setVisibility(View.VISIBLE);
        if (i > this.f9988aB) {
            this.f9981U.setSecondaryProgress(this.f9988aB);
            this.f9981U.setProgress(i - this.f9988aB);
            return;
        }
        this.f9981U.setSecondaryProgress(i);
        this.f9981U.setProgress(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11410b(View view) {
        if (this.f10069bd != null) {
            this.f10058bS = this.f10069bd.mo18253a(view, this.f10068bc == null ? null : this.f10068bc.mo18217b(), this.f10068bc != null && this.f10068bc.mo18218c(), new View.OnClickListener() {
                public void onClick(View view) {
                    if (!C2483g.this.f10046bG) {
                        if (C2483g.this.f10058bS != null) {
                            C2483g.this.f10058bS.dismiss();
                        }
                        switch (view.getId()) {
                            case R.id.subtitle_adjust /*2131296859*/:
                                LogEvents.m18492b("Subtitle", "Adjust");
                                if (C2483g.this.f10072bg == null) {
                                    awo unused = C2483g.this.f10072bg = new awo(C2483g.this.f10092c);
                                }
                                C2483g.this.f10072bg.mo10863a(C2483g.this.f10068bc);
                                return;
                            case R.id.subtitle_download /*2131296860*/:
                                LogEvents.m18492b("Subtitle", "Download");
                                C2483g.this.m11301G();
                                return;
                            case R.id.subtitle_open_from /*2131296861*/:
                                LogEvents.m18492b("Subtitle", "OpenFrom");
                                C2483g.this.m11300F();
                                return;
                            case R.id.subtitle_personality /*2131296863*/:
                                LogEvents.m18492b("Subtitle", "Personality");
                                C2483g.this.m11308J();
                                C2483g.this.f10010aX.mo11004c();
                                return;
                            case R.id.subtitle_select /*2131296864*/:
                                LogEvents.m18492b("Subtitle", "Select");
                                C2483g.this.m11298E();
                                return;
                            case R.id.subtitle_turn_off /*2131296867*/:
                                LogEvents.m18492b("Subtitle", "TurnOff");
                                C2483g.this.m11303H();
                                return;
                            case R.id.subtitle_turn_on /*2131296868*/:
                                LogEvents.m18492b("Subtitle", "TurnOn");
                                C2483g.this.m11306I();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
            this.f10058bS.showAtLocation(this.f10092c.getWindow().getDecorView(), 17, 0, 0);
            if (this.f10072bg != null) {
                this.f10072bg.mo10862a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11367a(String str, final boolean z, final boolean z2, final int i) {
        this.f10059bT = str;
        C2822c.m12788a(str, (C2822c.C2825a) new C2822c.C2825a() {
            /* renamed from: a */
            public void mo17596a(C2822c.C2827c cVar) {
                if (!C2483g.this.f10046bG && C2483g.this.f10092c != null && !C2483g.this.f10092c.isFinishing() && TextUtils.equals(C2483g.this.f10059bT, cVar.f11231a)) {
                    if (!z && z2) {
                        C2483g.this.m11350a(-1, true);
                        if (C2483g.this.f10069bd != null && C2483g.this.f10069bd.mo18258c()) {
                            C2483g.this.f10069bd.mo18254a();
                        }
                    }
                    C2822c unused = C2483g.this.f10068bc = new C2822c(cVar, z2, i);
                }
            }

            /* renamed from: a */
            public void mo17597a(String str) {
                if (!C2483g.this.f10046bG && C2483g.this.f10092c != null && !C2483g.this.f10092c.isFinishing() && TextUtils.equals(C2483g.this.f10059bT, str)) {
                    if (!z) {
                        axv.m7440b(R.string.subtitle_load_failed);
                    }
                    if (C2483g.this.f10068bc != null) {
                        String unused = C2483g.this.f10059bT = C2483g.this.f10068bc.mo18217b();
                    } else {
                        String unused2 = C2483g.this.f10059bT = null;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11350a(int i, boolean z) {
        if (z) {
            int d = this.f10102d.mo17483d(3);
            if (d != i) {
                this.f10102d.mo17479c(d);
            } else {
                return;
            }
        }
        this.f10102d.mo17477b(i);
        if (i != -1) {
            this.f10102d.seekTo(m11496x());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m11298E() {
        if (this.f10069bd != null) {
            this.f10069bd.mo18255a(this.f10092c, this.f10068bc == null ? null : this.f10068bc.mo18217b(), this.f10068bc != null && this.f10068bc.mo18218c(), new C2840g.C2844b() {
                /* renamed from: a */
                public void mo17598a(boolean z, int i) {
                    if (!C2483g.this.f10046bG) {
                        C2483g.this.f10070be.setText((CharSequence) null);
                        if (C2483g.this.f10071bf != null) {
                            C2483g.this.f10071bf.mo18175a();
                        }
                        if (z) {
                            if (C2483g.this.f10068bc != null && C2483g.this.f10068bc.mo18218c()) {
                                C2483g.this.f10068bc.mo18216a(false);
                            }
                            C2483g.this.m11350a(i, true);
                            return;
                        }
                        if (C2483g.this.f10068bc != null && !C2483g.this.f10068bc.mo18218c()) {
                            C2483g.this.f10068bc.mo18216a(true);
                        }
                        C2483g.this.m11350a(-1, true);
                    }
                }
            }, this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m11300F() {
        SubtitleSelectorFragment.m12811a(this.f10092c, this.f10004aR ? this.f10068bc != null ? this.f10068bc.mo18217b() : null : this.f9991aE, new SubtitleSelectorFragment.C2834c() {
            /* renamed from: a */
            public void mo17599a(String str) {
                if (!C2483g.this.f10046bG) {
                    C2483g.this.m11367a(str, false, true, 0);
                }
            }
        }, this);
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m11301G() {
        if (this.f10060bU == null) {
            this.f10060bU = new C2796a(this.f10092c);
        }
        this.f10060bU.mo18180a(this.f9992aF, this.f9991aE, this.f9992aF, new C2796a.C2810a() {
            /* renamed from: a */
            public void mo17600a() {
                axv.m7440b(R.string.subtitle_downloading);
            }

            /* renamed from: a */
            public void mo17601a(String str, String str2) {
                axv.m7440b(R.string.subtitle_downloaded);
                if (TextUtils.equals(str2, C2483g.this.f9991aE)) {
                    C2483g.this.m11367a(str, false, true, 0);
                }
                if (C2483g.this.f10060bU != null) {
                    C2483g.this.f10060bU.mo18179a();
                }
            }

            /* renamed from: b */
            public void mo17602b() {
                axv.m7440b(R.string.subtitle_download_failed);
                if (C2483g.this.f10060bU != null) {
                    C2483g.this.f10060bU.mo18179a();
                }
            }
        }, this);
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public void m11303H() {
        this.f10070be.setText((CharSequence) null);
        if (this.f10071bf != null) {
            this.f10071bf.mo18175a();
        }
        if (this.f10069bd != null && this.f10069bd.mo18258c()) {
            this.f10069bd.mo18256a(false);
            this.f10102d.mo17479c(this.f10069bd.mo18259d());
        } else if (this.f10068bc != null) {
            this.f10068bc.mo18216a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public void m11306I() {
        if (this.f10069bd != null && (this.f10069bd.mo18258c() || (this.f10068bc == null && this.f10069bd.mo18261f()))) {
            this.f10069bd.mo18256a(true);
            m11350a(this.f10069bd.mo18260e(), false);
        } else if (this.f10068bc != null) {
            this.f10068bc.mo18216a(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public void m11308J() {
        if (this.f10061bV == null) {
            this.f10061bV = new C2835e(this.f10077bl, this);
        }
        this.f10061bV.mo18232a(this.f10092c, this.f10103e, this.f10089bx);
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public boolean m11309K() {
        if (this.f10061bV != null) {
            return this.f10061bV.mo18233a();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public void m11311L() {
        int i = this.f10032at + 1;
        this.f10032at = i;
        if (i > 3) {
            this.f10032at = 0;
        }
        m11469o(true);
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt("sKrMspmkr", this.f10032at).apply();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008c, code lost:
        r3.f10035aw = 301;
        m11313M();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0095, code lost:
        if (r3.f10083br == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0097, code lost:
        m11316N();
        r3.f10086bu.obtainMessage(8).sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11449ii(int r4) {
        /*
            r3 = this;
            boolean r0 = r3.f10046bG
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = -1010(0xfffffffffffffc0e, float:NaN)
            r1 = 299(0x12b, float:4.19E-43)
            if (r4 == r0) goto L_0x00b7
            r0 = -1007(0xfffffffffffffc11, float:NaN)
            if (r4 == r0) goto L_0x00b7
            r0 = -1004(0xfffffffffffffc14, float:NaN)
            if (r4 == r0) goto L_0x00b7
            r0 = -110(0xffffffffffffff92, float:NaN)
            if (r4 == r0) goto L_0x00b7
            r0 = 1
            if (r4 == r0) goto L_0x00b7
            r2 = 3
            if (r4 == r2) goto L_0x00a6
            r2 = 100
            if (r4 == r2) goto L_0x00b7
            if (r4 == r1) goto L_0x00b7
            switch(r4) {
                case 301: goto L_0x008c;
                case 302: goto L_0x00a6;
                case 303: goto L_0x00a6;
                case 304: goto L_0x00a6;
                case 305: goto L_0x002b;
                default: goto L_0x0026;
            }
        L_0x0026:
            switch(r4) {
                case 701: goto L_0x008c;
                case 702: goto L_0x00a6;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x00de
        L_0x002b:
            r4 = 305(0x131, float:4.27E-43)
            r3.f10035aw = r4
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3.m11351a((long) r1)
            r4 = 0
            r3.f10036ax = r4
            r3.m11324R()
            boolean r1 = r3.f10085bt
            if (r1 == 0) goto L_0x0054
            r3.f10085bt = r4
            com.inshot.xplayer.application.MyApplication r1 = com.inshot.xplayer.application.MyApplication.myApplication()
            r1.mo17870a((boolean) r4)
            r3.f10091bz = r0
            r3.f10098cf = r4
            com.inshot.xplayer.activities.PlayerActivity r4 = r3.f10092c
            r4.finish()
            return
        L_0x0054:
            java.util.ArrayList<com.inshot.inplayer.bean.VideoPlayListBean> r1 = r3.f10007aU
            if (r1 == 0) goto L_0x0082
            int r1 = r3.f10032at
            r2 = 2
            if (r1 != r2) goto L_0x0067
            int r1 = r3.f10009aW
            boolean r1 = r3.m11414b((int) r1, (boolean) r4)
            if (r1 == 0) goto L_0x0082
            goto L_0x00de
        L_0x0067:
            int r1 = r3.f10032at
            if (r1 != 0) goto L_0x007b
            android.content.Context r1 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            android.content.SharedPreferences r1 = p000.axn.getSharedPrefrence(r1)
            java.lang.String r2 = "playNext"
            boolean r1 = r1.getBoolean(r2, r0)
            if (r1 == 0) goto L_0x0082
        L_0x007b:
            boolean r1 = r3.m11480r((boolean) r4)
            if (r1 == 0) goto L_0x0082
            goto L_0x00de
        L_0x0082:
            r3.f10091bz = r0
            r3.f10098cf = r4
            com.inshot.xplayer.activities.PlayerActivity r4 = r3.f10092c
            r4.finish()
            goto L_0x00de
        L_0x008c:
            r4 = 301(0x12d, float:4.22E-43)
            r3.f10035aw = r4
            r3.m11313M()
            boolean r4 = r3.f10083br
            if (r4 == 0) goto L_0x00de
            r3.m11316N()
            android.os.Handler r4 = r3.f10086bu
            r0 = 8
            android.os.Message r4 = r4.obtainMessage(r0)
            r4.sendToTarget()
            goto L_0x00de
        L_0x00a6:
            int r4 = r3.f10035aw
            r0 = 304(0x130, float:4.26E-43)
            if (r4 != r0) goto L_0x00af
            r3.f10035aw = r0
            goto L_0x00b3
        L_0x00af:
            r4 = 303(0x12f, float:4.25E-43)
            r3.f10035aw = r4
        L_0x00b3:
            r3.m11313M()
            goto L_0x00de
        L_0x00b7:
            r3.f10035aw = r1
            r3.m11313M()
            boolean r4 = r3.f9995aI
            r0 = 2131624405(0x7f0e01d5, float:1.8875989E38)
            if (r4 == 0) goto L_0x00d1
            com.inshot.xplayer.activities.PlayerActivity r4 = r3.f10092c
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getString(r0)
            r3.m11435f((java.lang.String) r4)
            goto L_0x00de
        L_0x00d1:
            com.inshot.xplayer.activities.PlayerActivity r4 = r3.f10092c
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getString(r0)
            r3.m11435f((java.lang.String) r4)
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.inplayer.widget.C2483g.m11449i(int):void");
    }
    private void m11449i3(int i2) {
        if (!this.f10046bG) {
            if (!(i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 1)) {
                if (i2 != 3) {
                    if (!(i2 == 100 || i2 == 299)) {
                        switch (i2) {
                            case 301:
                                this.f10035aw = 301;
                                m11313M();
                                if (this.f10083br) {
                                    m11316N();
                                    this.f10086bu.obtainMessage(8).sendToTarget();
                                    return;
                                }
                                return;
                            case 302:
                            case 303:
                            case 304:
                                break;
                            case 305:
                                this.f10035aw = 305;
                                m11351a(Long.MAX_VALUE);
                                this.f10036ax = 0;
                                m11324R();
                                if (this.f10085bt) {
                                    this.f10085bt = false;
                                    MyApplication.myApplication().mo17870a(false);
                                    this.f10091bz = true;
                                    this.f10098cf = false;
                                    this.f10092c.finish();
                                    return;
                                }
                                if (this.f10007aU != null) {
                                    if (this.f10032at == 2) {
                                        if (m11414b(this.f10009aW, false)) {
                                            return;
                                        }
                                    } else if ((this.f10032at != 0 || SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("playNext", true)) && m11480r(false)) {
                                        return;
                                    }
                                }
                                this.f10091bz = true;
                                this.f10098cf = false;
                                this.f10092c.finish();
                                return;
                            default:
                                switch (i2) {
                                    case 701:
                                        break;
                                    case 702:
                                        break;
                                    default:
                                        return;
                                }
                        }
                    }
                }
                if (this.f10035aw == 304) {
                    this.f10035aw = 304;
                } else {
                    this.f10035aw = 303;
                }
                m11313M();
                return;
            }
            this.f10035aw = 299;
            m11313M();
            if (this.f9995aI) {
                m11435f(this.f10092c.getResources().getString(R.string.small_problem));
            } else {
                m11435f(this.f10092c.getResources().getString(R.string.small_problem));
            }
        }
    }

    private void m11449ic(int paramInt) {
        if (this.f10046bG) {
            return;
        }
        if ((paramInt != 64526) && (paramInt != 64529) && (paramInt != 64532) && (paramInt != -110) && (paramInt != 1)) {
            if (paramInt != 3)
            {
                if ((paramInt != 100) && (paramInt != 299)) {
                    switch (paramInt)
                    {
                        default:
                            switch (paramInt)
                            {
                            }
                            break;
                        case 305:
                            this.f10035aw = 305;
                            m11351a(Long.MAX_VALUE);
                            this.f10036ax = 0;
                            m11324R();
                            if (this.f10085bt)
                            {
                                this.f10085bt = false;
                                MyApplication.myApplication().mo17870a(false);
                                this.f10091bz = true;
                                this.f10098cf = false;
                                this.f10092c.finish();
                                return;
                            }
                            if ((this.f10007aU != null) && (this.f10032at == 2 ? !m11414b(this.f10009aW, false) : ((this.f10032at != 0) || (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("playNext", true))) && (m11480r(false)))) {
                                break;
                            }
                            this.f10091bz = true;
                            this.f10098cf = false;
                            this.f10092c.finish();
                            break;
                        case 301:
                            this.f10035aw = 301;
                            m11313M();
                            if (!this.f10083br) {
                                break;
                            }
                            m11316N();
                            this.f10086bu.obtainMessage(8).sendToTarget();
                            break;
                    }
                }
            }
            else
            {
                if (this.f10035aw == 304) {
                    this.f10035aw = 304;
                } else {
                    this.f10035aw = 303;
                }
                m11313M();
                return;
            }
        }
        this.f10035aw = 299;
        m11313M();
        if (this.f9995aI) {
            m11435f(this.f10092c.getResources().getString(R.string.small_problem));
        } else {
            m11435f(this.f10092c.getResources().getString(R.string.small_problem));
        }
    }

    private void m11449i(int var1) {
        if (!this.f10046bG) {
            if (var1 != -1010 && var1 != -1007 && var1 != -1004 && var1 != -110 && var1 != 1) {
                label125: {
                    if (var1 != 3) {
                        if (var1 == 100 || var1 == 299) {
                            break label125;
                        }

                        label79:
                        switch(var1) {
                            case 302:
                            case 303:
                            case 304:
                                break;
                            case 305:
                                this.f10035aw = 305;
                                this.m11351a(Long.MAX_VALUE);
                                this.f10036ax = 0;
                                this.m11324R();
                                if (this.f10085bt) {
                                    this.f10085bt = false;
                                    MyApplication.myApplication().mo17870a(false);
                                    this.f10091bz = true;
                                    this.f10098cf = false;
                                    this.f10092c.finish();
                                    return;
                                }

                                if (this.f10007aU != null) {
                                    if (this.f10032at == 2) {
                                        if (this.m11414b(this.f10009aW, false)) {
                                            return;
                                        }
                                    } else if ((this.f10032at != 0 || SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("playNext", true)) && this.m11480r(false)) {
                                        return;
                                    }
                                }

                                this.f10091bz = true;
                                this.f10098cf = false;
                                this.f10092c.finish();
                                return;
                            default:
                                switch(var1) {
                                    case 701:
                                        break;
                                    case 702:
                                        break label79;
                                    default:
                                        return;
                                }
                            case 301:
                                this.f10035aw = 301;
                                this.m11313M();
                                if (this.f10083br) {
                                    this.m11316N();
                                    this.f10086bu.obtainMessage(8).sendToTarget();
                                }

                                return;
                        }
                    }

                    if (this.f10035aw == 304) {
                        this.f10035aw = 304;
                    } else {
                        this.f10035aw = 303;
                    }

                    this.m11313M();
                    return;
                }
            }

            this.f10035aw = 299;
            this.m11313M();
            if (this.f9995aI) {
                m11435f(this.f10092c.getResources().getString(R.string.small_problem));
            } else {
                m11435f(this.f10092c.getResources().getString(R.string.small_problem));
            }

        }
    }


    /* renamed from: f */
    private void m11435f(String str) {
        this.f9968H.setVisibility(0);
        this.f9984X.setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m11313M() {
        this.f10019ag.setVisibility(8);
        this.f9968H.setVisibility(8);
        m11318O();
        this.f10023ak.setText((CharSequence) null);
        this.f10086bu.removeMessages(8);
    }

    /* renamed from: N */
    private void m11316N() {
        if (!this.f10064bY) {
            this.f10064bY = true;
            if (!this.f10065bZ) {
                this.f10024al.setVisibility(0);
            }
        }
    }

    /* renamed from: O */
    private void m11318O() {
        if (this.f10064bY) {
            this.f10064bY = false;
            this.f10024al.setVisibility(8);
        }
    }

    /* renamed from: P */
    private void m11320P() {
        this.f10065bZ = true;
        if (this.f10064bY) {
            this.f10024al.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m11321Q() {
        this.f10065bZ = false;
        if (this.f10064bY) {
            this.f10024al.setVisibility(0);
        }
    }

    /* renamed from: R */
    private void m11324R() {
        this.f10105g.setVisibility(8);
        this.f10106h.setVisibility(8);
        m11313M();
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m11325S() {
        int i = this.f10093ca + 1;
        this.f10093ca = i;
        mo17568d(i % aww.f6159e.length);
        axv.m7434a(aww.f6162h[this.f10093ca]);
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt("xuWEdsJa", this.f10093ca).apply();
        m11376aa();
    }

    /* renamed from: d */
    public C2483g mo17568d(int i) {
        this.f10093ca = i;
        this.f10092c.setRequestedOrientation(aww.f6159e[i]);
        this.f10108j.setImageResource(aww.f6160f[i]);
        this.f10109k.setText(aww.f6161g[i]);
        return this;
    }

    /* renamed from: i */
    public void mo17579i() {
        if (!this.f10094cb) {
            m11460l(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m11460l(boolean z) {
        this.f10094cb = !this.f10094cb;
        if (this.f10096cd == null) {
            this.f10096cd = this.f10092c.findViewById(R.id.night_mode_mask);
        }
        if (this.f10094cb) {
            this.f10096cd.setBackgroundColor(Integer.MIN_VALUE);
            this.f10110l.setBackgroundResource(R.drawable.bg_btn_green);
            if (z) {
                axv.m7434a((int) R.string.night_on);
                return;
            }
            return;
        }
        this.f10096cd.setBackground((Drawable) null);
        this.f10110l.setBackgroundResource(R.drawable.bg_btn_grey);
        if (z) {
            axv.m7434a((int) R.string.night_off);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m11464m(boolean z) {
        this.f10095cc = !this.f10095cc;
        if (this.f10095cc) {
            this.f10102d.setVolume(0.0f);
            if (!z) {
                this.f10111m.setImageResource(R.drawable.ic_mute_on);
                axv.m7434a((int) R.string.mute_on);
                return;
            }
            return;
        }
        this.f10102d.setVolume(1.0f);
        if (!z) {
            this.f10111m.setImageResource(R.drawable.ic_mute_off);
            axv.m7434a((int) R.string.mute_off);
        }
    }

    /* renamed from: T */
    private void m11327T() {
        int i;
        if (this.f10094cb) {
            if (this.f10118t.getParent() != this.f10123y) {
                this.f10116r.removeView(this.f10118t);
                this.f10123y.addView(this.f10118t);
            }
            i = 3;
        } else {
            if (this.f10118t.getParent() != this.f10116r) {
                this.f10123y.removeView(this.f10118t);
                this.f10116r.addView(this.f10118t);
            }
            i = 2;
        }
        if (this.f10098cf) {
            if (this.f10119u.getParent() != this.f10123y) {
                this.f10116r.removeView(this.f10119u);
                this.f10123y.addView(this.f10119u);
            }
            i++;
        } else if (this.f10119u.getParent() != this.f10116r) {
            this.f10123y.removeView(this.f10119u);
            this.f10116r.addView(this.f10119u);
        }
        if (MyApplication.myApplication().mo17872c()) {
            if (MyApplication.myApplication().mo17874e()) {
                this.f10085bt = true;
            }
            this.f10113o.setVisibility(8);
            this.f10121w.setVisibility(0);
            if (this.f10120v.getParent() != this.f10123y) {
                this.f10116r.removeView(this.f10120v);
                this.f10123y.addView(this.f10120v);
            }
            i++;
        } else {
            this.f10113o.setVisibility(0);
            this.f10121w.setVisibility(8);
            if (this.f10120v.getParent() != this.f10116r) {
                this.f10123y.removeView(this.f10120v);
                this.f10116r.addView(this.f10120v);
            }
        }
        int i2 = aww.f6164j ? 8 : 7;
        if (this.f10092c.isInMultiWindowMode()) {
            i2--;
            i--;
            this.f10117s.setVisibility(8);
        }
        this.f10122x.mo17423a(i2, i);
        this.f10122x.mo17422a();
    }

    /* renamed from: e */
    public void mo17573e(int i) {
        if (i != -1) {
            this.f10032at = i;
        }
    }

    /* renamed from: j */
    public void mo17580j() {
        this.f10098cf = true;
        this.f10112n.setBackgroundResource(R.drawable.bg_btn_green);
        this.f10102d.getSettings().mo17549b(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m11441g(String str) {
        this.f10098cf = !this.f10098cf;
        if (this.f10098cf) {
            axv.m7434a((int) R.string.background_play_on);
            this.f10092c.finish();
            LogEvents.m18492b("PlayPage", "AudioMode/On" + str);
            LogEvents.m18495c(this.f9991aE);
        } else {
            axv.m7434a((int) R.string.background_play_off);
            C2779a.m12613a().mo18136b((Context) this.f10092c, false);
            LogEvents.m18492b("PlayPage", "AudioMode/Off" + str);
        }
        if (this.f10098cf) {
            this.f10112n.setBackgroundResource(R.drawable.bg_btn_green);
        } else {
            this.f10112n.setBackgroundResource(R.drawable.bg_btn_grey);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m11466n(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10026an.getLayoutParams();
        if (this.f10001aO) {
            if (Build.VERSION.SDK_INT < 23 || layoutParams.getRule(12) != -1) {
                layoutParams.removeRule(11);
                layoutParams.addRule(12);
                layoutParams.height = this.f10031as;
                layoutParams.width = -1;
            }
        } else if (Build.VERSION.SDK_INT < 23 || layoutParams.getRule(11) != -1) {
            layoutParams.addRule(11);
            layoutParams.removeRule(12);
            layoutParams.width = this.f10030ar;
            layoutParams.height = -1;
        }
        if (this.f10026an.getVisibility() != 0) {
            this.f10026an.clearAnimation();
            if (z) {
                this.f10026an.setAnimation(AnimationUtils.loadAnimation(this.f10092c, this.f10001aO ? R.anim.bottom_in : R.anim.right_in));
            }
            if (this.f10026an.getVisibility() != 0) {
                this.f10026an.setVisibility(0);
                m11329U();
            }
            if (this.f10027ao.getLayoutManager() == null) {
                this.f10027ao.setLayoutManager(new LinearLayoutManager(this.f10092c, 1, false));
                this.f10027ao.setAdapter(new C2523a());
            }
            final int i = this.f10009aW;
            if (i >= 0) {
                this.f10026an.post(new Runnable() {
                    public void run() {
                        C2483g.this.f10027ao.smoothScrollToPosition(i);
                    }
                });
            }
            m11469o(false);
            if (this.f10052bM) {
                this.f10028ap.postDelayed(new Runnable() {
                    public void run() {
                        int i;
                        if (C2483g.this.f10052bM && C2483g.this.f10092c != null && !C2483g.this.f10092c.isFinishing() && C2483g.this.f10026an.getVisibility() == 0) {
                            View inflate = LayoutInflater.from(C2483g.this.f10092c).inflate(R.layout.bookmark_url, (ViewGroup) null, false);
                            PopupWindow unused = C2483g.this.f10053bN = new PopupWindow(inflate, axw.m7444a((Context) C2483g.this.f10092c, 250.0f), -2, true);
                            boolean unused2 = C2483g.this.f10052bM = false;
                            if (C2483g.this.f10001aO) {
                                ((ImageView) inflate.findViewById(R.id.arrow_down)).setImageResource(R.drawable.ic_triangle);
                                if (Build.VERSION.SDK_INT >= 21) {
                                    inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                                    i = -(inflate.getMeasuredHeight() + C2483g.this.f10028ap.getHeight());
                                    C2483g.this.f10053bN.setBackgroundDrawable(new ColorDrawable());
                                    C2483g.this.f10053bN.showAsDropDown(C2483g.this.f10028ap, 0, i);
                                }
                            } else {
                                ((ImageView) inflate.findViewById(R.id.arrow_up)).setImageResource(R.drawable.ic_triangle_up);
                                if (Build.VERSION.SDK_INT >= 21) {
                                    i = -axw.m7444a(MyApplication.getApplicationContext_(), 10.0f);
                                    C2483g.this.f10053bN.setBackgroundDrawable(new ColorDrawable());
                                    C2483g.this.f10053bN.showAsDropDown(C2483g.this.f10028ap, 0, i);
                                }
                            }
                            i = 0;
                            C2483g.this.f10053bN.setBackgroundDrawable(new ColorDrawable());
                            C2483g.this.f10053bN.showAsDropDown(C2483g.this.f10028ap, 0, i);
                        }
                    }
                }, 500);
            }
        }
    }

    /* renamed from: o */
    private void m11469o(boolean z) {
        switch (this.f10032at) {
            case 0:
                this.f10028ap.setImageResource(R.drawable.ic_repeat_order);
                this.f10029aq.setText(R.string.repeat_order);
                if (z) {
                    LogEvents.m18492b("PlayPage", "RepeatMode/Order");
                    return;
                }
                return;
            case 1:
                this.f10028ap.setImageResource(R.drawable.ic_repeat_shuffle);
                this.f10029aq.setText(R.string.repeat_shuffle);
                if (z) {
                    LogEvents.m18492b("PlayPage", "RepeatMode/Shuffle");
                    return;
                }
                return;
            case 2:
                this.f10028ap.setImageResource(R.drawable.ic_repeat_repeat);
                this.f10029aq.setText(R.string.repeat_repeat);
                if (z) {
                    LogEvents.m18492b("PlayPage", "RepeatMode/Repeat");
                    return;
                }
                return;
            case 3:
                this.f10028ap.setImageResource(R.drawable.ic_repeat_loop);
                this.f10029aq.setText(R.string.repeat_loop);
                if (z) {
                    LogEvents.m18492b("PlayPage", "RepeatMode/Loop");
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: U */
    private void m11329U() {
        if (this.f10026an.getVisibility() == 0 && this.f10027ao.getAdapter() != null) {
            this.f10027ao.getAdapter().notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean m11473p(boolean z) {
        boolean z2;
        if (this.f10026an.getVisibility() != 8) {
            this.f10026an.clearAnimation();
            if (z) {
                this.f10026an.setAnimation(AnimationUtils.loadAnimation(this.f10092c, this.f10001aO ? R.anim.bottom_out : R.anim.right_out));
            }
            this.f10026an.setVisibility(8);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        m11376aa();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m11475q(boolean z) {
        this.f9987aA = -1;
        this.f9990aD = -1.0f;
        if (this.f10037ay >= 0) {
            this.f10086bu.removeMessages(3);
            this.f10086bu.sendEmptyMessage(3);
        }
        this.f10086bu.removeMessages(4);
        this.f10086bu.sendEmptyMessageDelayed(4, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public long m11331V() {
        long currentPosition = (long) this.f10102d.getCurrentPosition();
        long duration = (long) this.f10102d.getDuration();
        if (!this.f9999aM && this.f10025am != null) {
            if (duration > 0) {
                this.f10025am.setProgress((int) ((currentPosition * 1000) / duration));
            }
            if (this.f10083br) {
                this.f10025am.setSecondaryProgress(this.f10102d.getBufferPercentage() * 10);
            }
        }
        this.f10033au.setText(m11406b(currentPosition));
        this.f10034av.setText(m11406b(duration));
        if (this.f10085bt) {
            long j = duration - currentPosition;
            this.f10121w.setText(String.format(Locale.ENGLISH, "%02d:%02d", new Object[]{Long.valueOf(j / 60000), Long.valueOf((j / 1000) % 60)}));
        }
        return currentPosition;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m11406b(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        if (i4 > 0) {
            return String.format(Locale.ENGLISH, "%02d:%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)});
        }
        return String.format(Locale.ENGLISH, "%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
 /*   public void m11334W_() {
        if (this.f10102d.isPlaying()) {
            if (this.f9995aI) {
                this.f10013aa.setImageResource(R.mipmap.k5);
            } else {
                this.f10013aa.setImageResource(R.drawable.ec);
                this.f10019ag.setImageResource(R.mipmap.k2);
            }
          //  m11336X();
            return;
        }
        this.f10013aa.setImageResource(R.drawable.eh);
        this.f10019ag.setImageResource(R.mipmap.k3);
        if (this.f9996aJ) {
          //  m11337Y();
        }
    }*/
    public void m11334W() {
        if (!this.f10102d.isPlaying()) {
            this.f10013aa.setImageResource(R.drawable.ic_play);
            this.f10019ag.setImageResource(R.mipmap.simple_player_center_play);
           boolean z = this.f9996aJ;
        } else if (this.f9995aI) {
            this.f10013aa.setImageResource(R.mipmap.simple_player_stop_white_24dp);
        } else {
            this.f10013aa.setImageResource(R.drawable.ic_pause);
            this.f10019ag.setImageResource(R.mipmap.simple_player_center_pause);
        }
    }



    /* renamed from: Z */
    private void m11339Z() {
        switch (this.f10038az) {
            case 0:
                m11368a(false, (int) R.string.ratio_fit);
                return;
            case 1:
                m11368a(false, (int) R.string.ratio_fill);
                return;
            case 2:
                m11368a(false, (int) R.string.ratio_original);
                return;
            case 3:
                m11368a(false, (int) R.string.ratio_stretch);
                return;
            case 4:
                m11369a(false, "16:9");
                return;
            case 5:
                m11369a(false, "4:3");
                return;
            case 6:
                m11369a(false, "18:9");
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11348a(float f) {
        int i = 0;
        if (this.f9987aA == -1) {
            int i2 = this.f9989aC;
            if (this.f10095cc) {
                i2 = 0;
            }
            this.f9987aA = i2;
            if (this.f9987aA < 0) {
                this.f9987aA = 0;
            }
        }
        int i3 = this.f9989aC;
        int i4 = (int) (f * ((float) this.f9988aB));
        int i5 = this.f9987aA + i4;
        if (i5 > this.f9988aB) {
            i = this.f9988aB;
        } else if (i5 >= 0) {
            i = i5;
        }
        if (i4 != 0) {
            m11439g(i);
        }
        m11444h(i);
        boolean unused = this.f10101ci.f10192c = true;
        if (i > this.f9988aB && i > i3 && i3 <= this.f9988aB) {
            LogEvents.m18484a("PlayPage", "Volume/Boost");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11409b(float f) {
        m11420c((long) (f * 22000.0f));
    }

    /* renamed from: c */
    private void m11420c(long j) {
        int i;
        if (!this.f10000aN) {
            i = this.f10102d.getCurrentPosition();
        } else if (this.f10047bH <= 0) {
            i = this.f10102d.getCurrentPosition();
            this.f10047bH = i;
        } else {
            i = this.f10047bH;
        }
        long duration = (long) this.f10102d.getDuration();
        long j2 = (long) i;
        this.f10037ay = j + j2;
        if (this.f10037ay > duration) {
            this.f10037ay = duration;
            j = duration - j2;
        } else if (this.f10037ay <= 0) {
            this.f10037ay = 0;
            j = (long) (-i);
        }
        if (Math.abs(j) < 500) {
            this.f10037ay = -1;
        }
        int i2 = ((int) j) / 1000;
        if (i2 != 0) {
            this.f9973M.setVisibility(0);
            m11320P();
            boolean z = i2 > 0;
            TextView textView = this.f9974N;
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[2];
            objArr[0] = z ? "+" : "-";
            objArr[1] = m11406b((long) Math.abs(i2 * 1000));
            textView.setText(String.format(locale, "[%s%s]", objArr));
            this.f9975O.setText(m11406b(this.f10037ay));
            boolean unused = this.f10101ci.f10192c = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11349a(int i, int i2) {
        if (i2 > 1) {
            this.f10048bI = 0;
            this.f10047bH = 0;
        } else {
            if (this.f10048bI > 0) {
                i2 = this.f10048bI;
            }
            this.f10048bI++;
        }
        m11420c((long) (i * i2));
        this.f10086bu.sendMessageDelayed(this.f10086bu.obtainMessage(11, i, i2 + 1), i2 == 1 ? 500 : 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11419c(float f) {
        if (this.f9990aD < 0.0f) {
            this.f9990aD = this.f10092c.getWindow().getAttributes().screenBrightness;
            if (this.f9990aD <= 0.0f) {
                this.f9990aD = 0.5f;
            } else if (this.f9990aD < 0.01f) {
                this.f9990aD = 0.01f;
            }
        }
        this.f9969I.setVisibility(0);
        this.f9970J.setVisibility(0);
        WindowManager.LayoutParams attributes = this.f10092c.getWindow().getAttributes();
        attributes.screenBrightness = this.f9990aD + f;
        if (attributes.screenBrightness > 1.0f) {
            attributes.screenBrightness = 1.0f;
        } else if (attributes.screenBrightness < 0.01f) {
            attributes.screenBrightness = 0.01f;
        }
        TextView textView = this.f9971K;
        textView.setText(((int) (attributes.screenBrightness * 100.0f)) + "%");
        this.f9972L.setSecondaryProgress((int) (attributes.screenBrightness * 100.0f));
        this.f10092c.getWindow().setAttributes(attributes);
        boolean unused = this.f10101ci.f10192c = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean m11480r(boolean z) {
        if (this.f10007aU != null) {
            int b = this.f10032at == 1 ? m11404b(this.f10009aW, 1) : this.f10009aW + 1;
            if (b >= this.f10007aU.size() && (this.f10032at == 3 || this.f10032at == 2)) {
                b = 0;
            }
            if (m11414b(b, z)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public boolean m11484s(boolean z) {
        if (this.f10007aU == null) {
            return false;
        }
        int b = this.f10032at == 1 ? m11404b(this.f10009aW, -1) : this.f10009aW - 1;
        if (b < 0 && (this.f10032at == 3 || this.f10032at == 2)) {
            b = this.f10007aU.size() - 1;
        }
        if (m11414b(b, z)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private int m11404b(int i, int i2) {
        if (this.f10007aU == null || this.f10007aU.isEmpty()) {
            return 0;
        }
        return axi.m7351a(this.f10007aU, i, i2);
    }

    /* renamed from: b */
    private boolean m11414b(int i, boolean z) {
        VideoPlayListBean videoPlayListBean;
        if (i < 0 || i >= this.f10007aU.size() || (videoPlayListBean = this.f10007aU.get(i)) == null || videoPlayListBean.f9813a == null) {
            return false;
        }
        if (z) {
            m11494w();
        }
        this.f10009aW = i;
        m11329U();
        if (this.f10058bS != null) {
            this.f10058bS.dismiss();
            this.f10058bS = null;
        }
        m11354a(videoPlayListBean);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11354a(VideoPlayListBean videoPlayListBean) {
        mo17565c(videoPlayListBean.f9815c);
        if (this.f10004aR) {
            mo17569d(videoPlayListBean.f9817e);
        }
        mo17560b(videoPlayListBean.f9819g);
        mo17551a(videoPlayListBean.f9818f);
        mo17561b(videoPlayListBean.f9813a);
        this.f10084bs.m11563a();
        this.f10020ah.setImageResource(aww.f6163i[this.f10038az]);
        if (!SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("playResume", true) || this.f10098cf || C2779a.m12613a().mo18135b() || videoPlayListBean.f9816d <= 0 || videoPlayListBean.f9816d >= videoPlayListBean.f9814b - 100) {
            this.f10036ax = 0;
        } else {
            mo17564c((int) videoPlayListBean.f9816d);
            final String str = videoPlayListBean.f9813a;
            axv.m7437a(mo17577g(), R.string.resume_auto, this.f10092c.getString(R.string.start_over), new View.OnClickListener() {
                public void onClick(View view) {
                    if (!C2483g.this.f10046bG) {
                        C2483g.this.mo17574e(str);
                    }
                }
            });
        }
        this.f10086bu.sendEmptyMessage(5);
    }

    /* access modifiers changed from: private */
    /* renamed from: aa */
    public void m11376aa() {
        if (!this.f10046bG) {
            m11378ab();
            this.f10086bu.postDelayed(this.f10087bv, 3000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ab */
    public void m11378ab() {
        this.f10086bu.removeCallbacks(this.f10087bv);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11369a(boolean z, String str) {
        this.f10099cg.setTextSize(2, z ? 70.0f : 39.0f);
        this.f10099cg.setText(str);
        this.f10099cg.clearAnimation();
        this.f10099cg.setVisibility(0);
        this.f10086bu.removeCallbacks(this.f10100ch);
        this.f10086bu.postDelayed(this.f10100ch, 1000);
    }

    /* renamed from: a */
    private void m11368a(boolean z, int i) {
        m11369a(z, this.f10039b.getString(i));
    }

    /* renamed from: a */
    public boolean mo17544a() {
        if (!this.f10102d.isPlaying()) {
            return false;
        }
        m11442g(true);
        return true;
    }

    /* renamed from: a */
    public void mo17543a(int i) {
        if (!this.f10102d.isPlaying()) {
            mo17576f();
            if (awt.m7200a(i, 2)) {
                this.f10102d.seekTo(this.f10036ax);
            }
        }
    }

    /* renamed from: k */
    public String mo10919k() {
        if (this.f9991aE == null) {
            return "null";
        }
        File file = new File(this.f9991aE);
        StringBuilder sb = new StringBuilder("name:");
        if (file.exists()) {
            sb.append(file.getName());
            sb.append(",size:");
            sb.append(String.valueOf(file.length()));
        } else {
            sb.append(this.f9992aF);
            sb.append(",url:");
            sb.append(this.f9991aE);
        }
        sb.append(",audioMode:");
        sb.append(String.valueOf(this.f10098cf));
        sb.append(",duration:");
        sb.append(String.valueOf(m11498y()));
        ITrackInfo[] trackInfo = this.f10102d.getTrackInfo();
        if (trackInfo != null) {
            int i = 0;
            for (ITrackInfo bVar : trackInfo) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("#");
                sb.append(String.valueOf(i));
                sb.append(":");
                if (bVar != null) {
                    sb.append(bVar.getInfoInline());
                }
                i++;
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x010f  */
    /* renamed from: ac */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11379acc() {
        /*
            r18 = this;
            r0 = r18
            com.inshot.xplayer.activities.PlayerActivity r1 = r0.f10092c
            if (r1 == 0) goto L_0x018b
            com.inshot.xplayer.activities.PlayerActivity r1 = r0.f10092c
            boolean r1 = r1.isFinishing()
            if (r1 == 0) goto L_0x0010
            goto L_0x018b
        L_0x0010:
            com.inshot.xplayer.activities.PlayerActivity r1 = r0.f10092c
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            r2 = 2131427459(0x7f0b0083, float:1.8476535E38)
            r3 = 0
            r4 = 0
            android.view.View r1 = r1.inflate(r2, r3, r4)
            r2 = 2131296979(0x7f0902d3, float:1.821189E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r5 = r0.f9992aF
            r2.setText(r5)
            boolean r2 = r0.f10004aR
            if (r2 == 0) goto L_0x003c
            com.inshot.xplayer.activities.PlayerActivity r2 = r0.f10092c
            r5 = jd(0x7f0e017c, float:1.8875808E38)
            java.lang.String r2 = r2.getString(r5)
        L_0x003a:
            r5 = r3
            goto L_0x0056
        L_0x003c:
            java.io.File r2 = new java.io.File
            java.lang.String r5 = r0.f9991aE
            r2.<init>(r5)
            boolean r5 = r2.exists()
            if (r5 == 0) goto L_0x0053
            java.lang.String r5 = r2.getParent()
            r17 = r5
            r5 = r2
            r2 = r17
            goto L_0x0056
        L_0x0053:
            java.lang.String r2 = r0.f9991aE
            goto L_0x003a
        L_0x0056:
            r6 = 2131296978(0x7f0902d2, float:1.8211888E38)
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r6.setText(r2)
            r2 = 8
            r6 = 1
            if (r5 == 0) goto L_0x00b6
            r7 = 2131296981(0x7f0902d5, float:1.8211894E38)
            android.view.View r7 = r1.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.util.Locale r8 = java.util.Locale.ENGLISH
            java.lang.String r9 = "%s (%s bytes)"
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            long r11 = r5.length()
            java.lang.String r11 = p000.awt.m7196a((long) r11)
            r10[r4] = r11
            java.util.Locale r11 = java.util.Locale.US
            java.text.NumberFormat r11 = java.text.NumberFormat.getNumberInstance(r11)
            long r12 = r5.length()
            java.lang.String r11 = r11.format(r12)
            r10[r6] = r11
            java.lang.String r8 = java.lang.String.format(r8, r9, r10)
            r7.setText(r8)
            r7 = 2131296975(0x7f0902cf, float:1.8211882E38)
            android.view.View r7 = r1.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.text.DateFormat r8 = java.text.DateFormat.getDateInstance(r4)
            java.util.Date r9 = new java.util.Date
            long r10 = r5.lastModified()
            r9.<init>(r10)
            java.lang.String r5 = r8.format(r9)
            r7.setText(r5)
            goto L_0x00ca
        L_0x00b6:
            r5 = 2131296823(0x7f090237, float:1.8211574E38)
            android.view.View r5 = r1.findViewById(r5)
            r5.setVisibility(r2)
            r5 = 2131296447(0x7f0900bf, float:1.821081E38)
            android.view.View r5 = r1.findViewById(r5)
            r5.setVisibility(r2)
        L_0x00ca:
            r5 = 2131296977(0x7f0902d1, float:1.8211886E38)
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            long r7 = r18.m11498y()
            java.lang.String r7 = p000.axy.m7459a((long) r7)
            r5.setText(r7)
            java.lang.String r5 = r0.f9992aF
            java.lang.String r5 = p000.axe.m7324e(r5)
            if (r5 != 0) goto L_0x00f1
            r5 = format_layout(0x7f09010a, float:1.8210963E38)
            android.view.View r5 = r1.findViewById(r5)
            r5.setVisibility(r2)
            goto L_0x00fd
        L_0x00f1:
            r7 = 2131296976(0x7f0902d0, float:1.8211884E38)
            android.view.View r7 = r1.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setText(r5)
        L_0x00fd:
            r5 = 2131296750(0x7f0901ee, float:1.8211425E38)
            android.view.View r5 = r1.findViewById(r5)
            r5.setVisibility(r2)
            com.inshot.inplayer.widget.XVideoView r2 = r0.f10102d
            com.inshot.inplayer.misc.b[] r2 = r2.getTrackInfo()
            if (r2 == 0) goto L_0x0160
            r5 = 2131296719(0x7f0901cf, float:1.8211363E38)
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TableLayout r5 = (android.widget.TableLayout) r5
            int r7 = r2.length
            r8 = 0
            r9 = 0
        L_0x011b:
            if (r8 >= r7) goto L_0x0160
            r10 = r2[r8]
            com.inshot.xplayer.activities.PlayerActivity r11 = r0.f10092c
            android.view.LayoutInflater r11 = android.view.LayoutInflater.from(r11)
            r12 = 2131427439(0x7f0b006f, float:1.8476494E38)
            android.view.View r11 = r11.inflate(r12, r5, r4)
            r12 = 2131296578(0x7f090142, float:1.8211077E38)
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r13 = 2131296973(0x7f0902cd, float:1.8211878E38)
            android.view.View r13 = r11.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.util.Locale r14 = java.util.Locale.ENGLISH
            java.lang.String r15 = "Stream #%d"
            java.lang.Object[] r3 = new java.lang.Object[r6]
            int r9 = r9 + r6
            java.lang.Integer r16 = java.lang.Integer.valueOf(r9)
            r3[r4] = r16
            java.lang.String r3 = java.lang.String.format(r14, r15, r3)
            r12.setText(r3)
            java.lang.String r3 = r10.mo17417d()
            r13.setText(r3)
            r5.addView(r11)
            int r8 = r8 + 1
            r3 = 0
            goto L_0x011b
        L_0x0160:
            boolean r2 = r18.mo17544a()
            android.support.v7.app.AlertDialog$Builder r3 = new android.support.v7.app.AlertDialog$Builder
            com.inshot.xplayer.activities.PlayerActivity r4 = r0.f10092c
            r3.<init>(r4)
            r4 = 2131624319(0x7f0e017f, float:1.8875814E38)
            android.support.v7.app.AlertDialog$Builder r3 = r3.setTitle((int) r4)
            android.support.v7.app.AlertDialog$Builder r1 = r3.setView((android.view.View) r1)
            r3 = 2131624278(0x7f0e0156, float:1.8875731E38)
            r4 = 0
            android.support.v7.app.AlertDialog$Builder r1 = r1.setPositiveButton((int) r3, (android.content.DialogInterface.OnClickListener) r4)
            com.inshot.inplayer.widget.g$29 r3 = new com.inshot.inplayer.widget.g$29
            r3.<init>(r2)
            android.support.v7.app.AlertDialog$Builder r1 = r1.setOnDismissListener(r3)
            r1.show()
            return
        L_0x018b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.inplayer.widget.C2483g.m11379ac():void");
    }
    private void m11379acd() {
        File file;
        String str;
        String e2;
        ITrackInfo[] trackInfo;
        if (!(this.f10092c == null || this.f10092c.isFinishing())) {
            View inflate = LayoutInflater.from(this.f10092c).inflate(R.layout.layout_property, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(R.id.value_name)).setText(this.f9992aF);
            if (this.f10004aR) {
                str = this.f10092c.getString(R.string.private_videos);
            } else {
                File file2 = new File(this.f9991aE);
                if (file2.exists()) {
                    file = file2;
                    str = file2.getParent();
                    ((TextView) inflate.findViewById(R.id.value_location)).setText(str);
                    if (file == null) {
                        ((TextView) inflate.findViewById(R.id.value_size)).setText(String.format(Locale.ENGLISH, "%s (%s bytes)", awt.m7196a(file.length()), NumberFormat.getNumberInstance(Locale.US).format(file.length())));
                        ((TextView) inflate.findViewById(R.id.value_date)).setText(DateFormat.getDateInstance(0).format(new Date(file.lastModified())));
                    } else {
                        inflate.findViewById(R.id.size_layout).setVisibility(8);
                        inflate.findViewById(R.id.date_layout).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.id.value_length)).setText(axy.m7459a(m11498y()));
                    e2 = axe.m7324e(this.f9992aF);
                    if (e2 != null) {
                        inflate.findViewById(R.id.format_layout).setVisibility(8);
                    } else {
                        ((TextView) inflate.findViewById(R.id.value_format)).setText(e2);
                    }
                    inflate.findViewById(R.id.resolution_layout).setVisibility(8);
                    trackInfo = this.f10102d.getTrackInfo();
                    if (trackInfo != null) {
                        TableLayout tableLayout = (TableLayout) inflate.findViewById(R.id.property_layout);
                        int i2 = 0;
                        for (ITrackInfo bVar : trackInfo) {
                            View inflate2 = LayoutInflater.from(this.f10092c).inflate(R.layout.item_property, (ViewGroup) tableLayout, false);
                            i2++;
                            ((TextView) inflate2.findViewById(R.id.key)).setText(String.format(Locale.ENGLISH, "Stream #%d", Integer.valueOf(i2)));
                            ((TextView) inflate2.findViewById(R.id.value)).setText(bVar.getInfoInline());
                            tableLayout.addView(inflate2);
                        }
                    }
                    final boolean a2 = mo17544a();
                    new AlertDialog.Builder(this.f10092c).setTitle(R.string.properties).setView(inflate).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).setOnDismissListener(new DialogInterface.OnDismissListener() {
                        /* class com.inshot.inplayer.widget.g.AnonymousClass29 */

                        public void onDismiss(DialogInterface dialogInterface) {
                            if (!C2483g.this.f10046bG && a2) {
                                C2483g.this.mo17543a(0);
                            }
                        }
                    }).show();
                }
                str = this.f9991aE;
            }
            file = null;
            ((TextView) inflate.findViewById(R.id.value_location)).setText(str);
            if (file == null) {
            }
            ((TextView) inflate.findViewById(R.id.value_length)).setText(axy.m7459a(m11498y()));
            e2 = axe.m7324e(this.f9992aF);
            if (e2 != null) {
            }
            inflate.findViewById(R.id.resolution_layout).setVisibility(8);
            trackInfo = this.f10102d.getTrackInfo();
            if (trackInfo != null) {
            }
            final boolean a22 = mo17544a();
            new AlertDialog.Builder(this.f10092c).setTitle(R.string.properties).setView(inflate).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).setOnDismissListener(new DialogInterface.OnDismissListener() {


                public void onDismiss(DialogInterface dialogInterface) {
                    if (!C2483g.this.f10046bG && a22) {
                        C2483g.this.mo17543a(0);
                    }
                }
            }).show();
        }
    }
    private void m11379ace() {
        if (this.f10092c != null && !this.f10092c.isFinishing()) {
            final View inflate = LayoutInflater.from((Context)this.f10092c).inflate(R.layout.layout_property, (ViewGroup)null, false);
            ((TextView)inflate.findViewById(R.id.value_name)).setText((CharSequence)this.f9992aF);
            String text = null;
            File file = null;
            Label_0111: {
                if (this.f10004aR) {
                    text = this.f10092c.getString(R.string.private_videos);
                }
                else {
                    file = new File(this.f9991aE);
                    if (file.exists()) {
                        text = file.getParent();
                        break Label_0111;
                    }
                    text = this.f9991aE;
                }
                file = null;
            }
            ((TextView)inflate.findViewById(R.id.value_location)).setText((CharSequence)text);
            if (file != null) {
                ((TextView)inflate.findViewById(R.id.value_size)).setText((CharSequence)String.format(Locale.ENGLISH, "%s (%s bytes)", awt.m7196a(file.length()), NumberFormat.getNumberInstance(Locale.US).format(file.length())));
                ((TextView)inflate.findViewById(R.id.value_date)).setText((CharSequence)DateFormat.getDateInstance(0).format(new Date(file.lastModified())));
            }
            else {
                inflate.findViewById(R.id.size_layout).setVisibility(8);
                inflate.findViewById(R.id.date_layout).setVisibility(8);
            }
            ((TextView)inflate.findViewById(R.id.value_length)).setText((CharSequence)axy.m7459a(this.m11498y()));
            final String e = axe.m7324e(this.f9992aF);
            if (e == null) {
                inflate.findViewById(R.id.format_layout).setVisibility(8);
            }
            else {
                ((TextView)inflate.findViewById(R.id.value_format)).setText((CharSequence)e);
            }
            inflate.findViewById(R.id.resolution_layout).setVisibility(8);
            final  ITrackInfo[] trackInfo = this.f10102d.getTrackInfo();
            if (trackInfo != null) {
                final TableLayout tableLayout = (TableLayout)inflate.findViewById(R.id.property_layout);
                final int length = trackInfo.length;
                int i = 0;
                int j = 0;
                while (i < length) {
                    final ITrackInfo b = trackInfo[i];
                    final View inflate2 = LayoutInflater.from((Context)this.f10092c).inflate(R.layout.item_property, (ViewGroup)tableLayout, false);
                    final TextView textView = (TextView)inflate2.findViewById(R.id.key);
                    final TextView textView2 = (TextView)inflate2.findViewById(R.id.value);
                    final Locale english = Locale.ENGLISH;
                    ++j;
                    textView.setText((CharSequence)String.format(english, "Stream #%d", Integer.valueOf(j)));
                    textView2.setText((CharSequence)b.getInfoInline());
                    tableLayout.addView(inflate2);
                    ++i;
                }
            }
            new AlertDialog.Builder((Context)this.f10092c).setTitle(R.string.properties).setView(inflate).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener)null).setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!C2483g.this.f10046bG && mo17544a()) {
                        C2483g.this.mo17543a(0);
                    }
                }
            }).show();
        }
    }
    private void m11379ac() {
        if (this.f10092c != null && !this.f10092c.isFinishing()) {
            View var1;
            String var2;
            File var3;
            label40: {
                var1 = LayoutInflater.from(this.f10092c).inflate(R.layout.layout_property, (ViewGroup)null, false);
                ((TextView)var1.findViewById(R.id.value_name)).setText(this.f9992aF);
                if (this.f10004aR) {
                    var2 = this.f10092c.getString(R.string.private_videos);
                } else {
                    var3 = new File(this.f9991aE);
                    if (var3.exists()) {
                        var2 = var3.getParent();
                        break label40;
                    }

                    var2 = this.f9991aE;
                }

                var3 = null;
            }

            ((TextView)var1.findViewById(R.id.value_location)).setText(var2);
            if (var3 != null) {
                ((TextView)var1.findViewById(R.id.value_size)).setText(String.format(Locale.ENGLISH, "%s (%s bytes)", awt.m7196a(var3.length()), NumberFormat.getNumberInstance(Locale.US).format(var3.length())));
                ((TextView)var1.findViewById(R.id.value_date)).setText(DateFormat.getDateInstance(0).format(new Date(var3.lastModified())));
            } else {
                var1.findViewById(R.id.size_layout).setVisibility(8);
                var1.findViewById(R.id.date_layout).setVisibility(8);
            }

            ((TextView)var1.findViewById(R.id.value_length)).setText(axy.m7459a(this.m11498y()));
            var2 = axe.m7324e(this.f9992aF);
            if (var2 == null) {
                var1.findViewById(R.id.format_layout).setVisibility(8);
            } else {
                ((TextView)var1.findViewById(R.id.value_format)).setText(var2);
            }

            var1.findViewById(R.id.resolution_layout).setVisibility(8);
            ITrackInfo[] var4 = this.f10102d.getTrackInfo();
            if (var4 != null) {
                TableLayout var14 = (TableLayout)var1.findViewById(R.id.property_layout);
                int var5 = var4.length;
                int var6 = 0;

                for(int var7 = 0; var6 < var5; ++var6) {
                    ITrackInfo var8 = var4[var6];
                    View var9 = LayoutInflater.from(this.f10092c).inflate(R.layout.item_property, var14, false);
                    TextView var10 = (TextView)var9.findViewById(R.id.key);
                    TextView var11 = (TextView)var9.findViewById(R.id.value);
                    Locale var13 = Locale.ENGLISH;
                    ++var7;
                    var10.setText(String.format(var13, "Stream #%d", var7));
                    var11.setText(var8.getInfoInline());
                    var14.addView(var9);
                }
            }

            boolean var12 = this.mo17544a();
            (new AlertDialog.Builder(this.f10092c)).setTitle(R.string.properties).setView(var1).setPositiveButton(R.string.ok, (android.content.DialogInterface.OnClickListener)null).setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!C2483g.this.f10046bG && var12) {
                        C2483g.this.mo17543a(0);
                    }
                }
            }).show();
        }
    }


    /* renamed from: com.inshot.inplayer.widget.g$c */
    private class C2525c implements View.OnTouchListener {

        /* renamed from: b */
        private boolean f10191b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f10192c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f10193d;

        /* renamed from: e */
        private final GestureDetector f10194e;

        /* renamed from: f */
        private int f10195f;

        /* renamed from: g */
        private boolean f10196g;

        private C2525c() {
            this.f10194e = new GestureDetector(C2483g.this.f10039b, new C2524b());
            this.f10195f = axw.m7444a(MyApplication.getApplicationContext_(), 40.0f);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z = false;
            if (C2483g.this.f10046bG) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.f10196g = motionEvent.getY() < ((float) this.f10195f) || motionEvent.getY() > ((float) (view.getHeight() - this.f10195f));
                this.f10193d = false;
                this.f10191b = false;
                this.f10192c = false;
            }
            if (this.f10196g || this.f10193d) {
                return false;
            }
            if (!this.f10192c) {
                C2483g.this.f10084bs.f10198b.onTouchEvent(motionEvent);
            }
            if (!this.f10192c && C2483g.this.f10084bs.f10198b.isInProgress()) {
                C2483g.this.m11475q(true);
                this.f10191b = true;
            } else if (!this.f10191b && motionEvent.getPointerCount() <= 1) {
                z = this.f10194e.onTouchEvent(motionEvent);
            }
            if ((motionEvent.getAction() & 255) == 1) {
                C2483g.this.m11475q(true);
            }
            return z;
        }
    }

    /* renamed from: com.inshot.inplayer.widget.g$b */
    private class C2524b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b */
        private boolean f10186b;

        /* renamed from: c */
        private boolean f10187c;

        /* renamed from: d */
        private boolean f10188d;

        /* renamed from: e */
        private boolean f10189e;

        private C2524b() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.f10186b = true;
            this.f10189e = false;
            return super.onDown(motionEvent);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (C2483g.this.f9997aK) {
                return super.onDoubleTap(motionEvent);
            }
            if (C2483g.this.mo17544a()) {
                C2483g.this.f10092c.mo17679a(false);
                C2483g.this.f10092c.mo17680b();
                C2483g.this.f10092c.mo17681c();
            } else {
                C2483g.this.f10092c.mo17679a(true);
                C2483g.this.f10092c.mo17676a();
                C2483g.this.f10092c.mo17682d();
                C2483g.this.mo17543a(0);
            }
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (C2483g.this.f10046bG) {
                return false;
            }
            if (!C2483g.this.f9997aK) {
                float x = motionEvent.getX();
                float y = motionEvent.getY() - motionEvent2.getY();
                float x2 = x - motionEvent2.getX();
                if (this.f10186b) {
                    this.f10188d = Math.abs(f) >= Math.abs(f2);
                    this.f10187c = x > ((float) C2483g.this.f10039b.getResources().getDisplayMetrics().widthPixels) * 0.5f;
                    if (this.f10187c) {
                        C2483g.this.m11296D();
                    }
                    this.f10186b = false;
                }
                if (!this.f10188d) {
                    float height = y / ((float) C2483g.this.f10102d.getHeight());
                    if (this.f10187c) {
                        C2483g.this.m11348a(height);
                        if (!this.f10189e) {
                            this.f10189e = true;
                        }
                    } else {
                        C2483g.this.m11419c(height);
                        if (!this.f10189e) {
                            this.f10189e = true;
                        }
                    }
                } else if (!C2483g.this.f9995aI) {
                    C2483g.this.m11409b(axw.m7442a(MyApplication.getApplicationContext_(), -x2, C2483g.this.f10001aO));
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (C2483g.this.f10046bG) {
                return false;
            }
            return C2483g.this.m11473p(true);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (C2483g.this.f10046bG) {
                return false;
            }
            if (C2483g.this.f10010aX.mo11003b()) {
                C2483g.this.f10010aX.mo11004c();
                return true;
            }
            C2483g.this.f10010aX.mo11002b(C2483g.this.f9997aK);
            return true;
        }
    }

    /* renamed from: com.inshot.inplayer.widget.g$d */
    private class C2526d implements ScaleGestureDetector.OnScaleGestureListener {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public ScaleGestureDetector f10198b;

        /* renamed from: c */
        private float f10199c;

        /* renamed from: d */
        private int f10200d;

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        private C2526d() {
            this.f10199c = 1.0f;
            this.f10200d = 100;
            this.f10198b = new ScaleGestureDetector(C2483g.this.f10102d.getContext(), this);
            if (Build.VERSION.SDK_INT >= 19) {
                this.f10198b.setQuickScaleEnabled(false);
            }
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = this.f10199c * scaleGestureDetector.getScaleFactor();
            float f = 8.0f;
            if (scaleFactor <= 8.0f) {
                f = scaleFactor < 0.25f ? 0.25f : scaleFactor;
            }
            this.f10199c = f;
            int a = m11562a(f);
            if (this.f10200d != a) {
                this.f10200d = a;
                C2483g.this.f10102d.setScaleX(f);
                C2483g.this.f10102d.setScaleY(f);
                C2483g gVar = C2483g.this;
                gVar.m11369a(true, a + "%");
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return !C2483g.this.f9997aK;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m11563a() {
            this.f10199c = 1.0f;
            if (this.f10200d != 100) {
                this.f10200d = 100;
                C2483g.this.f10102d.setScaleX(this.f10199c);
                C2483g.this.f10102d.setScaleY(this.f10199c);
            }
        }

        /* renamed from: a */
        private int m11562a(float f) {
            return Math.round(f * 100.0f);
        }
    }

    /* renamed from: com.inshot.inplayer.widget.g$a */
    private class C2523a extends RecyclerView.Adapter<C2527e> implements View.OnClickListener {

        /* renamed from: b */
        private int f10183b;

        /* renamed from: c */
        private int f10184c;

        private C2523a() {
            this.f10183b = -419463168;
            this.f10184c = -2130706433;
        }

        /* renamed from: a */
        public C2527e onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C2527e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.play_list_item, viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(C2527e eVar, int i) {
            String str;
            String str2;
            VideoPlayListBean videoPlayListBean = (VideoPlayListBean) C2483g.this.f10007aU.get(i);
            String str3 = null;
            if (videoPlayListBean == null) {
                str = null;
            } else {
                str = videoPlayListBean.f9813a;
            }
            if (videoPlayListBean == null) {
                str2 = null;
            } else {
                str2 = videoPlayListBean.f9815c;
            }
            boolean equals = TextUtils.equals(str, C2483g.this.f9991aE);
            eVar.f10201a.setText(str2);
            eVar.f10201a.setTextColor(equals ? this.f10183b : this.f10184c);
            TextView textView = eVar.f10203c;
            if (videoPlayListBean != null) {
                str3 = axy.m7459a(videoPlayListBean.f9814b);
            }
            textView.setText(str3);
            eVar.itemView.setBackgroundResource(equals ? R.drawable.play_list_black_selector : R.drawable.btn_black_selector);
            Glide.with((FragmentActivity) C2483g.this.f10092c).load(videoPlayListBean == null ? "" : videoPlayListBean.f9813a).asBitmap()
                    .centerCrop().decoder((ResourceDecoder<ImageVideoWrapper, Bitmap>) new awy(videoPlayListBean == null ? "" : videoPlayListBean.f9813a, C2483g.this.f10039b, videoPlayListBean == null ? 0 : videoPlayListBean.f9814b)).into(eVar.f10202b);
            eVar.itemView.setTag(Integer.valueOf(i));
            eVar.itemView.setOnClickListener(this);
        }

        public int getItemCount() {
            if (C2483g.this.f10007aU == null) {
                return 0;
            }
            return C2483g.this.f10007aU.size();
        }

        public void onClick(View view) {
            if (!C2483g.this.f10092c.isFinishing() && (view.getTag() instanceof Integer)) {
                LogEvents.m18492b("PlayPage", "PlayList/Play");
                int intValue = ((Integer) view.getTag()).intValue();
                VideoPlayListBean videoPlayListBean = (VideoPlayListBean) C2483g.this.f10007aU.get(intValue);
                if (videoPlayListBean != null && videoPlayListBean.f9813a != null) {
                    C2483g.this.m11494w();
                    int unused = C2483g.this.f10009aW = intValue;
                    C2483g.this.m11354a(videoPlayListBean);
                    boolean unused2 = C2483g.this.m11473p(true);
                    notifyDataSetChanged();
                }
            }
        }
    }

    /* renamed from: com.inshot.inplayer.widget.g$e */
    private class C2527e extends RecyclerView.ViewHolder {

        /* renamed from: a */
        public final TextView f10201a;

        /* renamed from: b */
        public final ImageView f10202b;

        /* renamed from: c */
        public final TextView f10203c;

        public C2527e(View view) {
            super(view);
            this.f10201a = (TextView) view.findViewById(R.id.play_list_title);
            this.f10202b = (ImageView) view.findViewById(R.id.icon);
            this.f10203c = (TextView) view.findViewById(R.id.duration);
        }
    }

    /* renamed from: l */
    public void mo10966l() {
        if (!C2779a.m12613a().mo18135b() && mo17544a()) {
            this.f10092c.mo17679a(false);
            this.f10092c.mo17680b();
            this.f10092c.mo17681c();
            if (!this.f9997aK) {
                m11446h(false);
            }
        }
    }

    /* renamed from: m */
    public void mo10967m() {
        if (C2779a.m12613a().mo18135b()) {
            return;
        }
        if (mo17544a()) {
            this.f10092c.mo17679a(false);
            this.f10092c.mo17680b();
            this.f10092c.mo17681c();
            if (!this.f9997aK) {
                m11446h(false);
                return;
            }
            return;
        }
        mo17543a(0);
        m11376aa();
    }

    /* renamed from: n */
    public void mo10968n() {
        if (!C2779a.m12613a().mo18135b()) {
            mo17543a(0);
            m11376aa();
        }
    }

    /* renamed from: o */
    public void mo10969o() {
        if (!C2779a.m12613a().mo18135b() && mo17544a()) {
            this.f10092c.mo17679a(false);
            this.f10092c.mo17680b();
            this.f10092c.mo17681c();
            if (!this.f9997aK) {
                m11446h(false);
            }
        }
    }

    /* renamed from: p */
    public void mo10970p() {
        if (!C2779a.m12613a().mo18135b() && !m11480r(true)) {
            axv.m7434a((int) R.string.no_next_video);
        }
    }

    /* renamed from: q */
    public void mo10971q() {
        if (!C2779a.m12613a().mo18135b() && !m11484s(true)) {
            axv.m7434a((int) R.string.no_previous_video);
        }
    }
}
