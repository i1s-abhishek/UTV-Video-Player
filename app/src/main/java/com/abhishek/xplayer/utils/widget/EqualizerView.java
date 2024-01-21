package com.abhishek.xplayer.utils.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import hdplayer.xdplayer.videoplayer.R;


public class EqualizerView extends View {

    /* renamed from: A */
    private String[] f11337A = {"hehe", "Haha", "HHHH", "abcdex", "wuwu"};

    /* renamed from: B */
    private C2848a f11338B;

    /* renamed from: C */
    private float f11339C;

    /* renamed from: D */
    private float f11340D;

    /* renamed from: a */
    int f11341a = -1;

    /* renamed from: b */
    int f11342b;

    /* renamed from: c */
    private Paint f11343c;

    /* renamed from: d */
    private int f11344d;

    /* renamed from: e */
    private int f11345e;

    /* renamed from: f */
    private int f11346f;

    /* renamed from: g */
    private int f11347g;

    /* renamed from: h */
    private int f11348h = 100;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int[] f11349i;

    /* renamed from: j */
    private int f11350j;

    /* renamed from: k */
    private int f11351k;

    /* renamed from: l */
    private int f11352l;

    /* renamed from: m */
    private int f11353m;

    /* renamed from: n */
    private int f11354n;

    /* renamed from: o */
    private int f11355o;

    /* renamed from: p */
    private int f11356p;

    /* renamed from: q */
    private int f11357q;

    /* renamed from: r */
    private int f11358r = Color.parseColor("#545456");

