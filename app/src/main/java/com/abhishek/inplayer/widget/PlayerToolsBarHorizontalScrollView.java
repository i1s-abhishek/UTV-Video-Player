package com.abhishek.inplayer.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.HorizontalScrollView;

import com.abhishek.xplayer.application.MyApplication;

import java.util.ArrayList;
import java.util.Iterator;

import hdplayer.vlcplayer.videoplayer.R;


public class PlayerToolsBarHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a */
    private View f9836a;

    /* renamed from: b */
    private View f9837b;

    /* renamed from: c */
    private Rect f9838c = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f9839d;

    /* renamed from: e */
    private int f9840e;

    /* renamed from: f */
    private int f9841f;

    /* renamed from: g */
    private int f9842g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f9843h = true;

    /* renamed from: i */
    private int f9844i;

    /* renamed from: j */
    private ArrayList<View> f9845j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f9846k;

    /* renamed from: l */
    private boolean f9847l;

    /* renamed from: m */
    private boolean f9848m;

    /* renamed from: n */
    private C2461a f9849n;

    /* renamed from: com.inshot.inplayer.widget.PlayerToolsBarHorizontalScrollView$a */
    public interface C2461a {
        /* renamed from: a */
        void mo17437a();

        /* renamed from: a */
        void mo17438a(int i, int i2, int i3, int i4);
    }

    public PlayerToolsBarHorizontalScrollView(Context context) {
        super(context);
        m11162b();
    }

    public PlayerToolsBarHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11162b();
    }

    public PlayerToolsBarHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11162b();
    }

    /* renamed from: b */
    private void m11162b() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_());
        int i = defaultSharedPreferences.getInt("needShowMore", -1);
        boolean z = false;
        if (i != -1) {
            if (i == 1) {
                z = true;
            }
            this.f9848m = z;
        } else if (defaultSharedPreferences.getLong("watchTime", 0) > 0) {
            defaultSharedPreferences.edit().putInt("needShowMore", 0).apply();
            this.f9848m = false;
        } else {
            defaultSharedPreferences.edit().putInt("needShowMore", 1).apply();
            this.f9848m = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.f9836a != null && this.f9837b != null) {
            if (i <= 0 && this.f9848m) {
                findViewById(R.id.new_more_dot).setVisibility(8);
                this.f9848m = false;
                PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt("needShowMore", 0).apply();
            }
            if (i < this.f9839d) {
                m11159a(this.f9837b, false, true);
                setAutoHideViewVisible(true);
                this.f9843h = false;
                super.onScrollChanged(i, i2, i3, i4);
                if (this.f9849n != null) {
                    this.f9849n.mo17438a(i, i2, i3, i4);
                    return;
                }
                return;
            }
            m11159a(this.f9837b, true, true);
            setAutoHideViewVisible(false);
            this.f9843h = true;
            if (this.f9847l || i == this.f9839d) {
                super.onScrollChanged(i, i2, i3, i4);
                if (this.f9849n != null) {
                    this.f9849n.mo17438a(i, i2, i3, i4);
                    return;
                }
                return;
            }
            post(new Runnable() {
                public void run() {
                    PlayerToolsBarHorizontalScrollView.this.smoothScrollTo(PlayerToolsBarHorizontalScrollView.this.f9839d, 0);
                }
            });
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f9836a == null || this.f9837b == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                float rawX = motionEvent.getRawX();
                this.f9836a.getGlobalVisibleRect(this.f9838c);
                if (rawX > ((float) this.f9838c.right) || rawX < ((float) this.f9838c.left)) {
                    this.f9847l = true;
                    break;
                } else {
                    return false;
                }
            case 1:
                this.f9847l = false;
                if (getScrollX() >= this.f9839d) {
                    post(new Runnable() {
                        public void run() {
                            PlayerToolsBarHorizontalScrollView.this.smoothScrollTo(PlayerToolsBarHorizontalScrollView.this.f9839d, 0);
                        }
                    });
                    break;
                }
                break;
        }
        if (this.f9849n != null) {
            this.f9849n.mo17437a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSpaceView(View view) {
        this.f9836a = view;
        view.getLayoutParams().width = Math.max(view.getResources().getDisplayMetrics().widthPixels, view.getResources().getDisplayMetrics().heightPixels);
    }

    public void setMoreView(View view) {
        this.f9837b = view;
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (PlayerToolsBarHorizontalScrollView.this.f9843h) {
                    PlayerToolsBarHorizontalScrollView.this.post(new Runnable() {
                        public void run() {
                            PlayerToolsBarHorizontalScrollView.this.smoothScrollTo(0, 0);
                        }
                    });
                }
            }
        });
    }

    public void setItemWidth(int i) {
        this.f9842g = i;
    }

    /* renamed from: a */
    public void mo17423a(int i, int i2) {
        this.f9840e = i;
        this.f9841f = i2;
    }

    public int getOutCount() {
        return this.f9841f;
    }

    public void setAutoHideViewId(int i) {
        this.f9844i = i;
        if (i != 0) {
            if (this.f9845j == null) {
                this.f9845j = new ArrayList<>(10);
            }
            m11160a((ViewGroup) this, this.f9845j);
        }
    }

    /* renamed from: a */
    public void mo17422a() {
        if (this.f9848m) {
            findViewById(R.id.new_more_dot).setVisibility(0);
        }
        this.f9839d = (this.f9840e - this.f9841f) * this.f9842g;
        getChildAt(0).setVisibility(4);
        post(new Runnable() {
            public void run() {
                boolean unused = PlayerToolsBarHorizontalScrollView.this.f9846k = true;
                PlayerToolsBarHorizontalScrollView.this.scrollTo(PlayerToolsBarHorizontalScrollView.this.f9839d, 0);
                boolean unused2 = PlayerToolsBarHorizontalScrollView.this.f9846k = false;
                PlayerToolsBarHorizontalScrollView.this.getChildAt(0).setVisibility(0);
            }
        });
    }

    private void setAutoHideViewVisible(boolean z) {
        if (this.f9845j != null) {
            Iterator<View> it = this.f9845j.iterator();
            while (it.hasNext()) {
                m11159a(it.next(), z, !this.f9846k);
            }
        }
    }

    /* renamed from: a */
    private void m11160a(ViewGroup viewGroup, ArrayList<View> arrayList) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null && childAt.getId() == this.f9844i) {
                arrayList.add(childAt);
            } else if (childAt instanceof ViewGroup) {
                m11160a((ViewGroup) childAt, arrayList);
            }
        }
    }

    /* renamed from: a */
    private static void m11159a(View view, boolean z, boolean z2) {
        if (z) {
            if (view.getVisibility() != 0) {
                view.clearAnimation();
                if (z2) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500);
                    view.setAnimation(alphaAnimation);
                }
                view.setVisibility(0);
            }
        } else if (view.getVisibility() != 4) {
            view.clearAnimation();
            if (z2) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setDuration(500);
                view.setAnimation(alphaAnimation2);
            }
            view.setVisibility(4);
        }
    }

    public void setPlayerToolBarScrollListener(C2461a aVar) {
        this.f9849n = aVar;
    }
}
