package com.abhishek.xplayer.ad;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.inshot.xplayer.ad.a */
public class C2226a extends AsyncTask<String, Void, byte[]> {

    /* renamed from: a */
    private C2227a f7924a;

    /* renamed from: com.inshot.xplayer.ad.a$a */
    public interface C2227a {
        /* renamed from: a */
        void mo16895a(byte[] bArr);
    }

    public C2226a(C2227a aVar) {
        this.f7924a = aVar;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] doInBackgroundd(String[] r6) {
        /*
            r5 = this;
            java.net.URL r0 = new java.net.URL     // Catch:{ Throwable -> 0x0044 }
            r1 = 0
            r6 = r6[r1]     // Catch:{ Throwable -> 0x0044 }
            r0.<init>(r6)     // Catch:{ Throwable -> 0x0044 }
            java.net.URLConnection r6 = r0.openConnection()     // Catch:{ Throwable -> 0x0044 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Throwable -> 0x0044 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r0)     // Catch:{ Throwable -> 0x0044 }
            r0 = 30000(0x7530, float:4.2039E-41)
            r6.setReadTimeout(r0)     // Catch:{ Throwable -> 0x0044 }
            java.lang.String r0 = "GET"
            r6.setRequestMethod(r0)     // Catch:{ Throwable -> 0x0044 }
            int r0 = r6.getResponseCode()     // Catch:{ Throwable -> 0x0044 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x004a
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0044 }
            r0.<init>()     // Catch:{ Throwable -> 0x0044 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x0044 }
        L_0x002e:
            java.io.InputStream r3 = r6.getInputStream()     // Catch:{ Throwable -> 0x0044 }
            int r3 = r3.read(r2)     // Catch:{ Throwable -> 0x0044 }
            r4 = -1
            if (r3 == r4) goto L_0x003d
            r0.write(r2, r1, r3)     // Catch:{ Throwable -> 0x0044 }
            goto L_0x002e
        L_0x003d:
            byte[] r6 = r0.toByteArray()     // Catch:{ Throwable -> 0x0044 }
            return r6
        L_0x0042:
            r6 = move-exception
            goto L_0x0049
        L_0x0044:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0042 }
            goto L_0x004a
        L_0x0049:
            throw r6     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.p005ad.C2226a.doInBackground(java.lang.String[]):byte[]");
    }
    public byte[] doInBackground(String[] strArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = httpURLConnection.getInputStream().read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(byte[] bArr) {
        C2227a aVar = this.f7924a;
        if (aVar != null) {
            aVar.mo16895a(bArr);
        }
    }
}
