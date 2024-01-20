package classesdef.subtitle;

import classesdef.subtitle.arc;
import classesdef.subtitle.ard;
import classesdef.subtitle.arj;

/* renamed from: arf */
class arf extends arj {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10015a() {
        return "UTF-8";
    }

    arf() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0092 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0094  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ard mo10014aa(arc r14) {
        /*
            r13 = this;
            byte[] r0 = r14.f4699f
            int r1 = r14.f4700g
            r2 = 2
            r3 = 3
            r4 = 0
            r5 = 1
            if (r1 < r3) goto L_0x0024
            byte r1 = r0[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 239(0xef, float:3.35E-43)
            if (r1 != r6) goto L_0x0024
            byte r1 = r0[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 187(0xbb, float:2.62E-43)
            if (r1 != r6) goto L_0x0024
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 191(0xbf, float:2.68E-43)
            if (r1 != r6) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0028:
            int r9 = r14.f4700g
            if (r6 >= r9) goto L_0x0065
            byte r9 = r0[r6]
            r10 = r9 & 128(0x80, float:1.794E-43)
            if (r10 != 0) goto L_0x0033
            goto L_0x0063
        L_0x0033:
            r10 = r9 & 224(0xe0, float:3.14E-43)
            r11 = 192(0xc0, float:2.69E-43)
            if (r10 != r11) goto L_0x003b
            r9 = 1
            goto L_0x004a
        L_0x003b:
            r10 = r9 & 240(0xf0, float:3.36E-43)
            r12 = 224(0xe0, float:3.14E-43)
            if (r10 != r12) goto L_0x0043
            r9 = 2
            goto L_0x004a
        L_0x0043:
            r9 = r9 & 248(0xf8, float:3.48E-43)
            r10 = 240(0xf0, float:3.36E-43)
            if (r9 != r10) goto L_0x0061
            r9 = 3
        L_0x004a:
            int r6 = r6 + r5
            int r10 = r14.f4700g
            if (r6 < r10) goto L_0x0050
            goto L_0x0063
        L_0x0050:
            byte r10 = r0[r6]
            r10 = r10 & r11
            r12 = 128(0x80, float:1.794E-43)
            if (r10 == r12) goto L_0x005a
            int r7 = r7 + 1
            goto L_0x0063
        L_0x005a:
            int r9 = r9 + -1
            if (r9 != 0) goto L_0x004a
            int r8 = r8 + 1
            goto L_0x0063
        L_0x0061:
            int r7 = r7 + 1
        L_0x0063:
            int r6 = r6 + r5
            goto L_0x0028
        L_0x0065:
            r0 = 80
            r2 = 100
            if (r1 == 0) goto L_0x0070
            if (r7 != 0) goto L_0x0070
        L_0x006d:
            r4 = 100
            goto L_0x0090
        L_0x0070:
            if (r1 == 0) goto L_0x0079
            int r1 = r7 * 10
            if (r8 <= r1) goto L_0x0079
        L_0x0076:
            r4 = 80
            goto L_0x0090
        L_0x0079:
            if (r8 <= r3) goto L_0x007e
            if (r7 != 0) goto L_0x007e
            goto L_0x006d
        L_0x007e:
            if (r8 <= 0) goto L_0x0083
            if (r7 != 0) goto L_0x0083
            goto L_0x0076
        L_0x0083:
            if (r8 != 0) goto L_0x008a
            if (r7 != 0) goto L_0x008a
            r4 = 15
            goto L_0x0090
        L_0x008a:
            int r7 = r7 * 10
            if (r8 <= r7) goto L_0x0090
            r4 = 25
        L_0x0090:
            if (r4 != 0) goto L_0x0094
            r14 = 0
            goto L_0x009a
        L_0x0094:
            ard r0 = new ard
            r0.<init>(r14, r13, r4)
            r14 = r0
        L_0x009a:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: arf.mo10014a(arc):ard");
    }
    public ard mo10014aab(arc arc) {
        int i = 0;
        byte[] bArr = arc.f4699f;
        int i2 = 0;
        boolean z = arc.f4700g >= 3 && (bArr[0] & 255) == 239 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < arc.f4700g) {
            byte b = bArr[i3];
            if ((b & 128) != 0) {
                if ((b & 224) == 192) {
                    i = 1;
                } else if ((b & 240) == 224) {
                    i = 2;
                } else if ((b & 248) == 240) {
                    i = 3;
                } else {
                    i4++;
                }
                while (true) {
                    i3++;
                    if (i3 < arc.f4700g) {
                        if ((bArr[i3] & 192) == 128) {
                            i--;
                            if (i == 0) {
                                i5++;
                                break;
                            }
                        } else {
                            i4++;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i3++;
        }
        if (!z || i4 != 0) {
            if (!z || i5 <= i4 * 10) {
                if (i5 <= 3 || i4 != 0) {
                    if (i5 <= 0 || i4 != 0) {
                        if (i5 == 0 && i4 == 0) {
                            i2 = 15;
                            if (i2 != 0) {
                            }
                        } else {
                            if (i5 > i4 * 10) {
                                i2 = 25;
                            }
                            if (i2 != 0) {
                                return null;
                            }
                            return new ard(arc, this, i2);
                        }
                    }
                }
            }
            i2 = 80;
            if (i2 != 0) {
            }
        }
        i2 = 100;
        if (i2 != 0) {
        }
        return null;
    }
    public ard mo10014aaaa(arc amt) {
        int i = 0;
        byte[] bArr = amt.f4699f;
        int i2 = 0;
        boolean z = amt.f4700g >= 3 && (bArr[0] & 255) == 239 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < amt.f4700g) {
            byte b = bArr[i3];
            if ((b & 128) != 0) {
                if ((b & 224) == 192) {
                    i = 1;
                } else if ((b & 240) == 224) {
                    i = 2;
                } else if ((b & 248) == 240) {
                    i = 3;
                } else {
                    i4++;
                }
                while (true) {
                    i3++;
                    if (i3 < amt.f4700g) {
                        if ((bArr[i3] & 192) == 128) {
                            i--;
                            if (i == 0) {
                                i5++;
                                break;
                            }
                        } else {
                            i4++;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i3++;
        }
        if (z && i4 == 0) {
            i2 = 100;
        } else if (z && i5 > i4 * 10) {
            i2 = 80;
        } else if (i5 > 3 && i4 == 0) {
            i2 = 100;
        } else if (i5 > 0 && i4 == 0) {
            i2 = 80;
        } else if (i5 == 0 && i4 == 0) {
            i2 = 15;
        } else if (i5 > i4 * 10) {
            i2 = 25;
        }
        if (i2 == 0) {
            return null;
        }
        return new ard(amt, this, i2);
    }

    public ard mo10014a(final arc amt) {
        final byte[] f = amt.f4699f;
        final int g = amt.f4700g;
        final int n = 0;
        final boolean b = g >= 3 && (f[0] & 0xFF) == 0xEF && (f[1] & 0xFF) == 0xBB && (f[2] & 0xFF) == 0xBF;
        int i = 0;
        int n2 = 0;
        int n3 = 0;
        while (i < amt.f4700g) {
            final byte b2 = f[i];
            int n4 = 0;
            Label_0241: {
                if ((b2 & 0x80) == 0x0) {
                    n4 = n2;
                }
                else {
                    int n5;
                    if ((b2 & 0xE0) == 0xC0) {
                        n5 = 1;
                    }
                    else if ((b2 & 0xF0) == 0xE0) {
                        n5 = 2;
                    }
                    else {
                        if ((b2 & 0xF8) != 0xF0) {
                            n4 = n2 + 1;
                            break Label_0241;
                        }
                        n5 = 3;
                    }
                    int n6;
                    int n7;
                    do {
                        n7 = i + 1;
                        if (n7 >= amt.f4700g) {
                            i = n7;
                            n4 = n2;
                            break Label_0241;
                        }
                        if ((f[n7] & 0xC0) != 0x80) {
                            n4 = n2 + 1;
                            i = n7;
                            break Label_0241;
                        }
                        n6 = n5 - 1;
                        i = n7;
                    } while ((n5 = n6) != 0);
                    ++n3;
                    i = n7;
                    n4 = n2;
                }
            }
            ++i;
            n2 = n4;
        }
        int n8;
        if (b && n2 == 0) {
            n8 = 100;
        }
        else if (b && n3 > n2 * 10) {
            n8 = 80;
        }
        else if (n3 > 3 && n2 == 0) {
            n8 = 100;
        }
        else if (n3 > 0 && n2 == 0) {
            n8 = 80;
        }
        else if (n3 == 0 && n2 == 0) {
            n8 = 15;
        }
        else {
            n8 = n;
            if (n3 > n2 * 10) {
                n8 = 25;
            }
        }
        ard amu;
        if (n8 == 0) {
            amu = null;
        }
        else {
            amu = new ard(amt, this, n8);
        }
        return amu;
    }
}
