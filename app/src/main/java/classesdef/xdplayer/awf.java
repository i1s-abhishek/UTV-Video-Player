package classesdef.xdplayer;

import android.media.MediaPlayer;
import android.util.Log;

import com.abhishek.xplayer.application.MyApplication;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: awf */
public class awf {

    /* renamed from: b */
    private static awf f6075b = new awf();

    /* renamed from: a */
    private MediaPlayer f6076a;

    /* renamed from: a */
    public static awf m7131a() {
        return f6075b;
    }

    /* renamed from: b */
    public int mo10858b() {
        if (this.f6076a == null) {
            Log.e("EqualizerActivity_","default_music");
            this.f6076a = MediaPlayer.create(MyApplication.getApplicationContext_(), R.raw.default_music);
        }
        if (this.f6076a == null) {
            return 0;
        }
        return this.f6076a.getAudioSessionId();
    }

    /* renamed from: c */
    public void mo10859c() {
        if (this.f6076a != null) {
            this.f6076a.release();
            this.f6076a = null;
        }
    }

    /* renamed from: d */
    public boolean mo10860d() {
        return this.f6076a != null;
    }
}
