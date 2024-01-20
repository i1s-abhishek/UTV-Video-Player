package com.abhishek.xplayer.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.abhishek.xplayer.service.C2779a;


import org.greenrobot.eventbus.EventBus;

import java.util.Locale;

import classesdef.eventbus.awk;
import classesdef.xdplayer.awy;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;
import tv.danmaku.ijk.media.player.IMediaPlayer;


public class AudioPlayerFragment extends FragmentLifecycle implements View.OnClickListener {

    /* renamed from: a */
    private ImageView f10650a;

    /* renamed from: b */
    private TextView f10651b;

    /* renamed from: c */
    private TextView f10652c;

    /* renamed from: d */
    private ProgressBar f10653d;

    /* renamed from: e */
    private ImageView f10654e;

    /* renamed from: f */
    private C2779a.C2786a f10655f = new C2779a.C2786a() {
        /* renamed from: c */
        public void mo17674c() {
        }

        /* renamed from: d */
        public boolean mo17675d() {
            return true;
        }

        /* renamed from: a */
        public void mo17671a() {
            AudioPlayerFragment.this.m12232a(-1);
        }

        /* renamed from: b */
        public void mo17673b() {
            AudioPlayerFragment.this.m12232a(-1);
        }

        /* renamed from: a */
        public void mo17672a(long j) {
            AudioPlayerFragment.this.m12232a(j);
        }
    };

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_audio_player_mini, viewGroup, false);
        this.f10650a = (ImageView) inflate.findViewById(R.id.icon);
        this.f10651b = (TextView) inflate.findViewById(R.id.name);
        this.f10652c = (TextView) inflate.findViewById(R.id.time);
        this.f10653d = (ProgressBar) inflate.findViewById(R.id.progressBar);
        inflate.findViewById(R.id.next).setOnClickListener(this);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.play);
        this.f10654e = imageView;
        imageView.setOnClickListener(this);
        inflate.setOnClickListener(this);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        this.f10650a.setTag((Object) null);
        m12232a(-1);
        C2779a.m12613a().mo18133a(this.f10655f);
    }

    public void onPause() {
        super.onPause();
        C2779a.m12613a().mo18134b(this.f10655f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12232a(long j) {
        if (mo17989b() && C2779a.m12613a().mo18135b()) {
            IMediaPlayer c = C2779a.m12613a().mo18137c();
            String d = C2779a.m12613a().mo18138d();
            String e = C2779a.m12613a().mo18139e();
            long k = c.getDuration();
            if (j <= 0) {
                j = c.getCurrentPosition();
            }
            this.f10651b.setText(d);
            this.f10652c.setText(String.format(Locale.ENGLISH, "%s/%s", new Object[]{axy.m7459a(j), axy.m7459a(k)}));
            this.f10653d.setProgress(Math.round((((float) j) / ((float) k)) * 100.0f));
            if (!TextUtils.equals(e, (CharSequence) this.f10650a.getTag(R.id.tagID_path))) {
                if (k <= 0 || e == null || !e.startsWith("/")) {
                    this.f10650a.setTag(R.id.tagID_path, (Object) null);
                    this.f10650a.setImageResource(R.mipmap.video_default_thumb);
                } else {
                    this.f10650a.setTag(R.id.tagID_path, e);
                    Glide.with(getContext()).load(e).asBitmap().centerCrop().decoder((ResourceDecoder<ImageVideoWrapper, Bitmap>) new awy(e, getActivity(), k)).into(this.f10650a);
                }
            }
            if (c.isPlaying()) {
                this.f10654e.setImageResource(R.drawable.ic_pause_audio);
            } else {
                this.f10654e.setImageResource(R.drawable.ic_play_audio);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        if (mo17989b()) {
            int id = view.getId();
            if (id == R.id.next) {
                LogEvents.m18492b("AudioBottom", "Next");
                if (!C2779a.m12613a().mo18148n()) {
                    axv.m7434a((int) R.string.no_next_video);
                }
            } else if (id != R.id.play) {
                LogEvents.m18492b("AudioBottom", "GoToPlay");
                EventBus.getDefault().post(new awk());
                startActivity(C2779a.m12613a().mo18128a((Context) getActivity(), false));
            } else if (C2779a.m12613a().mo18147m()) {
                LogEvents.m18492b("AudioBottom", "Pause");
            } else {
                LogEvents.m18492b("AudioBottom", "Play");
            }
        }
    }
}
