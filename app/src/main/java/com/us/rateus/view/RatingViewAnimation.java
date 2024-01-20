package com.us.rateus.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Message;

import java.util.List;

/* renamed from: com.zjsoft.rate.view.a */
public class RatingViewAnimation {

    /* renamed from: a */
    private Handler f10530a = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                RatingViewAnimation.this.m13036a(message.arg1, message.arg2, ((Boolean) message.obj).booleanValue());
            }
        }
    };

    /* renamed from: b */
    private List<StarCheckView> f10531b;

    /* renamed from: c */
    private int f10532c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2963a f10533d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f10534e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ObjectAnimator f10535f;

    /* renamed from: com.zjsoft.rate.view.a$a */
    public interface C2963a {
        /* renamed from: a */
        void mo20120a(int i);
    }

    public RatingViewAnimation(List<StarCheckView> list) {
        this.f10531b = list;
    }

    /* renamed from: a */
    public void mo20115a() {
        if (this.f10531b != null && this.f10532c < 0) {
            this.f10534e = false;
            m13040c();
            m13036a(0, this.f10531b.size() - 1, true);
        }
    }

    /* renamed from: a */
    public boolean mo20116a(int i) {
        if (this.f10532c == i) {
            return false;
        }
        this.f10532c = i;
        this.f10530a.removeMessages(1);
        this.f10534e = true;
        ObjectAnimator objectAnimator = this.f10535f;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        int i2 = 0;
        while (i2 < this.f10531b.size()) {
            this.f10531b.get(i2).mo20103a(i2 <= i, false);
            i2++;
        }
        C2963a aVar = this.f10533d;
        if (aVar != null) {
            aVar.mo20120a(mo20117b());
        }
        return true;
    }

    /* renamed from: b */
    public int mo20117b() {
        return this.f10532c;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13036a(int i, int i2, boolean z) {
        List<StarCheckView> list;
        if (i2 < i || (list = this.f10531b) == null || list.size() <= i || i < 0) {
            m13038a(z);
            return;
        }
        StarCheckView starCheckView = this.f10531b.get(i);
        if (starCheckView == null) {
            m13038a(z);
            return;
        }
        starCheckView.setPosition(i);
        starCheckView.mo20103a(true, true);
        Message message = new Message();
        message.what = 1;
        message.arg1 = i + 1;
        message.arg2 = i2;
        message.obj = Boolean.valueOf(z);
        this.f10530a.sendMessageDelayed(message, 160);
    }

    /* renamed from: a */
    private void m13038a(final boolean z) {
        List<StarCheckView> list = this.f10531b;
        if (list != null && list.size() > 0) {
            List<StarCheckView> list2 = this.f10531b;
            final StarCheckView starCheckView = list2.get(list2.size() - 1);
            if (starCheckView != null) {
                starCheckView.setOnAnimationEnd(new StarCheckView.C2958a() {
                    /* renamed from: a */
                    public void mo20112a(Animator animator) {
                        if (RatingViewAnimation.this.f10533d != null) {
                            RatingViewAnimation.this.f10533d.mo20120a(RatingViewAnimation.this.mo20117b());
                        }
                        if (z && !RatingViewAnimation.this.f10534e) {
                            RatingViewAnimation.this.m13040c();
                            ObjectAnimator unused = RatingViewAnimation.this.f10535f = ObjectAnimator.ofFloat(starCheckView, "rotation", new float[]{20.0f, -20.0f, 20.0f, -20.0f, 0.0f});
                            RatingViewAnimation.this.f10535f.setDuration(2000);
                            RatingViewAnimation.this.f10535f.addListener(new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    super.onAnimationEnd(animator);
                                    ObjectAnimator unused = RatingViewAnimation.this.f10535f = null;
                                }
                            });
                            RatingViewAnimation.this.f10535f.start();
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m13040c() {
        List<StarCheckView> list = this.f10531b;
        if (list != null) {
            for (StarCheckView next : list) {
                if (next != null) {
                    next.setCheck(false);
                }
            }
        }
    }
}
