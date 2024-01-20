package classesdef.browser;

import android.graphics.Bitmap;

/* renamed from: bmg */
public class bmg implements Comparable<bmg> {

    /* renamed from: a */
    private String f15639a = "";

    /* renamed from: b */
    private String f15640b = "";

    /* renamed from: c */
    private String f15641c = "";

    /* renamed from: d */
    private Bitmap f15642d = null;

    /* renamed from: e */
    private int f15643e = 0;

    /* renamed from: f */
    private int f15644f = 0;

    /* renamed from: g */
    private boolean f15645g = false;

    public bmg() {
    }

    public bmg(String str, String str2) {
        bql.m18952a(str);
        bql.m18952a(str2);
        this.f15639a = str;
        this.f15640b = str2;
        this.f15642d = null;
    }

    public bmg(String str, String str2, int i) {
        bql.m18952a(str);
        bql.m18952a(str2);
        this.f15639a = str;
        this.f15640b = str2;
        this.f15642d = null;
        this.f15643e = i;
    }

    /* renamed from: a */
    public int mo23039a() {
        return this.f15643e;
    }

    /* renamed from: a */
    public void mo23041a(int i) {
        this.f15643e = i;
    }

    /* renamed from: a */
    public void mo23042a(Bitmap bitmap) {
        this.f15642d = bitmap;
    }

    /* renamed from: a */
    public void mo23043a(String str) {
        if (str == null) {
            str = "";
        }
        this.f15641c = str;
    }

    /* renamed from: b */
    public void mo23046b(int i) {
        this.f15644f = i;
    }

    /* renamed from: b */
    public int mo23045b() {
        return this.f15644f;
    }

    /* renamed from: c */
    public String mo23048c() {
        return this.f15641c;
    }

    /* renamed from: d */
    public Bitmap mo23051d() {
        return this.f15642d;
    }

    /* renamed from: e */
    public String mo23052e() {
        return this.f15639a;
    }

    /* renamed from: b */
    public void mo23047b(String str) {
        if (str == null) {
            str = "";
        }
        this.f15639a = str;
    }

    /* renamed from: f */
    public String mo23054f() {
        return this.f15640b;
    }

    /* renamed from: c */
    public void mo23049c(String str) {
        if (str == null) {
            str = "";
        }
        this.f15640b = str;
    }

    /* renamed from: a */
    public void mo23044a(boolean z) {
        this.f15645g = z;
    }

    /* renamed from: g */
    public boolean mo23055g() {
        return this.f15645g;
    }

    public String toString() {
        return this.f15640b;
    }

    /* renamed from: a */
    public int compareTo(bmg bmg) {
        int compareTo = this.f15640b.compareTo(bmg.f15640b);
        return compareTo == 0 ? this.f15639a.compareTo(bmg.f15639a) : compareTo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof bmg)) {
            return false;
        }
        bmg bmg = (bmg) obj;
        if (this.f15643e != bmg.f15643e || !this.f15640b.equals(bmg.f15640b) || !this.f15639a.equals(bmg.f15639a) || !this.f15641c.equals(bmg.f15641c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((this.f15639a.hashCode() * 31) + this.f15643e) * 31) + this.f15640b.hashCode()) * 32) + this.f15641c.hashCode()) * 31) + this.f15643e;
    }
}
