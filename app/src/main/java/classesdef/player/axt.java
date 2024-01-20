package classesdef.player;

import android.app.Activity;

/* renamed from: axt */
public class axt {

    /* renamed from: a */
    private Activity f6312a;

    /* renamed from: b */
    private C1363a f6313b;

    /* renamed from: c */
    private boolean f6314c = true;

    /* renamed from: axt$a */
    public interface C1363a {
        /* renamed from: a */
        void mo11006a(boolean z);
    }

    /* renamed from: a */
    public void mo10999a() {
    }

    public axt(Activity activity) {
        this.f6312a = activity;
    }

    /* renamed from: b */
    public boolean mo11003b() {
        return this.f6314c;
    }

    /* renamed from: c */
    public void mo11004c() {
        mo11001a(false);
    }

    /* renamed from: a */
    public void mo11001a(boolean z) {
        this.f6314c = false;
        m7419c(false);
        if (!z && this.f6313b != null) {
            this.f6313b.mo11006a(false);
        }
    }

    /* renamed from: d */
    public void mo11005d() {
        mo11002b(false);
    }

    /* renamed from: b */
    public void mo11002b(boolean z) {
        this.f6314c = true;
        if (!z) {
            m7419c(true);
        }
        if (this.f6313b != null) {
            this.f6313b.mo11006a(true);
        }
    }

    /* renamed from: a */
    public void mo11000a(C1363a aVar) {
        this.f6313b = aVar;
    }

    /* renamed from: c */
    private void m7419c(boolean z) {
        int i;
        int i2;
        if (aws.m7192b()) {
            i2 = 1280;
            i = 512;
        } else {
            i2 = 0;
            i = 0;
        }
        if (!z) {
            this.f6312a.getWindow().addFlags(1024);
            if (aws.m7191a()) {
                i |= 1;
            } else {
                i2 |= 1;
            }
            if (!awr.m7188b()) {
                i |= 2;
                if (aws.m7193c()) {
                    i2 |= 2048;
                }
                if (aws.m7192b()) {
                    i2 |= 4;
                }
            }
        } else {
            this.f6312a.getWindow().clearFlags(1024);
            i2 = aws.m7191a() ? i2 | 0 : i2 | 0;
        }
        if (awr.m7187a()) {
            i2 |= i;
        }
        this.f6312a.getWindow().getDecorView().setSystemUiVisibility(i2);
    }
}
