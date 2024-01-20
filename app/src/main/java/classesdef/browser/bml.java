package classesdef.browser;

/* renamed from: bml */
public class bml implements Comparable<bml> {

    /* renamed from: a */
    private String f15670a = "";

    /* renamed from: b */
    private String f15671b = "";

    /* renamed from: c */
    private String f15672c = "";

    /* renamed from: a */
    public String mo23086a() {
        return this.f15670a;
    }

    /* renamed from: a */
    public void mo23087a(String str) {
        if (str == null) {
            str = "";
        }
        this.f15670a = str;
    }

    /* renamed from: b */
    public String mo23088b() {
        return this.f15671b;
    }

    /* renamed from: b */
    public void mo23089b(String str) {
        if (str == null) {
            str = "";
        }
        this.f15671b = str;
    }

    /* renamed from: c */
    public String mo23090c() {
        return this.f15672c;
    }

    /* renamed from: c */
    public void mo23091c(String str) {
        if (str == null) {
            str = "";
        }
        this.f15672c = str;
    }

    public String toString() {
        return this.f15671b;
    }

    /* renamed from: a */
    public int compareTo(bml bml) {
        int compareTo = this.f15671b.compareTo(bml.f15671b);
        return compareTo == 0 ? this.f15670a.compareTo(bml.f15670a) : compareTo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof bml)) {
            return false;
        }
        bml bml = (bml) obj;
        if (!this.f15671b.equals(bml.f15671b) || !this.f15670a.equals(bml.f15670a) || !this.f15672c.equals(bml.f15672c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f15670a.hashCode() * 31) + this.f15671b.hashCode();
    }
}
