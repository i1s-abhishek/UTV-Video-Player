package com.cc.promote.service;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;

import com.mopub.common.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Locale;

import classesdef.xdplayer.ServerConfigSharedPrefrence;

/* renamed from: if */
public class C4315if {

    /* renamed from: a */
    private String[] f16942a = {"loc", "tzo", "lan", "suc", "ron", "ven", "pve", "apm", "density"};

    /* renamed from: b */
    private final String f16943b = "app_name";

    /* renamed from: c */
    private Context f16944c;

    public C4315if(Context context) {
        this.f16944c = context;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
      public String mo23981aa() {
        /*
            r10 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x010f, Error -> 0x00f5, all -> 0x00f1 }
            android.content.Context r3 = r10.f16944c     // Catch:{ Exception -> 0x010f, Error -> 0x00f5, all -> 0x00f1 }
            java.lang.String r3 = p000.C4293hn.m19711b(r3)     // Catch:{ Exception -> 0x010f, Error -> 0x00f5, all -> 0x00f1 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x010f, Error -> 0x00f5, all -> 0x00f1 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x010f, Error -> 0x00f5, all -> 0x00f1 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x010f, Error -> 0x00f5, all -> 0x00f1 }
            r3 = 1
            r2.setDoOutput(r3)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            r2.setDoInput(r3)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            r3 = 10000(0x2710, float:1.4013E-41)
            r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            java.lang.String r3 = "POST"
            r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/x-www-form-urlencoded"
            r2.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            java.lang.String r3 = "Charset"
            java.lang.String r4 = "utf-8"
            r2.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            android.content.Context r3 = r10.f16944c     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            r4.<init>()     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            int r5 = r3.widthPixels     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            r4.append(r5)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            java.lang.String r5 = "X"
            r4.append(r5)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            int r3 = r3.heightPixels     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            r4.append(r3)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            android.content.Context r4 = r10.f16944c     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            android.content.Context r5 = r10.f16944c     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            r6 = 0
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r6)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            int r4 = r4.versionCode     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            java.lang.String r3 = r10.m19806a(r6, r3, r4)     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            if (r3 == 0) goto L_0x00cb
            java.io.OutputStream r4 = r2.getOutputStream()     // Catch:{ Exception -> 0x00ed, Error -> 0x00e9, all -> 0x00e6 }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x00c5, Error -> 0x00bf, all -> 0x00ba }
            r4.write(r3)     // Catch:{ Exception -> 0x00c5, Error -> 0x00bf, all -> 0x00ba }
            int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x00c5, Error -> 0x00bf, all -> 0x00ba }
            r5 = 200(0xc8, float:2.8E-43)
            if (r5 != r3) goto L_0x00cc
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00c5, Error -> 0x00bf, all -> 0x00ba }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x00c5, Error -> 0x00bf, all -> 0x00ba }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00c5, Error -> 0x00bf, all -> 0x00ba }
            r1 = 8192(0x2000, float:1.14794E-41)
            char[] r1 = new char[r1]     // Catch:{ Exception -> 0x00b2, Error -> 0x00aa, all -> 0x00a8 }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x00b2, Error -> 0x00aa, all -> 0x00a8 }
            r5.<init>()     // Catch:{ Exception -> 0x00b2, Error -> 0x00aa, all -> 0x00a8 }
        L_0x0096:
            int r7 = r3.read(r1)     // Catch:{ Exception -> 0x00b2, Error -> 0x00aa, all -> 0x00a8 }
            r8 = -1
            if (r7 == r8) goto L_0x00a1
            r5.append(r1, r6, r7)     // Catch:{ Exception -> 0x00b2, Error -> 0x00aa, all -> 0x00a8 }
            goto L_0x0096
        L_0x00a1:
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x00b2, Error -> 0x00aa, all -> 0x00a8 }
            r0 = r1
            r1 = r3
            goto L_0x00cc
        L_0x00a8:
            r0 = move-exception
            goto L_0x00bc
        L_0x00aa:
            r1 = move-exception
            r9 = r3
            r3 = r1
            r1 = r4
            r4 = r2
            r2 = r9
            goto L_0x00f9
        L_0x00b2:
            r1 = move-exception
            r9 = r3
            r3 = r1
            r1 = r4
            r4 = r2
            r2 = r9
            goto L_0x0113
        L_0x00ba:
            r0 = move-exception
            r3 = r1
        L_0x00bc:
            r1 = r4
            goto L_0x012c
        L_0x00bf:
            r3 = move-exception
            r9 = r2
            r2 = r1
            r1 = r4
            r4 = r9
            goto L_0x00f9
        L_0x00c5:
            r3 = move-exception
            r9 = r2
            r2 = r1
            r1 = r4
            r4 = r9
            goto L_0x0113
        L_0x00cb:
            r4 = r1
        L_0x00cc:
            if (r4 == 0) goto L_0x00d7
            r4.flush()     // Catch:{ IOException -> 0x00d5 }
            r4.close()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x00d7
        L_0x00d5:
            r1 = move-exception
            goto L_0x00e2
        L_0x00d7:
            if (r1 == 0) goto L_0x00dc
            r1.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00dc:
            if (r2 == 0) goto L_0x0128
            r2.disconnect()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x0128
        L_0x00e2:
            r1.printStackTrace()
            goto L_0x0128
        L_0x00e6:
            r0 = move-exception
            r3 = r1
            goto L_0x012c
        L_0x00e9:
            r3 = move-exception
            r4 = r2
            r2 = r1
            goto L_0x00f9
        L_0x00ed:
            r3 = move-exception
            r4 = r2
            r2 = r1
            goto L_0x0113
        L_0x00f1:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x012c
        L_0x00f5:
            r2 = move-exception
            r4 = r1
            r3 = r2
            r2 = r4
        L_0x00f9:
            r3.printStackTrace()     // Catch:{ all -> 0x0129 }
            if (r1 == 0) goto L_0x0104
            r1.flush()     // Catch:{ IOException -> 0x00d5 }
            r1.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x0104:
            if (r2 == 0) goto L_0x0109
            r2.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x0109:
            if (r4 == 0) goto L_0x0128
            r4.disconnect()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x0128
        L_0x010f:
            r2 = move-exception
            r4 = r1
            r3 = r2
            r2 = r4
        L_0x0113:
            r3.printStackTrace()     // Catch:{ all -> 0x0129 }
            if (r1 == 0) goto L_0x011e
            r1.flush()     // Catch:{ IOException -> 0x00d5 }
            r1.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x011e:
            if (r2 == 0) goto L_0x0123
            r2.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x0123:
            if (r4 == 0) goto L_0x0128
            r4.disconnect()     // Catch:{ IOException -> 0x00d5 }
        L_0x0128:
            return r0
        L_0x0129:
            r0 = move-exception
            r3 = r2
            r2 = r4
        L_0x012c:
            if (r1 == 0) goto L_0x0137
            r1.flush()     // Catch:{ IOException -> 0x0135 }
            r1.close()     // Catch:{ IOException -> 0x0135 }
            goto L_0x0137
        L_0x0135:
            r1 = move-exception
            goto L_0x0142
        L_0x0137:
            if (r3 == 0) goto L_0x013c
            r3.close()     // Catch:{ IOException -> 0x0135 }
        L_0x013c:
            if (r2 == 0) goto L_0x0145
            r2.disconnect()     // Catch:{ IOException -> 0x0135 }
            goto L_0x0145
        L_0x0142:
            r1.printStackTrace()
        L_0x0145:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C4315if.mo23981a():java.lang.String");
    }
    public String mo23981a() {
        InputStreamReader inputStreamReader;
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        Exception e;
        InputStreamReader inputStreamReader2;
        HttpURLConnection httpURLConnection3;
        Error e2;
        InputStreamReader inputStreamReader3;
        OutputStream outputStream;
        String str = "";
        OutputStream outputStream2 = null;
       // r1 = null;
        InputStreamReader inputStreamReader4 = null;
       // r1 = null;
     //   r1 = null;
        outputStream2 = null;
       // r1 = null;
        OutputStream outputStream3 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(ServerConfigSharedPrefrence.m19711b(this.f16944c)).openConnection();
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(Constants.TEN_SECONDS_MILLIS);
                httpURLConnection.setReadTimeout(Constants.TEN_SECONDS_MILLIS);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Charset", "utf-8");
                DisplayMetrics displayMetrics = this.f16944c.getResources().getDisplayMetrics();
                String a2 = m19806a(0, displayMetrics.widthPixels + "X" + displayMetrics.heightPixels, this.f16944c.getPackageManager().getPackageInfo(this.f16944c.getPackageName(), 0).versionCode);
                if (a2 != null) {
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(a2.getBytes());
                        if (200 == httpURLConnection.getResponseCode()) {
                            inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                            try {
                                char[] cArr = new char[8192];
                                StringBuffer stringBuffer = new StringBuffer();
                                while (true) {
                                    int read = inputStreamReader.read(cArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    stringBuffer.append(cArr, 0, read);
                                }
                                str = stringBuffer.toString();
                                inputStreamReader4 = inputStreamReader;
                            } catch (Exception e3) {
                                e = e3;
                                outputStream2 = outputStream;
                                httpURLConnection2 = httpURLConnection;
                                inputStreamReader2 = inputStreamReader;
                                e.printStackTrace();
                                if (outputStream2 != null) {
                                    outputStream2.flush();
                                    outputStream2.close();
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return str;
                            } catch (Error e4) {
                                e2 = e4;
                                outputStream3 = outputStream;
                                httpURLConnection3 = httpURLConnection;
                                inputStreamReader3 = inputStreamReader;
                                try {
                                    e2.printStackTrace();
                                    if (outputStream3 != null) {
                                        outputStream3.flush();
                                        outputStream3.close();
                                    }
                                    if (inputStreamReader3 != null) {
                                        inputStreamReader3.close();
                                    }
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                    return str;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStreamReader = inputStreamReader3;
                                    httpURLConnection = httpURLConnection3;
                                    if (outputStream3 != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream3 = outputStream;
                                if (outputStream3 != null) {
                                    try {
                                        outputStream3.flush();
                                        outputStream3.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        inputStreamReader2 = null;
                        outputStream2 = outputStream;
                        httpURLConnection2 = httpURLConnection;
                        e.printStackTrace();
                        if (outputStream2 != null) {
                        }
                        if (inputStreamReader2 != null) {
                        }
                        if (httpURLConnection2 != null) {
                        }
                        return str;
                    } catch (Error e7) {
                        e2 = e7;
                        inputStreamReader3 = null;
                        outputStream3 = outputStream;
                        httpURLConnection3 = httpURLConnection;
                        e2.printStackTrace();
                        if (outputStream3 != null) {
                        }
                        if (inputStreamReader3 != null) {
                        }
                        if (httpURLConnection3 != null) {
                        }
                        return str;
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = null;
                        outputStream3 = outputStream;
                        if (outputStream3 != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (inputStreamReader4 != null) {
                    inputStreamReader4.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception e9) {
                e = e9;
                httpURLConnection2 = httpURLConnection;
                inputStreamReader2 = null;
                e.printStackTrace();
                if (outputStream2 != null) {
                }
                if (inputStreamReader2 != null) {
                }
                if (httpURLConnection2 != null) {
                }
                return str;
            } catch (Error e10) {
                e2 = e10;
                httpURLConnection3 = httpURLConnection;
                inputStreamReader3 = null;
                e2.printStackTrace();
                if (outputStream3 != null) {
                }
                if (inputStreamReader3 != null) {
                }
                if (httpURLConnection3 != null) {
                }
                return str;
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
                if (outputStream3 != null) {
                }
                if (inputStreamReader != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (Exception e11) {
            httpURLConnection2 = null;
            e = e11;
            inputStreamReader2 = null;
            e.printStackTrace();
            if (outputStream2 != null) {
            }
            if (inputStreamReader2 != null) {
            }
            if (httpURLConnection2 != null) {
            }
            return str;
        } catch (Error e12) {
            httpURLConnection3 = null;
            e2 = e12;
            inputStreamReader3 = null;
            e2.printStackTrace();
            if (outputStream3 != null) {
            }
            if (inputStreamReader3 != null) {
            }
            if (httpURLConnection3 != null) {
            }
            return str;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            inputStreamReader = null;
            if (outputStream3 != null) {
            }
            if (inputStreamReader != null) {
            }
            if (httpURLConnection != null) {
            }
            //throw th;
        }
        return str;
    }

    /* renamed from: a */
    private String m19806a(int i, String str, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(this.f16942a[0], Locale.getDefault().getCountry());
            String format = new SimpleDateFormat("Z", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis()));
            if (format.startsWith("-")) {
                format = format.replace("-", "n");
            } else if (format.startsWith("+")) {
                format = format.replace("+", "p");
            }
            jSONObject.put(this.f16942a[1], format);
            jSONObject.put(this.f16942a[2], Locale.getDefault().getLanguage());
            jSONObject.put(this.f16942a[3], i);
            jSONObject.put(this.f16942a[4], str);
            jSONObject.put(this.f16942a[5], i2);
            jSONObject.put(this.f16942a[6], Build.VERSION.SDK_INT);
            jSONObject.put(this.f16942a[7], "app_name");
            jSONObject.put(this.f16942a[8], (double) this.f16944c.getResources().getDisplayMetrics().density);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("version=2");
        stringBuffer.append("&data=");
        stringBuffer.append(jSONObject2);
        return stringBuffer.toString();
    }
}
