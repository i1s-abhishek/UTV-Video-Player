package classesdef.inplayer;

import com.abhishek.xplayer.application.MyApplication;

import java.util.Arrays;

/* renamed from: awe */
public final class awe {

    /* renamed from: a */
    private static int f6062a = 0;

    /* renamed from: b */
    private static int f6063b = 0;

    /* renamed from: c */
    private static int f6064c = -1;

    /* renamed from: d */
    private static int f6065d = -1;

    /* renamed from: e */
    private static boolean f6066e;

    /* renamed from: f */
    private static boolean f6067f;

    /* renamed from: g */
    private static int[] f6068g;

    /* renamed from: h */
    private static int[] f6069h;

    /* renamed from: i */
    private static int[] f6070i;

    /* renamed from: j */
    private static int[] f6071j;

    /* renamed from: k */
    private static awa f6072k;

    /* renamed from: l */
    private static int f6073l;

    /* renamed from: m */
    private static String[] f6074m;

    /* renamed from: a */
    public static void m7112a(int i, int[] iArr) {
        if (f6064c == -1) {
            f6071j = iArr;
        }
        SharedPrefrence.m7391a(MyApplication.getApplicationContext_(), i, iArr);
    }

    /* renamed from: a */
    public static void m7110a(int i) {
        int[] c = SharedPrefrence.m7396c(MyApplication.getApplicationContext_(), i);
        if (c != null && c.length != 0) {
            if (i == -1) {
                f6071j = c;
            }
            f6068g = c;
            f6064c = i;
            f6065d = i;
        }
    }

    /* renamed from: b */
    public static void m7115b(int i) {
        SharedPrefrence.m7397d(MyApplication.getApplicationContext_(), i);
    }

    /* renamed from: a */
    public static int[] m7114a() {
        return f6071j;
    }

