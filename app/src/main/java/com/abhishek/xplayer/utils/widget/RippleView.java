package com.abhishek.xplayer.utils.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class RippleView extends View {

    /* renamed from: a */
    private Paint f11369a;

    /* renamed from: b */
    private float f11370b;

    /* renamed from: c */
    private int f11371c = Color.parseColor("#55ff0000");

    /* renamed from: d */
    private int f11372d;

    /* renamed from: e */
    private int f11373e;

    /* renamed from: f */
    private int f11374f;

    public int getBgAlpha() {
        return this.f11374f;
    }

    public void setBgAlpha(int i) {
        this.f11374f = i;
    }

    public RippleView(Context context) {
        super(context);
        m12918a();
    }

    public RippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12918a();
    }

    /* renamed from: a */
    private void m12918a() {
        this.f11369a = new Paint(5);
    }

    public void setColor(int i) {
        this.f11371c = i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m12917a(i), m12919b(i2));
    }

    /* renamed from: a */
    private int m12917a(int i) {
        return MeasureSpec.getMode(i) == Integer.MIN_VALUE ? getResources().getDisplayMetrics().widthPixels : MeasureSpec.getSize(i);
    }

    /* renamed from: b */
    private int m12919b(int i) {
        return MeasureSpec.getMode(i) == Integer.MIN_VALUE ? (int) TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics()) : MeasureSpec.getSize(i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11372d = getHeight();
        this.f11373e = getWidth();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f11369a.setColor(this.f11371c);
        canvas.drawCircle((float) (this.f11373e / 2), (float) (this.f11372d / 2), this.f11370b, this.f11369a);
    }

    public float getRadius() {
        return this.f11370b;
    }

    public void setRadius(float f) {
        this.f11370b = f;
    }
}
