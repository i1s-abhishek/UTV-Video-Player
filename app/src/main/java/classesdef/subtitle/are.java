package classesdef.subtitle;

/* renamed from: are */
abstract class are extends arj {
    are() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo10013ac(byte[] bArr, int i, byte[][] bArr2) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < i) {
            if (bArr[i2] == 27) {
                for (byte[] bArr3 : bArr2) {
                    if (i - i2 >= bArr3.length) {
                        int i6 = 1;
                        while (i6 < bArr3.length) {
                            if (bArr3[i6] == bArr[i2 + i6]) {
                                i6++;
                            }
                        }
                        i3++;
                        i2 += bArr3.length - 1;
                        break;
                    }
                }
                i4++;
            }
            if (bArr[i2] == 14 || bArr[i2] == 15) {
                i5++;
                i2++;
            } else {
                i2++;
            }
        }
        if (i3 == 0) {
            return 0;
        }
        int i7 = ((i3 * 100) - (i4 * 100)) / (i4 + i3);
        int i8 = i3 + i5;
        if (i8 < 5) {
            i7 -= (5 - i8) * 10;
        }
        if (i7 < 0) {
            return 0;
        }
        return i7;
    }
    public int mo10013a(final byte[] array, int n, final byte[][] array2) {
        int i = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (i < n) {
            int j = n3;
            int k = 0;
            int n5 = 0;
            int n6 = 0;
            Label_0179: {
                if (array[i] == 27) {
                    Label_0086:
                    for (j = 0; j < array2.length; ++j) {
                        final byte[] array3 = array2[j];
                        if (n - i >= array3.length) {
                            for (int kk = 1; kk < array3.length; ++kk) {
                                if (array3[kk] != array[i + kk]) {
                                    continue Label_0086;
                                }
                            }
                            n5 = n2 + 1;
                            k = i + (array3.length - 1);
                            n6 = n4;
                            break Label_0179;
                        }
                    }
                    j = n3 + 1;
                }
                if (array[i] != 14) {
                    k = i;
                    n5 = n2;
                    n3 = j;
                    n6 = n4;
                    if (array[i] != 15) {
                        break Label_0179;
                    }
                }
                n6 = n4 + 1;
                n3 = j;
                n5 = n2;
                k = i;
            }
            i = k + 1;
            n2 = n5;
            n4 = n6;
        }
        if (n2 == 0) {
            return 0;
        }
        i = (n2 * 100 - n3 * 100) / (n3 + n2);
        n3 = n2 + n4;
        n = i;
        if (n3 < 5) {
            n = i - (5 - n3) * 10;
        }
        if ((i = n) < 0) {
            i = 0;
        }
        return i;
    }
    public int mo10013ab(byte[] bArr, int i, byte[][] bArr2) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i7 < i) {
            if (bArr[i7] == 27) {
                for (byte[] bArr3 : bArr2) {
                    if (i - i7 >= bArr3.length) {
                        int i8 = 1;
                        while (i8 < bArr3.length) {
                            if (bArr3[i8] == bArr[i7 + i8]) {
                                i8++;
                            }
                        }
                        i7 += bArr3.length - 1;
                        i3 = i4;
                        i6++;
                        break;
                    }
                }
                i2 = i5 + 1;
                if (bArr[i7] != 14 || bArr[i7] == 15) {
                    i3 = i4 + 1;
                    i5 = i2;
                } else {
                    i3 = i4;
                    i5 = i2;
                }
            } else {
                i2 = i5;
                if (bArr[i7] != 14) {
                }
                i3 = i4 + 1;
                i5 = i2;
            }
            i7++;
            i4 = i3;
        }
        if (i6 == 0) {
            return 0;
        }
        int i9 = ((i6 * 100) - (i5 * 100)) / (i5 + i6);
        int i10 = i6 + i4;
        if (i10 < 5) {
            i9 -= (5 - i10) * 10;
        }
        if (i9 >= 0) {
            return i9;
        }
        return 0;
    }

    /* renamed from: are$b */
    static class C1097b extends are {

        /* renamed from: a */
        private byte[][] f4713a = {new byte[]{27, 36, 40, 67}, new byte[]{27, 36, 40, 68}, new byte[]{27, 36, 64}, new byte[]{27, 36, 65}, new byte[]{27, 36, 66}, new byte[]{27, 38, 64}, new byte[]{27, 40, 66}, new byte[]{27, 40, 72}, new byte[]{27, 40, 73}, new byte[]{27, 40, 74}, new byte[]{27, 46, 65}, new byte[]{27, 46, 70}};

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo10015a() {
            return "ISO-2022-JP";
        }

        C1097b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public ard mo10014a(arc arc) {
            int a = mo10013a(arc.f4694a, arc.f4695b, this.f4713a);
            if (a == 0) {
                return null;
            }
            return new ard(arc, this, a);
        }
    }

    /* renamed from: are$c */
    static class C1098c extends are {

        /* renamed from: a */
        private byte[][] f4714a = {new byte[]{27, 36, 41, 67}};

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo10015a() {
            return "ISO-2022-KR";
        }

        C1098c() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public ard mo10014a(arc arc) {
            int a = mo10013a(arc.f4694a, arc.f4695b, this.f4714a);
            if (a == 0) {
                return null;
            }
            return new ard(arc, this, a);
        }
    }

    /* renamed from: are$a */
    static class C1096a extends are {

        /* renamed from: a */
        private byte[][] f4712a = {new byte[]{27, 36, 41, 65}, new byte[]{27, 36, 41, 71}, new byte[]{27, 36, 42, 72}, new byte[]{27, 36, 41, 69}, new byte[]{27, 36, 43, 73}, new byte[]{27, 36, 43, 74}, new byte[]{27, 36, 43, 75}, new byte[]{27, 36, 43, 76}, new byte[]{27, 36, 43, 77}, new byte[]{27, 78}, new byte[]{27, 79}};

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo10015a() {
            return "ISO-2022-CN";
        }

        C1096a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public ard mo10014a(arc arc) {
            int a = mo10013a(arc.f4694a, arc.f4695b, this.f4712a);
            if (a == 0) {
                return null;
            }
            return new ard(arc, this, a);
        }
    }
}
