package com.us.rateus;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.us.rateus.general.RateConstant;
import com.us.rateus.general.RatingTheme;
import com.us.rateus.general.RatingInterface;
import com.us.rateus.view.RatingViewAnimation;
import com.us.rateus.view.StarCheckView;

import java.util.ArrayList;
import java.util.Locale;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: c */
public class RatingDialog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public StarCheckView f10472a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public StarCheckView f10473b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public StarCheckView f10474c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public StarCheckView f10475d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public StarCheckView f10476e;

    /* renamed from: f */
    private TextView f10477f;

    /* renamed from: g */
    private TextView f10478g;

    /* renamed from: h */
    private TextView f10479h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ImageView f10480i;

    /* renamed from: j */
    private TextView f10481j;

    /* renamed from: k */
    private LinearLayout f10482k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Dialog f10483l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public RatingViewAnimation f10484m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f10485n = 0;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo20093a(final Context context, final RateConstant avo, final RatingInterface avq, boolean z) {
        View view;
        try {
            if (!avo.f14676k || !m13008a(context)) {
                if (avq != null) {
                    avq.mo23215a("AppRate_new", "Show", "");
                }
                RatingTheme.C3942a aVar = new RatingTheme.C3942a(context);
                if (!avo.f14666a || avo.f14667b) {
                    view = LayoutInflater.from(context).inflate(R.layout.lib_rate_dialog, (ViewGroup) null);
                    if (avo.f14666a) {
                        ((ImageView) view.findViewById(R.id.rate_hand)).setScaleX(-1.0f);
                        view.findViewById(R.id.lib_rate_shining_view).setScaleX(-1.0f);
                    }
                } else {
                    view = LayoutInflater.from(context).inflate(R.layout.lib_rate_dialog_rtl, (ViewGroup) null);
                }
                this.f10480i = (ImageView) view.findViewById(R.id.rate_emoji);
                this.f10477f = (TextView) view.findViewById(R.id.rate_tip);
                this.f10482k = (LinearLayout) view.findViewById(R.id.lib_rate_button_bg);
                this.f10481j = (TextView) view.findViewById(R.id.lib_rate_button);
                this.f10478g = (TextView) view.findViewById(R.id.rate_result_title);
                this.f10479h = (TextView) view.findViewById(R.id.rate_result_tip);
                if (avo.f14668c) {
                    view.setBackgroundResource(R.drawable.lib_rate_dialog_bg_dark);
                    this.f10477f.setTextColor(ContextCompat.getColor(context, R.color.lib_rate_dialog_message_text_color_dark));
                    this.f10478g.setTextColor(ContextCompat.getColor(context, R.color.lib_rate_dialog_message_text_color_dark));
                    this.f10479h.setTextColor(ContextCompat.getColor(context, R.color.lib_rate_dialog_message_text_color_dark));
                }
                this.f10480i.setImageResource(R.mipmap.lib_rate_emoji_star_0);
                this.f10477f.setText(avo.f14669d);
                this.f10477f.setVisibility(0);
                this.f10478g.setVisibility(4);
                this.f10479h.setVisibility(4);
                this.f10481j.setEnabled(false);
                this.f10481j.setAlpha(0.5f);
                this.f10482k.setAlpha(0.5f);
                this.f10481j.setText(context.getString(avo.f14670e).toUpperCase());
                this.f10472a = (StarCheckView) view.findViewById(R.id.rate_star_1);
                this.f10473b = (StarCheckView) view.findViewById(R.id.rate_star_2);
                this.f10474c = (StarCheckView) view.findViewById(R.id.rate_star_3);
                this.f10475d = (StarCheckView) view.findViewById(R.id.rate_star_4);
                this.f10476e = (StarCheckView) view.findViewById(R.id.rate_star_5);
                C2952a aVar2 = new C2952a(avo, avq);
                this.f10472a.setOnClickListener(aVar2);
                this.f10473b.setOnClickListener(aVar2);
                this.f10474c.setOnClickListener(aVar2);
                this.f10475d.setOnClickListener(aVar2);
                this.f10476e.setOnClickListener(aVar2);
                aVar.setView(view);
                this.f10483l = aVar.create();
                this.f10483l.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        if (avq != null) {
                            avq.mo23214a(1);
                            avq.mo23215a("AppRate_new", "Show", "cancel");
                        }
                        dialogInterface.dismiss();
                    }
                });
                this.f10481j.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        RatingDialog.this.f10483l.dismiss();
                        if (RatingDialog.this.f10485n > 4) {
                            AppRate.m13019a(context, avo);
                            if (avq != null) {
                                avq.mo23213a();
                                avq.mo23215a("AppRate_new", "Like", "Review");
                            }
                            if (RatingDialog.this.f10483l != null && RatingDialog.this.f10483l.isShowing()) {
                                RatingDialog.this.f10483l.dismiss();
                                return;
                            }
                            return;
                        }
                        C2938a.m12996a().mo20085b();
                        new FeedbackDailog().mo20089a(context, avo, avq);
                    }
                });
                this.f10483l.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (avq != null) {
                            avq.mo23218b(1);
                        }
                    }
                });
                this.f10483l.show();
                if (context.getResources().getConfiguration().orientation == 2) {
                    final ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollView);
                    scrollView.post(new Runnable() {
                        public void run() {
                            if (!((Activity) context).isFinishing()) {
                                scrollView.fullScroll(130);
                            }
                        }
                    });
                }
                if (z) {
                    C2938a.m12996a().mo20084a(this.f10483l, 1);
                }
                ArrayList arrayList = new ArrayList();
                if (!avo.f14666a || avo.f14667b) {
                    arrayList.add(this.f10472a);
                    arrayList.add(this.f10473b);
                    arrayList.add(this.f10474c);
                    arrayList.add(this.f10475d);
                    arrayList.add(this.f10476e);
                } else {
                    arrayList.add(this.f10476e);
                    arrayList.add(this.f10475d);
                    arrayList.add(this.f10474c);
                    arrayList.add(this.f10473b);
                    arrayList.add(this.f10472a);
                }
                this.f10484m = new RatingViewAnimation(arrayList);
                view.postDelayed(new Runnable() {
                    public void run() {
                        RatingDialog.this.f10484m.mo20115a();
                    }
                }, 1200);
            }
        } catch (Exception e) {
            if (avq != null) {
                avq.mo23216a((Throwable) e);
            }
            e.printStackTrace();
        }
    }

    /* renamed from: c$a */
    private class C2952a implements View.OnClickListener {

        /* renamed from: a */
        RatingInterface f10500a;

        /* renamed from: b */
        RateConstant f10501b;

        public C2952a(RateConstant avo, RatingInterface avq) {
            this.f10501b = avo;
            this.f10500a = avq;
        }

        public void onClick(View view) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            int id = view.getId();
            boolean z9 = false;
            if (!this.f10501b.f14666a || this.f10501b.f14667b) {
                if (id == R.id.rate_star_1) {
                    if (RatingDialog.this.f10485n == 1) {
                        int unused = RatingDialog.this.f10485n = 0;
                        RatingDialog.this.f10472a.setCheck(false);
                        z4 = false;
                    } else {
                        z4 = RatingDialog.this.f10485n == 0;
                        int unused2 = RatingDialog.this.f10485n = 1;
                        RatingDialog.this.f10472a.setCheck(true);
                        RatingDialog.this.f10473b.setCheck(false);
                        RatingDialog.this.f10474c.setCheck(false);
                        RatingDialog.this.f10475d.setCheck(false);
                        RatingDialog.this.f10476e.setCheck(false);
                    }
                    RatingDialog.this.m13006a(view.getContext(), this.f10501b, z4, this.f10500a);
                } else if (id == R.id.rate_star_2) {
                    if (RatingDialog.this.f10485n == 2) {
                        int unused3 = RatingDialog.this.f10485n = 1;
                        RatingDialog.this.f10473b.setCheck(false);
                        z3 = false;
                    } else {
                        z3 = RatingDialog.this.f10485n == 0;
                        int unused4 = RatingDialog.this.f10485n = 2;
                        RatingDialog.this.f10472a.setCheck(true);
                        RatingDialog.this.f10473b.setCheck(true);
                        RatingDialog.this.f10474c.setCheck(false);
                        RatingDialog.this.f10475d.setCheck(false);
                        RatingDialog.this.f10476e.setCheck(false);
                    }
                    RatingDialog.this.m13006a(view.getContext(), this.f10501b, z3, this.f10500a);
                } else if (id == R.id.rate_star_3) {
                    if (RatingDialog.this.f10485n == 3) {
                        int unused5 = RatingDialog.this.f10485n = 2;
                        RatingDialog.this.f10474c.setCheck(false);
                        z2 = false;
                    } else {
                        z2 = RatingDialog.this.f10485n == 0;
                        int unused6 = RatingDialog.this.f10485n = 3;
                        RatingDialog.this.f10472a.setCheck(true);
                        RatingDialog.this.f10473b.setCheck(true);
                        RatingDialog.this.f10474c.setCheck(true);
                        RatingDialog.this.f10475d.setCheck(false);
                        RatingDialog.this.f10476e.setCheck(false);
                    }
                    RatingDialog.this.m13006a(view.getContext(), this.f10501b, z2, this.f10500a);
                } else if (id == R.id.rate_star_4) {
                    if (RatingDialog.this.f10485n == 4) {
                        int unused7 = RatingDialog.this.f10485n = 3;
                        RatingDialog.this.f10475d.setCheck(false);
                        z = false;
                    } else {
                        z = RatingDialog.this.f10485n == 0;
                        int unused8 = RatingDialog.this.f10485n = 4;
                        RatingDialog.this.f10472a.setCheck(true);
                        RatingDialog.this.f10473b.setCheck(true);
                        RatingDialog.this.f10474c.setCheck(true);
                        RatingDialog.this.f10475d.setCheck(true);
                        RatingDialog.this.f10476e.setCheck(false);
                    }
                    RatingDialog.this.m13006a(view.getContext(), this.f10501b, z, this.f10500a);
                } else if (id == R.id.rate_star_5) {
                    if (RatingDialog.this.f10485n == 5) {
                        int unused9 = RatingDialog.this.f10485n = 4;
                        RatingDialog.this.f10476e.setCheck(false);
                    } else {
                        if (RatingDialog.this.f10485n == 0) {
                            z9 = true;
                        }
                        int unused10 = RatingDialog.this.f10485n = 5;
                        RatingDialog.this.f10472a.setCheck(true);
                        RatingDialog.this.f10473b.setCheck(true);
                        RatingDialog.this.f10474c.setCheck(true);
                        RatingDialog.this.f10475d.setCheck(true);
                        RatingDialog.this.f10476e.setCheck(true);
                    }
                    RatingDialog.this.m13006a(view.getContext(), this.f10501b, z9, this.f10500a);
                }
            } else if (id == R.id.rate_star_1) {
                if (RatingDialog.this.f10485n == 5) {
                    int unused11 = RatingDialog.this.f10485n = 4;
                    RatingDialog.this.f10472a.setCheck(false);
                } else {
                    if (RatingDialog.this.f10485n == 0) {
                        z9 = true;
                    }
                    int unused12 = RatingDialog.this.f10485n = 5;
                    RatingDialog.this.f10472a.setCheck(true);
                    RatingDialog.this.f10473b.setCheck(true);
                    RatingDialog.this.f10474c.setCheck(true);
                    RatingDialog.this.f10475d.setCheck(true);
                    RatingDialog.this.f10476e.setCheck(true);
                }
                RatingDialog.this.m13006a(view.getContext(), this.f10501b, z9, this.f10500a);
            } else if (id == R.id.rate_star_2) {
                if (RatingDialog.this.f10485n == 4) {
                    int unused13 = RatingDialog.this.f10485n = 3;
                    RatingDialog.this.f10473b.setCheck(false);
                    z8 = false;
                } else {
                    z8 = RatingDialog.this.f10485n == 0;
                    int unused14 = RatingDialog.this.f10485n = 4;
                    RatingDialog.this.f10472a.setCheck(false);
                    RatingDialog.this.f10473b.setCheck(true);
                    RatingDialog.this.f10474c.setCheck(true);
                    RatingDialog.this.f10475d.setCheck(true);
                    RatingDialog.this.f10476e.setCheck(true);
                }
                RatingDialog.this.m13006a(view.getContext(), this.f10501b, z8, this.f10500a);
            } else if (id == R.id.rate_star_3) {
                if (RatingDialog.this.f10485n == 3) {
                    int unused15 = RatingDialog.this.f10485n = 2;
                    RatingDialog.this.f10474c.setCheck(false);
                    z7 = false;
                } else {
                    z7 = RatingDialog.this.f10485n == 0;
                    int unused16 = RatingDialog.this.f10485n = 3;
                    RatingDialog.this.f10472a.setCheck(false);
                    RatingDialog.this.f10473b.setCheck(false);
                    RatingDialog.this.f10474c.setCheck(true);
                    RatingDialog.this.f10475d.setCheck(true);
                    RatingDialog.this.f10476e.setCheck(true);
                }
                RatingDialog.this.m13006a(view.getContext(), this.f10501b, z7, this.f10500a);
            } else if (id == R.id.rate_star_4) {
                if (RatingDialog.this.f10485n == 2) {
                    int unused17 = RatingDialog.this.f10485n = 1;
                    RatingDialog.this.f10475d.setCheck(false);
                    z6 = false;
                } else {
                    z6 = RatingDialog.this.f10485n == 0;
                    int unused18 = RatingDialog.this.f10485n = 2;
                    RatingDialog.this.f10472a.setCheck(false);
                    RatingDialog.this.f10473b.setCheck(false);
                    RatingDialog.this.f10474c.setCheck(false);
                    RatingDialog.this.f10475d.setCheck(true);
                    RatingDialog.this.f10476e.setCheck(true);
                }
                RatingDialog.this.m13006a(view.getContext(), this.f10501b, z6, this.f10500a);
            } else if (id == R.id.rate_star_5) {
                if (RatingDialog.this.f10485n == 1) {
                    int unused19 = RatingDialog.this.f10485n = 0;
                    RatingDialog.this.f10476e.setCheck(false);
                    z5 = false;
                } else {
                    z5 = RatingDialog.this.f10485n == 0;
                    int unused20 = RatingDialog.this.f10485n = 1;
                    RatingDialog.this.f10472a.setCheck(false);
                    RatingDialog.this.f10473b.setCheck(false);
                    RatingDialog.this.f10474c.setCheck(false);
                    RatingDialog.this.f10475d.setCheck(false);
                    RatingDialog.this.f10476e.setCheck(true);
                }
                RatingDialog.this.m13006a(view.getContext(), this.f10501b, z5, this.f10500a);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13006a(Context context, RateConstant avo, boolean z, RatingInterface avq) {
        int i = R.mipmap.lib_rate_emoji_star_0;
        int i2 = R.string.lib_rate_btn_rate;
        int i3 = R.string.lib_rate_like_you;
        int i4 = R.string.lib_rate_thanks_feedback;
        int i5 = this.f10485n;
        if (i5 != 0) {
            switch (i5) {
                case 1:
                    this.f10484m.mo20116a(0);
                    i = R.mipmap.lib_rate_emoji_star_1;
                    i2 = R.string.lib_rate_btn_rate;
                    i3 = R.string.lib_rate_oh_no;
                    i4 = R.string.lib_rate_leave_feedback;
                    break;
                case 2:
                    this.f10484m.mo20116a(1);
                    i = R.mipmap.lib_rate_emoji_star_2;
                    i2 = R.string.lib_rate_btn_rate;
                    i3 = R.string.lib_rate_oh_no;
                    i4 = R.string.lib_rate_leave_feedback;
                    break;
                case 3:
                    this.f10484m.mo20116a(2);
                    i = R.mipmap.lib_rate_emoji_star_3;
                    i2 = R.string.lib_rate_btn_rate;
                    i3 = R.string.lib_rate_oh_no;
                    i4 = R.string.lib_rate_leave_feedback;
                    break;
                case 4:
                    this.f10484m.mo20116a(3);
                    i = R.mipmap.lib_rate_emoji_star_4;
                    i2 = R.string.lib_rate_btn_rate;
                    i3 = R.string.lib_rate_like_you;
                    i4 = R.string.lib_rate_thanks_feedback;
                    break;
                case 5:
                    this.f10484m.mo20116a(4);
                    i = R.mipmap.lib_rate_emoji_star_5;
                    i2 = avo.f14672g;
                    i3 = R.string.lib_rate_like_you;
                    i4 = R.string.lib_rate_thanks_feedback;
                    break;
            }
            m13005a(i);
            this.f10477f.setVisibility(4);
            this.f10478g.setVisibility(0);
            this.f10479h.setVisibility(0);
            this.f10478g.setText(i3);
            this.f10479h.setText(i4);
            this.f10481j.setText(i2);
            this.f10481j.setEnabled(true);
            this.f10481j.setAlpha(1.0f);
            this.f10482k.setAlpha(1.0f);
            if (avo.f14673h) {
                int i6 = this.f10485n;
                return;
            }
            return;
        }
        m13005a(i);
        this.f10477f.setVisibility(0);
        this.f10478g.setVisibility(4);
        this.f10479h.setVisibility(4);
        this.f10481j.setEnabled(false);
        this.f10481j.setAlpha(0.5f);
        this.f10482k.setAlpha(0.5f);
    }

    /* renamed from: a */
    private void m13005a(final int i) {
        ImageView imageView = this.f10480i;
        if (imageView != null) {
            imageView.animate().scaleX(0.2f).scaleY(0.2f).alpha(0.2f).setDuration(120).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    try {
                        RatingDialog.this.f10480i.setImageResource(i);
                        RatingDialog.this.f10480i.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(120);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private boolean m13008a(Context context) {
        if (m13009a(Locale.getDefault())) {
            return true;
        }
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration == null || !m13009a(configuration.locale)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m13009a(Locale locale) {
        if (locale == null) {
            return false;
        }
        try {
            String country = locale.getCountry();
            String language = locale.getLanguage();
            if (!TextUtils.isEmpty(country) && country.equalsIgnoreCase("ID")) {
                return true;
            }
            if (TextUtils.isEmpty(language) || !language.toLowerCase().startsWith("in")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
