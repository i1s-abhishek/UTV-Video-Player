package classesdef.subtitle;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* renamed from: ard */
public class ard implements Comparable<ard> {

    /* renamed from: a */
    private int f4706a;

    /* renamed from: b */
    private byte[] f4707b = null;

    /* renamed from: c */
    private int f4708c;

    /* renamed from: d */
    private InputStream f4709d = null;

    /* renamed from: e */
    private String f4710e;

    /* renamed from: f */
    private String f4711f;

    /* renamed from: a */
    public Reader mo10010a() {
        InputStream inputStream = this.f4709d;
        if (inputStream == null) {
            inputStream = new ByteArrayInputStream(this.f4707b, 0, this.f4708c);
        }
        try {
            inputStream.reset();
            return new InputStreamReader(inputStream, mo10011b());
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public String mo10011b() {
        return this.f4710e;
    }

    /* renamed from: a */
    public int compareTo(ard ard) {
        if (this.f4706a > ard.f4706a) {
            return 1;
        }
        return this.f4706a < ard.f4706a ? -1 : 0;
    }

    ard(arc arc, arj arj, int i) {
        this.f4706a = i;
        if (arc.f4701h == null) {
            this.f4707b = arc.f4699f;
            this.f4708c = arc.f4700g;
        }
        this.f4709d = arc.f4701h;
        this.f4710e = arj.mo10015a();
        this.f4711f = arj.mo10019b();
    }

    ard(arc arc, arj arj, int i, String str, String str2) {
        this.f4706a = i;
        if (arc.f4701h == null) {
            this.f4707b = arc.f4699f;
            this.f4708c = arc.f4700g;
        }
        this.f4709d = arc.f4701h;
        this.f4710e = str;
        this.f4711f = str2;
    }
}
