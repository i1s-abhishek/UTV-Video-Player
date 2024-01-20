package classesdef.xdplayer;

import android.util.Log;

import com.abhishek.xplayer.application.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import classesdef.ads.C4319ij;


/* renamed from: axk */
public class axk {

    /* renamed from: axk$a */
    public interface C1357a {
        /* renamed from: a */
        void mo10985a(boolean z);

        /* renamed from: b */
        void mo10986b(boolean z);
    }

    /* renamed from: a */
    public static void m7371a(final String stra, final String str2b, final Locale locale, final C1357a aVar) {
        new Thread(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
                r5 = e;
             */

            public void runn() {
                /*
                    r14 = this;
                    r0 = -1
                    r1 = 0
                    java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00b0 }
                    java.lang.String r3 = "http://dev2.period-calendar.com/appforgot.php"
                    r2.<init>(r3)     // Catch:{ IOException -> 0x00b0 }
                    java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00b0 }
                    java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00b0 }
                    r3 = 1
                    r2.setDoOutput(r3)     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    r2.setDoInput(r3)     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    r3 = 60000(0xea60, float:8.4078E-41)
                    r2.setConnectTimeout(r3)     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    r2.setReadTimeout(r3)     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    java.lang.String r3 = "POST"
                    r2.setRequestMethod(r3)     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    java.lang.String r3 = "Content-Type"
                    java.lang.String r4 = "application/x-www-form-urlencoded"
                    r2.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    java.lang.String r3 = "Charset"
                    java.lang.String r4 = "utf-8"
                    r2.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    java.lang.String r4 = r2     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    java.lang.String r5 = r3     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    java.util.Locale r6 = r4     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    java.lang.String r4 = axk.m7372b(r4, r5, r6)     // Catch:{ IOException -> 0x00a8, all -> 0x00a6 }
                    if (r4 == 0) goto L_0x009c
                    byte[] r5 = r4.getBytes()     // Catch:{ IOException -> 0x0099, all -> 0x00a6 }
                    r3.write(r5)     // Catch:{ IOException -> 0x0099, all -> 0x00a6 }
                    r3.flush()     // Catch:{ IOException -> 0x0099, all -> 0x00a6 }
                    r3.close()     // Catch:{ IOException -> 0x0099, all -> 0x00a6 }
                    int r3 = r2.getResponseCode()     // Catch:{ IOException -> 0x0099, all -> 0x00a6 }
                    r5 = 200(0xc8, float:2.8E-43)
                    if (r5 != r3) goto L_0x0096
                    java.io.InputStream r6 = r2.getInputStream()     // Catch:{ IOException -> 0x0091, all -> 0x00a6 }
                    java.lang.String r7 = "UTF-8"
                    java.lang.String r6 = axe.m7312a((java.io.InputStream) r6, (java.lang.String) r7)     // Catch:{ IOException -> 0x0091, all -> 0x00a6 }
                    if (r6 == 0) goto L_0x0097
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0086, IOException -> 0x0084, all -> 0x00a6 }
                    r1.<init>(r6)     // Catch:{ JSONException -> 0x0086, IOException -> 0x0084, all -> 0x00a6 }
                    java.lang.String r7 = "code"
                    int r1 = r1.getInt(r7)     // Catch:{ JSONException -> 0x0086, IOException -> 0x0084, all -> 0x00a6 }
                    if (r5 != r1) goto L_0x009f
                    com.inshot.xplayer.application.MyApplication r5 = com.inshot.xplayer.application.MyApplication.myApplication()     // Catch:{ JSONException -> 0x0082 }
                    axk$1$1 r7 = new axk$1$1     // Catch:{ JSONException -> 0x0082 }
                    r7.<init>()     // Catch:{ JSONException -> 0x0082 }
                    r5.runnable((java.lang.Runnable) r7)     // Catch:{ JSONException -> 0x0082 }
                    if (r2 == 0) goto L_0x0081
                    r2.disconnect()     // Catch:{ Exception -> 0x0081 }
                L_0x0081:
                    return
                L_0x0082:
                    r5 = move-exception
                    goto L_0x0088
                L_0x0084:
                    r5 = move-exception
                    goto L_0x0093
                L_0x0086:
                    r5 = move-exception
                    r1 = -1
                L_0x0088:
                    r5.printStackTrace()     // Catch:{ IOException -> 0x008c, all -> 0x00a6 }
                    goto L_0x009f
                L_0x008c:
                    r5 = move-exception
                    r13 = r2
                    r2 = r1
                    r1 = r13
                    goto L_0x00b5
                L_0x0091:
                    r5 = move-exception
                    r6 = r1
                L_0x0093:
                    r1 = r2
                    r2 = -1
                    goto L_0x00b5
                L_0x0096:
                    r6 = r1
                L_0x0097:
                    r1 = -1
                    goto L_0x009f
                L_0x0099:
                    r5 = move-exception
                    r6 = r1
                    goto L_0x00ab
                L_0x009c:
                    r6 = r1
                    r1 = -1
                    r3 = -1
                L_0x009f:
                    if (r2 == 0) goto L_0x00a4
                    r2.disconnect()     // Catch:{ Exception -> 0x00a4 }
                L_0x00a4:
                    r10 = r1
                    goto L_0x00be
                L_0x00a6:
                    r0 = move-exception
                    goto L_0x00f5
                L_0x00a8:
                    r5 = move-exception
                    r4 = r1
                    r6 = r4
                L_0x00ab:
                    r1 = r2
                    goto L_0x00b3
                L_0x00ad:
                    r0 = move-exception
                    r2 = r1
                    goto L_0x00f5
                L_0x00b0:
                    r5 = move-exception
                    r4 = r1
                    r6 = r4
                L_0x00b3:
                    r2 = -1
                    r3 = -1
                L_0x00b5:
                    r5.printStackTrace()     // Catch:{ all -> 0x00ad }
                    if (r1 == 0) goto L_0x00bd
                    r1.disconnect()     // Catch:{ Exception -> 0x00bd }
                L_0x00bd:
                    r10 = r2
                L_0x00be:
                    r11 = r3
                    r9 = r4
                    r8 = r6
                    r1 = 103(0x67, float:1.44E-43)
                    if (r10 != r1) goto L_0x00d2
                    com.inshot.xplayer.application.MyApplication r0 = com.inshot.xplayer.application.MyApplication.myApplication()
                    axk$1$2 r1 = new axk$1$2
                    r1.<init>()
                    r0.runnable((java.lang.Runnable) r1)
                    goto L_0x00f4
                L_0x00d2:
                    if (r10 != r0) goto L_0x00e6
                    r0 = 500(0x1f4, float:7.0E-43)
                    if (r11 != r0) goto L_0x00d9
                    goto L_0x00e6
                L_0x00d9:
                    com.inshot.xplayer.application.MyApplication r0 = com.inshot.xplayer.application.MyApplication.myApplication()
                    axk$1$3 r1 = new axk$1$3
                    r1.<init>()
                    r0.runnable((java.lang.Runnable) r1)
                    goto L_0x00f4
                L_0x00e6:
                    java.lang.String r0 = "retrievePin"
                    java.lang.String r1 = "ServerAPI2"
                    ayb.m18496c(r0, r1)
                    java.lang.String r7 = r2
                    axk$a r12 = r5
                    axk.m7373b(r7, r8, r9, r10, r11, r12)
                L_0x00f4:
                    return
                L_0x00f5:
                    if (r2 == 0) goto L_0x00fa
                    r2.disconnect()     // Catch:{ Exception -> 0x00fa }
                L_0x00fa:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: axk.C13501.run():void");
            }


            public void run() {
                int i = 0;
                String str = null;
                String str2= null;
                int i2 = 0;
                IOException e;
                int i3;
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("http://dev2.period-calendar.com/appforgot.php").openConnection();
                    try {
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setDoInput(true);
                        httpURLConnection2.setConnectTimeout(60000);
                        httpURLConnection2.setReadTimeout(60000);
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection2.setRequestProperty("Charset", "utf-8");
                        OutputStream outputStream = httpURLConnection2.getOutputStream();
                        str2 = axk.m7372b(stra, str2b, locale);
                        if (str2 != null) {
                            outputStream.write(str2.getBytes());
                            outputStream.flush();
                            outputStream.close();
                            i2 = httpURLConnection2.getResponseCode();
                            if (200 == i2) {
                                str = axe.m7312a(httpURLConnection2.getInputStream(), "UTF-8");
                                if (str != null) {
                                    i3 = new JSONObject(str).getInt("code");
                                    if (200 == i3) {
                                        MyApplication.myApplication().runnable(new Runnable() {
                                            /* class defpackage.axk.AnonymousClass1.AnonymousClass1 */

                                            public void run() {
                                                aVar.mo10985a(true);
                                            }
                                        });
                                        if (httpURLConnection2 != null) {
                                            try {
                                                httpURLConnection2.disconnect();
                                                return;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            } else {
                                str = null;
                            }
                            i3 = -1;
                        } else {
                            str = null;
                            i3 = -1;
                            i2 = -1;
                        }
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        i = i3;
                    } catch (IOException e4) {
                        e = e4;
                        str = null;
                        httpURLConnection = httpURLConnection2;
                        int i4 = -1;
                        i2 = -1;
                        try {
                            e.printStackTrace();
                            if (httpURLConnection != null) {
                            }
                            i = i4;
                            if (i != 103) {
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            httpURLConnection2 = httpURLConnection;
                            if (httpURLConnection2 != null) {
                            }
                            //throw th2;
                        }
                    } catch (Throwable th3) {
                    }
                } catch (IOException e5) {
                    e = e5;
                    str2 = null;
                    str = null;
                    int i42 = -1;
                    i2 = -1;
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                    }
                    i = i42;
                    if (i != 103) {
                    }
                }
                if (i != 103) {
                    MyApplication.myApplication().runnable(new Runnable() {
                        /* class defpackage.axk.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            aVar.mo10986b(false);
                        }
                    });
                } else if (i != -1 || i2 == 500) {
                    LogEvents.m18496c("retrievePin", "ServerAPI2");
                    axk.m7373b(stra, str, str2, i, i2, aVar);
                } else {
                    MyApplication.myApplication().runnable(new Runnable() {
                        /* class defpackage.axk.AnonymousClass1.AnonymousClass3 */

                        public void run() {
                            aVar.mo10986b(true);
                        }
                    });
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0081, code lost:
        r4 = e;
     */

    public static void m7373bb(String r3, String r4, String r5, int r6, int r7, final axk.C1357a r8) {
        /*
            r5 = -1
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x009f }
            java.lang.String r2 = "http://api.mobihealthplus.com/mail/log"
            r1.<init>(r2)     // Catch:{ IOException -> 0x009f }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x009f }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x009f }
            r0 = 1
            r1.setDoOutput(r0)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r1.setDoInput(r0)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r0 = 60000(0xea60, float:8.4078E-41)
            r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            java.lang.String r0 = "POST"
            r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r2 = "application/x-www-form-urlencoded"
            r1.setRequestProperty(r0, r2)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            java.lang.String r0 = "Charset"
            java.lang.String r2 = "utf-8"
            r1.setRequestProperty(r0, r2)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            java.io.OutputStream r0 = r1.getOutputStream()     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            java.lang.String r2 = "{\"data\":\"sdfasdfasdfadsf\"}"
            java.lang.String r3 = m7367a(r3, r4, r2, r6, r7)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            java.lang.String r4 = "XPlayerPassword"
            android.util.Log.d(r4, r3)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            byte[] r3 = r3.getBytes()     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r0.write(r3)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r0.flush()     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r0.close()     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            int r3 = r1.getResponseCode()     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r4 != r3) goto L_0x0091
            java.io.InputStream r7 = r1.getInputStream()     // Catch:{ IOException -> 0x008e, all -> 0x0097 }
            java.lang.String r0 = "UTF-8"
            java.lang.String r7 = axe.m7312a((java.io.InputStream) r7, (java.lang.String) r0)     // Catch:{ IOException -> 0x008e, all -> 0x0097 }
            if (r7 == 0) goto L_0x0091
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0089 }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x0089 }
            java.lang.String r7 = "code"
            int r7 = r0.getInt(r7)     // Catch:{ JSONException -> 0x0089 }
            if (r4 != r7) goto L_0x0087
            com.inshot.xplayer.application.MyApplication r4 = com.inshot.xplayer.application.MyApplication.myApplication()     // Catch:{ JSONException -> 0x0084, IOException -> 0x0081, all -> 0x0097 }
            axk$2 r6 = new axk$2     // Catch:{ JSONException -> 0x0084, IOException -> 0x0081, all -> 0x0097 }
            r6.<init>(r8)     // Catch:{ JSONException -> 0x0084, IOException -> 0x0081, all -> 0x0097 }
            r4.runnable((java.lang.Runnable) r6)     // Catch:{ JSONException -> 0x0084, IOException -> 0x0081, all -> 0x0097 }
            if (r1 == 0) goto L_0x0080
            r1.disconnect()     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            return
        L_0x0081:
            r4 = move-exception
            r6 = r7
            goto L_0x008f
        L_0x0084:
            r4 = move-exception
            r6 = r7
            goto L_0x008a
        L_0x0087:
            r6 = r7
            goto L_0x0091
        L_0x0089:
            r4 = move-exception
        L_0x008a:
            r4.printStackTrace()     // Catch:{ IOException -> 0x008e, all -> 0x0097 }
            goto L_0x0091
        L_0x008e:
            r4 = move-exception
        L_0x008f:
            r0 = r1
            goto L_0x00a1
        L_0x0091:
            if (r1 == 0) goto L_0x00a9
            r1.disconnect()     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00a9
        L_0x0097:
            r3 = move-exception
            goto L_0x00ca
        L_0x0099:
            r4 = move-exception
            r0 = r1
            goto L_0x00a0
        L_0x009c:
            r3 = move-exception
            r1 = r0
            goto L_0x00ca
        L_0x009f:
            r4 = move-exception
        L_0x00a0:
            r3 = -1
        L_0x00a1:
            r4.printStackTrace()     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x00a9
            r0.disconnect()     // Catch:{ Exception -> 0x00a9 }
        L_0x00a9:
            if (r6 != r5) goto L_0x00bd
            r4 = 500(0x1f4, float:7.0E-43)
            if (r3 != r4) goto L_0x00b0
            goto L_0x00bd
        L_0x00b0:
            com.inshot.xplayer.application.MyApplication r3 = com.inshot.xplayer.application.MyApplication.myApplication()
            axk$4 r4 = new axk$4
            r4.<init>(r8)
            r3.runnable((java.lang.Runnable) r4)
            goto L_0x00c9
        L_0x00bd:
            com.inshot.xplayer.application.MyApplication r3 = com.inshot.xplayer.application.MyApplication.myApplication()
            axk$3 r4 = new axk$3
            r4.<init>(r8)
            r3.runnable((java.lang.Runnable) r4)
        L_0x00c9:
            return
        L_0x00ca:
            if (r1 == 0) goto L_0x00cf
            r1.disconnect()     // Catch:{ Exception -> 0x00cf }
        L_0x00cf:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: axk.m7373b(java.lang.String, java.lang.String, java.lang.String, int, int, axk$a):void");
    }
    public static void m7373b(String str, String str2, String str3, int i, int i2, final axk.C1357a aVar) {
        int i3 = 0;
        IOException e;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("http://api.mobihealthplus.com/mail/log").openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.setReadTimeout(60000);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection2.setRequestProperty("Charset", "utf-8");
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                String a2 = m7367a(str, str2, "{\"data\":\"sdfasdfasdfadsf\"}", i, i2);
                Log.d("XPlayerPassword", a2);
                outputStream.write(a2.getBytes());
                outputStream.flush();
                outputStream.close();
                i3 = httpURLConnection2.getResponseCode();
                if (200 == i3) {
                    String a3 = axe.m7312a(httpURLConnection2.getInputStream(), "UTF-8");
                    if (a3 != null) {
                        try {
                            int i4 = new JSONObject(a3).getInt("code");
                            if (200 == i4) {
                                MyApplication.myApplication().runnable(new Runnable() {
                                    /* class defpackage.axk.AnonymousClass2 */

                                    public void run() {
                                        aVar.mo10985a(true);
                                    }
                                });
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                        return;
                                    } catch (Exception unused) {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                i = i4;
                            }
                        } catch (JSONException e2) {
                            JSONException e3 = e2;
                            e3.printStackTrace();
                            if (httpURLConnection2 != null) {
                            }
                            if (i == -1) {
                            }
                            MyApplication.myApplication().runnable(new Runnable() {
                                /* class defpackage.axk.AnonymousClass3 */

                                public void run() {
                                    aVar.mo10986b(false);
                                }
                            });
                        }
                    }
                }
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused2) {
                    }
                }
            } catch (IOException e4) {
                e = e4;
                httpURLConnection = httpURLConnection2;
                i3 = -1;
                try {
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                    }
                    if (i == -1) {
                    }
                    MyApplication.myApplication().runnable(new Runnable() {
                        /* class defpackage.axk.AnonymousClass3 */

                        public void run() {
                            aVar.mo10986b(false);
                        }
                    });
                } catch (Throwable th) {
                    Throwable th2 = th;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                    }
                  //  throw th2;
                }
            } catch (Throwable th3) {
            }
        } catch (IOException ce) {
            e = ce;
            i3 = -1;
            e.printStackTrace();
            if (httpURLConnection != null) {
            }
            if (i == -1) {
            }
            MyApplication.myApplication().runnable(new Runnable() {
                /* class defpackage.axk.AnonymousClass3 */

                public void run() {
                    aVar.mo10986b(false);
                }
            });
        }
        if (i == -1 || i3 == 500) {
            MyApplication.myApplication().runnable(new Runnable() {
                /* class defpackage.axk.AnonymousClass3 */

                public void run() {
                    aVar.mo10986b(false);
                }
            });
        } else {
            MyApplication.myApplication().runnable(new Runnable() {
                /* class defpackage.axk.AnonymousClass4 */

                public void run() {
                    aVar.mo10986b(true);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m7372b(String str, String str2, Locale locale) {
        StringBuilder sb = new StringBuilder();
        sb.append("lang=");
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (language != null && !language.equals("")) {
            sb.append(language);
            if (country != null && !country.equals("")) {
                sb.append("-");
                sb.append(country);
            }
        }
        sb.append("&to=");
        sb.append(URLEncoder.encode(str));
        sb.append("&data=");
        String a = m7366a("email=" + str, str2);
        if (a == null) {
            return null;
        }
        sb.append(a);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m7366a(String str, String str2) {
        byte[] b;
        String a = new C4319ij().mo23983a(str);
        if (a == null || a.equals("") || a.length() < 16 || (b = m7374b(a.substring(0, 16), str2)) == null) {
            return null;
        }
        return m7369a(b);
    }

    /* renamed from: a */
    private static String m7367a(String str, String str2, String str3, int i, int i2) {
        return "maitype=1&fromapp=1&result=2&mailfromuser=" + URLEncoder.encode("XPlayer") + "&mailtouser=" + URLEncoder.encode(str) + "&subject=" + URLEncoder.encode("Password httpCode:" + i2) + "&content=" + URLEncoder.encode(str3) + "&reason=" + URLEncoder.encode(str2);
    }

    /* renamed from: b */
    private static byte[] m7374b(String str, String str2) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            byte[] bytes = m7365a(m7369a(str2.getBytes("UTF-8"))).getBytes("UTF-8");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "AES"), new IvParameterSpec(str.getBytes("UTF-8")));
            return instance.doFinal(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m7365a(String str) {
        int length = 16 - (str.length() % 16);
        String str2 = str;
        for (int i = 0; i < length; i++) {
            str2 = str2 + 0;
        }
        return str2;
    }

    /* renamed from: a */
    private static String m7369a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            cArr2[i2] = cArr[(bArr[i] & 240) >>> 4];
            cArr2[i2 + 1] = cArr[bArr[i] & 15];
        }
        return new String(cArr2);
    }
}
