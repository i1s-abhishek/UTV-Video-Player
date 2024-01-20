package com.us.rateus.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import hdplayer.vlcplayer.videoplayer.R;


public class StarCheckView extends View {

    /* renamed from: a */
    private Bitmap f10512a;

    /* renamed from: b */
    private Bitmap f10513b;

    /* renamed from: c */
    private Paint f10514c;

    /* renamed from: d */
    private Paint f10515d;

    /* renamed from: e */
    private boolean f10516e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ValueAnimator f10517f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ValueAnimator f10518g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ValueAnimator f10519h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C2958a f10520i;

    /* renamed from: j */
    private int f10521j = 0;

    /* renamed from: com.zjsoft.rate.view.StarCheckView$a */
    public interface C2958a {
        /* renamed from: a */
        void mo20112a(Animator animator);
    }

    public StarCheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13026a();
    }

    public StarCheckView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13026a();
    }

    /* renamed from: a */
    private void m13026a() {
        this.f10512a = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.lib_rate_star);
        this.f10513b = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.lib_rate_star_on);
        this.f10514c = new Paint();
        this.f10515d = new Paint();
        this.f10515d.setAntiAlias(true);
        this.f10515d.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void setCheck(boolean z) {
        mo20103a(z, false);
    }

    public void setPosition(int i) {
        this.f10521j = i;
    }

    public void setOnAnimationEnd(C2958a aVar) {
        this.f10520i = aVar;
    }

    /* renamed from: a */
    public void mo20103a(boolean z, boolean z2) {
        this.f10516e = z;
        if (!z || !z2) {
            ValueAnimator valueAnimator = this.f10517f;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f10517f = null;
            }
            ValueAnimator valueAnimator2 = this.f10519h;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.f10519h = null;
            }
            ValueAnimator valueAnimator3 = this.f10518g;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.f10518g = null;
            }
            postInvalidate();
            return;
        }
        m13029b();
    }

    /* renamed from: b */
    private void m13029b() {
        this.f10517f = ValueAnimator.ofFloat(new float[]{0.4f, 1.0f});
        this.f10517f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                StarCheckView.this.invalidate();
            }
        });
        this.f10517f.setDuration(1200);
        this.f10517f.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ValueAnimator unused = StarCheckView.this.f10517f = null;
            }
        });
        this.f10517f.setInterpolator(new OvershootInterpolator(2.0f));
        this.f10517f.start();
        this.f10519h = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f});
        this.f10519h.setDuration(400);
        this.f10519h.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ValueAnimator unused = StarCheckView.this.f10519h = null;
            }
        });
        this.f10519h.setInterpolator(new OvershootInterpolator(2.0f));
        this.f10519h.start();
        this.f10518g = ValueAnimator.ofFloat(new float[]{0.4f, 1.2f});
        this.f10518g.setDuration(1200);
        this.f10518g.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (StarCheckView.this.f10520i != null) {
                    StarCheckView.this.f10520i.mo20112a(animator);
                }
                ValueAnimator unused = StarCheckView.this.f10518g = null;
            }
        });
        this.f10518g.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f10518g.start();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        float f;
        super.onDraw(canvas);
        if (getWidth() > 0 && getHeight() > 0) {
            float width = (float) (getWidth() / 2);
            float height = (float) (getHeight() / 2);
            ValueAnimator valueAnimator = this.f10518g;
            if (valueAnimator != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (getWidth() > getHeight()) {
                    f = ((float) (getHeight() / 2)) * floatValue;
                } else {
                    f = ((float) (getWidth() / 2)) * floatValue;
                }
                this.f10515d.setAlpha(((int) (((1.2f - floatValue) / 1.2f) * 255.0f)) * 2);
                this.f10515d.setShader(new RadialGradient(width, height, f, new int[]{1728043553, 1728043553, -855647711}, (float[]) null, Shader.TileMode.CLAMP));
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), f, this.f10515d);
            }
            boolean z = false;
            ValueAnimator valueAnimator2 = this.f10519h;
            int i2 = 255;
            if (valueAnimator2 != null) {
                float floatValue2 = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                i = (int) (((float) 255) * floatValue2);
                canvas.save();
                canvas.scale(floatValue2, floatValue2, width, height);
                z = true;
            } else {
                i = 255;
            }
            m13027a(canvas, this.f10512a, i);
            if (z) {
                canvas.restore();
            }
            ValueAnimator valueAnimator3 = this.f10517f;
            if (valueAnimator3 != null) {
                float floatValue3 = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                i2 = (int) (((float) 255) * floatValue3);
                canvas.scale(floatValue3, floatValue3, width, height);
            }
            if (this.f10516e) {
                m13027a(canvas, this.f10513b, i2);
            }
        }
    }

    /* renamed from: a */
    private void m13027a(Canvas canvas, Bitmap bitmap, int i) {
        if (bitmap != null && canvas != null) {
            if (i > 255) {
                i = 255;
            }
            this.f10514c.setAlpha(i);
            canvas.drawBitmap(bitmap, (float) ((getWidth() - bitmap.getWidth()) / 2), (float) ((getHeight() - bitmap.getHeight()) / 2), this.f10514c);
        }
    }
}
