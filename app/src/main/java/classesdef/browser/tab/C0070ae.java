package classesdef.browser.tab;

import android.os.Handler;
import android.os.Looper;

/* renamed from: ae */
public class C0070ae implements C4704r {

    /* renamed from: a */
    private final Handler f850a;

    public C0070ae(Looper looper) {
        this.f850a = new Handler(looper);
    }

    /* renamed from: a */
    public synchronized void mo322a(Runnable runnable) {
        this.f850a.post(runnable);
    }
}
