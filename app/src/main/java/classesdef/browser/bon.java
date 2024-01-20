package classesdef.browser;

import java.util.ArrayList;
import java.util.Iterator;


public class bon {


    private static bon f16067a;


    private ArrayList<String> f16068b = new ArrayList<>();


    private ArrayList<String> f16069c = new ArrayList<>();


    private ArrayList<String> f16070d = new ArrayList<>();


    private ArrayList<String> f16071e = new ArrayList<>();


    private ArrayList<String> f16072f = new ArrayList<>();

    private ArrayList<String> f16073g = new ArrayList<>();


    public String mo23286a(int i) {
        if (i == 100) {
            return ".unknown";
        }
        switch (i) {
            case 2:
                return ".mp4";
            case 3:
                return ".png";
            case 4:
                return ".mp3";
            case 5:
                return ".apk";
            case 6:
                return ".rar";
            case 7:
                return ".txt";
            default:
                return ".unknown";
        }
    }

    private bon() {
        m18361c();
        m18360b();
        m18362d();
        m18363e();
        m18364f();
        m18365g();
    }

    /* renamed from: a */
    public int mo23285a(String str) {
        if (mo23288c(str)) {
            return 4;
        }
        if (mo23287b(str)) {
            return 2;
        }
        if (mo23289d(str)) {
            return 3;
        }
        if (mo23290e(str)) {
            return 5;
        }
        if (mo23292g(str)) {
            return 6;
        }
        return mo23291f(str) ? 7 : 100;
    }

    /* renamed from: a */
    public static bon m18359a() {
        if (f16067a == null) {
            f16067a = new bon();
        }
        return f16067a;
    }

    /* renamed from: b */
    public boolean mo23287b(String str) {
        Iterator<String> it = this.f16068b.iterator();
        while (it.hasNext()) {
            if (it.next().toLowerCase().endsWith(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo23288c(String str) {
        Iterator<String> it = this.f16069c.iterator();
        while (it.hasNext()) {
            if (it.next().toLowerCase().endsWith(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public boolean mo23289d(String str) {
        Iterator<String> it = this.f16070d.iterator();
        while (it.hasNext()) {
            if (it.next().toLowerCase().endsWith(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public boolean mo23290e(String str) {
        Iterator<String> it = this.f16071e.iterator();
        while (it.hasNext()) {
            if (it.next().toLowerCase().endsWith(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo23291f(String str) {
        Iterator<String> it = this.f16073g.iterator();
        while (it.hasNext()) {
            if (it.next().toLowerCase().endsWith(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public boolean mo23292g(String str) {
        Iterator<String> it = this.f16072f.iterator();
        while (it.hasNext()) {
            if (it.next().toLowerCase().endsWith(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public boolean mo23293h(String str) {
        Iterator<String> it = this.f16068b.iterator();
        while (it.hasNext()) {
            if (str.toLowerCase().endsWith(it.next().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public boolean mo23294i(String str) {
        Iterator<String> it = this.f16069c.iterator();
        while (it.hasNext()) {
            if (str.toLowerCase().endsWith(it.next().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    public boolean mo23295j(String str) {
        Iterator<String> it = this.f16070d.iterator();
        while (it.hasNext()) {
            if (str.toLowerCase().endsWith(it.next().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m18360b() {
        if (this.f16068b == null) {
            this.f16068b = new ArrayList<>();
        }
        if (this.f16068b.size() == 0) {
            this.f16068b.add(".mp4");
            this.f16068b.add(".3gp");
            this.f16068b.add(".wmv");
            this.f16068b.add(".avi");
            this.f16068b.add(".rm");
            this.f16068b.add(".rmvb");
            this.f16068b.add(".mkv");
            this.f16068b.add(".flv");
            this.f16068b.add(".mov");
        }
    }

    /* renamed from: c */
    private void m18361c() {
        if (this.f16069c == null) {
            this.f16069c = new ArrayList<>();
        }
        if (this.f16069c.size() == 0) {
            this.f16069c.add(".mpeg");
            this.f16069c.add(".wav");
            this.f16069c.add(".mpeg3");
            this.f16069c.add(".x-mpeg3");
            this.f16069c.add(".x-wav");
            this.f16069c.add(".mp3");
            this.f16069c.add(".mp4a-latm");
            this.f16069c.add(".mp4a");
            this.f16069c.add(".ogg");
            this.f16069c.add(".m4a");
            this.f16069c.add(".ape");
            this.f16069c.add(".amr");
            this.f16069c.add(".wma");
        }
    }

    /* renamed from: d */
    private void m18362d() {
        if (this.f16070d == null) {
            this.f16070d = new ArrayList<>();
        }
        if (this.f16070d.size() == 0) {
            this.f16070d.add(".jpg");
            this.f16070d.add(".jpeg");
            this.f16070d.add(".png");
            this.f16070d.add(".bmp");
            this.f16070d.add(".gif");
        }
    }

    /* renamed from: e */
    private void m18363e() {
        if (this.f16071e != null && this.f16071e.size() == 0) {
            this.f16071e.add(".apk");
        }
    }

    /* renamed from: f */
    private void m18364f() {
        if (this.f16072f == null) {
            this.f16072f = new ArrayList<>();
        }
        if (this.f16072f.size() == 0) {
            this.f16072f.add(".zip");
            this.f16072f.add(".rar");
        }
    }

    private void m18365g() {
        if (this.f16073g == null) {
            this.f16073g = new ArrayList<>();
        }
        if (this.f16073g.size() == 0) {
            this.f16073g.add(".txt");
            this.f16073g.add(".doc");
            this.f16073g.add(".docx");
            this.f16073g.add(".ppt");
            this.f16073g.add(".pps");
            this.f16073g.add(".ppx");
            this.f16073g.add(".pptx");
            this.f16073g.add(".xls");
            this.f16073g.add(".xlsx");
            this.f16073g.add(".chm");
            this.f16073g.add(".pdf");
        }
    }
}
