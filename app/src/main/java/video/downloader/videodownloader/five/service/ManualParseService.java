package video.downloader.videodownloader.five.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;

import androidx.core.app.JobIntentService;
import androidx.core.view.PointerIconCompat;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classesdef.browser.bbc;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.BrowserData;
import classesdef.browser.bph;
import classesdef.browser.bqq;
import classesdef.browser.bqw;
import classesdef.browser.download.boi;
import classesdef.browser.download.bpd;
import classesdef.browser.download.bpf;
import classesdef.eventbus.bny;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import video.downloader.videodownloader.view.C3370c;

public class ManualParseService extends JobIntentService {

    private static ArrayList<String> f13721a = new ArrayList<>();
    private static ArrayList<String> f11675j = new ArrayList<>();

    private static void m14402b(String str) {
        if (f11675j == null) {
            f11675j = new ArrayList<>();
        }
        if (!TextUtils.isEmpty(str) && !f11675j.contains(str)) {
            f11675j.add(str);
        }
    }
    public static boolean m14400a(String str) {
        return f11675j != null && !TextUtils.isEmpty(str) && f11675j.contains(str);
    }

    /* renamed from: e */
    public static void m14410e() {
        ArrayList<String> arrayList = f11675j;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
    public void onHandleWork(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("title");
            String stringExtra2 = intent.getStringExtra("father_url");
            String stringExtra3 = intent.getStringExtra("request_url");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3)) {
                Log.e("manulparseservice","one+++start2");
                m15236a(stringExtra, stringExtra2, stringExtra3);
            }
        }
    }

    /* renamed from: a */
    private void m15236a__(String str, String str2, String str3) {
        EventBus cVar;
        bny bny;
        boolean z = false;
        int i = 2;
        try {
            OkHttpClient.Builder aVar = new OkHttpClient.Builder();
            aVar.connectTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.readTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.writeTimeout(30000, TimeUnit.MILLISECONDS);
            if (!str2.contains(BrowserData.m18402m(this))) {
                aVar.cookieJar( new bpf());
            }
            aVar.retryOnConnectionFailure(true);
            Response a = aVar.build().newCall(new Request.Builder().url(str3).addHeader(BrowserData.m18390b(this), BrowserData.m18392c(this)).build()).execute();
            boolean z2 = false;
            if (a.isSuccessful()) {
                BrowserLogEvent.downloaderLogEvent(this, "ManualSuccess", "");
                String e = a.body().string();
                if (!m15240b(this, str2)) {
                    if (!m15242c(this, str2)) {
                        if (!m15246d(this, str2) && !m15251f(this, str2)) {
                         /*   if (!m15249e(this, str2)) {
                                if (m15253g(this, str2)) {
                                    z = m15244c(str, str2, e);
                                } else if (m15255h(this, str2)) {
                                    z = m15247d(str, str2, e);
                                } else if (m15257i(this, str2)) {
                                    z = m15252f(str, str2, e);
                                } else if (m15259j(this, str2)) {
                                    z = m15254g(str, str2, e);
                                } else if (m15261k(this, str2)) {
                                    z = m15256h(str, str2, e);
                                } else if (m15262l(this, str2)) {
                                    z = m15258i(str, str2, e);
                                } else if (m15263m(this, str2)) {
                                    z = m15260j(str, str2, e);
                                }
                                z2 = z;
                            }*/
                        }
                      //  z = m15241b(str, str2, e);
                        z2 = z;
                    }
                }
                //z = m15250e(str, str2, e);
                z2 = z;
            } else {
                BrowserLogEvent.downloaderLogEvent(this, "ManualFailed", str2);
            }
            cVar = EventBus.getDefault();
            if (z2) {
                i = 1;
            }
            bny = new bny(str2, i);
        } catch (Exception e2) {
            e2.printStackTrace();
            BrowserLogEvent.downloaderLogEvent(this, "ManualFailed", str2);
            bbc.m15886a().mo21879a((Context) this, (Throwable) e2);
            cVar = EventBus.getDefault();
            bny = new bny(str2, 2);
        } catch (Error e3) {
            e3.printStackTrace();
            BrowserLogEvent.downloaderLogEvent(this, "ManualFailed", str2);
            bbc.m15886a().mo21879a((Context) this, (Throwable) e3);
            cVar = EventBus.getDefault();
            bny = new bny(str2, 2);
        } catch (Throwable th) {
            EventBus.getDefault().post(new bny(str2, 2));
            m15239b(str3);
            throw th;
        }
        cVar.post(bny);
        m15239b(str3);
    }
    private void m15236ac(String str, String str2, String str3) {
        Log.e("manulparseservice","one+++start");
        EventBus cVar;
        bny beq;
        String str4;
        List arrayList = new ArrayList();
        int i = 2;
        boolean z = false;
        try {
            OkHttpClient.Builder aVar = new OkHttpClient.Builder();
            aVar.connectTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.readTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.writeTimeout(30000, TimeUnit.MILLISECONDS);
            if (!str2.contains(BrowserData.m18402m(this))) {
                aVar.cookieJar( new bpf());
            }
            aVar.retryOnConnectionFailure(true);
            OkHttpClient a = aVar.build();
            Request.Builder a2 = new Request.Builder().url(str3);
            if (m15246d(this, str2)) {
                str4 = bqq.m21732g(this);
            } else if (m15249e(this, str2)) {
                str4 = bqq.m21733h(this);
            } else if (m14414f(this, str2)) {
                str4 = bqq.m21734i(this);
                if (!TextUtils.isEmpty(C3370c.f11781a)) {
                    a2.addHeader("X-FC2-Video-Access-Token", C3370c.f11781a);
                }
            } else {
                str4 = BrowserData.m18392c(this);
            }
            a2.addHeader(BrowserData.m18390b(this), str4);
            Response a3 = a.newCall(a2.build()).execute();
            if (a3.isSuccessful()) {
                BrowserLogEvent.downloaderLogEvent(this, "ManualSuccess", "");
                String e = a3.body().string();
                if (!m15240b(this, str2)) {
                    if (!m15242c(this, str2)) {
                        if (!m15246d(this, str2) && !m15251f(this, str2)) {
                            if (!m15249e(this, str2)) {
                                if (m15255h(this, str2)) {
                                    arrayList = C3344a.m14432a(this, str, str2, e);
                                } else if (m15249e(this, str2)) {
                                    arrayList = C3344a.m14439b(this, str, str2, e);
                                } else if (m15257i(this, str2)) {
                                    arrayList = m14401b(str, str2, e);
                                } else if (m15259j(this, str2)) {
                                    arrayList = C3344a.m14447g(this, str, str2, e);
                                } else if (m15261k(this, str2)) {
                                    arrayList = m14404c(str, str2, e);
                                } else if (m15262l(this, str2)) {
                                    arrayList = C3344a.m14444d(this, str, str2, e);
                                } else if (m15263m(this, str2)) {
                                    arrayList = m14407d(str, str2, e);
                                } else if (m14406c(this, str2)) {
                                    arrayList = C3344a.m14445e(this, str, str2, e);
                                } else if (m14414f(this, str2)) {
                                    arrayList = C3344a.m14448h(this, str, str2, e);
                                }
                            }
                        }
                        arrayList = C3344a.m14446f(this, str, str2, e);
                    }
                }
                arrayList = C3344a.m14442c(this, str, str2, e);
            } else {
                BrowserLogEvent.downloaderLogEvent(this, "ManualFailed", str2);
            }
            if (arrayList != null && arrayList.size() > 0) {
                z = true;
            }
            cVar = EventBus.getDefault();
            if (z) {
                i = 1;
            }
            beq = new bny(str2, i);
        } catch (Exception e2) {
            e2.printStackTrace();
            BrowserLogEvent.downloaderLogEvent(this, "ManualFailed", str2);
            bbc.m15886a().mo21879a((Context) this, (Throwable) e2);
            if (arrayList.size() > 0) {
                z = true;
            }
            cVar = EventBus.getDefault();
            if (z) {
                i = 1;
            }
            beq = new bny(str2, i);
        } catch (Error e3) {
            e3.printStackTrace();
            BrowserLogEvent.downloaderLogEvent(this, "ManualFailed", str2);
            bbc.m15886a().mo21879a((Context) this, (Throwable) e3);
            if (arrayList.size() > 0) {
                z = true;
            }
            cVar = EventBus.getDefault();
            if (z) {
                i = 1;
            }
            beq = new bny(str2, i);
        } catch (Throwable th) {
            if (arrayList.size() > 0) {
                z = true;
            }
            EventBus a4 = EventBus.getDefault();
            if (z) {
                i = 1;
            }
            a4.post(new bny(str2, i));
            m14402b(str2);
            boi.m18319b().mo24556a((Context) this, str2, (List<bph>) arrayList);
            m15239b(str3);
            throw th;
        }
        cVar.post(beq);
        m14402b(str2);
        boi.m18319b().mo24556a((Context) this, str2, (List<bph>) arrayList);
        m15239b(str3);
    }
    private void m15236a(final String s, final String s2, final String s3) {
        ArrayList<bph> list = new ArrayList<bph>();
        int n = 2;
        int n2 = 0;
        final int n3 = 0;
        final int n4 = 0;
        try {
            try {
                OkHttpClient.Builder aVar = new OkHttpClient.Builder();
                aVar.connectTimeout(30000, TimeUnit.MILLISECONDS);
                aVar.readTimeout(30000, TimeUnit.MILLISECONDS);
                aVar.writeTimeout(30000, TimeUnit.MILLISECONDS);
                if (!s2.contains(BrowserData.m18402m((Context)this))) {
                    aVar.cookieJar( new bpf());
                }
                aVar.retryOnConnectionFailure(true);
                OkHttpClient a = aVar.build();
                Request.Builder a2 = new Request.Builder().url(s3);
                String s4;
                if (m15246d((Context)this, s2)) {
                    s4 =  bqq.m21732g((Context)this);
                }
                else if (m15249e((Context)this, s2)) {
                    s4 =bqq.m21733h((Context)this);
                }
                else if (m14414f((Context)this, s2)) {
                    s4 =bqq.m21734i((Context)this);
                    if (!TextUtils.isEmpty((CharSequence)video.downloader.videodownloader.view.C3370c.f11781a)) {
                        a2.addHeader("X-FC2-Video-Access-Token", video.downloader.videodownloader.view.C3370c.f11781a);
                        s4 = s4;
                    }
                }
                else {
                    s4 =BrowserData.m18392c((Context)this);
                }
                a2.addHeader(BrowserData.m18390b((Context)this), s4);
                Response a3 = a.newCall(a2.build()).execute();
                List<bph> list2;
                if (a3.isSuccessful()) {
                    BrowserLogEvent.downloaderLogEvent((Context)this, "ManualSuccess", "");
                    String e = a3.body().string();
                    if (!m15240b((Context)this, s2) && !m15242c((Context)this, s2)) {
                        if (!m15246d((Context)this, s2) && !m15251f((Context)this, s2) && !m15249e((Context)this, s2)) {
                            if (m15255h((Context)this, s2)) {
                                Log.e("manulparseservicexx8","one+++start2"+String.valueOf(s2));
                                list2 = (List<bph>)C3344a.m14432a((Context)this, s, s2, e);
                            }
                            else if (m15249e((Context)this, s2)) {
                                Log.e("manulparseservicexx7","one+++start2"+String.valueOf(s2));
                                list2 = (List<bph>)C3344a.m14439b((Context)this, s, s2, e);
                            }
                            else if (m15257i((Context)this, s2)) {
                                Log.e("manulparseservicexx6","one+++start2"+String.valueOf(s2));
                                list2 = this.m14401b(s, s2, e);
                            }
                            else if (m15259j((Context)this, s2)) {
                                //dailymotion
                                Log.e("manulparseservicexx5","one+++start2"+String.valueOf(s2));
                                list2 = (List<bph>)C3344a.m14447g((Context)this, s, s2, e);
                            }
                            else if (m15261k((Context)this, s2)) {
                                Log.e("manulparseservicexx4","one+++start2"+String.valueOf(s2));
                                list2 = this.m14404c(s, s2, e);
                            }
                            else if (m15262l((Context)this, s2)) {
                                Log.e("manulparseservicexx3","one+++start2"+String.valueOf(s2));
                                list2 = (List<bph>)C3344a.m14444d((Context)this, s, s2, e);
                            }
                            else if (m15263m((Context)this, s2)) {
                                Log.e("manulparseservicexx2","one+++start2"+String.valueOf(s2));
                                list2 = this.m14407d(s, s2, e);
                            }
                            else if (m14406c((Context)this, s2)) {
                                Log.e("manulparseservicexx1","one+++start2"+String.valueOf(s2));
                                list2 = (List<bph>)C3344a.m14445e((Context)this, s, s2, e);
                            }
                            else {
                                list2 = list;
                                if (m14414f((Context)this, s2)) {
                                    list2 = (List<bph>) C3344a.m14448h((Context)this, s, s2, e);
                                }
                            }
                        }
                        else {
                            list2 = (List<bph>)C3344a.m14446f((Context)this, s, s2, e);
                        }
                    }
                    else {
                        list2 = (List<bph>)C3344a.m14442c((Context)this, s, s2, e);
                    }
                }
                else {
                    BrowserLogEvent.downloaderLogEvent((Context)this, "ManualFailed", s2);
                    list2 = list;
                }
                n2 = n4;
                if (list2 != null) {
                    n2 = n4;
                    if (list2.size() > 0) {
                        n2 = 1;
                    }
                }
                final EventBus a4 =  EventBus.getDefault();
                if (n2 != 0) {
                    n = 1;
                }
                final bny beq = new bny(s2, n);
                list = (ArrayList<bph>)list2;
                final EventBus c = a4;
            }
            finally {
                int n5 = n3;
                if (list.size() > 0) {
                    n5 = 1;
                }
                final EventBus a5 = EventBus.getDefault();
                if (n5 != 0) {
                    n = 1;
                }
                a5.post((Object)new bny(s2, n));
                m14402b(s2);
                boi.m18319b().mo24556a((Context)this, s2, (List)list);
                m15239b(s3);
                bny beq = null;
                Label_0663: {
                    beq = new bny(s2, n);
                }
                // iftrue(Label_0663:, n2 == 0)
                // iftrue(Label_0728:, !b)
                Block_30: {
                    EventBus c = null;
                    Label_0739: {
                        break Label_0739;
                       // Label_0728:
                      /*  while (true) {
                            n = 1;
                            break Label_0728;
                            n2 = 1;
                            c = org.greenrobot.eventbus.EventBus.getDefault();
                            break Block_30;
                            final boolean b = true;
                            c = org.greenrobot.eventbus.EventBus.getDefault();
                            continue;
                        }*/
                        //beq = new bny(s2, n);
                    }
                    c.post((Object)new bny(s2, n));
                    m14402b(s2);
                    boi.m18319b().mo24556a((Context)this, s2, (List)list);
                    m15239b(s3);
                    return;
                }
              //  n = 1;
            }
        }
        catch (Error error) {}
        catch (Exception ex) {}
    }



    private static void m15235a(String str) {
        if (f13721a == null) {
            f13721a = new ArrayList<>();
        }
        if (!f13721a.contains(str)) {
            f13721a.add(str);
        }
    }


    private static void m15239b(String str) {
        if (f13721a != null && !TextUtils.isEmpty(str)) {
            f13721a.remove(str);
        }
    }


    private static boolean m15243c(String str) {
        return f13721a != null && f13721a.contains(str);
    }

    /* renamed from: a */
    public static synchronized void m15233a(Context context, WebView webView) {
        synchronized (ManualParseService.class) {
            if (webView != null) {
                m15234a(context, webView.getUrl(), "", webView.getTitle());
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m15234a__(Context context, String str, String str2, String str3) {
        String str4;
        synchronized (ManualParseService.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.contains("vimeo.com") && TextUtils.isEmpty(str2)) {
                        try {
                            str2 = "https://player.vimeo.com/video/" + Long.parseLong(str.substring(str.lastIndexOf(47) + 1));
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (str.contains("www.dailymotion.com/video/") && TextUtils.isEmpty(str2)) {
                        try {
                            int lastIndexOf = str.lastIndexOf(47);
                            int lastIndexOf2 = str.lastIndexOf("?playlist");
                            int i = lastIndexOf + 1;
                            if (lastIndexOf2 > i) {
                                str4 = str.substring(i, lastIndexOf2);
                            } else {
                                str4 = str.substring(i);
                            }
                            str2 = "https://www.dailymotion.com/player/metadata/video/" + str4;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = str;
                    }
                    if (!m15243c(str2)) {
                        if (!boi.m18319b().mo23273b(str2)) {
                            if (TextUtils.isEmpty(str3)) {
                                str3 = "";
                            }
                            if (m15237a(context, str)) {
                                m15235a(str2);
                                Intent intent = new Intent(context, ManualParseService.class);
                                intent.putExtra("father_url", str);
                                intent.putExtra("request_url", str2);
                                intent.putExtra("title", str3);
                                if (bqw.m19024c()) {
                                    try {
                                        JobIntentService.enqueueWork(context, ManualParseService.class, (int) PointerIconCompat.TYPE_CONTEXT_MENU, intent);
                                    } catch (IllegalArgumentException e3) {
                                        e3.printStackTrace();
                                    }
                                } else {
                                    JobIntentService.enqueueWork(context, ManualParseService.class, (int) PointerIconCompat.TYPE_CONTEXT_MENU, intent);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public static synchronized void m15234a(Context context, String str, String str2, String str3) {
        Log.e("manulparseservice","one+++"+String.valueOf(str)+str2+str3);
        synchronized (ManualParseService.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    Log.e("manulparseservice","one+++2222");
                    if (str.contains("vimeo.com") && TextUtils.isEmpty(str2)) {
                        try {
                            str2 = "https://player.vimeo.com/video/" + Long.parseLong(str.substring(str.lastIndexOf(47) + 1));
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!m15259j(context, str) || !TextUtils.isEmpty(str2)) {
                        Log.e("manulparseservice","one+++33333333");
                        if (m14414f(context, str)) {
                            Log.e("manulparseservice","one+++4444444");
                            try {
                                Log.e("manulparseservice","one+++555555");
                                Matcher matcher = Pattern.compile("/content/([A-Za-z0-9]+)").matcher(str);
                                if (matcher.find()) {
                                    str2 = bpd.m21196a(str) + "/api/v3/videoplaylist/" + matcher.group(1);
                                }
                                if (TextUtils.isEmpty(str2)) {
                                    EventBus.getDefault().post(new bny(str, 2));
                                    m15239b(str2);
                                    return;
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                EventBus.getDefault().post(new bny(str, 2));
                                m15239b(str2);
                                return;
                            }
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str2 = str;
                        }
                        if (!m15243c(str2)) {
                            Log.e("manulparseservice","one+++6666");

                            if (!boi.m18319b().mo24563g(str2)) {
                                Log.e("manulparseservice","one+++77777");
                                if (TextUtils.isEmpty(str3)) {
                                    str3 = "";
                                }
                                if (m15237a(context, str)) {
                                    Log.e("manulparseservice","one+++8888");
                                    m15235a(str2);
                                    Intent intent = new Intent(context, ManualParseService.class);
                                    intent.putExtra("father_url", str);
                                    intent.putExtra("request_url", str2);
                                    intent.putExtra("title", str3);
                                    if (bqw.m19024c()) {
                                        Log.e("manulparseservice","one+++99999");
                                        try {
                                            Log.e("manulparseservice","one+++101010");
                                            JobIntentService.enqueueWork(context, ManualParseService.class, 1001, intent);
                                        } catch (IllegalArgumentException e3) {
                                            e3.printStackTrace();
                                        }
                                    } else {
                                        JobIntentService.enqueueWork(context, ManualParseService.class, 1001, intent);
                                    }
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!DayService.m14389a(str)) {
                        Log.e("manulparseservice","one+++111");
                        try {
                            Intent intent2 = new Intent(context, DayService.class);
                            intent2.putExtra("father_url", str);
                            intent2.putExtra("title", str3);
                            JobIntentService.enqueueWork(context, DayService.class, 1002, intent2);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static boolean m15237a(Context context, String str) {
        if (bqq.m18974b(context, str)) {
            return false;
        }
        if (m15240b(context, str) || m15242c(context, str) || m15246d(context, str) || m15251f(context, str)
                || m15253g(context, str) || m15255h(context, str) || m15249e(context, str) ||
                m15257i(context, str) || m15259j(context, str) || m15261k(context, str) ||
                m15262l(context, str) || m15263m(context, str)  || m14406c(context, str) ||
                m14414f(context, str) ) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m15240b(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m18393d(context));
    }

    /* renamed from: c */
    private static boolean m15242c(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m18394e(context));
    }

    /* renamed from: d */
    private static boolean m15246d(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m18395f(context));
    }

    /* renamed from: e */
    private static boolean m15249e(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m18396g(context));
    }

    /* renamed from: f */
    private static boolean m15251f(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m18397h(context));
    }

    /* renamed from: g */
    private static boolean m15253g(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m18398i(context));
    }

    /* renamed from: h */
    private static boolean m15255h(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m18399j(context));
    }

    /* renamed from: i */
    private static boolean m15257i(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("vimeo.com");
    }

    /* renamed from: j */
    public static boolean m15259j(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("dailymotion.com") && str.toLowerCase().contains("video/");
    }

    /* renamed from: k */
    private static boolean m15261k(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m18400k(context)) && str.contains("view?t=");
    }

    /* renamed from: l */
    private static boolean m15262l(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m18401l(context));
    }

    /* renamed from: m */
    private static boolean m15263m(Context context, String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(BrowserData.m18402m(context))) {
            return false;
        }
        try {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            Long.parseLong(str.substring(str.lastIndexOf(47) + 1));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean m14406c(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(BrowserData.m21105n(context)) && str.toLowerCase().contains("video/");
    }

    /* renamed from: d */
    public static boolean m14409d(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().matches(BrowserData.m21106o(context));
    }

    /* renamed from: e */
    public static boolean m14411e(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().matches(BrowserData.m21108q(context));
    }

    /* renamed from: f */
    public static boolean m14414f(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().matches(BrowserData.m21110s(context));
    }
    /* renamed from: a */
    private String m15231a(Context context, Document document, String str) {
        Log.e("typeDownlod","duration6");
        try {
            Elements elementsByAttributeValue = document.getElementsByAttributeValue("property", str);
            if (elementsByAttributeValue.size() <= 0) {
                return "";
            }
            Element element = (Element) elementsByAttributeValue.get(0);
            if (element.hasAttr("content")) {
                return element.attr("content");
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return "";
        }
    }

    /* renamed from: n */
    private int m15264n(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str) * 1000;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
            return 0;
        }
    }
    private java.util.ArrayList<bph> m14401bb(java.lang.String r16, java.lang.String r17, java.lang.String r18) {
        /*
            r15 = this;
            r8 = r15
            r1 = r18
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r2 = ""
            java.lang.String r3 = ""
            java.lang.String r0 = "\"duration\":(.*?),\"thumbs\":"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r1)
            boolean r4 = r0.find()
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x002e
            java.lang.String r0 = r0.group(r6)     // Catch:{ Exception -> 0x002a }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x002a }
            int r0 = r0 * 1000
            r10 = r0
            goto L_0x002f
        L_0x002a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002e:
            r10 = 0
        L_0x002f:
            java.lang.String r0 = "\"thumbs\":(.*?),\"owner\":"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r1)
            boolean r4 = r0.find()
            if (r4 == 0) goto L_0x0089
            java.lang.String r0 = r0.group(r6)
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0085 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r0 = "base"
            boolean r0 = r4.has(r0)     // Catch:{ Exception -> 0x0085 }
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = "base"
            java.lang.String r2 = r4.optString(r0)     // Catch:{ Exception -> 0x0085 }
            goto L_0x0083
        L_0x0057:
            java.lang.String r0 = "1280"
            boolean r0 = r4.has(r0)     // Catch:{ Exception -> 0x0085 }
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = "1280"
            java.lang.String r2 = r4.optString(r0)     // Catch:{ Exception -> 0x0085 }
            goto L_0x0083
        L_0x0066:
            java.lang.String r0 = "960"
            boolean r0 = r4.has(r0)     // Catch:{ Exception -> 0x0085 }
            if (r0 == 0) goto L_0x0075
            java.lang.String r0 = "960"
            java.lang.String r2 = r4.optString(r0)     // Catch:{ Exception -> 0x0085 }
            goto L_0x0083
        L_0x0075:
            java.lang.String r0 = "640"
            boolean r0 = r4.has(r0)     // Catch:{ Exception -> 0x0085 }
            if (r0 == 0) goto L_0x0083
            java.lang.String r0 = "640"
            java.lang.String r2 = r4.optString(r0)     // Catch:{ Exception -> 0x0085 }
        L_0x0083:
            r0 = r2
            goto L_0x008a
        L_0x0085:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0089:
            r0 = r2
        L_0x008a:
            java.lang.String r2 = "\"title\":(.*?),\"share_url\":"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.util.regex.Matcher r2 = r2.matcher(r1)
            boolean r4 = r2.find()
            if (r4 == 0) goto L_0x009f
            java.lang.String r2 = r2.group(r6)
            goto L_0x00a0
        L_0x009f:
            r2 = r3
        L_0x00a0:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x00a8
            r11 = r2
            goto L_0x00aa
        L_0x00a8:
            r11 = r16
        L_0x00aa:
            java.lang.String r2 = "\"progressive\":(.*?),\"lang\":"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.util.regex.Matcher r1 = r2.matcher(r1)
            boolean r2 = r1.find()
            if (r2 == 0) goto L_0x010a
            boi r2 = p000.boi.m21014b()
            r12 = r17
            r2.mo24559c(r12)
            java.lang.String r1 = r1.group(r6)
            org.json.JSONArray r13 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ff }
            r13.<init>(r1)     // Catch:{ JSONException -> 0x00ff }
            r14 = 0
        L_0x00cd:
            int r1 = r13.length()     // Catch:{ JSONException -> 0x00ff }
            if (r14 >= r1) goto L_0x010a
            org.json.JSONObject r1 = r13.getJSONObject(r14)     // Catch:{ JSONException -> 0x00ff }
            java.lang.String r2 = "url"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ JSONException -> 0x00ff }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00ff }
            if (r3 != 0) goto L_0x00fc
            java.lang.String r3 = "quality"
            java.lang.String r4 = "240p"
            java.lang.String r1 = r1.optString(r3, r4)     // Catch:{ JSONException -> 0x00ff }
            int r6 = r15.m15245d(r1)     // Catch:{ JSONException -> 0x00ff }
            r1 = r15
            r3 = r17
            r4 = r11
            r5 = r10
            r7 = r0
            bph r1 = p000.bpd.m21193a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x00ff }
            r9.add(r1)     // Catch:{ JSONException -> 0x00ff }
        L_0x00fc:
            int r14 = r14 + 1
            goto L_0x00cd
        L_0x00ff:
            r0 = move-exception
            r0.printStackTrace()
            bbc r1 = p000.bbc.m15886a()
            r1.mo21879a((android.content.Context) r15, (java.lang.Throwable) r0)
        L_0x010a:
            java.lang.String r0 = "parseVimeo"
            int r1 = r9.size()
            if (r1 <= 0) goto L_0x0115
            java.lang.String r1 = "parseSuccess"
            goto L_0x0117
        L_0x0115:
            java.lang.String r1 = "parseFailed"
        L_0x0117:
            p000.bop.downloaderLogEvent(r15, r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ManualParseService.m14401b(java.lang.String, java.lang.String, java.lang.String):java.util.ArrayList");
    }
    private ArrayList<bph> m14401b(String str, String str2, String str3) {
        Log.e("typeDownlod","duration5");
        int i=0;
        Matcher matcher;
        String str4 = null;
        Matcher matcher2;
        String str5 = null;
        Matcher matcher3;
        ArrayList<bph> arrayList = new ArrayList<bph>();
        String str6 = "";
        Matcher matcher4 = Pattern.compile("\"duration\":(.*?),\"thumbs\":").matcher(str3);
        if (matcher4.find()) {
            try {
                i = Integer.parseInt(matcher4.group(1)) * 1000;
            } catch (Exception e) {
                e.printStackTrace();
            }
            matcher = Pattern.compile("\"thumbs\":(.*?),\"owner\":").matcher(str3);
            if (matcher.find()) {
                try {
                    JSONObject jSONObject = new JSONObject(matcher.group(1));
                    if (jSONObject.has("base")) {
                        str6 = jSONObject.optString("base");
                    } else if (jSONObject.has("1280")) {
                        str6 = jSONObject.optString("1280");
                    } else if (jSONObject.has("960")) {
                        str6 = jSONObject.optString("960");
                    } else if (jSONObject.has("640")) {
                        str6 = jSONObject.optString("640");
                    }
                    str4 = str6;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                matcher2 = Pattern.compile("\"title\":(.*?),\"share_url\":").matcher(str3);
                if (matcher2.find()) {
                    str5 = matcher2.group(1);
                } else {
                    str5 = "";
                }
                String str7 = TextUtils.isEmpty(str5) ? str5 : str;
                matcher3 = Pattern.compile("\"progressive\":(.*?),\"lang\":").matcher(str3);
                if (matcher3.find()) {
                    boi.m18319b().mo23274c(str2);
                    try {
                        JSONArray jSONArray = new JSONArray(matcher3.group(1));
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String optString = jSONObject2.optString("url");
                            if (!TextUtils.isEmpty(optString)) {
                                arrayList.add(bpd.m21193a(this, optString, str2, str7, i, m15245d(jSONObject2.optString("quality", "240p")), str4));
                            }
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        bbc.m15886a().mo21879a(this, e3);
                    }
                }
                BrowserLogEvent.downloaderLogEvent(this, "parseVimeo", arrayList.size() > 0 ? "parseSuccess" : "parseFailed");
                return arrayList;
            }
            str4 = str6;
            matcher2 = Pattern.compile("\"title\":(.*?),\"share_url\":").matcher(str3);
            if (matcher2.find()) {
            }
            if (TextUtils.isEmpty(str5)) {
            }
            matcher3 = Pattern.compile("\"progressive\":(.*?),\"lang\":").matcher(str3);
            if (matcher3.find()) {
            }
            BrowserLogEvent.downloaderLogEvent(this, "parseVimeo", arrayList.size() > 0 ? "parseSuccess" : "parseFailed");
            return arrayList;
        }
        i = 0;
        matcher = Pattern.compile("\"thumbs\":(.*?),\"owner\":").matcher(str3);
        if (matcher.find()) {
        }
        str4 = str6;
        matcher2 = Pattern.compile("\"title\":(.*?),\"share_url\":").matcher(str3);
        if (matcher2.find()) {
        }
        if (TextUtils.isEmpty(str5)) {
        }
        matcher3 = Pattern.compile("\"progressive\":(.*?),\"lang\":").matcher(str3);
        if (matcher3.find()) {
        }
        BrowserLogEvent.downloaderLogEvent(this, "parseVimeo", arrayList.size() > 0 ? "parseSuccess" : "parseFailed");
        return arrayList;
    }


    /* renamed from: a */
    public static void m15232a(final Activity activity, String str, final String str2, final String str3) {
        Log.e("typeDownlod","duration4");
        try {
            OkHttpClient.Builder   aVar = new OkHttpClient.Builder  ();
            aVar.connectTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.readTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.cookieJar( new bpf());
            aVar.retryOnConnectionFailure(true);
            Response a = aVar.build().newCall(new Request.Builder().url(str).build()).execute();
            if (a.isSuccessful()) {
                final String string = new JSONObject(a.body().string()).getString("clip_id");
                if (!TextUtils.isEmpty(string)) {
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                          //  Activity activity = activity;
                            String str = str2;
                            Log.e("manulparseservice","one+++vimeo");
                            ManualParseService.m15234a((Context) activity, str, "https://player.vimeo.com/video/" + string, str3);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) activity, (Throwable) e);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m15245d__(String r2) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case 48687: goto L_0x0125;
                case 48811: goto L_0x011b;
                case 48873: goto L_0x0111;
                case 49710: goto L_0x0107;
                case 49803: goto L_0x00fc;
                case 49842: goto L_0x00f1;
                case 50733: goto L_0x00e6;
                case 51756: goto L_0x00db;
                case 52593: goto L_0x00d0;
                case 54453: goto L_0x00c5;
                case 1507671: goto L_0x00b9;
                case 1509409: goto L_0x00ae;
                case 1511391: goto L_0x00a2;
                case 1513253: goto L_0x0097;
                case 1515175: goto L_0x008c;
                case 1538361: goto L_0x0080;
                case 1541122: goto L_0x0075;
                case 1544005: goto L_0x0069;
                case 1545214: goto L_0x005d;
                case 1572835: goto L_0x0051;
                case 1604548: goto L_0x0045;
                case 1630495: goto L_0x0039;
                case 1688155: goto L_0x002d;
                case 46737913: goto L_0x0021;
                case 46853233: goto L_0x0015;
                case 47689303: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x012f
        L_0x0009:
            java.lang.String r0 = "2160p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 24
            goto L_0x0130
        L_0x0015:
            java.lang.String r0 = "1440p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 22
            goto L_0x0130
        L_0x0021:
            java.lang.String r0 = "1080p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 20
            goto L_0x0130
        L_0x002d:
            java.lang.String r0 = "720p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 18
            goto L_0x0130
        L_0x0039:
            java.lang.String r0 = "540p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 16
            goto L_0x0130
        L_0x0045:
            java.lang.String r0 = "480p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 14
            goto L_0x0130
        L_0x0051:
            java.lang.String r0 = "360p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 12
            goto L_0x0130
        L_0x005d:
            java.lang.String r0 = "288p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 10
            goto L_0x0130
        L_0x0069:
            java.lang.String r0 = "270p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 8
            goto L_0x0130
        L_0x0075:
            java.lang.String r0 = "240p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 6
            goto L_0x0130
        L_0x0080:
            java.lang.String r0 = "2160"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 25
            goto L_0x0130
        L_0x008c:
            java.lang.String r0 = "180p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 4
            goto L_0x0130
        L_0x0097:
            java.lang.String r0 = "160p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 2
            goto L_0x0130
        L_0x00a2:
            java.lang.String r0 = "1440"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 23
            goto L_0x0130
        L_0x00ae:
            java.lang.String r0 = "120p"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 0
            goto L_0x0130
        L_0x00b9:
            java.lang.String r0 = "1080"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 21
            goto L_0x0130
        L_0x00c5:
            java.lang.String r0 = "720"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 19
            goto L_0x0130
        L_0x00d0:
            java.lang.String r0 = "540"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 17
            goto L_0x0130
        L_0x00db:
            java.lang.String r0 = "480"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 15
            goto L_0x0130
        L_0x00e6:
            java.lang.String r0 = "360"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 13
            goto L_0x0130
        L_0x00f1:
            java.lang.String r0 = "288"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 11
            goto L_0x0130
        L_0x00fc:
            java.lang.String r0 = "270"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 9
            goto L_0x0130
        L_0x0107:
            java.lang.String r0 = "240"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 7
            goto L_0x0130
        L_0x0111:
            java.lang.String r0 = "180"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 5
            goto L_0x0130
        L_0x011b:
            java.lang.String r0 = "160"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 3
            goto L_0x0130
        L_0x0125:
            java.lang.String r0 = "120"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            r2 = 1
            goto L_0x0130
        L_0x012f:
            r2 = -1
        L_0x0130:
            r0 = 240(0xf0, float:3.36E-43)
            switch(r2) {
                case 0: goto L_0x0157;
                case 1: goto L_0x0157;
                case 2: goto L_0x0154;
                case 3: goto L_0x0154;
                case 4: goto L_0x0151;
                case 5: goto L_0x0151;
                case 6: goto L_0x0159;
                case 7: goto L_0x0159;
                case 8: goto L_0x014e;
                case 9: goto L_0x014e;
                case 10: goto L_0x014b;
                case 11: goto L_0x014b;
                case 12: goto L_0x0148;
                case 13: goto L_0x0148;
                case 14: goto L_0x0145;
                case 15: goto L_0x0145;
                case 16: goto L_0x0142;
                case 17: goto L_0x0142;
                case 18: goto L_0x013f;
                case 19: goto L_0x013f;
                case 20: goto L_0x013c;
                case 21: goto L_0x013c;
                case 22: goto L_0x0139;
                case 23: goto L_0x0139;
                case 24: goto L_0x0136;
                case 25: goto L_0x0136;
                default: goto L_0x0135;
            }
        L_0x0135:
            goto L_0x0159
        L_0x0136:
            r0 = 2160(0x870, float:3.027E-42)
            goto L_0x0159
        L_0x0139:
            r0 = 1440(0x5a0, float:2.018E-42)
            goto L_0x0159
        L_0x013c:
            r0 = 1080(0x438, float:1.513E-42)
            goto L_0x0159
        L_0x013f:
            r0 = 720(0x2d0, float:1.009E-42)
            goto L_0x0159
        L_0x0142:
            r0 = 540(0x21c, float:7.57E-43)
            goto L_0x0159
        L_0x0145:
            r0 = 480(0x1e0, float:6.73E-43)
            goto L_0x0159
        L_0x0148:
            r0 = 360(0x168, float:5.04E-43)
            goto L_0x0159
        L_0x014b:
            r0 = 288(0x120, float:4.04E-43)
            goto L_0x0159
        L_0x014e:
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x0159
        L_0x0151:
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x0159
        L_0x0154:
            r0 = 160(0xa0, float:2.24E-43)
            goto L_0x0159
        L_0x0157:
            r0 = 120(0x78, float:1.68E-43)
        L_0x0159:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.ManualParseService.m15245d(java.lang.String):int");
    }
    private int m15245d(String str) {
        Log.e("typeDownlod","duration3");
        char c;
        switch (str.hashCode()) {
            case 48687:
                if (str.equals("120")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 48811:
                if (str.equals("160")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 48873:
                if (str.equals("180")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 49710:
                if (str.equals("240")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 49803:
                if (str.equals("270")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 49842:
                if (str.equals("288")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 50733:
                if (str.equals("360")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 51756:
                if (str.equals("480")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 52593:
                if (str.equals("540")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 54453:
                if (str.equals("720")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1507671:
                if (str.equals("1080")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1509409:
                if (str.equals("120p")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1511391:
                if (str.equals("1440")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 1513253:
                if (str.equals("160p")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1515175:
                if (str.equals("180p")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1538361:
                if (str.equals("2160")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 1541122:
                if (str.equals("240p")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1544005:
                if (str.equals("270p")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1545214:
                if (str.equals("288p")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1572835:
                if (str.equals("360p")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 1604548:
                if (str.equals("480p")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1630495:
                if (str.equals("540p")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1688155:
                if (str.equals("720p")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 46737913:
                if (str.equals("1080p")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 46853233:
                if (str.equals("1440p")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 47689303:
                if (str.equals("2160p")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return 120;
            case 2:
            case 3:
                return 160;
            case 4:
            case 5:
                return 180;
            case 6:
            case 7:
            default:
                return 240;
            case '\b':
            case '\t':
                return 270;
            case '\n':
            case 11:
                return 288;
            case '\f':
            case '\r':
                return 360;
            case 14:
            case 15:
                return 480;
            case 16:
            case 17:
                return 540;
            case 18:
            case 19:
                return 720;
            case 20:
            case 21:
                return 1080;
            case 22:
            case 23:
                return 1440;
            case 24:
            case 25:
                return 2160;
        }
    }
    private int m15245bd(final String s) {
        int n = 0;
        Label_0639: {
            switch (s.hashCode()) {
                case 47689303:
                    if (s.equals("2160p")) {
                        n = 24;
                        break Label_0639;
                    }
                    break;
                case 46853233:
                    if (s.equals("1440p")) {
                        n = 22;
                        break Label_0639;
                    }
                    break;
                case 46737913:
                    if (s.equals("1080p")) {
                        n = 20;
                        break Label_0639;
                    }
                    break;
                case 1688155:
                    if (s.equals("720p")) {
                        n = 18;
                        break Label_0639;
                    }
                    break;
                case 1630495:
                    if (s.equals("540p")) {
                        n = 16;
                        break Label_0639;
                    }
                    break;
                case 1604548:
                    if (s.equals("480p")) {
                        n = 14;
                        break Label_0639;
                    }
                    break;
                case 1572835:
                    if (s.equals("360p")) {
                        n = 12;
                        break Label_0639;
                    }
                    break;
                case 1545214:
                    if (s.equals("288p")) {
                        n = 10;
                        break Label_0639;
                    }
                    break;
                case 1544005:
                    if (s.equals("270p")) {
                        n = 8;
                        break Label_0639;
                    }
                    break;
                case 1541122:
                    if (s.equals("240p")) {
                        n = 6;
                        break Label_0639;
                    }
                    break;
                case 1538361:
                    if (s.equals("2160")) {
                        n = 25;
                        break Label_0639;
                    }
                    break;
                case 1515175:
                    if (s.equals("180p")) {
                        n = 4;
                        break Label_0639;
                    }
                    break;
                case 1513253:
                    if (s.equals("160p")) {
                        n = 2;
                        break Label_0639;
                    }
                    break;
                case 1511391:
                    if (s.equals("1440")) {
                        n = 23;
                        break Label_0639;
                    }
                    break;
                case 1509409:
                    if (s.equals("120p")) {
                        n = 0;
                        break Label_0639;
                    }
                    break;
                case 1507671:
                    if (s.equals("1080")) {
                        n = 21;
                        break Label_0639;
                    }
                    break;
                case 54453:
                    if (s.equals("720")) {
                        n = 19;
                        break Label_0639;
                    }
                    break;
                case 52593:
                    if (s.equals("540")) {
                        n = 17;
                        break Label_0639;
                    }
                    break;
                case 51756:
                    if (s.equals("480")) {
                        n = 15;
                        break Label_0639;
                    }
                    break;
                case 50733:
                    if (s.equals("360")) {
                        n = 13;
                        break Label_0639;
                    }
                    break;
                case 49842:
                    if (s.equals("288")) {
                        n = 11;
                        break Label_0639;
                    }
                    break;
                case 49803:
                    if (s.equals("270")) {
                        n = 9;
                        break Label_0639;
                    }
                    break;
                case 49710:
                    if (s.equals("240")) {
                        n = 7;
                        break Label_0639;
                    }
                    break;
                case 48873:
                    if (s.equals("180")) {
                        n = 5;
                        break Label_0639;
                    }
                    break;
                case 48811:
                    if (s.equals("160")) {
                        n = 3;
                        break Label_0639;
                    }
                    break;
                case 48687:
                    if (s.equals("120")) {
                        n = 1;
                        break Label_0639;
                    }
                    break;
            }
            n = -1;
        }
        int n2 = 240;
        switch (n) {
            default:
                n2 = n2;
                return n2;
            case 6:
            case 7:
                return n2;
            case 24:
            case 25:
                n2 = 2160;
                return n2;
            case 22:
            case 23:
                n2 = 1440;
                return n2;
            case 20:
            case 21:
                n2 = 1080;
                return n2;
            case 18:
            case 19:
                n2 = 720;
                return n2;
            case 16:
            case 17:
                n2 = 540;
                return n2;
            case 14:
            case 15:
                n2 = 480;
                return n2;
            case 12:
            case 13:
                n2 = 360;
                return n2;
            case 10:
            case 11:
                n2 = 288;
                return n2;
            case 8:
            case 9:
                n2 = 270;
                return n2;
            case 4:
            case 5:
                n2 = 180;
                return n2;
            case 2:
            case 3:
                n2 = 160;
                return n2;
            case 0:
            case 1:
                n2 = 120;
                return n2;
        }
    }

    /* renamed from: c */
    private ArrayList<bph> m14404c(String str, String str2, String str3) {
        Log.e("typeDownlod","duration2");
        int i;
        ArrayList<bph> arrayList = new ArrayList<>();
        try {
            Document parse = Jsoup.parse(str3);
            String a = m15231a((Context) this, parse, "og:image");
            String a2 = m15231a((Context) this, parse, "og:title");
            if (!TextUtils.isEmpty(a2)) {
                str = a2;
            }
            Iterator it = parse.select("video *").iterator();
            while (it.hasNext()) {
                Element element = (Element) it.next();
                if (element.tagName().equals("source") && element.hasAttr("src")) {
                    if (element.hasAttr("label")) {
                        i = m15245d(element.attr("label"));
                    } else {
                        i = element.hasAttr("default label") ? m15245d(element.attr("default label")) : 240;
                    }
                    arrayList.add(bpd.m21193a(this, element.attr("src"), str2, str, 0, i, a));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
        }
        BrowserLogEvent.downloaderLogEvent(this, "parseLL", arrayList.size() > 0 ? "parseSuccess" : "parseFailed");
        return arrayList;
    }

    /* renamed from: d */
    private ArrayList<bph> m14407d(String str, String str2, String str3) {
        Log.e("typeDownlod","duration1");
        ArrayList<bph> arrayList = new ArrayList<>();
        try {
            Document parse = Jsoup.parse(str3);
            String a = m15231a((Context) this, parse, "og:title");
            if (!TextUtils.isEmpty(a)) {
                str = a;
            }
            String a2 = m15231a((Context) this, parse, "og:image");
            int r = m15264n(this, m15231a((Context) this, parse, "video:duration"));
            Matcher matcher = Pattern.compile("\"mediaDefinition\":(.*?)],\"").matcher(str3);
            if (matcher.find()) {
                String group = matcher.group(1);
                JSONArray jSONArray = new JSONArray(group + "]");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    int f = m15245d(jSONObject.optString("quality"));
                    String optString = jSONObject.optString("videoUrl");
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(bpd.m21193a(this, optString, str2, str, r, f, a2));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
        }
        BrowserLogEvent.downloaderLogEvent(this, "parseTb8", arrayList.size() > 0 ? "parseSuccess" : "parseFailed");
        return arrayList;
    }


}
