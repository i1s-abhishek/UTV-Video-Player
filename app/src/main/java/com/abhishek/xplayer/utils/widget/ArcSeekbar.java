package com.abhishek.xplayer.utils.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import hdplayer.vlcplayer.videoplayer.R;


public class ArcSeekbar extends View {

    /* renamed from: A */
    private float f11306A;

    /* renamed from: B */
    private boolean f11307B;

    /* renamed from: C */
    private C2846a f11308C;

    /* renamed from: a */
    private int f11309a;

    /* renamed from: b */
    private int f11310b;

    /* renamed from: c */
    private int f11311c;

    /* renamed from: d */
    private int f11312d;

    /* renamed from: e */
    private int f11313e;

    /* renamed from: f */
    private int f11314f;

    /* renamed from: g */
    private float f11315g;

    /* renamed from: h */
    private float f11316h;

    /* renamed from: i */
    private int f11317i;

    /* renamed from: j */
    private int f11318j;

    /* renamed from: k */
    private int f11319k;

    /* renamed from: l */
    private int f11320l;

    /* renamed from: m */
    private float f11321m;

    /* renamed from: n */
    private int f11322n;

    /* renamed from: o */
    private int f11323o;

    /* renamed from: p */
    private int f11324p;

    /* renamed from: q */
    private int f11325q;

    /* renamed from: r */
    private int f11326r;

    /* renamed from: s */
    private float f11327s;

    /* renamed from: t */
    private float f11328t;

    /* renamed from: u */
    private Paint f11329u;

    /* renamed from: v */
    private int f11330v;

    /* renamed from: w */
    private float f11331w;

    /* renamed from: x */
    private int f11332x;

    /* renamed from: y */
    private Bitmap f11333y;

    /* renamed from: z */
    private float f11334z;

    /* renamed from: com.inshot.xplayer.utils.widget.ArcSeekbar$a */
    public interface C2846a {
        /* renamed from: a */
        void mo17642a(ArcSeekbar arcSeekbar, float f);

        /* renamed from: b */
        void mo17644b(ArcSeekbar arcSeekbar, float f);

        /* renamed from: c */
        void mo17646c(ArcSeekbar arcSeekbar, float f);
    }

    public ArcSeekbar(Context context) {
        super(context);
        m12871a();
    }

