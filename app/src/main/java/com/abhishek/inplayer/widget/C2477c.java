package com.abhishek.inplayer.widget;

import android.view.View;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/* renamed from: com.inshot.inplayer.widget.c IRenderView */
public interface C2477c {

    /* renamed from: com.inshot.inplayer.widget.c$a */
    public interface C2478a {
        /* renamed from: a */
        void mo17527a();

        /* renamed from: a */
        void mo17528a(C2479b bVar);

        /* renamed from: a */
        void mo17529a(C2479b bVar, int i, int i2);

        /* renamed from: a */
        void mo17530a(C2479b bVar, int i, int i2, int i3);
    }

    /* renamed from: com.inshot.inplayer.widget.c$b */
    public interface C2479b {
        /* renamed from: a */
        C2477c mo17450a();

        /* renamed from: a */
        void mo17451a(IMediaPlayer avg);
    }

    /* renamed from: a */
    void setVideoSize(int i, int i2);

    /* renamed from: a */
    void mo17440a(C2478a aVar);

    /* renamed from: a */
    boolean mo17441a();

    /* renamed from: b */
    void setVideoSampleAspectRatio(int i, int i2);

    /* renamed from: b */
    void mo17443b(C2478a aVar);

    View getView();

    void setAspectRatio(int i);

    void setVideoRotation(int i);
}
