package classesdef.browser;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* renamed from: bck */
public class bck {
    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|6|8|9|10|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        android.util.Log.e("TorUtils", "Unable to get proc id for command: " + java.net.URLEncoder.encode(r5), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0038 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m15985a(android.content.Context r5) {
        /*
            java.io.File r5 = r5.getFilesDir()
            java.io.File r5 = r5.getParentFile()
            java.io.File r5 = r5.getParentFile()
            java.lang.String r5 = r5.getAbsolutePath()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = "/"
            r0.append(r5)
            java.lang.String r5 = "org.torproject.android"
            r0.append(r5)
            java.lang.String r5 = "/app_bin/tor"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r0 = -1
            int r1 = m15986a((java.lang.String) r5)     // Catch:{ Exception -> 0x0038 }
            if (r1 != r0) goto L_0x003c
            int r0 = m15987b(r5)     // Catch:{ Exception -> 0x0037 }
            goto L_0x0059
        L_0x0037:
            r0 = r1
        L_0x0038:
            int r1 = m15987b(r5)     // Catch:{ Exception -> 0x003e }
        L_0x003c:
            r0 = r1
            goto L_0x0059
        L_0x003e:
            r1 = move-exception
            java.lang.String r2 = "TorUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unable to get proc id for command: "
            r3.append(r4)
            java.lang.String r5 = java.net.URLEncoder.encode(r5)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            android.util.Log.e(r2, r5, r1)
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.bck.m15985a(android.content.Context):int");
    }

    /* renamed from: a */
    public static int m15986a(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"pidof", new File(str).getName()}).getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return -1;
            }
            try {
                return Integer.parseInt(readLine.trim());
            } catch (NumberFormatException e) {
                Log.e("TorServiceUtils", "unable to parse process pid: " + readLine, e);
            }
        }
    }

    /* renamed from: b */
    public static int m15987b(String str) throws IOException {
        String readLine;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ps").getInputStream()));
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                return -1;
            }
        } while (readLine.indexOf(' ' + str) == -1);
        StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
        stringTokenizer.nextToken();
        return Integer.parseInt(stringTokenizer.nextToken().trim());
    }
}