    public ArcSeekbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12871a();
    }

    /* renamed from: a */
    private void m12871a() {
        this.f11329u = new Paint(5);
        this.f11309a = getResources().getColor(R.color.arcBgColor);
        this.f11310b = getResources().getDimensionPixelSize(R.dimen.arc_seekbar_bg_width);
        this.f11312d = getResources().getColor(R.color.arcLineBgColor);
        this.f11313e = getResources().getDimensionPixelSize(R.dimen.arc_seekbar_circle_line_bg_width);
        this.f11316h = 60.0f;
        this.f11315g = (this.f11316h * 2.0f) + 180.0f;
        this.f11317i = getResources().getColor(R.color.colorAccent);
        this.f11318j = this.f11317i;
        this.f11319k = this.f11313e;
        this.f11320l = getResources().getDimensionPixelSize(R.dimen.arc_seekbar_progress_dot_radius);
        this.f11327s = 30.0f;
        this.f11328t = 30.0f;
        this.f11321m = 10.0f;
        this.f11331w = 100.0f;
        this.f11322n = 7;
        this.f11323o = this.f11318j;
        this.f11324p = -1;
        this.f11325q = getResources().getDimensionPixelSize(R.dimen.arc_seekbar_dot_radius);
        this.f11311c = getResources().getDimensionPixelSize(R.dimen.arc_seekbar_circle_bg_radius);
        this.f11314f = getResources().getDimensionPixelSize(R.dimen.arc_seekbar_cicle_line_bg_radius);
        this.f11326r = getResources().getDimensionPixelSize(R.dimen.arc_seekbar_dot_circle_ring_radius);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m12870a(i), m12870a(i2));
    }

    /* renamed from: a */
    private int m12870a(int i) {
        return MeasureSpec.getMode(i) == Integer.MIN_VALUE ? getResources().getDimensionPixelSize(R.dimen.arc_seekbar_width) : MeasureSpec.getSize(i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11330v = getMeasuredWidth();
        if (this.f11333y == null) {
            this.f11333y = BitmapFactory.decodeResource(getResources(), R.mipmap.progress_dot);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m12872a(canvas);
        m12875b(canvas);
        m12878c(canvas);
        m12879d(canvas);
    }

    /* renamed from: a */
    private void m12872a(Canvas canvas) {
        canvas.save();
        this.f11329u.setColor(this.f11309a);
        this.f11329u.setStyle(Paint.Style.STROKE);
        this.f11329u.setStrokeWidth((float) this.f11310b);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) (this.f11311c - (this.f11310b / 2)), this.f11329u);
        canvas.restore();
    }

    /* renamed from: b */
    private void m12875b(Canvas canvas) {
        canvas.save();
        this.f11329u.setColor(this.f11312d);
        this.f11329u.setStyle(Paint.Style.STROKE);
        this.f11329u.setStrokeWidth((float) this.f11313e);
        RectF rectF = new RectF();
        rectF.set((float) ((getWidth() / 2) - this.f11314f), (float) ((getWidth() / 2) - this.f11314f), (float) ((getWidth() / 2) + this.f11314f), (float) ((getWidth() / 2) + this.f11314f));
        canvas.drawArc(rectF, 180.0f - this.f11316h, this.f11315g, false, this.f11329u);
        canvas.restore();
    }

    /* renamed from: c */
    private void m12878c(Canvas canvas) {
        canvas.save();
        this.f11329u.setColor(this.f11317i);
        this.f11329u.setStyle(Paint.Style.STROKE);
        this.f11329u.setStrokeWidth((float) this.f11319k);
        RectF rectF = new RectF();
        rectF.set((float) ((getWidth() / 2) - this.f11314f), (float) ((getWidth() / 2) - this.f11314f), (float) ((getWidth() / 2) + this.f11314f), (float) ((getWidth() / 2) + this.f11314f));
        canvas.drawArc(rectF, 180.0f - this.f11316h, (this.f11321m / this.f11331w) * this.f11315g, false, this.f11329u);
        this.f11329u.setStyle(Paint.Style.FILL);
        double radians = Math.toRadians((double) ((180.0f - this.f11316h) + ((this.f11321m / this.f11331w) * this.f11315g)));
        float cos = (float) (((double) (this.f11330v / 2)) + (((double) this.f11314f) * Math.cos(radians)));
        float sin = (float) (((double) (this.f11330v / 2)) + (((double) this.f11314f) * Math.sin(radians)));
        canvas.drawBitmap(this.f11333y, new Rect(0, 0, this.f11333y.getWidth(), this.f11333y.getHeight()), new Rect((int) ((cos - ((float) this.f11320l)) - 10.0f), (int) ((sin - ((float) this.f11320l)) - 10.0f), (int) (cos + ((float) this.f11320l) + 10.0f), (int) (sin + ((float) this.f11320l) + 10.0f)), (Paint) null);
        canvas.restore();
    }

    /* renamed from: d */
    private void m12879d(Canvas canvas) {
        canvas.save();
        this.f11329u.setStyle(Paint.Style.FILL);
        float b = m12874b();
        int i = 0;
        while (i < this.f11322n) {
            if (getCurSweep() < this.f11327s + (((float) i) * b)) {
                break;
            }
            i++;
            this.f11332x = i;
        }
        m12876b(canvas, this.f11332x, b);
        m12873a(canvas, this.f11322n - this.f11332x, b);
        canvas.restore();
        this.f11332x = 0;
        this.f11329u.setAlpha(255);
    }

    /* renamed from: a */
    private void m12873a(Canvas canvas, int i, float f) {
        double d;
        float f2;
        this.f11329u.setColor(this.f11324p);
        this.f11329u.setAlpha(51);
        int i2 = 0;
        while (i2 < i) {
            i2++;
            float f3 = this.f11327s + (((float) (this.f11332x - 1)) * f) + (((float) i2) * f);
            if (f3 <= this.f11316h) {
                double radians = Math.toRadians((double) (this.f11316h - f3));
                f2 = (float) (((double) (getWidth() / 2)) - (((double) this.f11326r) * Math.cos(radians)));
                d = ((double) (getWidth() / 2)) + (((double) this.f11326r) * Math.sin(radians));
            } else if (f3 <= this.f11316h + 90.0f) {
                double radians2 = Math.toRadians((double) (f3 - this.f11316h));
                f2 = (float) (((double) (getWidth() / 2)) - (((double) this.f11326r) * Math.cos(radians2)));
                d = ((double) (getWidth() / 2)) - (((double) this.f11326r) * Math.sin(radians2));
            } else if (f3 <= this.f11316h + 180.0f) {
                double radians3 = Math.toRadians((double) ((180.0f - f3) + this.f11316h));
                f2 = (float) (((double) (getWidth() / 2)) + (((double) this.f11326r) * Math.cos(radians3)));
                d = ((double) (getWidth() / 2)) - (((double) this.f11326r) * Math.sin(radians3));
            } else {
                double radians4 = Math.toRadians((double) ((f3 - this.f11316h) - 180.0f));
                f2 = (float) (((double) (getWidth() / 2)) + (((double) this.f11326r) * Math.cos(radians4)));
                d = ((double) (getWidth() / 2)) + (((double) this.f11326r) * Math.sin(radians4));
            }
            canvas.drawCircle(f2, (float) d, (float) this.f11325q, this.f11329u);
        }
    }

    /* renamed from: b */
    private void m12876b(Canvas canvas, int i, float f) {
        double d;
        float f2;
        this.f11329u.setColor(this.f11323o);
        this.f11329u.setAlpha(255);
        for (int i2 = 0; i2 < i; i2++) {
            float f3 = this.f11327s + (((float) i2) * f);
            if (f3 <= this.f11316h) {
                double radians = Math.toRadians((double) (this.f11316h - f3));
                f2 = (float) (((double) (getWidth() / 2)) - (((double) this.f11326r) * Math.cos(radians)));
                d = ((double) (getWidth() / 2)) + (((double) this.f11326r) * Math.sin(radians));
            } else if (f3 <= this.f11316h + 90.0f) {
                double radians2 = Math.toRadians((double) (f3 - this.f11316h));
                f2 = (float) (((double) (getWidth() / 2)) - (((double) this.f11326r) * Math.cos(radians2)));
                d = ((double) (getWidth() / 2)) - (((double) this.f11326r) * Math.sin(radians2));
            } else if (f3 <= this.f11316h + 180.0f) {
                double radians3 = Math.toRadians((double) ((180.0f - f3) + this.f11316h));
                f2 = (float) (((double) (getWidth() / 2)) + (((double) this.f11326r) * Math.cos(radians3)));
                d = ((double) (getWidth() / 2)) - (((double) this.f11326r) * Math.sin(radians3));
            } else {
                double radians4 = Math.toRadians((double) ((f3 - this.f11316h) - 180.0f));
                f2 = (float) (((double) (getWidth() / 2)) + (((double) this.f11326r) * Math.cos(radians4)));
                d = ((double) (getWidth() / 2)) + (((double) this.f11326r) * Math.sin(radians4));
            }
            canvas.drawCircle(f2, (float) d, (float) this.f11325q, this.f11329u);
        }
    }

    /* renamed from: b */
    private float m12874b() {
        return ((this.f11315g - this.f11328t) - this.f11327s) / ((float) (this.f11322n - 1));
    }

    private float getCurSweep() {
        return (this.f11321m / this.f11331w) * this.f11315g;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (m12877b(x, y)) {
                    this.f11334z = x;
                    this.f11306A = y;
                    this.f11307B = true;
                    if (this.f11308C != null) {
                        this.f11308C.mo17644b(this, getProgress());
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.f11307B && this.f11308C != null) {
                    this.f11308C.mo17642a(this, getProgress());
                }
                this.f11307B = false;
                break;
            case 2:
                if (this.f11307B) {
                    setProgress(m12869a(x, y));
                    if (this.f11308C != null) {
                        this.f11308C.mo17646c(this, getProgress());
                    }
                    return true;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    private float m12869aa(float f, float f2) {
        float f3;
        double asin = Math.asin((double) ((f2 - ((float) (getWidth() / 2))) / ((float) Math.sqrt((double) (((f - ((float) (getWidth() / 2))) * (f - ((float) (getWidth() / 2)))) + ((f2 - ((float) (getWidth() / 2))) * (f2 - ((float) (getWidth() / 2)))))))));
        int i = (asin > 0.0d ? 1 : (asin == 0.0d ? 0 : -1));
        if (i < 0 || f > ((float) (getWidth() / 2))) {
            int i2 = (asin > 0.0d ? 1 : (asin == 0.0d ? 0 : -1));
            if (i2 < 0 && f <= ((float) (getWidth() / 2))) {
                f3 = (float) (((double) this.f11316h) - Math.toDegrees(asin));
            } else if (i2 > 0 || f <= ((float) (getWidth() / 2))) {
                f3 = (i <= 0 || f <= ((float) (getWidth() / 2))) ? 0.0f : (float) (((double) (this.f11316h + 180.0f)) + Math.abs(Math.toDegrees(asin)));
            } else {
                f3 = (float) (((double) (this.f11316h + 180.0f)) - Math.abs(Math.toDegrees(asin)));
            }
        } else {
            f3 = (float) (((double) this.f11316h) - Math.toDegrees(asin));
        }
        return (f3 / this.f11315g) * this.f11331w;
    }
    private float m12869a(float f, float f2) {
        float f3;
        double asin = Math.asin((double) ((f2 - ((float) (getWidth() / 2))) / ((float) Math.sqrt((double) (((f - ((float) (getWidth() / 2))) * (f - ((float) (getWidth() / 2)))) + ((f2 - ((float) (getWidth() / 2))) * (f2 - ((float) (getWidth() / 2)))))))));
        if (asin >= 0.0d && f <= ((float) (getWidth() / 2))) {
            double d = (double) this.f11316h;
            double degrees = Math.toDegrees(asin);
            Double.isNaN(d);
            f3 = (float) (d - degrees);
        } else if (asin < 0.0d && f <= ((float) (getWidth() / 2))) {
            double d2 = (double) this.f11316h;
            double degrees2 = Math.toDegrees(asin);
            Double.isNaN(d2);
            f3 = (float) (d2 - degrees2);
        } else if (asin <= 0.0d && f > ((float) (getWidth() / 2))) {
            double d3 = (double) (this.f11316h + 180.0f);
            double abs = Math.abs(Math.toDegrees(asin));
            Double.isNaN(d3);
            f3 = (float) (d3 - abs);
        } else if (asin <= 0.0d || f <= ((float) (getWidth() / 2))) {
            f3 = 0.0f;
        } else {
            double d4 = (double) (this.f11316h + 180.0f);
            double abs2 = Math.abs(Math.toDegrees(asin));
            Double.isNaN(d4);
            f3 = (float) (d4 + abs2);
        }
        return (f3 / this.f11315g) * this.f11331w;
    }

    /* renamed from: b */
    private boolean m12877b(float f, float f2) {
        float width = ((float) (getWidth() / 2)) - f;
        float width2 = ((float) (getWidth() / 2)) - f2;
        double d = (double) ((width * width) + (width2 * width2));
        return Math.sqrt(d) <= ((double) this.f11311c) && Math.sqrt(d) >= ((double) (this.f11311c - this.f11310b));
    }

    public void setProgress(float f) {
        if (f <= 0.0f) {
            f = 0.0f;
        }
        if (f >= this.f11331w) {
            f = this.f11331w;
        }
        this.f11321m = f;
        invalidate();
    }

    public float getProgress() {
        return this.f11321m;
    }

    public void setMax(float f) {
        this.f11331w = f;
    }

    public float getMax() {
        return this.f11331w;
    }

    public void setOnArcSeekChangedListener(C2846a aVar) {
        this.f11308C = aVar;
    }
}
