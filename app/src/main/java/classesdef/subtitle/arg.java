package classesdef.subtitle;

/* renamed from: arg */
abstract class arg extends arj {
    /* renamed from: a */
    static int m5455a(byte b, byte b2) {
        return ((b & 255) << 8) | (b2 & 255);
    }

    /* renamed from: a */
    static int m5456a(int i, int i2) {
        if (i == 0) {
            i2 -= 10;
        } else if ((i >= 32 && i <= 255) || i == 10) {
            i2 += 10;
        }
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract ard mo10014a(arc arc);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract String mo10015a();

    arg() {
    }

    /* renamed from: arg$a */
    static class C1099a extends arg {
        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo10015a() {
            return "UTF-16BE";
        }

        C1099a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public ard mo10014a(arc arc) {
            byte[] bArr = arc.f4699f;
            int min = Math.min(bArr.length, 30);
            int i = 0;
            int i2 = 0;
            int i3 = 10;
            while (true) {
                if (i2 >= min - 1) {
                    break;
                }
                int a = m5455a(bArr[i2], bArr[i2 + 1]);
                if (i2 != 0 || a != 65279) {
                    i3 = m5456a(a, i3);
                    if (i3 == 0 || i3 == 100) {
                        break;
                    }
                    i2 += 2;
                } else {
                    i3 = 100;
                    break;
                }
            }
            if (min >= 4 || i3 >= 100) {
                i = i3;
            }
            if (i > 0) {
                return new ard(arc, this, i);
            }
            return null;
        }
    }

    /* renamed from: arg$b */
    static class C1100b extends arg {
        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo10015a() {
            return "UTF-16LE";
        }

        C1100b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public ard mo10014a(arc arc) {
            byte[] bArr = arc.f4699f;
            int min = Math.min(bArr.length, 30);
            int i = 0;
            int i2 = 0;
            int i3 = 10;
            while (true) {
                if (i2 >= min - 1) {
                    break;
                }
                int a = m5455a(bArr[i2 + 1], bArr[i2]);
                if (i2 != 0 || a != 65279) {
                    i3 = m5456a(a, i3);
                    if (i3 == 0 || i3 == 100) {
                        break;
                    }
                    i2 += 2;
                } else {
                    i3 = 100;
                    break;
                }
            }
            if (min >= 4 || i3 >= 100) {
                i = i3;
            }
            if (i > 0) {
                return new ard(arc, this, i);
            }
            return null;
        }
    }

    /* renamed from: arg$c */
    static abstract class C1101c extends arg {
        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract int mo10016a(byte[] bArr, int i);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract String mo10015a();

        C1101c() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ard mo10014aa(arc r11) {
            /*
                r10 = this;
                byte[] r0 = r11.f4699f
                int r1 = r11.f4700g
                int r1 = r1 / 4
                int r1 = r1 * 4
                r2 = 0
                if (r1 != 0) goto L_0x000c
                return r2
            L_0x000c:
                r3 = 0
                int r4 = r10.mo10016a(r0, r3)
                r5 = 65279(0xfeff, float:9.1475E-41)
                if (r4 != r5) goto L_0x0018
                r4 = 1
                goto L_0x0019
            L_0x0018:
                r4 = 0
            L_0x0019:
                r5 = 0
                r6 = 0
                r7 = 0
            L_0x001c:
                if (r5 >= r1) goto L_0x003c
                int r8 = r10.mo10016a(r0, r5)
                if (r8 < 0) goto L_0x0037
                r9 = 1114111(0x10ffff, float:1.561202E-39)
                if (r8 >= r9) goto L_0x0037
                r9 = 55296(0xd800, float:7.7486E-41)
                if (r8 < r9) goto L_0x0034
                r9 = 57343(0xdfff, float:8.0355E-41)
                if (r8 > r9) goto L_0x0034
                goto L_0x0037
            L_0x0034:
                int r7 = r7 + 1
                goto L_0x0039
            L_0x0037:
                int r6 = r6 + 1
            L_0x0039:
                int r5 = r5 + 4
                goto L_0x001c
            L_0x003c:
                r0 = 80
                r1 = 100
                if (r4 == 0) goto L_0x0047
                if (r6 != 0) goto L_0x0047
            L_0x0044:
                r0 = 100
                goto L_0x0063
            L_0x0047:
                if (r4 == 0) goto L_0x004e
                int r4 = r6 * 10
                if (r7 <= r4) goto L_0x004e
                goto L_0x0063
            L_0x004e:
                r4 = 3
                if (r7 <= r4) goto L_0x0054
                if (r6 != 0) goto L_0x0054
                goto L_0x0044
            L_0x0054:
                if (r7 <= 0) goto L_0x0059
                if (r6 != 0) goto L_0x0059
                goto L_0x0063
            L_0x0059:
                int r6 = r6 * 10
                if (r7 <= r6) goto L_0x0062
                r3 = 25
                r0 = 25
                goto L_0x0063
            L_0x0062:
                r0 = 0
            L_0x0063:
                if (r0 != 0) goto L_0x0066
                goto L_0x006b
            L_0x0066:
                ard r2 = new ard
                r2.<init>(r11, r10, r0)
            L_0x006b:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: arg.C1101c.mo10014a(arc):ard");
        }
        public ard mo10014a(arc arc) {
            byte[] bArr = arc.f4699f;
            int i = (arc.f4700g / 4) * 4;
            if (i == 0) {
                return null;
            }
            boolean z = mo10016a(bArr, 0) == 65279;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4 += 4) {
                int a = mo10016a(bArr, i4);
                if (a < 0 || a >= 1114111 || (a >= 55296 && a <= 57343)) {
                    i2++;
                } else {
                    i3++;
                }
            }
            int i5 = 80;
            if (!z || i2 != 0) {
                if (!z || i3 <= i2 * 10) {
                    if (i3 <= 3 || i2 != 0) {
                        if (i3 <= 0 || i2 != 0) {
                            i5 = i3 > i2 * 10 ? 25 : 0;
                        }
                    }
                }
                if (i5 != 0) {
                    return null;
                }
                return new ard(arc, this, i5);
            }
            i5 = 100;
            if (i5 != 0) {
            }
            return null;
        }
        public ard mo10014ab( arc arc) {
            final byte[] f = arc.f4699f;
            final int n = arc.f4700g / 4 * 4;
            final ard ard = null;
            if (n == 0) {
                return null;
            }
            final boolean b = this.mo10016a(f, 0) == 65279;
            int i = 0;
            int n2 = 0;
            int n3 = 0;
            while (i < n) {
                final int a = this.mo10016a(f, i);
                if (a >= 0 && a < 1114111 && (a < 55296 || a > 57343)) {
                    ++n3;
                }
                else {
                    ++n2;
                }
                i += 4;
            }
            i = 80;
            int n4 = 0;
            Label_0205: {
                if (!b || n2 != 0) {
                    if (b && n3 > n2 * 10) {
                        n4 = i;
                        break Label_0205;
                    }
                    if (n3 <= 3 || n2 != 0) {
                        if (n3 > 0 && n2 == 0) {
                            n4 = i;
                            break Label_0205;
                        }
                        if (n3 > n2 * 10) {
                            n4 = 25;
                            break Label_0205;
                        }
                        n4 = 0;
                        break Label_0205;
                    }
                }
                n4 = 100;
            }
            ard ard2;
            if (n4 == 0) {
                ard2 = ard;
            }
            else {
                ard2 = new ard(arc, (arj)this, n4);
            }
            return ard2;
        }

    }

    /* renamed from: arg$d */
    static class C1102d extends C1101c {
        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo10015a() {
            return "UTF-32BE";
        }

        C1102d() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo10016a(byte[] bArr, int i) {
            return (bArr[i + 3] & 255) | ((bArr[i + 0] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        }
    }

    /* renamed from: arg$e */
    static class C1103e extends C1101c {
        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo10015a() {
            return "UTF-32LE";
        }

        C1103e() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo10016a(byte[] bArr, int i) {
            return (bArr[i + 0] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
        }
    }
}
