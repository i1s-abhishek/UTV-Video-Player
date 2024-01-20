package com.abhishek.xplayer.subtitle;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.RelativeLayout;

import com.abhishek.xplayer.application.MyApplication;

/* renamed from: com.inshot.xplayer.subtitle.f */
public class C2839f implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* renamed from: a */
    private View f11270a;

    /* renamed from: b */
    private RelativeLayout.LayoutParams f11271b = null;

    /* renamed from: c */
    private ScaleGestureDetector f11272c;

    /* renamed from: d */
    private SubtitleTextView f11273d;

    /* renamed from: e */
    private int f11274e = 20;

    /* renamed from: f */
    private float f11275f = 1.0f;

    /* renamed from: g */
    private float f11276g = 0.05f;

    /* renamed from: h */
    private boolean f11277h;

    /* renamed from: i */
    private int f11278i;

    /* renamed from: j */
    private int f11279j;

    /* renamed from: k */
    private int f11280k;

    /* renamed from: l */
    private boolean f11281l;

    /* renamed from: m */
    private float f11282m = 0.0f;

    /* renamed from: n */
    private int f11283n = -1;

    /* renamed from: o */
    private int f11284o = -1;

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public C2839f(SubtitleTextView subtitleTextView, boolean z) {
        this.f11273d = subtitleTextView;
        this.f11271b = (RelativeLayout.LayoutParams) subtitleTextView.getLayoutParams();
        this.f11272c = new ScaleGestureDetector(subtitleTextView.getContext(), this);
        subtitleTextView.setOnTouchListener(this);
        subtitleTextView.setTextSize(2, 20.0f);
        this.f11278i = subtitleTextView.getResources().getDisplayMetrics().widthPixels;
        this.f11279j = subtitleTextView.getResources().getDisplayMetrics().heightPixels;
        if (this.f11278i > this.f11279j) {
            int i = this.f11278i;
            this.f11278i = this.f11279j;
            this.f11279j = i;
        }
        mo18246b(z);
        int i2 = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("subtitleColor", -1);
        this.f11280k = i2;
        mo18245b(i2);
    }

    /* renamed from: a */
    public void mo18240a() {
        mo18242a(20, 0.05f);
    }

    /* renamed from: a */
    public void mo18242a(int i, float f) {
        mo18241a(i);
        if (f <= 1.0f && f > 0.0f) {
            this.f11276g = f;
            mo18246b(this.f11277h);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18241a(int i) {
        if (i > 0) {
            float f = (float) i;
            float f2 = f / 20.0f;
            if (f2 <= 3.0f && f2 >= 0.75f) {
                this.f11274e = i;
                this.f11275f = f2;
                this.f11273d.setTextSize(2, f);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo18245b(int i) {
        this.f11273d.setTextColor(i);
        if (this.f11280k != i) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit();
            this.f11280k = i;
            edit.putInt("subtitleColor", i).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18243a(boolean z) {
        this.f11273d.setVisibility(z ? 0 : 4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo18244b() {
        return this.f11280k;
    }

    /* renamed from: c */
    public int mo18247c() {
        return this.f11274e;
    }

    /* renamed from: d */
    public float mo18248d() {
        return this.f11276g;
    }

    /* renamed from: b */
    public void mo18246b(boolean z) {
        this.f11277h = z;
        if (this.f11276g <= 0.5f) {
            this.f11271b.topMargin = 0;
            this.f11271b.bottomMargin = m12836e();
            this.f11271b.addRule(12);
            this.f11271b.removeRule(10);
            this.f11273d.setGravity(81);
            return;
        }
        this.f11271b.topMargin = m12837f();
        this.f11271b.bottomMargin = 0;
        this.f11271b.removeRule(12);
        this.f11271b.addRule(10);
        this.f11273d.setGravity(49);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        switch (motionEvent.getAction()) {
            case 0:
                this.f11273d.setTouching(true);
                this.f11270a = (View) view.getParent();
                this.f11282m = motionEvent.getRawY();
                this.f11283n = this.f11271b.bottomMargin;
                this.f11284o = this.f11271b.topMargin;
                if (this.f11276g <= 0.5f) {
                    z = true;
                }
                this.f11281l = z;
                break;
            case 1:
                if (this.f11281l) {
                    this.f11276g = ((float) this.f11271b.bottomMargin) / ((float) (this.f11277h ? this.f11279j : this.f11278i));
                    if (this.f11276g > 0.5f) {
                        this.f11276g = (((float) this.f11271b.bottomMargin) + ((float) view.getHeight())) / ((float) (this.f11277h ? this.f11279j : this.f11278i));
                        this.f11281l = false;
                    }
                } else {
                    this.f11276g = 1.0f - (((float) this.f11271b.topMargin) / ((float) (this.f11277h ? this.f11279j : this.f11278i)));
                    if (this.f11276g <= 0.5f) {
                        this.f11276g = 1.0f - ((((float) this.f11271b.topMargin) + ((float) view.getHeight())) / ((float) (this.f11277h ? this.f11279j : this.f11278i)));
                        this.f11281l = true;
                    }
                }
                if (this.f11276g > 1.0f) {
                    this.f11276g = 1.0f;
                } else if (this.f11276g < 0.0f) {
                    this.f11276g = 0.0f;
                }
                mo18246b(this.f11277h);
                this.f11270a = null;
                this.f11273d.setTouching(false);
                break;
            case 2:
                if (motionEvent.getPointerCount() == 1) {
                    int round = Math.round(this.f11282m - motionEvent.getRawY());
                    int height = view.getHeight();
                    if (!this.f11281l) {
                        int min = Math.min((this.f11277h ? this.f11279j : this.f11278i) - height, Math.max(0, this.f11284o - round));
                        if (this.f11271b.topMargin != min) {
                            this.f11271b.topMargin = min;
                            view.setLayoutParams(this.f11271b);
                            if (this.f11270a != null) {
                                this.f11270a.invalidate();
                                break;
                            }
                        }
                    } else {
                        int min2 = Math.min((this.f11277h ? this.f11279j : this.f11278i) - height, Math.max(0, this.f11283n + round));
                        if (this.f11271b.bottomMargin != min2) {
                            this.f11271b.bottomMargin = min2;
                            view.setLayoutParams(this.f11271b);
                            if (this.f11270a != null) {
                                this.f11270a.invalidate();
                                break;
                            }
                        }
                    }
                }
                break;
        }
        this.f11272c.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = this.f11275f * scaleGestureDetector.getScaleFactor();
        if (scaleFactor > 3.0f || scaleFactor < 0.75f) {
            return true;
        }
        this.f11275f = scaleFactor;
        int a = m12835a(scaleFactor);
        if (this.f11274e == a) {
            return true;
        }
        this.f11274e = a;
        this.f11273d.setTextSize(2, (float) a);
        return true;
    }

    /* renamed from: a */
    private int m12835a(float f) {
        return Math.round(f * 20.0f);
    }

    /* renamed from: e */
    private int m12836e() {
        if (this.f11276g > 0.5f) {
            return 0;
        }
        return (int) (this.f11276g * ((float) (this.f11277h ? this.f11279j : this.f11278i)));
    }

    /* renamed from: f */
    private int m12837f() {
        if (this.f11276g <= 0.5f) {
            return 0;
        }
        return (int) ((1.0f - this.f11276g) * ((float) (this.f11277h ? this.f11279j : this.f11278i)));
    }
}
