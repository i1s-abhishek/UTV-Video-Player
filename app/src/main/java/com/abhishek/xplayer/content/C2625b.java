package com.abhishek.xplayer.content;

import android.content.Intent;
import android.os.Build;

import androidx.fragment.app.Fragment;

import com.abhishek.xplayer.application.MyApplication;

import java.util.List;
import java.util.Set;

import classesdef.xdplayer.axq;
import hdplayer.xdplayer.videoplayer.R;

public class C2625b {

    public boolean f10558a;

    public C2630d f10559b;

    public C2631e f10560c;

    private List<MediaFileInfo> f10561d;

    private axq f10562e;

    private int f10563f;

    private C2628b f10564g = new C2628b();

    interface C2627a extends C2630d {
        /* renamed from: a */
        void mo17935a(List<String> list);

        /* renamed from: a */
        void mo17936a(boolean z);
    }

    /* renamed from: com.inshot.xplayer.content.b$c */
    interface C2629c extends C2631e {
    }

    /* renamed from: com.inshot.xplayer.content.b$d */
    public interface C2630d {
        /* renamed from: a */
        void mo17937a();

        /* renamed from: a */
        void mo17938a(String str);

        /* renamed from: a */
        void mo17939a(Set<String> set, int i, int i2, String str, boolean z);

        /* renamed from: c */
        void mo17943c(String str);
    }

    /* renamed from: com.inshot.xplayer.content.b$e */
    public interface C2631e {
        /* renamed from: b */
        void mo17940b();

        /* renamed from: b */
        void mo17941b(String str);

        /* renamed from: b */
        void mo17942b(List<MediaFileInfo> list);

        /* renamed from: c */
        void mo17943c(String str);
    }

    /* renamed from: a */
    public void mo17933a(List<MediaFileInfo> list, C2630d dVar) {
        this.f10558a = false;
        this.f10559b = dVar;
        this.f10561d = list;
        m12097a(true);
    }

    /* renamed from: a */
    public void mo17934a(List<MediaFileInfo> list, C2631e eVar) {
        this.f10558a = true;
        this.f10560c = eVar;
        this.f10561d = list;
        m12100b(true);
    }

    /* renamed from: a */
    public void mo17932a(Fragment fragment, int i) {
        if (this.f10562e == null) {
            this.f10562e = new axq(this.f10564g, this.f10564g.f10569e);
        }
        this.f10562e.mo10993a(fragment, i);
    }

    /* renamed from: a */
    public void mo17931a(int i, Intent intent) {
        if (this.f10562e != null) {
            this.f10562e.mo10992a(i, intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12097a(boolean z) {
        this.f10559b.mo17937a();
        C2636d.m12140a(this.f10563f, this.f10561d, this.f10564g.f10571g, z && Build.VERSION.SDK_INT >= 21, this.f10564g);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12100b(boolean z) {
        this.f10560c.mo17940b();
        C2636d.m12146a(this.f10561d, this.f10564g.f10572h, z && Build.VERSION.SDK_INT >= 21, this.f10564g);
    }

    /* renamed from: com.inshot.xplayer.content.b$b */
    private class C2628b implements axq.C1362a, C2627a, C2629c {

        /* renamed from: a */
        int f10565a;

        /* renamed from: b */
        int f10566b;

        /* renamed from: c */
        String f10567c;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public String f10569e;

        /* renamed from: f */
        private List<String> f10570f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public Set<String> f10571g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public List<MediaFileInfo> f10572h;

        /* renamed from: i */
        private String f10573i;

        /* renamed from: j */
        private boolean f10574j;

        /* renamed from: k */
        private boolean f10575k;

        /* renamed from: a */
        public void mo17937a() {
        }

        /* renamed from: b */
        public void mo17940b() {
        }

        private C2628b() {
        }

        /* renamed from: a */
        public void mo17939a(Set<String> set, int i, int i2, String str, boolean z) {
            if (this.f10575k) {
                this.f10575k = false;
                this.f10571g = set;
                this.f10565a = i;
                this.f10566b = i2;
                this.f10567c = str;
                this.f10574j = z;
                C2625b.this.f10559b.mo17943c(this.f10569e);
                return;
            }
            C2625b.this.f10559b.mo17939a(set, i, i2, str, z);
        }

        /* renamed from: a */
        public void mo17938a(String str) {
            if (this.f10575k) {
                this.f10575k = false;
                this.f10573i = str;
                C2625b.this.f10559b.mo17943c(this.f10569e);
            } else if (this.f10571g != null) {
                C2625b.this.f10559b.mo17939a(this.f10571g, this.f10565a, this.f10566b, this.f10567c, this.f10574j);
            } else {
                C2625b.this.f10559b.mo17938a(str);
            }
        }

        /* renamed from: b */
        public void mo17942b(List<MediaFileInfo> list) {
            if (this.f10575k) {
                this.f10575k = false;
                this.f10572h = list;
                C2625b.this.f10560c.mo17943c(this.f10569e);
                return;
            }
            C2625b.this.f10560c.mo17942b(list);
        }

        /* renamed from: b */
        public void mo17941b(String str) {
            if (this.f10575k) {
                this.f10575k = false;
                this.f10573i = str;
                C2625b.this.f10560c.mo17943c(this.f10569e);
            } else if (this.f10572h != null) {
                C2625b.this.f10560c.mo17942b(this.f10572h);
            } else {
                C2625b.this.f10560c.mo17941b(str);
            }
        }

        /* renamed from: c */
        public void mo17943c(String str) {
            this.f10575k = true;
            this.f10569e = str;
        }

        /* renamed from: a */
        public void mo17935a(List<String> list) {
            this.f10575k = true;
            this.f10570f = list;
            this.f10569e = list.get(0);
        }

        /* renamed from: a */
        public void mo17936a(boolean z) {
            if (!z && !this.f10574j) {
                String string = MyApplication.getApplicationContext_().getString(R.string.delete_failed_cant_write);
                if (this.f10567c != null) {
                    if (!this.f10567c.isEmpty()) {
                        this.f10567c += "\n\n";
                    }
                    this.f10567c += string;
                } else {
                    this.f10567c = string;
                }
                this.f10574j = true;
            }
            C2625b.this.f10559b.mo17939a(this.f10571g, this.f10565a, this.f10566b, this.f10567c, this.f10574j);
        }

        /* renamed from: c */
        public void mo10931c() {
            if (C2625b.this.f10558a) {
                C2625b.this.m12100b(false);
            } else if (this.f10570f != null) {
                C2625b.this.f10559b.mo17937a();
                C2636d.m12144a(this.f10570f, (C2627a) this);
            } else {
                C2625b.this.m12097a(false);
            }
        }

        /* renamed from: d */
        public void mo10932d() {
            if (C2625b.this.f10558a) {
                if (this.f10572h != null) {
                    C2625b.this.f10560c.mo17942b(this.f10572h);
                } else {
                    C2625b.this.f10560c.mo17941b(this.f10573i);
                }
            } else if (this.f10570f != null) {
                mo17936a(false);
            } else if (this.f10571g != null) {
                C2625b.this.f10559b.mo17939a(this.f10571g, this.f10565a, this.f10566b, this.f10567c, this.f10574j);
            } else {
                C2625b.this.f10559b.mo17938a(this.f10573i);
            }
        }

        /* renamed from: e */
        public void mo10933e() {
            mo10932d();
        }
    }
}