    /* renamed from: b */
    public static boolean m7116b() {
        return f6072k != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073 A[Catch:{ Throwable -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008e A[Catch:{ Throwable -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b0 A[Catch:{ Throwable -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b7 A[Catch:{ Throwable -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ce A[Catch:{ Throwable -> 0x00f5 }, LOOP:1: B:49:0x00ce->B:51:0x00d2, LOOP_START, PHI: r1 
      PHI: (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:48:0x00cc, B:51:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e9 A[Catch:{ Throwable -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f1 A[Catch:{ Throwable -> 0x00f5 }] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m7118cc(int r5) {
        /*
            awa r0 = f6072k
            if (r0 == 0) goto L_0x0007
            m7117c()
        L_0x0007:
            awa r0 = new awa     // Catch:{ Throwable -> 0x00f5 }
            r0.<init>(r5)     // Catch:{ Throwable -> 0x00f5 }
            f6072k = r0     // Catch:{ Throwable -> 0x00f5 }
            awa r5 = f6072k     // Catch:{ Throwable -> 0x00f5 }
            short r5 = r5.mo10844b()     // Catch:{ Throwable -> 0x00f5 }
            int[] r0 = f6068g     // Catch:{ Throwable -> 0x00f5 }
            if (r0 != 0) goto L_0x001d
            int[] r0 = new int[r5]     // Catch:{ Throwable -> 0x00f5 }
            f6068g = r0     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x002a
        L_0x001d:
            int[] r0 = f6068g     // Catch:{ Throwable -> 0x00f5 }
            int r0 = r0.length     // Catch:{ Throwable -> 0x00f5 }
            if (r0 == r5) goto L_0x002a
            int[] r0 = f6068g     // Catch:{ Throwable -> 0x00f5 }
            int[] r0 = java.util.Arrays.copyOf(r0, r5)     // Catch:{ Throwable -> 0x00f5 }
            f6068g = r0     // Catch:{ Throwable -> 0x00f5 }
        L_0x002a:
            int[] r0 = f6069h     // Catch:{ Throwable -> 0x00f5 }
            if (r0 != 0) goto L_0x0033
            int[] r0 = new int[r5]     // Catch:{ Throwable -> 0x00f5 }
            f6069h = r0     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x0040
        L_0x0033:
            int[] r0 = f6069h     // Catch:{ Throwable -> 0x00f5 }
            int r0 = r0.length     // Catch:{ Throwable -> 0x00f5 }
            if (r0 == r5) goto L_0x0040
            int[] r0 = f6069h     // Catch:{ Throwable -> 0x00f5 }
            int[] r0 = java.util.Arrays.copyOf(r0, r5)     // Catch:{ Throwable -> 0x00f5 }
            f6069h = r0     // Catch:{ Throwable -> 0x00f5 }
        L_0x0040:
            int[] r0 = f6071j     // Catch:{ Throwable -> 0x00f5 }
            if (r0 != 0) goto L_0x0049
            int[] r0 = new int[r5]     // Catch:{ Throwable -> 0x00f5 }
            f6071j = r0     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x0056
        L_0x0049:
            int[] r0 = f6071j     // Catch:{ Throwable -> 0x00f5 }
            int r0 = r0.length     // Catch:{ Throwable -> 0x00f5 }
            if (r0 == r5) goto L_0x0056
            int[] r0 = f6071j     // Catch:{ Throwable -> 0x00f5 }
            int[] r0 = java.util.Arrays.copyOf(r0, r5)     // Catch:{ Throwable -> 0x00f5 }
            f6071j = r0     // Catch:{ Throwable -> 0x00f5 }
        L_0x0056:
            int[] r0 = f6070i     // Catch:{ Throwable -> 0x00f5 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0062
            int[] r0 = new int[r5]     // Catch:{ Throwable -> 0x00f5 }
            f6070i = r0     // Catch:{ Throwable -> 0x00f5 }
        L_0x0060:
            r0 = 1
            goto L_0x0071
        L_0x0062:
            int[] r0 = f6070i     // Catch:{ Throwable -> 0x00f5 }
            int r0 = r0.length     // Catch:{ Throwable -> 0x00f5 }
            if (r0 == r5) goto L_0x0070
            int[] r0 = f6070i     // Catch:{ Throwable -> 0x00f5 }
            int[] r0 = java.util.Arrays.copyOf(r0, r5)     // Catch:{ Throwable -> 0x00f5 }
            f6070i = r0     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x0060
        L_0x0070:
            r0 = 0
        L_0x0071:
            if (r0 == 0) goto L_0x0086
            int r5 = r5 - r2
        L_0x0074:
            if (r5 < 0) goto L_0x0086
            int[] r0 = f6070i     // Catch:{ Throwable -> 0x00f5 }
            awa r3 = f6072k     // Catch:{ Throwable -> 0x00f5 }
            short r4 = (short) r5     // Catch:{ Throwable -> 0x00f5 }
            int r3 = r3.mo10836a((short) r4)     // Catch:{ Throwable -> 0x00f5 }
            int r3 = r3 / 1000
            r0[r5] = r3     // Catch:{ Throwable -> 0x00f5 }
            int r5 = r5 + -1
            goto L_0x0074
        L_0x0086:
            awa r5 = f6072k     // Catch:{ Throwable -> 0x00f5 }
            short[] r5 = r5.mo10841a()     // Catch:{ Throwable -> 0x00f5 }
            if (r5 == 0) goto L_0x009c
            int r0 = r5.length     // Catch:{ Throwable -> 0x00f5 }
            r3 = 2
            if (r0 == r3) goto L_0x0093
            goto L_0x009c
        L_0x0093:
            short r0 = r5[r1]     // Catch:{ Throwable -> 0x00f5 }
            f6062a = r0     // Catch:{ Throwable -> 0x00f5 }
            short r5 = r5[r2]     // Catch:{ Throwable -> 0x00f5 }
            f6063b = r5     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x00a4
        L_0x009c:
            r5 = -1500(0xfffffffffffffa24, float:NaN)
            f6062a = r5     // Catch:{ Throwable -> 0x00f5 }
            r5 = 1500(0x5dc, float:2.102E-42)
            f6063b = r5     // Catch:{ Throwable -> 0x00f5 }
        L_0x00a4:
            awa r5 = f6072k     // Catch:{ Throwable -> 0x00f5 }
            int r5 = r5.mo10847e()     // Catch:{ Throwable -> 0x00f5 }
            f6073l = r5     // Catch:{ Throwable -> 0x00f5 }
            java.lang.String[] r5 = f6074m     // Catch:{ Throwable -> 0x00f5 }
            if (r5 != 0) goto L_0x00b7
            int r5 = f6073l     // Catch:{ Throwable -> 0x00f5 }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Throwable -> 0x00f5 }
            f6074m = r5     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x00cc
        L_0x00b7:
            java.lang.String[] r5 = f6074m     // Catch:{ Throwable -> 0x00f5 }
            int r5 = r5.length     // Catch:{ Throwable -> 0x00f5 }
            int r0 = f6073l     // Catch:{ Throwable -> 0x00f5 }
            if (r5 == r0) goto L_0x00cb
            java.lang.String[] r5 = f6074m     // Catch:{ Throwable -> 0x00f5 }
            int r0 = f6073l     // Catch:{ Throwable -> 0x00f5 }
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r0)     // Catch:{ Throwable -> 0x00f5 }
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ Throwable -> 0x00f5 }
            f6074m = r5     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x00cc
        L_0x00cb:
            r2 = 0
        L_0x00cc:
            if (r2 == 0) goto L_0x00df
        L_0x00ce:
            int r5 = f6073l     // Catch:{ Throwable -> 0x00f5 }
            if (r1 >= r5) goto L_0x00df
            java.lang.String[] r5 = f6074m     // Catch:{ Throwable -> 0x00f5 }
            awa r0 = f6072k     // Catch:{ Throwable -> 0x00f5 }
            java.lang.String r0 = r0.mo10843b((int) r1)     // Catch:{ Throwable -> 0x00f5 }
            r5[r1] = r0     // Catch:{ Throwable -> 0x00f5 }
            int r1 = r1 + 1
            goto L_0x00ce
        L_0x00df:
            int r5 = f6064c     // Catch:{ Throwable -> 0x00f5 }
            if (r5 < 0) goto L_0x00f1
            int r5 = f6064c     // Catch:{ Throwable -> 0x00f5 }
            int r0 = f6073l     // Catch:{ Throwable -> 0x00f5 }
            if (r5 >= r0) goto L_0x00f1
            awa r5 = f6072k     // Catch:{ Throwable -> 0x00f5 }
            int r0 = f6064c     // Catch:{ Throwable -> 0x00f5 }
            r5.mo10838a((int) r0)     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x00ff
        L_0x00f1:
            m7128h()     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x00ff
        L_0x00f5:
            m7117c()
            r5 = 0
            f6068g = r5
            f6070i = r5
            f6074m = r5
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.awe.m7118c(int):void");
    }
    public static void m7118cd(int i2) {
        boolean z;
        short[] a2;
        if (f6072k != null) {
            m7117c();
        }
        try {
            f6072k = new awa(i2);
            int b2 = f6072k.mo10844b();
            if (f6068g == null) {
                f6068g = new int[b2];
            } else if (f6068g.length != b2) {
                f6068g = Arrays.copyOf(f6068g, b2);
            }
            if (f6069h == null) {
                f6069h = new int[b2];
            } else if (f6069h.length != b2) {
                f6069h = Arrays.copyOf(f6069h, b2);
            }
            if (f6071j == null) {
                f6071j = new int[b2];
            } else if (f6071j.length != b2) {
                f6071j = Arrays.copyOf(f6071j, b2);
            }
            boolean z2 = true;
            if (f6070i == null) {
                f6070i = new int[b2];
            } else if (f6070i.length != b2) {
                f6070i = Arrays.copyOf(f6070i, b2);
            } else {
                z = false;
                if (z) {
                    for (int i3 = b2 - 1; i3 >= 0; i3--) {
                        f6070i[i3] = f6072k.mo10836a((short) i3) / 1000;
                    }
                }
                a2 = f6072k.mo10841a();
                if (a2 != null) {
                    if (a2.length == 2) {
                        f6062a = a2[0];
                        f6063b = a2[1];
                        f6073l = f6072k.mo10847e();
                        if (f6074m == null) {
                            f6074m = new String[f6073l];
                        } else if (f6074m.length != f6073l) {
                            f6074m = (String[]) Arrays.copyOf(f6074m, f6073l);
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            for (int i4 = 0; i4 < f6073l; i4++) {
                                f6074m[i4] = f6072k.mo10843b(i4);
                            }
                        }
                        if (f6064c >= 0 || f6064c >= f6073l) {
                            m7128h();
                        } else {
                            f6072k.mo10838a(f6064c);
                            return;
                        }
                    }
                }
                f6062a = -1500;
                f6063b = 1500;
                f6073l = f6072k.mo10847e();
                if (f6074m == null) {
                }
                if (z2) {
                }
                if (f6064c >= 0) {
                }
                m7128h();
            }
            z = true;
            if (z) {
            }
            a2 = f6072k.mo10841a();
            if (a2 != null) {
            }
            f6062a = -1500;
            f6063b = 1500;
            f6073l = f6072k.mo10847e();
            if (f6074m == null) {
            }
            if (z2) {
            }
            if (f6064c >= 0) {
            }
            m7128h();
        } catch (Throwable unused) {
            m7117c();
            f6068g = null;
            f6070i = null;
            f6074m = null;
        }
    }
    public static void m7118c(int i) {
        if (awe.f6072k != null) {
            m7117c();
        }
        try {
            awe.f6072k = new awa(i);
            final short b = awe.f6072k.mo10844b();
            if (awe.f6068g == null) {
                awe.f6068g = new int[b];
            }
            else if (awe.f6068g.length != b) {
                awe.f6068g = Arrays.copyOf(awe.f6068g, b);
            }
            if (awe.f6069h == null) {
                awe.f6069h = new int[b];
            }
            else if (awe.f6069h.length != b) {
                awe.f6069h = Arrays.copyOf(awe.f6069h, b);
            }
            if (awe.f6071j == null) {
                awe.f6071j = new int[b];
            }
            else if (awe.f6071j.length != b) {
                awe.f6071j = Arrays.copyOf(awe.f6071j, b);
            }
            final int[] j = awe.f6070i;
            final int n = 0;
            final int n2 = 1;
            Label_0175: {
                if (j == null) {
                    awe.f6070i = new int[b];
                }
                else {
                    if (awe.f6070i.length == b) {
                        i = 0;
                        break Label_0175;
                    }
                    awe.f6070i = Arrays.copyOf(awe.f6070i, b);
                }
                i = 1;
            }
            if (i != 0) {
                for (i = b - 1; i >= 0; --i) {
                    awe.f6070i[i] = awe.f6072k.mo10836a((short)i) / 1000;
                }
            }
            final short[] a = awe.f6072k.mo10841a();
            if (a != null && a.length == 2) {
                awe.f6062a = a[0];
                awe.f6063b= a[1];
            }
            else {
                awe.f6062a = -1500;
                awe.f6063b = 1500;
            }
            awe.f6073l = awe.f6072k.mo10847e();
            if (awe.f6074m == null) {
                awe.f6074m = new String[awe.f6073l];
                i = n2;
            }
            else if (awe.f6074m.length != awe.f6073l) {
                awe.f6074m = Arrays.copyOf(awe.f6074m, awe.f6073l);
                i = n2;
            }
            else {
                i = 0;
            }
            if (i != 0) {
                for (i = n; i < awe.f6073l; ++i) {
                    awe.f6074m[i] = awe.f6072k.mo10843b(i);
                }
            }
            if (awe.f6064c >= 0 && awe.f6064c < awe.f6073l) {
                awe.f6072k.mo10838a(awe.f6064c);
            }
            else {
                m7128h();
            }
        }
        catch (Throwable t) {
            m7117c();
            awe.f6068g = null;
            awe.f6070i = null;
            awe.f6074m = null;
        }
    }

    /* renamed from: c */
    public static void m7117c() {
        if (f6072k != null) {
            try {
                f6072k.mo10846d();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f6072k = null;
        }
    }

    /* renamed from: d */
    public static boolean m7120d() {
        return f6066e;
    }

    /* renamed from: e */
    public static int m7121e() {
        if (f6068g == null) {
            return 0;
        }
        return f6068g.length;
    }

    /* renamed from: d */
    public static int m7119d(int i) {
        if (f6070i == null || i >= f6070i.length) {
            return 0;
        }
        return f6070i[i];
    }

    /* renamed from: f */
    public static int m7123f() {
        return f6062a;
    }

    /* renamed from: g */
    public static int m7125g() {
        return f6063b;
    }

    /* renamed from: e */
    public static int m7122e(int i) {
        int[] iArr = f6068g;
        if (f6064c == -1) {
            iArr = f6071j;
        }
        if (f6067f && f6064c >= 0) {
            iArr = f6069h;
        }
        if (iArr == null || i >= iArr.length) {
            return 0;
        }
        return iArr[i];
    }

    /* renamed from: a */
    public static void m7111a(int i, int i2) {
        int[] iArr = f6068g;
        if (iArr != null && i < iArr.length) {
            if (f6067f && f6064c != -1) {
                System.arraycopy(f6069h, 0, iArr, 0, iArr.length);
                System.arraycopy(f6068g, 0, f6071j, 0, f6068g.length);
                f6067f = false;
            }
            f6071j[i] = i2;
            if (f6066e) {
                f6065d = -1;
            }
            f6064c = -1;
            if (i2 > f6063b) {
                i2 = f6063b;
            } else if (i2 < f6062a) {
                i2 = f6062a;
            }
            iArr[i] = i2;
        }
    }

    /* renamed from: a */
    public static void m7113a(boolean z) {
        f6066e = z;
        if (f6072k != null) {
            if (!z) {
                try {
                    f6072k.mo10837a(false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                if (f6064c != -1) {
                    m7128h();
                }
                f6072k.mo10837a(true);
            }
            f6066e = f6072k.mo10845c();
        }
    }

    /* renamed from: f */
    public static void m7124f(int i) {
        if (f6072k != null) {
            if (i < 0) {
                m7128h();
                return;
            }
            try {
                f6072k.mo10839a((short) i, (short) f6071j[i]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: h */
    public static void m7128h() {
        int[] iArr;
        int length = 0;
        if (f6064c == -1) {
            iArr = f6071j;
        } else {
            iArr = f6069h;
        }
        if (iArr != null && iArr.length > 0) {
            try {
                int b = iArr.length > f6072k.mo10844b() ? f6072k.mo10844b() : iArr.length;
                short[] sArr = new short[b];
                short s = (short) b;
                for (int i = b - 1; i >= 0; i--) {
                    int i2 = iArr[i];
                    if (i2 > f6063b) {
                        i2 = f6063b;
                        iArr[i] = i2;
                    } else if (i2 < f6062a) {
                        i2 = f6062a;
                        iArr[i] = i2;
                    }
                    sArr[i] = (short) i2;
                }
                f6072k.mo10840a(s, sArr);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            return;
        }
        length--;
    }

    /* renamed from: i */
    public static int m7129i() {
        return f6073l;
    }

    /* renamed from: g */
    public static void m7126g(int i) {
        if (f6072k != null && f6069h != null && f6068g != null && f6069h.length == f6068g.length) {
            if (i >= 0) {
                if (i >= f6073l) {
                    i = 0;
                }
                try {
                    f6072k.mo10838a(i);
                    if (f6066e) {
                        f6065d = i;
                    }
                    f6064c = i;
                    for (int i2 = 0; i2 < f6069h.length; i2++) {
                        f6069h[i2] = f6072k.mo10842b((short) i2);
                    }
                    f6067f = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                if (f6066e) {
                    f6065d = -1;
                }
                f6064c = -1;
                m7128h();
            }
        }
    }

    /* renamed from: j */
    public static int m7130j() {
        if (f6066e) {
            return f6065d;
        }
        return f6064c;
    }

    /* renamed from: h */
    public static String m7127h(int i) {
        return (f6074m == null || i < 0 || i >= f6074m.length) ? "Custom" : f6074m[i];
    }
}
