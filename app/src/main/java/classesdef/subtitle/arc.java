package classesdef.subtitle;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/* renamed from: arc */
public class arc {

    /* renamed from: k */
    private static final List<C1095a> f4693k;

    /* renamed from: a */
    byte[] f4694a = new byte[8000];

    /* renamed from: b */
    int f4695b;

    /* renamed from: c */
    short[] f4696c = new short[256];

    /* renamed from: d */
    boolean f4697d = false;

    /* renamed from: e */
    String f4698e;

    /* renamed from: f */
    byte[] f4699f;

    /* renamed from: g */
    int f4700g;

    /* renamed from: h */
    InputStream f4701h;

    /* renamed from: i */
    private boolean f4702i = false;

    /* renamed from: j */
    private boolean[] f4703j;

    /* renamed from: a */
    public arc mo10005a(InputStream inputStream) throws IOException {
        this.f4701h = inputStream;
        int i = 8000;
        this.f4701h.mark(8000);
        this.f4699f = new byte[8000];
        this.f4700g = 0;
        while (i > 0) {
            int read = this.f4701h.read(this.f4699f, this.f4700g, i);
            if (read <= 0) {
                break;
            }
            this.f4700g += read;
            i -= read;
        }
        this.f4701h.reset();
        return this;
    }

    /* renamed from: a */
    public ard mo10006a() {
        ard[] b = mo10008b();
        if (b == null || b.length == 0) {
            return null;
        }
        return b[0];
    }

    /* renamed from: b */
    public ard[] mo10008b() {
        ard a;
        ArrayList arrayList = new ArrayList();
        m5438c();
        for (int i = 0; i < f4693k.size(); i++) {
            C1095a aVar = f4693k.get(i);
            if ((this.f4703j != null ? this.f4703j[i] : aVar.f4705b) && (a = aVar.f4704a.mo10014a(this)) != null) {
                arrayList.add(a);
            }
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        return (ard[]) arrayList.toArray(new ard[arrayList.size()]);
    }

    /* renamed from: a */
    public Reader mo10007a(InputStream inputStream, String str) {
        this.f4698e = str;
        try {
            mo10005a(inputStream);
            ard a = mo10006a();
            if (a == null) {
                return null;
            }
            return a.mo10010a();
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: c */
    private void m5438c() {
        int i;
        int i2;
        if (this.f4702i) {
            int i3 = 0;
            i2 = 0;
            i = 0;
            boolean z = false;
            for (int i4 = 0; i4 < this.f4700g && i3 < this.f4694a.length; i4++) {
                byte b = this.f4699f[i4];
                if (b == 60) {
                    if (z) {
                        i++;
                    }
                    i2++;
                    z = true;
                }
                if (!z) {
                    this.f4694a[i3] = b;
                    i3++;
                }
                if (b == 62) {
                    z = false;
                }
            }
            this.f4695b = i3;
        } else {
            i2 = 0;
            i = 0;
        }
        if (i2 < 5 || i2 / 5 < i || (this.f4695b < 100 && this.f4700g > 600)) {
            int i5 = this.f4700g;
            if (i5 > 8000) {
                i5 = 8000;
            }
            int i6 = 0;
            while (i6 < i5) {
                this.f4694a[i6] = this.f4699f[i6];
                i6++;
            }
            this.f4695b = i6;
        }
        Arrays.fill(this.f4696c, (short) 0);
        for (int i7 = 0; i7 < this.f4695b; i7++) {
            int b2 =  (this.f4694a[i7] & 255);
            short[] sArr = this.f4696c;
            sArr[b2] = (short) (sArr[b2] + 1);
        }
        this.f4697d = false;
        for (int i8 = 128; i8 <= 159; i8++) {
            if (this.f4696c[i8] != 0) {
                this.f4697d = true;
                return;
            }
        }
    }

    /* renamed from: arc$a */
    private static class C1095a {

        /* renamed from: a */
        arj f4704a;

        /* renamed from: b */
        boolean f4705b;

        C1095a(arj arj, boolean z) {
            this.f4704a = arj;
            this.f4705b = z;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1095a(new arf(), true));
        arrayList.add(new C1095a(new arg.C1099a(), true));
        arrayList.add(new C1095a(new arg.C1100b(), true));
        arrayList.add(new C1095a(new arg.C1102d(), true));
        arrayList.add(new C1095a(new arg.C1103e(), true));
        arrayList.add(new C1095a(new arh.C1109d(), true));
        arrayList.add(new C1095a(new are.C1097b(), true));
        arrayList.add(new C1095a(new are.C1096a(), true));
        arrayList.add(new C1095a(new are.C1098c(), true));
        arrayList.add(new C1095a(new arh.C1108c(), true));
        arrayList.add(new C1095a(new arh.C1105b.C1106a(), true));
        arrayList.add(new C1095a(new arh.C1105b.C1107b(), true));
        arrayList.add(new C1095a(new arh.C1104a(), true));
        arrayList.add(new C1095a(new ari.C1111a(), true));
        arrayList.add(new C1095a(new ari.C1112b(), true));
        arrayList.add(new C1095a(new ari.C1114d(), true));
        arrayList.add(new C1095a(new ari.C1116f(), true));
        arrayList.add(new C1095a(new ari.C1118h(), true));
        arrayList.add(new C1095a(new ari.C1120j(), true));
        arrayList.add(new C1095a(new ari.C1121k(), true));
        arrayList.add(new C1095a(new ari.C1131u(), true));
        arrayList.add(new C1095a(new ari.C1132v(), true));
        arrayList.add(new C1095a(new ari.C1130t(), true));
        arrayList.add(new C1095a(new ari.C1123m(), true));
        arrayList.add(new C1095a(new ari.C1129s(), false));
        arrayList.add(new C1095a(new ari.C1128r(), false));
        arrayList.add(new C1095a(new ari.C1126p(), false));
        arrayList.add(new C1095a(new ari.C1125o(), false));
        f4693k = Collections.unmodifiableList(arrayList);
    }
}
