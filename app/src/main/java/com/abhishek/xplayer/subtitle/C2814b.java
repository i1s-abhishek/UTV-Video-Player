package com.abhishek.xplayer.subtitle;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.abhishek.xplayer.application.MyApplication;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import classesdef.inplayer.awt;
import classesdef.inplayer.axc;
import classesdef.xdplayer.axy;
import de.timroes.axmlrpc.XMLRPCClient;
import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.subtitle.b */
class C2814b {

    /* renamed from: a */
    private static final HashMap<String, String> f11193a = new HashMap<>();

    /* renamed from: b */
    private final String f11194b = "http://api.opensubtitles.org/xml-rpc";

    /* renamed from: c */
    private final String f11195c = "xplayerforandroid";

    /* renamed from: d */
    private HashMap<String, Object> f11196d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public XMLRPCClient f11197e;

    /* renamed from: f */
    private String f11198f = null;

    /* renamed from: g */
    private volatile boolean f11199g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C2820b f11200h;

    /* renamed from: com.inshot.xplayer.subtitle.b$b */
    interface C2820b {
        /* renamed from: a */
        void mo18184a(int i);

        /* renamed from: a */
        void mo18185a(List<C2821c> list);
    }

    C2814b() {
    }

    static {
        f11193a.put("limit", Integer.toString(50));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18207a(final C2819a aVar, C2820b bVar) {
        this.f11199g = false;
        this.f11200h = bVar;
        final ArrayList arrayList = new ArrayList(aVar.f11213d);
        new Thread(new Runnable() {
            public void run() {
                if (C2814b.this.m12775b()) {
                    C2814b.this.m12770a(aVar, (List<String>) arrayList);
                }
            }
        }).start();
    }

    /* renamed from: a */
    public void mo18206a() {
        this.f11199g = true;
        this.f11200h = null;
        m12777c();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m12775b() {
        try {
            this.f11197e = new XMLRPCClient(new URL("http://api.opensubtitles.org/xml-rpc"));
            this.f11196d = (HashMap) this.f11197e.call("LogIn", "", "", "eng", "xplayerforandroid");
            this.f11198f = (String) this.f11196d.get("token");
            this.f11196d = null;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            m12769a((int) R.string.service_unavailable);
            this.f11199g = true;
            return false;
        }
    }

    /* renamed from: a */
    private void m12769a(final int i) {
        if (this.f11200h != null) {
            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                public void run() {
                    if (C2814b.this.f11200h != null) {
                        C2814b.this.f11200h.mo18184a(i);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    private void m12777c() {
        if (this.f11198f != null /*&& this.f11197e != null*/) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                final String str = this.f11198f;
                new Thread() {
                    public void run() {
                        XMLRPCClient c = C2814b.this.f11197e;
                        if (c != null) {
                            try {
                                c.call("LogOut", str);
                            } catch (Exception e) {
                                Log.w("subtitles", "XMLRPCException", e);
                            }
                        }
                    }
                }.start();
            } else {
                try {
                    this.f11197e.call("LogOut", this.f11198f);
                } catch (Exception e) {
                    Log.w("subtitles", "XMLRPCException", e);
                }
            }
            this.f11198f = null;
            this.f11196d = null;
        }
    }

    /* JADX WARNING: type inference failed for: r15v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r15v4 */
    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12770a(C2819a aVar, List<String> list) {
        int r15;
        int i;
        Object[] objArr;
        int i2;
        C2819a aVar2 = aVar;
        List<String> list2 = list;
        final ArrayList arrayList = new ArrayList();
        String b = C2822c.m12791b(aVar.f11210a, aVar.f11211b);
        ArrayList<HashMap<String, String>> a = m12768a(aVar2, list2, true);
        int i3 = -1;
        if (!a.isEmpty()) {
            try {
               this.f11196d = (HashMap) this.f11197e.call("SearchSubtitles", this.f11198f, a, f11193a);
                if (!this.f11199g && (this.f11196d.get("data") instanceof Object[])) {
                    Object[] objArr2 = (Object[]) this.f11196d.get("data");
                    if (objArr2.length > 0) {
                        int length = objArr2.length;
                        int i4 = 0;
                        while (i4 < length) {
                            Object obj = objArr2[i4];
                            if (this.f11199g) {
                                break;
                            }
                            HashMap hashMap = (HashMap) obj;
                            String str = (String) hashMap.get("SubFormat");
                            String str2 = (String) hashMap.get("LanguageName");
                            String str3 = (String) hashMap.get("SubDownloadLink");
                            String str4 = (String) hashMap.get("SubFileName");
                            String str5 = (String) hashMap.get("SubSize");
                            if (!C2822c.m12789a(str)) {
                                i2 = i4;
                                i = length;
                                objArr = objArr2;
                            } else {
                                int a2 = awt.m7195a(str5, i3);
                                i2 = i4;
                                String str6 = str4;
                                objArr = objArr2;
                                i = length;
                                arrayList.add(new C2821c(str6, str3, a2, str2, b + "." + str));
                            }
                            i4 = i2 + 1;
                            objArr2 = objArr;
                            length = i;
                            i3 = -1;
                        }
                    }
                }
                r15 = 0;
                a.clear();
            } catch (Exception unused) {
                this.f11199g = true;
                m12769a((int) R.string.service_unavailable);
                return;
            }
        } else {
            r15 = 0;
        }
        boolean v= r15==1?true:false;
        if (!this.f11199g && aVar2 != null) {
            ArrayList<HashMap<String, String>> a3 = m12768a(aVar2, list2, (boolean) v);
            if (!a3.isEmpty()) {
                try {
                    XMLRPCClient bbm = this.f11197e;
                    Object[] objArr3 = new Object[3];
                    objArr3[r15] = this.f11198f;
                    objArr3[1] = a3;
                    objArr3[2] = f11193a;
                    this.f11196d = (HashMap) bbm.call("SearchSubtitles", objArr3);
                    if (this.f11196d.get("data") instanceof Object[]) {
                        Object[] objArr4 = (Object[]) this.f11196d.get("data");
                        if (objArr4.length > 0) {
                            int length2 = objArr4.length;
                            for (int i5 = r15; i5 < length2; i5++) {
                                Object obj2 = objArr4[i5];
                                if (this.f11199g) {
                                    break;
                                }
                                HashMap hashMap2 = (HashMap) obj2;
                                String str7 = (String) hashMap2.get("SubFormat");
                                String str8 = (String) hashMap2.get("LanguageName");
                                String str9 = (String) hashMap2.get("SubDownloadLink");
                                String str10 = (String) hashMap2.get("SubFileName");
                                String str11 = (String) hashMap2.get("SubSize");
                                if (C2822c.m12789a(str7)) {
                                    int a4 = awt.m7195a(str11, -1);
                                    arrayList.add(new C2821c(str10, str9, a4, str8, b + "." + str7));
                                }
                            }
                        }
                    }
                } catch (Exception unused2) {
                    this.f11199g = true;
                    m12769a((int) R.string.service_unavailable);
                    return;
                }
            }
        }
        if (this.f11200h != null) {
            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                public void run() {
                    if (C2814b.this.f11200h != null) {
                        C2814b.this.f11200h.mo18185a((List<C2821c>) arrayList);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061 A[SYNTHETIC, Splitter:B:29:0x0061] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo18208aa(C2821c r8, String r9) {
        /*
            r7 = this;
            java.lang.String r0 = r7.f11198f
            r1 = 0
            if (r0 == 0) goto L_0x00a9
            if (r8 != 0) goto L_0x0009
            goto L_0x00a9
        L_0x0009:
            java.lang.String r0 = r8.f11218e
            r2 = 0
            if (r0 == 0) goto L_0x0024
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x001d }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x001d }
            java.lang.String r0 = m12767a((java.lang.String) r0)     // Catch:{ IOException -> 0x001d }
            r4.<init>(r0)     // Catch:{ IOException -> 0x001d }
            r3.<init>(r4)     // Catch:{ IOException -> 0x001d }
            goto L_0x0025
        L_0x001d:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r2
            r3 = r0
            goto L_0x0025
        L_0x0024:
            r3 = r2
        L_0x0025:
            if (r0 != 0) goto L_0x005d
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0059 }
            r4.<init>(r9)     // Catch:{ IOException -> 0x0059 }
            boolean r9 = r4.exists()     // Catch:{ IOException -> 0x0059 }
            if (r9 != 0) goto L_0x0035
            r4.mkdirs()     // Catch:{ IOException -> 0x0059 }
        L_0x0035:
            java.io.File r9 = new java.io.File     // Catch:{ IOException -> 0x0059 }
            java.lang.String r5 = r8.f11214a     // Catch:{ IOException -> 0x0059 }
            r9.<init>(r4, r5)     // Catch:{ IOException -> 0x0059 }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x0059 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0054 }
            java.lang.String r5 = m12767a((java.lang.String) r9)     // Catch:{ IOException -> 0x0054 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0051 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x0051 }
            r3 = r0
            r0 = r5
            goto L_0x005d
        L_0x0051:
            r9 = move-exception
            r0 = r5
            goto L_0x005a
        L_0x0054:
            r0 = move-exception
            r6 = r0
            r0 = r9
            r9 = r6
            goto L_0x005a
        L_0x0059:
            r9 = move-exception
        L_0x005a:
            r9.printStackTrace()
        L_0x005d:
            r8.f11218e = r0
            if (r3 == 0) goto L_0x00a2
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x0096 }
            java.lang.String r8 = r8.f11215b     // Catch:{ Exception -> 0x0096 }
            r9.<init>(r8)     // Catch:{ Exception -> 0x0096 }
            java.net.URLConnection r8 = r9.openConnection()     // Catch:{ Exception -> 0x0096 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x0096 }
            java.util.zip.GZIPInputStream r9 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x0096 }
            java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x0096 }
            r9.<init>(r8)     // Catch:{ Exception -> 0x0096 }
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r8]     // Catch:{ Exception -> 0x0091, all -> 0x008e }
        L_0x007b:
            int r0 = r9.read(r8)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r2 = -1
            if (r0 == r2) goto L_0x0086
            r3.write(r8, r1, r0)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            goto L_0x007b
        L_0x0086:
            r8 = 1
            p000.axy.m7471a((java.io.Closeable) r3)
            p000.axy.m7471a((java.io.Closeable) r9)
            return r8
        L_0x008e:
            r8 = move-exception
            r2 = r9
            goto L_0x009b
        L_0x0091:
            r8 = move-exception
            r2 = r9
            goto L_0x0097
        L_0x0094:
            r8 = move-exception
            goto L_0x009b
        L_0x0096:
            r8 = move-exception
        L_0x0097:
            r8.printStackTrace()     // Catch:{ all -> 0x0094 }
            goto L_0x00a2
        L_0x009b:
            p000.axy.m7471a((java.io.Closeable) r3)
            p000.axy.m7471a((java.io.Closeable) r2)
            throw r8
        L_0x00a2:
            p000.axy.m7471a((java.io.Closeable) r3)
            p000.axy.m7471a((java.io.Closeable) r2)
            return r1
        L_0x00a9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.subtitle.C2814b.mo18208a(com.inshot.xplayer.subtitle.b$c, java.lang.String):boolean");
    }
    public boolean mo18208a(C2821c cVar, String str) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Exception e2;
        IOException e3;
        if (this.f11198f == null || cVar == null) {
            return false;
        }
        String str2 = cVar.f11218e;
        GZIPInputStream gZIPInputStream = null;
        if (str2 != null) {
            try {
                str2 = m12767a(str2);
                fileOutputStream = new FileOutputStream(new File(str2));
            } catch (IOException e4) {
                e4.printStackTrace();
                str2 = null;
                fileOutputStream = null;
            }
        } else {
            fileOutputStream = null;
        }
        if (str2 == null) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = new File(file, cVar.f11214a).getAbsolutePath();
            String a2 = m12767a(absolutePath);
            try {
                fileOutputStream = new FileOutputStream(new File(a2));
                str2 = a2;
            } catch (IOException e5) {
                e3 = e5;
                str2 = a2;
                e3.printStackTrace();
                cVar.f11218e = str2;
                if (fileOutputStream != null) {
                }
                axy.m7471a(fileOutputStream);
                axy.m7471a(gZIPInputStream);
                return false;
            }
        }
        cVar.f11218e = str2;
        if (fileOutputStream != null) {
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(((HttpURLConnection) new URL(cVar.f11215b).openConnection()).getInputStream());
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream2.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            axy.m7471a(fileOutputStream);
                            axy.m7471a(gZIPInputStream2);
                            return true;
                        }
                    }
                } catch (Exception e8) {
                    e2 = e8;
                    gZIPInputStream = gZIPInputStream2;
                    try {
                        e2.printStackTrace();
                        axy.m7471a(fileOutputStream);
                        axy.m7471a(gZIPInputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    gZIPInputStream = gZIPInputStream2;
                    axy.m7471a(fileOutputStream);
                    axy.m7471a(gZIPInputStream);
                   // throw th;
                }
            } catch (Exception e9) {
                e2 = e9;
                e2.printStackTrace();
                axy.m7471a(fileOutputStream);
                axy.m7471a(gZIPInputStream);
                return false;
            }
        }
        axy.m7471a(fileOutputStream);
        axy.m7471a(gZIPInputStream);
        return false;
    }

    /* renamed from: a */
    private static String m12767a(String str) {
        String parent;
        String str2;
        File file;
        int i;
        File file2 = new File(str);
        if (!file2.exists() || (parent = file2.getParent()) == null) {
            return str;
        }
        String name = file2.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf <= 0 || (i = lastIndexOf + 1) >= name.length()) {
            str2 = "";
        } else {
            String substring = name.substring(0, lastIndexOf);
            str2 = name.substring(i);
            name = substring;
        }
        int i2 = 0;
        do {
            i2++;
            file = new File(parent, String.format(Locale.ENGLISH, "%s_%d.%s", new Object[]{name, Integer.valueOf(i2), str2}));
        } while (file.exists());
        return file.getAbsolutePath();
    }

    /* renamed from: a */
    private ArrayList<HashMap<String, String>> m12768a(C2819a aVar, List<String> list, boolean z) {
        String str;
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        if (this.f11199g) {
            return arrayList;
        }
        long j = 0;
        String str2 = null;
        if (z) {
            File file = new File(aVar.f11210a);
            str = axc.m7298a(file);
            j = file.length();
            if (str == null) {
                return arrayList;
            }
        } else {
            str2 = aVar.f11212c;
            str = null;
        }
        for (String next : list) {
            if (this.f11199g) {
                break;
            }
            String b = m12774b(next);
            HashMap hashMap = new HashMap();
            hashMap.put("sublanguageid", b);
            if (z) {
                hashMap.put("moviehash", str);
                hashMap.put("moviebytesize", String.valueOf(j));
            } else if (!TextUtils.isEmpty(str2)) {
                hashMap.put("query", str2);
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    /* renamed from: b */
    private static String m12774b(String str) {
        String iSO3Language = new Locale(str).getISO3Language();
        if (iSO3Language.equals("system")) {
            return m12774b(Locale.getDefault().getISO3Language());
        }
        if (iSO3Language.equals("fra")) {
            return "fre";
        }
        if (iSO3Language.equals("deu")) {
            return "ger";
        }
        if (iSO3Language.equals("zho")) {
            return "chi";
        }
        if (iSO3Language.equals("ces")) {
            return "cze";
        }
        if (iSO3Language.equals("fas")) {
            return "per";
        }
        if (iSO3Language.equals("nld")) {
            return "dut";
        }
        if (iSO3Language.equals("ron")) {
            return "rum";
        }
        return iSO3Language.equals("slk") ? "slo" : iSO3Language;
    }

    /* renamed from: com.inshot.xplayer.subtitle.b$a */
    static class C2819a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f11210a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final String f11211b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final String f11212c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Set<String> f11213d;

        C2819a(String str, String str2, String str3, Set<String> set) {
            this.f11210a = str;
            this.f11213d = set;
            this.f11211b = str2;
            this.f11212c = str3;
        }
    }

    /* renamed from: com.inshot.xplayer.subtitle.b$c */
    class C2821c {

        /* renamed from: a */
        public final String f11214a;

        /* renamed from: b */
        public final String f11215b;

        /* renamed from: c */
        public final int f11216c;

        /* renamed from: d */
        public final String f11217d;

        /* renamed from: e */
        public String f11218e;

        private C2821c(String str, String str2, int i, String str3, String str4) {
            this.f11214a = str;
            this.f11215b = str2;
            this.f11216c = i;
            this.f11218e = str4;
            this.f11217d = str3;
        }
    }
}
