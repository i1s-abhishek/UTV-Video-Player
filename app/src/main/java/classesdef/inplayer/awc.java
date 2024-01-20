package classesdef.inplayer;

import android.media.audiofx.Virtualizer;

/* renamed from: awc */
public final class awc {

    /* renamed from: a */
    private final Virtualizer f6056a;

    public awc(int i) {
        this.f6056a = new Virtualizer(0, i);
    }

    /* renamed from: a */
    public boolean mo10854a() {
        return this.f6056a.getStrengthSupported();
    }

    /* renamed from: a */
    public void mo10853a(short s) {
        this.f6056a.setStrength(s);
    }

    /* renamed from: b */
    public short mo10855b() {
        return this.f6056a.getRoundedStrength();
    }

    /* renamed from: a */
    public int mo10852a(boolean z) {
        return this.f6056a.setEnabled(z);
    }

    /* renamed from: c */
    public boolean mo10856c() {
        return this.f6056a.getEnabled();
    }

    /* renamed from: d */
    public void mo10857d() {
        this.f6056a.release();
    }
}
