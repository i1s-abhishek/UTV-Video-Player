package classesdef.browser;

import com.mopub.mobileads.VastIconXmlManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: bpt */
public class bpt implements Serializable {

    /* renamed from: a */
    private String f16326a;

    /* renamed from: b */
    private String f16327b;

    /* renamed from: c */
    private String f16328c;

    /* renamed from: d */
    private String f16329d;

    /* renamed from: e */
    private String f16330e;

    /* renamed from: f */
    private String f16331f;

    /* renamed from: g */
    private String f16332g;

    /* renamed from: h */
    private String f16333h;

    /* renamed from: i */
    private String f16334i;

    /* renamed from: j */
    private String f16335j;

    /* renamed from: k */
    private String f16336k;

    /* renamed from: l */
    private String f16337l;

    /* renamed from: m */
    private Date f16338m;

    /* renamed from: n */
    private Collection<String> f16339n;

    /* renamed from: o */
    private List<bps> f16340o = null;

    /* renamed from: p */
    private final List<Map<String, String>> f16341p = new ArrayList();

    /* renamed from: q */
    private String f16342q;

    /* renamed from: r */
    private String f16343r;

    /* renamed from: s */
    private String f16344s;

    /* renamed from: a */
    public String mo23496a() {
        if (this.f16327b == null) {
            return "";
        }
        return this.f16327b;
    }

    /* renamed from: a */
    public bpt mo23494a(String str) {
        this.f16327b = str;
        return this;
    }

    /* renamed from: b */
    public bpt mo23500b(String str) {
        this.f16328c = str;
        return this;
    }

    /* renamed from: c */
    public bpt mo23502c(String str) {
        this.f16329d = str;
        return this;
    }

    /* renamed from: b */
    public String mo23501b() {
        if (this.f16334i == null) {
            return "";
        }
        return this.f16334i;
    }

    /* renamed from: d */
    public bpt mo23504d(String str) {
        this.f16334i = str;
        return this;
    }

    /* renamed from: e */
    public bpt mo23506e(String str) {
        this.f16332g = str;
        return this;
    }

    /* renamed from: c */
    public String mo23503c() {
        if (this.f16332g == null) {
            return "";
        }
        return this.f16332g;
    }

    /* renamed from: d */
    public String mo23505d() {
        if (this.f16335j == null) {
            return "";
        }
        return this.f16335j;
    }

    /* renamed from: f */
    public bpt mo23508f(String str) {
        this.f16335j = str;
        return this;
    }

    /* renamed from: e */
    public String mo23507e() {
        if (this.f16336k == null) {
            return "";
        }
        return this.f16336k;
    }

    /* renamed from: g */
    public bpt mo23510g(String str) {
        this.f16336k = str;
        return this;
    }

    /* renamed from: f */
    public String mo23509f() {
        if (this.f16337l == null) {
            return "";
        }
        return this.f16337l;
    }

    /* renamed from: h */
    public bpt mo23512h(String str) {
        this.f16337l = str;
        return this;
    }

    /* renamed from: g */
    public String mo23511g() {
        if (this.f16330e == null) {
            return "";
        }
        return this.f16330e;
    }

    /* renamed from: i */
    public bpt mo23514i(String str) {
        this.f16330e = str;
        return this;
    }

    /* renamed from: h */
    public String mo23513h() {
        if (this.f16333h == null) {
            return "";
        }
        return this.f16333h;
    }

    /* renamed from: j */
    public bpt mo23516j(String str) {
        this.f16333h = str;
        return this;
    }

    /* renamed from: i */
    public String mo23515i() {
        if (this.f16326a == null) {
            return "";
        }
        return this.f16326a;
    }

    /* renamed from: k */
    public bpt mo23518k(String str) {
        this.f16326a = str;
        return this;
    }

    /* renamed from: j */
    public String mo23517j() {
        if (this.f16331f == null) {
            return "";
        }
        return this.f16331f;
    }

    /* renamed from: l */
    public bpt mo23519l(String str) {
        this.f16331f = str;
        return this;
    }

    /* renamed from: a */
    public bpt mo23495a(Date date) {
        this.f16338m = date;
        return this;
    }

    /* renamed from: a */
    public void mo23498a(Collection<String> collection) {
        this.f16339n = collection;
    }

    /* renamed from: a */
    public void mo23499a(List<bps> list) {
        this.f16340o = list;
    }

    /* renamed from: a */
    public void mo23497a(String str, String str2, Integer num) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("text", str2);
        hashMap.put(VastIconXmlManager.OFFSET, String.valueOf(num));
        this.f16341p.add(hashMap);
    }

    /* renamed from: m */
    public void mo23520m(String str) {
        this.f16342q = str;
    }

    /* renamed from: n */
    public void mo23521n(String str) {
        this.f16343r = str;
    }

    /* renamed from: o */
    public void mo23522o(String str) {
        this.f16344s = str;
    }

    public String toString() {
        return "title:" + mo23515i() + " imageUrl:" + mo23511g() + " text:" + this.f16333h;
    }
}
