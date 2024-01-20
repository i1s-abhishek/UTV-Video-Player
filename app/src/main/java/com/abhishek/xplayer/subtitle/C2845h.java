package com.abhishek.xplayer.subtitle;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* renamed from: com.inshot.xplayer.subtitle.h */
public class C2845h {

    /* renamed from: a */
    private static Set<String> f11304a;

    /* renamed from: b */
    private static Pattern f11305b = Pattern.compile("(\\{.*?\\})");

    /* renamed from: a */
    private static void m12866a() {
        if (f11304a == null) {
            f11304a = new HashSet();
            f11304a.add("text");
            f11304a.add("ssa");
            f11304a.add("srt");
            f11304a.add("realtext");
            f11304a.add("subrip");
            f11304a.add("ass");
            f11304a.add("hdmv_pgs_subtitle");
            f11304a.add("dvd_subtitle");
            f11304a.add("dvb_subtitle");
            f11304a.add("mov_text");
        }
    }

    /* renamed from: a */
    static boolean m12867a(String str) {
        m12866a();
        return str != null && f11304a.contains(str.toLowerCase(Locale.ENGLISH));
    }

    /* renamed from: b */
    public static String m12868b(String str) {
        if (str != null) {
            return f11305b.matcher(str).replaceAll("");
        }
        return null;
    }
}
