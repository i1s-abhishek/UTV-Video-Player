package classesdef.xdplayer;

import android.content.Intent;
import android.os.Build;

import androidx.fragment.app.Fragment;

import com.abhishek.xplayer.application.MyApplication;

import java.io.File;
import java.util.List;

/* renamed from: axa */
public class axa implements axq.C1362a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<String> f6215a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f6216b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1330a f6217c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f6218d;

    /* renamed from: e */
    private axq f6219e;

    /* renamed from: axa$a */
    public interface C1330a {
        /* renamed from: a */
        void mo10938a();

        /* renamed from: b */
        void mo10939b();

        /* renamed from: c */
        void mo10940c();

        /* renamed from: d */
        void mo10941d();
    }

    public axa(List<String> list, C1330a aVar) {
        this.f6217c = aVar;
        this.f6215a = list;
    }

    /* renamed from: a */
    public void mo10930a(boolean z) {
        this.f6216b = z && Build.VERSION.SDK_INT >= 21;
        this.f6217c.mo10941d();
        new Thread() {
            public void run() {
                boolean z = true;
                for (String str : axa.this.f6215a) {
                    if (awx.m7220a(MyApplication.getApplicationContext_(), new File(str))) {
                        z = false;
                    } else if (axa.this.f6216b) {
                        String unused = axa.this.f6218d = str;
                        MyApplication.myApplication().runnable((Runnable) new Runnable() {
                            public void run() {
                                axa.this.f6217c.mo10940c();
                            }
                        });
                        return;
                    }
                }
                if (z) {
                    MyApplication.myApplication().runnable((Runnable) new Runnable() {
                        public void run() {
                            axa.this.f6217c.mo10939b();
                        }
                    });
                } else {
                    MyApplication.myApplication().runnable((Runnable) new Runnable() {
                        public void run() {
                            axa.this.f6217c.mo10938a();
                        }
                    });
                }
            }
        }.start();
    }

    /* renamed from: a */
    public void mo10929a(Fragment fragment, int i) {
        if (this.f6219e == null) {
            this.f6219e = new axq(this, this.f6218d);
        }
        this.f6219e.mo10993a(fragment, i);
    }

    /* renamed from: a */
    public void mo10928a(int i, Intent intent) {
        if (this.f6219e != null) {
            this.f6219e.mo10992a(i, intent);
        }
    }

    /* renamed from: c */
    public void mo10931c() {
        mo10930a(false);
    }

    /* renamed from: d */
    public void mo10932d() {
        this.f6217c.mo10939b();
    }

    /* renamed from: e */
    public void mo10933e() {
        this.f6217c.mo10939b();
    }
}
