package com.abhishek.xplayer.subtitle;


import android.text.TextUtils;
import android.util.Log;

import androidx.core.util.Pair;

import com.abhishek.xplayer.application.MyApplication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classesdef.inplayer.awt;
import classesdef.inplayer.axc;
import classesdef.subtitle.arc;
import classesdef.xdplayer.axe;

/* renamed from: com.inshot.xplayer.subtitle.c */
public class C2822c {


    private int f11220a = 0;

    /* renamed from: b */
    private long f11221b = 0;

    /* renamed from: c */
    private boolean f11222c;

    /* renamed from: d */
    private C2827c f11223d;

    /* renamed from: com.inshot.xplayer.subtitle.c$a */
    public interface C2825a {
        /* renamed from: a */
        void mo17596a(C2827c cVar);

        /* renamed from: a */
        void mo17597a(String str);
    }

    public C2822c(C2827c cVar, boolean z, int i) {
        this.f11223d = cVar;
        this.f11222c = z;
        mo18215a(i);
    }

    /* renamed from: a */
    public List<C2826b> mo18214a(long j) {
        if (j < this.f11221b) {
            this.f11220a = 0;
        }
        this.f11221b = j;
        long a = j + ((long) this.f11223d.f11232b);
        LinkedList linkedList = null;
        int size = this.f11223d.size();
        for (int i = this.f11220a; i < size; i++) {
            C2826b bVar = (C2826b) this.f11223d.get(i);
            if (linkedList == null) {
                this.f11220a = i;
            }
            if (a < bVar.f11229b) {
                break;
            }
            if (a <= bVar.f11230c) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(bVar);
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public void mo18215a(int i) {
        int unused = this.f11223d.f11232b = i;
    }

    /* renamed from: a */
    public int mo18213a() {
        return this.f11223d.f11232b;
    }

    /* renamed from: b */
    public String mo18217b() {
        return this.f11223d.f11231a;
    }

    /* renamed from: a */
    public void mo18216a(boolean z) {
        this.f11222c = z;
    }

    /* renamed from: c */
    public boolean mo18218c() {
        return this.f11222c;
    }

    /* renamed from: a */
    public static void m12788a(final String str, final C2825a aVar) {
        new Thread() {
            public void run() {
                final C2827c b = C2822c.m12792c(str);
                MyApplication.myApplication().runnable((Runnable) new Runnable() {
                    public void run() {
                        if (b == null) {
                            aVar.mo17597a(str);
                        } else {
                            aVar.mo17596a(b);
                        }
                    }
                });
            }
        }.start();
    }

    /* renamed from: a */
    public static String m12787a(String str, String str2) {
        String str3;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            str3 = m12794d();
        } else {
            str3 = file.getParent();
            str2 = file.getName();
        }
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            str2 = str2.substring(0, lastIndexOf);
        }
        for (String str4 : new String[]{".srt", ".ass", ".smi"}) {
            File file2 = new File(str3 + "/" + str2 + str4);
            if (file2.exists()) {
                return file2.getAbsolutePath();
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m12791b(String str, String str2) {
        String str3;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            str3 = m12794d();
        } else {
            str3 = file.getParent();
            str2 = file.getName();
        }
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            str2 = str2.substring(0, lastIndexOf);
        }
        return str3 + "/" + str2;
    }

    /* renamed from: d */
    static String m12794d() {
        return axc.appFolder() + "/Subtitle";
    }

    /* renamed from: a */
    static boolean m12789a(String str) {
        return "srt".equalsIgnoreCase(str) || "smi".equalsIgnoreCase(str) || "ass".equalsIgnoreCase(str);
    }

    /* access modifiers changed from: private */
    public static C2827c m12792c(String str) {
        if (!axe.m7319a(str, false)) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (lowerCase.endsWith(".srt")) {
            return m12796f(str);
        }
        if (lowerCase.endsWith(".smi")) {
            return m12797g(str);
        }
        if (lowerCase.endsWith(".ass")) {
            return m12798h(str);
        }
        return null;
    }

    private static Pair<Long, Long> m12793d(String str) {
        try {
            String[] split = str.split("-->");
            if (split.length != 2) {
                return null;
            }
            long e = m12795e(split[0].trim());
            long e2 = m12795e(split[1].trim());
            if (e == -1 || e2 == -1) {
                return null;
            }
            return new Pair<>(Long.valueOf(e), Long.valueOf(e2));
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }


    private static long m12795e(String str) {
        int parseInt = Integer.parseInt(str.substring(0, 2));
        int parseInt2 = Integer.parseInt(str.substring(3, 5));
        return (long) (Integer.parseInt(str.substring(9, 12)) + (Integer.parseInt(str.substring(6, 8)) * 1000) + (parseInt2 * 60000) + (parseInt * 3600000));
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bd A[SYNTHETIC, Splitter:B:40:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d5 A[SYNTHETIC, Splitter:B:51:0x00d5] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static C2827c m12796ff(String r18) {
        /*
            r1 = r18
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            r3 = 1
            r4 = 0
            r5 = 0
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            arc r7 = new arc     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            r7.<init>()     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            r9.<init>(r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            java.io.Reader r7 = r7.mo10007a(r8, r5)     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
        L_0x0022:
            java.lang.String r7 = r6.readLine()     // Catch:{ Exception -> 0x00ae }
            if (r7 == 0) goto L_0x00a2
            java.lang.String r8 = r7.trim()     // Catch:{ Exception -> 0x00ae }
            java.lang.String r9 = ""
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x00ae }
            if (r8 == 0) goto L_0x0035
            goto L_0x0022
        L_0x0035:
            java.lang.String r8 = r6.readLine()     // Catch:{ Exception -> 0x00ae }
            if (r8 == 0) goto L_0x0088
            android.support.v4.util.Pair r8 = m12793d(r8)     // Catch:{ Exception -> 0x00ae }
            if (r8 == 0) goto L_0x0088
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ae }
            r9.<init>()     // Catch:{ Exception -> 0x00ae }
        L_0x0046:
            java.lang.String r10 = r6.readLine()     // Catch:{ Exception -> 0x00ae }
            if (r10 == 0) goto L_0x0088
            java.lang.String r11 = r10.trim()     // Catch:{ Exception -> 0x00ae }
            java.lang.String r12 = ""
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x00ae }
            if (r11 == 0) goto L_0x007f
            int r10 = r9.length()     // Catch:{ Exception -> 0x00ae }
            if (r10 <= 0) goto L_0x0088
            com.inshot.xplayer.subtitle.c$b r10 = new com.inshot.xplayer.subtitle.c$b     // Catch:{ Exception -> 0x00ae }
            java.lang.String r12 = r9.toString()     // Catch:{ Exception -> 0x00ae }
            F r9 = r8.first     // Catch:{ Exception -> 0x00ae }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ Exception -> 0x00ae }
            long r13 = r9.longValue()     // Catch:{ Exception -> 0x00ae }
            S r8 = r8.second     // Catch:{ Exception -> 0x00ae }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ Exception -> 0x00ae }
            long r15 = r8.longValue()     // Catch:{ Exception -> 0x00ae }
            r17 = 0
            r11 = r10
            r11.<init>(r12, r13, r15)     // Catch:{ Exception -> 0x00ae }
            r2.add(r10)     // Catch:{ Exception -> 0x00ae }
            r8 = 1
            goto L_0x0089
        L_0x007f:
            r9.append(r10)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r10 = "\n"
            r9.append(r10)     // Catch:{ Exception -> 0x00ae }
            goto L_0x0046
        L_0x0088:
            r8 = 0
        L_0x0089:
            if (r8 != 0) goto L_0x0022
            java.io.PrintStream r8 = java.lang.System.err     // Catch:{ Exception -> 0x00ae }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ae }
            r9.<init>()     // Catch:{ Exception -> 0x00ae }
            java.lang.String r10 = "SRTParser Error parse line : "
            r9.append(r10)     // Catch:{ Exception -> 0x00ae }
            r9.append(r7)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x00ae }
            r8.println(r7)     // Catch:{ Exception -> 0x00ae }
            goto L_0x0022
        L_0x00a2:
            if (r6 == 0) goto L_0x00ac
            r6.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00ac
        L_0x00a8:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ac:
            r3 = 0
            goto L_0x00c5
        L_0x00ae:
            r0 = move-exception
            r4 = r0
            goto L_0x00b8
        L_0x00b1:
            r0 = move-exception
            r1 = r0
            r6 = r5
            goto L_0x00d3
        L_0x00b5:
            r0 = move-exception
            r4 = r0
            r6 = r5
        L_0x00b8:
            r4.printStackTrace()     // Catch:{ all -> 0x00d1 }
            if (r6 == 0) goto L_0x00c5
            r6.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c5
        L_0x00c1:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00c5:
            if (r3 == 0) goto L_0x00c8
            return r5
        L_0x00c8:
            com.inshot.xplayer.subtitle.c$c r3 = new com.inshot.xplayer.subtitle.c$c
            r3.<init>(r1, r2)
            java.util.Collections.sort(r3)
            return r3
        L_0x00d1:
            r0 = move-exception
            r1 = r0
        L_0x00d3:
            if (r6 == 0) goto L_0x00dd
            r6.close()     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00dd:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.subtitle.C2822c.m12796f(java.lang.String):com.inshot.xplayer.subtitle.c$c");
    }
    private static C2827c m12796f(String str) {
        Log.e("abhi_subtitle","srt");
        BufferedReader bufferedReader;
        Throwable th;
        Exception exc;
        boolean z = false;
        Pair<Long, Long> d2;
        LinkedList linkedList = new LinkedList();
        boolean z2 = true;
        try {
            bufferedReader = new BufferedReader(new arc().mo10007a(new BufferedInputStream(new FileInputStream(str)), null));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    Log.e("abhi_subtitle_start","srt start readLine "+String.valueOf(readLine));
                    if (readLine == null) {
                        break;
                    } else if (!readLine.trim().equals("")) {
                        String readLine2 = bufferedReader.readLine();
                        Log.e("abhi_subtitle_readLine2","srt start readLine2 "+String.valueOf(readLine2));
                        if (readLine2 != null && (d2 = m12793d(readLine2)) != null) {
                            StringBuilder sb = new StringBuilder();
                         //   while (true) {
                                String readLine3 = bufferedReader.readLine();
                                if (readLine3 == null) {
                                    break;
                                } else if (!readLine3.trim().equals("")) {
                                    sb.append(readLine3);
                                    sb.append("\n");
                                }  if (sb.length() > 0) {
                                    linkedList.add(new C2822c.C2826b(sb.toString(), d2.first.longValue(), d2.second.longValue()));
                                    z = true;
                                }
                            }
                       // }
                        z = false;
                        if (!z) {
                            System.err.println("SRTParser Error parse line : " + readLine);
                        }
                    }
                }
                catch (Exception e) {
                    exc = e;
                    try {
                        exc.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (z2) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            z2 = false;
        } catch (Exception e5) {
            exc = e5;
            bufferedReader = null;
            exc.printStackTrace();
            if (bufferedReader != null) {
            }
            if (z2) {
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
        //    throw th;
        }
        if (z2) {
            Log.e("abhi_subtitle","srt2 done null");
            return null;
        }
        Log.e("abhi_subtitle","srt2 done");
        C2822c.C2827c cVar = new C2827c(str, linkedList);
        Collections.sort(cVar);
        return cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0121 A[SYNTHETIC, Splitter:B:60:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013c A[SYNTHETIC, Splitter:B:71:0x013c] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static C2827c m12797gg(String r23) {
        /*
            r1 = r23
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.lang.String r3 = "<[S|s][Y|y][N|n][C|c].*[S|s][T|t][A|a][R|r][T|t]=(\\d+).*?>([\\s\\S]*)"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 1
            r6 = 0
            r7 = 0
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0119, all -> 0x0115 }
            arc r9 = new arc     // Catch:{ Exception -> 0x0119, all -> 0x0115 }
            r9.<init>()     // Catch:{ Exception -> 0x0119, all -> 0x0115 }
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0119, all -> 0x0115 }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0119, all -> 0x0115 }
            r11.<init>(r1)     // Catch:{ Exception -> 0x0119, all -> 0x0115 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0119, all -> 0x0115 }
            java.io.Reader r9 = r9.mo10007a(r10, r7)     // Catch:{ Exception -> 0x0119, all -> 0x0115 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0119, all -> 0x0115 }
            r9 = r7
        L_0x002e:
            java.lang.String r10 = r8.readLine()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            r13 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r15 = 2
            if (r10 == 0) goto L_0x00b6
            int r7 = r10.length()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            r11 = 5
            if (r7 <= r11) goto L_0x00a5
            java.lang.String r7 = r10.substring(r6, r11)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r11 = "<sync"
            boolean r7 = r7.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r7 == 0) goto L_0x00a5
            int r7 = r4.length()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r7 <= 0) goto L_0x009c
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r7 = r7.trim()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.util.regex.Matcher r7 = r3.matcher(r7)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            boolean r11 = r7.find()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r11 == 0) goto L_0x0097
            int r11 = r7.groupCount()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r11 != r15) goto L_0x0097
            java.lang.String r11 = r7.group(r5)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            long r18 = java.lang.Long.parseLong(r11)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r17 = r7.group(r15)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r9 == 0) goto L_0x0085
            long r11 = r9.f11230c     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            int r7 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r7 != 0) goto L_0x0085
            r11 = 1
            long r11 = r18 - r11
            r9.f11230c = r11     // Catch:{ Exception -> 0x0111, all -> 0x010e }
        L_0x0085:
            com.inshot.xplayer.subtitle.c$b r7 = new com.inshot.xplayer.subtitle.c$b     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r22 = 0
            r16 = r7
            r16.<init>(r17, r18, r20)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            r2.add(r7)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            goto L_0x0098
        L_0x0097:
            r7 = r9
        L_0x0098:
            r4.setLength(r6)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            r9 = r7
        L_0x009c:
            r4.append(r10)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r7 = "\n"
            r4.append(r7)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            goto L_0x00b3
        L_0x00a5:
            int r7 = r4.length()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r7 <= 0) goto L_0x00b3
            r4.append(r10)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r7 = "\n"
            r4.append(r7)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
        L_0x00b3:
            r7 = 0
            goto L_0x002e
        L_0x00b6:
            int r7 = r4.length()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r7 <= 0) goto L_0x0102
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r7 = r7.trim()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.util.regex.Matcher r3 = r3.matcher(r7)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            boolean r7 = r3.find()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r7 == 0) goto L_0x00ff
            int r7 = r3.groupCount()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r7 != r15) goto L_0x00ff
            java.lang.String r7 = r3.group(r5)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            long r18 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r17 = r3.group(r15)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r9 == 0) goto L_0x00ee
            long r10 = r9.f11230c     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            int r3 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x00ee
            r10 = 1
            long r10 = r18 - r10
            r9.f11230c = r10     // Catch:{ Exception -> 0x0111, all -> 0x010e }
        L_0x00ee:
            com.inshot.xplayer.subtitle.c$b r3 = new com.inshot.xplayer.subtitle.c$b     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r22 = 0
            r16 = r3
            r16.<init>(r17, r18, r20)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            r2.add(r3)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
        L_0x00ff:
            r4.setLength(r6)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
        L_0x0102:
            if (r8 == 0) goto L_0x010c
            r8.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x010c
        L_0x0108:
            r0 = move-exception
            r0.printStackTrace()
        L_0x010c:
            r5 = 0
            goto L_0x0129
        L_0x010e:
            r0 = move-exception
            r1 = r0
            goto L_0x013a
        L_0x0111:
            r0 = move-exception
            r3 = r0
            r7 = r8
            goto L_0x011c
        L_0x0115:
            r0 = move-exception
            r1 = r0
            r8 = 0
            goto L_0x013a
        L_0x0119:
            r0 = move-exception
            r3 = r0
            r7 = 0
        L_0x011c:
            r3.printStackTrace()     // Catch:{ all -> 0x0137 }
            if (r7 == 0) goto L_0x0129
            r7.close()     // Catch:{ IOException -> 0x0125 }
            goto L_0x0129
        L_0x0125:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0129:
            if (r5 == 0) goto L_0x012d
            r3 = 0
            return r3
        L_0x012d:
            r3 = 0
            com.inshot.xplayer.subtitle.c$c r4 = new com.inshot.xplayer.subtitle.c$c
            r4.<init>(r1, r2)
            java.util.Collections.sort(r4)
            return r4
        L_0x0137:
            r0 = move-exception
            r1 = r0
            r8 = r7
        L_0x013a:
            if (r8 == 0) goto L_0x0144
            r8.close()     // Catch:{ IOException -> 0x0140 }
            goto L_0x0144
        L_0x0140:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0144:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.subtitle.C2822c.m12797g(java.lang.String):com.inshot.xplayer.subtitle.c$c");
    }
    private static C2827c m12797g(String str) {
        Log.e("abhi_subtitle","smi");
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        Exception exc;
        C2826b bVar;
        LinkedList linkedList = new LinkedList();
        Pattern compile = Pattern.compile("<[S|s][Y|y][N|n][C|c].*[S|s][T|t][A|a][R|r][T|t]=(\\d+).*?>([\\s\\S]*)");
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        try {
            bufferedReader = new BufferedReader(new arc().mo10007a(new BufferedInputStream(new FileInputStream(str)), null));
            C2826b bVar2 = null;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.length() > 5 && readLine.substring(0, 5).equalsIgnoreCase("<sync")) {
                        Log.e("abhi_subtitle"," smi srt2");
                        if (sb.length() > 0) {
                            Matcher matcher = compile.matcher(sb.toString().trim());
                            if (!matcher.find() || matcher.groupCount() != 2) {
                                bVar = bVar2;
                            } else {
                                long parseLong = Long.parseLong(matcher.group(1));
                                String group = matcher.group(2);
                                if (bVar2 != null && bVar2.f11230c == Long.MAX_VALUE) {
                                    bVar2.f11230c = parseLong - 1;
                                }
                                Log.e("abhi_subtitle","smi a1"+String.valueOf(sb.toString()));
                                Log.e("abhi_subtitle","smi a2"+String.valueOf(parseLong));
                                Log.e("abhi_subtitle","smi a3"+String.valueOf( Long.MAX_VALUE));
                                bVar = new C2826b(group, parseLong, Long.MAX_VALUE);
                                linkedList.add(bVar);
                            }
                            sb.setLength(0);
                            bVar2 = bVar;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    } else if (sb.length() > 0) {
                        sb.append(readLine);
                        sb.append("\n");
                    }
                } catch (Exception e) {
                    exc = e;
                    bufferedReader2 = bufferedReader;
                    try {
                        exc.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (z) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            if (sb.length() > 0) {
                Matcher matcher2 = compile.matcher(sb.toString().trim());
                if (matcher2.find() && matcher2.groupCount() == 2) {
                    long parseLong2 = Long.parseLong(matcher2.group(1));
                    String group2 = matcher2.group(2);
                    if (bVar2 != null && bVar2.f11230c == Long.MAX_VALUE) {
                        bVar2.f11230c = parseLong2 - 1;
                    }
                    linkedList.add(new C2826b(group2, parseLong2, Long.MAX_VALUE));
                }
                sb.setLength(0);
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            z = false;
        } catch (Exception e5) {
            exc = e5;
            bufferedReader2 = null;
            exc.printStackTrace();
            if (bufferedReader2 != null) {
            }
            if (z) {
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
          //  throw th;
        }
        if (z) {
            return null;
        }
        C2827c cVar = new C2827c(str, linkedList);
        Collections.sort(cVar);
        return cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x011f A[SYNTHETIC, Splitter:B:48:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0138 A[SYNTHETIC, Splitter:B:60:0x0138] */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static C2827c m12798hh(String r18) {
        /*
            r1 = r18
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.lang.String r3 = "\\{.*\\}"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)
            r4 = 0
            r5 = 1
            r6 = 0
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0117, all -> 0x0113 }
            arc r8 = new arc     // Catch:{ Exception -> 0x0117, all -> 0x0113 }
            r8.<init>()     // Catch:{ Exception -> 0x0117, all -> 0x0113 }
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0117, all -> 0x0113 }
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0117, all -> 0x0113 }
            r10.<init>(r1)     // Catch:{ Exception -> 0x0117, all -> 0x0113 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0117, all -> 0x0113 }
            java.io.Reader r8 = r8.mo10007a(r9, r6)     // Catch:{ Exception -> 0x0117, all -> 0x0113 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0117, all -> 0x0113 }
            r8 = 0
        L_0x0029:
            java.lang.String r9 = r7.readLine()     // Catch:{ Exception -> 0x0110 }
            if (r9 == 0) goto L_0x0105
            if (r8 == 0) goto L_0x00f3
            java.lang.String r10 = "Dialogue"
            boolean r10 = r9.contains(r10)     // Catch:{ Exception -> 0x0110 }
            if (r10 == 0) goto L_0x0029
            java.lang.String r10 = ","
            r11 = 10
            java.lang.String[] r9 = r9.split(r10, r11)     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0110 }
            r10.<init>()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r11 = "0"
            r10.append(r11)     // Catch:{ Exception -> 0x0110 }
            r11 = r9[r5]     // Catch:{ Exception -> 0x0110 }
            java.lang.String r11 = r11.trim()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r12 = "\\."
            java.lang.String r13 = ","
            java.lang.String r11 = r11.replace(r12, r13)     // Catch:{ Exception -> 0x0110 }
            r10.append(r11)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r11 = "0"
            r10.append(r11)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0110 }
            long r13 = m12795e(r10)     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0110 }
            r10.<init>()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r11 = "0"
            r10.append(r11)     // Catch:{ Exception -> 0x0110 }
            r11 = 2
            r11 = r9[r11]     // Catch:{ Exception -> 0x0110 }
            java.lang.String r11 = r11.trim()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r12 = "\\."
            java.lang.String r15 = ","
            java.lang.String r11 = r11.replace(r12, r15)     // Catch:{ Exception -> 0x0110 }
            r10.append(r11)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r11 = "0"
            r10.append(r11)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0110 }
            long r15 = m12795e(r10)     // Catch:{ Exception -> 0x0110 }
            r10 = 9
            r9 = r9[r10]     // Catch:{ Exception -> 0x0110 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0110 }
            if (r10 != 0) goto L_0x00ac
            java.util.regex.Matcher r10 = r3.matcher(r9)     // Catch:{ Exception -> 0x0110 }
            boolean r11 = r10.find()     // Catch:{ Exception -> 0x0110 }
            if (r11 == 0) goto L_0x00ac
            java.lang.String r9 = ""
            java.lang.String r9 = r10.replaceAll(r9)     // Catch:{ Exception -> 0x0110 }
        L_0x00ac:
            r10 = 0
            int r12 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x00b6
            int r10 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            if (r10 == 0) goto L_0x0029
        L_0x00b6:
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0110 }
            if (r10 == 0) goto L_0x00be
            goto L_0x0029
        L_0x00be:
            java.lang.String r9 = com.inshot.xplayer.subtitle.C2845h.m12868b(r9)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r10 = "\\N"
            boolean r10 = r9.contains(r10)     // Catch:{ Exception -> 0x0110 }
            if (r10 != 0) goto L_0x00d5
            java.lang.String r10 = "\\n"
            boolean r10 = r9.contains(r10)     // Catch:{ Exception -> 0x0110 }
            if (r10 == 0) goto L_0x00d3
            goto L_0x00d5
        L_0x00d3:
            r12 = r9
            goto L_0x00e6
        L_0x00d5:
            java.lang.String r10 = "\\n"
            java.lang.String r11 = "<br/>"
            java.lang.String r9 = r9.replace(r10, r11)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r10 = "\\N"
            java.lang.String r11 = "<br/>"
            java.lang.String r9 = r9.replace(r10, r11)     // Catch:{ Exception -> 0x0110 }
            goto L_0x00d3
        L_0x00e6:
            com.inshot.xplayer.subtitle.c$b r9 = new com.inshot.xplayer.subtitle.c$b     // Catch:{ Exception -> 0x0110 }
            r17 = 0
            r11 = r9
            r11.<init>(r12, r13, r15)     // Catch:{ Exception -> 0x0110 }
            r2.add(r9)     // Catch:{ Exception -> 0x0110 }
            goto L_0x0029
        L_0x00f3:
            java.lang.String r9 = r9.trim()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r10 = "[Events]"
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x0110 }
            if (r9 == 0) goto L_0x0029
            r7.readLine()     // Catch:{ Exception -> 0x0110 }
            r8 = 1
            goto L_0x0029
        L_0x0105:
            if (r7 == 0) goto L_0x0128
            r7.close()     // Catch:{ IOException -> 0x010b }
            goto L_0x0128
        L_0x010b:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0128
        L_0x0110:
            r0 = move-exception
            r3 = r0
            goto L_0x011a
        L_0x0113:
            r0 = move-exception
            r1 = r0
            r7 = r6
            goto L_0x0136
        L_0x0117:
            r0 = move-exception
            r3 = r0
            r7 = r6
        L_0x011a:
            r3.printStackTrace()     // Catch:{ all -> 0x0134 }
            if (r7 == 0) goto L_0x0127
            r7.close()     // Catch:{ IOException -> 0x0123 }
            goto L_0x0127
        L_0x0123:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0127:
            r4 = 1
        L_0x0128:
            if (r4 == 0) goto L_0x012b
            return r6
        L_0x012b:
            com.inshot.xplayer.subtitle.c$c r3 = new com.inshot.xplayer.subtitle.c$c
            r3.<init>(r1, r2)
            java.util.Collections.sort(r3)
            return r3
        L_0x0134:
            r0 = move-exception
            r1 = r0
        L_0x0136:
            if (r7 == 0) goto L_0x0140
            r7.close()     // Catch:{ IOException -> 0x013c }
            goto L_0x0140
        L_0x013c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0140:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.subtitle.C2822c.m12798h(java.lang.String):com.inshot.xplayer.subtitle.c$c");
    }
    private static C2827c m12798h(String str) {
         BufferedReader bufferedReader;
        Throwable th;
        Exception exc;
        LinkedList linkedList = new LinkedList();
        Pattern compile = Pattern.compile("\\{.*\\}");
        boolean z = false;
        try {
            bufferedReader = new BufferedReader(new arc().mo10007a(new BufferedInputStream(new FileInputStream(str)), null));
            boolean z2 = false;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (z2) {
                        if (readLine.contains("Dialogue")) {
                            String[] split = readLine.split(",", 10);
                            long e = m12795e("0" + split[1].trim().replace("\\.", ",") + "0");
                            long e2 = m12795e("0" + split[2].trim().replace("\\.", ",") + "0");
                            String str2 = split[9];
                            if (!TextUtils.isEmpty(str2)) {
                                Matcher matcher = compile.matcher(str2);
                                if (matcher.find()) {
                                    str2 = matcher.replaceAll("");
                                }
                            }
                            if (e != 0 || e2 != 0) {
                                if (!TextUtils.isEmpty(str2)) {
                                    String b2 = C2845h.m12868b(str2);
                                    if (!b2.contains("\\N")) {
                                        if (b2.contains("\\n")) {
                                        }
                                     //   linkedList.add(new C2826b(b2, e, e2));
                                    }
                                   b2 = b2.replace("\\n", "<br/>").replace("\\N", "<br/>");
                                    linkedList.add(new C2826b(b2, e, e2));
                                }
                            }
                        }
                    } else if (readLine.trim().equals("[Events]")) {
                        bufferedReader.readLine();
                        z2 = true;
                    }
                } catch (Exception e3) {
                    exc = e3;
                    try {
                        exc.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        } catch (Exception e7) {
            exc = e7;
            bufferedReader = null;
            exc.printStackTrace();
            if (bufferedReader != null) {
            }
            z = true;
            if (z) {
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
          //  throw th;
        }
        if (z) {
            return null;
        }
        C2827c cVar = new C2827c(str, linkedList);
        Collections.sort(cVar);
        return cVar;
    }

    /* renamed from: com.inshot.xplayer.subtitle.c$c */
    public static class C2827c extends ArrayList<C2826b> {

        /* renamed from: a */
        public final String f11231a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f11232b;

        private C2827c(String str, Collection<C2826b> collection) {
            super(collection);
            this.f11231a = str;
        }
    }

    /* renamed from: com.inshot.xplayer.subtitle.c$b */
    public static class C2826b implements Comparable<C2826b> {

        /* renamed from: a */
        public final String f11228a;

        /* renamed from: b */
        final long f11229b;

        /* renamed from: c */
        long f11230c;

        private C2826b(String str, long j, long j2) {
            this.f11228a = str;
            this.f11229b = j;
            this.f11230c = j2;
        }

        /* renamed from: a */
        public int compareTo(C2826b bVar) {
            long j;
            long j2;
            if (this.f11229b != bVar.f11229b) {
                j = this.f11229b;
                j2 = bVar.f11229b;
            } else {
                j = this.f11230c;
                j2 = bVar.f11230c;
            }
            return awt.m7204b(j, j2);
        }
    }
}
