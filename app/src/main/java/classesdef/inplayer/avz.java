package classesdef.inplayer;

import android.media.audiofx.BassBoost;

/* renamed from: avz */
public final class avz {

    /* renamed from: a */
    private final BassBoost f6032a;

    public avz(int i) {
        this.f6032a = new BassBoost(0, i);
    }

    /* renamed from: a */
    public boolean mo10827a() {
        return this.f6032a.getStrengthSupported();
    }

    /* renamed from: a */
    public void mo10826a(short s) {
        this.f6032a.setStrength(s);
    }

    /* renamed from: b */
    public short mo10828b() {
        return this.f6032a.getRoundedStrength();
    }

    /* renamed from: a */
    public int mo10825a(boolean z) {
        return this.f6032a.setEnabled(z);
    }

    /* renamed from: c */
    public boolean mo10829c() {
        return this.f6032a.getEnabled();
    }

    /* renamed from: d */
    public void mo10830d() {
        this.f6032a.release();
    }
}
