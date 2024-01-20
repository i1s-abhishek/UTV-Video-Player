package classesdef.inplayer;

import android.media.audiofx.PresetReverb;

/* renamed from: awb */
public class awb {

    /* renamed from: a */
    private final PresetReverb f6055a;

    public awb(int i) {
        this.f6055a = new PresetReverb(0, i);
    }

    /* renamed from: a */
    public void mo10849a(short s) {
        this.f6055a.setPreset(s);
    }

    /* renamed from: a */
    public int mo10848a(boolean z) {
        return this.f6055a.setEnabled(z);
    }

    /* renamed from: a */
    public boolean mo10850a() {
        return this.f6055a.getEnabled();
    }

    /* renamed from: b */
    public void mo10851b() {
        this.f6055a.release();
    }
}
