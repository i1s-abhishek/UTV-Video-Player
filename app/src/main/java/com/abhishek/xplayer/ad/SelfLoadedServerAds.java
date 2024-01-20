package com.abhishek.xplayer.ad;

import android.content.Context;

import com.cc.promote.service.C4315if;
import com.cc.promote.service.C4320ik;
import com.cc.promote.service.C4321il;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import classesdef.ads.C4319ij;
import classesdef.xdplayer.ServerConfigSharedPrefrence;

/* renamed from: com.inshot.xplayer.ad.s */
public class SelfLoadedServerAds {
    /* renamed from: a */
    public static void m10398a(Context context, String str, String str2) {
        ServerConfigSharedPrefrence.m19709a(context, str);
        ServerConfigSharedPrefrence.m19713b(context, str2);
        if (System.currentTimeMillis() - ServerConfigSharedPrefrence.m19729i(context) > 0) {
            m10399b(context);
        }
    }

    /* renamed from: b */
    private static void m10399b(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (C4321il.m19820a(context)) {
                        ServerConfigSharedPrefrence.m19727h(context);
                        String a = new C4315if(context).mo23981a();
                        if (a.equals("")) {
                            return;
                        }
                        if (!a.equals("[]")) {
                            JSONObject jSONObject = new JSONObject(a);
                            int optInt = jSONObject.optInt("version");
                            if (optInt >= ServerConfigSharedPrefrence.m19723f(context)) {
                                ServerConfigSharedPrefrence.m19712b(context, optInt);
                                ServerConfigSharedPrefrence.m19716c(context, jSONObject.optInt("update_interval", 5));
                                ServerConfigSharedPrefrence.PutSelfAds(context, jSONObject.optString("self_ads", ""));
                                if (new C4320ik().mo23985a(ServerConfigSharedPrefrence.m19715c(context)) > 20.0f) {
                                    SelfLoadedServerAds.m10400c(context);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Error e2) {
                    e2.printStackTrace();
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m10400c(Context context)throws JSONException {
        File file = new File(ServerConfigSharedPrefrence.m19715c(context));
        if (!file.exists()) {
            file.mkdirs();
        }
        String j = ServerConfigSharedPrefrence.GetSelfAds(context);
        if (j != null && !j.equals("")) {
            JSONArray jSONArray = new JSONArray(j);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("app_icon", "");
                String optString2 = jSONObject.optString("app_cover", "");
                String optString3 = jSONObject.optString("package", "");
                boolean z = true;
                try {
                    if (!optString3.equals("") && !optString.equals("")) {
                        String a = new C4319ij().mo23983a(optString);
                        File file2 = new File(ServerConfigSharedPrefrence.m19715c(context) + "/" + a);
                        if (!file2.exists() ? m10396a(optString, file2) != null : true) {
                            jSONObject.put("app_icon", file2.getAbsolutePath());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if (!optString3.equals("") && !optString2.equals("")) {
                        String a2 = new C4319ij().mo23983a(optString2);
                        File file3 = new File(ServerConfigSharedPrefrence.m19715c(context) + "/" + a2);
                        if (!file3.exists()) {
                            if (m10396a(optString2, file3) == null) {
                                z = false;
                            }
                        }
                        if (z) {
                            jSONObject.put("app_cover", file3.getAbsolutePath());
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            ServerConfigSharedPrefrence.PutSelfAds(context, jSONArray.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0088 A[SYNTHETIC, Splitter:B:43:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0096 A[Catch:{ IOException -> 0x008c, all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009e A[SYNTHETIC, Splitter:B:53:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a3 A[Catch:{ IOException -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ac A[SYNTHETIC, Splitter:B:60:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ba A[Catch:{ IOException -> 0x008c, all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c2 A[SYNTHETIC, Splitter:B:70:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ca A[Catch:{ IOException -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00d6 A[SYNTHETIC, Splitter:B:81:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00de A[Catch:{ IOException -> 0x00da }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String m10396aa(String r7, File r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            r1.<init>(r7)     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            r1 = 30000(0x7530, float:4.2039E-41)
            r7.setConnectTimeout(r1)     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            r7.setReadTimeout(r1)     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            java.lang.String r1 = "GET"
            r7.setRequestMethod(r1)     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            int r1 = r7.getResponseCode()     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x00d1
            boolean r1 = r8.exists()     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            if (r1 == 0) goto L_0x0031
            long r1 = r8.length()     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0034
        L_0x0031:
            r8.createNewFile()     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
        L_0x0034:
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Error -> 0x00a7, Exception -> 0x0083, all -> 0x0080 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Error -> 0x007b, Exception -> 0x0076, all -> 0x0071 }
            r1.<init>(r8)     // Catch:{ Error -> 0x007b, Exception -> 0x0076, all -> 0x0071 }
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = new byte[r2]     // Catch:{ Error -> 0x006c, Exception -> 0x0067, all -> 0x0062 }
        L_0x0041:
            int r3 = r7.read(r2)     // Catch:{ Error -> 0x006c, Exception -> 0x0067, all -> 0x0062 }
            r4 = -1
            if (r3 == r4) goto L_0x004d
            r4 = 0
            r1.write(r2, r4, r3)     // Catch:{ Error -> 0x006c, Exception -> 0x0067, all -> 0x0062 }
            goto L_0x0041
        L_0x004d:
            r1.flush()     // Catch:{ Error -> 0x006c, Exception -> 0x0067, all -> 0x0062 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ Error -> 0x006c, Exception -> 0x0067, all -> 0x0062 }
            r1.close()     // Catch:{ IOException -> 0x005d }
            if (r7 == 0) goto L_0x0061
            r7.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0061:
            return r8
        L_0x0062:
            r8 = move-exception
            r2 = r7
            r7 = r8
            goto L_0x00d3
        L_0x0067:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
            goto L_0x0086
        L_0x006c:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
            goto L_0x00aa
        L_0x0071:
            r8 = move-exception
            r2 = r7
            r7 = r8
            goto L_0x00d4
        L_0x0076:
            r1 = move-exception
            r2 = r7
            r7 = r1
            r1 = r0
            goto L_0x0086
        L_0x007b:
            r1 = move-exception
            r2 = r7
            r7 = r1
            r1 = r0
            goto L_0x00aa
        L_0x0080:
            r7 = move-exception
            r2 = r0
            goto L_0x00d4
        L_0x0083:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L_0x0086:
            if (r1 == 0) goto L_0x0090
            r1.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00d2 }
        L_0x0090:
            boolean r3 = r8.exists()     // Catch:{ all -> 0x00d2 }
            if (r3 == 0) goto L_0x0099
            r8.delete()     // Catch:{ all -> 0x00d2 }
        L_0x0099:
            r7.printStackTrace()     // Catch:{ all -> 0x00d2 }
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ IOException -> 0x00c6 }
        L_0x00a1:
            if (r2 == 0) goto L_0x00d1
            r2.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00d1
        L_0x00a7:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L_0x00aa:
            if (r1 == 0) goto L_0x00b4
            r1.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00b4
        L_0x00b0:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00d2 }
        L_0x00b4:
            boolean r3 = r8.exists()     // Catch:{ all -> 0x00d2 }
            if (r3 == 0) goto L_0x00bd
            r8.delete()     // Catch:{ all -> 0x00d2 }
        L_0x00bd:
            r7.printStackTrace()     // Catch:{ all -> 0x00d2 }
            if (r1 == 0) goto L_0x00c8
            r1.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00c8
        L_0x00c6:
            r7 = move-exception
            goto L_0x00ce
        L_0x00c8:
            if (r2 == 0) goto L_0x00d1
            r2.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00d1
        L_0x00ce:
            r7.printStackTrace()
        L_0x00d1:
            return r0
        L_0x00d2:
            r7 = move-exception
        L_0x00d3:
            r0 = r1
        L_0x00d4:
            if (r0 == 0) goto L_0x00dc
            r0.close()     // Catch:{ IOException -> 0x00da }
            goto L_0x00dc
        L_0x00da:
            r8 = move-exception
            goto L_0x00e2
        L_0x00dc:
            if (r2 == 0) goto L_0x00e5
            r2.close()     // Catch:{ IOException -> 0x00da }
            goto L_0x00e5
        L_0x00e2:
            r8.printStackTrace()
        L_0x00e5:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.p005ad.C2263s.m10396a(java.lang.String, java.io.File):java.lang.String");
    }
    private static String m10396a(String str, File file) {
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Error e;
        InputStream inputStream2;
        Exception e2;
        FileOutputStream fileOutputStream2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() == 200) {
                if (!file.exists() || file.length() == 0) {
                    file.createNewFile();
                }
                InputStream inputStream3 = httpURLConnection.getInputStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream3.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        String absolutePath = file.getAbsolutePath();
                        try {
                            fileOutputStream.close();
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return absolutePath;
                    } catch (Error e4) {
                        inputStream2 = inputStream3;
                        e = e4;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        return null;
                    } catch (Exception e6) {
                        inputStream = inputStream3;
                        e2 = e6;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        e2.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return null;
                    } catch (Throwable th3) {
                        inputStream = inputStream3;
                        th = th3;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } catch (Error e10) {
                    inputStream2 = inputStream3;
                    e = e10;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (file.exists()) {
                    }
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    return null;
                } catch (Exception e11) {
                    inputStream = inputStream3;
                    e2 = e11;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (file.exists()) {
                    }
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    return null;
                } catch (Throwable th4) {
                    inputStream = inputStream3;
                    th = th4;
                    if (fileOutputStream2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Error e12) {
            e = e12;
            fileOutputStream = null;
            inputStream2 = null;
            if (fileOutputStream != null) {
            }
            if (file.exists()) {
            }
            e.printStackTrace();
            if (fileOutputStream != null) {
            }
            if (inputStream2 != null) {
            }
            return null;
        } catch (Exception e13) {
            e2 = e13;
            fileOutputStream = null;
            inputStream = null;
            if (fileOutputStream != null) {
            }
            if (file.exists()) {
            }
            e2.printStackTrace();
            if (fileOutputStream != null) {
            }
            if (inputStream != null) {
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            if (fileOutputStream2 != null) {
            }
            if (inputStream != null) {
            }
           // throw th;
        }
        return null;
    }

}
