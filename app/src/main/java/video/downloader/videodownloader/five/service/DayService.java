package video.downloader.videodownloader.five.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import androidx.core.app.JobIntentService;

import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classesdef.browser.BrowserData;
import classesdef.browser.download.bpf;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class DayService extends JobIntentService {

    private static ArrayList<String> f11674j = new ArrayList<>();

    private static void m14391c(String str) {
        if (f11674j == null) {
            f11674j = new ArrayList<>();
        }
        if (!f11674j.contains(str)) {
            f11674j.add(str);
        }
    }

    private static void m14392d(String str) {
        if (f11674j != null && !TextUtils.isEmpty(str)) {
            f11674j.remove(str);
        }
    }

    public static boolean m14389a(String str) {
        ArrayList<String> arrayList = f11674j;
        return arrayList != null && arrayList.contains(str);
    }

    /* access modifiers changed from: protected */
    public void onHandleWork(Intent intent) {
        Log.e("typeDownlod","one20_1");
        if (intent != null) {
            String stringExtra = intent.getStringExtra("title");
            String stringExtra2 = intent.getStringExtra("father_url");
            if (!TextUtils.isEmpty(stringExtra2) && !m14389a(stringExtra2)) {
                m14391c(stringExtra2);
                m14388a(stringExtra, stringExtra2);
            }
        }
    }

    private void m14388a(String str, String str2) {
        Log.e("typeDownlod","one20_");
        String str3 = "";
        try {
            OkHttpClient.Builder  aVar = new OkHttpClient.Builder();
            aVar.connectTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.readTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.writeTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.cookieJar((CookieJar) new bpf());
            aVar.retryOnConnectionFailure(true);
            Response execute = aVar.build().newCall(new Request.Builder().url(str2).addHeader(BrowserData.m18390b(this), BrowserData.m18392c(this)).build()).execute();
            if (execute.isSuccessful()) {
                str3 =  execute.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            m14387a(this, str, str2, str3);
            m14392d(str2);
            throw th;
        }
        m14387a(this, str, str2, str3);
        m14392d(str2);
    }

    /* renamed from: a */
    public static void m14387a(Context context, String str, String str2, String str3) {
        Log.e("manulparseservice","one+++dailymotion");
        String str4 = "";
        String b = m14390b(str2);
        try {
            Matcher matcher = Pattern.compile("var __PLAYER_CONFIG__ = (.*?);</script>").matcher(str3);
            if (matcher.find()) {
                JSONObject jSONObject = new JSONObject(matcher.group(1)).getJSONObject("context");
                if (jSONObject.has("metadata_template_url")) {
                    str4 = jSONObject.optString("metadata_template_url", "");
                } else if (jSONObject.has("metadata_template_url1")) {
                    str4 = jSONObject.optString("metadata_template_url1", "");
                }
                if (!TextUtils.isEmpty(str4) && str4.contains(":videoId")) {
                    str4 = str4.replace(":videoId", b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Log.e("manulparseservice","one+++dailymotion2");
            if (TextUtils.isEmpty(str4)) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://www.dailymotion.com/player/metadata/video/" + b);
                sb.append("?embedder=");
                sb.append(URLEncoder.encode(str2, "UTF-8"));
                sb.append("&integration=inline&GK_PV5_NEON=1");
                str4 = sb.toString();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            str4 = "https://www.dailymotion.com/player/metadata/video/" + b;
        }
        if (!TextUtils.isEmpty(str4)) {
            Log.e("manulparseservice","one+++dailymotion4");
            ManualParseService.m15234a(context, str2, str4, str);
        }
    }

    /* renamed from: b */
    public static String m14390b(String str) {
        try {
            int lastIndexOf = str.lastIndexOf(47);
            int lastIndexOf2 = str.lastIndexOf("?playlist");
            int i = lastIndexOf + 1;
            if (lastIndexOf2 > i) {
                return str.substring(i, lastIndexOf2);
            }
            return str.substring(i);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
