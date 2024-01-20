package com.us.rateus;

import android.app.Dialog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: a */
public class C2938a {

    /* renamed from: a */
    private static C2938a f10450a;

    /* renamed from: b */
    private List<C2940a> f10451b = new ArrayList();

    /* renamed from: c */
    private int f10452c;

    /* renamed from: d */
    private boolean f10453d;

    /* renamed from: a */
    public static C2938a m12996a() {
        if (f10450a == null) {
            f10450a = new C2938a();
        }
        return f10450a;
    }

    private C2938a() {
    }

    /* renamed from: a */
    public void mo20084a(Dialog dialog, int i) {
        if (dialog != null) {
            Iterator<C2940a> it = this.f10451b.iterator();
            while (it.hasNext()) {
                C2940a next = it.next();
                if (!(next == null || next.mo20086a() == null)) {
                    next.mo20087a(true);
                    next.mo20088b();
                    it.remove();
                }
            }
            this.f10452c = i;
            this.f10453d = false;
            this.f10451b.add(new C2940a(dialog, i) {
            });
        }
    }

    /* renamed from: b */
    public void mo20085b() {
        for (C2940a next : this.f10451b) {
            if (next != null) {
                next.mo20087a(false);
                next.mo20088b();
            }
        }
        this.f10452c = 0;
        this.f10451b.clear();
        this.f10451b = null;
        f10450a = null;
    }

    /* renamed from: a$a */
    public abstract class C2940a {

        /* renamed from: a */
        private Dialog f10455a;

        /* renamed from: c */
        private boolean f10457c;

        /* renamed from: d */
        private int f10458d;

        public C2940a(Dialog dialog, int i) {
            this.f10455a = dialog;
            this.f10458d = i;
        }

        /* renamed from: a */
        public Dialog mo20086a() {
            return this.f10455a;
        }

        /* renamed from: a */
        public void mo20087a(boolean z) {
            this.f10457c = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo20088b() {
            Dialog dialog = this.f10455a;
            if (dialog != null) {
                dialog.dismiss();
                this.f10455a = null;
            }
        }
    }
}
