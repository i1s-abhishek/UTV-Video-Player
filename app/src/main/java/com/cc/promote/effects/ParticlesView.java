package com.cc.promote.effects;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cc.promote.effects.ParticlesView */
public class ParticlesView extends View {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<C1452b> f6528a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f6529b = new Handler() {
        public void handleMessage(Message message) {
            for (C1452b a : ParticlesView.this.f6528a) {
                a.mo11393a();
            }
            ParticlesView.this.invalidate();
            ParticlesView.this.f6529b.sendEmptyMessageDelayed(0, 10);
        }
    };

    /* renamed from: c */
    private boolean f6530c;

    public ParticlesView(Context context) {
        super(context);
    }

    public ParticlesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParticlesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ParticlesView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    public void mo11383a(List<C1452b> list) {
        if (list != null) {
            this.f6528a.addAll(list);
        }
    }

    /* renamed from: a */
    public void mo11382a() {
        if (this.f6528a.isEmpty()) {
            throw new IllegalStateException("Must add at least one animator");
        }
        for (C1452b start : this.f6528a) {
            start.start();
        }
        this.f6529b.removeMessages(0);
        this.f6529b.sendEmptyMessageDelayed(0, 10);
    }

    /* renamed from: b */
    public void mo11384b() {
        this.f6529b.removeMessages(0);
        for (C1452b cancel : this.f6528a) {
            cancel.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (C1452b a : this.f6528a) {
            a.mo11394a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("ParticlesView", "onAttached");
        this.f6530c = true;
        if (!this.f6528a.isEmpty()) {
            mo11382a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("ParticlesView", "onDetached");
        this.f6530c = false;
        mo11384b();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        Log.d("ParticlesView", "Visibility changed:" + i);
        if (this.f6530c) {
            if (i != 0) {
                mo11384b();
            } else if (!this.f6528a.isEmpty()) {
                mo11382a();
            }
        }
    }
}
