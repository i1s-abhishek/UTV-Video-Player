package com.abhishek.inplayer.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;
import tv.danmaku.ijk.media.player.ISurfaceTextureHost;

@TargetApi(14)
public class TextureRenderView extends TextureView implements C2477c {

    /* renamed from: a */
    private C2480d f9866a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C2465b f9867b;

    /* renamed from: a */
    public boolean mo17441a() {
        return false;
    }

    public View getView() {
        return this;
    }

    public TextureRenderView(Context context) {
        super(context);
        m11179a(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11179a(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11179a(context);
    }

    /* renamed from: a */
    private void m11179a(Context context) {
        this.f9866a = new C2480d(this);
        this.f9867b = new C2465b(this);
        setSurfaceTextureListener(this.f9867b);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f9867b.mo17463a();
        super.onDetachedFromWindow();
        this.f9867b.mo17466b();
    }

    /* renamed from: a */
    public void setVideoSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f9866a.mo17538a(i, i2);
            requestLayout();
        }
    }

    /* renamed from: b */
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f9866a.mo17541b(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.f9866a.mo17537a(i);
        setRotation((float) i);
    }

    public void setAspectRatio(int i) {
        this.f9866a.mo17540b(i);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f9866a.doMeasure(i, i2);
        setMeasuredDimension(this.f9866a.mo17536a(), this.f9866a.mo17539b());
    }

    public C2479b getSurfaceHolder() {
        return new C2464a(this, this.f9867b.f9871a, this.f9867b);
    }

    /* renamed from: com.inshot.inplayer.widget.TextureRenderView$a */
    private static final class C2464a implements C2479b {

        /* renamed from: a */
        private TextureRenderView f9868a;

        /* renamed from: b */
        private SurfaceTexture f9869b;

        /* renamed from: c */
        private ISurfaceTextureHost f9870c;

        public C2464a(TextureRenderView textureRenderView, SurfaceTexture surfaceTexture, ISurfaceTextureHost avi) {
            this.f9868a = textureRenderView;
            this.f9869b = surfaceTexture;
            this.f9870c = avi;
        }

        @TargetApi(16)
        /* renamed from: a */
        public void mo17451a(IMediaPlayer avg) {
            if (avg != null) {
                if (Build.VERSION.SDK_INT < 16 || !(avg instanceof ISurfaceTextureHolder)) {
                    avg.setSurface(mo17462b());
                    return;
                }
                ISurfaceTextureHolder avh = (ISurfaceTextureHolder) avg;
                this.f9868a.f9867b.mo17465a(false);
                SurfaceTexture a = avh.getSurfaceTexture();
                if (a != null) {
                    this.f9868a.setSurfaceTexture(a);
                    return;
                }
                avh.setSurfaceTexture(this.f9869b);
                avh.setSurfaceTextureHost((ISurfaceTextureHost) this.f9868a.f9867b);
            }
        }

        /* renamed from: a */
        public C2477c mo17450a() {
            return this.f9868a;
        }

        /* renamed from: b */
        public Surface mo17462b() {
            if (this.f9869b == null) {
                return null;
            }
            return new Surface(this.f9869b);
        }
    }

    /* renamed from: a */
    public void mo17440a(C2478a aVar) {
        this.f9867b.mo17464a(aVar);
    }

    /* renamed from: b */
    public void mo17443b(C2478a aVar) {
        this.f9867b.mo17467b(aVar);
    }

    /* renamed from: com.inshot.inplayer.widget.TextureRenderView$b */
    private static final class C2465b implements SurfaceTextureListener, ISurfaceTextureHost {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public SurfaceTexture f9871a;

        /* renamed from: b */
        private boolean f9872b;

        /* renamed from: c */
        private int f9873c;

        /* renamed from: d */
        private int f9874d;

        /* renamed from: e */
        private boolean f9875e = true;

        /* renamed from: f */
        private boolean f9876f = false;

        /* renamed from: g */
        private boolean f9877g = false;

        /* renamed from: h */
        private WeakReference<TextureRenderView> f9878h;

        /* renamed from: i */
        private Map<C2478a, Object> f9879i = new ConcurrentHashMap();

        public C2465b(TextureRenderView textureRenderView) {
            this.f9878h = new WeakReference<>(textureRenderView);
        }

        /* renamed from: a */
        public void mo17465a(boolean z) {
            this.f9875e = z;
        }

        /* renamed from: a */
        public void mo17464a(C2478a aVar) {
            C2464a aVar2;
            this.f9879i.put(aVar, aVar);
            if (this.f9871a != null) {
                aVar2 = new C2464a((TextureRenderView) this.f9878h.get(), this.f9871a, this);
                aVar.mo17529a(aVar2, this.f9873c, this.f9874d);
            } else {
                aVar2 = null;
            }
            if (this.f9872b) {
                if (aVar2 == null) {
                    aVar2 = new C2464a((TextureRenderView) this.f9878h.get(), this.f9871a, this);
                }
                aVar.mo17530a(aVar2, 0, this.f9873c, this.f9874d);
            }
        }

        /* renamed from: b */
        public void mo17467b(C2478a aVar) {
            this.f9879i.remove(aVar);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f9871a = surfaceTexture;
            this.f9872b = false;
            this.f9873c = 0;
            this.f9874d = 0;
            C2464a aVar = new C2464a((TextureRenderView) this.f9878h.get(), surfaceTexture, this);
            for (C2478a a : this.f9879i.keySet()) {
                a.mo17529a(aVar, 0, 0);
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f9871a = surfaceTexture;
            this.f9872b = true;
            this.f9873c = i;
            this.f9874d = i2;
            C2464a aVar = new C2464a((TextureRenderView) this.f9878h.get(), surfaceTexture, this);
            for (C2478a a : this.f9879i.keySet()) {
                a.mo17530a(aVar, 0, i, i2);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f9871a = surfaceTexture;
            this.f9872b = false;
            this.f9873c = 0;
            this.f9874d = 0;
            C2464a aVar = new C2464a((TextureRenderView) this.f9878h.get(), surfaceTexture, this);
            for (C2478a a : this.f9879i.keySet()) {
                a.mo17528a(aVar);
            }
            return this.f9875e;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            for (C2478a a : this.f9879i.keySet()) {
                a.mo17527a();
            }
        }

        /* renamed from: a */
        public void mo17463a() {
            this.f9876f = true;
        }

        /* renamed from: b */
        public void mo17466b() {
            this.f9877g = true;
        }
        @Override
        public void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {

        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }
}
