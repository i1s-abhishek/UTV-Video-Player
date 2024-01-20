package classesdef.inplayer;

import android.media.audiofx.Equalizer;

/* renamed from: awa */
public final class awa {

    /* renamed from: a */
    private final Equalizer f6054a;

    public awa(int i) {
        this.f6054a = new Equalizer(0, i);
    }

    /* renamed from: a */
    public short[] mo10841a() {
        return this.f6054a.getBandLevelRange();
    }

    /* renamed from: a */
    public int mo10836a(short s) {
        return this.f6054a.getCenterFreq(s);
    }

    /* renamed from: b */
    public short mo10844b() {
        return this.f6054a.getNumberOfBands();
    }

    /* renamed from: a */
    public void mo10839a(short s, short s2) {
        this.f6054a.setBandLevel(s, s2);
    }

    /* renamed from: b */
    public int mo10842b(short s) {
        return this.f6054a.getBandLevel(s);
    }

    /* renamed from: a */
    public void mo10840a(short s, short[] sArr) {
        Equalizer.Settings settings = new Equalizer.Settings();
        settings.curPreset = -1;
        settings.numBands = s;
        settings.bandLevels = sArr;
        this.f6054a.setProperties(settings);
    }

    /* renamed from: a */
    public int mo10837a(boolean z) {
        return this.f6054a.setEnabled(z);
    }

    /* renamed from: c */
    public boolean mo10845c() {
        return this.f6054a.getEnabled();
    }

    /* renamed from: d */
    public void mo10846d() {
        this.f6054a.release();
    }

    /* renamed from: e */
    public int mo10847e() {
        return this.f6054a.getNumberOfPresets();
    }

    /* renamed from: a */
    public void mo10838a(int i) {
        this.f6054a.usePreset((short) i);
    }

    /* renamed from: b */
    public String mo10843b(int i) {
        return this.f6054a.getPresetName((short) i);
    }
}
