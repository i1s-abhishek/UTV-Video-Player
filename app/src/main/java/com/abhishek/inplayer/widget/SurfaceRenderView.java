package com.abhishek.inplayer.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;

public class SurfaceRenderView extends SurfaceView implements C2477c {

    /* renamed from: a */
    private C2480d f9855a;

    /* renamed from: b */
    private C2463b f9856b;

    /* renamed from: a */
    public boolean mo17441a() {
        return true;
    }

    public View getView() {
        return this;
    }

    public void setVideoRotation(int i) {
    }

    public SurfaceRenderView(Context context) {
        super(context);
        m11168a(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11168a(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11168a(context);
    }

    /* renamed from: a */
    private void m11168a(Context context) {
        this.f9855a = new C2480d(this);
        this.f9856b = new C2463b(this);
        getHolder().addCallback(this.f9856b);
        getHolder().setType(0);
    }

    /* renamed from: a */
    public void setVideoSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f9855a.mo17538a(i, i2);
            getHolder().setFixedSize(i, i2);
            requestLayout();
        }
    }

    /* renamed from: b */
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f9855a.mo17541b(i, i2);
            requestLayout();
        }
    }

    public void setAspectRatio(int i) {
        this.f9855a.mo17540b(i);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f9855a.doMeasure(i, i2);
        setMeasuredDimension(this.f9855a.mo17536a(), this.f9855a.mo17539b());
    }

    /* renamed from: com.inshot.inplayer.widget.SurfaceRenderView$a */
    private static final class C2462a implements C2479b {

        /* renamed from: a */
        private SurfaceRenderView f9857a;

        /* renamed from: b */
        private SurfaceHolder f9858b;

        public C2462a(SurfaceRenderView surfaceRenderView, SurfaceHolder surfaceHolder) {
            this.f9857a = surfaceRenderView;
            this.f9858b = surfaceHolder;
        }

        /* renamed from: a */
        public void mo17451a(IMediaPlayer avg) {
            if (avg != null) {
                if (Build.VERSION.SDK_INT >= 16 && (avg instanceof ISurfaceTextureHolder)) {
                    ((ISurfaceTextureHolder) avg).setSurfaceTexture((SurfaceTexture) null);
                }
                avg.setDisplay(this.f9858b);
            }
        }

        /* renamed from: a */
        public C2477c mo17450a() {
            return this.f9857a;
        }
    }

    /* renamed from: a */
    public void mo17440a(C2478a aVar) {
        this.f9856b.mo17452a(aVar);
    }

    /* renamed from: b */
    public void mo17443b(C2478a aVar) {
        this.f9856b.mo17453b(aVar);
    }

    /* renamed from: com.inshot.inplayer.widget.SurfaceRenderView$b */
    private static final class C2463b implements SurfaceHolder.Callback {

        /* renamed from: a */
        private SurfaceHolder f9859a;

        /* renamed from: b */
        private boolean f9860b;

        /* renamed from: c */
        private int f9861c;

        /* renamed from: d */
        private int f9862d;

        /* renamed from: e */
        private int f9863e;

        /* renamed from: f */
        private WeakReference<SurfaceRenderView> f9864f;

        /* renamed from: g */
        private Map<C2478a, Object> f9865g = new ConcurrentHashMap();

        public C2463b(SurfaceRenderView surfaceRenderView) {
            this.f9864f = new WeakReference<>(surfaceRenderView);
        }

        /* renamed from: a */
        public void mo17452a(C2478a aVar) {
            C2462a aVar2;
            this.f9865g.put(aVar, aVar);
            if (this.f9859a != null) {
                aVar2 = new C2462a((SurfaceRenderView) this.f9864f.get(), this.f9859a);
                aVar.mo17529a(aVar2, this.f9862d, this.f9863e);
            } else {
                aVar2 = null;
            }
            if (this.f9860b) {
                if (aVar2 == null) {
                    aVar2 = new C2462a((SurfaceRenderView) this.f9864f.get(), this.f9859a);
                }
                aVar.mo17530a(aVar2, this.f9861c, this.f9862d, this.f9863e);
            }
        }

        /* renamed from: b */
        public void mo17453b(C2478a aVar) {
            this.f9865g.remove(aVar);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f9859a = surfaceHolder;
            this.f9860b = false;
            this.f9861c = 0;
            this.f9862d = 0;
            this.f9863e = 0;
            C2462a aVar = new C2462a((SurfaceRenderView) this.f9864f.get(), this.f9859a);
            for (C2478a a : this.f9865g.keySet()) {
                a.mo17529a(aVar, 0, 0);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f9859a = null;
            this.f9860b = false;
            this.f9861c = 0;
            this.f9862d = 0;
            this.f9863e = 0;
            C2462a aVar = new C2462a((SurfaceRenderView) this.f9864f.get(), this.f9859a);
            for (C2478a a : this.f9865g.keySet()) {
                a.mo17528a(aVar);
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.f9859a = surfaceHolder;
            this.f9860b = true;
            this.f9861c = i;
            this.f9862d = i2;
            this.f9863e = i3;
            C2462a aVar = new C2462a((SurfaceRenderView) this.f9864f.get(), this.f9859a);
            for (C2478a a : this.f9865g.keySet()) {
                a.mo17530a(aVar, i, i2, i3);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SurfaceRenderView.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(SurfaceRenderView.class.getName());
        }
    }
}