    /* renamed from: s */
    private int f11359s = ((int) TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics()));

    /* renamed from: t */
    private int f11360t = ((int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));

    /* renamed from: u */
    private int f11361u;

    /* renamed from: v */
    private int f11362v = 5;

    /* renamed from: w */
    private int f11363w;

    /* renamed from: x */
    private int f11364x;

    /* renamed from: y */
    private int f11365y;

    /* renamed from: z */
    private int f11366z;

    /* renamed from: com.inshot.xplayer.utils.widget.EqualizerView$a */
    public interface C2848a {
        /* renamed from: a */
        void mo17643a(EqualizerView equalizerView, int[] iArr, int i);

        /* renamed from: b */
        void mo17645b(EqualizerView equalizerView, int[] iArr, int i);

        /* renamed from: c */
        void mo17647c(EqualizerView equalizerView, int[] iArr, int i);
    }

    public void setOnEqualizerChangedListener(C2848a aVar) {
        this.f11338B = aVar;
    }

    public EqualizerView(Context context) {
        super(context);
        m12887a();
    }

    public EqualizerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12887a();
    }

    /* renamed from: a */
    private void m12887a() {
        this.f11343c = new Paint(5);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f11363w = displayMetrics.heightPixels;
        this.f11364x = displayMetrics.widthPixels;
        mo18276a(getResources().getColor(R.color.progressBgColor)).mo18281c(getResources().getDimensionPixelSize(R.dimen.eq_progress_bg_width)).mo18280b(getResources().getColor(R.color.progressColor)).mo18282d(getResources().getDimensionPixelSize(R.dimen.eq_progress_width)).mo18294i(getResources().getColor(R.color.progressLineColor)).mo18295j(getResources().getDimensionPixelSize(R.dimen.eq_line_width)).mo18285g(getResources().getDimensionPixelSize(R.dimen.eq_circle_radius)).mo18283e(getResources().getColor(R.color.progressColor)).mo18284f(Color.parseColor("#212021")).mo18293h(getResources().getDimensionPixelSize(R.dimen.eq_circle_width));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m12897o(i), m12896n(i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11365y = getMeasuredHeight();
        this.f11366z = getMeasuredWidth();
        this.f11346f = (((((this.f11365y - (this.f11353m * 2)) - (this.f11354n * 2)) - getPaddingTop()) - getPaddingBottom()) - this.f11361u) - this.f11360t;
        this.f11351k = (this.f11365y - this.f11360t) - this.f11361u;
        if (this.f11349i == null) {
            this.f11349i = new int[this.f11362v];
        }
    }

    /* renamed from: n */
    private int m12896n(int i) {
        return MeasureSpec.getMode(i) == Integer.MIN_VALUE ? this.f11363w / 2 : MeasureSpec.getSize(i);
    }

    /* renamed from: o */
    private int m12897o(int i) {
        return MeasureSpec.getMode(i) == Integer.MIN_VALUE ? (this.f11364x * 2) / 3 : MeasureSpec.getSize(i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m12888a(canvas);
        m12891b(canvas);
        m12892c(canvas);
        m12894d(canvas);
        m12895e(canvas);
    }

    /* renamed from: a */
    private void m12888a(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) this.f11351k);
        this.f11343c.setStyle(Paint.Style.FILL);
        this.f11343c.setColor(this.f11356p);
        this.f11343c.setStrokeWidth((float) this.f11357q);
        PointF[] c = m12893c();
        int i = 0;
        while (i < c.length - 1) {
            i++;
            canvas.drawLine(c[i].x, c[i].y, c[i].x, c[i].y, this.f11343c);
        }
        canvas.restore();
    }

    /* renamed from: b */
    private float m12890b() {
        return (((float) ((((this.f11366z - (this.f11353m * 2)) - this.f11354n) - getPaddingLeft()) - getPaddingRight())) * 1.0f) / ((float) (this.f11362v - 1));
    }

    /* renamed from: c */
    private PointF[] m12893c() {
        PointF[] pointFArr = new PointF[this.f11362v];
        float b = m12890b();
        int[] progress = getProgress();
        for (int i = 0; i < progress.length; i++) {
            pointFArr[i] = new PointF();
            pointFArr[i].x = ((float) ((this.f11354n / 2) + this.f11353m)) + (((float) i) * b) + ((float) getPaddingLeft());
            pointFArr[i].y = ((((((float) (-progress[i])) * 1.0f) / ((float) this.f11348h)) * ((float) this.f11346f)) - ((float) this.f11353m)) - ((float) this.f11354n);
        }
        return pointFArr;
    }

    /* renamed from: b */
    private void m12891b(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) this.f11351k);
        this.f11343c.setColor(this.f11344d);
        this.f11343c.setStrokeWidth((float) this.f11345e);
        float b = m12890b();
        for (int i = 0; i < this.f11362v; i++) {
            float f = ((float) i) * b;
            canvas.drawLine(((float) ((this.f11354n / 2) + this.f11353m)) + f + ((float) getPaddingLeft()), (float) ((-this.f11353m) - this.f11354n), ((float) ((this.f11354n / 2) + this.f11353m)) + f + ((float) getPaddingLeft()), (float) ((-this.f11351k) + this.f11353m + this.f11354n), this.f11343c);
        }
        canvas.restore();
    }

    /* renamed from: c */
    private void m12892c(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) this.f11351k);
        this.f11343c.setColor(this.f11347g);
        this.f11343c.setStrokeWidth((float) this.f11350j);
        float b = m12890b();
        for (int i = 0; i < this.f11349i.length; i++) {
            float f = ((float) i) * b;
            Canvas canvas2 = canvas;
            canvas2.drawLine(((float) ((this.f11354n / 2) + this.f11353m)) + f + ((float) getPaddingLeft()), (float) ((-this.f11353m) - this.f11354n), ((float) ((this.f11354n / 2) + this.f11353m)) + f + ((float) getPaddingLeft()), ((((((float) (-this.f11349i[i])) * 1.0f) / ((float) this.f11348h)) * ((float) this.f11346f)) - ((float) this.f11353m)) - ((float) this.f11354n), this.f11343c);
        }
        canvas.restore();
    }

    /* renamed from: d */
    private void m12894d(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) this.f11351k);
        PointF[] c = m12893c();
        this.f11343c.setColor(this.f11352l);
        this.f11343c.setStyle(Paint.Style.STROKE);
        this.f11343c.setStrokeWidth((float) this.f11354n);
        for (int i = 0; i < c.length; i++) {
            canvas.drawCircle(c[i].x, c[i].y, (float) this.f11353m, this.f11343c);
        }
        this.f11343c.setColor(this.f11355o);
        this.f11343c.setStyle(Paint.Style.FILL);
        for (PointF pointF : c) {
            canvas.drawCircle(pointF.x, pointF.y, (float) (this.f11353m - (this.f11354n / 2)), this.f11343c);
        }
        canvas.restore();
    }

    /* renamed from: e */
    private void m12895e(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) this.f11351k);
        this.f11343c.setColor(this.f11358r);
        this.f11343c.setTextSize((float) this.f11359s);
        PointF[] c = m12893c();
        for (int i = 0; i < this.f11337A.length; i++) {
            if (this.f11337A[i] == null) {
                throw new NullPointerException("null cannot be passed to text,invalid index is " + i);
            }
            Rect rect = new Rect();
            this.f11343c.getTextBounds(this.f11337A[i], 0, this.f11337A[i].length(), rect);
            canvas.drawText(this.f11337A[i], c[i].x - ((float) ((rect.right - rect.left) / 2)), ((float) this.f11361u) - this.f11343c.getFontMetrics().top, this.f11343c);
        }
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
                this.f11341a = m12886a(x, y);
                if (this.f11341a >= 0) {
                    this.f11339C = x;
                    this.f11340D = y;
                    this.f11342b = mo18298m(this.f11341a);
                    mo18278a(this.f11341a, (int) ((((((float) this.f11351k) - y) - ((float) (this.f11353m + this.f11354n))) / ((float) this.f11351k)) * ((float) this.f11348h)));
                    if (this.f11338B != null) {
                        this.f11338B.mo17647c(this, getProgress(), this.f11341a);
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                if (!(this.f11341a < 0 || mo18298m(this.f11341a) == this.f11342b || this.f11338B == null)) {
                    this.f11338B.mo17645b(this, getProgress(), this.f11341a);
                    this.f11342b = 0;
                    break;
                }
            case 2:
                if (this.f11341a >= 0) {
                    mo18278a(this.f11341a, (int) (((float) mo18298m(this.f11341a)) - (((y - this.f11340D) / ((float) this.f11351k)) * ((float) this.f11348h))));
                    this.f11340D = y;
                    this.f11339C = x;
                    if (this.f11338B != null) {
                        this.f11338B.mo17643a(this, getProgress(), this.f11341a);
                    }
                    return true;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    private int m12886a(float f, float f2) {
        PointF[] c = m12893c();
        for (int i = 0; i < c.length; i++) {
            float f3 = c[i].x - f;
            float f4 = (c[i].y - f2) + ((float) this.f11351k);
            int i2 = this.f11353m + this.f11354n;
            if ((f3 * f3) + (f4 * f4) <= ((float) (i2 * i2)) * 1.2f || (Math.abs(f3) <= ((float) this.f11350j) && f2 <= ((float) (this.f11348h + (i2 * 2))))) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public EqualizerView mo18276a(int i) {
        this.f11344d = i;
        return this;
    }

    /* renamed from: b */
    public EqualizerView mo18280b(int i) {
        this.f11347g = i;
        return this;
    }

    /* renamed from: c */
    public EqualizerView mo18281c(int i) {
        this.f11345e = i;
        return this;
    }

    /* renamed from: d */
    public EqualizerView mo18282d(int i) {
        this.f11350j = i;
        return this;
    }

    /* renamed from: e */
    public EqualizerView mo18283e(int i) {
        this.f11352l = i;
        return this;
    }

    /* renamed from: f */
    public EqualizerView mo18284f(int i) {
        this.f11355o = i;
        return this;
    }

    /* renamed from: g */
    public EqualizerView mo18285g(int i) {
        this.f11353m = i;
        return this;
    }

    /* renamed from: h */
    public EqualizerView mo18293h(int i) {
        this.f11354n = i;
        return this;
    }

    /* renamed from: i */
    public EqualizerView mo18294i(int i) {
        this.f11356p = i;
        return this;
    }

    /* renamed from: j */
    public EqualizerView mo18295j(int i) {
        this.f11357q = i;
        return this;
    }

    /* renamed from: a */
    public EqualizerView mo18277a(String[] strArr) {
        this.f11337A = strArr;
        return this;
    }

    public String[] getText() {
        return this.f11337A;
    }

    public int getTextSize() {
        return this.f11359s;
    }

    public void setTextColor(int i) {
        this.f11358r = i;
    }

    public int getTextColor() {
        return this.f11358r;
    }

    public int getTextVerticalMargin() {
        return this.f11361u;
    }

    /* renamed from: k */
    public EqualizerView mo18296k(int i) {
        this.f11362v = i;
        return this;
    }

    public int getCount() {
        return this.f11362v;
    }

    /* renamed from: l */
    public EqualizerView mo18297l(int i) {
        this.f11348h = i;
        return this;
    }

    public int getMax() {
        return this.f11348h;
    }

    public void setProgress(int[] iArr) {
        if (iArr != null) {
            if (this.f11349i == null) {
                this.f11349i = new int[this.f11362v];
            }
            if (this.f11349i.length != 0) {
                for (int i = 0; i < iArr.length; i++) {
                    if (iArr[i] < 0) {
                        this.f11349i[i] = 0;
                    } else if (iArr[i] > this.f11348h) {
                        this.f11349i[i] = this.f11348h;
                    } else {
                        this.f11349i[i] = iArr[i];
                    }
                }
                invalidate();
            }
        }
    }

    public int[] getProgress() {
        return this.f11349i;
    }

    /* renamed from: a */
    public void mo18278a(int i, int i2) {
        if (this.f11349i == null) {
            this.f11349i = new int[this.f11362v];
        }
        if (i < 0 || i > this.f11349i.length - 1) {
            throw new ArrayIndexOutOfBoundsException("total length of array is " + this.f11349i.length + "invalid index is " + i);
        }
        if (i2 >= this.f11348h) {
            i2 = this.f11348h;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        this.f11349i[i] = i2;
        invalidate();
    }

    /* renamed from: a */
    public void mo18279a(int[] iArr, boolean z) {
        if (!z || this.f11349i == null || this.f11349i.length == 0) {
            setProgress(iArr);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f11349i[i], iArr[i]});
            int finalI = i;
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    EqualizerView.this.f11349i[finalI] = Integer.valueOf(valueAnimator.getAnimatedValue().toString()).intValue();
                    EqualizerView.this.postInvalidate();
                }
            });
            arrayList.add(ofInt);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    /* renamed from: m */
    public int mo18298m(int i) {
        if (i >= 0 && i <= this.f11349i.length - 1) {
            return this.f11349i[i];
        }
        throw new ArrayIndexOutOfBoundsException("total length of array is " + this.f11349i.length + "invalid index is " + i);
    }
}
