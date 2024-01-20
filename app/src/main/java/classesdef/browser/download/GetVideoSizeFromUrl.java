package classesdef.browser.download;

import android.text.TextUtils;
import android.util.Log;

import com.mopub.common.Constants;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import classesdef.browser.bph;
import classesdef.eventbus.bob;

/* renamed from: boz */
public class GetVideoSizeFromUrl {

    /* renamed from: a */
    private static ExecutorService f16110a = Executors.newFixedThreadPool(2);

    /* renamed from: a */
    public void mo23305a(final bph bph) {
        bph.setVideoSize(-1);
        f16110a.execute(new Runnable() {
            public void run() {
                GetVideoSizeFromUrl.this.m18464b(bph);
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x011f  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0094=Splitter:B:22:0x0094, B:31:0x00c5=Splitter:B:31:0x00c5} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m18464b_(bph r11) {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            r4 = 0
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x00c1, Error -> 0x0090, all -> 0x008c }
            java.lang.String r6 = r11.mo23339c()     // Catch:{ Exception -> 0x00c1, Error -> 0x0090, all -> 0x008c }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00c1, Error -> 0x0090, all -> 0x008c }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x00c1, Error -> 0x0090, all -> 0x008c }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x00c1, Error -> 0x0090, all -> 0x008c }
            r4 = 10000(0x2710, float:1.4013E-41)
            r5.setConnectTimeout(r4)     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            r5.setReadTimeout(r4)     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            java.lang.String r4 = "GET"
            r5.setRequestMethod(r4)     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r6 = "identity"
            r5.setRequestProperty(r4, r6)     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            r5.connect()     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            int r4 = r5.getResponseCode()     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r4 != r6) goto L_0x005d
            int r4 = r5.getContentLength()     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            if (r4 <= 0) goto L_0x005d
            if (r11 == 0) goto L_0x005d
            long r6 = (long) r4     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            r11.setVideoSize((long) r6)     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            org.greenrobot.eventbus.c r4 = org.greenrobot.eventbus.C3279c.m14239a()     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            bob r6 = new bob     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            boi r7 = p000.boi.m18319b()     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            java.lang.String r8 = r11.mo23354i()     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            int r7 = r7.mo23264a((java.lang.String) r8)     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            java.lang.String r8 = r11.mo23354i()     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            r6.<init>(r7, r8)     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
            r4.mo20557d(r6)     // Catch:{ Exception -> 0x008a, Error -> 0x0088 }
        L_0x005d:
            if (r5 == 0) goto L_0x0062
            r5.disconnect()
        L_0x0062:
            long r4 = r11.getVideoSize()
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f4
            r11.setVideoSize((long) r2)
            org.greenrobot.eventbus.c r2 = org.greenrobot.eventbus.C3279c.m14239a()
            bob r3 = new bob
            boi r4 = p000.boi.m18319b()
            java.lang.String r5 = r11.mo23354i()
            int r4 = r4.mo23264a((java.lang.String) r5)
            java.lang.String r11 = r11.mo23354i()
            r3.<init>(r4, r11)
            goto L_0x00f1
        L_0x0088:
            r4 = move-exception
            goto L_0x0094
        L_0x008a:
            r4 = move-exception
            goto L_0x00c5
        L_0x008c:
            r0 = move-exception
            r5 = r4
            goto L_0x0112
        L_0x0090:
            r5 = move-exception
            r9 = r5
            r5 = r4
            r4 = r9
        L_0x0094:
            r4.printStackTrace()     // Catch:{ all -> 0x0111 }
            if (r5 == 0) goto L_0x009c
            r5.disconnect()
        L_0x009c:
            long r4 = r11.getVideoSize()
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f4
            r11.setVideoSize((long) r2)
            org.greenrobot.eventbus.c r2 = org.greenrobot.eventbus.C3279c.m14239a()
            bob r3 = new bob
            boi r4 = p000.boi.m18319b()
            java.lang.String r5 = r11.mo23354i()
            int r4 = r4.mo23264a((java.lang.String) r5)
            java.lang.String r11 = r11.mo23354i()
            r3.<init>(r4, r11)
            goto L_0x00f1
        L_0x00c1:
            r5 = move-exception
            r9 = r5
            r5 = r4
            r4 = r9
        L_0x00c5:
            r4.printStackTrace()     // Catch:{ all -> 0x0111 }
            if (r5 == 0) goto L_0x00cd
            r5.disconnect()
        L_0x00cd:
            long r4 = r11.getVideoSize()
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f4
            r11.setVideoSize((long) r2)
            org.greenrobot.eventbus.c r2 = org.greenrobot.eventbus.C3279c.m14239a()
            bob r3 = new bob
            boi r4 = p000.boi.m18319b()
            java.lang.String r5 = r11.mo23354i()
            int r4 = r4.mo23264a((java.lang.String) r5)
            java.lang.String r11 = r11.mo23354i()
            r3.<init>(r4, r11)
        L_0x00f1:
            r2.mo20557d(r3)
        L_0x00f4:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "read size time = "
            r11.append(r2)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            r11.append(r2)
            java.lang.String r11 = r11.toString()
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            p000.bau.m15850a(r11, r0)
            return
        L_0x0111:
            r0 = move-exception
        L_0x0112:
            if (r5 == 0) goto L_0x0117
            r5.disconnect()
        L_0x0117:
            long r4 = r11.getVideoSize()
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x013e
            r11.setVideoSize((long) r2)
            org.greenrobot.eventbus.c r1 = org.greenrobot.eventbus.C3279c.m14239a()
            bob r2 = new bob
            boi r3 = p000.boi.m18319b()
            java.lang.String r4 = r11.mo23354i()
            int r3 = r3.mo23264a((java.lang.String) r4)
            java.lang.String r11 = r11.mo23354i()
            r2.<init>(r3, r11)
            r1.mo20557d(r2)
        L_0x013e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.boz.m18464b(bph):void");
    }

    private void m18464b(bph bph) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        bob bob;
        EventBus cVar;
        Exception e;
        Error e2;
        int contentLength;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Log.e("getVideoSize4444","///"+String.valueOf("contentLength"));
            httpURLConnection = (HttpURLConnection) new URL(bph.mo23339c()).openConnection();
            Log.e("getVideoSize4444a","///"+String.valueOf("contentLength"));
            try {
                httpURLConnection.setConnectTimeout(Constants.TEN_SECONDS_MILLIS);
                httpURLConnection.setReadTimeout(Constants.TEN_SECONDS_MILLIS);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                Log.e("getVideoSize4444b","///"+String.valueOf("contentLength"));
                if (!TextUtils.isEmpty(bph.mo24644s())) {
                    httpURLConnection.setRequestProperty("Referer", bph.mo24644s());
                }
                if (!TextUtils.isEmpty(bph.mo23362q())) {
                    httpURLConnection.setRequestProperty("Cookie", bph.mo23362q());
                }
                Log.e("getVideoSize4444len","///"+String.valueOf(" httpURLConnection.getContentLength()"));
                httpURLConnection.connect();
                Log.e("getVideoSize4444len","///"+String.valueOf(httpURLConnection.getContentLength()));
                Log.e("getVideoSize4444len","///"+String.valueOf(httpURLConnection.getResponseCode() == 200));
                Log.e("getVideoSize4444len","///"+String.valueOf( contentLength = httpURLConnection.getContentLength()));
                if (httpURLConnection.getResponseCode() == 200 && (contentLength = httpURLConnection.getContentLength()) > 0 && bph != null) {
                    Log.e("getVideoSize4444c","///"+String.valueOf("contentLength"));
                    bph.setVideoSize((long) contentLength);
                    Log.e("getVideoSize4444","///"+String.valueOf(contentLength));
                    EventBus.getDefault().post(new bob(boi.m18319b().mo23264a(bph.mo23354i()), bph.mo23354i()));
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bph.getVideoSize() < 0) {
                    bph.setVideoSize(0L);
                    cVar = EventBus.getDefault();
                    bob = new bob(boi.m18319b().mo23264a(bph.mo23354i()), bph.mo23354i());
                    cVar.post(bob);
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bph.getVideoSize() < 0) {
                    bph.setVideoSize(0L);
                    cVar = EventBus.getDefault();
                    bob = new bob(boi.m18319b().mo23264a(bph.mo23354i()), bph.mo23354i());
                    cVar.post(bob);
                }
                Logger.e("read size time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            } catch (Error e4) {
                e2 = e4;
                try {
                    e2.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bph.getVideoSize() < 0) {
                        bph.setVideoSize(0L);
                        cVar = EventBus.getDefault();
                        bob = new bob(boi.m18319b().mo23264a(bph.mo23354i()), bph.mo23354i());
                        cVar.post(bob);
                    }
                    Logger.e("read size time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bph.getVideoSize() < 0) {
                        bph.setVideoSize(0L);
                        EventBus.getDefault().post(new bob(boi.m18319b().mo23264a(bph.mo23354i()), bph.mo23354i()));
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            httpURLConnection = null;
            e = e5;
            e.printStackTrace();
            if (httpURLConnection != null) {
            }
            if (bph.getVideoSize() < 0) {
            }
            Logger.e("read size time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        } catch (Error e6) {
            httpURLConnection = null;
            e2 = e6;
            e2.printStackTrace();
            if (httpURLConnection != null) {
            }
            if (bph.getVideoSize() < 0) {
            }
            Logger.e("read size time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            if (bph.getVideoSize() < 0) {
            }
          //  throw th;
        }
        Logger.e("read size time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

}
