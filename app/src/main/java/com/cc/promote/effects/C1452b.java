package com.cc.promote.effects;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.media.session.PlaybackStateCompat;

import classesdef.ads.C4294ho;
import classesdef.ads.C4297hr;

/* renamed from: com.cc.promote.effects.b */
public class C1452b extends ValueAnimator {

    /* renamed from: a */
    private C4297hr[] f6533a;

    /* renamed from: b */
    private Paint f6534b;

    /* renamed from: c */
    private C4294ho f6535c;

    public C1452b(C4294ho hoVar, Rect rect, Paint paint) {
        this.f6535c = hoVar;
        setFloatValues(new float[]{0.0f, 1.0f});
        setDuration(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
        this.f6534b = paint;
        this.f6533a = hoVar.mo17845a(rect);
    }

    /* renamed from: a */
    public void mo11393a() {
        if (isStarted()) {
            for (C4297hr a : this.f6533a) {
                a.mo17843a(((Float) getAnimatedValue()).floatValue());
            }
        }
    }

    /* renamed from: a */
    public void mo11394a(Canvas canvas) {
        if (isStarted()) {
            for (C4297hr a : this.f6533a) {
                a.mo23956a(canvas, this.f6534b, ((Float) getAnimatedValue()).floatValue());
            }
        }
    }
}
